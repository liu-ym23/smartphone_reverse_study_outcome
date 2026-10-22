package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f4634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f4635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f4636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ColorStateList f4637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final aa.j f4639f;

    public a(ColorStateList r8, ColorStateList r10, ColorStateList r11, int r12, aa.j r13, Rect r14) {
        t2.b.m(r14.left);
        t2.b.m(r14.top);
        t2.b.m(r14.right);
        t2.b.m(r14.bottom);
        this.f4634a = r14;
        this.f4635b = r10;
        this.f4636c = r8;
        this.f4637d = r11;
        this.f4638e = r12;
        this.f4639f = r13;
    }

    public static a a(Context r12, int r13) {
        if (r13 == 0) goto L5;
        boolean r8 = true;
    L6:
        t2.b.l("Cannot create a CalendarItemStyle with a styleResId of 0", r8);
        TypedArray r14 = r12.obtainStyledAttributes(r13, g9.a.f7773n);
        Rect r11 = new Rect(r14.getDimensionPixelOffset(0, 0), r14.getDimensionPixelOffset(2, 0), r14.getDimensionPixelOffset(1, 0), r14.getDimensionPixelOffset(3, 0));
        ColorStateList r10 = x9.c.a(r12, r14, 4);
        ColorStateList r15 = x9.c.a(r12, r14, 9);
        ColorStateList r16 = x9.c.a(r12, r14, 7);
        int r17 = r14.getDimensionPixelSize(8, 0);
        aa.j r18 = new aa.j(aa.j.a(r12, r14.getResourceId(5, 0), r14.getResourceId(6, 0), new aa.a(0)));
        r14.recycle();
        return new a(r10, r15, r16, r17, r18, r11);
    L5:
        r8 = false;
        goto L6
    }

    public final void b(TextView r10) {
        aa.f r8 = new aa.f();
        aa.f r11 = new aa.f();
        aa.j r12 = this.f4639f;
        r8.setShapeAppearanceModel(r12);
        r11.setShapeAppearanceModel(r12);
        r8.k(this.f4636c);
        r8.f139a.f166k = this.f4638e;
        r8.invalidateSelf();
        aa.f.b r13 = r8.f139a;
        ColorStateList r14 = r13.f159d;
        ColorStateList r15 = this.f4637d;
        if (r14 == r15) goto L5;
        r13.f159d = r15;
        r8.onStateChange(r8.getState());
    L5:
        ColorStateList r16 = this.f4635b;
        r10.setTextColor(r16);
        RippleDrawable r17 = new RippleDrawable(r16.withAlpha(30), r8, r11);
        Rect r18 = this.f4634a;
        InsetDrawable r19 = new InsetDrawable(r17, r18.left, r18.top, r18.right, r18.bottom);
        WeakHashMap<View, j0.h0> r20 = j0.w.f8437a;
        j0.w.d.q(r10, r19);
    }
}
