package org.bouncycastle.pqc.crypto.crystals.dilithium;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class DilithiumPublicKeyParameters extends DilithiumKeyParameters {
    final byte[] rho;
    final byte[] t1;

    public DilithiumPublicKeyParameters(DilithiumParameters r2, byte[] r3) {
        super(false, r2);
        this.rho = Arrays.copyOfRange(r3, 0, 32);
        this.t1 = Arrays.copyOfRange(r3, 32, r3.length);
    }

    public DilithiumPublicKeyParameters(DilithiumParameters r2, byte[] r3, byte[] r4) {
        super(false, r2);
        this.rho = Arrays.clone(r3);
        this.t1 = Arrays.clone(r4);
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(this.rho, this.t1);
    }

    public byte[] getRho() {
        return Arrays.clone(this.rho);
    }

    public byte[] getT1() {
        return Arrays.clone(this.t1);
    }
}
