package com.larus.suggest.impl.wcb.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public final e a;
    public final WcbTransportSource b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "WcbTransportEmission(result=" + this.a + ", source=" + this.b + ", refreshesPreviousTarget=" + this.c + ')';
    }

    public g(e r2, WcbTransportSource r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
