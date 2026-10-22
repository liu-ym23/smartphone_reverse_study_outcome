package com.obric.cae.userAware;

import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.obric.cae.libs.statemachine.e;
import com.obric.cae.libs.useraware.SensorEventInfo;
import com.obric.cae.location.a;
import com.obric.cae.location.cell.b;
import com.obric.cae.location.report.d;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class SensorCollectManager implements SensorEventListener {
    public static final String ACTION_SLEEP_MODE_CHANGED = "com.bytedanceos.action.SLEEP_MODE_CHANGED";
    public static final int ESCALATOR_DOWN = 4;
    public static final int ESCALATOR_UP = 3;
    public static final int IN_ELEVATOR = 1;
    public static final int OUT_ELEVATOR = 2;
    public static final int SENSOR_TYPE_ELEVATOR = 33171014;
    public static final int SENSOR_TYPE_FLIGHT_MODE = 33171018;
    public static final int SENSOR_TYPE_UP_DOWN = 33171019;
    public static final int STAIR_DOWN = 2;
    public static final int STAIR_UP = 1;
    public static final int STATE_FLYING = 1;
    public static final int STATE_GROUND = 0;
    public static final int STATE_PRE_LANDING = 2;
    public static final int STATE_UNKNOWN = -1;
    public static final String TAG = "SensorCollectManager";
    private static SensorCollectManager sInstance;
    private final Sensor mAccelerometer;
    private final PluginBroadcastReceiver mActionReceiver;
    private Handler mAlwaysOnSensorHandler;
    private HandlerThread mAlwaysOnSensorHandlerThread;
    private final b.a mCellPoiListener;
    private final AtomicBoolean mCellPoiListenerRegistered;
    private final Context mContext;
    private a.C0349a mFlightModeFlyPrevLocation;
    private long mFlightModeFlyTimestamp;
    private long mFlightModeGroundTimestamp;
    private final InnerAwareInfoCallback mFlightModeLocationCallback;
    private final Object mFlightModeReportLock;
    private final Sensor mFlightModeSensor;
    private final FlightModeStateManager mFlightModeStateManager;
    private boolean mFlightModeWaitingGroundLocation;
    private final Sensor mGyroscope;
    private final AtomicBoolean mIsSensorRecording;
    private a.C0349a mLastLocationSource;
    private final Sensor mLightSensor;
    private final Sensor mLinearAcceleration;
    private final Sensor mMagneticField;
    private final NearElevator mNearElevator;
    private final Sensor mOrientation;
    private final Sensor mOutElevator;
    private final Sensor mPressure;
    private final Sensor mProximity;
    private final Sensor mRotationVector;
    private String mSensorCollectFileKey;
    private SensorCollectMonitor mSensorCollectMonitor;
    private File mSensorEventsFile;
    private Handler mSensorHandler;
    private HandlerThread mSensorHandlerThread;
    private final SensorManager mSensorManager;
    private final AtomicInteger mSensorMask;
    private final ExecutorService mSensorThreadPool;
    private final Sensor mUpDownStairSensor;
    private final AtomicInteger mUpDownStairSensorRefCount;
    private final Sensor mUserStepsCounter;

    public static final class FlightModeStateManager {
        private int mCurrentState;
        private boolean mShouldIgnoreFirstEvent;

        private FlightModeStateManager() {
            this.mCurrentState = -1;
            this.mShouldIgnoreFirstEvent = true;
        }

        public /* synthetic */ FlightModeStateManager(AnonymousClass1 r1) {
            this();
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.mCurrentState = -1;     // Catch: Throwable -> L7
            this.mShouldIgnoreFirstEvent = true;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized boolean shouldDispatch(int r6) {
            monitor-enter(this);
            int r1 = -1;
            if (this.mShouldIgnoreFirstEvent == false) goto L8;
            this.mShouldIgnoreFirstEvent = false;     // Catch: Throwable -> L35
            this.mCurrentState = -1;     // Catch: Throwable -> L35
            com.obric.cae.log.a.c(SensorCollectManager.TAG, "ignore first flight mode event: " + SensorCollectManager.stateToString(r6) + ", currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L35
            monitor-exit(this);
            return false;
        L8:
            if (r6 != (-1)) goto L12;
            com.obric.cae.log.a.c(SensorCollectManager.TAG, "ignore unknown flight mode event");     // Catch: Throwable -> L35
            monitor-exit(this);
            return false;
        L12:
            int r0 = this.mCurrentState;     // Catch: Throwable -> L35
            if (r6 != r0) goto L18;
            com.obric.cae.log.a.c(SensorCollectManager.TAG, "ignore duplicate flight mode event: " + SensorCollectManager.stateToString(r6));     // Catch: Throwable -> L35
            monitor-exit(this);
            return false;
        L18:
            if (r6 != 2) goto L23;
            if (r0 == 1) goto L23;
            com.obric.cae.log.a.c(SensorCollectManager.TAG, "ignore pre-landing flight mode event, currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L35
            monitor-exit(this);
            return false;
        L23:
            if (r6 != 0) goto L29;
            if (r0 == 1) goto L29;
            if (r0 == 2) goto L29;
            com.obric.cae.log.a.c(SensorCollectManager.TAG, "ignore ground flight mode event, currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L35
            this.mCurrentState = -1;     // Catch: Throwable -> L35
            monitor-exit(this);
            return false;
        L29:
            if (r6 == 0) goto L32;
            r1 = r6;
        L32:
            this.mCurrentState = r1;     // Catch: Throwable -> L35
            com.obric.cae.log.a.e(SensorCollectManager.TAG, "flight mode state changed: " + SensorCollectManager.stateToString(r0) + " -> " + SensorCollectManager.stateToString(r6) + ", currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L35
            monitor-exit(this);
            return true;
        L35:
            th = move-exception;
            throw th;
        }
    }

    private SensorCollectManager(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.mSensorMask = new AtomicInteger(0);
        this.mSensorCollectFileKey = "";
        this.mSensorThreadPool = Executors.newCachedThreadPool();
        this.mIsSensorRecording = new AtomicBoolean(false);
        this.mUpDownStairSensorRefCount = new AtomicInteger(0);
        this.mCellPoiListenerRegistered = new AtomicBoolean(false);
        this.mCellPoiListener = $$Lambda$SensorCollectManager$v7H5asnK6BEu6jY_KQCrO5FTPUI.INSTANCE;
        this.mFlightModeStateManager = new FlightModeStateManager(null);
        Object r0 = new Object();
        this.mFlightModeReportLock = r0;
        this.mFlightModeLocationCallback = new AnonymousClass1(this);
        this.mActionReceiver = new AnonymousClass2(this);
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        initSensorEventsFile();
        this.mNearElevator = NearElevator.getInstance(r7);
        SensorManager r2 = (SensorManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("sensor"), SensorManager.class, "com.obric.memorydata.plugin");
        this.mSensorManager = r2;
        this.mAccelerometer = r2.getDefaultSensor(1, false);
        this.mGyroscope = r2.getDefaultSensor(4, false);
        this.mLinearAcceleration = r2.getDefaultSensor(10, false);
        this.mMagneticField = r2.getDefaultSensor(2, false);
        this.mUserStepsCounter = r2.getDefaultSensor(19, false);
        this.mLightSensor = r2.getDefaultSensor(5, false);
        this.mPressure = r2.getDefaultSensor(6, false);
        this.mOutElevator = r2.getDefaultSensor(SENSOR_TYPE_ELEVATOR, true);
        this.mUpDownStairSensor = r2.getDefaultSensor(SENSOR_TYPE_UP_DOWN, true);
        this.mFlightModeSensor = r2.getDefaultSensor(SENSOR_TYPE_FLIGHT_MODE, false);
        this.mOrientation = r2.getDefaultSensor(3, false);
        this.mRotationVector = r2.getDefaultSensor(11, false);
        this.mProximity = r2.getDefaultSensor(8, true);
        d.a(r7);
        monitor-enter(r0);
        this.mLastLocationSource = a.a().c();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        registerFlightModeSensor();
        registerSleepModeReceiver(r7);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$100(SensorCollectManager r0, a.C0349a r1) {
        r0.handleLocationSourceChanged(r1);
    }

    public static /* synthetic */ AtomicInteger access$200(SensorCollectManager r0) {
        return r0.mSensorMask;
    }

    private synchronized Handler ensureAlwaysOnSensorHandler() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mAlwaysOnSensorHandlerThread != null) goto L6;
        HandlerThread r0 = new HandlerThread("SensorCollectManagerAlwaysOn");     // Catch: Throwable -> L9
        this.mAlwaysOnSensorHandlerThread = r0;     // Catch: Throwable -> L9
        r0.start();     // Catch: Throwable -> L9
        this.mAlwaysOnSensorHandler = new Handler(this.mAlwaysOnSensorHandlerThread.getLooper());     // Catch: Throwable -> L9
    L6:
        Handler r1 = this.mAlwaysOnSensorHandler;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    }

    public static SensorCollectManager getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(SensorCollectManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SensorCollectManager(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SensorCollectManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handleFlightModeStateForReport(int r8) {
        Object r0 = this.mFlightModeReportLock;
        monitor-enter(r0);
        if (r8 != 1) goto L14;
        d.a();     // Catch: Throwable -> L12
        this.mFlightModeFlyTimestamp = System.currentTimeMillis();     // Catch: Throwable -> L12
        a.C0349a r9 = this.mLastLocationSource;     // Catch: Throwable -> L12
        if (r9 != null) goto L9;
        a.C0349a r10 = null;
    L10:
        this.mFlightModeFlyPrevLocation = r10;     // Catch: Throwable -> L12
        this.mFlightModeGroundTimestamp = 0;     // Catch: Throwable -> L12
    L11:
        this.mFlightModeWaitingGroundLocation = false;     // Catch: Throwable -> L12
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        r10 = r9.a();     // Catch: Throwable -> L12
        goto L10
    L14:
        if (r8 != 0) goto L18;
        if (this.mFlightModeFlyTimestamp <= 0) goto L11;
        this.mFlightModeGroundTimestamp = System.currentTimeMillis();     // Catch: Throwable -> L12
        this.mFlightModeWaitingGroundLocation = true;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void handleLocationSourceChanged(a.C0349a r20) {
        Object r1 = this.mFlightModeReportLock;
        monitor-enter(r1);
        a.C0349a r2 = r20.a();     // Catch: Throwable -> L17
        this.mLastLocationSource = r2;     // Catch: Throwable -> L17
        if (this.mFlightModeWaitingGroundLocation == true) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L8:
        long r4 = this.mFlightModeFlyTimestamp;     // Catch: Throwable -> L17
        long r7 = this.mFlightModeGroundTimestamp;     // Catch: Throwable -> L17
        a.C0349a r3 = this.mFlightModeFlyPrevLocation;     // Catch: Throwable -> L17
        if (r3 != null) goto L13;
        this.mFlightModeFlyTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeGroundTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeWaitingGroundLocation = false;     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L13:
        a.C0349a r5 = r3.a();     // Catch: Throwable -> L17
        a.C0349a r6 = r2.a();     // Catch: Throwable -> L17
        this.mFlightModeFlyTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeGroundTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeFlyPrevLocation = null;     // Catch: Throwable -> L17
        this.mFlightModeWaitingGroundLocation = false;     // Catch: Throwable -> L17
        int r10 = (int) com.obric.cae.location.util.d.a().a(r5.e(), r5.f(), r6.e(), r6.f());     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        d.a(r4, r5, r7, r6, r10);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void initSensorEventsFile() {
        File r0 = new File(UserAwareUtil.getLocalDir(this.mContext, "sensor"), "sensor_events.log");
        r0.delete();
        r0.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mSensorEventsFile = r0;
        com.obric.cae.log.a.c(TAG, "initSensorEventsFile, file: " + this.mSensorEventsFile);
        com.obric.cae.log.a.a("sensor_events", this.mSensorEventsFile);
        return;
    L5:
        com.obric.cae.log.a.i(TAG, "IO error occurred!");
        goto L6
    }

    static /* synthetic */ void lambda$new$0(int r12, int r13, int r14, long r15, int r17, String r18) {
        com.obric.cae.log.a.e(TAG, e.a(com.obric.cae.location.b.a("onCellPoiStatusChange: cellPoiType=", r12, " rat=", r13, " tac="), r14, " pci=", r17, " cellid=").append(r15).append(" stationName=").append(r18).toString());
        InnerAwareInfoCallback.CellPoiStatus r0 = new InnerAwareInfoCallback.CellPoiStatus(r12, r13, r14, r15, r17, r18);
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$ZTaN9HtPNu7TNNExG9CYIXEVxuU.INSTANCE, r0);
    }

    private int normalizeFlightModeState(int r1) {
        if (r1 != 0) goto L4;
    L10:
        return r1;
    L4:
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        return -1;
    }

    private void registerFlightModeSensor() {
        String r0 = TAG;
        com.obric.cae.log.a.e(r0, "registerFlightModeSensor");
        if (this.mFlightModeSensor != null) goto L6;
        com.obric.cae.log.a.g(r0, "flight mode sensor not found");
        return;
    L6:
        this.mFlightModeStateManager.reset();
        Handler r1 = ensureAlwaysOnSensorHandler();
        if (this.mSensorManager.registerListener(this, this.mFlightModeSensor, 1, r1) == true) goto L10;
        com.obric.cae.log.a.g(r0, "registerFlightModeSensor failed");
        return;
    }

    private void registerSleepModeReceiver(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        IntentFilter r0 = new IntentFilter();
        r0.addAction(ACTION_SLEEP_MODE_CHANGED);
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        ZeusTransformUtils.registerReceiver(r5, this.mActionReceiver, r0, 2, "com.obric.memorydata.plugin");
    }

    public static String stateToString(int r1) {
        if (r1 != 0) goto L4;
        return "ground";
    L4:
        if (r1 != 1) goto L6;
        return "flying";
    L6:
        if (r1 == 2) goto L9;
        return "unknown";
    L9:
        return "pre_landing";
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r12) {
        if (r12 == null) goto L53;
        float[] r1 = r12.values;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.length != 0) goto L10;
        return;
    L10:
        if (r12.sensor.getType() != 33171014) goto L23;
        String r2 = TAG;
        if (((int) r12.values[0]) != 2) goto L14;
        String r3 = "out elevator";
    L15:
        com.obric.cae.log.a.e(r2, "elevator event: ".concat(r3));
        NearElevator r4 = this.mNearElevator;
        if (r4 != null) goto L18;
        com.obric.cae.log.a.i(r2, "mNearElevator is null");
        goto L23
    L18:
        if (((int) r12.values[0]) != 2) goto L20;
        r4.outElevatorEvent();
        goto L23
    L20:
        r4.inElevatorEvent();
        goto L23
    L14:
        r3 = "in elevator";
    L23:
        if (r12.sensor.getType() != 33171018) goto L29;
        int r13 = normalizeFlightModeState((int) r12.values[0]);
        com.obric.cae.log.a.e(TAG, "flight mode event: " + stateToString(r13));
        if (this.mFlightModeStateManager.shouldDispatch(r13) == true) goto L27;
        return;
    L27:
        handleFlightModeStateForReport(r13);
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$y6bHYAMmkgmErsRG3uAAgrvuPqI.INSTANCE, Integer.valueOf(r13));
        return;
    L29:
        SensorEventInfo r5 = new SensorEventInfo(r12.sensor.getName(), r12.sensor.getType(), r12.accuracy, r12.timestamp, r12.values);
        if (r12.sensor.getType() != 19) goto L33;
        this.mSensorCollectMonitor.onStepsCounterChanged((int) r12.values[0]);
        com.obric.cae.log.a.c(TAG, r5.toString(), this.mSensorEventsFile);
    L38:
        UserAwareManager r0 = UserAwareManager.getInstance();
        if (r0.isRecording() == false) goto L41;
    L46:
        com.obric.cae.log.a.b(r5.toString(), com.obric.cae.log.a.b(this.mSensorCollectFileKey));
    L47:
        r0.postHarLevel2Data(r5);
        SensorCollectMonitor r11 = this.mSensorCollectMonitor;
        if (r11 == null) goto L55;
        r11.onSensorDataChanged(r12);
        return;
    L55:
        return;
    L41:
        if (r0.isRecordingByCallback() == true) goto L46;
        if (r0.isHarLevel2DataRecording() == false) goto L47;
        if (AwareStateListener.isHarCollectLocal() == false) goto L47;
    L33:
        if (r12.sensor.getType() != 11) goto L38;
        float[] r9 = new float[9];
        com.obric.cae.log.a.c(TAG, "rotation matrix sensor name: " + r12.sensor.getName());     // Catch: IllegalArgumentException -> L37
        SensorManager.getRotationMatrixFromVector(r9, r12.values);     // Catch: IllegalArgumentException -> L37
        r5 = new SensorEventInfo("RotationMatrix", r12.sensor.getType(), r12.accuracy, r12.timestamp, r9);     // Catch: IllegalArgumentException -> L37
    L37:
        com.obric.cae.log.a.i(TAG, "Invalid rotation vector data");
        goto L38
    }

    public void recordSensorFile(String r1, File r2) {
        this.mSensorCollectFileKey = r1;
        com.obric.cae.log.a.a(r1, r2);
    }

    public void registerOutElevator() {
        com.obric.cae.log.a.e(TAG, "registerOutElevator");
        Handler r0 = ensureAlwaysOnSensorHandler();
        this.mSensorManager.registerListener(this, this.mOutElevator, 1, r0);
        AtomicInteger r4 = this.mSensorMask;
        r4.set(r4.get() | 4096);
    }

    public void registerSensorCollectMonitor(SensorCollectMonitor r3) {
        SensorCollectMonitor r4 = (SensorCollectMonitor) ZeusTransformUtils.wrapperContextForParams(r3, SensorCollectMonitor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        com.obric.cae.log.a.g(TAG, "registerSensorCollectMonitor monitor is null");
        return;
    L6:
        this.mSensorCollectMonitor = r4;
        UserAwareManager.getInstance().registerInnerCallback(this.mFlightModeLocationCallback);
    }

    public void registerStepsCounter() {
        Handler r0 = ensureAlwaysOnSensorHandler();
        this.mSensorManager.registerListener(this, this.mUserStepsCounter, 1, r0);
        AtomicInteger r4 = this.mSensorMask;
        r4.set(r4.get() | 512);
    }

    public void registerSubwaySensor() {
        com.obric.cae.log.a.e(TAG, "registerSubwaySensor");
        if (this.mCellPoiListenerRegistered.compareAndSet(false, true) == false) goto L6;
        b.a().a(this.mCellPoiListener);
        return;
    }

    public void registerUpDownStairSensor() {
        if (this.mUpDownStairSensor != null) goto L6;
        com.obric.cae.log.a.g(TAG, "up down stair sensor not found");
        return;
    L6:
        int r0 = this.mUpDownStairSensorRefCount.getAndIncrement();
        String r1 = TAG;
        com.obric.cae.log.a.e(r1, "registerUpDownStairSensor refCount=" + (r0 + 1));
        if (r0 <= 0) goto L10;
        return;
    L10:
        if (this.mSensorManager.registerListener(this, this.mUpDownStairSensor, 1, ensureAlwaysOnSensorHandler()) == true) goto L13;
        this.mUpDownStairSensorRefCount.decrementAndGet();
        com.obric.cae.log.a.g(r1, "registerUpDownStairSensor failed");
        return;
    }

    public void startSensorCollect(int r8) {
        if (r8 != 0) goto L6;
        com.obric.cae.log.a.c(TAG, "startSensorCollect mask is 0");
        return;
    L6:
        if (this.mIsSensorRecording.get() == false) goto L10;
        com.obric.cae.log.a.g(TAG, "sensor is already recording");
        return;
    L10:
        if (r8 == this.mSensorMask.get()) goto L12;
        com.obric.cae.log.a.e(TAG, "startSensorCollect mask from " + String.format("0x%08x", new Object[]{Integer.valueOf(this.mSensorMask.get())}) + " to " + String.format("0x%08x", new Object[]{Integer.valueOf(r8)}));
        stopSensorCollect();
    L12:
        HandlerThread r0 = new HandlerThread("SensorCollectManager");
        this.mSensorHandlerThread = r0;
        r0.start();
        Handler r1 = new Handler(this.mSensorHandlerThread.getLooper());
        this.mSensorHandler = r1;
        if ((r8 & 32) != 32) goto L16;
        this.mSensorManager.registerListener(this, this.mAccelerometer, 1, r1);
        AtomicInteger r2 = this.mSensorMask;
        r2.set(r2.get() | 32);
    L16:
        if ((r8 & 64) != 64) goto L19;
        this.mSensorManager.registerListener(this, this.mLinearAcceleration, 1, this.mSensorHandler);
        AtomicInteger r3 = this.mSensorMask;
        r3.set(64 | r3.get());
    L19:
        if ((r8 & 128) != 128) goto L22;
        this.mSensorManager.registerListener(this, this.mGyroscope, 1, this.mSensorHandler);
        AtomicInteger r4 = this.mSensorMask;
        r4.set(128 | r4.get());
    L22:
        if ((r8 & 256) != 256) goto L25;
        this.mSensorManager.registerListener(this, this.mMagneticField, 1, this.mSensorHandler);
        AtomicInteger r5 = this.mSensorMask;
        r5.set(256 | r5.get());
    L25:
        if ((r8 & 512) != 512) goto L28;
        AtomicInteger r6 = this.mSensorMask;
        r6.set(512 | r6.get());
    L28:
        if ((r8 & 1024) != 1024) goto L31;
        this.mSensorManager.registerListener(this, this.mLightSensor, 1, this.mSensorHandler);
        AtomicInteger r7 = this.mSensorMask;
        r7.set(1024 | r7.get());
    L31:
        if ((r8 & 2048) != 2048) goto L34;
        this.mSensorManager.registerListener(this, this.mPressure, 1, this.mSensorHandler);
        AtomicInteger r9 = this.mSensorMask;
        r9.set(2048 | r9.get());
    L34:
        if ((r8 & 8192) != 8192) goto L37;
        this.mSensorManager.registerListener(this, this.mOrientation, 1, this.mSensorHandler);
        AtomicInteger r10 = this.mSensorMask;
        r10.set(8192 | r10.get());
    L37:
        if ((r8 & 16384) != 16384) goto L40;
        this.mSensorManager.registerListener(this, this.mProximity, 1, this.mSensorHandler);
        AtomicInteger r11 = this.mSensorMask;
        r11.set(16384 | r11.get());
    L40:
        if ((r8 & 32768) != 32768) goto L42;
        this.mSensorManager.registerListener(this, this.mRotationVector, 1, this.mSensorHandler);
        AtomicInteger r12 = this.mSensorMask;
        r12.set(32768 | r12.get());
    L42:
        this.mIsSensorRecording.set(true);
    }

    public void stopSensorCollect() {
        if (this.mIsSensorRecording.get() == true) goto L6;
        com.obric.cae.log.a.g(TAG, "sensor is not recording");
        return;
    L6:
        this.mIsSensorRecording.set(false);
        int r0 = this.mSensorMask.get();
        com.obric.cae.log.a.c(TAG, "stopSensorCollect mask: " + String.format("0x%08x", new Object[]{Integer.valueOf(r0)}));
        if ((r0 & 32) != 32) goto L10;
        this.mSensorManager.unregisterListener(this, this.mAccelerometer);
        AtomicInteger r1 = this.mSensorMask;
        r1.set(r1.get() & (-33));
    L10:
        if ((r0 & 64) != 64) goto L13;
        this.mSensorManager.unregisterListener(this, this.mLinearAcceleration);
        AtomicInteger r2 = this.mSensorMask;
        r2.set(r2.get() & (-65));
    L13:
        if ((r0 & 128) != 128) goto L16;
        this.mSensorManager.unregisterListener(this, this.mGyroscope);
        AtomicInteger r3 = this.mSensorMask;
        r3.set(r3.get() & (-129));
    L16:
        if ((r0 & 256) != 256) goto L19;
        this.mSensorManager.unregisterListener(this, this.mMagneticField);
        AtomicInteger r4 = this.mSensorMask;
        r4.set(r4.get() & (-257));
    L19:
        if ((r0 & 512) != 512) goto L22;
        AtomicInteger r5 = this.mSensorMask;
        r5.set(r5.get() & NetError.ERR_TTNET_FT_INVALID_STREAM);
    L22:
        if ((r0 & 1024) != 1024) goto L25;
        this.mSensorManager.unregisterListener(this, this.mLightSensor);
        AtomicInteger r6 = this.mSensorMask;
        r6.set(r6.get() & (-1025));
    L25:
        if ((r0 & 2048) != 2048) goto L28;
        this.mSensorManager.unregisterListener(this, this.mPressure);
        AtomicInteger r7 = this.mSensorMask;
        r7.set(r7.get() & (-2049));
    L28:
        if ((r0 & 8192) != 8192) goto L31;
        this.mSensorManager.unregisterListener(this, this.mOrientation);
        AtomicInteger r8 = this.mSensorMask;
        r8.set(r8.get() & (-8193));
    L31:
        if ((r0 & 16384) != 16384) goto L34;
        this.mSensorManager.unregisterListener(this, this.mProximity);
        AtomicInteger r9 = this.mSensorMask;
        r9.set(r9.get() & (-16385));
    L34:
        if ((r0 & 32768) != 32768) goto L36;
        this.mSensorManager.unregisterListener(this, this.mRotationVector);
        AtomicInteger r10 = this.mSensorMask;
        r10.set(r10.get() & (-32769));
    L36:
        Handler r11 = this.mSensorHandler;
        if (r11 == null) goto L39;
        r11.removeCallbacksAndMessages(null);
        this.mSensorHandler = null;
    L39:
        HandlerThread r12 = this.mSensorHandlerThread;
        if (r12 == null) goto L43;
        r12.quit();
        this.mSensorHandlerThread = null;
        return;
    }

    public void unregisterOutElevator() {
        com.obric.cae.log.a.e(TAG, "unregisterOutElevator");
        this.mSensorManager.unregisterListener(this, this.mOutElevator);
        AtomicInteger r2 = this.mSensorMask;
        r2.set(r2.get() & (-4097));
    }

    public void unregisterSubwaySensor() {
        com.obric.cae.log.a.e(TAG, "unregisterSubwaySensor");
        if (this.mCellPoiListenerRegistered.compareAndSet(true, false) == false) goto L6;
        b.a().b(this.mCellPoiListener);
        return;
    }

    public void unregisterUpDownStairSensor() {
        if (this.mUpDownStairSensorRefCount.get() > 0) goto L6;
        this.mUpDownStairSensorRefCount.set(0);
        com.obric.cae.log.a.g(TAG, "unregisterUpDownStairSensor without registration");
        return;
    L6:
        int r0 = this.mUpDownStairSensorRefCount.decrementAndGet();
        com.obric.cae.log.a.e(TAG, "unregisterUpDownStairSensor refCount=" + r0);
        if (r0 <= 0) goto L9;
        return;
    L9:
        this.mSensorManager.unregisterListener(this, this.mUpDownStairSensor);
    }
}
