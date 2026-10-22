package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w4 {
    public final String a;
    public final long b;
    public final int c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w4) == true) goto L8;
        return false;
    L8:
        w4 r9 = (w4) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c;
    }

    public final String toString() {
        return "PrefetchVideoResult(currentProcessStage=" + this.a + ", timeStamp=" + this.b + ", result=" + this.c + ')';
    }

    public w4(String r2, long r3, int r5) {
        Intrinsics.checkNotNullParameter(r2, "currentProcessStage");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
