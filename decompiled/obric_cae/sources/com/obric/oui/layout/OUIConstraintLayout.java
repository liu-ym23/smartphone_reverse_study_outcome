package com.obric.oui.layout;

import ac.a;
import ac.b;
import ac.e;
import ac.f;
import ac.h;
import ac.l;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class OUIConstraintLayout extends ConstraintLayout implements a, b {
    public final h A;
    public final e B;
    public final f C;
    public final /* synthetic */ e D;
    public final /* synthetic */ h E;
    public final /* synthetic */ l F;

    public OUIConstraintLayout(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    @Override // ac.b
    public final boolean c() {
        this.E.getClass();
        return false;
    }

    @Override // ac.a
    public final void d(View r8, boolean r10) {
        this.D.d(r8, r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.dispatchDraw(r8);
        h r10 = this.A;
        if (r10 == null) goto L5;
        r10.h(r8, getWidth(), getHeight());
    L5:
        if (r10 == null) goto L8;
        r10.b(r8);
        return;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent r8) {
        i.f(r8, "event");
        if (this.C == null) goto L6;
        f.f280k = r8.getDeviceId();
    L6:
        return super.dispatchGenericMotionEvent(r8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        if (this.C == null) goto L6;
        f.f280k = r8.getDeviceId();
    L6:
        if (this.B == null) goto L9;
        r8.getAction();
    L9:
        return super.dispatchTouchEvent(r8);
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        i.f(r8, "canvas");
        h r10 = this.A;
        if (r10 == null) goto L5;
        r10.d(r8);
    L5:
        super.draw(r8);
    }

    @Override // ac.b
    public final void e(int r8) {
        this.E.getClass();
    }

    @Override // ac.b
    public final boolean f() {
        this.E.getClass();
        return false;
    }

    @Override // ac.b
    public final void g(float r8) {
        this.E.g(r8);
    }

    public a getAlphaHelper() {
        return this.F.f327b;
    }

    public f getEffectHelper() {
        return this.F.a();
    }

    public b getLayoutHelper() {
        return this.F.f326a;
    }

    public int getRadius() {
        return this.E.M;
    }

    public float getShadowAlpha() {
        return this.E.f294c0;
    }

    public int getShadowColor() {
        return this.E.d0;
    }

    public int getShadowElevation() {
        return this.E.f293b0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onHoverChanged(boolean r8) {
        super.onHoverChanged(r8);
        f r10 = this.C;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f288e == false) goto L15;
        if (r8 == true) goto L9;
        return;
    L9:
        if (r10.f285b == false) goto L14;
        r10.a(true);
        return;
    L14:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        h r11 = this.A;
        if (r11 == null) goto L8;
        i.c(r11);
        int r12 = r11.l(r8);
        i.c(r11);
        int r13 = r11.k(r10);
        super.onMeasure(r12, r13);
        i.c(r11);
        int r14 = r11.o(r12, getMeasuredWidth());
        i.c(r11);
        int r15 = r11.n(r13, getMeasuredHeight());
        if (r12 != r14) goto L7;
        if (r13 != r15) goto L7;
        return;
    L7:
        super.onMeasure(r14, r15);
        return;
    L8:
        super.onMeasure(r8, r10);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r8) {
        super.onWindowVisibilityChanged(r8);
        f r10 = this.C;
        if (r10 == null) goto L6;
        r10.d(r8);
        return;
    }

    public void setBorderColor(int r8) {
        this.E.r(r8);
    }

    public void setBorderWidth(int r8) {
        this.E.s(r8);
    }

    public void setBottomDividerAlpha(int r8) {
        this.E.t(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenDisable(boolean r8) {
        this.D.setChangeAlphaWhenDisable(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenPress(boolean r8) {
        this.D.setChangeAlphaWhenPress(r8);
    }

    public void setChangeAlphaWhenSelected(boolean r8) {
        this.D.f262o = r8;
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        e r10 = this.B;
        if (r10 == null) goto L6;
        r10.c(this, r8);
        return;
    }

    @Override // ac.a
    public void setKeepPressAlpha(boolean r8) {
        this.D.setKeepPressAlpha(r8);
    }

    public void setLeftDividerAlpha(int r8) {
        this.E.u(r8);
    }

    public void setOuterNormalColor(int r8) {
        this.E.v(r8);
    }

    public void setOutlineExcludePadding(boolean r8) {
        this.E.w(r8);
    }

    public void setOverridePressColor(int r8) {
        this.D.f264q = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        f r10 = this.C;
        if (r10 == null) goto L5;
        r10.e(r8);
    L5:
        super.setPressed(r8);
        e r11 = this.B;
        if (r11 == null) goto L9;
        r11.e(r8);
        return;
    }

    public void setRadius(int r8) {
        this.E.x(r8);
    }

    public void setRightDividerAlpha(int r8) {
        this.E.z(r8);
    }

    @Override // android.view.View
    public void setSelected(boolean r8) {
        super.setSelected(r8);
        e r10 = this.B;
        if (r10 == null) goto L6;
        r10.d(this, r8);
        return;
    }

    public void setShadowAlpha(float r8) {
        this.E.B(r8);
    }

    public void setShadowColor(int r8) {
        this.E.C(r8);
    }

    public void setShadowCornerRadius(int r8) {
        this.E.f308o0 = r8;
    }

    public void setShadowElevation(int r8) {
        this.E.D(r8);
    }

    public void setShadowStyle(int r8) {
        this.E.E(r8);
    }

    public void setShowBorderOnlyBeforeL(boolean r8) {
        this.E.F(r8);
    }

    public final void setSoundEffectEnabled(boolean r8) {
        f r10 = this.C;
        if (r10 == null) goto L6;
        r10.f287d = r8;
        return;
    }

    public void setTopDividerAlpha(int r8) {
        this.E.G(r8);
    }

    public final void setVibrateEnabled(boolean r8) {
        f r10 = this.C;
        if (r10 == null) goto L6;
        r10.f286c = r8;
        return;
    }

    @Override // ac.b
    public void setWidthMin(int r8) {
        this.E.f305n = r8;
    }

    public OUIConstraintLayout(Context r8, AttributeSet r10, int r11) {
        l r12 = new l(r8, r10, 0, 0);
        i.f(r8, "context");
        super(r8, r10);
        this.D = r12.f327b;
        this.E = r12.f326a;
        this.F = r12;
        r12.b(this);
        b r13 = getLayoutHelper();
        if (r13 == null) goto L11;
        this.A = (h) r13;
        a r14 = getAlphaHelper();
        if (r14 == null) goto L9;
        this.B = (e) r14;
        this.C = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }
}
