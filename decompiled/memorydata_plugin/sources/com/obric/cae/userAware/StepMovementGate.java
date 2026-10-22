package com.obric.cae.userAware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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

    public StepMovementGate(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.mLock = new Object();
        this.mLastActivityRecognitionGranted = true;
        this.mLastStepElapsedMs = -1;
        this.mListener = new AnonymousClass1(this);
        if (r6 == null) goto L5;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static /* synthetic */ long access$002(StepMovementGate r0, long r1) {
        r0.mLastStepElapsedMs = r1;
        return r1;
    }

    private boolean hasActivityRecognitionPermission() {
        Context r4 = this.mContext;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L9;
        return true;
    L9:
        if (r4.checkSelfPermission("android.permission.ACTIVITY_RECOGNITION") == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean allowScanNow(long r7) {
        if (this.mRegistered == true) goto L5;
        return true;
    L5:
        long r2 = this.mLastStepElapsedMs;
        if (r2 > 0) goto L9;
        return false;
    L9:
        if ((SystemClock.elapsedRealtime() - r2) > r7) goto L12;
        return true;
    L12:
        return false;
    }

    public void ensureStarted() {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L48:
        th = move-exception;
        throw th;
    L5:
        if (this.mRegistered == false) goto L9;
        monitor-exit(r2);     // Catch: Throwable -> L48
        return;
    L9:
        if (this.mContext != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L48
        return;
    L13:
        if (hasActivityRecognitionPermission() == true) goto L21;
        if (this.mLastActivityRecognitionGranted == false) goto L17;
        a.g(TAG, "No ACTIVITY_RECOGNITION permission, disable step gate and allow scan");     // Catch: Throwable -> L48
    L17:
        this.mLastActivityRecognitionGranted = false;     // Catch: Throwable -> L48
        monitor-exit(r2);     // Catch: Throwable -> L48
        return;
    L21:
        if (this.mLastActivityRecognitionGranted == true) goto L23;
        a.e(TAG, "ACTIVITY_RECOGNITION permission granted, enable step gate");     // Catch: Throwable -> L48
    L23:
        this.mLastActivityRecognitionGranted = true;     // Catch: Throwable -> L48
        if (this.mSensorManager != null) goto L27;
        this.mSensorManager = (SensorManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("sensor"), SensorManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
    L27:
        if (this.mSensorManager != null) goto L32;
        a.g(TAG, "No SensorManager, gate disabled");     // Catch: Throwable -> L48
        monitor-exit(r2);     // Catch: Throwable -> L48
        return;
    L32:
        if (this.mThread != null) goto L35;
        HandlerThread r4 = new HandlerThread("CaeStepDetectorGate");     // Catch: Throwable -> L48
        this.mThread = r4;     // Catch: Throwable -> L48
        r4.start();     // Catch: Throwable -> L48
        this.mHandler = new Handler(this.mThread.getLooper());     // Catch: Throwable -> L48
    L35:
        if (this.mStepSensor != null) goto L37;
        this.mStepSensor = this.mSensorManager.getDefaultSensor(18);     // Catch: Throwable -> L48
    L37:
        Sensor r5 = this.mStepSensor;     // Catch: Throwable -> L48
        if (r5 != null) goto L52;
        a.g(TAG, "No TYPE_STEP_DETECTOR sensor, gate disabled");     // Catch: Throwable -> L48
        monitor-exit(r2);     // Catch: Throwable -> L48
        return;
    L52:
        this.mSensorManager.registerListener(this.mListener, r5, 3, this.mHandler);     // Catch: Throwable -> L44
        this.mRegistered = true;     // Catch: Throwable -> L44
        a.e(TAG, "Step gate started, sensor=" + this.mStepSensor.getName());     // Catch: Throwable -> L44
    L46:
        monitor-exit(r2);     // Catch: Throwable -> L48
        return;
    L44:
        th = move-exception;
        a.g(TAG, "registerListener failed, gate disabled: " + th.getMessage());     // Catch: Throwable -> L48
        goto L46
    }

    public long getLastStepDeltaMs() {
        long r0 = this.mLastStepElapsedMs;
        if (r0 > 0) goto L7;
        return Long.MAX_VALUE;
    L7:
        return SystemClock.elapsedRealtime() - r0;
    }
}
