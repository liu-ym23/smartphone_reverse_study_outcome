package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    PathInterpolatorApi14(float r10, float r11) {
        this(createQuad(r10, r11));
    }

    PathInterpolatorApi14(float r10, float r11, float r12, float r13) {
        this(createCubic(r10, r11, r12, r13));
    }

    PathInterpolatorApi14(Path r10) {
        PathMeasure r11 = new PathMeasure(r10, false);
        float r12 = r11.getLength();
        int r13 = ((int) (r12 / 0.002f)) + 1;
        this.mX = new float[r13];
        this.mY = new float[r13];
        float[] r14 = new float[2];
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r11.getPosTan((r15 * r12) / (r13 - 1), r14, null);
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

    private static Path createQuad(float r10, float r11) {
        Path r12 = new Path();
        r12.moveTo(0.0f, 0.0f);
        r12.quadTo(r10, r11, 1.0f, 1.0f);
        return r12;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        if (r10 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r10 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r11 = 0;
        int r12 = this.mX.length - 1;
    L10:
        if ((r12 - r11) <= 1) goto L15;
        int r13 = (r11 + r12) / 2;
        if (r10 < this.mX[r13]) goto L13;
        r11 = r13;
        goto L10
    L13:
        r12 = r13;
        goto L10
    L15:
        float[] r14 = this.mX;
        float r15 = r14[r12] - r14[r11];
        if (r15 == 0.0f) goto L18;
        float r16 = (r10 - r14[r11]) / r15;
        float[] r17 = this.mY;
        float r18 = r17[r11];
        return r18 + (r16 * (r17[r12] - r18));
    L18:
        return this.mY[r11];
    }
}
