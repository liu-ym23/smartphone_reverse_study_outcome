package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Interpolator createPathInterpolator(Path r5) {
            return new PathInterpolator(r5);
        }

        @DoNotInline
        public static Interpolator createPathInterpolator(float r5, float r10) {
            return new PathInterpolator(r5, r10);
        }

        @DoNotInline
        public static Interpolator createPathInterpolator(float r5, float r10, float r11, float r12) {
            return new PathInterpolator(r5, r10, r11, r12);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path r5) {
        return Api21Impl.createPathInterpolator(r5);
    }

    @NonNull
    public static Interpolator create(float r5, float r10) {
        return Api21Impl.createPathInterpolator(r5, r10);
    }

    @NonNull
    public static Interpolator create(float r5, float r10, float r11, float r12) {
        return Api21Impl.createPathInterpolator(r5, r10, r11, r12);
    }
}
