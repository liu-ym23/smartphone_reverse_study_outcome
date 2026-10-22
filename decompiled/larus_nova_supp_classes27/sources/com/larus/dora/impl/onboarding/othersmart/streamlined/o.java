package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o {
    public final long a;
    public final n0 b;
    public final boolean c;
    public final o0 d;

    /* JADX WARN: Multi-variable type inference failed */
    public o() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 15);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r2 = 1231;
    L7:
        return ((r1 + r2) * 31) + this.d.hashCode();
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraHStreamlinedInterruptUiState(roundToken=" + this.a + ", query=" + this.b + ", shouldPlayEntryAnimation=" + this.c + ", reply=" + this.d + ')';
    }

    public /* synthetic */ o(n0.a r7, o0.b r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        r7 = n0.a.a;
    L5:
        n0.a r3 = r7;
        if ((r9 & 8) == 0) goto L8;
        r8 = o0.b.a;
    L8:
        this(0, r3, false, r8);
    }

    public o(long r2, n0 r4, boolean r5, o0 r6) {
        Intrinsics.checkNotNullParameter(r4, "query");
        Intrinsics.checkNotNullParameter(r6, "reply");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }

    public static o a(o r6, long r7, n0 r9, o0 r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        long r1 = r7;
        if ((r11 & 2) == 0) goto L8;
        r9 = r6.b;
    L8:
        n0 r3 = r9;
        if ((r11 & 4) == 0) goto L11;
        boolean r4 = r6.c;
    L13:
        if ((r11 & 8) == 0) goto L15;
        r10 = r6.d;
    L15:
        o0 r5 = r10;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "query");
        Intrinsics.checkNotNullParameter(r5, "reply");
        return new o(r1, r3, r4, r5);
    L11:
        r4 = false;
        goto L13
    }
}
