package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;

/* JADX INFO: loaded from: classes7.dex */
public class OpenSSHPrivateKeySpec extends EncodedKeySpec {
    private final String format;

    public OpenSSHPrivateKeySpec(byte[] r4) {
        super(r4);
        if (r4[0] != 48) goto L7;
        String r5 = "ASN.1";
    L5:
        this.format = r5;
        return;
    L7:
        if (r4[0] != 111) goto L11;
        r5 = "OpenSSH";
        goto L5
    L11:
        throw new IllegalArgumentException("unknown byte encoding");
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return this.format;
    }
}
