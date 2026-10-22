package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(float r10, float r11) {
            return new PathInterpolator(r10, r11);
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(float r10, float r11, float r12, float r13) {
            return new PathInterpolator(r10, r11, r12, r13);
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(Path r10) {
            return new PathInterpolator(r10);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(float r10, float r11) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r10, r11);
    L7:
        return new PathInterpolatorApi14(r10, r11);
    }

    @NonNull
    public static Interpolator create(float r10, float r11, float r12, float r13) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r10, r11, r12, r13);
    L7:
        return new PathInterpolatorApi14(r10, r11, r12, r13);
    }

    @NonNull
    public static Interpolator create(@NonNull Path r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r10);
    L7:
        return new PathInterpolatorApi14(r10);
    }
}
