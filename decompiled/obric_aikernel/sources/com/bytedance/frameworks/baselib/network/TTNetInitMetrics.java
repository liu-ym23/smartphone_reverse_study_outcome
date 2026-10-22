package com.bytedance.frameworks.baselib.network;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import r1.c;

/* JADX INFO: loaded from: classes.dex */
public class TTNetInitMetrics {
    public static final String Y = "TTNetInitMetrics";
    private static volatile CopyOnWriteArrayList<b> Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static AtomicBoolean f1521a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static volatile TTNetInitMetrics f1522b0;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public String F;
    public long G;
    public String H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f1523J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public long V;
    public long W;
    public long X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CronetInitMode f1524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f1536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f1538o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f1539p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f1540q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f1541r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1542s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f1543t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f1544u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f1545v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f1546w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f1547x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f1548y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f1549z;

    public static final enum CronetInitMode extends Enum<CronetInitMode> {
        private static final /* synthetic */ CronetInitMode[] $VALUES = null;
        public static final CronetInitMode ACTIVITY_RESUME_SUSPEND = null;
        public static final CronetInitMode BIZ_HTTPDNS_API = null;
        public static final CronetInitMode COOKIE_INIT_COMPLETE_API = null;
        public static final CronetInitMode DEPRECATED_API = null;
        public static final CronetInitMode FORCE_INIT = null;
        public static final CronetInitMode LAZY_INIT = null;
        public static final CronetInitMode NONE = null;
        public static final CronetInitMode PRE_INIT = null;
        public static final CronetInitMode ZSTD_API = null;
        final int initMode;

        static {
            CronetInitMode r10 = new CronetInitMode("NONE", 0, 0);
            NONE = r10;
            CronetInitMode r11 = new CronetInitMode("LAZY_INIT", 1, 1);
            LAZY_INIT = r11;
            CronetInitMode r12 = new CronetInitMode("PRE_INIT", 2, 2);
            PRE_INIT = r12;
            CronetInitMode r13 = new CronetInitMode("FORCE_INIT", 3, 3);
            FORCE_INIT = r13;
            CronetInitMode r14 = new CronetInitMode("DEPRECATED_API", 4, 4);
            DEPRECATED_API = r14;
            CronetInitMode r15 = new CronetInitMode("BIZ_HTTPDNS_API", 5, 5);
            BIZ_HTTPDNS_API = r15;
            CronetInitMode r16 = new CronetInitMode("ZSTD_API", 6, 6);
            ZSTD_API = r16;
            CronetInitMode r17 = new CronetInitMode("COOKIE_INIT_COMPLETE_API", 7, 7);
            COOKIE_INIT_COMPLETE_API = r17;
            CronetInitMode r18 = new CronetInitMode("ACTIVITY_RESUME_SUSPEND", 8, 8);
            ACTIVITY_RESUME_SUSPEND = r18;
            $VALUES = new CronetInitMode[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private CronetInitMode(String r10, int r11, int r12) {
            super(r10, r11);
            this.initMode = r12;
        }

        public static CronetInitMode valueOf(String r10) {
            return (CronetInitMode) Enum.valueOf(CronetInitMode.class, r10);
        }

        public static CronetInitMode[] values() {
            return (CronetInitMode[]) $VALUES.clone();
        }
    }

    class a extends c {
        a(String r10) {
            super(r10);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            Iterator r10 = TTNetInitMetrics.a().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((b) r10.next()).a();
            goto L4
        }
    }

    public interface b {
        void a();
    }

    static {
        Z = new CopyOnWriteArrayList();
        f1521a0 = new AtomicBoolean(false);
    }

    public TTNetInitMetrics() {
        this.f1524a = CronetInitMode.NONE;
        this.f1525b = true;
        this.f1527d = 0;
        this.f1528e = 0;
        this.f1529f = 0;
        this.f1530g = 0;
        this.f1531h = 0;
        this.f1532i = 0;
        this.f1533j = 0;
        this.f1534k = 0;
        this.f1535l = 0;
        this.f1536m = 0;
        this.f1537n = 0;
        this.f1538o = 0;
        this.f1539p = 0;
        this.f1540q = 0;
        this.f1541r = 0;
        this.f1542s = 0;
        this.f1543t = 0;
        this.f1544u = 0;
        this.f1545v = 0;
        this.f1546w = 0;
        this.f1547x = 0;
        this.f1548y = 0;
        this.f1549z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.G = 0;
        this.I = 0;
        this.f1523J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
    }

    static /* synthetic */ CopyOnWriteArrayList a() {
        return Z;
    }

    private long e(long r10) {
        return (this.f1527d + r10) - this.f1528e;
    }

    private static long f(long r10, long r11) {
        long r12 = g(r10, r11);
        if (r12 != (-1)) goto L6;
        return -1;
    L6:
        return r12 / 1000;
    }

    private static long g(long r10, long r11) {
        if (r10 != 0) goto L5;
    L12:
        return -1;
    L5:
        if (r11 == 0) goto L12;
        if (r10 <= r11) goto L11;
        return -1;
    L11:
        return (r11 - r10) / 1000;
    }

    private static String h(long r10, long r11) {
        return String.valueOf(g(r10, r11));
    }

    public static TTNetInitMetrics k() {
        if (f1522b0 != null) goto L15;
        monitor-enter(TTNetInitMetrics.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1522b0 != null) goto L9;
        f1522b0 = new TTNetInitMetrics();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTNetInitMetrics.class);     // Catch: Throwable -> L11
    L15:
        return f1522b0;
    }

