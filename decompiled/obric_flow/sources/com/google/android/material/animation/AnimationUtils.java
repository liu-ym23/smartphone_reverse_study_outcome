package com.google.android.material.animation;

import ai.j0;
import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = null;
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = null;
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = null;
    public static final TimeInterpolator LINEAR_INTERPOLATOR = null;
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = null;

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
        FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
        LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
        DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    }

    public AnimationUtils() {
    }

    public static float lerp(float r5, float r10, float r11) {
        return j0.b(r10, r5, r11, r5);
    }

    public static int lerp(int r5, int r10, float r11) {
        return Math.round(r11 * (r10 - r5)) + r5;
    }

    public static float lerp(float r5, float r10, float r11, float r12, float r13) {
        if (r13 > r11) goto L6;
        return r5;
    L6:
        if (r13 < r12) goto L9;
        return r10;
    L9:
        return lerp(r5, r10, (r13 - r11) / (r12 - r11));
    }
}
