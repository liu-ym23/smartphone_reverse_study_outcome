package com.larus.disk.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final Long d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Long r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DiskRegisteredCacheEntry(business=" + this.a + ", bizTag=" + this.b + ", path=" + this.c + ", sizeBytes=" + this.d + ')';
    }

    public h(String r2, String r3, String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r2, "business");
        Intrinsics.checkNotNullParameter(r3, "bizTag");
        Intrinsics.checkNotNullParameter(r4, "path");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
