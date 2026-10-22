package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class X448PublicKeyParameters extends AsymmetricKeyParameter {
    private final byte[] data;

    public X448PublicKeyParameters(byte[] r2) {
        this(validate(r2), 0);
    }

    public X448PublicKeyParameters(byte[] r4, int r5) {
        super(false);
        byte[] r2 = new byte[56];
        this.data = r2;
        System.arraycopy(r4, r5, r2, 0, 56);
    }

    private static byte[] validate(byte[] r2) {
        if (r2.length != 56) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("'buf' must have length 56");
    }

    public void encode(byte[] r3, int r4) {
        System.arraycopy(this.data, 0, r3, r4, 56);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
