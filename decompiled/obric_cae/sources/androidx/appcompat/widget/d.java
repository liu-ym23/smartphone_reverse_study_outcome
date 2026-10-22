package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f1109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f1110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t0 f1112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t0 f1113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t0 f1114f;

    public d(View r8) {
        this.f1111c = -1;
        this.f1109a = r8;
        this.f1110b = j.a();
    }

    public final void a() {
        View r8 = this.f1109a;
        Drawable r10 = r8.getBackground();
        if (r10 == null) goto L32;
        boolean r11 = false;
        if (this.f1112d == null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L10;
    L25:
        t0 r13 = this.f1113e;
        if (r13 == null) goto L28;
        j.e(r10, r13, r8.getDrawableState());
        return;
    L28:
        t0 r14 = this.f1112d;
        if (r14 == null) goto L34;
        j.e(r10, r14, r8.getDrawableState());
        return;
    L34:
        return;
    L10:
        if (this.f1114f != null) goto L12;
        this.f1114f = new t0();
    L12:
        t0 r15 = this.f1114f;
        r15.f1262a = null;
        r15.f1265d = false;
        r15.f1263b = null;
        r15.f1264c = false;
        WeakHashMap<View, j0.h0> r16 = j0.w.f8437a;
        ColorStateList r17 = j0.w.i.g(r8);
        if (r17 == null) goto L15;
        r15.f1265d = true;
        r15.f1262a = r17;
    L15:
        PorterDuff.Mode r18 = j0.w.i.h(r8);
        if (r18 == null) goto L19;
        r15.f1264c = true;
        r15.f1263b = r18;
    L19:
        if (r15.f1265d == false) goto L21;
    L22:
        j.e(r10, r15, r8.getDrawableState());
        r11 = true;
    L23:
        if (r11 == false) goto L25;
        return;
    L21:
        if (r15.f1264c == false) goto L23;
    L7:
        r12 = false;
        goto L8
    }

    public final ColorStateList b() {
        t0 r8 = this.f1113e;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1262a;
    }

    public final PorterDuff.Mode c() {
        t0 r8 = this.f1113e;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1263b;
    }

    public final void d(AttributeSet r10, int r11) {
        View r8 = this.f1109a;
        Context r12 = r8.getContext();
        int[] r13 = c.a.A;
        v0 r14 = v0.m(r12, r10, r13, r11);
        View r15 = this.f1109a;
        Context r16 = r15.getContext();
        TypedArray r17 = r14.f1275b;
        WeakHashMap<View, j0.h0> r18 = j0.w.f8437a;
        j0.w.m.c(r15, r16, r13, r10, r17, r11, 0);
    L22:
        th = move-exception;
        r14.n();
        throw th;
    L4:
        if (r14.l(0) == false) goto L15;
        this.f1111c = r14.i(0, -1);     // Catch: Throwable -> L22
        j r19 = this.f1110b;     // Catch: Throwable -> L22
        Context r110 = r8.getContext();     // Catch: Throwable -> L22
        int r20 = this.f1111c;     // Catch: Throwable -> L22
        monitor-enter(r19);     // Catch: Throwable -> L22
        ColorStateList r111 = r19.f1193a.h(r110, r20);     // Catch: Throwable -> L11
        monitor-exit(r19);     // Catch: Throwable -> L22
        if (r111 == null) goto L15;
        g(r111);     // Catch: Throwable -> L22
        goto L15
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L15:
        if (r14.l(1) == false) goto L18;
        j0.w.i.q(r8, r14.b(1));     // Catch: Throwable -> L22
    L18:
        if (r14.l(2) == false) goto L20;
        j0.w.i.r(r8, d0.b(r14.h(2, -1), null));     // Catch: Throwable -> L22
    L20:
        r14.n();
    }

    public final void e() {
        this.f1111c = -1;
        g(null);
        a();
    }

    public final void f(int r8) {
        this.f1111c = r8;
        j r10 = this.f1110b;
        if (r10 == null) goto L12;
        Context r11 = this.f1109a.getContext();
        monitor-enter(r10);
        ColorStateList r12 = r10.f1193a.h(r11, r8);     // Catch: Throwable -> L9
        monitor-exit(r10);
    L13:
        g(r12);
        a();
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r12 = null;
        goto L13
    }

    public final void g(ColorStateList r8) {
        if (r8 != null) goto L4;
        this.f1112d = null;
    L8:
        a();
        return;
    L4:
        if (this.f1112d != null) goto L6;
        this.f1112d = new t0();
    L6:
        t0 r10 = this.f1112d;
        r10.f1262a = r8;
        r10.f1265d = true;
        goto L8
    }

    public final void h(ColorStateList r8) {
        if (this.f1113e != null) goto L5;
        this.f1113e = new t0();
    L5:
        t0 r10 = this.f1113e;
        r10.f1262a = r8;
        r10.f1265d = true;
        a();
    }

    public final void i(PorterDuff.Mode r8) {
        if (this.f1113e != null) goto L5;
        this.f1113e = new t0();
    L5:
        t0 r10 = this.f1113e;
        r10.f1263b = r8;
        r10.f1264c = true;
        a();
    }
}
