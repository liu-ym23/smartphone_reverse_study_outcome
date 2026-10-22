package com.obric.cae.userAware;

import android.content.Context;
import android.os.SystemClock;
import com.obric.cae.libs.statemachine.d;
import com.obric.cae.libs.statemachine.e;
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.location.b;
import com.obric.cae.location.cell.g;
import com.obric.cae.location.city.f;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class RssiFluctuationMonitor {
    private static final int DEFAULT_COMPANY_RSSI_DROP_DB = 10;
    private static final int DEFAULT_COMPANY_RSSI_DROP_WINDOW_MS = 10000;
    private static final int DEFAULT_HOME_RSSI_DROP_DB = 17;
    private static final int DEFAULT_HOME_RSSI_DROP_WINDOW_MS = 5000;
    private static final int DEFAULT_RSSI_JUMP_TRIGGER_DB = 9;
    private static final int RSSI_BYPASS_FENCE_COMPANY = 2;
    private static final int RSSI_BYPASS_FENCE_HOME = 1;
    private static final int RSSI_BYPASS_FENCE_NONE = 0;
    private static final int RSSI_RECOVERY_HYSTERESIS_DB = 3;
    private static final int RSSI_TRIGGER_MAX_DBM_EXCLUSIVE = -68;
    private static final int RSSI_VALID_MAX_EXCLUSIVE_DBM = 0;
    private static final int RSSI_VALID_MIN_DBM = -100;
    private static final int RSSI_WINDOW_TOLERANCE_MS = 500;
    private static final int STRONG_SIGNAL_BYPASS_LIMIT_PER_FENCE = 5;
    private static final int STRONG_SIGNAL_RSSI_DBM = -68;
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
    private int mRssiTriggeredScanSceneType;
    private WifiScanConfigProvider mScanConfigProvider;
    private int mScanTriggerBaselineRssi;
    private int mStrongSignalBypassCount;
    private String mStrongSignalBypassDay;
    private int mStrongSignalBypassFenceKey;

    public interface Callback {
        List<String> getBssidsToAvoidRomingScan();

        String getCurrentConnectedBssid();

        int getFenceState();

        long getIndoorScanningDurationMs();

        boolean isEnabled();

        boolean isInPredictedRoom();

        boolean isOutsideFenceState();

        ConcurrentWifiScanner.RequestHandle startRssiTriggeredScan(int r1, long r2, long r4, boolean r6, boolean r7);

        boolean stopRssiTriggeredScan(ConcurrentWifiScanner.RequestHandle r1);
    }

    public static final class RssiSample {
        final int rssi;
        final long timestamp;

        public RssiSample(long r1, int r3) {
            this.timestamp = r1;
            this.rssi = r3;
        }
    }

    public RssiFluctuationMonitor(Context r5, Callback r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Callback r8 = (Callback) ZeusTransformUtils.wrapperContextForParams(r6, Callback.class, "com.obric.memorydata.plugin");
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
        this.mRssiTriggeredScanSceneType = -1;
        this.mStrongSignalBypassDay = "";
        this.mStrongSignalBypassFenceKey = 0;
        this.mStrongSignalBypassCount = 0;
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mCallback = r8;
    }

    private boolean allowRssiTriggeredScan(int r5, int r6) {
        Callback r4 = this.mCallback;
        boolean r1 = true;
        if (r4 != null) goto L7;
        a.g(TAG, "[RssiMonitor] allowRssiTriggeredScan: callback is null, fail-open");
        return true;
    L7:
        if (r4.isInPredictedRoom() == true) goto L10;
        return true;
    L10:
        if (r6 < (-68)) goto L15;
        if (r5 == 1) goto L15;
        r1 = false;
    L15:
        if (r1 == true) goto L17;
        StringBuilder r2 = new StringBuilder("[RssiMonitor] allowRssiTriggeredScan: blocked by gate, inPredictedRoom=true, fenceState=");
        a.e(TAG, r2.append(r5).append(", rssi=").append(r6).append(", threshold<-68").toString());
    L18:
        return r1;
    L17:
        r2 = new StringBuilder("[RssiMonitor] allowRssiTriggeredScan: pass, inPredictedRoom=true, fenceState=");
        a.c(TAG, r2.append(r5).append(", rssi=").append(r6).toString());
        goto L18
    }

    private void clearRecoveryStopState() {
        this.mScanTriggerBaselineRssi = Integer.MIN_VALUE;
        this.mAllowRecoveryStopForCurrentScan = false;
        this.mRecoveryStopFenceState = Integer.MIN_VALUE;
    }

    private static String formatDay(long r3) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(r3));
    }

    private int getRssiBypassFenceKey(int r1) {
        if (r1 != 1) goto L6;
        return 1;
    L6:
        if (r1 != 3) goto L9;
        return 2;
    L9:
        return 0;
    }

    private WifiScanConfigProvider getScanConfigProvider() {
        if (this.mScanConfigProvider != null) goto L6;
        this.mScanConfigProvider = WifiScanConfigProvider.getInstance(this.mContext);
    L6:
        return this.mScanConfigProvider;
    }

    private boolean isActiveRssiScanWindow() {
        if (this.mRssiTriggeredScanSceneType != (-1)) goto L5;
    L7:
        return false;
    L5:
        if ((this.mRssiTriggeredScanEndElapsedMs - SystemClock.elapsedRealtime()) <= 0) goto L7;
        return true;
    }

    private boolean isInHomeOrCompanyFence(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isStrongSignal(int r1) {
        if (r1 <= (-68)) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean lambda$onRssiUpdate$0(long r2, long r4, RssiSample r6) {
        if (r6 != null) goto L4;
    L7:
        return true;
    L4:
        if ((r2 - r6.timestamp) > r4) goto L7;
        return false;
    }

    private boolean maybeStopScanOnRecovery(int r9) {
        if ((this.mRssiTriggeredScanEndElapsedMs - SystemClock.elapsedRealtime()) > 0) goto L6;
        return false;
    L6:
        if (this.mAllowRecoveryStopForCurrentScan == true) goto L8;
        return false;
    L8:
        if (r9 < 0) goto L10;
    L35:
        return false;
    L10:
        if (r9 <= (-100)) goto L35;
        int r4 = this.mScanTriggerBaselineRssi;
        if (r4 > (-100)) goto L15;
    L17:
        boolean r0 = false;
    L18:
        int r5 = this.mRecoveryStopFenceState;
        if (r5 == 3) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r5 != 1) goto L26;
        boolean r6 = r0;
    L31:
        if (r6 == true) goto L33;
        return false;
    L33:
        a.e(TAG, d.a("[RssiMonitor] signal recovered, stop scan: rssi=", r9, ", baseline=").append(this.mScanTriggerBaselineRssi).append(", fenceState=").append(this.mRecoveryStopFenceState).append(", absRecovered=").append(r7).append(", relRecovered=").append(r0).toString());
        stopScan();
        this.mRssiTriggeredScanEndElapsedMs = 0;
        clearRecoveryStopState();
        return true;
    L26:
        if (r5 != 3) goto L30;
        if (r7 == true) goto L29;
        if (r0 == false) goto L30;
    L29:
        r6 = true;
    L30:
        r6 = false;
        goto L31
    L21:
        if (r9 < (-65)) goto L23;
        r7 = true;
        goto L24
    L15:
        if (r9 < (r4 - 3)) goto L17;
        r0 = true;
        goto L18
    }

    private void maybeTriggerDropScan(long r7, int r9, int r10, int r11, int r12) {
        if (allowRssiTriggeredScan(this.mCallback.getFenceState(), r9) == true) goto L5;
        return;
    L5:
        long r8 = (r7 - ((long) r10)) - 500;
        Iterator<RssiSample> r0 = this.mRssiHistory.iterator();
        int r2 = Integer.MIN_VALUE;
    L7:
        if (r0.hasNext() == false) goto L14;
        RssiSample r3 = (RssiSample) ZeusTransformUtils.preCheckCast(r0.next(), RssiSample.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        if (r3.timestamp < r8) goto L7;
        r2 = Math.max(r2, r3.rssi);
        goto L7
    L14:
        if (r2 != Integer.MIN_VALUE) goto L16;
        return;
    L16:
        int r4 = r2 - r9;
        if (r4 < r11) goto L27;
        a.e(TAG, b.a("[RssiMonitor] RSSI drop matched: ", r4, "dB in ", r10, "ms (threshold=").append(r11).append(")").toString());
        clearRecoveryStopState();
        restartRssiTriggeredScan(r12, this.mCallback.getIndoorScanningDurationMs(), this.mCallback.getFenceState(), r9);
        return;
    }

    private void resetStrongSignalBypassCounterIfNeededLocked(int r3) {
        String r0 = formatDay(System.currentTimeMillis());
        if (r0.equals(this.mStrongSignalBypassDay) == true) goto L5;
    L6:
        this.mStrongSignalBypassDay = r0;
        this.mStrongSignalBypassFenceKey = r3;
        this.mStrongSignalBypassCount = 0;
        a.e(TAG, "[RssiMonitor] reset strong RSSI bypass counter: fenceKey=" + r3 + ", day=" + r0);
        return;
    L5:
        if (this.mStrongSignalBypassFenceKey != r3) goto L6;
    }

    private void resetStrongSignalBypassCounterLocked() {
        if (this.mStrongSignalBypassFenceKey == 0) goto L5;
    L6:
        g.a(new StringBuilder("[RssiMonitor] reset strong RSSI bypass counter on fence exit: count="), this.mStrongSignalBypassCount, TAG);
    L7:
        this.mStrongSignalBypassFenceKey = 0;
        this.mStrongSignalBypassCount = 0;
        this.mStrongSignalBypassDay = "";
        return;
    L5:
        if (this.mStrongSignalBypassCount == 0) goto L7;
        goto L6
    }

    private void restartRssiTriggeredScan(int r13, long r14, int r16, int r17) {
        a.c(TAG, "[RssiMonitor] restartRssiTriggeredScan");
        Callback r3 = this.mCallback;
        if (r3 != null) goto L5;
    L21:
        a.e(TAG, "[RssiMonitor] skip scan: OutsideFenceState");
        return;
    L5:
        if (r3.isOutsideFenceState() == true) goto L21;
        if (r14 > 0) goto L10;
        return;
    L10:
        WifiScanConfigProvider.ActiveConfigSnapshot r7 = getScanConfigProvider().getActiveConfigSnapshot();
        if (r7.isSceneEnabled(r13) == true) goto L14;
        a.e(TAG, d.a("[RssiMonitor] skip scan: scene disabled, sceneType=", r13, ", name=").append(WifiScanSceneType.sceneNameOf(r13)).toString());
        this.mRssiTriggeredScanEndElapsedMs = 0;
        this.mRssiTriggeredScanSceneType = -1;
        return;
    L14:
        boolean r4 = isActiveRssiScanWindow();
        this.mRssiTriggeredScanEndElapsedMs = SystemClock.elapsedRealtime() + r14;
        long r8 = r7.getEffectiveIntervalMs(r13);
        boolean r5 = false;
        boolean r9 = r7.shouldIgnoreMovementGate(r13, false);
        if (r9 == false) goto L17;
    L19:
        boolean r10 = r5;
        this.mRssiTriggeredScanSceneType = r13;
        a.e(TAG, "[RssiMonitor] start scan: sceneType=" + r13 + ", interval=" + r8 + "ms, duration=" + r14 + "ms, ignoreMovementGate=" + r9 + ", allowFirstScanWithoutMovement=" + r10 + ", reconfig=" + r4);
        this.mRssiTriggeredScanHandle = this.mCallback.startRssiTriggeredScan(r13, r8, r14, r9, r10);
        return;
    L17:
        if (shouldAllowFirstScanWithoutMovement(r16, r17, r4) == false) goto L19;
        r5 = true;
        goto L19
    }

    private boolean shouldAllowFirstScanWithoutMovement(int r7, int r8, boolean r9) {
        if (r9 == false) goto L7;
        a.c(TAG, "[RssiMonitor] first movement bypass denied for RSSI reconfig");
        return false;
    L7:
        if (isStrongSignal(r8) == true) goto L10;
        a.c(TAG, "[RssiMonitor] weak RSSI first movement bypass allowed");
        return true;
    L10:
        int r10 = getRssiBypassFenceKey(r7);
        if (r10 != 0) goto L14;
        a.c(TAG, "[RssiMonitor] strong RSSI bypass quota ignored outside home/company, fenceState=" + r7);
        return true;
    L14:
        monitor-enter(this);
        resetStrongSignalBypassCounterIfNeededLocked(r10);     // Catch: Throwable -> L23
        int r11 = this.mStrongSignalBypassCount;     // Catch: Throwable -> L23
        if (r11 >= 5) goto L20;
        this.mStrongSignalBypassCount = r11 + 1;     // Catch: Throwable -> L23
        a.e(TAG, "[RssiMonitor] strong RSSI first movement bypass allowed: count=" + this.mStrongSignalBypassCount + "/5, fenceKey=" + r10);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return true;
    L20:
        a.e(TAG, "[RssiMonitor] strong RSSI first movement bypass denied: count=" + this.mStrongSignalBypassCount + "/5, fenceKey=" + r10);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return false;
    L23:
        th = move-exception;
        throw th;
    }

    public void onFenceStateChanged(int r4) {
        int r5 = getRssiBypassFenceKey(r4);
        monitor-enter(this);
        if (r5 != 0) goto L9;
        resetStrongSignalBypassCounterLocked();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L9:
        if (this.mStrongSignalBypassFenceKey == r5) goto L11;
        this.mStrongSignalBypassFenceKey = r5;     // Catch: Throwable -> L13
        this.mStrongSignalBypassDay = formatDay(System.currentTimeMillis());     // Catch: Throwable -> L13
        this.mStrongSignalBypassCount = 0;     // Catch: Throwable -> L13
        a.e(TAG, "[RssiMonitor] reset strong RSSI bypass counter: fenceKey=" + r5 + ", day=" + this.mStrongSignalBypassDay);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void onRssiUpdate(int r17) {
        Callback r1 = this.mCallback;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isEnabled() == false) goto L71;
        String r2 = this.mCallback.getCurrentConnectedBssid();
        List<String> r3 = this.mCallback.getBssidsToAvoidRomingScan();
        if (r3 == null) goto L15;
        if (r2 == null) goto L15;
        if (r3.contains(String.valueOf(r2.hashCode())) == false) goto L15;
        a.c(TAG, f.a("onRssiUpdate: avoid roming scan for connected bssid:", r2, " hashcode:").append(r2.hashCode()).toString());
        return;
    L15:
        if (r17 <= (-100)) goto L62;
        if (r17 >= 0) goto L62;
        a.c(TAG, "onRssiUpdate");
        final long r9 = System.currentTimeMillis();
        List<RssiSample> r4 = this.mRssiHistory;
        monitor-enter(r4);
        this.mRssiHistory.add(new RssiSample(r9, r17));     // Catch: Throwable -> L59
        monitor-exit(r4);     // Catch: Throwable -> L59
        int r11 = this.mCallback.getFenceState();
        g.a(e.a(new StringBuilder("mLastRssi: "), this.mLastRssi, " rssi: ", r17, " mFenceState: "), r11, TAG);
        Object r5 = this.mConfigLock;
        monitor-enter(r5);
        int r6 = this.mJumpTriggerDb;     // Catch: Throwable -> L56
        int r12 = this.mHomeDropWindowMs;     // Catch: Throwable -> L56
        int r13 = this.mHomeDropDb;     // Catch: Throwable -> L56
        int r7 = this.mCompanyDropWindowMs;     // Catch: Throwable -> L56
        int r8 = this.mCompanyDropDb;     // Catch: Throwable -> L56
        monitor-exit(r5);     // Catch: Throwable -> L56
        final long r10 = ((long) Math.max(r7, r12)) + 1000;
        List<RssiSample> r14 = this.mRssiHistory;
        monitor-enter(r14);
        this.mRssiHistory.removeIf(new $$Lambda$RssiFluctuationMonitor$zkUXz0a9u3bKPS5knPt3JgRyBWE(r9, r10));     // Catch: Throwable -> L53
        monitor-exit(r14);     // Catch: Throwable -> L53
        if (maybeStopScanOnRecovery(r17) == false) goto L35;
        this.mLastRssi = r17;
        return;
    L35:
        if (isInHomeOrCompanyFence(r11) == false) goto L47;
        int r15 = this.mLastRssi;
        if (r15 >= 0) goto L47;
        if (r15 <= (-100)) goto L47;
        if ((r15 - r17) < r6) goto L47;
        a.e(TAG, "[RssiMonitor] RSSI drop matched: 9dB");
        if (allowRssiTriggeredScan(r11, r17) == false) goto L45;
        this.mScanTriggerBaselineRssi = this.mLastRssi;
        this.mAllowRecoveryStopForCurrentScan = true;
        this.mRecoveryStopFenceState = r11;
        restartRssiTriggeredScan(6, this.mCallback.getIndoorScanningDurationMs(), r11, r17);
        this.mLastRssi = r17;
        return;
    L45:
        a.e(TAG, "[RssiMonitor] skip scan: rssi=" + r17 + " not < -68");
    L47:
        if (r11 != 3) goto L49;
        maybeTriggerDropScan(r9, r17, r7, r8, 7);
    L49:
        if (r11 != 1) goto L51;
        maybeTriggerDropScan(r9, r17, r12, r13, 8);
    L51:
        this.mLastRssi = r17;
        return;
    L53:
        th = move-exception;
        throw th;
    L56:
        th = move-exception;
        throw th;
    L59:
        th = move-exception;
        throw th;
    L62:
        a.e(TAG, "[RssiMonitor] ignore invalid rssi=" + r17);
        return;
    }

    public void reset() {
        List<RssiSample> r0 = this.mRssiHistory;
        monitor-enter(r0);
        this.mLastRssi = Integer.MIN_VALUE;     // Catch: Throwable -> L9
        this.mRssiHistory.clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mRssiTriggeredScanSceneType = -1;
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
        if (this.mCallback.isOutsideFenceState() == false) goto L10;
        a.e(TAG, "[RssiMonitor] skip resume: OutsideFenceState");
        return;
    L10:
        if (this.mRssiTriggeredScanSceneType != (-1)) goto L12;
        return;
    L12:
        WifiScanConfigProvider.ActiveConfigSnapshot r2 = getScanConfigProvider().getActiveConfigSnapshot();
        if (r2.isSceneEnabled(this.mRssiTriggeredScanSceneType) == true) goto L16;
        a.e(TAG, "[RssiMonitor] skip resume: scene disabled, sceneType=" + this.mRssiTriggeredScanSceneType + ", name=" + WifiScanSceneType.sceneNameOf(this.mRssiTriggeredScanSceneType));
        this.mRssiTriggeredScanEndElapsedMs = 0;
        this.mRssiTriggeredScanSceneType = -1;
        return;
    L16:
        long r6 = r2.getEffectiveIntervalMs(this.mRssiTriggeredScanSceneType);
        a.e(TAG, "[RssiMonitor] resumeRssiTriggeredScan remaining=" + r8 + "ms, allowFirstScanWithoutMovement=false");
        Callback r4 = this.mCallback;
        int r5 = this.mRssiTriggeredScanSceneType;
        this.mRssiTriggeredScanHandle = r4.startRssiTriggeredScan(r5, r6, r8, r2.shouldIgnoreMovementGate(r5, false), false);
    }

    public void setDropThresholdList(List<RssiDropThreshold> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        this.mDropThresholdList = new ArrayList(r4);
        return;
    L5:
        this.mDropThresholdList = new ArrayList();
    }

    public void setTriggerThresholds(int r4, int r5, int r6, int r7, int r8) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        if (r4 <= 0) goto L11;
        if (r4 >= 50) goto L11;
        this.mJumpTriggerDb = r4;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        if (r5 <= 0) goto L14;
        if (r5 > 60000) goto L14;
        this.mHomeDropWindowMs = r5;     // Catch: Throwable -> L8
    L14:
        if (r6 <= 0) goto L17;
        if (r6 >= 50) goto L17;
        this.mHomeDropDb = r6;     // Catch: Throwable -> L8
    L17:
        if (r7 <= 0) goto L20;
        if (r7 > 60000) goto L20;
        this.mCompanyDropWindowMs = r7;     // Catch: Throwable -> L8
    L20:
        if (r8 <= 0) goto L23;
        if (r8 >= 50) goto L23;
        this.mCompanyDropDb = r8;     // Catch: Throwable -> L8
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
        g.a(e.a(b.a("[RssiMonitor] setTriggerThresholds: jumpDb=", r4, ", homeDropWindowMs=", r5, ", homeDropDb="), r6, ", companyDropWindowMs=", r7, ", companyDropDb="), r8, TAG);
    }

    public void stopScan() {
        a.c(TAG, "[RssiMonitor] stopScan");
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.stopRssiTriggeredScan(this.mRssiTriggeredScanHandle);
        return;
    }
}
