package androidx.core.view;

import android.os.Build;
import android.view.ScaleGestureDetector;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static boolean isQuickScaleEnabled(ScaleGestureDetector r10) {
            return r10.isQuickScaleEnabled();
        }

        @DoNotInline
        static void setQuickScaleEnabled(ScaleGestureDetector r10, boolean r11) {
            r10.setQuickScaleEnabled(r11);
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(@NonNull ScaleGestureDetector r10) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isQuickScaleEnabled(r10);
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object r10) {
        return isQuickScaleEnabled((ScaleGestureDetector) r10);
    }

    public static void setQuickScaleEnabled(@NonNull ScaleGestureDetector r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setQuickScaleEnabled(r10, r11);
        return;
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object r10, boolean r11) {
        setQuickScaleEnabled((ScaleGestureDetector) r10, r11);
    }
}
