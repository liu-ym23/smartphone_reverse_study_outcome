package androidx.recyclerview.base;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class SmoothInterpolator extends BaseInterpolator {
    private static final float NORMALIZATION_FACTOR = 1.0011656f;
    private static final float OMEGA = 9.06472f;

    public SmoothInterpolator() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r5) {
        return Math.min(1.0f, (1.0f - (((OMEGA * r5) + 1.0f) * ((float) Math.exp(r5 * (-9.06472f))))) * NORMALIZATION_FACTOR);
    }
}
