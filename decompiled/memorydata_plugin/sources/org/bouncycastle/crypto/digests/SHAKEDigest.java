package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes7.dex */
public class SHAKEDigest extends KeccakDigest implements Xof {
    public SHAKEDigest() {
        this(128);
    }

    public SHAKEDigest(int r2) {
        super(checkBitLength(r2), CryptoServicePurpose.ANY);
    }

    private static int checkBitLength(int r3) {
        if (r3 != 128) goto L5;
    L9:
        return r3;
    L5:
        if (r3 == 256) goto L9;
        throw new IllegalArgumentException("'bitStrength' " + r3 + " not supported for SHAKE");
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, this.purpose);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r2, int r3) {
        return doFinal(r2, r3, getDigestSize());
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] r1, int r2, int r3) {
        int r4 = doOutput(r1, r2, r3);
        reset();
        return r4;
    }

    public int doOutput(byte[] r5, int r6, int r7) {
        if (this.squeezing == true) goto L5;
        absorbBits(15, 4);
    L5:
        squeeze(r5, r6, ((long) r7) * 8);
        return r7;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 4;
    }
}
