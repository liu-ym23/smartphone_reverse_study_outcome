package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
class ObjectAnimatorUtils {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static <T, V> ObjectAnimator ofObject(T r5, Property<T, V> r10, Path r11) {
            return ObjectAnimator.ofObject(r5, r10, null, r11);
        }
    }

    private ObjectAnimatorUtils() {
    }

    public static <T> ObjectAnimator ofPointF(T r5, Property<T, PointF> r10, Path r11) {
        return Api21Impl.ofObject(r5, r10, r11);
    }
}
