package evc;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import cvc.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTConfigManager$a;
import okhttp3.ttnet.TTNetUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements Interceptor {
    public static final List<String> g = null;
    public final OkHttpClient a;
    public volatile StreamAllocation b;
    public Object c;
    public volatile boolean d;
    public volatile int e;
    public volatile boolean f;

    static {
        g = c.o(new String[]{"Accept", "Accept-Charset", DownloadHelper.ACCEPT_ENCODING, "Accept-Language", "Authorization", DownloadHelper.CACHE_CONTROL, "Connection", DownloadUtils.CONTENT_LENGTH, DownloadHelper.CONTENT_TYPE, DownloadConstants.HOST, DownloadHelper.IF_MATCH, "If-Modified-Since", DownloadHelper.IF_NONE_MATCH, "If-Range", "If-Unmodified-Since", "Origin", "Pragma", "Proxy-Authorization", "Proxy-Connection", "Range", "Referer", DownloadHelper.TRANSFER_ENCODING, DownloadConstants.USER_AGENT});
    }

    public i(OkHttpClient r2) {
        this.e = -1;
        this.f = false;
        this.a = r2;
    }

    public final okhttp3.a a(HttpUrl r17) {
        if (r17.isHttps() == false) goto L5;
        SSLSocketFactory r1 = this.a.sslSocketFactory();
        SSLSocketFactory r7 = r1;
        HostnameVerifier r8 = this.a.hostnameVerifier();
        okhttp3.c r9 = this.a.certificatePinner();
    L7:
        return new okhttp3.a(r17.host(), r17.port(), this.a.dns(), this.a.socketFactory(), r7, r8, r9, this.a.proxyAuthenticator(), this.a.proxy(), this.a.protocols(), this.a.connectionSpecs(), this.a.proxySelector(), this.a.ttnetDns());
    L5:
        r7 = null;
        r8 = null;
        r9 = null;
        goto L7
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r15) throws IOException {
        Request r0 = r15.request();
        RealInterceptorChain r16 = (RealInterceptorChain) r15;
        Call r7 = r16.call();
        okhttp3.i r8 = r16.eventListener();
        StreamAllocation r9 = new StreamAllocation(this.a.connectionPool(), a(r0.url()), r7, r8, this.c);
        this.b = r9;
        Response r1 = null;
        int r2 = 0;
    L4:
        if (this.d == true) goto L46;
        Response r3 = r16.proceed(r0, r9, null, null);     // Catch: Throwable -> L27 IOException -> L29 RouteException -> L38
    L6:
        if (r1 == null) goto L50;
        r3 = r3.newBuilder().priorResponse(r1.newBuilder().body(null).build()).build();
    L50:
        Request r12 = b(r3, r9.route(), r7, r8);     // Catch: IOException -> L24
        if (r12 == null) goto L10;
        c.e(r3.body());
        int r13 = r2 + 1;
        if (r13 > 20) goto L22;
        r12.body();
        if (e(r3, r12.url()) == true) goto L18;
        r9.release();
        r9 = new StreamAllocation(this.a.connectionPool(), a(r12.url()), r7, r8, this.c);
        this.b = r9;
    L19:
        r1 = r3;
        r0 = r12;
        r2 = r13;
        goto L4
    L18:
        if (r9.codec() == null) goto L19;
        throw new IllegalStateException("Closing the body of " + r3 + " didn't close its backing stream. Bad interceptor?");
    L22:
        r9.release();
        throw new ProtocolException("Too many follow-up requests: " + r13);
    L10:
        r9.release();
        return r3;
    L24:
        e = move-exception;
        r9.release();
        throw e;
    L27:
        th = move-exception;
        r9.streamFailed(null);
        r9.release();
        throw th;
    L29:
        e = move-exception;
        if ((e instanceof ConnectionShutdownException) == true) goto L33;
        boolean r4 = true;
    L35:
        if (c(e, r9, r4, r0) == true) goto L4;
        throw e;     // Catch: Throwable -> L27
    L33:
        r4 = false;
    L38:
        e = move-exception;
        if (c(e.getLastConnectException(), r9, false, r0) == true) goto L4;
        throw e.getFirstConnectException();     // Catch: Throwable -> L27
    L46:
        r9.release();
        throw new IOException("Canceled#Reason=" + this.e);
    }

    public static int d(Response r1, int r2) {
        String r3 = r1.header("Retry-After");
        if (r3 != null) goto L6;
        return r2;
    L6:
        if (r3.matches("\\d+") == true) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return CastIntegerProtector.valueOf(r3).intValue();
    }

    public static boolean e(Response r2, HttpUrl r3) {
        HttpUrl r4 = r2.request().url();
        if (r4.host().equals(r3.host()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r4.port() != r3.port()) goto L9;
        if (r4.scheme().equals(r3.scheme()) == false) goto L9;
        return true;
    }

    public final boolean f(IOException r5, Request r6) {
        if (this.f == false) goto L5;
        return false;
    L5:
        this.f = true;
        int r2 = TTNetUtils.convertExceptionToErrorCode(r5);
        if (TTConfigManager.inst().shouldRetryForceHttpdnsOnError(r5, r6, r2) == false) goto L26;
        this.b.resetRouteSelector(r2);
        if (lvc.a.b == null) goto L10;
    L19:
        lvc.a r7 = lvc.a.b;
        r7.getClass();
        if (r6.url() != null) goto L22;
    L25:
        return true;
    L22:
        if (TextUtils.isEmpty(r6.url().host()) == true) goto L25;
        String r8 = r6.url().host();
        r7.a.add(r8);
        goto L25
    L10:
        monitor-enter(lvc.a.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (lvc.a.b != null) goto L14;
        lvc.a.b = new lvc.a();     // Catch: Throwable -> L16
    L14:
        monitor-exit(lvc.a.class);     // Catch: Throwable -> L16
        goto L19
    L26:
        return false;
    }

    public final Request b(Response r17, Route r18, Call r19, okhttp3.i r20) throws IOException {
        if (r17 == null) goto L143;
        int r2 = r17.code();
        String r3 = r17.request().method();
        RequestBody r5 = null;
        boolean r7 = false;
        if (r2 == 307) goto L49;
        if (r2 == 308) goto L49;
        if (r2 != 401) goto L10;
        this.a.authenticator().getClass();
        return null;
    L10:
        if (r2 == 503) goto L37;
        if (r2 == 407) goto L31;
        if (r2 == 408) goto L18;
        switch(r2) {
            case 300: goto L49;
            case 301: goto L49;
            case 302: goto L49;
            case 303: goto L49;
            default: goto L16;
        };
    L16:
        return null;
    L18:
        if (this.a.retryOnConnectionFailure() == true) goto L20;
        return null;
    L20:
        r17.request().body();
        if (r17.priorResponse() == null) goto L26;
        if (r17.priorResponse().code() != 408) goto L26;
        return null;
    L26:
        if (d(r17, 0) <= 0) goto L29;
        return null;
    L29:
        return r17.request();
    L31:
        if (r18.proxy().type() != Proxy.Type.HTTP) goto L35;
        this.a.proxyAuthenticator().getClass();
        return null;
    L35:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L37:
        if (r17.priorResponse() == null) goto L42;
        if (r17.priorResponse().code() != 503) goto L42;
        return null;
    L42:
        if (d(r17, Integer.MAX_VALUE) == 0) goto L44;
        return null;
    L44:
        return r17.request();
    L49:
        if (this.a.followRedirects() == true) goto L51;
        return null;
    L51:
        String r8 = r17.header("Location");
        if (r8 != null) goto L54;
        return null;
    L54:
        HttpUrl r9 = r17.request().url().resolve(r8);
        if (r9 != null) goto L58;
        return null;
    L58:
        if (r9.scheme().equals(r17.request().url().scheme()) == false) goto L60;
    L62:
        Request.Builder r10 = r17.request().newBuilder();
        if (f.b(r3) == false) goto L90;
        if (r3.equals("PROPFIND") == true) goto L74;
        if (r2 == 308) goto L70;
        if (r2 == 307) goto L70;
        boolean r12 = false;
    L71:
        if (r12 == true) goto L74;
        boolean r13 = false;
    L75:
        if (r2 == 308) goto L79;
        if (r2 == 307) goto L79;
        boolean r4 = false;
    L80:
        if (r4 == false) goto L82;
    L84:
        if (r13 == false) goto L86;
        r5 = r17.request().body();
    L86:
        r10.method(r3, r5);
    L87:
        if (r13 == true) goto L90;
        r10.removeHeader(DownloadHelper.TRANSFER_ENCODING);
        r10.removeHeader(DownloadUtils.CONTENT_LENGTH);
        r10.removeHeader(DownloadHelper.CONTENT_TYPE);
        goto L90
    L82:
        if ((!r3.equals("PROPFIND")) == false) goto L84;
        r10.method("GET", null);
    L79:
        r4 = true;
    L70:
        r12 = true;
    L74:
        r13 = true;
    L90:
        if (e(r17, r9) == true) goto L92;
        r10.removeHeader("Authorization");
    L92:
        Request r1 = r17.request();
        if (r1 == null) goto L141;
        if (TextUtils.isEmpty(r9.host()) == true) goto L141;
        if (this.a.enableBoe() == true) goto L141;
        if (r1.isHttps() == true) goto L106;
        if (r1.originUrl() != null) goto L104;
    L108:
        boolean r6 = false;
    L109:
        if (r6 == false) goto L114;
        g(r19, r1, r9, true, r10, r20);
        if (TTConfigManager.inCookieHostList(r9.host()) == false) goto L141;
        r10.addHeader("x-metasec-ok-bypass-downgrade-cookie", "1");
        goto L141
    L114:
        if (TTConfigManager.inst().getRedirectRequestControlConfig().f.get() == true) goto L141;
        if (r1.url().host().equals(r9.host()) == true) goto L141;
        if (r1.originUrl() != null) goto L120;
    L122:
        String r11 = r9.host();
        if (TextUtils.isEmpty(r11) == true) goto L138;
        Iterator<String> r14 = TTConfigManager.inst().getRedirectRequestControlConfig().b.iterator();
    L127:
        if (r14.hasNext() == false) goto L137;
        String r15 = r14.next();
        if (r11.equals(r15) == true) goto L136;
        if (r15.startsWith(".") == true) goto L135;
        r15 = ".".concat(r15);
    L135:
        if (r11.toLowerCase().endsWith(r15.toLowerCase()) == false) goto L127;
    L136:
        r7 = true;
        goto L138
    L137:
        TTConfigManager.inst();
        r7 = TTConfigManager.inCookieHostList(r11);
    L138:
        if (r7 == true) goto L141;
        g(r19, r1, r9, false, r10, r20);
        goto L141
    L120:
        if (r9.host().equals(r1.originUrl().host()) == false) goto L122;
    L104:
        if (r1.originUrl().isHttps() == false) goto L108;
    L106:
        if (r9.isHttps() == true) goto L108;
        r6 = true;
    L141:
        return r10.url(r9).build();
    L60:
        if (this.a.followSslRedirects() == true) goto L62;
        return null;
    L143:
        throw new IllegalStateException();
    }

    public final boolean c(IOException r3, StreamAllocation r4, boolean r5, Request r6) {
        r4.streamFailed(r3);
        boolean r0 = false;
        if (this.a.retryOnConnectionFailure() == true) goto L5;
        return false;
    L5:
        if (r5 == false) goto L10;
        r6.body();
        if ((r3 instanceof FileNotFoundException) == false) goto L10;
        return false;
    L10:
        if ((r3 instanceof ProtocolException) == false) goto L13;
    L27:
        if (r0 == true) goto L31;
        return f(r3, r6);
    L31:
        if (this.b.hasMoreRoutes() == false) goto L33;
        return true;
    L33:
        return f(r3, r6);
    L13:
        if ((r3 instanceof InterruptedIOException) == false) goto L19;
        if ((r3 instanceof SocketTimeoutException) == false) goto L27;
        if (r5 == true) goto L27;
    L26:
        r0 = true;
        goto L27
    L19:
        if ((r3 instanceof SSLHandshakeException) == false) goto L24;
        if ((r3.getCause() instanceof CertificateException) == true) goto L27;
    L24:
        if ((r3 instanceof SSLPeerUnverifiedException) == false) goto L26;
        goto L26
    }

    public static void g(Call r9, Request r10, HttpUrl r11, boolean r12, Request.Builder r13, okhttp3.i r14) {
        TTConfigManager$a r0 = TTConfigManager.inst().getRedirectRequestControlConfig();
        ArrayList r1 = new ArrayList();
        boolean r3 = false;
        boolean r4 = true;
        if (r0.h.get() == false) goto L5;
        Iterator<Map.Entry<String, List<String>>> r2 = r10.headers().toMultimap().entrySet().iterator();
    L45:
        if (r2.hasNext() == false) goto L72;
        String r5 = r2.next().getKey();
        List<String> r6 = r0.i;
        List<String> r7 = r0.j;
        if (TextUtils.isEmpty(r5) == true) goto L66;
        Iterator r8 = ((ArrayList) r6).iterator();
    L51:
        if (r8.hasNext() == false) goto L55;
        if (r5.equalsIgnoreCase((String) r8.next()) == false) goto L51;
    L55:
        Iterator r15 = ((ArrayList) r7).iterator();
    L57:
        if (r15.hasNext() == false) goto L61;
        if (r5.equalsIgnoreCase((String) r15.next()) == false) goto L57;
    L67:
        boolean r16 = false;
    L68:
        if (r16 == true) goto L45;
        r1.add(r5);
        goto L45
    L61:
        Iterator<String> r17 = g.iterator();
    L63:
        if (r17.hasNext() == false) goto L67;
        if (r5.equalsIgnoreCase(r17.next()) == false) goto L63;
    L66:
        r16 = true;
    L72:
        if (r1.isEmpty() == false) goto L74;
        return;
    L74:
        boolean r18 = r4 | r12;
        if (r18 == false) goto L81;
        Iterator r19 = r1.iterator();
    L78:
        if (r19.hasNext() == false) goto L81;
        r13.removeHeader((String) r19.next());
    L81:
        if (r0.e.get() == false) goto L100;
        return;
    L100:
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L97
        r20.put("src", "ttok");     // Catch: JSONException -> L97
        if (r0.g.get() == false) goto L87;
        r20.put("origin_url", r10.url());     // Catch: JSONException -> L97
        r20.put("rect_url", r11.url());     // Catch: JSONException -> L97
    L87:
        r20.put("origin_host", r10.url().scheme() + "://" + r10.url().host());     // Catch: JSONException -> L97
        r20.put("rect_host", r11.scheme() + "://" + r11.host());     // Catch: JSONException -> L97
        r20.put("origin_path", r10.url().encodedPath());     // Catch: JSONException -> L97
        r20.put("rect_path", r11.encodedPath());     // Catch: JSONException -> L97
        JSONArray r110 = new JSONArray();     // Catch: JSONException -> L97
        Iterator r111 = r1.iterator();     // Catch: JSONException -> L97
    L89:
        if (r111.hasNext() == false) goto L91;
        r110.put((String) r111.next());     // Catch: JSONException -> L97
        goto L89
    L91:
        r20.put("scy_headers", r110);     // Catch: JSONException -> L97
        r20.put("remove_scy_header", r18);     // Catch: JSONException -> L97
        r20.put("downgrade", r12);     // Catch: JSONException -> L97
        if (r0.h.get() == false) goto L94;
        r20.put("ctl_ver", "v2");     // Catch: JSONException -> L97
    L94:
        if (r14 == null) goto L127;
        r14.callInSecureRedirect(r9, r20);     // Catch: JSONException -> L97
        return;
    L127:
        return;
    L97:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r0.c.get() == true) goto L23;
        String r21 = r11.host();
        if (TextUtils.isEmpty(r21) == true) goto L21;
        Iterator<String> r22 = TTConfigManager.inst().getRedirectRequestControlConfig().d.iterator();
    L11:
        if (r22.hasNext() == false) goto L21;
        String r23 = r22.next();
        if (r21.equals(r23) == true) goto L20;
        if (r23.startsWith(".") == true) goto L19;
        r23 = ".".concat(r23);
    L19:
        if (r21.toLowerCase().endsWith(r23.toLowerCase()) == false) goto L11;
    L20:
        boolean r24 = true;
    L22:
        if (r24 == true) goto L23;
    L25:
        if (TextUtils.isEmpty(r10.header("x-tt-token")) == true) goto L28;
        r1.add("x-tt-token");
    L28:
        if (TextUtils.isEmpty(r10.header("Cookie")) == true) goto L31;
        r1.add("Cookie");
    L31:
        if (TextUtils.isEmpty(r10.header("Cookie2")) == true) goto L34;
        r1.add("Cookie2");
    L34:
        if (TextUtils.isEmpty(r10.header("X-SS-Cookie")) == true) goto L36;
        r1.add("X-SS-Cookie");
    L36:
        Iterator<String> r25 = r0.a.iterator();
    L38:
        if (r25.hasNext() == false) goto L42;
        String r26 = r25.next();
        if (TextUtils.isEmpty(r10.header(r26)) == true) goto L38;
        r1.add(r26);
        goto L38
    L42:
        r4 = r3;
    L21:
        r24 = false;
    L23:
        r3 = true;
        goto L25
    }
}
