package com.larus.avlink.gallery.power.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        if (this.d == false) goto L5;
        int r6 = 1231;
    L7:
        return ((r5 + r6) * 31) + this.e.hashCode();
    L5:
        r6 = 1237;
        goto L7
    }

    public final String toString() {
        return "AlbumVideoThermalMetrics(durationMs=" + this.a + ", moderateDurationMs=" + this.b + ", severeDurationMs=" + this.c + ", thermalValid=" + this.d + ", result=" + this.e + ')';
    }

    public a(long r2, long r4, long r6, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "result");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r9;
    }
}
