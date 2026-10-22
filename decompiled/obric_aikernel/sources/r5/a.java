package r5;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f12673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f12674b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f12675c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f12676d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f12677e = null;

    static {
        f12673a = new LinearInterpolator();
        f12674b = new FastOutSlowInInterpolator();
        f12675c = new FastOutLinearInInterpolator();
        f12676d = new LinearOutSlowInInterpolator();
        f12677e = new DecelerateInterpolator();
    }

    public static float a(float r10, float r11, float r12) {
        return r10 + (r12 * (r11 - r10));
    }

    public static float b(float r10, float r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d, to = 1.0d) float r14) {
        if (r14 >= r12) goto L6;
        return r10;
    L6:
        if (r14 <= r13) goto L9;
        return r11;
    L9:
        return a(r10, r11, (r14 - r12) / (r13 - r12));
    }

    public static int c(int r10, int r11, float r12) {
        return r10 + Math.round(r12 * (r11 - r10));
    }
}
