package dh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final boolean a;
    public final int b;
    public final int c;
    public final boolean d;
    public final long e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final String l;
    public final Integer m;
    public final String n;
    public final boolean o;

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
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.b) * 31) + this.c) * 31;
        if (this.d == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        long r5 = this.e;
        int r6 = (((((((r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        if (this.i == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.j == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((r8 + r9) * 31) + this.k.hashCode()) * 31;
        String r11 = this.l;
        int r12 = 0;
        if (r11 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r10 + r13) * 31;
        Integer r15 = this.m;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        String r18 = this.n;
        if (r18 == null) goto L30;
        r12 = r18.hashCode();
    L30:
        int r19 = (r17 + r12) * 31;
        if (this.o == true) goto L35;
        r1 = 1237;
    L35:
        return r19 + r1;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r11.hashCode();
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LongMessageCollapseConfig(enabled=" + this.a + ", collapsedHeight=" + this.b + ", triggerHeight=" + this.c + ", expanded=" + this.d + ", historyGeneration=" + this.e + ", messageKey=" + this.f + ", stateScope=" + this.g + ", direction=" + this.h + ", isSelectionMode=" + this.i + ", initialCollapsed=" + this.j + ", parentMessageKey=" + this.k + ", selectionLookupMessageId=" + this.l + ", selectedSubMessageIndex=" + this.m + ", selectedSubMessageId=" + this.n + ", expandedAfterSubMessageSwitch=" + this.o + ')';
    }

    public static a a(a r21, int r22, int r23, boolean r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        boolean r5 = r21.a;
    L7:
        if ((r25 & 2) == 0) goto L9;
        int r6 = r21.b;
    L11:
        if ((r25 & 4) == 0) goto L13;
        int r7 = r21.c;
    L15:
        if ((r25 & 8) == 0) goto L17;
        boolean r8 = r21.d;
    L19:
        if ((r25 & 16) == 0) goto L21;
        long r9 = r21.e;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r11 = r21.f;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r12 = r21.g;
    L31:
        if ((r25 & 128) == 0) goto L33;
        String r13 = r21.h;
    L35:
        if ((r25 & 256) == 0) goto L37;
        boolean r14 = r21.i;
    L39:
        if ((r25 & 512) == 0) goto L41;
        boolean r15 = r21.j;
    L43:
        if ((r25 & 1024) == 0) goto L45;
        String r2 = r21.k;
    L47:
        if ((r25 & 2048) == 0) goto L49;
        String r17 = r21.l;
    L51:
        if ((r25 & 4096) == 0) goto L53;
        Integer r18 = r21.m;
    L55:
        if ((r25 & 8192) == 0) goto L57;
        String r19 = r21.n;
    L59:
        if ((r25 & 16384) == 0) goto L61;
        boolean r20 = r21.o;
    L62:
        Intrinsics.checkNotNullParameter(r11, "messageKey");
        Intrinsics.checkNotNullParameter(r12, "stateScope");
        Intrinsics.checkNotNullParameter(r13, "direction");
        Intrinsics.checkNotNullParameter(r2, "parentMessageKey");
        return new a(r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r2, r17, r18, r19, r20);
    L61:
        r20 = false;
        goto L62
    L57:
        r19 = null;
        goto L59
    L53:
        r18 = null;
        goto L55
    L49:
        r17 = null;
        goto L51
    L45:
        r2 = null;
        goto L47
    L41:
        r15 = false;
        goto L43
    L37:
        r14 = false;
        goto L39
    L33:
        r13 = null;
        goto L35
    L29:
        r12 = null;
        goto L31
    L25:
        r11 = null;
        goto L27
    L21:
        r9 = 0;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r7 = r23;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r5 = false;
        goto L7
    }

    public a(boolean r8, int r9, int r10, boolean r11, long r12, String r14, String r15, String r16, boolean r17, boolean r18, String r19, String r20, Integer r21, String r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r14, "messageKey");
        Intrinsics.checkNotNullParameter(r15, "stateScope");
        Intrinsics.checkNotNullParameter(r16, "direction");
        Intrinsics.checkNotNullParameter(r19, "parentMessageKey");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r23;
    }
}
