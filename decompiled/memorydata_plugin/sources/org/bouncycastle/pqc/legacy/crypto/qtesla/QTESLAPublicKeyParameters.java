package org.bouncycastle.pqc.legacy.crypto.qtesla;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class QTESLAPublicKeyParameters extends AsymmetricKeyParameter {
    private byte[] publicKey;
    private int securityCategory;

    public QTESLAPublicKeyParameters(int r3, byte[] r4) {
        super(false);
        if (r4.length != QTESLASecurityCategory.getPublicSize(r3)) goto L7;
        this.securityCategory = r3;
        this.publicKey = Arrays.clone(r4);
        return;
    L7:
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] getPublicData() {
        return Arrays.clone(this.publicKey);
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
