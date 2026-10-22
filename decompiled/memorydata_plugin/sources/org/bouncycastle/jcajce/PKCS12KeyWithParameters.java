package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class PKCS12KeyWithParameters extends PKCS12Key implements PBEKey {
    private final int iterationCount;
    private final byte[] salt;

    public PKCS12KeyWithParameters(char[] r1, boolean r2, byte[] r3, int r4) {
        super(r1, r2);
        this.salt = Arrays.clone(r3);
        this.iterationCount = r4;
    }

    public PKCS12KeyWithParameters(char[] r1, byte[] r2, int r3) {
        super(r1);
        this.salt = Arrays.clone(r2);
        this.iterationCount = r3;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        return this.iterationCount;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        return this.salt;
    }
}
