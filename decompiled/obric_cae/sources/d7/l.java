package d7;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.wifi.WiFiDBHelper;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import we.e0;
import we.w;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public w A;
    public boolean B;
    public boolean C;
    public String D;
    public Socket E;
    public we.q F;
    public String G;
    public int H;
    public final ArrayList I;
    public d J;
    public final String K;
    public int L;
    public s M;
    public String N;
    public boolean O;
    public boolean P;
    public List<g7.d> Q;
    public int R;
    public e7.b.a S;
    public final CopyOnWriteArrayList<String> T;
    public String U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f6878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f6879l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6880m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f6881n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f6882o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f6883p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f6884q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f6885r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Proxy.Type f6886s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f6887t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public e0 f6888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public we.g f6889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f6890w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public we.q f6891x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f6893z;

    public l() {
        this.f6868a = -1;
        this.f6869b = -1;
        this.f6870c = -1;
        this.f6871d = -1;
        this.f6872e = -1;
        this.f6873f = -1;
        this.f6874g = -1;
        this.f6875h = -1;
        this.f6876i = -1;
        this.f6877j = -1;
        this.f6878k = -1;
        this.f6879l = -1;
        this.f6880m = -1;
        this.f6881n = -1;
        this.f6882o = -1;
        this.f6883p = -1;
        this.f6884q = -1;
        this.f6885r = new ArrayList();
        this.f6886s = Proxy.Type.DIRECT;
        this.f6887t = c.f6847a;
        this.f6890w = 0;
        this.f6892y = -1;
        this.f6893z = 0;
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = "";
        this.G = "";
        this.H = 0;
        this.I = new ArrayList();
        this.J = d.f6851a;
        this.K = "";
        this.L = -1;
        this.M = s.f6935a;
        this.N = "";
        this.O = false;
        this.P = false;
        this.R = 0;
        this.S = e7.b.a.f7149a;
        this.T = new CopyOnWriteArrayList();
        this.U = "";
    }

    public static void a(long r11, String r13, JSONObject r14) {
        HashMap r8 = new HashMap();
        o r10 = new o();
        if (TextUtils.isEmpty(r13) == true) goto L16;
        String[] r15 = r13.split(",");
        if (r15 == null) goto L16;
        int r12 = r15.length;
        int r16 = 0;
    L7:
        if (r16 >= r12) goto L16;
        String[] r17 = r15[r16].split(";");
        if (r17 == null) goto L15;
        if (TextUtils.isEmpty(r17[0]) == true) goto L15;
        if (TextUtils.isEmpty(r17[1]) == true) goto L15;
        r8.put(r17[0], r17[1]);
    L15:
        r16 = r16 + 1;
    L16:
        Iterator r18 = r8.entrySet().iterator();
    L18:
        if (r18.hasNext() == false) goto L39;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = ((String) r19.getKey()).trim();
        String r21 = ((String) r19.getValue()).trim();
        if (r20.equalsIgnoreCase("cdn-cache") == true) goto L21;
        if (r20.equalsIgnoreCase("edge") == true) goto L29;
        if (r20.equalsIgnoreCase("origin") == true) goto L32;
        if (r20.equalsIgnoreCase("inner") == true) goto L35;
        if (TextUtils.isEmpty(r20) == true) goto L18;
        r14.put(r20, c(r21));
        goto L18
    L35:
        r10.f6902e = c(r21);
        goto L18
    L32:
        r10.f6901d = c(r21);
        goto L18
    L29:
        r10.f6900c = c(r21);
        goto L18
    L21:
        r10.f6898a = true;
        String[] r22 = r21.split("=");
        if (r22.length != 2) goto L26;
        if (r22[1].equalsIgnoreCase("hit") == false) goto L26;
        r10.f6899b = true;
    L26:
        r10.f6899b = false;
        goto L18
    L39:
        boolean r110 = r10.f6898a;
        if (r110 == true) goto L42;
    L48:
        if (r110 == false) goto L58;
        r14.put("edge", r10.f6900c);
        r14.put("cdn-cache", "miss");
        long r23 = r10.f6901d;
        long r24 = r10.f6902e;
        if (r23 <= r24) goto L52;
        r14.put("origin", r23 - r24);
    L53:
        r14.put("inner", r10.f6902e);
        if (r11 == (-1)) goto L64;
        long r25 = r10.f6901d;
        long r26 = r10.f6900c;
        if (r11 <= (r25 + r26)) goto L64;
        long r111 = (r11 - r25) - r26;
    L63:
        r10.f6903f = r111;
    L64:
        r14.put("rtt", r10.f6903f);
        return;
    L52:
        r14.put("origin", -1);
        goto L53
    L58:
        r14.put("inner", r10.f6902e);
        if (r11 == (-1)) goto L64;
        long r27 = r10.f6902e;
        if (r11 <= r27) goto L64;
    L62:
        r111 = r11 - r27;
        goto L63
    L42:
        if (r10.f6899b == false) goto L48;
        r14.put("edge", r10.f6900c);
        r14.put("cdn-cache", "hit");
        if (r11 == (-1)) goto L64;
        r27 = r10.f6900c;
        if (r11 <= r27) goto L64;
        goto L64
    }

    public static long c(String r8) {
        String[] r10 = r8.split("=");
        if (r10.length == 2) goto L12;
        return -1;
    L12:
        long r11 = Long.parseLong(r10[1]);     // Catch: NumberFormatException -> L11
        if (r11 >= 0) goto L10;
        return -1;
    L10:
        return r11;
    L16:
        return -1;
    }

    public static long d(long r8, long r10) {
        if (r10 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r8 == (-1)) goto L8;
        return r8 - r10;
    }

    public final void b(w6.a r22, Context r23) {
        r22.f12990a = this.D;
        r22.f12999j = d(this.f6870c, this.f6869b);
        r22.f13000k = d(this.f6872e, this.f6871d);
        r22.f13001l = d(this.f6873f, this.f6872e);
        r22.f13002m = d(this.f6877j, this.f6876i) + d(this.f6875h, this.f6874g);
        r22.f13003n = d(this.f6879l, this.f6875h);
        if (this.f6871d == (-1)) goto L5;
    L7:
        boolean r8 = false;
    L8:
        r22.f13004o = r8;
        r22.f13005p = -1;
        r22.f13006q = d(this.f6882o, this.f6868a);
        r22.f13007r = this.f6890w;
        r22.f13008s = this.f6893z;
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L159
        String r14 = g7.j.e().f7753l;     // Catch: JSONException -> L159
        if (TextUtils.isEmpty(r14) == true) goto L18;
        String[] r15 = r14.split(",");     // Catch: JSONException -> L159
        JSONArray r16 = new JSONArray();     // Catch: JSONException -> L159
        int r10 = r15.length;     // Catch: JSONException -> L159
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L17;
        String r17 = r15[r11];     // Catch: JSONException -> L159
        if (TextUtils.isEmpty(r17) == true) goto L16;
        r16.put(r17);     // Catch: JSONException -> L159
    L16:
        r11 = r11 + 1;     // Catch: JSONException -> L159
        goto L12
    L17:
        r13.put("hit", r16);     // Catch: JSONException -> L159
    L18:
        r12.put("ab_test", r13);     // Catch: JSONException -> L159
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L159
        r18.put("load_state", this.J.ordinal());     // Catch: JSONException -> L159
        r18.put(BdimCategoryConstants.INTENT_KEY_METHOD, this.K);     // Catch: JSONException -> L159
        if (this.M != s.f6937m) goto L21;
        boolean r19 = true;
    L22:
        r18.put("is_pending", r19);     // Catch: JSONException -> L159
        r18.put("status", this.M);     // Catch: JSONException -> L159
        if (this.M == s.f6936b) goto L25;
        r18.put("net_error", this.L);     // Catch: JSONException -> L159
    L25:
        r18.put("origin_url", this.N);     // Catch: JSONException -> L159
        r18.put("redirect_times", this.H);     // Catch: JSONException -> L159
        JSONArray r20 = new JSONArray();     // Catch: JSONException -> L159
        JSONArray r21 = new JSONArray();     // Catch: JSONException -> L159
        Iterator r110 = this.I.iterator();     // Catch: JSONException -> L159
    L28:
        if (r110.hasNext() == false) goto L39;
        n r111 = (n) r110.next();     // Catch: JSONException -> L159
        JSONObject r24 = new JSONObject();     // Catch: JSONException -> L159
        Iterator r112 = r110;
        r24.put("code", r111.f6894a);     // Catch: JSONException -> L159
        r24.put(BdimCategoryConstants.INTENT_KEY_METHOD, r111.f6895b);     // Catch: JSONException -> L159
        r24.put(WsConstants.KEY_CONNECTION_URL, r111.f6896c);     // Catch: JSONException -> L159
        r24.put("internal", r111.f6897d);     // Catch: JSONException -> L159
        r20.put(r24);     // Catch: JSONException -> L159
        String r25 = r111.f6896c;     // Catch: JSONException -> L159
        if (r25 == null) goto L38;
        Uri r26 = Uri.parse(r25);     // Catch: JSONException -> L159
        if (r26 == null) goto L38;
        if (TextUtils.isEmpty(r26.getScheme()) == true) goto L38;
        if (TextUtils.isEmpty(r26.getHost()) == true) goto L38;
        r21.put(r26.getScheme() + "://" + r26.getHost());     // Catch: JSONException -> L159
    L38:
        r110 = r112;
        goto L28
    L39:
        r18.put("redirect_info", r20);     // Catch: JSONException -> L159
        r18.put("redirecting_list", r21);     // Catch: JSONException -> L159
        r18.put("dispatched", this.O);     // Catch: JSONException -> L159
        r12.put("base", r18);     // Catch: JSONException -> L159
        JSONObject r27 = new JSONObject();     // Catch: JSONException -> L159
        r27.put("code", this.f6892y);     // Catch: JSONException -> L159
        w r28 = this.A;     // Catch: JSONException -> L159
        if (r28 == null) goto L51;
        int r29 = r28.ordinal();     // Catch: JSONException -> L159
        if (r29 != 0) goto L45;
        b r30 = b.f6844q;     // Catch: JSONException -> L159
    L57:
        r27.put("connection_info", r30.f6846a);     // Catch: JSONException -> L159
        we.q r31 = this.f6891x;     // Catch: JSONException -> L159
        if (r31 == null) goto L60;
        long r32 = r31.a();     // Catch: JSONException -> L159
    L61:
        r27.put("sent_bytes", this.f6890w + r32);     // Catch: JSONException -> L159
        we.q r33 = this.F;     // Catch: JSONException -> L159
        if (r33 == null) goto L64;
        long r34 = r33.a();     // Catch: JSONException -> L159
    L65:
        r27.put("received_bytes", this.f6893z + r34);     // Catch: JSONException -> L159
        r27.put("cached", this.B);     // Catch: JSONException -> L159
        r27.put("network_accessed", this.C);     // Catch: JSONException -> L159
        if (this.f6886s == Proxy.Type.DIRECT) goto L68;
        boolean r35 = true;
    L69:
        r27.put("via_proxy", r35);     // Catch: JSONException -> L159
        r12.put("response", r27);     // Catch: JSONException -> L159
        JSONObject r36 = new JSONObject();     // Catch: JSONException -> L159
        if (this.F == null) goto L90;
        int r37 = 0;
    L73:
        we.q r113 = this.F;     // Catch: JSONException -> L159
        if (r37 >= (r113.f13238a.length / 2)) goto L83;
        String r114 = r113.e(r37);     // Catch: JSONException -> L159
        String r115 = this.F.j(r37);     // Catch: JSONException -> L159
        if (TextUtils.isEmpty(r114) == true) goto L82;
        if (r114.startsWith("x-tt-") == false) goto L82;
        if (TextUtils.isEmpty(r115) == true) goto L82;
        r36.put(r114, r115);     // Catch: JSONException -> L159
    L82:
        r37 = r37 + 1;     // Catch: JSONException -> L159
        goto L73
    L83:
        String r38 = r113.d("tt-idc-switch");     // Catch: JSONException -> L159
        if (TextUtils.isEmpty(r38) == true) goto L86;
        r36.put("tt-idc-switch", r38);     // Catch: JSONException -> L159
    L86:
        String r39 = this.F.d("server-timing");     // Catch: JSONException -> L159
        if (TextUtils.isEmpty(r39) == true) goto L89;
        r36.put("server-timing", r39);     // Catch: JSONException -> L159
    L89:
        r12.put(CloudServiceConstants.OCloud.HEADER, r36);     // Catch: JSONException -> L159
    L91:
        JSONObject r40 = new JSONObject();     // Catch: JSONException -> L159
        r40.put("libcore", "okhttp");     // Catch: JSONException -> L159
        r40.put("core_ver", "tt-ok/3.10.0.2");     // Catch: JSONException -> L159
        r40.put(LocationMonitorConst.IS_MAIN_PROCESS, l7.e.c(r23));     // Catch: JSONException -> L159
        r40.put("ttnet_version", "4.0.76.2");     // Catch: JSONException -> L159
        r40.put(ICronetClient.KEY_RETRY_ATTEMPTS, -1);     // Catch: JSONException -> L159
        r12.put("other", r40);     // Catch: JSONException -> L159
        JSONObject r41 = new JSONObject();     // Catch: JSONException -> L159
        JSONObject r42 = new JSONObject();     // Catch: JSONException -> L159
        r42.put("dns", d(this.f6870c, this.f6869b));     // Catch: JSONException -> L159
        r42.put("tcp", d(this.f6872e, this.f6871d));     // Catch: JSONException -> L159
        r42.put("ssl", d(this.f6873f, this.f6872e));     // Catch: JSONException -> L159
        r42.put("send", d(this.f6875h, this.f6874g) + d(this.f6877j, this.f6876i));     // Catch: JSONException -> L159
        long r43 = d(this.f6879l, this.f6875h);     // Catch: JSONException -> L159
        r42.put(ICronetClient.KEY_TTFB, r43);     // Catch: JSONException -> L159
        r42.put("header_recv", d(this.f6879l, this.f6878k));     // Catch: JSONException -> L159
        r42.put("body_recv", d(this.f6881n, this.f6880m));     // Catch: JSONException -> L159
        r42.put("dispatch", this.f6884q);     // Catch: JSONException -> L159
        a(r43, r39, r42);     // Catch: JSONException -> L159
        r41.put("detailed_duration", r42);     // Catch: JSONException -> L159
        JSONObject r44 = new JSONObject();     // Catch: JSONException -> L159
        r44.put("start_time", this.f6868a);     // Catch: JSONException -> L159
        r44.put("duration", d(this.f6882o, this.f6868a));     // Catch: JSONException -> L159
        r44.put("request_sent_time", this.f6874g);     // Catch: JSONException -> L159
        r44.put("response_recv_time", this.f6878k);     // Catch: JSONException -> L159
        r41.put("request", r44);     // Catch: JSONException -> L159
        r12.put("timing", r41);     // Catch: JSONException -> L159
        JSONObject r45 = new JSONObject();     // Catch: JSONException -> L159
        Socket r46 = this.E;     // Catch: JSONException -> L159
        if (r46 == null) goto L110;
        InetAddress r47 = r46.getInetAddress();     // Catch: JSONException -> L159
        if (r47 == null) goto L110;
        a r48 = a.f6835a;     // Catch: JSONException -> L159
        if ((r47 instanceof Inet4Address) == false) goto L99;
        r48 = a.f6836b;     // Catch: JSONException -> L159
    L101:
        r45.put("address_family", r48.ordinal());     // Catch: JSONException -> L159
        if (this.f6871d == (-1)) goto L104;
    L106:
        boolean r49 = false;
    L107:
        r45.put(ICronetClient.KEY_SOCKET_REUSED, r49);     // Catch: JSONException -> L159
        if (r47.getHostAddress() == null) goto L110;
        r45.put("remote", r47.getHostAddress());     // Catch: JSONException -> L159
        goto L110
    L104:
        if (this.f6883p == (-1)) goto L106;
        r49 = true;
        goto L107
    L99:
        if ((r47 instanceof Inet6Address) == false) goto L101;
        r48 = a.f6837m;     // Catch: JSONException -> L159
    L110:
        JSONArray r50 = new JSONArray();     // Catch: JSONException -> L159
        Iterator r51 = this.f6885r.iterator();     // Catch: JSONException -> L159
    L112:
        if (r51.hasNext() == false) goto L114;
        Pair r52 = (Pair) r51.next();     // Catch: JSONException -> L159
        JSONObject r53 = new JSONObject();     // Catch: JSONException -> L159
        r53.put(StarLocationDbManager.GeofenceEntry.ADDRESS, ((InetSocketAddress) r52.first).toString().substring(1));     // Catch: JSONException -> L159
        r53.put("result", r52.second);     // Catch: JSONException -> L159
        r50.put(r53);     // Catch: JSONException -> L159
        goto L112
    L114:
        r45.put("connection_attempts", r50);     // Catch: JSONException -> L159
        r12.put("socket", r45);     // Catch: JSONException -> L159
        JSONObject r54 = new JSONObject();     // Catch: JSONException -> L159
        r54.put("handshake_type", this.f6887t.ordinal());     // Catch: JSONException -> L159
        r54.put("cipher_suite", this.f6889v);     // Catch: JSONException -> L159
        r54.put("ssl_version", this.f6888u);     // Catch: JSONException -> L159
        r12.put("ssl", r54);     // Catch: JSONException -> L159
        JSONObject r55 = new JSONObject();     // Catch: JSONException -> L159
        JSONArray r56 = new JSONArray();     // Catch: JSONException -> L159
        if (this.P == false) goto L119;
        boolean r57 = true;
        r55.put("host_replace_map", 1);     // Catch: JSONException -> L159
        r55.put("host_replace_map_size", this.R);     // Catch: JSONException -> L159
        boolean r58 = false;
    L141:
        r55.put("source", g7.j.e().f7749h.get());     // Catch: JSONException -> L159
        r55.put(WiFiDBHelper.COL_UPDATE_TIME, g7.j.e().f7750i.get());     // Catch: JSONException -> L159
        r55.put(URLDispatch.KEY_EPOCH, g7.j.e().f7744c.get());     // Catch: JSONException -> L159
        r12.put("url_dispatch", r55);     // Catch: JSONException -> L159
        if (TextUtils.isEmpty(g7.j.e().f7752k) == true) goto L144;
        r12.put("tt_tnc_etag", g7.j.e().f7752k);     // Catch: JSONException -> L159
    L144:
        JSONObject r59 = new JSONObject();     // Catch: JSONException -> L159
        JSONArray r60 = new JSONArray();     // Catch: JSONException -> L159
        Iterator<String> r61 = this.T.iterator();     // Catch: JSONException -> L159
    L146:
        if (r61.hasNext() == false) goto L148;
        r60.put(r61.next());     // Catch: JSONException -> L159
        goto L146
    L148:
        r59.put("address_list", r60);     // Catch: JSONException -> L159
        r59.put("httpdns_prefer", e7.e.g().f7169b);     // Catch: JSONException -> L159
        u r62 = u.f6946b;     // Catch: JSONException -> L159
        t r63 = t.f6941b;     // Catch: JSONException -> L159
        switch(this.S.ordinal()) {
            case 1: goto L156;
            case 2: goto L155;
            case 3: goto L154;
            case 4: goto L153;
            case 5: goto L152;
            case 6: goto L151;
            default: goto L157;
        };     // Catch: JSONException -> L159
    L151:
        r62 = u.f6950p;     // Catch: JSONException -> L159
        goto L157
    L152:
        r62 = u.f6947m;     // Catch: JSONException -> L159
        r63 = t.f6943n;     // Catch: JSONException -> L159
        goto L157
    L153:
        r62 = u.f6949o;     // Catch: JSONException -> L159
        goto L157
    L154:
        r62 = u.f6948n;     // Catch: JSONException -> L159
        goto L157
    L155:
        r62 = u.f6947m;     // Catch: JSONException -> L159
        r63 = t.f6942m;     // Catch: JSONException -> L159
        r58 = r57;
        goto L157
    L156:
        r62 = u.f6947m;     // Catch: JSONException -> L159
        r63 = t.f6942m;     // Catch: JSONException -> L159
    L157:
        r59.put("source", r62.f6952a);     // Catch: JSONException -> L159
        r59.put("cache_source", r63.f6945a);     // Catch: JSONException -> L159
        r59.put("from_stale_cache", r58);     // Catch: JSONException -> L159
        r12.put("dns", r59);     // Catch: JSONException -> L159
        j.b().c(this.U, this);     // Catch: JSONException -> L159
    L161:
        r22.f13012w = r12.toString();
        we.q r64 = this.f6891x;
        if (r64 == null) goto L164;
        r64.toString();
        r22.f13007r = this.f6891x.a() + r22.f13007r;
    L164:
        we.q r65 = this.F;
        if (r65 == null) goto L167;
        r65.toString();
        r22.f13008s = this.F.a() + r22.f13008s;
    L167:
        r22.D = this.G;
        return;
    L119:
        r57 = true;
        List<g7.d> r66 = this.Q;     // Catch: JSONException -> L159
        if (r66 == null) goto L140;
        Iterator<g7.d> r67 = r66.iterator();     // Catch: JSONException -> L159
    L123:
        if (r67.hasNext() == false) goto L140;
        g7.d r68 = r67.next();     // Catch: JSONException -> L159
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L159
        if (r68.f7720d == false) goto L123;
        r116.put("priority", r68.f7719c);     // Catch: JSONException -> L159
        r116.put("type", r68.f7721e);     // Catch: JSONException -> L159
        r116.put("action_hit", r68.f7720d);     // Catch: JSONException -> L159
        if (TextUtils.isEmpty(r68.f7723g) == true) goto L132;
        Uri r117 = Uri.parse(r68.f7723g);     // Catch: JSONException -> L159
        if (r117.getHost() == null) goto L133;
        r116.put("replace_host", r117.getHost());     // Catch: JSONException -> L159
    L133:
        r116.put("feedback", r68.f7722f);     // Catch: JSONException -> L159
        long r118 = r68.f7718b;     // Catch: JSONException -> L159
        if (r118 <= 0) goto L137;
        r116.put("rule_id", r118);     // Catch: JSONException -> L159
    L137:
        if (TextUtils.isEmpty(r68.f7717a) == true) goto L139;
        r116.put("service_name", r68.f7717a);     // Catch: JSONException -> L159
    L139:
        r56.put(r116);     // Catch: JSONException -> L159
        goto L123
    L132:
        r116.put("replace_host", "");     // Catch: JSONException -> L159
    L140:
        r55.put("action_info", r56);     // Catch: JSONException -> L159
        r55.put("empty_action", g7.j.e().f());     // Catch: JSONException -> L159
        r58 = false;
        r55.put("host_replace_map", 0);     // Catch: JSONException -> L159
        goto L141
    L90:
        r39 = "";
        goto L91
    L68:
        r35 = false;
        goto L69
    L64:
        r34 = 0;
        goto L65
    L60:
        r32 = 0;
        goto L61
    L45:
        if (r29 == 1) goto L55;
        if (r29 != 2) goto L48;
        r30 = b.f6841n;     // Catch: JSONException -> L159
        goto L57
    L48:
        if (r29 != 3) goto L50;
        r30 = b.f6842o;     // Catch: JSONException -> L159
        goto L57
    L50:
        if (r29 != 5) goto L51;
        r30 = b.f6843p;     // Catch: JSONException -> L159
        goto L57
    L55:
        r30 = b.f6840m;     // Catch: JSONException -> L159
    L51:
        r30 = b.f6839b;     // Catch: JSONException -> L159
        goto L57
    L21:
        r19 = false;
    L159:
        e = move-exception;
        e.printStackTrace();
        goto L161
    L5:
        if (this.f6883p == (-1)) goto L7;
        r8 = true;
        goto L8
    }
}
