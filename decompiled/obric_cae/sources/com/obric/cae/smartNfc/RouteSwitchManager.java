package com.obric.cae.smartNfc;

import android.content.ComponentName;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.NfcOemExtension;
import android.nfc.RoutingStatus;
import android.nfc.cardemulation.ApduServiceInfo;
import android.nfc.cardemulation.CardEmulation;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNfc.event.PaymentChangeEvent;
import defpackage.a;
import defpackage.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class RouteSwitchManager implements PaymentChangeEvent.PaymentChangeListener, CaeNfcEventManagerService.NfcStateListener {
    public static final int ESE_ID_TYPE = 1;
    public static final int HOST_ID_TYPE = 0;
    private static final String KEY_DEFAULT_PAYMENT = "nfc_payment_default_component";
    private static final String KEY_DEFAULT_SE = "nfc_default_se_route";
    public static final int NDEF_ID_TYPE = 4;
    private static final String SOURCE_PAYMENT = "payment";
    private static final String SOURCE_SETTINGS = "settings";
    private static final String SOURCE_SHELL = "shell";
    private static final String TAG = "NFC:RouteSwitchManager";
    public static final int UICC_ID_TYPE = 2;
    private final Context mContext;
    private final Set<String> mEsePaymentComponents;
    private boolean mIgnoreNextSettingsChange;
    private int mLastAppliedSeId;
    private String mLastAppliedSource;
    private Handler mObserverHandler;
    private HandlerThread mObserverThread;
    private final PaymentChangeEvent mPaymentChangeEvent;
    private ContentObserver mSettingsObserver;
    private boolean mSettingsOverrideEnabled;

    public RouteSwitchManager(Context r8, PaymentChangeEvent r10) {
        ArraySet r11 = new ArraySet();
        this.mEsePaymentComponents = r11;
        this.mLastAppliedSeId = Integer.MIN_VALUE;
        this.mLastAppliedSource = "";
        this.mContext = r8.getApplicationContext();
        this.mPaymentChangeEvent = r10;
        r11.add("com.zte.wallet/com.zte.wallet.service.WalletOffHostApduService");
    }

    public static /* synthetic */ void access$000(RouteSwitchManager r8, Uri r10) {
        r8.handleSettingsChange(r10);
    }

    private boolean applyIfNfcOn() {
        NfcAdapter r8 = getDefaultAdapterSafely("applyIfNfcOn");
        if (r8 != null) goto L14;
        return false;
    L14:
        if (r8.isEnabled() == false) goto L9;
        CaeLog.i(TAG, "applyIfNfcOn: STATE_ON");
        return applyOnNfcStateOn();
    L9:
        CaeLog.i(TAG, "applyIfNfcOn: NFC is not enabled");
        return true;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "applyIfNfcOn: isEnabled failed: " + e);
        return false;
    }

    private boolean applyInitialRoute() {
        Integer r8 = readGlobalSeId();
        if (this.mSettingsOverrideEnabled == false) goto L7;
        if (r8 == null) goto L7;
        CaeLog.i(TAG, "applyInitialRoute: settings override seId=" + r8);
        return applyRoute(r8.intValue(), SOURCE_SETTINGS, false);
    L7:
        CaeLog.i(TAG, "applyInitialRoute: use payment");
        return handlePaymentChanged(getDefaultPaymentComponent());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    private boolean applyOnNfcStateOn() {
        ?? r8 = isEsePayment(getDefaultPaymentComponent());
        Integer r10 = readGlobalSeId();
        if (this.mSettingsOverrideEnabled == false) goto L8;
        if (r10 == null) goto L8;
        if (r10.intValue() == r8) goto L8;
        CaeLog.i(TAG, "applyOnNfcStateOn: settings override " + r10 + " (payment=" + r8 + ")");
        int r11 = r10.intValue();
        String r12 = SOURCE_SETTINGS;
        boolean r13 = false;
        int r14 = r11;
    L10:
        return applyRoute(r14, r12, r13);
    L8:
        a.i("applyOnNfcStateOn: apply payment route ", r8, TAG);
        r12 = SOURCE_PAYMENT;
        r13 = true;
        r14 = r8;
        goto L10
    }

    private synchronized boolean applyRoute(int r17, String r18, boolean r19) {
        monitor-enter(this);
        int r13 = NfcRoutingUtils.seIdToRoute(r17);     // Catch: Throwable -> L37
        if (r13 != (-1)) goto L9;
        CaeLog.w(TAG, "applyRoute: invalid seId=" + r17 + " source=" + r18);     // Catch: Throwable -> L37
        monitor-exit(this);
        return false;
    L9:
        CaeLog.i(TAG, "applyRoute: seId=" + r17 + " route=" + r13 + " source=" + r18 + " updateSettings=" + r19);     // Catch: Throwable -> L37
        NfcOemExtension r15 = getNfcOemExtension();     // Catch: Throwable -> L37
        if (r15 != null) goto L17;
        CaeLog.w(TAG, "applyRoute: NfcOemExtension is null");     // Catch: Throwable -> L37
        monitor-exit(this);
        return false;
    L17:
        if (shouldSkipDuplicateRoute(r17, r13, r18, r19, r15) == false) goto L22;
        monitor-exit(this);
        return true;
    L22:
        if (shouldSkipPersistedRoute(r17, r13, r18, r19, r15) == false) goto L40;
        monitor-exit(this);
        return true;
    L40:
        r15.overwriteRoutingTable(r13, r13, r13, r13);     // Catch: Exception -> L32 Throwable -> L37
        this.mLastAppliedSeId = r17;     // Catch: Exception -> L32 Throwable -> L37
        this.mLastAppliedSource = r18;     // Catch: Exception -> L32 Throwable -> L37
        if (r19 == false) goto L30;
        this.mIgnoreNextSettingsChange = true;     // Catch: Throwable -> L37
        if (Settings.Global.putInt(this.mContext.getContentResolver(), KEY_DEFAULT_SE, r17) == true) goto L30;
        CaeLog.w(TAG, "applyRoute: persist default se failed, seId=" + r17);     // Catch: Throwable -> L37
    L30:
        monitor-exit(this);
        return true;
    L32:
        e = move-exception;
        CaeLog.e(TAG, "applyRoute: failed, seId=" + r17 + " source=" + r18 + " e=" + e);     // Catch: Throwable -> L37
        StringBuilder r8 = new StringBuilder("apply failed, seId=");     // Catch: Throwable -> L37
        r8.append(r17);     // Catch: Throwable -> L37
        r8.append(" source=");     // Catch: Throwable -> L37
        r8.append(r18);     // Catch: Throwable -> L37
        resetLastAppliedRoute(r8.toString());     // Catch: Throwable -> L37
        return false;
    L37:
        th = move-exception;
        throw th;
    }

    private String formatRoutingStatus(RoutingStatus r8) {
        if (r8 != null) goto L6;
        return "routingStatus=null";
    L6:
        return "routingStatus default=" + NfcRoutingUtils.routeToName(r8.getDefaultRoute()) + ", isoDep=" + NfcRoutingUtils.routeToName(r8.getDefaultIsoDepRoute()) + ", offHost=" + NfcRoutingUtils.routeToName(r8.getDefaultOffHostRoute());
    }

    private NfcAdapter getDefaultAdapterSafely(String r8) {
        return NfcAdapter.getDefaultAdapter(this.mContext);
    L4:
        e = move-exception;
        CaeLog.e(TAG, r8 + ": getDefaultAdapter failed: " + e);
        return null;
    }

    private NfcOemExtension getNfcOemExtension() {
        NfcAdapter r8 = getDefaultAdapterSafely("getNfcOemExtension");
        if (r8 != null) goto L10;
        return null;
    L10:
        return r8.getNfcOemExtension();
    L7:
        e = move-exception;
        android.aimedia.a.q("getNfcOemExtension error: ", e, TAG);
        return null;
    }

    private boolean handlePaymentChanged(String r8) {
        boolean r10 = isEsePayment(r8);
        a.i("handlePaymentChanged: target=", r10 ? 1 : 0, TAG);
        if (this.mSettingsOverrideEnabled == false) goto L6;
        CaeLog.i(TAG, "handlePaymentChanged: reset shell override");
        this.mSettingsOverrideEnabled = false;
    L6:
        return applyRoute(r10 ? 1 : 0, SOURCE_PAYMENT, true);
    }

    private void handleSettingsChange(Uri r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.equals(Settings.Global.getUriFor(KEY_DEFAULT_SE)) == false) goto L18;
        Integer r10 = readGlobalSeId();
        if (r10 != null) goto L9;
        return;
    L9:
        CaeLog.i(TAG, "handleSettingsChange: seId=" + r10);
        if (this.mIgnoreNextSettingsChange == true) goto L12;
    L15:
        this.mIgnoreNextSettingsChange = false;
        applyRoute(r10.intValue(), SOURCE_SETTINGS, false);
        return;
    L12:
        if (r10.intValue() != this.mLastAppliedSeId) goto L15;
        this.mIgnoreNextSettingsChange = false;
        return;
    }

    private boolean isEsePayment(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return false;
    L7:
        return this.mEsePaymentComponents.contains(r8);
    }

    private boolean isRoutingStatusMatched(RoutingStatus r8, int r10) {
        if (r8 != null) goto L4;
    L10:
        return false;
    L4:
        if (r8.getDefaultRoute() != r10) goto L10;
        if (r8.getDefaultIsoDepRoute() != r10) goto L10;
        if (r8.getDefaultOffHostRoute() != r10) goto L10;
        return true;
    }

    private Integer readGlobalSeId() {
        String r8 = Settings.Global.getString(this.mContext.getContentResolver(), KEY_DEFAULT_SE);
        if (TextUtils.isEmpty(r8) == false) goto L9;
        return null;
    L9:
        return Integer.valueOf(Integer.parseInt(r8));
    L7:
        CaeLog.e(TAG, "readGlobalSeId parse error: " + r8);
        return null;
    }

    private void registerSettingsObserver() {
        if (this.mObserverThread == null) goto L5;
        return;
    L5:
        HandlerThread r8 = new HandlerThread("CaeNfcRouteObserver");
        this.mObserverThread = r8;
        r8.start();
        this.mObserverHandler = new Handler(this.mObserverThread.getLooper());
        final Handler r10 = this.mObserverHandler;
        this.mSettingsObserver = new AnonymousClass1(this, r10);
        Uri r11 = Settings.Global.getUriFor(KEY_DEFAULT_SE);
        this.mContext.getContentResolver().registerContentObserver(r11, false, this.mSettingsObserver);
        CaeLog.i(TAG, "registerSettingsObserver: " + r11);
    }

    private void resetLastAppliedRoute(String r8) {
        StringBuilder r10 = b.h("resetLastAppliedRoute: ", r8, ", lastApplied=");
        r10.append(NfcRoutingUtils.seIdToName(this.mLastAppliedSeId));
        r10.append(" source=");
        if (TextUtils.isEmpty(this.mLastAppliedSource) == false) goto L5;
        String r11 = "-";
    L6:
        r10.append(r11);
        CaeLog.w(TAG, r10.toString());
        this.mLastAppliedSeId = Integer.MIN_VALUE;
        this.mLastAppliedSource = "";
        return;
    L5:
        r11 = this.mLastAppliedSource;
        goto L6
    }

    private boolean shouldSkipDuplicateRoute(int r8, int r10, String r11, boolean r12, NfcOemExtension r13) {
        if (r8 == this.mLastAppliedSeId) goto L15;
        return false;
    L15:
        RoutingStatus r14 = r13.getRoutingStatus();     // Catch: Exception -> L11
        if (isRoutingStatusMatched(r14, r10) == false) goto L9;
        CaeLog.i(TAG, "applyRoute: skip duplicate seId=" + r8 + " source=" + r11 + " updateSettings=" + r12);     // Catch: Exception -> L11
        return true;
    L9:
        CaeLog.w(TAG, "applyRoute: duplicate seId=" + r8 + " but " + formatRoutingStatus(r14) + ", target=" + NfcRoutingUtils.routeToName(r10) + ", force reapply");     // Catch: Exception -> L11
    L13:
        resetLastAppliedRoute("duplicate route desync");
        return false;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "applyRoute: duplicate seId=" + r8 + " getRoutingStatus failed, force reapply: " + e);
        goto L13
    }

    private boolean shouldSkipPersistedRoute(int r8, int r10, String r11, boolean r12, NfcOemExtension r13) {
        if (r12 == true) goto L5;
    L20:
        return false;
    L5:
        if (SOURCE_PAYMENT.equals(r11) == false) goto L20;
        Integer r14 = readGlobalSeId();
        if (r14 == null) goto L20;
        if (r14.intValue() != r8) goto L20;
        RoutingStatus r15 = r13.getRoutingStatus();     // Catch: Exception -> L18
        if (isRoutingStatusMatched(r15, r10) == false) goto L16;
        CaeLog.i(TAG, "applyRoute: skip persisted seId=" + r8 + " route=" + r10 + " source=" + r11);     // Catch: Exception -> L18
        this.mLastAppliedSeId = r8;     // Catch: Exception -> L18
        this.mLastAppliedSource = r11;     // Catch: Exception -> L18
        return true;
    L16:
        CaeLog.i(TAG, "applyRoute: persisted seId=" + r8 + " but " + formatRoutingStatus(r15));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        android.aimedia.a.q("shouldSkipPersistedRoute: getRoutingStatus failed: ", e, TAG);
        goto L20
    }

    private void unregisterSettingsObserver() {
        if (this.mSettingsObserver != null) goto L14;
        return;
    L14:
        this.mContext.getContentResolver().unregisterContentObserver(this.mSettingsObserver);     // Catch: Exception -> L7
    L9:
        this.mSettingsObserver = null;
        HandlerThread r8 = this.mObserverThread;
        if (r8 == null) goto L12;
        r8.quitSafely();
        this.mObserverThread = null;
    L12:
        CaeLog.i(TAG, "unregisterSettingsObserver");
        return;
    L7:
        e = move-exception;
        android.aimedia.a.q("unregisterSettingsObserver: ", e, TAG);
        goto L9
    }

    public void cleanup() {
        CaeLog.i(TAG, "cleanup");
        PaymentChangeEvent r8 = this.mPaymentChangeEvent;
        if (r8 == null) goto L5;
        r8.setInternalListener(null);
    L5:
        unregisterSettingsObserver();
    }

    public String getDefaultPaymentComponent() {
        String r8 = Settings.Secure.getString(this.mContext.getContentResolver(), KEY_DEFAULT_PAYMENT);
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return "";
    L6:
        return r8;
    }

    public List<String> getPaymentServiceList() {
        ArrayList r8 = new ArrayList();
        NfcAdapter r10 = getDefaultAdapterSafely("getPaymentServiceList");
        if (r10 != null) goto L30;
        return r8;
    L30:
        CardEmulation r11 = CardEmulation.getInstance(r10);     // Catch: RuntimeException -> L25
        if (r11 != null) goto L28;
        return r8;
    L28:
        List r12 = r11.getServices(SOURCE_PAYMENT);     // Catch: RuntimeException -> L22
        if (r12 != null) goto L11;
        return r8;
    L11:
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L20;
        ApduServiceInfo r14 = (ApduServiceInfo) r13.next();
        if (r14 == null) goto L13;
        ComponentName r15 = r14.getComponent();
        if (r15 == null) goto L13;
        r8.add(r15.flattenToString());
        goto L13
    L20:
        CaeLog.i(TAG, "getPaymentServiceList size=" + r8.size());
        return r8;
    L22:
        e = move-exception;
        CaeLog.e(TAG, "getPaymentServiceList: getServices failed: " + e);
        return r8;
    L25:
        e = move-exception;
        CaeLog.e(TAG, "getPaymentServiceList: getInstance failed: " + e);
        return r8;
    }

    public String getRouteStatusString() {
        StringBuilder r8 = new StringBuilder("settings.defaultSe=");
        Integer r10 = readGlobalSeId();
        if (r10 != null) goto L5;
        String r11 = "null";
    L6:
        r8.append(r11);
        r8.append(" (");
        String r12 = "-";
        Object r13 = r10;
        if (r10 != null) goto L9;
        r13 = "-";
    L9:
        r8.append(r13);
        r8.append(")\nlastApplied=");
        r8.append(NfcRoutingUtils.seIdToName(this.mLastAppliedSeId));
        r8.append(" source=");
        if (TextUtils.isEmpty(this.mLastAppliedSource) == true) goto L13;
        r12 = this.mLastAppliedSource;
    L13:
        r8.append(r12);
        r8.append("\n");
        NfcOemExtension r14 = getNfcOemExtension();
        if (r14 != null) goto L23;
        r8.append("routingStatus=n/a");
        return r8.toString();
    L23:
        RoutingStatus r15 = r14.getRoutingStatus();     // Catch: Exception -> L19
        r8.append("routingStatus: default=");     // Catch: Exception -> L19
        r8.append(NfcRoutingUtils.routeToName(r15.getDefaultRoute()));     // Catch: Exception -> L19
        r8.append(", isoDep=");     // Catch: Exception -> L19
        r8.append(NfcRoutingUtils.routeToName(r15.getDefaultIsoDepRoute()));     // Catch: Exception -> L19
        r8.append(", offHost=");     // Catch: Exception -> L19
        r8.append(NfcRoutingUtils.routeToName(r15.getDefaultOffHostRoute()));     // Catch: Exception -> L19
    L22:
        return r8.toString();
    L19:
        e = move-exception;
        r8.append("routingStatus=error: ");
        r8.append(e);
        goto L22
    L5:
        r11 = NfcRoutingUtils.seIdToName(r10.intValue());
        goto L6
    }

    public void init() {
        CaeLog.i(TAG, "init");
        registerSettingsObserver();
        PaymentChangeEvent r8 = this.mPaymentChangeEvent;
        if (r8 == null) goto L5;
        r8.setInternalListener(this);
    L5:
        applyInitialRoute();
        applyIfNfcOn();
    }

    @Override // com.obric.cae.smartNfc.CaeNfcEventManagerService.NfcStateListener
    public void onNfcStateChanged(int r8) {
        if (r8 != 3) goto L6;
        CaeLog.i(TAG, "onNfcStateChanged: STATE_ON");
        applyOnNfcStateOn();
        return;
    }

    @Override // com.obric.cae.smartNfc.event.PaymentChangeEvent.PaymentChangeListener
    public void onPaymentChanged(String r8) {
        CaeLog.i(TAG, "onPaymentChanged: " + r8);
        handlePaymentChanged(r8);
    }

    public boolean setRouteFromShell(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        int r10 = NfcRoutingUtils.routeNameToSeId(r8);
        if (r10 != Integer.MIN_VALUE) goto L8;
        return false;
    L8:
        CaeLog.i(TAG, "setRouteFromShell: " + r8 + " -> " + r10);
        this.mSettingsOverrideEnabled = true;
        return applyRoute(r10, SOURCE_SHELL, true);
    }
}
