package org.bouncycastle.crypto.digests;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class MD5Digest extends GeneralDigest {
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int[] X;
    private int xOff;

    public MD5Digest() {
        this(CryptoServicePurpose.ANY);
    }

    public MD5Digest(CryptoServicePurpose r2) {
        super(r2);
        this.X = new int[16];
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, 64, r2));
        reset();
    }

    public MD5Digest(MD5Digest r2) {
        super(r2);
        this.X = new int[16];
        copyIn(r2);
    }

    private int F(int r1, int r2, int r3) {
        return (r1 & r2) | ((~r1) & r3);
    }

    private int G(int r1, int r2, int r3) {
        return (r1 & r3) | ((~r3) & r2);
    }

    private int H(int r1, int r2, int r3) {
        return (r1 ^ r2) ^ r3;
    }

    private int K(int r1, int r2, int r3) {
        return ((~r3) | r1) ^ r2;
    }

    private void copyIn(MD5Digest r5) {
        super.copyIn(r5);
        this.H1 = r5.H1;
        this.H2 = r5.H2;
        this.H3 = r5.H3;
        this.H4 = r5.H4;
        int[] r0 = r5.X;
        System.arraycopy(r0, 0, this.X, 0, r0.length);
        this.xOff = r5.xOff;
    }

    private int rotateLeft(int r1, int r2) {
        return (r1 << r2) | (r1 >>> (32 - r2));
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new MD5Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r3, int r4) {
        finish();
        Pack.intToLittleEndian(this.H1, r3, r4);
        Pack.intToLittleEndian(this.H2, r3, r4 + 4);
        Pack.intToLittleEndian(this.H3, r3, r4 + 8);
        Pack.intToLittleEndian(this.H4, r3, r4 + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return CryptoConst.ALGORITHM_MD5;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r1 = this.H1;
        int r2 = this.H2;
        int r3 = this.H3;
        int r4 = this.H4;
        int r5 = rotateLeft(((r1 + F(r2, r3, r4)) + this.X[0]) - 680876936, 7) + r2;
        int r6 = rotateLeft(((r4 + F(r5, r2, r3)) + this.X[1]) - 389564586, 12) + r5;
        int r7 = rotateLeft(((r3 + F(r6, r5, r2)) + this.X[2]) + 606105819, 17) + r6;
        int r8 = rotateLeft(((r2 + F(r7, r6, r5)) + this.X[3]) - 1044525330, 22) + r7;
        int r9 = rotateLeft(((r5 + F(r8, r7, r6)) + this.X[4]) - 176418897, 7) + r8;
        int r10 = rotateLeft(((r6 + F(r9, r8, r7)) + this.X[5]) + 1200080426, 12) + r9;
        int r11 = rotateLeft(((r7 + F(r10, r9, r8)) + this.X[6]) - 1473231341, 17) + r10;
        int r12 = rotateLeft(((r8 + F(r11, r10, r9)) + this.X[7]) - 45705983, 22) + r11;
        int r13 = rotateLeft(((r9 + F(r12, r11, r10)) + this.X[8]) + 1770035416, 7) + r12;
        int r14 = rotateLeft(((r10 + F(r13, r12, r11)) + this.X[9]) - 1958414417, 12) + r13;
        int r15 = rotateLeft(((r11 + F(r14, r13, r12)) + this.X[10]) - 42063, 17) + r14;
        int r16 = rotateLeft(((r12 + F(r15, r14, r13)) + this.X[11]) - 1990404162, 22) + r15;
        int r17 = rotateLeft(((r13 + F(r16, r15, r14)) + this.X[12]) + 1804603682, 7) + r16;
        int r18 = rotateLeft(((r14 + F(r17, r16, r15)) + this.X[13]) - 40341101, 12) + r17;
        int r19 = rotateLeft(((r15 + F(r18, r17, r16)) + this.X[14]) - 1502002290, 17) + r18;
        int r20 = rotateLeft(((r16 + F(r19, r18, r17)) + this.X[15]) + 1236535329, 22) + r19;
        int r21 = rotateLeft(((r17 + G(r20, r19, r18)) + this.X[1]) - 165796510, 5) + r20;
        int r22 = rotateLeft(((r18 + G(r21, r20, r19)) + this.X[6]) - 1069501632, 9) + r21;
        int r23 = rotateLeft(((r19 + G(r22, r21, r20)) + this.X[11]) + 643717713, 14) + r22;
        int r24 = rotateLeft(((r20 + G(r23, r22, r21)) + this.X[0]) - 373897302, 20) + r23;
        int r25 = rotateLeft(((r21 + G(r24, r23, r22)) + this.X[5]) - 701558691, 5) + r24;
        int r26 = rotateLeft(((r22 + G(r25, r24, r23)) + this.X[10]) + 38016083, 9) + r25;
        int r27 = rotateLeft(((r23 + G(r26, r25, r24)) + this.X[15]) - 660478335, 14) + r26;
        int r28 = rotateLeft(((r24 + G(r27, r26, r25)) + this.X[4]) - 405537848, 20) + r27;
        int r29 = rotateLeft(((r25 + G(r28, r27, r26)) + this.X[9]) + 568446438, 5) + r28;
        int r30 = rotateLeft(((r26 + G(r29, r28, r27)) + this.X[14]) - 1019803690, 9) + r29;
        int r31 = rotateLeft(((r27 + G(r30, r29, r28)) + this.X[3]) - 187363961, 14) + r30;
        int r32 = rotateLeft(((r28 + G(r31, r30, r29)) + this.X[8]) + 1163531501, 20) + r31;
        int r33 = rotateLeft(((r29 + G(r32, r31, r30)) + this.X[13]) - 1444681467, 5) + r32;
        int r34 = rotateLeft(((r30 + G(r33, r32, r31)) + this.X[2]) - 51403784, 9) + r33;
        int r35 = rotateLeft(((r31 + G(r34, r33, r32)) + this.X[7]) + 1735328473, 14) + r34;
        int r36 = rotateLeft(((r32 + G(r35, r34, r33)) + this.X[12]) - 1926607734, 20) + r35;
        int r37 = rotateLeft(((r33 + H(r36, r35, r34)) + this.X[5]) - 378558, 4) + r36;
        int r38 = rotateLeft(((r34 + H(r37, r36, r35)) + this.X[8]) - 2022574463, 11) + r37;
        int r39 = rotateLeft(((r35 + H(r38, r37, r36)) + this.X[11]) + 1839030562, 16) + r38;
        int r40 = rotateLeft(((r36 + H(r39, r38, r37)) + this.X[14]) - 35309556, 23) + r39;
        int r41 = rotateLeft(((r37 + H(r40, r39, r38)) + this.X[1]) - 1530992060, 4) + r40;
        int r42 = rotateLeft(((r38 + H(r41, r40, r39)) + this.X[4]) + 1272893353, 11) + r41;
        int r43 = rotateLeft(((r39 + H(r42, r41, r40)) + this.X[7]) - 155497632, 16) + r42;
        int r44 = rotateLeft(((r40 + H(r43, r42, r41)) + this.X[10]) - 1094730640, 23) + r43;
        int r45 = rotateLeft(((r41 + H(r44, r43, r42)) + this.X[13]) + 681279174, 4) + r44;
        int r46 = rotateLeft(((r42 + H(r45, r44, r43)) + this.X[0]) - 358537222, 11) + r45;
        int r47 = rotateLeft(((r43 + H(r46, r45, r44)) + this.X[3]) - 722521979, 16) + r46;
        int r48 = rotateLeft(((r44 + H(r47, r46, r45)) + this.X[6]) + 76029189, 23) + r47;
        int r49 = rotateLeft(((r45 + H(r48, r47, r46)) + this.X[9]) - 640364487, 4) + r48;
        int r50 = rotateLeft(((r46 + H(r49, r48, r47)) + this.X[12]) - 421815835, 11) + r49;
        int r51 = rotateLeft(((r47 + H(r50, r49, r48)) + this.X[15]) + 530742520, 16) + r50;
        int r52 = rotateLeft(((r48 + H(r51, r50, r49)) + this.X[2]) - 995338651, 23) + r51;
        int r53 = rotateLeft(((r49 + K(r52, r51, r50)) + this.X[0]) - 198630844, 6) + r52;
        int r54 = rotateLeft(((r50 + K(r53, r52, r51)) + this.X[7]) + 1126891415, 10) + r53;
        int r55 = rotateLeft(((r51 + K(r54, r53, r52)) + this.X[14]) - 1416354905, 15) + r54;
        int r56 = rotateLeft(((r52 + K(r55, r54, r53)) + this.X[5]) - 57434055, 21) + r55;
        int r57 = rotateLeft(((r53 + K(r56, r55, r54)) + this.X[12]) + 1700485571, 6) + r56;
        int r58 = rotateLeft(((r54 + K(r57, r56, r55)) + this.X[3]) - 1894986606, 10) + r57;
        int r59 = rotateLeft(((r55 + K(r58, r57, r56)) + this.X[10]) - 1051523, 15) + r58;
        int r60 = rotateLeft(((r56 + K(r59, r58, r57)) + this.X[1]) - 2054922799, 21) + r59;
        int r61 = rotateLeft(((r57 + K(r60, r59, r58)) + this.X[8]) + 1873313359, 6) + r60;
        int r62 = rotateLeft(((r58 + K(r61, r60, r59)) + this.X[15]) - 30611744, 10) + r61;
        int r63 = rotateLeft(((r59 + K(r62, r61, r60)) + this.X[6]) - 1560198380, 15) + r62;
        int r64 = rotateLeft(((r60 + K(r63, r62, r61)) + this.X[13]) + 1309151649, 21) + r63;
        int r65 = rotateLeft(((r61 + K(r64, r63, r62)) + this.X[4]) - 145523070, 6) + r64;
        int r66 = rotateLeft(((r62 + K(r65, r64, r63)) + this.X[11]) - 1120210379, 10) + r65;
        int r67 = rotateLeft(((r63 + K(r66, r65, r64)) + this.X[2]) + 718787259, 15) + r66;
        int r68 = rotateLeft(((r64 + K(r67, r66, r65)) + this.X[9]) - 343485551, 21) + r67;
        this.H1 += r65;
        this.H2 += r68;
        this.H3 += r67;
        this.H4 += r66;
        this.xOff = 0;
        int r69 = 0;
    L3:
        int[] r70 = this.X;
        if (r69 == r70.length) goto L6;
        r70[r69] = 0;
        r69 = r69 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r5) {
        if (this.xOff <= 14) goto L5;
        processBlock();
    L5:
        int[] r4 = this.X;
        r4[14] = (int) ((-1) & r5);
        r4[15] = (int) (r5 >>> 32);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] r4, int r5) {
        int[] r0 = this.X;
        int r1 = this.xOff;
        this.xOff = r1 + 1;
        r0[r1] = Pack.littleEndianToInt(r4, r5);
        if (this.xOff != 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.xOff = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.X;
        if (r1 == r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r3) {
        copyIn((MD5Digest) ZeusTransformUtils.preCheckCast((Memoable) ZeusTransformUtils.wrapperContextForParams(r3, Memoable.class, "com.obric.memorydata.plugin"), MD5Digest.class, "com.obric.memorydata.plugin"));
    }
}
