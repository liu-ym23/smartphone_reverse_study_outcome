package androidx.interpolator.view.animation;

import ai.j0;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] r5) {
        this.mValues = r5;
        this.mStepSize = 1.0f / (r5.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r5) {
        if (r5 < 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r5 > 0.0f) goto L8;
        return 0.0f;
    L8:
        float[] r10 = this.mValues;
        int r11 = Math.min((int) ((r10.length - 1) * r5), r10.length - 2);
        float r12 = this.mStepSize;
        float r13 = (r5 - (r11 * r12)) / r12;
        float[] r14 = this.mValues;
        float r15 = r14[r11];
        return j0.b(r14[r11 + 1], r15, r13, r15);
    }
}
