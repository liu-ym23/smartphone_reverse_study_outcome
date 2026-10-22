package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.c;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import q5.b;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean f3081t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final boolean f3082u = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialButton f3083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private l f3084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f3091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private ColorStateList f3092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f3093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private ColorStateList f3094l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private Drawable f3095m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f3096n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f3097o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f3098p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f3099q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LayerDrawable f3100r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3101s;

    static {
        int r10 = Build.VERSION.SDK_INT;
        boolean r11 = true;
        if (r10 < 21) goto L5;
        boolean r12 = true;
    L6:
        f3081t = r12;
        if (r10 >= 21) goto L9;
    L11:
        r11 = false;
    L12:
        f3082u = r11;
        return;
    L9:
        if (r10 > 22) goto L11;
    L5:
        r12 = false;
        goto L6
    }

    a(MaterialButton r10, @NonNull l r11) {
        this.f3096n = false;
        this.f3097o = false;
        this.f3098p = false;
        this.f3083a = r10;
        this.f3084b = r11;
    }

    private void E(@Dimension int r10, @Dimension int r11) {
        int r12 = ViewCompat.getPaddingStart(this.f3083a);
        int r13 = this.f3083a.getPaddingTop();
        int r14 = ViewCompat.getPaddingEnd(this.f3083a);
        int r15 = this.f3083a.getPaddingBottom();
        int r16 = this.f3087e;
        int r17 = this.f3088f;
        this.f3088f = r11;
        this.f3087e = r10;
        if (this.f3097o == true) goto L5;
        F();
    L5:
        ViewCompat.setPaddingRelative(this.f3083a, r12, (r13 + r10) - r16, r14, (r15 + r11) - r17);
    }

    private void F() {
        this.f3083a.setInternalBackground(a());
        MaterialShapeDrawable r10 = f();
        if (r10 == null) goto L6;
        r10.setElevation(this.f3101s);
        return;
    }

    private void G(@NonNull l r10) {
        if (f3082u == false) goto L8;
        if (this.f3097o == true) goto L8;
        int r11 = ViewCompat.getPaddingStart(this.f3083a);
        int r12 = this.f3083a.getPaddingTop();
        int r13 = ViewCompat.getPaddingEnd(this.f3083a);
        int r14 = this.f3083a.getPaddingBottom();
        F();
        ViewCompat.setPaddingRelative(this.f3083a, r11, r12, r13, r14);
        return;
    L8:
        if (f() == null) goto L11;
        f().setShapeAppearanceModel(r10);
    L11:
        if (n() == null) goto L14;
        n().setShapeAppearanceModel(r10);
    L14:
        if (e() == null) goto L18;
        e().setShapeAppearanceModel(r10);
        return;
    }

    private void I() {
        MaterialShapeDrawable r10 = f();
        MaterialShapeDrawable r11 = n();
        if (r10 == null) goto L12;
        r10.setStroke(this.f3090h, this.f3093k);
        if (r11 == null) goto L13;
        float r12 = this.f3090h;
        if (this.f3096n == false) goto L9;
        int r13 = t5.a.d(this.f3083a, b.colorSurface);
    L10:
        r11.setStroke(r12, r13);
        return;
    L9:
        r13 = 0;
        goto L10
    L13:
        return;
    }

    @NonNull
    private InsetDrawable J(Drawable r10) {
        return new InsetDrawable(r10, this.f3085c, this.f3087e, this.f3086d, this.f3088f);
    }

    private Drawable a() {
        MaterialShapeDrawable r10 = new MaterialShapeDrawable(this.f3084b);
        r10.initializeElevationOverlay(this.f3083a.getContext());
        DrawableCompat.setTintList(r10, this.f3092j);
        PorterDuff.Mode r11 = this.f3091i;
        if (r11 == null) goto L5;
        DrawableCompat.setTintMode(r10, r11);
    L5:
        r10.setStroke(this.f3090h, this.f3093k);
        MaterialShapeDrawable r12 = new MaterialShapeDrawable(this.f3084b);
        r12.setTint(0);
        float r13 = this.f3090h;
        if (this.f3096n == false) goto L8;
        int r14 = t5.a.d(this.f3083a, b.colorSurface);
    L9:
        r12.setStroke(r13, r14);
        if (f3081t == false) goto L13;
        MaterialShapeDrawable r15 = new MaterialShapeDrawable(this.f3084b);
        this.f3095m = r15;
        DrawableCompat.setTint(r15, -1);
        RippleDrawable r16 = new RippleDrawable(com.google.android.material.ripple.a.d(this.f3094l), J(new LayerDrawable(new Drawable[]{r12, r10})), this.f3095m);
        this.f3100r = r16;
        return r16;
    L13:
        RippleDrawableCompat r17 = new RippleDrawableCompat(this.f3084b);
        this.f3095m = r17;
        DrawableCompat.setTintList(r17, com.google.android.material.ripple.a.d(this.f3094l));
        LayerDrawable r18 = new LayerDrawable(new Drawable[]{r12, r10, this.f3095m});
        this.f3100r = r18;
        return J(r18);
    L8:
        r14 = 0;
        goto L9
    }

    @Nullable
    private MaterialShapeDrawable g(boolean r10) {
        LayerDrawable r11 = this.f3100r;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.getNumberOfLayers() <= 0) goto L13;
        boolean r12 = f3081t;
        LayerDrawable r13 = this.f3100r;
        if (r12 == false) goto L10;
        r13 = (LayerDrawable) ((InsetDrawable) r13.getDrawable(0)).getDrawable();
    L10:
        return (MaterialShapeDrawable) r13.getDrawable(!r10 ? 1 : 0);
    L13:
        return null;
    }

    @Nullable
    private MaterialShapeDrawable n() {
        return g(true);
    }

    void A(@Nullable ColorStateList r10) {
        if (this.f3093k == r10) goto L6;
        this.f3093k = r10;
        I();
        return;
    }

    void B(int r10) {
        if (this.f3090h == r10) goto L6;
        this.f3090h = r10;
        I();
        return;
    }

    void C(@Nullable ColorStateList r10) {
        if (this.f3092j == r10) goto L8;
        this.f3092j = r10;
        if (f() == null) goto L9;
        DrawableCompat.setTintList(f(), this.f3092j);
        return;
    L9:
        return;
    }

    void D(@Nullable PorterDuff.Mode r10) {
        if (this.f3091i == r10) goto L10;
        this.f3091i = r10;
        if (f() != null) goto L7;
        return;
    L7:
        if (this.f3091i == null) goto L12;
        DrawableCompat.setTintMode(f(), this.f3091i);
        return;
    L12:
        return;
    }

    void H(int r10, int r11) {
        Drawable r12 = this.f3095m;
        if (r12 == null) goto L6;
        r12.setBounds(this.f3085c, this.f3087e, r11 - this.f3086d, r10 - this.f3088f);
        return;
    }

    int b() {
        return this.f3089g;
    }

    public int c() {
        return this.f3088f;
    }

    public int d() {
        return this.f3087e;
    }

    @Nullable
    public p e() {
        LayerDrawable r10 = this.f3100r;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getNumberOfLayers() <= 1) goto L14;
        int r11 = this.f3100r.getNumberOfLayers();
        LayerDrawable r12 = this.f3100r;
        if (r11 <= 2) goto L11;
        Object r13 = r12.getDrawable(2);
    L10:
        return (p) r13;
    L11:
        r13 = r12.getDrawable(1);
        goto L10
    L14:
        return null;
    }

    @Nullable
    MaterialShapeDrawable f() {
        return g(false);
    }

    @Nullable
    ColorStateList h() {
        return this.f3094l;
    }

    @NonNull
    l i() {
        return this.f3084b;
    }

    @Nullable
    ColorStateList j() {
        return this.f3093k;
    }

    int k() {
        return this.f3090h;
    }

    ColorStateList l() {
        return this.f3092j;
    }

    PorterDuff.Mode m() {
        return this.f3091i;
    }

    boolean o() {
        return this.f3097o;
    }

    boolean p() {
        return this.f3099q;
    }

    void q(@NonNull TypedArray r10) {
        this.f3085c = r10.getDimensionPixelOffset(q5.l.MaterialButton_android_insetLeft, 0);
        this.f3086d = r10.getDimensionPixelOffset(q5.l.MaterialButton_android_insetRight, 0);
        this.f3087e = r10.getDimensionPixelOffset(q5.l.MaterialButton_android_insetTop, 0);
        this.f3088f = r10.getDimensionPixelOffset(q5.l.MaterialButton_android_insetBottom, 0);
        int r11 = q5.l.MaterialButton_cornerRadius;
        if (r10.hasValue(r11) == false) goto L5;
        int r12 = r10.getDimensionPixelSize(r11, -1);
        this.f3089g = r12;
        y(this.f3084b.w(r12));
        this.f3098p = true;
    L5:
        this.f3090h = r10.getDimensionPixelSize(q5.l.MaterialButton_strokeWidth, 0);
        this.f3091i = ViewUtils.j(r10.getInt(q5.l.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f3092j = c.a(this.f3083a.getContext(), r10, q5.l.MaterialButton_backgroundTint);
        this.f3093k = c.a(this.f3083a.getContext(), r10, q5.l.MaterialButton_strokeColor);
        this.f3094l = c.a(this.f3083a.getContext(), r10, q5.l.MaterialButton_rippleColor);
        this.f3099q = r10.getBoolean(q5.l.MaterialButton_android_checkable, false);
        this.f3101s = r10.getDimensionPixelSize(q5.l.MaterialButton_elevation, 0);
        int r13 = ViewCompat.getPaddingStart(this.f3083a);
        int r14 = this.f3083a.getPaddingTop();
        int r15 = ViewCompat.getPaddingEnd(this.f3083a);
        int r16 = this.f3083a.getPaddingBottom();
        if (r10.hasValue(q5.l.MaterialButton_android_background) == false) goto L8;
        s();
    L9:
        ViewCompat.setPaddingRelative(this.f3083a, r13 + this.f3085c, r14 + this.f3087e, r15 + this.f3086d, r16 + this.f3088f);
        return;
    L8:
        F();
        goto L9
    }

    void r(int r10) {
        if (f() == null) goto L6;
        f().setTint(r10);
        return;
    }

    void s() {
        this.f3097o = true;
        this.f3083a.setSupportBackgroundTintList(this.f3092j);
        this.f3083a.setSupportBackgroundTintMode(this.f3091i);
    }

    void t(boolean r10) {
        this.f3099q = r10;
    }

    void u(int r10) {
        if (this.f3098p == true) goto L5;
    L6:
        this.f3089g = r10;
        this.f3098p = true;
        y(this.f3084b.w(r10));
        return;
    L5:
        if (this.f3089g != r10) goto L6;
    }

    public void v(@Dimension int r10) {
        E(this.f3087e, r10);
    }

    public void w(@Dimension int r10) {
        E(r10, this.f3088f);
    }

    void x(@Nullable ColorStateList r10) {
        if (this.f3094l == r10) goto L14;
        this.f3094l = r10;
        boolean r11 = f3081t;
        if (r11 == true) goto L7;
    L9:
        if (r11 == false) goto L11;
        return;
    L11:
        if ((this.f3083a.getBackground() instanceof RippleDrawableCompat) == false) goto L17;
        ((RippleDrawableCompat) this.f3083a.getBackground()).setTintList(com.google.android.material.ripple.a.d(r10));
        return;
    L17:
        return;
    L7:
        if ((this.f3083a.getBackground() instanceof RippleDrawable) == false) goto L9;
        ((RippleDrawable) this.f3083a.getBackground()).setColor(com.google.android.material.ripple.a.d(r10));
        return;
    }

    void y(@NonNull l r10) {
        this.f3084b = r10;
        G(r10);
    }

    void z(boolean r10) {
        this.f3096n = r10;
        I();
    }
}
