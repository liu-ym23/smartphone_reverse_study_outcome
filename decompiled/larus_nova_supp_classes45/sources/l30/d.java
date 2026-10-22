package l30;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements SensorEventListener {
    public static SensorManager a;
    public static Sensor b;
    public static int c;
    public static final float[] d = null;
    public static final float[] e = null;
    public static final float[] f = null;
    public static Disposable g;
    public static final d h = null;

    public d() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    static {
        h = new d();
        float[] r1 = new float[3];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 3) goto L6;
        r1[r3] = 0.0f;
        r3 = r3 + 1;
        goto L4
    L6:
        d = r1;
        float[] r4 = new float[3];
        int r5 = 0;
    L7:
        if (r5 >= 3) goto L9;
        r4[r5] = 0.0f;
        r5 = r5 + 1;
        goto L7
    L9:
        e = r4;
        float[] r6 = new float[3];
    L10:
        if (r2 >= 3) goto L12;
        r6[r2] = 0.0f;
        r2 = r2 + 1;
        goto L10
    L12:
        f = r6;
    }

    public static final String a() {
        JsonObject r0 = new JsonObject();
        float[] r1 = f;
        r0.addProperty("x", Float.valueOf(r1[0]));
        r0.addProperty("y", Float.valueOf(r1[1]));
        r0.addProperty("z", Float.valueOf(r1[2]));
        return r0.toString();
    }

    public final void c() {
        SensorManager r0 = a;
        if (r0 == null) goto L12;
        Sensor r2 = b;
        if (fna.g.d() == true) goto L7;
        r0.unregisterListener(this, r2);
        goto L12
    L7:
        r0.unregisterListener(this, r2);
        int r3 = hashCode();
        if (r2 == null) goto L10;
        int r4 = r2.hashCode();
    L11:
        ona.b.c(new ona.a(r3, Integer.valueOf(r4)));
        goto L12
    L10:
        r4 = 0;
    L12:
        c = 0;
        a = null;
        b = null;
        Disposable r1 = g;
        if (r1 != null) goto L15;
    L19:
        g = null;
        return;
    L15:
        if (r1.isDisposed() == true) goto L19;
        Disposable r5 = g;
        if (r5 == null) goto L19;
        r5.dispose();
        goto L19
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r18) {
        if (r18 == null) goto L20;
        Sensor r1 = r18.sensor;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getType() != 15) goto L22;
        float[] r2 = r18.values;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.length < 4) goto L25;
        int r3 = c;
        float[] r12 = d;
        if (r3 == 2) goto L17;
        b(r12, r2[0], r2[1], r2[2], r2[3]);
        c++;
    L17:
        if (c != 2) goto L24;
        float[] r4 = e;
        float[] r0 = r18.values;
        b(r4, r0[0], r0[1], r0[2], r0[3]);
        float[] r5 = f;
        r5[0] = r4[0] - r12[0];
        r5[1] = r4[1] - r12[1];
        r5[2] = r4[2] - r12[2];
        return;
    L24:
        return;
    L25:
        return;
    L22:
        return;
    }

    public static void b(float[] r14, double r15, double r17, double r19, double r21) {
        double r3 = 2;
        double r8 = 1;
        double r12 = r17 * r17;
        r14[0] = (float) Math.atan2((((-r21) * r15) + (r17 * r19)) * r3, r8 - (((r15 * r15) + r12) * r3));
        r14[1] = (float) Math.asin(((r21 * r17) - (r15 * r19)) * r3);
        r14[2] = (float) Math.atan2(((r21 * r19) - (r17 * r15)) * r3, r8 - (r3 * (r12 + (r19 * r19))));
    }
}
