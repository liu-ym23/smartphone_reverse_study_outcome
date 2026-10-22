package org.bouncycastle.pqc.crypto.cmce;

/* JADX INFO: loaded from: classes7.dex */
class GF12 extends GF {
    public GF12(int r1) {
        super(r1);
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    public short gf_inv(short r4) {
        short r0 = gf_mul(gf_sq(r4), r4);
        short r1 = gf_mul(gf_sq(gf_sq(r0)), r0);
        return gf_sq(gf_mul(gf_sq(gf_mul(gf_sq(gf_sq(gf_mul(gf_sq(gf_sq(gf_sq(gf_sq(r1)))), r1))), r0)), r4));
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    public short gf_mul(short r5, short r6) {
        int r0 = (r6 & 1) * r5;
        int r2 = 1;
    L4:
        if (r2 >= this.GFBITS) goto L6;
        r0 = r0 ^ (((1 << r2) & r6) * r5);
        r2 = r2 + 1;
        goto L4
    L6:
        int r7 = 8372224 & r0;
        int r8 = (r7 >> 12) ^ ((r7 >> 9) ^ r0);
        int r9 = r8 & 12288;
        return (short) (((1 << this.GFBITS) - 1) & ((r8 ^ (r9 >> 9)) ^ (r9 >> 12)));
    }

    public short gf_sq(short r4) {
        int[] r0 = {1431655765, 858993459, 252645135, 16711935};
        int r5 = (r4 | (r4 << 8)) & r0[3];
        int r6 = (r5 | (r5 << 4)) & r0[2];
        int r7 = (r6 | (r6 << 2)) & r0[1];
        int r8 = (r7 | (r7 << 1)) & r0[0];
        int r1 = 8372224 & r8;
        int r9 = (r8 ^ (r1 >> 9)) ^ (r1 >> 12);
        int r2 = r9 & 12288;
        int r3 = (1 << this.GFBITS) - 1;
        return (short) (r3 & ((r9 ^ (r2 >> 9)) ^ (r2 >> 12)));
    }
}
