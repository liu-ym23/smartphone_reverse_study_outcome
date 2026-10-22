package com.obric.cae.userAware.SubwayFusionAware;

import android.app.AlarmManager;
import android.app.PendingIntent;
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
import androidx.core.app.NotificationCompat;
import com.obric.cae.libs.location.indoor.a;
import com.obric.cae.libs.location.indoor.b;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareListener;
import com.obric.cae.userAware.btaware.SmartBluetoothAwareManager;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
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
    private final a mIndoorCheckCallback;
    private b mStarIndoorCheckManager;
    private SubwayStateManager mStateManager;
    private final SubwayContext mSubwayContext;
    private PowerManager.WakeLock mWakeLock;
    private SubwayHandler mWorkerHandler;
    private HandlerThread mWorkerThread;

    /* JADX INFO: renamed from: com.obric.cae.userAware.SubwayFusionAware.SubwayFusionAware$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = null;

        static {
            int[] r0 = new int[SubwayState.values().length];
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = r0;
            r0[SubwayState.STATE_IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
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

        public SubwayHandler(SubwayFusionAware r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r0 = r8.what;
            if (r0 != 100) goto L5;
        L10:
            boolean r1 = true;
        L11:
            if (r1 == false) goto L13;
        L15:
            int r2 = r8.what;
            switch(r2) {
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                default: goto L17;
            };
        L17:
            switch(r2) {
                case 100: goto L30;
                case 101: goto L30;
                case 102: goto L30;
                case 103: goto L29;
                case 104: goto L28;
                default: goto L18;
            };
        L18:
            com.obric.cae.log.a.g(SubwayFusionAware.access$100(), "Unknown message type: " + r8.what);
        L31:
            SubwayFusionAware.access$1100(this.this$0).evaluateCurrentState();
            return;
        L28:
            SubwayFusionAware.access$1400(this.this$0);
            goto L31
        L29:
            SubwayFusionAware.access$1300(this.this$0);
            goto L31
        L30:
            SubwayFusionAware.access$1200(this.this$0, r2);
            goto L31
        L19:
            SubwayFusionAware.access$1100(this.this$0).processSubwayCellPoiStatusChange((InnerAwareInfoCallback.CellPoiStatus) ZeusTransformUtils.preCheckCast(r8.obj, InnerAwareInfoCallback.CellPoiStatus.class, "com.obric.memorydata.plugin"));
            goto L31
        L20:
            SubwayFusionAware.access$1100(this.this$0).processStepsCounterChanged(r8.arg1);
            goto L31
        L21:
            SubwayFusionAware.access$1100(this.this$0).processIndoorOutdoorStatus(r8.arg1);
            goto L31
        L22:
            SubwayFusionAware.access$1100(this.this$0).processSharedBikeEvent(r8.arg1);
            goto L31
        L23:
            SubwayFusionAware.access$1100(this.this$0).processSensorEvent((SensorEvent) ZeusTransformUtils.preCheckCast(r8.obj, SensorEvent.class, "com.obric.memorydata.plugin"));
            goto L31
        L24:
            SubwayFusionAware.access$700(this.this$0).locationState = (String) ZeusTransformUtils.preCheckCast(r8.obj, String.class, "com.obric.memorydata.plugin");
            String r9 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"LOCATION_STATE", "state=" + SubwayFusionAware.access$700(this.this$0).locationState});
        L26:
            com.obric.cae.log.a.c(SubwayFusionAware.access$100(), r9, SubwayFusionAware.access$200());
            goto L31
        L25:
            SubwayFusionAware.access$700(this.this$0).isWifiConnected = ((Boolean) ZeusTransformUtils.preCheckCast(r8.obj, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            r9 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"WIFI_STATE", "connected=" + SubwayFusionAware.access$700(this.this$0).isWifiConnected});
            goto L26
        L27:
            SubwayFusionAware.access$1100(this.this$0).processHarStatusChanged(r8.arg1);
            goto L31
        L13:
            if (UserAwareManager.getInstance().isMemDHarEnabled() == true) goto L15;
            return;
        L5:
            if (r0 == 101) goto L10;
            if (r0 == 102) goto L10;
            r1 = false;
            goto L11
        }
    }

    private SubwayFusionAware(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.alreadyInit = false;
        this.mSubwayContext = new SubwayContext();
        this.mIndoorCheckCallback = new AnonymousClass1(this);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ SubwayHandler access$000(SubwayFusionAware r0) {
        return r0.mWorkerHandler;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ void access$1000(SubwayFusionAware r0, long r1) {
        r0.acquireWakeLock(r1);
    }

    public static /* synthetic */ SubwayEventProcessor access$1100(SubwayFusionAware r0) {
        return r0.mEventProcessor;
    }

    public static /* synthetic */ void access$1200(SubwayFusionAware r0, int r1) {
        r0.handleTimeout(r1);
    }

    public static /* synthetic */ void access$1300(SubwayFusionAware r0) {
        r0.handleEnterPeriodicIndoorCheck();
    }

    public static /* synthetic */ void access$1400(SubwayFusionAware r0) {
        r0.handleExitPeriodicTriggerEvaluation();
    }

    public static /* synthetic */ File access$200() {
        return mSubwayLogFile;
    }

    public static /* synthetic */ void access$300(SubwayFusionAware r0, SubwayState r1) {
        r0.handleStateEnter(r1);
    }

    public static /* synthetic */ void access$400(SubwayFusionAware r0, SubwayState r1) {
        r0.handleStateExit(r1);
    }

    public static /* synthetic */ Context access$500(SubwayFusionAware r0) {
        return r0.mContext;
    }

    public static /* synthetic */ SubwayStateManager access$600(SubwayFusionAware r0) {
        return r0.mStateManager;
    }

    public static /* synthetic */ SubwayContext access$700(SubwayFusionAware r0) {
        return r0.mSubwayContext;
    }

    public static /* synthetic */ void access$800(SubwayFusionAware r0) {
        r0.cancelFallbackAlarm();
    }

    public static /* synthetic */ void access$900(SubwayFusionAware r0) {
        r0.releaseWakeLock();
    }

    private synchronized void acquireWakeLock(long r4) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.mWakeLock != null) goto L8;
        PowerManager r0 = (PowerManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r0 == null) goto L8;
        this.mWakeLock = r0.newWakeLock(1, TAG + "::Wakelock");     // Catch: Throwable -> L18
    L8:
        PowerManager.WakeLock r1 = this.mWakeLock;     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
    L16:
        monitor-exit(this);
        return;
    L11:
        if (r1.isHeld() == true) goto L16;
        this.mWakeLock.acquire(r4);     // Catch: Throwable -> L18
        SubwayStateManager r2 = this.mStateManager;     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        r2.onWakeLockAcquired(r4);     // Catch: Throwable -> L18
    L15:
        com.obric.cae.log.a.c(TAG, "[WAKELOCK] WakeLock acquired for " + r4 + "ms", mSubwayLogFile);     // Catch: Throwable -> L18
        goto L16
    }

    private void cancelExitFallbackAlarm() {
        AlarmManager r0 = (AlarmManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM), AlarmManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        PendingIntent r3 = this.mExitAlarmPendingIntent;
        if (r3 == null) goto L9;
        r0.cancel(r3);
        com.obric.cae.log.a.c(TAG, "[ALARM] Cancelled exit fallback alarm", mSubwayLogFile);
        return;
    L9:
        return;
    }

    private void cancelFallbackAlarm() {
        AlarmManager r0 = (AlarmManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM), AlarmManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        PendingIntent r3 = this.mAlarmPendingIntent;
        if (r3 == null) goto L9;
        r0.cancel(r3);
        com.obric.cae.log.a.c(TAG, "[ALARM] Cancelled fallback alarm", mSubwayLogFile);
        return;
    L9:
        return;
    }

    public static SubwayFusionAware getInstance(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(SubwayFusionAware.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SubwayFusionAware((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
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

    private void handleStateEnter(SubwayState r7) {
        int r8 = AnonymousClass6.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r7.ordinal()];
        if (r8 != 1) goto L5;
        SubwayContext r9 = this.mSubwayContext;
        r9.enterStateIdleTime = System.currentTimeMillis();
    L19:
        registerSubwaySensor();
        return;
    L5:
        if (r8 != 2) goto L7;
        acquireWakeLock(20000);
        initWifiConnectedState();
        initLocationState();
        initHarStatus();
        this.mEventProcessor.evaluateCurrentState();
        return;
    L7:
        if (r8 != 3) goto L9;
        SubwayContext r10 = this.mSubwayContext;
        r10.enterStateEnterScoringTime = System.currentTimeMillis();
        acquireWakeLock(20000);
        scheduleFallbackAlarm();
        startSensorCollectSafe(3072);
        registerElevatorSensor();
        registerUpDownStairSensor();
        return;
    L9:
        if (r8 != 4) goto L11;
        SubwayContext r11 = this.mSubwayContext;
        r11.enterStateOnSubwayTime = System.currentTimeMillis();
        startSensorCollectSafe(2048);
    L15:
        registerElevatorSensor();
        registerUpDownStairSensor();
        goto L19
    L11:
        if (r8 != 5) goto L23;
        SubwayContext r12 = this.mSubwayContext;
        r12.enterStateExitScoringTime = System.currentTimeMillis();
        scheduleExitFallbackAlarm();
        startSensorCollectSafe(3072);
        goto L15
    }

    private void handleStateExit(SubwayState r2) {
        int r3 = AnonymousClass6.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r2.ordinal()];
        if (r3 != 1) goto L5;
    L17:
        unregisterSubwaySensor();
        return;
    L5:
        if (r3 != 2) goto L7;
        releaseWakeLock();
        return;
    L7:
        if (r3 != 3) goto L9;
        cancelFallbackAlarm();
        releaseWakeLock();
        stopSensorCollectSafe();
        unregisterElevatorSensor();
        unregisterUpDownStairSensor();
        return;
    L9:
        if (r3 != 4) goto L11;
    L14:
        stopSensorCollectSafe();
        unregisterElevatorSensor();
        unregisterUpDownStairSensor();
        goto L17
    L11:
        if (r3 != 5) goto L21;
        cancelExitFallbackAlarm();
        releaseWakeLock();
        goto L14
    }

    private void handleTimeout(int r6) {
        SubwayState r0 = this.mStateManager.getCurrentState();
        String r1 = String.format("[TIMEOUT] %s", new Object[]{r0});
        String r3 = TAG;
        com.obric.cae.log.a.c(r3, r1, mSubwayLogFile);
        if (r6 != 100) goto L9;
        if (r0 != SubwayState.STATE_ENTER_PRE_FILTER) goto L9;
    L6:
        SubwayStateManager r5 = this.mStateManager;
        SubwayState r7 = SubwayState.STATE_IDLE;
    L7:
        r5.transitionToState(r7);
        return;
    L9:
        if (r6 != 101) goto L14;
        if (r0 == SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L6;
    L14:
        if (r6 == 102) goto L16;
        return;
    L16:
        if (r0 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L23;
        SubwayContext r8 = this.mSubwayContext;
        if (r8.curHarStatus != 5) goto L20;
        com.obric.cae.log.a.c(r3, "Timeout but HAR is still subway, returning to STATE_ON_SUBWAY", mSubwayLogFile);
        r5 = this.mStateManager;
        r7 = SubwayState.STATE_ON_SUBWAY;
        goto L7
    L20:
        r8.isInSubwayGeofence = false;
        goto L6
    }

    private void initDumpLogFile() {
        File r1 = new File(UserAwareUtil.getLocalDir(this.mContext, KEY_FILE_SUBWAY), STR_SUBWAY_FILE);
        if (r1.exists() == true) goto L5;
    L18:
    L15:
        com.obric.cae.log.a.i(TAG, "IO error occurred!");
    L16:
        mSubwayLogFile = r1;
        com.obric.cae.log.a.c(TAG, "initDumpLogFile, file: " + mSubwayLogFile);
        com.obric.cae.log.a.a(KEY_FILE_SUBWAY, mSubwayLogFile);
        return;
    L10:
        if (r1.exists() == true) goto L16;
        if (r1.createNewFile() == true) goto L16;
        com.obric.cae.log.a.g(TAG, "Failed to create new dump file");     // Catch: IOException -> L15
        goto L16
    L5:
        if ((System.currentTimeMillis() - r1.lastModified()) <= 172800000) goto L18;
        String r6 = TAG;
        com.obric.cae.log.a.e(r6, "Dump file is older than 2 days, deleting it");
        if (r1.delete() == true) goto L18;
        com.obric.cae.log.a.g(r6, "Failed to delete old dump file");
        goto L18
    }

    private void initHarStatus() {
        if (UserAwareManager.getInstance().getOemHarInfoManager() == null) goto L6;
        this.mSubwayContext.curHarStatus = UserAwareManager.getInstance().getOemHarInfoManager().getHarLastNotifyState();
        com.obric.cae.log.a.c(TAG, "Init HAR status: " + this.mSubwayContext.curHarStatus, mSubwayLogFile);
        return;
    }

    private void initLocationState() {
        SubwayContext r1 = this.mSubwayContext;     // Catch: Exception -> L5
        Context r2 = this.mContext;     // Catch: Exception -> L5
        r1.locationState = UserAwareUtil.getHostSettingsString(r2, r2.getContentResolver(), "user_location_state");     // Catch: Exception -> L5
        com.obric.cae.log.a.c(TAG, "Init location state: " + this.mSubwayContext.locationState, mSubwayLogFile);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "Failed to get initial location state", e);
    }

    private void initWifiConnectedState() {
        WifiAwareInfoManager r0 = WifiAwareInfoManager.getInstance(this.mContext);
        if (r0 == null) goto L10;
        SubwayContext r1 = this.mSubwayContext;
        boolean r2 = true;
        if (r0.getWifiConnectionState() == 1) goto L8;
        r2 = false;
    L8:
        r1.isWifiConnected = r2;
        com.obric.cae.log.a.c(TAG, "Init wifi connected state: " + this.mSubwayContext.isWifiConnected, mSubwayLogFile);
        return;
    }

    /* JADX INFO: renamed from: lambda$ZeUcT31ptNZimC-qc0puM663Twk, reason: not valid java name */
    public static /* synthetic */ void m403lambda$ZeUcT31ptNZimCqc0puM663Twk(SubwayFusionAware r0, String r1) {
        r0.triggerIndoorOutdoorCheck(r1);
    }

    private void registerAlarmReceiver() {
        PluginBroadcastReceiver r0 = new AnonymousClass5(this);
        IntentFilter r1 = new IntentFilter(ACTION_ALARM_ENTER_CONFIDENCE_SCORING);
        r1.addAction(ACTION_ALARM_EXIT_CONFIDENCE_SCORING);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        ZeusTransformUtils.registerReceiver(this.mContext, r0, r1, 4, "com.obric.memorydata.plugin");
    L6:
        Intent r2 = new Intent(ACTION_ALARM_ENTER_CONFIDENCE_SCORING);
        this.mAlarmPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, r2, 201326592);
        Intent r3 = new Intent(ACTION_ALARM_EXIT_CONFIDENCE_SCORING);
        this.mExitAlarmPendingIntent = PendingIntent.getBroadcast(this.mContext, 1, r3, 201326592);
        return;
    L5:
        ZeusTransformUtils.registerReceiver(this.mContext, r0, r1, "com.obric.memorydata.plugin");
        goto L6
    }

    private void registerElevatorSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        com.obric.cae.log.a.c(TAG, "registerElevatorSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().registerOutElevator();
        return;
    }

    private void registerSubwaySensor() {
        String r2 = TAG;
        com.obric.cae.log.a.e(r2, "registerSubwaySensor");
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        com.obric.cae.log.a.c(r2, "registerSubwaySensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().registerSubwaySensor();
        return;
    }

    private void registerUpDownStairSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        com.obric.cae.log.a.c(TAG, "registerUpDownStairSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().registerUpDownStairSensor();
        return;
    }

    private synchronized void releaseWakeLock() {
        monitor-enter(this);
        PowerManager.WakeLock r0 = this.mWakeLock;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (r0.isHeld() == false) goto L11;
        SubwayStateManager r1 = this.mStateManager;     // Catch: Throwable -> L13
        if (r1 == null) goto L10;
        r1.onWakeLockReleased();     // Catch: Throwable -> L13
    L10:
        this.mWakeLock.release();     // Catch: Throwable -> L13
        this.mWakeLock = null;     // Catch: Throwable -> L13
        com.obric.cae.log.a.c(TAG, "[WAKELOCK] WakeLock released", mSubwayLogFile);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void scheduleExitFallbackAlarm() {
        AlarmManager r0 = (AlarmManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM), AlarmManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mExitAlarmPendingIntent == null) goto L9;
        r0.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + SubwayUtils.ALARM_DELAY_EXIT_CONFIDENCE_SCORING_MS, this.mExitAlarmPendingIntent);
        com.obric.cae.log.a.c(TAG, "[ALARM] Scheduled exit fallback alarm in 90s", mSubwayLogFile);
        return;
    }

    private void scheduleFallbackAlarm() {
        AlarmManager r0 = (AlarmManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM), AlarmManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mAlarmPendingIntent == null) goto L9;
        r0.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 120000, this.mAlarmPendingIntent);
        com.obric.cae.log.a.c(TAG, "[ALARM] Scheduled fallback alarm in 120s", mSubwayLogFile);
        return;
    }

    private void startSensorCollectSafe(int r3) {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        UserAwareManager.getInstance().getSensorCollectManager().startSensorCollect(r3);
        com.obric.cae.log.a.c(TAG, "[SENSOR_CONTROL] Started collecting sensors with mask: " + r3, mSubwayLogFile);
        return;
    }

    private void stopSensorCollectSafe() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        UserAwareManager.getInstance().getSensorCollectManager().stopSensorCollect();
        com.obric.cae.log.a.c(TAG, "[SENSOR_CONTROL] Stopped collecting sensors", mSubwayLogFile);
        return;
    }

    private void triggerIndoorOutdoorCheck(final String r4) {
        b r1 = this.mStarIndoorCheckManager;
        if (r1 != null) goto L13;
        com.obric.cae.log.a.g(TAG, "triggerIndoorOutdoorCheck failed: StarLocationService is not ready.");
        com.obric.cae.runtime.a.a(this.mContext, StarLocationService.class, new $$Lambda$SubwayFusionAware$hawvlGlXhwSCQmKfQHuiUpGvME(this, r4));
        return;
    L13:
        r1.a(this.mIndoorCheckCallback, r4);     // Catch: Exception -> L9
        SubwayStateManager r3 = this.mStateManager;     // Catch: Exception -> L9
        if (r3 == null) goto L7;
        r3.onIndoorOutdoorCheckTriggered();     // Catch: Exception -> L9
    L7:
        com.obric.cae.log.a.e(TAG, "runIndoorCheckAsync trigger success, reason=" + r4);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "runIndoorCheckAsync trigger failed", e);
    }

    private void unregisterElevatorSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        com.obric.cae.log.a.c(TAG, "unregisterElevatorSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().unregisterOutElevator();
        return;
    }

    private void unregisterSubwaySensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        com.obric.cae.log.a.c(TAG, "unregisterSubwaySensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().unregisterSubwaySensor();
        return;
    }

    private void unregisterUpDownStairSensor() {
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L6;
        com.obric.cae.log.a.c(TAG, "unregisterUpDownStairSensor", mSubwayLogFile);
        UserAwareManager.getInstance().getSensorCollectManager().unregisterUpDownStairSensor();
        return;
    }

    public void forceTriggerIndoorOutdoorCheck() {
        triggerIndoorOutdoorCheck("SubwayFusionTestTool");
    }

    public SubwayEventProcessor getEventProcessor() {
        return this.mEventProcessor;
    }

    public SubwayStateManager getStateManager() {
        return this.mStateManager;
    }

    public void init() {
        if (this.alreadyInit == false) goto L6;
        com.obric.cae.log.a.e(TAG, "SubwayFusionAware already init. v1.3.0");
        return;
    L6:
        this.alreadyInit = true;
        String r0 = TAG;
        com.obric.cae.log.a.e(r0, "SubwayFusionAware init. v1.3.0");
        SubwayContext r1 = this.mSubwayContext;
        r1.isTestMode = UserAwareUtil.isSubwayTestToolEnabled(this.mContext);
        HandlerThread r2 = new HandlerThread("SubwayFusionAwareThread");
        this.mWorkerThread = r2;
        r2.start();
        this.mWorkerHandler = new SubwayHandler(this, this.mWorkerThread.getLooper());
        registerAlarmReceiver();
        initDumpLogFile();
        SubwayStateManager r3 = new SubwayStateManager(this.mContext, this.mSubwayContext, new AnonymousClass2(this), mSubwayLogFile);
        this.mStateManager = r3;
        r3.setWorkerHandler(this.mWorkerHandler);
        this.mEventProcessor = new SubwayEventProcessor(this.mContext, this.mSubwayContext, this.mStateManager, new $$Lambda$SubwayFusionAware$ZeUcT31ptNZimCqc0puM663Twk(this), mSubwayLogFile);
        this.mBluetoothListener = new AnonymousClass3(this);
        SmartBluetoothAwareManager.getInstance(this.mContext).addSmartBluetoothAwareListener(this.mBluetoothListener);
        this.mAwareCallback = new AnonymousClass4(this);
        UserAwareManager.getInstance().registerInnerCallback(this.mAwareCallback);
        com.obric.cae.runtime.a.a(this.mContext, StarLocationService.class, new $$Lambda$SubwayFusionAware$7pBFDV2QgcVlclkuPpwpFEov50s(this));
        initWifiConnectedState();
        initLocationState();
        initHarStatus();
        registerSubwaySensor();
        com.obric.cae.log.a.c(r0, "SubwayFusionAware init complete. v1.3.0", mSubwayLogFile);
        SubwayStateManager r9 = this.mStateManager;
        if (r9 == null) goto L10;
        r9.showToast("SubwayFusionAware init complete. v1.3.0");
        return;
    }

    public /* synthetic */ void lambda$init$0$SubwayFusionAware(Context r3, StarLocationService r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        StarLocationService r6 = (StarLocationService) ZeusTransformUtils.wrapperContextForParams(r4, StarLocationService.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "register indoor check callback failed", e);
    L11:
        com.obric.cae.log.a.c(TAG, "StarLocationService is ready and cached.", mSubwayLogFile);
        return;
    L4:
        if (r6.a() == null) goto L11;
        b r7 = r6.a().j();     // Catch: Exception -> L9
        this.mStarIndoorCheckManager = r7;     // Catch: Exception -> L9
        if (r7 == null) goto L11;
        r7.a(this.mIndoorCheckCallback);     // Catch: Exception -> L9
        goto L11
    }

    public /* synthetic */ void lambda$triggerIndoorOutdoorCheck$1$SubwayFusionAware(String r3, Context r4, StarLocationService r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        StarLocationService r7 = (StarLocationService) ZeusTransformUtils.wrapperContextForParams(r5, StarLocationService.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "runIndoorCheckAsync delayed trigger failed", e);
        return;
    L4:
        if (r7.a() == null) goto L17;
        b r8 = r7.a().j();     // Catch: Exception -> L12
        this.mStarIndoorCheckManager = r8;     // Catch: Exception -> L12
        if (r8 == null) goto L18;
        r8.a(this.mIndoorCheckCallback, r3);     // Catch: Exception -> L12
        SubwayStateManager r2 = this.mStateManager;     // Catch: Exception -> L12
        if (r2 == null) goto L10;
        r2.onIndoorOutdoorCheckTriggered();     // Catch: Exception -> L12
    L10:
        com.obric.cae.log.a.c(TAG, "runIndoorCheckAsync delayed trigger success, reason=" + r3);     // Catch: Exception -> L12
        return;
    L18:
        return;
    }

    public void release() {
        com.obric.cae.log.a.c(TAG, "SubwayFusionAware release", mSubwayLogFile);
        b r0 = this.mStarIndoorCheckManager;
        if (r0 == null) goto L10;
        r0.a();     // Catch: Exception -> L6
    L8:
        this.mStarIndoorCheckManager = null;
    L6:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "unregister indoor check callback failed", e);
    L10:
        if (this.mBluetoothListener == null) goto L13;
        SmartBluetoothAwareManager.getInstance(this.mContext).removeSmartBluetoothAwareListener(this.mBluetoothListener);
        this.mBluetoothListener = null;
    L13:
        if (this.mAwareCallback == null) goto L16;
        UserAwareManager.getInstance().unregisterInnerCallback(this.mAwareCallback);
        this.mAwareCallback = null;
    L16:
        if (UserAwareManager.getInstance().getSensorCollectManager() == null) goto L18;
        UserAwareManager.getInstance().getSensorCollectManager().unregisterSubwaySensor();
    L18:
        SubwayHandler r1 = this.mWorkerHandler;
        if (r1 == null) goto L21;
        r1.removeCallbacksAndMessages(null);
        this.mWorkerHandler = null;
    L21:
        HandlerThread r2 = this.mWorkerThread;
        if (r2 == null) goto L24;
        r2.quitSafely();
        this.mWorkerThread = null;
    L24:
        cancelFallbackAlarm();
        cancelExitFallbackAlarm();
        releaseWakeLock();
        stopSensorCollectSafe();
        SubwayStateManager r3 = this.mStateManager;
        if (r3 == null) goto L27;
        r3.resetCycleStats();
    L27:
        this.alreadyInit = false;
    }
}
