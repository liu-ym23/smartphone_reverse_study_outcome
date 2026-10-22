package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
class PropertyValuesHolderUtils {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static <V> PropertyValuesHolder ofObject(Property<?, V> r5, Path r10) {
            return PropertyValuesHolder.ofObject(r5, null, r10);
        }
    }

    private PropertyValuesHolderUtils() {
    }

    public static PropertyValuesHolder ofPointF(Property<?, PointF> r5, Path r10) {
        return Api21Impl.ofObject(r5, r10);
    }
}
