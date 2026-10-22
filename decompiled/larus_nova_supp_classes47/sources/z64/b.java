package z64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final String a;
    public final int b;
    public final boolean c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L25:
        return true;
    L5:
        if ((r8 instanceof b) == false) goto L24;
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == false) goto L24;
        if (this.b != r9.b) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L24;
        if (this.c != r9.c) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L24;
        if (this.d != r9.d) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L24;
    L21:
        r10 = false;
        goto L22
    L16:
        r2 = false;
        goto L17
    L11:
        r1 = false;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        boolean r3 = this.c;
        ?? r4 = r3;
        if (r3 == false) goto L9;
        r4 = 1;
    L9:
        int r5 = (r2 + r4) * 31;
        long r6 = this.d;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "BadgerReport(payload=" + this.a + ", errorCode=" + this.b + ", isFull=" + this.c + ", durationNs=" + this.d + ")";
    }

    public b(String r1, int r2, boolean r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
