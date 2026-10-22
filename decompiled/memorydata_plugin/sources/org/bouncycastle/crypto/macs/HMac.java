package org.bouncycastle.crypto.macs;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes7.dex */
public class HMac implements Mac {
    private static Hashtable blockLengths;
    private int blockLength;
    private Digest digest;
    private int digestSize;
    private byte[] inputPad;
    private Memoable ipadState;
    private Memoable opadState;
    private byte[] outputBuf;

    static {
        Hashtable r0 = new Hashtable();
        blockLengths = r0;
        r0.put("GOST3411", Integers.valueOf(32));
        blockLengths.put("MD2", Integers.valueOf(16));
        blockLengths.put("MD4", Integers.valueOf(64));
        blockLengths.put(CryptoConst.ALGORITHM_MD5, Integers.valueOf(64));
        blockLengths.put("RIPEMD128", Integers.valueOf(64));
        blockLengths.put("RIPEMD160", Integers.valueOf(64));
        blockLengths.put("SHA-1", Integers.valueOf(64));
        blockLengths.put("SHA-224", Integers.valueOf(64));
        blockLengths.put(CryptoConst.ALGORITHM_SHA256, Integers.valueOf(64));
        blockLengths.put("SHA-384", Integers.valueOf(128));
        blockLengths.put("SHA-512", Integers.valueOf(128));
        blockLengths.put("Tiger", Integers.valueOf(64));
        blockLengths.put("Whirlpool", Integers.valueOf(64));
    }

    public HMac(Digest r3) {
        Digest r4 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        this(r4, getByteLength(r4));
    }

    private HMac(Digest r3, int r4) {
        Digest r5 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        this.digest = r5;
        int r6 = r5.getDigestSize();
        this.digestSize = r6;
        this.blockLength = r4;
        this.inputPad = new byte[r4];
        this.outputBuf = new byte[r4 + r6];
    }

    private static int getByteLength(Digest r3) {
        Digest r4 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ExtendedDigest.class) == true) goto L5;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(blockLengths.get(r4.getAlgorithmName()), Integer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        return r0.intValue();
    L11:
        throw new IllegalArgumentException("unknown digest passed: " + r4.getAlgorithmName());
    L5:
        return ((ExtendedDigest) ZeusTransformUtils.preCheckCast(r4, ExtendedDigest.class, "com.obric.memorydata.plugin")).getByteLength();
    }

    private static void xorPad(byte[] r2, int r3, byte r4) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L5;
        r2[r0] = (byte) (r2[r0] ^ r4);
        r0 = r0 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r7, int r8) {
        this.digest.doFinal(this.outputBuf, this.blockLength);
        if (this.opadState == null) goto L5;
        ((Memoable) ZeusTransformUtils.preCheckCast(this.digest, Memoable.class, "com.obric.memorydata.plugin")).reset(this.opadState);
        Digest r0 = this.digest;
        r0.update(this.outputBuf, this.blockLength, r0.getDigestSize());
    L6:
        int r9 = this.digest.doFinal(r7, r8);
        int r10 = this.blockLength;
    L7:
        byte[] r1 = this.outputBuf;
        if (r10 >= r1.length) goto L11;
        r1[r10] = 0;
        r10 = r10 + 1;
        goto L7
    L11:
        if (this.ipadState == null) goto L13;
        ((Memoable) ZeusTransformUtils.preCheckCast(this.digest, Memoable.class, "com.obric.memorydata.plugin")).reset(this.ipadState);
    L14:
        return r9;
    L13:
        Digest r11 = this.digest;
        byte[] r6 = this.inputPad;
        r11.update(r6, 0, r6.length);
        goto L14
    L5:
        Digest r2 = this.digest;
        byte[] r3 = this.outputBuf;
        r2.update(r3, 0, r3.length);
        goto L6
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "/HMAC";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.digestSize;
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r5) {
        CipherParameters r6 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r5, CipherParameters.class, "com.obric.memorydata.plugin");
        this.digest.reset();
        byte[] r7 = ((KeyParameter) ZeusTransformUtils.preCheckCast(r6, KeyParameter.class, "com.obric.memorydata.plugin")).getKey();
        int r0 = r7.length;
        if (r0 <= this.blockLength) goto L5;
        this.digest.update(r7, 0, r0);
        this.digest.doFinal(this.inputPad, 0);
        r0 = this.digestSize;
    L6:
        byte[] r8 = this.inputPad;
        if (r0 >= r8.length) goto L9;
        r8[r0] = 0;
        r0 = r0 + 1;
        goto L6
    L9:
        System.arraycopy(r8, 0, this.outputBuf, 0, this.blockLength);
        xorPad(this.inputPad, this.blockLength, (byte) 54);
        xorPad(this.outputBuf, this.blockLength, (byte) 92);
        if (ZeusTransformUtils.instanceOf(this.digest, Memoable.class) == false) goto L12;
        Memoable r9 = ((Memoable) ZeusTransformUtils.preCheckCast(this.digest, Memoable.class, "com.obric.memorydata.plugin")).copy();
        this.opadState = r9;
        ((Digest) ZeusTransformUtils.preCheckCast(r9, Digest.class, "com.obric.memorydata.plugin")).update(this.outputBuf, 0, this.blockLength);
    L12:
        Digest r10 = this.digest;
        byte[] r1 = this.inputPad;
        r10.update(r1, 0, r1.length);
        if (ZeusTransformUtils.instanceOf(this.digest, Memoable.class) == false) goto L18;
        this.ipadState = ((Memoable) ZeusTransformUtils.preCheckCast(this.digest, Memoable.class, "com.obric.memorydata.plugin")).copy();
        return;
    L18:
        return;
    L5:
        System.arraycopy(r7, 0, this.inputPad, 0, r0);
        goto L6
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r1) {
        this.digest.update(r1);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r1, int r2, int r3) {
        this.digest.update(r1, r2, r3);
    }
}
