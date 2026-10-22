package com.lynx.tasm.behavior.ui.accessibility;

import android.view.accessibility.AccessibilityManager;
import com.lynx.base.log.LynxLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements AccessibilityManager.AccessibilityStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10402a;

    public a(d r5) {
        this.f10402a = new WeakReference(r5);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean r5) {
        LynxLog.b(2, "LynxAccessibilityStateHelper", "onAccessibilityStateChanged: " + r5);
        WeakReference r10 = this.f10402a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.get() == null) goto L11;
        d r11 = (d) ((c) r10.get());
        r11.g = r5;
        if (r11.f10415o == false) goto L12;
        r11.a();
        return;
    L12:
        return;
    }
}
