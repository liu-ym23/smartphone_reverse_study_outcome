package okhttp3;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0003 !\"B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0000¢\u0006\u0002\b\u0012J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u001fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", "findMatchingPins$okhttp", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class CertificatePinner {
    public static final Companion Companion = null;
    public static final CertificatePinner DEFAULT = null;
    public static final String WILDCARD = "*.";
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\t\"\u00020\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "add", XSDatatype.FACET_PATTERN, "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private final List<Pin> pins;

        public Builder() {
            this.pins = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        public final Builder add(String r9, String... r10) {
            Intrinsics.checkParameterIsNotNull(r9, XSDatatype.FACET_PATTERN);
            Intrinsics.checkParameterIsNotNull(r10, "pins");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r3 = r10.length;
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L6;
            String r5 = r10[r4];
            r2.pins.add(CertificatePinner.Companion.newPin$okhttp(r9, r5));
            r4 = r4 + 1;
            goto L3
        L6:
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(this.pins, Iterable.class, "com.obric.memorydata.plugin")), null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u0011\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0011\u0010\u0012\u001a\u00020\u000f*\u00020\u0010H\u0000¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "WILDCARD", "", "newPin", "Lokhttp3/CertificatePinner$Pin;", XSDatatype.FACET_PATTERN, "pin", "newPin$okhttp", "certificate", "Ljava/security/cert/Certificate;", "toSha1ByteString", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "toSha1ByteString$okhttp", "toSha256ByteString", "toSha256ByteString$okhttp", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Pin newPin$okhttp(String r7, String r8) {
            Intrinsics.checkParameterIsNotNull(r7, XSDatatype.FACET_PATTERN);
            Intrinsics.checkParameterIsNotNull(r8, "pin");
            if (StringsKt.startsWith$default(r7, CertificatePinner.WILDCARD, false, 2, null) == false) goto L5;
            HttpUrl.Companion r6 = HttpUrl.Companion;
            StringBuilder r3 = new StringBuilder().append("http://");
            String r5 = r7.substring(2);
            Intrinsics.checkExpressionValueIsNotNull(r5, "(this as java.lang.String).substring(startIndex)");
            StringBuilder r4 = r3.append(r5);
        L6:
            String r9 = r6.get(r4.toString()).host();
            if (StringsKt.startsWith$default(r8, "sha1/", false, 2, null) == false) goto L13;
            ByteString.Companion r0 = ByteString.Companion;
            String r10 = r8.substring(5);
            Intrinsics.checkExpressionValueIsNotNull(r10, "(this as java.lang.String).substring(startIndex)");
            ByteString r11 = r0.decodeBase64(r10);
            if (r11 != null) goto L21;
            Intrinsics.throwNpe();
        L21:
            return new Pin(r7, r9, "sha1/", r11);
        L13:
            if (StringsKt.startsWith$default(r8, "sha256/", false, 2, null) == false) goto L20;
            ByteString.Companion r1 = ByteString.Companion;
            String r12 = r8.substring(7);
            Intrinsics.checkExpressionValueIsNotNull(r12, "(this as java.lang.String).substring(startIndex)");
            ByteString r13 = r1.decodeBase64(r12);
            if (r13 != null) goto L18;
            Intrinsics.throwNpe();
        L18:
            return new Pin(r7, r9, "sha256/", r13);
        L20:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + r8), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r6 = HttpUrl.Companion;
            r4 = new StringBuilder().append("http://").append(r7);
            goto L6
        }

        @JvmStatic
        public final String pin(Certificate r4) {
            Intrinsics.checkParameterIsNotNull(r4, "certificate");
            if (ZeusTransformUtils.instanceOf(r4, X509Certificate.class) == false) goto L7;
            return "sha256/" + ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).toSha256ByteString$okhttp((X509Certificate) ZeusTransformUtils.preCheckCast(r4, X509Certificate.class, "com.obric.memorydata.plugin")).base64();
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Certificate pinning requires X509 certificates".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final ByteString toSha1ByteString$okhttp(X509Certificate r7) {
            Intrinsics.checkParameterIsNotNull(r7, "$this$toSha1ByteString");
            ByteString.Companion r0 = ByteString.Companion;
            PublicKey r6 = r7.getPublicKey();
            Intrinsics.checkExpressionValueIsNotNull(r6, "publicKey");
            byte[] r1 = r6.getEncoded();
            Intrinsics.checkExpressionValueIsNotNull(r1, "publicKey.encoded");
            return ByteString.Companion.of$default(r0, r1, 0, 0, 3, null).sha1();
        }

        public final ByteString toSha256ByteString$okhttp(X509Certificate r7) {
            Intrinsics.checkParameterIsNotNull(r7, "$this$toSha256ByteString");
            ByteString.Companion r0 = ByteString.Companion;
            PublicKey r6 = r7.getPublicKey();
            Intrinsics.checkExpressionValueIsNotNull(r6, "publicKey");
            byte[] r1 = r6.getEncoded();
            Intrinsics.checkExpressionValueIsNotNull(r1, "publicKey.encoded");
            return ByteString.Companion.of$default(r0, r1, 0, 0, 3, null).sha256();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0003J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", XSDatatype.FACET_PATTERN, "", "canonicalHostname", "hashAlgorithm", "hash", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "getHash", "()Lokio/ByteString;", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "matches", "hostname", "toString", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Pin {
        private final String canonicalHostname;
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String r2, String r3, String r4, ByteString r5) {
            Intrinsics.checkParameterIsNotNull(r2, XSDatatype.FACET_PATTERN);
            Intrinsics.checkParameterIsNotNull(r3, "canonicalHostname");
            Intrinsics.checkParameterIsNotNull(r4, "hashAlgorithm");
            Intrinsics.checkParameterIsNotNull(r5, "hash");
            this.pattern = r2;
            this.canonicalHostname = r3;
            this.hashAlgorithm = r4;
            this.hash = r5;
        }

        private final String component2() {
            return this.canonicalHostname;
        }

        public static /* synthetic */ Pin copy$default(Pin r0, String r1, String r2, String r3, ByteString r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.pattern;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.canonicalHostname;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.hashAlgorithm;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.hash;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.pattern;
        }

        public final String component3() {
            return this.hashAlgorithm;
        }

        public final ByteString component4() {
            return this.hash;
        }

        public final Pin copy(String r1, String r2, String r3, ByteString r4) {
            Intrinsics.checkParameterIsNotNull(r1, XSDatatype.FACET_PATTERN);
            Intrinsics.checkParameterIsNotNull(r2, "canonicalHostname");
            Intrinsics.checkParameterIsNotNull(r3, "hashAlgorithm");
            Intrinsics.checkParameterIsNotNull(r4, "hash");
            return new Pin(r1, r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, Pin.class) == false) goto L15;
            Pin r4 = (Pin) ZeusTransformUtils.preCheckCast(r3, Pin.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.pattern, r4.pattern) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.canonicalHostname, r4.canonicalHostname) == true) goto L11;
            return false;
        L11:
            if (Intrinsics.areEqual(this.hashAlgorithm, r4.hashAlgorithm) == true) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(this.hash, r4.hash) == true) goto L23;
            return false;
        L23:
            return true;
        L15:
            return false;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            String r0 = this.pattern;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.canonicalHostname;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.hashAlgorithm;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            ByteString r10 = this.hash;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final boolean matches(String r12) {
            Intrinsics.checkParameterIsNotNull(r12, "hostname");
            if (StringsKt.startsWith$default(this.pattern, CertificatePinner.WILDCARD, false, 2, null) == false) goto L11;
            int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), '.', 0, false, 6, null);
            if (((r12.length() - r0) - 1) == this.canonicalHostname.length()) goto L7;
            return false;
        L7:
            if (StringsKt.startsWith$default(r12, this.canonicalHostname, r0 + 1, false, 4, null) == true) goto L9;
            return false;
        L9:
            return true;
        L11:
            return Intrinsics.areEqual(r12, this.canonicalHostname);
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new Builder().build();
    }

    public CertificatePinner(Set<Pin> r3, CertificateChainCleaner r4) {
        Set<Pin> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "pins");
        this.pins = r5;
        this.certificateChainCleaner = r4;
    }

    @JvmStatic
    public static final String pin(Certificate r1) {
        return Companion.pin(r1);
    }

    public final void check(final String r3, List<? extends Certificate> r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "hostname");
        Intrinsics.checkParameterIsNotNull(r5, "peerCertificates");
        check$okhttp(r3, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r5, r3), Function0.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "replaced with {@link #check(String, List)}.", replaceWith = @ReplaceWith(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(String r2, Certificate... r3) {
        Intrinsics.checkParameterIsNotNull(r2, "hostname");
        Intrinsics.checkParameterIsNotNull(r3, "peerCertificates");
        check(r2, ArraysKt.toList(r3));
    }

    public final void check$okhttp(String r11, Function0<? extends List<? extends X509Certificate>> r12) {
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r11, "hostname");
        Intrinsics.checkParameterIsNotNull(r13, "cleanedPeerCertificatesFn");
        List<Pin> r10 = findMatchingPins$okhttp(r11);
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r13.invoke(), List.class, "com.obric.memorydata.plugin");
        Iterator r0 = r14.iterator();
    L7:
        if (r0.hasNext() == false) goto L31;
        X509Certificate r2 = (X509Certificate) ZeusTransformUtils.preCheckCast(r0.next(), X509Certificate.class, "com.obric.memorydata.plugin");
        ByteString r3 = (ByteString) ZeusTransformUtils.preCheckCast(null, ByteString.class, "com.obric.memorydata.plugin");
        ByteString r4 = (ByteString) ZeusTransformUtils.preCheckCast(null, ByteString.class, "com.obric.memorydata.plugin");
        Iterator<Pin> r5 = r10.iterator();
    L10:
        if (r5.hasNext() == false) goto L7;
        Pin r6 = (Pin) ZeusTransformUtils.preCheckCast(r5.next(), Pin.class, "com.obric.memorydata.plugin");
        String r7 = r6.getHashAlgorithm();
        int r8 = r7.hashCode();
        if (r8 != 109397962) goto L14;
        if (r7.equals("sha1/") == false) goto L30;
        if (r3 != null) goto L27;
        r3 = Companion.toSha1ByteString$okhttp(r2);
    L27:
        if (Intrinsics.areEqual(r6.getHash(), r3) == false) goto L10;
        return;
    L30:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("unsupported hashAlgorithm: " + r6.getHashAlgorithm()), Throwable.class, "com.obric.memorydata.plugin"));
    L14:
        if (r8 != 2052263656) goto L30;
        if (r7.equals("sha256/") == false) goto L30;
        if (r4 != null) goto L20;
        r4 = Companion.toSha256ByteString$okhttp(r2);
    L20:
        if (Intrinsics.areEqual(r6.getHash(), r4) == false) goto L10;
        return;
    L31:
        StringBuilder r1 = new StringBuilder();
        r1.append("Certificate pinning failure!");
        r1.append("\n  Peer certificate chain:");
        Iterator r15 = r14.iterator();
    L33:
        if (r15.hasNext() == false) goto L39;
        X509Certificate r9 = (X509Certificate) ZeusTransformUtils.preCheckCast(r15.next(), X509Certificate.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L38;
        r1.append("\n    ");
        r1.append(Companion.pin((Certificate) ZeusTransformUtils.preCheckCast(r9, Certificate.class, "com.obric.memorydata.plugin")));
        r1.append(": ");
        Principal r16 = r9.getSubjectDN();
        Intrinsics.checkExpressionValueIsNotNull(r16, "x509Certificate.subjectDN");
        r1.append(r16.getName());
        goto L33
    L38:
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L39:
        r1.append("\n  Pinned certificates for ");
        r1.append(r11);
        r1.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        Iterator<Pin> r17 = r10.iterator();
    L41:
        if (r17.hasNext() == false) goto L43;
        Pin r18 = (Pin) ZeusTransformUtils.preCheckCast(r17.next(), Pin.class, "com.obric.memorydata.plugin");
        r1.append("\n    ");
        r1.append(r18);
        goto L41
    L43:
        String r19 = r1.toString();
        Intrinsics.checkExpressionValueIsNotNull(r19, "StringBuilder().apply(builderAction).toString()");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SSLPeerUnverifiedException(r19), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, CertificatePinner.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(((CertificatePinner) ZeusTransformUtils.preCheckCast(r5, CertificatePinner.class, "com.obric.memorydata.plugin")).pins, this.pins) == false) goto L9;
        if (Intrinsics.areEqual(((CertificatePinner) ZeusTransformUtils.preCheckCast(r5, CertificatePinner.class, "com.obric.memorydata.plugin")).certificateChainCleaner, this.certificateChainCleaner) == false) goto L9;
        return true;
    }

    public final List<Pin> findMatchingPins$okhttp(String r5) {
        Intrinsics.checkParameterIsNotNull(r5, "hostname");
        List<Pin> r0 = CollectionsKt.emptyList();
        Iterator<Pin> r4 = this.pins.iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        Pin r1 = (Pin) ZeusTransformUtils.preCheckCast(r4.next(), Pin.class, "com.obric.memorydata.plugin");
        if (r1.matches(r5) == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L10:
        if (r0 == null) goto L13;
        TypeIntrinsics.asMutableList(r0).add(r1);
        goto L4
    L13:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<okhttp3.CertificatePinner.Pin>");
    L14:
        return r0;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public int hashCode() {
        int r1 = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner r2 = this.certificateChainCleaner;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner r2) {
        if (Intrinsics.areEqual(this.certificateChainCleaner, r2) == false) goto L6;
        return this;
    L6:
        return new CertificatePinner(this.pins, r2);
    }
}
