package org.bouncycastle.crypto.digests;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SM3Digest extends GeneralDigest {
    private static final int[] T = null;
    private int[] V;
    private int[] W;
    private int[] inwords;
    private int xOff;

    static {
        T = new int[64];
        int r1 = 0;
    L3:
        int r2 = 16;
        if (r1 >= 16) goto L6;
        int r3 = 2043430169 >>> (32 - r1);
        T[r1] = r3 | (2043430169 << r1);
        r1 = r1 + 1;
    L6:
        if (r2 >= 64) goto L8;
        int r4 = r2 % 32;
        int r5 = 2055708042 << r4;
        T[r2] = (2055708042 >>> (32 - r4)) | r5;
        r2 = r2 + 1;
        goto L6
    }

    public SM3Digest() {
        this(CryptoServicePurpose.ANY);
    }

    public SM3Digest(CryptoServicePurpose r1) {
        super(r1);
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset();
    }

    public SM3Digest(SM3Digest r2) {
        super(r2);
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        copyIn(r2);
    }

    private int FF0(int r1, int r2, int r3) {
        return (r1 ^ r2) ^ r3;
    }

    private int FF1(int r1, int r2, int r3) {
        return ((r1 & r2) | (r1 & r3)) | (r2 & r3);
    }

    private int GG0(int r1, int r2, int r3) {
        return (r1 ^ r2) ^ r3;
    }

    private int GG1(int r1, int r2, int r3) {
        return (r1 & r2) | ((~r1) & r3);
    }

    private int P0(int r3) {
        int r2 = (r3 << 9) | (r3 >>> 23);
        int r4 = r2 ^ r3;
        return r4 ^ ((r3 << 17) | (r3 >>> 15));
    }

    private int P1(int r3) {
        int r2 = (r3 << 15) | (r3 >>> 17);
        int r4 = r2 ^ r3;
        return r4 ^ ((r3 << 23) | (r3 >>> 9));
    }

    private void copyIn(SM3Digest r5) {
        int[] r0 = r5.V;
        int[] r1 = this.V;
        System.arraycopy(r0, 0, r1, 0, r1.length);
        int[] r2 = r5.inwords;
        int[] r3 = this.inwords;
        System.arraycopy(r2, 0, r3, 0, r3.length);
        this.xOff = r5.xOff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SM3Digest(this);
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 256, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r2, int r3) {
        finish();
        Pack.intToBigEndian(this.V, r2, r3);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SM3";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r2 = 0;
    L3:
        int r3 = 16;
        if (r2 >= 16) goto L6;
        this.W[r2] = this.inwords[r2];
        r2 = r2 + 1;
        goto L3
    L6:
        int r4 = 16;
    L8:
        if (r4 >= 68) goto L10;
        int[] r5 = this.W;
        int r6 = r5[r4 - 3];
        int r7 = (r6 >>> 17) | (r6 << 15);
        int r8 = r5[r4 - 13];
        r5[r4] = (P1(r7 ^ (r5[r4 - 16] ^ r5[r4 - 9])) ^ ((r8 >>> 25) | (r8 << 7))) ^ this.W[r4 - 6];
        r4 = r4 + 1;
        goto L8
    L10:
        int[] r9 = this.V;
        int r10 = r9[0];
        int r11 = r9[1];
        int r12 = r9[2];
        int r13 = r9[3];
        int r14 = r9[4];
        int r15 = r9[5];
        int r16 = r9[6];
        int r17 = r9[7];
        int r18 = 0;
        int r19 = r16;
    L11:
        if (r18 >= r3) goto L13;
        int r110 = (r10 << 12) | (r10 >>> 20);
        int r111 = (r110 + r14) + T[r18];
        int r112 = (r111 << 7) | (r111 >>> 25);
        int[] r20 = this.W;
        int r21 = r20[r18];
        int r22 = r21 ^ r20[r18 + 4];
        int r23 = FF0(r10, r11, r12) + r13;
        int r113 = ((GG0(r14, r15, r19) + r17) + r112) + r21;
        int r24 = (r11 << 9) | (r11 >>> 23);
        int r25 = (r15 << 19) | (r15 >>> 13);
        r18 = r18 + 1;
        r15 = r14;
        r14 = P0(r113);
        r13 = r12;
        r12 = r24;
        r17 = r19;
        r19 = r25;
        r11 = r10;
        r10 = (r23 + (r112 ^ r110)) + r22;
        r3 = 16;
        goto L11
    L13:
        int r26 = r17;
        int r114 = r14;
        int r27 = r19;
        int r115 = r13;
        int r116 = r12;
        int r28 = r11;
        int r29 = r10;
        int r30 = 16;
    L15:
        if (r30 >= 64) goto L17;
        int r117 = (r29 << 12) | (r29 >>> 20);
        int r118 = (r117 + r114) + T[r30];
        int r119 = (r118 << 7) | (r118 >>> 25);
        int[] r120 = this.W;
        int r210 = r120[r30];
        int r121 = r210 ^ r120[r30 + 4];
        int r211 = FF1(r29, r28, r116) + r115;
        int r122 = ((GG1(r114, r15, r27) + r26) + r119) + r210;
        int r31 = (r28 >>> 23) | (r28 << 9);
        int r32 = (r15 << 19) | (r15 >>> 13);
        r30 = r30 + 1;
        r15 = r114;
        r114 = P0(r122);
        r115 = r116;
        r116 = r31;
        r28 = r29;
        r29 = (r211 + (r119 ^ r117)) + r121;
        r26 = r27;
        r27 = r32;
        goto L15
    L17:
        int[] r33 = this.V;
        r33[0] = r29 ^ r33[0];
        r33[1] = r33[1] ^ r28;
        r33[2] = r33[2] ^ r116;
        r33[3] = r33[3] ^ r115;
        r33[4] = r33[4] ^ r114;
        r33[5] = r33[5] ^ r15;
        r33[6] = r27 ^ r33[6];
        r33[7] = r33[7] ^ r26;
        this.xOff = 0;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r6) {
        int r0 = this.xOff;
        if (r0 <= 14) goto L5;
        this.inwords[r0] = 0;
        this.xOff = r0 + 1;
        processBlock();
    L5:
        int r1 = this.xOff;
        if (r1 >= 14) goto L8;
        this.inwords[r1] = 0;
        this.xOff = r1 + 1;
        goto L5
    L8:
        int[] r2 = this.inwords;
        int r3 = r1 + 1;
        this.xOff = r3;
        r2[r1] = (int) (r6 >>> 32);
        this.xOff = r3 + 1;
        r2[r3] = (int) r6;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] r4, int r5) {
        int[] r0 = this.inwords;
        int r1 = this.xOff;
        this.xOff = r1 + 1;
        r0[r1] = Pack.bigEndianToInt(r4, r5);
        if (this.xOff < 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        int[] r0 = this.V;
        r0[0] = 1937774191;
        r0[1] = 1226093241;
        r0[2] = 388252375;
        r0[3] = -628488704;
        r0[4] = -1452330820;
        r0[5] = 372324522;
        r0[6] = -477237683;
        r0[7] = -1325724082;
        this.xOff = 0;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r3) {
        SM3Digest r4 = (SM3Digest) ZeusTransformUtils.preCheckCast((Memoable) ZeusTransformUtils.wrapperContextForParams(r3, Memoable.class, "com.obric.memorydata.plugin"), SM3Digest.class, "com.obric.memorydata.plugin");
        super.copyIn(r4);
        copyIn(r4);
    }
}
