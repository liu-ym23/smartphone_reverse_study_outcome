package com.bumptech.glide.load.engine;

import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class x implements z.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1586c;
    public final int d;
    public final Class e;
    public final Class f;
    public final z.c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CachedHashCodeArrayMap f1587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z.f f1588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1589j;

    public x(Object r5, z.c r10, int r11, int r12, CachedHashCodeArrayMap r13, Class r14, Class r15, z.f r16) {
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1585b = r5;
        io.reactivex.internal.observers.h.h(r10, "Signature must not be null");
        this.g = r10;
        this.f1586c = r11;
        this.d = r12;
        io.reactivex.internal.observers.h.h(r13, "Argument must not be null");
        this.f1587h = r13;
        io.reactivex.internal.observers.h.h(r14, "Resource class must not be null");
        this.e = r14;
        io.reactivex.internal.observers.h.h(r15, "Transcode class must not be null");
        this.f = r15;
        io.reactivex.internal.observers.h.h(r16, "Argument must not be null");
        this.f1588i = r16;
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        throw new UnsupportedOperationException();
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof x) == false) goto L22;
        x r10 = (x) r5;
        Object r11 = r10.f1585b;
        if (this.f1585b.equals(r11) == true) goto L7;
        return false;
    L7:
        if (this.g.equals(r10.g) == true) goto L9;
        return false;
    L9:
        if (this.d == r10.d) goto L11;
        return false;
    L11:
        if (this.f1586c == r10.f1586c) goto L13;
        return false;
    L13:
        if (this.f1587h.equals(r10.f1587h) == true) goto L15;
        return false;
    L15:
        if (this.e.equals(r10.e) == true) goto L17;
        return false;
    L17:
        if (this.f.equals(r10.f) == true) goto L19;
        return false;
    L19:
        if (this.f1588i.equals(r10.f1588i) == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        return false;
    }

    @Override // z.c
    public final int hashCode() {
        if (this.f1589j != 0) goto L6;
        int r5 = this.f1585b.hashCode();
        this.f1589j = r5;
        int r10 = this.g.hashCode();
        int r11 = ((((r10 + (r5 * 31)) * 31) + this.f1586c) * 31) + this.d;
        this.f1589j = r11;
        int r12 = this.f1587h.hashCode();
        int r13 = r12 + (r11 * 31);
        this.f1589j = r13;
        int r14 = this.e.hashCode();
        int r15 = r14 + (r13 * 31);
        this.f1589j = r15;
        int r16 = this.f.hashCode();
        int r17 = r16 + (r15 * 31);
        this.f1589j = r17;
        int r18 = this.f1588i.f23357b.hashCode();
        this.f1589j = r18 + (r17 * 31);
    L6:
        return this.f1589j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f1585b + ", width=" + this.f1586c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.f1589j + ", transformations=" + this.f1587h + ", options=" + this.f1588i + '}';
    }
}
