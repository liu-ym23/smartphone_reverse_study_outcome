package n4a;

import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x0 extends b1 {
    public final String c;
    public final d0 d;
    public final Object[] e;

    public x0(c1 r1, c0 r2, String r3, Object... r4) {
        super(r1);
        this.c = r3;
        this.d = r2;
        this.e = r4;
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r4) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String r5 = f5.d(r4);
        if (TextUtils.isEmpty(r5) == false) goto L12;
        return null;
    L12:
        String r0 = String.format(f5.o(this.c), this.e);     // Catch: Throwable -> L8
    L11:
        return f5.j("{\"pinfo\":\"" + f5.d(this.d.b(f5.j(r0))) + "\",\"els\":[" + r5 + "]}");
    L8:
        th = move-exception;
        th.printStackTrace();
        r.f(th, "ofm", "gpj");
        r0 = NameKeys.UnloadStrategy_No_Strategy;
        goto L11
    }
}
