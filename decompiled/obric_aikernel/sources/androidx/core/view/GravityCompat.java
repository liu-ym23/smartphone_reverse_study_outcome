package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static void apply(int r10, int r11, int r12, Rect r13, int r14, int r15, Rect r16, int r17) {
            Gravity.apply(r10, r11, r12, r13, r14, r15, r16, r17);
        }

        @DoNotInline
        static void apply(int r10, int r11, int r12, Rect r13, Rect r14, int r15) {
            Gravity.apply(r10, r11, r12, r13, r14, r15);
        }

        @DoNotInline
        static void applyDisplay(int r10, Rect r11, Rect r12, int r13) {
            Gravity.applyDisplay(r10, r11, r12, r13);
        }
    }

    private GravityCompat() {
    }

    public static void apply(int r10, int r11, int r12, @NonNull Rect r13, int r14, int r15, @NonNull Rect r16, int r17) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.apply(r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        Gravity.apply(r10, r11, r12, r13, r14, r15, r16);
    }

    public static void apply(int r10, int r11, int r12, @NonNull Rect r13, @NonNull Rect r14, int r15) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.apply(r10, r11, r12, r13, r14, r15);
        return;
    L5:
        Gravity.apply(r10, r11, r12, r13, r14);
    }

    public static void applyDisplay(int r10, @NonNull Rect r11, @NonNull Rect r12, int r13) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.applyDisplay(r10, r11, r12, r13);
        return;
    L5:
        Gravity.applyDisplay(r10, r11, r12);
    }

    public static int getAbsoluteGravity(int r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Gravity.getAbsoluteGravity(r10, r11);
    L7:
        return r10 & (-8388609);
    }
}
