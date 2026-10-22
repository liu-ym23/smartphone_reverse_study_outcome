package n4a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i3 implements SensorEventListener {
    public SensorManager a;
    public Sensor b;
    public Sensor c;
    public Sensor d;
    public boolean e;
    public double f;
    public float g;
    public final Handler h;
    public double i;
    public double j;
    public double k;
    public double l;
    public final double[] m;
    public volatile double n;
    public long o;
    public long p;

    public i3(Context r4) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = 0.0d;
        this.g = 0.0f;
        this.h = new Handler();
        this.i = 0.0d;
        this.j = 0.0d;
        this.k = 0.0d;
        this.l = 0.0d;
        this.m = new double[3];
        this.n = 0.0d;
        this.o = 0;
        this.p = 0;
    L10:
        th = move-exception;
        c4.g(th, "AMapSensorManager", "<init>");
        return;
    L4:
        if (this.a != null) goto L18;
        this.a = (SensorManager) r4.getSystemService("sensor");     // Catch: Throwable -> L10
    L18:
        this.b = this.a.getDefaultSensor(6);     // Catch: Throwable -> L13
    L16:
        this.c = this.a.getDefaultSensor(11);     // Catch: Throwable -> L14
    L20:
        this.d = this.a.getDefaultSensor(1);     // Catch: Throwable -> L15
        return;
    }

    public final void c(float[] r14) {
        double[] r0 = this.m;
        double r2 = r0[0] * 0.800000011920929d;
        float r6 = r14[0];
        double r3 = r2 + ((double) (r6 * 0.19999999f));
        r0[0] = r3;
        double r8 = r0[1] * 0.800000011920929d;
        float r10 = r14[1];
        double r9 = r8 + ((double) (r10 * 0.19999999f));
        r0[1] = r9;
        double r11 = r0[2] * 0.800000011920929d;
        float r15 = r14[2];
        double r12 = r11 + ((double) (0.19999999f * r15));
        r0[2] = r12;
        this.i = ((double) r6) - r3;
        this.j = ((double) r10) - r9;
        this.k = ((double) r15) - r12;
        long r1 = System.currentTimeMillis();
        if ((r1 - this.o) >= 100) goto L5;
        return;
    L5:
        double r4 = this.i;
        double r5 = this.j;
        double r7 = (r4 * r4) + (r5 * r5);
        double r13 = this.k;
        double r16 = Math.sqrt(r7 + (r13 * r13));
        this.p++;
        this.o = r1;
        this.n += r16;
        if (this.p < 30) goto L9;
        this.l = this.n / this.p;
        this.n = 0.0d;
        this.p = 0;
        return;
    }

    public final void d() {
        SensorManager r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.e == false) goto L27;
        this.e = false;
        Sensor r1 = this.b;     // Catch: Throwable -> L17
        if (r1 == null) goto L24;
        b(r0, this, r1);     // Catch: Throwable -> L17
    L24:
        Sensor r2 = this.c;     // Catch: Throwable -> L18
        if (r2 == null) goto L22;
        b(this.a, this, r2);     // Catch: Throwable -> L18
    L22:
        Sensor r3 = this.d;     // Catch: Throwable -> L19
        if (r3 == null) goto L28;
        b(this.a, this, r3);     // Catch: Throwable -> L19
        return;
    L28:
        return;
    L29:
        return;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r5) {
        if (r5 != null) goto L35;
        return;
    L35:
        int r0 = r5.sensor.getType();     // Catch: Throwable -> L30
        if (r0 == 1) goto L25;
        if (r0 != 6) goto L10;
        if (this.b == null) goto L39;
        this.f = (float) (((long) (((double) SensorManager.getAltitude(1013.25f, ((float[]) r5.values.clone())[0])) * 100.0d)) / 100.0d);     // Catch: Throwable -> L29
        return;
    L39:
        return;
    L40:
        return;
    L10:
        if (r0 != 11) goto L42;
        if (this.c == null) goto L37;
        float[] r1 = new float[9];     // Catch: Throwable -> L28
        SensorManager.getRotationMatrixFromVector(r1, (float[]) r5.values.clone());     // Catch: Throwable -> L28
        float[] r6 = new float[3];     // Catch: Throwable -> L28
        SensorManager.getOrientation(r1, r6);     // Catch: Throwable -> L28
        float r7 = (float) Math.toDegrees(r6[0]);     // Catch: Throwable -> L28
        this.g = r7;     // Catch: Throwable -> L28
        if (r7 > 0.0f) goto L18;
        r7 = r7 + 360.0f;     // Catch: Throwable -> L28
    L18:
        this.g = (float) Math.floor(r7);     // Catch: Throwable -> L28
        return;
    L37:
        return;
    L38:
        return;
    L42:
        return;
    L25:
        if (this.d == null) goto L41;
        c((float[]) r5.values.clone());     // Catch: Throwable -> L30
        return;
    L41:
        return;
    }

    public static void b(SensorManager r1, SensorEventListener r2, Sensor r3) {
        if (fna.g.d() == true) goto L6;
        r1.unregisterListener(r2, r3);
        return;
    L6:
        r1.unregisterListener(r2, r3);
        int r0 = 0;
        if (r2 == null) goto L9;
        int r4 = r2.hashCode();
    L10:
        if (r3 == null) goto L12;
        r0 = r3.hashCode();
    L12:
        ona.b.c(new ona.a(r4, Integer.valueOf(r0)));
        return;
    L9:
        r4 = 0;
        goto L10
    }

    public static void a(SensorManager r3, i3 r4, Sensor r5, Handler r6) {
        if (fna.g.d() == true) goto L6;
        Boolean r7 = Boolean.valueOf(r3.registerListener(r4, r5, 3, r6));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Boolean");
        r7.booleanValue();
        return;
    L6:
        Boolean r8 = Boolean.valueOf(r3.registerListener(r4, r5, 3, r6));
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Boolean");
        r8.booleanValue();
        int r9 = r4.hashCode();
        if (r5 == null) goto L9;
        int r10 = r5.hashCode();
    L10:
        ona.b.a(new ona.a(r9, Integer.valueOf(r10)));
        return;
    L9:
        r10 = 0;
        goto L10
    }
}
