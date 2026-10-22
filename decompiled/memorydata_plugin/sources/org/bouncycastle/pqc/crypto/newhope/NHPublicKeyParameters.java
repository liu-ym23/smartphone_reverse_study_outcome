package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class NHPublicKeyParameters extends AsymmetricKeyParameter {
    final byte[] pubData;

    public NHPublicKeyParameters(byte[] r2) {
        super(false);
        this.pubData = Arrays.clone(r2);
    }

    public byte[] getPubData() {
        return Arrays.clone(this.pubData);
    }
}
