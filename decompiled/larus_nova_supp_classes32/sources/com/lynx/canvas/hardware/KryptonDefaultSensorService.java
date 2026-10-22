package com.lynx.canvas.hardware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonSensorService;
import fna.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonDefaultSensorService extends KryptonSensorService {
    private static final String TAG = "KryptonDefaultSensorService";
    private HashMap<Integer, Sensor> mCachedSensors;
    private final Invoker mInvoker;
    private KryptonSensorService.Listener mListener;
    private SensorEventListener mOrientationListener;
    private final SensorManager mSensorManager;

    public interface Invoker {
        boolean registerSensorListener(SensorManager r1, SensorEventListener r2, Sensor r3, int r4);

        void unregisterSensorListener(SensorManager r1, SensorEventListener r2);
    }

    private void initSensorEventListener() {
        this.mOrientationListener = new AnonymousClass1(this);
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public void stop() {
        Invoker r0 = this.mInvoker;
        if (r0 == null) goto L5;
        r0.unregisterSensorListener(this.mSensorManager, this.mOrientationListener);
        return;
    L5:
        INVOKEVIRTUAL_com_lynx_canvas_hardware_KryptonDefaultSensorService_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(this.mSensorManager, this.mOrientationListener);
    }

    public static /* synthetic */ KryptonSensorService.Listener access$000(KryptonDefaultSensorService r0) {
        return r0.mListener;
    }

    private Collection<Sensor> getSensors(List<Integer> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L40;
        HashMap<Integer, Sensor> r0 = this.mCachedSensors;
        if (r0 != null) goto L10;
        this.mCachedSensors = new HashMap();
    L22:
        Iterator<Integer> r5 = r4.iterator();
    L24:
        if (r5.hasNext() == false) goto L29;
        Integer r1 = r5.next();
        Sensor r2 = this.mSensorManager.getDefaultSensor(r1.intValue());
        if (r2 == null) goto L24;
        this.mCachedSensors.put(r1, r2);
        goto L24
    L29:
        return this.mCachedSensors.values();
    L10:
        if (r0.size() == r4.size()) goto L12;
        this.mCachedSensors.clear();
        goto L22
    L12:
        Iterator<Integer> r3 = r4.iterator();
    L14:
        if (r3.hasNext() == false) goto L19;
        Integer r6 = r3.next();
        if (this.mCachedSensors.containsKey(r6) == true) goto L14;
        this.mCachedSensors.clear();
    L19:
        if (this.mCachedSensors.isEmpty() == true) goto L22;
        return this.mCachedSensors.values();
    L40:
        return null;
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public List<Integer> getAvailableSensorTypes(List<Integer> r5) {
        if (this.mSensorManager == null) goto L15;
        if (r5 == null) goto L24;
        ArrayList r0 = new ArrayList();
        Iterator<Integer> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        Integer r1 = r6.next();
        if (r1 == null) goto L8;
        if (this.mSensorManager.getDefaultSensor(r1.intValue()) == null) goto L8;
        r0.add(r1);
        goto L8
    L14:
        return r0;
    L24:
        return null;
    L15:
        return null;
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public void setListener(KryptonSensorService.Listener r1) {
        monitor-enter(this);
        this.mListener = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public KryptonDefaultSensorService(Context r2, Invoker r3) {
        this.mSensorManager = (SensorManager) r2.getSystemService("sensor");
        this.mInvoker = r3;
    }

    public static void INVOKEVIRTUAL_com_lynx_canvas_hardware_KryptonDefaultSensorService_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r1, SensorEventListener r2) {
        if (g.d() == true) goto L6;
        r1.unregisterListener(r2);
        return;
    L6:
        r1.unregisterListener(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        b.c(new a(r3, null));
        return;
    L9:
        r3 = 0;
        goto L10
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public boolean start(List<Integer> r5, int r6) {
        if (this.mSensorManager != null) goto L6;
        KryptonLLog.e(TAG, "get system sensor service error");
        return false;
    L6:
        Collection<Sensor> r7 = getSensors(r5);
        if (r7 != null) goto L9;
    L26:
        KryptonLLog.e(TAG, "start error with empty type list");
        return false;
    L9:
        if (r7.isEmpty() == true) goto L26;
        if (this.mOrientationListener != null) goto L14;
        initSensorEventListener();
    L14:
        int r8 = r6 * 1000;
        Invoker r0 = this.mInvoker;
        if (r0 == null) goto L20;
        r0.unregisterSensorListener(this.mSensorManager, this.mOrientationListener);
        Iterator<Sensor> r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L24;
        Sensor r1 = r9.next();
        this.mInvoker.registerSensorListener(this.mSensorManager, this.mOrientationListener, r1, r8);
        goto L18
    L24:
        return true;
    L20:
        INVOKEVIRTUAL_com_lynx_canvas_hardware_KryptonDefaultSensorService_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(this.mSensorManager, this.mOrientationListener);
        Iterator<Sensor> r10 = r7.iterator();
    L22:
        if (r10.hasNext() == false) goto L30;
        Sensor r2 = r10.next();
        this.mSensorManager.registerListener(this.mOrientationListener, r2, r8);
        goto L22
    L30:
        return true;
    }
}
