package com.obric.cae.userAware.SubwayFusionAware;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorEvent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.runtime.CaeRuntime;
import com.obric.cae.smartNetwork.trafficMonitor.TrafficMonitorUtil;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareListener;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareManager;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayFusionAware {
    private static final String ACTION_ALARM_ENTER_CONFIDENCE_SCORING = "com.obric.cae.action.SFA_ALARM_ENTER_CONFIDENCE_SCORING";
    private static final String ACTION_ALARM_EXIT_CONFIDENCE_SCORING = "com.obric.cae.action.SFA_ALARM_EXIT_CONFIDENCE_SCORING";
    private static final String KEY_FILE_SUBWAY = "subway_fusion";
    static final int MSG_HAR_CHANGED = 1;
    static final int MSG_INDOOR_OUTDOOR_STATUS_CHANGED = 6;
    static final int MSG_LOCATION_STATE_CHANGED = 3;
    static final int MSG_SENSOR_DATA_CHANGED = 4;
    static final int MSG_SHARED_BIKE_SCAN = 5;
    static final int MSG_STEPS_COUNTER_CHANGED = 7;
    static final int MSG_SUBWAY_CELL_POI_STATUS_CHANGED = 8;
    static final int MSG_TICK_ENTER_INDOOR_CHECK = 103;
    static final int MSG_TICK_EXIT_TRIGGER_EVALUATION = 104;
    static final int MSG_TIMEOUT_ENTER_CONFIDENCE_SCORING = 101;
    static final int MSG_TIMEOUT_ENTER_PRE_FILTER = 100;
    static final int MSG_TIMEOUT_EXIT_CONFIDENCE_SCORING = 102;
    static final int MSG_WIFI_NETWORK_AVAILABLE = 2;
    private static final String SETTINGS_GLOBAL_USER_LOCATION_STATE = "user_location_state";
    private static final String SFA_VERSION = "v1.3.0";
    private static final String STR_SUBWAY_FILE = "subway_fusion_events.txt";
    private static final String TAG = "SubwayFusionAware";
    private static File mSubwayLogFile;
    private static volatile SubwayFusionAware sInstance;
    private boolean alreadyInit;
    private PendingIntent mAlarmPendingIntent;
    private InnerAwareInfoCallback mAwareCallback;
    private SmartBluetoothAwareListener mBluetoothListener;
    private final Context mContext;
    private SubwayEventProcessor mEventProcessor;
    private PendingIntent mExitAlarmPendingIntent;
    private StarLocationService mStarLocationService;
    private SubwayStateManager mStateManager;
    private final SubwayContext mSubwayContext;
    private PowerManager.WakeLock mWakeLock;
    private SubwayHandler mWorkerHandler;
    private HandlerThread mWorkerThread;

    /* JADX INFO: renamed from: com.obric.cae.userAware.SubwayFusionAware.SubwayFusionAware$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = null;

        static {
            int[] r8 = new int[SubwayState.values().length];
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = r8;
            r8[SubwayState.STATE_IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ENTER_PRE_FILTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ENTER_CONFIDENCE_SCORING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ON_SUBWAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_EXIT_CONFIDENCE_SCORING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class SubwayHandler extends Handler {
        final /* synthetic */ SubwayFusionAware this$0;

        public SubwayHandler(SubwayFusionAware r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 100) goto L5;
        L10:
            boolean r11 = true;
        L11:
            if (r11 == false) goto L13;
        L15:
            int r12 = r8.what;
            switch(r12) {
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L22;
                default: goto L17;
            };
        L17:
            switch(r12) {
                case 100: goto L21;
                case 101: goto L21;
                case 102: goto L21;
                case 103: goto L20;
                case 104: goto L19;
                default: goto L18;
            };
        L18:
            CommSenseLog.w(SubwayFusionAware.access$600(), "Unknown message type: " + r8.what);
        L31:
            SubwayFusionAware.access$1100(this.this$0).evaluateCurrentState();
            return;
        L19:
            SubwayFusionAware.access$1400(this.this$0);
            goto L31
        L20:
            SubwayFusionAware.access$1300(this.this$0);
            goto L31
        L21:
            SubwayFusionAware.access$1200(this.this$0, r12);
            goto L31
        L22:
            SubwayFusionAware.access$1100(this.this$0).processSubwayCellPoiStatusChange((InnerAwareInfoCallback.CellPoiStatus) r8.obj);
            goto L31
        L23:
            SubwayFusionAware.access$1100(this.this$0).processStepsCounterChanged(r8.arg1);
            goto L31
        L24:
            SubwayFusionAware.access$1100(this.this$0).processIndoorOutdoorStatus(r8.arg1);
            goto L31
        L25:
            SubwayFusionAware.access$1100(this.this$0).processSharedBikeEvent(r8.arg1);
            goto L31
        L26:
            SubwayFusionAware.access$1100(this.this$0).processSensorEvent((SensorEvent) r8.obj);
            goto L31
        L27:
            SubwayFusionAware.access$500(this.this$0).locationState = (String) r8.obj;
            String r13 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"LOCATION_STATE", "state=" + SubwayFusionAware.access$500(this.this$0).locationState});
        L29:
            CommSenseLog.dumpI(SubwayFusionAware.access$600(), r13, SubwayFusionAware.access$700());
            goto L31
        L28:
            SubwayFusionAware.access$500(this.this$0).isWifiConnected = ((Boolean) r8.obj).booleanValue();
            r13 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"WIFI_STATE", "connected=" + SubwayFusionAware.access$500(this.this$0).isWifiConnected});
            goto L29
        L30:
            SubwayFusionAware.access$1100(this.this$0).processHarStatusChanged(r8.arg1);
            goto L31
        L13:
            if (UserAwareManager.getInstance().isMemDHarEnabled() == true) goto L15;
            return;
        L5:
            if (r10 == 101) goto L10;
            if (r10 == 102) goto L10;
            r11 = false;
            goto L11
        }
    }

    private SubwayFusionAware(Context r8) {
        this.alreadyInit = false;
        this.mSubwayContext = new SubwayContext();
        this.mContext = r8;
    }

    public static /* synthetic */ void a(SubwayFusionAware r8) {
        r8.triggerIndoorOutdoorCheck();
    }

    public static /* synthetic */ void access$000(SubwayFusionAware r8, SubwayState r10) {
        r8.handleStateEnter(r10);
    }

    public static /* synthetic */ void access$100(SubwayFusionAware r8, SubwayState r10) {
        r8.handleStateExit(r10);
    }

    public static /* synthetic */ void access$1000(SubwayFusionAware r8, long r10) {
        r8.acquireWakeLock(r10);
    }

    public static /* synthetic */ SubwayEventProcessor access$1100(SubwayFusionAware r8) {
        return r8.mEventProcessor;
    }

    public static /* synthetic */ void access$1200(SubwayFusionAware r8, int r10) {
        r8.handleTimeout(r10);
    }

    public static /* synthetic */ void access$1300(SubwayFusionAware r8) {
        r8.handleEnterPeriodicIndoorCheck();
    }

    public static /* synthetic */ void access$1400(SubwayFusionAware r8) {
        r8.handleExitPeriodicTriggerEvaluation();
    }

    public static /* synthetic */ SubwayHandler access$200(SubwayFusionAware r8) {
        return r8.mWorkerHandler;
    }

    public static /* synthetic */ Context access$300(SubwayFusionAware r8) {
        return r8.mContext;
    }

    public static /* synthetic */ SubwayStateManager access$400(SubwayFusionAware r8) {
        return r8.mStateManager;
    }

    public static /* synthetic */ SubwayContext access$500(SubwayFusionAware r8) {
        return r8.mSubwayContext;
    }

    public static /* synthetic */ String access$600() {
        return TAG;
    }

    public static /* synthetic */ File access$700() {
        return mSubwayLogFile;
    }

    public static /* synthetic */ void access$800(SubwayFusionAware r8) {
        r8.cancelFallbackAlarm();
    }

    public static /* synthetic */ void access$900(SubwayFusionAware r8) {
        r8.releaseWakeLock();
    }

    private synchronized void acquireWakeLock(long r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mWakeLock != null) goto L9;
        PowerManager r10 = (PowerManager) this.mContext.getSystemService("power");     // Catch: Throwable -> L19
        if (r10 == null) goto L9;
        this.mWakeLock = r10.newWakeLock(1, TAG + "::Wakelock");     // Catch: Throwable -> L19
    L9:
        PowerManager.WakeLock r11 = this.mWakeLock;     // Catch: Throwable -> L19
        if (r11 != null) goto L12;
    L17:
        monitor-exit(this);
        return;
    L12:
        if (r11.isHeld() == true) goto L17;
        this.mWakeLock.acquire(r8);     // Catch: Throwable -> L19
        SubwayStateManager r12 = this.mStateManager;     // Catch: Throwable -> L19
        if (r12 == null) goto L16;
        r12.onWakeLockAcquired(r8);     // Catch: Throwable -> L19
    L16:
        CommSenseLog.dumpI(TAG, "[WAKELOCK] WakeLock acquired for " + r8 + "ms", mSubwayLogFile);     // Catch: Throwable -> L19
        goto L17
    }

    public static /* synthetic */ void b(SubwayFusionAware r8, Context r10, StarLocationService r11) {
        r8.lambda$init$0(r10, r11);
    }

    public static /* synthetic */ void c(SubwayFusionAware r8, Context r10, StarLocationService r11) {
        r8.lambda$triggerIndoorOutdoorCheck$1(r10, r11);
    }

    private void cancelExitFallbackAlarm() {
        AlarmManager r8 = (AlarmManager) this.mContext.getSystemService("alarm");
        if (r8 == null) goto L8;
        PendingIntent r10 = this.mExitAlarmPendingIntent;
        if (r10 == null) goto L9;
        r8.cancel(r10);
        CommSenseLog.dumpI(TAG, "[ALARM] Cancelled exit fallback alarm", mSubwayLogFile);
        return;
    L9:
        return;
    }

    private void cancelFallbackAlarm() {
        AlarmManager r8 = (AlarmManager) this.mContext.getSystemService("alarm");
        if (r8 == null) goto L8;
        PendingIntent r10 = this.mAlarmPendingIntent;
        if (r10 == null) goto L9;
        r8.cancel(r10);
        CommSenseLog.dumpI(TAG, "[ALARM] Cancelled fallback alarm", mSubwayLogFile);
        return;
    L9:
        return;
    }

    public static SubwayFusionAware getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SubwayFusionAware.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SubwayFusionAware(r8.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(SubwayFusionAware.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handleEnterPeriodicIndoorCheck() {
        if (this.mStateManager.getCurrentState() != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L6;
        this.mEventProcessor.evaluateEnterPeriodicIndoorCheck();
        this.mWorkerHandler.sendEmptyMessageDelayed(103, 2500);
        return;
    }

    private void handleExitPeriodicTriggerEvaluation() {
        if (this.mStateManager.getCurrentState() != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L6;
        this.mEventProcessor.evaluateExitCheckTriggerConditions();
        this.mWorkerHandler.sendEmptyMessageDelayed(104, 2500);
        return;
    }

    private void handleStateEnter(SubwayState r8) {
        int r10 = AnonymousClass5.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r8.ordinal()];
        if (r10 != 1) goto L5;
        SubwayContext r11 = this.mSubwayContext;
        r11.enterStateIdleTime = System.currentTimeMillis();
    L19:
        registerSubwaySensor();
        return;
    L5:
        if (r10 != 2) goto L7;
        acquireWakeLock(20000);
        initWifiConnectedState();
        initLocationState();
        initHarStatus();
        this.mEventProcessor.evaluateCurrentState();
        return;
    L7:
        if (r10 != 3) goto L9;
        SubwayContext r12 = this.mSubwayContext;
        r12.enterStateEnterScoringTime = System.currentTimeMillis();
        acquireWakeLock(20000);
        scheduleFallbackAlarm();
        startSensorCollectSafe(TrafficMonitorUtil.THRESHOLD_3GB);
        registerElevatorSensor();
        registerUpDownStairSensor();
        return;
    L9:
        if (r10 != 4) goto L11;
        SubwayContext r13 = this.mSubwayContext;
        r13.enterStateOnSubwayTime = System.currentTimeMillis();
        startSensorCollectSafe(2048);
    L15:
        registerElevatorSensor();
        registerUpDownStairSensor();
        goto L19
    L11:
        if (r10 != 5) goto L23;
        SubwayContext r14 = this.mSubwayContext;
        r14.enterStateExitScoringTime = System.currentTimeMillis();
        scheduleExitFallbackAlarm();
        startSensorCollectSafe(TrafficMonitorUtil.THRESHOLD_3GB);
        goto L15
    }

    private void handleStateExit(SubwayState r8) {
        int r10 = AnonymousClass5.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r8.ordinal()];
        if (r10 != 1) goto L5;
    L17:
        unregisterSubwaySensor();
        return;
    L5:
        if (r10 != 2) goto L7;
        releaseWakeLock();
        return;
    L7:
        if (r10 != 3) goto L9;
        cancelFallbackAlarm();
        releaseWakeLock();
        stopSensorCollectSafe();
        unregisterElevatorSensor();
        unregisterUpDownStairSensor();
        return;
    L9:
        if (r10 != 4) goto L11;
    L14:
        stopSensorCollectSafe();
        unregisterElevatorSensor();
        unregisterUpDownStairSensor();
        goto L17
    L11:
        if (r10 != 5) goto L21;
        cancelExitFallbackAlarm();
        releaseWakeLock();
        goto L14
    }

    private void handleTimeout(int r8) {
        SubwayState r10 = this.mStateManager.getCurrentState();
        String r11 = String.format("[TIMEOUT] %s", new Object[]{r10});
        String r12 = TAG;
        CommSenseLog.dumpI(r12, r11, mSubwayLogFile);
        if (r8 != 100) goto L9;
        if (r10 != SubwayState.STATE_ENTER_PRE_FILTER) goto L9;
    L6:
        SubwayStateManager r13 = this.mStateManager;
        SubwayState r14 = SubwayState.STATE_IDLE;
    L7:
        r13.transitionToState(r14);
        return;
    L9:
        if (r8 != 101) goto L14;
        if (r10 == SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L6;
    L14:
        if (r8 == 102) goto L16;
        return;
    L16:
        if (r10 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L23;
        SubwayContext r15 = this.mSubwayContext;
        if (r15.curHarStatus != 5) goto L20;
        CommSenseLog.dumpI(r12, "Timeout but HAR is still subway, returning to STATE_ON_SUBWAY", mSubwayLogFile);
        r13 = this.mStateManager;
        r14 = SubwayState.STATE_ON_SUBWAY;
        goto L7
    L20:
        r15.isInSubwayGeofence = false;
        goto L6
    }

    private void initDumpLogFile() {
        File r8 = new File(UserAwareUtil.getLocalDir(this.mContext, KEY_FILE_SUBWAY), STR_SUBWAY_FILE);
        if (r8.exists() == true) goto L5;
    L18:
    L15:
        CommSenseLog.e(TAG, "IO error occurred!");
    L16:
        mSubwayLogFile = r8;
        CommSenseLog.d(TAG, "initDumpLogFile, file: " + mSubwayLogFile);
        CommSenseLog.recordFileWithKey(KEY_FILE_SUBWAY, mSubwayLogFile);
        return;
    L10:
        if (r8.exists() == true) goto L16;
        if (r8.createNewFile() == true) goto L16;
        CommSenseLog.w(TAG, "Failed to create new dump file");     // Catch: IOException -> L15
        goto L16
    L5:
        if ((System.currentTimeMillis() - r8.lastModified()) <= 172800000) goto L18;
        String r10 = TAG;
        CommSenseLog.i(r10, "Dump file is older than 2 days, deleting it");
        if (r8.delete() == true) goto L18;
        CommSenseLog.w(r10, "Failed to delete old dump file");
        goto L18
    }

    private void initHarStatus() {
        if (UserAwareManager.getInstance().getOemHarInfoManager() == null) goto L6;
        this.mSubwayContext.curHarStatus = UserAwareManager.getInstance().getOemHarInfoManager().getHarLastNotifyState();
        CommSenseLog.dumpI(TAG, "Init HAR status: " + this.mSubwayContext.curHarStatus, mSubwayLogFile);
        return;
    }

    private void initLocationState() {
        this.mSubwayContext.locationState = Settings.Global.getString(this.mContext.getContentResolver(), "user_location_state");     // Catch: Exception -> L5
        CommSenseLog.dumpI(TAG, "Init location state: " + this.mSubwayContext.locationState, mSubwayLogFile);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to get initial location state", e);
    }

    private void initWifiConnectedState() {
        WifiAwareInfoManager r8 = WifiAwareInfoManager.getInstance(this.mContext);
        if (r8 == null) goto L10;
        SubwayContext r10 = this.mSubwayContext;
        boolean r11 = true;
        if (r8.getWifiConnectionState() == 1) goto L8;
        r11 = false;
    L8:
        r10.isWifiConnected = r11;
        CommSenseLog.dumpI(TAG, "Init wifi connected state: " + this.mSubwayContext.isWifiConnected, mSubwayLogFile);
        return;
    }

    private /* synthetic */ void lambda$init$0(Context r8, StarLocationService r10) {
        this.mStarLocationService = r10;
        CommSenseLog.dumpI(TAG, "StarLocationService is ready and cached.", mSubwayLogFile);
    }

    private /* synthetic */ void lambda$triggerIndoorOutdoorCheck$1(Context r8, StarLocationService r10) {
        this.mStarLocationService = r10;
    L10:
        e = move-exception;
        CommSenseLog.e(TAG, "runIndoorCheck delayed trigger failed", e);
        return;
    L4:
        if (r10.getStarLocationServiceBinder() == null) goto L15;
        r10.getStarLocationServiceBinder().runIndoorCheck(30000);     // Catch: Exception -> L10
        SubwayStateManager r11 = this.mStateManager;     // Catch: Exception -> L10
        if (r11 == null) goto L8;
        r11.onIndoorOutdoorCheckTriggered();     // Catch: Exception -> L10
    L8:
        CommSenseLog.d(TAG, "runIndoorCheck delayed trigger success");     // Catch: Exception -> L10
        return;
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private void registerAlarmReceiver() {
        BroadcastReceiver r8 = new AnonymousClass4(this);
        IntentFilter r10 = new IntentFilter(ACTION_ALARM_ENTER_CONFIDENCE_SCORING);
        r10.addAction(ACTION_ALARM_EXIT_CONFIDENCE_SCORING);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        this.mContext.registerReceiver(r8, r10, 4);
    L6:
        Intent r11 = new Intent(ACTION_ALARM_ENTER_CONFIDENCE_SCORING);
        this.mAlarmPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, r11, 201326592);
        Intent r12 = new Intent(ACTION_ALARM_EXIT_CONFIDENCE_SCORING);
        this.mExitAlarmPendingIntent = PendingIntent.getBroadcast(this.mContext, 1, r12, 201326592);
        return;
    L5:
        this.mContext.registerReceiver(r8, r10);
        goto L6
    }

    private void registerElevatorSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        CommSenseLog.dumpI(TAG, "registerElevatorSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().registerOutElevator();
        return;
    }

    private void registerSubwaySensor() {
        String r8 = TAG;
        CommSenseLog.i(r8, "registerSubwaySensor");
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        CommSenseLog.dumpI(r8, "registerSubwaySensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().registerSubwaySensor();
        return;
    }

    private void registerUpDownStairSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        CommSenseLog.dumpI(TAG, "registerUpDownStairSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().registerUpDownStairSensor();
        return;
    }

    private synchronized void releaseWakeLock() {
        monitor-enter(this);
        PowerManager.WakeLock r8 = this.mWakeLock;     // Catch: Throwable -> L13
        if (r8 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (r8.isHeld() == false) goto L11;
        SubwayStateManager r10 = this.mStateManager;     // Catch: Throwable -> L13
        if (r10 == null) goto L10;
        r10.onWakeLockReleased();     // Catch: Throwable -> L13
    L10:
        this.mWakeLock.release();     // Catch: Throwable -> L13
        this.mWakeLock = null;     // Catch: Throwable -> L13
        CommSenseLog.dumpI(TAG, "[WAKELOCK] WakeLock released", mSubwayLogFile);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void scheduleExitFallbackAlarm() {
        AlarmManager r8 = (AlarmManager) this.mContext.getSystemService("alarm");
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mExitAlarmPendingIntent == null) goto L9;
        r8.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + SubwayUtils.ALARM_DELAY_EXIT_CONFIDENCE_SCORING_MS, this.mExitAlarmPendingIntent);
        CommSenseLog.dumpI(TAG, "[ALARM] Scheduled exit fallback alarm in 90s", mSubwayLogFile);
        return;
    }

    private void scheduleFallbackAlarm() {
        AlarmManager r8 = (AlarmManager) this.mContext.getSystemService("alarm");
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mAlarmPendingIntent == null) goto L9;
        r8.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 120000, this.mAlarmPendingIntent);
        CommSenseLog.dumpI(TAG, "[ALARM] Scheduled fallback alarm in 120s", mSubwayLogFile);
        return;
    }

    private void startSensorCollectSafe(int r8) {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        UserAwareManager.getInstance().getSensorCollectManager().startSensorCollect(r8);
        CommSenseLog.dumpI(TAG, defpackage.a.d("[SENSOR_CONTROL] Started collecting sensors with mask: ", r8), mSubwayLogFile);
        return;
    }

    private void stopSensorCollectSafe() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        UserAwareManager.getInstance().getSensorCollectManager().stopSensorCollect();
        CommSenseLog.dumpI(TAG, "[SENSOR_CONTROL] Stopped collecting sensors", mSubwayLogFile);
        return;
    }

    private void triggerIndoorOutdoorCheck() {
        StarLocationService r8 = this.mStarLocationService;
        if (r8 != null) goto L15;
        CommSenseLog.w(TAG, "triggerIndoorOutdoorCheck failed: StarLocationService is not ready.");
        CaeRuntime.registerServiceReadyListener(this.mContext, StarLocationService.class, new a(this));
        return;
    L15:
    L11:
        e = move-exception;
        CommSenseLog.e(TAG, "runIndoorCheck trigger failed", e);
        return;
    L5:
        if (r8.getStarLocationServiceBinder() == null) goto L17;
        this.mStarLocationService.getStarLocationServiceBinder().runIndoorCheck(30000);     // Catch: Exception -> L11
        SubwayStateManager r10 = this.mStateManager;     // Catch: Exception -> L11
        if (r10 == null) goto L9;
        r10.onIndoorOutdoorCheckTriggered();     // Catch: Exception -> L11
    L9:
        CommSenseLog.i(TAG, "runIndoorCheck trigger success");     // Catch: Exception -> L11
        return;
    }

    private void unregisterElevatorSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        CommSenseLog.dumpI(TAG, "unregisterElevatorSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().unregisterOutElevator();
        return;
    }

    private void unregisterSubwaySensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        CommSenseLog.dumpI(TAG, "unregisterSubwaySensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().unregisterSubwaySensor();
        return;
    }

    private void unregisterUpDownStairSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        CommSenseLog.dumpI(TAG, "unregisterUpDownStairSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().unregisterUpDownStairSensor();
        return;
    }

    public void forceTriggerIndoorOutdoorCheck() {
        triggerIndoorOutdoorCheck();
    }

    public SubwayEventProcessor getEventProcessor() {
        return this.mEventProcessor;
    }

    public SubwayStateManager getStateManager() {
        return this.mStateManager;
    }

    public void init() {
        if (this.alreadyInit == false) goto L6;
        CommSenseLog.i(TAG, "SubwayFusionAware already init. v1.3.0");
        return;
    L6:
        this.alreadyInit = true;
        String r8 = TAG;
        CommSenseLog.i(r8, "SubwayFusionAware init. v1.3.0");
        SubwayContext r10 = this.mSubwayContext;
        r10.isTestMode = UserAwareUtil.isSubwayTestToolEnabled(this.mContext);
        HandlerThread r11 = new HandlerThread("SubwayFusionAwareThread");
        this.mWorkerThread = r11;
        r11.start();
        this.mWorkerHandler = new SubwayHandler(this, this.mWorkerThread.getLooper());
        registerAlarmReceiver();
        initDumpLogFile();
        SubwayStateManager r12 = new SubwayStateManager(this.mContext, this.mSubwayContext, new AnonymousClass1(this), mSubwayLogFile);
        this.mStateManager = r12;
        r12.setWorkerHandler(this.mWorkerHandler);
        this.mEventProcessor = new SubwayEventProcessor(this.mContext, this.mSubwayContext, this.mStateManager, new androidx.core.app.b(this), mSubwayLogFile);
        this.mBluetoothListener = new AnonymousClass2(this);
        SmartBluetoothAwareManager.getInstance(this.mContext).addSmartBluetoothAwareListener(this.mBluetoothListener);
        this.mAwareCallback = new AnonymousClass3(this);
        UserAwareManager.getInstance().registerInnerCallback(this.mAwareCallback);
        CaeRuntime.registerServiceReadyListener(this.mContext, StarLocationService.class, new b(this));
        initWifiConnectedState();
        initLocationState();
        initHarStatus();
        registerSubwaySensor();
        CommSenseLog.dumpI(r8, "SubwayFusionAware init complete. v1.3.0", mSubwayLogFile);
        SubwayStateManager r13 = this.mStateManager;
        if (r13 == null) goto L10;
        r13.showToast("SubwayFusionAware init complete. v1.3.0");
        return;
    }

    public void release() {
        CommSenseLog.dumpI(TAG, "SubwayFusionAware release", mSubwayLogFile);
        if (this.mBluetoothListener == null) goto L6;
        SmartBluetoothAwareManager.getInstance(this.mContext).removeSmartBluetoothAwareListener(this.mBluetoothListener);
        this.mBluetoothListener = null;
    L6:
        if (this.mAwareCallback == null) goto L9;
        UserAwareManager.getInstance().unregisterInnerCallback(this.mAwareCallback);
        this.mAwareCallback = null;
    L9:
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L11;
        UserAwareManager.getInstance().getSensorCollectManager().unregisterSubwaySensor();
    L11:
        SubwayHandler r8 = this.mWorkerHandler;
        if (r8 == null) goto L14;
        r8.removeCallbacksAndMessages(null);
        this.mWorkerHandler = null;
    L14:
        HandlerThread r10 = this.mWorkerThread;
        if (r10 == null) goto L17;
        r10.quitSafely();
        this.mWorkerThread = null;
    L17:
        cancelFallbackAlarm();
        cancelExitFallbackAlarm();
        releaseWakeLock();
        stopSensorCollectSafe();
        SubwayStateManager r11 = this.mStateManager;
        if (r11 == null) goto L20;
        r11.resetCycleStats();
    L20:
        this.alreadyInit = false;
    }
}
