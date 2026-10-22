package com.obric.cae.userAware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes2.dex */
public class StepMovementGate {
    private static final String TAG = "StepMovementGate";
    private final Context mContext;
    private Handler mHandler;
    private volatile boolean mLastActivityRecognitionGranted;
    private volatile long mLastStepElapsedMs;
    private final SensorEventListener mListener;
    private final Object mLock;
    private boolean mRegistered;
    private SensorManager mSensorManager;
    private Sensor mStepSensor;
    private HandlerThread mThread;

    public StepMovementGate(Context r8) {
        this.mLock = new Object();
        this.mLastActivityRecognitionGranted = true;
        this.mLastStepElapsedMs = -1;
        this.mListener = new AnonymousClass1(this);
        if (r8 == null) goto L5;
        Context r10 = r8.getApplicationContext();
    L6:
        this.mContext = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public static /* synthetic */ long access$002(StepMovementGate r8, long r10) {
        r8.mLastStepElapsedMs = r10;
        return r10;
    }

    private boolean hasActivityRecognitionPermission() {
        Context r8 = this.mContext;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.checkSelfPermission("android.permission.ACTIVITY_RECOGNITION") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean allowScanNow(long r8) {
        if (this.mRegistered == true) goto L5;
        return true;
    L5:
        long r10 = this.mLastStepElapsedMs;
        if (r10 > 0) goto L9;
        return false;
    L9:
        if ((SystemClock.elapsedRealtime() - r10) > r8) goto L12;
        return true;
    L12:
        return false;
    }

    public void ensureStarted() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L48:
        th = move-exception;
        throw th;
    L5:
        if (this.mRegistered == false) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L48
        return;
    L9:
        if (this.mContext != null) goto L13;
        monitor-exit(r8);     // Catch: Throwable -> L48
        return;
    L13:
        if (hasActivityRecognitionPermission() == true) goto L21;
        if (this.mLastActivityRecognitionGranted == false) goto L17;
        CommSenseLog.w(TAG, "No ACTIVITY_RECOGNITION permission, disable step gate and allow scan");     // Catch: Throwable -> L48
    L17:
        this.mLastActivityRecognitionGranted = false;     // Catch: Throwable -> L48
        monitor-exit(r8);     // Catch: Throwable -> L48
        return;
    L21:
        if (this.mLastActivityRecognitionGranted == true) goto L23;
        CommSenseLog.i(TAG, "ACTIVITY_RECOGNITION permission granted, enable step gate");     // Catch: Throwable -> L48
    L23:
        this.mLastActivityRecognitionGranted = true;     // Catch: Throwable -> L48
        if (this.mSensorManager != null) goto L27;
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");     // Catch: Throwable -> L48
    L27:
        if (this.mSensorManager != null) goto L32;
        CommSenseLog.w(TAG, "No SensorManager, gate disabled");     // Catch: Throwable -> L48
        monitor-exit(r8);     // Catch: Throwable -> L48
        return;
    L32:
        if (this.mThread != null) goto L35;
        HandlerThread r10 = new HandlerThread("CaeStepDetectorGate");     // Catch: Throwable -> L48
        this.mThread = r10;     // Catch: Throwable -> L48
        r10.start();     // Catch: Throwable -> L48
        this.mHandler = new Handler(this.mThread.getLooper());     // Catch: Throwable -> L48
    L35:
        if (this.mStepSensor != null) goto L37;
        this.mStepSensor = this.mSensorManager.getDefaultSensor(18);     // Catch: Throwable -> L48
    L37:
        Sensor r11 = this.mStepSensor;     // Catch: Throwable -> L48
        if (r11 != null) goto L51;
        CommSenseLog.w(TAG, "No TYPE_STEP_DETECTOR sensor, gate disabled");     // Catch: Throwable -> L48
        monitor-exit(r8);     // Catch: Throwable -> L48
        return;
    L51:
        this.mSensorManager.registerListener(this.mListener, r11, 3, this.mHandler);     // Catch: Throwable -> L44
        this.mRegistered = true;     // Catch: Throwable -> L44
        CommSenseLog.i(TAG, "Step gate started, sensor=" + this.mStepSensor.getName());     // Catch: Throwable -> L44
    L46:
        monitor-exit(r8);     // Catch: Throwable -> L48
        return;
    L44:
        th = move-exception;
        CommSenseLog.w(TAG, "registerListener failed, gate disabled: " + th.getMessage());     // Catch: Throwable -> L48
        goto L46
    }

    public long getLastStepDeltaMs() {
        long r8 = this.mLastStepElapsedMs;
        if (r8 > 0) goto L7;
        return Long.MAX_VALUE;
    L7:
        return SystemClock.elapsedRealtime() - r8;
    }
}
