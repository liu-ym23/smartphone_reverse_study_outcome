package org.bouncycastle.pqc.crypto.saber;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class SABERParameters implements CipherParameters {
    public static final SABERParameters firesaberkem128r3 = null;
    public static final SABERParameters firesaberkem192r3 = null;
    public static final SABERParameters firesaberkem256r3 = null;
    public static final SABERParameters lightsaberkem128r3 = null;
    public static final SABERParameters lightsaberkem192r3 = null;
    public static final SABERParameters lightsaberkem256r3 = null;
    public static final SABERParameters saberkem128r3 = null;
    public static final SABERParameters saberkem192r3 = null;
    public static final SABERParameters saberkem256r3 = null;
    private final int defaultKeySize;
    private final SABEREngine engine;
    private final int l;
    private final String name;

    static {
        lightsaberkem128r3 = new SABERParameters("lightsaberkem128r3", 2, 128);
        saberkem128r3 = new SABERParameters("saberkem128r3", 3, 128);
        firesaberkem128r3 = new SABERParameters("firesaberkem128r3", 4, 128);
        lightsaberkem192r3 = new SABERParameters("lightsaberkem192r3", 2, 192);
        saberkem192r3 = new SABERParameters("saberkem192r3", 3, 192);
        firesaberkem192r3 = new SABERParameters("firesaberkem192r3", 4, 192);
        lightsaberkem256r3 = new SABERParameters("lightsaberkem256r3", 2, 256);
        saberkem256r3 = new SABERParameters("saberkem256r3", 3, 256);
        firesaberkem256r3 = new SABERParameters("firesaberkem256r3", 4, 256);
    }

    public SABERParameters(String r1, int r2, int r3) {
        this.name = r1;
        this.l = r2;
        this.defaultKeySize = r3;
        this.engine = new SABEREngine(r2, r3);
    }

    public String getName() {
        return this.name;
    }
}
