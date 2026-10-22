package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes7.dex */
public class DSAKeyParameters extends AsymmetricKeyParameter {
    private DSAParameters params;

    public DSAKeyParameters(boolean r1, DSAParameters r2) {
        super(r1);
        this.params = r2;
    }

    public DSAParameters getParameters() {
        return this.params;
    }
}
