package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int r5, int r10, int r11, @NonNull Rect r12, @NonNull Rect r13, int r14) {
        Gravity.apply(r5, r10, r11, r12, r13, r14);
    }

    public static void applyDisplay(int r5, @NonNull Rect r10, @NonNull Rect r11, int r12) {
        Gravity.applyDisplay(r5, r10, r11, r12);
    }

    public static int getAbsoluteGravity(int r5, int r10) {
        return Gravity.getAbsoluteGravity(r5, r10);
    }

    public static void apply(int r5, int r10, int r11, @NonNull Rect r12, int r13, int r14, @NonNull Rect r15, int r16) {
        Gravity.apply(r5, r10, r11, r12, r13, r14, r15, r16);
    }
}
