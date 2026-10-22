package androidx.core.view;

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

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static void setDecorFitsSystemWindows(@NonNull Window r5, boolean r10) {
            View r11 = r5.getDecorView();
            int r12 = r11.getSystemUiVisibility();
            if (r10 == false) goto L5;
            int r13 = r12 & (-1793);
        L6:
            r11.setSystemUiVisibility(r13);
            return;
        L5:
            r13 = r12 | 1792;
            goto L6
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static <T> T requireViewById(Window r5, int r10) {
            return (T) r5.requireViewById(r10);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static void setDecorFitsSystemWindows(@NonNull Window r5, boolean r10) {
            r5.setDecorFitsSystemWindows(r10);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window r5, @NonNull View r10) {
        return new WindowInsetsControllerCompat(r5, r10);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window r5, @IdRes int r10) {
        return (T) Api28Impl.requireViewById(r5, r10);
    }

    public static void setDecorFitsSystemWindows(@NonNull Window r5, boolean r10) {
        Api30Impl.setDecorFitsSystemWindows(r5, r10);
    }
}
