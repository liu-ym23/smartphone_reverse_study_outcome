package qa;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class z2 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f11250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Sensor f11251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Sensor f11252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Sensor f11253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f11255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f11256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f11257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f11258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f11259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f11260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f11261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final double[] f11262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile double f11263n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f11265p;

    public z2(Context r8) {
        this.f11250a = null;
        this.f11251b = null;
        this.f11252c = null;
        this.f11253d = null;
        this.f11254e = false;
        this.f11255f = 0.0d;
        this.f11256g = 0.0f;
        this.f11257h = new Handler();
        this.f11258i = 0.0d;
        this.f11259j = 0.0d;
        this.f11260k = 0.0d;
        this.f11261l = 0.0d;
        this.f11262m = new double[3];
        this.f11263n = 0.0d;
        this.f11264o = 0;
        this.f11265p = 0;
    L10:
        th = move-exception;
        t3.g("AMapSensorManager", "<init>", th);
        return;
    L4:
        if (this.f11250a != null) goto L18;
        this.f11250a = (SensorManager) r8.getSystemService("sensor");     // Catch: Throwable -> L10
    L18:
        this.f11251b = this.f11250a.getDefaultSensor(6);     // Catch: Throwable -> L13
    L16:
        this.f11252c = this.f11250a.getDefaultSensor(11);     // Catch: Throwable -> L14
    L20:
        this.f11253d = this.f11250a.getDefaultSensor(1);     // Catch: Throwable -> L15
        return;
    }

    public final void a(float[] r14) {
        double[] r8 = this.f11262m;
        double r10 = r8[0] * 0.800000011920929d;
        float r11 = r14[0];
        double r12 = r10 + ((double) (r11 * 0.19999999f));
        r8[0] = r12;
        double r13 = r8[1] * 0.800000011920929d;
        float r15 = r14[1];
        double r16 = r13 + ((double) (r15 * 0.19999999f));
        r8[1] = r16;
        double r17 = r8[2] * 0.800000011920929d;
        float r18 = r14[2];
        double r19 = r17 + ((double) (0.19999999f * r18));
        r8[2] = r19;
        this.f11258i = ((double) r11) - r12;
        this.f11259j = ((double) r15) - r16;
        this.f11260k = ((double) r18) - r19;
        long r20 = System.currentTimeMillis();
        if ((r20 - this.f11264o) >= 100) goto L5;
        return;
    L5:
        double r21 = this.f11258i;
        double r22 = this.f11259j;
        double r23 = (r22 * r22) + (r21 * r21);
        double r24 = this.f11260k;
        double r25 = Math.sqrt((r24 * r24) + r23);
        this.f11265p++;
        this.f11264o = r20;
        this.f11263n += r25;
        if (this.f11265p < 30) goto L9;
        this.f11261l = this.f11263n / this.f11265p;
        this.f11263n = 0.0d;
        this.f11265p = 0;
        return;
    }

    public final void b() {
        SensorManager r8 = this.f11250a;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.f11254e == false) goto L27;
        this.f11254e = false;
        Sensor r10 = this.f11251b;     // Catch: Throwable -> L17
        if (r10 == null) goto L24;
        r8.unregisterListener(this, r10);     // Catch: Throwable -> L17
    L24:
        Sensor r11 = this.f11252c;     // Catch: Throwable -> L18
        if (r11 == null) goto L22;
        this.f11250a.unregisterListener(this, r11);     // Catch: Throwable -> L18
    L22:
        Sensor r12 = this.f11253d;     // Catch: Throwable -> L19
        if (r12 == null) goto L28;
        this.f11250a.unregisterListener(this, r12);     // Catch: Throwable -> L19
        return;
    L28:
        return;
    L29:
        return;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r8, int r10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r8) {
        if (r8 != null) goto L35;
        return;
    L35:
        int r10 = r8.sensor.getType();     // Catch: Throwable -> L30
        if (r10 == 1) goto L25;
        if (r10 != 6) goto L10;
        if (this.f11251b == null) goto L39;
        this.f11255f = (float) (((long) (((double) SensorManager.getAltitude(1013.25f, ((float[]) r8.values.clone())[0])) * 100.0d)) / 100.0d);     // Catch: Throwable -> L29
        return;
    L39:
        return;
    L40:
        return;
    L10:
        if (r10 != 11) goto L42;
        if (this.f11252c == null) goto L37;
        float[] r11 = new float[9];     // Catch: Throwable -> L28
        SensorManager.getRotationMatrixFromVector(r11, (float[]) r8.values.clone());     // Catch: Throwable -> L28
        float[] r12 = new float[3];     // Catch: Throwable -> L28
        SensorManager.getOrientation(r11, r12);     // Catch: Throwable -> L28
        float r13 = (float) Math.toDegrees(r12[0]);     // Catch: Throwable -> L28
        this.f11256g = r13;     // Catch: Throwable -> L28
        if (r13 > 0.0f) goto L18;
        r13 = r13 + 360.0f;     // Catch: Throwable -> L28
    L18:
        this.f11256g = (float) Math.floor(r13);     // Catch: Throwable -> L28
        return;
    L37:
        return;
    L38:
        return;
    L42:
        return;
    L25:
        if (this.f11253d == null) goto L41;
        a((float[]) r8.values.clone());     // Catch: Throwable -> L30
        return;
    L41:
        return;
    }
}
