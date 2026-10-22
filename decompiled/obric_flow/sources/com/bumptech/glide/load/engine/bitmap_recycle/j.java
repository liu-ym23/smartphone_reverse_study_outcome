package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap.Config f1466c;

    public j(e r5) {
        this.f1464a = r5;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.h
    public final void a() {
        this.f1464a.t(this);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof j) == false) goto L10;
        j r10 = (j) r5;
        if (this.f1465b == r10.f1465b) goto L7;
        return false;
    L7:
        if (q0.i.a(this.f1466c, r10.f1466c) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = this.f1465b * 31;
        Bitmap.Config r10 = this.f1466c;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return r5 + r11;
    L5:
        r11 = 0;
        goto L7
    }

    public final String toString() {
        return k.c(this.f1465b, this.f1466c);
    }
}
