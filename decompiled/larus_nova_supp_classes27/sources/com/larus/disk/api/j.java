package com.larus.disk.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j {
    public final ManualCacheCleanStatus a;
    public final long b;
    public final long c;
    public final String d;
    public final ManualCacheCleanError e;
    public final String f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        return ((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "ManualCacheCleanResult(status=" + this.a + ", beforeBytes=" + this.b + ", remainingBytes=" + this.c + ", operationId=" + this.d + ", error=" + this.e + ", failureOwner=" + this.f + ')';
    }

    public j(ManualCacheCleanStatus r2, long r3, long r5, String r7, ManualCacheCleanError r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r7, "operationId");
        Intrinsics.checkNotNullParameter(r8, "error");
        Intrinsics.checkNotNullParameter(r9, "failureOwner");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }
}
