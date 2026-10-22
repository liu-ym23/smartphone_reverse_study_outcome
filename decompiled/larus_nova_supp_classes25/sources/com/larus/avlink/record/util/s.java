package com.larus.avlink.record.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s {
    public final int a;
    public final RetryTrigger b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (this.a == r6.a) goto L12;
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
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "RetryContext(attempt=" + this.a + ", trigger=" + this.b + ", delaySec=" + this.c + ')';
    }

    public s(int r2, RetryTrigger r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "trigger");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
