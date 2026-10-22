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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    static /* synthetic */ class AnonymousClass1 {
    }

    private class SensorCollectListener implements SensorEventListener {
        final /* synthetic */ SensorInfoManager this$0;

        private SensorCollectListener(SensorInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SensorCollectListener(SensorInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r1, int r2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r4) {
            if (r4.sensor.getType() != 5) goto L10;
            Logger.i("SensorInfoManager: onSensorChanged light");
            LightInfo r0 = new LightInfo();
            r0.lightValue = r4.values[0];
            r0.timestamp = System.currentTimeMillis();
            if (SensorInfoManager.access$100(this.this$0).size() < BDLocationConfig.getMaxLightCount()) goto L8;
            Logger.i("SensorInfoManager: light info count is more than " + BDLocationConfig.getMaxLightCount());
            SensorInfoManager.access$100(this.this$0).poll();
        L8:
            SensorInfoManager.access$100(this.this$0).offer(r0);
            return;
        }
    }

    private class TimeOutTask implements Runnable {
        private int mSensorType;
        final /* synthetic */ SensorInfoManager this$0;

        public TimeOutTask(SensorInfoManager r1, int r2) {
            this.this$0 = r1;
            this.mSensorType = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.i("SensorInfoManager: collect sensor info timeout and sensor type is: " + this.mSensorType);
            this.this$0.unregisterListener(this.mSensorType);
        }
    }

    static {
    }

    private SensorInfoManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mLightInfoQueue = new ConcurrentLinkedQueue();
        Context r5 = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.mContext = r5;
        if (r5 != null) goto L6;
        Logger.i("Context is null!");
        return;
    L6:
        this.mSensorManager = (SensorManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("sensor"), SensorManager.class, "com.obric.memorydata.plugin");
        this.mSensorCollectListener = new SensorCollectListener(this, null);
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    static /* synthetic */ Queue access$100(SensorInfoManager r0) {
        return r0.mLightInfoQueue;
    }

    public static SensorInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SensorInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SensorInfoManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(SensorInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public List<LightInfo> getLightInfoList() {
        return new LinkedList(this.mLightInfoQueue);
    }

    public synchronized void registerListener(int r6) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: registerListener and sensor type is: " + r6);     // Catch: Throwable -> L24 Exception -> L26
        if (r6 != 5) goto L28;
        this.mLightInfoQueue.clear();     // Catch: Throwable -> L24 Exception -> L26
        if (BDLocationConfig.isCollectLightInfo() == false) goto L21;
        SensorManager r7 = this.mSensorManager;     // Catch: Throwable -> L24 Exception -> L26
        if (r7 == null) goto L21;
        this.mLightSensor = this.mBPEAManager.getDefaultSensor(r7, 5, null);     // Catch: Throwable -> L24 Exception -> L26
        StringBuilder r8 = new StringBuilder().append("SensorInfoManager: registerListener and light sensor: ");     // Catch: Throwable -> L24 Exception -> L26
        if (this.mLightSensor == null) goto L13;
        boolean r1 = true;
    L14:
        Logger.i(r8.append(r1).toString());     // Catch: Throwable -> L24 Exception -> L26
        Sensor r9 = this.mLightSensor;     // Catch: Throwable -> L24 Exception -> L26
        if (r9 == null) goto L28;
        this.mSensorManager.registerListener(this.mSensorCollectListener, r9, BDLocationConfig.getLightInfoInterval(), this.mHandler);     // Catch: Throwable -> L24 Exception -> L26
        if (this.mTimeOutTask != null) goto L19;
        this.mTimeOutTask = new TimeOutTask(this, 5);     // Catch: Throwable -> L24 Exception -> L26
    L19:
        this.mHandler.postDelayed(this.mTimeOutTask, BDLocationConfig.getMaxLightDuration());     // Catch: Throwable -> L24 Exception -> L26
        goto L28
    L13:
        r1 = false;
    L21:
        if (BDLocationConfig.isCollectLightInfo() == true) goto L28;
        Logger.i("SensorInfoManager.registerListener: skip register.");     // Catch: Throwable -> L24 Exception -> L26
    L28:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    L26:
        e = move-exception;
        Logger.e("SensorInfoManager: registerListener error", e);     // Catch: Throwable -> L24
        goto L28
    }

    public synchronized void unregisterListener(int r3) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: unregisterListener and sensor type is: " + r3);     // Catch: Throwable -> L17 Exception -> L19
        if (r3 == 5) goto L7;
    L21:
        monitor-exit(this);
        return;
    L7:
        if (BDLocationConfig.isCollectLightInfo() == false) goto L13;
        SensorManager r4 = this.mSensorManager;     // Catch: Throwable -> L17 Exception -> L19
        if (r4 == null) goto L13;
        r4.unregisterListener(this.mSensorCollectListener, this.mLightSensor);     // Catch: Throwable -> L17 Exception -> L19
        String r5 = "SensorInfoManager: unregisterListener and light sensor";
    L11:
        Logger.i(r5);     // Catch: Throwable -> L17 Exception -> L19
    L15:
        this.mLightSensor = null;     // Catch: Throwable -> L17 Exception -> L19
    L13:
        if (BDLocationConfig.isCollectLightInfo() == true) goto L15;
        r5 = "SensorInfoManager.unregisterListener: skip unregister.";
    L19:
        e = move-exception;
        Logger.e("SensorInfoManager: unregisterListener error", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
