package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AbstractAccessibilityLibIsolation$accessibilityStateChangeListener$2$a implements AccessibilityManager.AccessibilityStateChangeListener {
    public final /* synthetic */ AbstractAccessibilityLibIsolation.accessibilityStateChangeListener.2 a;

    public AbstractAccessibilityLibIsolation$accessibilityStateChangeListener$2$a(AbstractAccessibilityLibIsolation.accessibilityStateChangeListener.2 r1) {
        this.a = r1;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean r10) {
        if (("onAccessibilityStateChanged " + r10) == null) goto L5;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L5:
        AbstractAccessibilityLibIsolation.c(this.a.this$0, r10);
    }
}
