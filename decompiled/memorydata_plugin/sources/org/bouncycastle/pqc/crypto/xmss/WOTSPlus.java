package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
final class WOTSPlus {
    private final KeyedHashFunctions khf;
    private final WOTSPlusParameters params;
    private byte[] publicSeed;
    private byte[] secretKeySeed;

    WOTSPlus(WOTSPlusParameters r3) {
        Objects.requireNonNull(r3, "params == null");
        this.params = r3;
        int r0 = r3.getTreeDigestSize();
        this.khf = new KeyedHashFunctions(r3.getTreeDigest(), r0);
        this.secretKeySeed = new byte[r0];
        this.publicSeed = new byte[r0];
    }

    private byte[] chain(byte[] r7, int r8, int r9, OTSHashAddress r10) {
        int r0 = this.params.getTreeDigestSize();
        Objects.requireNonNull(r7, "startHash == null");
        if (r7.length != r0) goto L16;
        Objects.requireNonNull(r10, "otsHashAddress == null");
        Objects.requireNonNull(r10.toByteArray(), "otsHashAddress byte array == null");
        int r1 = r8 + r9;
        if (r1 > (this.params.getWinternitzParameter() - 1)) goto L14;
        if (r9 != 0) goto L8;
        return r7;
    L8:
        byte[] r11 = chain(r7, r8, r9 - 1, r10);
        int r12 = 0;
        OTSHashAddress r13 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r10.getLayerAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r10.getTreeAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(r10.getOTSAddress()).withChainAddress(r10.getChainAddress()).withHashAddress(r1 - 1).withKeyAndMask(0), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        byte[] r14 = this.khf.PRF(this.publicSeed, r13.toByteArray());
        byte[] r15 = this.khf.PRF(this.publicSeed, ((OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r13.getLayerAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r13.getTreeAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(r13.getOTSAddress()).withChainAddress(r13.getChainAddress()).withHashAddress(r13.getHashAddress()).withKeyAndMask(1), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).build(), OTSHashAddress.class, "com.obric.memorydata.plugin")).toByteArray());
        byte[] r2 = new byte[r0];
    L9:
        if (r12 >= r0) goto L12;
        r2[r12] = (byte) (r11[r12] ^ r15[r12]);
        r12 = r12 + 1;
        goto L9
    L12:
        return this.khf.F(r14, r2);
    L14:
        throw new IllegalArgumentException("max chain length must not be greater than w");
    L16:
        throw new IllegalArgumentException("startHash needs to be " + r0 + "bytes");
    }

    private byte[] expandSecretKeySeed(int r4) {
        if (r4 < 0) goto L8;
        if (r4 >= this.params.getLen()) goto L8;
        return this.khf.PRF(this.secretKeySeed, XMSSUtil.toBytesBigEndian(r4, 32));
    L8:
        throw new IllegalArgumentException("index out of bounds");
    }

    public KeyedHashFunctions getKhf() {
        return this.khf;
    }

    public WOTSPlusParameters getParams() {
        return this.params;
    }

    WOTSPlusPublicKeyParameters getPublicKey(OTSHashAddress r9) {
        Objects.requireNonNull(r9, "otsHashAddress == null");
        byte[][] r0 = new byte[this.params.getLen()][];
        int r2 = 0;
    L4:
        if (r2 >= this.params.getLen()) goto L7;
        r9 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r9.getLayerAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r9.getTreeAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(r9.getOTSAddress()).withChainAddress(r2).withHashAddress(r9.getHashAddress()).withKeyAndMask(r9.getKeyAndMask()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        r0[r2] = chain(expandSecretKeySeed(r2), 0, this.params.getWinternitzParameter() - 1, r9);
        r2 = r2 + 1;
        goto L4
    L7:
        return new WOTSPlusPublicKeyParameters(this.params, r0);
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    public byte[] getWOTSPlusSecretKey(byte[] r6, OTSHashAddress r7) {
        OTSHashAddress r8 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r7.getLayerAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r7.getTreeAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(r7.getOTSAddress()).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        return this.khf.PRF(r6, r8.toByteArray());
    }

    void importKeys(byte[] r3, byte[] r4) {
        Objects.requireNonNull(r3, "secretKeySeed == null");
        if (r3.length != this.params.getTreeDigestSize()) goto L11;
        Objects.requireNonNull(r4, "publicSeed == null");
        if (r4.length != this.params.getTreeDigestSize()) goto L9;
        this.secretKeySeed = r3;
        this.publicSeed = r4;
        return;
    L9:
        throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
    L11:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }
}
