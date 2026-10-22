package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SPHINCSPublicKeyParameters extends SPHINCSKeyParameters {
    private final byte[] keyData;

    public SPHINCSPublicKeyParameters(byte[] r2, String r3) {
        super(false, r3);
        this.keyData = Arrays.clone(r2);
    }

    public byte[] getKeyData() {
        return Arrays.clone(this.keyData);
    }
}
