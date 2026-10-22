package com.obric.cae.smartBluetooth.btaware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.cae.log.CaeLog;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public class SmartBluetoothWalkingAware {
    private static final long ACTIVE_WINDOW_MS = 1500;
    private static final float GRAVITY_ALPHA = 0.8f;
    private static final int MIN_ACTIVE_SAMPLES_TO_START_WALKING = 12;
    private static final int MIN_STEPS_TO_START_WALKING = 3;
    private static final long STEP_START_WINDOW_MS = 2500;
    private static final long STOP_TIMEOUT_MS = 2500;
    private static final String TAG = "SmartBluetoothWalkingAware";
    private static final float WALK_ENERGY_THRESHOLD_CONTINUE = 1.2f;
    private static final float WALK_ENERGY_THRESHOLD_START = 1.8f;
    private static volatile SmartBluetoothWalkingAware sInstance;
    private Sensor mAccelerometer;
    private int mActiveSampleCount;
    private long mActiveWindowStartUptimeMs;
    private final Context mContext;
    private final float[] mGravity;
    private boolean mHasGravityInit;
    private volatile boolean mIsStarted;
    private volatile boolean mIsWalking;
    private long mLastMotionUptimeMs;
    private final Handler mMainHandler;
    private final ArrayDeque<Long> mRecentStepUptimes;
    private final SensorEventListener mSensorEventListener;
    private Handler mSensorHandler;
    private final SensorManager mSensorManager;
    private HandlerThread mSensorThread;
    private Sensor mStepDetector;
    private final Runnable mStopCheckRunnable;

    private SmartBluetoothWalkingAware(Context r8) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mIsStarted = false;
        this.mIsWalking = false;
        this.mLastMotionUptimeMs = 0;
        this.mActiveWindowStartUptimeMs = 0;
        this.mActiveSampleCount = 0;
        this.mRecentStepUptimes = new ArrayDeque();
        this.mHasGravityInit = false;
        this.mGravity = new float[3];
        this.mStopCheckRunnable = new AnonymousClass1(this);
        this.mSensorEventListener = new AnonymousClass2(this);
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mSensorManager = (SensorManager) r10.getSystemService("sensor");
    }

    public static /* synthetic */ boolean access$000(SmartBluetoothWalkingAware r8) {
        return r8.mIsWalking;
    }

    public static /* synthetic */ long access$100(SmartBluetoothWalkingAware r8) {
        return r8.mLastMotionUptimeMs;
    }

    public static /* synthetic */ void access$1000(SmartBluetoothWalkingAware r8, long r10) {
        r8.onMotionDetected(r10);
    }

    public static /* synthetic */ long access$102(SmartBluetoothWalkingAware r8, long r10) {
        r8.mLastMotionUptimeMs = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(SmartBluetoothWalkingAware r8, boolean r10) {
        r8.setWalkingState(r10);
    }

    public static /* synthetic */ boolean access$300(SmartBluetoothWalkingAware r8) {
        return r8.mIsStarted;
    }

    public static /* synthetic */ Handler access$400(SmartBluetoothWalkingAware r8) {
        return r8.mSensorHandler;
    }

    public static /* synthetic */ void access$500(SmartBluetoothWalkingAware r8, long r10) {
        r8.onStepDetected(r10);
    }

    public static /* synthetic */ boolean access$600(SmartBluetoothWalkingAware r8) {
        return r8.mHasGravityInit;
    }

    public static /* synthetic */ boolean access$602(SmartBluetoothWalkingAware r8, boolean r10) {
        r8.mHasGravityInit = r10;
        return r10;
    }

    public static /* synthetic */ float[] access$700(SmartBluetoothWalkingAware r8) {
        return r8.mGravity;
    }

    public static /* synthetic */ long access$800(SmartBluetoothWalkingAware r8) {
        return r8.mActiveWindowStartUptimeMs;
    }

    public static /* synthetic */ long access$802(SmartBluetoothWalkingAware r8, long r10) {
        r8.mActiveWindowStartUptimeMs = r10;
        return r10;
    }

    public static /* synthetic */ int access$900(SmartBluetoothWalkingAware r8) {
        return r8.mActiveSampleCount;
    }

    public static /* synthetic */ int access$902(SmartBluetoothWalkingAware r8, int r10) {
        r8.mActiveSampleCount = r10;
        return r10;
    }

    public static /* synthetic */ int access$908(SmartBluetoothWalkingAware r8) {
        int r10 = r8.mActiveSampleCount;
        r8.mActiveSampleCount = r10 + 1;
        return r10;
    }

    public static SmartBluetoothWalkingAware getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothWalkingAware.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothWalkingAware(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothWalkingAware.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void onMotionDetected(long r8) {
        this.mLastMotionUptimeMs = r8;
    }

    private void onStepDetected(long r8) {
        onMotionDetected(r8);
        this.mRecentStepUptimes.addLast(Long.valueOf(r8));
    L4:
        if (this.mRecentStepUptimes.isEmpty() == true) goto L9;
        if ((r8 - this.mRecentStepUptimes.peekFirst().longValue()) <= 2500) goto L9;
        this.mRecentStepUptimes.removeFirst();
    L9:
        if (this.mIsWalking == false) goto L11;
        return;
    L11:
        if (this.mRecentStepUptimes.size() < 3) goto L17;
        setWalkingState(true);
        return;
    }

    private void resetMotionState() {
        this.mIsWalking = false;
        this.mLastMotionUptimeMs = 0;
        this.mActiveWindowStartUptimeMs = 0;
        this.mActiveSampleCount = 0;
        this.mHasGravityInit = false;
        this.mRecentStepUptimes.clear();
    }

    private void setWalkingState(boolean r8) {
        if (this.mIsWalking != r8) goto L5;
        return;
    L5:
        this.mIsWalking = r8;
        CaeLog.i(TAG, "walking state changed: " + r8);
    }

    private void stopInternalThreads() {
        HandlerThread r8 = this.mSensorThread;
        if (r8 != null) goto L8;
    L5:
        this.mSensorThread = null;
        this.mSensorHandler = null;
        return;
    L8:
        r8.quitSafely();     // Catch: Throwable -> L7
        goto L5
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        stop();
        sInstance = null;
    }

    public void init() {
        CaeLog.d(TAG, "init");
        start();
    }

    public boolean isWalking() {
        return this.mIsWalking;
    }

    public void start() {
        if (this.mIsStarted == false) goto L6;
        return;
    L6:
        if (this.mSensorManager != null) goto L9;
        CaeLog.w(TAG, "start: mSensorManager is null");
        return;
    L9:
        HandlerThread r8 = new HandlerThread(TAG);
        this.mSensorThread = r8;
        r8.start();
        this.mSensorHandler = new Handler(this.mSensorThread.getLooper());
        this.mStepDetector = this.mSensorManager.getDefaultSensor(18);
        boolean r10 = true;
        this.mAccelerometer = this.mSensorManager.getDefaultSensor(1);
        Sensor r11 = this.mStepDetector;
        if (r11 == null) goto L12;
        boolean r12 = this.mSensorManager.registerListener(this.mSensorEventListener, r11, 3, this.mSensorHandler) | false;
    L13:
        if (r12 == true) goto L17;
        Sensor r13 = this.mAccelerometer;
        if (r13 == null) goto L17;
        r12 = r12 | this.mSensorManager.registerListener(this.mSensorEventListener, r13, 1, this.mSensorHandler);
    L21:
        if (r12 == true) goto L24;
        CaeLog.w(TAG, "start: no available walking sensors (stepDetector/accelerometer)");
        stopInternalThreads();
        return;
    L24:
        resetMotionState();
        this.mIsStarted = true;
        this.mSensorHandler.removeCallbacks(this.mStopCheckRunnable);
        this.mSensorHandler.postDelayed(this.mStopCheckRunnable, 500);
        StringBuilder r14 = new StringBuilder("start ok, stepDetector=");
        if (this.mStepDetector == null) goto L27;
        boolean r15 = true;
    L28:
        r14.append(r15);
        r14.append(", accelerometer=");
        if (this.mAccelerometer != null) goto L32;
        r10 = false;
    L32:
        r14.append(r10);
        CaeLog.d(TAG, r14.toString());
        return;
    L27:
        r15 = false;
    L17:
        if (r12 == false) goto L21;
        Sensor r16 = this.mAccelerometer;
        if (r16 == null) goto L21;
        this.mSensorManager.registerListener(this.mSensorEventListener, r16, 1, this.mSensorHandler);
        goto L21
    L12:
        r12 = false;
        goto L13
    }

    public void stop() {
        if (this.mIsStarted == true) goto L6;
        stopInternalThreads();
        return;
    L6:
        this.mIsStarted = false;
        Handler r8 = this.mSensorHandler;
        if (r8 == null) goto L9;
        r8.removeCallbacks(this.mStopCheckRunnable);
    L9:
        SensorManager r10 = this.mSensorManager;
        if (r10 != null) goto L17;
    L15:
        stopInternalThreads();
        resetMotionState();
        return;
    L17:
        r10.unregisterListener(this.mSensorEventListener);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CaeLog.e(TAG, "stop unregisterListener threw: " + th.getMessage());
        goto L15
    }
}
