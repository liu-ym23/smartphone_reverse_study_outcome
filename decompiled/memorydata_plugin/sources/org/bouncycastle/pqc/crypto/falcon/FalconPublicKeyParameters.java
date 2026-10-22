package org.bouncycastle.pqc.crypto.falcon;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class FalconPublicKeyParameters extends FalconKeyParameters {
    private byte[] H;

    public FalconPublicKeyParameters(FalconParameters r2, byte[] r3) {
        super(false, r2);
        this.H = Arrays.clone(r3);
    }

    public byte[] getH() {
        return Arrays.clone(this.H);
    }
}
