package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class Ed448PrivateKeyParameters extends AsymmetricKeyParameter {
    private Ed448PublicKeyParameters cachedPublicKey;
    private final byte[] data;

    public Ed448PrivateKeyParameters(byte[] r2) {
        this(validate(r2), 0);
    }

    public Ed448PrivateKeyParameters(byte[] r3, int r4) {
        super(true);
        byte[] r1 = new byte[57];
        this.data = r1;
        System.arraycopy(r3, r4, r1, 0, 57);
    }

    private static byte[] validate(byte[] r2) {
        if (r2.length != 57) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    public Ed448PublicKeyParameters generatePublicKey() {
        byte[] r0 = this.data;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.cachedPublicKey != null) goto L7;
        byte[] r1 = new byte[57];     // Catch: Throwable -> L10
        Ed448.generatePublicKey(this.data, 0, r1, 0);     // Catch: Throwable -> L10
        this.cachedPublicKey = new Ed448PublicKeyParameters(r1, 0);     // Catch: Throwable -> L10
    L7:
        Ed448PublicKeyParameters r4 = this.cachedPublicKey;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }
}
