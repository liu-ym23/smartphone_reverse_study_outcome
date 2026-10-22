package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    static int getChildDrawingOrder(ViewGroup r7, int r8) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return r7.getChildDrawingOrder(r8);
    L7:
        if (sGetChildDrawingOrderMethodFetched == false) goto L19;
    L10:
        Method r0 = sGetChildDrawingOrderMethod;
        if (r0 != null) goto L17;
    L14:
        return r8;
    L17:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r7, new Object[]{Integer.valueOf(r7.getChildCount()), Integer.valueOf(r8)}), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L19:
        Method r1 = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: NoSuchMethodException -> L16
        sGetChildDrawingOrderMethod = r1;     // Catch: NoSuchMethodException -> L16
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L16
    L9:
        sGetChildDrawingOrderMethodFetched = true;
        goto L10
    }

    static ViewGroupOverlayImpl getOverlay(ViewGroup r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new ViewGroupOverlayApi18(r2);
    L7:
        return ViewGroupOverlayApi14.createFrom(r2);
    }

    private static void hiddenSuppressLayout(ViewGroup r1, boolean r2) {
        if (sTryHiddenSuppressLayout == false) goto L10;
        r1.suppressLayout(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSuppressLayout = false;
        return;
    }

    static void suppressLayout(ViewGroup r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r2.suppressLayout(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L8;
        hiddenSuppressLayout(r2, r3);
        return;
    L8:
        ViewGroupUtilsApi14.suppressLayout(r2, r3);
    }
}
