package org.bouncycastle.crypto.digests;

import androidx.core.view.MotionEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3411Digest implements ExtendedDigest, Memoable {
    private static final byte[] C2 = null;
    private byte[][] C;
    private byte[] H;
    private byte[] K;
    private byte[] L;
    private byte[] M;
    byte[] S;
    private byte[] Sum;
    byte[] U;
    byte[] V;
    byte[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f17972a;
    private long byteCount;
    private BlockCipher cipher;
    private final CryptoServicePurpose purpose;
    private byte[] sBox;
    short[] wS;
    short[] w_S;
    private byte[] xBuf;
    private int xBufOff;

    static {
        C2 = new byte[]{0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};
    }

    public GOST3411Digest() {
        this(CryptoServicePurpose.ANY);
    }

    public GOST3411Digest(CryptoServicePurpose r4) {
        this.H = new byte[32];
        this.L = new byte[32];
        this.M = new byte[32];
        this.Sum = new byte[32];
        this.C = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.K = new byte[32];
        this.f17972a = new byte[8];
        this.wS = new short[16];
        this.w_S = new short[16];
        this.S = new byte[32];
        this.U = new byte[32];
        this.V = new byte[32];
        this.W = new byte[32];
        this.purpose = r4;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        this.sBox = GOST28147Engine.getSBox("D-A");
        this.cipher.init(true, new ParametersWithSBox(null, this.sBox));
        reset();
    }

    public GOST3411Digest(GOST3411Digest r4) {
        this.H = new byte[32];
        this.L = new byte[32];
        this.M = new byte[32];
        this.Sum = new byte[32];
        this.C = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.K = new byte[32];
        this.f17972a = new byte[8];
        this.wS = new short[16];
        this.w_S = new short[16];
        this.S = new byte[32];
        this.U = new byte[32];
        this.V = new byte[32];
        this.W = new byte[32];
        this.purpose = r4.purpose;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset(r4);
    }

    private byte[] A(byte[] r6) {
        int r1 = 0;
    L4:
        if (r1 >= 8) goto L6;
        this.f17972a[r1] = (byte) (r6[r1] ^ r6[r1 + 8]);
        r1 = r1 + 1;
        goto L4
    L6:
        System.arraycopy(r6, 8, r6, 0, 24);
        System.arraycopy(this.f17972a, 0, r6, 24, 8);
        return r6;
    }

    private void E(byte[] r3, byte[] r4, int r5, byte[] r6, int r7) {
        this.cipher.init(true, new KeyParameter(r3));
        this.cipher.processBlock(r6, r7, r4, r5);
    }

    private byte[] P(byte[] r6) {
        int r0 = 0;
    L4:
        if (r0 >= 8) goto L7;
        byte[] r1 = this.K;
        int r2 = r0 * 4;
        r1[r2] = r6[r0];
        r1[r2 + 1] = r6[r0 + 8];
        r1[r2 + 2] = r6[r0 + 16];
        r1[r2 + 3] = r6[r0 + 24];
        r0 = r0 + 1;
        goto L4
    L7:
        return this.K;
    }

    private void cpyBytesToShort(byte[] r4, short[] r5) {
        int r3 = 0;
    L4:
        if (r3 >= (r4.length / 2)) goto L6;
        int r0 = r3 * 2;
        int r1 = (r4[r0 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        r5[r3] = (short) ((r4[r0] & 255) | r1);
        r3 = r3 + 1;
        goto L4
    }

    private void cpyShortToBytes(short[] r4, byte[] r5) {
        int r3 = 0;
    L4:
        if (r3 >= (r5.length / 2)) goto L6;
        int r0 = r3 * 2;
        r5[r0 + 1] = (byte) (r4[r3] >> 8);
        r5[r0] = (byte) r4[r3];
        r3 = r3 + 1;
        goto L4
    }

    private void finish() {
        Pack.longToLittleEndian(this.byteCount * 8, this.L, 0);
    L4:
        if (this.xBufOff == 0) goto L6;
        update((byte) 0);
        goto L4
    L6:
        processBlock(this.L, 0);
        processBlock(this.Sum, 0);
    }

    private void fw(byte[] r8) {
        cpyBytesToShort(r8, this.wS);
        short[] r0 = this.w_S;
        short[] r1 = this.wS;
        r0[15] = (short) (((((r1[0] ^ r1[1]) ^ r1[2]) ^ r1[3]) ^ r1[12]) ^ r1[15]);
        System.arraycopy(r1, 1, r0, 0, 15);
        cpyShortToBytes(this.w_S, r8);
    }

    private void sumByteArray(byte[] r6) {
        int r0 = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.Sum;
        if (r0 == r2.length) goto L6;
        int r3 = ((r2[r0] & 255) + (r6[r0] & 255)) + r1;
        r2[r0] = (byte) r3;
        r1 = r3 >>> 8;
        r0 = r0 + 1;
        goto L3
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new GOST3411Digest(this);
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 256, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r4, int r5) {
        finish();
        byte[] r0 = this.H;
        System.arraycopy(r0, 0, r4, r5, r0.length);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "GOST3411";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    public void processBlock(byte[] r10, int r11) {
        System.arraycopy(r10, r11, this.M, 0, 32);
        System.arraycopy(this.H, 0, this.U, 0, 32);
        System.arraycopy(this.M, 0, this.V, 0, 32);
        int r12 = 0;
    L3:
        if (r12 >= 32) goto L5;
        this.W[r12] = (byte) (this.U[r12] ^ this.V[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        E(P(this.W), this.S, 0, this.H, 0);
        int r13 = 1;
    L7:
        if (r13 >= 4) goto L15;
        byte[] r14 = A(this.U);
        int r0 = 0;
    L9:
        if (r0 >= 32) goto L11;
        this.U[r0] = (byte) (r14[r0] ^ this.C[r13][r0]);
        r0 = r0 + 1;
        goto L9
    L11:
        this.V = A(A(this.V));
        int r15 = 0;
    L12:
        if (r15 >= 32) goto L14;
        this.W[r15] = (byte) (this.U[r15] ^ this.V[r15]);
        r15 = r15 + 1;
        goto L12
    L14:
        int r8 = r13 * 8;
        E(P(this.W), this.S, r8, this.H, r8);
        r13 = r13 + 1;
        goto L7
    L15:
        int r16 = 0;
    L17:
        if (r16 >= 12) goto L19;
        fw(this.S);
        r16 = r16 + 1;
        goto L17
    L19:
        int r17 = 0;
    L20:
        if (r17 >= 32) goto L22;
        byte[] r18 = this.S;
        r18[r17] = (byte) (r18[r17] ^ this.M[r17]);
        r17 = r17 + 1;
        goto L20
    L22:
        fw(this.S);
        int r19 = 0;
    L23:
        if (r19 >= 32) goto L25;
        byte[] r110 = this.S;
        r110[r19] = (byte) (this.H[r19] ^ r110[r19]);
        r19 = r19 + 1;
        goto L23
    L25:
        int r111 = 0;
    L27:
        if (r111 >= 61) goto L29;
        fw(this.S);
        r111 = r111 + 1;
        goto L27
    L29:
        byte[] r112 = this.S;
        byte[] r9 = this.H;
        System.arraycopy(r112, 0, r9, 0, r9.length);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.H;
        if (r1 >= r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    L6:
        int r3 = 0;
    L7:
        byte[] r4 = this.L;
        if (r3 >= r4.length) goto L10;
        r4[r3] = 0;
        r3 = r3 + 1;
        goto L7
    L10:
        int r5 = 0;
    L11:
        byte[] r6 = this.M;
        if (r5 >= r6.length) goto L14;
        r6[r5] = 0;
        r5 = r5 + 1;
        goto L11
    L14:
        int r7 = 0;
    L15:
        byte[][] r8 = this.C;
        if (r7 >= r8[1].length) goto L18;
        r8[1][r7] = 0;
        r7 = r7 + 1;
        goto L15
    L18:
        int r9 = 0;
    L19:
        byte[][] r10 = this.C;
        if (r9 >= r10[3].length) goto L22;
        r10[3][r9] = 0;
        r9 = r9 + 1;
        goto L19
    L22:
        int r11 = 0;
    L23:
        byte[] r12 = this.Sum;
        if (r11 >= r12.length) goto L26;
        r12[r11] = 0;
        r11 = r11 + 1;
        goto L23
    L26:
        int r13 = 0;
    L27:
        byte[] r14 = this.xBuf;
        if (r13 >= r14.length) goto L30;
        r14[r13] = 0;
        r13 = r13 + 1;
        goto L27
    L30:
        byte[] r15 = C2;
        System.arraycopy(r15, 0, this.C[2], 0, r15.length);
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r6) {
        GOST3411Digest r7 = (GOST3411Digest) ZeusTransformUtils.preCheckCast((Memoable) ZeusTransformUtils.wrapperContextForParams(r6, Memoable.class, "com.obric.memorydata.plugin"), GOST3411Digest.class, "com.obric.memorydata.plugin");
        this.sBox = r7.sBox;
        this.cipher.init(true, new ParametersWithSBox(null, this.sBox));
        reset();
        byte[] r0 = r7.H;
        System.arraycopy(r0, 0, this.H, 0, r0.length);
        byte[] r1 = r7.L;
        System.arraycopy(r1, 0, this.L, 0, r1.length);
        byte[] r2 = r7.M;
        System.arraycopy(r2, 0, this.M, 0, r2.length);
        byte[] r3 = r7.Sum;
        System.arraycopy(r3, 0, this.Sum, 0, r3.length);
        byte[][] r4 = r7.C;
        System.arraycopy(r4[1], 0, this.C[1], 0, r4[1].length);
        byte[][] r5 = r7.C;
        System.arraycopy(r5[2], 0, this.C[2], 0, r5[2].length);
        byte[][] r8 = r7.C;
        System.arraycopy(r8[3], 0, this.C[3], 0, r8[3].length);
        byte[] r9 = r7.xBuf;
        System.arraycopy(r9, 0, this.xBuf, 0, r9.length);
        this.xBufOff = r7.xBufOff;
        this.byteCount = r7.byteCount;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r5) {
        byte[] r0 = this.xBuf;
        int r1 = this.xBufOff;
        int r2 = r1 + 1;
        this.xBufOff = r2;
        r0[r1] = r5;
        if (r2 != r0.length) goto L5;
        sumByteArray(r0);
        processBlock(this.xBuf, 0);
        this.xBufOff = 0;
    L5:
        this.byteCount++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r6, int r7, int r8) {
    L3:
        if (this.xBufOff == 0) goto L6;
        if (r8 <= 0) goto L6;
        update(r6[r7]);
        r7 = r7 + 1;
        r8 = r8 - 1;
    L6:
        byte[] r0 = this.xBuf;
        if (r8 < r0.length) goto L9;
        System.arraycopy(r6, r7, r0, 0, r0.length);
        sumByteArray(this.xBuf);
        processBlock(this.xBuf, 0);
        byte[] r1 = this.xBuf;
        r7 = r7 + r1.length;
        r8 = r8 - r1.length;
        this.byteCount += (long) r1.length;
    L9:
        if (r8 <= 0) goto L11;
        update(r6[r7]);
        r7 = r7 + 1;
        r8 = r8 - 1;
        goto L9
    }
}
