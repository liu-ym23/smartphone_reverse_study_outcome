package com.lynx.tasm.behavior.ui.accessibility;

import android.view.accessibility.AccessibilityManager;
import com.lynx.base.log.LynxLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10403a;

    public b(d r5) {
        this.f10403a = new WeakReference(r5);
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean r5) {
        LynxLog.b(2, "LynxAccessibilityStateHelper", "onTouchExplorationStateChanged: " + r5);
        WeakReference r10 = this.f10403a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.get() == null) goto L11;
        d r11 = (d) ((c) r10.get());
        r11.f10408h = r5;
        if (r11.f10415o == false) goto L12;
        r11.a();
        return;
    L12:
        return;
    }
}
