package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import io.reactivex.internal.observers.h;
import q0.i;
import z.e;
import z.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f1674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Priority f1675c;
    public int d;
    public boolean e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z.c f1676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f1678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CachedHashCodeArrayMap f1679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Class f1680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1684p;

    public a() {
        this.f1674b = m.d;
        this.f1675c = Priority.NORMAL;
        this.e = true;
        this.f = -1;
        this.g = -1;
        this.f1676h = p0.a.f21316b;
        this.f1678j = new f();
        this.f1679k = new CachedHashCodeArrayMap();
        this.f1680l = Object.class;
        this.f1683o = true;
    }

    public static boolean f(int r5, int r10) {
        if ((r5 & r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public a a(a r5) {
        if (this.f1682n == true) goto L5;
        int r10 = r5.f1673a;
        if (f(r5.f1673a, 1048576) == false) goto L10;
        this.f1684p = r5.f1684p;
    L10:
        if (f(r5.f1673a, 4) == false) goto L13;
        this.f1674b = r5.f1674b;
    L13:
        if (f(r5.f1673a, 8) == false) goto L16;
        this.f1675c = r5.f1675c;
    L16:
        if (f(r5.f1673a, 16) == false) goto L19;
        this.f1673a &= -33;
    L19:
        if (f(r5.f1673a, 32) == false) goto L22;
        this.f1673a &= -17;
    L22:
        if (f(r5.f1673a, 64) == false) goto L25;
        this.d = 0;
        this.f1673a &= -129;
    L25:
        if (f(r5.f1673a, 128) == false) goto L28;
        this.d = r5.d;
        this.f1673a &= -65;
    L28:
        if (f(r5.f1673a, 256) == false) goto L31;
        this.e = r5.e;
    L31:
        if (f(r5.f1673a, 512) == false) goto L34;
        this.g = r5.g;
        this.f = r5.f;
    L34:
        if (f(r5.f1673a, 1024) == false) goto L37;
        this.f1676h = r5.f1676h;
    L37:
        if (f(r5.f1673a, 4096) == false) goto L40;
        this.f1680l = r5.f1680l;
    L40:
        if (f(r5.f1673a, 8192) == false) goto L43;
        this.f1673a &= -16385;
    L43:
        if (f(r5.f1673a, 16384) == false) goto L46;
        this.f1673a &= -8193;
    L46:
        if (f(r5.f1673a, 131072) == false) goto L49;
        this.f1677i = r5.f1677i;
    L49:
        if (f(r5.f1673a, 2048) == false) goto L51;
        this.f1679k.putAll(r5.f1679k);
        this.f1683o = r5.f1683o;
    L51:
        this.f1673a |= r5.f1673a;
        this.f1678j.f23357b.putAll(r5.f1678j.f23357b);
        k();
        return this;
    L5:
        return b().a(r5);
    }

    public a b() {
        a r5 = (a) super.clone();     // Catch: CloneNotSupportedException -> L4
        f r10 = new f();     // Catch: CloneNotSupportedException -> L4
        r5.f1678j = r10;     // Catch: CloneNotSupportedException -> L4
        f r11 = this.f1678j;     // Catch: CloneNotSupportedException -> L4
        r10.f23357b.putAll(r11.f23357b);     // Catch: CloneNotSupportedException -> L4
        CachedHashCodeArrayMap r12 = new CachedHashCodeArrayMap();     // Catch: CloneNotSupportedException -> L4
        r5.f1679k = r12;     // Catch: CloneNotSupportedException -> L4
        r12.putAll(this.f1679k);     // Catch: CloneNotSupportedException -> L4
        r5.f1681m = false;     // Catch: CloneNotSupportedException -> L4
        r5.f1682n = false;     // Catch: CloneNotSupportedException -> L4
        return r5;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final a c(Class r5) {
        if (this.f1682n == true) goto L5;
        this.f1680l = r5;
        this.f1673a |= 4096;
        k();
        return this;
    L5:
        return b().c(r5);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final a e(m r5) {
        if (this.f1682n == true) goto L5;
        this.f1674b = r5;
        this.f1673a |= 4;
        k();
        return this;
    L5:
        return b().e(r5);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof a) == false) goto L38;
        a r10 = (a) r5;
        r10.getClass();
        if (Float.compare(1.0f, 1.0f) == 0) goto L7;
        return false;
    L7:
        if (i.a(null, null) == true) goto L9;
        return false;
    L9:
        if (this.d == r10.d) goto L11;
        return false;
    L11:
        if (i.a(null, null) == true) goto L13;
        return false;
    L13:
        if (i.a(null, null) == true) goto L15;
        return false;
    L15:
        if (this.e == r10.e) goto L17;
        return false;
    L17:
        if (this.f == r10.f) goto L19;
        return false;
    L19:
        if (this.g == r10.g) goto L21;
        return false;
    L21:
        if (this.f1677i == r10.f1677i) goto L23;
        return false;
    L23:
        if (this.f1674b.equals(r10.f1674b) == true) goto L25;
        return false;
    L25:
        if (this.f1675c == r10.f1675c) goto L27;
        return false;
    L27:
        if (this.f1678j.equals(r10.f1678j) == true) goto L29;
        return false;
    L29:
        if (this.f1679k.equals(r10.f1679k) == true) goto L31;
        return false;
    L31:
        if (this.f1680l.equals(r10.f1680l) == true) goto L33;
        return false;
    L33:
        if (i.a(this.f1676h, r10.f1676h) == true) goto L35;
        return false;
    L35:
        if (i.a(null, null) == false) goto L54;
        return true;
    L54:
        return false;
    L38:
        return false;
    }

    public final a g(j r5, com.bumptech.glide.load.resource.bitmap.d r10) {
        if (this.f1682n == true) goto L5;
        l(j.g, r5);
        return p(r10, false);
    L5:
        return b().g(r5, r10);
    }

    public final a h(int r5, int r10) {
        if (this.f1682n == true) goto L5;
        this.g = r5;
        this.f = r10;
        this.f1673a |= 512;
        k();
        return this;
    L5:
        return b().h(r5, r10);
    }

    public final int hashCode() {
        char[] r5 = i.f21459a;
        int r10 = i.f(i.e(0, i.e(Float.floatToIntBits(1.0f), 17)), null);
        int r11 = i.f(i.e(0, i.f(i.e(this.d, r10), null)), null);
        int r12 = i.e(this.e ? 1 : 0, r11);
        int r13 = i.e(this.f, r12);
        int r14 = i.e(this.g, r13);
        return i.f(i.f(i.f(i.f(i.f(i.f(i.f(i.e(0, i.e(0, i.e(1, i.e(this.f1677i ? 1 : 0, r14)))), this.f1674b), this.f1675c), this.f1678j), this.f1679k), this.f1680l), this.f1676h), null);
    }

    public final a i(int r5) {
        if (this.f1682n == true) goto L5;
        this.d = r5;
        this.f1673a = (this.f1673a | 128) & (-65);
        k();
        return this;
    L5:
        return b().i(r5);
    }

    public final a j(Priority r5) {
        if (this.f1682n == true) goto L5;
        h.h(r5, "Argument must not be null");
        this.f1675c = r5;
        this.f1673a |= 8;
        k();
        return this;
    L5:
        return b().j(r5);
    }

    public final void k() {
        if (this.f1681m == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final a l(e r5, j r10) {
        if (this.f1682n == true) goto L5;
        h.g(r5);
        this.f1678j.f23357b.put(r5, r10);
        k();
        return this;
    L5:
        return b().l(r5, r10);
    }

    public final a m(z.c r5) {
        if (this.f1682n == true) goto L5;
        h.h(r5, "Argument must not be null");
        this.f1676h = r5;
        this.f1673a |= 1024;
        k();
        return this;
    L5:
        return b().m(r5);
    }

    public final a n() {
        if (this.f1682n == true) goto L5;
        this.e = false;
        this.f1673a |= 256;
        k();
        return this;
    L5:
        return b().n();
    }

    public final a o(Class r5, z.i r10, boolean r11) {
        if (this.f1682n == true) goto L5;
        h.g(r10);
        this.f1679k.put(r5, r10);
        int r12 = this.f1673a;
        this.f1673a = 67584 | r12;
        this.f1683o = false;
        if (r11 == false) goto L9;
        this.f1673a = r12 | 198656;
        this.f1677i = true;
    L9:
        k();
        return this;
    L5:
        return b().o(r5, r10, r11);
    }

    public final a p(z.i r5, boolean r10) {
        if (this.f1682n == true) goto L5;
        o r11 = new o(r5, r10);
        o(Bitmap.class, r5, r10);
        o(Drawable.class, r11, r10);
        o(BitmapDrawable.class, r11, r10);
        o(GifDrawable.class, new com.bumptech.glide.load.resource.gif.d(r5), r10);
        k();
        return this;
    L5:
        return b().p(r5, r10);
    }

    public final a q() {
        if (this.f1682n == true) goto L5;
        this.f1684p = true;
        this.f1673a |= 1048576;
        k();
        return this;
    L5:
        return b().q();
    }
}
