package com.obric.cae.userAware;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiScanner;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.libs.statemachine.d;
import com.obric.cae.libs.statemachine.e;
import com.obric.cae.location.b;
import com.obric.cae.log.a;
import com.obric.cae.userAware.datacollection.WifiScanCount;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class ConcurrentWifiScanner {
    private static final int FULL_BAND = 3;
    private static final int PNO_MIN_24GHZ_RSSI_DBM = -80;
    private static final int PNO_MIN_5GHZ_RSSI_DBM = -77;
    private static final int PNO_MIN_6GHZ_RSSI_DBM = -80;
    private static final int PNO_SCAN_INTERVAL_MULTIPLIER = 1;
    static final long SCAN_RETRY_BACKOFF_MS = 1000;
    static final long SCAN_RETRY_BACKOFF_NO_SUCH_DEVICE_MS = 3000;
    static final long SCAN_TIMEOUT_MS = 3500;
    private static final long SCAN_WAKELOCK_BUFFER_MS = 500;
    private static final long STEP_GATE_RETRY_DELAY_MS = 1000;
    private static final long STEP_RECENT_WINDOW_MS = 3000;
    private static final String TAG = "ConcurrentWifiScanner";
    private static final String WIFI_SCANNING_SERVICE = "wifiscanner";
    private final Context mContext;
    private ScanRequest mCurrentRequest;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private boolean mIsWifiEnabled;
    private List<ScanResult> mLastScanResults;
    private long mLastScanTimestampMs;
    private final Object mLock;
    private volatile WifiScanConfigProvider mScanConfigProvider;
    private final AtomicInteger mScanSessionId;
    private final StepMovementGate mStepMovementGate;
    private final AtomicInteger mTotalScanCount;
    private boolean mTrainingMode;
    private PowerManager.WakeLock mWakeLock;
    private final Object mWakeLockLock;
    private WifiAwareInfoManager mWifiAwareInfoManager;
    private final WifiManager mWifiManager;
    private WifiStateReceiver mWifiReceiver;
    private final WifiScanner mWifiScanner;

    public interface AttributedScanCallback {
        void onScanResults(List<ScanResult> r1, WifiScanAttribution r2);
    }

    public static final enum FirstAttemptGateState extends Enum<FirstAttemptGateState> {
        private static final /* synthetic */ FirstAttemptGateState[] $VALUES = null;
        public static final FirstAttemptGateState AFTER_FIRST_ATTEMPT = null;
        public static final FirstAttemptGateState BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE = null;
        public static final FirstAttemptGateState BEFORE_FIRST_ATTEMPT_NO_TOKEN = null;

        private static /* synthetic */ FirstAttemptGateState[] $values() {
            return new FirstAttemptGateState[]{BEFORE_FIRST_ATTEMPT_NO_TOKEN, BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE, AFTER_FIRST_ATTEMPT};
        }

        static {
            BEFORE_FIRST_ATTEMPT_NO_TOKEN = new FirstAttemptGateState("BEFORE_FIRST_ATTEMPT_NO_TOKEN", 0);
            BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE = new FirstAttemptGateState("BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE", 1);
            AFTER_FIRST_ATTEMPT = new FirstAttemptGateState("AFTER_FIRST_ATTEMPT", 2);
            $VALUES = $values();
        }

        private FirstAttemptGateState(String r1, int r2) {
            super(r1, r2);
        }

        public static FirstAttemptGateState valueOf(String r2) {
            return (FirstAttemptGateState) ZeusTransformUtils.preCheckCast(Enum.valueOf(FirstAttemptGateState.class, r2), FirstAttemptGateState.class, "com.obric.memorydata.plugin");
        }

        public static FirstAttemptGateState[] values() {
            return (FirstAttemptGateState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FirstAttemptGateState[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class RequestHandle {
        private final WifiScanAttribution attribution;
        private final int requestId;

        public RequestHandle(int r2) {
            this(r2, WifiScanAttributionFactory.invalid());
        }

        public RequestHandle(int r1, WifiScanAttribution r2) {
            this.requestId = r1;
            if (r2 != null) goto L6;
            r2 = WifiScanAttributionFactory.invalid();
        L6:
            this.attribution = r2;
        }

        public WifiScanAttribution getAttribution() {
            return this.attribution;
        }

        public int getId() {
            return this.requestId;
        }

        public boolean isScene(int r1) {
            WifiScanAttribution r0 = this.attribution;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.getSceneId() != r1) goto L7;
            return true;
        }

        public String toString() {
            return "RequestHandle{requestId=" + this.requestId + ", attribution=" + this.attribution + '}';
        }
    }

    public interface ScanCallback {
        void onScanResults(List<ScanResult> r1);
    }

    public class ScanRequest {
        private volatile WifiScanAttribution attribution;
        private volatile AttributedScanCallback callback;
        private volatile long durationMs;
        private volatile FirstAttemptGateState firstAttemptGateState;
        private volatile int id;
        private volatile boolean ignoreMovementGate;
        private boolean ignoreScanBudget;
        private volatile long intervalMs;
        private final Runnable scanRunnable;
        private volatile long startTimeMs;
        final /* synthetic */ ConcurrentWifiScanner this$0;

        public ScanRequest(ConcurrentWifiScanner r14, int r15, long r16, long r18, AttributedScanCallback r20, boolean r21, WifiScanAttribution r22) {
            this(r14, r15, r16, r18, (AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r20, AttributedScanCallback.class, "com.obric.memorydata.plugin"), r21, false, false, r22);
        }

        public ScanRequest(ConcurrentWifiScanner r3, int r4, long r5, long r7, AttributedScanCallback r9, boolean r10, boolean r11, boolean r12, WifiScanAttribution r13) {
            AttributedScanCallback r14 = (AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r9, AttributedScanCallback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.id = r4;
            this.intervalMs = r5;
            this.durationMs = r7;
            this.callback = r14;
            if (r13 != null) goto L6;
            r13 = WifiScanAttributionFactory.invalid();
        L6:
            this.attribution = r13;
            this.ignoreMovementGate = r10;
            this.ignoreScanBudget = r11;
            this.firstAttemptGateState = createInitialFirstAttemptGateState(r10, r12);
            this.startTimeMs = SystemClock.elapsedRealtime();
            this.scanRunnable = new $$Lambda$ConcurrentWifiScanner$ScanRequest$v0C3U_05oi6qT8MADPJMPdGTRYM(this);
        }

        public ScanRequest(ConcurrentWifiScanner r12, int r13, long r14, long r16, ScanCallback r18, boolean r19) {
            this(r12, r13, r14, r16, ConcurrentWifiScanner.access$000((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r18, ScanCallback.class, "com.obric.memorydata.plugin")), r19, WifiScanAttributionFactory.invalid());
        }

        public ScanRequest(ConcurrentWifiScanner r14, int r15, long r16, long r18, ScanCallback r20, boolean r21, boolean r22) {
            this(r14, r15, r16, r18, ConcurrentWifiScanner.access$000((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r20, ScanCallback.class, "com.obric.memorydata.plugin")), r21, r22, false, WifiScanAttributionFactory.invalid());
        }

        public ScanRequest(ConcurrentWifiScanner r14, int r15, long r16, long r18, ScanCallback r20, boolean r21, boolean r22, boolean r23) {
            this(r14, r15, r16, r18, ConcurrentWifiScanner.access$000((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r20, ScanCallback.class, "com.obric.memorydata.plugin")), r21, r22, r23, WifiScanAttributionFactory.invalid());
        }

        private FirstAttemptGateState createInitialFirstAttemptGateState(boolean r1, boolean r2) {
            if (r1 == true) goto L8;
            if (r2 == false) goto L8;
            return FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE;
        L8:
            return FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_NO_TOKEN;
        }

        private void failureScanScheduleNext(long r5) {
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) <= this.durationMs) goto L6;
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$300(this.this$0, this.id);
            return;
        L6:
            ConcurrentWifiScanner.access$100(this.this$0).postDelayed(this.scanRunnable, r5);
        }

        private List<Integer> findMissedFrequencies(List<ScanResult> r8, List<ScanResult> r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            long r2 = SystemClock.elapsedRealtime() - ConcurrentWifiScanner.access$700(this.this$0);
            if (r2 <= 5000) goto L6;
            a.c(ConcurrentWifiScanner.TAG, "Skip rescan: last scan was " + r2 + "ms ago");
            return Collections.emptyList();
        L6:
            HashSet r7 = new HashSet();
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r7.add(((ScanResult) ZeusTransformUtils.preCheckCast(r12.next(), ScanResult.class, "com.obric.memorydata.plugin")).BSSID);
            goto L8
        L10:
            HashSet r13 = new HashSet();
            Iterator r14 = r10.iterator();
        L12:
            if (r14.hasNext() == false) goto L21;
            ScanResult r4 = (ScanResult) ZeusTransformUtils.preCheckCast(r14.next(), ScanResult.class, "com.obric.memorydata.plugin");
            if (r7.contains(r4.BSSID) == true) goto L12;
            if (r4.level <= (-80)) goto L12;
            if (TextUtils.isEmpty(r4.SSID) == true) goto L12;
            a.c(ConcurrentWifiScanner.TAG, "missed AP: " + r4.SSID + " " + r4.BSSID + " freq=" + r4.frequency + " rssi=" + r4.level + " timeSinceLastScan=" + r2 + "ms");
            r13.add(Integer.valueOf(r4.frequency));
            goto L12
        L21:
            return new ArrayList(r13);
        }

        private CommSenseScanTuningConfig getCurrentScanTuningConfig() {
            return CommSenseScanTuningConfig.getCurrent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), isWifiConnected());
        }

        private CommSenseScanTuningConfig getCurrentScanTuningConfig(WifiScanAttribution r1, boolean r2) {
            if (r1 != null) goto L4;
            return null;
        L4:
            if (r1.isHomeCompanyAware() == true) goto L7;
            return null;
        L7:
            return getCurrentScanTuningConfig(r2);
        }

        private CommSenseScanTuningConfig getCurrentScanTuningConfig(boolean r3) {
            return CommSenseScanTuningConfig.getCurrent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3);
        }

        private boolean isWifiConnected() {
            if (ConcurrentWifiScanner.access$1100(this.this$0) != null) goto L5;
        L7:
            return false;
        L5:
            if (ConcurrentWifiScanner.access$1100(this.this$0).getWifiConnectionState() != 1) goto L7;
            return true;
        }

        public static /* synthetic */ void lambda$v0C3U_05oi6qT8MADPJMPdGTRYM(ScanRequest r0) {
            r0.runScanCycle();
        }

        private void markFirstAttemptStarted() {
            FirstAttemptGateState r0 = this.firstAttemptGateState;
            FirstAttemptGateState r1 = FirstAttemptGateState.AFTER_FIRST_ATTEMPT;
            if (r0 == r1) goto L6;
            this.firstAttemptGateState = r1;
            return;
        }

        private List<ScanResult> mergeResults(List<ScanResult> r4, List<ScanResult> r5) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            LinkedHashMap r7 = new LinkedHashMap();
            Iterator r8 = r3.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            ScanResult r1 = (ScanResult) ZeusTransformUtils.preCheckCast(r8.next(), ScanResult.class, "com.obric.memorydata.plugin");
            r7.put(r1.BSSID, r1);
            goto L4
        L6:
            Iterator r9 = r6.iterator();
        L8:
            if (r9.hasNext() == false) goto L11;
            ScanResult r10 = (ScanResult) ZeusTransformUtils.preCheckCast(r9.next(), ScanResult.class, "com.obric.memorydata.plugin");
            r7.put(r10.BSSID, r10);
            goto L8
        L11:
            return new ArrayList(r7.values());
        }

        private void runScanCycle() {
            a.e(ConcurrentWifiScanner.TAG, "runScanCycle: id=" + this.id + " mScanSessionId.get()=" + ConcurrentWifiScanner.access$200(this.this$0).get());
            if (this.id == ConcurrentWifiScanner.access$200(this.this$0).get()) goto L6;
            return;
        L6:
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) <= this.durationMs) goto L10;
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$300(this.this$0, this.id);
            return;
        L10:
            if (ConcurrentWifiScanner.access$400(this.this$0) == false) goto L12;
        L23:
            boolean r0 = false;
        L24:
            if (r0 == false) goto L26;
        L28:
            markFirstAttemptStarted();
            final int r5 = this.id;
            final AttributedScanCallback r10 = this.callback;
            if (this.attribution == null) goto L31;
            WifiScanAttribution r1 = this.attribution;
        L32:
            final WifiScanAttribution r11 = r1;
            if (this.ignoreScanBudget == false) goto L35;
        L52:
            a.c(ConcurrentWifiScanner.TAG, "Start full scan...");
            final long r6 = SystemClock.elapsedRealtime();
            final boolean r8 = isWifiConnected();
            final CommSenseScanTuningConfig r2 = getCurrentScanTuningConfig(r11, r8);
            ConcurrentWifiScanner.access$702(this.this$0, r6);
            startScanInternal(new $$Lambda$ConcurrentWifiScanner$ScanRequest$JSDsdHv2XHYxLkTGR8QKVBja15Y(this, r5, r6, r8, r2, r10, r11), r2);
            return;
        L35:
            if (UserAwareUtil.tryAcquireUserAwareWifiScanBudget((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L52;
            int r3 = UserAwareUtil.getUserAwareWifiScanDropCountToday((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            int r4 = UserAwareUtil.getUserAwareWifiScanDailyCap((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            int r7 = UserAwareUtil.getUserAwareWifiScanSuccessCountToday((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            StringBuilder r9 = e.a(b.a("UA wifi scan budget blocked, emit drop snapshot: cap=", r4, " successToday=", r7, " attemptsToday="), UserAwareUtil.getUserAwareWifiScanAttemptCountToday((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), " dropsToday=", r3, " trainingMode=").append(ConcurrentWifiScanner.access$400(this.this$0)).append(" scanType=");
            int r12 = 2;
            if (ConcurrentWifiScanner.access$400(this.this$0) == false) goto L39;
            int r13 = 2;
        L40:
            a.c(ConcurrentWifiScanner.TAG, r9.append(r13).toString());
            if (r11.shouldReportToWifiScanCount() == false) goto L49;
            WifiScanCount r14 = new WifiScanCount();
            r14.setTimeStamp(System.currentTimeMillis());
            r14.setSceneType(r11.getWifiScanCountSceneType());
            if (ConcurrentWifiScanner.access$400(this.this$0) == true) goto L46;
            r12 = 0;
        L46:
            r14.setScanType(r12);
            r14.setDateScanCount(0);
            r14.setDateScanDropCount(r3);
            CaeUserAwareReportBase r15 = CaeUserAwareReportFactory.getReportInstance();
            if (r15 == null) goto L50;
            r15.reportScanCount(r14);
        L50:
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$300(this.this$0, this.id);
            return;
        L49:
            a.c(ConcurrentWifiScanner.TAG, "Skip WifiScanCount budget snapshot for attribution=" + r11);
            goto L50
        L39:
            r13 = 0;
            goto L40
        L31:
            r1 = WifiScanAttributionFactory.invalid();
            goto L32
        L26:
            if (this.firstAttemptGateState != FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE) goto L28;
            a.c(ConcurrentWifiScanner.TAG, "Retire unused first-attempt bypass token after natural movement");
            goto L28
        L12:
            if (this.ignoreMovementGate == true) goto L23;
            ConcurrentWifiScanner.access$500(this.this$0).ensureStarted();
            if (ConcurrentWifiScanner.access$500(this.this$0).allowScanNow(3000) == true) goto L23;
            if (this.firstAttemptGateState != FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE) goto L18;
            r0 = true;
            a.c(ConcurrentWifiScanner.TAG, "Bypass movement gate once for current session");
            goto L24
        L18:
            a.c(ConcurrentWifiScanner.TAG, "Skip scan: no movement in last 3000ms, delta=" + ConcurrentWifiScanner.access$500(this.this$0).getLastStepDeltaMs() + "ms");
            if (this.intervalMs != 0) goto L21;
            failureScanScheduleNext(1000);
            return;
        L21:
            scheduleNext();
        }

        private void scheduleNext() {
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) <= this.durationMs) goto L7;
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$300(this.this$0, this.id);
            return;
        L7:
            if (this.intervalMs != 0) goto L9;
            ConcurrentWifiScanner.access$100(this.this$0).post(this.scanRunnable);
            return;
        L9:
            ConcurrentWifiScanner.access$100(this.this$0).postDelayed(this.scanRunnable, this.intervalMs);
        }

        private void startScanInternal(ScanCallback r3) {
            startScanInternal((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r3, ScanCallback.class, "com.obric.memorydata.plugin"), getCurrentScanTuningConfig());
        }

        private void startScanInternal(ScanCallback r10, CommSenseScanTuningConfig r11) {
            ScanCallback r3 = (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r10, ScanCallback.class, "com.obric.memorydata.plugin");
            CoalescedWifiScanExecutor r2 = CoalescedWifiScanExecutor.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ConcurrentWifiScanner.access$800(this.this$0));
            final WifiScanConfigProvider.ActiveConfigSnapshot r12 = ConcurrentWifiScanner.access$900(this.this$0).getActiveConfigSnapshot();
            r2.startScanInternal(r3, r11, new $$Lambda$ConcurrentWifiScanner$ScanRequest$W5OJ7K60dqbPPvWEa6Dy8SwAiIY(this, r12), new $$Lambda$ConcurrentWifiScanner$ScanRequest$jGY5pO1UP1ovNaI9hW8jmwqqlOc(this, r12), ConcurrentWifiScanner.access$1000(this.this$0, r12));
        }

        private void startScanInternal(List<Integer> r3, ScanCallback r4) {
            startScanInternal((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r4, ScanCallback.class, "com.obric.memorydata.plugin"), null);
        }

        private void startScanInternal(List<Integer> r11, ScanCallback r12, CommSenseScanTuningConfig r13) {
            List<Integer> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            ScanCallback r4 = (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r12, ScanCallback.class, "com.obric.memorydata.plugin");
            CoalescedWifiScanExecutor r2 = CoalescedWifiScanExecutor.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ConcurrentWifiScanner.access$800(this.this$0));
            final WifiScanConfigProvider.ActiveConfigSnapshot r14 = ConcurrentWifiScanner.access$900(this.this$0).getActiveConfigSnapshot();
            r2.startScanChannels(r3, r4, r13, new $$Lambda$ConcurrentWifiScanner$ScanRequest$jNS1IuS04XDnczm2bYknNL9A3Ts(this, r14), new $$Lambda$ConcurrentWifiScanner$ScanRequest$WyMPR0dUv7zcJ7M3Ku1ZcNEoEjc(this, r14), ConcurrentWifiScanner.access$1000(this.this$0, r14));
        }

        public void cancel() {
            a.c(ConcurrentWifiScanner.TAG, "ScanRequest cancel: id=" + this.id);
            this.durationMs = 0;
            ConcurrentWifiScanner.access$100(this.this$0).removeCallbacks(this.scanRunnable);
        }

        public WifiScanAttribution getAttribution() {
            return this.attribution;
        }

        public int getId() {
            return this.id;
        }

        public boolean isActive() {
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) > this.durationMs) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ void lambda$runScanCycle$0$ConcurrentWifiScanner$ScanRequest(int r3, List r4, int r5, AttributedScanCallback r6, WifiScanAttribution r7, List r8) {
            List<ScanResult> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            AttributedScanCallback r10 = (AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r6, AttributedScanCallback.class, "com.obric.memorydata.plugin");
            List<ScanResult> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            if (ConcurrentWifiScanner.access$1400(this.this$0, r3) == true) goto L6;
            a.c(ConcurrentWifiScanner.TAG, d.a("Drop stale rescan results: attemptId=", r3, " currentId=").append(ConcurrentWifiScanner.access$200(this.this$0).get()).toString());
            return;
        L6:
            List<ScanResult> r12 = mergeResults(r9, r11);
            a.c(ConcurrentWifiScanner.TAG, "Combined results: " + r12.size() + " missed freqs scan results: " + r11.size() + " total scan count: " + r5);
            if (r10 == null) goto L9;
            r10.onScanResults(r12, r7);
        L9:
            ConcurrentWifiScanner.access$1502(this.this$0, r12);
            scheduleNext();
        }

        public /* synthetic */ void lambda$runScanCycle$1$ConcurrentWifiScanner$ScanRequest(final int r16, long r17, boolean r19, CommSenseScanTuningConfig r20, AttributedScanCallback r21, final WifiScanAttribution r22, List r23) {
            final AttributedScanCallback r5 = (AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r21, AttributedScanCallback.class, "com.obric.memorydata.plugin");
            final List<ScanResult> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
            if (ConcurrentWifiScanner.access$1400(this.this$0, r16) == true) goto L6;
            a.c(ConcurrentWifiScanner.TAG, d.a("Drop stale scan results: attemptId=", r16, " currentId=").append(ConcurrentWifiScanner.access$200(this.this$0).get()).toString());
            return;
        L6:
            long r8 = SystemClock.elapsedRealtime() - r17;
            List<Integer> r0 = Collections.emptyList();
            if (ConcurrentWifiScanner.access$400(this.this$0) == true) goto L9;
            r0 = findMissedFrequencies(ConcurrentWifiScanner.access$1500(this.this$0), r3);
        L9:
            List<Integer> r14 = r0;
            CommSenseScanTuningReporter.reportScanTuningResult(r8, r3, r19, r20, r14.size());
            final int r6 = ConcurrentWifiScanner.access$1600(this.this$0).incrementAndGet();
            if (ConcurrentWifiScanner.access$400(this.this$0) == true) goto L15;
            UserAwareUtil.onUserAwareWifiScanSuccess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ConcurrentWifiScanner.access$600(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            if (r14.isEmpty() == true) goto L15;
            a.c(ConcurrentWifiScanner.TAG, "Rescanning missed freqs: " + r14);
            startScanInternal(r14, new $$Lambda$ConcurrentWifiScanner$ScanRequest$wzbxykcQT2TlKZ5l37LKW4kxbwI(this, r16, r3, r6, r5, r22));
            return;
        L15:
            ConcurrentWifiScanner.access$1502(this.this$0, r3);
            a.c(ConcurrentWifiScanner.TAG, "Full scan results: " + r3.size() + " total scan count: " + r6);
            if (r5 == null) goto L18;
            r5.onScanResults(r3, r22);
        L18:
            scheduleNext();
        }

        public /* synthetic */ void lambda$startScanInternal$2$ConcurrentWifiScanner$ScanRequest(WifiScanConfigProvider.ActiveConfigSnapshot r3) {
            failureScanScheduleNext(ConcurrentWifiScanner.access$1300(this.this$0, r3));
        }

        public /* synthetic */ void lambda$startScanInternal$3$ConcurrentWifiScanner$ScanRequest(WifiScanConfigProvider.ActiveConfigSnapshot r3) {
            failureScanScheduleNext(ConcurrentWifiScanner.access$1200(this.this$0, r3));
        }

        public /* synthetic */ void lambda$startScanInternal$4$ConcurrentWifiScanner$ScanRequest(WifiScanConfigProvider.ActiveConfigSnapshot r3) {
            failureScanScheduleNext(ConcurrentWifiScanner.access$1300(this.this$0, r3));
        }

        public /* synthetic */ void lambda$startScanInternal$5$ConcurrentWifiScanner$ScanRequest(WifiScanConfigProvider.ActiveConfigSnapshot r3) {
            failureScanScheduleNext(ConcurrentWifiScanner.access$1200(this.this$0, r3));
        }

        public void reconfigure(int r3, long r4, long r6, AttributedScanCallback r8, boolean r9, WifiScanAttribution r10) {
            AttributedScanCallback r11 = (AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r8, AttributedScanCallback.class, "com.obric.memorydata.plugin");
            StringBuilder r0 = new StringBuilder("ScanRequest reconfigure: id=").append(r3).append(" interval=").append(r4).append("ms duration=").append(r6).append("ms callback=");
            if (r11 == null) goto L5;
            boolean r1 = true;
        L6:
            a.c(ConcurrentWifiScanner.TAG, r0.append(r1).toString());
            this.id = r3;
            this.intervalMs = r4;
            this.durationMs = r6;
            if (r11 == null) goto L9;
            this.callback = r11;
        L9:
            if (r10 != null) goto L12;
            r10 = WifiScanAttributionFactory.invalid();
        L12:
            this.attribution = r10;
            this.ignoreMovementGate = r9;
            this.startTimeMs = SystemClock.elapsedRealtime();
            this.this$0.acquireWakeLock(r6 + ConcurrentWifiScanner.SCAN_WAKELOCK_BUFFER_MS);
            ConcurrentWifiScanner.access$100(this.this$0).removeCallbacks(this.scanRunnable);
            if (this.intervalMs != 0) goto L15;
            ConcurrentWifiScanner.access$100(this.this$0).post(this.scanRunnable);
            return;
        L15:
            ConcurrentWifiScanner.access$100(this.this$0).postDelayed(this.scanRunnable, this.intervalMs);
            return;
        L5:
            r1 = false;
            goto L6
        }

        public void start() {
            ConcurrentWifiScanner.access$100(this.this$0).post(this.scanRunnable);
        }
    }

    public class WifiStateReceiver extends PluginBroadcastReceiver {
        final /* synthetic */ ConcurrentWifiScanner this$0;

        public WifiStateReceiver(ConcurrentWifiScanner r1) {
            this.this$0 = r1;
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r4.getAction()) == false) goto L17;
            int r6 = r4.getIntExtra("wifi_state", 4);
            if (r6 != 1) goto L14;
            a.c(ConcurrentWifiScanner.TAG, "Wifi disabled, stop scan");
            ConcurrentWifiScanner.access$1702(this.this$0, false);
            if (ConcurrentWifiScanner.access$400(this.this$0) == false) goto L9;
            return;
        L9:
            if (ConcurrentWifiScanner.access$1800(this.this$0) != null) goto L11;
            return;
        L11:
            if (ConcurrentWifiScanner.access$1900(this.this$0) == true) goto L20;
            ConcurrentWifiScanner.access$2000(this.this$0);
            return;
        L20:
            return;
        L14:
            if (r6 != 3) goto L22;
            ConcurrentWifiScanner.access$1702(this.this$0, true);
            return;
        L22:
            return;
        }
    }

    public ConcurrentWifiScanner(Context r7, WifiAwareInfoManager r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.mLock = new Object();
        this.mLastScanResults = new ArrayList();
        this.mCurrentRequest = null;
        this.mScanSessionId = new AtomicInteger(0);
        this.mWakeLock = null;
        this.mLastScanTimestampMs = 0;
        this.mTotalScanCount = new AtomicInteger(0);
        this.mTrainingMode = false;
        this.mWakeLockLock = new Object();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r0, "com.obric.memorydata.plugin");
        this.mWifiAwareInfoManager = r8;
        WifiManager r10 = (WifiManager) ZeusTransformUtils.preCheckCast(r9.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        this.mWifiManager = r10;
        this.mWifiScanner = (WifiScanner) ZeusTransformUtils.preCheckCast(r9.getSystemService(WIFI_SCANNING_SERVICE), WifiScanner.class, "com.obric.memorydata.plugin");
        HandlerThread r11 = new HandlerThread("WifiScanHandler");
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new Handler(r11.getLooper());
        this.mIsWifiEnabled = r10.isWifiEnabled();
        if (this.mWifiReceiver != null) goto L5;
        this.mWifiReceiver = new WifiStateReceiver(this);
        IntentFilter r12 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        ZeusTransformUtils.registerReceiver(r0, this.mWifiReceiver, r12, "com.obric.memorydata.plugin");
    L5:
        this.mStepMovementGate = new StepMovementGate(r0);
    }

    public static /* synthetic */ AttributedScanCallback access$000(ScanCallback r2) {
        return wrapCallback((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r2, ScanCallback.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Handler access$100(ConcurrentWifiScanner r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ long access$1000(ConcurrentWifiScanner r0, WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        return r0.liveScanTimeoutMs(r1);
    }

    public static /* synthetic */ WifiAwareInfoManager access$1100(ConcurrentWifiScanner r0) {
        return r0.mWifiAwareInfoManager;
    }

    public static /* synthetic */ long access$1200(ConcurrentWifiScanner r0, WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        return r0.liveRetryNoSuchDeviceBackoffMs(r1);
    }

    public static /* synthetic */ long access$1300(ConcurrentWifiScanner r0, WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        return r0.liveRetryBackoffMs(r1);
    }

    public static /* synthetic */ boolean access$1400(ConcurrentWifiScanner r0, int r1) {
        return r0.isCurrentScanAttempt(r1);
    }

    public static /* synthetic */ List access$1500(ConcurrentWifiScanner r0) {
        return r0.mLastScanResults;
    }

    public static /* synthetic */ List access$1502(ConcurrentWifiScanner r2, List r3) {
        List<ScanResult> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.mLastScanResults = r4;
        return r4;
    }

    public static /* synthetic */ AtomicInteger access$1600(ConcurrentWifiScanner r0) {
        return r0.mTotalScanCount;
    }

    public static /* synthetic */ boolean access$1702(ConcurrentWifiScanner r0, boolean r1) {
        r0.mIsWifiEnabled = r1;
        return r1;
    }

    public static /* synthetic */ ScanRequest access$1800(ConcurrentWifiScanner r0) {
        return r0.mCurrentRequest;
    }

    public static /* synthetic */ boolean access$1900(ConcurrentWifiScanner r0) {
        return r0.isScanAvailable();
    }

    public static /* synthetic */ AtomicInteger access$200(ConcurrentWifiScanner r0) {
        return r0.mScanSessionId;
    }

    public static /* synthetic */ void access$2000(ConcurrentWifiScanner r0) {
        r0.stopScanInternal();
    }

    public static /* synthetic */ void access$300(ConcurrentWifiScanner r0, int r1) {
        r0.onSessionFinished(r1);
    }

    public static /* synthetic */ boolean access$400(ConcurrentWifiScanner r0) {
        return r0.mTrainingMode;
    }

    public static /* synthetic */ StepMovementGate access$500(ConcurrentWifiScanner r0) {
        return r0.mStepMovementGate;
    }

    public static /* synthetic */ Context access$600(ConcurrentWifiScanner r0) {
        return r0.mContext;
    }

    public static /* synthetic */ long access$700(ConcurrentWifiScanner r2) {
        return r2.mLastScanTimestampMs;
    }

    public static /* synthetic */ long access$702(ConcurrentWifiScanner r0, long r1) {
        r0.mLastScanTimestampMs = r1;
        return r1;
    }

    public static /* synthetic */ WifiScanner access$800(ConcurrentWifiScanner r0) {
        return r0.mWifiScanner;
    }

    public static /* synthetic */ WifiScanConfigProvider access$900(ConcurrentWifiScanner r0) {
        return r0.getScanConfigProvider();
    }

    private static Object createWifiSsid(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return null;
    L16:
        Class r0 = ZeusTransformUtils.forName("android.net.wifi.WifiSsid", "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Method r4 = r0.getDeclaredMethod("createFromAsciiEncoded", new Class[]{String.class});     // Catch: Throwable -> L9
        r4.setAccessible(true);     // Catch: Throwable -> L9
        return r4.invoke(null, new Object[]{r7});
    L9:
        Method r5 = r0.getDeclaredMethod("fromString", new Class[]{String.class});     // Catch: Throwable -> L11
        r5.setAccessible(true);     // Catch: Throwable -> L11
        return r5.invoke(null, new Object[]{r7});
    L11:
        Method r1 = r0.getDeclaredMethod("createFromByteArray", new Class[]{byte[].class});     // Catch: Throwable -> L13
        r1.setAccessible(true);     // Catch: Throwable -> L13
        return r1.invoke(null, new Object[]{r7.getBytes()});
    L13:
        return null;
    }

    private static String encodeSsidForPno(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        if (r2.length() < 2) goto L14;
        if (r2.charAt(0) != '\"') goto L14;
        if (r2.charAt(r2.length() - 1) != '\"') goto L14;
        return r2;
    L14:
        return "\"" + r2 + "\"";
    }

    private static Field findSsidField(Class<?> r8) {
        String[] r1 = {Api.KEY_SSID, "mSsid", "SSID", "mSSID"};
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 4) goto L39;
        String r4 = r1[r3];
        Field r5 = r8.getField(r4);     // Catch: Throwable -> L32
        if (r5 == null) goto L35;
        if (r5.getType() != String.class) goto L35;
        return r5;
    L35:
        Field r6 = r8.getDeclaredField(r4);     // Catch: Throwable -> L33
        if (r6 == null) goto L16;
        if (r6.getType() != String.class) goto L16;
        return r6;
    L16:
        r3 = r3 + 1;
        goto L4
    L39:
        Field[] r9 = r8.getDeclaredFields();     // Catch: Throwable -> L34
        int r7 = r9.length;     // Catch: Throwable -> L34
    L18:
        if (r2 >= r7) goto L51;
        Field r10 = r9[r2];     // Catch: Throwable -> L34
        if (r10 == null) goto L29;
        if (r10.getType() != String.class) goto L29;
        String r11 = r10.getName();     // Catch: Throwable -> L34
        if (r11 == null) goto L29;
        if (r11.toLowerCase(Locale.ROOT).contains(Api.KEY_SSID) == false) goto L29;
        return r10;
    L29:
        r2 = r2 + 1;
        goto L18
    L51:
        return null;
    L30:
        return null;
    }

    private WifiScanConfigProvider getScanConfigProvider() {
        WifiScanConfigProvider r0 = this.mScanConfigProvider;
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = this.mScanConfigProvider;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = WifiScanConfigProvider.getInstance(this.mContext);     // Catch: Throwable -> L10
        this.mScanConfigProvider = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    private boolean isCurrentScanAttempt(int r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ScanRequest r1 = this.mCurrentRequest;     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r1.getId() != r3) goto L11;
        if (this.mScanSessionId.get() != r3) goto L11;
        r2 = true;
    L14:
        th = move-exception;
        throw th;
    }

    private boolean isScanAvailable() {
        WifiManager r0 = this.mWifiManager;     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsWifiEnabled == true) goto L8;
        if (r0.isScanAlwaysAvailable() == false) goto L9;
    L8:
        return true;
    L12:
        return this.mIsWifiEnabled;
    }

    static /* synthetic */ void lambda$wrapCallback$0(ScanCallback r1, List r2, WifiScanAttribution r3) {
        ((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r1, ScanCallback.class, "com.obric.memorydata.plugin")).onScanResults((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private long liveRetryBackoffMs(WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        return r1.getScanRetryBackoffMs();
    L4:
        return 1000;
    }

    private long liveRetryNoSuchDeviceBackoffMs(WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        return r1.getScanRetryNoSuchDeviceBackoffMs();
    L4:
        return 3000;
    }

    private long liveScanTimeoutMs(WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        return r1.getScanTimeoutMs();
    L4:
        return SCAN_TIMEOUT_MS;
    }

    private void onSessionFinished(int r5) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        ScanRequest r2 = this.mCurrentRequest;     // Catch: Throwable -> L11
        if (r2 != null) goto L7;
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        if (r2.getId() != r5) goto L9;
        a.c(TAG, "Scan session finished: id=" + r5 + ", clear mCurrentRequest");     // Catch: Throwable -> L11
        this.mCurrentRequest = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void startDisconnectedPnoScanWithList(List<WifiScanner.PnoSettings.PnoNetwork> r9, WifiScanner.PnoScanListener r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        WifiScanner.PnoScanListener r12 = (WifiScanner.PnoScanListener) ZeusTransformUtils.wrapperContextForParams(r10, WifiScanner.PnoScanListener.class, "com.obric.memorydata.plugin");
        if (this.mWifiScanner != null) goto L6;
        a.i(TAG, "mWifiScanner is null, cannot start PNO scan");
        return;
    L6:
        if (r11 != null) goto L8;
    L35:
        a.e(TAG, "PNO network list is empty, skip start");
        return;
    L8:
        if (r11.isEmpty() == true) goto L35;
        WifiScanner.PnoSettings r0 = null;
        Constructor r5 = ZeusTransformUtils.forName("android.net.wifi.WifiScanner$PnoSettings", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L13
        r5.setAccessible(true);     // Catch: Exception -> L13
        r0 = (WifiScanner.PnoSettings) ZeusTransformUtils.preCheckCast(r5.newInstance(new Object[0]), WifiScanner.PnoSettings.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
    L15:
        if (r0 != null) goto L17;
        return;
    L17:
        WifiScanConfigProvider.ActiveConfigSnapshot r6 = getScanConfigProvider().getActiveConfigSnapshot();
        WifiScanner.PnoSettings.PnoNetwork[] r7 = new WifiScanner.PnoSettings.PnoNetwork[r11.size()];     // Catch: Exception -> L32
        r0.networkList = r7;     // Catch: Exception -> L32
        r0.networkList = (WifiScanner.PnoSettings.PnoNetwork[]) ZeusTransformUtils.preCheckCast(r11.toArray(r7), WifiScanner.PnoSettings.PnoNetwork[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L32
        r0.min5GHzRssi = PNO_MIN_5GHZ_RSSI_DBM;     // Catch: Exception -> L32
        r0.min24GHzRssi = -80;     // Catch: Exception -> L32
        r0.min6GHzRssi = -80;     // Catch: NoSuchFieldError -> L37 Exception -> L32
    L20:
        r0.isConnected = false;     // Catch: Exception -> L32
        Class<?> r1 = r0.getClass();     // Catch: Exception -> L32
        r1.getField("scanIterations").setInt(r0, r6.getPnoScanIterations());     // Catch: Exception -> L38
    L48:
        r1.getField("scanIntervalMultiplier").setInt(r0, 1);     // Catch: Exception -> L39
    L23:
        WifiScanner.ScanSettings r2 = new WifiScanner.ScanSettings();
        r2.band = 7;
        r2.reportEvents = 4;
        r2.numBssidsPerScan = 0;
        r2.periodInMs = r6.getPnoScanIntervalMs();
        Executor r3 = this.mContext.getMainExecutor();
        a.e(TAG, "Calling startDisconnectedPnoScan with listener=" + r12 + ", networkListSize=" + r11.size() + ", periodMs=" + r2.periodInMs + ", iterations=" + r6.getPnoScanIterations());
        this.mWifiScanner.startDisconnectedPnoScan(r2, r0, r3, r12);     // Catch: Exception -> L26 SecurityException -> L28
    L52:
        return;
    L28:
        e = e;
        String r13 = "SecurityException: Permission denied. Check ACCESS_FINE_LOCATION.";
    L30:
        a.a(TAG, r13, e);
        return;
    L26:
        e = e;
        r13 = "Failed to call startDisconnectedPnoScan";
    L32:
        e = move-exception;
        a.a(TAG, "Error setting PnoSettings fields", e);
        return;
    L13:
        e = move-exception;
        a.a(TAG, "FATAL: Failed to create PnoSettings via reflection", e);
        goto L15
    }

    private RequestHandle startScan(long r19, long r21, AttributedScanCallback r23, boolean r24, boolean r25, WifiScanAttribution r26) {
        AttributedScanCallback r8 = (AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r23, AttributedScanCallback.class, "com.obric.memorydata.plugin");
        WifiAwareInfoManager r1 = this.mWifiAwareInfoManager;
        if (r1.mHasFirstEnterFence == true) goto L5;
    L31:
        a.e(TAG, "Reject scan request: hasFirstEnterFence=" + this.mWifiAwareInfoManager.mHasFirstEnterFence + ", functionEnabled=" + this.mWifiAwareInfoManager.mFunctionEnabled + ", interval=" + r19 + "ms, duration=" + r21 + "ms, attribution=" + r26);
        return null;
    L5:
        if (r1.mFunctionEnabled == false) goto L31;
        if (isScanAvailable() == true) goto L11;
        a.g(TAG, "Scan not available: Wi-Fi disabled and always scan off");
        return null;
    L11:
        Object r15 = this.mLock;
        monitor-enter(r15);
    L28:
        th = move-exception;
        throw th;
    L14:
        if (this.mTrainingMode == false) goto L18;
        a.g(TAG, "TrainingMode active, ignoring scan request");     // Catch: Throwable -> L28
        monitor-exit(r15);     // Catch: Throwable -> L28
        return null;
    L18:
        ScanRequest r2 = this.mCurrentRequest;     // Catch: Throwable -> L28
        if (r2 != null) goto L21;
    L25:
        int r12 = this.mScanSessionId.incrementAndGet();     // Catch: Throwable -> L28
        ScanRequest r11 = new ScanRequest(this, r12, r19, r21, r8, r24, false, r25, r26);     // Catch: Throwable -> L28
        this.mCurrentRequest = r11;     // Catch: Throwable -> L28
        acquireWakeLock(SCAN_WAKELOCK_BUFFER_MS + r21);     // Catch: Throwable -> L28
        r11.start();     // Catch: Throwable -> L28
        RequestHandle r0 = new RequestHandle(r12, r11.getAttribution());     // Catch: Throwable -> L28
        monitor-exit(r15);     // Catch: Throwable -> L28
        return r0;
    L21:
        if (r2.isActive() == false) goto L25;
        this.mCurrentRequest.reconfigure(this.mScanSessionId.incrementAndGet(), r19, r21, r8, r24, r26);     // Catch: Throwable -> L28
        RequestHandle r3 = new RequestHandle(this.mCurrentRequest.getId(), this.mCurrentRequest.getAttribution());     // Catch: Throwable -> L28
        monitor-exit(r15);     // Catch: Throwable -> L28
        return r3;
    }

    private void stopScanInternal() {
        if (this.mCurrentRequest == null) goto L6;
        this.mScanSessionId.incrementAndGet();
        this.mCurrentRequest.cancel();
        this.mCurrentRequest = null;
        releaseWakeLock();
        return;
    }

    private static AttributedScanCallback wrapCallback(ScanCallback r2) {
        final ScanCallback r3 = (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r2, ScanCallback.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new $$Lambda$ConcurrentWifiScanner$_98ChsH9yYq4HZhxUxorEQ6ugc(r3);
    }

    public void acquireWakeLock(long r7) {
        Object r2 = this.mWakeLockLock;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mWakeLock != null) goto L8;
        this.mWakeLock = ((PowerManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin")).newWakeLock(1, "Cae::WifiScanWakeLock");     // Catch: Throwable -> L16
    L8:
        if (this.mWakeLock.isHeld() == true) goto L21;
    L13:
        a.e(TAG, "acquireWakeLock timeout=" + r7);     // Catch: Throwable -> L16
        this.mWakeLock.acquire(r7);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return;
    L21:
        this.mWakeLock.release();     // Catch: RuntimeException -> L11 Throwable -> L16
    L11:
        e = move-exception;
        a.i(TAG, "WakeLock release failed: " + e.getMessage());     // Catch: Throwable -> L16
        goto L13
    }

    public boolean getTrainingMode() {
        return this.mTrainingMode;
    }

    public void releaseWakeLock() {
        Object r1 = this.mWakeLockLock;
        monitor-enter(r1);
        PowerManager.WakeLock r2 = this.mWakeLock;     // Catch: Throwable -> L15
        if (r2 != null) goto L7;
    L12:
        a.g(TAG, "releaseWakeLock skipped: already released or not held");     // Catch: Throwable -> L15
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L7:
        if (r2.isHeld() == false) goto L12;
        this.mWakeLock.release();     // Catch: RuntimeException -> L10 Throwable -> L15
        a.e(TAG, "WakeLock released");     // Catch: RuntimeException -> L10 Throwable -> L15
    L10:
        e = move-exception;
        a.i(TAG, "WakeLock release failed: " + e.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public List<WifiScanner.PnoSettings.PnoNetwork> retrievePnoNetworkList(Set<Map<String, Integer>> r15) {
        Set r16 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L104;
        if (r16.isEmpty() == true) goto L104;
        Class r0 = ZeusTransformUtils.forName("android.net.wifi.WifiScanner$PnoSettings$PnoNetwork", "com.obric.memorydata.plugin");     // Catch: Exception -> L100
        Constructor r2 = null;
        Constructor r5 = r0.getDeclaredConstructor(new Class[]{String.class});     // Catch: Throwable -> L12
        r5.setAccessible(true);     // Catch: Throwable -> L105
    L112:
        Constructor r6 = r0.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L16
        r6.setAccessible(true);     // Catch: Throwable -> L106
    L116:
        r2 = r0.getDeclaredConstructor(new Class[]{ZeusTransformUtils.forName("android.net.wifi.WifiSsid", "com.obric.memorydata.plugin")});     // Catch: Throwable -> L107
        r2.setAccessible(true);     // Catch: Throwable -> L107
    L18:
        Field r1 = findSsidField(r0);     // Catch: Exception -> L100
        if (r5 != null) goto L24;
        if (r6 != null) goto L24;
        if (r2 != null) goto L24;
        a.i(TAG, "FATAL: No usable PnoNetwork constructor found by reflection");
        return Collections.emptyList();
    L24:
        HashMap r7 = new HashMap();
        HashMap r8 = new HashMap();
        Iterator r17 = r16.iterator();
    L26:
        if (r17.hasNext() == false) goto L66;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r17.next(), Map.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L26;
        if (r9.isEmpty() == true) goto L26;
        Iterator r10 = r9.entrySet().iterator();
    L34:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin");
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(r11.getValue(), Integer.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r12) == true) goto L34;
        if (r13 == null) goto L34;
        if (r13.intValue() <= 0) goto L34;
        if (((WifiScanner.PnoSettings.PnoNetwork) ZeusTransformUtils.preCheckCast(r7.get(r12), WifiScanner.PnoSettings.PnoNetwork.class, "com.obric.memorydata.plugin")) != null) goto L62;
        String r14 = encodeSsidForPno(r12);
        if (r14 == null) goto L34;
        if (r5 == null) goto L50;
        Object r18 = r5.newInstance(new Object[]{r14});     // Catch: Exception -> L48
    L59:
        r7.put(r12, (WifiScanner.PnoSettings.PnoNetwork) ZeusTransformUtils.preCheckCast(r18, WifiScanner.PnoSettings.PnoNetwork.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L48
    L48:
        e = move-exception;
        a.a(TAG, "Failed to instantiate PnoNetwork", e);
        goto L34
    L50:
        if (r2 != null) goto L51;
        Object r19 = r6.newInstance(new Object[0]);     // Catch: Exception -> L48
        if (r1 != null) goto L58;
        a.i(TAG, "No ssid field found for PnoNetwork, skip current network");     // Catch: Exception -> L48
        goto L34
    L58:
        r1.setAccessible(true);     // Catch: Exception -> L48
        r1.set(r19, r14);     // Catch: Exception -> L48
        r18 = r19;
        goto L59
    L51:
        Object r110 = createWifiSsid(r12);     // Catch: Exception -> L48
        if (r110 == null) goto L53;
        r18 = r2.newInstance(new Object[]{r110});     // Catch: Exception -> L48
        goto L59
    L53:
        a.g(TAG, "createWifiSsid failed, skip current network");     // Catch: Exception -> L48
    L62:
        Set r111 = (Set) ZeusTransformUtils.preCheckCast(r8.get(r12), Set.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L65;
        r111 = new HashSet();
        r8.put(r12, r111);
    L65:
        r111.add(r13);
        goto L34
    L66:
        Iterator r112 = r7.entrySet().iterator();
    L68:
        if (r112.hasNext() == false) goto L99;
        Map.Entry r113 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        WifiScanner.PnoSettings.PnoNetwork r3 = (WifiScanner.PnoSettings.PnoNetwork) ZeusTransformUtils.preCheckCast(r113.getValue(), WifiScanner.PnoSettings.PnoNetwork.class, "com.obric.memorydata.plugin");
        Set r114 = (Set) ZeusTransformUtils.preCheckCast(r8.get(r113.getKey()), Set.class, "com.obric.memorydata.plugin");
        if (r114 == null) goto L97;
        if (r114.isEmpty() == true) goto L97;
        ArrayList r4 = new ArrayList(r114);
        Collections.sort(r4);
        int[] r115 = new int[r4.size()];
        int r20 = 0;
        boolean r21 = false;
        boolean r22 = false;
    L76:
        if (r20 >= r4.size()) goto L92;
        int r116 = ((Integer) ZeusTransformUtils.preCheckCast(r4.get(r20), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r115[r20] = r116;
        if (r116 < 2400) goto L83;
        if (r116 > 2500) goto L83;
        r21 = true;
    L91:
        r20 = r20 + 1;
    L83:
        if (r116 < 5000) goto L87;
        if (r116 > 6000) goto L87;
    L90:
        r22 = true;
    L87:
        if (r116 < 5925) goto L91;
        if (r116 > 7125) goto L91;
    L92:
        r3.frequencies = r115;
        if (r21 == false) goto L95;
        r3.flags = (byte) (r3.flags | 4);
    L95:
        if (r22 == false) goto L68;
        r3.flags = (byte) (r3.flags | 2);
    L97:
        r3.frequencies = new int[0];
        goto L68
    L99:
        return new ArrayList(r7.values());
    L16:
        r6 = null;
    L12:
        r5 = null;
    L100:
        e = move-exception;
        a.a(TAG, "FATAL: Failed to init PnoNetwork reflection", e);
        return Collections.emptyList();
    L104:
        return Collections.emptyList();
    }

    public List<WifiScanner.PnoSettings.PnoNetwork> retrieveSavedPnoNetworkList(int r2) {
        WifiAwareInfoManager r0 = this.mWifiAwareInfoManager;
        if (r0 != null) goto L7;
        a.g(TAG, "retrieveSavedPnoNetworkList: WifiAwareInfoManager is null");
        return Collections.emptyList();
    L7:
        return retrievePnoNetworkList(r0.getSavedPnoNetworkSetForFence(r2));
    }

    public void setTrainingMode(boolean r13, AttributedScanCallback r14, WifiScanAttribution r15) {
        AttributedScanCallback r7 = (AttributedScanCallback) ZeusTransformUtils.wrapperContextForParams(r14, AttributedScanCallback.class, "com.obric.memorydata.plugin");
        Object r16 = this.mLock;
        monitor-enter(r16);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrainingMode != r13) goto L8;
        monitor-exit(r16);     // Catch: Throwable -> L15
        return;
    L8:
        this.mTrainingMode = r13;     // Catch: Throwable -> L15
        if (r13 == false) goto L12;
        stopScanInternal();     // Catch: Throwable -> L15
        ScanRequest r17 = new ScanRequest(this, this.mScanSessionId.incrementAndGet(), 0, Long.MAX_VALUE, r7, false, true, false, r15);     // Catch: Throwable -> L15
        this.mCurrentRequest = r17;     // Catch: Throwable -> L15
        acquireWakeLock(Long.MAX_VALUE);     // Catch: Throwable -> L15
        r17.start();     // Catch: Throwable -> L15
        String r12 = TAG;
        String r18 = "TrainingMode enabled";
    L11:
        a.e(r12, r18);     // Catch: Throwable -> L15
        monitor-exit(r16);     // Catch: Throwable -> L15
        return;
    L12:
        stopScanInternal();     // Catch: Throwable -> L15
        r12 = TAG;
        r18 = "TrainingMode disabled";
        goto L11
    }

    public void setTrainingMode(boolean r3, ScanCallback r4) {
        setTrainingMode(r3, wrapCallback((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r4, ScanCallback.class, "com.obric.memorydata.plugin")), WifiScanAttributionFactory.invalid());
    }

    public void startPnoScanWithSavedNetworks(int r3, WifiScanner.PnoScanListener r4) {
        WifiScanner.PnoScanListener r5 = (WifiScanner.PnoScanListener) ZeusTransformUtils.wrapperContextForParams(r4, WifiScanner.PnoScanListener.class, "com.obric.memorydata.plugin");
        a.e(TAG, "startPnoScanWithSavedNetworks fenceState=" + r3);
        startDisconnectedPnoScanWithList(retrieveSavedPnoNetworkList(r3), r5);
    }

    public RequestHandle startPrioritySingleScan(long r7, long r9, ScanCallback r11) {
        ScanCallback r12 = (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r11, ScanCallback.class, "com.obric.memorydata.plugin");
        return startPrioritySingleScan(WifiScanRequestSpec.prioritySingle(WifiScanAttributionFactory.invalid(), r7, r9, wrapCallback(r12)));
    }

    public RequestHandle startPrioritySingleScan(WifiScanRequestSpec r17) {
        if (r17 != null) goto L6;
        return null;
    L6:
        Object r13 = this.mLock;
        monitor-enter(r13);
        int r14 = this.mScanSessionId.incrementAndGet();     // Catch: Throwable -> L14
        if (this.mCurrentRequest == null) goto L11;
        a.c(TAG, "startPrioritySingleScan: cancel current request for priority scan");     // Catch: Throwable -> L14
        this.mCurrentRequest.cancel();     // Catch: Throwable -> L14
        releaseWakeLock();     // Catch: Throwable -> L14
    L11:
        ScanRequest r15 = new ScanRequest(this, r14, r17.getIntervalMs(), r17.getDurationMs(), r17.getCallback(), true, true, false, r17.getAttribution());     // Catch: Throwable -> L14
        this.mCurrentRequest = r15;     // Catch: Throwable -> L14
        acquireWakeLock(r17.getDurationMs() + SCAN_WAKELOCK_BUFFER_MS);     // Catch: Throwable -> L14
        r15.start();     // Catch: Throwable -> L14
        RequestHandle r0 = new RequestHandle(r14, r15.getAttribution());     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public RequestHandle startScan(long r8, long r10, ScanCallback r12) {
        return startScan(r8, r10, (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r12, ScanCallback.class, "com.obric.memorydata.plugin"), false);
    }

    public RequestHandle startScan(long r10, long r12, ScanCallback r14, boolean r15) {
        return startScan(r10, r12, wrapCallback((ScanCallback) ZeusTransformUtils.wrapperContextForParams(r14, ScanCallback.class, "com.obric.memorydata.plugin")), r15, !r15, WifiScanAttributionFactory.invalid());
    }

    public RequestHandle startScan(WifiScanRequestSpec r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isPrioritySingleScan() == false) goto L10;
        return startPrioritySingleScan(r10);
    L10:
        return startScan(r10.getIntervalMs(), r10.getDurationMs(), r10.getCallback(), r10.shouldIgnoreMovementGate(), r10.shouldAllowFirstScanWithoutMovement(), r10.getAttribution());
    }

    public void startSingleScan(long r16, long r18, ScanCallback r20) {
        ScanCallback r1 = (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r20, ScanCallback.class, "com.obric.memorydata.plugin");
        Object r13 = this.mLock;
        monitor-enter(r13);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrainingMode == false) goto L10;
        a.g(TAG, "TrainingMode active, ignoring scan request");     // Catch: Throwable -> L16
        monitor-exit(r13);     // Catch: Throwable -> L16
        return;
    L10:
        if (this.mCurrentRequest == null) goto L13;
        monitor-exit(r13);     // Catch: Throwable -> L16
        return;
    L13:
        ScanRequest r14 = new ScanRequest(this, this.mScanSessionId.incrementAndGet(), r16, r18, wrapCallback(r1), false, false, true, WifiScanAttributionFactory.invalid());     // Catch: Throwable -> L16
        this.mCurrentRequest = r14;     // Catch: Throwable -> L16
        acquireWakeLock(r18 + SCAN_WAKELOCK_BUFFER_MS);     // Catch: Throwable -> L16
        r14.start();     // Catch: Throwable -> L16
        monitor-exit(r13);     // Catch: Throwable -> L16
    }

    public void startTrainingScan(ScanCallback r3) {
        setTrainingMode(true, (ScanCallback) ZeusTransformUtils.wrapperContextForParams(r3, ScanCallback.class, "com.obric.memorydata.plugin"));
    }

    public void stopPnoScan(WifiScanner.ScanListener r9) {
        WifiScanner.ScanListener r10 = (WifiScanner.ScanListener) ZeusTransformUtils.wrapperContextForParams(r9, WifiScanner.ScanListener.class, "com.obric.memorydata.plugin");
        a.e(TAG, "stopPnoScan listener=" + r10);
        WifiScanner r1 = this.mWifiScanner;
        if (r1 == null) goto L18;
        if (r10 == null) goto L18;
        Class<?> r2 = r1.getClass();
        Method r5 = r2.getMethod("stopPnoScan", new Class[]{WifiScanner.ScanListener.class});     // Catch: Throwable -> L9
        r5.setAccessible(true);     // Catch: Throwable -> L9
        r5.invoke(this.mWifiScanner, new Object[]{r10});     // Catch: Throwable -> L9
        return;
    L9:
        Method r6 = r2.getMethod("stopPnoScan", new Class[]{WifiScanner.PnoScanListener.class});     // Catch: Throwable -> L11
        r6.setAccessible(true);     // Catch: Throwable -> L11
        r6.invoke(this.mWifiScanner, new Object[]{r10});     // Catch: Throwable -> L11
        return;
    L11:
        Method r7 = r2.getMethod("stopDisconnectedPnoScan", new Class[]{WifiScanner.PnoScanListener.class});     // Catch: Throwable -> L13
        r7.setAccessible(true);     // Catch: Throwable -> L13
        r7.invoke(this.mWifiScanner, new Object[]{r10});     // Catch: Throwable -> L13
        return;
    L13:
        Method r11 = r2.getMethod("stopPnoScan", new Class[0]);     // Catch: Throwable -> L15
        r11.setAccessible(true);     // Catch: Throwable -> L15
        r11.invoke(this.mWifiScanner, new Object[0]);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        a.a(TAG, "stopPnoScan: no compatible method found", th);
        return;
    L18:
        a.g(TAG, "stopPnoScan: mWifiScanner or listener is null");
    }

    public boolean stopScan(RequestHandle r9) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        ScanRequest r3 = this.mCurrentRequest;     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        if (r9 == null) goto L15;
        int r1 = r9.getId();     // Catch: Throwable -> L18
        int r5 = r3.getId();     // Catch: Throwable -> L18
        a.c(TAG, "stopScan handle=" + r9 + " handleId=" + r1 + " currentRequest=" + r3 + " currentRequestId=" + r5);     // Catch: Throwable -> L18
        if (r5 == r1) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L18
        return false;
    L12:
        a.c(TAG, "stopScan: cancel current request");     // Catch: Throwable -> L18
        this.mScanSessionId.incrementAndGet();     // Catch: Throwable -> L18
        r3.cancel();     // Catch: Throwable -> L18
        this.mCurrentRequest = null;     // Catch: Throwable -> L18
        releaseWakeLock();     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return true;
    L15:
        a.c(TAG, "stopScan handle=" + r9 + " currentRequest=" + r3);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }
}
