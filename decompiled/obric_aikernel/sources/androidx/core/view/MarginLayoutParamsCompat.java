package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class MarginLayoutParamsCompat {

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static int getLayoutDirection(ViewGroup.MarginLayoutParams r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        static int getMarginEnd(ViewGroup.MarginLayoutParams r10) {
            return r10.getMarginEnd();
        }

        @DoNotInline
        static int getMarginStart(ViewGroup.MarginLayoutParams r10) {
            return r10.getMarginStart();
        }

        @DoNotInline
        static boolean isMarginRelative(ViewGroup.MarginLayoutParams r10) {
            return r10.isMarginRelative();
        }

        @DoNotInline
        static void resolveLayoutDirection(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.resolveLayoutDirection(r11);
        }

        @DoNotInline
        static void setLayoutDirection(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.setLayoutDirection(r11);
        }

        @DoNotInline
        static void setMarginEnd(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.setMarginEnd(r11);
        }

        @DoNotInline
        static void setMarginStart(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.setMarginStart(r11);
        }
    }

    private MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(@NonNull ViewGroup.MarginLayoutParams r10) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        int r11 = Api17Impl.getLayoutDirection(r10);
    L6:
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L11;
        return 0;
    L11:
        return r11;
    L5:
        r11 = 0;
        goto L6
    }

    public static int getMarginEnd(@NonNull ViewGroup.MarginLayoutParams r10) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getMarginEnd(r10);
    L7:
        return r10.rightMargin;
    }

    public static int getMarginStart(@NonNull ViewGroup.MarginLayoutParams r10) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getMarginStart(r10);
    L7:
        return r10.leftMargin;
    }

    public static boolean isMarginRelative(@NonNull ViewGroup.MarginLayoutParams r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.isMarginRelative(r10);
    }

    public static void resolveLayoutDirection(@NonNull ViewGroup.MarginLayoutParams r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.resolveLayoutDirection(r10, r11);
        return;
    }

    public static void setLayoutDirection(@NonNull ViewGroup.MarginLayoutParams r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLayoutDirection(r10, r11);
        return;
    }

    public static void setMarginEnd(@NonNull ViewGroup.MarginLayoutParams r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setMarginEnd(r10, r11);
        return;
    L5:
        r10.rightMargin = r11;
    }

    public static void setMarginStart(@NonNull ViewGroup.MarginLayoutParams r10, int r11) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setMarginStart(r10, r11);
        return;
    L5:
        r10.leftMargin = r11;
    }
}
