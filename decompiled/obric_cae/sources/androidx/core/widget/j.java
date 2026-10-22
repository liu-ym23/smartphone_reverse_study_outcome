package androidx.core.widget;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static boolean a(PopupWindow r8) {
        return r8.getOverlapAnchor();
    }

    public static int b(PopupWindow r8) {
        return r8.getWindowLayoutType();
    }

    public static void c(PopupWindow r8, boolean r10) {
        r8.setOverlapAnchor(r10);
    }

    public static void d(PopupWindow r8, int r10) {
        r8.setWindowLayoutType(r10);
    }
}
