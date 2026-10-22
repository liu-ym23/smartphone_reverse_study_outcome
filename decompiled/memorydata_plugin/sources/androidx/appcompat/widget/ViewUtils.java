package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils {
    static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE = false;
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        if (Build.VERSION.SDK_INT < 27) goto L5;
        boolean r0 = true;
    L6:
        SDK_LEVEL_SUPPORTS_AUTOSIZE = r0;
        if (Build.VERSION.SDK_INT < 18) goto L16;
        Method r1 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L12
        sComputeFitSystemWindowsMethod = r1;     // Catch: NoSuchMethodException -> L12
        if (r1.isAccessible() == true) goto L17;
        sComputeFitSystemWindowsMethod.setAccessible(true);     // Catch: NoSuchMethodException -> L12
        return;
    L17:
        return;
    L12:
        Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View r3, Rect r4, Rect r5) {
        Method r0 = sComputeFitSystemWindowsMethod;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.invoke(r3, new Object[]{r4, r5});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
    }

    public static boolean isLayoutRtl(View r1) {
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void makeOptionalFitsSystemWindows(View r6) {
        if (Build.VERSION.SDK_INT < 16) goto L15;
        Method r2 = r6.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);     // Catch: Throwable -> L9 NoSuchMethodException -> L11
        if (r2.isAccessible() == true) goto L7;
        r2.setAccessible(true);     // Catch: Throwable -> L9 NoSuchMethodException -> L11
    L7:
        r2.invoke(r6, new Object[0]);     // Catch: Throwable -> L9 NoSuchMethodException -> L11
    L17:
        return;
    L9:
        e = move-exception;
        Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e);
        return;
    L11:
        Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        return;
    }
}
