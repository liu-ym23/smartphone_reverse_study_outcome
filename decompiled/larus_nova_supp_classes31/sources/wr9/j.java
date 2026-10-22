package wr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final long a;
    public final l b;
    public final b c;
    public final c d;
    public final a e;
    public final k f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "PowerStateSnapshot(capturedAtElapsedRealtimeMs=" + this.a + ", thermal=" + this.b + ", cpu=" + this.c + ", memory=" + this.d + ", battery=" + this.e + ", staticCpu=" + this.f + ')';
    }

    public j(long r2, l r4, b r5, c r6, a r7, k r8) {
        Intrinsics.checkNotNullParameter(r4, "thermal");
        Intrinsics.checkNotNullParameter(r5, "cpu");
        Intrinsics.checkNotNullParameter(r6, "memory");
        Intrinsics.checkNotNullParameter(r7, "battery");
        Intrinsics.checkNotNullParameter(r8, "staticCpu");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    public static j a(j r8, long r9, l r11, c r12, a r13, k r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        long r1 = r9;
        if ((r15 & 2) == 0) goto L8;
        r11 = r8.b;
    L8:
        l r3 = r11;
        if ((r15 & 4) == 0) goto L11;
        b r10 = r8.c;
    L12:
        b r4 = r10;
        if ((r15 & 8) == 0) goto L15;
        r12 = r8.d;
    L15:
        c r5 = r12;
        if ((r15 & 16) == 0) goto L18;
        r13 = r8.e;
    L18:
        a r6 = r13;
        if ((r15 & 32) == 0) goto L21;
        r14 = r8.f;
    L21:
        k r7 = r14;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r3, "thermal");
        Intrinsics.checkNotNullParameter(r4, "cpu");
        Intrinsics.checkNotNullParameter(r5, "memory");
        Intrinsics.checkNotNullParameter(r6, "battery");
        Intrinsics.checkNotNullParameter(r7, "staticCpu");
        return new j(r1, r3, r4, r5, r6, r7);
    L11:
        r10 = null;
        goto L12
    }
}
