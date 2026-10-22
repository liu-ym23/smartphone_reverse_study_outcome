package j0;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static int a(ViewGroup.MarginLayoutParams r8) {
        return r8.getLayoutDirection();
    }

    public static int b(ViewGroup.MarginLayoutParams r8) {
        return r8.getMarginEnd();
    }

    public static int c(ViewGroup.MarginLayoutParams r8) {
        return r8.getMarginStart();
    }

    public static boolean d(ViewGroup.MarginLayoutParams r8) {
        return r8.isMarginRelative();
    }

    public static void e(ViewGroup.MarginLayoutParams r8, int r10) {
        r8.resolveLayoutDirection(r10);
    }

    public static void f(ViewGroup.MarginLayoutParams r8, int r10) {
        r8.setLayoutDirection(r10);
    }

    public static void g(ViewGroup.MarginLayoutParams r8, int r10) {
        r8.setMarginEnd(r10);
    }

    public static void h(ViewGroup.MarginLayoutParams r8, int r10) {
        r8.setMarginStart(r10);
    }
}
