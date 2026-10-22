package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void disableZ(Canvas r5) {
            r5.disableZ();
        }

        @DoNotInline
        public static void enableZ(Canvas r5) {
            r5.enableZ();
        }
    }

    private CanvasUtils() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void enableZ(@NonNull Canvas r5, boolean r10) {
        if (r10 == false) goto L4;
        Api29Impl.enableZ(r5);
        return;
    L4:
        Api29Impl.disableZ(r5);
    }
}
