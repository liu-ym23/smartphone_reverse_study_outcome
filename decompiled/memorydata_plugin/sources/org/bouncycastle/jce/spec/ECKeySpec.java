package org.bouncycastle.jce.spec;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class ECKeySpec implements KeySpec {
    private ECParameterSpec spec;

    public ECParameterSpec getParams() {
        return this.spec;
    }
}
