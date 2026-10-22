package okhttp3;

import android.text.TextUtils;
import hvc.g;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import jvc.d;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class OkHttpClient implements Cloneable, Call.a {
    static final List<f> DEFAULT_CONNECTION_SPECS = null;
    static final List<Protocol> DEFAULT_PROTOCOLS = null;
    final b authenticator;

    @Nullable
    final Cache cache;
    final int callTimeout;
    final jvc.c certificateChainCleaner;
    final c certificatePinner;
    final int connectTimeout;
    final ConnectionPool connectionPool;
    final List<f> connectionSpecs;
    final h cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final boolean enableBoe;
    final i.c eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;

    @Nullable
    final dvc.i internalCache;
    final List<Interceptor> networkInterceptors;
    final int pingInterval;
    final List<Protocol> protocols;

    @Nullable
    final Proxy proxy;
    final b proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final TTNetDns ttnetDns;
    final int writeTimeout;

    public static final class Builder {
        b authenticator;

        @Nullable
        Cache cache;
        int callTimeout;

        @Nullable
        jvc.c certificateChainCleaner;
        c certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<f> connectionSpecs;
        h cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        boolean enableBoe;
        i.c eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;

        @Nullable
        dvc.i internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;

        @Nullable
        Proxy proxy;
        b proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;

        @Nullable
        SSLSocketFactory sslSocketFactory;

        @Nullable
        TTNetDns ttnetDns;
        int writeTimeout;

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = i.factory(i.NONE);
            ProxySelector r0 = ProxySelector.getDefault();
            this.proxySelector = r0;
            if (r0 != null) goto L5;
            this.proxySelector = new ivc.a();
        L5:
            this.cookieJar = h.a;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = d.a;
            this.certificatePinner = c.c;
            b.a r1 = b.a;
            this.proxyAuthenticator = r1;
            this.authenticator = r1;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
            this.ttnetDns = null;
            this.enableBoe = false;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder(OkHttpClient r4) {
            ArrayList r0 = new ArrayList();
            this.interceptors = r0;
            ArrayList r1 = new ArrayList();
            this.networkInterceptors = r1;
            this.dispatcher = r4.dispatcher;
            this.proxy = r4.proxy;
            this.protocols = r4.protocols;
            this.connectionSpecs = r4.connectionSpecs;
            r0.addAll(r4.interceptors);
            r1.addAll(r4.networkInterceptors);
            this.eventListenerFactory = r4.eventListenerFactory;
            this.proxySelector = r4.proxySelector;
            this.cookieJar = r4.cookieJar;
            this.internalCache = r4.internalCache;
            this.cache = r4.cache;
            this.socketFactory = r4.socketFactory;
            this.sslSocketFactory = r4.sslSocketFactory;
            this.certificateChainCleaner = r4.certificateChainCleaner;
            this.hostnameVerifier = r4.hostnameVerifier;
            this.certificatePinner = r4.certificatePinner;
            this.proxyAuthenticator = r4.proxyAuthenticator;
            this.authenticator = r4.authenticator;
            this.connectionPool = r4.connectionPool;
            this.dns = r4.dns;
            this.followSslRedirects = r4.followSslRedirects;
            this.followRedirects = r4.followRedirects;
            this.retryOnConnectionFailure = r4.retryOnConnectionFailure;
            this.callTimeout = r4.callTimeout;
            this.connectTimeout = r4.connectTimeout;
            this.readTimeout = r4.readTimeout;
            this.writeTimeout = r4.writeTimeout;
            this.pingInterval = r4.pingInterval;
            this.ttnetDns = r4.ttnetDns;
            this.enableBoe = r4.enableBoe;
        }

        public Builder addInterceptor(Interceptor r2) {
            if (r2 == null) goto L6;
            this.interceptors.add(r2);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addNetworkInterceptor(Interceptor r2) {
            if (r2 == null) goto L6;
            this.networkInterceptors.add(r2);
            return this;
        L6:
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder authenticator(b r2) {
            if (r2 == null) goto L6;
            this.authenticator = r2;
            return this;
        L6:
            throw new NullPointerException("authenticator == null");
        }

        public Builder cache(@Nullable Cache r1) {
            this.cache = r1;
            this.internalCache = null;
            return this;
        }

        public Builder callTimeout(Duration r4) {
            this.callTimeout = cvc.c.d("timeout", r4.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder certificatePinner(c r2) {
            if (r2 == null) goto L6;
            this.certificatePinner = r2;
            return this;
        L6:
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder connectTimeout(Duration r4) {
            this.connectTimeout = cvc.c.d("timeout", r4.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectionPool(ConnectionPool r2) {
            if (r2 == null) goto L6;
            this.connectionPool = r2;
            return this;
        L6:
            throw new NullPointerException("connectionPool == null");
        }

        public Builder connectionSpecs(List<f> r1) {
            this.connectionSpecs = cvc.c.n(r1);
            return this;
        }

        public Builder cookieJar(h r2) {
            if (r2 == null) goto L6;
            this.cookieJar = r2;
            return this;
        L6:
            throw new NullPointerException("cookieJar == null");
        }

        public Builder dispatcher(Dispatcher r2) {
            if (r2 == null) goto L6;
            this.dispatcher = r2;
            return this;
        L6:
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder dns(Dns r2) {
            if (r2 == null) goto L6;
            this.dns = r2;
            return this;
        L6:
            throw new NullPointerException("dns == null");
        }

        public Builder enableBoe(boolean r1) {
            this.enableBoe = r1;
            return this;
        }

        public Builder eventListener(i r2) {
            if (r2 == null) goto L6;
            this.eventListenerFactory = i.factory(r2);
            return this;
        L6:
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(i.c r2) {
            if (r2 == null) goto L6;
            this.eventListenerFactory = r2;
            return this;
        L6:
            throw new NullPointerException("eventListenerFactory == null");
        }

        public Builder followRedirects(boolean r1) {
            this.followRedirects = r1;
            return this;
        }

        public Builder followSslRedirects(boolean r1) {
            this.followSslRedirects = r1;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier r2) {
            if (r2 == null) goto L6;
            this.hostnameVerifier = r2;
            return this;
        L6:
            throw new NullPointerException("hostnameVerifier == null");
        }

        public Builder pingInterval(Duration r4) {
            this.pingInterval = cvc.c.d("timeout", r4.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder protocols(List<Protocol> r4) {
            ArrayList r0 = new ArrayList(r4);
            Protocol r5 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (r0.contains(r5) == true) goto L10;
            if (r0.contains(Protocol.HTTP_1_1) == true) goto L10;
            throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + r0);
        L10:
            if (r0.contains(r5) == false) goto L17;
            if (r0.size() <= 1) goto L17;
            throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + r0);
        L17:
            if (r0.contains(Protocol.HTTP_1_0) == true) goto L25;
            if (r0.contains(null) == true) goto L23;
            r0.remove(Protocol.SPDY_3);
            this.protocols = Collections.unmodifiableList(r0);
            return this;
        L23:
            throw new IllegalArgumentException("protocols must not contain null");
        L25:
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + r0);
        }

        public Builder proxy(@Nullable Proxy r1) {
            this.proxy = r1;
            return this;
        }

        public Builder proxyAuthenticator(b r2) {
            if (r2 == null) goto L6;
            this.proxyAuthenticator = r2;
            return this;
        L6:
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder proxySelector(ProxySelector r2) {
            if (r2 == null) goto L6;
            this.proxySelector = r2;
            return this;
        L6:
            throw new NullPointerException("proxySelector == null");
        }

        public Builder readTimeout(Duration r4) {
            this.readTimeout = cvc.c.d("timeout", r4.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean r1) {
            this.retryOnConnectionFailure = r1;
            return this;
        }

        public void setInternalCache(@Nullable dvc.i r1) {
            this.internalCache = r1;
            this.cache = null;
        }

        public Builder socketFactory(SocketFactory r2) {
            if (r2 == null) goto L6;
            this.socketFactory = r2;
            return this;
        L6:
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory r5) {
            if (r5 == null) goto L10;
            this.sslSocketFactory = r5;
            g r0 = g.a;
            X509TrustManager r1 = r0.p(r5);
            if (r1 == null) goto L8;
            this.certificateChainCleaner = r0.d(r1);
            return this;
        L8:
            throw new IllegalStateException("Unable to extract the trust manager on " + r0 + ", sslSocketFactory is " + r5.getClass());
        L10:
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder ttnetDns(TTNetDns r2) {
            if (r2 == null) goto L6;
            this.ttnetDns = r2;
            return this;
        L6:
            throw new NullPointerException("ttnetDns == null");
        }

        public Builder writeTimeout(Duration r4) {
            this.writeTimeout = cvc.c.d("timeout", r4.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder callTimeout(long r2, TimeUnit r4) {
            this.callTimeout = cvc.c.d("timeout", r2, r4);
            return this;
        }

        public Builder connectTimeout(long r2, TimeUnit r4) {
            this.connectTimeout = cvc.c.d("timeout", r2, r4);
            return this;
        }

        public Builder pingInterval(long r2, TimeUnit r4) {
            this.pingInterval = cvc.c.d("interval", r2, r4);
            return this;
        }

        public Builder readTimeout(long r2, TimeUnit r4) {
            this.readTimeout = cvc.c.d("timeout", r2, r4);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory r1, X509TrustManager r2) {
            if (r1 == null) goto L9;
            if (r2 == null) goto L7;
            this.sslSocketFactory = r1;
            this.certificateChainCleaner = g.a.d(r2);
            return this;
        L7:
            throw new NullPointerException("trustManager == null");
        L9:
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder writeTimeout(long r2, TimeUnit r4) {
            this.writeTimeout = cvc.c.d("timeout", r2, r4);
            return this;
        }
    }

    public static class a extends cvc.a {
        public a() {
        }

        public final int a(Response.Builder r1) {
            return r1.code;
        }

        public final okhttp3.internal.connection.e b(ConnectionPool r1) {
            return r1.routeDatabase;
        }
    }

    static {
        DEFAULT_PROTOCOLS = cvc.c.o(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        DEFAULT_CONNECTION_SPECS = cvc.c.o(new f[]{f.e, f.g});
        cvc.a.a = new a();
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public dvc.i internalCache() {
        Cache r0 = this.cache;
        if (r0 == null) goto L6;
        return r0.internalCache;
    L6:
        return this.internalCache;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public b authenticator() {
        return this.authenticator;
    }

    @Nullable
    public Cache cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public c certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public List<f> connectionSpecs() {
        return this.connectionSpecs;
    }

    public h cookieJar() {
        return this.cookieJar;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public boolean enableBoe() {
        return this.enableBoe;
    }

    public i.c eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public b proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public TTNetDns ttnetDns() {
        return this.ttnetDns;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public OkHttpClient(Builder r7) {
        this.dispatcher = r7.dispatcher;
        this.proxy = r7.proxy;
        this.protocols = r7.protocols;
        List<f> r0 = r7.connectionSpecs;
        this.connectionSpecs = r0;
        this.interceptors = cvc.c.n(r7.interceptors);
        this.networkInterceptors = cvc.c.n(r7.networkInterceptors);
        this.eventListenerFactory = r7.eventListenerFactory;
        this.proxySelector = r7.proxySelector;
        this.cookieJar = r7.cookieJar;
        this.cache = r7.cache;
        this.internalCache = r7.internalCache;
        this.socketFactory = r7.socketFactory;
        Iterator<f> r1 = r0.iterator();
    L3:
        boolean r2 = false;
    L5:
        if (r1.hasNext() == false) goto L11;
        f r3 = r1.next();
        if (r2 == true) goto L10;
        if (r3.a == false) goto L3;
    L10:
        r2 = true;
        goto L5
    L11:
        SSLSocketFactory r4 = r7.sslSocketFactory;
        if (r4 != null) goto L27;
        if (r2 == false) goto L27;
        TrustManagerFactory r5 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: GeneralSecurityException -> L24
        r5.init(null);     // Catch: GeneralSecurityException -> L24
        TrustManager[] r6 = r5.getTrustManagers();     // Catch: GeneralSecurityException -> L24
        if (r6.length != 1) goto L23;
        TrustManager r8 = r6[0];     // Catch: GeneralSecurityException -> L24
        if ((r8 instanceof X509TrustManager) == false) goto L23;
        X509TrustManager r9 = (X509TrustManager) r8;     // Catch: GeneralSecurityException -> L24
        this.sslSocketFactory = newSslSocketFactory(r9);
        this.certificateChainCleaner = g.a.d(r9);
    L28:
        SSLSocketFactory r10 = this.sslSocketFactory;
        if (r10 == null) goto L31;
        g.a.f(r10);
    L31:
        this.hostnameVerifier = r7.hostnameVerifier;
        c r11 = r7.certificatePinner;
        jvc.c r12 = this.certificateChainCleaner;
        if (cvc.c.k(r11.b, r12) == true) goto L35;
        r11 = new c(r11.a, r12);
    L35:
        this.certificatePinner = r11;
        this.proxyAuthenticator = r7.proxyAuthenticator;
        this.authenticator = r7.authenticator;
        this.connectionPool = r7.connectionPool;
        this.dns = r7.dns;
        this.followSslRedirects = r7.followSslRedirects;
        this.followRedirects = r7.followRedirects;
        this.retryOnConnectionFailure = r7.retryOnConnectionFailure;
        this.callTimeout = r7.callTimeout;
        this.connectTimeout = r7.connectTimeout;
        this.readTimeout = r7.readTimeout;
        this.writeTimeout = r7.writeTimeout;
        this.pingInterval = r7.pingInterval;
        this.ttnetDns = r7.ttnetDns;
        this.enableBoe = r7.enableBoe;
        if (this.interceptors.contains(null) == true) goto L43;
        if (this.networkInterceptors.contains(null) == true) goto L41;
        return;
    L41:
        throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
    L43:
        throw new IllegalStateException("Null interceptor: " + this.interceptors);
    L23:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r6));     // Catch: GeneralSecurityException -> L24
    L24:
        e = move-exception;
        throw cvc.c.a("No System TLS", e);
    L27:
        this.sslSocketFactory = r4;
        this.certificateChainCleaner = r7.certificateChainCleaner;
        goto L28
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager r3) {
        SSLContext r0 = g.a.i();     // Catch: GeneralSecurityException -> L4
        r0.init(null, new TrustManager[]{r3}, null);     // Catch: GeneralSecurityException -> L4
        return r0.getSocketFactory();
    L4:
        e = move-exception;
        throw cvc.c.a("No System TLS", e);
    }

    @Override // okhttp3.Call.a
    public Call newCall(Request r2) {
        return l.c(this, r2, false);
    }

    public WebSocket newWebSocket(Request r8, WebSocketListener r9) {
        kvc.a r6 = new kvc.a(r8, r9, new Random(), this.pingInterval);
        OkHttpClient r10 = newBuilder().eventListener(i.NONE).protocols(kvc.a.v).build();
        Request r11 = r6.a.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", r6.e).header("Sec-WebSocket-Version", "13").build();
        cvc.a.a.getClass();
        l r12 = l.c(r10, r11, true);
        r6.f = r12;
        r12.c.c = 0;
        r12.enqueue(new kvc.b(r6, r11));
        return r6;
    }

    public int pingIntervalMillisWithHostPort(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        if (TTConfigManager.inst().getPingKeepAliveHosts().contains(r2 + ":" + r3) == false) goto L9;
        return TTConfigManager.inst().getPingKeepAliveInterval();
    L9:
        return this.pingInterval;
    }
}
