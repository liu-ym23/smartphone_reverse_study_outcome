package com.obric.cae.userAware;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiScanner;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.obric.cae.libs.statemachine.IState;
import com.obric.cae.libs.statemachine.State;
import com.obric.cae.libs.statemachine.StateMachine;
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class WifiScanStateMachine extends StateMachine {
    public static final long DEFAULT_GEO_SCANNING_DURATION_NORMAL = 600000;
    public static final long DEFAULT_GEO_SCANNING_DURATION_TRAINING = 1200000;
    public static final long DEFAULT_GEO_SCAN_INTERVAL_MS_NORMAL = 5000;
    public static final long DEFAULT_GEO_SCAN_INTERVAL_MS_TRAINING = 2000;
    public static final long DEFAULT_INDOOR_SCANNING_DURATION_NORMAL = 20000;
    public static final long DEFAULT_INDOOR_SCANNING_DURATION_TRAINING = 120000;
    public static final int DEFAULT_RSSI_THRESHOLD_DB_NORMAL = 7;
    public static final int DEFAULT_RSSI_THRESHOLD_DB_TRAINING = 5;
    public static final long DEFAULT_RSSI_WINDOW_MS_NORMAL = 5000;
    public static final long DEFAULT_RSSI_WINDOW_MS_TRAINING = 6000;
    public static final long DEFAULT_WIFI_SCANNING_DURATION_NORMAL = 300000;
    public static final long DEFAULT_WIFI_SCANNING_DURATION_TRAINING = 600000;
    private static final int EVENT_ENTER_HOME = 5;
    private static final int EVENT_EXIT_HOME = 6;
    private static final int EVENT_FENCE_ENTER = 1;
    private static final int EVENT_FENCE_EXIT = 2;
    private static final int EVENT_GEO_STOP = 101;
    private static final int EVENT_INDOOR_STOP = 103;
    private static final int EVENT_PNO_TIMEOUT = 300;
    private static final int EVENT_RSSI_UPDATE = 200;
    private static final int EVENT_SCAN = 100;
    private static final int EVENT_WIFI_CONNECT_CHANGED = 201;
    private static final int EVENT_WIFI_ENTER = 3;
    private static final int EVENT_WIFI_EXIT = 4;
    private static final int EVENT_WIFI_SCAN_CONTINUE = 301;
    private static final int EVENT_WIFI_SCAN_PAUSE = 102;
    private static final long FENCE_PNO_MAX_DURATION_MS = 600000;
    private static final long FENCE_PNO_MAX_DURATION_MS_LEARNING_SUCCESS = 900000;
    private static final int PNO_SCAN_STATE_DISABLED_UNTIL_REBOOT = 0;
    private static final int PNO_SCAN_STATE_DISABLED_UNTIL_WIFI_TOGGLE = 1;
    private static final int PNO_SCAN_STATE_ENABLED = 2;
    private static final int RSSI_JUMP_TRIGGER_DB = 9;
    private static final int RSSI_VALID_MAX_EXCLUSIVE_DBM = 0;
    private static final int RSSI_VALID_MIN_DBM = -100;
    public static final long SCAN_INTERVAL_WITH_THROTTLE_LEVEL_1_MS = 2000;
    public static final long SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS = 4000;
    public static final long SCAN_INTERVAL_WITH_THROTTLE_LEVEL_3_MS = 6000;
    public static final int SCAN_THROTTLE_LEVEL_1_COUNT = 100;
    public static final int SCAN_THROTTLE_LEVEL_2_COUNT = 300;
    private static final String TAG = "WifiScanSM";
    public static final long WAKE_LOCK_TIMEOUT_1_DATE_MS = 86400000;
    public static final long WAKE_LOCK_TIMEOUT_1_WEEK_MS = 604800000;
    private static final Object sSmLock = null;
    private static HandlerThread sSmThread;
    private ConcurrentWifiScanner mConcurrentWifiScanner;
    private final Context mContext;
    private final DefaultState mDefaultState;
    private int mFenceState;
    private final GeoFenceState mGeoFenceState;
    private long mGeoScanIntervalMsNormal;
    private long mGeoScanIntervalMsTraining;
    private long mGeoScanningDurationNormal;
    private long mGeoScanningDurationTraining;
    private long mIndoorScanningDurationNormal;
    private long mIndoorScanningDurationTraining;
    private final IndoorState mIndoorState;
    private volatile boolean mLearningSuccess;
    private Set<Map<String, Integer>> mMonitorWifiFenceSet;
    private final OutsideFenceState mOutsideFenceState;
    private final WifiScanner.ScanListener mPnoScanListener;
    private boolean mPnoScanStarted;
    private final RssiFluctuationMonitor mRssiMonitor;
    private int mRssiThresholdDbNormal;
    private int mRssiThresholdDbTraining;
    private long mRssiWindowMsNormal;
    private long mRssiWindowMsTraining;
    private boolean mTrainingMode;
    private WifiAwareInfoManager mWifiAwareInfoManager;
    private int mWifiConnectionState;
    private final WifiFenceState mWifiFenceState;
    private WifiManager mWifiManager;
    private long mWifiScanningDurationNormal;
    private long mWifiScanningDurationTraining;

    public class DefaultState extends State {
        final /* synthetic */ WifiScanStateMachine this$0;

        private DefaultState(WifiScanStateMachine r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public boolean processMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 200) goto L7;
            CommSenseLog.d(WifiScanStateMachine.TAG, "DefaultState hanndle EVENT_RSSI_UPDATE");
            WifiScanStateMachine.access$1100(this.this$0).onRssiUpdate(r8.arg1);
            return true;
        L7:
            if (r10 != 300) goto L12;
            CommSenseLog.i(WifiScanStateMachine.TAG, "EVENT_PNO_TIMEOUT received, mPnoScanStarted=" + WifiScanStateMachine.access$900(this.this$0));
            if (WifiScanStateMachine.access$900(this.this$0) == false) goto L11;
            CommSenseLog.i(WifiScanStateMachine.TAG, "Fence PNO timeout reached, force disable");
            WifiScanStateMachine.access$1200(this.this$0, false);
        L11:
            return true;
        L12:
            return false;
        }

        public /* synthetic */ DefaultState(WifiScanStateMachine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class GeoFenceState extends State {
        final /* synthetic */ WifiScanStateMachine this$0;

        private GeoFenceState(WifiScanStateMachine r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public void enter() {
            CommSenseLog.i(WifiScanStateMachine.TAG, "Enter GeoFenceState");
            if (WifiScanStateMachine.access$1400(this.this$0) == true) goto L6;
            this.this$0.sendMessage(100);
            return;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public void exit() {
            CommSenseLog.d(WifiScanStateMachine.TAG, "Exit GeoFenceState");
            WifiScanStateMachine.access$1500(this.this$0, 100);
            WifiScanStateMachine.access$1600(this.this$0, 101);
            if (WifiScanStateMachine.access$900(this.this$0) == false) goto L6;
            WifiScanStateMachine.access$1200(this.this$0, false);
            return;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public boolean processMessage(Message r8) {
            CommSenseLog.d(WifiScanStateMachine.TAG, "GeoFenceState handle msg: " + r8.what);
            int r10 = r8.what;
            if (r10 != 2) goto L5;
            WifiScanStateMachine r11 = this.this$0;
            r11.transitionTo(WifiScanStateMachine.access$1800(r11));
            return true;
        L5:
            if (r10 == 3) goto L30;
            if (r10 != 5) goto L9;
            WifiScanStateMachine r12 = this.this$0;
            r12.transitionTo(WifiScanStateMachine.access$2000(r12));
            return true;
        L9:
            if (r10 == 201) goto L22;
            if (r10 != 100) goto L13;
            WifiScanStateMachine.access$1200(this.this$0, true);
            return true;
        L13:
            if (r10 == 101) goto L15;
            return false;
        L15:
            WifiScanStateMachine.access$1700(this.this$0, 100);
            if (WifiScanStateMachine.access$900(this.this$0) == false) goto L18;
            WifiScanStateMachine.access$1200(this.this$0, false);
        L18:
            return true;
        L22:
            if (r8.arg1 != 1) goto L26;
            CommSenseLog.i(WifiScanStateMachine.TAG, "GeoFenceState: wifi connected, stop fence PNO scan");
            if (WifiScanStateMachine.access$900(this.this$0) == false) goto L26;
            WifiScanStateMachine.access$1200(this.this$0, false);
        L26:
            return true;
        L30:
            if (WifiScanStateMachine.access$1000(this.this$0) == false) goto L33;
            CommSenseLog.i(WifiScanStateMachine.TAG, "LearningSuccess=true, ignore EVENT_WIFI_ENTER in GeoFenceState");
            return true;
        L33:
            WifiScanStateMachine r13 = this.this$0;
            r13.transitionTo(WifiScanStateMachine.access$1900(r13));
            return true;
        }

        public /* synthetic */ GeoFenceState(WifiScanStateMachine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class IndoorState extends State {
        final /* synthetic */ WifiScanStateMachine this$0;

        private IndoorState(WifiScanStateMachine r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public void enter() {
            CommSenseLog.d(WifiScanStateMachine.TAG, "Enter IndoorState");
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public void exit() {
            CommSenseLog.d(WifiScanStateMachine.TAG, "Exit IndoorState");
            WifiScanStateMachine.access$2400(this.this$0, 103);
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public boolean processMessage(Message r8) {
            CommSenseLog.d(WifiScanStateMachine.TAG, "IndoorState handle msg: " + r8.what);
            int r10 = r8.what;
            if (r10 != 103) goto L7;
            CommSenseLog.d(WifiScanStateMachine.TAG, "Indoor scan stop");
            return true;
        L7:
            if (r10 != 6) goto L15;
            if (WifiScanStateMachine.access$1000(this.this$0) == false) goto L11;
            CommSenseLog.d(WifiScanStateMachine.TAG, "Exit home, LearningSuccess=true, transition to GeoFenceState (skip WifiFenceState)");
            WifiScanStateMachine r11 = this.this$0;
            IState r12 = WifiScanStateMachine.access$1300(r11);
        L12:
            r11.transitionTo(r12);
            return true;
        L11:
            CommSenseLog.d(WifiScanStateMachine.TAG, "Exit home, transition to WifiFenceState");
            r11 = this.this$0;
            r12 = WifiScanStateMachine.access$1900(r11);
            goto L12
        L15:
            if (r10 != 2) goto L18;
            WifiScanStateMachine r13 = this.this$0;
            r13.transitionTo(WifiScanStateMachine.access$1800(r13));
            return true;
        L18:
            return false;
        }

        public /* synthetic */ IndoorState(WifiScanStateMachine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class OutsideFenceState extends State {
        final /* synthetic */ WifiScanStateMachine this$0;

        private OutsideFenceState(WifiScanStateMachine r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public void enter() {
            CommSenseLog.i(WifiScanStateMachine.TAG, "Enter OutsideFenceState");
            if (WifiScanStateMachine.access$900(this.this$0) == false) goto L6;
            WifiScanStateMachine.access$1200(this.this$0, false);
            return;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public boolean processMessage(Message r8) {
            CommSenseLog.d(WifiScanStateMachine.TAG, "OutsideFenceState handle msg: " + r8.what);
            if (r8.what != 1) goto L6;
            WifiScanStateMachine r10 = this.this$0;
            r10.transitionTo(WifiScanStateMachine.access$1300(r10));
            return true;
        L6:
            return false;
        }

        public /* synthetic */ OutsideFenceState(WifiScanStateMachine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class WifiFenceState extends State {
        private PowerManager.WakeLock mWifiFencePauseWakeLock;
        private long mWifiFenceScanDurationMs;
        private ConcurrentWifiScanner.RequestHandle mWifiFenceScanHandle;
        private long mWifiFenceScanIntervalMs;
        private boolean mWifiFenceScanPaused;
        private long mWifiFenceScanStartElapsedMs;
        private long mWifiFenceScanTotalDurationMs;
        final /* synthetic */ WifiScanStateMachine this$0;

        private WifiFenceState(WifiScanStateMachine r8) {
            this.this$0 = r8;
            this.mWifiFenceScanPaused = false;
            this.mWifiFencePauseWakeLock = null;
        }

        public static /* synthetic */ void a(WifiFenceState r8, List r10) {
            r8.lambda$processMessage$1(r10);
        }

        public static /* synthetic */ void b(WifiFenceState r8, List r10) {
            r8.lambda$enter$0(r10);
        }

        private /* synthetic */ void lambda$enter$0(List r8) {
            WifiScanStateMachine.access$500(this.this$0).handleWifiScanResults(r8);
        }

        private /* synthetic */ void lambda$processMessage$1(List r8) {
            WifiScanStateMachine.access$500(this.this$0).handleWifiScanResults(r8);
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public void enter() {
            CommSenseLog.i(WifiScanStateMachine.TAG, "Enter WifiFenceState");
            int r8 = 0;
            this.mWifiFenceScanPaused = false;
            this.mWifiFenceScanHandle = null;
            CommSenseLog.d(WifiScanStateMachine.TAG, "mWifiConnectionState: " + WifiScanStateMachine.access$2100(this.this$0));
            if (WifiScanStateMachine.access$2100(this.this$0) != 0) goto L9;
            this.mWifiFenceScanIntervalMs = WifiScanStateMachine.getThrottledScanIntervalMs(WifiScanStateMachine.access$2200(this.this$0));
            this.mWifiFenceScanTotalDurationMs = WifiScanStateMachine.access$2300(this.this$0);
            this.mWifiFenceScanStartElapsedMs = SystemClock.elapsedRealtime();
            long r10 = this.mWifiFenceScanTotalDurationMs;
            if (r10 <= 0) goto L7;
            this.mWifiFenceScanDurationMs = r10;
            WifiScanStateMachine.access$500(this.this$0).mLastTriggeredSceneType = 3;
            this.mWifiFenceScanHandle = WifiScanStateMachine.access$800(this.this$0).startScan(this.mWifiFenceScanIntervalMs, this.mWifiFenceScanDurationMs, new v(this, r8));
            return;
        L7:
            CommSenseLog.i(WifiScanStateMachine.TAG, "WifiFenceState: totalDuration <= 0, skip starting scan");
            return;
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public void exit() {
            CommSenseLog.d(WifiScanStateMachine.TAG, "Exit WifiFenceState");
            if (this.mWifiFenceScanHandle == null) goto L5;
            WifiScanStateMachine.access$800(this.this$0).stopScan(this.mWifiFenceScanHandle);
            this.mWifiFenceScanHandle = null;
        L5:
            PowerManager.WakeLock r8 = this.mWifiFencePauseWakeLock;
            if (r8 != null) goto L8;
        L14:
            this.mWifiFencePauseWakeLock = null;
            this.mWifiFenceScanPaused = false;
            this.mWifiFenceScanTotalDurationMs = 0;
            return;
        L8:
            if (r8.isHeld() == false) goto L14;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause-held wakelock on exit");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L12
        L12:
            e = move-exception;
            CommSenseLog.e(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
            goto L14
        }

        @Override // com.obric.cae.libs.statemachine.State, com.obric.cae.libs.statemachine.IState
        public boolean processMessage(Message r19) {
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState handle msg: " + r19.what);
            int r8 = r19.what;
            int r10 = 2;
            if (r8 != 2) goto L5;
            WifiScanStateMachine r11 = this.this$0;
            r11.transitionTo(WifiScanStateMachine.access$1800(r11));
            return true;
        L5:
            if (r8 != 102) goto L7;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: EVENT_WIFI_SCAN_PAUSE, pause wifi fence scan");
            if (this.mWifiFenceScanHandle != null) goto L67;
        L82:
            return true;
        L67:
            if (this.mWifiFenceScanPaused == true) goto L82;
            WifiScanStateMachine.access$800(this.this$0).stopScan(this.mWifiFenceScanHandle);
            this.mWifiFenceScanHandle = null;
            this.mWifiFenceScanPaused = true;
            long r12 = this.mWifiFenceScanTotalDurationMs - (SystemClock.elapsedRealtime() - this.mWifiFenceScanStartElapsedMs);
            if (r12 <= 0) goto L82;
            if (r12 > WifiScanStateMachine.access$2300(this.this$0)) goto L82;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: acquire pause wakelock for remaining=" + r12 + "ms");
            if (this.mWifiFencePauseWakeLock != null) goto L76;
            this.mWifiFencePauseWakeLock = ((PowerManager) WifiScanStateMachine.access$2200(this.this$0).getSystemService("power")).newWakeLock(1, "Cae::WifiFencePauseWakeLock");
        L76:
            if (this.mWifiFencePauseWakeLock.isHeld() == true) goto L87;
        L81:
            this.mWifiFencePauseWakeLock.acquire(r12);
            goto L82
        L87:
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L79
        L79:
            e = move-exception;
            CommSenseLog.e(WifiScanStateMachine.TAG, "Pause WakeLock pre-release failed: " + e.getMessage());
            goto L81
        L7:
            if (r8 == 201) goto L52;
            if (r8 != 301) goto L11;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: EVENT_WIFI_SCAN_CONTINUE, resume wifi fence scan");
            if (this.mWifiFenceScanPaused == true) goto L23;
            return true;
        L23:
            if (WifiScanStateMachine.access$2100(this.this$0) == 0) goto L35;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: wifi connected, skip resume scan");
            PowerManager.WakeLock r13 = this.mWifiFencePauseWakeLock;
            if (r13 != null) goto L27;
        L34:
            return true;
        L27:
            if (r13.isHeld() == false) goto L34;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause wakelock due to wifi connected");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L31
        L33:
            this.mWifiFencePauseWakeLock = null;
        L31:
            e = move-exception;
            CommSenseLog.e(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
            goto L33
        L35:
            long r14 = this.mWifiFenceScanTotalDurationMs - (SystemClock.elapsedRealtime() - this.mWifiFenceScanStartElapsedMs);
            if (r14 > 0) goto L39;
            CommSenseLog.i(WifiScanStateMachine.TAG, "WifiFenceState: no remaining duration for wifi fence scan, skip resume");
            this.mWifiFenceScanPaused = false;
            return true;
        L39:
            this.mWifiFenceScanDurationMs = r14;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: resume scan, remaining=" + r14 + "ms");
            this.mWifiFenceScanHandle = WifiScanStateMachine.access$800(this.this$0).startScan(this.mWifiFenceScanIntervalMs, this.mWifiFenceScanDurationMs, new t(this, r10));
            PowerManager.WakeLock r15 = this.mWifiFencePauseWakeLock;
            if (r15 != null) goto L42;
        L49:
            this.mWifiFenceScanPaused = false;
            return true;
        L42:
            if (r15.isHeld() == false) goto L49;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause wakelock after resume");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L46
        L48:
            this.mWifiFencePauseWakeLock = null;
        L46:
            e = move-exception;
            CommSenseLog.e(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
            goto L48
        L11:
            if (r8 != 4) goto L13;
            WifiScanStateMachine r16 = this.this$0;
            r16.transitionTo(WifiScanStateMachine.access$1300(r16));
            return true;
        L13:
            if (r8 == 5) goto L15;
            return false;
        L15:
            WifiScanStateMachine r17 = this.this$0;
            r17.transitionTo(WifiScanStateMachine.access$2000(r17));
            return true;
        L52:
            if (r19.arg1 != 1) goto L63;
            WifiScanStateMachine.access$800(this.this$0).stopScan(this.mWifiFenceScanHandle);
            PowerManager.WakeLock r18 = this.mWifiFencePauseWakeLock;
            if (r18 == null) goto L63;
            if (r18.isHeld() == false) goto L63;
            CommSenseLog.d(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause wakelock on wifi connected");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L60
        L62:
            this.mWifiFencePauseWakeLock = null;
        L60:
            e = move-exception;
            CommSenseLog.e(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
        L63:
            return true;
        }

        public /* synthetic */ WifiFenceState(WifiScanStateMachine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    static {
        sSmLock = new Object();
    }

    public WifiScanStateMachine(Context r10, WifiAwareInfoManager r11, ConcurrentWifiScanner r12) {
        super(TAG, getStateMachineLooper());
        this.mGeoScanIntervalMsNormal = 5000;
        this.mGeoScanningDurationNormal = 600000;
        this.mWifiScanningDurationNormal = 300000;
        this.mIndoorScanningDurationNormal = 20000;
        this.mRssiThresholdDbNormal = 7;
        this.mRssiWindowMsNormal = 5000;
        this.mGeoScanIntervalMsTraining = 2000;
        this.mGeoScanningDurationTraining = DEFAULT_GEO_SCANNING_DURATION_TRAINING;
        this.mWifiScanningDurationTraining = 600000;
        this.mIndoorScanningDurationTraining = 120000;
        this.mRssiThresholdDbTraining = 5;
        this.mRssiWindowMsTraining = 6000;
        this.mTrainingMode = false;
        this.mLearningSuccess = false;
        this.mWifiConnectionState = 0;
        this.mFenceState = -1;
        this.mPnoScanStarted = false;
        AnonymousClass1 r8 = null;
        DefaultState r13 = new DefaultState(this, r8);
        this.mDefaultState = r13;
        OutsideFenceState r14 = new OutsideFenceState(this, r8);
        this.mOutsideFenceState = r14;
        GeoFenceState r15 = new GeoFenceState(this, r8);
        this.mGeoFenceState = r15;
        WifiFenceState r16 = new WifiFenceState(this, r8);
        this.mWifiFenceState = r16;
        IndoorState r17 = new IndoorState(this, r8);
        this.mIndoorState = r17;
        Context r18 = r10.getApplicationContext();
        this.mContext = r18;
        this.mConcurrentWifiScanner = r12;
        this.mWifiAwareInfoManager = r11;
        this.mWifiManager = (WifiManager) r18.getSystemService("wifi");
        this.mRssiMonitor = new RssiFluctuationMonitor(r18, new AnonymousClass1(this));
        addState(r13, null);
        addState(r14, r13);
        addState(r15, r13);
        addState(r16, r13);
        addState(r17, r13);
        new Handler(getStateMachineLooper()).post(new o5.r(2));
        setInitialState(r14);
        CommSenseLog.i(TAG, "WifiScanStateMachine init done, calling start() on looper=" + getStateMachineLooper().getThread().getName());
        start();
        this.mPnoScanListener = new AnonymousClass2(this);
    }

    public static /* synthetic */ void a() {
        lambda$new$0();
    }

    public static /* synthetic */ boolean access$1000(WifiScanStateMachine r8) {
        return r8.mLearningSuccess;
    }

    public static /* synthetic */ RssiFluctuationMonitor access$1100(WifiScanStateMachine r8) {
        return r8.mRssiMonitor;
    }

    public static /* synthetic */ void access$1200(WifiScanStateMachine r8, boolean r10) {
        r8.setPnoScanInFence(r10);
    }

    public static /* synthetic */ GeoFenceState access$1300(WifiScanStateMachine r8) {
        return r8.mGeoFenceState;
    }

    public static /* synthetic */ boolean access$1400(WifiScanStateMachine r8) {
        return r8.isWifiConnectedForPnoGuard();
    }

    public static /* synthetic */ void access$1500(WifiScanStateMachine r8, int r10) {
        r8.removeMessages(r10);
    }

    public static /* synthetic */ void access$1600(WifiScanStateMachine r8, int r10) {
        r8.removeMessages(r10);
    }

    public static /* synthetic */ void access$1700(WifiScanStateMachine r8, int r10) {
        r8.removeMessages(r10);
    }

    public static /* synthetic */ OutsideFenceState access$1800(WifiScanStateMachine r8) {
        return r8.mOutsideFenceState;
    }

    public static /* synthetic */ WifiFenceState access$1900(WifiScanStateMachine r8) {
        return r8.mWifiFenceState;
    }

    public static /* synthetic */ IndoorState access$2000(WifiScanStateMachine r8) {
        return r8.mIndoorState;
    }

    public static /* synthetic */ int access$2100(WifiScanStateMachine r8) {
        return r8.mWifiConnectionState;
    }

    public static /* synthetic */ Context access$2200(WifiScanStateMachine r8) {
        return r8.mContext;
    }

    public static /* synthetic */ long access$2300(WifiScanStateMachine r8) {
        return r8.getWifiScanningDuration();
    }

    public static /* synthetic */ void access$2400(WifiScanStateMachine r8, int r10) {
        r8.removeMessages(r10);
    }

    public static /* synthetic */ WifiAwareInfoManager access$500(WifiScanStateMachine r8) {
        return r8.mWifiAwareInfoManager;
    }

    public static /* synthetic */ int access$600(WifiScanStateMachine r8) {
        return r8.mFenceState;
    }

    public static /* synthetic */ long access$700(WifiScanStateMachine r8) {
        return r8.getIndoorScanningDuration();
    }

    public static /* synthetic */ ConcurrentWifiScanner access$800(WifiScanStateMachine r8) {
        return r8.mConcurrentWifiScanner;
    }

    public static /* synthetic */ boolean access$900(WifiScanStateMachine r8) {
        return r8.mPnoScanStarted;
    }

    public static /* synthetic */ boolean access$902(WifiScanStateMachine r8, boolean r10) {
        r8.mPnoScanStarted = r10;
        return r10;
    }

    private void enablePnoScanInFence() {
        if (isWifiConnectedForPnoGuard() == false) goto L7;
        String r8 = "enablePnoScanInFence: Wi-Fi connected, skip disconnected PNO";
    L5:
        CommSenseLog.i(TAG, r8);
        return;
    L7:
        Set<Map<String, Integer>> r10 = null;
        if (this.mLearningSuccess == false) goto L17;
        WifiAwareInfoManager r11 = this.mWifiAwareInfoManager;
        if (r11 == null) goto L12;
        r10 = r11.getSavedPnoNetworkSetForFence(this.mFenceState);
    L12:
        if (r10 != null) goto L14;
    L15:
        r8 = "enablePnoScanInFence: learningSuccess=true but savedSet empty, skip PNO";
        goto L5
    L14:
        if (r10.isEmpty() == true) goto L15;
    L17:
        if (this.mLearningSuccess == true) goto L23;
        Set<Map<String, Integer>> r12 = this.mMonitorWifiFenceSet;
        if (r12 != null) goto L21;
    L22:
        r8 = "enablePnoScanInFence: mMonitorWifiFenceSet empty, skip PNO";
        goto L5
    L21:
        if (r12.isEmpty() == true) goto L22;
    L23:
        this.mPnoScanStarted = true;
        this.mWifiAwareInfoManager.mLastTriggeredSceneType = 1;
        UserAwareService.getService().updateWifiScanCountForPnoChanged(true);
        CommSenseLog.i(TAG, "enablePnoScanInFence mPnoScanListener: " + this.mPnoScanListener);
        setPnoScanStateReflect(this.mContext, 1);
        if (this.mLearningSuccess == false) goto L30;
        StringBuilder r13 = new StringBuilder("enablePnoScanInFence: learningSuccess=true, start PNO with savedSet size=");
        if (r10 != null) goto L28;
        int r14 = 0;
    L29:
        r13.append(r14);
        r13.append(", fenceState=");
        r13.append(this.mFenceState);
        CommSenseLog.i(TAG, r13.toString());
        this.mConcurrentWifiScanner.startPnoScanWithSavedNetworks(this.mFenceState, (WifiScanner.PnoScanListener) this.mPnoScanListener);
        return;
    L28:
        r14 = r10.size();
        goto L29
    L30:
        this.mConcurrentWifiScanner.startPnoScan(this.mMonitorWifiFenceSet, (WifiScanner.PnoScanListener) this.mPnoScanListener);
    }

    private long getGeoScanInterval() {
        if (this.mTrainingMode == false) goto L6;
        return this.mGeoScanIntervalMsTraining;
    L6:
        return this.mGeoScanIntervalMsNormal;
    }

    private long getGeoScanningDuration() {
        if (this.mTrainingMode == false) goto L6;
        return this.mGeoScanningDurationTraining;
    L6:
        return this.mGeoScanningDurationNormal;
    }

    private long getIndoorScanningDuration() {
        if (this.mTrainingMode == false) goto L6;
        return this.mIndoorScanningDurationTraining;
    L6:
        return this.mIndoorScanningDurationNormal;
    }

    private int getRssiThresholdDb() {
        if (this.mTrainingMode == false) goto L6;
        return this.mRssiThresholdDbTraining;
    L6:
        return this.mRssiThresholdDbNormal;
    }

    private long getRssiWindowMs() {
        if (this.mTrainingMode == false) goto L6;
        return this.mRssiWindowMsTraining;
    L6:
        return this.mRssiWindowMsNormal;
    }

    private static Looper getStateMachineLooper() {
        Object r8 = sSmLock;
        monitor-enter(r8);
        HandlerThread r10 = sSmThread;     // Catch: Throwable -> L17
        if (r10 != null) goto L7;
    L10:
        HandlerThread r11 = sSmThread;     // Catch: Throwable -> L17
        if (r11 == null) goto L13;
        r11.quit();     // Catch: Throwable -> L17
        CommSenseLog.w(TAG, "Previous StateMachine thread was dead or invalid, recreating...");     // Catch: Throwable -> L17
    L13:
        HandlerThread r12 = new HandlerThread("WifiScanSMThread");     // Catch: Throwable -> L17
        sSmThread = r12;     // Catch: Throwable -> L17
        r12.start();     // Catch: Throwable -> L17
        CommSenseLog.i(TAG, "StateMachine looper thread started: " + sSmThread.getName() + " ID: " + sSmThread.getId());     // Catch: Throwable -> L17
    L14:
        Looper r13 = sSmThread.getLooper();     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return r13;
    L7:
        if (r10.isAlive() == false) goto L10;
        if (sSmThread.getLooper() != null) goto L14;
    L17:
        th = move-exception;
        throw th;
    }

    public static long getThrottledScanIntervalMs(Context r8) {
        int r10 = UserAwareUtil.getUserAwareWifiScanSuccessCountToday(r8);
        if (r10 >= 100) goto L7;
        return 2000;
    L7:
        if (r10 >= 300) goto L10;
        return SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS;
    L10:
        return 6000;
    }

    private long getWifiScanningDuration() {
        if (this.mTrainingMode == false) goto L6;
        return this.mWifiScanningDurationTraining;
    L6:
        return this.mWifiScanningDurationNormal;
    }

    private boolean isWifiConnectedForPnoGuard() {
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L15;
        return false;
    L15:
        WifiInfo r10 = r8.getConnectionInfo();     // Catch: RuntimeException -> L12
        if (r10 == null) goto L17;
        if (r10.getNetworkId() == (-1)) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        e = move-exception;
        CommSenseLog.w(TAG, "isWifiConnectedForPnoGuard failed: " + e.getMessage());
        return false;
    }

    private static /* synthetic */ void lambda$new$0() {
        Log.e(TAG, "TEST: HandlerThread is ALIVE and processing messages. Thread ID: " + Thread.currentThread().getId());
    }

    private void setPnoScanInFence(boolean r8) {
        if (r8 == true) goto L5;
        removeMessages(300);
        if (this.mPnoScanStarted == false) goto L15;
        this.mPnoScanStarted = false;
        CommSenseLog.i(TAG, "disablePnoScanInFence mPnoScanListener: " + this.mPnoScanListener);
        this.mWifiAwareInfoManager.mLastTriggeredSceneType = 2;
        UserAwareService.getService().updateWifiScanCountForPnoChanged(false);
        this.mConcurrentWifiScanner.stopPnoScan(this.mPnoScanListener);
        setPnoScanStateReflect(this.mContext, 2);
        return;
    L15:
        CommSenseLog.i(TAG, "setPnoScanInFence(false) called but mPnoScanStarted is already false");
        return;
    L5:
        if (this.mWifiAwareInfoManager.mFunctionEnabled == true) goto L7;
        return;
    L7:
        removeMessages(300);
        enablePnoScanInFence();
        if (this.mLearningSuccess == false) goto L10;
        long r10 = FENCE_PNO_MAX_DURATION_MS_LEARNING_SUCCESS;
    L11:
        sendMessageDelayed(300, r10);
        return;
    L10:
        r10 = 600000;
        goto L11
    }

    private void setPnoScanStateReflect(Context r8, int r10) {
        WifiManager r11 = (WifiManager) r8.getSystemService("wifi");
        if (r11 != null) goto L16;
        Log.e(TAG, "WifiManager is null, cannot call setPnoScanState");
        return;
    L16:
        Method r12 = WifiManager.class.getDeclaredMethod("setPnoScanState", new Class[]{Integer.TYPE});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12
        r12.setAccessible(true);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12
        r12.invoke(r11, new Object[]{Integer.valueOf(r10)});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12
        Log.i(TAG, "setPnoScanState invoked successfully, state=" + r10);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12
    L18:
        return;
    L10:
        e = e;
        String r13 = "IllegalAccess when calling setPnoScanState";
    L14:
        Log.e(TAG, r13, e);
        return;
    L12:
        e = e;
        r13 = "setPnoScanState method not found via reflection";
    L8:
        e = e;
        r13 = "InvocationTargetException when calling setPnoScanState";
        goto L14
    }

    public void continueWifiFenceScan() {
        CommSenseLog.d(TAG, "continueWifiFenceScan: send EVENT_WIFI_SCAN_CONTINUE");
        sendMessage(301);
    }

    public boolean isLearningSuccess() {
        return this.mLearningSuccess;
    }

    public boolean isOutsideFenceState() {
        if (getCurrentState() != this.mOutsideFenceState) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPnoScanning() {
        return this.mPnoScanStarted;
    }

    public boolean isTrainingMode() {
        CommSenseLog.d(TAG, "get training mode: " + this.mTrainingMode);
        return this.mTrainingMode;
    }

    public void onEnterHome() {
        CommSenseLog.d(TAG, "onEnterHome");
        sendMessage(5);
    }

    public void onExitHome() {
        CommSenseLog.d(TAG, "onExitHome");
        sendMessage(6);
    }

    public void onFenceEnter(Set<Map<String, Integer>> r8) {
        CommSenseLog.d(TAG, "onFenceEnter " + r8.size());
        this.mMonitorWifiFenceSet = r8;
        sendMessage(1);
    }

    public void onFenceExit() {
        CommSenseLog.d(TAG, "onFenceExit");
        sendMessage(2);
    }

    public void onRssiChanged(int r8) {
        CommSenseLog.d(TAG, "onRssiChanged: " + r8);
        sendMessage(200, r8);
    }

    public void onWifiConnectStateChanged(int r8) {
        CommSenseLog.d(TAG, "onWifiConnectStateChanged: " + r8);
        this.mWifiConnectionState = r8;
        this.mRssiMonitor.reset();
        if (r8 == 1) goto L5;
    L7:
        sendMessage(201, r8);
        return;
    L5:
        if (this.mPnoScanStarted == false) goto L7;
        CommSenseLog.i(TAG, "Wi-Fi connected, stop fence PNO scan");
        setPnoScanInFence(false);
        goto L7
    }

    public void onWifiEnter() {
        CommSenseLog.d(TAG, "onWifiEnter");
        sendMessage(3);
    }

    public void onWifiExit() {
        CommSenseLog.d(TAG, "onWifiExit");
        sendMessage(4);
    }

    public void pauseWifiFenceScan() {
        CommSenseLog.d(TAG, "stopWifiFenceScan: send EVENT_WIFI_STOP");
        sendMessage(102);
    }

    public void resumeRssiTriggeredScanIfNeeded() {
        this.mRssiMonitor.resumeRssiTriggeredScanIfNeeded();
    }

    public void setLearningSuccess(boolean r8) {
        CommSenseLog.i(TAG, "setLearningSuccess: " + r8);
        this.mLearningSuccess = r8;
    }

    public void setNormalRssiParams(int r8, long r10) {
        this.mRssiThresholdDbNormal = r8;
        this.mRssiWindowMsNormal = r10;
    }

    public void setNormalScanParams(long r8, long r10, long r11, long r12) {
        this.mGeoScanIntervalMsNormal = r8;
        this.mGeoScanningDurationNormal = r10;
        this.mWifiScanningDurationNormal = r11;
        this.mIndoorScanningDurationNormal = r12;
    }

    public void setRssiDropThresholdList(List<RssiDropThreshold> r8) {
        this.mRssiMonitor.setDropThresholdList(r8);
    }

    public void setRssiTriggerThresholds(int r8, int r10, int r11, int r12, int r13) {
        RssiFluctuationMonitor r14 = this.mRssiMonitor;
        if (r14 == null) goto L6;
        r14.setTriggerThresholds(r8, r10, r11, r12, r13);
        return;
    }

    public void setTrainingMode(boolean r8) {
        CommSenseLog.d(TAG, "Set training mode: " + r8);
        this.mTrainingMode = r8;
    }

    public void setTrainingRssiParams(int r8, long r10) {
        this.mRssiThresholdDbTraining = r8;
        this.mRssiWindowMsTraining = r10;
    }

    public void setTrainingScanParams(long r8, long r10, long r11, long r12) {
        this.mGeoScanIntervalMsTraining = r8;
        this.mGeoScanningDurationTraining = r10;
        this.mWifiScanningDurationTraining = r11;
        this.mIndoorScanningDurationTraining = r12;
    }

    public void updateFenceState(int r8) {
        CommSenseLog.d(TAG, "updateFenceState: " + r8);
        this.mFenceState = r8;
    }
}
