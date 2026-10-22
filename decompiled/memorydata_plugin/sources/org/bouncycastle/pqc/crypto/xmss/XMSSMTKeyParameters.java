package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes7.dex */
public class XMSSMTKeyParameters extends AsymmetricKeyParameter {
    private final String treeDigest;

    public XMSSMTKeyParameters(boolean r1, String r2) {
        super(r1);
        this.treeDigest = r2;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
