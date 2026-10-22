package com.bytedance.bdlocation.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class SensorInfoManager {
    public static final int SENSOR_DELAY_FASTEST = 0;
    public static final int SENSOR_DELAY_GAME = 1;
    public static final int SENSOR_DELAY_NORMAL = 3;
    public static final int SENSOR_DELAY_UI = 2;
    public static final int TYPE_LIGHT = 5;
    private static volatile SensorInfoManager sInstance;
    private IBPEALocal mBPEAManager;
    private Context mContext;
    private Handler mHandler;
    private final Queue<LightInfo> mLightInfoQueue;
    private Sensor mLightSensor;
    private SensorCollectListener mSensorCollectListener;
    private SensorManager mSensorManager;
    private TimeOutTask mTimeOutTask;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.sensor.SensorInfoManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class SensorCollectListener implements SensorEventListener {
        final /* synthetic */ SensorInfoManager this$0;

        private SensorCollectListener(SensorInfoManager r8) {
            this.this$0 = r8;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r8, int r10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r8) {
            if (r8.sensor.getType() != 5) goto L10;
            Logger.i("SensorInfoManager: onSensorChanged light");
            LightInfo r10 = new LightInfo();
            r10.lightValue = r8.values[0];
            r10.timestamp = System.currentTimeMillis();
            if (SensorInfoManager.access$100(this.this$0).size() < BDLocationConfig.getMaxLightCount()) goto L8;
            Logger.i("SensorInfoManager: light info count is more than " + BDLocationConfig.getMaxLightCount());
            SensorInfoManager.access$100(this.this$0).poll();
        L8:
            SensorInfoManager.access$100(this.this$0).offer(r10);
            return;
        }

        public /* synthetic */ SensorCollectListener(SensorInfoManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class TimeOutTask implements Runnable {
        private int mSensorType;
        final /* synthetic */ SensorInfoManager this$0;

        public TimeOutTask(SensorInfoManager r8, int r10) {
            this.this$0 = r8;
            this.mSensorType = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.i("SensorInfoManager: collect sensor info timeout and sensor type is: " + this.mSensorType);
            this.this$0.unregisterListener(this.mSensorType);
        }
    }

    private SensorInfoManager(Context r8) {
        this.mLightInfoQueue = new ConcurrentLinkedQueue();
        this.mContext = r8;
        if (r8 != null) goto L6;
        Logger.i("Context is null!");
        return;
    L6:
        this.mSensorManager = (SensorManager) r8.getSystemService("sensor");
        this.mSensorCollectListener = new SensorCollectListener(this, null);
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    public static /* synthetic */ Queue access$100(SensorInfoManager r8) {
        return r8.mLightInfoQueue;
    }

    public static SensorInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SensorInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SensorInfoManager(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(SensorInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public List<LightInfo> getLightInfoList() {
        return new LinkedList(this.mLightInfoQueue);
    }

    public synchronized void registerListener(int r8) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: registerListener and sensor type is: " + r8);     // Catch: Throwable -> L25 Exception -> L27
        if (r8 != 5) goto L29;
        this.mLightInfoQueue.clear();     // Catch: Throwable -> L25 Exception -> L27
        if (BDLocationConfig.isCollectLightInfo() == false) goto L22;
        SensorManager r10 = this.mSensorManager;     // Catch: Throwable -> L25 Exception -> L27
        if (r10 == null) goto L22;
        this.mLightSensor = this.mBPEAManager.getDefaultSensor(r10, 5, null);     // Catch: Throwable -> L25 Exception -> L27
        StringBuilder r11 = new StringBuilder("SensorInfoManager: registerListener and light sensor: ");     // Catch: Throwable -> L25 Exception -> L27
        if (this.mLightSensor == null) goto L14;
        boolean r12 = true;
    L15:
        r11.append(r12);     // Catch: Throwable -> L25 Exception -> L27
        Logger.i(r11.toString());     // Catch: Throwable -> L25 Exception -> L27
        Sensor r13 = this.mLightSensor;     // Catch: Throwable -> L25 Exception -> L27
        if (r13 == null) goto L29;
        this.mSensorManager.registerListener(this.mSensorCollectListener, r13, BDLocationConfig.getLightInfoInterval(), this.mHandler);     // Catch: Throwable -> L25 Exception -> L27
        if (this.mTimeOutTask != null) goto L20;
        this.mTimeOutTask = new TimeOutTask(this, 5);     // Catch: Throwable -> L25 Exception -> L27
    L20:
        this.mHandler.postDelayed(this.mTimeOutTask, BDLocationConfig.getMaxLightDuration());     // Catch: Throwable -> L25 Exception -> L27
        goto L29
    L14:
        r12 = false;
    L22:
        if (BDLocationConfig.isCollectLightInfo() == true) goto L29;
        Logger.i("SensorInfoManager.registerListener: skip register.");     // Catch: Throwable -> L25 Exception -> L27
    L29:
        monitor-exit(this);
        return;
    L27:
        e = move-exception;
        Logger.e("SensorInfoManager: registerListener error", e);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterListener(int r8) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: unregisterListener and sensor type is: " + r8);     // Catch: Throwable -> L18 Exception -> L20
        if (r8 == 5) goto L8;
    L22:
        monitor-exit(this);
        return;
    L8:
        if (BDLocationConfig.isCollectLightInfo() == false) goto L14;
        SensorManager r10 = this.mSensorManager;     // Catch: Throwable -> L18 Exception -> L20
        if (r10 == null) goto L14;
        r10.unregisterListener(this.mSensorCollectListener, this.mLightSensor);     // Catch: Throwable -> L18 Exception -> L20
        String r11 = "SensorInfoManager: unregisterListener and light sensor";
    L12:
        Logger.i(r11);     // Catch: Throwable -> L18 Exception -> L20
    L16:
        this.mLightSensor = null;     // Catch: Throwable -> L18 Exception -> L20
    L14:
        if (BDLocationConfig.isCollectLightInfo() == true) goto L16;
        r11 = "SensorInfoManager.unregisterListener: skip unregister.";
    L20:
        e = move-exception;
        Logger.e("SensorInfoManager: unregisterListener error", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
