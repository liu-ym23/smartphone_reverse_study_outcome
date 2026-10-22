package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class MarginLayoutParamsCompat {

    static class Api17Impl {
        private Api17Impl() {
        }

        static int getLayoutDirection(ViewGroup.MarginLayoutParams r0) {
            return r0.getLayoutDirection();
        }

        static int getMarginEnd(ViewGroup.MarginLayoutParams r0) {
            return r0.getMarginEnd();
        }

        static int getMarginStart(ViewGroup.MarginLayoutParams r0) {
            return r0.getMarginStart();
        }

        static boolean isMarginRelative(ViewGroup.MarginLayoutParams r0) {
            return r0.isMarginRelative();
        }

        static void resolveLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.resolveLayoutDirection(r1);
        }

        static void setLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setLayoutDirection(r1);
        }

        static void setMarginEnd(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setMarginEnd(r1);
        }

        static void setMarginStart(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setMarginStart(r1);
        }
    }

    private MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        int r4 = Api17Impl.getLayoutDirection(r3);
    L6:
        if (r4 == 0) goto L11;
        if (r4 == 1) goto L11;
        return 0;
    L11:
        return r4;
    L5:
        r4 = 0;
        goto L6
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getMarginEnd(r2);
    L7:
        return r2.rightMargin;
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getMarginStart(r2);
    L7:
        return r2.leftMargin;
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.isMarginRelative(r2);
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.resolveLayoutDirection(r2, r3);
        return;
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLayoutDirection(r2, r3);
        return;
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setMarginEnd(r2, r3);
        return;
    L5:
        r2.rightMargin = r3;
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setMarginStart(r2, r3);
        return;
    L5:
        r2.leftMargin = r3;
    }
}
