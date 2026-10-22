package com.obric.cae.connectivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ConnectivityMotionDetector {
    private static final int CALCULATE_PERIOD_MS = 2000;
    public static final int STATE_MOVING = 2;
    public static final int STATE_STILL = 1;
    public static final int STATE_UNKNOWN = 0;
    private static final float STEP_FREQ_STILL_THRESHOLD = 0.3f;
    private static final String TAG = "ConnMotionDetector";
    private static final int WINDOW_SIZE = 5;
    private final Runnable mCalculateRunnable;
    private Context mContext;
    private int mCurrentState;
    private StepData mFirstStepData;
    private final Handler mHandler;
    private boolean mIsRunning;
    private StepData mLastStepData;
    private MotionStateListener mListener;
    private final SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private final Queue<StepData> mStepDataQueue;

    public interface MotionStateListener {
        void onMotionStateChanged(int r8);
    }

    public static class StepData {
        int steps;
        long timestamp;

        public StepData(int r8, long r10) {
            this.steps = r8;
            this.timestamp = r10;
        }
    }

    public ConnectivityMotionDetector(Context r8, MotionStateListener r10) {
        this.mIsRunning = false;
        this.mCurrentState = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mStepDataQueue = new ArrayDeque(5);
        this.mFirstStepData = null;
        this.mLastStepData = null;
        this.mSensorEventListener = new AnonymousClass1(this);
        this.mCalculateRunnable = new AnonymousClass2(this);
        this.mContext = r8.getApplicationContext();
        this.mListener = r10;
        initSensor();
    }

    public static /* synthetic */ StepData access$000(ConnectivityMotionDetector r8) {
        return r8.mLastStepData;
    }

    public static /* synthetic */ StepData access$002(ConnectivityMotionDetector r8, StepData r10) {
        r8.mLastStepData = r10;
        return r10;
    }

    public static /* synthetic */ Queue access$100(ConnectivityMotionDetector r8) {
        return r8.mStepDataQueue;
    }

    public static /* synthetic */ StepData access$202(ConnectivityMotionDetector r8, StepData r10) {
        r8.mFirstStepData = r10;
        return r10;
    }

    public static /* synthetic */ void access$300(ConnectivityMotionDetector r8) {
        r8.calculateAndDispatchState();
    }

    public static /* synthetic */ Handler access$400(ConnectivityMotionDetector r8) {
        return r8.mHandler;
    }

    private void calculateAndDispatchState() {
        if (this.mStepDataQueue.size() >= 5) goto L5;
        return;
    L5:
        long r8 = System.currentTimeMillis();
        int r10 = this.mLastStepData.steps;
        StepData r11 = this.mFirstStepData;
        int r12 = r10 - r11.steps;
        int r13 = ((int) (r8 - r11.timestamp)) / 1000;
        if (r13 > 0) goto L8;
        return;
    L8:
        float r14 = r12 / r13;
        if (r14 > STEP_FREQ_STILL_THRESHOLD) goto L11;
        int r15 = 1;
    L13:
        if (r15 == this.mCurrentState) goto L18;
        Log.i(TAG, "Motion state changed: " + stateToString(this.mCurrentState) + " -> " + stateToString(r15) + " (freq: " + r14 + ")");
        this.mCurrentState = r15;
        MotionStateListener r16 = this.mListener;
        if (r16 == null) goto L19;
        r16.onMotionStateChanged(r15);
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r15 = 2;
        goto L13
    }

    private void initSensor() {
        SensorManager r8 = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = r8;
        if (r8 == null) goto L6;
        this.mStepCounterSensor = r8.getDefaultSensor(19);
    L6:
        if (this.mStepCounterSensor != null) goto L9;
        Log.e(TAG, "Device does not support STEP_COUNTER sensor!");
        return;
    }

    private String stateToString(int r8) {
        if (r8 != 1) goto L5;
        return "STILL";
    L5:
        if (r8 == 2) goto L8;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L8:
        return "MOVING";
    }

    public void start() {
        if (this.mIsRunning == false) goto L5;
        return;
    L5:
        if (this.mStepCounterSensor != null) goto L7;
        return;
    L7:
        if (this.mSensorManager == null) goto L13;
        Log.i(TAG, "Starting motion detector...");
        this.mStepDataQueue.clear();
        this.mFirstStepData = null;
        this.mLastStepData = null;
        this.mCurrentState = 0;
        this.mSensorManager.registerListener(this.mSensorEventListener, this.mStepCounterSensor, 3);
        this.mHandler.postDelayed(this.mCalculateRunnable, 2000);
        this.mIsRunning = true;
        return;
    }

    public void stop() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        if (this.mSensorManager == null) goto L10;
        Log.i(TAG, "Stopping motion detector...");
        this.mSensorManager.unregisterListener(this.mSensorEventListener);
        this.mHandler.removeCallbacks(this.mCalculateRunnable);
        this.mIsRunning = false;
        this.mCurrentState = 0;
        return;
    }
}
