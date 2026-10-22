package com.larus.bmhome.instruction;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final int k;
    public final String l;
    public final String m;
    public final Pair<Integer, Integer> n;
    public final String o;

    public a() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        int r11 = 1231;
        if (this.e == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (((r10 + r12) * 31) + this.f) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.h == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        if (this.i == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.j == true) goto L34;
        r11 = 1237;
    L34:
        int r21 = (((r20 + r11) * 31) + this.k) * 31;
        String r22 = this.l;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        String r25 = this.m;
        if (r25 != null) goto L41;
        int r26 = 0;
    L42:
        int r27 = (r24 + r26) * 31;
        Pair<Integer, Integer> r28 = this.n;
        if (r28 != null) goto L45;
        int r29 = 0;
    L46:
        int r30 = (r27 + r29) * 31;
        String r31 = this.o;
        if (r31 == null) goto L51;
        r2 = r31.hashCode();
    L51:
        return r30 + r2;
    L45:
        r29 = r28.hashCode();
        goto L46
    L41:
        r26 = r25.hashCode();
        goto L42
    L37:
        r23 = r22.hashCode();
        goto L38
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionSchemaConfig(instructionType=" + this.a + ", enterMethod=" + this.b + ", actionBarKey=" + this.c + ", actionBarItemId=" + this.d + ", isHalfScreenPage=" + this.e + ", menuInstructionType=" + this.f + ", feedLandingTab=" + this.g + ", openAlbum=" + this.h + ", albumDirectSend=" + this.i + ", albumMultiSelect=" + this.j + ", maxImage=" + this.k + ", prompt=" + this.l + ", instructionDefaultParams=" + this.m + ", selectedPromptPosition=" + this.n + ", conversationId=" + this.o + ')';
    }

    public a(int r16, String r17, String r18, String r19, boolean r20, int r21, String r22, boolean r23, boolean r24, boolean r25, int r26, String r27, Pair r28, String r29, int r30) {
        if ((r30 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r30 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r30 & 8) == 0) goto L13;
        String r5 = null;
    L14:
        int r7 = 0;
        if ((r30 & 16) == 0) goto L17;
        boolean r6 = false;
    L19:
        if ((r30 & 64) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r30 & 128) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r30 & 256) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r30 & 512) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r30 & 1024) != 0) goto L39;
        r7 = r26;
    L39:
        if ((r30 & 2048) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r30 & 8192) == 0) goto L45;
        Pair r13 = null;
    L47:
        if ((r30 & 16384) == 0) goto L49;
        String r1 = null;
    L50:
        this.a = r16;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r21;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r7;
        this.l = r12;
        this.m = null;
        this.n = r13;
        this.o = r1;
        return;
    L49:
        r1 = r29;
        goto L50
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L14
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }
}
