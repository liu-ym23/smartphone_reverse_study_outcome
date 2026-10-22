package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
final class WOTSPlusPublicKeyParameters {
    private final byte[][] publicKey;

    public WOTSPlusPublicKeyParameters(WOTSPlusParameters r4, byte[][] r5) {
        Objects.requireNonNull(r4, "params == null");
        Objects.requireNonNull(r5, "publicKey == null");
        if (XMSSUtil.hasNullPointer(r5) == true) goto L19;
        if (r5.length != r4.getLen()) goto L17;
        int r0 = 0;
    L8:
        if (r0 >= r5.length) goto L14;
        if (r5[r0].length != r4.getTreeDigestSize()) goto L13;
        r0 = r0 + 1;
        goto L8
    L13:
        throw new IllegalArgumentException("wrong publicKey format");
    L14:
        this.publicKey = XMSSUtil.cloneArray(r5);
        return;
    L17:
        throw new IllegalArgumentException("wrong publicKey size");
    L19:
        throw new NullPointerException("publicKey byte array == null");
    }

    public byte[][] toByteArray() {
        return XMSSUtil.cloneArray(this.publicKey);
    }
}
