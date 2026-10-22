package androidx.core.view;

import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object r5) {
        return isQuickScaleEnabled((ScaleGestureDetector) r5);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object r5, boolean r10) {
        setQuickScaleEnabled((ScaleGestureDetector) r5, r10);
    }

    public static boolean isQuickScaleEnabled(@NonNull ScaleGestureDetector r5) {
        return r5.isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(@NonNull ScaleGestureDetector r5, boolean r10) {
        r5.setQuickScaleEnabled(r10);
    }
}
