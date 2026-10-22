package org.bouncycastle.crypto;

import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PBEParametersGenerator {
    protected int iterationCount;
    protected byte[] password;
    protected byte[] salt;

    public PBEParametersGenerator() {
    }

    public static byte[] PKCS12PasswordToBytes(char[] r4) {
        int r0 = 0;
        if (r4 == null) goto L12;
        if (r4.length <= 0) goto L12;
        byte[] r1 = new byte[(r4.length + 1) * 2];
    L8:
        if (r0 == r4.length) goto L10;
        int r2 = r0 * 2;
        r1[r2] = (byte) (r4[r0] >>> '\b');
        r1[r2 + 1] = (byte) r4[r0];
        r0 = r0 + 1;
        goto L8
    L10:
        return r1;
    L12:
        return new byte[0];
    }

    public static byte[] PKCS5PasswordToBytes(char[] r4) {
        int r0 = 0;
        if (r4 == null) goto L9;
        int r1 = r4.length;
        byte[] r2 = new byte[r1];
    L5:
        if (r0 == r1) goto L7;
        r2[r0] = (byte) r4[r0];
        r0 = r0 + 1;
        goto L5
    L7:
        return r2;
    L9:
        return new byte[0];
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] r0) {
        if (r0 == null) goto L6;
        return Strings.toUTF8ByteArray(r0);
    L6:
        return new byte[0];
    }

    public abstract CipherParameters generateDerivedMacParameters(int r1);

    public abstract CipherParameters generateDerivedParameters(int r1);

    public abstract CipherParameters generateDerivedParameters(int r1, int r2);

    public void init(byte[] r1, byte[] r2, int r3) {
        this.password = r1;
        this.salt = r2;
        this.iterationCount = r3;
    }
}
