package org.bouncycastle.pqc.crypto.ntruprime;

import com.ss.bduploader.BDVideoUploaderBase;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class SNTRUPrimeParameters implements CipherParameters {
    public static final SNTRUPrimeParameters sntrup1013 = null;
    public static final SNTRUPrimeParameters sntrup1277 = null;
    public static final SNTRUPrimeParameters sntrup653 = null;
    public static final SNTRUPrimeParameters sntrup761 = null;
    public static final SNTRUPrimeParameters sntrup857 = null;
    public static final SNTRUPrimeParameters sntrup953 = null;
    private final String name;
    private final int p;
    private final int privateKeyBytes;
    private final int publicKeyBytes;
    private final int q;
    private final int roundedPolynomialBytes;
    private final int rqPolynomialBytes;
    private final int sharedKeyBytes;
    private final int w;

    static {
        sntrup653 = new SNTRUPrimeParameters("sntrup653", 653, 4621, 288, 994, 865, 994, 1518, 16);
        sntrup761 = new SNTRUPrimeParameters("sntrup761", 761, 4591, 286, 1158, 1007, 1158, 1763, 16);
        sntrup857 = new SNTRUPrimeParameters("sntrup857", 857, 5167, 322, 1322, 1152, 1322, 1999, 16);
        sntrup953 = new SNTRUPrimeParameters("sntrup953", 953, 6343, 396, 1505, 1317, 1505, 2254, 24);
        sntrup1013 = new SNTRUPrimeParameters("sntrup1013", 1013, 7177, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, 1623, 1423, 1623, 2417, 24);
        sntrup1277 = new SNTRUPrimeParameters("sntrup1277", 1277, 7879, 492, 2067, 1815, 2067, 3059, 32);
    }

    private SNTRUPrimeParameters(String r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.name = r1;
        this.p = r2;
        this.q = r3;
        this.w = r4;
        this.rqPolynomialBytes = r5;
        this.roundedPolynomialBytes = r6;
        this.publicKeyBytes = r7;
        this.privateKeyBytes = r8;
        this.sharedKeyBytes = r9;
    }

    public String getName() {
        return this.name;
    }

    public int getPrivateKeyBytes() {
        return this.privateKeyBytes;
    }
}
