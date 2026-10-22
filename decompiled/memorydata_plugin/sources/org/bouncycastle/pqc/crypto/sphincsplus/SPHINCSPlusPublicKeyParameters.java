package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SPHINCSPlusPublicKeyParameters extends SPHINCSPlusKeyParameters {
    private final PK pk;

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters r4, byte[] r5) {
        super(false, r4);
        int r6 = r4.getN();
        int r2 = r6 * 2;
        if (r5.length != r2) goto L7;
        this.pk = new PK(Arrays.copyOfRange(r5, 0, r6), Arrays.copyOfRange(r5, r6, r2));
        return;
    L7:
        throw new IllegalArgumentException("public key encoding does not match parameters");
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue()), this.pk.seed, this.pk.root);
    }
}
