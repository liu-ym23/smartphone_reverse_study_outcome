package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import hr.o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VirtualLayout extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13055j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13056k;

    public VirtualLayout(Context r5) {
        super(r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void g(ConstraintLayout r5) {
        f(r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L13;
        int r13 = r11.getIndex(r12);
        if (r13 != R$styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.f13055j = true;
    L12:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.f13056k = true;
        goto L12
    L13:
        r11.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13055j == false) goto L5;
    L6:
        ViewParent r5 = getParent();
        if ((r5 instanceof ConstraintLayout) == false) goto L28;
        ConstraintLayout r10 = (ConstraintLayout) r5;
        int r11 = getVisibility();
        float r12 = getElevation();
        int r13 = 0;
    L10:
        if (r13 >= this.f12985b) goto L29;
        View r14 = r10.e(this.f12984a[r13]);
        if (r14 == null) goto L21;
        if (this.f13055j == false) goto L17;
        r14.setVisibility(r11);
    L17:
        if (this.f13056k == false) goto L21;
        if (r12 <= 0.0f) goto L21;
        r14.setTranslationZ(r14.getTranslationZ() + r12);
    L21:
        r13 = r13 + 1;
        goto L10
    L29:
        return;
    L28:
        return;
    L5:
        if (this.f13056k == true) goto L6;
    }

    public void r(o r5, int r10, int r11) {
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        super.setElevation(r5);
        e();
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        e();
    }

    public VirtualLayout(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public VirtualLayout(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
