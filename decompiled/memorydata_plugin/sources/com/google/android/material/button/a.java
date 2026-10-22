package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.r;
import com.google.android.material.resources.c;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3822a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f3823b = false;
    private final MaterialButton c;
    private l d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private PorterDuff.Mode k;
    private ColorStateList l;
    private ColorStateList m;
    private ColorStateList n;
    private Drawable o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private LayerDrawable t;
    private int u;

    static {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r0 = true;
    L6:
        f3822a = r0;
        if (Build.VERSION.SDK_INT >= 21) goto L9;
    L11:
        r1 = false;
    L12:
        f3823b = r1;
        return;
    L9:
        if (Build.VERSION.SDK_INT > 22) goto L11;
    L5:
        r0 = false;
        goto L6
    }

    a(MaterialButton r2, l r3) {
        this.p = false;
        this.q = false;
        this.r = false;
        this.c = r2;
        this.d = r3;
    }

    private InsetDrawable a(Drawable r8) {
        return new InsetDrawable(r8, this.e, this.g, this.f, this.h);
    }

    private void b(int r8, int r9) {
        int r0 = ViewCompat.getPaddingStart(this.c);
        int r1 = this.c.getPaddingTop();
        int r2 = ViewCompat.getPaddingEnd(this.c);
        int r3 = this.c.getPaddingBottom();
        int r4 = this.g;
        int r5 = this.h;
        this.h = r9;
        this.g = r8;
        if (this.q == true) goto L5;
        o();
    L5:
        ViewCompat.setPaddingRelative(this.c, r0, (r1 + r8) - r4, r2, (r3 + r9) - r5);
    }

    private void b(l r4) {
        if (f3823b == false) goto L8;
        if (this.q == true) goto L8;
        int r5 = ViewCompat.getPaddingStart(this.c);
        int r0 = this.c.getPaddingTop();
        int r1 = ViewCompat.getPaddingEnd(this.c);
        int r2 = this.c.getPaddingBottom();
        o();
        ViewCompat.setPaddingRelative(this.c, r5, r0, r1, r2);
        return;
    L8:
        if (i() == null) goto L11;
        i().setShapeAppearanceModel(r4);
    L11:
        if (r() == null) goto L14;
        r().setShapeAppearanceModel(r4);
    L14:
        if (k() == null) goto L18;
        k().setShapeAppearanceModel(r4);
        return;
    }

    private MaterialShapeDrawable c(boolean r3) {
        LayerDrawable r0 = this.t;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() <= 0) goto L13;
        boolean r1 = f3822a;
        LayerDrawable r2 = this.t;
        if (r1 == false) goto L10;
        r2 = (LayerDrawable) ZeusTransformUtils.preCheckCast(((InsetDrawable) ZeusTransformUtils.preCheckCast(r2.getDrawable(0), InsetDrawable.class, "com.obric.memorydata.plugin")).getDrawable(), LayerDrawable.class, "com.obric.memorydata.plugin");
    L10:
        return (MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(r2.getDrawable(!r3 ? 1 : 0), MaterialShapeDrawable.class, "com.obric.memorydata.plugin");
    L13:
        return null;
    }

    private void o() {
        this.c.setInternalBackground(p());
        MaterialShapeDrawable r0 = i();
        if (r0 == null) goto L6;
        r0.setElevation(this.u);
        return;
    }

    private Drawable p() {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.d);
        r0.initializeElevationOverlay((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        DrawableCompat.setTintList(r0, this.l);
        PorterDuff.Mode r1 = this.k;
        if (r1 == null) goto L5;
        DrawableCompat.setTintMode(r0, r1);
    L5:
        r0.setStroke(this.j, this.m);
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(this.d);
        r2.setTint(0);
        float r3 = this.j;
        if (this.p == false) goto L8;
        int r4 = com.google.android.material.c.a.a(this.c, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
    L9:
        r2.setStroke(r3, r4);
        if (f3822a == false) goto L13;
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(this.d);
        this.o = r5;
        DrawableCompat.setTint(r5, -1);
        RippleDrawable r6 = new RippleDrawable(com.google.android.material.ripple.a.b(this.n), a(new LayerDrawable(new Drawable[]{r2, r0})), this.o);
        this.t = r6;
        return r6;
    L13:
        RippleDrawableCompat r7 = new RippleDrawableCompat(this.d);
        this.o = r7;
        DrawableCompat.setTintList(r7, com.google.android.material.ripple.a.b(this.n));
        LayerDrawable r8 = new LayerDrawable(new Drawable[]{r2, r0, this.o});
        this.t = r8;
        return a(r8);
    L8:
        r4 = 0;
        goto L9
    }

    private void q() {
        MaterialShapeDrawable r0 = i();
        MaterialShapeDrawable r1 = r();
        if (r0 == null) goto L12;
        r0.setStroke(this.j, this.m);
        if (r1 == null) goto L13;
        float r2 = this.j;
        if (this.p == false) goto L9;
        int r5 = com.google.android.material.c.a.a(this.c, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
    L10:
        r1.setStroke(r2, r5);
        return;
    L9:
        r5 = 0;
        goto L10
    L13:
        return;
    }

    private MaterialShapeDrawable r() {
        return c(true);
    }

    void a() {
        this.q = true;
        this.c.setSupportBackgroundTintList(this.l);
        this.c.setSupportBackgroundTintMode(this.k);
    }

    void a(int r2) {
        if (i() == null) goto L6;
        i().setTint(r2);
        return;
    }

    void a(int r5, int r6) {
        Drawable r0 = this.o;
        if (r0 == null) goto L6;
        r0.setBounds(this.e, this.g, r6 - this.f, r5 - this.h);
        return;
    }

    void a(ColorStateList r2) {
        if (this.l == r2) goto L8;
        this.l = r2;
        if (i() == null) goto L9;
        DrawableCompat.setTintList(i(), this.l);
        return;
    L9:
        return;
    }

    void a(TypedArray r8) {
        this.e = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetLeft, "styleable", "MaterialButton_android_insetLeft"), 0);
        this.f = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetRight, "styleable", "MaterialButton_android_insetRight"), 0);
        this.g = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetTop, "styleable", "MaterialButton_android_insetTop"), 0);
        this.h = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetBottom, "styleable", "MaterialButton_android_insetBottom"), 0);
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_cornerRadius, "styleable", "MaterialButton_cornerRadius")) == false) goto L5;
        int r0 = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_cornerRadius, "styleable", "MaterialButton_cornerRadius"), -1);
        this.i = r0;
        a(this.d.a(r0));
        this.r = true;
    L5:
        this.j = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_strokeWidth, "styleable", "MaterialButton_strokeWidth"), 0);
        this.k = r.a(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_backgroundTintMode, "styleable", "MaterialButton_backgroundTintMode"), -1), PorterDuff.Mode.SRC_IN);
        this.l = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, ZeusTransformUtils.mapRes(R.styleable.MaterialButton_backgroundTint, "styleable", "MaterialButton_backgroundTint"));
        this.m = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, ZeusTransformUtils.mapRes(R.styleable.MaterialButton_strokeColor, "styleable", "MaterialButton_strokeColor"));
        this.n = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, ZeusTransformUtils.mapRes(R.styleable.MaterialButton_rippleColor, "styleable", "MaterialButton_rippleColor"));
        this.s = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_checkable, "styleable", "MaterialButton_android_checkable"), false);
        this.u = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_elevation, "styleable", "MaterialButton_elevation"), 0);
        int r1 = ViewCompat.getPaddingStart(this.c);
        int r2 = this.c.getPaddingTop();
        int r3 = ViewCompat.getPaddingEnd(this.c);
        int r4 = this.c.getPaddingBottom();
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_background, "styleable", "MaterialButton_android_background")) == false) goto L8;
        a();
    L9:
        ViewCompat.setPaddingRelative(this.c, r1 + this.e, r2 + this.g, r3 + this.f, r4 + this.h);
        return;
    L8:
        o();
        goto L9
    }

    void a(PorterDuff.Mode r2) {
        if (this.k == r2) goto L10;
        this.k = r2;
        if (i() != null) goto L7;
        return;
    L7:
        if (this.k == null) goto L12;
        DrawableCompat.setTintMode(i(), this.k);
        return;
    L12:
        return;
    }

    void a(l r1) {
        this.d = r1;
        b(r1);
    }

    void a(boolean r1) {
        this.p = r1;
        q();
    }

    void b(int r2) {
        if (this.j == r2) goto L6;
        this.j = r2;
        q();
        return;
    }

    void b(ColorStateList r5) {
        if (this.n == r5) goto L14;
        this.n = r5;
        boolean r0 = f3822a;
        if (r0 == true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(this.c.getBackground(), RippleDrawableCompat.class) == false) goto L17;
        ((RippleDrawableCompat) ZeusTransformUtils.preCheckCast(this.c.getBackground(), RippleDrawableCompat.class, "com.obric.memorydata.plugin")).setTintList(com.google.android.material.ripple.a.b(r5));
        return;
    L17:
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(this.c.getBackground(), RippleDrawable.class) == false) goto L9;
        ((RippleDrawable) ZeusTransformUtils.preCheckCast(this.c.getBackground(), RippleDrawable.class, "com.obric.memorydata.plugin")).setColor(com.google.android.material.ripple.a.b(r5));
        return;
    }

    void b(boolean r1) {
        this.s = r1;
    }

    boolean b() {
        return this.q;
    }

    ColorStateList c() {
        return this.l;
    }

    void c(int r2) {
        if (this.r == true) goto L5;
    L6:
        this.i = r2;
        this.r = true;
        a(this.d.a(r2));
        return;
    L5:
        if (this.i != r2) goto L6;
    }

    void c(ColorStateList r2) {
        if (this.m == r2) goto L6;
        this.m = r2;
        q();
        return;
    }

    PorterDuff.Mode d() {
        return this.k;
    }

    public void d(int r2) {
        b(this.g, r2);
    }

    ColorStateList e() {
        return this.n;
    }

    public void e(int r2) {
        b(r2, this.h);
    }

    ColorStateList f() {
        return this.m;
    }

    int g() {
        return this.j;
    }

    int h() {
        return this.i;
    }

    MaterialShapeDrawable i() {
        return c(false);
    }

    boolean j() {
        return this.s;
    }

    public p k() {
        LayerDrawable r0 = this.t;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() <= 1) goto L14;
        int r1 = this.t.getNumberOfLayers();
        LayerDrawable r4 = this.t;
        if (r1 <= 2) goto L11;
        Drawable r5 = r4.getDrawable(2);
    L10:
        return (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin");
    L11:
        r5 = r4.getDrawable(1);
        goto L10
    L14:
        return null;
    }

    l l() {
        return this.d;
    }

    public int m() {
        return this.h;
    }

    public int n() {
        return this.g;
    }
}
