package com.larus.suggest.impl.wcb.policy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 {
    public final long a;
    public final String b;
    public final boolean c;

    public /* synthetic */ c0() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r9 = (c0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "WcbResponseValidation(errorCode=" + this.a + ", errorMessage=" + this.b + ", interceptResponse=" + this.c + ')';
    }

    public c0(long r2, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
