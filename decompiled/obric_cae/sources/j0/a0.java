package j0;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public static int a(ViewGroup r8) {
        return r8.getNestedScrollAxes();
    }

    public static boolean b(ViewGroup r8) {
        return r8.isTransitionGroup();
    }

    public static void c(ViewGroup r8, boolean r10) {
        r8.setTransitionGroup(r10);
    }
}
