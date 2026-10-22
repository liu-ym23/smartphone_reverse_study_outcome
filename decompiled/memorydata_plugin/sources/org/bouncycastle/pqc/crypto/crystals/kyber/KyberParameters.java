package org.bouncycastle.pqc.crypto.crystals.kyber;

/* JADX INFO: loaded from: classes7.dex */
public class KyberParameters {
    public static final KyberParameters kyber1024 = null;
    public static final KyberParameters kyber1024_aes = null;
    public static final KyberParameters kyber512 = null;
    public static final KyberParameters kyber512_aes = null;
    public static final KyberParameters kyber768 = null;
    public static final KyberParameters kyber768_aes = null;
    private final int k;
    private final String name;
    private final int sessionKeySize;
    private final boolean usingAes;

    static {
        kyber512 = new KyberParameters("kyber512", 2, 128, false);
        kyber768 = new KyberParameters("kyber768", 3, 192, false);
        kyber1024 = new KyberParameters("kyber1024", 4, 256, false);
        kyber512_aes = new KyberParameters("kyber512-aes", 2, 128, true);
        kyber768_aes = new KyberParameters("kyber768-aes", 3, 192, true);
        kyber1024_aes = new KyberParameters("kyber1024-aes", 4, 256, true);
    }

    private KyberParameters(String r1, int r2, int r3, boolean r4) {
        this.name = r1;
        this.k = r2;
        this.sessionKeySize = r3;
        this.usingAes = r4;
    }

    public String getName() {
        return this.name;
    }
}
