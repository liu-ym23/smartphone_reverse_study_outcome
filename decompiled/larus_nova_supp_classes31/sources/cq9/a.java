package cq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final double e;
    public final double f;
    public final Integer g;

    public a() {
        this(0, 0, 0, 0, 0.0d, 0.0d, 127);
    }

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
        if (Double.compare(this.e, r9.e) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f, r9.f) == 0) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        long r1 = Double.doubleToLongBits(this.e);
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = Double.doubleToLongBits(this.f);
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Integer r5 = this.g;
        if (r5 != null) goto L5;
        int r6 = 0;
    L7:
        return r4 + r6;
    L5:
        r6 = r5.hashCode();
        goto L7
    }

    public final String toString() {
        return "CreationMultiReferenceLogSummary(imageCount=" + this.a + ", videoCount=" + this.b + ", audioCount=" + this.c + ", unknownCount=" + this.d + ", videoDurationSeconds=" + this.e + ", audioDurationSeconds=" + this.f + ", entityCount=" + this.g + ')';
    }

    public /* synthetic */ a(int r13, int r14, int r15, int r16, double r17, double r19, int r21) {
        if ((r21 & 1) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r21 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r21 & 16) == 0) goto L21;
        double r7 = 0.0d;
    L23:
        if ((r21 & 32) == 0) goto L25;
        double r9 = 0.0d;
    L26:
        this(r3, r4, r5, r6, r7, r9, null);
        return;
    L25:
        r9 = r19;
        goto L26
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public a(int r1, int r2, int r3, int r4, double r5, double r7, Integer r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r9;
    }
}
