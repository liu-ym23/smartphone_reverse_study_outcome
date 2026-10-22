package com.google.common.hash;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class SipHashFunction extends b implements Serializable {
    static final k SIP_HASH_24 = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9265c;
    private final int d;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final long f9266k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private final long f9267k1;

    static {
        SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    }

    public SipHashFunction(int r5, int r10, long r11, long r12) {
        boolean r13 = false;
        if (r5 <= 0) goto L5;
        boolean r14 = true;
    L6:
        com.google.common.base.b0.d(r5, "The number of SipRound iterations (c=%s) during Compression must be positive.", r14);
        if (r10 <= 0) goto L9;
        r13 = true;
    L9:
        com.google.common.base.b0.d(r10, "The number of SipRound iterations (d=%s) during Finalization must be positive.", r13);
        this.f9265c = r5;
        this.d = r10;
        this.f9266k0 = r11;
        this.f9267k1 = r12;
        return;
    L5:
        r14 = false;
        goto L6
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof SipHashFunction) == false) goto L14;
        SipHashFunction r11 = (SipHashFunction) r10;
        if (this.f9265c == r11.f9265c) goto L7;
        return false;
    L7:
        if (this.d == r11.d) goto L9;
        return false;
    L9:
        if (this.f9266k0 == r11.f9266k0) goto L11;
        return false;
    L11:
        if (this.f9267k1 != r11.f9267k1) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f9265c) ^ this.d)) ^ this.f9266k0) ^ this.f9267k1);
    }

    @Override // com.google.common.hash.k
    public l newHasher() {
        return new a0(this.f9265c, this.d, this.f9266k0, this.f9267k1);
    }

    public String toString() {
        int r5 = this.f9265c;
        int r10 = this.d;
        long r11 = this.f9266k0;
        long r12 = this.f9267k1;
        StringBuilder r13 = new StringBuilder(81);
        r13.append("Hashing.sipHash");
        r13.append(r5);
        r13.append(r10);
        r13.append("(");
        r13.append(r11);
        r13.append(", ");
        r13.append(r12);
        r13.append(")");
        return r13.toString();
    }
}
