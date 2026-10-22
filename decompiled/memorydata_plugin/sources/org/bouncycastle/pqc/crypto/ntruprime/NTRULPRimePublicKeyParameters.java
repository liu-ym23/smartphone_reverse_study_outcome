package org.bouncycastle.pqc.crypto.ntruprime;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class NTRULPRimePublicKeyParameters extends NTRULPRimeKeyParameters {
    private final byte[] roundEncA;
    private final byte[] seed;

    public NTRULPRimePublicKeyParameters(NTRULPRimeParameters r2, byte[] r3) {
        super(false, r2);
        byte[] r4 = Arrays.copyOfRange(r3, 0, 32);
        this.seed = r4;
        this.roundEncA = Arrays.copyOfRange(r3, r4.length, r3.length);
    }

    public byte[] getEncoded() {
        byte[] r0 = new byte[getParameters().getPublicKeyBytes()];
        byte[] r1 = this.seed;
        System.arraycopy(r1, 0, r0, 0, r1.length);
        byte[] r2 = this.roundEncA;
        System.arraycopy(r2, 0, r0, this.seed.length, r2.length);
        return r0;
    }
}
