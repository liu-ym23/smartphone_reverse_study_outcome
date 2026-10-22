package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: classes.dex */
public final class a extends j0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CheckableImageButton f4823d;

    public a(CheckableImageButton r8) {
        this.f4823d = r8;
    }

    @Override // j0.a
    public final void c(View r8, AccessibilityEvent r10) {
        super.c(r8, r10);
        r10.setChecked(this.f4823d.isChecked());
    }

    @Override // j0.a
    public final void d(View r8, k0.f r10) {
        View.AccessibilityDelegate r11 = this.f8370a;
        AccessibilityNodeInfo r12 = r10.f8890a;
        r11.onInitializeAccessibilityNodeInfo(r8, r12);
        CheckableImageButton r13 = this.f4823d;
        r12.setCheckable(r13.f4818o);
        r12.setChecked(r13.isChecked());
    }
}
