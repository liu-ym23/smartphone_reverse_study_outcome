package com.bumptech.glide.load.engine;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class d implements z.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z.c f1479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z.c f1480c;

    public d(z.c r5, z.c r10) {
        this.f1479b = r5;
        this.f1480c = r10;
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        this.f1479b.b(r5);
        this.f1480c.b(r5);
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof d) == false) goto L10;
        d r10 = (d) r5;
        z.c r11 = r10.f1479b;
        if (this.f1479b.equals(r11) == true) goto L7;
        return false;
    L7:
        if (this.f1480c.equals(r10.f1480c) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // z.c
    public final int hashCode() {
        int r5 = this.f1479b.hashCode() * 31;
        return this.f1480c.hashCode() + r5;
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f1479b + ", signature=" + this.f1480c + '}';
    }
}
