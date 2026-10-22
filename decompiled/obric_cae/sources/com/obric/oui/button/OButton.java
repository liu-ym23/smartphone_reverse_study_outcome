package com.obric.oui.button;

import ac.b;
import ac.e;
import ac.f;
import ac.h;
import ac.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.obric.cae.R;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public class OButton extends Button implements ac.a, b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f6184z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f6186b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f6187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e f6197w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h f6198x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ l f6199y;

    public static final class a {
        public a() {
        }
    }

    static {
        f6184z = new a();
    }

    public OButton(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    private final void setPressState(boolean r8) {
        if (this.f6190p != r8) goto L6;
        zc.b.h("OButton", "setPressState, already set, skip! pressed: " + r8);
        return;
    L6:
        this.f6190p = r8;
        f r10 = this.f6186b;
        if (r10 == null) goto L9;
        r10.e(r8);
    L9:
        e r11 = this.f6185a;
        if (r11 == null) goto L13;
        r11.e(r8);
        return;
    }

    public final void a(boolean r8) {
        int r10 = getPaddingTop();
        int r11 = getPaddingRight();
        int r12 = getPaddingBottom();
        if (r8 == false) goto L5;
        int r13 = getPaddingRight() - this.f6194t;
    L7:
        if (r13 == getPaddingLeft()) goto L10;
        setPadding(r13, r10, r11, r12);
        return;
    L10:
        return;
    L5:
        r13 = getPaddingRight();
        goto L7
    }

    public final void b(boolean r8) {
        int r10 = this.f6191q;
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = 0;
        if (r8 == true) goto L12;
        int r12 = t2.b.h(r10, this.f6195u);
        this.f6196v = true;
        super.setTextColor(r12);
        this.f6196v = false;
        Drawable[] r13 = getCompoundDrawables();
        i.e(r13, "compoundDrawables");
        int r14 = r13.length;
    L8:
        if (r11 >= r14) goto L17;
        Drawable r15 = r13[r11];
        r11 = r11 + 1;
        if (r15 == null) goto L8;
        r15.setAlpha((int) (this.f6195u * 255));
    L17:
        invalidate();
        return;
    L12:
        this.f6196v = true;
        super.setTextColor(r10);
        this.f6196v = false;
        Drawable[] r16 = getCompoundDrawables();
        i.e(r16, "compoundDrawables");
        int r17 = r16.length;
    L13:
        if (r11 >= r17) goto L17;
        Drawable r18 = r16[r11];
        r11 = r11 + 1;
        if (r18 == null) goto L13;
        r18.setAlpha((int) 255.0f);
        goto L13
    }

    @Override // ac.b
    public final boolean c() {
        this.f6198x.getClass();
        return false;
    }

    @Override // ac.a
    public final void d(View r8, boolean r10) {
        this.f6197w.d(r8, r10);
    }

    @Override // ac.b
    public final void e(int r12) {
        if (this.f6193s == true) goto L5;
        return;
    L5:
        float r13 = l6.a.w(r12 / 255.0f);
        int r8 = this.f6191q;
        if (r8 == 0) goto L9;
        int r10 = (r8 >> 24) & 255;
        int r11 = l6.a.x((int) ((1 - (r13 * 0.7f)) * r10), 255);
        int r14 = ((r8 >> 16) & 255) << 16;
        setTextColor((r8 & 255) | ((r14 | (r11 << 24)) | (((r8 >> 8) & 255) << 8)));
        zc.b.a("OButton", "updateTextColorOnPress, fraction: " + r13 + ", newTextAlpha: " + r11 + ", originTextAlpha: " + r10);
    L9:
        int r15 = this.f6192r;
        if (r15 == 0) goto L17;
        int r16 = l6.a.x((int) ((1 - (0.7f * r13)) * r15), 255);
        Drawable r17 = this.f6187m;
        if (r17 == null) goto L15;
        r17.setAlpha(r16);
    L15:
        zc.b.a("OButton", "updateIconAlphaOnPress, fraction: " + r13 + ", alpha: " + r16 + ", originIconAlpha: " + this.f6192r);
        return;
    }

    @Override // ac.b
    public final boolean f() {
        this.f6198x.getClass();
        return false;
    }

    @Override // ac.b
    public final void g(float r8) {
        this.f6198x.g(r8);
    }

    public ac.a getAlphaHelper() {
        return this.f6199y.f327b;
    }

    public f getEffectHelper() {
        return this.f6199y.a();
    }

    public b getLayoutHelper() {
        return this.f6199y.f326a;
    }

    public final Drawable getMIcon() {
        return this.f6187m;
    }

    public final int getMImageTintColorId() {
        return this.f6189o;
    }

    public int getRadius() {
        return this.f6198x.M;
    }

    public float getShadowAlpha() {
        return this.f6198x.f294c0;
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f6198x.d0;
    }

    public int getShadowElevation() {
        return this.f6198x.f293b0;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r8) {
        i.f(r8, "canvas");
        super.onDraw(r8);
        Drawable r10 = this.f6187m;
        if (r10 == null) goto L9;
        int r11 = (getWidth() - r10.getIntrinsicWidth()) / 2;
        int r12 = (getHeight() - r10.getIntrinsicHeight()) / 2;
        r10.setBounds(r11, r12, r10.getIntrinsicWidth() + r11, r10.getIntrinsicHeight() + r12);
        if (this.f6189o <= 0) goto L7;
        r10.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.f6189o), PorterDuff.Mode.SRC_IN));
    L7:
        r10.draw(r8);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        int r11 = getMeasuredWidth();
        int r12 = getMeasuredHeight();
        Drawable r13 = this.f6187m;
        if (r13 == null) goto L5;
        int r14 = r13.getIntrinsicWidth();
        int r15 = getPaddingLeft() + r14;
        r11 = Math.max(r11, getPaddingRight() + r15);
        int r16 = r13.getIntrinsicHeight();
        int r17 = getPaddingTop() + r16;
        r12 = Math.max(r12, getPaddingBottom() + r17);
    L5:
        setMeasuredDimension(r11, r12);
    }

    public void setBorderColor(int r8) {
        this.f6198x.r(r8);
    }

    public void setBorderWidth(int r8) {
        this.f6198x.s(r8);
    }

    public void setBottomDividerAlpha(int r8) {
        this.f6198x.t(r8);
    }

    public final void setButtonSourceBitmap(int r8) {
        if (r8 >= 0) goto L4;
        return;
    L4:
        Context r10 = getContext();
        Object r11 = androidx.core.content.a.f1674a;
        setMIcon(androidx.core.content.a.b.b(r10, r8));
        Drawable r12 = this.f6187m;
        if (r12 == null) goto L7;
        int r13 = r12.getAlpha();
    L8:
        this.f6192r = r13;
        invalidate();
        return;
    L7:
        r13 = 0;
        goto L8
    }

    @Override // ac.a
    public void setChangeAlphaWhenDisable(boolean r8) {
        this.f6197w.setChangeAlphaWhenDisable(r8);
    }

    @Override // ac.a
    public void setChangeAlphaWhenPress(boolean r8) {
        this.f6197w.setChangeAlphaWhenPress(r8);
    }

    public void setChangeAlphaWhenSelected(boolean r8) {
        this.f6197w.f262o = r8;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        if (r8 == null) goto L5;
        boolean r13 = true;
    L6:
        a(r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        if (r8 == null) goto L5;
        boolean r13 = true;
    L6:
        a(r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r8) {
        this.f6195u = r8;
        if (isEnabled() == true) goto L6;
        b(false);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        e r10 = this.f6185a;
        if (r10 == null) goto L5;
        r10.c(this, r8);
    L5:
        b(r8);
    }

    @Override // ac.a
    public void setKeepPressAlpha(boolean r8) {
        this.f6197w.setKeepPressAlpha(r8);
    }

    public void setLeftDividerAlpha(int r8) {
        this.f6198x.u(r8);
    }

    public final void setMIcon(Drawable r8) {
        this.f6187m = r8;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r8) {
        this.f6189o = r8;
        invalidate();
    }

    public void setOuterNormalColor(int r8) {
        this.f6198x.v(r8);
    }

    public void setOutlineExcludePadding(boolean r8) {
        this.f6198x.w(r8);
    }

    public void setOverridePressColor(int r8) {
        this.f6197w.f264q = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        super.setPressed(r8);
        f r10 = this.f6186b;
        if (r10 == null) goto L5;
        r10.e(r8);
    L5:
        e r11 = this.f6185a;
        if (r11 == null) goto L9;
        r11.e(r8);
        return;
    }

    public void setRadius(int r8) {
        this.f6198x.x(r8);
    }

    public void setRightDividerAlpha(int r8) {
        this.f6198x.z(r8);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r8) {
        super.setSelected(r8);
        e r10 = this.f6185a;
        if (r10 == null) goto L6;
        r10.d(this, r8);
        return;
    }

    public void setShadowAlpha(float r8) {
        this.f6198x.B(r8);
    }

    public void setShadowColor(int r8) {
        this.f6198x.C(r8);
    }

    public void setShadowCornerRadius(int r8) {
        this.f6198x.f308o0 = r8;
    }

    public void setShadowElevation(int r8) {
        this.f6198x.D(r8);
    }

    public void setShadowStyle(int r8) {
        this.f6198x.E(r8);
    }

    public void setShowBorderOnlyBeforeL(boolean r8) {
        this.f6198x.F(r8);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r8) {
        if (this.f6196v == true) goto L5;
        this.f6191q = r8;
    L5:
        super.setTextColor(r8);
    }

    public void setTopDividerAlpha(int r8) {
        this.f6198x.G(r8);
    }

    @Override // ac.b
    public void setWidthMin(int r8) {
        this.f6198x.f305n = r8;
    }

    public OButton(Context r8, AttributeSet r10, int r11) {
        l r12 = new l(r8, r10, 0, 0);
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6197w = r12.f327b;
        h r13 = r12.f326a;
        this.f6198x = r13;
        this.f6199y = r12;
        this.f6195u = 1.0f;
        if (r13 == null) goto L21;
        r13.f302l0 = true;
        r12.b(this);
        b r14 = getLayoutHelper();
        if (r14 == null) goto L19;
        h r15 = (h) r14;
        ac.a r16 = getAlphaHelper();
        if (r16 == null) goto L17;
        this.f6185a = (e) r16;
        this.f6186b = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r17 = r8.obtainStyledAttributes(r10, nb.a.f9489c);
        i.e(r17, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f6188n = r17.getResourceId(0, -1);
        setMImageTintColorId(r17.getResourceId(1, -1));
        int r18 = this.f6188n;
        if (r18 < 0) goto L11;
        setButtonSourceBitmap(r18);
    L11:
        setTextAppearance(r17.getResourceId(3, R.style.Title_Title_M_Thick));
        this.f6193s = r17.getBoolean(2, false);
        int r19 = getCurrentTextColor();
        this.f6191q = r19;
        ColorStateList r20 = ColorStateList.valueOf(r19);
        i.e(r20, "ColorStateList.valueOf(textColor)");
        setCompoundDrawableTintList(r20);
        this.f6194t = r17.getDimensionPixelSize(5, 0);
        Drawable[] r21 = getCompoundDrawables();
        i.e(r21, "getCompoundDrawables()");
        if (((Drawable) yd.e.t0(r21, 0)) == null) goto L14;
        a(true);
    L14:
        this.f6195u = r17.getFloat(4, 1.0f);
        r17.recycle();
        b(isEnabled());
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }
}
