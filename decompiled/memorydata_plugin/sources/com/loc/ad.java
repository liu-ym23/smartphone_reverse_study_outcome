package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ad f5274a;

    ad() {
    }

    ad(ad r1) {
        this.f5274a = r1;
    }

    public abstract byte[] a(byte[] r1);

    public final byte[] b(byte[] r2) {
        ad r0 = this.f5274a;
        if (r0 == null) goto L6;
        r2 = r0.b(r2);
    L6:
        return a(r2);
    }
}
