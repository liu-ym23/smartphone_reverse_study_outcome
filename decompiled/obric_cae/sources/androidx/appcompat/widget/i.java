package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompoundButton f1164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f1165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1169f;

    public i(CompoundButton r8) {
        this.f1165b = null;
        this.f1166c = null;
        this.f1167d = false;
        this.f1168e = false;
        this.f1164a = r8;
    }

    public final void a() {
        CompoundButton r8 = this.f1164a;
        Drawable r10 = androidx.core.widget.c.a(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f1167d == false) goto L7;
    L8:
        Drawable r11 = r10.mutate();
        if (this.f1167d == false) goto L12;
        b0.a.b.h(r11, this.f1165b);
    L12:
        if (this.f1168e == false) goto L15;
        b0.a.b.i(r11, this.f1166c);
    L15:
        if (r11.isStateful() == false) goto L17;
        r11.setState(r8.getDrawableState());
    L17:
        r8.setButtonDrawable(r11);
        return;
    L7:
        if (this.f1168e == true) goto L8;
    }

    public final void b(AttributeSet r10, int r11) {
        CompoundButton r8 = this.f1164a;
        Context r12 = r8.getContext();
        int[] r13 = c.a.f3227m;
        v0 r14 = v0.m(r12, r10, r13, r11);
        Context r15 = r8.getContext();
        TypedArray r16 = r14.f1275b;
        WeakHashMap<View, j0.h0> r17 = j0.w.f8437a;
        j0.w.m.c(r8, r15, r13, r10, r16, r11, 0);
        boolean r18 = true;
    L24:
        th = move-exception;
        r14.n();
        throw th;
    L4:
        if (r14.l(1) == false) goto L9;
        int r19 = r14.i(1, 0);     // Catch: Throwable -> L24
        if (r19 == 0) goto L9;
        r8.setButtonDrawable(d.a.a(r8.getContext(), r19));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
    L10:
        if (r18 == true) goto L17;
        if (r14.l(0) == false) goto L17;
        int r20 = r14.i(0, 0);     // Catch: Throwable -> L24
        if (r20 == 0) goto L17;
        r8.setButtonDrawable(d.a.a(r8.getContext(), r20));     // Catch: Throwable -> L24
    L17:
        if (r14.l(2) == false) goto L20;
        androidx.core.widget.b.c(r8, r14.b(2));     // Catch: Throwable -> L24
    L20:
        if (r14.l(3) == false) goto L22;
        androidx.core.widget.b.d(r8, d0.b(r14.h(3, -1), null));     // Catch: Throwable -> L24
    L22:
        r14.n();
        return;
    L9:
        r18 = false;
        goto L10
    }
}
