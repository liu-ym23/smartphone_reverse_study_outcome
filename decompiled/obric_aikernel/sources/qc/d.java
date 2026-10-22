package qc;

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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.h0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nOkHostnameVerifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,208:1\n1747#2,3:209\n1747#2,3:212\n*S KotlinDebug\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n*L\n63#1:209,3\n71#1:212,3\n*E\n"})
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12506a = null;

    static {
        f12506a = new d();
    }

    private d() {
    }

    private final String b(String r10) {
        if (d(r10) == false) goto L6;
        Locale r11 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r11, "US");
        String r12 = r10.toLowerCase(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(locale)");
        return r12;
    L6:
        return r10;
    }

    private final List<String> c(X509Certificate r10, int r11) {
        Collection<List<?>> r12 = r10.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L22
        if (r12 == null) goto L5;
        ArrayList r13 = new ArrayList();     // Catch: CertificateParsingException -> L22
        Iterator<List<?>> r14 = r12.iterator();     // Catch: CertificateParsingException -> L22
    L8:
        if (r14.hasNext() == false) goto L21;
        List<?> r15 = r14.next();     // Catch: CertificateParsingException -> L22
        if (r15 == null) goto L8;
        if (r15.size() < 2) goto L8;
        if (Intrinsics.areEqual(r15.get(0), Integer.valueOf(r11)) == false) goto L8;
        Object r16 = r15.get(1);     // Catch: CertificateParsingException -> L22
        if (r16 == null) goto L8;
        r13.add((String) r16);     // Catch: CertificateParsingException -> L22
        goto L8
    L21:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    L23:
        return CollectionsKt.emptyList();
    }

    private final boolean d(String r10) {
        if (r10.length() != ((int) h0.b(r10, 0, 0, 3, null))) goto L6;
        return true;
    L6:
        return false;
    }

    private final boolean f(String r17, String r18) {
        String r10 = r17;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
    L58:
        return false;
    L11:
        if (StringsKt.startsWith$default(r10, ".", false, 2, null) == true) goto L58;
        if (StringsKt.endsWith$default(r10, "..", false, 2, null) == true) goto L58;
        if (r18 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == true) goto L58;
        if (StringsKt.startsWith$default(r18, ".", false, 2, null) == true) goto L58;
        if (StringsKt.endsWith$default(r18, "..", false, 2, null) == true) goto L58;
        if (StringsKt.endsWith$default(r10, ".", false, 2, null) == true) goto L30;
        r10 = r10 + '.';
    L30:
        String r13 = r10;
        if (StringsKt.endsWith$default(r18, ".", false, 2, null) == true) goto L33;
        String r14 = r18 + '.';
    L34:
        String r15 = b(r14);
        if (StringsKt.contains$default(r15, "*", false, 2, null) == true) goto L39;
        return Intrinsics.areEqual(r13, r15);
    L39:
        if (StringsKt.startsWith$default(r15, "*.", false, 2, null) == false) goto L58;
        if (StringsKt.indexOf$default(r15, '*', 1, false, 4, null) != (-1)) goto L58;
        if (r13.length() >= r15.length()) goto L47;
        return false;
    L47:
        if (Intrinsics.areEqual("*.", r15) == false) goto L49;
        return false;
    L49:
        String r16 = r15.substring(1);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).substring(startIndex)");
        if (StringsKt.endsWith$default(r13, r16, false, 2, null) == true) goto L52;
        return false;
    L52:
        int r19 = r13.length() - r16.length();
        if (r19 > 0) goto L55;
    L57:
        return true;
    L55:
        if (StringsKt.lastIndexOf$default(r13, '.', r19 - 1, false, 4, null) == (-1)) goto L57;
        return false;
    L33:
        r14 = r18;
        goto L34
    L17:
        if (r18.length() == 0) goto L20;
        r12 = false;
        goto L21
    L5:
        if (r17.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    private final boolean g(String r10, X509Certificate r11) {
        String r12 = b(r10);
        List<String> r13 = c(r11, 2);
        if ((r13 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L18;
        String r15 = (String) r14.next();
        if (f12506a.f(r12, r15) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r13.isEmpty() == false) goto L7;
        return false;
    }

    private final boolean h(String r10, X509Certificate r11) {
        String r12 = hc.a.e(r10);
        List<String> r13 = c(r11, 7);
        if ((r13 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r12, hc.a.e((String) r14.next())) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r13.isEmpty() == false) goto L7;
        return false;
    }

    public final List<String> a(X509Certificate r10) {
        Intrinsics.checkNotNullParameter(r10, "certificate");
        return CollectionsKt.plus(c(r10, 7), c(r10, 2));
    }

    public final boolean e(String r10, X509Certificate r11) {
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r11, "certificate");
        if (hc.e.i(r10) == false) goto L6;
        return h(r10, r11);
    L6:
        return g(r10, r11);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r10, SSLSession r11) {
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r11, "session");
        if (d(r10) == false) goto L11;
        Certificate r12 = r11.getPeerCertificates()[0];     // Catch: SSLException -> L8
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: SSLException -> L8
        return e(r10, (X509Certificate) r12);
    L12:
        return false;
    L11:
        return false;
    }
}
