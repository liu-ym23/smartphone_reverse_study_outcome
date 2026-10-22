package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
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

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void showAsDropDown(PopupWindow r10, View r11, int r12, int r13, int r14) {
            r10.showAsDropDown(r11, r12, r13, r14);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static boolean getOverlapAnchor(PopupWindow r10) {
            return r10.getOverlapAnchor();
        }

        @DoNotInline
        static int getWindowLayoutType(PopupWindow r10) {
            return r10.getWindowLayoutType();
        }

        @DoNotInline
        static void setOverlapAnchor(PopupWindow r10, boolean r11) {
            r10.setOverlapAnchor(r11);
        }

        @DoNotInline
        static void setWindowLayoutType(PopupWindow r10, int r11) {
            r10.setWindowLayoutType(r11);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 23) goto L7;
        return Api23Impl.getOverlapAnchor(r10);
    L7:
        if (r11 >= 21) goto L9;
        return false;
    L9:
        if (sOverlapAnchorFieldAttempted == false) goto L26;
    L16:
        Field r12 = sOverlapAnchorField;
        if (r12 == null) goto L29;
        return ((Boolean) r12.get(r10)).booleanValue();
    L20:
        e = move-exception;
        Log.i(TAG, "Could not get overlap anchor field in PopupWindow", e);
        return false;
    L29:
        return false;
    L26:
        Field r13 = PopupWindow.class.getDeclaredField("mOverlapAnchor");     // Catch: NoSuchFieldException -> L13
        sOverlapAnchorField = r13;     // Catch: NoSuchFieldException -> L13
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L13
    L15:
        sOverlapAnchorFieldAttempted = true;
    L13:
        e = move-exception;
        Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e);
        goto L15
    }

    public static int getWindowLayoutType(@NonNull PopupWindow r10) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getWindowLayoutType(r10);
    L7:
        if (sGetWindowLayoutTypeMethodAttempted == false) goto L18;
    L11:
        Method r11 = sGetWindowLayoutTypeMethod;
        if (r11 != null) goto L20;
    L15:
        return 0;
    L20:
        return ((Integer) r11.invoke(r10, new Object[0])).intValue();
    L18:
        Method r12 = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);     // Catch: Exception -> L16
        sGetWindowLayoutTypeMethod = r12;     // Catch: Exception -> L16
        r12.setAccessible(true);     // Catch: Exception -> L16
    L10:
        sGetWindowLayoutTypeMethodAttempted = true;
        goto L11
    }

    public static void setOverlapAnchor(@NonNull PopupWindow r10, boolean r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 23) goto L6;
        Api23Impl.setOverlapAnchor(r10, r11);
        return;
    L6:
        if (r12 >= 21) goto L8;
        return;
    L8:
        if (sOverlapAnchorFieldAttempted == false) goto L24;
    L15:
        Field r13 = sOverlapAnchorField;
        if (r13 == null) goto L28;
        r13.set(r10, Boolean.valueOf(r11));     // Catch: IllegalAccessException -> L19
        return;
    L19:
        e = move-exception;
        Log.i(TAG, "Could not set overlap anchor field in PopupWindow", e);
        return;
    L28:
        return;
    L24:
        Field r14 = PopupWindow.class.getDeclaredField("mOverlapAnchor");     // Catch: NoSuchFieldException -> L12
        sOverlapAnchorField = r14;     // Catch: NoSuchFieldException -> L12
        r14.setAccessible(true);     // Catch: NoSuchFieldException -> L12
    L14:
        sOverlapAnchorFieldAttempted = true;
    L12:
        e = move-exception;
        Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e);
        goto L14
    }

    public static void setWindowLayoutType(@NonNull PopupWindow r10, int r11) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setWindowLayoutType(r10, r11);
        return;
    L6:
        if (sSetWindowLayoutTypeMethodAttempted == false) goto L17;
    L9:
        Method r12 = sSetWindowLayoutTypeMethod;
        if (r12 == null) goto L20;
        r12.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L13
        return;
    L21:
        return;
    L20:
        return;
    L17:
        Method r13 = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});     // Catch: Exception -> L14
        sSetWindowLayoutTypeMethod = r13;     // Catch: Exception -> L14
        r13.setAccessible(true);     // Catch: Exception -> L14
    L8:
        sSetWindowLayoutTypeMethodAttempted = true;
        goto L9
    }

    public static void showAsDropDown(@NonNull PopupWindow r10, @NonNull View r11, int r12, int r13, int r14) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.showAsDropDown(r10, r11, r12, r13, r14);
        return;
    L6:
        if ((GravityCompat.getAbsoluteGravity(r14, ViewCompat.getLayoutDirection(r11)) & 7) != 5) goto L8;
        r12 = r12 - (r10.getWidth() - r11.getWidth());
    L8:
        r10.showAsDropDown(r11, r12, r13);
    }
}
