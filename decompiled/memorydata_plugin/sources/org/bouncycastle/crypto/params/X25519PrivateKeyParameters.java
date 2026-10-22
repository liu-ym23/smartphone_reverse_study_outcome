package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class X25519PrivateKeyParameters extends AsymmetricKeyParameter {
    private final byte[] data;

    public X25519PrivateKeyParameters(byte[] r2) {
        this(validate(r2), 0);
    }

    public X25519PrivateKeyParameters(byte[] r3, int r4) {
        super(true);
        byte[] r1 = new byte[32];
        this.data = r1;
        System.arraycopy(r3, r4, r1, 0, 32);
    }

    private static byte[] validate(byte[] r2) {
        if (r2.length != 32) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public X25519PublicKeyParameters generatePublicKey() {
        byte[] r0 = new byte[32];
        X25519.generatePublicKey(this.data, 0, r0, 0);
        return new X25519PublicKeyParameters(r0, 0);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
