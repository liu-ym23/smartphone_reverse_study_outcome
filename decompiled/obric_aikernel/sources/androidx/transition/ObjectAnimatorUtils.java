package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    static <T> ObjectAnimator ofPointF(T r10, Property<T, PointF> r11, Path r12) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return ObjectAnimator.ofObject(r10, r11, null, r12);
    L7:
        return ObjectAnimator.ofFloat(r10, new PathProperty(r11, r12), new float[]{0.0f, 1.0f});
    }
}
