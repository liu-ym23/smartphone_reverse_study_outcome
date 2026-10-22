package androidx.core.view;

import android.os.Build;
import android.view.ScaleGestureDetector;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean isQuickScaleEnabled(ScaleGestureDetector r0) {
            return r0.isQuickScaleEnabled();
        }

        static void setQuickScaleEnabled(ScaleGestureDetector r0, boolean r1) {
            r0.setQuickScaleEnabled(r1);
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isQuickScaleEnabled(r2);
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object r2) {
        return isQuickScaleEnabled((ScaleGestureDetector) ZeusTransformUtils.preCheckCast(r2, ScaleGestureDetector.class, "com.obric.memorydata.plugin"));
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setQuickScaleEnabled(r2, r3);
        return;
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object r2, boolean r3) {
        setQuickScaleEnabled((ScaleGestureDetector) ZeusTransformUtils.preCheckCast(r2, ScaleGestureDetector.class, "com.obric.memorydata.plugin"), r3);
    }
}
