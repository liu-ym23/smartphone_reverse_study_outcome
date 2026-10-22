package ns9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final t a;
    public final long b;
    public final long c;
    public final boolean d;
    public final boolean e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
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
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        int r5 = 1231;
        if (this.d == false) goto L5;
        int r6 = 1231;
    L6:
        int r7 = (r4 + r6) * 31;
        if (this.e == true) goto L11;
        r5 = 1237;
    L11:
        return r7 + r5;
    L5:
        r6 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReachHostDisplayEntry(request=" + this.a + ", arrivalOrder=" + this.b + ", firstShownAtUptimeMs=" + this.c + ", isP0=" + this.d + ", isDismissing=" + this.e + ')';
    }

    public j(t r2, long r3, long r5, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
    }
}
