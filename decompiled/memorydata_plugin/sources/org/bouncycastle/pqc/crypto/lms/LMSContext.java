package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes7.dex */
public class LMSContext implements Digest {
    private final byte[] C;
    private volatile Digest digest;
    private final LMOtsPrivateKey key;
    private final byte[][] path;
    private final LMOtsPublicKey publicKey;
    private final LMSigParameters sigParams;
    private final Object signature;

    public LMSContext(LMOtsPrivateKey r3, LMSigParameters r4, Digest r5, byte[] r6, byte[][] r7) {
        Digest r8 = (Digest) ZeusTransformUtils.wrapperContextForParams(r5, Digest.class, "com.obric.memorydata.plugin");
        this.key = r3;
        this.sigParams = r4;
        this.digest = r8;
        this.C = r6;
        this.path = r7;
        this.publicKey = null;
        this.signature = null;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r1, int r2) {
        return this.digest.doFinal(r1, r2);
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.digest.getAlgorithmName();
    }

    byte[] getC() {
        return this.C;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digest.getDigestSize();
    }

    byte[][] getPath() {
        return this.path;
    }

    LMOtsPrivateKey getPrivateKey() {
        return this.key;
    }

    byte[] getQ() {
        byte[] r0 = new byte[34];
        this.digest.doFinal(r0, 0);
        this.digest = null;
        return r0;
    }

    LMSigParameters getSigParams() {
        return this.sigParams;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.digest.reset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r1) {
        this.digest.update(r1);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r1, int r2, int r3) {
        this.digest.update(r1, r2, r3);
    }
}
