package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getScaledHorizontalScrollFactor(ViewConfiguration r10) {
            return r10.getScaledHorizontalScrollFactor();
        }

        @DoNotInline
        static float getScaledVerticalScrollFactor(ViewConfiguration r10) {
            return r10.getScaledVerticalScrollFactor();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int getScaledHoverSlop(ViewConfiguration r10) {
            return r10.getScaledHoverSlop();
        }

        @DoNotInline
        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration r10) {
            return r10.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static {
        if (Build.VERSION.SDK_INT != 25) goto L10;
        sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);     // Catch: Exception -> L6
        return;
    L6:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
        return;
    }

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration r10, Context r11) {
        if (Build.VERSION.SDK_INT < 25) goto L11;
        Method r12 = sGetScaledScrollFactorMethod;
        if (r12 == null) goto L11;
        return ((Integer) r12.invoke(r10, new Object[0])).intValue();
    L10:
        Log.i(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
    L11:
        TypedValue r13 = new TypedValue();
        if (r11.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r13, true) == true) goto L14;
        return 0.0f;
    L14:
        return r13.getDimension(r11.getResources().getDisplayMetrics());
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration r10, @NonNull Context r11) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledHorizontalScrollFactor(r10);
    L7:
        return getLegacyScrollFactor(r10, r11);
    }

    public static int getScaledHoverSlop(@NonNull ViewConfiguration r10) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getScaledHoverSlop(r10);
    L7:
        return r10.getScaledTouchSlop() / 2;
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration r10) {
        return r10.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration r10, @NonNull Context r11) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getScaledVerticalScrollFactor(r10);
    L7:
        return getLegacyScrollFactor(r10, r11);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration r10) {
        return r10.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(@NonNull ViewConfiguration r10, @NonNull Context r11) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Resources r12 = r11.getResources();
        int r13 = r12.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        if (r13 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r12.getBoolean(r13) == false) goto L11;
        return true;
    L5:
        return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(r10);
    }
}
