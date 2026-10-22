package okhttp3;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002opB\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\bLJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\bMJ\r\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\bNJ\r\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\bOJ\r\u0010\u0017\u001a\u00020\u000fH\u0007¢\u0006\u0002\bPJ\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\bQJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0002\bRJ\r\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\bSJ\r\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\bTJ\r\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\bUJ\r\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\bVJ\r\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\bWJ\r\u0010.\u001a\u00020,H\u0007¢\u0006\u0002\bXJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\bYJ\u0013\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007¢\u0006\u0002\bZJ\u0013\u00104\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007¢\u0006\u0002\b[J\b\u0010\\\u001a\u00020\u0006H\u0016J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0016J\u0018\u0010a\u001a\u00020b2\u0006\u0010_\u001a\u00020`2\u0006\u0010c\u001a\u00020dH\u0016J\r\u00105\u001a\u00020\u000fH\u0007¢\u0006\u0002\beJ\u0013\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001cH\u0007¢\u0006\u0002\bfJ\u000f\u00108\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\bgJ\r\u0010;\u001a\u00020\tH\u0007¢\u0006\u0002\bhJ\r\u0010<\u001a\u00020=H\u0007¢\u0006\u0002\biJ\r\u0010?\u001a\u00020\u000fH\u0007¢\u0006\u0002\bjJ\r\u0010@\u001a\u00020,H\u0007¢\u0006\u0002\bkJ\r\u0010A\u001a\u00020BH\u0007¢\u0006\u0002\blJ\r\u0010D\u001a\u00020EH\u0007¢\u0006\u0002\bmJ\r\u0010H\u001a\u00020\u000fH\u0007¢\u0006\u0002\bnR\u0013\u0010\b\u001a\u00020\t8G¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f8G¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00128G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u00158G¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u0018\u001a\u00020\u00198G¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001eR\u0013\u0010\u001f\u001a\u00020 8G¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010!R\u0013\u0010\"\u001a\u00020#8G¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010$R\u0013\u0010%\u001a\u00020&8G¢\u0006\b\n\u0000\u001a\u0004\b%\u0010'R\u0013\u0010(\u001a\u00020)8G¢\u0006\b\n\u0000\u001a\u0004\b(\u0010*R\u0013\u0010+\u001a\u00020,8G¢\u0006\b\n\u0000\u001a\u0004\b+\u0010-R\u0013\u0010.\u001a\u00020,8G¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010/\u001a\u0002008G¢\u0006\b\n\u0000\u001a\u0004\b/\u00101R\u0019\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0019\u00104\u001a\b\u0012\u0004\u0012\u0002030\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0013\u00105\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0010R\u0019\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001eR\u0015\u00108\u001a\u0004\u0018\u0001098G¢\u0006\b\n\u0000\u001a\u0004\b8\u0010:R\u0013\u0010;\u001a\u00020\t8G¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\nR\u0013\u0010<\u001a\u00020=8G¢\u0006\b\n\u0000\u001a\u0004\b<\u0010>R\u0013\u0010?\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0010R\u0013\u0010@\u001a\u00020,8G¢\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0013\u0010A\u001a\u00020B8G¢\u0006\b\n\u0000\u001a\u0004\bA\u0010CR\u0011\u0010D\u001a\u00020E8G¢\u0006\u0006\u001a\u0004\bD\u0010FR\u0010\u0010G\u001a\u0004\u0018\u00010EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010H\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0010R\u0015\u0010I\u001a\u0004\u0018\u00010J8G¢\u0006\b\n\u0000\u001a\u0004\bI\u0010K¨\u0006q"}, d2 = {"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "()V", "builder", "Lokhttp3/OkHttpClient$Builder;", "(Lokhttp3/OkHttpClient$Builder;)V", "authenticator", "Lokhttp3/Authenticator;", "()Lokhttp3/Authenticator;", "cache", "Lokhttp3/Cache;", "()Lokhttp3/Cache;", "callTimeoutMillis", "", "()I", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "certificatePinner", "Lokhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "connectTimeoutMillis", "connectionPool", "Lokhttp3/ConnectionPool;", "()Lokhttp3/ConnectionPool;", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "()Ljava/util/List;", "cookieJar", "Lokhttp3/CookieJar;", "()Lokhttp3/CookieJar;", "dispatcher", "Lokhttp3/Dispatcher;", "()Lokhttp3/Dispatcher;", "dns", "Lokhttp3/Dns;", "()Lokhttp3/Dns;", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "()Lokhttp3/EventListener$Factory;", "followRedirects", "", "()Z", "followSslRedirects", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "interceptors", "Lokhttp3/Interceptor;", "networkInterceptors", "pingIntervalMillis", "protocols", "Lokhttp3/Protocol;", "proxy", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxyAuthenticator", "proxySelector", "Ljava/net/ProxySelector;", "()Ljava/net/ProxySelector;", "readTimeoutMillis", "retryOnConnectionFailure", "socketFactory", "Ljavax/net/SocketFactory;", "()Ljavax/net/SocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "writeTimeoutMillis", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "-deprecated_authenticator", "-deprecated_cache", "-deprecated_callTimeoutMillis", "-deprecated_certificatePinner", "-deprecated_connectTimeoutMillis", "-deprecated_connectionPool", "-deprecated_connectionSpecs", "-deprecated_cookieJar", "-deprecated_dispatcher", "-deprecated_dns", "-deprecated_eventListenerFactory", "-deprecated_followRedirects", "-deprecated_followSslRedirects", "-deprecated_hostnameVerifier", "-deprecated_interceptors", "-deprecated_networkInterceptors", "newBuilder", "newCall", "Lokhttp3/Call;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "newWebSocket", "Lokhttp3/WebSocket;", "listener", "Lokhttp3/WebSocketListener;", "-deprecated_pingIntervalMillis", "-deprecated_protocols", "-deprecated_proxy", "-deprecated_proxyAuthenticator", "-deprecated_proxySelector", "-deprecated_readTimeoutMillis", "-deprecated_retryOnConnectionFailure", "-deprecated_socketFactory", "-deprecated_sslSocketFactory", "-deprecated_writeTimeoutMillis", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final Companion Companion = null;
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = null;
    private static final List<Protocol> DEFAULT_PROTOCOLS = null;
    private final Authenticator authenticator;
    private final Cache cache;
    private final int callTimeoutMillis;
    private final CertificateChainCleaner certificateChainCleaner;
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    private final ConnectionPool connectionPool;
    private final List<ConnectionSpec> connectionSpecs;
    private final CookieJar cookieJar;
    private final Dispatcher dispatcher;
    private final Dns dns;
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    private final HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    private final X509TrustManager x509TrustManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J<\u0010\u0092\u0001\u001a\u00020\u00002*\b\u0004\u0010\u0093\u0001\u001a#\u0012\u0017\u0012\u00150\u0095\u0001¢\u0006\u000f\b\u0096\u0001\u0012\n\b\u0097\u0001\u0012\u0005\b\b(\u0098\u0001\u0012\u0005\u0012\u00030\u0099\u00010\u0094\u0001H\u0087\b¢\u0006\u0003\b\u009a\u0001J\u0010\u0010\u0092\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020]J<\u0010\u009c\u0001\u001a\u00020\u00002*\b\u0004\u0010\u0093\u0001\u001a#\u0012\u0017\u0012\u00150\u0095\u0001¢\u0006\u000f\b\u0096\u0001\u0012\n\b\u0097\u0001\u0012\u0005\b\b(\u0098\u0001\u0012\u0005\u0012\u00030\u0099\u00010\u0094\u0001H\u0087\b¢\u0006\u0003\b\u009d\u0001J\u0010\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020]J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0007\u0010\u009e\u0001\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0012\u001a\u00020\u00002\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0007J\u001a\u0010\u0012\u001a\u00020\u00002\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010$\u001a\u00020\u00002\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0007J\u001a\u0010$\u001a\u00020\u00002\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J\u0014\u0010-\u001a\u00020\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ\u0011\u0010¥\u0001\u001a\u00020\u00002\b\u0010¥\u0001\u001a\u00030¦\u0001J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020GJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010L\u001a\u00020MJ\u000f\u0010R\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020MJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020VJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\J\f\u0010_\u001a\b\u0012\u0004\u0012\u00020]0\\J\u0012\u0010a\u001a\u00020\u00002\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0007J\u001a\u0010a\u001a\u00020\u00002\b\u0010¨\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001J\u0014\u0010d\u001a\u00020\u00002\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0.J\u0010\u0010h\u001a\u00020\u00002\b\u0010h\u001a\u0004\u0018\u00010iJ\u000e\u0010n\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0007J\u000e\u0010q\u001a\u00020\u00002\u0006\u0010q\u001a\u00020rJ\u0012\u0010w\u001a\u00020\u00002\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0007J\u001a\u0010w\u001a\u00020\u00002\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001J\u000e\u0010z\u001a\u00020\u00002\u0006\u0010z\u001a\u00020MJ\u000e\u0010}\u001a\u00020\u00002\u0006\u0010}\u001a\u00020~J\u0013\u0010©\u0001\u001a\u00020\u00002\b\u0010©\u0001\u001a\u00030\u0084\u0001H\u0007J\u001b\u0010©\u0001\u001a\u00020\u00002\b\u0010©\u0001\u001a\u00030\u0084\u00012\b\u0010ª\u0001\u001a\u00030\u008d\u0001J\u0013\u0010\u0089\u0001\u001a\u00020\u00002\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0007J\u001b\u0010\u0089\u0001\u001a\u00020\u00002\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR\u001a\u0010U\u001a\u00020VX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u00101R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u00101R\u001a\u0010a\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0015\"\u0004\bc\u0010\u0017R \u0010d\u001a\b\u0012\u0004\u0012\u00020e0.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00101\"\u0004\bg\u00103R\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001a\u0010n\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\t\"\u0004\bp\u0010\u000bR\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0015\"\u0004\by\u0010\u0017R\u001a\u0010z\u001a\u00020MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010O\"\u0004\b|\u0010QR\u001d\u0010}\u001a\u00020~X\u0080\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\"\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001d\u0010\u0089\u0001\u001a\u00020\u0013X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0015\"\u0005\b\u008b\u0001\u0010\u0017R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006«\u0001"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "()V", "authenticator", "Lokhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "cache", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "callTimeout", "", "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "certificatePinner", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "connectTimeout", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "connectionPool", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "getConnectionSpecs$okhttp", "()Ljava/util/List;", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "cookieJar", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "dispatcher", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "dns", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "followRedirects", "", "getFollowRedirects$okhttp", "()Z", "setFollowRedirects$okhttp", "(Z)V", "followSslRedirects", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "interceptors", "", "Lokhttp3/Interceptor;", "getInterceptors$okhttp", "networkInterceptors", "getNetworkInterceptors$okhttp", "pingInterval", "getPingInterval$okhttp", "setPingInterval$okhttp", "protocols", "Lokhttp3/Protocol;", "getProtocols$okhttp", "setProtocols$okhttp", "proxy", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxyAuthenticator", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "proxySelector", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "readTimeout", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "retryOnConnectionFailure", "getRetryOnConnectionFailure$okhttp", "setRetryOnConnectionFailure$okhttp", "socketFactory", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "writeTimeout", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "addInterceptor", "block", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "chain", "Lokhttp3/Response;", "-addInterceptor", "interceptor", "addNetworkInterceptor", "-addNetworkInterceptor", "build", "duration", "Ljava/time/Duration;", LocationMonitorConst.TIMEOUT, "", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "eventListener", "Lokhttp3/EventListener;", "followProtocolRedirects", "interval", "sslSocketFactory", "trustManager", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private Authenticator authenticator;
        private Cache cache;
        private int callTimeout;
        private CertificateChainCleaner certificateChainCleaner;
        private CertificatePinner certificatePinner;
        private int connectTimeout;
        private ConnectionPool connectionPool;
        private List<ConnectionSpec> connectionSpecs;
        private CookieJar cookieJar;
        private Dispatcher dispatcher;
        private Dns dns;
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;
        private HostnameVerifier hostnameVerifier;
        private final List<Interceptor> interceptors;
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;
        private List<? extends Protocol> protocols;
        private Proxy proxy;
        private Authenticator proxyAuthenticator;
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        private SocketFactory socketFactory;
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.networkInterceptors = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            this.authenticator = Authenticator.NONE;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = Authenticator.NONE;
            SocketFactory r0 = SocketFactory.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(r0, "SocketFactory.getDefault()");
            this.socketFactory = r0;
            this.connectionSpecs = OkHttpClient.Companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = OkHttpClient.Companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = (HostnameVerifier) ZeusTransformUtils.preCheckCast(OkHostnameVerifier.INSTANCE, HostnameVerifier.class, "com.obric.memorydata.plugin");
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
        }

        public Builder(OkHttpClient r5) {
            Intrinsics.checkParameterIsNotNull(r5, "okHttpClient");
            this();
            this.dispatcher = r5.dispatcher();
            this.connectionPool = r5.connectionPool();
            CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(this.interceptors, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.interceptors(), Iterable.class, "com.obric.memorydata.plugin"));
            CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(this.networkInterceptors, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5.networkInterceptors(), Iterable.class, "com.obric.memorydata.plugin"));
            this.eventListenerFactory = r5.eventListenerFactory();
            this.retryOnConnectionFailure = r5.retryOnConnectionFailure();
            this.authenticator = r5.authenticator();
            this.followRedirects = r5.followRedirects();
            this.followSslRedirects = r5.followSslRedirects();
            this.cookieJar = r5.cookieJar();
            this.cache = r5.cache();
            this.dns = r5.dns();
            this.proxy = r5.proxy();
            this.proxySelector = r5.proxySelector();
            this.proxyAuthenticator = r5.proxyAuthenticator();
            this.socketFactory = r5.socketFactory();
            this.sslSocketFactoryOrNull = OkHttpClient.access$getSslSocketFactoryOrNull$p(r5);
            this.x509TrustManagerOrNull = r5.x509TrustManager();
            this.connectionSpecs = r5.connectionSpecs();
            this.protocols = r5.protocols();
            this.hostnameVerifier = r5.hostnameVerifier();
            this.certificatePinner = r5.certificatePinner();
            this.certificateChainCleaner = r5.certificateChainCleaner();
            this.callTimeout = r5.callTimeoutMillis();
            this.connectTimeout = r5.connectTimeoutMillis();
            this.readTimeout = r5.readTimeoutMillis();
            this.writeTimeout = r5.writeTimeoutMillis();
            this.pingInterval = r5.pingIntervalMillis();
        }

        /* JADX INFO: renamed from: -addInterceptor, reason: not valid java name */
        public final Builder m3023addInterceptor(Function1<? super Interceptor.Chain, Response> r3) {
            final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "block");
            Interceptor.Companion r0 = Interceptor.Companion;
            return addInterceptor((Interceptor) ZeusTransformUtils.preCheckCast(new OkHttpClient$Builder$addInterceptor$$inlined$invoke$1(r4), Interceptor.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: -addNetworkInterceptor, reason: not valid java name */
        public final Builder m3024addNetworkInterceptor(Function1<? super Interceptor.Chain, Response> r3) {
            final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "block");
            Interceptor.Companion r0 = Interceptor.Companion;
            return addNetworkInterceptor((Interceptor) ZeusTransformUtils.preCheckCast(new OkHttpClient$Builder$addNetworkInterceptor$$inlined$invoke$1(r4), Interceptor.class, "com.obric.memorydata.plugin"));
        }

        public final Builder addInterceptor(Interceptor r5) {
            Interceptor r6 = (Interceptor) ZeusTransformUtils.wrapperContextForParams(r5, Interceptor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "interceptor");
            ((Collection) ZeusTransformUtils.preCheckCast(((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).interceptors, Collection.class, "com.obric.memorydata.plugin")).add(r6);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addNetworkInterceptor(Interceptor r5) {
            Interceptor r6 = (Interceptor) ZeusTransformUtils.wrapperContextForParams(r5, Interceptor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "interceptor");
            ((Collection) ZeusTransformUtils.preCheckCast(((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).networkInterceptors, Collection.class, "com.obric.memorydata.plugin")).add(r6);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder authenticator(Authenticator r4) {
            Authenticator r5 = (Authenticator) ZeusTransformUtils.wrapperContextForParams(r4, Authenticator.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "authenticator");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).authenticator = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public final Builder cache(Cache r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).cache = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder callTimeout(long r5, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, Scraps.INNER_UNIT);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.callTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r5, r7);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder callTimeout(Duration r7) {
            Intrinsics.checkParameterIsNotNull(r7, "duration");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.callTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r7.toMillis(), TimeUnit.MILLISECONDS);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder certificatePinner(CertificatePinner r4) {
            Intrinsics.checkParameterIsNotNull(r4, "certificatePinner");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).certificatePinner = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder connectTimeout(long r5, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, Scraps.INNER_UNIT);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.connectTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r5, r7);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder connectTimeout(Duration r7) {
            Intrinsics.checkParameterIsNotNull(r7, "duration");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.connectTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r7.toMillis(), TimeUnit.MILLISECONDS);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder connectionPool(ConnectionPool r4) {
            Intrinsics.checkParameterIsNotNull(r4, "connectionPool");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).connectionPool = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder connectionSpecs(List<ConnectionSpec> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "connectionSpecs");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r1.connectionSpecs = Util.toImmutableList(r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder cookieJar(CookieJar r4) {
            CookieJar r5 = (CookieJar) ZeusTransformUtils.wrapperContextForParams(r4, CookieJar.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "cookieJar");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).cookieJar = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder dispatcher(Dispatcher r4) {
            Intrinsics.checkParameterIsNotNull(r4, "dispatcher");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).dispatcher = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder dns(Dns r4) {
            Dns r5 = (Dns) ZeusTransformUtils.wrapperContextForParams(r4, Dns.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "dns");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).dns = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder eventListener(EventListener r4) {
            Intrinsics.checkParameterIsNotNull(r4, "eventListener");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.eventListenerFactory = Util.asFactory(r4);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder eventListenerFactory(EventListener.Factory r4) {
            EventListener.Factory r5 = (EventListener.Factory) ZeusTransformUtils.wrapperContextForParams(r4, EventListener.Factory.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "eventListenerFactory");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).eventListenerFactory = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder followRedirects(boolean r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).followRedirects = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder followSslRedirects(boolean r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).followSslRedirects = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        public final Dns getDns$okhttp() {
            return this.dns;
        }

        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        public final Builder hostnameVerifier(HostnameVerifier r4) {
            HostnameVerifier r5 = (HostnameVerifier) ZeusTransformUtils.wrapperContextForParams(r4, HostnameVerifier.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "hostnameVerifier");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).hostnameVerifier = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public final Builder pingInterval(long r5, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, Scraps.INNER_UNIT);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.pingInterval = Util.checkDuration("interval", r5, r7);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder pingInterval(Duration r7) {
            Intrinsics.checkParameterIsNotNull(r7, "duration");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.pingInterval = Util.checkDuration(LocationMonitorConst.TIMEOUT, r7.toMillis(), TimeUnit.MILLISECONDS);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder protocols(List<? extends Protocol> r8) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r9, "protocols");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            List r3 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin"));
            boolean r5 = false;
            if (r3.contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L32;
            if (r3.contains(Protocol.H2_PRIOR_KNOWLEDGE) == true) goto L13;
        L14:
            r5 = true;
        L15:
            if (r5 == false) goto L30;
            if ((!r3.contains(Protocol.HTTP_1_0)) == false) goto L28;
            if (r3 == null) goto L26;
            if ((!r3.contains(null)) == false) goto L24;
            r3.remove(Protocol.SPDY_3);
            List<? extends Protocol> r10 = Collections.unmodifiableList(r9);
            Intrinsics.checkExpressionValueIsNotNull(r10, "Collections.unmodifiableList(protocols)");
            r1.protocols = r10;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L24:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("protocols must not contain null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L26:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
        L28:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("protocols must not contain http/1.0: " + r3).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L30:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + r3).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L13:
            if (r3.size() > 1) goto L15;
        L32:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + r3).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            if (r3.contains(Protocol.HTTP_1_1) == true) goto L8;
            r4 = false;
            goto L9
        }

        public final Builder proxy(Proxy r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).proxy = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder proxyAuthenticator(Authenticator r4) {
            Authenticator r5 = (Authenticator) ZeusTransformUtils.wrapperContextForParams(r4, Authenticator.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "proxyAuthenticator");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).proxyAuthenticator = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder proxySelector(ProxySelector r4) {
            Intrinsics.checkParameterIsNotNull(r4, "proxySelector");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).proxySelector = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder readTimeout(long r5, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, Scraps.INNER_UNIT);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.readTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r5, r7);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder readTimeout(Duration r7) {
            Intrinsics.checkParameterIsNotNull(r7, "duration");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.readTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r7.toMillis(), TimeUnit.MILLISECONDS);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder retryOnConnectionFailure(boolean r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).retryOnConnectionFailure = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final void setAuthenticator$okhttp(Authenticator r3) {
            Authenticator r4 = (Authenticator) ZeusTransformUtils.wrapperContextForParams(r3, Authenticator.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.authenticator = r4;
        }

        public final void setCache$okhttp(Cache r1) {
            this.cache = r1;
        }

        public final void setCallTimeout$okhttp(int r1) {
            this.callTimeout = r1;
        }

        public final void setCertificateChainCleaner$okhttp(CertificateChainCleaner r1) {
            this.certificateChainCleaner = r1;
        }

        public final void setCertificatePinner$okhttp(CertificatePinner r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.certificatePinner = r2;
        }

        public final void setConnectTimeout$okhttp(int r1) {
            this.connectTimeout = r1;
        }

        public final void setConnectionPool$okhttp(ConnectionPool r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.connectionPool = r2;
        }

        public final void setConnectionSpecs$okhttp(List<ConnectionSpec> r3) {
            List<ConnectionSpec> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.connectionSpecs = r4;
        }

        public final void setCookieJar$okhttp(CookieJar r3) {
            CookieJar r4 = (CookieJar) ZeusTransformUtils.wrapperContextForParams(r3, CookieJar.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.cookieJar = r4;
        }

        public final void setDispatcher$okhttp(Dispatcher r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.dispatcher = r2;
        }

        public final void setDns$okhttp(Dns r3) {
            Dns r4 = (Dns) ZeusTransformUtils.wrapperContextForParams(r3, Dns.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.dns = r4;
        }

        public final void setEventListenerFactory$okhttp(EventListener.Factory r3) {
            EventListener.Factory r4 = (EventListener.Factory) ZeusTransformUtils.wrapperContextForParams(r3, EventListener.Factory.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.eventListenerFactory = r4;
        }

        public final void setFollowRedirects$okhttp(boolean r1) {
            this.followRedirects = r1;
        }

        public final void setFollowSslRedirects$okhttp(boolean r1) {
            this.followSslRedirects = r1;
        }

        public final void setHostnameVerifier$okhttp(HostnameVerifier r3) {
            HostnameVerifier r4 = (HostnameVerifier) ZeusTransformUtils.wrapperContextForParams(r3, HostnameVerifier.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.hostnameVerifier = r4;
        }

        public final void setPingInterval$okhttp(int r1) {
            this.pingInterval = r1;
        }

        public final void setProtocols$okhttp(List<? extends Protocol> r3) {
            List<? extends Protocol> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.protocols = r4;
        }

        public final void setProxy$okhttp(Proxy r1) {
            this.proxy = r1;
        }

        public final void setProxyAuthenticator$okhttp(Authenticator r3) {
            Authenticator r4 = (Authenticator) ZeusTransformUtils.wrapperContextForParams(r3, Authenticator.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.proxyAuthenticator = r4;
        }

        public final void setProxySelector$okhttp(ProxySelector r1) {
            this.proxySelector = r1;
        }

        public final void setReadTimeout$okhttp(int r1) {
            this.readTimeout = r1;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean r1) {
            this.retryOnConnectionFailure = r1;
        }

        public final void setSocketFactory$okhttp(SocketFactory r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.socketFactory = r2;
        }

        public final void setSslSocketFactoryOrNull$okhttp(SSLSocketFactory r1) {
            this.sslSocketFactoryOrNull = r1;
        }

        public final void setWriteTimeout$okhttp(int r1) {
            this.writeTimeout = r1;
        }

        public final void setX509TrustManagerOrNull$okhttp(X509TrustManager r3) {
            this.x509TrustManagerOrNull = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin");
        }

        public final Builder socketFactory(SocketFactory r5) {
            Intrinsics.checkParameterIsNotNull(r5, "socketFactory");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if ((!ZeusTransformUtils.instanceOf(r5, SSLSocketFactory.class)) == false) goto L7;
            r2.socketFactory = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        public final Builder sslSocketFactory(SSLSocketFactory r5) {
            Intrinsics.checkParameterIsNotNull(r5, "sslSocketFactory");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.sslSocketFactoryOrNull = r5;
            r2.certificateChainCleaner = Platform.Companion.get().buildCertificateChainCleaner(r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder sslSocketFactory(SSLSocketFactory r4, X509TrustManager r5) {
            X509TrustManager r6 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r5, X509TrustManager.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "sslSocketFactory");
            Intrinsics.checkParameterIsNotNull(r6, "trustManager");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r1.sslSocketFactoryOrNull = r4;
            r1.certificateChainCleaner = CertificateChainCleaner.Companion.get(r6);
            r1.x509TrustManagerOrNull = r6;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder writeTimeout(long r5, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, Scraps.INNER_UNIT);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.writeTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r5, r7);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder writeTimeout(Duration r7) {
            Intrinsics.checkParameterIsNotNull(r7, "duration");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.writeTimeout = Util.checkDuration(LocationMonitorConst.TIMEOUT, r7.toMillis(), TimeUnit.MILLISECONDS);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000f"}, d2 = {"Lokhttp3/OkHttpClient$Companion;", "", "()V", "DEFAULT_CONNECTION_SPECS", "", "Lokhttp3/ConnectionSpec;", "getDEFAULT_CONNECTION_SPECS$okhttp", "()Ljava/util/List;", "DEFAULT_PROTOCOLS", "Lokhttp3/Protocol;", "getDEFAULT_PROTOCOLS$okhttp", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ SSLSocketFactory access$newSslSocketFactory(Companion r2, X509TrustManager r3) {
            return r2.newSslSocketFactory((X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin"));
        }

        private final SSLSocketFactory newSslSocketFactory(X509TrustManager r5) {
            X509TrustManager r4 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r5, X509TrustManager.class, "com.obric.memorydata.plugin");
            SSLContext r6 = Platform.Companion.get().newSSLContext();     // Catch: GeneralSecurityException -> L5
            r6.init(null, new TrustManager[]{(TrustManager) ZeusTransformUtils.preCheckCast(r4, TrustManager.class, "com.obric.memorydata.plugin")}, null);     // Catch: GeneralSecurityException -> L5
            SSLSocketFactory r7 = r6.getSocketFactory();     // Catch: GeneralSecurityException -> L5
            Intrinsics.checkExpressionValueIsNotNull(r7, "sslContext.socketFactory");     // Catch: GeneralSecurityException -> L5
            return r7;
        L5:
            e = move-exception;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("No System TLS", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.access$getDEFAULT_CONNECTION_SPECS$cp();
        }

        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.access$getDEFAULT_PROTOCOLS$cp();
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT_PROTOCOLS = Util.immutableListOf(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        DEFAULT_CONNECTION_SPECS = Util.immutableListOf(new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public OkHttpClient(Builder r6) {
        Intrinsics.checkParameterIsNotNull(r6, "builder");
        this.dispatcher = r6.getDispatcher$okhttp();
        this.connectionPool = r6.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(r6.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(r6.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = r6.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = r6.getRetryOnConnectionFailure$okhttp();
        this.authenticator = r6.getAuthenticator$okhttp();
        this.followRedirects = r6.getFollowRedirects$okhttp();
        this.followSslRedirects = r6.getFollowSslRedirects$okhttp();
        this.cookieJar = r6.getCookieJar$okhttp();
        this.cache = r6.getCache$okhttp();
        this.dns = r6.getDns$okhttp();
        this.proxy = r6.getProxy$okhttp();
        if (r6.getProxy$okhttp() == null) goto L5;
    L4:
        ProxySelector r0 = (ProxySelector) ZeusTransformUtils.preCheckCast(NullProxySelector.INSTANCE, ProxySelector.class, "com.obric.memorydata.plugin");
    L10:
        this.proxySelector = r0;
        this.proxyAuthenticator = r6.getProxyAuthenticator$okhttp();
        this.socketFactory = r6.getSocketFactory$okhttp();
        List<ConnectionSpec> r1 = r6.getConnectionSpecs$okhttp();
        this.connectionSpecs = r1;
        this.protocols = r6.getProtocols$okhttp();
        this.hostnameVerifier = r6.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = r6.getCallTimeout$okhttp();
        this.connectTimeoutMillis = r6.getConnectTimeout$okhttp();
        this.readTimeoutMillis = r6.getReadTimeout$okhttp();
        this.writeTimeoutMillis = r6.getWriteTimeout$okhttp();
        this.pingIntervalMillis = r6.getPingInterval$okhttp();
        if (r6.getSslSocketFactoryOrNull$okhttp() != null) goto L32;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L15;
    L17:
        Iterator r3 = r2.iterator();
    L19:
        if (r3.hasNext() == false) goto L16;
        if (((ConnectionSpec) ZeusTransformUtils.preCheckCast(r3.next(), ConnectionSpec.class, "com.obric.memorydata.plugin")).isTls() == false) goto L19;
        boolean r4 = false;
    L23:
        if (r4 == true) goto L32;
        X509TrustManager r5 = Platform.Companion.get().platformTrustManager();
        this.x509TrustManager = r5;
        Platform.Companion.get().configureTrustManager(r5);
        Companion r7 = Companion;
        if (r5 != null) goto L28;
        Intrinsics.throwNpe();
    L28:
        this.sslSocketFactoryOrNull = Companion.access$newSslSocketFactory(r7, r5);
        CertificateChainCleaner.Companion r8 = CertificateChainCleaner.Companion;
        if (r5 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        this.certificateChainCleaner = r8.get(r5);
    L34:
        if (this.sslSocketFactoryOrNull == null) goto L36;
        Platform.Companion.get().configureSslSocketFactory(this.sslSocketFactoryOrNull);
    L36:
        this.certificatePinner = r6.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(this.certificateChainCleaner);
        List<Interceptor> r9 = this.interceptors;
        if (r9 == null) goto L52;
        if ((!r9.contains(null)) == false) goto L50;
        List<Interceptor> r10 = this.networkInterceptors;
        if (r10 == null) goto L48;
        if ((!r10.contains(null)) == false) goto L46;
        return;
    L46:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L48:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    L50:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("Null interceptor: " + this.interceptors).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L52:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    L16:
        r4 = true;
        goto L23
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
    L32:
        this.sslSocketFactoryOrNull = r6.getSslSocketFactoryOrNull$okhttp();
        this.certificateChainCleaner = r6.getCertificateChainCleaner$okhttp();
        this.x509TrustManager = r6.getX509TrustManagerOrNull$okhttp();
        goto L34
    L5:
        r0 = r6.getProxySelector$okhttp();
        if (r0 != null) goto L9;
        r0 = ProxySelector.getDefault();
    L9:
        if (r0 == null) goto L4;
        goto L4
    }

    public static final /* synthetic */ List access$getDEFAULT_CONNECTION_SPECS$cp() {
        return DEFAULT_CONNECTION_SPECS;
    }

    public static final /* synthetic */ List access$getDEFAULT_PROTOCOLS$cp() {
        return DEFAULT_PROTOCOLS;
    }

    public static final /* synthetic */ SSLSocketFactory access$getSslSocketFactoryOrNull$p(OkHttpClient r0) {
        return r0.sslSocketFactoryOrNull;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authenticator", imports = {}))
    /* JADX INFO: renamed from: -deprecated_authenticator, reason: not valid java name */
    public final Authenticator m2997deprecated_authenticator() {
        return this.authenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cache", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cache, reason: not valid java name */
    public final Cache m2998deprecated_cache() {
        return this.cache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "callTimeoutMillis", imports = {}))
    /* JADX INFO: renamed from: -deprecated_callTimeoutMillis, reason: not valid java name */
    public final int m2999deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "certificatePinner", imports = {}))
    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m3000deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectTimeoutMillis", imports = {}))
    /* JADX INFO: renamed from: -deprecated_connectTimeoutMillis, reason: not valid java name */
    public final int m3001deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionPool", imports = {}))
    /* JADX INFO: renamed from: -deprecated_connectionPool, reason: not valid java name */
    public final ConnectionPool m3002deprecated_connectionPool() {
        return this.connectionPool;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionSpecs", imports = {}))
    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m3003deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cookieJar", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cookieJar, reason: not valid java name */
    public final CookieJar m3004deprecated_cookieJar() {
        return this.cookieJar;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dispatcher", imports = {}))
    /* JADX INFO: renamed from: -deprecated_dispatcher, reason: not valid java name */
    public final Dispatcher m3005deprecated_dispatcher() {
        return this.dispatcher;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dns", imports = {}))
    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m3006deprecated_dns() {
        return this.dns;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "eventListenerFactory", imports = {}))
    /* JADX INFO: renamed from: -deprecated_eventListenerFactory, reason: not valid java name */
    public final EventListener.Factory m3007deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followRedirects", imports = {}))
    /* JADX INFO: renamed from: -deprecated_followRedirects, reason: not valid java name */
    public final boolean m3008deprecated_followRedirects() {
        return this.followRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followSslRedirects", imports = {}))
    /* JADX INFO: renamed from: -deprecated_followSslRedirects, reason: not valid java name */
    public final boolean m3009deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostnameVerifier", imports = {}))
    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m3010deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "interceptors", imports = {}))
    /* JADX INFO: renamed from: -deprecated_interceptors, reason: not valid java name */
    public final List<Interceptor> m3011deprecated_interceptors() {
        return this.interceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkInterceptors", imports = {}))
    /* JADX INFO: renamed from: -deprecated_networkInterceptors, reason: not valid java name */
    public final List<Interceptor> m3012deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pingIntervalMillis", imports = {}))
    /* JADX INFO: renamed from: -deprecated_pingIntervalMillis, reason: not valid java name */
    public final int m3013deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocols", imports = {}))
    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m3014deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m3015deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxyAuthenticator", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m3016deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxySelector", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m3017deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "readTimeoutMillis", imports = {}))
    /* JADX INFO: renamed from: -deprecated_readTimeoutMillis, reason: not valid java name */
    public final int m3018deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "retryOnConnectionFailure", imports = {}))
    /* JADX INFO: renamed from: -deprecated_retryOnConnectionFailure, reason: not valid java name */
    public final boolean m3019deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketFactory", imports = {}))
    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m3020deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslSocketFactory", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m3021deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "writeTimeoutMillis", imports = {}))
    /* JADX INFO: renamed from: -deprecated_writeTimeoutMillis, reason: not valid java name */
    public final int m3022deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final Authenticator authenticator() {
        return this.authenticator;
    }

    public final Cache cache() {
        return this.cache;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public Object clone() {
        return super.clone();
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public final Dns dns() {
        return this.dns;
    }

    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request r3) {
        Intrinsics.checkParameterIsNotNull(r3, Ext.KEY_REQUEST);
        return (Call) ZeusTransformUtils.preCheckCast(RealCall.Companion.newRealCall(this, r3, false), Call.class, "com.obric.memorydata.plugin");
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request r8, WebSocketListener r9) {
        Intrinsics.checkParameterIsNotNull(r8, Ext.KEY_REQUEST);
        Intrinsics.checkParameterIsNotNull(r9, "listener");
        RealWebSocket r0 = new RealWebSocket(r8, r9, new Random(), this.pingIntervalMillis);
        r0.connect(this);
        return (WebSocket) ZeusTransformUtils.preCheckCast(r0, WebSocket.class, "com.obric.memorydata.plugin");
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory r2 = this.sslSocketFactoryOrNull;
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("CLEARTEXT-only client"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }
}