    public static boolean l() {
        return f1521a0.get();
    }

    private boolean n(Context r10, List<Long> r11) {
        HashMap r12 = null;
        Class<?> r13 = Class.forName("com.bytedance.mobsec.metasec.ml.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r13 != null) goto L9;
        r13 = Class.forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L21
    L9:
        if (r13 != null) goto L12;
        return false;
    L12:
        if (r11 != null) goto L24;
    L16:
        r13.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r13, new Object[]{r10, 1, r12});     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        th.printStackTrace();
        return false;
    L24:
        if (r11.size() != 2) goto L16;
        r12 = new HashMap();     // Catch: Throwable -> L18
        r12.put("http_callback", String.valueOf(r11.get(0)));     // Catch: Throwable -> L18
        r12.put("ws_callback", String.valueOf(r11.get(1)));     // Catch: Throwable -> L18
    L5:
        r13 = null;
        goto L6
    }

    public static void o(boolean r10) {
        f1521a0.set(r10);
        if (Z.isEmpty() == false) goto L5;
        return;
    L5:
        new a("ttnet-init").a();
    }

    public boolean b() {
        if (this.f1527d != 0) goto L5;
    L49:
        return false;
    L5:
        if (this.f1528e == 0) goto L49;
        if (this.f1529f == 0) goto L49;
        if (this.f1530g == 0) goto L49;
        if (this.f1531h == 0) goto L49;
        if (this.f1532i == 0) goto L49;
        if (this.f1533j == 0) goto L49;
        if (this.f1535l == 0) goto L49;
        if (this.f1536m == 0) goto L49;
        if (this.f1537n == 0) goto L49;
        if (this.f1538o == 0) goto L49;
        if (this.f1539p == 0) goto L49;
        if (this.f1540q == 0) goto L49;
        if (this.f1541r == 0) goto L49;
        if (this.f1542s == 0) goto L49;
        if (this.f1543t == 0) goto L49;
        if (this.f1544u == 0) goto L49;
        if (this.f1545v == 0) goto L49;
        if (this.f1546w == 0) goto L49;
        if (this.f1547x == 0) goto L49;
        if (this.f1548y == 0) goto L49;
        if (this.f1549z == 0) goto L49;
        if (this.A == 0) goto L49;
        return true;
    }

    public JSONObject c() {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        r10.put("mode", this.f1524a.initMode);     // Catch: JSONException -> L16
        r10.put("is_main_process", this.f1525b);     // Catch: JSONException -> L16
        r10.put("net_thread_priority", this.f1526c);     // Catch: JSONException -> L16
        r11.put("ttnet_start", this.f1527d);     // Catch: JSONException -> L16
        r11.put("ttnet_end", e(this.f1531h));     // Catch: JSONException -> L16
        r11.put("engine_start", e(this.f1535l));     // Catch: JSONException -> L16
        r11.put("engine_end", e(this.A));     // Catch: JSONException -> L16
        r11.put("init_start", e(this.B));     // Catch: JSONException -> L16
        r11.put("init_end", e(this.C));     // Catch: JSONException -> L16
        r11.put("preconnect_start", this.I);     // Catch: JSONException -> L16
        r12.put("builder_build", f(this.f1546w, this.f1547x));     // Catch: JSONException -> L16
        r12.put("load_cronet", f(this.D, this.E));     // Catch: JSONException -> L16
        r12.put("init_metasec", f(this.f1529f, this.f1530g));     // Catch: JSONException -> L16
        r12.put("init_ttnet", f(this.f1528e, this.f1531h));     // Catch: JSONException -> L16
        r12.put("init_mssdk", f(this.f1548y, this.f1549z));     // Catch: JSONException -> L16
        r12.put("create_engine", f(this.f1535l, this.A));     // Catch: JSONException -> L16
        r12.put("init_thread", f(this.B, this.C));     // Catch: JSONException -> L16
        r12.put("init_total", f(Math.min(this.f1527d, this.f1534k) * TimeUtils.NANOSECONDS_PER_MILLISECOND, this.K * TimeUtils.NANOSECONDS_PER_MILLISECOND));     // Catch: JSONException -> L16
        r12.put("init_preconnect", f(this.f1527d, this.I));     // Catch: JSONException -> L16
        long r13 = this.f1523J;     // Catch: JSONException -> L16
        long r14 = this.K;     // Catch: JSONException -> L16
        long r15 = -1;
        if (r13 <= r14) goto L6;
        long r16 = -1;
    L7:
        r12.put("network_thread", r16);     // Catch: JSONException -> L16
        long r17 = this.K;     // Catch: JSONException -> L16
        long r18 = this.L;     // Catch: JSONException -> L16
        if (r17 > r18) goto L11;
        r15 = r18 - r17;     // Catch: JSONException -> L16
    L11:
        r12.put("exec_tasks", r15);     // Catch: JSONException -> L16
        r12.put("nqe_init", this.M);     // Catch: JSONException -> L16
        r12.put("prefs_init", this.N);     // Catch: JSONException -> L16
        r12.put("channel_init", this.O);     // Catch: JSONException -> L16
        r12.put("context_build", this.P);     // Catch: JSONException -> L16
        r12.put("tnc_config", this.Q);     // Catch: JSONException -> L16
        r12.put("update_appinfo", this.R);     // Catch: JSONException -> L16
        r12.put("netlog_init", this.S);     // Catch: JSONException -> L16
        r12.put("nqe_detect", this.T);     // Catch: JSONException -> L16
        r12.put("preconnect", this.U);     // Catch: JSONException -> L16
        r12.put("ssl_session", this.V);     // Catch: JSONException -> L16
        r12.put("ttnet_config", this.W);     // Catch: JSONException -> L16
        r12.put("install_cert", this.X);     // Catch: JSONException -> L16
        r10.put("ttnet_timestamp", r11);     // Catch: JSONException -> L16
        r10.put("ttnet_duration", r12);     // Catch: JSONException -> L16
        r10.put("ab_test", this.H);     // Catch: JSONException -> L16
        goto L13
    L6:
        r16 = r14 - r13;     // Catch: JSONException -> L16
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d(Y, "cronet init metrics json: " + r10.toString());
    L15:
        return r10;
    }

