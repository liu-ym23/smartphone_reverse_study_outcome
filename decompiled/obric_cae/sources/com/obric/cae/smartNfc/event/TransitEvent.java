package com.obric.cae.smartNfc.event;

import android.aimedia.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.obric.cae.libs.nfc.ICaeNfcTransitEventCallback;
import com.obric.cae.log.CaeLog;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class TransitEvent implements EventComponent {
    private static final String EXTRA_DATA_URI = "data_uri";
    public static final int SOURCE_BINDER = 2;
    public static final int SOURCE_BROADCAST = 1;
    private static final String TAG = "NFC:TransitEvent";
    private final RemoteCallbackList<ICaeNfcTransitEventCallback> mCallbacks;
    private final Context mContext;
    private final TransitEventFilter mEventFilter;
    private volatile int mEventSource;
    private volatile boolean mPreFilterEnabled;
    private BroadcastReceiver mReceiver;

    public TransitEvent(Context r8) {
        this.mCallbacks = new RemoteCallbackList();
        this.mEventFilter = new TransitEventFilter();
        this.mEventSource = 1;
        this.mPreFilterEnabled = true;
        this.mContext = r8;
    }

    public static /* synthetic */ Bundle access$000(TransitEvent r8, Bundle r10) {
        return r8.normalizeTransitEvent(r10);
    }

    public static /* synthetic */ String access$100(Bundle r8) {
        return describeTransitEvent(r8);
    }

    private static String describeTransitEvent(Bundle r8) {
        if (r8 != null) goto L5;
        return "data=null";
    L5:
        byte[] r10 = getByteArrayExtra(r8, "android.nfc.extra.AID");
        byte[] r11 = getByteArrayExtra(r8, "android.nfc.extra.DATA");
        String r12 = getStringExtra(r8, "android.nfc.extra.SECURE_ELEMENT_NAME");
        String r13 = getStringExtra(r8, EXTRA_DATA_URI);
        StringBuilder r14 = new StringBuilder("aid=");
        r14.append(toHexForLog(r10));
        r14.append(", payloadLen=");
        if (r11 != null) goto L8;
        int r15 = -1;
    L9:
        r14.append(r15);
        r14.append(", se=");
        r14.append(r12);
        r14.append(", dataUri=");
        r14.append(r13);
        return r14.toString();
    L8:
        r15 = r11.length;
        goto L9
    }

    private static byte[] getByteArrayExtra(Bundle r8, String r10) {
        Object r11 = r8.get(r10);
        if ((r11 instanceof byte[]) == true) goto L7;
        return null;
    L7:
        return (byte[]) r11;
    }

    private static String getStringExtra(Bundle r8, String r10) {
        Object r11 = r8.get(r10);
        if ((r11 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r11;
    }

    private static byte[] hexStringToBytes(String r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = normalizeHexString(r8);
        if (r10 != null) goto L8;
    L19:
        return null;
    L8:
        if ((r10.length() % 2) != 0) goto L19;
        int r11 = r10.length() / 2;
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L11:
        if (r13 >= r11) goto L18;
        int r14 = r13 * 2;
        int r15 = Character.digit(r10.charAt(r14), 16);
        int r16 = Character.digit(r10.charAt(r14 + 1), 16);
        if (r15 < 0) goto L17;
        if (r16 < 0) goto L17;
        r12[r13] = (byte) (r16 | (r15 << 4));
        r13 = r13 + 1;
    L17:
        return null;
    L18:
        return r12;
    }

    private static boolean isValidSource(int r8) {
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private static String normalizeHexString(String r8) {
        String r10 = r8.trim();
        if (r10.startsWith("0x") == false) goto L5;
    L8:
        int r11 = 2;
    L9:
        StringBuilder r12 = new StringBuilder(r10.length() - r11);
    L11:
        if (r11 >= r10.length()) goto L26;
        char r13 = r10.charAt(r11);
        if (Character.isWhitespace(r13) == true) goto L24;
        if (r13 == ':') goto L24;
        if (r13 == '-') goto L24;
        if (Character.digit(r13, 16) < 0) goto L21;
        r12.append(r13);
        goto L24
    L21:
        return null;
    L24:
        r11 = r11 + 1;
        goto L11
    L26:
        return r12.toString();
    L5:
        if (r10.startsWith("0X") == true) goto L8;
        r11 = 0;
        goto L9
    }

    private static void normalizeHexStringExtra(Bundle r8, String r10) {
        Object r11 = r8.get(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof byte[]) == false) goto L8;
        return;
    L8:
        if ((r11 instanceof String) == true) goto L10;
        StringBuilder r12 = b.h("drop unsupported transit extra type: key=", r10, ", type=");
        r12.append(r11.getClass().getName());
        String r13 = r12.toString();
    L13:
        CaeLog.e(TAG, r13);
        r8.remove(r10);
        return;
    L10:
        byte[] r14 = hexStringToBytes((String) r11);
        if (r14 != null) goto L15;
        r13 = b.c("drop invalid hex transit extra: key=", r10);
        goto L13
    L15:
        r8.putByteArray(r10, r14);
    }

    private Bundle normalizeTransitEvent(Bundle r8) {
        if (r8 != null) goto L5;
        Bundle r10 = new Bundle();
    L6:
        normalizeHexStringExtra(r10, "android.nfc.extra.AID");
        normalizeHexStringExtra(r10, "android.nfc.extra.DATA");
        if (getByteArrayExtra(r10, "android.nfc.extra.DATA") != null) goto L9;
        r10.putByteArray("android.nfc.extra.DATA", new byte[0]);
    L9:
        return r10;
    L5:
        r10 = new Bundle(r8);
        goto L6
    }

    private void registerReceiver() {
        if (this.mReceiver == null) goto L5;
        return;
    L5:
        this.mReceiver = new AnonymousClass1(this);
        IntentFilter r8 = new IntentFilter("android.nfc.action.TRANSACTION_DETECTED");
        r8.addDataScheme("nfc");
        this.mContext.registerReceiver(this.mReceiver, r8, "android.permission.NFC", null, 2);
        CaeLog.i(TAG, "registered transit broadcast receiver");
    }

    private static String toHexForLog(byte[] r8) {
        if (r8 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder(r8.length * 2);
        int r11 = r8.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L12;
        int r13 = r8[r12] & 255;
        if (r13 >= 16) goto L10;
        r10.append('0');
    L10:
        r10.append(Integer.toHexString(r13).toUpperCase());
        r12 = r12 + 1;
        goto L6
    L12:
        return r10.toString();
    }

    private void unregisterReceiver() {
        BroadcastReceiver r8 = this.mReceiver;
        if (r8 != null) goto L5;
        return;
    L5:
        this.mContext.unregisterReceiver(r8);
        this.mReceiver = null;
        CaeLog.i(TAG, "unregistered transit broadcast receiver");
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void cleanup() {
        unregisterReceiver();
        this.mCallbacks.kill();
    }

    public int getAllowedAidTypes() {
        return this.mEventFilter.getAllowedAidTypes();
    }

    public int getEventSource() {
        return this.mEventSource;
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void init() {
        registerReceiver();
    }

    public boolean isPreFilterEnabled() {
        return this.mPreFilterEnabled;
    }

    public void notifyTransitEvent(Bundle r8, int r10) {
        if (r10 == this.mEventSource) goto L6;
        b.m("drop transit event from disabled source ", r10, TAG);
        return;
    L6:
        Bundle r11 = normalizeTransitEvent(r8);
        if (this.mPreFilterEnabled == false) goto L24;
        TransitEventFilter.Result r12 = this.mEventFilter.filter(r11);
        if (r12 != TransitEventFilter.Result.INVALID_PAYLOAD) goto L13;
        CaeLog.e(TAG, "drop invalid transit event");
        return;
    L13:
        if (r12 != TransitEventFilter.Result.DUPLICATE) goto L17;
        CaeLog.d(TAG, "drop duplicate transit event");
        return;
    L17:
        if (r12 != TransitEventFilter.Result.SHORT_TRANSIT_PAYLOAD) goto L21;
        CaeLog.d(TAG, "drop short transit card payload");
        return;
    L21:
        if (r12 != TransitEventFilter.Result.FILTERED_AID_TYPE) goto L24;
        CaeLog.d(TAG, "drop transit event by AID type");
        return;
    L24:
        int r13 = this.mCallbacks.beginBroadcast();
        int r14 = 0;
    L25:
        if (r14 >= r13) goto L31;
        ((ICaeNfcTransitEventCallback) this.mCallbacks.getBroadcastItem(r14)).onTransitEvent(r11);     // Catch: Exception -> L28
    L30:
        r14 = r14 + 1;
    L28:
        e = move-exception;
        a.q("notifyTransitEvent error: ", e, TAG);
        goto L30
    L31:
        this.mCallbacks.finishBroadcast();
    }

    public void registerCallback(ICaeNfcTransitEventCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "registerCallback: callback is null");
        return;
    L5:
        this.mCallbacks.register(r8);
    }

    public boolean setAllowedAidTypes(int r8) {
        return this.mEventFilter.setAllowedAidTypes(r8);
    }

    public boolean setEventSource(int r8) {
        if (isValidSource(r8) == true) goto L7;
        a.p("setEventSource: invalid source ", r8, TAG);
        return false;
    L7:
        if (this.mEventSource == r8) goto L11;
        this.mEventSource = r8;
        this.mEventFilter.reset();
        return true;
    L11:
        return true;
    }

    public void setPreFilterEnabled(boolean r8) {
        if (this.mPreFilterEnabled == r8) goto L6;
        this.mPreFilterEnabled = r8;
        this.mEventFilter.reset();
        return;
    }

    public void unregisterCallback(ICaeNfcTransitEventCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "unregisterCallback: callback is null");
        return;
    L5:
        this.mCallbacks.unregister(r8);
    }
}
