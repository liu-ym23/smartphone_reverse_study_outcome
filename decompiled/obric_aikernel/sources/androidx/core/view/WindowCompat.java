package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void setDecorFitsSystemWindows(@NonNull Window r10, boolean r11) {
            View r12 = r10.getDecorView();
            int r13 = r12.getSystemUiVisibility();
            if (r11 == false) goto L5;
            int r14 = r13 & (-1793);
        L6:
            r12.setSystemUiVisibility(r14);
            return;
        L5:
            r14 = r13 | 1792;
            goto L6
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T requireViewById(Window r10, int r11) {
            return (T) r10.requireViewById(r11);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static void setDecorFitsSystemWindows(@NonNull Window r10, boolean r11) {
            r10.setDecorFitsSystemWindows(r11);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window r10, @NonNull View r11) {
        return new WindowInsetsControllerCompat(r10, r11);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window r10, @IdRes int r11) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r12 = (T) r10.findViewById(r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    L5:
        return (T) Api28Impl.requireViewById(r10, r11);
    }

    public static void setDecorFitsSystemWindows(@NonNull Window r10, boolean r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 30) goto L6;
        Api30Impl.setDecorFitsSystemWindows(r10, r11);
        return;
    L6:
        if (r12 < 16) goto L10;
        Api16Impl.setDecorFitsSystemWindows(r10, r11);
        return;
    }
}
