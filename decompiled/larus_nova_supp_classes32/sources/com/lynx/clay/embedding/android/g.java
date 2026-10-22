package com.lynx.clay.embedding.android;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements AccessibilityManager.AccessibilityStateChangeListener {
    public final /* synthetic */ FlutterView a;

    public g(FlutterView r1) {
        this.a = r1;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean r1) {
        if (r1 == true) goto L4;
        return;
    L4:
        if (this.a.i() == false) goto L8;
        this.a.e();
        return;
    }
}
