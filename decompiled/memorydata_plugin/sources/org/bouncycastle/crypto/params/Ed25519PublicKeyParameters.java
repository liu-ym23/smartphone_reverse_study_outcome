package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class Ed25519PublicKeyParameters extends AsymmetricKeyParameter {
    private final byte[] data;

    public Ed25519PublicKeyParameters(byte[] r2) {
        this(validate(r2), 0);
    }

    public Ed25519PublicKeyParameters(byte[] r4, int r5) {
        super(false);
        byte[] r2 = new byte[32];
        this.data = r2;
        System.arraycopy(r4, r5, r2, 0, 32);
    }

    private static byte[] validate(byte[] r2) {
        if (r2.length != 32) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public void encode(byte[] r3, int r4) {
        System.arraycopy(this.data, 0, r3, r4, 32);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
