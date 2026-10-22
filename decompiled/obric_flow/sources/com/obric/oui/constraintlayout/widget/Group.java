package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes3.dex */
public class Group extends ConstraintHelper {
    public Group(Context r5) {
        super(r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void g(ConstraintLayout r5) {
        f(r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r5) {
        super.k(r5);
        this.e = false;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n() {
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r5.f13027q0.P(0);
        r5.f13027q0.M(0);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
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

    public Group(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public Group(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
