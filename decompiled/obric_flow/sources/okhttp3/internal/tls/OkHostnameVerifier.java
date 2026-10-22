package okhttp3.internal.tls;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\bH\u0002J\f\u0010\u0018\u001a\u00020\u000e*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "asciiToLowercase", "isAscii", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = null;

    static {
        INSTANCE = new OkHostnameVerifier();
    }

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String r5) {
        if (isAscii(r5) == false) goto L9;
        Locale r10 = Locale.US;
        if (r5 == null) goto L8;
        return r5.toLowerCase(r10);
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        return r5;
    }

    private final List<String> getSubjectAltNames(X509Certificate r5, int r10) {
        Collection<List<?>> r11 = r5.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L21
        if (r11 == null) goto L20;
        ArrayList r12 = new ArrayList();     // Catch: CertificateParsingException -> L21
        Iterator<List<?>> r13 = r11.iterator();     // Catch: CertificateParsingException -> L21
    L6:
        if (r13.hasNext() == false) goto L18;
        List<?> r14 = r13.next();     // Catch: CertificateParsingException -> L21
        if (r14 == null) goto L6;
        if (r14.size() < 2) goto L6;
        if (Intrinsics.areEqual(r14.get(0), Integer.valueOf(r10)) == false) goto L6;
        Object r15 = r14.get(1);     // Catch: CertificateParsingException -> L21
        if (r15 == null) goto L6;
        r12.add((String) r15);     // Catch: CertificateParsingException -> L21
        goto L6
    L18:
        return r12;
    L20:
        return CollectionsKt.emptyList();
    L22:
        return CollectionsKt.emptyList();
    }

    private final boolean isAscii(String r13) {
        int r12 = r13.length();
        int r5 = r13.length();
        Intrinsics.checkNotNullParameter(r13, "$this$utf8Size");
        if (r5 < 0) goto L41;
        if (r5 > r13.length()) goto L38;
        long r10 = 0;
        int r11 = 0;
    L7:
        if (r11 >= r5) goto L35;
        char r14 = r13.charAt(r11);
        if (r14 < 128) goto L10;
        if (r14 < 2048) goto L14;
        if (r14 < 55296) goto L33;
        if (r14 > 57343) goto L33;
        int r15 = r11 + 1;
        if (r15 >= r5) goto L24;
        char r16 = r13.charAt(r15);
    L26:
        if (r14 > 56319) goto L32;
        if (r16 < 56320) goto L32;
        if (r16 > 57343) goto L32;
        r10 = r10 + ((long) 4);
        r11 = r11 + 2;
    L32:
        r10 = r10 + 1;
        r11 = r15;
        goto L7
    L24:
        r16 = 0;
    L33:
        int r17 = 3;
    L15:
        r10 = r10 + ((long) r17);
    L11:
        r11 = r11 + 1;
        goto L7
    L14:
        r17 = 2;
        goto L15
    L10:
        r10 = r10 + 1;
        goto L11
    L35:
        if (r12 != ((int) r10)) goto L56;
        return true;
    L56:
        return false;
    L38:
        StringBuilder r18 = j0.s(r5, "endIndex > string.length: ", " > ");
        r18.append(r13.length());
        throw new IllegalArgumentException(r18.toString().toString());
    L41:
        throw new IllegalArgumentException(j0.f(r5, 0, "endIndex < beginIndex: ", " < ").toString());
    }

    private final boolean verifyHostname(String r5, X509Certificate r10) {
        String r11 = asciiToLowercase(r5);
        List<String> r12 = getSubjectAltNames(r10, 2);
        if (r12 != null) goto L5;
    L7:
        Iterator<T> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        if (INSTANCE.verifyHostname(r11, r14) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r12.isEmpty() == false) goto L7;
        return false;
    }

    private final boolean verifyIpAddress(String r5, X509Certificate r10) {
        String r11 = HostnamesKt.toCanonicalHost(r5);
        List<String> r12 = getSubjectAltNames(r10, 7);
        if (r12 != null) goto L5;
    L7:
        Iterator<T> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r11, HostnamesKt.toCanonicalHost((String) r13.next())) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r12.isEmpty() == false) goto L7;
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate r5) {
        Intrinsics.checkNotNullParameter(r5, "certificate");
        return CollectionsKt.plus(getSubjectAltNames(r5, 7), getSubjectAltNames(r5, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r5, SSLSession r10) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r10, "session");
        if (isAscii(r5) == false) goto L13;
        Certificate r11 = r10.getPeerCertificates()[0];     // Catch: SSLException -> L11
        if (r11 == null) goto L9;
        return verify(r5, (X509Certificate) r11);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: SSLException -> L11
    L14:
        return false;
    L13:
        return false;
    }

    public final boolean verify(String r5, X509Certificate r10) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r10, "certificate");
        if (Util.canParseAsIpAddress(r5) == false) goto L6;
        return verifyIpAddress(r5, r10);
    L6:
        return verifyHostname(r5, r10);
    }

    private final boolean verifyHostname(String r10, String r11) {
        if (r10 != null) goto L5;
    L51:
        return false;
    L5:
        if (r10.length() == 0) goto L51;
        if (StringsKt.P(r10, ".") == true) goto L51;
        if (StringsKt.k(r10, "..") == true) goto L51;
        if (r11 == null) goto L51;
        if (r11.length() == 0) goto L51;
        if (StringsKt.P(r11, ".") == true) goto L51;
        if (StringsKt.k(r11, "..") == true) goto L51;
        if (StringsKt.k(r10, ".") == true) goto L25;
        r10 = r10.concat(".");
    L25:
        if (StringsKt.k(r11, ".") == true) goto L27;
        r11 = r11.concat(".");
    L27:
        String r12 = asciiToLowercase(r11);
        if (StringsKt.g(r12, XPath.WILDCARD) == true) goto L32;
        return Intrinsics.areEqual(r10, r12);
    L32:
        if (StringsKt.P(r12, "*.") == false) goto L51;
        if (StringsKt.q(r12, '*', 1, 4) != (-1)) goto L51;
        if (r10.length() >= r12.length()) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual("*.", r12) == false) goto L42;
        return false;
    L42:
        String r13 = r12.substring(1);
        if (StringsKt.k(r10, r13) == true) goto L45;
        return false;
    L45:
        int r14 = r10.length() - r13.length();
        if (r14 > 0) goto L48;
    L50:
        return true;
    L48:
        if (StringsKt.t(r10, '.', r14 - 1, 4) == (-1)) goto L50;
        return false;
    }
}
