package oo1;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final byte[] a;
    public final int b;
    public final long c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof b) == false) goto L12;
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        byte[] r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = Arrays.hashCode(r0);
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        long r3 = this.c;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "AudioDataFrame(inout=" + Arrays.toString(this.a) + ", samples=" + this.b + ", timestamp=" + this.c + ")";
    }

    public b(byte[] r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
