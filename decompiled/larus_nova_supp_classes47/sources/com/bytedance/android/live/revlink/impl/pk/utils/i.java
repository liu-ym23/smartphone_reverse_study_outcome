package com.bytedance.android.live.revlink.impl.pk.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public final int a;
    public final int b;
    public final String c;
    public final boolean d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L14;
        i r4 = (i) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = (r0 + r2) * 31;
        boolean r4 = this.d;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return r3 + r5;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ListExtraInfo(followSize=" + this.a + ", originFollowSize=" + this.b + ", requestID=" + this.c + ", isFromRefresh=" + this.d + ")";
    }

    public i(int r1, int r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
