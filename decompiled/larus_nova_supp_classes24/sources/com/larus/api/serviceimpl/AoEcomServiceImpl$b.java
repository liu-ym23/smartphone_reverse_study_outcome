package com.larus.api.serviceimpl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n48.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AoEcomServiceImpl$b {
    public final String a;
    public final Function0<Unit> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AoEcomServiceImpl$b) == true) goto L8;
        return false;
    L8:
        AoEcomServiceImpl$b r6 = (AoEcomServiceImpl$b) r5;
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
        return "HalfPageListenerRegistration(schema=" + this.a + ", close=" + this.b + ')';
    }

    public AoEcomServiceImpl$b(String r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "close");
        this.a = r2;
        this.b = r3;
    }
}
