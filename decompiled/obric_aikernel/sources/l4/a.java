package l4;

import android.text.TextUtils;
import com.bytedance.apm.block.e;
import com.bytedance.apm.block.h;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.Tools;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.constants.Constants;
import com.bytedance.monitor.collector.k;
import com.bytedance.monitor.collector.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;
import t.f;
import t.g;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.block.a implements e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static a f10878o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static l4.b f10879p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static long f10880q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f10881r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f10882s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static volatile boolean f10883t = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f10884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f.C0295f f10885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private f.C0295f f10886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile String f10887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long[] f10888k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f10889l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d f10890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f10891n;

    /* JADX INFO: renamed from: l4.a$a, reason: collision with other inner class name */
    class RunnableC0230a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f10892c;

        RunnableC0230a(a r10) {
            this.f10892c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.e.B().N(this.f10892c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f10893c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f10894g;

        b(a r10, long[] r11, long r12) {
            this.f10893c = r11;
            this.f10894g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r10 = new LinkedList();
            k4.a.j(this.f10893c, r10, true, com.bytedance.monitor.collector.a.f2242b);
            k4.a.f(r10, 5);
            com.bytedance.monitor.collector.d.a r11 = k.n().p();
            if (r11 != null) goto L6;
            return;
        L6:
            if (r10.size() > 2) goto L8;
            return;
        L8:
            r11.i("method_tracer", "in," + this.f10894g);
            Iterator r12 = r10.iterator();
        L10:
            if (r12.hasNext() == false) goto L12;
            r11.i("method_tracer", ((g) r12.next()).toString());
            goto L10
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10895c;

        c(String r10) {
            this.f10895c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
            r10.put("evil_method_section", this.f10895c);     // Catch: JSONException -> L4
            x.a.p().e(new y.c("evil_method_tracing", 0, null, r10, null, null));     // Catch: JSONException -> L4
            return;
        }
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f10896c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f10897g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long[] f10898h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f10899i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f10900j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f10901k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f10902l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        String f10903m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f10904n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        long f10905o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        com.bytedance.monitor.collector.g.i f10906p;

        /* JADX INFO: renamed from: l4.a$d$a, reason: collision with other inner class name */
        class C0231a implements k4.a.b {
            C0231a(d r10) {
            }

            @Override // k4.a.b
            public boolean a(long r10, int r11) {
                if (r10 >= (r11 * 5)) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // k4.a.b
            public int b() {
                return 60;
            }

            @Override // k4.a.b
            public void c(List<g> r10, int r11) {
                if (com.bytedance.apm.d.D() == false) goto L5;
                e0.g.c("EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[]{Integer.valueOf(r11), 30, r10});
            L5:
                ListIterator<g> r12 = r10.listIterator(Math.min(r11, 30));
            L7:
                if (r12.hasNext() == false) goto L9;
                r12.next();
                r12.remove();
                goto L7
            }
        }

        d(a r10, boolean r11, String r12, long[] r13, long[] r14, long r15, long r16, long r17, String r18, long r19, String r110, com.bytedance.monitor.collector.g.i r111) {
            this.f10902l = r12;
            this.f10900j = r16;
            this.f10899i = r15;
            this.f10898h = r13;
            this.f10901k = r17;
            this.f10903m = r18;
            this.f10905o = r19;
            this.f10904n = r110;
            this.f10906p = r111;
        }

        static /* synthetic */ boolean a(d r10, boolean r11) {
            r10.f10897g = r11;
            return r11;
        }

        static /* synthetic */ boolean b(d r10, boolean r11) {
            r10.f10896c = r11;
            return r11;
        }

        void c() {
            LinkedList r10 = new LinkedList();     // Catch: Exception -> L14
            long[] r11 = this.f10898h;     // Catch: Exception -> L14
            if (r11.length <= 0) goto L7;
            k4.a.j(r11, r10, true, this.f10901k);     // Catch: Exception -> L14
            k4.a.m(r10, 30, new C0231a(this));     // Catch: Exception -> L14
        L7:
            if (r10.size() > 2) goto L9;
            return;
        L9:
            StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L14
            long r13 = Math.max(this.f10900j, k4.a.g(r10, r12));     // Catch: Exception -> L14
            String r14 = k4.a.d(r10, r13);     // Catch: Exception -> L14
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L14
            String r16 = r12.toString();     // Catch: Exception -> L14
            com.bytedance.monitor.collector.g.i r17 = this.f10906p;     // Catch: Exception -> L14
            if (r17 == null) goto L12;
            r17.f(this.f10904n, null, null, r16);     // Catch: Exception -> L14
        L12:
            r15.put("stack", r16);     // Catch: Exception -> L14
            r15.put("stack_key", r14);     // Catch: Exception -> L14
            r15.put("scene", this.f10902l);     // Catch: Exception -> L14
            r15.put("cost_time", r13);     // Catch: Exception -> L14
            r15.put("cpu_cost", this.f10899i);     // Catch: Exception -> L14
            r15.put("method_time", r13);     // Catch: Exception -> L14
            k r18 = k.n();     // Catch: Exception -> L14
            long r19 = this.f10901k;     // Catch: Exception -> L14
            JSONObject r20 = r18.f(r19 - this.f10900j, r19);     // Catch: Exception -> L14
            f r21 = f.E();     // Catch: Exception -> L14
            long r22 = this.f10901k;     // Catch: Exception -> L14
            r20.put("evil_method", r21.D(r22 - this.f10900j, r22));     // Catch: Exception -> L14
            r15.put("custom", r20);     // Catch: Exception -> L14
            r15.put("message", o.b(this.f10903m));     // Catch: Exception -> L14
            r15.put("timestamp", this.f10901k);     // Catch: Exception -> L14
            r15.put(Constants.EVENT_TYPE, "lag_drop_frame");     // Catch: Exception -> L14
            JSONObject r23 = new JSONObject();     // Catch: Exception -> L14
            r23.put("crash_section", com.bytedance.apm.d.C(this.f10905o));     // Catch: Exception -> L14
            r23.put("block_frame", String.valueOf(this.f10897g));     // Catch: Exception -> L14
            r23.put("block_input", String.valueOf(this.f10896c));     // Catch: Exception -> L14
            r23.put("trace_type", "message");     // Catch: Exception -> L14
            r23.put("update_version_code", com.bytedance.apm.d.k().optString("update_version_code"));     // Catch: Exception -> L14
            r15.put("filters", r23);     // Catch: Exception -> L14
            x.a.p().e(new y.d(LogTypeName.MONITOR_TYPE_DROP_FRAME_STACK, r15));     // Catch: Exception -> L14
            a.i("evil_method_end");     // Catch: Exception -> L14
            return;
        L14:
            a.i("evil_method_analyse_exception");
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    static {
    }

    public a(boolean r10) {
        this(false, false);
    }

    public a(boolean r10, boolean r11) {
        this.f10884g = false;
        this.f10888k = new long[3];
        this.f10889l = 0;
        this.f10890m = null;
        this.f10891n = false;
        if (r11 == true) goto L6;
        j();
    L6:
        if (f10878o != null) goto L9;
        f10878o = this;
        return;
    }

    static /* synthetic */ void i(String r10) {
        k(r10);
    }

    private static void k(String r10) {
        q0.b.f().i(new c(r10));
    }

    public static void l(l4.b r10) {
        f10879p = r10;
    }

    public static void m(long r10) {
        if (r10 >= 70) goto L5;
        r10 = 1000;
    L5:
        f10880q = r10;
    }

    public static void n(boolean r10) {
        f10882s = r10;
    }

    @Override // com.bytedance.apm.block.e
    public void b(boolean r10, long r11) {
        m(r11);
        f10882s = r10;
        if (r10 == true) goto L6;
        Tools.runOnUiThread(new RunnableC0230a(this));
        f.E().L();
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void c(String r10) {
        super.c(r10);
        f.G(1048574, com.bytedance.monitor.collector.a.f2242b);
        if ((com.bytedance.monitor.collector.a.f2242b - this.f10889l) <= 300) goto L9;
        this.f10886i = this.f10885h;
        this.f10889l = com.bytedance.monitor.collector.a.f2242b;
        this.f10885h = f.I("EvilMethodTracer#dispatchBegin", 0);
        if (this.f10884g == false) goto L9;
        if (this.f10886i == null) goto L9;
        long[] r11 = f.E().w(this.f10886i);     // Catch: Throwable -> L11
        long r12 = com.bytedance.monitor.collector.a.f2242b;     // Catch: Throwable -> L11
        k.n().r().f(new b(this, r11, r12));     // Catch: Throwable -> L11
    L9:
        this.f10887j = r10;
    }

    @Override // com.bytedance.apm.block.a
    public void d(long r19, long r21, long r23, long r25, boolean r27) {
        super.d(r19, r21, r23, r25, r27);
        f.J(1048574, com.bytedance.monitor.collector.a.f2242b);
        d r10 = this.f10890m;
        if (r10 == null) goto L6;
        d.a(r10, r27);
        d.b(this.f10890m, t.e.B().f12841b.b());
        q0.b.f().i(this.f10890m);
        this.f10890m = null;
    L6:
        if (f.E().H() == true) goto L8;
        return;
    L8:
        long r11 = r23 - r19;
        if (r11 < f10880q) goto L25;
        l4.b r12 = f10879p;
        if (r12 == null) goto L13;
        r12.a(r11, r27);
    L13:
        k("evil_method_begin");
        long[] r13 = f.E().w(this.f10885h);
        if (r13 != null) goto L16;
    L23:
        k("evil_method_data_null");
        return;
    L16:
        if (r13.length == 0) goto L23;
        long[] r14 = new long[3];
        System.arraycopy(this.f10888k, 0, r14, 0, 3);
        String r15 = h.b();
        if (TextUtils.isEmpty(r15) == false) goto L21;
        String r16 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L22:
        String r17 = this.f10887j;
        this.f10890m = new d(this, ActivityLifeObserver.getInstance().isForeground(), r16, r13, r14, r25 - r21, r11, r23, r17, System.currentTimeMillis(), Api.KEY_UUID, k.n().o());
        return;
    L21:
        r16 = r15 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L22
    }

    public void j() {
        if (f10883t == false) goto L5;
        return;
    L5:
        com.bytedance.apm.block.f.a(this);
        f10883t = true;
    }

    public void o(boolean r10) {
    }

    public synchronized void p() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f10891n == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (f10882s == true) goto L10;
    L12:
        this.f10891n = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (f10881r == false) goto L12;
        t.e.B().v(this);     // Catch: Throwable -> L15
        goto L12
    }
}
