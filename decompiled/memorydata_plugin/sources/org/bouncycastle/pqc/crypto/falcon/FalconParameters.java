package org.bouncycastle.pqc.crypto.falcon;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class FalconParameters implements CipherParameters {
    public static final FalconParameters falcon_1024 = null;
    public static final FalconParameters falcon_512 = null;
    private final int logn;
    private final String name;
    private final int nonce_length;

    static {
        falcon_512 = new FalconParameters("falcon-512", 9, 40);
        falcon_1024 = new FalconParameters("falcon-1024", 10, 40);
    }

    private FalconParameters(String r2, int r3, int r4) {
        if (r3 < 1) goto L9;
        if (r3 > 10) goto L9;
        this.name = r2;
        this.logn = r3;
        this.nonce_length = r4;
        return;
    L9:
        throw new IllegalArgumentException("Log N degree should be between 1 and 10");
    }

    public int getLogN() {
        return this.logn;
    }

    public String getName() {
        return this.name;
    }
}
