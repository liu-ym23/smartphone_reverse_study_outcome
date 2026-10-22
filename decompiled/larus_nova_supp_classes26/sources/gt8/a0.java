package gt8;

import android.graphics.PointF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 {
    public final PointF a;
    public final PointF b;
    public final PointF c;

    public static final class a {
    }

    static {
    }

    public final float a() {
        PointF r0 = this.b;
        float r1 = r0.y;
        PointF r2 = this.a;
        float r3 = r2.y;
        float r4 = (r1 - r3) * (r1 - r3);
        float r5 = r0.x;
        float r6 = r2.x;
        return (float) Math.sqrt(r4 + ((r5 - r6) * (r5 - r6)));
    }

    public final String toString() {
        return "/n1.  " + this.a + "/n；2. " + this.b;
    }

    public a0(float r2, float r3, float r4, float r5) {
        this.a = new PointF(r2, r3);
        this.b = new PointF(r4, r5);
        float r6 = r2 + r4;
        float r7 = 2;
        this.c = new PointF(r6 / r7, (r3 + r5) / r7);
    }
}
