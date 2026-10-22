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
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.libs.statemachine.b;
import com.obric.cae.libs.statemachine.c;
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.location.cell.g;
import com.obric.cae.log.a;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class WifiScanStateMachine extends c {
    public static final long DEFAULT_FENCE_PNO_MAX_DURATION_AFTER_LEARNING_MS = 900000;
    public static final long DEFAULT_FENCE_PNO_MAX_DURATION_MS = 900000;
    public static final long DEFAULT_GEO_SCANNING_DURATION_NORMAL = 600000;
    public static final long DEFAULT_GEO_SCANNING_DURATION_TRAINING = 1200000;
    public static final long DEFAULT_GEO_SCAN_INTERVAL_MS_NORMAL = 5000;
    public static final long DEFAULT_GEO_SCAN_INTERVAL_MS_TRAINING = 2000;
    public static final long DEFAULT_INDOOR_SCANNING_DURATION_NORMAL = 20000;
    public static final long DEFAULT_INDOOR_SCANNING_DURATION_TRAINING = 120000;
    public static final long DEFAULT_PNO_SCAN_INTERVAL_MS = 5000;
    public static final int DEFAULT_PNO_SCAN_ITERATIONS = 1;
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
    private static final int EVENT_RSSI_UPDATE = 200;
    private static final int EVENT_SCAN = 100;
    private static final int EVENT_WIFI_CONNECT_CHANGED = 201;
    private static final int EVENT_WIFI_ENTER = 3;
    private static final int EVENT_WIFI_EXIT = 4;
    private static final int EVENT_WIFI_SCAN_CONTINUE = 301;
    private static final int EVENT_WIFI_SCAN_PAUSE = 102;
    private static final int FENCE_PNO_SCAN_MULTIPLIER = 1;
    private static final int PNO_SCAN_STATE_DISABLED_UNTIL_WIFI_TOGGLE = 1;
    private static final int PNO_SCAN_STATE_ENABLED = 2;
    private static final int RSSI_JUMP_TRIGGER_DB = 9;
    private static final int RSSI_VALID_MAX_EXCLUSIVE_DBM = 0;
    private static final int RSSI_VALID_MIN_DBM = -100;
    public static final long SCAN_INTERVAL_WITH_THROTTLE_LEVEL_1_MS = 2000;
    public static final long SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS = 4000;
    public static final long SCAN_INTERVAL_WITH_THROTTLE_LEVEL_3_MS = 6000;
    public static final int SCAN_THROTTLE_LEVEL_1_COUNT = 100;
    public static final int SCAN_THROTTLE_LEVEL_2_COUNT = 200;
    private static final String SCREEN_OFF_SCAN_SCHEDULE_BUILDER_CLASS = "android.net.wifi.WifiManager$ScreenOffScanSchedule$Builder";
    private static final String SCREEN_OFF_SCAN_SCHEDULE_CLASS = "android.net.wifi.WifiManager$ScreenOffScanSchedule";
    private static final String SCREEN_ON_SCAN_SCHEDULE_CLASS = "android.net.wifi.WifiManager$ScreenOnScanSchedule";
    private static final String TAG = "WifiScanSM";
    public static final long WAKE_LOCK_TIMEOUT_1_DATE_MS = 86400000;
    public static final long WAKE_LOCK_TIMEOUT_1_WEEK_MS = 604800000;
    private static final String WIFI_SCANNER_CLASS = "android.net.wifi.WifiScanner";
    private static final String WIFI_SCANNER_SCAN_TYPE_HIGH_ACCURACY = "SCAN_TYPE_HIGH_ACCURACY";
    private static final Object sSmLock = null;
    private static HandlerThread sSmThread;
    private ConcurrentWifiScanner mConcurrentWifiScanner;
    private final Context mContext;
    private final DefaultState mDefaultState;
    private int mFenceState;
    private final GeoFenceState mGeoFenceState;
    private final IndoorState mIndoorState;
    private volatile boolean mLearningSuccess;
    private boolean mLegacyPnoScanStarted;
    private final OutsideFenceState mOutsideFenceState;
    private final WifiScanner.ScanListener mPnoScanListener;
    private boolean mPnoScanStarted;
    private final RssiFluctuationMonitor mRssiMonitor;
    private WifiScanConfigProvider mScanConfigProvider;
    private boolean mTrainingMode;
    private WifiAwareInfoManager mWifiAwareInfoManager;
    private int mWifiConnectionState;
    private final WifiFenceState mWifiFenceState;
    private WifiManager mWifiManager;

    public class DefaultState extends b {
        final /* synthetic */ WifiScanStateMachine this$0;

        private DefaultState(WifiScanStateMachine r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ DefaultState(WifiScanStateMachine r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.cae.libs.statemachine.b
        public boolean processMessage(Message r3) {
            if (r3.what != 200) goto L6;
            WifiScanStateMachine.access$1200(this.this$0).onRssiUpdate(r3.arg1);
            return true;
        L6:
            return false;
        }
    }

    public class GeoFenceState extends b {
        final /* synthetic */ WifiScanStateMachine this$0;

        private GeoFenceState(WifiScanStateMachine r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ GeoFenceState(WifiScanStateMachine r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.cae.libs.statemachine.b
        public void enter() {
            a.e(WifiScanStateMachine.TAG, "Enter GeoFenceState");
            if (WifiScanStateMachine.access$1500(this.this$0) == true) goto L6;
            this.this$0.sendMessage(100);
            return;
        }

        @Override // com.obric.cae.libs.statemachine.b
        public void exit() {
            a.c(WifiScanStateMachine.TAG, "Exit GeoFenceState");
            WifiScanStateMachine.access$1600(this.this$0, 100);
            WifiScanStateMachine.access$1700(this.this$0, 101);
            if (WifiScanStateMachine.access$500(this.this$0) == false) goto L6;
            WifiScanStateMachine.access$1300(this.this$0, false);
            return;
        }

        @Override // com.obric.cae.libs.statemachine.b
        public boolean processMessage(Message r6) {
            a.c(WifiScanStateMachine.TAG, "GeoFenceState handle msg: " + r6.what);
            int r0 = r6.what;
            if (r0 != 2) goto L5;
            WifiScanStateMachine r5 = this.this$0;
            r5.transitionTo(WifiScanStateMachine.access$1900(r5));
            return true;
        L5:
            if (r0 == 3) goto L30;
            if (r0 != 5) goto L9;
            WifiScanStateMachine r7 = this.this$0;
            r7.transitionTo(WifiScanStateMachine.access$2200(r7));
            return true;
        L9:
            if (r0 == 201) goto L22;
            if (r0 != 100) goto L13;
            WifiScanStateMachine.access$1300(this.this$0, true);
            return true;
        L13:
            if (r0 == 101) goto L15;
            return false;
        L15:
            WifiScanStateMachine.access$1800(this.this$0, 100);
            if (WifiScanStateMachine.access$500(this.this$0) == false) goto L18;
            WifiScanStateMachine.access$1300(this.this$0, false);
        L18:
            return true;
        L22:
            if (r6.arg1 != 1) goto L26;
            a.e(WifiScanStateMachine.TAG, "GeoFenceState: wifi connected, stop fence PNO scan");
            if (WifiScanStateMachine.access$500(this.this$0) == false) goto L26;
            WifiScanStateMachine.access$1300(this.this$0, false);
        L26:
            return true;
        L30:
            if (WifiScanStateMachine.access$2000(this.this$0).getActiveConfigSnapshot().isSceneEnabled(3) == true) goto L34;
            a.e(WifiScanStateMachine.TAG, "Wifi fence active scan disabled, keep GeoFenceState for PNO");
            return true;
        L34:
            if (WifiScanStateMachine.access$700(this.this$0) == false) goto L37;
            a.e(WifiScanStateMachine.TAG, "LearningSuccess=true, ignore EVENT_WIFI_ENTER in GeoFenceState");
            return true;
        L37:
            WifiScanStateMachine r8 = this.this$0;
            r8.transitionTo(WifiScanStateMachine.access$2100(r8));
            return true;
        }
    }

    public class IndoorState extends b {
        final /* synthetic */ WifiScanStateMachine this$0;

        private IndoorState(WifiScanStateMachine r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ IndoorState(WifiScanStateMachine r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.cae.libs.statemachine.b
        public void enter() {
            a.c(WifiScanStateMachine.TAG, "Enter IndoorState");
        }

        @Override // com.obric.cae.libs.statemachine.b
        public void exit() {
            a.c(WifiScanStateMachine.TAG, "Exit IndoorState");
            WifiScanStateMachine.access$2600(this.this$0, 103);
        }

        @Override // com.obric.cae.libs.statemachine.b
        public boolean processMessage(Message r4) {
            a.c(WifiScanStateMachine.TAG, "IndoorState handle msg: " + r4.what);
            int r5 = r4.what;
            if (r5 != 103) goto L7;
            a.c(WifiScanStateMachine.TAG, "Indoor scan stop");
            return true;
        L7:
            if (r5 != 6) goto L18;
            if (WifiScanStateMachine.access$700(this.this$0) == false) goto L11;
        L14:
            a.c(WifiScanStateMachine.TAG, "Exit home, transition to GeoFenceState (skip WifiFenceState)");
            WifiScanStateMachine r3 = this.this$0;
            com.obric.cae.libs.statemachine.a r6 = WifiScanStateMachine.access$1400(r3);
        L15:
            r3.transitionTo(r6);
            return true;
        L11:
            if (WifiScanStateMachine.access$2000(this.this$0).getActiveConfigSnapshot().isSceneEnabled(3) == false) goto L14;
            a.c(WifiScanStateMachine.TAG, "Exit home, transition to WifiFenceState");
            r3 = this.this$0;
            r6 = WifiScanStateMachine.access$2100(r3);
            goto L15
        L18:
            if (r5 != 2) goto L21;
            WifiScanStateMachine r7 = this.this$0;
            r7.transitionTo(WifiScanStateMachine.access$1900(r7));
            return true;
        L21:
            return false;
        }
    }

    public class OutsideFenceState extends b {
        final /* synthetic */ WifiScanStateMachine this$0;

        private OutsideFenceState(WifiScanStateMachine r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ OutsideFenceState(WifiScanStateMachine r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.cae.libs.statemachine.b
        public void enter() {
            a.e(WifiScanStateMachine.TAG, "Enter OutsideFenceState");
            if (WifiScanStateMachine.access$500(this.this$0) == false) goto L6;
            WifiScanStateMachine.access$1300(this.this$0, false);
            return;
        }

        @Override // com.obric.cae.libs.statemachine.b
        public boolean processMessage(Message r3) {
            a.c(WifiScanStateMachine.TAG, "OutsideFenceState handle msg: " + r3.what);
            if (r3.what != 1) goto L6;
            WifiScanStateMachine r2 = this.this$0;
            r2.transitionTo(WifiScanStateMachine.access$1400(r2));
            return true;
        L6:
            return false;
        }
    }

    public class WifiFenceState extends b {
        private PowerManager.WakeLock mWifiFencePauseWakeLock;
        private long mWifiFenceScanDurationMs;
        private ConcurrentWifiScanner.RequestHandle mWifiFenceScanHandle;
        private long mWifiFenceScanIntervalMs;
        private boolean mWifiFenceScanPaused;
        private long mWifiFenceScanStartElapsedMs;
        private long mWifiFenceScanTotalDurationMs;
        final /* synthetic */ WifiScanStateMachine this$0;

        private WifiFenceState(WifiScanStateMachine r1) {
            this.this$0 = r1;
            this.mWifiFenceScanPaused = false;
            this.mWifiFencePauseWakeLock = null;
        }

        public /* synthetic */ WifiFenceState(WifiScanStateMachine r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.cae.libs.statemachine.b
        public void enter() {
            a.e(WifiScanStateMachine.TAG, "Enter WifiFenceState");
            this.mWifiFenceScanPaused = false;
            this.mWifiFenceScanHandle = null;
            a.c(WifiScanStateMachine.TAG, "mWifiConnectionState: " + WifiScanStateMachine.access$2300(this.this$0));
            if (WifiScanStateMachine.access$2300(this.this$0) != 0) goto L9;
            WifiScanConfigProvider.ActiveConfigSnapshot r2 = WifiScanStateMachine.access$2000(this.this$0).getActiveConfigSnapshot();
            this.mWifiFenceScanIntervalMs = r2.getEffectiveIntervalMs(3);
            this.mWifiFenceScanTotalDurationMs = WifiScanStateMachine.access$2400(this.this$0, r2);
            this.mWifiFenceScanStartElapsedMs = SystemClock.elapsedRealtime();
            long r4 = this.mWifiFenceScanTotalDurationMs;
            if (r4 <= 0) goto L7;
            this.mWifiFenceScanDurationMs = r4;
            this.mWifiFenceScanHandle = WifiScanStateMachine.access$800(this.this$0).startHomeCompanyScan(3, this.mWifiFenceScanIntervalMs, this.mWifiFenceScanDurationMs, r2.shouldIgnoreMovementGate(3, false));
            return;
        L7:
            a.e(WifiScanStateMachine.TAG, "WifiFenceState: totalDuration <= 0, skip starting scan");
            return;
        }

        @Override // com.obric.cae.libs.statemachine.b
        public void exit() {
            a.c(WifiScanStateMachine.TAG, "Exit WifiFenceState");
            if (this.mWifiFenceScanHandle == null) goto L5;
            WifiScanStateMachine.access$1100(this.this$0).stopScan(this.mWifiFenceScanHandle);
            this.mWifiFenceScanHandle = null;
        L5:
            PowerManager.WakeLock r1 = this.mWifiFencePauseWakeLock;
            if (r1 != null) goto L8;
        L14:
            this.mWifiFencePauseWakeLock = null;
            this.mWifiFenceScanPaused = false;
            this.mWifiFenceScanTotalDurationMs = 0;
            return;
        L8:
            if (r1.isHeld() == false) goto L14;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause-held wakelock on exit");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L12
        L12:
            e = move-exception;
            a.i(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
            goto L14
        }

        @Override // com.obric.cae.libs.statemachine.b
        public boolean processMessage(Message r19) {
            a.c(WifiScanStateMachine.TAG, "WifiFenceState handle msg: " + r19.what);
            int r2 = r19.what;
            if (r2 != 2) goto L5;
            WifiScanStateMachine r0 = this.this$0;
            r0.transitionTo(WifiScanStateMachine.access$1900(r0));
            return true;
        L5:
            if (r2 != 102) goto L7;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: EVENT_WIFI_SCAN_PAUSE, pause wifi fence scan");
            if (this.mWifiFenceScanHandle != null) goto L67;
        L82:
            return true;
        L67:
            if (this.mWifiFenceScanPaused == true) goto L82;
            WifiScanStateMachine.access$1100(this.this$0).stopScan(this.mWifiFenceScanHandle);
            this.mWifiFenceScanHandle = null;
            this.mWifiFenceScanPaused = true;
            long r9 = SystemClock.elapsedRealtime() - this.mWifiFenceScanStartElapsedMs;
            long r11 = this.mWifiFenceScanTotalDurationMs;
            long r10 = r11 - r9;
            if (r10 <= 0) goto L82;
            if (r10 > r11) goto L82;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: acquire pause wakelock for remaining=" + r10 + "ms");
            if (this.mWifiFencePauseWakeLock != null) goto L76;
            this.mWifiFencePauseWakeLock = ((PowerManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(WifiScanStateMachine.access$2500(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin")).newWakeLock(1, "Cae::WifiFencePauseWakeLock");
        L76:
            if (this.mWifiFencePauseWakeLock.isHeld() == true) goto L89;
        L81:
            this.mWifiFencePauseWakeLock.acquire(r10);
            goto L82
        L89:
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L79
        L79:
            e = move-exception;
            a.i(WifiScanStateMachine.TAG, "Pause WakeLock pre-release failed: " + e.getMessage());
            goto L81
        L7:
            if (r2 == 201) goto L52;
            if (r2 != 301) goto L11;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: EVENT_WIFI_SCAN_CONTINUE, resume wifi fence scan");
            if (this.mWifiFenceScanPaused == true) goto L23;
            return true;
        L23:
            if (WifiScanStateMachine.access$2300(this.this$0) == 0) goto L35;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: wifi connected, skip resume scan");
            PowerManager.WakeLock r1 = this.mWifiFencePauseWakeLock;
            if (r1 != null) goto L27;
        L34:
            return true;
        L27:
            if (r1.isHeld() == false) goto L34;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause wakelock due to wifi connected");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L31
        L33:
            this.mWifiFencePauseWakeLock = null;
        L31:
            e = move-exception;
            a.i(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
            goto L33
        L35:
            long r13 = this.mWifiFenceScanTotalDurationMs - (SystemClock.elapsedRealtime() - this.mWifiFenceScanStartElapsedMs);
            if (r13 > 0) goto L39;
            a.e(WifiScanStateMachine.TAG, "WifiFenceState: no remaining duration for wifi fence scan, skip resume");
            this.mWifiFenceScanPaused = false;
            return true;
        L39:
            this.mWifiFenceScanDurationMs = r13;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: resume scan, remaining=" + r13 + "ms");
            this.mWifiFenceScanHandle = WifiScanStateMachine.access$800(this.this$0).startHomeCompanyScan(3, this.mWifiFenceScanIntervalMs, this.mWifiFenceScanDurationMs, WifiScanStateMachine.access$2000(this.this$0).getActiveConfigSnapshot().shouldIgnoreMovementGate(3, false));
            PowerManager.WakeLock r3 = this.mWifiFencePauseWakeLock;
            if (r3 != null) goto L42;
        L49:
            this.mWifiFenceScanPaused = false;
            return true;
        L42:
            if (r3.isHeld() == false) goto L49;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause wakelock after resume");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L46
        L48:
            this.mWifiFencePauseWakeLock = null;
        L46:
            e = move-exception;
            a.i(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
            goto L48
        L11:
            if (r2 != 4) goto L13;
            WifiScanStateMachine r4 = this.this$0;
            r4.transitionTo(WifiScanStateMachine.access$1400(r4));
            return true;
        L13:
            if (r2 == 5) goto L15;
            return false;
        L15:
            WifiScanStateMachine r5 = this.this$0;
            r5.transitionTo(WifiScanStateMachine.access$2200(r5));
            return true;
        L52:
            if (r19.arg1 != 1) goto L63;
            WifiScanStateMachine.access$1100(this.this$0).stopScan(this.mWifiFenceScanHandle);
            PowerManager.WakeLock r6 = this.mWifiFencePauseWakeLock;
            if (r6 == null) goto L63;
            if (r6.isHeld() == false) goto L63;
            a.c(WifiScanStateMachine.TAG, "WifiFenceState: releasing pause wakelock on wifi connected");
            this.mWifiFencePauseWakeLock.release();     // Catch: RuntimeException -> L60
        L62:
            this.mWifiFencePauseWakeLock = null;
        L60:
            e = move-exception;
            a.i(WifiScanStateMachine.TAG, "Pause WakeLock release failed: " + e.getMessage());
        L63:
            return true;
        }
    }

    static {
        sSmLock = new Object();
    }

    public WifiScanStateMachine(Context r10, WifiAwareInfoManager r11, ConcurrentWifiScanner r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        super(TAG, getStateMachineLooper());
        this.mTrainingMode = false;
        this.mLearningSuccess = false;
        this.mWifiConnectionState = 0;
        this.mFenceState = -1;
        this.mPnoScanStarted = false;
        this.mLegacyPnoScanStarted = false;
        AnonymousClass1 r3 = null;
        DefaultState r0 = new DefaultState(this, r3);
        this.mDefaultState = r0;
        OutsideFenceState r4 = new OutsideFenceState(this, r3);
        this.mOutsideFenceState = r4;
        GeoFenceState r5 = new GeoFenceState(this, r3);
        this.mGeoFenceState = r5;
        WifiFenceState r6 = new WifiFenceState(this, r3);
        this.mWifiFenceState = r6;
        IndoorState r7 = new IndoorState(this, r3);
        this.mIndoorState = r7;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r14, "com.obric.memorydata.plugin");
        this.mConcurrentWifiScanner = r12;
        this.mWifiAwareInfoManager = r11;
        this.mWifiManager = (WifiManager) ZeusTransformUtils.preCheckCast(r14.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        this.mPnoScanListener = new AnonymousClass1(this);
        this.mRssiMonitor = new RssiFluctuationMonitor(r14, new AnonymousClass2(this));
        addState(r0, null);
        addState(r4, r0);
        addState(r5, r0);
        addState(r6, r0);
        addState(r7, r0);
        new Handler(getStateMachineLooper()).post($$Lambda$WifiScanStateMachine$RblUHtp_Af7rfBDhpa4l27rW0Xk.INSTANCE);
        setInitialState(r4);
        a.e(TAG, "WifiScanStateMachine init done, calling start() on looper=" + getStateMachineLooper().getThread().getName());
        start();
    }

    public static /* synthetic */ long access$1000(WifiScanStateMachine r2) {
        return r2.getIndoorScanningDuration();
    }

    public static /* synthetic */ ConcurrentWifiScanner access$1100(WifiScanStateMachine r0) {
        return r0.mConcurrentWifiScanner;
    }

    public static /* synthetic */ RssiFluctuationMonitor access$1200(WifiScanStateMachine r0) {
        return r0.mRssiMonitor;
    }

    public static /* synthetic */ void access$1300(WifiScanStateMachine r0, boolean r1) {
        r0.setPnoScanInFence(r1);
    }

    public static /* synthetic */ GeoFenceState access$1400(WifiScanStateMachine r0) {
        return r0.mGeoFenceState;
    }

    public static /* synthetic */ boolean access$1500(WifiScanStateMachine r0) {
        return r0.isWifiConnectedForPnoGuard();
    }

    public static /* synthetic */ void access$1600(WifiScanStateMachine r0, int r1) {
        r0.removeMessages(r1);
    }

    public static /* synthetic */ void access$1700(WifiScanStateMachine r0, int r1) {
        r0.removeMessages(r1);
    }

    public static /* synthetic */ void access$1800(WifiScanStateMachine r0, int r1) {
        r0.removeMessages(r1);
    }

    public static /* synthetic */ OutsideFenceState access$1900(WifiScanStateMachine r0) {
        return r0.mOutsideFenceState;
    }

    public static /* synthetic */ WifiScanConfigProvider access$2000(WifiScanStateMachine r0) {
        return r0.getScanConfigProvider();
    }

    public static /* synthetic */ WifiFenceState access$2100(WifiScanStateMachine r0) {
        return r0.mWifiFenceState;
    }

    public static /* synthetic */ IndoorState access$2200(WifiScanStateMachine r0) {
        return r0.mIndoorState;
    }

    public static /* synthetic */ int access$2300(WifiScanStateMachine r0) {
        return r0.mWifiConnectionState;
    }

    public static /* synthetic */ long access$2400(WifiScanStateMachine r0, WifiScanConfigProvider.ActiveConfigSnapshot r1) {
        return r0.getWifiScanningDuration(r1);
    }

    public static /* synthetic */ Context access$2500(WifiScanStateMachine r0) {
        return r0.mContext;
    }

    public static /* synthetic */ void access$2600(WifiScanStateMachine r0, int r1) {
        r0.removeMessages(r1);
    }

    public static /* synthetic */ boolean access$500(WifiScanStateMachine r0) {
        return r0.mPnoScanStarted;
    }

    public static /* synthetic */ boolean access$502(WifiScanStateMachine r0, boolean r1) {
        r0.mPnoScanStarted = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$602(WifiScanStateMachine r0, boolean r1) {
        r0.mLegacyPnoScanStarted = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$700(WifiScanStateMachine r0) {
        return r0.mLearningSuccess;
    }

    public static /* synthetic */ WifiAwareInfoManager access$800(WifiScanStateMachine r0) {
        return r0.mWifiAwareInfoManager;
    }

    public static /* synthetic */ int access$900(WifiScanStateMachine r0) {
        return r0.mFenceState;
    }

    private Object createScreenOffScanScheduleReflect(WifiScanConfigProvider.ActiveConfigSnapshot r12) {
        Class<?> r0 = ZeusTransformUtils.forName(SCREEN_OFF_SCAN_SCHEDULE_BUILDER_CLASS, "com.obric.memorydata.plugin");
        Object r8 = r0.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (r12 != null) goto L6;
        r12 = getScanConfigProvider().getActiveConfigSnapshot();
    L6:
        Duration r9 = Duration.ofMillis(r12.getPnoScanIntervalMs());
        invokeBuilderMethod(r0, r8, "setMovingScanInterval", new Class[]{Duration.class}, r9);
        invokeBuilderMethod(r0, r8, "setStationaryScanInterval", new Class[]{Duration.class}, r9);
        Class<?> r10 = Integer.TYPE;
        invokeBuilderMethod(r0, r8, "setScanIterations", new Class[]{r10}, Integer.valueOf(r12.getPnoScanIterations()));
        invokeBuilderMethod(r0, r8, "setScanMultiplier", new Class[]{r10}, 1);
        return r0.getDeclaredMethod("build", new Class[0]).invoke(r8, new Object[0]);
    }

    private List<Object> createScreenOnScanScheduleReflect(WifiScanConfigProvider.ActiveConfigSnapshot r7) {
        Class r0 = ZeusTransformUtils.forName(SCREEN_ON_SCAN_SCHEDULE_CLASS, "com.obric.memorydata.plugin");
        int r1 = ZeusTransformUtils.forName(WIFI_SCANNER_CLASS, "com.obric.memorydata.plugin").getField(WIFI_SCANNER_SCAN_TYPE_HIGH_ACCURACY).getInt(null);
        if (r7 != null) goto L6;
        r7 = getScanConfigProvider().getActiveConfigSnapshot();
    L6:
        Object r6 = r0.getConstructor(new Class[]{Duration.class, Integer.TYPE}).newInstance(new Object[]{Duration.ofMillis(r7.getPnoScanIntervalMs()), Integer.valueOf(r1)});
        ArrayList r8 = new ArrayList(1);
        r8.add(r6);
        return r8;
    }

    private void enablePnoScanInFence() {
        if (isWifiConnectedForPnoGuard() == false) goto L8;
        String r9 = "enablePnoScanInFence: Wi-Fi connected, skip disconnected PNO";
    L5:
        a.e(TAG, r9);
        return;
    L8:
        if (this.mPnoScanStarted == false) goto L10;
        r9 = "enablePnoScanInFence: CommSense PNO already started, legacy=" + this.mLegacyPnoScanStarted;
        goto L5
    L10:
        g.a(new StringBuilder("enablePnoScanInFence: start CommSense PNO, learningSuccess=").append(this.mLearningSuccess).append(", fenceState="), this.mFenceState, TAG);
        WifiScanConfigProvider.ActiveConfigSnapshot r0 = getScanConfigProvider().getActiveConfigSnapshot();
        long r2 = r0.getFencePnoMaxDurationMs(this.mLearningSuccess);
        boolean r4 = isCommSensePnoSchedulePolicySupported(this.mContext);
        if (r4 == false) goto L13;
        this.mPnoScanStarted = setCommSensePnoSchedulePolicyEnabledReflect(this.mContext, true, r0);
        this.mLegacyPnoScanStarted = false;
    L14:
        if (r4 == true) goto L16;
    L18:
        removeMessages(101);
        if (this.mPnoScanStarted == true) goto L21;
        return;
    L21:
        if (this.mLegacyPnoScanStarted == true) goto L25;
        UserAwareService r6 = (UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L25;
        r6.updateWifiScanCountForPnoChanged(true);
    L25:
        sendMessageDelayed(101, r2);
        a.e(TAG, "enablePnoScanInFence: scheduled CommSense PNO timeout, durationMs=" + r2 + ", intervalMs=" + r0.getPnoScanIntervalMs() + ", iterations=" + r0.getPnoScanIterations() + ", legacy=" + this.mLegacyPnoScanStarted);
        return;
    L16:
        if (this.mPnoScanStarted == true) goto L18;
        a.e(TAG, "enablePnoScanInFence: schedule policy failed, fallback to legacy PNO scan");
        this.mPnoScanStarted = startLegacyPnoScanInFence();
        goto L18
    L13:
        a.e(TAG, "enablePnoScanInFence: CommSense PNO schedule policy unsupported, fallback to legacy PNO scan");
        this.mPnoScanStarted = startLegacyPnoScanInFence();
        goto L14
    }

    private long getGeoScanInterval() {
        return getGeoScanInterval(getScanConfigProvider().getActiveConfigSnapshot());
    }

    private long getGeoScanInterval(WifiScanConfigProvider.ActiveConfigSnapshot r4) {
        boolean r3 = this.mTrainingMode;
        if (r3 == false) goto L5;
        int r0 = 402;
    L6:
        if (r3 == false) goto L8;
        long r1 = 2000;
    L10:
        return r4.getGeoIntervalMs(r0, r1);
    L8:
        r1 = 5000;
        goto L10
    L5:
        r0 = 401;
        goto L6
    }

    private long getGeoScanningDuration() {
        return getGeoScanningDuration(getScanConfigProvider().getActiveConfigSnapshot());
    }

    private long getGeoScanningDuration(WifiScanConfigProvider.ActiveConfigSnapshot r4) {
        boolean r3 = this.mTrainingMode;
        if (r3 == false) goto L5;
        int r0 = 402;
    L6:
        if (r3 == false) goto L8;
        long r1 = DEFAULT_GEO_SCANNING_DURATION_TRAINING;
    L10:
        return r4.getGeoDurationMs(r0, r1);
    L8:
        r1 = 600000;
        goto L10
    L5:
        r0 = 401;
        goto L6
    }

    private long getIndoorScanningDuration() {
        return getIndoorScanningDuration(getScanConfigProvider().getActiveConfigSnapshot());
    }

    private long getIndoorScanningDuration(WifiScanConfigProvider.ActiveConfigSnapshot r4) {
        boolean r3 = this.mTrainingMode;
        if (r3 == false) goto L5;
        int r0 = 402;
    L6:
        if (r3 == false) goto L8;
        long r1 = 120000;
    L10:
        return r4.getIndoorDurationMs(r0, r1);
    L8:
        r1 = 20000;
        goto L10
    L5:
        r0 = 401;
        goto L6
    }

    private WifiScanConfigProvider getScanConfigProvider() {
        if (this.mScanConfigProvider != null) goto L6;
        this.mScanConfigProvider = WifiScanConfigProvider.getInstance(this.mContext);
    L6:
        return this.mScanConfigProvider;
    }

    private static Looper getStateMachineLooper() {
        Object r1 = sSmLock;
        monitor-enter(r1);
        HandlerThread r2 = sSmThread;     // Catch: Throwable -> L17
        if (r2 != null) goto L7;
    L10:
        HandlerThread r3 = sSmThread;     // Catch: Throwable -> L17
        if (r3 == null) goto L13;
        r3.quit();     // Catch: Throwable -> L17
        a.g(TAG, "Previous StateMachine thread was dead or invalid, recreating...");     // Catch: Throwable -> L17
    L13:
        HandlerThread r4 = new HandlerThread("WifiScanSMThread");     // Catch: Throwable -> L17
        sSmThread = r4;     // Catch: Throwable -> L17
        r4.start();     // Catch: Throwable -> L17
        a.e(TAG, "StateMachine looper thread started: " + sSmThread.getName() + " ID: " + sSmThread.getId());     // Catch: Throwable -> L17
    L14:
        Looper r0 = sSmThread.getLooper();     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r0;
    L7:
        if (r2.isAlive() == false) goto L10;
        if (sSmThread.getLooper() != null) goto L14;
    L17:
        th = move-exception;
        throw th;
    }

    public static long getThrottledScanIntervalMs(Context r7) {
        return getThrottledScanIntervalMs((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), 2000, SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS, 6000);
    }

    public static long getThrottledScanIntervalMs(Context r2, long r3, long r5, long r7) {
        int r4 = UserAwareUtil.getUserAwareWifiScanSuccessCountToday((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        if (r4 >= 100) goto L6;
        return r3;
    L6:
        if (r4 >= 200) goto L8;
        return r5;
    L8:
        return r7;
    }

    private long getWifiScanningDuration() {
        return getWifiScanningDuration(getScanConfigProvider().getActiveConfigSnapshot());
    }

    private long getWifiScanningDuration(WifiScanConfigProvider.ActiveConfigSnapshot r4) {
        boolean r3 = this.mTrainingMode;
        if (r3 == false) goto L5;
        int r0 = 402;
    L6:
        if (r3 == false) goto L8;
        long r1 = 600000;
    L10:
        return r4.getWifiDurationMs(r0, r1);
    L8:
        r1 = 300000;
        goto L10
    L5:
        r0 = 401;
        goto L6
    }

    private void invokeBuilderMethod(Class<?> r1, Object r2, String r3, Class<?>[] r4, Object r5) {
        Method r0 = r1.getDeclaredMethod(r3, r4);
        r0.setAccessible(true);
        r0.invoke(r2, new Object[]{r5});
    }

    private boolean isCommSensePnoSchedulePolicySupported(Context r9) {
        if (((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin")) != null) goto L11;
        Log.e(TAG, "WifiManager is null, cannot check CommSense PNO schedule policy");
        return false;
    L11:
        Class r8 = ZeusTransformUtils.forName(SCREEN_OFF_SCAN_SCHEDULE_CLASS, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Class r2 = ZeusTransformUtils.forName(SCREEN_ON_SCAN_SCHEDULE_CLASS, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Class r3 = ZeusTransformUtils.forName(SCREEN_OFF_SCAN_SCHEDULE_BUILDER_CLASS, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        WifiManager.class.getDeclaredMethod("setScreenOffScanSchedule", new Class[]{r8});     // Catch: Throwable -> L8
        WifiManager.class.getDeclaredMethod("setScreenOnScanSchedule", new Class[]{List.class});     // Catch: Throwable -> L8
        r3.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L8
        r3.getDeclaredMethod("setMovingScanInterval", new Class[]{Duration.class});     // Catch: Throwable -> L8
        r3.getDeclaredMethod("setStationaryScanInterval", new Class[]{Duration.class});     // Catch: Throwable -> L8
        Class<?> r5 = Integer.TYPE;     // Catch: Throwable -> L8
        r3.getDeclaredMethod("setScanIterations", new Class[]{r5});     // Catch: Throwable -> L8
        r3.getDeclaredMethod("setScanMultiplier", new Class[]{r5});     // Catch: Throwable -> L8
        r3.getDeclaredMethod("build", new Class[0]);     // Catch: Throwable -> L8
        r2.getConstructor(new Class[]{Duration.class, r5});     // Catch: Throwable -> L8
        ZeusTransformUtils.forName(WIFI_SCANNER_CLASS, "com.obric.memorydata.plugin").getField(WIFI_SCANNER_SCAN_TYPE_HIGH_ACCURACY);     // Catch: Throwable -> L8
        return true;
    L8:
        e = move-exception;
        a.e(TAG, "CommSense PNO schedule policy unsupported: " + e);
        return false;
    }

    private boolean isWifiConnectedForPnoGuard() {
        WifiManager r3 = this.mWifiManager;
        if (r3 != null) goto L15;
        return false;
    L15:
        WifiInfo r4 = r3.getConnectionInfo();     // Catch: RuntimeException -> L12
        if (r4 == null) goto L17;
        if (r4.getNetworkId() == (-1)) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        e = move-exception;
        a.g(TAG, "isWifiConnectedForPnoGuard failed: " + e.getMessage());
        return false;
    }

    static /* synthetic */ void lambda$new$0() {
        a.c(TAG, "HandlerThread is alive and processing messages. Thread ID: " + Thread.currentThread().getId());
    }

    private static int positiveOrDefault(int r0, int r1) {
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return r1;
    }

    private static int secondsToMillisOrDefault(int r0, int r1) {
        return positiveOrDefault(r0, r1) * 1000;
    }

    private boolean setCommSensePnoSchedulePolicyEnabledReflect(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L5;
        WifiScanConfigProvider.ActiveConfigSnapshot r0 = getScanConfigProvider().getActiveConfigSnapshot();
    L7:
        return setCommSensePnoSchedulePolicyEnabledReflect(r5, r4, r0);
    L5:
        r0 = null;
        goto L7
    }

    private boolean setCommSensePnoSchedulePolicyEnabledReflect(Context r5, boolean r6, WifiScanConfigProvider.ActiveConfigSnapshot r7) {
        WifiManager r8 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L7;
        Log.e(TAG, "WifiManager is null, cannot set CommSense PNO schedule policy");
        return false;
    L7:
        if (r6 == true) goto L13;
        boolean r9 = setScreenOffScanScheduleReflect(r8, false);
        boolean r4 = setScreenOnScanScheduleReflect(r8, false);
        if (r9 == false) goto L23;
        if (r4 == true) goto L12;
        return false;
    L12:
        return true;
    L23:
        return false;
    L13:
        if (r7 != null) goto L16;
        r7 = getScanConfigProvider().getActiveConfigSnapshot();
    L16:
        boolean r10 = setScreenOffScanScheduleReflect(r8, true, r7);
        boolean r11 = setScreenOnScanScheduleReflect(r8, true, r7);
        if (r10 == false) goto L21;
        if (r11 == false) goto L21;
        return true;
    L21:
        Log.e(TAG, "Failed to configure CommSense PNO schedules, rollback. screenOff=" + r10 + ", screenOn=" + r11);
        setScreenOffScanScheduleReflect(r8, false);
        setScreenOnScanScheduleReflect(r8, false);
        return false;
    }

    private void setPnoScanInFence(boolean r4) {
        if (r4 == true) goto L4;
        removeMessages(101);
        if (this.mPnoScanStarted == false) goto L22;
        a.e(TAG, "disablePnoScanInFence: stop CommSense PNO, legacy=" + this.mLegacyPnoScanStarted);
        if (this.mLegacyPnoScanStarted == false) goto L18;
        this.mPnoScanStarted = false;
        UserAwareService r5 = (UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        r5.updateWifiScanCountForPnoChanged(false);
    L14:
        ConcurrentWifiScanner r6 = this.mConcurrentWifiScanner;
        if (r6 == null) goto L17;
        r6.stopPnoScan(this.mPnoScanListener);
    L17:
        setPnoScanStateReflect(this.mContext, 2);
    L23:
        this.mLegacyPnoScanStarted = false;
        return;
    L18:
        setCommSensePnoSchedulePolicyEnabledReflect(this.mContext, false);
        UserAwareService r7 = (UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        r7.updateWifiScanCountForPnoChanged(false);
    L21:
        this.mPnoScanStarted = false;
        goto L23
    L22:
        a.e(TAG, "setPnoScanInFence(false) called but mPnoScanStarted is already false");
        goto L23
    L4:
        if (this.mWifiAwareInfoManager.mFunctionEnabled == true) goto L6;
        return;
    L6:
        enablePnoScanInFence();
    }

    private boolean setPnoScanStateReflect(Context r8, int r9) {
        WifiManager r7 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        Log.e(TAG, "WifiManager is null, cannot call setPnoScanState");
        return false;
    L16:
        Method r2 = WifiManager.class.getDeclaredMethod("setPnoScanState", new Class[]{Integer.TYPE});     // Catch: RuntimeException -> L8 ReflectiveOperationException -> L10 NoSuchMethodException -> L12
        r2.setAccessible(true);     // Catch: RuntimeException -> L8 ReflectiveOperationException -> L10 NoSuchMethodException -> L12
        r2.invoke(r7, new Object[]{Integer.valueOf(r9)});     // Catch: RuntimeException -> L8 ReflectiveOperationException -> L10 NoSuchMethodException -> L12
        Log.i(TAG, "setPnoScanState invoked successfully, state=" + r9);     // Catch: RuntimeException -> L8 ReflectiveOperationException -> L10 NoSuchMethodException -> L12
        return true;
    L12:
        e = e;
        String r10 = "setPnoScanState method not found via reflection";
    L14:
        Log.e(TAG, r10, e);
        return false;
    L10:
        e = e;
        r10 = "Reflection failed when calling setPnoScanState";
    L8:
        e = e;
        r10 = "RuntimeException when calling setPnoScanState";
        goto L14
    }

    private boolean setScreenOffScanScheduleReflect(WifiManager r2, boolean r3) {
        return setScreenOffScanScheduleReflect(r2, r3, null);
    }

    private boolean setScreenOffScanScheduleReflect(WifiManager r9, boolean r10, WifiScanConfigProvider.ActiveConfigSnapshot r11) {
        Method r3 = WifiManager.class.getDeclaredMethod("setScreenOffScanSchedule", new Class[]{ZeusTransformUtils.forName(SCREEN_OFF_SCAN_SCHEDULE_CLASS, "com.obric.memorydata.plugin")});     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        r3.setAccessible(true);     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        if (r10 == false) goto L6;
        Object r8 = createScreenOffScanScheduleReflect(r11);     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
    L7:
        r3.invoke(r9, new Object[]{r8});     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        Log.i(TAG, "setScreenOffScanSchedule invoked successfully, enabled=" + r10);     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        return true;
    L6:
        r8 = null;
    L11:
        e = e;
        String r12 = "LinkageError when calling setScreenOffScanSchedule";
    L17:
        Log.e(TAG, r12, e);
        return false;
    L15:
        e = e;
        r12 = "setScreenOffScanSchedule method not found via reflection";
    L13:
        e = e;
        r12 = "Reflection failed when calling setScreenOffScanSchedule";
    L9:
        e = e;
        r12 = "RuntimeException when calling setScreenOffScanSchedule";
        goto L17
    }

    private boolean setScreenOnScanScheduleReflect(WifiManager r2, boolean r3) {
        return setScreenOnScanScheduleReflect(r2, r3, null);
    }

    private boolean setScreenOnScanScheduleReflect(WifiManager r9, boolean r10, WifiScanConfigProvider.ActiveConfigSnapshot r11) {
        Method r3 = WifiManager.class.getDeclaredMethod("setScreenOnScanSchedule", new Class[]{List.class});     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        r3.setAccessible(true);     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        if (r10 == false) goto L6;
        List<Object> r8 = createScreenOnScanScheduleReflect(r11);     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
    L7:
        r3.invoke(r9, new Object[]{r8});     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        Log.i(TAG, "setScreenOnScanSchedule invoked successfully, enabled=" + r10);     // Catch: RuntimeException -> L9 LinkageError -> L11 ReflectiveOperationException -> L13 NoSuchMethodException -> L15
        return true;
    L6:
        r8 = null;
    L11:
        e = e;
        String r12 = "LinkageError when calling setScreenOnScanSchedule";
    L17:
        Log.e(TAG, r12, e);
        return false;
    L15:
        e = e;
        r12 = "setScreenOnScanSchedule method not found via reflection";
    L13:
        e = e;
        r12 = "Reflection failed when calling setScreenOnScanSchedule";
    L9:
        e = e;
        r12 = "RuntimeException when calling setScreenOnScanSchedule";
        goto L17
    }

    private boolean startLegacyPnoScanInFence() {
        if (this.mConcurrentWifiScanner != null) goto L6;
        a.i(TAG, "startLegacyPnoScanInFence: scanner is null");
        return false;
    L6:
        WifiAwareInfoManager r0 = this.mWifiAwareInfoManager;
        if (r0 == null) goto L9;
        Set<Map<String, Integer>> r1 = r0.getSavedPnoNetworkSetForFence(this.mFenceState);
    L11:
        if (r1 != null) goto L13;
    L20:
        g.a(new StringBuilder("startLegacyPnoScanInFence: savedSet empty, skip PNO, learningSuccess=").append(this.mLearningSuccess).append(", fenceState="), this.mFenceState, TAG);
        return false;
    L13:
        if (r1.isEmpty() == true) goto L20;
        this.mPnoScanStarted = true;
        this.mLegacyPnoScanStarted = true;
        UserAwareService r4 = (UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L18;
        r4.updateWifiScanCountForPnoChanged(true);
    L18:
        setPnoScanStateReflect(this.mContext, 1);
        g.a(new StringBuilder("startLegacyPnoScanInFence: start PNO with savedSet size=").append(r1.size()).append(", learningSuccess=").append(this.mLearningSuccess).append(", fenceState="), this.mFenceState, TAG);
        this.mConcurrentWifiScanner.startPnoScanWithSavedNetworks(this.mFenceState, (WifiScanner.PnoScanListener) ZeusTransformUtils.preCheckCast(this.mPnoScanListener, WifiScanner.PnoScanListener.class, "com.obric.memorydata.plugin"));
        return true;
    L9:
        r1 = null;
        goto L11
    }

    public void continueWifiFenceScan() {
        a.c(TAG, "continueWifiFenceScan: send EVENT_WIFI_SCAN_CONTINUE");
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
        a.c(TAG, "get training mode: " + this.mTrainingMode);
        return this.mTrainingMode;
    }

    public void onEnterHome() {
        a.c(TAG, "onEnterHome");
        sendMessage(5);
    }

    public void onExitHome() {
        a.c(TAG, "onExitHome");
        sendMessage(6);
    }

    public void onFenceEnter() {
        a.c(TAG, "onFenceEnter");
        sendMessage(1);
    }

    public void onFenceExit() {
        a.c(TAG, "onFenceExit");
        sendMessage(2);
    }

    public void onRssiChanged(int r3) {
        a.c(TAG, "onRssiChanged: " + r3);
        sendMessage(200, r3);
    }

    public void onWifiConnectStateChanged(int r3) {
        a.c(TAG, "onWifiConnectStateChanged: " + r3);
        this.mWifiConnectionState = r3;
        this.mRssiMonitor.reset();
        if (r3 == 1) goto L5;
    L7:
        sendMessage(201, r3);
        return;
    L5:
        if (this.mPnoScanStarted == false) goto L7;
        a.e(TAG, "Wi-Fi connected, stop fence PNO scan");
        setPnoScanInFence(false);
        goto L7
    }

    public void onWifiEnter() {
        a.c(TAG, "onWifiEnter");
        sendMessage(3);
    }

    public void onWifiExit() {
        a.c(TAG, "onWifiExit");
        sendMessage(4);
    }

    public void pauseWifiFenceScan() {
        a.c(TAG, "stopWifiFenceScan: send EVENT_WIFI_STOP");
        sendMessage(102);
    }

    public void resumeRssiTriggeredScanIfNeeded() {
        this.mRssiMonitor.resumeRssiTriggeredScanIfNeeded();
    }

    public void setLearningSuccess(boolean r3) {
        a.e(TAG, "setLearningSuccess: " + r3);
        this.mLearningSuccess = r3;
    }

    public void setRssiDropThresholdList(List<RssiDropThreshold> r11) {
        List<RssiDropThreshold> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        this.mRssiMonitor.setDropThresholdList(r12);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.size() >= 3) goto L7;
        return;
    L7:
        if (this.mRssiMonitor == null) goto L33;
        int r0 = 0;
        RssiDropThreshold r2 = (RssiDropThreshold) ZeusTransformUtils.preCheckCast(r12.get(0), RssiDropThreshold.class, "com.obric.memorydata.plugin");
        RssiDropThreshold r3 = (RssiDropThreshold) ZeusTransformUtils.preCheckCast(r12.get(1), RssiDropThreshold.class, "com.obric.memorydata.plugin");
        RssiDropThreshold r13 = (RssiDropThreshold) ZeusTransformUtils.preCheckCast(r12.get(2), RssiDropThreshold.class, "com.obric.memorydata.plugin");
        RssiFluctuationMonitor r4 = this.mRssiMonitor;
        if (r2 != null) goto L12;
        int r10 = 0;
    L13:
        int r5 = positiveOrDefault(r10, 9);
        if (r13 != null) goto L16;
        int r14 = 0;
    L17:
        int r6 = secondsToMillisOrDefault(r14, 5);
        if (r13 != null) goto L20;
        int r15 = 0;
    L21:
        int r7 = positiveOrDefault(r15, 17);
        if (r3 != null) goto L24;
        int r16 = 0;
    L25:
        int r8 = secondsToMillisOrDefault(r16, 10);
        if (r3 == null) goto L29;
        r0 = r3.dropDb;
    L29:
        r4.setTriggerThresholds(r5, r6, r7, r8, positiveOrDefault(r0, 10));
        return;
    L24:
        r16 = r3.durationSec;
        goto L25
    L20:
        r15 = r13.dropDb;
        goto L21
    L16:
        r14 = r13.durationSec;
        goto L17
    L12:
        r10 = r2.dropDb;
        goto L13
    }

    public void setRssiTriggerThresholds(int r7, int r8, int r9, int r10, int r11) {
        RssiFluctuationMonitor r0 = this.mRssiMonitor;
        if (r0 == null) goto L6;
        r0.setTriggerThresholds(r7, r8, r9, r10, r11);
        return;
    }

    public void setTrainingMode(boolean r3) {
        a.c(TAG, "Set training mode: " + r3);
        this.mTrainingMode = r3;
    }

    public void updateFenceState(int r3) {
        a.c(TAG, "updateFenceState: " + r3);
        this.mFenceState = r3;
        this.mRssiMonitor.onFenceStateChanged(r3);
    }
}
