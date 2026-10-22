package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes7.dex */
class LMOtsPrivateKey {
    private final byte[] I;
    private final byte[] masterSecret;
    private final LMOtsParameters parameter;
    private final int q;

    public LMOtsPrivateKey(LMOtsParameters r1, byte[] r2, int r3, byte[] r4) {
        this.parameter = r1;
        this.I = r2;
        this.q = r3;
        this.masterSecret = r4;
    }

    SeedDerive getDerivationFunction() {
        SeedDerive r0 = new SeedDerive(this.I, this.masterSecret, DigestUtil.getDigest(this.parameter.getDigestOID()));
        r0.setQ(this.q);
        return r0;
    }

    public byte[] getI() {
        return this.I;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.q;
    }

    LMSContext getSignatureContext(LMSigParameters r8, byte[][] r9) {
        byte[] r5 = new byte[32];
        SeedDerive r0 = getDerivationFunction();
        r0.setJ(-3);
        r0.deriveSeed(r5, false);
        Digest r4 = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(getI(), r4);
        LmsUtils.u32str(getQ(), r4);
        LmsUtils.u16str(-32383, r4);
        LmsUtils.byteArray(r5, r4);
        return new LMSContext(this, r8, r4, r5, r9);
    }
}
