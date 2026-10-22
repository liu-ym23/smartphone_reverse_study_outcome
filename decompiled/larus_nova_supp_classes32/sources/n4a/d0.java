package n4a;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class d0 {
    public final d0 a;

    public d0() {
    }

    public d0(d0 r1) {
        this.a = r1;
    }

    public abstract byte[] a(byte[] r1) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] b(byte[] r2) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        d0 r0 = this.a;
        if (r0 == null) goto L6;
        r2 = r0.b(r2);
    L6:
        return a(r2);
    }
}
