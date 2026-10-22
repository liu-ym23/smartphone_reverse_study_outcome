package org.bouncycastle.pqc.crypto.crystals.dilithium;

/* JADX INFO: loaded from: classes7.dex */
public class DilithiumParameters {
    public static final DilithiumParameters dilithium2 = null;
    public static final DilithiumParameters dilithium2_aes = null;
    public static final DilithiumParameters dilithium3 = null;
    public static final DilithiumParameters dilithium3_aes = null;
    public static final DilithiumParameters dilithium5 = null;
    public static final DilithiumParameters dilithium5_aes = null;
    private final int k;
    private final String name;
    private final boolean usingAES;

    static {
        dilithium2 = new DilithiumParameters("dilithium2", 2, false);
        dilithium2_aes = new DilithiumParameters("dilithium2-aes", 2, true);
        dilithium3 = new DilithiumParameters("dilithium3", 3, false);
        dilithium3_aes = new DilithiumParameters("dilithium3-aes", 3, true);
        dilithium5 = new DilithiumParameters("dilithium5", 5, false);
        dilithium5_aes = new DilithiumParameters("dilithium5-aes", 5, true);
    }

    private DilithiumParameters(String r1, int r2, boolean r3) {
        this.name = r1;
        this.k = r2;
        this.usingAES = r3;
    }

    public String getName() {
        return this.name;
    }
}
