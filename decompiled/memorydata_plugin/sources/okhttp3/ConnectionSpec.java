package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007¢\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0015J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b J\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u0007¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\rR\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006%"}, d2 = {"Lokhttp3/ConnectionSpec;", "", "isTls", "", "supportsTlsExtensions", "cipherSuitesAsString", "", "", "tlsVersionsAsString", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "cipherSuites", "", "Lokhttp3/CipherSuite;", "()Ljava/util/List;", "[Ljava/lang/String;", "()Z", "tlsVersions", "Lokhttp3/TlsVersion;", "apply", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "-deprecated_cipherSuites", "equals", "other", "hashCode", "", "isCompatible", "socket", "supportedSpec", "-deprecated_supportsTlsExtensions", "-deprecated_tlsVersions", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES = null;
    public static final ConnectionSpec CLEARTEXT = null;
    public static final ConnectionSpec COMPATIBLE_TLS = null;
    public static final Companion Companion = null;
    public static final ConnectionSpec MODERN_TLS = null;
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES = null;
    public static final ConnectionSpec RESTRICTED_TLS = null;
    private final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    private final String[] tlsVersionsAsString;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u0006J\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u001cJ\u001f\u0010\b\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\t\"\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0007J\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\t\"\u00020\u001f¢\u0006\u0002\u0010 R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006!"}, d2 = {"Lokhttp3/ConnectionSpec$Builder;", "", "tls", "", "(Z)V", "connectionSpec", "Lokhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "cipherSuites", "", "", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "getTls$okhttp", "setTls$okhttp", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "allEnabledCipherSuites", "allEnabledTlsVersions", "build", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;

        public Builder(ConnectionSpec r2) {
            Intrinsics.checkParameterIsNotNull(r2, "connectionSpec");
            this.tls = r2.isTls();
            this.cipherSuites = ConnectionSpec.access$getCipherSuitesAsString$p(r2);
            this.tlsVersions = ConnectionSpec.access$getTlsVersionsAsString$p(r2);
            this.supportsTlsExtensions = r2.supportsTlsExtensions();
        }

        public Builder(boolean r1) {
            this.tls = r1;
        }

        public final Builder allEnabledCipherSuites() {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.tls == false) goto L7;
            r2.cipherSuites = (String[]) ZeusTransformUtils.preCheckCast(null, String[].class, "com.obric.memorydata.plugin");
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("no cipher suites for cleartext connections".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder allEnabledTlsVersions() {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.tls == false) goto L7;
            r2.tlsVersions = (String[]) ZeusTransformUtils.preCheckCast(null, String[].class, "com.obric.memorydata.plugin");
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("no TLS versions for cleartext connections".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        public final Builder cipherSuites(String... r6) {
            Intrinsics.checkParameterIsNotNull(r6, "cipherSuites");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.tls == false) goto L19;
            if (r6.length != 0) goto L7;
            boolean r3 = true;
        L9:
            if ((!r3) == false) goto L17;
            Object r7 = r6.clone();
            if (r7 == null) goto L15;
            r2.cipherSuites = (String[]) ZeusTransformUtils.preCheckCast(r7, String[].class, "com.obric.memorydata.plugin");
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L15:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("At least one cipher suite is required".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r3 = false;
            goto L9
        L19:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("no cipher suites for cleartext connections".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder cipherSuites(CipherSuite... r7) {
            Intrinsics.checkParameterIsNotNull(r7, "cipherSuites");
            Builder r6 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r6.tls == false) goto L14;
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.memorydata.plugin");
            int r2 = r7.length;
            int r4 = 0;
        L5:
            if (r4 >= r2) goto L7;
            r0.add(r7[r4].javaName());
            r4 = r4 + 1;
            goto L5
        L7:
            Object[] r8 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
            if (r8 == null) goto L12;
            String[] r9 = (String[]) ZeusTransformUtils.preCheckCast(r8, String[].class, "com.obric.memorydata.plugin");
            return r6.cipherSuites((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r9, r9.length), String[].class, "com.obric.memorydata.plugin"));
        L12:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        L14:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("no cipher suites for cleartext connections".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(String[] r1) {
            this.cipherSuites = r1;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean r1) {
            this.supportsTlsExtensions = r1;
        }

        public final void setTls$okhttp(boolean r1) {
            this.tls = r1;
        }

        public final void setTlsVersions$okhttp(String[] r1) {
            this.tlsVersions = r1;
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        public final Builder supportsTlsExtensions(boolean r5) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.tls == false) goto L7;
            r2.supportsTlsExtensions = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("no TLS extensions for cleartext connections".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder tlsVersions(String... r6) {
            Intrinsics.checkParameterIsNotNull(r6, "tlsVersions");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r2.tls == false) goto L19;
            if (r6.length != 0) goto L7;
            boolean r3 = true;
        L9:
            if ((!r3) == false) goto L17;
            Object r7 = r6.clone();
            if (r7 == null) goto L15;
            r2.tlsVersions = (String[]) ZeusTransformUtils.preCheckCast(r7, String[].class, "com.obric.memorydata.plugin");
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L15:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("At least one TLS version is required".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r3 = false;
            goto L9
        L19:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("no TLS versions for cleartext connections".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder tlsVersions(TlsVersion... r7) {
            Intrinsics.checkParameterIsNotNull(r7, "tlsVersions");
            Builder r6 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r6.tls == false) goto L14;
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.memorydata.plugin");
            int r2 = r7.length;
            int r4 = 0;
        L5:
            if (r4 >= r2) goto L7;
            r0.add(r7[r4].javaName());
            r4 = r4 + 1;
            goto L5
        L7:
            Object[] r8 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
            if (r8 == null) goto L12;
            String[] r9 = (String[]) ZeusTransformUtils.preCheckCast(r8, String[].class, "com.obric.memorydata.plugin");
            return r6.tlsVersions((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r9, r9.length), String[].class, "com.obric.memorydata.plugin"));
        L12:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        L14:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("no TLS versions for cleartext connections".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/ConnectionSpec$Companion;", "", "()V", "APPROVED_CIPHER_SUITES", "", "Lokhttp3/CipherSuite;", "[Lokhttp3/CipherSuite;", "CLEARTEXT", "Lokhttp3/ConnectionSpec;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CipherSuite[] r1 = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
        RESTRICTED_CIPHER_SUITES = r1;
        CipherSuite[] r2 = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = r2;
        RESTRICTED_TLS = new Builder(true).cipherSuites((CipherSuite[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length), CipherSuite[].class, "com.obric.memorydata.plugin")).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2}).supportsTlsExtensions(true).build();
        MODERN_TLS = new Builder(true).cipherSuites((CipherSuite[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), CipherSuite[].class, "com.obric.memorydata.plugin")).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2}).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new Builder(true).cipherSuites((CipherSuite[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), CipherSuite[].class, "com.obric.memorydata.plugin")).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0}).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    public ConnectionSpec(boolean r1, boolean r2, String[] r3, String[] r4) {
        this.isTls = r1;
        this.supportsTlsExtensions = r2;
        this.cipherSuitesAsString = r3;
        this.tlsVersionsAsString = r4;
    }

    public static final /* synthetic */ String[] access$getCipherSuitesAsString$p(ConnectionSpec r0) {
        return r0.cipherSuitesAsString;
    }

    public static final /* synthetic */ String[] access$getTlsVersionsAsString$p(ConnectionSpec r0) {
        return r0.tlsVersionsAsString;
    }

    private final ConnectionSpec supportedSpec(SSLSocket r5, boolean r6) {
        if (this.cipherSuitesAsString == null) goto L5;
        String[] r0 = r5.getEnabledCipherSuites();
        Intrinsics.checkExpressionValueIsNotNull(r0, "sslSocket.enabledCipherSuites");
        String[] r1 = Util.intersect(r0, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
    L7:
        if (this.tlsVersionsAsString == null) goto L9;
        String[] r2 = r5.getEnabledProtocols();
        Intrinsics.checkExpressionValueIsNotNull(r2, "sslSocket.enabledProtocols");
        String[] r3 = Util.intersect(r2, this.tlsVersionsAsString, ComparisonsKt.naturalOrder());
    L10:
        String[] r7 = r5.getSupportedCipherSuites();
        Intrinsics.checkExpressionValueIsNotNull(r7, "supportedCipherSuites");
        int r4 = Util.indexOf(r7, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if (r6 == true) goto L13;
    L15:
        Builder r8 = new Builder(this);
        Intrinsics.checkExpressionValueIsNotNull(r1, "cipherSuitesIntersection");
        Builder r9 = r8.cipherSuites((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length), String[].class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r3, "tlsVersionsIntersection");
        return r9.tlsVersions((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), String[].class, "com.obric.memorydata.plugin")).build();
    L13:
        if (r4 == (-1)) goto L15;
        Intrinsics.checkExpressionValueIsNotNull(r1, "cipherSuitesIntersection");
        String r10 = r7[r4];
        Intrinsics.checkExpressionValueIsNotNull(r10, "supportedCipherSuites[indexOfFallbackScsv]");
        r1 = Util.concat(r1, r10);
        goto L15
    L9:
        r3 = r5.getEnabledProtocols();
        goto L10
    L5:
        r1 = r5.getEnabledCipherSuites();
        goto L7
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuites", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cipherSuites, reason: not valid java name */
    public final List<CipherSuite> m2940deprecated_cipherSuites() {
        return cipherSuites();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "supportsTlsExtensions", imports = {}))
    /* JADX INFO: renamed from: -deprecated_supportsTlsExtensions, reason: not valid java name */
    public final boolean m2941deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersions", imports = {}))
    /* JADX INFO: renamed from: -deprecated_tlsVersions, reason: not valid java name */
    public final List<TlsVersion> m2942deprecated_tlsVersions() {
        return tlsVersions();
    }

    public final void apply$okhttp(SSLSocket r2, boolean r3) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocket");
        ConnectionSpec r1 = supportedSpec(r2, r3);
        if (r1.tlsVersions() == null) goto L6;
        r2.setEnabledProtocols(r1.tlsVersionsAsString);
    L6:
        if (r1.cipherSuites() == null) goto L9;
        r2.setEnabledCipherSuites(r1.cipherSuitesAsString);
        return;
    }

    public final List<CipherSuite> cipherSuites() {
        String[] r6 = this.cipherSuitesAsString;
        if (r6 == null) goto L8;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r6.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L11;
        String r4 = r6[r3];
        r0.add(CipherSuite.Companion.forJavaName(r4));
        r3 = r3 + 1;
        goto L5
    L11:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L8:
        return null;
    }

    public boolean equals(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, ConnectionSpec.class) == true) goto L6;
        return false;
    L6:
        if (r7 != ((ConnectionSpec) ZeusTransformUtils.preCheckCast(this, ConnectionSpec.class, "com.obric.memorydata.plugin"))) goto L9;
        return true;
    L9:
        if (this.isTls == ((ConnectionSpec) ZeusTransformUtils.preCheckCast(r7, ConnectionSpec.class, "com.obric.memorydata.plugin")).isTls) goto L12;
        return false;
    L12:
        if (this.isTls == true) goto L14;
    L22:
        return true;
    L14:
        if (Arrays.equals(this.cipherSuitesAsString, ((ConnectionSpec) ZeusTransformUtils.preCheckCast(r7, ConnectionSpec.class, "com.obric.memorydata.plugin")).cipherSuitesAsString) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.tlsVersionsAsString, ((ConnectionSpec) ZeusTransformUtils.preCheckCast(r7, ConnectionSpec.class, "com.obric.memorydata.plugin")).tlsVersionsAsString) == true) goto L20;
        return false;
    L20:
        if (this.supportsTlsExtensions == ((ConnectionSpec) ZeusTransformUtils.preCheckCast(r7, ConnectionSpec.class, "com.obric.memorydata.plugin")).supportsTlsExtensions) goto L22;
        return false;
    }

    public int hashCode() {
        if (this.isTls == false) goto L12;
        String[] r1 = this.cipherSuitesAsString;
        int r2 = 0;
        if (r1 == null) goto L7;
        int r3 = Arrays.hashCode(r1);
    L8:
        int r0 = (527 + r3) * 31;
        String[] r4 = this.tlsVersionsAsString;
        if (r4 == null) goto L14;
        r2 = Arrays.hashCode(r4);
    L14:
        return ((r0 + r2) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    L7:
        r3 = 0;
        goto L8
    L12:
        return 17;
    }

    public final boolean isCompatible(SSLSocket r5) {
        Intrinsics.checkParameterIsNotNull(r5, "socket");
        if (this.isTls == true) goto L5;
        return false;
    L5:
        String[] r0 = this.tlsVersionsAsString;
        if (r0 != null) goto L8;
    L10:
        String[] r4 = this.cipherSuitesAsString;
        if (r4 != null) goto L13;
        return true;
    L13:
        if (Util.hasIntersection(r4, r5.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (Util.hasIntersection(r0, r5.getEnabledProtocols(), ComparisonsKt.naturalOrder()) == true) goto L10;
        return false;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final List<TlsVersion> tlsVersions() {
        String[] r6 = this.tlsVersionsAsString;
        if (r6 == null) goto L8;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r6.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L11;
        String r4 = r6[r3];
        r0.add(TlsVersion.Companion.forJavaName(r4));
        r3 = r3 + 1;
        goto L5
    L11:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L8:
        return null;
    }

    public String toString() {
        if (this.isTls == true) goto L7;
        return "ConnectionSpec()";
    L7:
        return "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }
}
