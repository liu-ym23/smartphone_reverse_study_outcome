package okhttp3.internal.platform;

import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "sslSocketFactory", "Companion", "DisabledHostnameVerifier", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion = null;
    private static final boolean isSupported = false;
    private final Provider provider;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "atLeastVersion", "major", "", "minor", "patch", "buildIfSupported", "Lokhttp3/internal/platform/ConscryptPlatform;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion r5, int r10, int r11, int r12, int r13, Object r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = 0;
        L6:
            if ((r13 & 4) == 0) goto L9;
            r12 = 0;
        L9:
            return r5.atLeastVersion(r10, r11, r12);
        }

        public final boolean atLeastVersion(int r5, int r10, int r11) {
            Conscrypt.Version r12 = Conscrypt.version();
            if (r12.major() == r5) goto L9;
            if (r12.major() > r5) goto L7;
            return false;
        L7:
            return true;
        L9:
            if (r12.minor() == r10) goto L15;
            if (r12.minor() > r10) goto L13;
            return false;
        L13:
            return true;
        L15:
            if (r12.patch() >= r11) goto L17;
            return false;
        L17:
            return true;
        }

        public final ConscryptPlatform buildIfSupported() {
            DefaultConstructorMarker r5 = null;
            if (isSupported() == true) goto L5;
            return null;
        L5:
            return new ConscryptPlatform(r5);
        }

        public final boolean isSupported() {
            return ConscryptPlatform.access$isSupported$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$DisabledHostnameVerifier;", "Lorg/conscrypt/ConscryptHostnameVerifier;", "()V", "verify", "", "certs", "", "Ljava/security/cert/X509Certificate;", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = null;

        static {
            INSTANCE = new DisabledHostnameVerifier();
        }

        private DisabledHostnameVerifier() {
        }

        public final boolean verify(String r5, SSLSession r10) {
            return true;
        }

        public boolean verify(X509Certificate[] r5, String r10, SSLSession r11) {
            return true;
        }
    }

    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        boolean r10 = false;
        Class.forName("org.conscrypt.Conscrypt$Version", false, r5.getClass().getClassLoader());     // Catch: Throwable -> L10
        if (Conscrypt.isAvailable() == false) goto L8;
        if (r5.atLeastVersion(2, 1, 0) == false) goto L8;
        r10 = true;
    L8:
        isSupported = r10;
    }

    private ConscryptPlatform() {
        this.provider = Conscrypt.newProvider();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket r5, String r10, List<Protocol> r11) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        Intrinsics.checkNotNullParameter(r11, "protocols");
        if (Conscrypt.isConscrypt(r5) == false) goto L9;
        Conscrypt.setUseSessionTickets(r5, true);
        Object[] r12 = Platform.Companion.alpnProtocolNames(r11).toArray(new String[0]);
        if (r12 == null) goto L8;
        Conscrypt.setApplicationProtocols(r5, (String[]) r12);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        super.configureTlsExtensions(r5, r10, r11);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        if (Conscrypt.isConscrypt(r5) == false) goto L6;
        return Conscrypt.getApplicationProtocol(r5);
    L6:
        return super.getSelectedProtocol(r5);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() {
        return SSLContext.getInstance("TLS", this.provider);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLSocketFactory newSslSocketFactory(X509TrustManager r5) {
        Intrinsics.checkNotNullParameter(r5, "trustManager");
        SSLContext r10 = newSSLContext();
        r10.init(null, new TrustManager[]{r5}, null);
        return r10.getSocketFactory();
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r5 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r5.init(null);
        TrustManager[] r10 = r5.getTrustManagers();
        Intrinsics.checkNotNull(r10);
        boolean r11 = true;
        if (r10.length == 1) goto L5;
    L7:
        r11 = false;
    L8:
        if (r11 == false) goto L16;
        TrustManager r12 = r10[0];
        if (r12 == null) goto L14;
        X509TrustManager r13 = (X509TrustManager) r12;
        Conscrypt.setHostnameVerifier(r13, DisabledHostnameVerifier.INSTANCE);
        return r13;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L16:
        throw new IllegalStateException(("Unexpected default trust managers: " + Arrays.toString(r10)).toString());
    L5:
        if ((r10[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocketFactory");
        return null;
    }

    public /* synthetic */ ConscryptPlatform(DefaultConstructorMarker r5) {
        this();
    }
}
