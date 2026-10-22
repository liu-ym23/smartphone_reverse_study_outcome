package com.lynx.canvas.hardware;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonSensorService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class HardwareManager implements KryptonSensorService.Listener {
    private static final int GYROSCOPE_SENSOR_AVAILABLE = 2;
    private static final ArrayList<Integer> MONITOR_GYROSCOPE_TYPE_LIST = null;
    private static final int ORIENTATION_SENSOR_AVAILABLE = 4;
    private static final int SENSOR_AVAILABILITY_KNOWN = 1;
    private static final String TAG = "KryptonHardwareManager";
    private final long mNativePtr;
    private boolean mReleased;
    private KryptonSensorService mSensorService;

    private static native void nativeNotifyGyroscopeData(long r0, float r2, float r3, float r4, long r5);

    private static native void nativeNotifyOrientationData(long r0, float r2, float r3, float r4, long r5);

    private static ArrayList<Integer> monitorGyroscopeSensorTypeList() {
        ArrayList<Integer> r0 = new ArrayList();
        r0.add(new Integer(4));
        r0.add(new Integer(15));
        return r0;
    }

    private void stopMonitorGyroscope() {
        KryptonSensorService r0 = this.mSensorService;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    static {
        MONITOR_GYROSCOPE_TYPE_LIST = monitorGyroscopeSensorTypeList();
    }

    private void release() {
        stopMonitorGyroscope();
        monitor-enter(this);
        this.mReleased = true;     // Catch: Throwable -> L10
        KryptonSensorService r0 = this.mSensorService;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        r0.setListener(null);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private int startMonitorGyroscope(int r5) {
        KryptonSensorService r0 = this.mSensorService;
        int r1 = 0;
        if (r0 != null) goto L6;
        KryptonLLog.e(TAG, "startMonitorGyroscope error: no sensor service");
        return 0;
    L6:
        ArrayList<Integer> r2 = MONITOR_GYROSCOPE_TYPE_LIST;
        List<Integer> r3 = r0.getAvailableSensorTypes(r2);
        if (r3 != null) goto L9;
    L15:
        this.mSensorService.start(r2, r5);
        return r1;
    L9:
        if (r3.contains(4) == false) goto L11;
        r1 = 3;
    L13:
        if (r3.contains(15) == false) goto L15;
        r1 = r1 | 4;
        goto L15
    L11:
        r1 = 1;
        goto L13
    }

    public HardwareManager(long r1, KryptonApp r3) {
        this.mNativePtr = r1;
        KryptonSensorService r2 = (KryptonSensorService) r3.getService(KryptonSensorService.class);
        this.mSensorService = r2;
        if (r2 == null) goto L5;
        r2.setListener(this);
        return;
    L5:
        KryptonLLog.e(TAG, "no sensor service found");
    }

    private static HardwareManager createInstance(long r1, KryptonApp r3) {
        return new HardwareManager(r1, r3);
    }

    @Override // com.lynx.canvas.KryptonSensorService.Listener
    public void notifyGyroscopeData(float r9, float r10, float r11, long r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mReleased == true) goto L6;
        nativeNotifyGyroscopeData(this.mNativePtr, r9, r10, r11, r12);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    @Override // com.lynx.canvas.KryptonSensorService.Listener
    public void notifyOrientationData(float r9, float r10, float r11, long r12) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mReleased == true) goto L6;
        nativeNotifyOrientationData(this.mNativePtr, r9, r10, r11, r12);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }
}