    public JSONObject d(long r12) {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L8
        r14.put("mssdk", h(this.f1548y, this.f1549z));     // Catch: Exception -> L8
        r14.put("app_info_subset", h(this.f1536m, this.f1537n));     // Catch: Exception -> L8
        r14.put("thread_config_list", h(this.f1538o, this.f1539p));     // Catch: Exception -> L8
        r14.put("sla_samp_setting", h(this.f1542s, this.f1543t));     // Catch: Exception -> L8
        r14.put("build_ctx_config", h(this.f1544u, this.f1545v));     // Catch: Exception -> L8
        r14.put("init_total", h(Math.min(this.f1527d, this.f1534k) * TimeUtils.NANOSECONDS_PER_MILLISECOND, this.K * TimeUtils.NANOSECONDS_PER_MILLISECOND));     // Catch: Exception -> L8
        String r15 = "-1";
        if (r12 == (-1)) goto L6;
        r15 = h(r12, this.f1528e);     // Catch: Exception -> L8
    L6:
        r14.put("app_init_time", r15);     // Catch: Exception -> L8
        r13.put("cross_plfm", r14);     // Catch: Exception -> L8
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L8
        r16.put("ttnet_init", h(this.f1528e, this.f1531h));     // Catch: Exception -> L8
        r16.put("init_cookie_mgr", h(this.f1532i, this.f1533j));     // Catch: Exception -> L8
        r16.put("pre_init_mssdk", h(this.f1529f, this.f1530g));     // Catch: Exception -> L8
        r16.put("builder_build", h(this.f1546w, this.f1547x));     // Catch: Exception -> L8
        r16.put("create_engine", h(this.f1535l, this.A));     // Catch: Exception -> L8
        r16.put("cronet_init_thread", h(this.B, this.C));     // Catch: Exception -> L8
        r16.put("cronet_load_so", h(this.D, this.E));     // Catch: Exception -> L8
        r16.put("thread_config_callback", h(this.f1540q, this.f1541r));     // Catch: Exception -> L8
        r13.put("android_spec", r16);     // Catch: Exception -> L8
        r11.put("durations_us", r13);     // Catch: Exception -> L8
        r11.put("cronet_init_mode", this.f1524a.initMode);     // Catch: Exception -> L8
        r10.put("ttnet_layer", r11);     // Catch: Exception -> L8
        r10.put("cronet_layer", new JSONObject(this.F));     // Catch: Exception -> L8
        r10.put("ab_test", this.H);     // Catch: Exception -> L8
    L10:
        return r10;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public void i(Context r10, List<Long> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.size() == 2) goto L7;
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d(Y, "http address: " + r11.get(0) + " ws address: " + r11.get(1));
    L9:
        this.f1548y = System.nanoTime();
        if (n(r10, r11) == false) goto L12;
    L14:
        this.f1549z = System.nanoTime();
        return;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(Y, "init mssdk failed.");
        goto L14
    }

    public void j(Context r10) {
        this.f1529f = System.nanoTime();
        n(r10, null);
        this.f1530g = System.nanoTime();
    }

    public boolean m() {
        CronetInitMode r10 = this.f1524a;
        if (r10 != CronetInitMode.PRE_INIT) goto L5;
    L8:
        return true;
    L5:
        if (r10 == CronetInitMode.FORCE_INIT) goto L8;
        return false;
    }
}
