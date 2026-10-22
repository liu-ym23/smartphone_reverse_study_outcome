package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.l1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o0 {
    public final l1 a;
    public final py.k b;
    public final py.k c;
    public final long d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof o0) == false) goto L14;
        o0 r6 = (o0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        l1 r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        py.k r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        py.k r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        long r9 = this.d;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VMBuffInfo(buffInfo=" + this.a + ", showImg=" + this.b + ", dynamicShowImg=" + this.c + ", originId=" + this.d + ")";
    }

    public final l1 a() {
        return this.a;
    }

    public final py.k b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public final py.k d() {
        return this.b;
    }

    public o0(l1 r2, py.k r3, py.k r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "buffInfo");
        Intrinsics.checkNotNullParameter(r3, "showImg");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
