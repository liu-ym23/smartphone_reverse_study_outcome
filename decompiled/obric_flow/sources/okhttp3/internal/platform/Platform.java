package okhttp3.internal.platform;

import ai.j0;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.j;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u0011H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u000fJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020+H\u0016¨\u00060"}, d2 = {"Lokhttp3/internal/platform/Platform;", "", "()V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getPrefix", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "platformTrustManager", "toString", "sslSocketFactory", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public class Platform {
    public static final Companion Companion = null;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger = null;
    private static volatile Platform platform;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/platform/Platform$Companion;", "", "()V", "INFO", "", "WARN", "isAndroid", "", "()Z", "isBouncyCastlePreferred", "isConscryptPreferred", "isOpenJSSEPreferred", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", WsConstants.KEY_PLATFORM, "Lokhttp3/internal/platform/Platform;", "alpnProtocolNames", "", "", "protocols", "Lokhttp3/Protocol;", "concatLengthPrefixed", "", "findAndroidPlatform", "findJvmPlatform", "findPlatform", "get", "resetForTests", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Platform access$findPlatform(Companion r5) {
            return r5.findPlatform();
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform r5 = Android10Platform.Companion.buildIfSupported();
            if (r5 != null) goto L7;
            Platform r10 = AndroidPlatform.Companion.buildIfSupported();
            Intrinsics.checkNotNull(r10);
            return r10;
        L7:
            return r5;
        }

        private final Platform findJvmPlatform() {
            if (isConscryptPreferred() == false) goto L8;
            ConscryptPlatform r5 = ConscryptPlatform.Companion.buildIfSupported();
            if (r5 == null) goto L8;
            return r5;
        L8:
            if (isBouncyCastlePreferred() == false) goto L13;
            BouncyCastlePlatform r10 = BouncyCastlePlatform.Companion.buildIfSupported();
            if (r10 == null) goto L13;
            return r10;
        L13:
            if (isOpenJSSEPreferred() == false) goto L17;
            OpenJSSEPlatform r11 = OpenJSSEPlatform.Companion.buildIfSupported();
            if (r11 == null) goto L17;
            return r11;
        L17:
            Jdk9Platform r12 = Jdk9Platform.Companion.buildIfSupported();
            if (r12 == null) goto L20;
            return r12;
        L20:
            Platform r13 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            if (r13 == null) goto L24;
            return r13;
        L24:
            return new Platform();
        }

        private final Platform findPlatform() {
            if (isAndroid() == false) goto L6;
            return findAndroidPlatform();
        L6:
            return findJvmPlatform();
        }

        private final boolean isBouncyCastlePreferred() {
            return Intrinsics.areEqual("BC", Security.getProviders()[0].getName());
        }

        private final boolean isConscryptPreferred() {
            return Intrinsics.areEqual("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean isOpenJSSEPreferred() {
            return Intrinsics.areEqual("OpenJSSE", Security.getProviders()[0].getName());
        }

        public static /* synthetic */ void resetForTests$default(Companion r5, Platform r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = r5.findPlatform();
        L5:
            r5.resetForTests(r10);
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> r5) {
            Intrinsics.checkNotNullParameter(r5, "protocols");
            ArrayList r10 = new ArrayList();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            Object r12 = r11.next();
            if (((Protocol) r12) == Protocol.HTTP_1_0) goto L4;
            r10.add(r12);
            goto L4
        L8:
            ArrayList r13 = new ArrayList(CollectionsKt.h(r10));
            Iterator r14 = r10.iterator();
        L10:
            if (r14.hasNext() == false) goto L12;
            r13.add(((Protocol) r14.next()).toString());
            goto L10
        L12:
            return r13;
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> r5) {
            Intrinsics.checkNotNullParameter(r5, "protocols");
            j r10 = new j();
            Iterator<String> r11 = alpnProtocolNames(r5).iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            String r12 = r11.next();
            r10.T(r12.length());
            r10.b0(r12);
            goto L4
        L7:
            return r10.K(r10.f20328b);
        }

        @JvmStatic
        public final Platform get() {
            return Platform.access$getPlatform$cp();
        }

        public final boolean isAndroid() {
            return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }

        public final void resetForTests(Platform r5) {
            Intrinsics.checkNotNullParameter(r5, WsConstants.KEY_PLATFORM);
            Platform.access$setPlatform$cp(r5);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        platform = Companion.access$findPlatform(r5);
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public Platform() {
    }

    public static final /* synthetic */ Platform access$getPlatform$cp() {
        return platform;
    }

    public static final /* synthetic */ void access$setPlatform$cp(Platform r5) {
        platform = r5;
    }

    @JvmStatic
    public static final Platform get() {
        return Companion.get();
    }

    public static /* synthetic */ void log$default(Platform r5, String r10, int r11, Throwable r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 2) == 0) goto L7;
        r11 = 4;
    L7:
        if ((r13 & 4) == 0) goto L9;
        r12 = null;
    L9:
        r5.log(r10, r11, r12);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void afterHandshake(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r5) {
        Intrinsics.checkNotNullParameter(r5, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(r5));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager r5) {
        Intrinsics.checkNotNullParameter(r5, "trustManager");
        X509Certificate[] r10 = r5.getAcceptedIssuers();
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(r10, r10.length));
    }

    public void configureTlsExtensions(SSLSocket r5, String r10, List<Protocol> r11) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        Intrinsics.checkNotNullParameter(r11, "protocols");
    }

    public void connectSocket(Socket r5, InetSocketAddress r10, int r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "socket");
        Intrinsics.checkNotNullParameter(r10, "address");
        r5.connect(r10, r11);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        return null;
    }

    public Object getStackTraceForCloseable(String r5) {
        Intrinsics.checkNotNullParameter(r5, "closer");
        if (logger.isLoggable(Level.FINE) == true) goto L7;
        return null;
    L7:
        return new Throwable(r5);
    }

    public boolean isCleartextTrafficPermitted(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostname");
        return true;
    }

    public void log(String r5, int r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r10 != 5) goto L5;
        Level r12 = Level.WARNING;
    L6:
        logger.log(r12, r5, r11);
        return;
    L5:
        r12 = Level.INFO;
        goto L6
    }

    public void logCloseableLeak(String r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r10 != null) goto L5;
        r5 = j0.j(r5, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
    L5:
        log(r5, 5, (Throwable) r10);
    }

    public SSLContext newSSLContext() {
        return SSLContext.getInstance("TLS");
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager r5) {
        Intrinsics.checkNotNullParameter(r5, "trustManager");
        SSLContext r10 = newSSLContext();     // Catch: GeneralSecurityException -> L5
        r10.init(null, new TrustManager[]{r5}, null);     // Catch: GeneralSecurityException -> L5
        return r10.getSocketFactory();
    L5:
        e = move-exception;
        throw new AssertionError("No System TLS: " + e, e);
    }

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
        return (X509TrustManager) r12;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L16:
        throw new IllegalStateException(("Unexpected default trust managers: " + Arrays.toString(r10)).toString());
    L5:
        if ((r10[0] instanceof X509TrustManager) == false) goto L7;
        goto L7
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public X509TrustManager trustManager(SSLSocketFactory r5) {
        Intrinsics.checkNotNullParameter(r5, "sslSocketFactory");
        Object r10 = Util.readFieldOrNull(r5, Class.forName("sun.security.ssl.SSLContextImpl"), "context");     // Catch: RuntimeException -> L7 ClassNotFoundException -> L15
        if (r10 == null) goto L9;
        goto L19
    L14:
        return (X509TrustManager) Util.readFieldOrNull(r10, X509TrustManager.class, "trustManager");
    L9:
        return null;
    L7:
        e = move-exception;
        if (Intrinsics.areEqual(e.getClass().getName(), "java.lang.reflect.InaccessibleObjectException") == true) goto L18;
        throw e;
    L18:
        return null;
    L19:
        return null;
    }
}
