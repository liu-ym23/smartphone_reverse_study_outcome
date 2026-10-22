package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    static {
    }

    private ViewGroupUtils() {
    }

    static int getChildDrawingOrder(@NonNull ViewGroup r10, int r11) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return r10.getChildDrawingOrder(r11);
    L7:
        if (sGetChildDrawingOrderMethodFetched == false) goto L19;
    L10:
        Method r12 = sGetChildDrawingOrderMethod;
        if (r12 != null) goto L17;
    L14:
        return r11;
    L17:
        return ((Integer) r12.invoke(r10, new Object[]{Integer.valueOf(r10.getChildCount()), Integer.valueOf(r11)})).intValue();
    L19:
        Class r13 = Integer.TYPE;     // Catch: NoSuchMethodException -> L16
        Method r14 = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[]{r13, r13});     // Catch: NoSuchMethodException -> L16
        sGetChildDrawingOrderMethod = r14;     // Catch: NoSuchMethodException -> L16
        r14.setAccessible(true);     // Catch: NoSuchMethodException -> L16
    L9:
        sGetChildDrawingOrderMethodFetched = true;
        goto L10
    }

    static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup r10) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new ViewGroupOverlayApi18(r10);
    L7:
        return ViewGroupOverlayApi14.createFrom(r10);
    }

    @RequiresApi(18)
    @SuppressLint({"NewApi"})
    private static void hiddenSuppressLayout(@NonNull ViewGroup r10, boolean r11) {
        if (sTryHiddenSuppressLayout == false) goto L10;
        r10.suppressLayout(r11);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSuppressLayout = false;
        return;
    }

    static void suppressLayout(@NonNull ViewGroup r10, boolean r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 29) goto L6;
        r10.suppressLayout(r11);
        return;
    L6:
        if (r12 < 18) goto L8;
        hiddenSuppressLayout(r10, r11);
        return;
    L8:
        ViewGroupUtilsApi14.suppressLayout(r10, r11);
    }
}
