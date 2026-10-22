package okhttp3;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b!J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\"J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b#J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0017H\u0016R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lokhttp3/Handshake;", "", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "localCertificates", "", "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lkotlin/Function0;", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "localPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "peerCertificates", "peerCertificates$delegate", "Lkotlin/Lazy;", "peerPrincipal", "()Lokhttp3/TlsVersion;", ActivityLifecycle.NAME, "", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "-deprecated_cipherSuite", "equals", "", "other", "hashCode", "", "-deprecated_localCertificates", "-deprecated_localPrincipal", "-deprecated_peerCertificates", "-deprecated_peerPrincipal", "-deprecated_tlsVersion", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Handshake {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final Lazy peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0011\u0010\u0010\u001a\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0002\b\u0003J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "()V", "get", "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final List<Certificate> toImmutableList(Certificate[] r2) {
            if (r2 == null) goto L5;
            return Util.immutableListOf((Certificate[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), Certificate[].class, "com.obric.memorydata.plugin"));
        L5:
            return CollectionsKt.emptyList();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sslSession.handshake()", imports = {}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m2960deprecated_get(SSLSession r3) {
            SSLSession r4 = (SSLSession) ZeusTransformUtils.wrapperContextForParams(r3, SSLSession.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "sslSession");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).get(r4);
        }

        @JvmStatic
        public final Handshake get(SSLSession r7) {
            SSLSession r8 = (SSLSession) ZeusTransformUtils.wrapperContextForParams(r7, SSLSession.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r8, "$this$handshake");
            String r1 = r8.getCipherSuite();
            if (r1 == null) goto L23;
            if (Intrinsics.areEqual("SSL_NULL_WITH_NULL_NULL", r1) == true) goto L21;
            CipherSuite r2 = CipherSuite.Companion.forJavaName(r1);
            String r3 = r8.getProtocol();
            if (r3 == null) goto L19;
            if (Intrinsics.areEqual("NONE", r3) == true) goto L17;
            TlsVersion r4 = TlsVersion.Companion.forJavaName(r3);
            final List<Certificate> r5 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).toImmutableList(r8.getPeerCertificates());     // Catch: SSLPeerUnverifiedException -> L13
        L15:
            return new Handshake(r4, r2, ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).toImmutableList(r8.getLocalCertificates()), (Function0) ZeusTransformUtils.preCheckCast(new Handshake$Companion$handshake$1(r5), Function0.class, "com.obric.memorydata.plugin"));
        L13:
            r5 = CollectionsKt.emptyList();
            goto L15
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("tlsVersion == NONE"), Throwable.class, "com.obric.memorydata.plugin"));
        L19:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("tlsVersion == null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L21:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL"), Throwable.class, "com.obric.memorydata.plugin"));
        L23:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("cipherSuite == null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @JvmStatic
        public final Handshake get(TlsVersion r3, CipherSuite r4, List<? extends Certificate> r5, List<? extends Certificate> r6) {
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r3, "tlsVersion");
            Intrinsics.checkParameterIsNotNull(r4, "cipherSuite");
            Intrinsics.checkParameterIsNotNull(r2, "peerCertificates");
            Intrinsics.checkParameterIsNotNull(r7, "localCertificates");
            final List r8 = Util.toImmutableList(r2);
            return new Handshake(r3, r4, Util.toImmutableList(r7), (Function0) ZeusTransformUtils.preCheckCast(new Handshake$Companion$get$1(r8), Function0.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Handshake.class), "peerCertificates", "peerCertificates()Ljava/util/List;")), KProperty.class, "com.obric.memorydata.plugin")};
        Companion = new Companion(null);
    }

    public Handshake(TlsVersion r3, CipherSuite r4, List<? extends Certificate> r5, Function0<? extends List<? extends Certificate>> r6) {
        List<Certificate> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "tlsVersion");
        Intrinsics.checkParameterIsNotNull(r4, "cipherSuite");
        Intrinsics.checkParameterIsNotNull(r7, "localCertificates");
        Intrinsics.checkParameterIsNotNull(r8, "peerCertificatesFn");
        this.tlsVersion = r3;
        this.cipherSuite = r4;
        this.localCertificates = r7;
        this.peerCertificates$delegate = LazyKt.lazy(r8);
    }

    @JvmStatic
    public static final Handshake get(SSLSession r2) {
        SSLSession r3 = (SSLSession) ZeusTransformUtils.wrapperContextForParams(r2, SSLSession.class, "com.obric.memorydata.plugin");
        return Companion.get(r3);
    }

    @JvmStatic
    public static final Handshake get(TlsVersion r2, CipherSuite r3, List<? extends Certificate> r4, List<? extends Certificate> r5) {
        List<? extends Certificate> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<? extends Certificate> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        return Companion.get(r2, r3, r6, r7);
    }

    private final String getName(Certificate r2) {
        if (ZeusTransformUtils.instanceOf(r2, X509Certificate.class) == true) goto L7;
        String r1 = r2.getType();
        Intrinsics.checkExpressionValueIsNotNull(r1, "type");
        return r1;
    L7:
        return ((X509Certificate) ZeusTransformUtils.preCheckCast(r2, X509Certificate.class, "com.obric.memorydata.plugin")).getSubjectDN().toString();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuite", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m2954deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localCertificates", imports = {}))
    /* JADX INFO: renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m2955deprecated_localCertificates() {
        return this.localCertificates;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localPrincipal", imports = {}))
    /* JADX INFO: renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m2956deprecated_localPrincipal() {
        return localPrincipal();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerCertificates", imports = {}))
    /* JADX INFO: renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m2957deprecated_peerCertificates() {
        return peerCertificates();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerPrincipal", imports = {}))
    /* JADX INFO: renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m2958deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersion", imports = {}))
    /* JADX INFO: renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m2959deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Handshake.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (((Handshake) ZeusTransformUtils.preCheckCast(r5, Handshake.class, "com.obric.memorydata.plugin")).tlsVersion != this.tlsVersion) goto L13;
        if (Intrinsics.areEqual(((Handshake) ZeusTransformUtils.preCheckCast(r5, Handshake.class, "com.obric.memorydata.plugin")).cipherSuite, this.cipherSuite) == false) goto L13;
        if (Intrinsics.areEqual(((Handshake) ZeusTransformUtils.preCheckCast(r5, Handshake.class, "com.obric.memorydata.plugin")).peerCertificates(), peerCertificates()) == false) goto L13;
        if (Intrinsics.areEqual(((Handshake) ZeusTransformUtils.preCheckCast(r5, Handshake.class, "com.obric.memorydata.plugin")).localCertificates, this.localCertificates) == false) goto L13;
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object r3 = CollectionsKt.firstOrNull(this.localCertificates);
        X500Principal r1 = null;
        if (ZeusTransformUtils.instanceOf(r3, X509Certificate.class) == true) goto L5;
        r3 = null;
    L5:
        X509Certificate r4 = (X509Certificate) ZeusTransformUtils.preCheckCast(r3, X509Certificate.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        r1 = r4.getSubjectX500Principal();
    L9:
        return (Principal) ZeusTransformUtils.preCheckCast(r1, Principal.class, "com.obric.memorydata.plugin");
    }

    public final List<Certificate> peerCertificates() {
        Lazy r2 = this.peerCertificates$delegate;
        KProperty r0 = $$delegatedProperties[0];
        return (List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    public final Principal peerPrincipal() {
        Object r3 = CollectionsKt.firstOrNull(peerCertificates());
        X500Principal r1 = null;
        if (ZeusTransformUtils.instanceOf(r3, X509Certificate.class) == true) goto L5;
        r3 = null;
    L5:
        X509Certificate r4 = (X509Certificate) ZeusTransformUtils.preCheckCast(r3, X509Certificate.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        r1 = r4.getSubjectX500Principal();
    L9:
        return (Principal) ZeusTransformUtils.preCheckCast(r1, Principal.class, "com.obric.memorydata.plugin");
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Handshake{").append("tlsVersion=").append(this.tlsVersion).append(' ').append("cipherSuite=").append(this.cipherSuite).append(' ').append("peerCertificates=");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(peerCertificates(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(getName((Certificate) ZeusTransformUtils.preCheckCast(r4.next(), Certificate.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        StringBuilder r1 = r0.append((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).append(' ').append("localCertificates=");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.localCertificates, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L11;
        r6.add(getName((Certificate) ZeusTransformUtils.preCheckCast(r7.next(), Certificate.class, "com.obric.memorydata.plugin")));
        goto L8
    L11:
        return r1.append((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")).append('}').toString();
    }
}
