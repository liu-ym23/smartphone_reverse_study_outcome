package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class PropertyValuesHolderUtils {
    private PropertyValuesHolderUtils() {
    }

    static PropertyValuesHolder ofPointF(Property<?, PointF> r10, Path r11) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return PropertyValuesHolder.ofObject(r10, null, r11);
    L7:
        return PropertyValuesHolder.ofFloat(new PathProperty(r10, r11), new float[]{0.0f, 1.0f});
    }
}
