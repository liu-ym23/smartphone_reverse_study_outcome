package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.PBEParametersGenerator;

/* JADX INFO: loaded from: classes7.dex */
public class PKCS12Key implements PBKDFKey {
    private final char[] password;
    private final boolean useWrongZeroLengthConversion;

    public PKCS12Key(char[] r2) {
        this(r2, false);
    }

    public PKCS12Key(char[] r3, boolean r4) {
        if (r3 != null) goto L5;
        r3 = new char[0];
    L5:
        char[] r1 = new char[r3.length];
        this.password = r1;
        this.useWrongZeroLengthConversion = r4;
        System.arraycopy(r3, 0, r1, 0, r3.length);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PKCS12";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.useWrongZeroLengthConversion == false) goto L9;
        if (this.password.length != 0) goto L9;
        return new byte[2];
    L9:
        return PBEParametersGenerator.PKCS12PasswordToBytes(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS12";
    }

    public char[] getPassword() {
        return this.password;
    }
}
