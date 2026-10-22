package okhttp3.internal.tls;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CertificatePinner;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", XSDatatype.FACET_PATTERN, "verifyIpAddress", "ipAddress", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = null;

    static {
        INSTANCE = new OkHostnameVerifier();
    }

    private OkHostnameVerifier() {
    }

    private final List<String> getSubjectAltNames(X509Certificate r5, int r6) {
        Collection<List<?>> r7 = r5.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L25
        if (r7 == null) goto L24;
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: CertificateParsingException -> L25
        Iterator<List<?>> r8 = r7.iterator();     // Catch: CertificateParsingException -> L25
    L7:
        if (r8.hasNext() == false) goto L22;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r8.next(), List.class, "com.obric.memorydata.plugin");     // Catch: CertificateParsingException -> L25
        if (r1 == null) goto L7;
        if (r1.size() < 2) goto L7;
        if ((!Intrinsics.areEqual(r1.get(0), Integer.valueOf(r6))) == true) goto L7;
        Object r2 = r1.get(1);     // Catch: CertificateParsingException -> L25
        if (r2 == null) goto L7;
        if (r2 == null) goto L21;
        r0.add((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));     // Catch: CertificateParsingException -> L25
        goto L7
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: CertificateParsingException -> L25
    L22:
        return r0;
    L24:
        return CollectionsKt.emptyList();
    L26:
        return CollectionsKt.emptyList();
    }

    private final boolean verifyHostname(String r18, String r19) {
        String r0 = r18;
        String r1 = r19;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
    L66:
        return false;
    L11:
        if (StringsKt.startsWith$default(r0, ".", false, 2, null) == true) goto L66;
        if (StringsKt.endsWith$default(r0, "..", false, 2, null) == true) goto L66;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == true) goto L66;
        if (StringsKt.startsWith$default(r1, ".", false, 2, null) == true) goto L66;
        if (StringsKt.endsWith$default(r1, "..", false, 2, null) == true) goto L66;
        if (StringsKt.endsWith$default(r0, ".", false, 2, null) == true) goto L32;
        r0 = r0 + ".";
    L32:
        if (StringsKt.endsWith$default(r1, ".", false, 2, null) == true) goto L34;
        r1 = r1 + ".";
    L34:
        Locale r4 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(r4, "Locale.US");
        if (r1 == null) goto L65;
        String r5 = r1.toLowerCase(r4);
        Intrinsics.checkExpressionValueIsNotNull(r5, "(this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L41;
        return Intrinsics.areEqual(r0, r5);
    L41:
        if (StringsKt.startsWith$default(r5, CertificatePinner.WILDCARD, false, 2, null) == true) goto L43;
    L63:
        return false;
    L43:
        if (StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), '*', 1, false, 4, null) != (-1)) goto L63;
        if (r0.length() >= r5.length()) goto L49;
        return false;
    L49:
        if (Intrinsics.areEqual(CertificatePinner.WILDCARD, r5) == false) goto L51;
        return false;
    L51:
        if (r5 == null) goto L62;
        String r6 = r5.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(r6, "(this as java.lang.String).substring(startIndex)");
        if (StringsKt.endsWith$default(r0, r6, false, 2, null) == true) goto L55;
        return false;
    L55:
        int r7 = r0.length() - r6.length();
        if (r7 > 0) goto L58;
    L60:
        return true;
    L58:
        if (StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), '.', r7 - 1, false, 4, null) == (-1)) goto L60;
        return false;
    L62:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L65:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L18:
        if (r9.length() == 0) goto L21;
        r10 = false;
        goto L22
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final boolean verifyHostname(String r4, X509Certificate r5) {
        Locale r0 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(r0, "Locale.US");
        if (r4 == null) goto L17;
        String r6 = r4.toLowerCase(r0);
        Intrinsics.checkExpressionValueIsNotNull(r6, "(this as java.lang.String).toLowerCase(locale)");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(getSubjectAltNames(r5, 2), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L7;
    L9:
        Iterator r7 = r3.iterator();
    L11:
        if (r7.hasNext() == false) goto L22;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (INSTANCE.verifyHostname(r6, r8) == false) goto L11;
        return true;
    L22:
        return false;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
        return false;
    L17:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final boolean verifyIpAddress(String r5, X509Certificate r6) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(getSubjectAltNames(r6, 7), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r4.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        if (StringsKt.equals(r5, (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), true) == false) goto L9;
        return true;
    L12:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final List<String> allSubjectAltNames(X509Certificate r3) {
        Intrinsics.checkParameterIsNotNull(r3, "certificate");
        List<String> r0 = getSubjectAltNames(r3, 7);
        List<String> r2 = getSubjectAltNames(r3, 2);
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean verify(String r2, X509Certificate r3) {
        Intrinsics.checkParameterIsNotNull(r2, "host");
        Intrinsics.checkParameterIsNotNull(r3, "certificate");
        if (Util.canParseAsIpAddress(r2) == false) goto L6;
        return verifyIpAddress(r2, r3);
    L6:
        return verifyHostname(r2, r3);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r4, SSLSession r5) {
        SSLSession r6 = (SSLSession) ZeusTransformUtils.wrapperContextForParams(r5, SSLSession.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "host");
        Intrinsics.checkParameterIsNotNull(r6, "session");
        Certificate r7 = r6.getPeerCertificates()[0];     // Catch: SSLException -> L9
        if (r7 == null) goto L7;
        return verify(r4, (X509Certificate) ZeusTransformUtils.preCheckCast(r7, X509Certificate.class, "com.obric.memorydata.plugin"));
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: SSLException -> L9
    L11:
        return false;
    }
}
