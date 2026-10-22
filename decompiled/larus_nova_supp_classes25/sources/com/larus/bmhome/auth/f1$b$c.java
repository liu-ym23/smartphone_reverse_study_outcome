package com.larus.bmhome.auth;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f1$b$c extends f1.b {
    public final long a;
    public final long b;
    public final String c;
    public final Set<LaunchBiz> d;
    public final boolean e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f1$b$c) == true) goto L8;
        return false;
    L8:
        f1$b$c r9 = (f1$b$c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r4 = 1231;
    L7:
        return r2 + r4;
    L5:
        r4 = 1237;
        goto L7
    }

    public final String toString() {
        return "Success(batchId=" + this.a + ", accountGeneration=" + this.b + ", source=" + this.c + ", expectedBiz=" + this.d + ", publishCompat=" + this.e + ')';
    }

    public final long a() {
        return this.b;
    }

    public f1$b$c(long r2, long r4, String r6, Set<? extends LaunchBiz> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "expectedBiz");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
    }
}
