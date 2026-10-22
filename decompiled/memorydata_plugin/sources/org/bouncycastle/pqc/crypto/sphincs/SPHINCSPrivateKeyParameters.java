package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SPHINCSPrivateKeyParameters extends SPHINCSKeyParameters {
    private final byte[] keyData;

    public SPHINCSPrivateKeyParameters(byte[] r2, String r3) {
        super(true, r3);
        this.keyData = Arrays.clone(r2);
    }

    public byte[] getKeyData() {
        return Arrays.clone(this.keyData);
    }
}
