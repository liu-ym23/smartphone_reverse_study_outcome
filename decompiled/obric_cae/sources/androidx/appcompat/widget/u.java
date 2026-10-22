package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class u extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SeekBar f1266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f1268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f1269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1271i;

    public u(SeekBar r8) {
        super(r8);
        this.f1268f = null;
        this.f1269g = null;
        this.f1270h = false;
        this.f1271i = false;
        this.f1266d = r8;
    }

    @Override // androidx.appcompat.widget.q
    public final void a(AttributeSet r10, int r11) {
        super.a(r10, r11);
        SeekBar r8 = this.f1266d;
        Context r12 = r8.getContext();
        int[] r13 = c.a.f3221g;
        v0 r14 = v0.m(r12, r10, r13, r11);
        Context r15 = r8.getContext();
        TypedArray r16 = r14.f1275b;
        WeakHashMap<View, j0.h0> r17 = j0.w.f8437a;
        j0.w.m.c(r8, r15, r13, r10, r16, r11, 0);
        Drawable r18 = r14.f(0);
        if (r18 == null) goto L5;
        r8.setThumb(r18);
    L5:
        Drawable r19 = r14.e(1);
        Drawable r20 = this.f1267e;
        if (r20 == null) goto L8;
        r20.setCallback(null);
    L8:
        this.f1267e = r19;
        if (r19 == null) goto L14;
        r19.setCallback(r8);
        b0.a.c.b(r19, j0.w.e.d(r8));
        if (r19.isStateful() == false) goto L13;
        r19.setState(r8.getDrawableState());
    L13:
        c();
    L14:
        r8.invalidate();
        if (r14.l(3) == false) goto L18;
        this.f1269g = d0.b(r14.h(3, -1), this.f1269g);
        this.f1271i = true;
    L18:
        if (r14.l(2) == false) goto L20;
        this.f1268f = r14.b(2);
        this.f1270h = true;
    L20:
        r14.n();
        c();
    }

    public final void c() {
        Drawable r8 = this.f1267e;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.f1270h == false) goto L7;
    L8:
        Drawable r10 = r8.mutate();
        this.f1267e = r10;
        if (this.f1270h == false) goto L12;
        b0.a.b.h(r10, this.f1268f);
    L12:
        if (this.f1271i == false) goto L15;
        b0.a.b.i(this.f1267e, this.f1269g);
    L15:
        if (this.f1267e.isStateful() == false) goto L20;
        this.f1267e.setState(this.f1266d.getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f1271i == true) goto L8;
    }

    public final void d(Canvas r8) {
        if (this.f1267e == null) goto L18;
        SeekBar r10 = this.f1266d;
        int r11 = r10.getMax();
        int r12 = 1;
        if (r11 <= 1) goto L19;
        int r13 = this.f1267e.getIntrinsicWidth();
        int r14 = this.f1267e.getIntrinsicHeight();
        if (r13 < 0) goto L9;
        int r15 = r13 / 2;
    L10:
        if (r14 < 0) goto L12;
        r12 = r14 / 2;
    L12:
        this.f1267e.setBounds(-r15, -r12, r15, r12);
        float r16 = ((r10.getWidth() - r10.getPaddingLeft()) - r10.getPaddingRight()) / r11;
        int r17 = r8.save();
        r8.translate(r10.getPaddingLeft(), r10.getHeight() / 2);
        int r18 = 0;
    L13:
        if (r18 > r11) goto L15;
        this.f1267e.draw(r8);
        r8.translate(r16, 0.0f);
        r18 = r18 + 1;
        goto L13
    L15:
        r8.restoreToCount(r17);
        return;
    L9:
        r15 = 1;
        goto L10
    L19:
        return;
    }
}
