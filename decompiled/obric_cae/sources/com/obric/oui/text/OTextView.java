package com.obric.oui.text;

import ac.a;
import ac.b;
import ac.e;
import ac.f;
import ac.h;
import ac.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.obric.cae.R;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public class OTextView extends TextView implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f6580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f6581b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f6582m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f6583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ e f6585p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ h f6586q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ l f6587r;

    public OTextView(Context r8, AttributeSet r10) {
        this(r8, r10, 0, 12);
    }

    @Override // ac.b
    public final boolean c() {
        this.f6586q.getClass();
        return false;
    }

    @Override // ac.a
    public final void d(View r8, boolean r10) {
        this.f6585p.d(r8, r10);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.dispatchDraw(r8);
        h r10 = this.f6580a;
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
        h r10 = this.f6580a;
        if (r10 == null) goto L5;
        r10.d(r8);
    L5:
        super.draw(r8);
    }

    @Override // ac.b
    public final void e(int r8) {
        this.f6586q.getClass();
    }

    @Override // ac.b
    public final boolean f() {
        this.f6586q.getClass();
        return false;
    }

    @Override // ac.b
    public final void g(float r8) {
        this.f6586q.g(r8);
    }

    public a getAlphaHelper() {
        return this.f6587r.f327b;
    }

    public f getEffectHelper() {
        return this.f6587r.a();
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.f6584o;
    }

    public b getLayoutHelper() {
        return this.f6587r.f326a;
    }

    public int getRadius() {
        return this.f6586q.M;
    }

    public float getShadowAlpha() {
        return this.f6586q.f294c0;
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f6586q.d0;
    }

    public int getShadowElevation() {
        return this.f6586q.f293b0;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        if (this.f6584o == false) goto L16;
        int r14 = 1;
        if (getLineCount() > 1) goto L7;
        boolean r15 = true;
    L8:
        int r16 = this.f6583n & BWDLInnerConstant.LINK_RECOVERY;
        if (r15 == true) goto L12;
        r14 = 3;
    L12:
        int r17 = r16 | r14;
        if (getGravity() == r17) goto L17;
        setGravity(r17);
        return;
    L17:
        return;
    L7:
        r15 = false;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    public void setBorderColor(int r8) {
        this.f6586q.r(r8);
    }

    public void setBorderWidth(int r8) {
        this.f6586q.s(r8);
    }

    public void setBottomDividerAlpha(int r8) {
        this.f6586q.t(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenDisable(boolean r8) {
        this.f6585p.setChangeAlphaWhenDisable(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenPress(boolean r8) {
        this.f6585p.setChangeAlphaWhenPress(r8);
    }

    public void setChangeAlphaWhenSelected(boolean r8) {
        this.f6585p.f262o = r8;
    }

    public final void setEnableAutoAlignLeft(boolean r8) {
        if (this.f6584o == r8) goto L6;
        this.f6584o = r8;
        requestLayout();
        return;
    }

    @Override // ac.a
    public void setKeepPressAlpha(boolean r8) {
        this.f6585p.setKeepPressAlpha(r8);
    }

    public void setLeftDividerAlpha(int r8) {
        this.f6586q.u(r8);
    }

    public void setOuterNormalColor(int r8) {
        this.f6586q.v(r8);
    }

    public void setOutlineExcludePadding(boolean r8) {
        this.f6586q.w(r8);
    }

    public void setOverridePressColor(int r8) {
        this.f6585p.f264q = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        f r10 = this.f6582m;
        if (r10 == null) goto L5;
        r10.e(r8);
    L5:
        super.setPressed(r8);
        e r11 = this.f6581b;
        if (r11 == null) goto L9;
        r11.e(r8);
        return;
    }

    public void setRadius(int r8) {
        this.f6586q.x(r8);
    }

    public void setRightDividerAlpha(int r8) {
        this.f6586q.z(r8);
    }

    public void setShadowAlpha(float r8) {
        this.f6586q.B(r8);
    }

    public void setShadowColor(int r8) {
        this.f6586q.C(r8);
    }

    public void setShadowCornerRadius(int r8) {
        this.f6586q.f308o0 = r8;
    }

    public void setShadowElevation(int r8) {
        this.f6586q.D(r8);
    }

    public void setShadowStyle(int r8) {
        this.f6586q.E(r8);
    }

    public void setShowBorderOnlyBeforeL(boolean r8) {
        this.f6586q.F(r8);
    }

    public void setTopDividerAlpha(int r8) {
        this.f6586q.G(r8);
    }

    @Override // ac.b
    public void setWidthMin(int r8) {
        this.f6586q.f305n = r8;
    }

    public OTextView(Context r8, AttributeSet r10, int r11, int r12) {
        l r13 = null;
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r12 & 8) == 0) goto L11;
        r13 = new l(r8, r10, r11, 0);
    L11:
        i.f(r8, "context");
        i.f(r13, "provider");
        super(r8, r10, r11);
        this.f6585p = r13.f327b;
        this.f6586q = r13.f326a;
        this.f6587r = r13;
        this.f6583n = getGravity();
        r13.b(this);
        b r14 = getLayoutHelper();
        if (r14 == null) goto L20;
        this.f6580a = (h) r14;
        a r15 = getAlphaHelper();
        if (r15 == null) goto L18;
        e r16 = (e) r15;
        this.f6581b = r16;
        this.f6582m = getEffectHelper();
        r16.setChangeAlphaWhenPress(false);
        r16.setChangeAlphaWhenDisable(false);
        setHighlightColor(r8.getColor(R.color.oui_text_highlight_color));
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }
}
