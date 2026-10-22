package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;

/* JADX INFO: loaded from: classes7.dex */
public class SHA3Digest extends KeccakDigest {
    public SHA3Digest() {
        this(256, CryptoServicePurpose.ANY);
    }

    public SHA3Digest(int r2) {
        super(checkBitLength(r2), CryptoServicePurpose.ANY);
    }

    public SHA3Digest(int r1, CryptoServicePurpose r2) {
        super(checkBitLength(r1), r2);
    }

    private static int checkBitLength(int r3) {
        if (r3 != 224) goto L5;
    L13:
        return r3;
    L5:
        if (r3 == 256) goto L13;
        if (r3 == 384) goto L13;
        if (r3 == 512) goto L13;
        throw new IllegalArgumentException("'bitLength' " + r3 + " not supported for SHA-3");
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r2, int r3) {
        absorbBits(2, 2);
        return super.doFinal(r2, r3);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA3-" + this.fixedOutputLength;
    }
}
