package com.obric.cae.userAware;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.obric.cae.libs.useraware.SensorEventInfo;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.cell.CellPoiService;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.ttnet.org.chromium.net.NetError;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
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

    @SuppressLint({"StaticFieldLeak"})
    private static SensorCollectManager sInstance;
    private final Sensor mAccelerometer;
    private final BroadcastReceiver mActionReceiver;
    private Handler mAlwaysOnSensorHandler;
    private HandlerThread mAlwaysOnSensorHandlerThread;
    private final CellPoiService.CellPoiListener mCellPoiListener;
    private final AtomicBoolean mCellPoiListenerRegistered;
    private final Context mContext;
    private StarLocationManager.LocationSource mFlightModeFlyPrevLocation;
    private long mFlightModeFlyTimestamp;
    private long mFlightModeGroundTimestamp;
    private final InnerAwareInfoCallback mFlightModeLocationCallback;
    private final Object mFlightModeReportLock;
    private final Sensor mFlightModeSensor;
    private final FlightModeStateManager mFlightModeStateManager;
    private boolean mFlightModeWaitingGroundLocation;
    private final Sensor mGyroscope;
    private final AtomicBoolean mIsSensorRecording;
    private StarLocationManager.LocationSource mLastLocationSource;
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

        public synchronized boolean shouldDispatch(int r10) {
            monitor-enter(this);
            int r8 = -1;
            if (this.mShouldIgnoreFirstEvent == false) goto L9;
            this.mShouldIgnoreFirstEvent = false;     // Catch: Throwable -> L36
            this.mCurrentState = -1;     // Catch: Throwable -> L36
            CommSenseLog.d(SensorCollectManager.TAG, "ignore first flight mode event: " + SensorCollectManager.stateToString(r10) + ", currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L36
            monitor-exit(this);
            return false;
        L9:
            if (r10 != (-1)) goto L13;
            CommSenseLog.d(SensorCollectManager.TAG, "ignore unknown flight mode event");     // Catch: Throwable -> L36
            monitor-exit(this);
            return false;
        L13:
            int r11 = this.mCurrentState;     // Catch: Throwable -> L36
            if (r10 != r11) goto L19;
            CommSenseLog.d(SensorCollectManager.TAG, "ignore duplicate flight mode event: " + SensorCollectManager.stateToString(r10));     // Catch: Throwable -> L36
            monitor-exit(this);
            return false;
        L19:
            if (r10 != 2) goto L24;
            if (r11 == 1) goto L24;
            CommSenseLog.d(SensorCollectManager.TAG, "ignore pre-landing flight mode event, currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L36
            monitor-exit(this);
            return false;
        L24:
            if (r10 != 0) goto L30;
            if (r11 == 1) goto L30;
            if (r11 == 2) goto L30;
            CommSenseLog.d(SensorCollectManager.TAG, "ignore ground flight mode event, currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L36
            this.mCurrentState = -1;     // Catch: Throwable -> L36
            monitor-exit(this);
            return false;
        L30:
            if (r10 == 0) goto L33;
            r8 = r10;
        L33:
            this.mCurrentState = r8;     // Catch: Throwable -> L36
            CommSenseLog.i(SensorCollectManager.TAG, "flight mode state changed: " + SensorCollectManager.stateToString(r11) + " -> " + SensorCollectManager.stateToString(r10) + ", currentState=" + SensorCollectManager.stateToString(this.mCurrentState));     // Catch: Throwable -> L36
            monitor-exit(this);
            return true;
        L36:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ FlightModeStateManager(AnonymousClass1 r8) {
            this();
        }
    }

    private SensorCollectManager(Context r8) {
        this.mSensorMask = new AtomicInteger(0);
        this.mSensorCollectFileKey = "";
        this.mSensorThreadPool = Executors.newCachedThreadPool();
        this.mIsSensorRecording = new AtomicBoolean(false);
        this.mUpDownStairSensorRefCount = new AtomicInteger(0);
        this.mCellPoiListenerRegistered = new AtomicBoolean(false);
        this.mCellPoiListener = new l();
        this.mFlightModeStateManager = new FlightModeStateManager(null);
        Object r10 = new Object();
        this.mFlightModeReportLock = r10;
        this.mFlightModeLocationCallback = new AnonymousClass1(this);
        this.mActionReceiver = new AnonymousClass2(this);
        this.mContext = r8;
        initSensorEventsFile();
        this.mNearElevator = NearElevator.getInstance(r8);
        SensorManager r11 = (SensorManager) r8.getSystemService("sensor");
        this.mSensorManager = r11;
        this.mAccelerometer = r11.getDefaultSensor(1, false);
        this.mGyroscope = r11.getDefaultSensor(4, false);
        this.mLinearAcceleration = r11.getDefaultSensor(10, false);
        this.mMagneticField = r11.getDefaultSensor(2, false);
        this.mUserStepsCounter = r11.getDefaultSensor(19, false);
        this.mLightSensor = r11.getDefaultSensor(5, false);
        this.mPressure = r11.getDefaultSensor(6, false);
        this.mOutElevator = r11.getDefaultSensor(SENSOR_TYPE_ELEVATOR, true);
        this.mUpDownStairSensor = r11.getDefaultSensor(SENSOR_TYPE_UP_DOWN, true);
        this.mFlightModeSensor = r11.getDefaultSensor(SENSOR_TYPE_FLIGHT_MODE, false);
        this.mOrientation = r11.getDefaultSensor(3, false);
        this.mRotationVector = r11.getDefaultSensor(11, false);
        this.mProximity = r11.getDefaultSensor(8, true);
        StarLocationTeaReporter.init(r8);
        monitor-enter(r10);
        this.mLastLocationSource = StarLocationManager.getInstance().getLastLocationSource();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        registerFlightModeSensor();
        registerSleepModeReceiver(r8);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void a(int r8, int r10, int r11, long r12, int r13, String r14) {
        lambda$new$0(r8, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void access$100(SensorCollectManager r8, StarLocationManager.LocationSource r10) {
        r8.handleLocationSourceChanged(r10);
    }

    public static /* synthetic */ AtomicInteger access$200(SensorCollectManager r8) {
        return r8.mSensorMask;
    }

    private synchronized Handler ensureAlwaysOnSensorHandler() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mAlwaysOnSensorHandlerThread != null) goto L6;
        HandlerThread r8 = new HandlerThread("SensorCollectManagerAlwaysOn");     // Catch: Throwable -> L9
        this.mAlwaysOnSensorHandlerThread = r8;     // Catch: Throwable -> L9
        r8.start();     // Catch: Throwable -> L9
        this.mAlwaysOnSensorHandler = new Handler(this.mAlwaysOnSensorHandlerThread.getLooper());     // Catch: Throwable -> L9
    L6:
        Handler r10 = this.mAlwaysOnSensorHandler;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    }

    public static SensorCollectManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SensorCollectManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SensorCollectManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SensorCollectManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handleFlightModeStateForReport(int r8) {
        Object r10 = this.mFlightModeReportLock;
        monitor-enter(r10);
        if (r8 != 1) goto L14;
        StarLocationTeaReporter.resetAirportEnterReportGate();     // Catch: Throwable -> L12
        this.mFlightModeFlyTimestamp = System.currentTimeMillis();     // Catch: Throwable -> L12
        StarLocationManager.LocationSource r11 = this.mLastLocationSource;     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
        StarLocationManager.LocationSource r12 = null;
    L10:
        this.mFlightModeFlyPrevLocation = r12;     // Catch: Throwable -> L12
        this.mFlightModeGroundTimestamp = 0;     // Catch: Throwable -> L12
    L11:
        this.mFlightModeWaitingGroundLocation = false;     // Catch: Throwable -> L12
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L9:
        r12 = r11.copy();     // Catch: Throwable -> L12
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

    private void handleLocationSourceChanged(StarLocationManager.LocationSource r20) {
        Object r8 = this.mFlightModeReportLock;
        monitor-enter(r8);
        StarLocationManager.LocationSource r10 = r20.copy();     // Catch: Throwable -> L17
        this.mLastLocationSource = r10;     // Catch: Throwable -> L17
        if (this.mFlightModeWaitingGroundLocation == true) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L17
        return;
    L8:
        long r11 = this.mFlightModeFlyTimestamp;     // Catch: Throwable -> L17
        long r12 = this.mFlightModeGroundTimestamp;     // Catch: Throwable -> L17
        StarLocationManager.LocationSource r13 = this.mFlightModeFlyPrevLocation;     // Catch: Throwable -> L17
        if (r13 != null) goto L13;
        this.mFlightModeFlyTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeGroundTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeWaitingGroundLocation = false;     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return;
    L13:
        StarLocationManager.LocationSource r14 = r13.copy();     // Catch: Throwable -> L17
        StarLocationManager.LocationSource r15 = r10.copy();     // Catch: Throwable -> L17
        this.mFlightModeFlyTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeGroundTimestamp = 0;     // Catch: Throwable -> L17
        this.mFlightModeFlyPrevLocation = null;     // Catch: Throwable -> L17
        this.mFlightModeWaitingGroundLocation = false;     // Catch: Throwable -> L17
        int r16 = (int) LocationUtil.getInstance().calculateDistance(r14.getLatitude(), r14.getLongitude(), r15.getLatitude(), r15.getLongitude());     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        StarLocationTeaReporter.reportFlightMode(r11, r14, r12, r15, r16);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void initSensorEventsFile() {
        File r8 = new File(UserAwareUtil.getLocalDir(this.mContext, "sensor"), "sensor_events.log");
        r8.delete();
        r8.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mSensorEventsFile = r8;
        CommSenseLog.d(TAG, "initSensorEventsFile, file: " + this.mSensorEventsFile);
        CommSenseLog.recordFileWithKey("sensor_events", this.mSensorEventsFile);
        return;
    L5:
        CommSenseLog.e(TAG, "IO error occurred!");
        goto L6
    }

    private static /* synthetic */ void lambda$new$0(int r12, int r13, int r14, long r15, int r17, String r18) {
        String r8 = TAG;
        StringBuilder r10 = defpackage.a.g("onCellPoiStatusChange: cellPoiType=", r12, " rat=", r13, " tac=");
        defpackage.b.q(r10, r14, " pci=", r17, " cellid=");
        r10.append(r15);
        r10.append(" stationName=");
        r10.append(r18);
        CommSenseLog.i(r8, r10.toString());
        InnerAwareInfoCallback.CellPoiStatus r11 = new InnerAwareInfoCallback.CellPoiStatus(r12, r13, r14, r15, r17, r18);
        UserAwareManager.getInstance().notifyInnerCallbacks(new o5.o(7), r11);
    }

    private int normalizeFlightModeState(int r8) {
        if (r8 != 0) goto L4;
    L10:
        return r8;
    L4:
        if (r8 == 1) goto L10;
        if (r8 == 2) goto L10;
        return -1;
    }

    private void registerFlightModeSensor() {
        String r8 = TAG;
        CommSenseLog.i(r8, "registerFlightModeSensor");
        if (this.mFlightModeSensor != null) goto L6;
        CommSenseLog.w(r8, "flight mode sensor not found");
        return;
    L6:
        this.mFlightModeStateManager.reset();
        Handler r10 = ensureAlwaysOnSensorHandler();
        if (this.mSensorManager.registerListener(this, this.mFlightModeSensor, 1, r10) == true) goto L10;
        CommSenseLog.w(r8, "registerFlightModeSensor failed");
        return;
    }

    private void registerSleepModeReceiver(Context r8) {
        IntentFilter r10 = defpackage.a.c(ACTION_SLEEP_MODE_CHANGED, "android.net.wifi.WIFI_STATE_CHANGED");
        r8.registerReceiver(this.mActionReceiver, r10, 2);
    }

    public static String stateToString(int r8) {
        if (r8 != 0) goto L4;
        return "ground";
    L4:
        if (r8 != 1) goto L6;
        return "flying";
    L6:
        if (r8 == 2) goto L9;
        return "unknown";
    L9:
        return "pre_landing";
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r8, int r10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r12) {
        if (r12 == null) goto L53;
        float[] r8 = r12.values;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.length != 0) goto L10;
        return;
    L10:
        if (r12.sensor.getType() != 33171014) goto L23;
        String r10 = TAG;
        if (((int) r12.values[0]) != 2) goto L14;
        String r11 = "out elevator";
    L15:
        CommSenseLog.i(r10, "elevator event: ".concat(r11));
        NearElevator r13 = this.mNearElevator;
        if (r13 != null) goto L18;
        CommSenseLog.e(r10, "mNearElevator is null");
        goto L23
    L18:
        if (((int) r12.values[0]) != 2) goto L20;
        r13.outElevatorEvent();
        goto L23
    L20:
        r13.inElevatorEvent();
        goto L23
    L14:
        r11 = "in elevator";
    L23:
        if (r12.sensor.getType() != 33171018) goto L29;
        int r14 = normalizeFlightModeState((int) r12.values[0]);
        CommSenseLog.i(TAG, "flight mode event: " + stateToString(r14));
        if (this.mFlightModeStateManager.shouldDispatch(r14) == true) goto L27;
        return;
    L27:
        handleFlightModeStateForReport(r14);
        UserAwareManager.getInstance().notifyInnerCallbacks(new com.obric.cae.location.geofence.a(4), Integer.valueOf(r14));
        return;
    L29:
        SensorEventInfo r15 = new SensorEventInfo(r12.sensor.getName(), r12.sensor.getType(), r12.accuracy, r12.timestamp, r12.values);
        if (r12.sensor.getType() != 19) goto L33;
        this.mSensorCollectMonitor.onStepsCounterChanged((int) r12.values[0]);
        CommSenseLog.dumpI(TAG, r15.toString(), this.mSensorEventsFile);
    L38:
        UserAwareManager r16 = UserAwareManager.getInstance();
        if (r16.isRecording() == false) goto L41;
    L46:
        CommSenseLog.addTimeLog(r15.toString(), CommSenseLog.getRecordFile(this.mSensorCollectFileKey));
    L47:
        r16.postHarLevel2Data(r15);
        SensorCollectMonitor r17 = this.mSensorCollectMonitor;
        if (r17 == null) goto L55;
        r17.onSensorDataChanged(r12);
        return;
    L55:
        return;
    L41:
        if (r16.isRecordingByCallback() == true) goto L46;
        if (r16.isHarLevel2DataRecording() == false) goto L47;
        if (AwareStateListener.isHarCollectLocal() == false) goto L47;
    L33:
        if (r12.sensor.getType() != 11) goto L38;
        float[] r18 = new float[9];
        CommSenseLog.d(TAG, "rotation matrix sensor name: " + r12.sensor.getName());     // Catch: IllegalArgumentException -> L37
        SensorManager.getRotationMatrixFromVector(r18, r12.values);     // Catch: IllegalArgumentException -> L37
        r15 = new SensorEventInfo("RotationMatrix", r12.sensor.getType(), r12.accuracy, r12.timestamp, r18);     // Catch: IllegalArgumentException -> L37
    L37:
        CommSenseLog.e(TAG, "Invalid rotation vector data");
        goto L38
    }

    public void recordSensorFile(String r8, File r10) {
        this.mSensorCollectFileKey = r8;
        CommSenseLog.recordFileWithKey(r8, r10);
    }

    public void registerOutElevator() {
        CommSenseLog.i(TAG, "registerOutElevator");
        Handler r8 = ensureAlwaysOnSensorHandler();
        this.mSensorManager.registerListener(this, this.mOutElevator, 1, r8);
        AtomicInteger r10 = this.mSensorMask;
        r10.set(r10.get() | 4096);
    }

    public void registerSensorCollectMonitor(SensorCollectMonitor r8) {
        if (r8 != null) goto L5;
        CommSenseLog.w(TAG, "registerSensorCollectMonitor monitor is null");
        return;
    L5:
        this.mSensorCollectMonitor = r8;
        UserAwareManager.getInstance().registerInnerCallback(this.mFlightModeLocationCallback);
    }

    public void registerStepsCounter() {
        Handler r8 = ensureAlwaysOnSensorHandler();
        this.mSensorManager.registerListener(this, this.mUserStepsCounter, 1, r8);
        AtomicInteger r10 = this.mSensorMask;
        r10.set(r10.get() | 512);
    }

    public void registerSubwaySensor() {
        CommSenseLog.i(TAG, "registerSubwaySensor");
        if (this.mCellPoiListenerRegistered.compareAndSet(false, true) == false) goto L6;
        CellPoiService.getInstance().addCellPoiListener(this.mCellPoiListener);
        return;
    }

    public void registerUpDownStairSensor() {
        if (this.mUpDownStairSensor != null) goto L6;
        CommSenseLog.w(TAG, "up down stair sensor not found");
        return;
    L6:
        int r8 = this.mUpDownStairSensorRefCount.getAndIncrement();
        String r10 = TAG;
        CommSenseLog.i(r10, "registerUpDownStairSensor refCount=" + (r8 + 1));
        if (r8 <= 0) goto L10;
        return;
    L10:
        if (this.mSensorManager.registerListener(this, this.mUpDownStairSensor, 1, ensureAlwaysOnSensorHandler()) == true) goto L13;
        this.mUpDownStairSensorRefCount.decrementAndGet();
        CommSenseLog.w(r10, "registerUpDownStairSensor failed");
        return;
    }

    public void startSensorCollect(int r8) {
        if (r8 != 0) goto L6;
        CommSenseLog.d(TAG, "startSensorCollect mask is 0");
        return;
    L6:
        if (this.mIsSensorRecording.get() == false) goto L10;
        CommSenseLog.w(TAG, "sensor is already recording");
        return;
    L10:
        if (r8 == this.mSensorMask.get()) goto L12;
        CommSenseLog.i(TAG, "startSensorCollect mask from " + String.format("0x%08x", new Object[]{Integer.valueOf(this.mSensorMask.get())}) + " to " + String.format("0x%08x", new Object[]{Integer.valueOf(r8)}));
        stopSensorCollect();
    L12:
        HandlerThread r10 = new HandlerThread("SensorCollectManager");
        this.mSensorHandlerThread = r10;
        r10.start();
        Handler r11 = new Handler(this.mSensorHandlerThread.getLooper());
        this.mSensorHandler = r11;
        if ((r8 & 32) != 32) goto L16;
        this.mSensorManager.registerListener(this, this.mAccelerometer, 1, r11);
        AtomicInteger r12 = this.mSensorMask;
        r12.set(r12.get() | 32);
    L16:
        if ((r8 & 64) != 64) goto L19;
        this.mSensorManager.registerListener(this, this.mLinearAcceleration, 1, this.mSensorHandler);
        AtomicInteger r13 = this.mSensorMask;
        r13.set(64 | r13.get());
    L19:
        if ((r8 & 128) != 128) goto L22;
        this.mSensorManager.registerListener(this, this.mGyroscope, 1, this.mSensorHandler);
        AtomicInteger r14 = this.mSensorMask;
        r14.set(128 | r14.get());
    L22:
        if ((r8 & 256) != 256) goto L25;
        this.mSensorManager.registerListener(this, this.mMagneticField, 1, this.mSensorHandler);
        AtomicInteger r15 = this.mSensorMask;
        r15.set(256 | r15.get());
    L25:
        if ((r8 & 512) != 512) goto L28;
        AtomicInteger r16 = this.mSensorMask;
        r16.set(512 | r16.get());
    L28:
        if ((r8 & 1024) != 1024) goto L31;
        this.mSensorManager.registerListener(this, this.mLightSensor, 1, this.mSensorHandler);
        AtomicInteger r17 = this.mSensorMask;
        r17.set(1024 | r17.get());
    L31:
        if ((r8 & 2048) != 2048) goto L34;
        this.mSensorManager.registerListener(this, this.mPressure, 1, this.mSensorHandler);
        AtomicInteger r18 = this.mSensorMask;
        r18.set(2048 | r18.get());
    L34:
        if ((r8 & 8192) != 8192) goto L37;
        this.mSensorManager.registerListener(this, this.mOrientation, 1, this.mSensorHandler);
        AtomicInteger r19 = this.mSensorMask;
        r19.set(8192 | r19.get());
    L37:
        if ((r8 & 16384) != 16384) goto L40;
        this.mSensorManager.registerListener(this, this.mProximity, 1, this.mSensorHandler);
        AtomicInteger r20 = this.mSensorMask;
        r20.set(16384 | r20.get());
    L40:
        if ((r8 & 32768) != 32768) goto L42;
        this.mSensorManager.registerListener(this, this.mRotationVector, 1, this.mSensorHandler);
        AtomicInteger r21 = this.mSensorMask;
        r21.set(32768 | r21.get());
    L42:
        this.mIsSensorRecording.set(true);
    }

    public void stopSensorCollect() {
        if (this.mIsSensorRecording.get() == true) goto L6;
        CommSenseLog.w(TAG, "sensor is not recording");
        return;
    L6:
        this.mIsSensorRecording.set(false);
        int r8 = this.mSensorMask.get();
        CommSenseLog.d(TAG, "stopSensorCollect mask: " + String.format("0x%08x", new Object[]{Integer.valueOf(r8)}));
        if ((r8 & 32) != 32) goto L10;
        this.mSensorManager.unregisterListener(this, this.mAccelerometer);
        AtomicInteger r10 = this.mSensorMask;
        r10.set(r10.get() & (-33));
    L10:
        if ((r8 & 64) != 64) goto L13;
        this.mSensorManager.unregisterListener(this, this.mLinearAcceleration);
        AtomicInteger r11 = this.mSensorMask;
        r11.set(r11.get() & (-65));
    L13:
        if ((r8 & 128) != 128) goto L16;
        this.mSensorManager.unregisterListener(this, this.mGyroscope);
        AtomicInteger r12 = this.mSensorMask;
        r12.set(r12.get() & NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY);
    L16:
        if ((r8 & 256) != 256) goto L19;
        this.mSensorManager.unregisterListener(this, this.mMagneticField);
        AtomicInteger r13 = this.mSensorMask;
        r13.set(r13.get() & (-257));
    L19:
        if ((r8 & 512) != 512) goto L22;
        AtomicInteger r14 = this.mSensorMask;
        r14.set(r14.get() & NetError.ERR_TTNET_FT_INVALID_STREAM);
    L22:
        if ((r8 & 1024) != 1024) goto L25;
        this.mSensorManager.unregisterListener(this, this.mLightSensor);
        AtomicInteger r15 = this.mSensorMask;
        r15.set(r15.get() & (-1025));
    L25:
        if ((r8 & 2048) != 2048) goto L28;
        this.mSensorManager.unregisterListener(this, this.mPressure);
        AtomicInteger r16 = this.mSensorMask;
        r16.set(r16.get() & (-2049));
    L28:
        if ((r8 & 8192) != 8192) goto L31;
        this.mSensorManager.unregisterListener(this, this.mOrientation);
        AtomicInteger r17 = this.mSensorMask;
        r17.set(r17.get() & (-8193));
    L31:
        if ((r8 & 16384) != 16384) goto L34;
        this.mSensorManager.unregisterListener(this, this.mProximity);
        AtomicInteger r18 = this.mSensorMask;
        r18.set(r18.get() & (-16385));
    L34:
        if ((r8 & 32768) != 32768) goto L36;
        this.mSensorManager.unregisterListener(this, this.mRotationVector);
        AtomicInteger r19 = this.mSensorMask;
        r19.set(r19.get() & (-32769));
    L36:
        Handler r20 = this.mSensorHandler;
        if (r20 == null) goto L39;
        r20.removeCallbacksAndMessages(null);
        this.mSensorHandler = null;
    L39:
        HandlerThread r21 = this.mSensorHandlerThread;
        if (r21 == null) goto L43;
        r21.quit();
        this.mSensorHandlerThread = null;
        return;
    }

    public void unregisterOutElevator() {
        CommSenseLog.i(TAG, "unregisterOutElevator");
        this.mSensorManager.unregisterListener(this, this.mOutElevator);
        AtomicInteger r8 = this.mSensorMask;
        r8.set(r8.get() & (-4097));
    }

    public void unregisterSubwaySensor() {
        CommSenseLog.i(TAG, "unregisterSubwaySensor");
        if (this.mCellPoiListenerRegistered.compareAndSet(true, false) == false) goto L6;
        CellPoiService.getInstance().removeCellPoiListener(this.mCellPoiListener);
        return;
    }

    public void unregisterUpDownStairSensor() {
        if (this.mUpDownStairSensorRefCount.get() > 0) goto L6;
        this.mUpDownStairSensorRefCount.set(0);
        CommSenseLog.w(TAG, "unregisterUpDownStairSensor without registration");
        return;
    L6:
        int r8 = this.mUpDownStairSensorRefCount.decrementAndGet();
        CommSenseLog.i(TAG, "unregisterUpDownStairSensor refCount=" + r8);
        if (r8 <= 0) goto L9;
        return;
    L9:
        this.mSensorManager.unregisterListener(this, this.mUpDownStairSensor);
    }
}
