package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class NHPrivateKeyParameters extends AsymmetricKeyParameter {
    final short[] secData;

    public NHPrivateKeyParameters(short[] r2) {
        super(true);
        this.secData = Arrays.clone(r2);
    }

    public short[] getSecData() {
        return Arrays.clone(this.secData);
    }
}
