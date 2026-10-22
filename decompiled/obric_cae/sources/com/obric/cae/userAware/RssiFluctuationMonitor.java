package com.obric.cae.userAware;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RssiFluctuationMonitor {
    private static final int DEFAULT_COMPANY_RSSI_DROP_DB = 10;
    private static final int DEFAULT_COMPANY_RSSI_DROP_WINDOW_MS = 10000;
    private static final int DEFAULT_HOME_RSSI_DROP_DB = 17;
    private static final int DEFAULT_HOME_RSSI_DROP_WINDOW_MS = 5000;
    private static final int DEFAULT_RSSI_JUMP_TRIGGER_DB = 9;
    private static final int RSSI_RECOVERY_HYSTERESIS_DB = 3;
    private static final int RSSI_TRIGGER_MAX_DBM_EXCLUSIVE = -68;
    private static final int RSSI_VALID_MAX_EXCLUSIVE_DBM = 0;
    private static final int RSSI_VALID_MIN_DBM = -100;
    private static final int RSSI_WINDOW_TOLERANCE_MS = 500;
    private static final String TAG = "RssiFluctuationMonitor";
    private boolean mAllowRecoveryStopForCurrentScan;
    private final Callback mCallback;
    private int mCompanyDropDb;
    private int mCompanyDropWindowMs;
    private final Object mConfigLock;
    private final Context mContext;
    private List<RssiDropThreshold> mDropThresholdList;
    private int mHomeDropDb;
    private int mHomeDropWindowMs;
    private int mJumpTriggerDb;
    private int mLastRssi;
    private int mRecoveryStopFenceState;
    private final List<RssiSample> mRssiHistory;
    private long mRssiTriggeredScanEndElapsedMs;
    private ConcurrentWifiScanner.RequestHandle mRssiTriggeredScanHandle;
    private int mScanTriggerBaselineRssi;

    public interface Callback {
        List<String> getBssidsToAvoidRomingScan();

        String getCurrentConnectedBssid();

        int getFenceState();

        long getIndoorScanningDurationMs();

        ConcurrentWifiScanner getScanner();

        boolean isEnabled();

        boolean isInPredictedRoom();

        boolean isOutsideFenceState();

        void onScanResults(List<ScanResult> r8);

        void setLastTriggeredSceneType(int r8);
    }

    public static final class RssiSample {
        final int rssi;
        final long timestamp;

        public RssiSample(long r8, int r10) {
            this.timestamp = r8;
            this.rssi = r10;
        }
    }

    public RssiFluctuationMonitor(Context r8, Callback r10) {
        this.mRssiTriggeredScanEndElapsedMs = 0;
        this.mScanTriggerBaselineRssi = Integer.MIN_VALUE;
        this.mAllowRecoveryStopForCurrentScan = false;
        this.mRecoveryStopFenceState = Integer.MIN_VALUE;
        this.mConfigLock = new Object();
        this.mJumpTriggerDb = 9;
        this.mHomeDropWindowMs = 5000;
        this.mHomeDropDb = 17;
        this.mCompanyDropWindowMs = 10000;
        this.mCompanyDropDb = 10;
        this.mRssiHistory = new CopyOnWriteArrayList();
        this.mDropThresholdList = new ArrayList();
        this.mLastRssi = Integer.MIN_VALUE;
        this.mContext = r8;
        this.mCallback = r10;
    }

    public static /* synthetic */ void a(RssiFluctuationMonitor r8, List r10) {
        r8.lambda$restartRssiTriggeredScan$1(r10);
    }

    private boolean allowRssiTriggeredScan(int r8, int r10) {
        Callback r11 = this.mCallback;
        boolean r12 = true;
        if (r11 != null) goto L7;
        CommSenseLog.w(TAG, "[RssiMonitor] allowRssiTriggeredScan: callback is null, fail-open");
        return true;
    L7:
        if (r11.isInPredictedRoom() == true) goto L10;
        return true;
    L10:
        if (r10 < RSSI_TRIGGER_MAX_DBM_EXCLUSIVE) goto L15;
        if (r8 == 1) goto L15;
        r12 = false;
    L15:
        if (r12 == true) goto L17;
        StringBuilder r13 = new StringBuilder("[RssiMonitor] allowRssiTriggeredScan: blocked by gate, inPredictedRoom=true, fenceState=");
        r13.append(r8);
        r13.append(", rssi=");
        r13.append(r10);
        r13.append(", threshold<-68");
        CommSenseLog.i(TAG, r13.toString());
    L18:
        return r12;
    L17:
        r13 = new StringBuilder("[RssiMonitor] allowRssiTriggeredScan: pass, inPredictedRoom=true, fenceState=");
        r13.append(r8);
        r13.append(", rssi=");
        r13.append(r10);
        CommSenseLog.d(TAG, r13.toString());
        goto L18
    }

    public static /* synthetic */ void b(RssiFluctuationMonitor r8, List r10) {
        r8.lambda$resumeRssiTriggeredScanIfNeeded$2(r10);
    }

    public static /* synthetic */ boolean c(long r8, long r10, RssiSample r11) {
        return lambda$onRssiUpdate$0(r8, r10, r11);
    }

    private void clearRecoveryStopState() {
        this.mScanTriggerBaselineRssi = Integer.MIN_VALUE;
        this.mAllowRecoveryStopForCurrentScan = false;
        this.mRecoveryStopFenceState = Integer.MIN_VALUE;
    }

    private boolean isInHomeOrCompanyFence(int r8) {
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    private static /* synthetic */ boolean lambda$onRssiUpdate$0(long r8, long r10, RssiSample r11) {
        if (r11 != null) goto L4;
    L7:
        return true;
    L4:
        if ((r8 - r11.timestamp) > r10) goto L7;
        return false;
    }

    private /* synthetic */ void lambda$restartRssiTriggeredScan$1(List r8) {
        Callback r10 = this.mCallback;
        if (r10 == null) goto L6;
        r10.onScanResults(r8);
        return;
    }

    private /* synthetic */ void lambda$resumeRssiTriggeredScanIfNeeded$2(List r8) {
        Callback r10 = this.mCallback;
        if (r10 == null) goto L6;
        r10.onScanResults(r8);
        return;
    }

    private boolean maybeStopScanOnRecovery(int r10) {
        if ((this.mRssiTriggeredScanEndElapsedMs - SystemClock.elapsedRealtime()) > 0) goto L6;
        return false;
    L6:
        if (this.mAllowRecoveryStopForCurrentScan == true) goto L8;
        return false;
    L8:
        if (r10 < 0) goto L10;
    L35:
        return false;
    L10:
        if (r10 <= (-100)) goto L35;
        int r8 = this.mScanTriggerBaselineRssi;
        if (r8 > (-100)) goto L15;
    L17:
        boolean r11 = false;
    L18:
        int r12 = this.mRecoveryStopFenceState;
        if (r12 == 3) goto L21;
    L23:
        boolean r13 = false;
    L24:
        if (r12 != 1) goto L26;
        boolean r14 = r11;
    L31:
        if (r14 == true) goto L33;
        return false;
    L33:
        StringBuilder r15 = defpackage.b.f("[RssiMonitor] signal recovered, stop scan: rssi=", r10, ", baseline=");
        r15.append(this.mScanTriggerBaselineRssi);
        r15.append(", fenceState=");
        r15.append(this.mRecoveryStopFenceState);
        r15.append(", absRecovered=");
        r15.append(r13);
        r15.append(", relRecovered=");
        r15.append(r11);
        CommSenseLog.i(TAG, r15.toString());
        stopScan();
        this.mRssiTriggeredScanEndElapsedMs = 0;
        clearRecoveryStopState();
        return true;
    L26:
        if (r12 != 3) goto L30;
        if (r13 == true) goto L29;
        if (r11 == false) goto L30;
    L29:
        r14 = true;
    L30:
        r14 = false;
        goto L31
    L21:
        if (r10 < (-65)) goto L23;
        r13 = true;
        goto L24
    L15:
        if (r10 < (r8 - 3)) goto L17;
        r11 = true;
        goto L18
    }

    private void maybeTriggerDropScan(long r8, int r10, int r11, int r12, int r13) {
        if (allowRssiTriggeredScan(this.mCallback.getFenceState(), r10) == true) goto L5;
        return;
    L5:
        long r14 = (r8 - ((long) r11)) - 500;
        Iterator<RssiSample> r15 = this.mRssiHistory.iterator();
        int r16 = Integer.MIN_VALUE;
    L7:
        if (r15.hasNext() == false) goto L14;
        RssiSample r17 = r15.next();
        if (r17 == null) goto L7;
        if (r17.timestamp < r14) goto L7;
        r16 = Math.max(r16, r17.rssi);
        goto L7
    L14:
        if (r16 != Integer.MIN_VALUE) goto L16;
        return;
    L16:
        int r18 = r16 - r10;
        if (r18 < r12) goto L27;
        StringBuilder r19 = defpackage.a.g("[RssiMonitor] RSSI drop matched: ", r18, "dB in ", r11, "ms (threshold=");
        r19.append(r12);
        r19.append(")");
        CommSenseLog.i(TAG, r19.toString());
        this.mCallback.setLastTriggeredSceneType(r13);
        clearRecoveryStopState();
        restartRssiTriggeredScan(this.mCallback.getIndoorScanningDurationMs());
        return;
    }

    private void restartRssiTriggeredScan(long r8) {
        CommSenseLog.d(TAG, "[RssiMonitor] restartRssiTriggeredScan");
        Callback r10 = this.mCallback;
        if (r10 != null) goto L5;
    L15:
        CommSenseLog.i(TAG, "[RssiMonitor] skip scan: OutsideFenceState");
        return;
    L5:
        if (r10.isOutsideFenceState() == true) goto L15;
        if (r8 > 0) goto L10;
        return;
    L10:
        this.mRssiTriggeredScanEndElapsedMs = SystemClock.elapsedRealtime() + r8;
        ConcurrentWifiScanner r11 = this.mCallback.getScanner();
        if (r11 != null) goto L13;
        return;
    L13:
        this.mRssiTriggeredScanHandle = r11.startScan(WifiScanStateMachine.getThrottledScanIntervalMs(this.mContext), r8, new v(this, 1));
    }

    public void onRssiUpdate(int r15) {
        Callback r8 = this.mCallback;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEnabled() == false) goto L66;
        String r10 = this.mCallback.getCurrentConnectedBssid();
        List<String> r11 = this.mCallback.getBssidsToAvoidRomingScan();
        if (r11 == null) goto L14;
        if (r10 == null) goto L14;
        if (r11.contains(String.valueOf(r10.hashCode())) == false) goto L14;
        StringBuilder r16 = defpackage.b.h("onRssiUpdate: avoid roming scan for connected bssid:", r10, " hashcode:");
        r16.append(r10.hashCode());
        CommSenseLog.i(TAG, r16.toString());
        return;
    L14:
        CommSenseLog.d(TAG, "onRssiUpdate");
        final long r12 = System.currentTimeMillis();
        List<RssiSample> r13 = this.mRssiHistory;
        monitor-enter(r13);
        this.mRssiHistory.add(new RssiSample(r12, r15));     // Catch: Throwable -> L56
        monitor-exit(r13);     // Catch: Throwable -> L56
        int r14 = this.mCallback.getFenceState();
        StringBuilder r17 = new StringBuilder("mLastRssi: ");
        defpackage.b.q(r17, this.mLastRssi, " rssi: ", r15, " mFenceState: ");
        r17.append(r14);
        CommSenseLog.d(TAG, r17.toString());
        Object r18 = this.mConfigLock;
        monitor-enter(r18);
        int r19 = this.mJumpTriggerDb;     // Catch: Throwable -> L53
        int r110 = this.mHomeDropWindowMs;     // Catch: Throwable -> L53
        int r111 = this.mHomeDropDb;     // Catch: Throwable -> L53
        int r20 = this.mCompanyDropWindowMs;     // Catch: Throwable -> L53
        int r21 = this.mCompanyDropDb;     // Catch: Throwable -> L53
        monitor-exit(r18);     // Catch: Throwable -> L53
        final long r22 = ((long) Math.max(r20, r110)) + 1000;
        List<RssiSample> r23 = this.mRssiHistory;
        monitor-enter(r23);
        this.mRssiHistory.removeIf(new k(r12, r22));     // Catch: Throwable -> L50
        monitor-exit(r23);     // Catch: Throwable -> L50
        if (maybeStopScanOnRecovery(r15) == false) goto L31;
        this.mLastRssi = r15;
        return;
    L31:
        if (isInHomeOrCompanyFence(r14) == false) goto L44;
        int r24 = this.mLastRssi;
        if (r24 >= 0) goto L44;
        if (r24 <= (-100)) goto L44;
        if ((r24 - r15) < r19) goto L44;
        CommSenseLog.i(TAG, "[RssiMonitor] RSSI drop matched: 9dB");
        if (allowRssiTriggeredScan(r14, r15) == false) goto L42;
        this.mCallback.setLastTriggeredSceneType(6);
        this.mScanTriggerBaselineRssi = this.mLastRssi;
        this.mAllowRecoveryStopForCurrentScan = true;
        this.mRecoveryStopFenceState = r14;
        restartRssiTriggeredScan(this.mCallback.getIndoorScanningDurationMs());
        this.mLastRssi = r15;
        return;
    L42:
        CommSenseLog.i(TAG, "[RssiMonitor] skip scan: rssi=" + r15 + " not < -68");
    L44:
        if (r14 != 3) goto L46;
        maybeTriggerDropScan(r12, r15, r20, r21, 7);
    L46:
        if (r14 != 1) goto L48;
        maybeTriggerDropScan(r12, r15, r110, r111, 8);
    L48:
        this.mLastRssi = r15;
        return;
    L50:
        th = move-exception;
        throw th;
    L53:
        th = move-exception;
        throw th;
    L56:
        th = move-exception;
        throw th;
    }

    public void reset() {
        List<RssiSample> r8 = this.mRssiHistory;
        monitor-enter(r8);
        this.mLastRssi = Integer.MIN_VALUE;     // Catch: Throwable -> L9
        this.mRssiHistory.clear();     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        clearRecoveryStopState();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void resumeRssiTriggeredScanIfNeeded() {
        long r8 = this.mRssiTriggeredScanEndElapsedMs - SystemClock.elapsedRealtime();
        if (r8 > 0) goto L6;
        return;
    L6:
        if (this.mCallback.isOutsideFenceState() == false) goto L9;
        CommSenseLog.i(TAG, "[RssiMonitor] skip resume: OutsideFenceState");
        return;
    L9:
        ConcurrentWifiScanner r10 = this.mCallback.getScanner();
        if (r10 != null) goto L12;
        return;
    L12:
        long r11 = WifiScanStateMachine.getThrottledScanIntervalMs(this.mContext);
        CommSenseLog.i(TAG, "[RssiMonitor] resumeRssiTriggeredScan remaining=" + r8 + "ms");
        this.mRssiTriggeredScanHandle = r10.startScan(r11, r8, new e(this, 1));
    }

    public void setDropThresholdList(List<RssiDropThreshold> r8) {
        if (r8 == null) goto L4;
        this.mDropThresholdList = new ArrayList(r8);
        return;
    L4:
        this.mDropThresholdList = new ArrayList();
    }

    public void setTriggerThresholds(int r8, int r10, int r11, int r12, int r13) {
        Object r14 = this.mConfigLock;
        monitor-enter(r14);
        if (r8 <= 0) goto L11;
        if (r8 >= 50) goto L11;
        this.mJumpTriggerDb = r8;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        if (r10 <= 0) goto L14;
        if (r10 > 60000) goto L14;
        this.mHomeDropWindowMs = r10;     // Catch: Throwable -> L8
    L14:
        if (r11 <= 0) goto L17;
        if (r11 >= 50) goto L17;
        this.mHomeDropDb = r11;     // Catch: Throwable -> L8
    L17:
        if (r12 <= 0) goto L20;
        if (r12 > 60000) goto L20;
        this.mCompanyDropWindowMs = r12;     // Catch: Throwable -> L8
    L20:
        if (r13 <= 0) goto L23;
        if (r13 >= 50) goto L23;
        this.mCompanyDropDb = r13;     // Catch: Throwable -> L8
    L23:
        monitor-exit(r14);     // Catch: Throwable -> L8
        StringBuilder r15 = defpackage.a.g("[RssiMonitor] setTriggerThresholds: jumpDb=", r8, ", homeDropWindowMs=", r10, ", homeDropDb=");
        defpackage.b.q(r15, r11, ", companyDropWindowMs=", r12, ", companyDropDb=");
        r15.append(r13);
        CommSenseLog.i(TAG, r15.toString());
    }

    public void stopScan() {
        CommSenseLog.d(TAG, "[RssiMonitor] stopScan");
        Callback r8 = this.mCallback;
        if (r8 == null) goto L5;
        ConcurrentWifiScanner r10 = r8.getScanner();
    L6:
        if (r10 == null) goto L9;
        r10.stopScan(this.mRssiTriggeredScanHandle);
        return;
    L9:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
