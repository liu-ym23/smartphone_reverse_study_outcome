package com.larus.dora.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraServiceImpl$a {
    public final String a;
    public final int b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraServiceImpl$a) == true) goto L8;
        return false;
    L8:
        DoraServiceImpl$a r6 = (DoraServiceImpl$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "AtomicJsonRpcResult(id=" + this.a + ", code=" + this.b + ", result=" + this.c + ')';
    }

    public DoraServiceImpl$a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r4, "result");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
