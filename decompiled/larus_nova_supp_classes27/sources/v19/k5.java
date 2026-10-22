package v19;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class k5 implements Interpolator {
    public int a;
    public final PointF b;
    public final PointF c;

    public static final class a {
        public static double a(double r12, double r14, double r16) {
            double r0 = ((double) 1) - r12;
            double r2 = r12 * r12;
            double r4 = r0 * r0;
            double r10 = 3;
            return ((((r4 * r0) * 0.0d) + (((r4 * r10) * r12) * r14)) + (((r10 * r0) * r2) * r16)) + ((r2 * r12) * 1.0d);
        }
    }

    static {
    }

    public k5() {
        this.b = new PointF();
        this.c = new PointF();
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r9) {
        int r0 = this.a;
        float r1 = r9;
    L4:
        if (r0 >= 4096) goto L9;
        r1 = (r0 * 1.0f) / 4096;
        if (a.a(r1, this.b.x, this.c.x) >= r9) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        this.a = r0;
    L9:
        double r2 = a.a(r1, this.b.y, this.c.y);
        if (r2 <= 0.999d) goto L13;
        this.a = 0;
        r2 = 1.0d;
    L13:
        return (float) r2;
    }
}
