package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.live.base.model.message.a5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final long a;
    public final a5 b;
    public final long c;

    public c() {
        this(0, null, 0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L12;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        a5 r2 = this.b;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        long r4 = this.c;
        return ((r1 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicInfoData(showAfterTimeMs=" + this.a + ", text=" + this.b + ", durationMs=" + this.c + ")";
    }

    public c(long r1, a5 r3, long r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
