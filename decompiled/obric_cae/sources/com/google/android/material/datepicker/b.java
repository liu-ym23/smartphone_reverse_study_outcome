package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f4645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f4646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f4647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f4648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f4649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f4650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f4651h;

    public b(Context r8) {
        TypedArray r10 = r8.obtainStyledAttributes(x9.b.c(r8, R.attr.materialCalendarStyle, i.class.getCanonicalName()).data, g9.a.f7772m);
        this.f4644a = a.a(r8, r10.getResourceId(4, 0));
        this.f4650g = a.a(r8, r10.getResourceId(2, 0));
        this.f4645b = a.a(r8, r10.getResourceId(3, 0));
        this.f4646c = a.a(r8, r10.getResourceId(5, 0));
        ColorStateList r11 = x9.c.a(r8, r10, 7);
        this.f4647d = a.a(r8, r10.getResourceId(9, 0));
        this.f4648e = a.a(r8, r10.getResourceId(8, 0));
        this.f4649f = a.a(r8, r10.getResourceId(10, 0));
        Paint r12 = new Paint();
        this.f4651h = r12;
        r12.setColor(r11.getDefaultColor());
        r10.recycle();
    }
}
