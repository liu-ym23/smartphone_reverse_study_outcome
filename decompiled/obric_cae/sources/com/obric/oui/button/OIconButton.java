package com.obric.oui.button;

import ac.a;
import ac.b;
import ac.e;
import ac.f;
import ac.h;
import ac.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class OIconButton extends AppCompatImageView implements a, b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h f6200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f6201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f f6202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f6204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6205s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6206t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ e f6207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h f6208v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l f6209w;

    public OIconButton(Context r8, AttributeSet r10) {
        l r11 = new l(r8, r10, 0, 0);
        super(r8, r10, 0);
        this.f6207u = r11.f327b;
        this.f6208v = r11.f326a;
        this.f6209w = r11;
        this.f6206t = 1.0f;
        r11.b(this);
        b r12 = getLayoutHelper();
        if (r12 == null) goto L11;
        this.f6200n = (h) r12;
        a r13 = getAlphaHelper();
        if (r13 == null) goto L9;
        this.f6201o = (e) r13;
        this.f6202p = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r14 = r8.obtainStyledAttributes(r10, nb.a.f9489c);
        i.e(r14, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f6204r = r14.getBoolean(2, false);
        this.f6206t = r14.getFloat(4, 1.0f);
        r14.recycle();
        h(isEnabled());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }

    private final void setPressState(boolean r8) {
        if (this.f6203q != r8) goto L5;
        return;
    L5:
        this.f6203q = r8;
        f r10 = this.f6202p;
        if (r10 == null) goto L8;
        r10.e(r8);
    L8:
        e r11 = this.f6201o;
        if (r11 == null) goto L12;
        r11.e(r8);
        return;
    }

    @Override // ac.b
    public final boolean c() {
        this.f6208v.getClass();
        return false;
    }

    @Override // ac.a
    public final void d(View r8, boolean r10) {
        this.f6207u.d(r8, r10);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.dispatchDraw(r8);
        h r10 = this.f6200n;
        if (r10 == null) goto L5;
        r10.h(r8, getWidth(), getHeight());
    L5:
        if (r10 == null) goto L8;
        r10.b(r8);
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        i.f(r8, "canvas");
        h r10 = this.f6200n;
        if (r10 == null) goto L5;
        r10.d(r8);
    L5:
        super.draw(r8);
    }

    @Override // ac.b
    public final void e(int r8) {
        if (this.f6204r == true) goto L5;
        return;
    L5:
        float r10 = l6.a.w(r8 / 255.0f);
        if (this.f6205s != 0) goto L8;
        this.f6205s = getImageAlpha();
    L8:
        int r11 = this.f6205s;
        if (r11 == 0) goto L13;
        setImageAlpha(l6.a.x((int) ((1 - (r10 * 0.7f)) * r11), 255));
        return;
    }

    @Override // ac.b
    public final boolean f() {
        this.f6208v.getClass();
        return false;
    }

    @Override // ac.b
    public final void g(float r8) {
        this.f6208v.g(r8);
    }

    public a getAlphaHelper() {
        return this.f6209w.f327b;
    }

    public f getEffectHelper() {
        return this.f6209w.a();
    }

    public b getLayoutHelper() {
        return this.f6209w.f326a;
    }

    public int getRadius() {
        return this.f6208v.M;
    }

    public float getShadowAlpha() {
        return this.f6208v.f294c0;
    }

    public int getShadowColor() {
        return this.f6208v.d0;
    }

    public int getShadowElevation() {
        return this.f6208v.f293b0;
    }

    public final void h(boolean r8) {
        if (r8 == true) goto L6;
        Drawable r10 = getDrawable();
        if (r10 == null) goto L10;
        r10.setAlpha((int) (this.f6206t * 255));
        return;
    L10:
        return;
    L6:
        Drawable r11 = getDrawable();
        if (r11 == null) goto L12;
        r11.setAlpha((int) 255.0f);
        return;
    }

    public void setBorderColor(int r8) {
        this.f6208v.r(r8);
    }

    public void setBorderWidth(int r8) {
        this.f6208v.s(r8);
    }

    public void setBottomDividerAlpha(int r8) {
        this.f6208v.t(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenDisable(boolean r8) {
        this.f6207u.setChangeAlphaWhenDisable(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenPress(boolean r8) {
        this.f6207u.setChangeAlphaWhenPress(r8);
    }

    public void setChangeAlphaWhenSelected(boolean r8) {
        this.f6207u.f262o = r8;
    }

    public final void setDisabledAlpha(float r8) {
        this.f6206t = r8;
        if (isEnabled() == true) goto L6;
        h(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        e r10 = this.f6201o;
        if (r10 == null) goto L5;
        r10.c(this, r8);
    L5:
        h(r8);
    }

    @Override // ac.a
    public void setKeepPressAlpha(boolean r8) {
        this.f6207u.setKeepPressAlpha(r8);
    }

    public void setLeftDividerAlpha(int r8) {
        this.f6208v.u(r8);
    }

    public void setOuterNormalColor(int r8) {
        this.f6208v.v(r8);
    }

    public void setOutlineExcludePadding(boolean r8) {
        this.f6208v.w(r8);
    }

    public void setOverridePressColor(int r8) {
        this.f6207u.f264q = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        super.setPressed(r8);
        f r10 = this.f6202p;
        if (r10 == null) goto L5;
        r10.e(r8);
    L5:
        e r11 = this.f6201o;
        if (r11 == null) goto L9;
        r11.e(r8);
        return;
    }

    public void setRadius(int r8) {
        this.f6208v.x(r8);
    }

    public void setRightDividerAlpha(int r8) {
        this.f6208v.z(r8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r8) {
        super.setSelected(r8);
        e r10 = this.f6201o;
        if (r10 == null) goto L6;
        r10.d(this, r8);
        return;
    }

    public void setShadowAlpha(float r8) {
        this.f6208v.B(r8);
    }

    public void setShadowColor(int r8) {
        this.f6208v.C(r8);
    }

    public void setShadowCornerRadius(int r8) {
        this.f6208v.f308o0 = r8;
    }

    public void setShadowElevation(int r8) {
        this.f6208v.D(r8);
    }

    public void setShadowStyle(int r8) {
        this.f6208v.E(r8);
    }

    public void setShowBorderOnlyBeforeL(boolean r8) {
        this.f6208v.F(r8);
    }

    public void setTopDividerAlpha(int r8) {
        this.f6208v.G(r8);
    }

    @Override // ac.b
    public void setWidthMin(int r8) {
        this.f6208v.f305n = r8;
    }
}
