package com.lynx.tasm.behavior.ui.accessibility;

import android.view.accessibility.AccessibilityManager;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final AccessibilityManager a;
    public final a b;
    public final AccessibilityManagerTouchExplorationStateChangeListenerC0052b c;

    public static class a implements AccessibilityManager.AccessibilityStateChangeListener {
        public final WeakReference<c> a;

        public a(c r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public final void onAccessibilityStateChanged(boolean r3) {
            LLog.i("LynxAccessibilityStateHelper", "onAccessibilityStateChanged: " + r3);
            WeakReference<c> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L9;
            this.a.get().b(r3);
            return;
        }
    }

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.accessibility.b$b, reason: collision with other inner class name */
    public static class AccessibilityManagerTouchExplorationStateChangeListenerC0052b implements AccessibilityManager.TouchExplorationStateChangeListener {
        public final WeakReference<c> a;

        public AccessibilityManagerTouchExplorationStateChangeListenerC0052b(c r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public final void onTouchExplorationStateChanged(boolean r3) {
            LLog.i("LynxAccessibilityStateHelper", "onTouchExplorationStateChanged: " + r3);
            WeakReference<c> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L9;
            this.a.get().a(r3);
            return;
        }
    }

    public interface c {
        void a(boolean r1);

        void b(boolean r1);
    }

    public b(AccessibilityManager r3, c r4) {
        this.a = null;
        this.b = null;
        this.c = null;
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        this.a = r3;
        boolean r0 = r3.isEnabled();
        boolean r1 = r3.isTouchExplorationEnabled();
        r4.b(r0);
        r4.a(r1);
        a r2 = new a(r4);
        this.b = r2;
        r3.addAccessibilityStateChangeListener(r2);
        AccessibilityManagerTouchExplorationStateChangeListenerC0052b r5 = new AccessibilityManagerTouchExplorationStateChangeListenerC0052b(r4);
        this.c = r5;
        r3.addTouchExplorationStateChangeListener(r5);
        return;
    L8:
        return;
    }
}
