package jf;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final transient byte[][] f8879p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final transient int[] f8880q;

    public u(d r8, int r10) {
        super(null);
        y.a(r8.f8830b, 0, r10);
        s r11 = r8.f8829a;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r10) goto L9;
        int r15 = r11.f8872c;
        int r16 = r11.f8871b;
        if (r15 == r16) goto L8;
        r13 = r13 + (r15 - r16);
        r14 = r14 + 1;
        r11 = r11.f8875f;
        goto L3
    L8:
        throw new AssertionError("s.limit == s.pos");
    L9:
        this.f8879p = new byte[r14][];
        this.f8880q = new int[r14 * 2];
        s r17 = r8.f8829a;
        int r18 = 0;
    L10:
        if (r12 >= r10) goto L16;
        byte[][] r19 = this.f8879p;
        r19[r18] = r17.f8870a;
        int r20 = r17.f8872c;
        int r21 = r17.f8871b;
        int r22 = (r20 - r21) + r12;
        if (r22 <= r10) goto L14;
        r12 = r10;
    L15:
        int[] r23 = this.f8880q;
        r23[r18] = r12;
        r23[r19.length + r18] = r21;
        r17.f8873d = true;
        r18 = r18 + 1;
        r17 = r17.f8875f;
        goto L10
    L14:
        r12 = r22;
        goto L15
    }

    @Override // jf.g
    public final String a() {
        return s().a();
    }

    @Override // jf.g
    public final byte e(int r10) {
        byte[][] r8 = this.f8879p;
        int r11 = r8.length - 1;
        int[] r12 = this.f8880q;
        y.a(r12[r11], r10, 1);
        int r13 = r(r10);
        if (r13 != 0) goto L5;
        int r14 = 0;
    L7:
        return r8[r13][(r10 - r14) + r12[r8.length + r13]];
    L5:
        r14 = r12[r13 - 1];
        goto L7
    }

    @Override // jf.g
    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == false) goto L12;
        g r10 = (g) r8;
        if (r10.l() != l()) goto L12;
        if (i(r10, l()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // jf.g
    public final String f() {
        return s().f();
    }

    @Override // jf.g
    public final boolean h(int r10, byte[] r11, int r12, int r13) {
        if (r10 >= 0) goto L5;
    L27:
        return false;
    L5:
        if (r10 > (l() - r13)) goto L27;
        if (r12 < 0) goto L27;
        if (r12 > (r11.length - r13)) goto L27;
        int r8 = r(r10);
    L11:
        boolean r14 = true;
        if (r13 <= 0) goto L26;
        int[] r15 = this.f8880q;
        if (r8 != 0) goto L16;
        int r16 = 0;
    L17:
        int r17 = Math.min(r13, ((r15[r8] - r16) + r16) - r10);
        byte[][] r18 = this.f8879p;
        int r19 = (r10 - r16) + r15[r18.length + r8];
        byte[] r20 = r18[r8];
        Charset r21 = y.f8885a;
        int r22 = 0;
    L18:
        if (r22 >= r17) goto L23;
        if (r20[r22 + r19] != r11[r22 + r12]) goto L21;
        r22 = r22 + 1;
        goto L18
    L21:
        r14 = false;
    L23:
        if (r14 == false) goto L24;
        r10 = r10 + r17;
        r12 = r12 + r17;
        r13 = r13 - r17;
        r8 = r8 + 1;
        goto L11
    L24:
        return false;
    L16:
        r16 = r15[r8 - 1];
        goto L17
    L26:
        return true;
    }

    @Override // jf.g
    public final int hashCode() {
        int r8 = this.f8843b;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        byte[][] r10 = this.f8879p;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 1;
        int r14 = 0;
    L6:
        if (r12 >= r11) goto L11;
        byte[] r15 = r10[r12];
        int[] r16 = this.f8880q;
        int r17 = r16[r11 + r12];
        int r18 = r16[r12];
        int r19 = (r18 - r14) + r17;
    L8:
        if (r17 >= r19) goto L10;
        r13 = (r13 * 31) + r15[r17];
        r17 = r17 + 1;
        goto L8
    L10:
        r12 = r12 + 1;
        r14 = r18;
        goto L6
    L11:
        this.f8843b = r13;
        return r13;
    }

    @Override // jf.g
    public final boolean i(g r10, int r11) {
        if ((l() - r11) >= 0) goto L5;
        return false;
    L5:
        int r8 = r(0);
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r11 <= 0) goto L15;
        int[] r14 = this.f8880q;
        if (r8 != 0) goto L10;
        int r15 = 0;
    L11:
        int r16 = Math.min(r11, ((r14[r8] - r15) + r15) - r12);
        byte[][] r17 = this.f8879p;
        if (r10.h(r13, r17[r8], (r12 - r15) + r14[r17.length + r8], r16) == false) goto L13;
        r12 = r12 + r16;
        r13 = r13 + r16;
        r11 = r11 - r16;
        r8 = r8 + 1;
        goto L6
    L13:
        return false;
    L10:
        r15 = r14[r8 - 1];
        goto L11
    L15:
        return true;
    }

    @Override // jf.g
    public final g j() {
        throw null;
    }

    @Override // jf.g
    public final g k() {
        throw null;
    }

    @Override // jf.g
    public final int l() {
        return this.f8880q[this.f8879p.length - 1];
    }

    @Override // jf.g
    public final g m() {
        return s().m();
    }

    @Override // jf.g
    public final g n() {
        return s().n();
    }

    @Override // jf.g
    public final byte[] o() {
        byte[][] r8 = this.f8879p;
        int r10 = r8.length - 1;
        int[] r11 = this.f8880q;
        byte[] r12 = new byte[r11[r10]];
        int r13 = r8.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        int r16 = r11[r13 + r14];
        int r17 = r11[r14];
        System.arraycopy(r8[r14], r16, r12, r15, r17 - r15);
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L5:
        return r12;
    }

    @Override // jf.g
    public final String p() {
        return s().p();
    }

    @Override // jf.g
    public final void q(d r13) {
        byte[][] r8 = this.f8879p;
        int r10 = r8.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L9;
        int[] r14 = this.f8880q;
        int r15 = r14[r10 + r11];
        int r16 = r14[r11];
        s r17 = new s(r8[r11], r15, (r15 + r16) - r12, true, false);
        s r18 = r13.f8829a;
        if (r18 != null) goto L7;
        r17.f8876g = r17;
        r17.f8875f = r17;
        r13.f8829a = r17;
    L8:
        r11 = r11 + 1;
        r12 = r16;
        goto L3
    L7:
        r18.f8876g.b(r17);
        goto L8
    L9:
        r13.f8830b += (long) r12;
    }

    public final int r(int r8) {
        int[] r10 = this.f8880q;
        int r11 = Arrays.binarySearch(r10, 0, this.f8879p.length, r8 + 1);
        if (r11 < 0) goto L6;
        return r11;
    L6:
        return ~r11;
    }

    public final g s() {
        return new g(o());
    }

    @Override // jf.g
    public final String toString() {
        return s().toString();
    }
}
