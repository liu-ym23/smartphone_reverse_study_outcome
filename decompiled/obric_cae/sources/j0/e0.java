package j0;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public final class e0 {
    public static boolean a(ViewParent r8, View r10, float r11, float r12, boolean r13) {
        return r8.onNestedFling(r10, r11, r12, r13);
    }

    public static boolean b(ViewParent r8, View r10, float r11, float r12) {
        return r8.onNestedPreFling(r10, r11, r12);
    }

    public static void c(ViewParent r8, View r10, int r11, int r12, int[] r13) {
        r8.onNestedPreScroll(r10, r11, r12, r13);
    }

    public static void d(ViewParent r8, View r10, int r11, int r12, int r13, int r14) {
        r8.onNestedScroll(r10, r11, r12, r13, r14);
    }

    public static void e(ViewParent r8, View r10, View r11, int r12) {
        r8.onNestedScrollAccepted(r10, r11, r12);
    }

    public static boolean f(ViewParent r8, View r10, View r11, int r12) {
        return r8.onStartNestedScroll(r10, r11, r12);
    }

    public static void g(ViewParent r8, View r10) {
        r8.onStopNestedScroll(r10);
    }
}
