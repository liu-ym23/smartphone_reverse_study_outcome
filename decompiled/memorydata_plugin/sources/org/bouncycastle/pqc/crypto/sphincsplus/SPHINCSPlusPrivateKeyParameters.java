package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SPHINCSPlusPrivateKeyParameters extends SPHINCSPlusKeyParameters {
    final PK pk;
    final SK sk;

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters r6, byte[] r7) {
        super(true, r6);
        int r8 = r6.getN();
        int r1 = r8 * 4;
        if (r7.length != r1) goto L7;
        int r3 = r8 * 2;
        this.sk = new SK(Arrays.copyOfRange(r7, 0, r8), Arrays.copyOfRange(r7, r8, r3));
        int r9 = r8 * 3;
        this.pk = new PK(Arrays.copyOfRange(r7, r3, r9), Arrays.copyOfRange(r7, r9, r1));
        return;
    L7:
        throw new IllegalArgumentException("private key encoding does not match parameters");
    }

    public byte[] getEncoded() {
        return Arrays.concatenate(Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue()), Arrays.concatenate(this.sk.seed, this.sk.prf, this.pk.seed, this.pk.root));
    }

    public byte[] getEncodedPublicKey() {
        return Arrays.concatenate(Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue()), this.pk.seed, this.pk.root);
    }

    public byte[] getPublicKey() {
        return Arrays.concatenate(this.pk.seed, this.pk.root);
    }
}
