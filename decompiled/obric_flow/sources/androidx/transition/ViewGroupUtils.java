package androidx.transition;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int getChildDrawingOrder(ViewGroup r5, int r10) {
            return r5.getChildDrawingOrder(r10);
        }

        @DoNotInline
        public static void suppressLayout(ViewGroup r5, boolean r10) {
            r5.suppressLayout(r10);
        }
    }

    private ViewGroupUtils() {
    }

    public static int getChildDrawingOrder(@NonNull ViewGroup r5, int r10) {
        return Api29Impl.getChildDrawingOrder(r5, r10);
    }

    @SuppressLint({"NewApi"})
    private static void hiddenSuppressLayout(@NonNull ViewGroup r5, boolean r10) {
        if (sTryHiddenSuppressLayout == false) goto L10;
        Api29Impl.suppressLayout(r5, r10);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSuppressLayout = false;
        return;
    }

    public static void suppressLayout(@NonNull ViewGroup r5, boolean r10) {
        Api29Impl.suppressLayout(r5, r10);
    }
}
