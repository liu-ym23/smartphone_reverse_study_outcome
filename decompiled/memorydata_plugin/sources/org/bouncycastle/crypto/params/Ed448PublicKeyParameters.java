package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class Ed448PublicKeyParameters extends AsymmetricKeyParameter {
    private final byte[] data;

    public Ed448PublicKeyParameters(byte[] r2) {
        this(validate(r2), 0);
    }

    public Ed448PublicKeyParameters(byte[] r4, int r5) {
        super(false);
        byte[] r2 = new byte[57];
        this.data = r2;
        System.arraycopy(r4, r5, r2, 0, 57);
    }

    private static byte[] validate(byte[] r2) {
        if (r2.length != 57) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    public void encode(byte[] r3, int r4) {
        System.arraycopy(this.data, 0, r3, r4, 57);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
