package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.d;
import com.google.android.material.shape.e;
import com.google.android.material.shape.l;
import q5.b;
import q5.f;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final double f3102u = 0.0d;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Drawable f3103v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final MaterialCardView f3104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Rect f3105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f3106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f3107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Dimension
    private int f3108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Dimension
    private int f3109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Dimension
    private int f3111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Drawable f3112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Drawable f3113j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f3114k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private ColorStateList f3115l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private l f3116m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private ColorStateList f3117n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private Drawable f3118o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private LayerDrawable f3119p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f3120q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f3121r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3122s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f3123t;

    /* JADX INFO: renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    class C0077a extends InsetDrawable {
        C0077a(a r10, Drawable r11, int r12, int r13, int r14, int r15) {
            super(r11, r12, r13, r14, r15);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect r10) {
            return false;
        }
    }

    static {
        f3102u = Math.cos(Math.toRadians(45.0d));
        if (Build.VERSION.SDK_INT > 28) goto L5;
        ColorDrawable r10 = new ColorDrawable();
    L6:
        f3103v = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public a(@NonNull MaterialCardView r10, AttributeSet r11, int r12, @StyleRes int r13) {
        this.f3105b = new Rect();
        this.f3122s = false;
        this.f3104a = r10;
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(r10.getContext(), r11, r12, r13);
        this.f3106c = r14;
        r14.initializeElevationOverlay(r10.getContext());
        r14.setShadowColor(-12303292);
        l.b r15 = r14.getShapeAppearanceModel().v();
        TypedArray r16 = r10.getContext().obtainStyledAttributes(r11, q5.l.CardView, r12, k.CardView);
        int r17 = q5.l.CardView_cardCornerRadius;
        if (r16.hasValue(r17) == false) goto L5;
        r15.o(r16.getDimension(r17, 0.0f));
    L5:
        this.f3107d = new MaterialShapeDrawable();
        V(r15.m());
        r16.recycle();
    }

    @NonNull
    private Drawable B(Drawable r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
    L11:
        int r12 = (int) Math.ceil(d());
        int r13 = (int) Math.ceil(c());
        int r14 = r12;
    L13:
        return new C0077a(this, r10, r13, r14, r13, r14);
    L8:
        if (this.f3104a.getUseCompatPadding() == true) goto L11;
        r13 = 0;
        r14 = 0;
        goto L13
    L5:
        r11 = false;
        goto L6
    }

    private boolean E() {
        if ((this.f3110g & 80) != 80) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean F() {
        if ((this.f3110g & GravityCompat.END) != 8388613) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean Z() {
        if (this.f3104a.getPreventCornerOverlap() == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == true) goto L7;
        return true;
    }

    private float a() {
        return Math.max(Math.max(b(this.f3116m.q(), this.f3106c.getTopLeftCornerResolvedSize()), b(this.f3116m.s(), this.f3106c.getTopRightCornerResolvedSize())), Math.max(b(this.f3116m.k(), this.f3106c.getBottomRightCornerResolvedSize()), b(this.f3116m.i(), this.f3106c.getBottomLeftCornerResolvedSize())));
    }

    private boolean a0() {
        if (this.f3104a.getPreventCornerOverlap() == true) goto L5;
    L9:
        return false;
    L5:
        if (e() == false) goto L9;
        if (this.f3104a.getUseCompatPadding() == false) goto L9;
        return true;
    }

    private float b(d r10, float r11) {
        if ((r10 instanceof com.google.android.material.shape.k) == false) goto L7;
        return (float) ((1.0d - f3102u) * ((double) r11));
    L7:
        if ((r10 instanceof e) == true) goto L9;
        return 0.0f;
    L9:
        return r11 / 2.0f;
    }

    private float c() {
        float r10 = this.f3104a.getMaxCardElevation();
        if (a0() == false) goto L5;
        float r11 = a();
    L7:
        return r10 + r11;
    L5:
        r11 = 0.0f;
        goto L7
    }

    private float d() {
        float r10 = this.f3104a.getMaxCardElevation() * 1.5f;
        if (a0() == false) goto L5;
        float r11 = a();
    L7:
        return r10 + r11;
    L5:
        r11 = 0.0f;
        goto L7
    }

    private boolean e() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        return false;
    L5:
        if (this.f3106c.isRoundRect() == false) goto L7;
        return true;
    }

    private void e0(Drawable r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L7:
        this.f3104a.setForeground(B(r10));
        return;
    L5:
        if ((this.f3104a.getForeground() instanceof InsetDrawable) == false) goto L7;
        ((InsetDrawable) this.f3104a.getForeground()).setDrawable(r10);
    }

    @NonNull
    private Drawable f() {
        StateListDrawable r10 = new StateListDrawable();
        MaterialShapeDrawable r11 = h();
        this.f3120q = r11;
        r11.setFillColor(this.f3114k);
        r10.addState(new int[]{R.attr.state_pressed}, this.f3120q);
        return r10;
    }

    @NonNull
    private Drawable g() {
        if (com.google.android.material.ripple.a.f3599a == false) goto L7;
        this.f3121r = h();
        return new RippleDrawable(this.f3114k, null, this.f3121r);
    L7:
        return f();
    }

    private void g0() {
        if (com.google.android.material.ripple.a.f3599a == false) goto L7;
        Drawable r10 = this.f3118o;
        if (r10 == null) goto L7;
        ((RippleDrawable) r10).setColor(this.f3114k);
        return;
    L7:
        MaterialShapeDrawable r11 = this.f3120q;
        if (r11 == null) goto L12;
        r11.setFillColor(this.f3114k);
        return;
    }

    @NonNull
    private MaterialShapeDrawable h() {
        return new MaterialShapeDrawable(this.f3116m);
    }

    @NonNull
    private Drawable r() {
        if (this.f3118o != null) goto L6;
        this.f3118o = g();
    L6:
        if (this.f3119p != null) goto L9;
        LayerDrawable r10 = new LayerDrawable(new Drawable[]{this.f3118o, this.f3107d, this.f3113j});
        this.f3119p = r10;
        r10.setId(2, f.mtrl_card_checked_layer_id);
    L9:
        return this.f3119p;
    }

    private float t() {
        if (this.f3104a.getPreventCornerOverlap() == true) goto L5;
        return 0.0f;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (this.f3104a.getUseCompatPadding() == true) goto L9;
        return 0.0f;
    L9:
        return (float) ((1.0d - f3102u) * ((double) this.f3104a.getCardViewRadius()));
    }

    @NonNull
    Rect A() {
        return this.f3105b;
    }

    boolean C() {
        return this.f3122s;
    }

    boolean D() {
        return this.f3123t;
    }

    void G(@NonNull TypedArray r10) {
        ColorStateList r11 = c.a(this.f3104a.getContext(), r10, q5.l.MaterialCardView_strokeColor);
        this.f3117n = r11;
        if (r11 != null) goto L5;
        this.f3117n = ColorStateList.valueOf(-1);
    L5:
        this.f3111h = r10.getDimensionPixelSize(q5.l.MaterialCardView_strokeWidth, 0);
        boolean r12 = r10.getBoolean(q5.l.MaterialCardView_android_checkable, false);
        this.f3123t = r12;
        this.f3104a.setLongClickable(r12);
        this.f3115l = c.a(this.f3104a.getContext(), r10, q5.l.MaterialCardView_checkedIconTint);
        N(c.e(this.f3104a.getContext(), r10, q5.l.MaterialCardView_checkedIcon));
        Q(r10.getDimensionPixelSize(q5.l.MaterialCardView_checkedIconSize, 0));
        P(r10.getDimensionPixelSize(q5.l.MaterialCardView_checkedIconMargin, 0));
        this.f3110g = r10.getInteger(q5.l.MaterialCardView_checkedIconGravity, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END);
        ColorStateList r13 = c.a(this.f3104a.getContext(), r10, q5.l.MaterialCardView_rippleColor);
        this.f3114k = r13;
        if (r13 != null) goto L8;
        this.f3114k = ColorStateList.valueOf(t5.a.d(this.f3104a, b.colorControlHighlight));
    L8:
        K(c.a(this.f3104a.getContext(), r10, q5.l.MaterialCardView_cardForegroundColor));
        g0();
        d0();
        h0();
        this.f3104a.setBackgroundInternal(B(this.f3106c));
        if (this.f3104a.isClickable() == false) goto L11;
        Drawable r14 = r();
    L12:
        this.f3112i = r14;
        this.f3104a.setForeground(B(r14));
        return;
    L11:
        r14 = this.f3107d;
        goto L12
    }

    void H(int r13, int r14) {
        if (this.f3119p == null) goto L36;
        int r10 = 0;
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
    L13:
        int r12 = (int) Math.ceil(d() * 2.0f);
        r10 = (int) Math.ceil(c() * 2.0f);
        int r15 = r12;
    L15:
        if (F() == false) goto L17;
        int r16 = ((r13 - this.f3108e) - this.f3109f) - r10;
    L19:
        if (E() == false) goto L21;
        int r17 = this.f3108e;
    L22:
        int r18 = r17;
        if (F() == false) goto L25;
        int r19 = this.f3108e;
    L27:
        if (E() == false) goto L29;
        int r110 = ((r14 - this.f3108e) - this.f3109f) - r15;
    L30:
        int r20 = r110;
        if (ViewCompat.getLayoutDirection(this.f3104a) != 1) goto L33;
        int r21 = r19;
        int r22 = r16;
    L34:
        this.f3119p.setLayerInset(2, r21, r20, r22, r18);
        return;
    L33:
        r22 = r19;
        r21 = r16;
        goto L34
    L29:
        r110 = this.f3108e;
        goto L30
    L25:
        r19 = ((r13 - this.f3108e) - this.f3109f) - r10;
        goto L27
    L21:
        r17 = ((r14 - this.f3108e) - this.f3109f) - r15;
        goto L22
    L17:
        r16 = this.f3108e;
        goto L19
    L10:
        if (this.f3104a.getUseCompatPadding() == true) goto L13;
        r15 = 0;
        goto L15
    L7:
        r11 = false;
        goto L8
    }

    void I(boolean r10) {
        this.f3122s = r10;
    }

    void J(ColorStateList r10) {
        this.f3106c.setFillColor(r10);
    }

    void K(@Nullable ColorStateList r10) {
        MaterialShapeDrawable r11 = this.f3107d;
        if (r10 != null) goto L5;
        r10 = ColorStateList.valueOf(0);
    L5:
        r11.setFillColor(r10);
    }

    void L(boolean r10) {
        this.f3123t = r10;
    }

    public void M(boolean r10) {
        Drawable r11 = this.f3113j;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 255;
    L7:
        r11.setAlpha(r12);
        return;
    L6:
        r12 = 0;
        goto L7
    }

    void N(@Nullable Drawable r10) {
        if (r10 == null) goto L4;
        Drawable r11 = DrawableCompat.wrap(r10).mutate();
        this.f3113j = r11;
        DrawableCompat.setTintList(r11, this.f3115l);
        M(this.f3104a.isChecked());
    L5:
        LayerDrawable r12 = this.f3119p;
        if (r12 == null) goto L9;
        r12.setDrawableByLayerId(f.mtrl_card_checked_layer_id, this.f3113j);
        return;
    L9:
        return;
    L4:
        this.f3113j = f3103v;
        goto L5
    }

    void O(int r10) {
        this.f3110g = r10;
        H(this.f3104a.getMeasuredWidth(), this.f3104a.getMeasuredHeight());
    }

    void P(@Dimension int r10) {
        this.f3108e = r10;
    }

    void Q(@Dimension int r10) {
        this.f3109f = r10;
    }

    void R(@Nullable ColorStateList r10) {
        this.f3115l = r10;
        Drawable r11 = this.f3113j;
        if (r11 == null) goto L6;
        DrawableCompat.setTintList(r11, r10);
        return;
    }

    void S(float r10) {
        V(this.f3116m.w(r10));
        this.f3112i.invalidateSelf();
        if (a0() == false) goto L5;
    L6:
        c0();
    L8:
        if (a0() == false) goto L11;
        f0();
        return;
    L11:
        return;
    L5:
        if (Z() == false) goto L8;
        goto L6
    }

    void T(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.f3106c.setInterpolation(r10);
        MaterialShapeDrawable r11 = this.f3107d;
        if (r11 == null) goto L5;
        r11.setInterpolation(r10);
    L5:
        MaterialShapeDrawable r12 = this.f3121r;
        if (r12 == null) goto L9;
        r12.setInterpolation(r10);
        return;
    }

    void U(@Nullable ColorStateList r10) {
        this.f3114k = r10;
        g0();
    }

    void V(@NonNull l r10) {
        this.f3116m = r10;
        this.f3106c.setShapeAppearanceModel(r10);
        MaterialShapeDrawable r11 = this.f3106c;
        r11.setShadowBitmapDrawingEnable(!r11.isRoundRect());
        MaterialShapeDrawable r12 = this.f3107d;
        if (r12 == null) goto L5;
        r12.setShapeAppearanceModel(r10);
    L5:
        MaterialShapeDrawable r13 = this.f3121r;
        if (r13 == null) goto L8;
        r13.setShapeAppearanceModel(r10);
    L8:
        MaterialShapeDrawable r14 = this.f3120q;
        if (r14 == null) goto L12;
        r14.setShapeAppearanceModel(r10);
        return;
    }

    void W(ColorStateList r10) {
        if (this.f3117n != r10) goto L5;
        return;
    L5:
        this.f3117n = r10;
        h0();
    }

    void X(@Dimension int r10) {
        if (r10 != this.f3111h) goto L5;
        return;
    L5:
        this.f3111h = r10;
        h0();
    }

    void Y(int r10, int r11, int r12, int r13) {
        this.f3105b.set(r10, r11, r12, r13);
        c0();
    }

    void b0() {
        Drawable r10 = this.f3112i;
        if (this.f3104a.isClickable() == false) goto L5;
        Drawable r11 = r();
    L6:
        this.f3112i = r11;
        if (r10 == r11) goto L10;
        e0(r11);
        return;
    L10:
        return;
    L5:
        r11 = this.f3107d;
        goto L6
    }

    void c0() {
        if (Z() == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        float r11 = a();
    L12:
        int r12 = (int) (r11 - t());
        MaterialCardView r13 = this.f3104a;
        Rect r14 = this.f3105b;
        r13.setAncestorContentPadding(r14.left + r12, r14.top + r12, r14.right + r12, r14.bottom + r12);
        return;
    L11:
        r11 = 0.0f;
        goto L12
    L5:
        if (a0() == true) goto L8;
        r10 = false;
        goto L9
    }

    void d0() {
        this.f3106c.setElevation(this.f3104a.getCardElevation());
    }

    void f0() {
        if (C() == true) goto L5;
        this.f3104a.setBackgroundInternal(B(this.f3106c));
    L5:
        this.f3104a.setForeground(B(this.f3112i));
    }

    void h0() {
        this.f3107d.setStroke(this.f3111h, this.f3117n);
    }

    @RequiresApi(api = 23)
    void i() {
        Drawable r10 = this.f3118o;
        if (r10 == null) goto L6;
        Rect r11 = r10.getBounds();
        int r12 = r11.bottom;
        this.f3118o.setBounds(r11.left, r11.top, r11.right, r12 - 1);
        this.f3118o.setBounds(r11.left, r11.top, r11.right, r12);
        return;
    }

    @NonNull
    MaterialShapeDrawable j() {
        return this.f3106c;
    }

    ColorStateList k() {
        return this.f3106c.getFillColor();
    }

    ColorStateList l() {
        return this.f3107d.getFillColor();
    }

    @Nullable
    Drawable m() {
        return this.f3113j;
    }

    int n() {
        return this.f3110g;
    }

    @Dimension
    int o() {
        return this.f3108e;
    }

    @Dimension
    int p() {
        return this.f3109f;
    }

    @Nullable
    ColorStateList q() {
        return this.f3115l;
    }

    float s() {
        return this.f3106c.getTopLeftCornerResolvedSize();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float u() {
        return this.f3106c.getInterpolation();
    }

    @Nullable
    ColorStateList v() {
        return this.f3114k;
    }

    l w() {
        return this.f3116m;
    }

    @ColorInt
    int x() {
        ColorStateList r10 = this.f3117n;
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getDefaultColor();
    }

    @Nullable
    ColorStateList y() {
        return this.f3117n;
    }

    @Dimension
    int z() {
        return this.f3111h;
    }
}
