package org.bouncycastle.pqc.crypto.saber;

/* JADX INFO: loaded from: classes7.dex */
class SABEREngine {
    private final int SABER_BYTES_CCA_DEC;
    private final int SABER_ET;
    private final int SABER_INDCPA_PUBLICKEYBYTES;
    private final int SABER_INDCPA_SECRETKEYBYTES;
    private final int SABER_L;
    private final int SABER_MU;
    private final int SABER_POLYBYTES;
    private final int SABER_POLYCOINBYTES;
    private final int SABER_POLYCOMPRESSEDBYTES;
    private final int SABER_POLYVECBYTES;
    private final int SABER_POLYVECCOMPRESSEDBYTES;
    private final int SABER_PUBLICKEYBYTES;
    private final int SABER_SCALEBYTES_KEM;
    private final int SABER_SECRETKEYBYTES;
    private final int defaultKeySize;
    private final int h1;
    private final int h2;
    private final Poly poly;
    private final Utils utils;

    public SABEREngine(int r6, int r7) {
        this.defaultKeySize = r7;
        this.SABER_L = r6;
        int r0 = 3;
        if (r6 != 2) goto L6;
        this.SABER_MU = 10;
    L5:
        this.SABER_ET = r0;
    L9:
        this.SABER_POLYCOINBYTES = (this.SABER_MU * 256) / 8;
        this.SABER_POLYBYTES = 416;
        int r1 = r6 * 416;
        this.SABER_POLYVECBYTES = r1;
        this.SABER_POLYCOMPRESSEDBYTES = 320;
        int r8 = r6 * 320;
        this.SABER_POLYVECCOMPRESSEDBYTES = r8;
        int r3 = this.SABER_ET;
        int r4 = (r3 * 256) / 8;
        this.SABER_SCALEBYTES_KEM = r4;
        int r2 = r8 + 32;
        this.SABER_INDCPA_PUBLICKEYBYTES = r2;
        this.SABER_INDCPA_SECRETKEYBYTES = r1;
        this.SABER_PUBLICKEYBYTES = r2;
        this.SABER_SECRETKEYBYTES = ((r1 + r2) + 32) + 32;
        this.SABER_BYTES_CCA_DEC = r8 + r4;
        this.h1 = 4;
        this.h2 = (256 - (1 << ((10 - r3) - 1))) + 4;
        this.utils = new Utils(this);
        this.poly = new Poly(this);
        return;
    L6:
        if (r6 != 3) goto L8;
        this.SABER_MU = 8;
        this.SABER_ET = 4;
        goto L9
    L8:
        r0 = 6;
        this.SABER_MU = 6;
        goto L5
    }

    public int getSABER_EP() {
        return 10;
    }

    public int getSABER_ET() {
        return this.SABER_ET;
    }

    public int getSABER_KEYBYTES() {
        return 32;
    }

    public int getSABER_L() {
        return this.SABER_L;
    }

    public int getSABER_N() {
        return 256;
    }

    public int getSABER_POLYBYTES() {
        return this.SABER_POLYBYTES;
    }

    public Utils getUtils() {
        return this.utils;
    }
}
