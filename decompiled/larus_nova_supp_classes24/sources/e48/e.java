package e48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
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
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        boolean r1 = this.b;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        long r4 = this.c;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.g;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
    }

    public final String toString() {
        return "AccountSecurityObservationState(uid=" + this.a + ", inObservation=" + this.b + ", remainingSeconds=" + this.c + ", expireAtMs=" + this.d + ", updatedAtMs=" + this.e + ", chatMessageCountThreshold=" + this.f + ", browsedChatMessageCount=" + this.g + ')';
    }

    public e(String r2, boolean r3, long r4, long r6, long r8, long r10, long r12) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r10;
        this.g = r12;
    }
}
