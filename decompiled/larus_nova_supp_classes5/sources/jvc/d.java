package jvc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements HostnameVerifier {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static List<String> a(X509Certificate r4) {
        List<String> r0 = b(r4, 7);
        List<String> r5 = b(r4, 2);
        ArrayList r1 = new ArrayList(r0.size() + r5.size());
        r1.addAll(r0);
        r1.addAll(r5);
        return r1;
    }

    public static List<String> b(X509Certificate r4, int r5) {
        ArrayList r0 = new ArrayList();
        Collection<List<?>> r6 = r4.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L25
        if (r6 == null) goto L6;
        Iterator<List<?>> r7 = r6.iterator();     // Catch: CertificateParsingException -> L25
    L9:
        if (r7.hasNext() == false) goto L24;
        List<?> r1 = r7.next();     // Catch: CertificateParsingException -> L25
        if (r1 == null) goto L9;
        if (r1.size() < 2) goto L9;
        Integer r2 = (Integer) ListProtector.get(r1, 0);     // Catch: CertificateParsingException -> L25
        if (r2 == null) goto L9;
        if (r2.intValue() != r5) goto L9;
        String r3 = (String) ListProtector.get(r1, 1);     // Catch: CertificateParsingException -> L25
        if (r3 == null) goto L9;
        r0.add(r3);     // Catch: CertificateParsingException -> L25
        goto L9
    L24:
        return r0;
    L6:
        return Collections.emptyList();
    L26:
        return Collections.emptyList();
    }

    public static boolean c(String r8, X509Certificate r9) {
        if (cvc.c.x(r8) == false) goto L10;
        List<String> r10 = b(r9, 7);
        int r0 = r10.size();
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L72;
        if (r8.equalsIgnoreCase((String) ListProtector.get(r10, r3)) == true) goto L62;
        r3 = r3 + 1;
    L62:
        return true;
    L72:
        return false;
    L10:
        String r11 = r8.toLowerCase(Locale.US);
        Iterator<String> r12 = b(r9, 2).iterator();
    L12:
        if (r12.hasNext() == false) goto L73;
        String r1 = r12.next();
        if (r11 != null) goto L16;
    L60:
        boolean r2 = false;
    L61:
        if (r2 == false) goto L12;
    L16:
        if (r11.length() == 0) goto L60;
        if (r11.startsWith(".") == true) goto L60;
        if (r11.endsWith(DownloadConstants.VULNERABILITY_PATH) == true) goto L60;
        if (r1 == null) goto L60;
        if (r1.length() == 0) goto L60;
        if (r1.startsWith(".") == true) goto L60;
        if (r1.endsWith(DownloadConstants.VULNERABILITY_PATH) == true) goto L60;
        if (r11.endsWith(".") == true) goto L33;
        String r4 = r11.concat(".");
    L35:
        if (r1.endsWith(".") == true) goto L37;
        r1 = r1.concat(".");
    L37:
        String r5 = r1.toLowerCase(Locale.US);
        if (r5.contains("*") == true) goto L41;
        r2 = r4.equals(r5);
        goto L61
    L41:
        if (r5.startsWith("*.") == false) goto L60;
        if (r5.indexOf(42, 1) != (-1)) goto L60;
        if (r4.length() < r5.length()) goto L60;
        if ("*.".equals(r5) == true) goto L60;
        String r6 = r5.substring(1);
        if (r4.endsWith(r6) == false) goto L60;
        int r7 = r4.length() - r6.length();
        if (r7 > 0) goto L57;
    L59:
        r2 = true;
        goto L61
    L57:
        if (r4.lastIndexOf(46, r7 - 1) == (-1)) goto L59;
    L33:
        r4 = r11;
        goto L35
    L73:
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String r2, SSLSession r3) {
        return c(r2, (X509Certificate) r3.getPeerCertificates()[0]);
    L5:
        return false;
    }
}
