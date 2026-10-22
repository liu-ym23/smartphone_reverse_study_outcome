package com.obric.cae.smartNetwork.fastReconnect;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.obric.cae.log.CaeLog;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class StepCounterListen {
    private static final int DEVICE_STATE_CALCULATE_PERIOD = 1500;
    public static final String DEVICE_STATE_CHANGE_ACTION = "obric.intent.action.DEVICE_STATE_CHANGE";
    public static final int DEVICE_STATE_RUNNING = 3;
    public static final int DEVICE_STATE_STILL = 1;
    public static final int DEVICE_STATE_UNKNOWN = 0;
    public static final int DEVICE_STATE_WAKING = 2;
    private static final int STEPCOUNTER_REPORT_WINDOW_SIZE = 5;
    private static final float STEP_FREQ_RUNNING_THRESHOLD = 2.6f;
    private static final float STEP_FREQ_STILL_THRESHOLD = 0.3f;
    private static final float STEP_FREQ_WAKING_THRESHOLD = 0.4f;
    private static final String TAG = "StepCounter";
    private boolean isRegister;
    private final Runnable mCalDeviceStateRunnable;
    private Context mContext;
    private Sensor mCounterSensor;
    private int mDeviceState;
    private StepData mFristStepData;
    private final Handler mHandler;
    private StepData mLastedStepData;
    private final WifiScanManager mScanManager;
    private SensorManager mSensorManager;
    private Queue<StepData> mStepDataQueue;
    private SensorEventListener mStepListener;

    public class StepData {
        private int steps;
        final /* synthetic */ StepCounterListen this$0;
        private long timestamp;

        public StepData(StepCounterListen r8, int r10, long r11) {
            this.this$0 = r8;
            this.steps = r10;
            this.timestamp = r11;
        }

        public static /* synthetic */ int access$302(StepData r8, int r10) {
            r8.steps = r10;
            return r10;
        }

        public int getSteps() {
            return this.steps;
        }

        public long getTimestamp() {
            return this.timestamp;
        }
    }

    public StepCounterListen(Context r8, WifiScanManager r10) {
        this.mDeviceState = 0;
        this.mStepDataQueue = new ArrayDeque(5);
        this.mLastedStepData = null;
        this.mFristStepData = null;
        this.isRegister = false;
        this.mCalDeviceStateRunnable = new AnonymousClass1(this);
        this.mStepListener = new AnonymousClass2(this);
        this.mContext = r8;
        this.mScanManager = r10;
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public static /* synthetic */ void access$000(StepCounterListen r8) {
        r8.calculateDeviceState();
    }

    public static /* synthetic */ Handler access$100(StepCounterListen r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$200(StepCounterListen r8, SensorEvent r10) {
        r8.processSensorEvent(r10);
    }

    private void calculateDeviceState() {
        if (this.mStepDataQueue.size() != 5) goto L22;
        long r8 = System.currentTimeMillis();
        float r10 = (this.mLastedStepData.getSteps() - this.mFristStepData.getSteps()) / (((int) (r8 - this.mFristStepData.getTimestamp())) / 1000);
        if (r10 < STEP_FREQ_RUNNING_THRESHOLD) goto L11;
        if (this.mDeviceState == 3) goto L23;
        this.mDeviceState = 3;
        StringBuilder r11 = new StringBuilder("StepFreq: ");
        r11.append(r10);
        String r12 = " Device state change: 3";
    L9:
        r11.append(r12);
        CaeLog.i(TAG, r11.toString());
        handleDeviceStateChanged(this.mDeviceState);
        return;
    L23:
        return;
    L11:
        if (r10 >= STEP_FREQ_RUNNING_THRESHOLD) goto L18;
        if (r10 < 0.4f) goto L18;
        if (this.mDeviceState == 2) goto L25;
        this.mDeviceState = 2;
        r11 = new StringBuilder("StepFreq: ");
        r11.append(r10);
        r12 = " Device state change: 2";
        goto L9
    L25:
        return;
    L18:
        if (r10 <= STEP_FREQ_STILL_THRESHOLD) goto L20;
        return;
    L20:
        if (this.mDeviceState == 1) goto L27;
        this.mDeviceState = 1;
        r11 = new StringBuilder("StepFreq: ");
        r11.append(r10);
        r12 = " Device state change: 1";
        goto L9
    L27:
        return;
    }

    private void handleDeviceStateChanged(int r8) {
        this.mScanManager.handleDeviceStateChanged(r8);
    }

    private void init() {
        SensorManager r8 = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = r8;
        this.mCounterSensor = r8.getDefaultSensor(19);
    }

    private void processSensorEvent(SensorEvent r8) {
        if (r8.sensor.getType() != 19) goto L15;
        long r10 = System.currentTimeMillis();
        int r11 = (int) r8.values[0];
        StepData r12 = this.mLastedStepData;
        if (r12 == null) goto L11;
        if (r12.getTimestamp() != r10) goto L11;
        StepData.access$302(this.mLastedStepData, r11);
        return;
    L11:
        if (this.mStepDataQueue.size() < 5) goto L13;
        this.mStepDataQueue.poll();
    L13:
        StepData r13 = new StepData(this, r11, r10);
        this.mLastedStepData = r13;
        this.mStepDataQueue.offer(r13);
        this.mFristStepData = this.mStepDataQueue.peek();
        return;
    }

    private void startCalculateDeviceState() {
        CaeLog.d(TAG, "start calculate device state");
        this.mHandler.postDelayed(this.mCalDeviceStateRunnable, 0);
    }

    private void stopCalculateDeviceState() {
        CaeLog.d(TAG, "stop calculate device state");
        this.mHandler.removeCallbacks(this.mCalDeviceStateRunnable);
    }

    public void register() {
        if (this.isRegister == true) goto L6;
        CaeLog.d(TAG, "register STEP_COUNTER Sensor!");
        this.mSensorManager.registerListener(this.mStepListener, this.mCounterSensor, 3);
        startCalculateDeviceState();
        this.isRegister = true;
        return;
    }

    public void unregister() {
        if (this.isRegister == false) goto L6;
        CaeLog.d(TAG, "unregister STEP_COUNTER Sensor!");
        this.mSensorManager.unregisterListener(this.mStepListener, this.mCounterSensor);
        stopCalculateDeviceState();
        this.mDeviceState = 0;
        handleDeviceStateChanged(0);
        this.isRegister = false;
        return;
    }
}
