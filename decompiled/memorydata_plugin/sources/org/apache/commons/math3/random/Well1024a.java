package org.apache.commons.math3.random;

/* JADX INFO: loaded from: classes6.dex */
public class Well1024a extends AbstractWell {
    private static final int K = 1024;
    private static final int M1 = 3;
    private static final int M2 = 24;
    private static final int M3 = 10;
    private static final long serialVersionUID = 5680173464174485492L;

    public Well1024a() {
        super(1024, 3, 24, 10);
    }

    public Well1024a(int r7) {
        super(1024, 3, 24, 10, r7);
    }

    public Well1024a(long r8) {
        super(1024, 3, 24, 10, r8);
    }

    public Well1024a(int[] r7) {
        super(1024, 3, 24, 10, r7);
    }

    @Override // org.apache.commons.math3.random.AbstractWell, org.apache.commons.math3.random.BitsStreamGenerator
    public int next(int r8) {
        int r0 = this.iRm1[this.index];
        int r1 = this.v[this.index];
        int r2 = this.v[this.i1[this.index]];
        int r3 = this.v[this.i2[this.index]];
        int r4 = this.v[this.i3[this.index]];
        int r5 = this.v[r0];
        int r6 = r1 ^ (r2 ^ (r2 >>> 8));
        int r7 = ((r3 << 19) ^ r3) ^ ((r4 << 14) ^ r4);
        int r9 = r6 ^ r7;
        int r10 = (r5 << 11) ^ r5;
        int r11 = ((r6 ^ (r6 << 7)) ^ r10) ^ (r7 ^ (r7 << 13));
        this.v[this.index] = r9;
        this.v[r0] = r11;
        this.index = r0;
        return r11 >>> (32 - r8);
    }
}
