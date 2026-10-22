package t8;

import java.io.ByteArrayOutputStream;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(List r8) {
        if (r8 == null) goto L24;
        if (r8.isEmpty() == true) goto L24;
        if (3 > r8.size()) goto L24;
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        Iterator r11 = r8.iterator();
        int r12 = 0;
    L9:
        if (r11.hasNext() == false) goto L22;
        Certificate r13 = (Certificate) r11.next();
        if (r12 >= 3) goto L22;
        if (r13 == null) goto L20;
        r10.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r14 = Base64.getEncoder().encodeToString(r13.getEncoded());
        int r15 = 0;
    L16:
        if (r15 >= r14.length()) goto L18;
        int r16 = r15 + 64;
        r10.write(r14.substring(r15, Math.min(r16, r14.length())).getBytes());
        r15 = r16;
        goto L16
    L18:
        r10.write("\\n".getBytes());
        r10.write("-----END CERTIFICATE-----\\n".getBytes());
        r12 = r12 + 1;
        goto L9
    L20:
        throw new IllegalArgumentException(defpackage.a.d("Certificate is null at index ", r12));
    L22:
        return r10.toString();
    L24:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }
}
