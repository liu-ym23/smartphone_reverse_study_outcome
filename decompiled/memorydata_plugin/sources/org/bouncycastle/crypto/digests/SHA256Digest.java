package org.bouncycastle.crypto.digests;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SHA256Digest extends GeneralDigest {
    static final int[] K = null;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int[] X;
    private int xOff;

    static {
        K = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    }

    public SHA256Digest() {
        this(CryptoServicePurpose.ANY);
    }

    public SHA256Digest(CryptoServicePurpose r1) {
        super(r1);
        this.X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset();
    }

    public SHA256Digest(SHA256Digest r2) {
        super(r2);
        this.X = new int[64];
        copyIn(r2);
    }

    private static int Ch(int r0, int r1, int r2) {
        int r3 = r1 & r0;
        return ((~r0) & r2) ^ r3;
    }

    private static int Maj(int r1, int r2, int r3) {
        int r0 = r1 & r2;
        return ((r1 ^ r2) & r3) | r0;
    }

    private static int Sum0(int r3) {
        int r0 = ((r3 >>> 2) | (r3 << 30)) ^ ((r3 >>> 13) | (r3 << 19));
        int r1 = r3 >>> 22;
        return ((r3 << 10) | r1) ^ r0;
    }

    private static int Sum1(int r3) {
        int r0 = ((r3 >>> 6) | (r3 << 26)) ^ ((r3 >>> 11) | (r3 << 21));
        int r1 = r3 >>> 25;
        return ((r3 << 7) | r1) ^ r0;
    }

    private static int Theta0(int r3) {
        int r0 = ((r3 >>> 7) | (r3 << 25)) ^ ((r3 >>> 18) | (r3 << 14));
        return (r3 >>> 3) ^ r0;
    }

    private static int Theta1(int r3) {
        int r0 = ((r3 >>> 17) | (r3 << 15)) ^ ((r3 >>> 19) | (r3 << 13));
        return (r3 >>> 10) ^ r0;
    }

    private void copyIn(SHA256Digest r5) {
        super.copyIn(r5);
        this.H1 = r5.H1;
        this.H2 = r5.H2;
        this.H3 = r5.H3;
        this.H4 = r5.H4;
        this.H5 = r5.H5;
        this.H6 = r5.H6;
        this.H7 = r5.H7;
        this.H8 = r5.H8;
        int[] r0 = r5.X;
        System.arraycopy(r0, 0, this.X, 0, r0.length);
        this.xOff = r5.xOff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA256Digest(this);
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 256, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r3, int r4) {
        finish();
        Pack.intToBigEndian(this.H1, r3, r4);
        Pack.intToBigEndian(this.H2, r3, r4 + 4);
        Pack.intToBigEndian(this.H3, r3, r4 + 8);
        Pack.intToBigEndian(this.H4, r3, r4 + 12);
        Pack.intToBigEndian(this.H5, r3, r4 + 16);
        Pack.intToBigEndian(this.H6, r3, r4 + 20);
        Pack.intToBigEndian(this.H7, r3, r4 + 24);
        Pack.intToBigEndian(this.H8, r3, r4 + 28);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return CryptoConst.ALGORITHM_SHA256;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r1 = 16;
    L4:
        if (r1 > 63) goto L6;
        int[] r2 = this.X;
        int r3 = Theta1(r2[r1 - 2]);
        int[] r4 = this.X;
        r2[r1] = ((r3 + r4[r1 - 7]) + Theta0(r4[r1 - 15])) + this.X[r1 - 16];
        r1 = r1 + 1;
        goto L4
    L6:
        int r5 = this.H1;
        int r6 = this.H2;
        int r7 = this.H3;
        int r8 = this.H4;
        int r9 = this.H5;
        int r10 = this.H6;
        int r11 = this.H7;
        int r12 = this.H8;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r13 >= 8) goto L10;
        int r15 = Sum1(r9) + Ch(r9, r10, r11);
        int[] r16 = K;
        int r17 = r12 + ((r15 + r16[r14]) + this.X[r14]);
        int r18 = r8 + r17;
        int r19 = r17 + (Sum0(r5) + Maj(r5, r6, r7));
        int r110 = r14 + 1;
        int r20 = r11 + (((Sum1(r18) + Ch(r18, r9, r10)) + r16[r110]) + this.X[r110]);
        int r21 = r7 + r20;
        int r22 = r20 + (Sum0(r19) + Maj(r19, r5, r6));
        int r111 = r110 + 1;
        int r23 = r10 + (((Sum1(r21) + Ch(r21, r18, r9)) + r16[r111]) + this.X[r111]);
        int r24 = r6 + r23;
        int r25 = r23 + (Sum0(r22) + Maj(r22, r19, r5));
        int r112 = r111 + 1;
        int r26 = r9 + (((Sum1(r24) + Ch(r24, r21, r18)) + r16[r112]) + this.X[r112]);
        int r27 = r5 + r26;
        int r28 = r26 + (Sum0(r25) + Maj(r25, r22, r19));
        int r113 = r112 + 1;
        int r29 = r18 + (((Sum1(r27) + Ch(r27, r24, r21)) + r16[r113]) + this.X[r113]);
        r12 = r19 + r29;
        r8 = r29 + (Sum0(r28) + Maj(r28, r25, r22));
        int r114 = r113 + 1;
        int r30 = r21 + (((Sum1(r12) + Ch(r12, r27, r24)) + r16[r114]) + this.X[r114]);
        r11 = r22 + r30;
        r7 = r30 + (Sum0(r8) + Maj(r8, r28, r25));
        int r115 = r114 + 1;
        int r31 = r24 + (((Sum1(r11) + Ch(r11, r12, r27)) + r16[r115]) + this.X[r115]);
        r10 = r25 + r31;
        r6 = r31 + (Sum0(r7) + Maj(r7, r8, r28));
        int r116 = r115 + 1;
        int r32 = r27 + (((Sum1(r10) + Ch(r10, r11, r12)) + r16[r116]) + this.X[r116]);
        r9 = r28 + r32;
        r5 = r32 + (Sum0(r6) + Maj(r6, r7, r8));
        r14 = r116 + 1;
        r13 = r13 + 1;
        goto L8
    L10:
        this.H1 += r5;
        this.H2 += r6;
        this.H3 += r7;
        this.H4 += r8;
        this.H5 += r9;
        this.H6 += r10;
        this.H7 += r11;
        this.H8 += r12;
        this.xOff = 0;
        int r33 = 0;
    L11:
        if (r33 >= 16) goto L13;
        this.X[r33] = 0;
        r33 = r33 + 1;
        goto L11
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r5) {
        if (this.xOff <= 14) goto L5;
        processBlock();
    L5:
        int[] r4 = this.X;
        r4[14] = (int) (r5 >>> 32);
        r4[15] = (int) (r5 & (-1));
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] r3, int r4) {
        this.X[this.xOff] = Pack.bigEndianToInt(r3, r4);
        int r5 = this.xOff + 1;
        this.xOff = r5;
        if (r5 != 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 1779033703;
        this.H2 = -1150833019;
        this.H3 = 1013904242;
        this.H4 = -1521486534;
        this.H5 = 1359893119;
        this.H6 = -1694144372;
        this.H7 = 528734635;
        this.H8 = 1541459225;
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
        copyIn((SHA256Digest) ZeusTransformUtils.preCheckCast((Memoable) ZeusTransformUtils.wrapperContextForParams(r3, Memoable.class, "com.obric.memorydata.plugin"), SHA256Digest.class, "com.obric.memorydata.plugin"));
    }
}
