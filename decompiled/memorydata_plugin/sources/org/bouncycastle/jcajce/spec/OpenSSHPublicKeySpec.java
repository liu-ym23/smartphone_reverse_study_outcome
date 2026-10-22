package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class OpenSSHPublicKeySpec extends EncodedKeySpec {
    private static final String[] allowedTypes = null;
    private final String type;

    static {
        allowedTypes = new String[]{"ssh-rsa", "ssh-ed25519", "ssh-dss"};
    }

    public OpenSSHPublicKeySpec(byte[] r5) {
        super(r5);
        int r0 = 0;
        int r1 = (((((r5[0] & 255) << 24) | ((r5[1] & 255) << 16)) | ((r5[2] & 255) << 8)) | (r5[3] & 255)) + 4;
        if (r1 >= r5.length) goto L16;
        String r6 = Strings.fromByteArray(Arrays.copyOfRange(r5, 4, r1));
        this.type = r6;
        if (r6.startsWith("ecdsa") == false) goto L7;
        return;
    L7:
        String[] r7 = allowedTypes;
        if (r0 >= r7.length) goto L14;
        if (r7[r0].equals(this.type) == true) goto L11;
        r0 = r0 + 1;
        goto L7
    L11:
        return;
    L14:
        throw new IllegalArgumentException("unrecognised public key type " + this.type);
    L16:
        throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return "OpenSSH";
    }

    public String getType() {
        return this.type;
    }
}
