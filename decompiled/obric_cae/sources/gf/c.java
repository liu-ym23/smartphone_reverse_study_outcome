package gf;

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

/* JADX INFO: loaded from: classes2.dex */
public final class c implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7831a = null;

    static {
        f7831a = new c();
    }

    public static ArrayList a(X509Certificate r8) {
        List<String> r10 = b(r8, 7);
        List<String> r11 = b(r8, 2);
        int r12 = r10.size();
        ArrayList r13 = new ArrayList(r11.size() + r12);
        r13.addAll(r10);
        r13.addAll(r11);
        return r13;
    }

    public static List<String> b(X509Certificate r8, int r10) {
        ArrayList r11 = new ArrayList();
        Collection<List<?>> r12 = r8.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L25
        if (r12 == null) goto L6;
        Iterator<List<?>> r13 = r12.iterator();     // Catch: CertificateParsingException -> L25
    L9:
        if (r13.hasNext() == false) goto L24;
        List<?> r14 = r13.next();     // Catch: CertificateParsingException -> L25
        if (r14 == null) goto L9;
        if (r14.size() < 2) goto L9;
        Integer r15 = (Integer) r14.get(0);     // Catch: CertificateParsingException -> L25
        if (r15 == null) goto L9;
        if (r15.intValue() != r10) goto L9;
        String r16 = (String) r14.get(1);     // Catch: CertificateParsingException -> L25
        if (r16 == null) goto L9;
        r11.add(r16);     // Catch: CertificateParsingException -> L25
        goto L9
    L24:
        return r11;
    L6:
        return Collections.emptyList();
    L26:
        return Collections.emptyList();
    }

    public static boolean c(String r8, X509Certificate r10) {
        boolean r11 = xe.c.f13896q.matcher(r8).matches();     // Catch: IllegalArgumentException -> L5
    L8:
        if (r11 == false) goto L15;
        List<String> r12 = b(r10, 7);
        int r13 = r12.size();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L79;
        if (r8.equalsIgnoreCase(r12.get(r14)) == true) goto L68;
        r14 = r14 + 1;
    L68:
        return true;
    L79:
        return false;
    L15:
        String r15 = r8.toLowerCase(Locale.US);
        Iterator<String> r16 = b(r10, 2).iterator();
    L17:
        if (r16.hasNext() == false) goto L80;
        String r17 = r16.next();
        if (r15 != null) goto L21;
    L65:
        boolean r18 = false;
    L66:
        if (r18 == false) goto L17;
    L21:
        if (r15.length() == 0) goto L65;
        if (r15.startsWith(".") == true) goto L65;
        if (r15.endsWith("..") == true) goto L65;
        if (r17 == null) goto L65;
        if (r17.length() == 0) goto L65;
        if (r17.startsWith(".") == true) goto L65;
        if (r17.endsWith("..") == true) goto L65;
        if (r15.endsWith(".") == true) goto L38;
        String r19 = r15.concat(".");
    L40:
        if (r17.endsWith(".") == true) goto L42;
        r17 = r17.concat(".");
    L42:
        String r20 = r17.toLowerCase(Locale.US);
        if (r20.contains("*") == true) goto L46;
        r18 = r19.equals(r20);
        goto L66
    L46:
        if (r20.startsWith("*.") == false) goto L65;
        if (r20.indexOf(42, 1) != (-1)) goto L65;
        if (r19.length() < r20.length()) goto L65;
        if ("*.".equals(r20) == true) goto L65;
        String r21 = r20.substring(1);
        if (r19.endsWith(r21) == false) goto L65;
        int r22 = r19.length() - r21.length();
        if (r22 > 0) goto L62;
    L64:
        r18 = true;
        goto L66
    L62:
        if (r19.lastIndexOf(46, r22 - 1) == (-1)) goto L64;
    L38:
        r19 = r15;
        goto L40
    L80:
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r11 = false;
        goto L8
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String r8, SSLSession r10) {
        return c(r8, (X509Certificate) r10.getPeerCertificates()[0]);
    L8:
        return false;
    }
}
