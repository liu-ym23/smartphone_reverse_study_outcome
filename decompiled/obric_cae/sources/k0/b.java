package k0;

import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static int a(AccessibilityEvent r8) {
        return r8.getContentChangeTypes();
    }

    public static void b(AccessibilityEvent r8, int r10) {
        r8.setContentChangeTypes(r10);
    }
}
