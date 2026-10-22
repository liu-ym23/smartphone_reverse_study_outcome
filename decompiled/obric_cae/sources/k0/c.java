package k0;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static boolean a(AccessibilityManager r8, d r10) {
        return r8.addTouchExplorationStateChangeListener(new e(r10));
    }

    public static boolean b(AccessibilityManager r8, d r10) {
        return r8.removeTouchExplorationStateChangeListener(new e(r10));
    }
}
