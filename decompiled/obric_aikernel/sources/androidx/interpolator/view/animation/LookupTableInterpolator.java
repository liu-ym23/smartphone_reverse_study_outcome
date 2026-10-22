package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected LookupTableInterpolator(float[] r10) {
        this.mValues = r10;
        this.mStepSize = 1.0f / (r10.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        if (r10 < 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r10 > 0.0f) goto L8;
        return 0.0f;
    L8:
        float[] r11 = this.mValues;
        int r12 = Math.min((int) ((r11.length - 1) * r10), r11.length - 2);
        float r13 = this.mStepSize;
        float r14 = (r10 - (r12 * r13)) / r13;
        float[] r15 = this.mValues;
        return r15[r12] + (r14 * (r15[r12 + 1] - r15[r12]));
    }
}
