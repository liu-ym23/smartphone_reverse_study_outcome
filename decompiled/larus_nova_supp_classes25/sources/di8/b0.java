package di8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 {
    public final String a;
    public final CharSequence b;
    public final String c;
    public final Integer d;
    public final String e;
    public final Integer f;
    public final String g;
    public final boolean h;
    public final String i;
    public final String j;
    public final Boolean k;
    public final String l;
    public final Integer m;
    public final String n;
    public final Integer o;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CharSequence r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        if (this.h == false) goto L33;
        int r22 = 1231;
    L34:
        int r23 = (r21 + r22) * 31;
        String r24 = this.i;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        String r27 = this.j;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        Boolean r30 = this.k;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        String r33 = this.l;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        Integer r36 = this.m;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        String r39 = this.n;
        if (r39 != null) goto L57;
        int r40 = 0;
    L58:
        int r41 = (r38 + r40) * 31;
        Integer r42 = this.o;
        if (r42 == null) goto L63;
        r1 = r42.hashCode();
    L63:
        return r41 + r1;
    L57:
        r40 = r39.hashCode();
        goto L58
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = 1237;
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuCenterModel(title=" + this.a + ", styledTitle=" + this.b + ", titleIconUrl=" + this.c + ", titleColor=" + this.d + ", subtitle=" + this.e + ", subtitleColor=" + this.f + ", tagText=" + this.g + ", isHighlightTag=" + this.h + ", badgeText=" + this.i + ", badgeIconUrl=" + this.j + ", showUpgradeTag=" + this.k + ", upgradeTagText=" + this.l + ", upgradeTagIconRes=" + this.m + ", upgradeTagIconUrl=" + this.n + ", titleColorValue=" + this.o + ')';
    }

    public b0(String r3, CharSequence r4, String r5, Integer r6, String r7, String r8, Boolean r9, String r10, String r11, Integer r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r13 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r13 & 64) == 0) goto L15;
        r7 = null;
    L15:
        if ((r13 & 256) == 0) goto L18;
        r8 = null;
    L18:
        if ((r13 & 1024) == 0) goto L21;
        r9 = null;
    L21:
        if ((r13 & 2048) == 0) goto L24;
        r10 = null;
    L24:
        if ((r13 & 8192) == 0) goto L27;
        r11 = null;
    L27:
        if ((r13 & 16384) == 0) goto L29;
        r12 = null;
    L29:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = null;
        this.g = r7;
        this.h = false;
        this.i = r8;
        this.j = null;
        this.k = r9;
        this.l = r10;
        this.m = null;
        this.n = r11;
        this.o = r12;
    }
}
