package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410KeyParameters extends AsymmetricKeyParameter {
    private GOST3410Parameters params;

    public GOST3410KeyParameters(boolean r1, GOST3410Parameters r2) {
        super(r1);
        this.params = r2;
    }

    public GOST3410Parameters getParameters() {
        return this.params;
    }
}
