package com.google.android.material.button;

import aa.f;
import aa.j;
import aa.n;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;
import t2.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f4481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f4482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f4489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f4490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f4491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f4492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f4493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4494n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4495o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4496p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4497q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4498r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RippleDrawable f4499s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4500t;

    public a(MaterialButton r8, j r10) {
        this.f4494n = false;
        this.f4495o = false;
        this.f4496p = false;
        this.f4498r = true;
        this.f4481a = r8;
        this.f4482b = r10;
    }

    public final n a() {
        RippleDrawable r8 = this.f4499s;
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r8.getNumberOfLayers() <= 1) goto L14;
        int r10 = this.f4499s.getNumberOfLayers();
        RippleDrawable r11 = this.f4499s;
        if (r10 <= 2) goto L9;
        Object r12 = r11.getDrawable(2);
    L11:
        return (n) r12;
    L9:
        r12 = r11.getDrawable(1);
        goto L11
    L14:
        return null;
    }

    public final f b(boolean r8) {
        RippleDrawable r10 = this.f4499s;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getNumberOfLayers() > 0) goto L7;
        return null;
    L7:
        return (f) ((LayerDrawable) ((InsetDrawable) this.f4499s.getDrawable(0)).getDrawable()).getDrawable(!r8 ? 1 : 0);
    }

    public final void c(j r8) {
        this.f4482b = r8;
        if (b(false) == null) goto L6;
        b(false).setShapeAppearanceModel(r8);
    L6:
        if (b(true) == null) goto L9;
        b(true).setShapeAppearanceModel(r8);
    L9:
        if (a() == null) goto L12;
        a().setShapeAppearanceModel(r8);
        return;
    }

    public final void d(int r10, int r11) {
        WeakHashMap<View, h0> r8 = w.f8437a;
        MaterialButton r12 = this.f4481a;
        int r13 = w.e.f(r12);
        int r14 = r12.getPaddingTop();
        int r15 = w.e.e(r12);
        int r16 = r12.getPaddingBottom();
        int r17 = this.f4485e;
        int r18 = this.f4486f;
        this.f4486f = r11;
        this.f4485e = r10;
        if (this.f4495o == true) goto L5;
        e();
    L5:
        w.e.k(r12, r13, (r14 + r10) - r17, r15, (r16 + r11) - r18);
    }

    public final void e() {
        f r8 = new f(this.f4482b);
        MaterialButton r10 = this.f4481a;
        r8.i(r10.getContext());
        b0.a.b.h(r8, this.f4490j);
        PorterDuff.Mode r11 = this.f4489i;
        if (r11 == null) goto L5;
        b0.a.b.i(r8, r11);
    L5:
        float r12 = this.f4488h;
        ColorStateList r13 = this.f4491k;
        r8.f139a.f166k = r12;
        r8.invalidateSelf();
        f.b r14 = r8.f139a;
        if (r14.f159d == r13) goto L8;
        r14.f159d = r13;
        r8.onStateChange(r8.getState());
    L8:
        f r15 = new f(this.f4482b);
        r15.setTint(0);
        float r16 = this.f4488h;
        if (this.f4494n == false) goto L11;
        int r17 = b.z(r10, R.attr.colorSurface);
    L12:
        r15.f139a.f166k = r16;
        r15.invalidateSelf();
        ColorStateList r18 = ColorStateList.valueOf(r17);
        f.b r19 = r15.f139a;
        if (r19.f159d == r18) goto L15;
        r19.f159d = r18;
        r15.onStateChange(r15.getState());
    L15:
        f r20 = new f(this.f4482b);
        this.f4493m = r20;
        b0.a.b.g(r20, -1);
        ColorStateList r21 = this.f4492l;
        if (r21 != null) goto L19;
        r21 = ColorStateList.valueOf(0);
    L19:
        RippleDrawable r22 = new RippleDrawable(r21, new InsetDrawable(new LayerDrawable(new Drawable[]{r15, r8}), this.f4483c, this.f4485e, this.f4484d, this.f4486f), this.f4493m);
        this.f4499s = r22;
        r10.setInternalBackground(r22);
        f r23 = b(false);
        if (r23 == null) goto L23;
        r23.j(this.f4500t);
        r23.setState(r10.getDrawableState());
        return;
    L23:
        return;
    L11:
        r17 = 0;
        goto L12
    }

    public final void f() {
        int r8 = 0;
        f r10 = b(false);
        f r11 = b(true);
        if (r10 == null) goto L15;
        float r12 = this.f4488h;
        ColorStateList r13 = this.f4491k;
        r10.f139a.f166k = r12;
        r10.invalidateSelf();
        f.b r14 = r10.f139a;
        if (r14.f159d == r13) goto L7;
        r14.f159d = r13;
        r10.onStateChange(r10.getState());
    L7:
        if (r11 == null) goto L16;
        float r15 = this.f4488h;
        if (this.f4494n == false) goto L11;
        r8 = b.z(this.f4481a, R.attr.colorSurface);
    L11:
        r11.f139a.f166k = r15;
        r11.invalidateSelf();
        ColorStateList r16 = ColorStateList.valueOf(r8);
        f.b r17 = r11.f139a;
        if (r17.f159d == r16) goto L17;
        r17.f159d = r16;
        r11.onStateChange(r11.getState());
        return;
    L17:
        return;
    L16:
        return;
    }
}
