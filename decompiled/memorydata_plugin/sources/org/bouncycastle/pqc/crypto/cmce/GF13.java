package org.bouncycastle.pqc.crypto.cmce;

/* JADX INFO: loaded from: classes7.dex */
class GF13 extends GF {
    public GF13(int r1) {
        super(r1);
    }

    private short gf_sq2mul(short r13, short r14) {
        long[] r1 = {2301339409586323456L, 4494803534348288L, 8778913153024L, 17146314752L, 33423360, 122880};
        long r2 = r13;
        long r15 = r14;
        long r4 = (r15 << 18) * (64 & r2);
        long r3 = r2 ^ (r2 << 21);
        long r16 = ((r15 * (r3 & 8589934624L)) << 15) ^ (((((r4 ^ ((268435457 & r3) * r15)) ^ (((536870914 & r3) * r15) << 3)) ^ (((1073741828 & r3) * r15) << 6)) ^ (((2147483656L & r3) * r15) << 9)) ^ (((4294967312L & r3) * r15) << 12));
        int r5 = 0;
    L3:
        if (r5 >= 6) goto L6;
        long r6 = r1[r5] & r16;
        r16 = r16 ^ ((r6 >> 13) ^ (((r6 >> 9) ^ (r6 >> 10)) ^ (r6 >> 12)));
        r5 = r5 + 1;
        goto L3
    L6:
        return (short) (r16 & ((long) this.GFMASK));
    }

    private short gf_sqmul(short r10, short r11) {
        long[] r1 = {137170518016L, 267911168, 516096};
        long r2 = r10;
        long r12 = r11;
        long r4 = (r12 << 6) * (64 & r2);
        long r3 = r2 ^ (r2 << 7);
        long r13 = ((r12 * (r3 & 524320)) << 5) ^ (((((r4 ^ ((16385 & r3) * r12)) ^ (((32770 & r3) * r12) << 1)) ^ (((65540 & r3) * r12) << 2)) ^ (((131080 & r3) * r12) << 3)) ^ (((262160 & r3) * r12) << 4));
        int r5 = 0;
    L3:
        if (r5 >= 3) goto L6;
        long r6 = r1[r5] & r13;
        r13 = r13 ^ ((r6 >> 13) ^ (((r6 >> 9) ^ (r6 >> 10)) ^ (r6 >> 12)));
        r5 = r5 + 1;
        goto L3
    L6:
        return (short) (r13 & ((long) this.GFMASK));
    }

    public short gf_frac(short r2, short r3) {
        short r4 = gf_sqmul(r2, r2);
        short r5 = gf_sq2mul(r4, r4);
        return gf_sqmul(gf_sq2mul(gf_sq2(gf_sq2mul(gf_sq2(r5), r5)), r5), r3);
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    public short gf_inv(short r2) {
        return gf_frac(r2, 1);
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    public short gf_mul(short r10, short r11) {
        long r0 = r10;
        long r12 = r11;
        long r2 = (1 & r12) * r0;
        int r5 = 1;
    L4:
        if (r5 >= this.GFBITS) goto L6;
        r2 = r2 ^ ((((long) (1 << r5)) & r12) * r0);
        r5 = r5 + 1;
        goto L4
    L6:
        long r13 = 33488896 & r2;
        long r14 = ((r13 >> 13) ^ (((r13 >> 9) ^ (r13 >> 10)) ^ (r13 >> 12))) ^ r2;
        long r3 = 57344 & r14;
        return (short) ((r14 ^ ((((r3 >> 10) ^ (r3 >> 9)) ^ (r3 >> 12)) ^ (r3 >> 13))) & ((long) this.GFMASK));
    }

    public short gf_sq2(short r13) {
        long[] r1 = {1229782938247303441L, 217020518514230019L, 4222189076152335L, 1095216660735L};
        long[] r2 = {561850441793536L, 1097364144128L, 2143289344, 4186112};
        long r3 = r13;
        long r4 = (r3 | (r3 << 24)) & r1[3];
        long r5 = (r4 | (r4 << 12)) & r1[2];
        long r6 = (r5 | (r5 << 6)) & r1[1];
        int r14 = 0;
        long r7 = (r6 | (r6 << 3)) & r1[0];
    L3:
        if (r14 >= 4) goto L6;
        long r8 = r2[r14] & r7;
        r7 = r7 ^ ((r8 >> 13) ^ (((r8 >> 9) ^ (r8 >> 10)) ^ (r8 >> 12)));
        r14 = r14 + 1;
        goto L3
    L6:
        return (short) (((long) this.GFMASK) & r7);
    }
}
