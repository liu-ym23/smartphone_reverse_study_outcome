package com.bytedance.frameworks.baselib.network;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.message.StructuredDataId;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetInitMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2270a = "TTNetInitMetrics";
    public static volatile TTNetInitMetrics ad = null;
    static final /* synthetic */ boolean ae = true;
    private static volatile CopyOnWriteArrayList<a> af;
    private static AtomicBoolean ag;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f2271J;
    public String K;
    public long L;
    public String M;
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
    public long Y;
    public long Z;
    public long aa;
    public long ab;
    public long ac;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CronetInitMode f2272b;
    public boolean c;
    public int d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    public static final enum CronetInitMode extends Enum<CronetInitMode> {
        private static final /* synthetic */ CronetInitMode[] $VALUES = null;
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
            CronetInitMode r0 = new CronetInitMode("NONE", 0, 0);
            NONE = r0;
            CronetInitMode r1 = new CronetInitMode("LAZY_INIT", 1, 1);
            LAZY_INIT = r1;
            CronetInitMode r3 = new CronetInitMode("PRE_INIT", 2, 2);
            PRE_INIT = r3;
            CronetInitMode r5 = new CronetInitMode("FORCE_INIT", 3, 3);
            FORCE_INIT = r5;
            CronetInitMode r7 = new CronetInitMode("DEPRECATED_API", 4, 4);
            DEPRECATED_API = r7;
            CronetInitMode r9 = new CronetInitMode("BIZ_HTTPDNS_API", 5, 5);
            BIZ_HTTPDNS_API = r9;
            CronetInitMode r11 = new CronetInitMode("ZSTD_API", 6, 6);
            ZSTD_API = r11;
            CronetInitMode r13 = new CronetInitMode("COOKIE_INIT_COMPLETE_API", 7, 7);
            COOKIE_INIT_COMPLETE_API = r13;
            $VALUES = new CronetInitMode[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private CronetInitMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.initMode = r3;
        }

        public static CronetInitMode valueOf(String r2) {
            return (CronetInitMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(CronetInitMode.class, r2), CronetInitMode.class, "com.obric.memorydata.plugin");
        }

        public static CronetInitMode[] values() {
            return (CronetInitMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CronetInitMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface a {
        void a();
    }

    static {
        af = new CopyOnWriteArrayList();
        ag = new AtomicBoolean(false);
    }

    public TTNetInitMetrics() {
        this.f2272b = CronetInitMode.NONE;
        this.c = true;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.f2271J = 0;
        this.L = 0;
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
        this.Y = 0;
        this.Z = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = 0;
    }

    private static String a(long r0, long r2) {
        return String.valueOf(b(r0, r2));
    }

    public static void a(boolean r1) {
        ag.set(r1);
        if (af.isEmpty() == false) goto L5;
        return;
    L5:
        final String r0 = "ttnet-init";
        new AnonymousClass1(r0).a();
    }

    public static boolean a() {
        return ag.get();
    }

    private long b(long r3) {
        return (this.e + r3) - this.f;
    }

    private static long b(long r5, long r7) {
        if (r5 != 0) goto L5;
    L12:
        return -1;
    L5:
        if (r7 == 0) goto L12;
        if (r5 <= r7) goto L11;
        return -1;
    L11:
        return (r7 - r5) / 1000;
    }

    private boolean b(Context r8, List<Long> r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        HashMap r11 = null;
        Class r1 = ZeusTransformUtils.forName("com.bytedance.mobsec.metasec.ml.MSB", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r1 != null) goto L9;
        r1 = ZeusTransformUtils.forName("com.bytedance.mobsec.metasec.ov.MSB", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L21
    L9:
        if (r1 != null) goto L12;
        return false;
    L12:
        if (r10 != null) goto L24;
    L16:
        r1.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r1, new Object[]{r7, 1, r11});     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        th.printStackTrace();
        return false;
    L24:
        if (r10.size() != 2) goto L16;
        r11 = new HashMap();     // Catch: Throwable -> L18
        r11.put("http_callback", String.valueOf(r10.get(0)));     // Catch: Throwable -> L18
        r11.put("ws_callback", String.valueOf(r10.get(1)));     // Catch: Throwable -> L18
    L5:
        r1 = null;
        goto L6
    }

    private static long c(long r1, long r3) {
        long r2 = b(r1, r3);
        if (r2 != (-1)) goto L6;
        return -1;
    L6:
        return r2 / 1000;
    }

    public static TTNetInitMetrics c() {
        if (ad != null) goto L15;
        monitor-enter(TTNetInitMetrics.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (ad != null) goto L9;
        ad = new TTNetInitMetrics();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTNetInitMetrics.class);     // Catch: Throwable -> L11
    L15:
        return ad;
    }

    static /* synthetic */ CopyOnWriteArrayList f() {
        return af;
    }

    public JSONObject a(long r12) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L8
        r3.put("mssdk", a(this.D, this.E));     // Catch: Exception -> L8
        r3.put("app_info_subset", a(this.r, this.s));     // Catch: Exception -> L8
        r3.put("thread_config_list", a(this.t, this.u));     // Catch: Exception -> L8
        r3.put("sla_samp_setting", a(this.x, this.y));     // Catch: Exception -> L8
        r3.put("build_ctx_config", a(this.z, this.A));     // Catch: Exception -> L8
        r3.put("init_total", a(Math.min(this.e, this.n) * TimeUtils.NANOSECONDS_PER_MILLISECOND, this.P * TimeUtils.NANOSECONDS_PER_MILLISECOND));     // Catch: Exception -> L8
        String r4 = StructuredDataId.RESERVED;
        if (r12 == (-1)) goto L6;
        r4 = a(r12, this.f);     // Catch: Exception -> L8
    L6:
        r3.put("app_init_time", r4);     // Catch: Exception -> L8
        r2.put("cross_plfm", r3);     // Catch: Exception -> L8
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L8
        r13.put("ttnet_init", a(this.f, this.i));     // Catch: Exception -> L8
        r13.put("init_stack_config", a(this.l, this.m));     // Catch: Exception -> L8
        r13.put("get_stack_config", a(this.p, this.q));     // Catch: Exception -> L8
        r13.put("init_cookie_mgr", a(this.j, this.k));     // Catch: Exception -> L8
        r13.put("pre_init_mssdk", a(this.g, this.h));     // Catch: Exception -> L8
        r13.put("builder_build", a(this.B, this.C));     // Catch: Exception -> L8
        r13.put("create_engine", a(this.o, this.F));     // Catch: Exception -> L8
        r13.put("cronet_init_thread", a(this.G, this.H));     // Catch: Exception -> L8
        r13.put("cronet_load_so", a(this.I, this.f2271J));     // Catch: Exception -> L8
        r13.put("thread_config_callback", a(this.v, this.w));     // Catch: Exception -> L8
        r2.put("android_spec", r13);     // Catch: Exception -> L8
        r1.put("durations_us", r2);     // Catch: Exception -> L8
        r1.put("cronet_init_mode", this.f2272b.initMode);     // Catch: Exception -> L8
        r0.put("ttnet_layer", r1);     // Catch: Exception -> L8
        r0.put("cronet_layer", new JSONObject(this.K));     // Catch: Exception -> L8
        r0.put("ab_test", this.M);     // Catch: Exception -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.g = System.nanoTime();
        b(r4, null);
        this.h = System.nanoTime();
    }

    public void a(Context r4, List<Long> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ae == false) goto L5;
    L9:
        if (r7 != null) goto L11;
        return;
    L11:
        if (r7.size() == 2) goto L14;
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(f2270a, "http address: " + r7.get(0) + " ws address: " + r7.get(1));
    L16:
        this.D = System.nanoTime();
        if (b(r6, r7) == false) goto L19;
    L21:
        this.E = System.nanoTime();
        return;
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(f2270a, "init mssdk failed.");
        goto L21
    L5:
        if (r7.size() == 2) goto L9;
        throw new AssertionError();
    }

    public boolean b() {
        if (this.f2272b != CronetInitMode.PRE_INIT) goto L5;
    L8:
        return true;
    L5:
        if (this.f2272b == CronetInitMode.FORCE_INIT) goto L8;
        return false;
    }

    public JSONObject d() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r0.put("mode", this.f2272b.initMode);     // Catch: JSONException -> L16
        r0.put(LocationMonitorConst.IS_MAIN_PROCESS, this.c);     // Catch: JSONException -> L16
        r0.put("net_thread_priority", this.d);     // Catch: JSONException -> L16
        r1.put("ttnet_start", this.e);     // Catch: JSONException -> L16
        r1.put("ttnet_end", b(this.i));     // Catch: JSONException -> L16
        r1.put("engine_start", b(this.o));     // Catch: JSONException -> L16
        r1.put("engine_end", b(this.F));     // Catch: JSONException -> L16
        r1.put("init_start", b(this.G));     // Catch: JSONException -> L16
        r1.put("init_end", b(this.H));     // Catch: JSONException -> L16
        r1.put("preconnect_start", this.N);     // Catch: JSONException -> L16
        r2.put("builder_build", c(this.B, this.C));     // Catch: JSONException -> L16
        r2.put("load_cronet", c(this.I, this.f2271J));     // Catch: JSONException -> L16
        r2.put("init_metasec", c(this.g, this.h));     // Catch: JSONException -> L16
        r2.put("init_ttnet", c(this.f, this.i));     // Catch: JSONException -> L16
        r2.put("init_mssdk", c(this.D, this.E));     // Catch: JSONException -> L16
        r2.put("create_engine", c(this.o, this.F));     // Catch: JSONException -> L16
        r2.put("init_thread", c(this.G, this.H));     // Catch: JSONException -> L16
        r2.put("init_total", c(Math.min(this.e, this.n) * TimeUtils.NANOSECONDS_PER_MILLISECOND, this.P * TimeUtils.NANOSECONDS_PER_MILLISECOND));     // Catch: JSONException -> L16
        r2.put("init_preconnect", c(this.e, this.N));     // Catch: JSONException -> L16
        long r4 = this.O;     // Catch: JSONException -> L16
        long r6 = this.P;     // Catch: JSONException -> L16
        long r9 = -1;
        if (r4 <= r6) goto L6;
        long r7 = -1;
    L7:
        r2.put("network_thread", r7);     // Catch: JSONException -> L16
        long r5 = this.P;     // Catch: JSONException -> L16
        long r8 = this.Q;     // Catch: JSONException -> L16
        if (r5 > r8) goto L11;
        r9 = r8 - r5;     // Catch: JSONException -> L16
    L11:
        r2.put("exec_tasks", r9);     // Catch: JSONException -> L16
        r2.put("nqe_init", this.R);     // Catch: JSONException -> L16
        r2.put("prefs_init", this.S);     // Catch: JSONException -> L16
        r2.put("channel_init", this.T);     // Catch: JSONException -> L16
        r2.put("context_build", this.U);     // Catch: JSONException -> L16
        r2.put("tnc_config", this.V);     // Catch: JSONException -> L16
        r2.put("update_appinfo", this.W);     // Catch: JSONException -> L16
        r2.put("netlog_init", this.X);     // Catch: JSONException -> L16
        r2.put("nqe_detect", this.Y);     // Catch: JSONException -> L16
        r2.put("preconnect", this.Z);     // Catch: JSONException -> L16
        r2.put("ssl_session", this.aa);     // Catch: JSONException -> L16
        r2.put("ttnet_config", this.ab);     // Catch: JSONException -> L16
        r2.put("install_cert", this.ac);     // Catch: JSONException -> L16
        r0.put("ttnet_timestamp", r1);     // Catch: JSONException -> L16
        r0.put("ttnet_duration", r2);     // Catch: JSONException -> L16
        r0.put("ab_test", this.M);     // Catch: JSONException -> L16
        goto L13
    L6:
        r7 = r6 - r4;     // Catch: JSONException -> L16
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d(f2270a, "cronet init metrics json: " + r0.toString());
    L15:
        return r0;
    }

    public boolean e() {
        if (this.e != 0) goto L5;
    L57:
        return false;
    L5:
        if (this.f == 0) goto L57;
        if (this.g == 0) goto L57;
        if (this.h == 0) goto L57;
        if (this.i == 0) goto L57;
        if (this.j == 0) goto L57;
        if (this.k == 0) goto L57;
        if (this.l == 0) goto L57;
        if (this.m == 0) goto L57;
        if (this.o == 0) goto L57;
        if (this.p == 0) goto L57;
        if (this.q == 0) goto L57;
        if (this.r == 0) goto L57;
        if (this.s == 0) goto L57;
        if (this.t == 0) goto L57;
        if (this.u == 0) goto L57;
        if (this.v == 0) goto L57;
        if (this.w == 0) goto L57;
        if (this.x == 0) goto L57;
        if (this.y == 0) goto L57;
        if (this.z == 0) goto L57;
        if (this.A == 0) goto L57;
        if (this.B == 0) goto L57;
        if (this.C == 0) goto L57;
        if (this.D == 0) goto L57;
        if (this.E == 0) goto L57;
        if (this.F == 0) goto L57;
        return true;
    }
}
