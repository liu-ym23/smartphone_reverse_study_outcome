package k0;

import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static int a(AccessibilityRecord r8) {
        return r8.getMaxScrollX();
    }

    public static int b(AccessibilityRecord r8) {
        return r8.getMaxScrollY();
    }

    public static void c(AccessibilityRecord r8, int r10) {
        r8.setMaxScrollX(r10);
    }

    public static void d(AccessibilityRecord r8, int r10) {
        r8.setMaxScrollY(r10);
    }
}
