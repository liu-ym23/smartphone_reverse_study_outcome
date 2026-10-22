package com.obric.cae.smartNfc;

import android.aimedia.a;
import android.content.Context;
import android.database.ContentObserver;
import android.nfc.NfcAdapter;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import androidx.activity.d;
import androidx.activity.j;
import com.obric.cae.log.CaeLog;
import z.g;

/* JADX INFO: loaded from: classes2.dex */
public class ReverseChargingNfcController implements CaeNfcEventManagerService.NfcStateListener {
    private static final long DISABLE_RETRY_DELAY_MS = 1000;
    private static final String OBSERVER_THREAD_NAME = "CaeNfcReverseCharging";
    private static final String TAG = "NFC:ReverseChargingNfcController";
    private final Context mContext;
    private final Runnable mDisableRetryRunnable;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mNeedRestoreNfc;
    private ContentObserver mReverseChargingObserver;
    private int mReverseChargingState;

    public ReverseChargingNfcController(Context r8) {
        this.mDisableRetryRunnable = new d(this, 25);
        this.mReverseChargingState = 0;
        this.mContext = r8.getApplicationContext();
    }

    public static /* synthetic */ void a(ReverseChargingNfcController r8) {
        r8.retryDisableIfNeeded();
    }

    public static /* synthetic */ void access$000(ReverseChargingNfcController r8) {
        r8.updateReverseChargingState();
    }

    public static /* synthetic */ void b(ReverseChargingNfcController r8, int r10) {
        r8.lambda$onNfcStateChanged$0(r10);
    }

    public static /* synthetic */ void c(ReverseChargingNfcController r8) {
        r8.updateReverseChargingState();
    }

    private void cancelPendingDisableRetry() {
        Handler r8 = this.mHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        r8.removeCallbacks(this.mDisableRetryRunnable);
    }

    private void disableNfcForReverseCharging() {
        cancelPendingDisableRetry();
        NfcAdapter r8 = getDefaultAdapterSafely("disableNfcForReverseCharging");
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = getAdapterStateSafely(r8, "disableNfcForReverseCharging");
        if (r10 != 3) goto L11;
        this.mNeedRestoreNfc = true;
        if (requestDisable(r8) == true) goto L14;
        scheduleDisableRetry();
        return;
    L14:
        return;
    L11:
        if (r10 != 2) goto L16;
        this.mNeedRestoreNfc = true;
        return;
    }

    private int getAdapterStateSafely(NfcAdapter r8, String r10) {
        return r8.getAdapterState();
    L4:
        e = move-exception;
        CaeLog.e(TAG, r10 + ": getAdapterState failed: " + e);
        return 1;
    }

    private NfcAdapter getDefaultAdapterSafely(String r8) {
        return NfcAdapter.getDefaultAdapter(this.mContext);
    L4:
        e = move-exception;
        CaeLog.e(TAG, r8 + ": getDefaultAdapter failed: " + e);
        return null;
    }

    private void handleNfcStateChanged(int r8) {
        CaeLog.i(TAG, "handleNfcStateChanged: " + NfcStateUtils.adapterStateToString(r8) + ", reverseState=" + stateToString(this.mReverseChargingState) + ", restore=" + this.mNeedRestoreNfc);
        if (NfcConstants.isReverseChargingBlockingState(this.mReverseChargingState) == false) goto L8;
        if (r8 != 3) goto L16;
        disableNfcForReverseCharging();
        return;
    L16:
        return;
    L8:
        if (this.mNeedRestoreNfc == true) goto L11;
        return;
    L11:
        if (r8 != 1) goto L13;
        restoreNfcIfNeeded();
        return;
    L13:
        if (r8 != 3) goto L18;
        this.mNeedRestoreNfc = false;
        return;
    }

    private /* synthetic */ void lambda$onNfcStateChanged$0(int r8) {
        handleNfcStateChanged(r8);
    }

    private void post(Runnable r8) {
        Handler r10 = this.mHandler;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.post(r8);
    }

    private int readReverseChargingState() {
        return Settings.System.getInt(this.mContext.getContentResolver(), NfcConstants.REVERSE_CHARGING_STATE, 0);
    L5:
        e = move-exception;
        a.q("readReverseChargingState: ", e, TAG);
        return 0;
    }

