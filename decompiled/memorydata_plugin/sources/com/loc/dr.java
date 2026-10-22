package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class dr implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SensorManager f5464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Sensor f5465b;
    Sensor c;
    Sensor d;
    public boolean e;
    public double f;
    public float g;
    Handler h;
    double i;
    double j;
    double k;
    double l;
    double[] m;
    volatile double n;
    long o;
    long p;
    final int q;
    final int r;
    private Context s;
    private float t;
    private float u;

    public dr(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.s = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.f5464a = null;
        this.f5465b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = 0.0d;
        this.g = 0.0f;
        this.t = 1013.25f;
        this.u = 0.0f;
        this.h = new Handler();
        this.i = 0.0d;
        this.j = 0.0d;
        this.k = 0.0d;
        this.l = 0.0d;
        this.m = new double[3];
        this.n = 0.0d;
        this.o = 0;
        this.p = 0;
        this.q = 100;
        this.r = 30;
        Context r8 = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        this.s = r8;     // Catch: Throwable -> L10
        if (this.f5464a != null) goto L16;
        this.f5464a = (SensorManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("sensor"), SensorManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L16:
        this.f5465b = this.f5464a.getDefaultSensor(6);     // Catch: Throwable -> L13
    L22:
        this.c = this.f5464a.getDefaultSensor(11);     // Catch: Throwable -> L14
    L18:
        this.d = this.f5464a.getDefaultSensor(1);     // Catch: Throwable -> L15
        return;
    L24:
        return;
    L10:
        th = move-exception;
        ev.a(th, "AMapSensorManager", "<init>");
    }

    private void a(float[] r13) {
        double[] r0 = this.m;
        r0[0] = (r0[0] * 0.800000011920929d) + ((double) (r13[0] * 0.19999999f));
        r0[1] = (r0[1] * 0.800000011920929d) + ((double) (r13[1] * 0.19999999f));
        r0[2] = (r0[2] * 0.800000011920929d) + ((double) (r13[2] * 0.19999999f));
        this.i = ((double) r13[0]) - r0[0];
        this.j = ((double) r13[1]) - r0[1];
        this.k = ((double) r13[2]) - r0[2];
        long r1 = System.currentTimeMillis();
        if ((r1 - this.o) >= 100) goto L5;
        return;
    L5:
        double r2 = this.i;
        double r4 = this.j;
        double r3 = (r2 * r2) + (r4 * r4);
        double r5 = this.k;
        double r6 = Math.sqrt(r3 + (r5 * r5));
        this.p++;
        this.o = r1;
        this.n += r6;
        if (this.p < 30) goto L9;
        this.l = this.n / this.p;
        this.n = 0.0d;
        this.p = 0;
        return;
    }

    private void b(float[] r3) {
        if (r3 == null) goto L5;
        this.f = fd.a(SensorManager.getAltitude(this.t, r3[0]));
        return;
    }

    private void c(float[] r3) {
        if (r3 == null) goto L9;
        float[] r0 = new float[9];
        SensorManager.getRotationMatrixFromVector(r0, r3);
        float[] r4 = new float[3];
        SensorManager.getOrientation(r0, r4);
        float r5 = (float) Math.toDegrees(r4[0]);
        this.u = r5;
        if (r5 > 0.0f) goto L7;
        r5 = r5 + 360.0f;
    L7:
        this.u = (float) Math.floor(r5);
        return;
    }

    public final void a() {
        SensorManager r1 = this.f5464a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (this.e == true) goto L34;
        this.e = true;
        Sensor r3 = this.f5465b;     // Catch: Throwable -> L11
        if (r3 == null) goto L28;
        r1.registerListener(this, r3, 3, this.h);     // Catch: Throwable -> L11
    L28:
        Sensor r2 = this.c;     // Catch: Throwable -> L17
        if (r2 == null) goto L30;
        this.f5464a.registerListener(this, r2, 3, this.h);     // Catch: Throwable -> L17
    L30:
        Sensor r4 = this.d;     // Catch: Throwable -> L23
        if (r4 == null) goto L32;
        this.f5464a.registerListener(this, r4, 3, this.h);     // Catch: Throwable -> L23
        return;
    L32:
        return;
    L23:
        th = move-exception;
        ev.a(th, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        return;
    L17:
        th = move-exception;
        ev.a(th, "AMapSensorManager", "registerListener mRotationVector");
    L11:
        th = move-exception;
        ev.a(th, "AMapSensorManager", "registerListener mPressure");
        goto L28
    }

    public final void b() {
        SensorManager r0 = this.f5464a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.e == false) goto L27;
        this.e = false;
        Sensor r1 = this.f5465b;     // Catch: Throwable -> L17
        if (r1 == null) goto L24;
        r0.unregisterListener(this, r1);     // Catch: Throwable -> L17
    L24:
        Sensor r2 = this.c;     // Catch: Throwable -> L18
        if (r2 == null) goto L22;
        this.f5464a.unregisterListener(this, r2);     // Catch: Throwable -> L18
    L22:
        Sensor r3 = this.d;     // Catch: Throwable -> L19
        if (r3 == null) goto L28;
        this.f5464a.unregisterListener(this, r3);     // Catch: Throwable -> L19
        return;
    L28:
        return;
    L29:
        return;
    }

    public final double c() {
        return this.f;
    }

    public final float d() {
        return this.u;
    }

    public final double e() {
        return this.l;
    }

    public final void f() {
        b();     // Catch: Throwable -> L4
        this.f5465b = null;     // Catch: Throwable -> L4
        this.c = null;     // Catch: Throwable -> L4
        this.f5464a = null;     // Catch: Throwable -> L4
        this.d = null;     // Catch: Throwable -> L4
        this.e = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "AMapSensorManager", "destroy");
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r5) {
        if (r5 != null) goto L33;
        return;
    L33:
        int r1 = r5.sensor.getType();     // Catch: Throwable -> L30
        if (r1 == 1) goto L25;
        if (r1 != 6) goto L11;
        if (this.f5465b == null) goto L39;
        float[] r6 = (float[]) ZeusTransformUtils.preCheckCast(r5.values.clone(), float[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r6 == null) goto L22;
        this.g = r6[0];     // Catch: Throwable -> L29
    L22:
        b(r6);     // Catch: Throwable -> L29
        return;
    L39:
        return;
    L40:
        return;
    L11:
        if (r1 != 11) goto L42;
        if (this.c == null) goto L37;
        c((float[]) ZeusTransformUtils.preCheckCast(r5.values.clone(), float[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        return;
    L37:
        return;
    L38:
        return;
    L42:
        return;
    L25:
        if (this.d == null) goto L41;
        a((float[]) ZeusTransformUtils.preCheckCast(r5.values.clone(), float[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
        return;
    L41:
        return;
    }
}
