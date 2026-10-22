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
public final class f0 extends d0 {
    public f0() {
    }

    public f0(e0 r1) {
        super(r1);
    }

    @Override // n4a.d0
    public final byte[] a(byte[] r1) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return y4.a(r1);
    }
}
