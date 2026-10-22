package ck8;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final Pair<Integer, Integer> h;
    public final String i;
    public final int j;
    public final Integer k;

    public g() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
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
        int r16 = 1231;
        if (this.f == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.g == true) goto L30;
        r16 = 1237;
    L30:
        int r19 = (r18 + r16) * 31;
        Pair<Integer, Integer> r20 = this.h;
        if (r20 != null) goto L33;
        int r21 = 0;
    L34:
        int r22 = (r19 + r21) * 31;
        String r23 = this.i;
        if (r23 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (((r22 + r24) * 31) + this.j) * 31;
        Integer r26 = this.k;
        if (r26 == null) goto L43;
        r1 = r26.hashCode();
    L43:
        return r25 + r1;
    L37:
        r24 = r23.hashCode();
        goto L38
    L33:
        r21 = r20.hashCode();
        goto L34
    L25:
        r17 = 1237;
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
        return "ComplexTaskColorCapsuleViewInput(iconUrl=" + this.a + ", name=" + this.b + ", nameColor=" + this.c + ", pillColor=" + this.d + ", summary=" + this.e + ", showShimmer=" + this.f + ", showArrow=" + this.g + ", topAndBottomMarginPair=" + this.h + ", messageId=" + this.i + ", cardPosition=" + this.j + ", backgroundRes=" + this.k + ')';
    }

    public /* synthetic */ g(int r13) {
        this(null, null, null, null, null, false, false, null, null, 0, null);
    }

    public g(String r1, String r2, Integer r3, Integer r4, String r5, boolean r6, boolean r7, Pair<Integer, Integer> r8, String r9, int r10, Integer r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
