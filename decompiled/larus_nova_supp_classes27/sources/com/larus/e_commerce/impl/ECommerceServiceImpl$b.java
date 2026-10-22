package com.larus.e_commerce.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ECommerceServiceImpl$b {
    public final cf.o a;
    public final cf.k b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ECommerceServiceImpl$b) == true) goto L8;
        return false;
    L8:
        ECommerceServiceImpl$b r6 = (ECommerceServiceImpl$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "HalfPageListenerHolder(sdkListener=" + this.a + ", handle=" + this.b + ')';
    }

    public ECommerceServiceImpl$b(ECommerceServiceImpl$c r2, cf.k r3) {
        Intrinsics.checkNotNullParameter(r2, "sdkListener");
        Intrinsics.checkNotNullParameter(r3, "handle");
        this.a = r2;
        this.b = r3;
    }
}
