package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class X448PrivateKeyParameters extends AsymmetricKeyParameter {
    private final byte[] data;

    public X448PrivateKeyParameters(byte[] r2) {
        this(validate(r2), 0);
    }

    public X448PrivateKeyParameters(byte[] r3, int r4) {
        super(true);
        byte[] r1 = new byte[56];
        this.data = r1;
        System.arraycopy(r3, r4, r1, 0, 56);
    }

    private static byte[] validate(byte[] r2) {
        if (r2.length != 56) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("'buf' must have length 56");
    }

    public X448PublicKeyParameters generatePublicKey() {
        byte[] r0 = new byte[56];
        X448.generatePublicKey(this.data, 0, r0, 0);
        return new X448PublicKeyParameters(r0, 0);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
