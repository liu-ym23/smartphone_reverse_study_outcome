package com.larus.audio.call.aec;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z {
    public final long a;
    public final long b;
    public final byte[] c;
    public final boolean d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof z) == true) goto L8;
        return false;
    L8:
        z r9 = (z) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + Arrays.hashCode(this.c)) * 31;
        if (this.d == false) goto L5;
        int r4 = 1231;
    L7:
        return r2 + r4;
    L5:
        r4 = 1237;
        goto L7
    }

    public final String toString() {
        return "TtsData(startTime=" + this.a + ", endTime=" + this.b + ", data=" + Arrays.toString(this.c) + ", hasModify=" + this.d + ')';
    }

    public z(long r2, long r4, byte[] r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
    }

    public static z a(z r7, long r8, long r10, byte[] r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.b;
    L8:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r12 = r7.c;
    L11:
        byte[] r5 = r12;
        if ((r14 & 8) == 0) goto L14;
        r13 = r7.d;
    L14:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        return new z(r1, r3, r5, r13);
    }
}
