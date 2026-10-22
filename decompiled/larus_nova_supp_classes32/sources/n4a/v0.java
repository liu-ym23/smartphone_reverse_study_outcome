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
public final class v0 extends b1 {
    public final f0 c;

    public v0(a1 r1) {
        super(r1);
        this.c = new f0();
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r2) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.c.b(r2);
    }
}
