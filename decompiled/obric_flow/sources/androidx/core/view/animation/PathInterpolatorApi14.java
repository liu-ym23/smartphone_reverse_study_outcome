package androidx.core.view.animation;

import ai.j0;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path r10) {
        PathMeasure r5 = new PathMeasure(r10, false);
        float r11 = r5.getLength();
        int r12 = (int) (r11 / 0.002f);
        int r13 = r12 + 1;
        this.mX = new float[r13];
        this.mY = new float[r13];
        float[] r14 = new float[2];
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r5.getPosTan((r15 * r11) / r12, r14, null);
        this.mX[r15] = r14[0];
        this.mY[r15] = r14[1];
        r15 = r15 + 1;
        goto L3
    }

    private static Path createCubic(float r10, float r11, float r12, float r13) {
        Path r14 = new Path();
        r14.moveTo(0.0f, 0.0f);
        r14.cubicTo(r10, r11, r12, r13, 1.0f, 1.0f);
        return r14;
    }

    private static Path createQuad(float r5, float r10) {
        Path r11 = new Path();
        r11.moveTo(0.0f, 0.0f);
        r11.quadTo(r5, r10, 1.0f, 1.0f);
        return r11;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        if (r10 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r10 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r5 = this.mX.length - 1;
        int r11 = 0;
    L10:
        if ((r5 - r11) <= 1) goto L15;
        int r12 = (r11 + r5) / 2;
        if (r10 < this.mX[r12]) goto L13;
        r11 = r12;
        goto L10
    L13:
        r5 = r12;
        goto L10
    L15:
        float[] r13 = this.mX;
        float r14 = r13[r5];
        float r15 = r13[r11];
        float r16 = r14 - r15;
        if (r16 == 0.0f) goto L18;
        float[] r17 = this.mY;
        float r18 = r17[r11];
        float r19 = r17[r5];
        return j0.b(r19, r18, (r10 - r15) / r16, r18);
    L18:
        return this.mY[r11];
    }

    public PathInterpolatorApi14(float r5, float r10) {
        this(createQuad(r5, r10));
    }

    public PathInterpolatorApi14(float r5, float r10, float r11, float r12) {
        this(createCubic(r5, r10, r11, r12));
    }
}
