package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.bytedance.monitor.collector.b {
    private static volatile com.bytedance.monitor.collector.f A;
    private static int[] B;
    private static int[] C;
    private static int D;
    public static boolean E;
    public static boolean F;
    public static boolean G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static int f2252y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static int f2253z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    InterfaceC0066g f2254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f2256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private j f2259k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private f f2260l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f2261m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f2262n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f2263o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f2264p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f2265q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f2266r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.bytedance.monitor.collector.a f2267s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile boolean f2268t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2269u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final q0.e f2270v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile boolean f2271w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Runnable f2272x;

    class a implements InterfaceC0066g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f2273a;

        a(g r10) {
            this.f2273a = r10;
        }

        @Override // com.bytedance.monitor.collector.g.InterfaceC0066g
        public void a(long[] r10) {
            if (g.g(this.f2273a) == true) goto L6;
            return;
        L6:
            if (g.h(this.f2273a) != null) goto L8;
            return;
        L8:
            i r11 = g.h(this.f2273a).c();
            if (r11 != null) goto L11;
            return;
        L11:
            if (r11.f2304d != 8) goto L19;
            h r12 = new h();
            if (r10 == null) goto L16;
            r12.f2296a = r10[1];
            r12.f2297b = r10[5];
            r12.f2298c = r10[6];
            r12.f2299d = r10[7];
            r12.f2300e = r10[8];
        L16:
            r11.f2314n = r12;
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f2274c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f2275g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2276h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2277i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f2278j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ g f2279k;

        b(g r10) {
            this.f2279k = r10;
            this.f2274c = 0;
            this.f2276h = -1;
            this.f2277i = 0;
            this.f2278j = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = SystemClock.uptimeMillis();
            e r11 = g.p(this.f2279k).c();
            if (this.f2276h != g.q(this.f2279k)) goto L5;
            this.f2277i++;
        L6:
            this.f2276h = g.q(this.f2279k);
            int r12 = this.f2277i;
            if (r12 > 0) goto L9;
        L21:
            r11.f2289d = g.t(this.f2279k);
            r11.f2288c = (r10 - this.f2274c) - ((long) g.x());
            r11.f2286a = r10;
            long r13 = SystemClock.uptimeMillis();
            this.f2274c = r13;
            r11.f2287b = r13 - r10;
            r11.f2290e = g.q(this.f2279k);
            g.j(this.f2279k).g(g.i(this.f2279k), g.x());
            g.p(this.f2279k).a(r11);
            return;
        L9:
            if ((r12 - this.f2278j) < g.r()) goto L21;
            if (this.f2274c == 0) goto L21;
            if ((r10 - this.f2275g) < g.s()) goto L21;
            if (g.t(this.f2279k) == false) goto L21;
            if (g.v() == null) goto L19;
            String r14 = g.w(this.f2279k).a(Looper.getMainLooper().getThread());
        L20:
            r11.f2291f = r14;
            this.f2278j = this.f2277i;
            goto L21
        L19:
            r14 = o.c(Looper.getMainLooper().getThread().getStackTrace());
            goto L20
        L5:
            this.f2277i = 0;
            this.f2278j = 0;
            this.f2275g = r10;
            goto L6
        }
    }

    class c extends com.bytedance.monitor.collector.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f2280d;

        c(g r10) {
            this.f2280d = r10;
        }

        @Override // com.bytedance.monitor.collector.a
        public void b(String r10, Message r11) {
            super.b(r10, r11);
            g.n(this.f2280d);
            g.m(this.f2280d, false, com.bytedance.monitor.collector.a.f2242b);
            g r12 = this.f2280d;
            g.o(r12, g.k(r12));
            g.l(this.f2280d, "no message running");
            g.u(this.f2280d, false);
        }

        @Override // com.bytedance.monitor.collector.a
        public void c(String r10) {
            g.u(this.f2280d, true);
            g.l(this.f2280d, r10);
            super.c(r10);
            g.m(this.f2280d, true, com.bytedance.monitor.collector.a.f2242b);
        }

        @Override // com.bytedance.monitor.collector.a
        public boolean d() {
            return true;
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f2281c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f2282g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f2283h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f2284i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ g f2285j;

        d(g r10, boolean r11, long r12, long r13, String r14) {
            this.f2285j = r10;
            this.f2281c = r11;
            this.f2282g = r12;
            this.f2283h = r13;
            this.f2284i = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.monitor.collector.d.a r10 = k.n().p();
            if (r10 != null) goto L6;
            return;
        L6:
            if (this.f2281c == false) goto L8;
            String r11 = this.f2285j.f2245a;
            StringBuilder r12 = new StringBuilder();
            r12.append(this.f2282g);
            r12.append(",");
            r12.append(this.f2283h);
            r12.append(",B|");
            String r13 = o.b(this.f2284i);
        L9:
            r12.append(r13);
            r10.i(r11, r12.toString());
            return;
        L8:
            r11 = this.f2285j.f2245a;
            r12 = new StringBuilder();
            r12.append(this.f2282g);
            r12.append(",");
            r12.append(this.f2283h);
            r13 = ",E";
            goto L9
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2289d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2290e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f2291f;

        private e() {
        }

        /* synthetic */ e(a r10) {
            this();
        }

        void a() {
            this.f2286a = -1;
            this.f2287b = -1;
            this.f2288c = -1;
            this.f2290e = -1;
            this.f2291f = null;
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();
            r10.put("startTime", this.f2286a);     // Catch: JSONException -> L5
            r10.put("cost", this.f2287b);     // Catch: JSONException -> L5
            r10.put("delay", this.f2288c);     // Catch: JSONException -> L5
            r10.put("isMessage", String.valueOf(this.f2289d));     // Catch: JSONException -> L5
            r10.put("seqNum", this.f2290e);     // Catch: JSONException -> L5
            r10.put("stack", this.f2291f);     // Catch: JSONException -> L5
        L7:
            return r10;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f2294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final List<e> f2295d;

        public f(int r10) {
            this.f2293b = 0;
            this.f2292a = r10;
            this.f2295d = new ArrayList(r10);
        }

        void a(e r10) {
            int r11 = this.f2295d.size();
            int r12 = this.f2292a;
            if (r11 >= r12) goto L5;
            this.f2295d.add(r10);
            int r13 = this.f2295d.size();
        L6:
            this.f2293b = r13;
            return;
        L5:
            int r14 = this.f2293b % r12;
            this.f2293b = r14;
            e r15 = this.f2295d.set(r14, r10);
            r15.a();
            this.f2294c = r15;
            r13 = this.f2293b + 1;
            goto L6
        }

        JSONArray b() {
            JSONArray r10 = new JSONArray();
            int r11 = 0;
            if (this.f2295d.size() != this.f2292a) goto L12;
            int r12 = this.f2293b - 1;
        L6:
            if (r12 >= this.f2295d.size()) goto L9;
            r10.put(this.f2295d.get(r12).b());
            r12 = r12 + 1;
        L9:
            if (r11 >= (this.f2293b - 1)) goto L14;
            r10.put(this.f2295d.get(r11).b());
            r11 = r11 + 1;
        L14:
            return r10;
        L12:
            if (r11 >= this.f2295d.size()) goto L14;
            r10.put(this.f2295d.get(r11).b());
            r11 = r11 + 1;
            goto L12
        }

        e c() {
            e r10 = this.f2294c;
            a r11 = null;
            if (r10 == null) goto L6;
            this.f2294c = null;
            return r10;
        L6:
            return new e(r11);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.monitor.collector.g$g, reason: collision with other inner class name */
    public interface InterfaceC0066g {
        void a(long[] r10);
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f2299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f2300e;

        public h() {
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2305e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f2306f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f2307g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        w3.c f2308h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f2309i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        StackTraceElement[] f2310j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        StackTraceElement[] f2311k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f2312l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        String f2313m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        h f2314n;

        public i() {
        }

        private void a(JSONObject r10) {
            StackTraceElement[] r11 = this.f2310j;
            if (r11 == null) goto L5;
            r10.put("block_stack", o.c(r11));
        L5:
            r10.put("block_uuid", this.f2313m);
            StackTraceElement[] r12 = this.f2311k;
            if (r12 == null) goto L8;
            r10.put("sblock_stack", o.c(r12));
        L8:
            r10.put("sblock_uuid", this.f2313m);
            if (TextUtils.isEmpty(this.f2312l) == false) goto L12;
            r10.put("evil_msg", this.f2312l);
        L12:
            if (this.f2314n == null) goto L14;
            boolean r13 = true;
        L15:
            r10.put("belong_frame", r13);
            h r14 = this.f2314n;
            if (r14 == null) goto L18;
            r10.put("vsyncDelayTime", this.f2303c - (r14.f2296a / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r10.put("doFrameTime", (this.f2314n.f2297b / TimeUtils.NANOSECONDS_PER_MILLISECOND) - this.f2303c);
            h r15 = this.f2314n;
            r10.put("inputHandlingTime", (r15.f2298c / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (r15.f2297b / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            h r16 = this.f2314n;
            r10.put("animationsTime", (r16.f2299d / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (r16.f2298c / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            h r17 = this.f2314n;
            r10.put("performTraversalsTime", (r17.f2300e / TimeUtils.NANOSECONDS_PER_MILLISECOND) - (r17.f2299d / TimeUtils.NANOSECONDS_PER_MILLISECOND));
            r10.put("drawTime", this.f2302b - (this.f2314n.f2300e / TimeUtils.NANOSECONDS_PER_MILLISECOND));
        L18:
            w3.c r18 = this.f2308h;
            if (r18 == null) goto L22;
            r10.put("service_name", r18.f13319a);
            r10.put("service_what", this.f2308h.f13320b);
            r10.put("service_time", this.f2308h.f13321c);
            r10.put("service_thread", this.f2308h.f13323e);
            r10.put("service_token", this.f2308h.f13322d);
            return;
        L22:
            return;
        L14:
            r13 = false;
            goto L15
        }

        boolean b() {
            if ((this.f2302b - this.f2303c) <= 17) goto L5;
            return true;
        L5:
            if (this.f2306f > 400) goto L22;
            int r10 = this.f2305e;
            if (r10 <= 300) goto L10;
            return true;
        L10:
            if (r10 >= 20) goto L13;
            return true;
        L13:
            if (this.f2304d != 1) goto L16;
            return true;
        L16:
            if (this.f2307g < 20) goto L24;
            return false;
        L24:
            return true;
        L22:
            return true;
        }

        void c() {
            this.f2304d = -1;
            this.f2305e = -1;
            this.f2306f = -1;
            this.f2309i = null;
            this.f2310j = null;
            this.f2311k = null;
            this.f2312l = null;
            this.f2313m = null;
            this.f2314n = null;
            this.f2308h = null;
        }

        public JSONObject d() {
            JSONObject r10 = new JSONObject();
            r10.put(NotificationCompat.CATEGORY_MESSAGE, o.b(this.f2309i));     // Catch: JSONException -> L5
            r10.put("cpuDuration", this.f2307g);     // Catch: JSONException -> L5
            r10.put("duration", this.f2306f);     // Catch: JSONException -> L5
            r10.put(WsConstants.KEY_CONNECTION_TYPE, this.f2304d);     // Catch: JSONException -> L5
            r10.put("messageCount", this.f2305e);     // Catch: JSONException -> L5
            r10.put("lastDuration", this.f2302b - this.f2303c);     // Catch: JSONException -> L5
            r10.put(CommonConsts.APM_INNER_EVENT_COST_START, this.f2301a);     // Catch: JSONException -> L5
            r10.put("end", this.f2302b);     // Catch: JSONException -> L5
            a(r10);     // Catch: JSONException -> L5
        L7:
            return r10;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public String e() {
            return "msg:" + o.b(this.f2309i) + ",cpuDuration:" + this.f2307g + ",duration:" + this.f2306f + ",type:" + this.f2304d + ",messageCount:" + this.f2305e + ",lastDuration:" + (this.f2302b - this.f2303c) + ",start:" + this.f2301a + ",end:" + this.f2302b;
        }

        public void f(String r10, StackTraceElement[] r11, StackTraceElement[] r12, String r13) {
            if (TextUtils.isEmpty(r10) == true) goto L5;
            this.f2313m = r10;
        L5:
            if (r11 == null) goto L7;
            this.f2310j = r11;
        L7:
            if (r12 == null) goto L10;
            this.f2311k = r12;
        L10:
            if (TextUtils.isEmpty(r13) == true) goto L13;
            this.f2312l = r13;
            return;
        }
    }

    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        i f2317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<i> f2318d;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f2319c;

            a(j r10, String r11) {
                this.f2319c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                e0.a.b("block_looper_info", this.f2319c);
            }
        }

        j(int r10) {
            this.f2318d = new ArrayList();
            this.f2315a = r10;
        }

        void a(i r10) {
            int r11 = this.f2318d.size();
            int r12 = this.f2315a;
            if (r11 >= r12) goto L5;
            this.f2318d.add(r10);
            int r13 = this.f2318d.size();
        L6:
            this.f2316b = r13;
            if (e0.a.e() == true) goto L9;
            return;
        L9:
            if (r10.b() == false) goto L13;
            String r14 = r10.e();
            q0.b.f().i(new a(this, r14));
            return;
        L13:
            return;
        L5:
            int r15 = this.f2316b % r12;
            this.f2316b = r15;
            i r16 = this.f2318d.set(r15, r10);
            r16.c();
            this.f2317c = r16;
            r13 = this.f2316b + 1;
            goto L6
        }

        List<i> b() {
            ArrayList r10 = new ArrayList();
            int r11 = 0;
            if (this.f2318d.size() != this.f2315a) goto L12;
            int r12 = this.f2316b - 1;
        L6:
            if (r12 >= this.f2318d.size()) goto L9;
            r10.add(this.f2318d.get(r12));
            r12 = r12 + 1;
        L9:
            if (r11 >= (this.f2316b - 1)) goto L14;
            r10.add(this.f2318d.get(r11));
            r11 = r11 + 1;
        L14:
            return r10;
        L12:
            if (r11 >= this.f2318d.size()) goto L14;
            r10.add(this.f2318d.get(r11));
            r11 = r11 + 1;
            goto L12
        }

        i c() {
            int r10 = this.f2316b;
            if (r10 > 0) goto L7;
            return null;
        L7:
            return this.f2318d.get(r10 - 1);
        }

        i d(int r10) {
            i r11 = this.f2317c;
            if (r11 == null) goto L5;
            r11.f2304d = r10;
            this.f2317c = null;
            return r11;
        L5:
            i r12 = new i();
            r12.f2304d = r10;
            return r12;
        }
    }

    static {
        B = new int[]{600, 300};
        C = new int[]{200, 100};
        E = false;
        F = false;
        G = false;
    }

    public g(int r10, boolean r11) {
        super(r10, "block_looper_info");
        this.f2255g = 0;
        this.f2256h = 0;
        this.f2257i = 100;
        this.f2258j = 200;
        this.f2261m = -1;
        this.f2262n = -1;
        this.f2263o = -1;
        this.f2264p = -1;
        this.f2268t = false;
        this.f2269u = false;
        this.f2271w = false;
        this.f2272x = new b(this);
        w3.d.c().e();
        this.f2254f = new a(this);
        if (r11 == false) goto L5;
    L8:
        q0.e r12 = new q0.e("looper_monitor__");
        this.f2270v = r12;
        r12.k();
        y();
        this.f2260l = new f(300);
        r12.g(this.f2272x, f2252y);
        return;
    L5:
        if (E == true) goto L8;
        this.f2270v = null;
    }

    private JSONObject A(long r10) {
        JSONObject r11 = new JSONObject();
        r11.put("message", this.f2266r);     // Catch: Throwable -> L5
        r11.put("currentMessageCost", r10 - this.f2262n);     // Catch: Throwable -> L5
        r11.put("currentMessageCpu", l.h(this.f2263o) - this.f2264p);     // Catch: Throwable -> L5
        r11.put("messageCount", this.f2255g);     // Catch: Throwable -> L5
        r11.put(CommonConsts.APM_INNER_EVENT_COST_START, this.f2262n);     // Catch: Throwable -> L5
        r11.put("end", r10);     // Catch: Throwable -> L5
    L4:
        return r11;
    }

    private JSONArray D(int r10, long r11) {
        MessageQueue r12 = com.bytedance.monitor.collector.i.a();
        JSONArray r13 = new JSONArray();
        if (r12 != null) goto L24;
        return r13;
    L24:
        monitor-enter(r12);     // Catch: Throwable -> L21
        Message r14 = com.bytedance.monitor.collector.i.b(r12);     // Catch: Throwable -> L18
        if (r14 != null) goto L10;
        monitor-exit(r12);     // Catch: Throwable -> L18
        return r13;
    L10:
        int r15 = 0;
        int r16 = 0;
    L11:
        if (r14 == null) goto L16;
        if (r15 >= r10) goto L16;
        r15 = r15 + 1;     // Catch: Throwable -> L18
        r16 = r16 + 1;     // Catch: Throwable -> L18
        JSONObject r17 = K(r14, r11);     // Catch: Throwable -> L18
        r17.put(OaidModel.KEY_ID, r16);     // Catch: JSONException -> L22 Throwable -> L18
    L15:
        r13.put(r17);     // Catch: Throwable -> L18
        r14 = com.bytedance.monitor.collector.i.c(r14);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        return r13;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        return r13;
    }

    private com.bytedance.monitor.collector.f F() {
        return A;
    }

    private void G(boolean r14, long r15) {
        int r10 = this.f2256h + 1;
        this.f2256h = r10;
        this.f2256h = r10 & SupportMenu.USER_MASK;
        this.f2269u = false;
        if (this.f2261m >= 0) goto L6;
        this.f2261m = r15;
    L6:
        if (this.f2262n >= 0) goto L9;
        this.f2262n = r15;
    L9:
        if (this.f2263o >= 0) goto L11;
        this.f2263o = Process.myTid();
        this.f2264p = SystemClock.currentThreadTimeMillis();
    L11:
        w3.c r11 = w3.d.b();
        w3.d.a();
        long r12 = r15 - this.f2261m;
        int r13 = this.f2258j;
        if (r12 > r13) goto L14;
        if (r11 != null) goto L14;
    L29:
        this.f2262n = r15;
        String r16 = this.f2266r;
        if (this.f2248d == false) goto L33;
        k.n().f2365n.f(new d(this, r14, r15, SystemClock.currentThreadTimeMillis(), r16));
        return;
    L33:
        return;
    L14:
        long r17 = this.f2262n;
        if ((r15 - r17) > r13) goto L19;
        if (r11 != null) goto L19;
        H(9, r15, this.f2266r);
    L19:
        int r18 = this.f2255g;
        if (r14 == false) goto L24;
        if (r18 != 0) goto L23;
        H(1, r15, "no message running");
        goto L29
    L23:
        H(9, r17, this.f2265q);
        int r19 = 1;
        boolean r20 = false;
        w3.c r21 = null;
        String r22 = "no message running";
        g r23 = this;
    L28:
        r23.I(r19, r15, r22, r20, r21);
        goto L29
    L24:
        if (r18 != 0) goto L26;
        r19 = 8;
        r22 = this.f2266r;
        r20 = true;
        r23 = this;
    L27:
        r21 = r11;
        goto L28
    L26:
        r23 = this;
        r23.I(9, r17, this.f2265q, false, null);
        r19 = 8;
        r22 = this.f2266r;
        r20 = true;
        goto L27
    }

    private void H(int r10, long r11, String r12) {
        I(r10, r11, r12, true, null);
    }

    private void I(int r10, long r11, String r12, boolean r13, w3.c r14) {
        this.f2269u = true;
        i r15 = this.f2259k.d(r10);
        r15.f2306f = r11 - this.f2261m;
        if (r13 == false) goto L5;
        long r16 = SystemClock.currentThreadTimeMillis();
        r15.f2307g = r16 - this.f2264p;
        this.f2264p = r16;
    L6:
        r15.f2305e = this.f2255g;
        r15.f2309i = r12;
        r15.f2301a = this.f2261m;
        r15.f2302b = r11;
        r15.f2303c = this.f2262n;
        if (r14 == null) goto L9;
        r15.f2308h = r14;
    L9:
        this.f2259k.a(r15);
        this.f2255g = 0;
        this.f2261m = r11;
        return;
    L5:
        r15.f2307g = -1;
        goto L6
    }

    private static JSONObject K(Message r10, long r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != null) goto L20;
        return r12;
    L20:
        r12.put("when", r10.getWhen() - r11);     // Catch: JSONException -> L17
        if (r10.getCallback() == null) goto L8;
        r12.put("callback", String.valueOf(r10.getCallback()));     // Catch: JSONException -> L17
    L8:
        r12.put("what", r10.what);     // Catch: JSONException -> L17
        if (r10.getTarget() == null) goto L11;
        r12.put(TypedValues.AttributesType.S_TARGET, String.valueOf(r10.getTarget()));     // Catch: JSONException -> L17
    L12:
        r12.put("arg1", r10.arg1);     // Catch: JSONException -> L17
        r12.put("arg2", r10.arg2);     // Catch: JSONException -> L17
        Object r13 = r10.obj;     // Catch: JSONException -> L17
        if (r13 == null) goto L15;
        r12.put("obj", String.valueOf(r13));     // Catch: JSONException -> L17
    L15:
        r12.put(CommonConsts.APM_INNER_EVENT_COST_START, r10.getWhen());     // Catch: JSONException -> L17
        r12.put("end", -1);     // Catch: JSONException -> L17
    L19:
        return r12;
    L11:
        r12.put("barrier", r10.arg1);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private void L() {
        int r10 = this.f2247c;
        if (r10 != 0) goto L5;
    L12:
        this.f2257i = 100;
        this.f2258j = 300;
        return;
    L5:
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L9;
    L11:
        this.f2257i = 300;
        this.f2258j = 200;
        return;
    L9:
        if (r10 == 3) goto L11;
    }

    static /* synthetic */ boolean g(g r10) {
        return r10.f2269u;
    }

    static /* synthetic */ j h(g r10) {
        return r10.f2259k;
    }

    static /* synthetic */ Runnable i(g r10) {
        return r10.f2272x;
    }

    static /* synthetic */ q0.e j(g r10) {
        return r10.f2270v;
    }

    static /* synthetic */ String k(g r10) {
        return r10.f2266r;
    }

    static /* synthetic */ String l(g r10, String r11) {
        r10.f2266r = r11;
        return r11;
    }

    static /* synthetic */ void m(g r10, boolean r11, long r12) {
        r10.G(r11, r12);
    }

    static /* synthetic */ int n(g r10) {
        int r11 = r10.f2255g;
        r10.f2255g = r11 + 1;
        return r11;
    }

    static /* synthetic */ String o(g r10, String r11) {
        r10.f2265q = r11;
        return r11;
    }

    static /* synthetic */ f p(g r10) {
        return r10.f2260l;
    }

    static /* synthetic */ int q(g r10) {
        return r10.f2256h;
    }

    static /* synthetic */ int r() {
        return D;
    }

    static /* synthetic */ int s() {
        return f2253z;
    }

    static /* synthetic */ boolean t(g r10) {
        return r10.f2271w;
    }

    static /* synthetic */ boolean u(g r10, boolean r11) {
        r10.f2271w = r11;
        return r11;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f v() {
        return A;
    }

    static /* synthetic */ com.bytedance.monitor.collector.f w(g r10) {
        return r10.F();
    }

    static /* synthetic */ int x() {
        return f2252y;
    }

    private void y() {
        boolean r10 = G;
        if (r10 == false) goto L5;
    L8:
        if (r10 == false) goto L10;
    L12:
        if (r10 == true) goto L14;
    L16:
        if (r10 == true) goto L18;
        return;
    L18:
        if (F == true) goto L22;
        int r11 = C[0];
        f2252y = r11;
        int r12 = B[1];
    L7:
        f2253z = r12;
        D = r12 / r11;
        return;
    L22:
        return;
    L14:
        if (F == false) goto L16;
        r11 = C[1];
        f2252y = r11;
        r12 = B[1];
        goto L7
    L10:
        if (F == true) goto L12;
        r11 = C[0];
        f2252y = r11;
        r12 = B[0];
        goto L7
    L5:
        if (F == false) goto L8;
        r11 = C[1];
        f2252y = r11;
        r12 = B[0];
        goto L7
    }

    public JSONArray B() {
        JSONArray r10 = new JSONArray();
        List<i> r11 = this.f2259k.b();     // Catch: Throwable -> L15
        if (r11 != null) goto L6;
        return r10;
    L6:
        int r12 = 0;
        Iterator<i> r13 = r11.iterator();     // Catch: Throwable -> L15
    L8:
        if (r13.hasNext() == false) goto L14;
        i r14 = r13.next();     // Catch: Throwable -> L15
        if (r14 == null) goto L8;
        r12 = r12 + 1;     // Catch: Throwable -> L15
        r10.put(r14.d().put(OaidModel.KEY_ID, r12));     // Catch: Throwable -> L15
    L14:
        return r10;
    }

    public JSONObject C() {
        long r10 = SystemClock.uptimeMillis();
        JSONObject r11 = new JSONObject();
        JSONArray r12 = B();
        JSONObject r13 = A(r10);
        JSONArray r14 = D(100, r10);
        r11.put("history_message", r12);     // Catch: JSONException -> L5
        r11.put("current_message", r13);     // Catch: JSONException -> L5
        r11.put("pending_messages", r14);     // Catch: JSONException -> L5
        r11.put("check_time_info", z());     // Catch: JSONException -> L5
    L4:
        return r11;
    }

    public i E() {
        j r10 = this.f2259k;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (this.f2269u == true) goto L9;
        return null;
    L9:
        if (r10.c().f2304d == 8) goto L12;
        return null;
    L12:
        return this.f2259k.c();
    }

    public void J() {
        if (this.f2268t == false) goto L5;
        return;
    L5:
        this.f2268t = true;
        L();
        this.f2259k = new j(this.f2257i);
        c r10 = new c(this);
        this.f2267s = r10;
        com.bytedance.monitor.collector.h.k(r10);
        com.bytedance.monitor.collector.i.b(com.bytedance.monitor.collector.i.a());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> a() {
        return new Pair(this.f2245a, C());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> b(long r10, long r11) {
        return new Pair(this.f2245a, C());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    void d() {
        super.d();
        J();
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r10) {
    }

    public JSONArray z() {
        f r10 = this.f2260l;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.b();
    }
}
