package org.bouncycastle.pqc.crypto.saber;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    private final int SABER_EP;
    private final int SABER_ET;
    private final int SABER_KEYBYTES;
    private final int SABER_L;
    private final int SABER_N;
    private final int SABER_POLYBYTES;

    public Utils(SABEREngine r2) {
        this.SABER_N = r2.getSABER_N();
        this.SABER_L = r2.getSABER_L();
        this.SABER_ET = r2.getSABER_ET();
        this.SABER_POLYBYTES = r2.getSABER_POLYBYTES();
        this.SABER_EP = r2.getSABER_EP();
        this.SABER_KEYBYTES = r2.getSABER_KEYBYTES();
    }
}
