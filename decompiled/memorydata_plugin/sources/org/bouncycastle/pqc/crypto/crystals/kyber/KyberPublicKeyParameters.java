package org.bouncycastle.pqc.crypto.crystals.kyber;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class KyberPublicKeyParameters extends KyberKeyParameters {
    final byte[] rho;
    final byte[] t;

    public KyberPublicKeyParameters(KyberParameters r2, byte[] r3) {
        super(false, r2);
        this.t = Arrays.copyOfRange(r3, 0, r3.length - 32);
        this.rho = Arrays.copyOfRange(r3, r3.length - 32, r3.length);
    }

    public KyberPublicKeyParameters(KyberParameters r2, byte[] r3, byte[] r4) {
        super(false, r2);
        this.t = Arrays.clone(r3);
        this.rho = Arrays.clone(r4);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return Arrays.concatenate(this.t, this.rho);
    }

    public byte[] getRho() {
        return Arrays.clone(this.rho);
    }

    public byte[] getT() {
        return Arrays.clone(this.t);
    }
}
