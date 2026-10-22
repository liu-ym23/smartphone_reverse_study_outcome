package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import hr.l;
import hr.n;
import hr.o;

/* JADX INFO: loaded from: classes3.dex */
public class MotionPlaceholder extends VirtualLayout {
    public MotionPlaceholder(Context r5) {
        super(r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r5) {
        super.k(r5);
        this.d = new n();
        q();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int r5, int r10) {
        r(null, r5, r10);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void p(l r5, SparseArray r10) {
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout
    public final void r(o r5, int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        if (r5 == null) goto L5;
        r5.V(r12, r13, r14, r15);
        setMeasuredDimension(r5.D0, r5.E0);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public MotionPlaceholder(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public MotionPlaceholder(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
