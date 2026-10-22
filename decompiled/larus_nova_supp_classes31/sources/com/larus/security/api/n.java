package com.larus.security.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n {
    public final boolean a;
    public final long b;
    public final String c;
    public final l d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == true) goto L8;
        return false;
    L8:
        n r9 = (n) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.b;
        int r2 = ((((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31;
        l r3 = this.d;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.e;
        if (r7 == null) goto L15;
        r4 = r7.hashCode();
    L15:
        return r6 + r4;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "TtCnpaManualWriteResult(success=" + this.a + ", errorCode=" + this.b + ", errorDesc=" + this.c + ", manifest=" + this.d + ", rawJsonManifest=" + this.e + ')';
    }

    public n(boolean r2, long r3, String r5, l r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "errorDesc");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
