package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static Interpolator createPathInterpolator(float r1, float r2) {
            return new PathInterpolator(r1, r2);
        }

        static Interpolator createPathInterpolator(float r1, float r2, float r3, float r4) {
            return new PathInterpolator(r1, r2, r3, r4);
        }

        static Interpolator createPathInterpolator(Path r1) {
            return new PathInterpolator(r1);
        }
    }

    private PathInterpolatorCompat() {
    }

    public static Interpolator create(float r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r2, r3);
    L7:
        return new PathInterpolatorApi14(r2, r3);
    }

    public static Interpolator create(float r2, float r3, float r4, float r5) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r2, r3, r4, r5);
    L7:
        return new PathInterpolatorApi14(r2, r3, r4, r5);
    }

    public static Interpolator create(Path r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r2);
    L7:
        return new PathInterpolatorApi14(r2);
    }
}
