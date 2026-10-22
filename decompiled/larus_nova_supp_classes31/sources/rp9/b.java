package rp9;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements Interpolator {
    public final PointF a;
    public final PointF b;

    public static float a(float r3, float r4, float r5) {
        if (r3 != 0.0f) goto L5;
    L9:
        return r3;
    L5:
        if (r3 == 1.0f) goto L9;
        float r2 = ((r4 - 0.0f) * r3) + 0.0f;
        float r6 = r4 + ((r5 - r4) * r3);
        float r7 = r2 + ((r6 - r2) * r3);
        return r7 + (((r6 + (((r5 + ((1.0f - r5) * r3)) - r6) * r3)) - r7) * r3);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r19) {
        float r1 = 0.0f;
        if (r19 <= 0.0f) goto L31;
        if (r19 < 1.0f) goto L8;
        r1 = 1.0f;
        goto L31
    L8:
        int r3 = 0;
        r1 = r19;
        float r2 = 0.0f;
        float r4 = 0.0f;
        float r5 = 1.0f;
        int r6 = 0;
    L10:
        if (r6 >= 8) goto L23;
        r4 = a(r1, this.a.x, this.b.x);
        double r9 = (a(r1 + 1.0E-6f, this.a.x, this.b.x) - r4) / 1.0E-6f;
        float r11 = r4 - r19;
        if (Math.abs(r11) < 1.0E-6f) goto L31;
        if (Math.abs(r9) < 9.999999974752427E-7d) goto L23;
        if (r4 >= r19) goto L20;
        r2 = r1;
    L21:
        r1 = (float) (((double) r1) - (((double) r11) / r9));
        r6 = r6 + 1;
        goto L10
    L20:
        r5 = r1;
    L23:
        if (Math.abs(r4 - r19) <= 1.0E-6f) goto L31;
        if (r3 >= 8) goto L31;
        if (r4 >= r19) goto L28;
        r2 = r1;
        r1 = (r1 + r5) / 2.0f;
    L29:
        r4 = a(r1, this.a.x, this.b.x);
        r3 = r3 + 1;
        goto L23
    L28:
        r5 = r1;
        r1 = (r1 + r2) / 2.0f;
    L31:
        return a(r1, this.a.y, this.b.y);
    }

    public b(PointF r7, PointF r8) {
        float r0 = r7.x;
        boolean r1 = true;
        if (r0 >= 0.0f) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L21;
        float r3 = r8.x;
        if (r3 >= 0.0f) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L19;
        this.a = r7;
        this.b = r8;
        new PointF();
        new PointF();
        new PointF();
        return;
    L19:
        throw new RuntimeException("endX should be in [0, 1]");
    L12:
        if (r3 > 1.0f) goto L14;
    L21:
        throw new RuntimeException("startX should be in [0, 1]");
    L5:
        if (r0 > 1.0f) goto L7;
        r2 = true;
        goto L8
    }
}
