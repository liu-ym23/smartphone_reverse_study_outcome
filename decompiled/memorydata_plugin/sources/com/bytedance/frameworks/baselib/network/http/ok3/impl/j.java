package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okio.ByteString;
import org.chromium.wschannel.TrafficChangedObservable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private long A;
    private Protocol B;
    private String C;
    private boolean D;
    private boolean E;
    private String F;
    private Socket G;
    private Headers H;
    private String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f2492J;
    private final List<m> K;
    private LoadState L;
    private String M;
    private int N;
    private Status O;
    private String P;
    private boolean Q;
    private boolean R;
    private final List<com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.c> S;
    private int T;
    private com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b U;
    private String V;
    private com.bytedance.frameworks.baselib.network.http.c W;
    private com.bytedance.frameworks.baselib.network.http.b X;
    private Context Y;
    private final AtomicBoolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2494b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private final AtomicLong p;
    private long q;
    private long r;
    private final List<Pair<InetSocketAddress, Integer>> s;
    private Proxy.Type t;
    private HandshakeType u;
    private TlsVersion v;
    private CipherSuite w;
    private long x;
    private Headers y;
    private int z;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2495a = null;

        static {
            int[] r0 = new int[Protocol.values().length];
            f2495a = r0;
            r0[Protocol.HTTP_1_0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f2495a[Protocol.HTTP_1_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f2495a[Protocol.HTTP_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f2495a[Protocol.SPDY_3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f2495a[Protocol.QUIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public j(com.bytedance.frameworks.baselib.network.http.b r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.f2493a = -1;
        this.f2494b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = new AtomicLong(-1);
        this.q = -1;
        this.r = -1;
        this.s = new ArrayList();
        this.t = Proxy.Type.DIRECT;
        this.u = HandshakeType.HANDSHAKE_UNKNOWN;
        this.x = 0;
        this.z = -1;
        this.A = 0;
        this.B = null;
        this.C = "";
        this.D = false;
        this.E = false;
        this.F = "";
        this.I = "";
        this.f2492J = 0;
        this.K = new ArrayList();
        this.L = LoadState.IDLE;
        this.M = "";
        this.N = -1;
        this.O = Status.UNKNOWN;
        this.P = "";
        this.Q = false;
        this.R = false;
        this.S = new ArrayList();
        this.T = 0;
        this.V = "";
        this.Z = new AtomicBoolean(false);
        this.X = r6;
        this.Y = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
    }

    private static int a(IOException r2, int r3) {
        if (r2 != null) goto L21;
        return r3;
    L21:
        int r0 = a(r2.getMessage(), r3);     // Catch: Throwable -> L18
        if (r0 == r3) goto L19;
        return r0;
    L19:
        Throwable r4 = r2.getCause();     // Catch: Throwable -> L15
        if (r4 != null) goto L10;
        return r0;
    L10:
        String r5 = r4.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return r0;
    L13:
        return a(r5, r3);
    L15:
        r3 = r0;
    L17:
        return r3;
    }

    private static int a(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r2;
    L6:
        if (r1.contains("ECONNRESET") == false) goto L8;
    L39:
        return -101;
    L8:
        if (r1.contains("Connection reset") == true) goto L39;
        if (r1.contains("reset by peer") == true) goto L39;
        if (r1.contains("ECONNREFUSED") == false) goto L16;
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r1.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
    L18:
        if (r1.contains("connection abort") == true) goto L38;
        if (r1.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r1.contains("Network is unreachable") == true) goto L37;
        if (r1.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r1.contains("ENETUNREACH") == true) goto L36;
        if (r1.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r1.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r2;
    }

    private static long a(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r3 == (-1)) goto L8;
        return r3 - r5;
    }

    private static long a(String r7) {
        String[] r8 = r7.split("=");
        if (r8.length == 2) goto L12;
        return -1;
    L12:
        long r3 = Long.parseLong(r8[1]);     // Catch: NumberFormatException -> L11
        if (r3 >= 0) goto L10;
        return -1;
    L10:
        return r3;
    L16:
        return -1;
    }

    private static ConnectionInfo a(Protocol r1) {
        if (r1 == null) goto L4;
        int r2 = AnonymousClass1.f2495a[r1.ordinal()];
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L24;
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L20;
        if (r2 == 5) goto L18;
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

    private String a(Context r24) {
        String r2 = "Cookie";
        String r3 = "ssl";
        String r4 = "dns";
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.memorydata.plugin");
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L296
        String r12 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().g();     // Catch: JSONException -> L296
        ArrayList r13 = new ArrayList();     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r12) == true) goto L8;
        String[] r14 = r12.split(",");     // Catch: JSONException -> L296
        if (r14 == null) goto L8;
        r13.addAll(Arrays.asList(r14));     // Catch: JSONException -> L296
    L8:
        com.bytedance.frameworks.baselib.network.http.ok3.a r15 = o.i();     // Catch: JSONException -> L296
        if (r15 == null) goto L24;
        List<String> r16 = r15.e();     // Catch: JSONException -> L296
        if (r16 == null) goto L24;
        if (r16.size() > 5) goto L15;
    L17:
        Iterator<String> r17 = r16.iterator();     // Catch: JSONException -> L296
        int r18 = 0;
    L19:
        if (r17.hasNext() == false) goto L24;
        Iterator<String> r19 = r17;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        r18 = r18 + 1;     // Catch: JSONException -> L296
        if (r18 > 5) goto L24;
        r13.add(r110);     // Catch: JSONException -> L296
        r17 = r19;
        goto L19
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("ok3log", "ab sdk version count must less than 5");     // Catch: JSONException -> L296
    L24:
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L296
        Iterator r112 = r13.iterator();     // Catch: JSONException -> L296
    L26:
        if (r112.hasNext() == false) goto L30;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r113) == true) goto L26;
        r111.put(r113);     // Catch: JSONException -> L296
        goto L26
    L30:
        r11.put("hit", r111);     // Catch: JSONException -> L296
        r10.put("ab_test", r11);     // Catch: JSONException -> L296
        JSONObject r114 = new JSONObject();     // Catch: JSONException -> L296
        r114.put("load_state", this.L.ordinal());     // Catch: JSONException -> L296
        r114.put("method", this.M);     // Catch: JSONException -> L296
        if (this.O != Status.IO_PENDING) goto L33;
        boolean r115 = true;
    L34:
        r114.put("is_pending", r115);     // Catch: JSONException -> L296
        r114.put("status", this.O);     // Catch: JSONException -> L296
        if (this.O == Status.SUCCESS) goto L39;
        r114.put("net_error", this.N);     // Catch: JSONException -> L296
    L39:
        if (TextUtils.isEmpty(this.P) == true) goto L49;
        Uri r116 = Uri.parse(this.P);     // Catch: JSONException -> L296
        if (r116 == null) goto L49;
        if (TextUtils.isEmpty(r116.getScheme()) == true) goto L49;
        if (TextUtils.isEmpty(r116.getHost()) == true) goto L49;
        if (r116.getPath() == null) goto L49;
        r114.put("origin_url", r116.getScheme() + "://" + r116.getHost() + r116.getPath());     // Catch: JSONException -> L296
    L49:
        r114.put("redirect_times", this.f2492J);     // Catch: JSONException -> L296
        JSONArray r117 = new JSONArray();     // Catch: JSONException -> L296
        JSONArray r118 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<m> r119 = this.K.iterator();     // Catch: JSONException -> L296
    L51:
        String r120 = r2;
        if (r119.hasNext() == false) goto L67;
        String r121 = r3;
        Iterator<m> r122 = r119;
        m r5 = (m) ZeusTransformUtils.preCheckCast(r119.next(), m.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        JSONObject r123 = new JSONObject();     // Catch: JSONException -> L296
        String r20 = r4;
        r123.put("code", r5.f2497a);     // Catch: JSONException -> L296
        r123.put("method", r5.f2498b);     // Catch: JSONException -> L296
        r123.put("internal", r5.d);     // Catch: JSONException -> L296
        if (r5.c == null) goto L66;
        Uri r6 = Uri.parse(r5.c);     // Catch: JSONException -> L296
        if (r6 == null) goto L66;
        if (TextUtils.isEmpty(r6.getScheme()) == true) goto L66;
        if (TextUtils.isEmpty(r6.getHost()) == true) goto L66;
        String r7 = r6.getScheme() + "://" + r6.getHost();     // Catch: JSONException -> L296
        r118.put(r7);     // Catch: JSONException -> L296
        if (r6.getPath() == null) goto L65;
        r7 = r7 + r6.getPath();     // Catch: JSONException -> L296
    L65:
        r123.put("url", r7);     // Catch: JSONException -> L296
    L66:
        r117.put(r123);     // Catch: JSONException -> L296
        r3 = r121;
        r2 = r120;
        r119 = r122;
        r4 = r20;
        goto L51
    L67:
        String r124 = r3;
        String r21 = r4;
        r114.put("redirect_info", r117);     // Catch: JSONException -> L296
        r114.put("redirecting_list", r118);     // Catch: JSONException -> L296
        r114.put("dispatched", this.Q);     // Catch: JSONException -> L296
        r10.put("base", r114);     // Catch: JSONException -> L296
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L296
        r9.put("code", this.z);     // Catch: JSONException -> L296
        r9.put("connection_info", a(this.B).mValue);     // Catch: JSONException -> L296
        Headers r22 = this.y;     // Catch: JSONException -> L296
        if (r22 == null) goto L70;
        long r125 = r22.byteCount();     // Catch: JSONException -> L296
    L71:
        r9.put(TrafficChangedObservable.TRAFFICCHANGED_SENTBYTES, this.x + r125);     // Catch: JSONException -> L296
        Headers r23 = this.H;     // Catch: JSONException -> L296
        if (r23 == null) goto L74;
        long r126 = r23.byteCount();     // Catch: JSONException -> L296
    L75:
        r9.put(TrafficChangedObservable.TRAFFICCHANGED_RECEIVEDBYTES, this.A + r126);     // Catch: JSONException -> L296
        r9.put("cached", this.D);     // Catch: JSONException -> L296
        r9.put("network_accessed", this.E);     // Catch: JSONException -> L296
        if (this.t == Proxy.Type.DIRECT) goto L78;
        boolean r25 = true;
    L79:
        r9.put("via_proxy", r25);     // Catch: JSONException -> L296
        Headers r26 = this.H;     // Catch: JSONException -> L296
        if (r26 == null) goto L94;
        List<String> r27 = r26.values(Api.KEY_SET_COOKIE);     // Catch: JSONException -> L296
        if (com.bytedance.common.utility.collection.a.a(r27) == true) goto L84;
        boolean r28 = true;
    L85:
        r9.put("set_cookie", r28);     // Catch: JSONException -> L296
        if (r28 == false) goto L94;
        r9.put("set_cookie_lines", r27.size());     // Catch: JSONException -> L296
        Iterator<String> r29 = r27.iterator();     // Catch: JSONException -> L296
        long r127 = 0;
    L89:
        if (r29.hasNext() == false) goto L93;
        String r30 = (String) ZeusTransformUtils.preCheckCast(r29.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        if (r30 == null) goto L89;
        r127 = r127 + ((long) r30.length());     // Catch: JSONException -> L296
        goto L89
    L93:
        r9.put("set_cookie_bytes", r127);     // Catch: JSONException -> L296
        goto L94
    L84:
        r28 = false;
    L94:
        r10.put(ChatMessage.TYPE_RESPONSE, r9);     // Catch: JSONException -> L296
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L296
        if (this.H == null) goto L137;
        int r32 = 0;
    L99:
        if (r32 >= this.H.size()) goto L121;
        String r128 = this.H.name(r32);     // Catch: JSONException -> L296
        String r129 = this.H.value(r32);     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r128) == true) goto L120;
        if (TextUtils.isEmpty(r129) == true) goto L120;
        String r130 = r128.toLowerCase();     // Catch: JSONException -> L296
        if (r130.startsWith("x-tt-") == false) goto L120;
        if (r130.contains("sids") == true) goto L120;
        if (r130.contains("session") == true) goto L120;
        if (r130.contains("token") == true) goto L120;
        if (r130.contains("uid") == true) goto L120;
        if (r130.contains("sign") == true) goto L120;
        r31.put(r128, r129);     // Catch: JSONException -> L296
    L120:
        r32 = r32 + 1;     // Catch: JSONException -> L296
        goto L99
    L121:
        String r33 = this.H.get("tt-idc-switch");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r33) == true) goto L124;
        r31.put("tt-idc-switch", r33);     // Catch: JSONException -> L296
    L124:
        String r34 = this.H.get("server-timing");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r34) == true) goto L127;
        r31.put("server-timing", r34);     // Catch: JSONException -> L296
    L127:
        List<String> r35 = a.a().b();     // Catch: JSONException -> L296
        if (com.bytedance.common.utility.collection.a.a(r35) == true) goto L136;
        Iterator<String> r36 = r35.iterator();     // Catch: JSONException -> L296
    L131:
        if (r36.hasNext() == false) goto L136;
        String r37 = (String) ZeusTransformUtils.preCheckCast(r36.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r37) == true) goto L131;
        r31.remove(r37);     // Catch: JSONException -> L296
    L136:
        r10.put("header", r31);     // Catch: JSONException -> L296
    L138:
        JSONObject r38 = new JSONObject();     // Catch: JSONException -> L296
        r38.put("libcore", "okhttp");     // Catch: JSONException -> L296
        r38.put("core_ver", o.h());     // Catch: JSONException -> L296
        r38.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.frameworks.baselib.network.http.util.g.b(r8));     // Catch: JSONException -> L296
        r38.put("ttnet_version", "4.2.243.22-doubao");     // Catch: JSONException -> L296
        r38.put("retry_attempts", -1);     // Catch: JSONException -> L296
        com.bytedance.frameworks.baselib.network.http.c r39 = this.W;     // Catch: JSONException -> L296
        if (r39 != null) goto L141;
    L143:
        r10.put("other", r38);     // Catch: JSONException -> L296
        JSONObject r40 = new JSONObject();     // Catch: JSONException -> L296
        JSONObject r41 = new JSONObject();     // Catch: JSONException -> L296
        r41.put(r21, a(this.c, this.f2494b));     // Catch: JSONException -> L296
        r41.put("tcp", a(this.f, this.d));     // Catch: JSONException -> L296
        r41.put(r124, a(this.g, this.f));     // Catch: JSONException -> L296
        Object r131 = "";
        r41.put("send", a(this.i, this.h) + a(this.k, this.j));     // Catch: JSONException -> L296
        long r42 = a(this.m, this.i);     // Catch: JSONException -> L296
        r41.put("ttfb", r42);     // Catch: JSONException -> L296
        r41.put("header_recv", a(this.m, this.l));     // Catch: JSONException -> L296
        r41.put("body_recv", a(this.o, this.n));     // Catch: JSONException -> L296
        r41.put("dispatch", this.r);     // Catch: JSONException -> L296
        a(r34, r41, r42);     // Catch: JSONException -> L296
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b r43 = this.U;     // Catch: JSONException -> L296
        if (r43 != null) goto L147;
    L149:
        r40.put("detailed_duration", r41);     // Catch: JSONException -> L296
        JSONObject r44 = new JSONObject();     // Catch: JSONException -> L296
        r44.put("start_time", this.f2493a);     // Catch: JSONException -> L296
        r44.put("duration", a(this.p.get(), this.f2493a));     // Catch: JSONException -> L296
        r44.put("request_sent_time", this.h);     // Catch: JSONException -> L296
        r44.put("response_recv_time", this.l);     // Catch: JSONException -> L296
        r40.put(Ext.KEY_REQUEST, r44);     // Catch: JSONException -> L296
        r10.put("timing", r40);     // Catch: JSONException -> L296
        JSONObject r45 = new JSONObject();     // Catch: JSONException -> L296
        Socket r46 = this.G;     // Catch: JSONException -> L296
        if (r46 == null) goto L168;
        InetAddress r47 = r46.getInetAddress();     // Catch: JSONException -> L296
        if (r47 == null) goto L168;
        AddressFamily r48 = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;     // Catch: JSONException -> L296
        if (ZeusTransformUtils.instanceOf(r47, Inet4Address.class) == false) goto L157;
        r48 = AddressFamily.ADDRESS_FAMILY_IPV4;     // Catch: JSONException -> L296
    L159:
        r45.put("address_family", r48.ordinal());     // Catch: JSONException -> L296
        if (this.d == (-1)) goto L162;
    L164:
        boolean r49 = false;
    L165:
        r45.put("socket_reused", r49);     // Catch: JSONException -> L296
        if (r47.getHostAddress() == null) goto L168;
        r45.put("remote", r47.getHostAddress());     // Catch: JSONException -> L296
        goto L168
    L162:
        if (this.q == (-1)) goto L164;
        r49 = true;
        goto L165
    L157:
        if (ZeusTransformUtils.instanceOf(r47, Inet6Address.class) == false) goto L159;
        r48 = AddressFamily.ADDRESS_FAMILY_IPV6;     // Catch: JSONException -> L296
    L168:
        JSONArray r50 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<Pair<InetSocketAddress, Integer>> r51 = this.s.iterator();     // Catch: JSONException -> L296
    L170:
        if (r51.hasNext() == false) goto L172;
        Pair r52 = (Pair) ZeusTransformUtils.preCheckCast(r51.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        JSONObject r132 = new JSONObject();     // Catch: JSONException -> L296
        r132.put(MemoryKeyInfoEntity.KEY_ADDRESS, ((InetSocketAddress) ZeusTransformUtils.preCheckCast(r52.first, InetSocketAddress.class, "com.obric.memorydata.plugin")).toString().substring(1));     // Catch: JSONException -> L296
        r132.put("result", r52.second);     // Catch: JSONException -> L296
        r50.put(r132);     // Catch: JSONException -> L296
        goto L170
    L172:
        r45.put("connection_attempts", r50);     // Catch: JSONException -> L296
        r10.put("socket", r45);     // Catch: JSONException -> L296
        JSONObject r53 = new JSONObject();     // Catch: JSONException -> L296
        r53.put("handshake_type", this.u.ordinal());     // Catch: JSONException -> L296
        r53.put("cipher_suite", this.w);     // Catch: JSONException -> L296
        r53.put("ssl_version", this.v);     // Catch: JSONException -> L296
        r10.put(r124, r53);     // Catch: JSONException -> L296
        JSONObject r54 = new JSONObject();     // Catch: JSONException -> L296
        JSONArray r55 = new JSONArray();     // Catch: JSONException -> L296
        if (this.R == true) goto L176;
        List<com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.c> r133 = this.S;     // Catch: JSONException -> L296
        if (r133 == null) goto L200;
        Iterator<com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.c> r134 = r133.iterator();     // Catch: JSONException -> L296
    L181:
        if (r134.hasNext() == false) goto L200;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.c r135 = (com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.c) ZeusTransformUtils.preCheckCast(r134.next(), com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.c.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        JSONObject r136 = new JSONObject();     // Catch: JSONException -> L296
        if (r135.d == false) goto L181;
        r136.put("priority", r135.c);     // Catch: JSONException -> L296
        r136.put("type", r135.e);     // Catch: JSONException -> L296
        r136.put("action_hit", r135.d);     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r135.g) == true) goto L191;
        Uri r137 = Uri.parse(r135.g);     // Catch: JSONException -> L296
        if (r137.getHost() == null) goto L190;
        r136.put("replace_host", r137.getHost());     // Catch: JSONException -> L296
    L190:
        Object r138 = r131;
    L192:
        r136.put("feedback", r135.f);     // Catch: JSONException -> L296
        r131 = r138;
        if (r135.f2515b <= 0) goto L196;
        r136.put("rule_id", r135.f2515b);     // Catch: JSONException -> L296
    L196:
        if (TextUtils.isEmpty(r135.f2514a) == true) goto L198;
        r136.put("service_name", r135.f2514a);     // Catch: JSONException -> L296
    L198:
        r55.put(r136);     // Catch: JSONException -> L296
        goto L181
    L191:
        r138 = r131;
        r136.put("replace_host", r138);     // Catch: JSONException -> L296
    L200:
        r54.put("action_info", r55);     // Catch: JSONException -> L296
        r54.put("empty_action", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().b());     // Catch: JSONException -> L296
        boolean r56 = false;
        r54.put("host_replace_map", 0);     // Catch: JSONException -> L296
    L201:
        r54.put(AILabCheckPermissionTask.KEY_SOURCE, com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().d());     // Catch: JSONException -> L296
        r54.put("update_time", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().e());     // Catch: JSONException -> L296
        r54.put(URLDispatch.KEY_EPOCH, com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().c());     // Catch: JSONException -> L296
        r10.put("url_dispatch", r54);     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().f()) == true) goto L205;
        r10.put("tt_tnc_etag", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().f());     // Catch: JSONException -> L296
    L205:
        if (this.U == null) goto L230;
        JSONObject r57 = new JSONObject();     // Catch: JSONException -> L296
        if (this.U.c == null) goto L212;
        if (this.U.c.isEmpty() == true) goto L212;
        r57.put("header_add", this.U.c);     // Catch: JSONException -> L296
    L212:
        if (this.U.d == null) goto L217;
        if (this.U.d.isEmpty() == true) goto L217;
        r57.put("header_rm", this.U.d);     // Catch: JSONException -> L296
    L217:
        if (this.U.f2452a == null) goto L222;
        if (this.U.f2452a.isEmpty() == true) goto L222;
        r57.put("query_add", this.U.f2452a);     // Catch: JSONException -> L296
    L222:
        if (this.U.f2453b == null) goto L227;
        if (this.U.f2453b.isEmpty() == true) goto L227;
        r57.put("query_rm", this.U.f2453b);     // Catch: JSONException -> L296
    L227:
        if (r57.length() <= 0) goto L230;
        r10.put("meta_dp", r57);     // Catch: JSONException -> L296
    L230:
        if (TextUtils.isEmpty(this.V) == false) goto L303;
    L232:
        JSONObject r58 = new JSONObject();     // Catch: JSONException -> L296
        com.bytedance.frameworks.baselib.network.http.c r59 = this.W;     // Catch: JSONException -> L296
        if (r59 != null) goto L235;
        long r139 = 0;
    L247:
        r10.put("socket_timeout_param", r58);     // Catch: JSONException -> L296
        JSONObject r60 = new JSONObject();     // Catch: JSONException -> L296
        r60.put("ipv4_reachable", NetworkUtils.b(r8));     // Catch: JSONException -> L296
        r60.put("ipv6_reachable", com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.d.b().get());     // Catch: JSONException -> L296
        r10.put("ifconfig", r60);     // Catch: JSONException -> L296
        if (o.c() == null) goto L253;
        Object r61 = o.c().a();     // Catch: JSONException -> L296
        if (r61 == null) goto L253;
        r10.put("tnc", r61);     // Catch: JSONException -> L296
    L253:
        if (com.bytedance.frameworks.baselib.network.http.d.b.a().e() == null) goto L256;
        r10.put("store_idc", com.bytedance.frameworks.baselib.network.http.d.b.a().e());     // Catch: JSONException -> L296
    L256:
        if (this.y == null) goto L299;
        JSONObject r62 = new JSONObject();     // Catch: JSONException -> L296
        List<String> r63 = this.y.values(r120);     // Catch: JSONException -> L296
        if (com.bytedance.common.utility.collection.a.a(r63) == true) goto L260;
        boolean r140 = true;
    L261:
        r62.put(r120, r140);     // Catch: JSONException -> L296
        if (r140 == false) goto L270;
        Iterator<String> r64 = r63.iterator();     // Catch: JSONException -> L296
    L265:
        if (r64.hasNext() == false) goto L269;
        String r65 = (String) ZeusTransformUtils.preCheckCast(r64.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L296
        if (r65 == null) goto L265;
        r139 = r139 + ((long) r65.length());     // Catch: JSONException -> L296
        goto L265
    L269:
        r62.put("add_cookie_bytes", r139);     // Catch: JSONException -> L296
    L270:
        String r66 = this.y.get("x-tt-token");     // Catch: JSONException -> L296
        if (r66 == null) goto L276;
        if (r66.isEmpty() == true) goto L276;
        r62.put("token_md5", ByteString.encodeUtf8(r66).md5().hex());     // Catch: JSONException -> L296
    L276:
        if ("http".equalsIgnoreCase(this.C) == false) goto L294;
        if (r63 != null) goto L279;
    L287:
        Set<String> r1 = com.bytedance.frameworks.baselib.network.a.a.a(this.y);     // Catch: JSONException -> L296
        if (r1 == null) goto L294;
        JSONArray r67 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<String> r68 = r1.iterator();     // Catch: JSONException -> L296
    L291:
        if (r68.hasNext() == false) goto L293;
        r67.put((String) ZeusTransformUtils.preCheckCast(r68.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: JSONException -> L296
        goto L291
    L293:
        r62.put("insecure_headers", r67);     // Catch: JSONException -> L296
        goto L294
    L279:
        if (r63.isEmpty() == true) goto L287;
        Set<String> r69 = com.bytedance.frameworks.baselib.network.a.a.a(r63);     // Catch: JSONException -> L296
        if (r69 == null) goto L287;
        JSONArray r70 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<String> r71 = r69.iterator();     // Catch: JSONException -> L296
    L284:
        if (r71.hasNext() == false) goto L286;
        r70.put((String) ZeusTransformUtils.preCheckCast(r71.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: JSONException -> L296
        goto L284
    L286:
        r62.put("insecure_cookies", r70);     // Catch: JSONException -> L296
    L294:
        r10.put("session", r62);     // Catch: JSONException -> L296
        goto L299
    L260:
        r140 = r56;
    L299:
        return r10.toString();
    L235:
        if (r59.i <= 0) goto L238;
        r58.put("protect", this.W.i);     // Catch: JSONException -> L296
    L238:
        if (this.W.f <= 0) goto L241;
        r58.put("connect", this.W.f);     // Catch: JSONException -> L296
    L241:
        if (this.W.d <= 0) goto L243;
        r58.put("read", this.W.d);     // Catch: JSONException -> L296
    L243:
        r139 = 0;
        if (this.W.e <= 0) goto L247;
        r58.put("write", this.W.e);     // Catch: JSONException -> L296
        goto L247
    L303:
        r10.put(r21, new JSONObject(this.V));     // Catch: JSONException -> L300
        goto L232
    L176:
        r54.put("host_replace_map", 1);     // Catch: JSONException -> L296
        r54.put("host_replace_map_size", this.T);     // Catch: JSONException -> L296
        r56 = false;
        goto L201
    L147:
        if (r43.e < 0) goto L149;
        r41.put("meta_dp", this.U.e);     // Catch: JSONException -> L296
        goto L149
    L141:
        if (r39.A == null) goto L143;
        r38.put("hook", 1);     // Catch: JSONException -> L296
        goto L143
    L137:
        r34 = "";
        goto L138
    L78:
        r25 = false;
        goto L79
    L74:
        r126 = 0;
        goto L75
    L70:
        r125 = 0;
        goto L71
    L33:
        r115 = false;
    L296:
        e = move-exception;
        e.printStackTrace();
        goto L299
    }

    private static String a(Headers r6) {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L18
        Iterator<Map.Entry<String, List<String>>> r7 = r6.toMultimap().entrySet().iterator();     // Catch: Exception -> L18
    L5:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r3) == true) goto L5;
        if (r4 == null) goto L5;
        if (r4.size() <= 0) goto L5;
        Iterator r5 = r4.iterator();     // Catch: Exception -> L18
    L14:
        if (r5.hasNext() == false) goto L5;
        r1.put(r3, (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L18
        goto L14
    L16:
        return r1.toString();
    L18:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private void a(String r16, JSONObject r17, long r18) {
        HashMap r1 = new HashMap();
        n r2 = new n();
        if (TextUtils.isEmpty(r16) == true) goto L18;
        String[] r3 = r16.split(",");
        if (r3 == null) goto L18;
        int r7 = r3.length;
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L18;
        String[] r9 = r3[r8].split(";");
        if (r9 == null) goto L17;
        if (r9.length != 2) goto L17;
        if (TextUtils.isEmpty(r9[0]) == true) goto L17;
        if (TextUtils.isEmpty(r9[1]) == true) goto L17;
        r1.put(r9[0], r9[1]);
    L17:
        r8 = r8 + 1;
    L18:
        Iterator r4 = r1.entrySet().iterator();
    L20:
        if (r4.hasNext() == false) goto L42;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r12 = ((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin")).trim();
        String r6 = ((String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.memorydata.plugin")).trim();
        if (r12.equalsIgnoreCase("cdn-cache") == true) goto L23;
        if (r12.equalsIgnoreCase("edge") == true) goto L31;
        if (r12.equalsIgnoreCase("origin") == true) goto L34;
        if (r12.equalsIgnoreCase("inner") == true) goto L37;
        if (TextUtils.isEmpty(r12) == true) goto L20;
        r17.put(r12, a(r6));
        goto L20
    L37:
        r2.e = a(r6);
        goto L20
    L34:
        r2.d = a(r6);
        goto L20
    L31:
        r2.c = a(r6);
        goto L20
    L23:
        r2.f2499a = true;
        String[] r10 = r6.split("=");
        if (r10.length != 2) goto L28;
        if (r10[1].equalsIgnoreCase("hit") == false) goto L28;
        r2.f2500b = true;
    L28:
        r2.f2500b = false;
        goto L20
    L42:
        if (r2.f2499a == false) goto L51;
        if (r2.f2500b == false) goto L51;
        r17.put("edge", r2.c);
        r17.put("cdn-cache", "hit");
        if (r18 != (-1)) goto L48;
    L68:
        r17.put("rtt", r2.f);
        return;
    L48:
        if (r18 <= r2.c) goto L68;
        long r11 = r2.c;
    L66:
        long r13 = r18 - r11;
    L67:
        r2.f = r13;
    L51:
        if (r2.f2499a == false) goto L61;
        r17.put("edge", r2.c);
        r17.put("cdn-cache", "miss");
        if (r2.d <= r2.e) goto L55;
        r17.put("origin", r2.d - r2.e);
    L56:
        r17.put("inner", r2.e);
        if (r18 == (-1)) goto L68;
        if (r18 <= (r2.d + r2.c)) goto L68;
        r13 = (r18 - r2.d) - r2.c;
        goto L67
    L55:
        r17.put("origin", -1);
        goto L56
    L61:
        r17.put("inner", r2.e);
        if (r18 == (-1)) goto L68;
        if (r18 <= r2.e) goto L68;
        r11 = r2.e;
        goto L66
    }

    public static int b(IOException r2) {
        if (ZeusTransformUtils.instanceOf(r2, SSLHandshakeException.class) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, SSLKeyException.class) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, SSLProtocolException.class) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, SSLPeerUnverifiedException.class) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, UnknownHostException.class) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, ConnectException.class) == false) goto L22;
        int r0 = NetError.ERR_CONNECTION_FAILED;
    L60:
        return a(r2, r0);
    L22:
        if (ZeusTransformUtils.instanceOf(r2, PortUnreachableException.class) == false) goto L25;
        return NetError.ERR_ADDRESS_INVALID;
    L25:
        if (ZeusTransformUtils.instanceOf(r2, NoRouteToHostException.class) == false) goto L28;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (ZeusTransformUtils.instanceOf(r2, BindException.class) == false) goto L31;
        return NetError.ERR_ADDRESS_IN_USE;
    L31:
        if (ZeusTransformUtils.instanceOf(r2, SocketException.class) == false) goto L34;
        r0 = -15;
        goto L60
    L34:
        if (ZeusTransformUtils.instanceOf(r2, MalformedURLException.class) == false) goto L37;
        return NetError.ERR_INVALID_URL;
    L37:
        if (ZeusTransformUtils.instanceOf(r2, SocketTimeoutException.class) == false) goto L40;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L40:
        if (ZeusTransformUtils.instanceOf(r2, ProtocolException.class) == false) goto L43;
        return NetError.ERR_FTX_NULL_CLIENT;
    L43:
        if (ZeusTransformUtils.instanceOf(r2, HttpRetryException.class) == false) goto L51;
        String r3 = r2.getMessage();
        if (TextUtils.isEmpty(r3) == true) goto L68;
        if (r3.contains("Too many follow-up requests") == false) goto L68;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L68:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L51:
        if (ZeusTransformUtils.instanceOf(r2, UnknownServiceException.class) == false) goto L53;
        return NetError.ERR_FTX_NULL_SESSION;
    L53:
        return -1;
    }

    private void m() {
        this.X.l = -1;
        this.X.d.setKernelDns(a(this.c, this.f2494b));
        this.X.d.setKernelTCPConnect(a(this.f, this.d));
        this.X.d.setKernelTls(a(this.g, this.f));
        this.X.d.setKernelSend(a(this.i, this.h) + a(this.k, this.j));
        this.X.d.setKernelPush(-1);
        this.X.d.setKernelTTFB(-1);
        this.X.d.setKernelReceiveBody(a(this.o, this.n));
        this.X.d.setKernelTotal(a(this.p.get(), this.f2493a));
        this.X.d.setNetworkKernelRawRequestLog(a(this.Y));
        this.X.w = this.F;
        com.bytedance.frameworks.baselib.network.http.b r0 = this.X;
        if (this.d == (-1)) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.D = r3;
        this.X.x = this.x;
        this.X.y = this.A;
        this.X.z = this.A;
        this.X.E = -1;
        Headers r1 = this.y;
        if (r1 == null) goto L11;
        this.X.M = a(r1);
        this.X.x += this.y.byteCount();
    L11:
        Headers r2 = this.H;
        if (r2 == null) goto L14;
        this.X.N = a(r2);
        this.X.y += this.H.byteCount();
    L14:
        this.X.O = this.I;
        this.X.d.markNetworkKernelLogCollected();
        return;
    L5:
        if (this.q == (-1)) goto L7;
        r3 = true;
        goto L8
    }

    public void a() {
        this.Z.set(true);
    }

    public void a(int r1) {
        this.N = r1;
    }

    public void a(long r3) {
        this.k = System.currentTimeMillis();
        this.x = r3;
    }

    public void a(com.bytedance.frameworks.baselib.network.http.c r1) {
        this.W = r1;
    }

    public void a(com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b r1) {
        this.U = r1;
    }

    public void a(IOException r6) {
        if (this.p.compareAndSet(-1, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (this.Z.get() == false) goto L8;
        r6 = new IOException("Biz Canceled");
    L8:
        this.L = LoadState.IDLE;
        if (r6 != null) goto L11;
    L15:
        Status r0 = Status.FAILED;
    L16:
        this.O = r0;
        this.N = b(r6);
        m();
        return;
    L11:
        if (TextUtils.isEmpty(r6.getMessage()) == true) goto L15;
        if (r6.getMessage().contains("Canceled") == false) goto L15;
        r0 = Status.CANCELED;
        goto L16
    }

    public void a(String r1, String r2) {
        this.P = r1;
        this.M = r2;
    }

    public void a(String r3, String r4, long r5, boolean r7, List<com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.c> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        m r0 = new m();
        r0.f2497a = 307;
        r0.d = true;
        r0.f2498b = r3;
        r0.c = r4;
        this.K.add(r0);
        this.f2492J++;
        this.r = r5;
        this.Q = true;
        if (r7 == false) goto L5;
        this.R = true;
        this.T = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().h().size();
        return;
    L5:
        this.S.addAll(r9);
        this.R = false;
    }

    public void a(Proxy r3) {
        this.e = System.currentTimeMillis();
        if (r3 == null) goto L6;
        this.t = r3.type();
        return;
    }

    public void a(Connection r5) {
        Connection r6 = (Connection) ZeusTransformUtils.wrapperContextForParams(r5, Connection.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L14:
        this.q = System.currentTimeMillis();
        return;
    L5:
        if (this.p.get() != (-1)) goto L14;
        if (r6.socket() != null) goto L9;
    L13:
        this.G = r6.socket();
        goto L14
    L9:
        if (r6.socket().getInetAddress() == null) goto L13;
        if (r6.socket().getInetAddress().getHostAddress() == null) goto L13;
        this.F = r6.socket().getInetAddress().getHostAddress();
        goto L13
    }

    public void a(Request r5) {
        this.i = System.currentTimeMillis();
        if (r5 != null) goto L5;
    L9:
        this.L = LoadState.WAITING_FOR_RESPONSE;
        return;
    L5:
        if (this.p.get() != (-1)) goto L9;
        this.y = r5.headers();
        if (r5.url() == null) goto L9;
        this.C = r5.url().scheme();
        goto L9
    }

    public void a(Response r5) {
        this.m = System.currentTimeMillis();
        if (this.g == (-1)) goto L5;
        HandshakeType r0 = HandshakeType.HANDSHAKE_FULL;
    L6:
        this.u = r0;
        if (r5 != null) goto L9;
        return;
    L9:
        if (this.p.get() != (-1)) goto L38;
        this.z = r5.code();
        this.B = r5.protocol();
        if (r5.handshake() == null) goto L15;
        this.v = r5.handshake().tlsVersion();
        this.w = r5.handshake().cipherSuite();
    L15:
        if (r5.isRedirect() == false) goto L28;
        this.f2492J++;
        m r1 = new m();
        r1.f2497a = r5.code();
        r1.f2498b = r5.request().method();
        String r2 = r5.header("location");
        if (TextUtils.isEmpty(r2) == false) goto L35;
    L26:
        this.K.add(r1);
        goto L28
    L35:
        HttpUrl r3 = r5.request().url().resolve(r2);     // Catch: Throwable -> L34
        if (r3 == null) goto L24;
        if (TextUtils.isEmpty(r3.host()) == true) goto L24;
        r1.c = r3.toString();     // Catch: Throwable -> L34
    L24:
        if (TextUtils.isEmpty(r1.c) == false) goto L26;
        r1.c = r2;
    L28:
        if (r5.isSuccessful() == false) goto L32;
        String r4 = r5.header("content-type");
        if (TextUtils.isEmpty(r4) == true) goto L32;
        this.I = r4;
    L32:
        this.H = r5.headers();
        return;
    L38:
        return;
    L5:
        r0 = HandshakeType.HANDSHAKE_RESUME;
        goto L6
    }

    public void b() {
        this.f2493a = System.currentTimeMillis();
        this.O = Status.IO_PENDING;
    }

    public void b(long r3) {
        this.o = System.currentTimeMillis();
        this.A = r3;
    }

    public void b(Response r4) {
        boolean r1 = true;
        if (r4.cacheResponse() == null) goto L5;
        boolean r0 = true;
    L6:
        this.D = r0;
        if (r4.networkResponse() != null) goto L10;
        r1 = false;
    L10:
        this.E = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void c() {
        this.f2494b = System.currentTimeMillis();
        this.L = LoadState.RESOLVING_HOST;
    }

    public void d() {
        this.c = System.currentTimeMillis();
    }

    public void e() {
        this.d = System.currentTimeMillis();
        this.L = LoadState.CONNECTING;
    }

    public void f() {
        this.f = System.currentTimeMillis();
        this.L = LoadState.SSL_HANDSHAKE;
    }

    public void g() {
        this.g = System.currentTimeMillis();
    }

    public void h() {
        this.L = LoadState.SENDING_REQUEST;
        this.h = System.currentTimeMillis();
    }

    public void i() {
        this.j = System.currentTimeMillis();
    }

    public void j() {
        this.l = System.currentTimeMillis();
    }

    public void k() {
        this.L = LoadState.READING_RESPONSE;
        this.n = System.currentTimeMillis();
    }

    public void l() {
        if (this.p.compareAndSet(-1, System.currentTimeMillis()) == true) goto L5;
        return;
    L5:
        this.L = LoadState.IDLE;
        this.O = Status.SUCCESS;
        m();
    }
}
