package com.bytedance.android.livesdk.gift.platform.core.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public py.k a;
    public String b;
    public int c;

    public n() {
        this(null, null, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L12;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        py.k r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.c;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftShowInfo(icon=" + this.a + ", giftName=" + this.b + ", scrollCount=" + this.c + ")";
    }

    public n(py.k r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this.a = r3;
        this.b = r4;
        this.c = 0;
    }
}
