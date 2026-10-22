package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import s.e;
import s.g;
import s.l;
import v.d;
import v.f;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g f1341u;

    public Flow(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // v.f, androidx.constraintlayout.widget.c
    public final void i(AttributeSet r8) {
        super.i(r8);
        this.f1341u = new g();
        if (r8 == null) goto L86;
        TypedArray r10 = getContext().obtainStyledAttributes(r8, d.f12656b);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L85;
        int r13 = r10.getIndex(r12);
        if (r13 != 0) goto L10;
        this.f1341u.X0 = r10.getInt(r13, 0);
    L84:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != 1) goto L13;
        g r14 = this.f1341u;
        int r15 = r10.getDimensionPixelSize(r13, 0);
        r14.f11934u0 = r15;
        r14.f11935v0 = r15;
        r14.f11936w0 = r15;
        r14.f11937x0 = r15;
        goto L84
    L13:
        if (r13 != 18) goto L16;
        g r16 = this.f1341u;
        int r17 = r10.getDimensionPixelSize(r13, 0);
        r16.f11936w0 = r17;
        r16.f11938y0 = r17;
        r16.f11939z0 = r17;
        goto L84
    L16:
        if (r13 != 19) goto L19;
        this.f1341u.f11937x0 = r10.getDimensionPixelSize(r13, 0);
        goto L84
    L19:
        if (r13 != 2) goto L22;
        this.f1341u.f11938y0 = r10.getDimensionPixelSize(r13, 0);
        goto L84
    L22:
        if (r13 != 3) goto L25;
        this.f1341u.f11934u0 = r10.getDimensionPixelSize(r13, 0);
        goto L84
    L25:
        if (r13 != 4) goto L28;
        this.f1341u.f11939z0 = r10.getDimensionPixelSize(r13, 0);
        goto L84
    L28:
        if (r13 != 5) goto L31;
        this.f1341u.f11935v0 = r10.getDimensionPixelSize(r13, 0);
        goto L84
    L31:
        if (r13 != 54) goto L34;
        this.f1341u.V0 = r10.getInt(r13, 0);
        goto L84
    L34:
        if (r13 != 44) goto L37;
        this.f1341u.F0 = r10.getInt(r13, 0);
        goto L84
    L37:
        if (r13 != 53) goto L40;
        this.f1341u.G0 = r10.getInt(r13, 0);
        goto L84
    L40:
        if (r13 != 38) goto L43;
        this.f1341u.H0 = r10.getInt(r13, 0);
        goto L84
    L43:
        if (r13 != 46) goto L46;
        this.f1341u.J0 = r10.getInt(r13, 0);
        goto L84
    L46:
        if (r13 != 40) goto L49;
        this.f1341u.I0 = r10.getInt(r13, 0);
        goto L84
    L49:
        if (r13 != 48) goto L52;
        this.f1341u.K0 = r10.getInt(r13, 0);
        goto L84
    L52:
        if (r13 != 42) goto L55;
        this.f1341u.L0 = r10.getFloat(r13, 0.5f);
        goto L84
    L55:
        if (r13 != 37) goto L58;
        this.f1341u.N0 = r10.getFloat(r13, 0.5f);
        goto L84
    L58:
        if (r13 != 45) goto L61;
        this.f1341u.P0 = r10.getFloat(r13, 0.5f);
        goto L84
    L61:
        if (r13 != 39) goto L64;
        this.f1341u.O0 = r10.getFloat(r13, 0.5f);
        goto L84
    L64:
        if (r13 != 47) goto L67;
        this.f1341u.Q0 = r10.getFloat(r13, 0.5f);
        goto L84
    L67:
        if (r13 != 51) goto L70;
        this.f1341u.M0 = r10.getFloat(r13, 0.5f);
        goto L84
    L70:
        if (r13 != 41) goto L73;
        this.f1341u.T0 = r10.getInt(r13, 2);
        goto L84
    L73:
        if (r13 != 50) goto L76;
        this.f1341u.U0 = r10.getInt(r13, 2);
        goto L84
    L76:
        if (r13 != 43) goto L79;
        this.f1341u.R0 = r10.getDimensionPixelSize(r13, 0);
        goto L84
    L79:
        if (r13 != 52) goto L82;
        this.f1341u.S0 = r10.getDimensionPixelSize(r13, 0);
        goto L84
    L82:
        if (r13 != 49) goto L84;
        this.f1341u.W0 = r10.getInt(r13, -1);
        goto L84
    L85:
        r10.recycle();
    L86:
        this.f1433n = this.f1341u;
        k();
    }

    @Override // androidx.constraintlayout.widget.c
    public final void j(e r8, boolean r10) {
        g r11 = this.f1341u;
        int r12 = r11.f11936w0;
        if (r12 <= 0) goto L5;
    L6:
        if (r10 == false) goto L8;
        r11.f11938y0 = r11.f11937x0;
    L9:
        r11.f11939z0 = r12;
        return;
    L8:
        r11.f11938y0 = r12;
        r12 = r11.f11937x0;
        goto L9
    L5:
        if (r11.f11937x0 > 0) goto L6;
    }

    @Override // v.f
    public final void l(l r8, int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        if (r8 == null) goto L5;
        r8.R(r12, r13, r14, r15);
        setMeasuredDimension(r8.B0, r8.C0);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.c, android.view.View
    @SuppressLint({"WrongCall"})
    public final void onMeasure(int r8, int r10) {
        l(this.f1341u, r8, r10);
    }

    public void setFirstHorizontalBias(float r8) {
        this.f1341u.N0 = r8;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r8) {
        this.f1341u.H0 = r8;
        requestLayout();
    }

    public void setFirstVerticalBias(float r8) {
        this.f1341u.O0 = r8;
        requestLayout();
    }

    public void setFirstVerticalStyle(int r8) {
        this.f1341u.I0 = r8;
        requestLayout();
    }

    public void setHorizontalAlign(int r8) {
        this.f1341u.T0 = r8;
        requestLayout();
    }

    public void setHorizontalBias(float r8) {
        this.f1341u.L0 = r8;
        requestLayout();
    }

    public void setHorizontalGap(int r8) {
        this.f1341u.R0 = r8;
        requestLayout();
    }

    public void setHorizontalStyle(int r8) {
        this.f1341u.F0 = r8;
        requestLayout();
    }

    public void setLastHorizontalBias(float r8) {
        this.f1341u.P0 = r8;
        requestLayout();
    }

    public void setLastHorizontalStyle(int r8) {
        this.f1341u.J0 = r8;
        requestLayout();
    }

    public void setLastVerticalBias(float r8) {
        this.f1341u.Q0 = r8;
        requestLayout();
    }

    public void setLastVerticalStyle(int r8) {
        this.f1341u.K0 = r8;
        requestLayout();
    }

    public void setMaxElementsWrap(int r8) {
        this.f1341u.W0 = r8;
        requestLayout();
    }

    public void setOrientation(int r8) {
        this.f1341u.X0 = r8;
        requestLayout();
    }

    public void setPadding(int r8) {
        g r10 = this.f1341u;
        r10.f11934u0 = r8;
        r10.f11935v0 = r8;
        r10.f11936w0 = r8;
        r10.f11937x0 = r8;
        requestLayout();
    }

    public void setPaddingBottom(int r8) {
        this.f1341u.f11935v0 = r8;
        requestLayout();
    }

    public void setPaddingLeft(int r8) {
        this.f1341u.f11938y0 = r8;
        requestLayout();
    }

    public void setPaddingRight(int r8) {
        this.f1341u.f11939z0 = r8;
        requestLayout();
    }

    public void setPaddingTop(int r8) {
        this.f1341u.f11934u0 = r8;
        requestLayout();
    }

    public void setVerticalAlign(int r8) {
        this.f1341u.U0 = r8;
        requestLayout();
    }

    public void setVerticalBias(float r8) {
        this.f1341u.M0 = r8;
        requestLayout();
    }

    public void setVerticalGap(int r8) {
        this.f1341u.S0 = r8;
        requestLayout();
    }

    public void setVerticalStyle(int r8) {
        this.f1341u.G0 = r8;
        requestLayout();
    }

    public void setWrapMode(int r8) {
        this.f1341u.V0 = r8;
        requestLayout();
    }
}
