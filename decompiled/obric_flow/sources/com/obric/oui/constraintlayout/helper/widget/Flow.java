package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.widget.Constraints;
import com.obric.oui.constraintlayout.widget.R$styleable;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.obric.oui.constraintlayout.widget.c;
import hr.f;
import hr.i;
import hr.l;
import hr.o;

/* JADX INFO: loaded from: classes3.dex */
public class Flow extends VirtualLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i f12621l;

    public Flow(Context r5) {
        super(r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r10) {
        super.k(r10);
        this.f12621l = new i();
        if (r10 == null) goto L86;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L85;
        int r13 = r11.getIndex(r12);
        if (r13 != R$styleable.ConstraintLayout_Layout_android_orientation) goto L10;
        this.f12621l.Z0 = r11.getInt(r13, 0);
    L84:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_padding) goto L13;
        i r14 = this.f12621l;
        int r15 = r11.getDimensionPixelSize(r13, 0);
        r14.f17465w0 = r15;
        r14.f17466x0 = r15;
        r14.f17467y0 = r15;
        r14.f17468z0 = r15;
        goto L84
    L13:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_paddingStart) goto L16;
        i r16 = this.f12621l;
        int r17 = r11.getDimensionPixelSize(r13, 0);
        r16.f17467y0 = r17;
        r16.A0 = r17;
        r16.B0 = r17;
        goto L84
    L16:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_paddingEnd) goto L19;
        this.f12621l.f17468z0 = r11.getDimensionPixelSize(r13, 0);
        goto L84
    L19:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_paddingLeft) goto L22;
        this.f12621l.A0 = r11.getDimensionPixelSize(r13, 0);
        goto L84
    L22:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_paddingTop) goto L25;
        this.f12621l.f17465w0 = r11.getDimensionPixelSize(r13, 0);
        goto L84
    L25:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_paddingRight) goto L28;
        this.f12621l.B0 = r11.getDimensionPixelSize(r13, 0);
        goto L84
    L28:
        if (r13 != R$styleable.ConstraintLayout_Layout_android_paddingBottom) goto L31;
        this.f12621l.f17466x0 = r11.getDimensionPixelSize(r13, 0);
        goto L84
    L31:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_wrapMode) goto L34;
        this.f12621l.X0 = r11.getInt(r13, 0);
        goto L84
    L34:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) goto L37;
        this.f12621l.H0 = r11.getInt(r13, 0);
        goto L84
    L37:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_verticalStyle) goto L40;
        this.f12621l.I0 = r11.getInt(r13, 0);
        goto L84
    L40:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) goto L43;
        this.f12621l.J0 = r11.getInt(r13, 0);
        goto L84
    L43:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) goto L46;
        this.f12621l.L0 = r11.getInt(r13, 0);
        goto L84
    L46:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) goto L49;
        this.f12621l.K0 = r11.getInt(r13, 0);
        goto L84
    L49:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) goto L52;
        this.f12621l.M0 = r11.getInt(r13, 0);
        goto L84
    L52:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_horizontalBias) goto L55;
        this.f12621l.N0 = r11.getFloat(r13, 0.5f);
        goto L84
    L55:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) goto L58;
        this.f12621l.P0 = r11.getFloat(r13, 0.5f);
        goto L84
    L58:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) goto L61;
        this.f12621l.R0 = r11.getFloat(r13, 0.5f);
        goto L84
    L61:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) goto L64;
        this.f12621l.Q0 = r11.getFloat(r13, 0.5f);
        goto L84
    L64:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) goto L67;
        this.f12621l.S0 = r11.getFloat(r13, 0.5f);
        goto L84
    L67:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_verticalBias) goto L70;
        this.f12621l.O0 = r11.getFloat(r13, 0.5f);
        goto L84
    L70:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) goto L73;
        this.f12621l.V0 = r11.getInt(r13, 2);
        goto L84
    L73:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_verticalAlign) goto L76;
        this.f12621l.W0 = r11.getInt(r13, 2);
        goto L84
    L76:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_horizontalGap) goto L79;
        this.f12621l.T0 = r11.getDimensionPixelSize(r13, 0);
        goto L84
    L79:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_verticalGap) goto L82;
        this.f12621l.U0 = r11.getDimensionPixelSize(r13, 0);
        goto L84
    L82:
        if (r13 != R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) goto L84;
        this.f12621l.Y0 = r11.getInt(r13, -1);
        goto L84
    L85:
        r11.recycle();
    L86:
        this.d = this.f12621l;
        q();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void l(c r5, l r10, Constraints.LayoutParams r11, SparseArray r12) {
        super.l(r5, r10, r11, r12);
        if ((r10 instanceof i) == false) goto L8;
        i r13 = (i) r10;
        int r14 = r11.V;
        if (r14 == (-1)) goto L9;
        r13.Z0 = r14;
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void m(f r5, boolean r10) {
        i r11 = this.f12621l;
        int r12 = r11.f17467y0;
        if (r12 <= 0) goto L5;
    L6:
        if (r10 == false) goto L8;
        r11.A0 = r11.f17468z0;
        r11.B0 = r12;
        return;
    L8:
        r11.A0 = r12;
        r11.B0 = r11.f17468z0;
        return;
    L5:
        if (r11.f17468z0 > 0) goto L6;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int r5, int r10) {
        r(this.f12621l, r5, r10);
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

    public void setFirstHorizontalBias(float r5) {
        this.f12621l.P0 = r5;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r5) {
        this.f12621l.J0 = r5;
        requestLayout();
    }

    public void setFirstVerticalBias(float r5) {
        this.f12621l.Q0 = r5;
        requestLayout();
    }

    public void setFirstVerticalStyle(int r5) {
        this.f12621l.K0 = r5;
        requestLayout();
    }

    public void setHorizontalAlign(int r5) {
        this.f12621l.V0 = r5;
        requestLayout();
    }

    public void setHorizontalBias(float r5) {
        this.f12621l.N0 = r5;
        requestLayout();
    }

    public void setHorizontalGap(int r5) {
        this.f12621l.T0 = r5;
        requestLayout();
    }

    public void setHorizontalStyle(int r5) {
        this.f12621l.H0 = r5;
        requestLayout();
    }

    public void setLastHorizontalBias(float r5) {
        this.f12621l.R0 = r5;
        requestLayout();
    }

    public void setLastHorizontalStyle(int r5) {
        this.f12621l.L0 = r5;
        requestLayout();
    }

    public void setLastVerticalBias(float r5) {
        this.f12621l.S0 = r5;
        requestLayout();
    }

    public void setLastVerticalStyle(int r5) {
        this.f12621l.M0 = r5;
        requestLayout();
    }

    public void setMaxElementsWrap(int r5) {
        this.f12621l.Y0 = r5;
        requestLayout();
    }

    public void setOrientation(int r5) {
        this.f12621l.Z0 = r5;
        requestLayout();
    }

    public void setPadding(int r5) {
        i r10 = this.f12621l;
        r10.f17465w0 = r5;
        r10.f17466x0 = r5;
        r10.f17467y0 = r5;
        r10.f17468z0 = r5;
        requestLayout();
    }

    public void setPaddingBottom(int r5) {
        this.f12621l.f17466x0 = r5;
        requestLayout();
    }

    public void setPaddingLeft(int r5) {
        this.f12621l.A0 = r5;
        requestLayout();
    }

    public void setPaddingRight(int r5) {
        this.f12621l.B0 = r5;
        requestLayout();
    }

    public void setPaddingTop(int r5) {
        this.f12621l.f17465w0 = r5;
        requestLayout();
    }

    public void setVerticalAlign(int r5) {
        this.f12621l.W0 = r5;
        requestLayout();
    }

    public void setVerticalBias(float r5) {
        this.f12621l.O0 = r5;
        requestLayout();
    }

    public void setVerticalGap(int r5) {
        this.f12621l.U0 = r5;
        requestLayout();
    }

    public void setVerticalStyle(int r5) {
        this.f12621l.I0 = r5;
        requestLayout();
    }

    public void setWrapMode(int r5) {
        this.f12621l.X0 = r5;
        requestLayout();
    }

    public Flow(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public Flow(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
