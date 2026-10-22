package com.larus.uaigc.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z {
    public final int a;
    public final Function0<Unit> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L8;
        return false;
    L8:
        z r6 = (z) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "NotifyItem(imageResId=" + this.a + ", clickCallback=" + this.b + ')';
    }

    public z(c r2) {
        Intrinsics.checkNotNullParameter(r2, "clickCallback");
        this.a = 2131240167;
        this.b = r2;
    }
}
