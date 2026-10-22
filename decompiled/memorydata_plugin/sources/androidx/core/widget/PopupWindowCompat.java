package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    static class Api19Impl {
        private Api19Impl() {
        }

        static void showAsDropDown(PopupWindow r0, View r1, int r2, int r3, int r4) {
            r0.showAsDropDown(r1, r2, r3, r4);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean getOverlapAnchor(PopupWindow r0) {
            return r0.getOverlapAnchor();
        }

        static int getWindowLayoutType(PopupWindow r0) {
            return r0.getWindowLayoutType();
        }

        static void setOverlapAnchor(PopupWindow r0, boolean r1) {
            r0.setOverlapAnchor(r1);
        }

        static void setWindowLayoutType(PopupWindow r0, int r1) {
            r0.setWindowLayoutType(r1);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow r4) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getOverlapAnchor(r4);
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return false;
    L9:
        if (sOverlapAnchorFieldAttempted == false) goto L26;
    L16:
        Field r0 = sOverlapAnchorField;
        if (r0 == null) goto L29;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r0.get(r4), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L20:
        e = move-exception;
        Log.i(TAG, "Could not get overlap anchor field in PopupWindow", e);
        return false;
    L29:
        return false;
    L26:
        Field r2 = PopupWindow.class.getDeclaredField("mOverlapAnchor");     // Catch: NoSuchFieldException -> L13
        sOverlapAnchorField = r2;     // Catch: NoSuchFieldException -> L13
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L13
    L15:
        sOverlapAnchorFieldAttempted = true;
    L13:
        e = move-exception;
        Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e);
        goto L15
    }

    public static int getWindowLayoutType(PopupWindow r5) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getWindowLayoutType(r5);
    L7:
        if (sGetWindowLayoutTypeMethodAttempted == false) goto L18;
    L11:
        Method r0 = sGetWindowLayoutTypeMethod;
        if (r0 != null) goto L20;
    L15:
        return 0;
    L20:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r5, new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L18:
        Method r2 = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);     // Catch: Exception -> L16
        sGetWindowLayoutTypeMethod = r2;     // Catch: Exception -> L16
        r2.setAccessible(true);     // Catch: Exception -> L16
    L10:
        sGetWindowLayoutTypeMethodAttempted = true;
        goto L11
    }

    public static void setOverlapAnchor(PopupWindow r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setOverlapAnchor(r4, r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        return;
    L8:
        if (sOverlapAnchorFieldAttempted == false) goto L22;
    L15:
        Field r0 = sOverlapAnchorField;
        if (r0 == null) goto L28;
        r0.set(r4, Boolean.valueOf(r5));     // Catch: IllegalAccessException -> L19
        return;
    L19:
        e = move-exception;
        Log.i(TAG, "Could not set overlap anchor field in PopupWindow", e);
        return;
    L28:
        return;
    L22:
        Field r2 = PopupWindow.class.getDeclaredField("mOverlapAnchor");     // Catch: NoSuchFieldException -> L12
        sOverlapAnchorField = r2;     // Catch: NoSuchFieldException -> L12
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L12
    L14:
        sOverlapAnchorFieldAttempted = true;
    L12:
        e = move-exception;
        Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e);
        goto L14
    }

    public static void setWindowLayoutType(PopupWindow r6, int r7) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setWindowLayoutType(r6, r7);
        return;
    L6:
        if (sSetWindowLayoutTypeMethodAttempted == false) goto L17;
    L9:
        Method r0 = sSetWindowLayoutTypeMethod;
        if (r0 == null) goto L20;
        r0.invoke(r6, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L13
        return;
    L21:
        return;
    L20:
        return;
    L17:
        Method r1 = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});     // Catch: Exception -> L14
        sSetWindowLayoutTypeMethod = r1;     // Catch: Exception -> L14
        r1.setAccessible(true);     // Catch: Exception -> L14
    L8:
        sSetWindowLayoutTypeMethodAttempted = true;
        goto L9
    }

    public static void showAsDropDown(PopupWindow r2, View r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.showAsDropDown(r2, r3, r4, r5, r6);
        return;
    L6:
        if ((GravityCompat.getAbsoluteGravity(r6, ViewCompat.getLayoutDirection(r3)) & 7) != 5) goto L8;
        r4 = r4 - (r2.getWidth() - r3.getWidth());
    L8:
        r2.showAsDropDown(r3, r4, r5);
    }
}
