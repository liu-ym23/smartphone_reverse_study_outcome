package org.bouncycastle.crypto.digests;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public class MD2Digest implements ExtendedDigest, Memoable {
    private static final byte[] S = null;
    private byte[] C;
    private int COff;
    private byte[] M;
    private byte[] X;
    private int mOff;
    private final CryptoServicePurpose purpose;
    private int xOff;

    static {
        S = new byte[]{41, 46, 67, MessagePack.Code.EXT32, -94, MessagePack.Code.FIXEXT16, 124, 1, Base64.padSymbol, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, MessagePack.Code.NIL, MessagePack.Code.EXT8, 115, -116, -104, -109, 43, MessagePack.Code.STR8, -68, 76, -126, MessagePack.Code.FLOAT32, 30, -101, 87, 60, -3, MessagePack.Code.FIXEXT1, MessagePack.Code.NEGFIXINT_PREFIX, 22, 103, 66, 111, 24, -118, 23, -27, 18, -66, 78, MessagePack.Code.BIN8, MessagePack.Code.FIXEXT4, MessagePack.Code.STR16, -98, MessagePack.Code.MAP16, 73, MessagePack.Code.FIXSTR_PREFIX, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, Utf8.REPLACEMENT_BYTE, -108, MessagePack.Code.FALSE, 16, -119, 11, 34, 95, 33, -128, ByteCompanionObject.MAX_VALUE, 93, -102, 90, MessagePack.Code.FIXARRAY_PREFIX, 50, 39, 53, 62, MessagePack.Code.UINT8, -25, -65, -9, -105, 3, -1, 25, 48, -77, 72, -91, -75, MessagePack.Code.INT16, MessagePack.Code.FIXEXT8, 94, -110, 42, -84, 86, -86, MessagePack.Code.BIN32, 79, -72, 56, MessagePack.Code.INT32, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, MessagePack.Code.UINT64, 101, -26, 45, -88, 2, 27, 96, 37, -83, -82, -80, -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 85, 71, -93, 35, MessagePack.Code.ARRAY32, 81, -81, 58, MessagePack.Code.TRUE, 92, -7, MessagePack.Code.UINT32, -70, MessagePack.Code.BIN16, -22, 38, 44, 83, 13, 110, -123, 40, -124, 9, MessagePack.Code.INT64, MessagePack.Code.MAP32, MessagePack.Code.UINT16, -12, 65, -127, 77, 82, 106, MessagePack.Code.ARRAY16, 55, MessagePack.Code.EXT16, 108, MessagePack.Code.NEVER_USED, -85, -6, 36, -31, 123, 8, 12, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, MessagePack.Code.FLOAT64, MessagePack.Code.FIXEXT2, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, 88, MessagePack.Code.INT8, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, 31, 26, MessagePack.Code.STR32, -103, -115, 51, -97, 17, -125, 20};
    }

    public MD2Digest() {
        this(CryptoServicePurpose.ANY);
    }

    public MD2Digest(CryptoServicePurpose r3) {
        this.X = new byte[48];
        this.M = new byte[16];
        this.C = new byte[16];
        this.purpose = r3;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, 64, r3));
        reset();
    }

    public MD2Digest(MD2Digest r3) {
        this.X = new byte[48];
        this.M = new byte[16];
        this.C = new byte[16];
        CryptoServicePurpose r0 = r3.purpose;
        this.purpose = r0;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, 64, r0));
        copyIn(r3);
    }

    private void copyIn(MD2Digest r5) {
        byte[] r0 = r5.X;
        System.arraycopy(r0, 0, this.X, 0, r0.length);
        this.xOff = r5.xOff;
        byte[] r1 = r5.M;
        System.arraycopy(r1, 0, this.M, 0, r1.length);
        this.mOff = r5.mOff;
        byte[] r2 = r5.C;
        System.arraycopy(r2, 0, this.C, 0, r2.length);
        this.COff = r5.COff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new MD2Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r5, int r6) {
        int r0 = this.M.length;
        int r1 = this.mOff;
        byte r2 = (byte) (r0 - r1);
    L3:
        byte[] r3 = this.M;
        if (r1 >= r3.length) goto L6;
        r3[r1] = r2;
        r1 = r1 + 1;
        goto L3
    L6:
        processCheckSum(r3);
        processBlock(this.M);
        processBlock(this.C);
        System.arraycopy(this.X, this.xOff, r5, r6, 16);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "MD2";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    public void processBlock(byte[] r7) {
        int r1 = 0;
    L4:
        if (r1 >= 16) goto L6;
        byte[] r2 = this.X;
        r2[r1 + 16] = r7[r1];
        r2[r1 + 32] = (byte) (r7[r1] ^ r2[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        int r8 = 0;
        int r3 = 0;
    L8:
        if (r8 >= 18) goto L14;
        int r4 = 0;
    L11:
        if (r4 >= 48) goto L13;
        byte[] r5 = this.X;
        byte r6 = (byte) (S[r3] ^ r5[r4]);
        r5[r4] = r6;
        r3 = r6 & 255;
        r4 = r4 + 1;
        goto L11
    L13:
        r3 = (r3 + r8) % 256;
        r8 = r8 + 1;
        goto L8
    }

    public void processCheckSum(byte[] r7) {
        byte r0 = this.C[15];
        int r1 = 0;
    L4:
        if (r1 >= 16) goto L6;
        byte[] r2 = this.C;
        byte r3 = r2[r1];
        r2[r1] = (byte) (S[(r0 ^ r7[r1]) & 255] ^ r3);
        r0 = r2[r1];
        r1 = r1 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.xOff = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.X;
        if (r1 == r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    L6:
        this.mOff = 0;
        int r3 = 0;
    L7:
        byte[] r4 = this.M;
        if (r3 == r4.length) goto L10;
        r4[r3] = 0;
        r3 = r3 + 1;
        goto L7
    L10:
        this.COff = 0;
        int r5 = 0;
    L11:
        byte[] r6 = this.C;
        if (r5 == r6.length) goto L14;
        r6[r5] = 0;
        r5 = r5 + 1;
        goto L11
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r3) {
        copyIn((MD2Digest) ZeusTransformUtils.preCheckCast((Memoable) ZeusTransformUtils.wrapperContextForParams(r3, Memoable.class, "com.obric.memorydata.plugin"), MD2Digest.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r4) {
        byte[] r0 = this.M;
        int r1 = this.mOff;
        int r2 = r1 + 1;
        this.mOff = r2;
        r0[r1] = r4;
        if (r2 != 16) goto L6;
        processCheckSum(r0);
        processBlock(this.M);
        this.mOff = 0;
        return;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r4, int r5, int r6) {
    L3:
        if (this.mOff == 0) goto L7;
        if (r6 <= 0) goto L7;
        update(r4[r5]);
        r5 = r5 + 1;
        r6 = r6 - 1;
    L7:
        if (r6 < 16) goto L9;
        System.arraycopy(r4, r5, this.M, 0, 16);
        processCheckSum(this.M);
        processBlock(this.M);
        r6 = r6 - 16;
        r5 = r5 + 16;
    L9:
        if (r6 <= 0) goto L11;
        update(r4[r5]);
        r5 = r5 + 1;
        r6 = r6 - 1;
        goto L9
    }
}
