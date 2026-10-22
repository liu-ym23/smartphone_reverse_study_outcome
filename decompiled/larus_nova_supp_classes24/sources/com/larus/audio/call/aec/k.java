package com.larus.audio.call.aec;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {
    public final long a;
    public final long b;
    public final byte[] c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return ((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + Arrays.hashCode(this.c);
    }

    public final String toString() {
        return "AecRefBlock(startTime=" + this.a + ", endTime=" + this.b + ", data=" + Arrays.toString(this.c) + ')';
    }

    public k(long r2, long r4, byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        this.a = r2;
        this.b = r4;
        this.c = r6;
    }

    public static k a(k r6, long r7, long r9) {
        byte[] r5 = r6.c;
        Intrinsics.checkNotNullParameter(r5, "data");
        return new k(r7, r9, r5);
    }
}
