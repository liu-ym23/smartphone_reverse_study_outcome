package okhttp3.internal.platform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Provider;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureSslSocketFactory", "", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "configureTlsExtensions", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "configureTrustManager", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "sslSocketFactory", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final Provider provider;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "atLeastVersion", "major", "", "minor", "patch", "buildIfSupported", "Lokhttp3/internal/platform/ConscryptPlatform;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = 0;
        L9:
            return r1.atLeastVersion(r2, r3, r4);
        }

        public final boolean atLeastVersion(int r4, int r5, int r6) {
            Conscrypt.Version r3 = Conscrypt.version();
            if (r3.major() == r4) goto L10;
            if (r3.major() <= r4) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (r3.minor() == r5) goto L17;
            if (r3.minor() <= r5) goto L15;
            return true;
        L15:
            return false;
        L17:
            if (r3.patch() < r6) goto L20;
            return true;
        L20:
            return false;
        }

        public final ConscryptPlatform buildIfSupported() {
            DefaultConstructorMarker r0 = null;
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isSupported() == true) goto L5;
            return null;
        L5:
            return new ConscryptPlatform(r0);
        }

        public final boolean isSupported() {
            return ConscryptPlatform.access$isSupported$cp();
        }
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        boolean r1 = false;
        ZeusTransformUtils.forName("org.conscrypt.Conscrypt$Version", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L10
        if (Conscrypt.isAvailable() == false) goto L8;
        if (r0.atLeastVersion(2, 1, 0) == false) goto L8;
        r1 = true;
    L8:
        isSupported = r1;
    }

    private ConscryptPlatform() {
        Provider r0 = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        Intrinsics.checkExpressionValueIsNotNull(r0, "Conscrypt.newProviderBui…rustManager(true).build()");
        this.provider = r0;
    }

    public /* synthetic */ ConscryptPlatform(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureSslSocketFactory(SSLSocketFactory r1) {
        Intrinsics.checkParameterIsNotNull(r1, "socketFactory");
        if (Conscrypt.isConscrypt(r1) == false) goto L6;
        Conscrypt.setUseEngineSocket(r1, true);
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r3, String r4, List<? extends Protocol> r5) {
        List<Protocol> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r6, "protocols");
        if (Conscrypt.isConscrypt(r3) == false) goto L11;
        if (r4 == null) goto L6;
        Conscrypt.setUseSessionTickets(r3, true);
        Conscrypt.setHostname(r3, r4);
    L6:
        Object[] r2 = ((Collection) ZeusTransformUtils.preCheckCast(Platform.Companion.alpnProtocolNames(r6), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        if (r2 == null) goto L10;
        Conscrypt.setApplicationProtocols(r3, (String[]) ZeusTransformUtils.preCheckCast(r2, String[].class, "com.obric.memorydata.plugin"));
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        super.configureTlsExtensions(r3, r4, r6);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTrustManager(X509TrustManager r3) {
        X509TrustManager r2 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin");
        if (Conscrypt.isConscrypt((TrustManager) ZeusTransformUtils.preCheckCast(r2, TrustManager.class, "com.obric.memorydata.plugin")) == false) goto L6;
        Conscrypt.setHostnameVerifier((TrustManager) ZeusTransformUtils.preCheckCast(r2, TrustManager.class, "com.obric.memorydata.plugin"), (ConscryptHostnameVerifier) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, ConscryptHostnameVerifier.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "sslSocket");
        if (Conscrypt.isConscrypt(r2) == false) goto L6;
        return Conscrypt.getApplicationProtocol(r2);
    L6:
        return super.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.checkExpressionValueIsNotNull(r1, "SSLContext.getInstance(\"TLS\", provider)");
        return r1;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        X509TrustManager r1 = Conscrypt.getDefaultX509TrustManager();
        Intrinsics.checkExpressionValueIsNotNull(r1, "Conscrypt.getDefaultX509TrustManager()");
        return r1;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r3) {
        Intrinsics.checkParameterIsNotNull(r3, "sslSocketFactory");
        if (Conscrypt.isConscrypt(r3) == false) goto L16;
        Object r2 = Util.readFieldOrNull(r3, Object.class, "sslParameters");     // Catch: Exception -> L11
        if (r2 == null) goto L9;
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(Util.readFieldOrNull(r2, X509TrustManager.class, "x509TrustManager"), X509TrustManager.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    L11:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L16:
        return super.trustManager(r3);
    }
}
