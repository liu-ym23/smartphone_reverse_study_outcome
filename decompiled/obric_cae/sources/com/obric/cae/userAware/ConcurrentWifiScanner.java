package com.obric.cae.userAware;

import android.content.BroadcastReceiver;
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
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.datacollection.WifiScanCount;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.UserAwareUtil;
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

/* JADX INFO: loaded from: classes2.dex */
public class ConcurrentWifiScanner {
    private static final int FULL_BAND = 3;
    private static final int PNO_MIN_24GHZ_RSSI_DBM = -80;
    private static final int PNO_MIN_5GHZ_RSSI_DBM = -77;
    private static final int PNO_MIN_6GHZ_RSSI_DBM = -80;
    private static final int PNO_SCAN_INTERVAL_MS = 5000;
    private static final int PNO_SCAN_INTERVAL_MULTIPLIER = 1;
    private static final int PNO_SCAN_ITERATIONS = 3;
    private static final long SCAN_RETRY_BACKOFF_MS = 1000;
    private static final long SCAN_RETRY_BACKOFF_NO_SUCH_DEVICE_MS = 3000;
    private static final long SCAN_TIMEOUT_MS = 3500;
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

        private FirstAttemptGateState(String r8, int r10) {
            super(r8, r10);
        }

        public static FirstAttemptGateState valueOf(String r8) {
            return (FirstAttemptGateState) Enum.valueOf(FirstAttemptGateState.class, r8);
        }

