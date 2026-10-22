package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class AsymmetricKeyParameter implements CipherParameters {
    boolean privateKey;

    public AsymmetricKeyParameter(boolean r1) {
        this.privateKey = r1;
    }

    public boolean isPrivate() {
        return this.privateKey;
    }
}
