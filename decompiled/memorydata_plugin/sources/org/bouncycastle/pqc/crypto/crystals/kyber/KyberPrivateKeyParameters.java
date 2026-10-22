package org.bouncycastle.pqc.crypto.crystals.kyber;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class KyberPrivateKeyParameters extends KyberKeyParameters {
    final byte[] hpk;
    final byte[] nonce;
    final byte[] rho;
    final byte[] s;
    final byte[] t;

    public KyberPrivateKeyParameters(KyberParameters r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6, byte[] r7) {
        super(true, r2);
        this.s = Arrays.clone(r3);
        this.hpk = Arrays.clone(r4);
        this.nonce = Arrays.clone(r5);
        this.t = Arrays.clone(r6);
        this.rho = Arrays.clone(r7);
    }

    public byte[] getEncoded() {
        return getPrivateKey();
    }

    public byte[] getHPK() {
        return Arrays.clone(this.hpk);
    }

    public byte[] getNonce() {
        return Arrays.clone(this.nonce);
    }

    public byte[] getPrivateKey() {
        return Arrays.concatenate(this.s, getPublicKey(), this.hpk, this.nonce);
    }

    public byte[] getPublicKey() {
        return Arrays.concatenate(this.t, this.rho);
    }

    public byte[] getRho() {
        return Arrays.clone(this.rho);
    }

    public byte[] getS() {
        return Arrays.clone(this.s);
    }

    public byte[] getT() {
        return Arrays.clone(this.t);
    }
}
