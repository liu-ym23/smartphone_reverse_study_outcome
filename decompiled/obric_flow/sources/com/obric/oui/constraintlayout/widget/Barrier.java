package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import hr.f;
import hr.g;
import hr.l;

/* JADX INFO: loaded from: classes3.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public hr.a f12982l;

    public Barrier(Context r5) {
        super(r5);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f12982l.f17370x0;
    }

    public int getMargin() {
        return this.f12982l.f17371y0;
    }

    public int getType() {
        return this.f12980j;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r10) {
        super.k(r10);
        this.f12982l = new hr.a();
        if (r10 == null) goto L17;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L16;
        int r13 = r11.getIndex(r12);
        if (r13 != R$styleable.ConstraintLayout_Layout_barrierDirection) goto L10;
        setType(r11.getInt(r13, 0));
    L15:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) goto L13;
        this.f12982l.f17370x0 = r11.getBoolean(r13, true);
        goto L15
    L13:
        if (r13 != R$styleable.ConstraintLayout_Layout_barrierMargin) goto L15;
        this.f12982l.f17371y0 = r11.getDimensionPixelSize(r13, 0);
        goto L15
    L16:
        r11.recycle();
    L17:
        this.d = this.f12982l;
        q();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void l(c r5, l r10, Constraints.LayoutParams r11, SparseArray r12) {
        super.l(r5, r10, r11, r12);
        if ((r10 instanceof hr.a) == false) goto L6;
        hr.a r13 = (hr.a) r10;
        boolean r14 = ((g) r10.V).f17437z0;
        lr.g r15 = r5.e;
        r(r13, r15.g0, r14);
        r13.f17370x0 = r15.f19737o0;
        r13.f17371y0 = r15.f19725h0;
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void m(f r5, boolean r10) {
        r(r5, this.f12980j, r10);
    }

    public final void r(f r5, int r10, boolean r11) {
        this.f12981k = r10;
        if (r11 == false) goto L9;
        int r12 = this.f12980j;
        if (r12 != 5) goto L7;
        this.f12981k = 1;
    L15:
        if ((r5 instanceof hr.a) == false) goto L18;
        int r13 = this.f12981k;
        ((hr.a) r5).f17369w0 = r13;
        return;
    L18:
        return;
    L7:
        if (r12 != 6) goto L15;
        this.f12981k = 0;
        goto L15
    L9:
        int r14 = this.f12980j;
        if (r14 != 5) goto L12;
        this.f12981k = 0;
        goto L15
    L12:
        if (r14 != 6) goto L15;
        this.f12981k = 1;
        goto L15
    }

    public void setAllowsGoneWidget(boolean r5) {
        this.f12982l.f17370x0 = r5;
    }

    public void setDpMargin(int r5) {
        this.f12982l.f17371y0 = (int) ((r5 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int r5) {
        this.f12982l.f17371y0 = r5;
    }

    public void setType(int r5) {
        this.f12980j = r5;
    }

    public Barrier(Context r5, AttributeSet r10) {
        super(r5, r10);
        super.setVisibility(8);
    }

    public Barrier(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        super.setVisibility(8);
    }
}
