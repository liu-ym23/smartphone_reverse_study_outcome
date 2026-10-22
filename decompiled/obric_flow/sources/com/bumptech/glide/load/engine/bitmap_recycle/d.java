package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f1452c;

    public d(e r5) {
        this.f1450a = r5;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.h
    public final void a() {
        this.f1450a.t(this);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof d) == false) goto L10;
        d r10 = (d) r5;
        if (this.f1451b == r10.f1451b) goto L7;
        return false;
    L7:
        if (this.f1452c != r10.f1452c) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = this.f1451b * 31;
        Class r10 = this.f1452c;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return r5 + r11;
    L5:
        r11 = 0;
        goto L7
    }

    public final String toString() {
        return "Key{size=" + this.f1451b + "array=" + this.f1452c + '}';
    }
}