    private void registerReverseChargingObserver() {
        if (this.mReverseChargingObserver == null) goto L5;
        return;
    L5:
        final Handler r8 = this.mHandler;
        if (r8 != null) goto L9;
        CaeLog.w(TAG, "registerReverseChargingObserver: handler is null");
        return;
    L9:
        this.mReverseChargingObserver = new AnonymousClass1(this, r8);
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(NfcConstants.REVERSE_CHARGING_STATE), false, this.mReverseChargingObserver);
    }

    private boolean requestDisable(NfcAdapter r8) {
        boolean r10 = r8.disable(false);     // Catch: RuntimeException -> L5
        CaeLog.i(TAG, "requestDisable: result=" + r10);     // Catch: RuntimeException -> L5
        return r10;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "requestDisable: " + e);
        return false;
    }

    private boolean requestEnable(NfcAdapter r8) {
        boolean r10 = r8.enable();     // Catch: RuntimeException -> L5
        CaeLog.i(TAG, "requestEnable: result=" + r10);     // Catch: RuntimeException -> L5
        return r10;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "requestEnable: " + e);
        return false;
    }

    private void restoreNfcIfNeeded() {
        if (this.mNeedRestoreNfc == true) goto L5;
        return;
    L5:
        NfcAdapter r8 = getDefaultAdapterSafely("restoreNfcIfNeeded");
        if (r8 != null) goto L8;
        return;
    L8:
        int r10 = getAdapterStateSafely(r8, "restoreNfcIfNeeded");
        if (r10 != 1) goto L14;
        if (requestEnable(r8) == false) goto L17;
    L15:
        this.mNeedRestoreNfc = false;
        return;
    L17:
        return;
    L14:
        if (r10 == 3) goto L15;
    }

    private void retryDisableIfNeeded() {
        if (NfcConstants.isReverseChargingBlockingState(this.mReverseChargingState) == true) goto L5;
        return;
    L5:
        disableNfcForReverseCharging();
    }

    private void scheduleDisableRetry() {
        Handler r8 = this.mHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        r8.removeCallbacks(this.mDisableRetryRunnable);
        r8.postDelayed(this.mDisableRetryRunnable, 1000);
        CaeLog.w(TAG, "scheduleDisableRetry: 1000 ms");
    }

    private void startObserverThread() {
        if (this.mHandlerThread == null) goto L5;
        return;
    L5:
        HandlerThread r8 = new HandlerThread(OBSERVER_THREAD_NAME);
        this.mHandlerThread = r8;
        r8.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    private static String stateToString(int r8) {
        if (r8 != 0) goto L4;
        return "IDLE";
    L4:
        if (r8 != 1) goto L6;
        return "WAITING";
    L6:
        if (r8 != 2) goto L8;
        return "CHARGING";
    L8:
        if (r8 != 3) goto L10;
        return "PROTECTION";
    L10:
        return a.c("UNKNOWN(", r8, ")");
    }

    private void stopObserverThread() {
        Handler r8 = this.mHandler;
        if (r8 == null) goto L5;
        r8.removeCallbacksAndMessages(null);
    L5:
        this.mHandler = null;
        HandlerThread r10 = this.mHandlerThread;
        if (r10 == null) goto L9;
        r10.quitSafely();
        this.mHandlerThread = null;
        return;
    }

    private void unregisterReverseChargingObserver() {
        if (this.mReverseChargingObserver != null) goto L11;
        return;
    L11:
        this.mContext.getContentResolver().unregisterContentObserver(this.mReverseChargingObserver);     // Catch: Exception -> L7
    L9:
        this.mReverseChargingObserver = null;
        return;
    L7:
        e = move-exception;
        a.q("unregisterReverseChargingObserver: ", e, TAG);
        goto L9
    }

    private void updateReverseChargingState() {
        int r8 = readReverseChargingState();
        int r10 = this.mReverseChargingState;
        if (r10 != r8) goto L5;
        return;
    L5:
        boolean r11 = NfcConstants.isReverseChargingBlockingState(r10);
        boolean r12 = NfcConstants.isReverseChargingBlockingState(r8);
        StringBuilder r13 = new StringBuilder("updateReverseChargingState: ");
        r13.append(stateToString(this.mReverseChargingState));
        r13.append(" -> ");
        a.r(r13, stateToString(r8), TAG);
        this.mReverseChargingState = r8;
        if (r12 == false) goto L8;
        disableNfcForReverseCharging();
        return;
    L8:
        if (r11 == false) goto L12;
        cancelPendingDisableRetry();
        restoreNfcIfNeeded();
        return;
    }

    public void cleanup() {
        CaeLog.i(TAG, "cleanup");
        cancelPendingDisableRetry();
        unregisterReverseChargingObserver();
        stopObserverThread();
    }

    public void init() {
        CaeLog.i(TAG, "init");
        startObserverThread();
        registerReverseChargingObserver();
        post(new j(this, 28));
    }

    @Override // com.obric.cae.smartNfc.CaeNfcEventManagerService.NfcStateListener
    public void onNfcStateChanged(int r8) {
        post(new g(r8, 4, this));
    }
}
