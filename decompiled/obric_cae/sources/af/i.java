package af;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import we.a0;
import we.d0;
import we.o;
import we.r;
import we.s;
import we.v;
import we.y;
import we.z;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f374g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile ze.g f376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f380f;

    static {
        f374g = xe.c.q(new String[]{"Accept", "Accept-Charset", "Accept-Encoding", "Accept-Language", "Authorization", "Cache-Control", "Connection", "Content-Length", "Content-Type", "Host", "If-Match", "If-Modified-Since", "If-None-Match", "If-Range", "If-Unmodified-Since", "Origin", "Pragma", "Proxy-Authorization", "Proxy-Connection", "Range", "Referer", "Transfer-Encoding", "User-Agent"});
    }

    public i(v r8) {
        this.f379e = -1;
        this.f380f = false;
        this.f375a = r8;
    }

    public static int e(a0 r8, int r10) {
        String r11 = r8.n("Retry-After");
        if (r11 != null) goto L6;
        return r10;
    L6:
        if (r11.matches("\\d+") == true) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return Integer.valueOf(r11).intValue();
    }

    public static boolean f(a0 r8, r r10) {
        r r11 = r8.f13114a.f13337a;
        if (r11.f13244d.equals(r10.f13244d) == true) goto L5;
    L9:
        return false;
    L5:
        if (r11.f13245e != r10.f13245e) goto L9;
        if (r11.f13241a.equals(r10.f13241a) == false) goto L9;
        return true;
    }

    public static void h(we.d r10, y r11, r r12, boolean r13, y.a r14, o r15) {
        p000if.a.C0093a r8 = p000if.a.b().f8340j;
        ArrayList r16 = new ArrayList();
        boolean r17 = r8.f8350h.get();
        String r18 = r12.f13244d;
        boolean r19 = false;
        boolean r20 = true;
        if (r17 == false) goto L5;
        Iterator r21 = r11.f13340d.i().entrySet().iterator();
    L45:
        if (r21.hasNext() == false) goto L72;
        String r22 = (String) ((Map.Entry) r21.next()).getKey();
        ArrayList r23 = r8.f8351i;
        ArrayList r24 = r8.f8352j;
        if (TextUtils.isEmpty(r22) == true) goto L66;
        Iterator r25 = r23.iterator();
    L51:
        if (r25.hasNext() == false) goto L55;
        if (r22.equalsIgnoreCase((String) r25.next()) == false) goto L51;
    L55:
        Iterator r26 = r24.iterator();
    L57:
        if (r26.hasNext() == false) goto L61;
        if (r22.equalsIgnoreCase((String) r26.next()) == false) goto L57;
    L67:
        boolean r27 = false;
    L68:
        if (r27 == true) goto L45;
        r16.add(r22);
        goto L45
    L61:
        Iterator<String> r28 = f374g.iterator();
    L63:
        if (r28.hasNext() == false) goto L67;
        if (r22.equalsIgnoreCase(r28.next()) == false) goto L63;
    L66:
        r27 = true;
    L72:
        if (r16.isEmpty() == false) goto L74;
        return;
    L74:
        boolean r29 = r20 | r13;
        if (r29 == false) goto L81;
        Iterator r30 = r16.iterator();
    L78:
        if (r30.hasNext() == false) goto L81;
        r14.d((String) r30.next());
    L81:
        if (r8.f8347e.get() == false) goto L108;
        return;
    L108:
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L103
        r31.put("src", "ttok");     // Catch: JSONException -> L103
        boolean r32 = r8.f8349g.get();     // Catch: JSONException -> L103
        r r110 = r11.f13337a;
        if (r32 == false) goto L93;
        r31.put("origin_url", r110);     // Catch: JSONException -> L103
        r31.put("rect_url", new URL(r12.f13249i));     // Catch: JSONException -> L103
        goto L93
    L90:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: JSONException -> L103
    L93:
        r31.put("origin_host", r110.f13241a + "://" + r110.f13244d);     // Catch: JSONException -> L103
        r31.put("rect_host", r12.f13241a + "://" + r18);     // Catch: JSONException -> L103
        r31.put("origin_path", r110.e());     // Catch: JSONException -> L103
        r31.put("rect_path", r12.e());     // Catch: JSONException -> L103
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L103
        Iterator r112 = r16.iterator();     // Catch: JSONException -> L103
    L95:
        if (r112.hasNext() == false) goto L97;
        r111.put((String) r112.next());     // Catch: JSONException -> L103
        goto L95
    L97:
        r31.put("scy_headers", r111);     // Catch: JSONException -> L103
        r31.put("remove_scy_header", r29);     // Catch: JSONException -> L103
        r31.put("downgrade", r13);     // Catch: JSONException -> L103
        if (r8.f8350h.get() == false) goto L100;
        r31.put("ctl_ver", LocationInfoConst.LIBRA_PARAM_V2);     // Catch: JSONException -> L103
    L100:
        if (r15 == null) goto L134;
        r15.callInSecureRedirect(r10, r31);     // Catch: JSONException -> L103
        return;
    L134:
        return;
    L103:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r8.f8345c.get() == false) goto L7;
    L23:
        r19 = true;
    L25:
        if (TextUtils.isEmpty(r11.b("x-tt-token")) == true) goto L28;
        r16.add("x-tt-token");
    L28:
        if (TextUtils.isEmpty(r11.b("Cookie")) == true) goto L31;
        r16.add("Cookie");
    L31:
        if (TextUtils.isEmpty(r11.b("Cookie2")) == true) goto L34;
        r16.add("Cookie2");
    L34:
        if (TextUtils.isEmpty(r11.b(CronetHttpURLConnection.SS_COOKIE)) == true) goto L36;
        r16.add(CronetHttpURLConnection.SS_COOKIE);
    L36:
        Iterator<String> r33 = r8.f8343a.iterator();
    L38:
        if (r33.hasNext() == false) goto L42;
        String r34 = r33.next();
        if (TextUtils.isEmpty(r11.b(r34)) == true) goto L38;
        r16.add(r34);
        goto L38
    L42:
        r20 = r19;
        goto L72
    L7:
        if (TextUtils.isEmpty(r18) == true) goto L21;
        Iterator<String> r35 = p000if.a.b().f8340j.f8346d.iterator();
    L11:
        if (r35.hasNext() == false) goto L21;
        String r36 = r35.next();
        if (r18.equals(r36) == true) goto L20;
        if (r36.startsWith(".") == true) goto L19;
        r36 = ".".concat(r36);
    L19:
        if (r18.toLowerCase().endsWith(r36.toLowerCase()) == false) goto L11;
    L20:
        boolean r37 = true;
    L22:
        if (r37 == false) goto L25;
    L21:
        r37 = false;
        goto L22
    }

    @Override // we.s
    public final a0 a(f r15) {
        y r8 = r15.f364f;
        we.d r10 = r15.f365g;
        o r11 = r15.f366h;
        ze.g r12 = new ze.g(this.f375a.A, b(r8.f13337a), r10, r11, this.f377c);
        this.f376b = r12;
        int r13 = 0;
        a0 r14 = null;
    L4:
        if (this.f378d == true) goto L56;
        a0 r16 = r15.f(r8, r12, null, null);     // Catch: Throwable -> L37 IOException -> L39 ze.e -> L48
    L6:
        if (r14 == null) goto L61;
        a0.a r17 = new a0.a(r16);
        a0.a r18 = new a0.a(r14);
        r18.f13132g = null;
        a0 r19 = r18.b();
        if (r19.f13120q != null) goto L11;
        r17.f13135j = r19;
        r16 = r17.b();
        goto L61
    L11:
        throw new IllegalArgumentException("priorResponse.body != null");
    L61:
        y r110 = c(r16, r12.f14402c, r10, r11);     // Catch: IOException -> L34
        if (r110 == null) goto L14;
        xe.c.f(r16.f13120q);
        int r111 = r13 + 1;
        if (r111 > 20) goto L32;
        if (f(r16, r110.f13337a) == true) goto L21;
        r12.g();
        r12 = new ze.g(this.f375a.A, b(r110.f13337a), r10, r11, this.f377c);
        this.f376b = r12;
    L26:
        r14 = r16;
        r8 = r110;
        r13 = r111;
        goto L4
    L21:
        we.i r20 = r12.f14403d;
        monitor-enter(r20);
        c r21 = r12.f14414o;     // Catch: Throwable -> L29
        monitor-exit(r20);     // Catch: Throwable -> L29
        if (r21 == null) goto L26;
        throw new IllegalStateException("Closing the body of " + r16 + " didn't close its backing stream. Bad interceptor?");
    L29:
        th = move-exception;
        throw th;
    L32:
        r12.g();
        throw new ProtocolException(defpackage.a.d("Too many follow-up requests: ", r111));
    L14:
        r12.g();
        return r16;
    L34:
        e = move-exception;
        r12.g();
        throw e;
    L37:
        th = move-exception;
        r12.h(null);
        r12.g();
        throw th;
    L39:
        e = move-exception;
        if ((e instanceof cf.a) == true) goto L43;
        boolean r22 = true;
    L45:
        if (d(e, r12, r22, r8) == true) goto L4;
        throw e;     // Catch: Throwable -> L37
    L43:
        r22 = false;
    L48:
        e = move-exception;
        if (d(e.f14388b, r12, false, r8) == true) goto L4;
        throw e.f14387a;     // Catch: Throwable -> L37
    L56:
        r12.g();
        throw new IOException("Canceled#Reason=" + this.f379e);
    }

    public final we.a b(r r15) {
        boolean r8 = r15.f13241a.equals(LocationInfoConst.HTTPS);
        v r14 = this.f375a;
        if (r8 == false) goto L5;
        SSLSocketFactory r10 = r14.f13287u;
        SSLSocketFactory r11 = r10;
        HostnameVerifier r12 = r14.f13289w;
        we.f r13 = r14.f13290x;
    L7:
        return new we.a(r15.f13244d, r15.f13245e, r14.B, r14.f13286t, r11, r12, r13, r14.f13291y, r14.f13278b, r14.f13279m, r14.f13280n, r14.f13284r);
    L5:
        r11 = null;
        r12 = null;
        r13 = null;
        goto L7
    }

    public final y c(a0 r17, d0 r18, we.d r19, o r20) {
        y r8 = r17.f13114a;
        String r10 = r8.f13339c;
        z r11 = null;
        boolean r12 = false;
        v r13 = this.f375a;
        int r14 = r17.f13116m;
        if (r14 == 307) goto L43;
        if (r14 == 308) goto L43;
        if (r14 == 401) goto L41;
        a0 r15 = r17.f13123t;
        if (r14 != 503) goto L10;
        if (r15 == null) goto L38;
        if (r15.f13116m != 503) goto L38;
        return null;
    L38:
        if (e(r17, Integer.MAX_VALUE) != 0) goto L40;
        return r8;
    L40:
        return null;
    L10:
        if (r14 == 407) goto L27;
        if (r14 == 408) goto L16;
        switch(r14) {
            case 300: goto L43;
            case 301: goto L43;
            case 302: goto L43;
            case 303: goto L43;
            default: goto L14;
        };
    L14:
        return null;
    L16:
        if (r13.E == true) goto L18;
        return null;
    L18:
        if (r15 == null) goto L23;
        if (r15.f13116m != 408) goto L23;
        return null;
    L23:
        if (e(r17, 0) <= 0) goto L25;
        return null;
    L25:
        return r8;
    L27:
        if (r18.f13159b.type() != Proxy.Type.HTTP) goto L32;
        we.b r16 = r13.f13291y;
    L29:
        r16.getClass();
        return null;
    L32:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L41:
        r16 = r13.f13292z;
    L43:
        if (r13.D == true) goto L45;
        return null;
    L45:
        String r21 = r17.n("Location");
        if (r21 != null) goto L48;
        return null;
    L48:
        r r110 = r8.f13337a;
        r110.getClass();
        r.a r111 = new r.a();     // Catch: IllegalArgumentException -> L51
        r111.b(r110, r21);     // Catch: IllegalArgumentException -> L51
    L52:
        if (r111 == null) goto L54;
        r r22 = r111.a();
    L55:
        if (r22 != null) goto L57;
        return null;
    L57:
        String r112 = r110.f13241a;
        String r113 = r22.f13241a;
        if (r113.equals(r112) == false) goto L60;
    L62:
        y.a r114 = new y.a(r8);
        if (defpackage.c.b0(r10) == false) goto L90;
        if (r10.equals("PROPFIND") == true) goto L74;
        if (r14 == 308) goto L70;
        if (r14 == 307) goto L70;
        boolean r115 = false;
    L71:
        if (r115 == true) goto L74;
        boolean r116 = false;
    L75:
        if (r14 == 308) goto L79;
        if (r14 == 307) goto L79;
        boolean r23 = false;
    L80:
        if (r23 == false) goto L82;
    L84:
        if (r116 == false) goto L86;
        r11 = r8.f13341e;
    L86:
        r114.c(r11, r10);
        if (r116 == true) goto L90;
        r114.d("Transfer-Encoding");
        r114.d("Content-Length");
        r114.d("Content-Type");
        goto L90
    L82:
        if ((!r10.equals("PROPFIND")) == false) goto L84;
        r10 = HttpMethodContrants.GET;
    L79:
        r23 = true;
    L70:
        r115 = true;
    L74:
        r116 = true;
    L90:
        if (f(r17, r22) == true) goto L92;
        r114.d("Authorization");
    L92:
        String r24 = r22.f13244d;
        if (TextUtils.isEmpty(r24) == false) goto L95;
    L136:
        r114.f(r22);
        return r114.a();
    L95:
        if (r13.K == true) goto L136;
        boolean r25 = r110.f13241a.equals(LocationInfoConst.HTTPS);
        r r26 = r8.f13338b;
        if (r25 == true) goto L103;
        if (r26 != null) goto L101;
    L105:
        boolean r27 = false;
    L106:
        if (r27 == false) goto L111;
        h(r19, r8, r22, true, r114, r20);
        if (p000if.a.a(r24) == false) goto L136;
        r114.f13347d.a("x-metasec-ok-bypass-downgrade-cookie", "1");
        goto L136
    L111:
        if (p000if.a.b().f8340j.f8348f.get() == true) goto L136;
        if (r110.f13244d.equals(r24) == true) goto L136;
        if (r26 == null) goto L119;
        if (r24.equals(r26.f13244d) == true) goto L136;
    L119:
        if (TextUtils.isEmpty(r24) == true) goto L134;
        Iterator<String> r28 = p000if.a.b().f8340j.f8344b.iterator();
    L123:
        if (r28.hasNext() == false) goto L133;
        String r29 = r28.next();
        if (r24.equals(r29) == true) goto L132;
        if (r29.startsWith(".") == true) goto L131;
        r29 = ".".concat(r29);
    L131:
        if (r24.toLowerCase().endsWith(r29.toLowerCase()) == false) goto L123;
    L132:
        r12 = true;
        goto L134
    L133:
        p000if.a.b();
        r12 = p000if.a.a(r24);
    L134:
        if (r12 == true) goto L136;
        h(r19, r8, r22, false, r114, r20);
        goto L136
    L101:
        if (r26.f13241a.equals(LocationInfoConst.HTTPS) == false) goto L105;
    L103:
        if (r113.equals(LocationInfoConst.HTTPS) == true) goto L105;
        r27 = true;
        goto L106
    L60:
        if (r13.C == true) goto L62;
        return null;
    L54:
        r22 = null;
    L51:
        r111 = null;
        goto L52
    }

    public final boolean d(IOException r8, ze.g r10, boolean r11, y r12) {
        r10.h(r8);
        boolean r13 = false;
        if (this.f375a.E == true) goto L5;
        return false;
    L5:
        if (r11 == false) goto L10;
        if ((r8 instanceof FileNotFoundException) == false) goto L10;
        return false;
    L10:
        if ((r8 instanceof ProtocolException) == false) goto L13;
    L25:
        boolean r14 = false;
    L27:
        if (r14 == false) goto L29;
        ze.g r15 = this.f376b;
        if (r15.f14402c != null) goto L47;
        ze.f.a r16 = r15.f14401b;
        if (r16 != null) goto L35;
    L36:
        ze.f r17 = r15.f14407h;
        if (r17.f14394f >= r17.f14393e.size()) goto L39;
        boolean r18 = true;
    L40:
        if (r18 == false) goto L42;
    L45:
        boolean r19 = true;
    L46:
        if (r19 == true) goto L47;
    L48:
        if (r13 == false) goto L50;
        return true;
    L50:
        return g(r8, r12);
    L42:
        if (r17.f14396h.isEmpty() == false) goto L45;
        r19 = false;
        goto L46
    L39:
        r18 = false;
        goto L40
    L35:
        if (r16.a() == false) goto L36;
    L47:
        r13 = true;
        goto L48
    L29:
        return g(r8, r12);
    L13:
        if ((r8 instanceof InterruptedIOException) == false) goto L19;
        if ((r8 instanceof SocketTimeoutException) == false) goto L25;
        if (r11 == true) goto L25;
    L26:
        r14 = true;
        goto L27
    L19:
        if ((r8 instanceof SSLHandshakeException) == false) goto L24;
        if ((r8.getCause() instanceof CertificateException) == true) goto L25;
    L24:
        if ((r8 instanceof SSLPeerUnverifiedException) == false) goto L26;
        goto L25
    }

    public final boolean g(IOException r8, y r10) {
        if (this.f380f == false) goto L5;
        return false;
    L5:
        this.f380f = true;
        if ((r8 instanceof SSLHandshakeException) == false) goto L9;
        int r11 = NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L91:
        p000if.a r12 = p000if.a.b();
        r12.getClass();
        if (r8 == null) goto L107;
        r r13 = r10.f13337a;
        if (r13 == null) goto L107;
        if (r12.f8337g.get() == false) goto L107;
        if (r12.f8338h.contains(Integer.valueOf(r11)) == false) goto L107;
        String r14 = r13.f13244d;
        if (TextUtils.isEmpty(r14) == true) goto L107;
        if (r12.f8339i.contains(r14) == false) goto L107;
        boolean r15 = true;
    L108:
        if (r15 == false) goto L128;
        ze.g r16 = this.f376b;
        ze.f r17 = r16.f14407h;
        we.a r18 = r17.f14389a;
        r17.b(r18.f13103a, r18.f13110h);
        r17.f14395g.clear();
        r17.f14396h.clear();
        r16.f14401b = null;
        if (p000if.b.f8353b == null) goto L112;
    L121:
        p000if.b r19 = p000if.b.f8353b;
        r19.getClass();
        r r20 = r10.f13337a;
        if (r20 != null) goto L124;
    L127:
        return true;
    L124:
        if (TextUtils.isEmpty(r20.f13244d) == true) goto L127;
        r19.f8354a.add(r20.f13244d);
        goto L127
    L112:
        monitor-enter(p000if.b.class);
    L118:
        th = move-exception;
        throw th;
    L114:
        if (p000if.b.f8353b != null) goto L116;
        p000if.b.f8353b = new p000if.b();     // Catch: Throwable -> L118
    L116:
        monitor-exit(p000if.b.class);     // Catch: Throwable -> L118
        goto L121
    L128:
        return false;
    L107:
        r15 = false;
        goto L108
    L9:
        if ((r8 instanceof SSLKeyException) == false) goto L12;
        r11 = NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
        goto L91
    L12:
        if ((r8 instanceof SSLProtocolException) == false) goto L15;
        r11 = NetError.ERR_SSL_PROTOCOL_ERROR;
        goto L91
    L15:
        if ((r8 instanceof SSLPeerUnverifiedException) == false) goto L18;
        r11 = NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
        goto L91
    L18:
        if ((r8 instanceof UnknownHostException) == false) goto L21;
        r11 = NetError.ERR_NAME_NOT_RESOLVED;
        goto L91
    L21:
        if ((r8 instanceof ConnectException) == false) goto L24;
        r11 = NetError.ERR_CONNECTION_FAILED;
    L35:
        if (r8 == null) goto L91;
        int r21 = l6.a.A(r11, r8.getMessage());     // Catch: Throwable -> L129
        if (r21 == r11) goto L135;
    L48:
        r11 = r21;
        goto L91
    L135:
        Throwable r22 = r8.getCause();     // Catch: Throwable -> L130
        if (r22 == null) goto L48;
        String r23 = r22.getMessage();     // Catch: Throwable -> L130
        if (TextUtils.isEmpty(r23) == true) goto L48;
        r11 = l6.a.A(r11, r23);     // Catch: Throwable -> L130
    L24:
        if ((r8 instanceof PortUnreachableException) == false) goto L27;
        r11 = NetError.ERR_ADDRESS_INVALID;
        goto L91
    L27:
        if ((r8 instanceof NoRouteToHostException) == false) goto L30;
        r11 = NetError.ERR_ADDRESS_UNREACHABLE;
        goto L91
    L30:
        if ((r8 instanceof BindException) == false) goto L33;
        r11 = NetError.ERR_ADDRESS_IN_USE;
        goto L91
    L33:
        if ((r8 instanceof SocketException) == false) goto L50;
        r11 = -15;
        goto L35
    L50:
        if ((r8 instanceof MalformedURLException) == false) goto L53;
        r11 = NetError.ERR_INVALID_URL;
        goto L91
    L53:
        if ((r8 instanceof SocketTimeoutException) == false) goto L56;
        r11 = NetError.ERR_CONNECTION_TIMED_OUT;
        goto L91
    L56:
        if ((r8 instanceof ProtocolException) == false) goto L59;
        r11 = -901;
        goto L91
    L59:
        if ((r8 instanceof HttpRetryException) == false) goto L67;
        String r24 = r8.getMessage();
        if (TextUtils.isEmpty(r24) == false) goto L63;
    L65:
        r11 = NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
        goto L91
    L63:
        if (r24.contains("Too many follow-up requests") == false) goto L65;
        r11 = NetError.ERR_TOO_MANY_REDIRECTS;
        goto L91
    L67:
        if ((r8 instanceof UnknownServiceException) == false) goto L69;
        r11 = -902;
        goto L91
    L69:
        if (r8 != null) goto L71;
    L73:
        if (r8 != null) goto L76;
    L87:
        boolean r25 = false;
    L88:
        if (r25 == false) goto L90;
        r11 = NetError.ERR_TTNET_REQUEST_TIMED_OUT;
        goto L91
    L90:
        r11 = -1;
        goto L91
    L76:
        if ("Canceled#Reason=-192".equals(r8.getMessage()) == false) goto L79;
    L86:
        r25 = true;
        goto L88
    L79:
        if ((r8 instanceof InterruptedIOException) == false) goto L87;
        Throwable r26 = r8.getCause();
        if (r26 == null) goto L87;
        if (TextUtils.isEmpty(r26.getMessage()) == true) goto L87;
        if ("Canceled#Reason=-192".equals(r26.getMessage()) == false) goto L87;
    L71:
        if ("Canceled#Reason=-199".equals(r8.getMessage()) == false) goto L73;
        r11 = NetError.ERR_TTNET_APP_TIMED_OUT;
        goto L91
    }
}
