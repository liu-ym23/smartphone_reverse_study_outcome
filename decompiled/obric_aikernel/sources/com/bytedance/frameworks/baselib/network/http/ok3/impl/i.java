package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okhttp3.r;
import okhttp3.x;
import okhttp3.z;
import okio.ByteString;
import org.chromium.wschannel.TrafficChangedObservable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private Protocol A;
    private String B;
    private boolean C;
    private boolean D;
    private String E;
    private Socket F;
    private r G;
    private String H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final List<l> f1746J;
    private LoadState K;
    private String L;
    private int M;
    private Status N;
    private String O;
    private boolean P;
    private boolean Q;
    private final List<y2.a> R;
    private int S;
    private x2.b T;
    private String U;
    private o2.c V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f1751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f1752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f1756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f1757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f1759m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f1760n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicLong f1761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f1762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f1763q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final List<Pair<InetSocketAddress, Integer>> f1764r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Proxy.Type f1765s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private HandshakeType f1766t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TlsVersion f1767u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private okhttp3.h f1768v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f1769w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private r f1770x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1771y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f1772z;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1773a = null;

        static {
            int[] r10 = new int[Protocol.values().length];
            f1773a = r10;
            r10[Protocol.HTTP_1_0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f1773a[Protocol.HTTP_1_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f1773a[Protocol.HTTP_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f1773a[Protocol.SPDY_3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f1773a[Protocol.QUIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public i() {
        this.f1747a = -1;
        this.f1748b = -1;
        this.f1749c = -1;
        this.f1750d = -1;
        this.f1751e = -1;
        this.f1752f = -1;
        this.f1753g = -1;
        this.f1754h = -1;
        this.f1755i = -1;
        this.f1756j = -1;
        this.f1757k = -1;
        this.f1758l = -1;
        this.f1759m = -1;
        this.f1760n = -1;
        this.f1761o = new AtomicLong(-1);
        this.f1762p = -1;
        this.f1763q = -1;
        this.f1764r = new ArrayList();
        this.f1765s = Proxy.Type.DIRECT;
        this.f1766t = HandshakeType.HANDSHAKE_UNKNOWN;
        this.f1769w = 0;
        this.f1771y = -1;
        this.f1772z = 0;
        this.A = null;
        this.B = "";
        this.C = false;
        this.D = false;
        this.E = "";
        this.H = "";
        this.I = 0;
        this.f1746J = new ArrayList();
        this.K = LoadState.IDLE;
        this.L = "";
        this.M = -1;
        this.N = Status.UNKNOWN;
        this.O = "";
        this.P = false;
        this.Q = false;
        this.R = new ArrayList();
        this.S = 0;
        this.U = "";
    }

    private static ConnectionInfo I(Protocol r10) {
        if (r10 == null) goto L4;
        int r11 = a.f1773a[r10.ordinal()];
        if (r11 == 1) goto L26;
        if (r11 == 2) goto L24;
        if (r11 == 3) goto L22;
        if (r11 == 4) goto L20;
        if (r11 == 5) goto L18;
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    L18:
        return ConnectionInfo.CONNECTION_INFO_QUIC_UNKNOWN_VERSION;
    L20:
        return ConnectionInfo.CONNECTION_INFO_DEPRECATED_SPDY3;
    L22:
        return ConnectionInfo.CONNECTION_INFO_HTTP2;
    L24:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_1;
    L26:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_0;
    L4:
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    }

    private static long J(String r10) {
        String[] r11 = r10.split("=");
        if (r11.length == 2) goto L12;
        return -1;
    L12:
        long r12 = Long.parseLong(r11[1]);     // Catch: NumberFormatException -> L11
        if (r12 >= 0) goto L10;
        return -1;
    L10:
        return r12;
    L16:
        return -1;
    }

    private static long K(long r10, long r11) {
        if (r11 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r10 == (-1)) goto L8;
        return r10 - r11;
    }

    private String h(Context r20) {
        String r10 = "Cookie";
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L274
        String r13 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().g();     // Catch: JSONException -> L274
        ArrayList r14 = new ArrayList();     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r13) == true) goto L8;
        String[] r15 = r13.split(",");     // Catch: JSONException -> L274
        if (r15 == null) goto L8;
        r14.addAll(Arrays.asList(r15));     // Catch: JSONException -> L274
    L8:
        u2.a r16 = n.p();     // Catch: JSONException -> L274
        if (r16 == null) goto L24;
        List<String> r17 = r16.getAbSdkVersion();     // Catch: JSONException -> L274
        if (r17 == null) goto L24;
        if (r17.size() > 5) goto L15;
    L17:
        Iterator<String> r18 = r17.iterator();     // Catch: JSONException -> L274
        int r19 = 0;
    L19:
        if (r18.hasNext() == false) goto L24;
        String r110 = r18.next();     // Catch: JSONException -> L274
        r19 = r19 + 1;     // Catch: JSONException -> L274
        if (r19 > 5) goto L24;
        r14.add(r110);     // Catch: JSONException -> L274
        goto L19
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("ok3log", "ab sdk version count must less than 5");     // Catch: JSONException -> L274
    L24:
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L274
        Iterator r112 = r14.iterator();     // Catch: JSONException -> L274
    L26:
        if (r112.hasNext() == false) goto L30;
        String r113 = (String) r112.next();     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r113) == true) goto L26;
        r111.put(r113);     // Catch: JSONException -> L274
        goto L26
    L30:
        r12.put("hit", r111);     // Catch: JSONException -> L274
        r11.put("ab_test", r12);     // Catch: JSONException -> L274
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L274
        r21.put("load_state", this.K.ordinal());     // Catch: JSONException -> L274
        r21.put(EnsureReportData.METHOD, this.L);     // Catch: JSONException -> L274
        if (this.N != Status.IO_PENDING) goto L33;
        boolean r114 = true;
    L34:
        r21.put("is_pending", r114);     // Catch: JSONException -> L274
        r21.put("status", this.N);     // Catch: JSONException -> L274
        if (this.N == Status.SUCCESS) goto L39;
        r21.put("net_error", this.M);     // Catch: JSONException -> L274
    L39:
        if (TextUtils.isEmpty(this.O) == true) goto L49;
        Uri r115 = Uri.parse(this.O);     // Catch: JSONException -> L274
        if (r115 == null) goto L49;
        if (TextUtils.isEmpty(r115.getScheme()) == true) goto L49;
        if (TextUtils.isEmpty(r115.getHost()) == true) goto L49;
        if (r115.getPath() == null) goto L49;
        r21.put("origin_url", r115.getScheme() + "://" + r115.getHost() + r115.getPath());     // Catch: JSONException -> L274
    L49:
        r21.put("redirect_times", this.I);     // Catch: JSONException -> L274
        JSONArray r116 = new JSONArray();     // Catch: JSONException -> L274
        JSONArray r117 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<l> r118 = this.f1746J.iterator();     // Catch: JSONException -> L274
    L52:
        if (r118.hasNext() == false) goto L66;
        l r119 = r118.next();     // Catch: JSONException -> L274
        Iterator<l> r120 = r118;
        JSONObject r121 = new JSONObject();     // Catch: JSONException -> L274
        String r122 = r10;
        r121.put("code", r119.f1775a);     // Catch: JSONException -> L274
        r121.put(EnsureReportData.METHOD, r119.f1776b);     // Catch: JSONException -> L274
        r121.put("internal", r119.f1778d);     // Catch: JSONException -> L274
        String r22 = r119.f1777c;     // Catch: JSONException -> L274
        if (r22 == null) goto L65;
        Uri r23 = Uri.parse(r22);     // Catch: JSONException -> L274
        if (r23 == null) goto L65;
        if (TextUtils.isEmpty(r23.getScheme()) == true) goto L65;
        if (TextUtils.isEmpty(r23.getHost()) == true) goto L65;
        String r123 = r23.getScheme() + "://" + r23.getHost();     // Catch: JSONException -> L274
        r117.put(r123);     // Catch: JSONException -> L274
        if (r23.getPath() == null) goto L64;
        r123 = r123 + r23.getPath();     // Catch: JSONException -> L274
    L64:
        r121.put("url", r123);     // Catch: JSONException -> L274
    L65:
        r116.put(r121);     // Catch: JSONException -> L274
        r118 = r120;
        r10 = r122;
        goto L52
    L66:
        String r124 = r10;
        r21.put("redirect_info", r116);     // Catch: JSONException -> L274
        r21.put("redirecting_list", r117);     // Catch: JSONException -> L274
        r21.put("dispatched", this.P);     // Catch: JSONException -> L274
        r11.put("base", r21);     // Catch: JSONException -> L274
        JSONObject r24 = new JSONObject();     // Catch: JSONException -> L274
        r24.put("code", this.f1771y);     // Catch: JSONException -> L274
        r24.put("connection_info", I(this.A).mValue);     // Catch: JSONException -> L274
        r r25 = this.f1770x;     // Catch: JSONException -> L274
        if (r25 == null) goto L69;
        long r125 = r25.a();     // Catch: JSONException -> L274
    L70:
        r24.put(TrafficChangedObservable.TRAFFICCHANGED_SENTBYTES, this.f1769w + r125);     // Catch: JSONException -> L274
        r r26 = this.G;     // Catch: JSONException -> L274
        if (r26 == null) goto L73;
        long r126 = r26.a();     // Catch: JSONException -> L274
    L74:
        r24.put(TrafficChangedObservable.TRAFFICCHANGED_RECEIVEDBYTES, this.f1772z + r126);     // Catch: JSONException -> L274
        r24.put("cached", this.C);     // Catch: JSONException -> L274
        r24.put("network_accessed", this.D);     // Catch: JSONException -> L274
        if (this.f1765s == Proxy.Type.DIRECT) goto L77;
        boolean r127 = true;
    L78:
        r24.put("via_proxy", r127);     // Catch: JSONException -> L274
        r r27 = this.G;     // Catch: JSONException -> L274
        if (r27 == null) goto L93;
        List<String> r28 = r27.j(Api.KEY_SET_COOKIE);     // Catch: JSONException -> L274
        if (com.bytedance.common.utility.collection.a.a(r28) == true) goto L83;
        boolean r128 = true;
    L84:
        r24.put("set_cookie", r128);     // Catch: JSONException -> L274
        if (r128 == false) goto L93;
        r24.put("set_cookie_lines", r28.size());     // Catch: JSONException -> L274
        Iterator<String> r29 = r28.iterator();     // Catch: JSONException -> L274
        long r129 = 0;
    L88:
        if (r29.hasNext() == false) goto L92;
        String r130 = r29.next();     // Catch: JSONException -> L274
        if (r130 == null) goto L88;
        r129 = r129 + ((long) r130.length());     // Catch: JSONException -> L274
        goto L88
    L92:
        r24.put("set_cookie_bytes", r129);     // Catch: JSONException -> L274
        goto L93
    L83:
        r128 = false;
    L93:
        r11.put("response", r24);     // Catch: JSONException -> L274
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L274
        if (this.G == null) goto L117;
        int r31 = 0;
    L98:
        if (r31 >= this.G.size()) goto L110;
        String r131 = this.G.c(r31);     // Catch: JSONException -> L274
        String r132 = this.G.i(r31);     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r131) == true) goto L109;
        String r133 = r131.toLowerCase();     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r133) == true) goto L109;
        if (r133.startsWith("x-tt-") == false) goto L109;
        if (TextUtils.isEmpty(r132) == true) goto L109;
        r30.put(r131, r132);     // Catch: JSONException -> L274
    L109:
        r31 = r31 + 1;     // Catch: JSONException -> L274
        goto L98
    L110:
        String r32 = this.G.b("tt-idc-switch");     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r32) == true) goto L113;
        r30.put("tt-idc-switch", r32);     // Catch: JSONException -> L274
    L113:
        String r33 = this.G.b("server-timing");     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r33) == true) goto L116;
        r30.put("server-timing", r33);     // Catch: JSONException -> L274
    L116:
        r11.put("header", r30);     // Catch: JSONException -> L274
    L118:
        JSONObject r34 = new JSONObject();     // Catch: JSONException -> L274
        r34.put("libcore", "okhttp");     // Catch: JSONException -> L274
        r34.put("core_ver", n.q());     // Catch: JSONException -> L274
        r34.put("is_main_process", com.bytedance.frameworks.baselib.network.http.util.g.h(r20));     // Catch: JSONException -> L274
        r34.put("ttnet_version", "4.2.228.21-doubao");     // Catch: JSONException -> L274
        r34.put(ICronetClient.KEY_RETRY_ATTEMPTS, -1);     // Catch: JSONException -> L274
        o2.c r35 = this.V;     // Catch: JSONException -> L274
        if (r35 != null) goto L121;
    L123:
        r11.put("other", r34);     // Catch: JSONException -> L274
        JSONObject r36 = new JSONObject();     // Catch: JSONException -> L274
        JSONObject r37 = new JSONObject();     // Catch: JSONException -> L274
        r37.put("dns", K(this.f1749c, this.f1748b));     // Catch: JSONException -> L274
        r37.put("tcp", K(this.f1751e, this.f1750d));     // Catch: JSONException -> L274
        r37.put("ssl", K(this.f1752f, this.f1751e));     // Catch: JSONException -> L274
        r37.put("send", K(this.f1754h, this.f1753g) + K(this.f1756j, this.f1755i));     // Catch: JSONException -> L274
        long r38 = K(this.f1758l, this.f1754h);     // Catch: JSONException -> L274
        r37.put(ICronetClient.KEY_TTFB, r38);     // Catch: JSONException -> L274
        r37.put("header_recv", K(this.f1758l, this.f1757k));     // Catch: JSONException -> L274
        r37.put("body_recv", K(this.f1760n, this.f1759m));     // Catch: JSONException -> L274
        r37.put("dispatch", this.f1763q);     // Catch: JSONException -> L274
        p(r33, r37, r38);     // Catch: JSONException -> L274
        x2.b r39 = this.T;     // Catch: JSONException -> L274
        if (r39 == null) goto L129;
        long r40 = r39.f13489e;     // Catch: JSONException -> L274
        if (r40 < 0) goto L129;
        r37.put("meta_dp", r40);     // Catch: JSONException -> L274
    L129:
        r36.put("detailed_duration", r37);     // Catch: JSONException -> L274
        JSONObject r41 = new JSONObject();     // Catch: JSONException -> L274
        r41.put("start_time", this.f1747a);     // Catch: JSONException -> L274
        r41.put("duration", K(this.f1761o.get(), this.f1747a));     // Catch: JSONException -> L274
        r41.put("request_sent_time", this.f1753g);     // Catch: JSONException -> L274
        r41.put("response_recv_time", this.f1757k);     // Catch: JSONException -> L274
        r36.put("request", r41);     // Catch: JSONException -> L274
        r11.put("timing", r36);     // Catch: JSONException -> L274
        JSONObject r42 = new JSONObject();     // Catch: JSONException -> L274
        Socket r43 = this.F;     // Catch: JSONException -> L274
        if (r43 == null) goto L148;
        InetAddress r44 = r43.getInetAddress();     // Catch: JSONException -> L274
        if (r44 == null) goto L148;
        AddressFamily r45 = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;     // Catch: JSONException -> L274
        if ((r44 instanceof Inet4Address) == false) goto L137;
        r45 = AddressFamily.ADDRESS_FAMILY_IPV4;     // Catch: JSONException -> L274
    L139:
        r42.put("address_family", r45.ordinal());     // Catch: JSONException -> L274
        if (this.f1750d == (-1)) goto L142;
    L144:
        boolean r46 = false;
    L145:
        r42.put(ICronetClient.KEY_SOCKET_REUSED, r46);     // Catch: JSONException -> L274
        if (r44.getHostAddress() == null) goto L148;
        r42.put("remote", r44.getHostAddress());     // Catch: JSONException -> L274
        goto L148
    L142:
        if (this.f1762p == (-1)) goto L144;
        r46 = true;
        goto L145
    L137:
        if ((r44 instanceof Inet6Address) == false) goto L139;
        r45 = AddressFamily.ADDRESS_FAMILY_IPV6;     // Catch: JSONException -> L274
    L148:
        JSONArray r47 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<Pair<InetSocketAddress, Integer>> r48 = this.f1764r.iterator();     // Catch: JSONException -> L274
    L150:
        if (r48.hasNext() == false) goto L152;
        Pair<InetSocketAddress, Integer> r49 = r48.next();     // Catch: JSONException -> L274
        JSONObject r134 = new JSONObject();     // Catch: JSONException -> L274
        r134.put("address", ((InetSocketAddress) r49.first).toString().substring(1));     // Catch: JSONException -> L274
        r134.put("result", r49.second);     // Catch: JSONException -> L274
        r47.put(r134);     // Catch: JSONException -> L274
        goto L150
    L152:
        r42.put("connection_attempts", r47);     // Catch: JSONException -> L274
        r11.put("socket", r42);     // Catch: JSONException -> L274
        JSONObject r50 = new JSONObject();     // Catch: JSONException -> L274
        r50.put("handshake_type", this.f1766t.ordinal());     // Catch: JSONException -> L274
        r50.put("cipher_suite", this.f1768v);     // Catch: JSONException -> L274
        r50.put("ssl_version", this.f1767u);     // Catch: JSONException -> L274
        r11.put("ssl", r50);     // Catch: JSONException -> L274
        JSONObject r51 = new JSONObject();     // Catch: JSONException -> L274
        JSONArray r52 = new JSONArray();     // Catch: JSONException -> L274
        if (this.Q == false) goto L157;
        boolean r53 = true;
        r51.put("host_replace_map", 1);     // Catch: JSONException -> L274
        r51.put("host_replace_map_size", this.S);     // Catch: JSONException -> L274
        boolean r54 = false;
    L179:
        r51.put("source", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().i());     // Catch: JSONException -> L274
        r51.put("update_time", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().j());     // Catch: JSONException -> L274
        r51.put(URLDispatch.KEY_EPOCH, com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().e());     // Catch: JSONException -> L274
        r11.put("url_dispatch", r51);     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().h()) == true) goto L183;
        r11.put("tt_tnc_etag", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().h());     // Catch: JSONException -> L274
    L183:
        if (this.T == null) goto L208;
        JSONObject r55 = new JSONObject();     // Catch: JSONException -> L274
        Set<String> r56 = this.T.f13487c;     // Catch: JSONException -> L274
        if (r56 != null) goto L187;
    L189:
        Set<String> r57 = this.T.f13488d;     // Catch: JSONException -> L274
        if (r57 != null) goto L192;
    L194:
        Set<String> r58 = this.T.f13485a;     // Catch: JSONException -> L274
        if (r58 != null) goto L197;
    L199:
        Set<String> r59 = this.T.f13486b;     // Catch: JSONException -> L274
        if (r59 == null) goto L205;
        if (r59.isEmpty() == true) goto L205;
        r55.put("query_rm", this.T.f13486b);     // Catch: JSONException -> L274
    L205:
        if (r55.length() <= 0) goto L208;
        r11.put("meta_dp", r55);     // Catch: JSONException -> L274
        goto L208
    L197:
        if (r58.isEmpty() == true) goto L199;
        r55.put("query_add", this.T.f13485a);     // Catch: JSONException -> L274
        goto L199
    L192:
        if (r57.isEmpty() == true) goto L194;
        r55.put("header_rm", this.T.f13488d);     // Catch: JSONException -> L274
        goto L194
    L187:
        if (r56.isEmpty() == true) goto L189;
        r55.put("header_add", this.T.f13487c);     // Catch: JSONException -> L274
    L208:
        if (TextUtils.isEmpty(this.U) == false) goto L279;
    L210:
        JSONObject r60 = new JSONObject();     // Catch: JSONException -> L274
        o2.c r61 = this.V;     // Catch: JSONException -> L274
        if (r61 == null) goto L224;
        long r62 = r61.f11428i;     // Catch: JSONException -> L274
        if (r62 <= 0) goto L215;
        r60.put("protect", r62);     // Catch: JSONException -> L274
    L215:
        long r63 = this.V.f11425f;     // Catch: JSONException -> L274
        if (r63 <= 0) goto L218;
        r60.put("connect", r63);     // Catch: JSONException -> L274
    L218:
        long r64 = this.V.f11423d;     // Catch: JSONException -> L274
        if (r64 <= 0) goto L221;
        r60.put("read", r64);     // Catch: JSONException -> L274
    L221:
        long r65 = this.V.f11424e;     // Catch: JSONException -> L274
        long r66 = 0;
        if (r65 <= 0) goto L225;
        r60.put("write", r65);     // Catch: JSONException -> L274
    L225:
        r11.put("socket_timeout_param", r60);     // Catch: JSONException -> L274
        JSONObject r67 = new JSONObject();     // Catch: JSONException -> L274
        r67.put("ipv4_reachable", NetworkUtils.g(r20));     // Catch: JSONException -> L274
        r67.put("ipv6_reachable", w2.d.b().get());     // Catch: JSONException -> L274
        r11.put("ifconfig", r67);     // Catch: JSONException -> L274
        if (n.o() == null) goto L231;
        Object r68 = n.o().b();     // Catch: JSONException -> L274
        if (r68 == null) goto L231;
        r11.put("tnc", r68);     // Catch: JSONException -> L274
    L231:
        if (c3.b.m().h() == null) goto L234;
        r11.put("store_idc", c3.b.m().h());     // Catch: JSONException -> L274
    L234:
        if (this.f1770x == null) goto L277;
        JSONObject r69 = new JSONObject();     // Catch: JSONException -> L274
        List<String> r70 = this.f1770x.j(r124);     // Catch: JSONException -> L274
        if (com.bytedance.common.utility.collection.a.a(r70) == true) goto L238;
        boolean r135 = r53;
    L239:
        r69.put(r124, r135);     // Catch: JSONException -> L274
        if (r135 == false) goto L248;
        Iterator<String> r71 = r70.iterator();     // Catch: JSONException -> L274
    L243:
        if (r71.hasNext() == false) goto L247;
        String r72 = r71.next();     // Catch: JSONException -> L274
        if (r72 == null) goto L243;
        r66 = r66 + ((long) r72.length());     // Catch: JSONException -> L274
        goto L243
    L247:
        r69.put("add_cookie_bytes", r66);     // Catch: JSONException -> L274
    L248:
        String r73 = this.f1770x.b("x-tt-token");     // Catch: JSONException -> L274
        if (r73 == null) goto L254;
        if (r73.isEmpty() == true) goto L254;
        r69.put("token_md5", ByteString.encodeUtf8(r73).md5().hex());     // Catch: JSONException -> L274
    L254:
        if ("http".equalsIgnoreCase(this.B) == false) goto L272;
        if (r70 != null) goto L257;
    L265:
        Set<String> r74 = k2.a.b(this.f1770x);     // Catch: JSONException -> L274
        if (r74 == null) goto L272;
        JSONArray r75 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<String> r76 = r74.iterator();     // Catch: JSONException -> L274
    L269:
        if (r76.hasNext() == false) goto L271;
        r75.put(r76.next());     // Catch: JSONException -> L274
        goto L269
    L271:
        r69.put("insecure_headers", r75);     // Catch: JSONException -> L274
        goto L272
    L257:
        if (r70.isEmpty() == true) goto L265;
        Set<String> r77 = k2.a.a(r70);     // Catch: JSONException -> L274
        if (r77 == null) goto L265;
        JSONArray r78 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<String> r79 = r77.iterator();     // Catch: JSONException -> L274
    L262:
        if (r79.hasNext() == false) goto L264;
        r78.put(r79.next());     // Catch: JSONException -> L274
        goto L262
    L264:
        r69.put("insecure_cookies", r78);     // Catch: JSONException -> L274
    L272:
        r11.put("session", r69);     // Catch: JSONException -> L274
        goto L277
    L238:
        r135 = r54;
    L277:
        return r11.toString();
    L224:
        r66 = 0;
        goto L225
    L279:
        r11.put("dns", new JSONObject(this.U));     // Catch: JSONException -> L278
        goto L210
    L157:
        r53 = true;
        List<y2.a> r80 = this.R;     // Catch: JSONException -> L274
        if (r80 == null) goto L178;
        Iterator<y2.a> r81 = r80.iterator();     // Catch: JSONException -> L274
    L161:
        if (r81.hasNext() == false) goto L178;
        y2.a r136 = r81.next();     // Catch: JSONException -> L274
        JSONObject r137 = new JSONObject();     // Catch: JSONException -> L274
        if (r136.f13662d == false) goto L161;
        r137.put("priority", r136.f13661c);     // Catch: JSONException -> L274
        r137.put(WsConstants.KEY_CONNECTION_TYPE, r136.f13663e);     // Catch: JSONException -> L274
        r137.put("action_hit", r136.f13662d);     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r136.f13665g) == true) goto L170;
        Uri r138 = Uri.parse(r136.f13665g);     // Catch: JSONException -> L274
        if (r138.getHost() == null) goto L171;
        r137.put("replace_host", r138.getHost());     // Catch: JSONException -> L274
    L171:
        r137.put("feedback", r136.f13664f);     // Catch: JSONException -> L274
        long r139 = r136.f13660b;     // Catch: JSONException -> L274
        if (r139 <= 0) goto L175;
        r137.put("rule_id", r139);     // Catch: JSONException -> L274
    L175:
        if (TextUtils.isEmpty(r136.f13659a) == true) goto L177;
        r137.put("service_name", r136.f13659a);     // Catch: JSONException -> L274
    L177:
        r52.put(r137);     // Catch: JSONException -> L274
        goto L161
    L170:
        r137.put("replace_host", "");     // Catch: JSONException -> L274
    L178:
        r51.put("action_info", r52);     // Catch: JSONException -> L274
        r51.put("empty_action", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().m());     // Catch: JSONException -> L274
        r54 = false;
        r51.put("host_replace_map", 0);     // Catch: JSONException -> L274
        goto L179
    L121:
        if (r35.A == null) goto L123;
        r34.put("hook", 1);     // Catch: JSONException -> L274
        goto L123
    L117:
        r33 = "";
        goto L118
    L77:
        r127 = false;
        goto L78
    L73:
        r126 = 0;
        goto L74
    L69:
        r125 = 0;
        goto L70
    L33:
        r114 = false;
    L274:
        e = move-exception;
        e.printStackTrace();
        goto L277
    }

    private static int i(IOException r10, int r11) {
        if (r10 != null) goto L21;
        return r11;
    L21:
        int r12 = j(r10.getMessage(), r11);     // Catch: Throwable -> L18
        if (r12 == r11) goto L19;
        return r12;
    L19:
        Throwable r13 = r10.getCause();     // Catch: Throwable -> L15
        if (r13 != null) goto L10;
        return r12;
    L10:
        String r14 = r13.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r14) == false) goto L13;
        return r12;
    L13:
        return j(r14, r11);
    L15:
        r11 = r12;
    L17:
        return r11;
    }

    private static int j(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r11;
    L6:
        if (r10.contains("ECONNRESET") == false) goto L8;
    L39:
        return -101;
    L8:
        if (r10.contains("Connection reset") == true) goto L39;
        if (r10.contains("reset by peer") == true) goto L39;
        if (r10.contains("ECONNREFUSED") == false) goto L16;
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r10.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
    L18:
        if (r10.contains("connection abort") == true) goto L38;
        if (r10.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r10.contains("Network is unreachable") == true) goto L37;
        if (r10.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r10.contains("ENETUNREACH") == true) goto L36;
        if (r10.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r10.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r11;
    }

    public static int k(IOException r10) {
        if ((r10 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r10 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r10 instanceof SSLProtocolException) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if ((r10 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r10 instanceof UnknownHostException) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if ((r10 instanceof ConnectException) == false) goto L22;
        int r11 = NetError.ERR_CONNECTION_FAILED;
    L60:
        return i(r10, r11);
    L22:
        if ((r10 instanceof PortUnreachableException) == false) goto L25;
        return NetError.ERR_ADDRESS_INVALID;
    L25:
        if ((r10 instanceof NoRouteToHostException) == false) goto L28;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if ((r10 instanceof BindException) == false) goto L31;
        return NetError.ERR_ADDRESS_IN_USE;
    L31:
        if ((r10 instanceof SocketException) == false) goto L34;
        r11 = -15;
        goto L60
    L34:
        if ((r10 instanceof MalformedURLException) == false) goto L37;
        return NetError.ERR_INVALID_URL;
    L37:
        if ((r10 instanceof SocketTimeoutException) == false) goto L40;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L40:
        if ((r10 instanceof ProtocolException) == false) goto L43;
        return -901;
    L43:
        if ((r10 instanceof HttpRetryException) == false) goto L51;
        String r12 = r10.getMessage();
        if (TextUtils.isEmpty(r12) == true) goto L68;
        if (r12.contains("Too many follow-up requests") == false) goto L68;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L68:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L51:
        if ((r10 instanceof UnknownServiceException) == false) goto L53;
        return -902;
    L53:
        return -1;
    }

    private static String o(r r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L17
        Iterator<Map.Entry<String, List<String>>> r12 = r10.h().entrySet().iterator();     // Catch: Exception -> L17
    L4:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Exception -> L17
        String r14 = r13.getKey();     // Catch: Exception -> L17
        List<String> r15 = r13.getValue();     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r14) == true) goto L4;
        if (r15 == null) goto L4;
        if (r15.size() <= 0) goto L4;
        Iterator<String> r16 = r15.iterator();     // Catch: Exception -> L17
    L13:
        if (r16.hasNext() == false) goto L4;
        r11.put(r14, r16.next());     // Catch: Exception -> L17
        goto L13
    L15:
        return r11.toString();
    L17:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private void p(String r12, JSONObject r13, long r14) {
        HashMap r11 = new HashMap();
        m r10 = new m();
        if (TextUtils.isEmpty(r12) == true) goto L18;
        String[] r15 = r12.split(",");
        if (r15 == null) goto L18;
        int r16 = r15.length;
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L18;
        String[] r18 = r15[r17].split(";");
        if (r18 == null) goto L17;
        if (r18.length != 2) goto L17;
        if (TextUtils.isEmpty(r18[0]) == true) goto L17;
        if (TextUtils.isEmpty(r18[1]) == true) goto L17;
        r11.put(r18[0], r18[1]);
    L17:
        r17 = r17 + 1;
    L18:
        Iterator r19 = r11.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L41;
        Map.Entry r110 = (Map.Entry) r19.next();
        String r20 = ((String) r110.getKey()).trim();
        String r111 = ((String) r110.getValue()).trim();
        if (r20.equalsIgnoreCase("cdn-cache") == true) goto L23;
        if (r20.equalsIgnoreCase("edge") == true) goto L31;
        if (r20.equalsIgnoreCase("origin") == true) goto L34;
        if (r20.equalsIgnoreCase("inner") == true) goto L37;
        if (TextUtils.isEmpty(r20) == true) goto L20;
        r13.put(r20, J(r111));
        goto L20
    L37:
        r10.f1783e = J(r111);
        goto L20
    L34:
        r10.f1782d = J(r111);
        goto L20
    L31:
        r10.f1781c = J(r111);
        goto L20
    L23:
        r10.f1779a = true;
        String[] r112 = r111.split("=");
        if (r112.length != 2) goto L28;
        if (r112[1].equalsIgnoreCase("hit") == false) goto L28;
        r10.f1780b = true;
    L28:
        r10.f1780b = false;
        goto L20
    L41:
        boolean r113 = r10.f1779a;
        if (r113 == true) goto L44;
    L50:
        if (r113 == false) goto L60;
        r13.put("edge", r10.f1781c);
        r13.put("cdn-cache", "miss");
        long r21 = r10.f1782d;
        long r22 = r10.f1783e;
        if (r21 <= r22) goto L54;
        r13.put("origin", r21 - r22);
    L55:
        r13.put("inner", r10.f1783e);
        if (r14 == (-1)) goto L66;
        long r23 = r10.f1782d;
        long r24 = r10.f1781c;
        if (r14 <= (r23 + r24)) goto L66;
        long r114 = (r14 - r23) - r24;
    L65:
        r10.f1784f = r114;
    L66:
        r13.put("rtt", r10.f1784f);
        return;
    L54:
        r13.put("origin", -1);
        goto L55
    L60:
        r13.put("inner", r10.f1783e);
        if (r14 == (-1)) goto L66;
        long r25 = r10.f1783e;
        if (r14 <= r25) goto L66;
    L64:
        r114 = r14 - r25;
        goto L65
    L44:
        if (r10.f1780b == false) goto L50;
        r13.put("edge", r10.f1781c);
        r13.put("cdn-cache", "hit");
        if (r14 == (-1)) goto L66;
        r25 = r10.f1781c;
        if (r14 <= r25) goto L66;
        goto L66
    }

    public void A() {
        this.f1757k = System.currentTimeMillis();
    }

    public void B() {
        this.f1752f = System.currentTimeMillis();
    }

    public void C() {
        this.f1751e = System.currentTimeMillis();
        this.K = LoadState.SSL_HANDSHAKE;
    }

    public void D(int r10) {
        this.M = r10;
    }

    public void E(String r10, String r11) {
        this.O = r10;
        this.L = r11;
    }

    public void F(o2.b r10, Context r11) {
        r10.f11397d = this.E;
        r10.f11407n = K(this.f1749c, this.f1748b);
        r10.f11408o = K(this.f1751e, this.f1750d);
        r10.f11409p = K(this.f1752f, this.f1751e);
        r10.f11410q = K(this.f1754h, this.f1753g) + K(this.f1756j, this.f1755i);
        r10.f11411r = K(this.f1758l, this.f1754h);
        if (this.f1750d == (-1)) goto L5;
    L7:
        boolean r12 = false;
    L8:
        r10.f11412s = r12;
        r10.f11413t = -1;
        r10.f11414u = K(this.f1761o.get(), this.f1747a);
        r10.f11415v = this.f1769w;
        r10.f11416w = this.f1772z;
        r10.A = h(r11);
        r r13 = this.f1770x;
        if (r13 == null) goto L11;
        o(r13);
        r10.f11415v += this.f1770x.a();
    L11:
        r r14 = this.G;
        if (r14 == null) goto L14;
        o(r14);
        r10.f11416w += this.G.a();
    L14:
        r10.N = this.H;
        return;
    L5:
        if (this.f1762p == (-1)) goto L7;
        r12 = true;
        goto L8
    }

    public void G(o2.c r10) {
        this.V = r10;
    }

    public void H(z r10) {
        boolean r11 = true;
        if (r10.f() == null) goto L5;
        boolean r12 = true;
    L6:
        this.C = r12;
        if (r10.D() != null) goto L10;
        r11 = false;
    L10:
        this.D = r11;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void a() {
        this.f1761o.set(System.currentTimeMillis());
        this.K = LoadState.IDLE;
        this.N = Status.SUCCESS;
    }

    public void b(IOException r10) {
        this.f1761o.set(System.currentTimeMillis());
        this.K = LoadState.IDLE;
        if (r10 != null) goto L5;
    L9:
        Status r11 = Status.FAILED;
    L10:
        this.N = r11;
        this.M = k(r10);
        return;
    L5:
        if (TextUtils.isEmpty(r10.getMessage()) == true) goto L9;
        if (r10.getMessage().contains("Canceled") == false) goto L9;
        r11 = Status.CANCELED;
        goto L10
    }

    public void c() {
        this.f1747a = System.currentTimeMillis();
        this.N = Status.IO_PENDING;
    }

    public void d(Proxy r10) {
        System.currentTimeMillis();
        if (r10 == null) goto L6;
        this.f1765s = r10.type();
        return;
    }

    public void e(InetSocketAddress r10, IOException r11, String r12) {
        System.currentTimeMillis();
        if (r10 == null) goto L8;
        if (this.f1761o.get() != (-1)) goto L8;
        this.f1764r.add(new Pair(r10, Integer.valueOf(k(r11))));
    L8:
        if (TextUtils.isEmpty(this.U) == true) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r12) == true) goto L14;
        this.U = r12;
        return;
    }

    public void f() {
        this.f1750d = System.currentTimeMillis();
        this.K = LoadState.CONNECTING;
    }

    public void g(okhttp3.i r10) {
        if (r10 != null) goto L4;
    L13:
        this.f1762p = System.currentTimeMillis();
        return;
    L4:
        if (this.f1761o.get() != (-1)) goto L13;
        if (r10.b() != null) goto L8;
    L12:
        this.F = r10.b();
        goto L13
    L8:
        if (r10.b().getInetAddress() == null) goto L12;
        if (r10.b().getInetAddress().getHostAddress() == null) goto L12;
        this.E = r10.b().getInetAddress().getHostAddress();
        goto L12
    }

    public void l() {
        this.f1749c = System.currentTimeMillis();
    }

    public void m(String r10) {
        this.f1749c = System.currentTimeMillis();
        this.U = r10;
    }

    public void n() {
        this.f1748b = System.currentTimeMillis();
        this.K = LoadState.RESOLVING_HOST;
    }

    public boolean q() {
        if (this.f1761o.get() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void r(String r10, String r11, long r12, boolean r13, List<y2.a> r14) {
        l r15 = new l();
        r15.f1775a = 307;
        r15.f1778d = true;
        r15.f1776b = r10;
        r15.f1777c = r11;
        this.f1746J.add(r15);
        this.I++;
        this.f1763q = r12;
        this.P = true;
        if (r13 == false) goto L5;
        this.Q = true;
        this.S = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().f().size();
        return;
    L5:
        this.R.addAll(r14);
        this.Q = false;
    }

    public void s(x2.b r10) {
        this.T = r10;
    }

    public void t(long r10) {
        this.f1756j = System.currentTimeMillis();
        this.f1769w = r10;
    }

    public void u() {
        this.f1755i = System.currentTimeMillis();
    }

    public void v(x r10) {
        this.f1754h = System.currentTimeMillis();
        if (r10 != null) goto L5;
    L9:
        this.K = LoadState.WAITING_FOR_RESPONSE;
        return;
    L5:
        if (this.f1761o.get() != (-1)) goto L9;
        this.f1770x = r10.e();
        if (r10.l() == null) goto L9;
        this.B = r10.l().s();
        goto L9
    }

    public void w() {
        this.K = LoadState.SENDING_REQUEST;
        this.f1753g = System.currentTimeMillis();
    }

    public void x(long r10) {
        this.f1760n = System.currentTimeMillis();
        this.f1772z = r10;
    }

    public void y() {
        this.K = LoadState.READING_RESPONSE;
        this.f1759m = System.currentTimeMillis();
    }

    public void z(z r10) {
        this.f1758l = System.currentTimeMillis();
        if (this.f1752f == (-1)) goto L5;
        HandshakeType r11 = HandshakeType.HANDSHAKE_FULL;
    L6:
        this.f1766t = r11;
        if (r10 != null) goto L9;
        return;
    L9:
        if (this.f1761o.get() != (-1)) goto L28;
        this.f1771y = r10.k();
        this.A = r10.I();
        if (r10.o() == null) goto L15;
        this.f1767u = r10.o().e();
        this.f1768v = r10.o().a();
    L15:
        if (r10.A() == false) goto L21;
        this.I++;
        l r12 = new l();
        r12.f1775a = r10.k();
        r12.f1776b = r10.K().g();
        String r13 = r10.p("location");
        if (TextUtils.isEmpty(r13) == true) goto L19;
        r12.f1777c = r13;
    L19:
        this.f1746J.add(r12);
    L21:
        if (r10.B() == false) goto L25;
        String r14 = r10.p("content-type");
        if (TextUtils.isEmpty(r14) == true) goto L25;
        this.H = r14;
    L25:
        this.G = r10.v();
        return;
    L28:
        return;
    L5:
        r11 = HandshakeType.HANDSHAKE_RESUME;
        goto L6
    }
}
