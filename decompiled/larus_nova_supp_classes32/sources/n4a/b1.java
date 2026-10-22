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
public abstract class b1 {
    public final b1 a;
    public byte[] b;

    public b1() {
        this.b = null;
    }

    public b1(b1 r2) {
        this.b = null;
        this.a = r2;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] r0 = b(this.b);
        b1 r1 = this.a;
        if (r1 == null) goto L6;
        r1.b = r0;
        return r1.a();
    L6:
        return r0;
    }

    public abstract byte[] b(byte[] r1) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void c(byte[] r1) {
    }
}