        public static FirstAttemptGateState[] values() {
            return (FirstAttemptGateState[]) $VALUES.clone();
        }
    }

    public static class RequestHandle {
        private final int requestId;

        public RequestHandle(int r8) {
            this.requestId = r8;
        }

        public int getId() {
            return this.requestId;
        }

        public String toString() {
            return android.aimedia.a.f(new StringBuilder("RequestHandle{requestId="), this.requestId, '}');
        }
    }

    public interface ScanCallback {
        void onScanResults(List<ScanResult> r8);
    }

    public class ScanRequest {
        private volatile ScanCallback callback;
        private volatile long durationMs;
        private volatile FirstAttemptGateState firstAttemptGateState;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private volatile int f5842id;
        private volatile boolean ignoreMovementGate;
        private boolean ignoreScanBudget;
        private volatile long intervalMs;
        private final Runnable scanRunnable;
        private volatile long startTimeMs;
        final /* synthetic */ ConcurrentWifiScanner this$0;

        public ScanRequest(ConcurrentWifiScanner r11, int r12, long r13, long r15, ScanCallback r17, boolean r18) {
            this(r11, r12, r13, r15, r17, r18, false);
        }

        public static /* synthetic */ void a(ScanRequest r8) {
            r8.lambda$startScanInternal$4();
        }

        public static /* synthetic */ void b(ScanRequest r8) {
            r8.lambda$startScanInternal$5();
        }

        public static /* synthetic */ void c(ScanRequest r8, List r10) {
            r8.lambda$runScanCycle$1(r10);
        }

        private FirstAttemptGateState createInitialFirstAttemptGateState(boolean r8, boolean r10) {
            if (r8 == true) goto L8;
            if (r10 == false) goto L8;
            return FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE;
        L8:
            return FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_NO_TOKEN;
        }

        public static /* synthetic */ void d(ScanRequest r8) {
            r8.lambda$startScanInternal$2();
        }

        public static /* synthetic */ void e(ScanRequest r8, List r10, int r11, List r12) {
            r8.lambda$runScanCycle$0(r10, r11, r12);
        }

        public static /* synthetic */ void f(ScanRequest r8) {
            r8.lambda$startScanInternal$3();
        }

        private void failureScanScheduleNext(long r8) {
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) <= this.durationMs) goto L6;
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$200(this.this$0, this.f5842id);
            return;
        L6:
            ConcurrentWifiScanner.access$000(this.this$0).postDelayed(this.scanRunnable, r8);
        }

        private List<Integer> findMissedFrequencies(List<ScanResult> r8, List<ScanResult> r10) {
            long r11 = SystemClock.elapsedRealtime() - ConcurrentWifiScanner.access$600(this.this$0);
            if (r11 <= 5000) goto L6;
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Skip rescan: last scan was " + r11 + "ms ago");
            return Collections.emptyList();
        L6:
            HashSet r12 = new HashSet();
            Iterator<ScanResult> r13 = r10.iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            r12.add(r13.next().BSSID);
            goto L8
        L10:
            HashSet r14 = new HashSet();
            Iterator<ScanResult> r15 = r8.iterator();
        L12:
            if (r15.hasNext() == false) goto L21;
            ScanResult r16 = r15.next();
            if (r12.contains(r16.BSSID) == true) goto L12;
            if (r16.level <= (-80)) goto L12;
            if (TextUtils.isEmpty(r16.SSID) == true) goto L12;
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "missed AP: " + r16.SSID + " " + r16.BSSID + " freq=" + r16.frequency + " rssi=" + r16.level + " timeSinceLastScan=" + r11 + "ms");
            r14.add(Integer.valueOf(r16.frequency));
            goto L12
        L21:
            return new ArrayList(r14);
        }

        public static /* synthetic */ void g(ScanRequest r8) {
            r8.runScanCycle();
        }

        private /* synthetic */ void lambda$runScanCycle$0(List r8, int r10, List r11) {
            List<ScanResult> r12 = mergeResults(r8, r11);
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Combined results: " + r12.size() + " missed freqs scan results: " + r11.size() + " total scan count: " + r10);
            ScanCallback r13 = this.callback;
            if (r13 == null) goto L5;
            r13.onScanResults(r12);
        L5:
            ConcurrentWifiScanner.access$902(this.this$0, r12);
            scheduleNext();
        }

        private /* synthetic */ void lambda$runScanCycle$1(final List r8) {
            final int r10 = ConcurrentWifiScanner.access$800(this.this$0).incrementAndGet();
            UserAwareUtil.onUserAwareWifiScanSuccess(ConcurrentWifiScanner.access$500(this.this$0));
            if (ConcurrentWifiScanner.access$300(this.this$0) == true) goto L8;
            List<Integer> r11 = findMissedFrequencies(ConcurrentWifiScanner.access$900(this.this$0), r8);
            if (r11.isEmpty() == true) goto L8;
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Rescanning missed freqs: " + r11);
            startScanInternal(r11, new f(this, r8, r10));
            return;
        L8:
            ConcurrentWifiScanner.access$902(this.this$0, r8);
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Full scan results: " + r8.size() + " total scan count: " + r10);
            ScanCallback r12 = this.callback;
            if (r12 == null) goto L11;
            r12.onScanResults(r8);
        L11:
            scheduleNext();
        }

        private /* synthetic */ void lambda$startScanInternal$2() {
            failureScanScheduleNext(1000);
        }

        private /* synthetic */ void lambda$startScanInternal$3() {
            failureScanScheduleNext(3000);
        }

        private /* synthetic */ void lambda$startScanInternal$4() {
            failureScanScheduleNext(1000);
        }

        private /* synthetic */ void lambda$startScanInternal$5() {
            failureScanScheduleNext(3000);
        }

        private void markFirstAttemptStarted() {
            FirstAttemptGateState r8 = this.firstAttemptGateState;
            FirstAttemptGateState r10 = FirstAttemptGateState.AFTER_FIRST_ATTEMPT;
            if (r8 == r10) goto L6;
            this.firstAttemptGateState = r10;
            return;
        }

        private void maybeSupplementFirstAttemptBypassToken(boolean r8, boolean r10) {
            if (r8 == true) goto L9;
            if (r10 == true) goto L6;
            return;
        L6:
            if (this.firstAttemptGateState != FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_NO_TOKEN) goto L10;
            this.firstAttemptGateState = FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE;
            return;
        L10:
            return;
        }

        private List<ScanResult> mergeResults(List<ScanResult> r8, List<ScanResult> r10) {
            LinkedHashMap r11 = new LinkedHashMap();
            Iterator<ScanResult> r12 = r8.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ScanResult r13 = r12.next();
            r11.put(r13.BSSID, r13);
            goto L4
        L6:
            Iterator<ScanResult> r14 = r10.iterator();
        L8:
            if (r14.hasNext() == false) goto L11;
            ScanResult r15 = r14.next();
            r11.put(r15.BSSID, r15);
            goto L8
        L11:
            return new ArrayList(r11.values());
        }

        private void runScanCycle() {
            CommSenseLog.i(ConcurrentWifiScanner.TAG, "runScanCycle: id=" + this.f5842id + " mScanSessionId.get()=" + ConcurrentWifiScanner.access$100(this.this$0).get());
            if (this.f5842id == ConcurrentWifiScanner.access$100(this.this$0).get()) goto L6;
            return;
        L6:
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) <= this.durationMs) goto L9;
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$200(this.this$0, this.f5842id);
            return;
        L9:
            int r8 = 0;
            if (ConcurrentWifiScanner.access$300(this.this$0) == false) goto L12;
        L23:
            boolean r10 = false;
        L24:
            if (r10 == false) goto L26;
        L28:
            markFirstAttemptStarted();
            if (UserAwareUtil.tryAcquireUserAwareWifiScanBudget(ConcurrentWifiScanner.access$500(this.this$0)) == true) goto L43;
            int r11 = UserAwareUtil.getUserAwareWifiScanDropCountToday(ConcurrentWifiScanner.access$500(this.this$0));
            int r12 = UserAwareUtil.getUserAwareWifiScanDailyCap(ConcurrentWifiScanner.access$500(this.this$0));
            int r13 = UserAwareUtil.getUserAwareWifiScanSuccessCountToday(ConcurrentWifiScanner.access$500(this.this$0));
            int r14 = UserAwareUtil.getUserAwareWifiScanAttemptCountToday(ConcurrentWifiScanner.access$500(this.this$0));
            StringBuilder r15 = defpackage.a.g("UA wifi scan budget blocked, emit drop snapshot: cap=", r12, " successToday=", r13, " attemptsToday=");
            defpackage.b.q(r15, r14, " dropsToday=", r11, " trainingMode=");
            r15.append(ConcurrentWifiScanner.access$300(this.this$0));
            r15.append(" scanType=");
            int r16 = 2;
            if (ConcurrentWifiScanner.access$300(this.this$0) == false) goto L33;
            int r17 = 2;
        L34:
            r15.append(r17);
            CommSenseLog.d(ConcurrentWifiScanner.TAG, r15.toString());
            WifiScanCount r18 = new WifiScanCount();
            r18.setTimeStamp(System.currentTimeMillis());
            if (ConcurrentWifiScanner.access$300(this.this$0) == true) goto L38;
            r16 = 0;
        L38:
            r18.setScanType(r16);
            r18.setDateScanCount(0);
            r18.setDateScanDropCount(r11);
            CaeUserAwareReportBase r19 = CaeUserAwareReportFactory.getReportInstance();
            if (r19 == null) goto L41;
            r19.reportScanCount(r18);
        L41:
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$200(this.this$0, this.f5842id);
            return;
        L33:
            r17 = 0;
            goto L34
        L43:
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Start full scan...");
            ConcurrentWifiScanner.access$602(this.this$0, SystemClock.elapsedRealtime());
            startScanInternal(new e(this, r8));
            return;
        L26:
            if (this.firstAttemptGateState != FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE) goto L28;
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Retire unused first-attempt bypass token after natural movement");
            goto L28
        L12:
            if (this.ignoreMovementGate == true) goto L23;
            ConcurrentWifiScanner.access$400(this.this$0).ensureStarted();
            if (ConcurrentWifiScanner.access$400(this.this$0).allowScanNow(3000) == true) goto L23;
            if (this.firstAttemptGateState != FirstAttemptGateState.BEFORE_FIRST_ATTEMPT_BYPASS_AVAILABLE) goto L18;
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Bypass movement gate once for current session");
            r10 = true;
            goto L24
        L18:
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Skip scan: no movement in last 3000ms, delta=" + ConcurrentWifiScanner.access$400(this.this$0).getLastStepDeltaMs() + "ms");
            if (this.intervalMs != 0) goto L21;
            failureScanScheduleNext(1000);
            return;
        L21:
            scheduleNext();
        }

        private void scheduleNext() {
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) <= this.durationMs) goto L7;
            this.this$0.releaseWakeLock();
            ConcurrentWifiScanner.access$200(this.this$0, this.f5842id);
            return;
        L7:
            if (this.intervalMs != 0) goto L9;
            ConcurrentWifiScanner.access$000(this.this$0).post(this.scanRunnable);
            return;
        L9:
            ConcurrentWifiScanner.access$000(this.this$0).postDelayed(this.scanRunnable, this.intervalMs);
        }

        private void startScanInternal(ScanCallback r10) {
            CoalescedWifiScanExecutor r8 = CoalescedWifiScanExecutor.getInstance(ConcurrentWifiScanner.access$500(this.this$0), ConcurrentWifiScanner.access$700(this.this$0));
            int r11 = 0;
            r8.startScanInternal(r10, new c(this, r11), new d(this, r11), ConcurrentWifiScanner.SCAN_TIMEOUT_MS);
        }

        public void cancel() {
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "ScanRequest cancel: id=" + this.f5842id);
            this.durationMs = 0;
            ConcurrentWifiScanner.access$000(this.this$0).removeCallbacks(this.scanRunnable);
        }

        public int getId() {
            return this.f5842id;
        }

        public boolean isActive() {
            if ((SystemClock.elapsedRealtime() - this.startTimeMs) > this.durationMs) goto L5;
            return true;
        L5:
            return false;
        }

        public void reconfigure(int r8, long r10, long r11, ScanCallback r12, boolean r13, boolean r14) {
            StringBuilder r15 = new StringBuilder("ScanRequest reconfigure: id=");
            r15.append(r8);
            r15.append(" interval=");
            r15.append(r10);
            r15.append("ms duration=");
            r15.append(r11);
            r15.append("ms callback=");
            if (r12 == null) goto L5;
            boolean r16 = true;
        L6:
            r15.append(r16);
            CommSenseLog.d(ConcurrentWifiScanner.TAG, r15.toString());
            this.f5842id = r8;
            this.intervalMs = r10;
            this.durationMs = r11;
            if (r12 == null) goto L9;
            this.callback = r12;
        L9:
            this.ignoreMovementGate = r13;
            maybeSupplementFirstAttemptBypassToken(r13, r14);
            this.startTimeMs = SystemClock.elapsedRealtime();
            this.this$0.acquireWakeLock(r11 + ConcurrentWifiScanner.SCAN_WAKELOCK_BUFFER_MS);
            ConcurrentWifiScanner.access$000(this.this$0).removeCallbacks(this.scanRunnable);
            if (this.intervalMs != 0) goto L12;
            ConcurrentWifiScanner.access$000(this.this$0).post(this.scanRunnable);
            return;
        L12:
            ConcurrentWifiScanner.access$000(this.this$0).postDelayed(this.scanRunnable, this.intervalMs);
            return;
        L5:
            r16 = false;
            goto L6
        }

        public void start() {
            ConcurrentWifiScanner.access$000(this.this$0).post(this.scanRunnable);
        }

        public ScanRequest(ConcurrentWifiScanner r12, int r13, long r14, long r16, ScanCallback r18, boolean r19, boolean r20) {
            this(r12, r13, r14, r16, r18, r19, r20, false);
        }

        private void startScanInternal(List<Integer> r10, ScanCallback r11) {
            CoalescedWifiScanExecutor r8 = CoalescedWifiScanExecutor.getInstance(ConcurrentWifiScanner.access$500(this.this$0), ConcurrentWifiScanner.access$700(this.this$0));
            int r12 = 1;
            r8.startScanChannels(r10, r11, new c(this, r12), new d(this, r12), ConcurrentWifiScanner.SCAN_TIMEOUT_MS);
        }

        public ScanRequest(ConcurrentWifiScanner r8, int r10, long r11, long r12, ScanCallback r13, boolean r14, boolean r15, boolean r16) {
            this.this$0 = r8;
            this.f5842id = r10;
            this.intervalMs = r11;
            this.durationMs = r12;
            this.callback = r13;
            this.ignoreMovementGate = r14;
            this.ignoreScanBudget = r15;
            this.firstAttemptGateState = createInitialFirstAttemptGateState(r14, r16);
            this.startTimeMs = SystemClock.elapsedRealtime();
            this.scanRunnable = new c(this, 2);
        }
    }

    public class WifiStateReceiver extends BroadcastReceiver {
        final /* synthetic */ ConcurrentWifiScanner this$0;

        public WifiStateReceiver(ConcurrentWifiScanner r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r10.getAction()) == false) goto L17;
            int r11 = r10.getIntExtra("wifi_state", 4);
            if (r11 != 1) goto L14;
            CommSenseLog.d(ConcurrentWifiScanner.TAG, "Wifi disabled, stop scan");
            ConcurrentWifiScanner.access$1002(this.this$0, false);
            if (ConcurrentWifiScanner.access$300(this.this$0) == false) goto L9;
            return;
        L9:
            if (ConcurrentWifiScanner.access$1100(this.this$0) != null) goto L11;
            return;
        L11:
            if (ConcurrentWifiScanner.access$1200(this.this$0) == true) goto L20;
            ConcurrentWifiScanner.access$1300(this.this$0);
            return;
        L20:
            return;
        L14:
            if (r11 != 3) goto L22;
            ConcurrentWifiScanner.access$1002(this.this$0, true);
            return;
        L22:
            return;
        }
    }

    public ConcurrentWifiScanner(Context r8, WifiAwareInfoManager r10) {
        this.mLock = new Object();
        this.mLastScanResults = new ArrayList();
        this.mCurrentRequest = null;
        this.mScanSessionId = new AtomicInteger(0);
        this.mWakeLock = null;
        this.mLastScanTimestampMs = 0;
        this.mTotalScanCount = new AtomicInteger(0);
        this.mTrainingMode = false;
        this.mWakeLockLock = new Object();
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        this.mWifiAwareInfoManager = r10;
        WifiManager r12 = (WifiManager) r8.getSystemService("wifi");
        this.mWifiManager = r12;
        this.mWifiScanner = (WifiScanner) r8.getSystemService(WIFI_SCANNING_SERVICE);
        HandlerThread r13 = new HandlerThread("WifiScanHandler");
        this.mHandlerThread = r13;
        r13.start();
        this.mHandler = new Handler(r13.getLooper());
        this.mIsWifiEnabled = r12.isWifiEnabled();
        if (this.mWifiReceiver != null) goto L5;
        this.mWifiReceiver = new WifiStateReceiver(this);
        IntentFilter r14 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        r11.registerReceiver(this.mWifiReceiver, r14);
    L5:
        this.mStepMovementGate = new StepMovementGate(r11);
    }

    public static /* synthetic */ Handler access$000(ConcurrentWifiScanner r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ AtomicInteger access$100(ConcurrentWifiScanner r8) {
        return r8.mScanSessionId;
    }

    public static /* synthetic */ boolean access$1002(ConcurrentWifiScanner r8, boolean r10) {
        r8.mIsWifiEnabled = r10;
        return r10;
    }

    public static /* synthetic */ ScanRequest access$1100(ConcurrentWifiScanner r8) {
        return r8.mCurrentRequest;
    }

    public static /* synthetic */ boolean access$1200(ConcurrentWifiScanner r8) {
        return r8.isScanAvailable();
    }

    public static /* synthetic */ void access$1300(ConcurrentWifiScanner r8) {
        r8.stopScanInternal();
    }

    public static /* synthetic */ void access$200(ConcurrentWifiScanner r8, int r10) {
        r8.onSessionFinished(r10);
    }

    public static /* synthetic */ boolean access$300(ConcurrentWifiScanner r8) {
        return r8.mTrainingMode;
    }

    public static /* synthetic */ StepMovementGate access$400(ConcurrentWifiScanner r8) {
        return r8.mStepMovementGate;
    }

    public static /* synthetic */ Context access$500(ConcurrentWifiScanner r8) {
        return r8.mContext;
    }

    public static /* synthetic */ long access$600(ConcurrentWifiScanner r8) {
        return r8.mLastScanTimestampMs;
    }

    public static /* synthetic */ long access$602(ConcurrentWifiScanner r8, long r10) {
        r8.mLastScanTimestampMs = r10;
        return r10;
    }

    public static /* synthetic */ WifiScanner access$700(ConcurrentWifiScanner r8) {
        return r8.mWifiScanner;
    }

    public static /* synthetic */ AtomicInteger access$800(ConcurrentWifiScanner r8) {
        return r8.mTotalScanCount;
    }

    public static /* synthetic */ List access$900(ConcurrentWifiScanner r8) {
        return r8.mLastScanResults;
    }

    public static /* synthetic */ List access$902(ConcurrentWifiScanner r8, List r10) {
        r8.mLastScanResults = r10;
        return r10;
    }

    private static Object createWifiSsid(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L16;
        return null;
    L16:
        Class<?> r10 = Class.forName("android.net.wifi.WifiSsid");     // Catch: Throwable -> L13
        Method r11 = r10.getDeclaredMethod("createFromAsciiEncoded", new Class[]{String.class});     // Catch: Throwable -> L9
        r11.setAccessible(true);     // Catch: Throwable -> L9
        return r11.invoke(null, new Object[]{r8});
    L9:
        Method r12 = r10.getDeclaredMethod("fromString", new Class[]{String.class});     // Catch: Throwable -> L11
        r12.setAccessible(true);     // Catch: Throwable -> L11
        return r12.invoke(null, new Object[]{r8});
    L11:
        Method r13 = r10.getDeclaredMethod("createFromByteArray", new Class[]{byte[].class});     // Catch: Throwable -> L13
        r13.setAccessible(true);     // Catch: Throwable -> L13
        return r13.invoke(null, new Object[]{r8.getBytes()});
    L13:
        return null;
    }

    private static String encodeSsidForPno(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return null;
    L7:
        if (r8.length() < 2) goto L14;
        if (r8.charAt(0) != '\"') goto L14;
        if (r8.charAt(r8.length() - 1) != '\"') goto L14;
        return r8;
    L14:
        return defpackage.b.d("\"", r8, "\"");
    }

    private static Field findSsidField(Class<?> r8) {
        String[] r10 = {"ssid", "mSsid", "SSID", "mSSID"};
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= 4) goto L38;
        String r13 = r10[r12];
        Field r14 = r8.getField(r13);     // Catch: Throwable -> L33
        if (r14 == null) goto L40;
        if (r14.getType() != String.class) goto L40;
        return r14;
    L40:
        Field r15 = r8.getDeclaredField(r13);     // Catch: Throwable -> L34
        if (r15 == null) goto L16;
        if (r15.getType() != String.class) goto L16;
        return r15;
    L16:
        r12 = r12 + 1;
        goto L4
    L38:
        Field[] r16 = r8.getDeclaredFields();     // Catch: Throwable -> L35
        int r17 = r16.length;     // Catch: Throwable -> L35
    L18:
        if (r11 >= r17) goto L52;
        Field r18 = r16[r11];     // Catch: Throwable -> L35
        if (r18 != null) goto L23;
    L30:
        r11 = r11 + 1;
        goto L18
    L23:
        if (r18.getType() != String.class) goto L30;
        String r19 = r18.getName();     // Catch: Throwable -> L35
        if (r19 == null) goto L30;
        if (r19.toLowerCase(Locale.ROOT).contains("ssid") == false) goto L30;
        return r18;
    L52:
        return null;
    L31:
        return null;
    }

    private boolean isScanAvailable() {
        WifiManager r8 = this.mWifiManager;     // Catch: Throwable -> L11
        if (r8 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsWifiEnabled == true) goto L8;
        if (r8.isScanAlwaysAvailable() == false) goto L9;
    L8:
        return true;
    L12:
        return this.mIsWifiEnabled;
    }

    private void onSessionFinished(int r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        ScanRequest r11 = this.mCurrentRequest;     // Catch: Throwable -> L11
        if (r11 != null) goto L7;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L7:
        if (r11.getId() != r8) goto L9;
        CommSenseLog.d(TAG, "Scan session finished: id=" + r8 + ", clear mCurrentRequest");     // Catch: Throwable -> L11
        this.mCurrentRequest = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void startDisconnectedPnoScanWithList(List<WifiScanner.PnoSettings.PnoNetwork> r8, WifiScanner.PnoScanListener r10) {
        if (this.mWifiScanner != null) goto L6;
        CommSenseLog.e(TAG, "mWifiScanner is null, cannot start scan");
        return;
    L6:
        if (r8 != null) goto L8;
    L32:
        CommSenseLog.i(TAG, "PNO Network list is empty, return.");
        return;
    L8:
        if (r8.isEmpty() == true) goto L32;
        Constructor<?> r11 = Class.forName("android.net.wifi.WifiScanner$PnoSettings").getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L13
        r11.setAccessible(true);     // Catch: Exception -> L13
        WifiScanner.PnoSettings r12 = (WifiScanner.PnoSettings) r11.newInstance(new Object[0]);     // Catch: Exception -> L13
    L39:
        WifiScanner.PnoSettings.PnoNetwork[] r13 = new WifiScanner.PnoSettings.PnoNetwork[r8.size()];     // Catch: Exception -> L21
        r12.networkList = r13;     // Catch: Exception -> L21
        r12.networkList = (WifiScanner.PnoSettings.PnoNetwork[]) r8.toArray(r13);     // Catch: Exception -> L21
        r12.min5GHzRssi = PNO_MIN_5GHZ_RSSI_DBM;     // Catch: Exception -> L21
        r12.min24GHzRssi = -80;     // Catch: Exception -> L21
        r12.min6GHzRssi = -80;     // Catch: NoSuchFieldError -> L35 Exception -> L21
    L17:
        r12.isConnected = false;     // Catch: Exception -> L21
        Class<?> r14 = r12.getClass();     // Catch: Exception -> L21
        r14.getField("scanIterations").setInt(r12, 3);     // Catch: Exception -> L36
    L43:
        r14.getField("scanIntervalMultiplier").setInt(r12, 1);     // Catch: Exception -> L34
    L23:
        WifiScanner.ScanSettings r15 = new WifiScanner.ScanSettings();
        r15.band = 7;
        r15.reportEvents = 4;
        r15.numBssidsPerScan = 0;
        r15.periodInMs = 5000;
        Executor r16 = this.mContext.getMainExecutor();
        CommSenseLog.i(TAG, "Calling startDisconnectedPnoScan with listener: " + r10 + ", networkListSize=" + r8.size());
        this.mWifiScanner.startDisconnectedPnoScan(r15, r12, r16, r10);     // Catch: Exception -> L26 SecurityException -> L28
    L49:
        return;
    L28:
        e = e;
        String r17 = "SecurityException: Permission denied. Check ACCESS_FINE_LOCATION.";
    L30:
        CommSenseLog.e(TAG, r17, e);
        return;
    L26:
        e = e;
        r17 = "Failed to call startDisconnectedPnoScan";
    L21:
        e = move-exception;
        CommSenseLog.e(TAG, "Error setting PnoSettings fields", e);
    L13:
        e = move-exception;
        CommSenseLog.e(TAG, "FATAL: Failed to create PnoSettings via reflection", e);
        r12 = null;
        goto L39
    }

    private void stopScanInternal() {
        ScanRequest r8 = this.mCurrentRequest;
        if (r8 == null) goto L6;
        r8.cancel();
        this.mCurrentRequest = null;
        releaseWakeLock();
        return;
    }

    public void acquireWakeLock(long r8) {
        Object r10 = this.mWakeLockLock;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mWakeLock != null) goto L8;
        this.mWakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, "Cae::WifiScanWakeLock");     // Catch: Throwable -> L16
    L8:
        if (this.mWakeLock.isHeld() == true) goto L21;
    L13:
        CommSenseLog.i(TAG, "acquireWakeLock timeout=" + r8);     // Catch: Throwable -> L16
        this.mWakeLock.acquire(r8);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L21:
        this.mWakeLock.release();     // Catch: RuntimeException -> L11 Throwable -> L16
    L11:
        e = move-exception;
        CommSenseLog.e(TAG, "WakeLock release failed: " + e.getMessage());     // Catch: Throwable -> L16
        goto L13
    }

    public boolean getTrainingMode() {
        return this.mTrainingMode;
    }

    public void releaseWakeLock() {
        Object r8 = this.mWakeLockLock;
        monitor-enter(r8);
        PowerManager.WakeLock r10 = this.mWakeLock;     // Catch: Throwable -> L15
        if (r10 != null) goto L7;
    L12:
        CommSenseLog.w(TAG, "releaseWakeLock skipped: already released or not held");     // Catch: Throwable -> L15
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L7:
        if (r10.isHeld() == false) goto L12;
        this.mWakeLock.release();     // Catch: RuntimeException -> L10 Throwable -> L15
        CommSenseLog.i(TAG, "WakeLock released");     // Catch: RuntimeException -> L10 Throwable -> L15
    L10:
        e = move-exception;
        CommSenseLog.e(TAG, "WakeLock release failed: " + e.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public List<WifiScanner.PnoSettings.PnoNetwork> retrievePnoNetworkList(Set<Map<String, Integer>> r14) {
        if (r14 == null) goto L108;
        if (r14.isEmpty() == true) goto L108;
        Class<?> r8 = Class.forName("android.net.wifi.WifiScanner$PnoSettings$PnoNetwork");     // Catch: Exception -> L104
        Constructor<?> r10 = null;
        Constructor<?> r11 = r8.getDeclaredConstructor(new Class[]{String.class});     // Catch: Throwable -> L12
        r11.setAccessible(true);     // Catch: Throwable -> L109
    L124:
        Constructor<?> r12 = r8.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L16
        r12.setAccessible(true);     // Catch: Throwable -> L110
    L114:
        r10 = r8.getDeclaredConstructor(new Class[]{Class.forName("android.net.wifi.WifiSsid")});     // Catch: Throwable -> L111
        r10.setAccessible(true);     // Catch: Throwable -> L111
    L18:
        Field r13 = findSsidField(r8);     // Catch: Exception -> L104
        if (r11 != null) goto L24;
        if (r12 != null) goto L24;
        if (r10 != null) goto L24;
        CommSenseLog.e(TAG, "FATAL: No usable PnoNetwork constructor found by reflection");
        return Collections.emptyList();
    L24:
        HashMap r15 = new HashMap();
        HashMap r16 = new HashMap();
        Iterator<Map<String, Integer>> r17 = r14.iterator();
    L26:
        if (r17.hasNext() == false) goto L70;
        Map<String, Integer> r18 = r17.next();
        if (r18 == null) goto L26;
        if (r18.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, Integer>> r19 = r18.entrySet().iterator();
    L34:
        if (r19.hasNext() == false) goto L26;
        Map.Entry<String, Integer> r20 = r19.next();
        String r110 = r20.getKey();
        Integer r21 = r20.getValue();
        if (TextUtils.isEmpty(r110) == true) goto L34;
        if (r21 == null) goto L34;
        if (r21.intValue() <= 0) goto L34;
        if (((WifiScanner.PnoSettings.PnoNetwork) r15.get(r110)) != null) goto L66;
        String r111 = encodeSsidForPno(r110);
        if (r111 == null) goto L34;
        if (r11 != null) goto L112;
        if (r10 != null) goto L51;
        Object r112 = r12.newInstance(new Object[0]);     // Catch: Exception -> L48
        if (r13 == null) goto L57;
        r13.setAccessible(true);     // Catch: Throwable -> L62
        r13.set(r112, r111);     // Catch: Throwable -> L62
    L60:
        Object r113 = r112;
    L61:
        r15.put(r110, (WifiScanner.PnoSettings.PnoNetwork) r113);     // Catch: Exception -> L48
    L62:
        th = move-exception;
        CommSenseLog.e(TAG, "Failed to set ssid field for PnoNetwork, skip ssid=" + r110, th);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to instantiate PnoNetwork for ssid: " + r110, e);
        goto L34
    L57:
        CommSenseLog.e(TAG, "No ssid field found for PnoNetwork, skip ssid=" + r110);     // Catch: Exception -> L48
        goto L34
    L51:
        Object r114 = createWifiSsid(r110);     // Catch: Exception -> L48
        if (r114 == null) goto L53;
        r113 = r10.newInstance(new Object[]{r114});     // Catch: Exception -> L48
        goto L61
    L53:
        CommSenseLog.w(TAG, "createWifiSsid failed, skip ssid=" + r110);     // Catch: Exception -> L48
        goto L34
    L112:
        r113 = r11.newInstance(new Object[]{r111});     // Catch: Exception -> L48
    L66:
        Set r115 = (Set) r16.get(r110);
        if (r115 != null) goto L69;
        r115 = new HashSet();
        r16.put(r110, r115);
    L69:
        r115.add(r21);
        goto L34
    L70:
        Iterator r116 = r15.entrySet().iterator();
    L72:
        if (r116.hasNext() == false) goto L103;
        Map.Entry r117 = (Map.Entry) r116.next();
        String r22 = (String) r117.getKey();
        WifiScanner.PnoSettings.PnoNetwork r118 = (WifiScanner.PnoSettings.PnoNetwork) r117.getValue();
        Set r23 = (Set) r16.get(r22);
        if (r23 == null) goto L101;
        if (r23.isEmpty() == true) goto L101;
        ArrayList r24 = new ArrayList(r23);
        Collections.sort(r24);
        int[] r25 = new int[r24.size()];
        int r26 = 0;
        boolean r27 = false;
        boolean r28 = false;
    L80:
        if (r26 >= r24.size()) goto L96;
        int r29 = ((Integer) r24.get(r26)).intValue();
        r25[r26] = r29;
        if (r29 < 2400) goto L87;
        if (r29 > 2500) goto L87;
        r27 = true;
    L95:
        r26 = r26 + 1;
    L87:
        if (r29 < 5000) goto L91;
        if (r29 > 6000) goto L91;
    L94:
        r28 = true;
    L91:
        if (r29 < 5925) goto L95;
        if (r29 > 7125) goto L95;
    L96:
        r118.frequencies = r25;
        if (r27 == false) goto L99;
        r118.flags = (byte) (r118.flags | 4);
    L99:
        if (r28 == false) goto L72;
        r118.flags = (byte) (r118.flags | 2);
    L101:
        r118.frequencies = new int[0];
        goto L72
    L103:
        return new ArrayList(r15.values());
    L16:
        r12 = null;
    L12:
        r11 = null;
    L104:
        e = move-exception;
        CommSenseLog.e(TAG, "FATAL: Failed to init PnoNetwork reflection", e);
        return Collections.emptyList();
    L108:
        return Collections.emptyList();
    }

    public List<WifiScanner.PnoSettings.PnoNetwork> retrieveSavedPnoNetworkList(int r8) {
        WifiAwareInfoManager r10 = this.mWifiAwareInfoManager;
        if (r10 != null) goto L7;
        CommSenseLog.w(TAG, "retrieveSavedPnoNetworkList: WifiAwareInfoManager is null");
        return Collections.emptyList();
    L7:
        return retrievePnoNetworkList(r10.getSavedPnoNetworkSetForFence(r8));
    }

    public void setTrainingMode(boolean r11, ScanCallback r12) {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrainingMode != r11) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L8:
        this.mTrainingMode = r11;     // Catch: Throwable -> L15
        if (r11 == false) goto L12;
        stopScanInternal();     // Catch: Throwable -> L15
        ScanRequest r13 = new ScanRequest(this, this.mScanSessionId.incrementAndGet(), 0, Long.MAX_VALUE, r12, false);     // Catch: Throwable -> L15
        this.mCurrentRequest = r13;     // Catch: Throwable -> L15
        acquireWakeLock(Long.MAX_VALUE);     // Catch: Throwable -> L15
        r13.start();     // Catch: Throwable -> L15
        String r10 = TAG;
        String r14 = "TrainingMode enabled";
    L11:
        CommSenseLog.i(r10, r14);     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L12:
        stopScanInternal();     // Catch: Throwable -> L15
        r10 = TAG;
        r14 = "TrainingMode disabled";
        goto L11
    }

    public void startPnoScan(Set<Map<String, Integer>> r8, WifiScanner.PnoScanListener r10) {
        StringBuilder r11 = new StringBuilder("startDisconnectedPnoScan fenceScanResults size is ");
        if (r8 == null) goto L5;
        Object r12 = Integer.valueOf(r8.size());
    L6:
        r11.append(r12);
        CommSenseLog.i(TAG, r11.toString());
        startDisconnectedPnoScanWithList(retrievePnoNetworkList(r8), r10);
        return;
    L5:
        r12 = "null";
        goto L6
    }

    public void startPnoScanWithSavedNetworks(int r8, WifiScanner.PnoScanListener r10) {
        CommSenseLog.i(TAG, "startPnoScanWithSavedNetworks fenceState=" + r8);
        startDisconnectedPnoScanWithList(retrieveSavedPnoNetworkList(r8), r10);
    }

    public RequestHandle startScan(long r8, long r10, ScanCallback r12) {
        return startScan(r8, r10, r12, false);
    }

    public void startSingleScan(long r15, long r17, ScanCallback r19) {
        Object r12 = this.mLock;
        monitor-enter(r12);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mTrainingMode == false) goto L10;
        CommSenseLog.w(TAG, "TrainingMode active, ignoring scan request");     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        return;
    L10:
        if (this.mCurrentRequest == null) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L16
        return;
    L13:
        ScanRequest r13 = new ScanRequest(this, this.mScanSessionId.incrementAndGet(), r15, r17, r19, false, false, true);     // Catch: Throwable -> L16
        this.mCurrentRequest = r13;     // Catch: Throwable -> L16
        acquireWakeLock(r17 + SCAN_WAKELOCK_BUFFER_MS);     // Catch: Throwable -> L16
        r13.start();     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
    }

    public void startTrainingScan(ScanCallback r8) {
        setTrainingMode(true, r8);
    }

    public void startUnrestrictedSingleScan(long r15, long r17, ScanCallback r19) {
        Object r12 = this.mLock;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentRequest == null) goto L7;
        CommSenseLog.d(TAG, "startUnrestrictedSingleScan: cancel current request for forced HAR scan");     // Catch: Throwable -> L10
        this.mCurrentRequest.cancel();     // Catch: Throwable -> L10
        releaseWakeLock();     // Catch: Throwable -> L10
    L7:
        ScanRequest r13 = new ScanRequest(this, this.mScanSessionId.incrementAndGet(), r15, r17, r19, true, true, false);     // Catch: Throwable -> L10
        this.mCurrentRequest = r13;     // Catch: Throwable -> L10
        acquireWakeLock(r17 + SCAN_WAKELOCK_BUFFER_MS);     // Catch: Throwable -> L10
        r13.start();     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
    }

    public void stopPnoScan(WifiScanner.ScanListener r10) {
        CommSenseLog.i(TAG, "stopPnoScan listener is " + r10);
        WifiScanner r8 = this.mWifiScanner;
        if (r8 == null) goto L18;
        if (r10 == null) goto L18;
        Class<?> r11 = r8.getClass();
        Object[] r12 = {r10};
        Method r13 = r11.getMethod("stopPnoScan", new Class[]{WifiScanner.ScanListener.class});     // Catch: Throwable -> L9
        r13.setAccessible(true);     // Catch: Throwable -> L9
        r13.invoke(this.mWifiScanner, r12);     // Catch: Throwable -> L9
        return;
    L9:
        Method r14 = r11.getMethod("stopPnoScan", new Class[]{WifiScanner.PnoScanListener.class});     // Catch: Throwable -> L11
        r14.setAccessible(true);     // Catch: Throwable -> L11
        r14.invoke(this.mWifiScanner, new Object[]{r10});     // Catch: Throwable -> L11
        return;
    L11:
        Method r15 = r11.getMethod("stopDisconnectedPnoScan", new Class[]{WifiScanner.PnoScanListener.class});     // Catch: Throwable -> L13
        r15.setAccessible(true);     // Catch: Throwable -> L13
        r15.invoke(this.mWifiScanner, new Object[]{r10});     // Catch: Throwable -> L13
        return;
    L13:
        Method r16 = r11.getMethod("stopPnoScan", new Class[0]);     // Catch: Throwable -> L15
        r16.setAccessible(true);     // Catch: Throwable -> L15
        r16.invoke(this.mWifiScanner, new Object[0]);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        CommSenseLog.e(TAG, "stopPnoScan: no compatible method found", th);
        return;
    L18:
        CommSenseLog.w(TAG, "stopPnoScan: mWifiScanner or listener is null");
    }

    public boolean stopScan(RequestHandle r10) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ScanRequest r11 = this.mCurrentRequest;     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        if (r10 == null) goto L16;
        int r12 = r10.getId();     // Catch: Throwable -> L19
        int r13 = r11.getId();     // Catch: Throwable -> L19
        CommSenseLog.d(TAG, "stopScan handle=" + r10 + " handleId=" + r12 + " currentRequest=" + r11 + " currentRequestId=" + r13);     // Catch: Throwable -> L19
        if (r13 == r12) goto L12;
        monitor-exit(r8);     // Catch: Throwable -> L19
        return false;
    L12:
        CommSenseLog.d(TAG, "stopScan: cancel current request");     // Catch: Throwable -> L19
        r11.cancel();     // Catch: Throwable -> L19
        this.mCurrentRequest = null;     // Catch: Throwable -> L19
        releaseWakeLock();     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return true;
    L16:
        CommSenseLog.d(TAG, "stopScan handle=" + r10 + " currentRequest=" + r11);     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return false;
    L19:
        th = move-exception;
        throw th;
    }

    public RequestHandle startScan(long r10, long r11, ScanCallback r13, boolean r14) {
        return startScan(r10, r11, r13, r14, !r14);
    }

    private RequestHandle startScan(long r16, long r18, ScanCallback r20, boolean r21, boolean r22) {
        WifiAwareInfoManager r8 = this.mWifiAwareInfoManager;
        if (r8.mHasFirstEnterFence == true) goto L5;
    L31:
        return null;
    L5:
        if (r8.mFunctionEnabled == false) goto L31;
        if (isScanAvailable() == true) goto L11;
        CommSenseLog.w(TAG, "Scan not available: Wi-Fi disabled and always scan off");
        return null;
    L11:
        Object r12 = this.mLock;
        monitor-enter(r12);
    L28:
        th = move-exception;
        throw th;
    L14:
        if (this.mTrainingMode == false) goto L18;
        CommSenseLog.w(TAG, "TrainingMode active, ignoring scan request");     // Catch: Throwable -> L28
        monitor-exit(r12);     // Catch: Throwable -> L28
        return null;
    L18:
        ScanRequest r10 = this.mCurrentRequest;     // Catch: Throwable -> L28
        if (r10 != null) goto L21;
    L25:
        int r13 = this.mScanSessionId.incrementAndGet();     // Catch: Throwable -> L28
        ScanRequest r14 = new ScanRequest(this, r13, r16, r18, r20, r21, false, r22);     // Catch: Throwable -> L28
        this.mCurrentRequest = r14;     // Catch: Throwable -> L28
        acquireWakeLock(r18 + SCAN_WAKELOCK_BUFFER_MS);     // Catch: Throwable -> L28
        r14.start();     // Catch: Throwable -> L28
        RequestHandle r11 = new RequestHandle(r13);     // Catch: Throwable -> L28
        monitor-exit(r12);     // Catch: Throwable -> L28
        return r11;
    L21:
        if (r10.isActive() == false) goto L25;
        int r15 = this.mScanSessionId.incrementAndGet();     // Catch: Throwable -> L28
        this.mCurrentRequest.reconfigure(r15, r16, r18, r20, r21, r22);     // Catch: Throwable -> L28
        RequestHandle r17 = new RequestHandle(this.mCurrentRequest.getId());     // Catch: Throwable -> L28
        monitor-exit(r12);     // Catch: Throwable -> L28
        return r17;
    }
}
