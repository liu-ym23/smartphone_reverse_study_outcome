package com.bytedance.retrofit2;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitMetrics {
    public long A;
    public int A0;
    public int B;
    public JSONObject B0;
    public String C;
    public int C0;
    public boolean D;
    public List<a> D0;
    public long E;
    public List<a> E0;
    public long F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f2424J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public boolean Q;
    public Throwable R;
    public Map<String, Long> S;
    public Map<String, Long> T;
    public long U;
    public long V;
    public long W;
    public long X;
    public long Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URL f2425a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public long f2426a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2427b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f2428b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2429c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public long f2430c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EncryptType f2431d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f2432d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2433e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f2434e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2435f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f2436f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2437g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f2438g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2439h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f2440h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2441i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f2442i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f2443j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Map<String, Long> f2444j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2445k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f2446k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2447l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public JSONArray f2448l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2449m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public String f2450m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2451n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f2452n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2453o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public long f2454o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f2455p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public long f2456p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f2457q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public JSONObject f2458q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2459r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f2460r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f2461s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f2462s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f2463t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public long f2464t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f2465u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public long f2466u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f2467v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f2468v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f2469w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public long f2470w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f2471x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public long f2472x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f2473y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public long f2474y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f2475z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public long f2476z0;

    public static final enum EncryptType extends Enum<EncryptType> {
        private static final /* synthetic */ EncryptType[] $VALUES = null;
        public static final EncryptType ENCRYPT_BODY = null;
        public static final EncryptType ENCRYPT_BOTH_QUERY_AND_BODY = null;
        public static final EncryptType ENCRYPT_NONE = null;
        public static final EncryptType ENCRYPT_QUERY = null;
        final int type;

        static {
            EncryptType r10 = new EncryptType("ENCRYPT_NONE", 0, 0);
            ENCRYPT_NONE = r10;
            EncryptType r11 = new EncryptType("ENCRYPT_QUERY", 1, 1);
            ENCRYPT_QUERY = r11;
            EncryptType r12 = new EncryptType("ENCRYPT_BODY", 2, 2);
            ENCRYPT_BODY = r12;
            EncryptType r13 = new EncryptType("ENCRYPT_BOTH_QUERY_AND_BODY", 3, 3);
            ENCRYPT_BOTH_QUERY_AND_BODY = r13;
            $VALUES = new EncryptType[]{r10, r11, r12, r13};
        }

        private EncryptType(String r10, int r11, int r12) {
            super(r10, r11);
            this.type = r12;
        }

        public static EncryptType valueOf(String r10) {
            return (EncryptType) Enum.valueOf(EncryptType.class, r10);
        }

        public static EncryptType[] values() {
            return (EncryptType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.type;
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f2478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f2479c;

        public a(RetrofitMetrics r10, String r11, long r12) {
            this.f2477a = r11;
            this.f2478b = r12;
            this.f2479c = r12;
        }
    }

    public RetrofitMetrics() {
        this.f2425a = null;
        this.f2427b = -1;
        this.f2429c = -1;
        this.f2431d = EncryptType.ENCRYPT_NONE;
        this.f2435f = -1;
        this.f2437g = "";
        this.f2439h = -1;
        this.f2441i = "";
        this.f2445k = "";
        this.B = -1;
        this.C = null;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.Q = false;
        this.S = new ConcurrentHashMap();
        this.T = new ConcurrentHashMap();
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.f2426a0 = -1;
        this.f2428b0 = -1;
        this.f2430c0 = -1;
        this.f2432d0 = -1;
        this.f2434e0 = -1;
        this.f2436f0 = -1;
        this.f2438g0 = -1;
        this.f2440h0 = -1;
        this.f2444j0 = new HashMap();
        this.f2446k0 = "";
        this.f2462s0 = -1;
        this.f2464t0 = -1;
        this.f2466u0 = -1;
        this.f2468v0 = -1;
        this.f2470w0 = -1;
        this.f2472x0 = -1;
        this.f2474y0 = -1;
        this.f2476z0 = -1;
        this.A0 = -1;
        new HashMap();
        this.C0 = 0;
        this.D0 = new ArrayList();
        this.E0 = new ArrayList();
    }

    public RetrofitMetrics(boolean r10) {
        this.f2425a = null;
        this.f2427b = -1;
        this.f2429c = -1;
        this.f2431d = EncryptType.ENCRYPT_NONE;
        this.f2435f = -1;
        this.f2437g = "";
        this.f2439h = -1;
        this.f2441i = "";
        this.f2445k = "";
        this.B = -1;
        this.C = null;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.Q = false;
        this.S = new ConcurrentHashMap();
        this.T = new ConcurrentHashMap();
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.f2426a0 = -1;
        this.f2428b0 = -1;
        this.f2430c0 = -1;
        this.f2432d0 = -1;
        this.f2434e0 = -1;
        this.f2436f0 = -1;
        this.f2438g0 = -1;
        this.f2440h0 = -1;
        this.f2444j0 = new HashMap();
        this.f2446k0 = "";
        this.f2462s0 = -1;
        this.f2464t0 = -1;
        this.f2466u0 = -1;
        this.f2468v0 = -1;
        this.f2470w0 = -1;
        this.f2472x0 = -1;
        this.f2474y0 = -1;
        this.f2476z0 = -1;
        this.A0 = -1;
        new HashMap();
        this.C0 = 0;
        this.D0 = new ArrayList();
        this.E0 = new ArrayList();
        this.f2453o = System.currentTimeMillis();
        long r11 = SystemClock.uptimeMillis();
        this.f2452n0 = r11;
        this.f2433e = r10;
        if (r10 == false) goto L6;
        this.f2465u = r11;
        this.f2467v = r11;
        return;
    }

    private JSONObject b() {
        JSONObject r10 = new JSONObject();
        r10.put("fallback", this.f2435f);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.f2437g) == true) goto L6;
        r10.put("fallbackMessage", this.f2437g);     // Catch: JSONException -> L23
    L6:
        r10.put("reqFallback", this.f2439h);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.f2441i) == true) goto L9;
        r10.put("reqFallbackMsg", this.f2441i);     // Catch: JSONException -> L23
    L9:
        r10.put("createRetrofitTime", this.f2453o);     // Catch: JSONException -> L23
        r10.put("appRequestStartTime", this.f2455p);     // Catch: JSONException -> L23
        r10.put("beforeAllInterceptTime", this.f2457q);     // Catch: JSONException -> L23
        r10.put("callServerInterceptTime", this.f2459r);     // Catch: JSONException -> L23
        r10.put("callExecuteStartTime", this.f2461s);     // Catch: JSONException -> L23
        r10.put("reportTime", this.f2463t);     // Catch: JSONException -> L23
        r10.put("delayWait", this.A);     // Catch: JSONException -> L23
        EncryptType r11 = this.f2431d;     // Catch: JSONException -> L23
        if (r11 == EncryptType.ENCRYPT_NONE) goto L13;
        r10.put("encrypt", r11.getValue());     // Catch: JSONException -> L23
    L13:
        if (TextUtils.isEmpty(this.f2445k) == true) goto L15;
        r10.put("transactionId", this.f2445k);     // Catch: JSONException -> L23
    L15:
        long r12 = this.f2474y0;     // Catch: JSONException -> L23
        if (r12 < 0) goto L18;
        r10.put(ICronetClient.KEY_UPPER_ADD_COOKIE_US, r12);     // Catch: JSONException -> L23
    L18:
        long r13 = this.f2476z0;     // Catch: JSONException -> L23
        if (r13 < 0) goto L21;
        r10.put(ICronetClient.KEY_UPPER_SAVE_COOKIE_US, r13);     // Catch: JSONException -> L23
    L21:
        r10.put("request_cookie_source", this.A0);     // Catch: JSONException -> L23
    L25:
        boolean r14 = m(r10, "loadServiceMethod", this.f2465u, this.f2467v, true);
        long r15 = this.f2469w;
        if (r15 <= 0) goto L28;
        boolean r16 = m(r10, "enqueueWait", r15, this.f2424J, r14);
        boolean r17 = true;
        m(r10, "biz_start_after_cronet_start", this.f2449m / 1000, this.f2471x / 1000, true);
        long r18 = this.f2471x;
    L29:
        m(r10, "biz_start_before_cronet_end", r18 / 1000, this.f2451n / 1000, r17);
        long r19 = this.M;
        long r20 = this.N;
        boolean r21 = m(r10, "executeCall", r19, r20, r16);
        boolean r22 = m(r10, "requestParse", this.K, this.L, r21);
        m(r10, "responseParse", this.O, this.P, r22);
        return r10;
    L28:
        r16 = m(r10, "executeWait", this.f2473y, this.f2424J, r14);
        r17 = true;
        m(r10, "biz_start_after_cronet_start", this.f2449m / 1000, this.f2475z / 1000, true);
        r18 = this.f2475z;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    private JSONObject c() {
        JSONObject r10 = new JSONObject();
        r10.put("filterUrl", this.U);     // Catch: JSONException -> L8
        r10.put("addCommonParam", this.V);     // Catch: JSONException -> L8
        r10.put("requestVerify", this.W);     // Catch: JSONException -> L8
        r10.put("encryptRequest", this.Y);     // Catch: JSONException -> L8
        r10.put("genReqTicket", this.Z);     // Catch: JSONException -> L8
        r10.put("checkReqTicket", this.f2426a0);     // Catch: JSONException -> L8
        r10.put("preCdnVerify", this.f2428b0);     // Catch: JSONException -> L8
        r10.put("postCdnVerify", this.f2434e0);     // Catch: JSONException -> L8
        r10.put("addClientKey", this.f2430c0);     // Catch: JSONException -> L8
        r10.put("updateClientKey", this.f2432d0);     // Catch: JSONException -> L8
        r10.put("commandListener", this.f2436f0);     // Catch: JSONException -> L8
        r10.put("filterDupQuery", this.X);     // Catch: JSONException -> L8
        r10.put("queryFilter", this.f2438g0);     // Catch: JSONException -> L8
        long r11 = this.f2440h0;     // Catch: JSONException -> L8
        if (r11 < 0) goto L6;
        r10.put("bodyEncrypt", r11);     // Catch: JSONException -> L8
    L6:
        r10.put("setSpeed", this.f2464t0);     // Catch: JSONException -> L8
        r10.put("tryInit", this.f2466u0);     // Catch: JSONException -> L8
        r10.put("openConn", this.f2468v0);     // Catch: JSONException -> L8
        r10.put("setConn", this.f2470w0);     // Catch: JSONException -> L8
        r10.put("prepareReq", this.f2472x0);     // Catch: JSONException -> L8
    L10:
        return r10;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private JSONObject d() {
        JSONObject r10 = new JSONObject();
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r10;
    L4:
        if (this.S.isEmpty() == true) goto L11;
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r12 = this.S.entrySet().iterator();     // Catch: JSONException -> L18
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, Long> r13 = r12.next();     // Catch: JSONException -> L18
        r11.put(r13.getKey(), r13.getValue());     // Catch: JSONException -> L18
        goto L7
    L9:
        r10.put("request", r11);     // Catch: JSONException -> L18
    L11:
        if (this.T.isEmpty() == true) goto L20;
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L18
        Iterator<Map.Entry<String, Long>> r15 = this.T.entrySet().iterator();     // Catch: JSONException -> L18
    L14:
        if (r15.hasNext() == false) goto L16;
        Map.Entry<String, Long> r16 = r15.next();     // Catch: JSONException -> L18
        r14.put(r16.getKey(), r16.getValue());     // Catch: JSONException -> L18
        goto L14
    L16:
        r10.put("response", r14);     // Catch: JSONException -> L18
        goto L20
    }

    private JSONObject e() {
        JSONObject r10 = new JSONObject();
        r10.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r11 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r11 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r10.put("abis", r11);     // Catch: JSONException -> L13
    L15:
        return r10;
    L6:
        String[] r12 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r12 == null) goto L11;
        if (r12.length <= 0) goto L11;
        r11 = Arrays.asList(r12).toString();     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    private boolean m(JSONObject r10, String r11, long r12, long r13, boolean r14) {
        if (r14 == true) goto L5;
    L10:
        r10.put(r11, -1);     // Catch: JSONException -> L12
        return false;
    L5:
        if (r12 > r13) goto L10;
        r10.put(r11, r13 - r12);     // Catch: JSONException -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public RetrofitMetrics a() {
        RetrofitMetrics r10 = new RetrofitMetrics();
        r10.f2452n0 = this.f2452n0;
        r10.f2453o = this.f2455p;
        r10.f2433e = this.f2433e;
        r10.f2465u = this.f2465u;
        r10.f2467v = this.f2467v;
        return r10;
    }

    public JSONObject f() {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        Iterator<a> r13 = this.D0.iterator();     // Catch: JSONException -> L13
    L5:
        if (r13.hasNext() == false) goto L7;
        a r14 = r13.next();     // Catch: JSONException -> L13
        r10.put(r14.f2477a, r14.f2479c - r14.f2478b);     // Catch: JSONException -> L13
        goto L5
    L7:
        Iterator<a> r15 = this.E0.iterator();     // Catch: JSONException -> L13
    L9:
        if (r15.hasNext() == false) goto L11;
        a r16 = r15.next();     // Catch: JSONException -> L13
        r11.put(r16.f2477a, r16.f2479c - r16.f2478b);     // Catch: JSONException -> L13
        goto L9
    L11:
        r12.put("interceptorRequestInfo", r10);     // Catch: JSONException -> L13
        r12.put("interceptorResponseInfo", r11);     // Catch: JSONException -> L13
    L15:
        return r12;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public String g() {
        JSONObject r10 = new JSONObject();
    L39:
        e = move-exception;
        e.printStackTrace();
    L42:
        return r10.toString();
    L4:
        if (this.f2435f == (-1)) goto L6;
        r10.put("model", e());     // Catch: JSONException -> L39
    L6:
        JSONObject r11 = this.f2443j;     // Catch: JSONException -> L39
        if (r11 == null) goto L9;
        r10.put("concurrentRequest", r11);     // Catch: JSONException -> L39
    L9:
        r10.put("concurrent", this.f2447l);     // Catch: JSONException -> L39
        r10.put("base", b());     // Catch: JSONException -> L39
        r10.put("callback", c());     // Catch: JSONException -> L39
        r10.put("interceptor", d());     // Catch: JSONException -> L39
        r10.put("ttnetVersion", this.f2446k0);     // Catch: JSONException -> L39
        JSONArray r12 = this.f2448l0;     // Catch: JSONException -> L39
        if (r12 != null) goto L12;
    L14:
        JSONObject r13 = this.f2458q0;     // Catch: JSONException -> L39
        if (r13 == null) goto L17;
        r10.put("compress", r13);     // Catch: JSONException -> L39
    L17:
        int r14 = this.f2460r0;     // Catch: JSONException -> L39
        if (r14 <= 0) goto L20;
        r10.put("postBufferSize", r14);     // Catch: JSONException -> L39
    L20:
        int r15 = this.C0;     // Catch: JSONException -> L39
        if (r15 <= 0) goto L23;
        r10.put("blockingQueueSize", r15);     // Catch: JSONException -> L39
    L23:
        int r16 = this.f2462s0;     // Catch: JSONException -> L39
        if (r16 <= 0) goto L26;
        r10.put("apiStreamReadCount", r16);     // Catch: JSONException -> L39
    L26:
        r10.put("stateDelayed", this.D);     // Catch: JSONException -> L39
        r10.put("stateDelayTime", this.E);     // Catch: JSONException -> L39
        r10.put("syncCount", this.F);     // Catch: JSONException -> L39
        r10.put("asyncCount", this.G);     // Catch: JSONException -> L39
        r10.put("delayState", this.B);     // Catch: JSONException -> L39
        r10.put("random", this.I);     // Catch: JSONException -> L39
        if (TextUtils.isEmpty(this.C) == true) goto L30;
        r10.put("stateName", this.C);     // Catch: JSONException -> L39
    L30:
        if (this.f2442i0 == false) goto L32;
        r10.put("cli_key", true);     // Catch: JSONException -> L39
    L32:
        int r17 = this.f2427b;     // Catch: JSONException -> L39
        if (r17 < 0) goto L35;
        r10.put("cp_cnt", r17);     // Catch: JSONException -> L39
    L35:
        int r18 = this.f2429c;     // Catch: JSONException -> L39
        if (r18 < 0) goto L42;
        r10.put("read_type", r18);     // Catch: JSONException -> L39
        goto L42
    L12:
        if (r12.length() <= 0) goto L14;
        r10.put("actionInfo", this.f2448l0);     // Catch: JSONException -> L39
        goto L14
    }

    public void h() {
        if (this.D0.size() > 0) goto L5;
        return;
    L5:
        List<a> r10 = this.D0;
        r10.get(r10.size() - 1).f2479c = SystemClock.uptimeMillis();
    }

    public void i(q4.a r10) {
        String r11 = r10.getClass().getName();
        if (TextUtils.isEmpty(r11) == true) goto L6;
        String r12 = r11.substring(r11.lastIndexOf(46) + 1);
        this.D0.add(new a(this, r12, SystemClock.uptimeMillis()));
        return;
    }

    public void j() {
        if (this.E0.size() > 0) goto L5;
        return;
    L5:
        List<a> r10 = this.E0;
        r10.get(r10.size() - 1).f2479c = SystemClock.uptimeMillis();
    }

    public void k(q4.a r10) {
        String r11 = r10.getClass().getName();
        if (TextUtils.isEmpty(r11) == true) goto L6;
        String r12 = r11.substring(r11.lastIndexOf(46) + 1);
        this.E0.add(new a(this, r12, SystemClock.uptimeMillis()));
        return;
    }

    public void l(EncryptType r10) {
        this.f2431d = r10;
    }
}
