package com.bytedance.badger.y;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final String a;
    public final Object b;
    public final long c;

    public b(String r1, Object r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L17:
        return true;
    L5:
        if ((r8 instanceof b) == false) goto L16;
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == false) goto L16;
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L16;
        if (this.c != r9.c) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
    L13:
        r10 = false;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.c;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "KeyEntry(key=" + this.a + ", value=" + this.b + ", createTimeMs=" + this.c + ")";
    }
}
