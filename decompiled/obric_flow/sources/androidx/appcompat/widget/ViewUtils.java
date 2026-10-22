package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewUtils {

    @ChecksSdkIntAtLeast(api = 27)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE = false;
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        SDK_LEVEL_SUPPORTS_AUTOSIZE = true;
        Method r5 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L7
        sComputeFitSystemWindowsMethod = r5;     // Catch: NoSuchMethodException -> L7
        if (r5.isAccessible() == true) goto L11;
        sComputeFitSystemWindowsMethod.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        return;
    L11:
        return;
    L7:
        Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View r5, Rect r10, Rect r11) {
        Method r12 = sComputeFitSystemWindowsMethod;
        if (r12 == null) goto L11;
        r12.invoke(r5, new Object[]{r10, r11});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
        return;
    }

    public static boolean isLayoutRtl(View r5) {
        if (ViewCompat.getLayoutDirection(r5) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void makeOptionalFitsSystemWindows(View r5) {
        Method r10 = r5.getClass().getMethod("makeOptionalFitsSystemWindows", null);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
        if (r10.isAccessible() == true) goto L10;
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
    L10:
        r10.invoke(r5, null);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L14
    L20:
        return;
    L6:
        e = move-exception;
        Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
        return;
    L14:
        Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        return;
    L8:
        e = move-exception;
        Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
    }
}
