package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
class LM_OTS {
    public static int cksm(byte[] r5, int r6, LMOtsParameters r7) {
        int r0 = (1 << r7.getW()) - 1;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= ((r6 * 8) / r7.getW())) goto L7;
        r2 = (r2 + r0) - coef(r5, r1, r7.getW());
        r1 = r1 + 1;
        goto L4
    L7:
        return r2 << r7.getLs();
    }

    public static int coef(byte[] r3, int r4, int r5) {
        int r0 = (r4 * r5) / 8;
        int r6 = ((~r4) & ((8 / r5) - 1)) * r5;
        int r7 = r3[r0] >>> r6;
        return r7 & ((1 << r5) - 1);
    }

    public static LMOtsSignature lm_ots_generate_signature(LMOtsPrivateKey r16, byte[] r17, byte[] r18) {
        LMOtsParameters r1 = r16.getParameter();
        int r2 = r1.getN();
        int r3 = r1.getP();
        int r4 = r1.getW();
        byte[] r5 = new byte[r3 * r2];
        Digest r6 = DigestUtil.getDigest(r1.getDigestOID());
        SeedDerive r7 = r16.getDerivationFunction();
        int r8 = cksm(r17, r2, r1);
        r17[r2] = (byte) ((r8 >>> 8) & 255);
        r17[r2 + 1] = (byte) r8;
        int r9 = r2 + 23;
        byte[] r10 = Composer.compose().bytes(r16.getI()).u32str(r16.getQ()).padUntil(0, r9).build();
        r7.setJ(0);
        int r11 = 0;
    L3:
        if (r11 >= r3) goto L13;
        Pack.shortToBigEndian((short) r11, r10, 20);
        if (r11 >= (r3 - 1)) goto L7;
        boolean r12 = true;
    L8:
        int r13 = 23;
        r7.deriveSeed(r10, r12, 23);
        int r14 = coef(r17, r11, r4);
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L11;
        r10[22] = (byte) r15;
        r6.update(r10, 0, r9);
        r13 = 23;
        r6.doFinal(r10, 23);
        r15 = r15 + 1;
        goto L9
    L11:
        System.arraycopy(r10, r13, r5, r2 * r11, r2);
        r11 = r11 + 1;
        goto L3
    L7:
        r12 = false;
        goto L8
    L13:
        return new LMOtsSignature(r1, r18, r5);
    }

    static byte[] lms_ots_generatePublicKey(LMOtsParameters r10, byte[] r11, int r12, byte[] r13) {
        Digest r0 = DigestUtil.getDigest(r10.getDigestOID());
        byte[] r1 = Composer.compose().bytes(r11).u32str(r12).u16str(-32640).padUntil(0, 22).build();
        r0.update(r1, 0, r1.length);
        Digest r2 = DigestUtil.getDigest(r10.getDigestOID());
        byte[] r4 = Composer.compose().bytes(r11).u32str(r12).padUntil(0, r2.getDigestSize() + 23).build();
        SeedDerive r5 = new SeedDerive(r11, r13, DigestUtil.getDigest(r10.getDigestOID()));
        r5.setQ(r12);
        r5.setJ(0);
        int r14 = r10.getP();
        int r15 = r10.getN();
        int r16 = (1 << r10.getW()) - 1;
        int r7 = 0;
    L3:
        if (r7 >= r14) goto L12;
        if (r7 >= (r14 - 1)) goto L7;
        boolean r8 = true;
    L8:
        r5.deriveSeed(r4, r8, 23);
        Pack.shortToBigEndian((short) r7, r4, 20);
        int r9 = 0;
    L9:
        if (r9 >= r16) goto L11;
        r4[22] = (byte) r9;
        r2.update(r4, 0, r4.length);
        r2.doFinal(r4, 23);
        r9 = r9 + 1;
        goto L9
    L11:
        r0.update(r4, 23, r15);
        r7 = r7 + 1;
        goto L3
    L7:
        r8 = false;
        goto L8
    L12:
        byte[] r17 = new byte[r0.getDigestSize()];
        r0.doFinal(r17, 0);
        return r17;
    }
}
