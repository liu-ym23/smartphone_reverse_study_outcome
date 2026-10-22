package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
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
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 27) goto L5;
        boolean r11 = true;
    L6:
        SDK_LEVEL_SUPPORTS_AUTOSIZE = r11;
        if (r10 < 18) goto L16;
        Method r12 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L12
        sComputeFitSystemWindowsMethod = r12;     // Catch: NoSuchMethodException -> L12
        if (r12.isAccessible() == true) goto L17;
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
        r11 = false;
        goto L6
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View r10, Rect r11, Rect r12) {
        Method r13 = sComputeFitSystemWindowsMethod;
        if (r13 != null) goto L10;
        return;
    L10:
        r13.invoke(r10, new Object[]{r11, r12});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
    }

    public static boolean isLayoutRtl(View r10) {
        if (ViewCompat.getLayoutDirection(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void makeOptionalFitsSystemWindows(View r10) {
        if (Build.VERSION.SDK_INT < 16) goto L15;
        Method r11 = r10.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);     // Catch: Throwable -> L9 NoSuchMethodException -> L11
        if (r11.isAccessible() == true) goto L7;
        r11.setAccessible(true);     // Catch: Throwable -> L9 NoSuchMethodException -> L11
    L7:
        r11.invoke(r10, new Object[0]);     // Catch: Throwable -> L9 NoSuchMethodException -> L11
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
