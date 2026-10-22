package org.bouncycastle.pqc.crypto.crystals.dilithium;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class DilithiumPrivateKeyParameters extends DilithiumKeyParameters {
    final byte[] k;
    final byte[] rho;
    final byte[] s1;
    final byte[] s2;
    final byte[] t0;
    private final byte[] t1;
    final byte[] tr;

    public DilithiumPrivateKeyParameters(DilithiumParameters r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6, byte[] r7, byte[] r8, byte[] r9) {
        super(true, r2);
        this.rho = Arrays.clone(r3);
        this.k = Arrays.clone(r4);
        this.tr = Arrays.clone(r5);
        this.s1 = Arrays.clone(r6);
        this.s2 = Arrays.clone(r7);
        this.t0 = Arrays.clone(r8);
        this.t1 = Arrays.clone(r9);
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(new byte[][]{this.rho, this.k, this.tr, this.s1, this.s2, this.t0});
    }

    public byte[] getK() {
        return Arrays.clone(this.k);
    }

    public byte[] getRho() {
        return Arrays.clone(this.rho);
    }

    public byte[] getS1() {
        return Arrays.clone(this.s1);
    }

    public byte[] getS2() {
        return Arrays.clone(this.s2);
    }

    public byte[] getT0() {
        return Arrays.clone(this.t0);
    }

    public byte[] getT1() {
        return this.t1;
    }

    public byte[] getTr() {
        return Arrays.clone(this.tr);
    }
}
