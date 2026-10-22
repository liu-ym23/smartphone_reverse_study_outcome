package okhttp3.internal.platform;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\nH\u0016J-\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0016¢\u0006\u0002\b\u00170\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0013J\u0012\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\u0013H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\b\u00100\u001a\u00020\u0013H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0014¨\u00062"}, d2 = {"Lokhttp3/internal/platform/Platform;", "", "()V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureSslSocketFactory", "socketFactory", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "configureTrustManager", "connectSocket", "socket", "Ljava/net/Socket;", MemoryKeyInfoEntity.KEY_ADDRESS, "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getPrefix", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "", "log", "level", "message", "t", "", "logCloseableLeak", "stackTrace", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public class Platform {
    public static final Companion Companion = null;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger = null;
    private static volatile Platform platform;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/platform/Platform$Companion;", "", "()V", CipherConst.LEVEL_INFO, "", CipherConst.LEVEL_WARN, "isConscryptPreferred", "", "()Z", "isOpenJSSEPreferred", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", WsConstants.KEY_PLATFORM, "Lokhttp3/internal/platform/Platform;", "alpnProtocolNames", "", "", "protocols", "Lokhttp3/Protocol;", "concatLengthPrefixed", "", "findPlatform", "get", "resetForTests", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ Platform access$findPlatform(Companion r0) {
            return r0.findPlatform();
        }

        private final Platform findPlatform() {
            Platform r1 = AndroidPlatform.Companion.buildIfSupported();
            if (r1 == null) goto L6;
            return r1;
        L6:
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isConscryptPreferred() == false) goto L13;
            ConscryptPlatform r2 = ConscryptPlatform.Companion.buildIfSupported();
            if (r2 == null) goto L13;
            Object r3 = ZeusTransformUtils.preCheckCast(r2, Platform.class, "com.obric.memorydata.plugin");
        L11:
            return (Platform) r3;
        L13:
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isOpenJSSEPreferred() == false) goto L17;
            Object r4 = OpenJSSEPlatform.Companion.buildIfSupported();
            if (r4 == null) goto L17;
        L16:
            r3 = ZeusTransformUtils.preCheckCast(r4, Platform.class, "com.obric.memorydata.plugin");
        L17:
            r4 = Jdk9Platform.Companion.buildIfSupported();
            if (r4 != null) goto L16;
            Platform r5 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            if (r5 == null) goto L24;
            return r5;
        L24:
            return new Platform();
        }

        private final boolean isConscryptPreferred() {
            Provider r1 = Security.getProviders()[0];
            Intrinsics.checkExpressionValueIsNotNull(r1, "Security.getProviders()[0]");
            return Intrinsics.areEqual("Conscrypt", r1.getName());
        }

        private final boolean isOpenJSSEPreferred() {
            Provider r1 = Security.getProviders()[0];
            Intrinsics.checkExpressionValueIsNotNull(r1, "Security.getProviders()[0]");
            return Intrinsics.areEqual("OpenJSSE", r1.getName());
        }

        public static /* synthetic */ void resetForTests$default(Companion r0, Platform r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = r0.findPlatform();
        L5:
            r0.resetForTests(r1);
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> r5) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "protocols");
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r6.iterator();
        L4:
            if (r8.hasNext() == false) goto L11;
            Object r1 = r8.next();
            if (((Protocol) ZeusTransformUtils.preCheckCast(r1, Protocol.class, "com.obric.memorydata.plugin")) == Protocol.HTTP_1_0) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
            r7.add(r1);
            goto L4
        L8:
            r2 = false;
            goto L9
        L11:
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r9.iterator();
        L13:
            if (r11.hasNext() == false) goto L16;
            r10.add(((Protocol) ZeusTransformUtils.preCheckCast(r11.next(), Protocol.class, "com.obric.memorydata.plugin")).toString());
            goto L13
        L16:
            return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> r4) {
            List<? extends Protocol> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "protocols");
            Buffer r0 = new Buffer();
            Iterator<String> r3 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).alpnProtocolNames(r5).iterator();
        L4:
            if (r3.hasNext() == false) goto L7;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
            r0.writeByte(r6.length());
            r0.writeUtf8(r6);
            goto L4
        L7:
            return r0.readByteArray();
        }

        @JvmStatic
        public final Platform get() {
            return Platform.access$getPlatform$cp();
        }

        public final void resetForTests(Platform r1) {
            Intrinsics.checkParameterIsNotNull(r1, WsConstants.KEY_PLATFORM);
            Platform.access$setPlatform$cp(r1);
        }
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        platform = Companion.access$findPlatform(r0);
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public Platform() {
    }

    public static final /* synthetic */ Platform access$getPlatform$cp() {
        return platform;
    }

    public static final /* synthetic */ void access$setPlatform$cp(Platform r0) {
        platform = r0;
    }

    @JvmStatic
    public static final Platform get() {
        return Companion.get();
    }

    public void afterHandshake(SSLSocket r1) {
        Intrinsics.checkParameterIsNotNull(r1, "sslSocket");
    }

    public final CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory r3) {
        Intrinsics.checkParameterIsNotNull(r3, "sslSocketFactory");
        X509TrustManager r0 = trustManager(r3);
        if (r0 == null) goto L7;
        return buildCertificateChainCleaner(r0);
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Unable to extract the trust manager on " + Companion.get() + ", sslSocketFactory is " + r3.getClass()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager r3) {
        X509TrustManager r4 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "trustManager");
        return (CertificateChainCleaner) ZeusTransformUtils.preCheckCast(new BasicCertificateChainCleaner(buildTrustRootIndex(r4)), CertificateChainCleaner.class, "com.obric.memorydata.plugin");
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager r3) {
        X509TrustManager r2 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, "trustManager");
        X509Certificate[] r4 = r2.getAcceptedIssuers();
        Intrinsics.checkExpressionValueIsNotNull(r4, "trustManager.acceptedIssuers");
        return (TrustRootIndex) ZeusTransformUtils.preCheckCast(new BasicTrustRootIndex((X509Certificate[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), X509Certificate[].class, "com.obric.memorydata.plugin")), TrustRootIndex.class, "com.obric.memorydata.plugin");
    }

    public void configureSslSocketFactory(SSLSocketFactory r1) {
        Intrinsics.checkParameterIsNotNull(r1, "socketFactory");
    }

    public void configureTlsExtensions(SSLSocket r1, String r2, List<Protocol> r3) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r1, "sslSocket");
        Intrinsics.checkParameterIsNotNull(r0, "protocols");
    }

    public void configureTrustManager(X509TrustManager r2) {
        X509TrustManager r1 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r2, X509TrustManager.class, "com.obric.memorydata.plugin");
    }

    public void connectSocket(Socket r2, InetSocketAddress r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r2, "socket");
        Intrinsics.checkParameterIsNotNull(r3, MemoryKeyInfoEntity.KEY_ADDRESS);
        r2.connect((SocketAddress) ZeusTransformUtils.preCheckCast(r3, SocketAddress.class, "com.obric.memorydata.plugin"), r4);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket r1) {
        Intrinsics.checkParameterIsNotNull(r1, "sslSocket");
        return null;
    }

    public Object getStackTraceForCloseable(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "closer");
        if (logger.isLoggable(Level.FINE) == true) goto L7;
        return null;
    L7:
        return new Throwable(r2);
    }

    public boolean isCleartextTrafficPermitted(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "hostname");
        return true;
    }

    public void log(int r1, String r2, Throwable r3) {
        Intrinsics.checkParameterIsNotNull(r2, "message");
        if (r1 != 5) goto L5;
        Level r0 = Level.WARNING;
    L6:
        logger.log(r0, r2, r3);
        return;
    L5:
        r0 = Level.INFO;
        goto L6
    }

    public void logCloseableLeak(String r4, Object r5) {
        Intrinsics.checkParameterIsNotNull(r4, "message");
        if (r5 != null) goto L5;
        r4 = r4 + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    L5:
        log(5, r4, (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public SSLContext newSSLContext() {
        SSLContext r1 = SSLContext.getInstance("TLS");
        Intrinsics.checkExpressionValueIsNotNull(r1, "SSLContext.getInstance(\"TLS\")");
        return r1;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory r5 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r5.init((KeyStore) ZeusTransformUtils.preCheckCast(null, KeyStore.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r5, "factory");
        TrustManager[] r6 = r5.getTrustManagers();
        if (r6 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        boolean r1 = true;
        if (r6.length == 1) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L18;
        TrustManager r7 = r6[0];
        if (r7 == null) goto L17;
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(r7, X509TrustManager.class, "com.obric.memorydata.plugin");
    L17:
        throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    L18:
        StringBuilder r0 = new StringBuilder().append("Unexpected default trust managers: ");
        String r8 = Arrays.toString(r6);
        Intrinsics.checkExpressionValueIsNotNull(r8, "java.util.Arrays.toString(this)");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(r0.append(r8).toString().toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        if (ZeusTransformUtils.instanceOf(r6[0], X509TrustManager.class) == false) goto L10;
        goto L10
    }

    public String toString() {
        String r1 = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(r1, "javaClass.simpleName");
        return r1;
    }

    public X509TrustManager trustManager(SSLSocketFactory r4) {
        Intrinsics.checkParameterIsNotNull(r4, "sslSocketFactory");
        Class r1 = ZeusTransformUtils.forName("sun.security.ssl.SSLContextImpl", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L8
        Intrinsics.checkExpressionValueIsNotNull(r1, "sslContextClass");     // Catch: ClassNotFoundException -> L8
        Object r5 = Util.readFieldOrNull(r4, r1, "context");     // Catch: ClassNotFoundException -> L8
        if (r5 == null) goto L11;
        return (X509TrustManager) ZeusTransformUtils.preCheckCast(Util.readFieldOrNull(r5, X509TrustManager.class, "trustManager"), X509TrustManager.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    L12:
        return null;
    }
}
