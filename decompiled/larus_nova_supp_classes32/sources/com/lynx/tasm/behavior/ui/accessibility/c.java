package com.lynx.tasm.behavior.ui.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends View.AccessibilityDelegate {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View r1) {
        return this.a.l;
    }
}
