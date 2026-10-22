package com.larus.dora.impl.log;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraLogManager$a {
    public final byte a;
    public final int b;
    public final int c;
    public final long d;
    public final byte e;
    public final byte[] f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DoraLogManager$a) == true) goto L8;
        return false;
    L8:
        DoraLogManager$a r9 = (DoraLogManager$a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
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
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        long r1 = this.d;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e) * 31) + Arrays.hashCode(this.f);
    }

    public final String toString() {
        return "LogInfo(magicId=" + this.a + ", recordId=" + this.b + ", tick=" + this.c + ", utc=" + this.d + ", len=" + this.e + ", pBuf=" + Arrays.toString(this.f) + ')';
    }

    public DoraLogManager$a(byte r2, int r3, int r4, long r5, byte r7, byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "pBuf");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
    }
}
