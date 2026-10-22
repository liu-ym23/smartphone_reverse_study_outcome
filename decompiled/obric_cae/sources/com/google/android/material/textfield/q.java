package com.google.android.material.textfield;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class q extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f5107a;

    public q(p r8) {
        this.f5107a = r8;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r8, AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r8, r10);
        EditText r11 = this.f5107a.f5083h.getEditText();
        if (r11 == null) goto L6;
        r10.setLabeledBy(r11);
        return;
    }
}
