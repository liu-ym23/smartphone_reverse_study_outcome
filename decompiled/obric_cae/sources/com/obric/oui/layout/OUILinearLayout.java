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
import android.widget.LinearLayout;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class OUILinearLayout extends LinearLayout implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f6342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f6343b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f6344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ e f6345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ h f6346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ l f6347p;

    public OUILinearLayout(Context r8, AttributeSet r10) {
        l r11 = new l(r8, r10, 0, 0);
        super(r8, r10);
        this.f6345n = r11.f327b;
        this.f6346o = r11.f326a;
        this.f6347p = r11;
        r11.b(this);
        b r12 = getLayoutHelper();
        if (r12 == null) goto L11;
        this.f6342a = (h) r12;
        a r13 = getAlphaHelper();
        if (r13 == null) goto L9;
        this.f6343b = (e) r13;
        this.f6344m = getEffectHelper();
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

    @Override // ac.b
    public final boolean c() {
        this.f6346o.getClass();
        return false;
    }

    @Override // ac.a
    public final void d(View r8, boolean r10) {
        this.f6345n.d(r8, r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.dispatchDraw(r8);
        h r10 = this.f6342a;
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
        if (this.f6344m == null) goto L6;
        f.f280k = r8.getDeviceId();
    L6:
        return super.dispatchGenericMotionEvent(r8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        if (this.f6344m == null) goto L6;
        f.f280k = r8.getDeviceId();
    L6:
        if (this.f6343b == null) goto L9;
        r8.getAction();
    L9:
        return super.dispatchTouchEvent(r8);
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        i.f(r8, "canvas");
        h r10 = this.f6342a;
        if (r10 == null) goto L5;
        r10.d(r8);
    L5:
        super.draw(r8);
    }

    @Override // ac.b
    public final void e(int r8) {
        this.f6346o.getClass();
    }

    @Override // ac.b
    public final boolean f() {
        this.f6346o.getClass();
        return false;
    }

    @Override // ac.b
    public final void g(float r8) {
        this.f6346o.g(r8);
    }

    public a getAlphaHelper() {
        return this.f6347p.f327b;
    }

    public f getEffectHelper() {
        return this.f6347p.a();
    }

    public b getLayoutHelper() {
        return this.f6347p.f326a;
    }

    public int getRadius() {
        return this.f6346o.M;
    }

    public float getShadowAlpha() {
        return this.f6346o.f294c0;
    }

    public int getShadowColor() {
        return this.f6346o.d0;
    }

    public int getShadowElevation() {
        return this.f6346o.f293b0;
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
        f r10 = this.f6344m;
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

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        h r11 = this.f6342a;
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
        f r10 = this.f6344m;
        if (r10 == null) goto L6;
        r10.d(r8);
        return;
    }

    public void setBorderColor(int r8) {
        this.f6346o.r(r8);
    }

    public void setBorderWidth(int r8) {
        this.f6346o.s(r8);
    }

    public void setBottomDividerAlpha(int r8) {
        this.f6346o.t(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenDisable(boolean r8) {
        this.f6345n.setChangeAlphaWhenDisable(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenPress(boolean r8) {
        this.f6345n.setChangeAlphaWhenPress(r8);
    }

    public void setChangeAlphaWhenSelected(boolean r8) {
        this.f6345n.f262o = r8;
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        e r10 = this.f6343b;
        if (r10 == null) goto L6;
        r10.c(this, r8);
        return;
    }

    @Override // ac.a
    public void setKeepPressAlpha(boolean r8) {
        this.f6345n.setKeepPressAlpha(r8);
    }

    public void setLeftDividerAlpha(int r8) {
        this.f6346o.u(r8);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r8) {
        h r10 = this.f6342a;
        if (r10 == null) goto L5;
        r10.f307o = r8;
    L5:
        super.setMinimumHeight(r8);
    }

    public void setOuterNormalColor(int r8) {
        this.f6346o.v(r8);
    }

    public void setOutlineExcludePadding(boolean r8) {
        this.f6346o.w(r8);
    }

    public void setOverridePressColor(int r8) {
        this.f6345n.f264q = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        f r10 = this.f6344m;
        if (r10 == null) goto L5;
        r10.e(r8);
    L5:
        super.setPressed(r8);
        e r11 = this.f6343b;
        if (r11 == null) goto L9;
        r11.e(r8);
        return;
    }

    public void setRadius(int r8) {
        this.f6346o.x(r8);
    }

    public void setRightDividerAlpha(int r8) {
        this.f6346o.z(r8);
    }

    @Override // android.view.View
    public void setSelected(boolean r8) {
        super.setSelected(r8);
        e r10 = this.f6343b;
        if (r10 == null) goto L6;
        r10.d(this, r8);
        return;
    }

    public void setShadowAlpha(float r8) {
        this.f6346o.B(r8);
    }

    public void setShadowColor(int r8) {
        this.f6346o.C(r8);
    }

    public void setShadowCornerRadius(int r8) {
        this.f6346o.f308o0 = r8;
    }

    public void setShadowElevation(int r8) {
        this.f6346o.D(r8);
    }

    public void setShadowStyle(int r8) {
        this.f6346o.E(r8);
    }

    public void setShowBorderOnlyBeforeL(boolean r8) {
        this.f6346o.F(r8);
    }

    public final void setSoundEffectEnabled(boolean r8) {
        f r10 = this.f6344m;
        if (r10 == null) goto L6;
        r10.f287d = r8;
        return;
    }

    public void setTopDividerAlpha(int r8) {
        this.f6346o.G(r8);
    }

    public final void setVibrateEnabled(boolean r8) {
        f r10 = this.f6344m;
        if (r10 == null) goto L6;
        r10.f286c = r8;
        return;
    }

    @Override // ac.b
    public void setWidthMin(int r8) {
        this.f6346o.f305n = r8;
    }
}
