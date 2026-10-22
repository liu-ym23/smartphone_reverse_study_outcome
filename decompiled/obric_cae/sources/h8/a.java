package h8;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import c2.k;
import com.bytedance.apm.core.ActivityLifeObserver;
import i2.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import o2.c;
import o2.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.bytedance.apm.block.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f7922h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f7923i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f7924j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f7925k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f7926l = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e.C0090e f7927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f7928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f7929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f7930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f7931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7932g;

    /* JADX INFO: renamed from: h8.a$a, reason: collision with other inner class name */
    public static class RunnableC0086a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7933a;

        public RunnableC0086a(String r8) {
            this.f7933a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r8 = new JSONObject();     // Catch: JSONException -> L4
            r8.put("evil_method_section", this.f7933a);     // Catch: JSONException -> L4
            n2.a.i().d(new c("evil_method_tracing", 0, null, r8, null, null));     // Catch: JSONException -> L4
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7935b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long[] f7936m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f7937n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final long f7938o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f7939p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f7940q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final String f7941r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final long f7942s;

        public b(String r8, long[] r10, long r11, long r12, long r13, String r14, long r15) {
            this.f7940q = r8;
            this.f7938o = r12;
            this.f7937n = r11;
            this.f7936m = r10;
            this.f7939p = r13;
            this.f7941r = r14;
            this.f7942s = r15;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long r8 = this.f7938o;
            LinkedList r10 = new LinkedList();     // Catch: Exception -> L34
            long[] r11 = this.f7936m;     // Catch: Exception -> L34
            int r12 = r11.length;     // Catch: Exception -> L34
            long r13 = this.f7939p;
            if (r12 <= 0) goto L8;
            g8.b.f(r11, r10, r13);     // Catch: Exception -> L34
            g8.b.g(r10, new h8.b());     // Catch: Exception -> L34
        L8:
            if (r10.size() <= 2) goto L50;
            StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L34
            long r15 = Math.max(r8, g8.b.e(r10, r14));     // Catch: Exception -> L34
            String r16 = g8.b.c(r15, r10);     // Catch: Exception -> L34
            JSONObject r17 = new JSONObject();     // Catch: Exception -> L34
            r17.put("stack", r14.toString());     // Catch: Exception -> L34
            r17.put("stack_key", r16);     // Catch: Exception -> L34
            r17.put("scene", this.f7940q);     // Catch: Exception -> L34
            r17.put("cost_time", r15);     // Catch: Exception -> L34
            r17.put("cpu_cost", this.f7937n);     // Catch: Exception -> L34
            r17.put("method_time", r15);     // Catch: Exception -> L34
            com.bytedance.monitor.collector.a r18 = com.bytedance.monitor.collector.a.b();     // Catch: Exception -> L34
            long r19 = r13 - r8;     // Catch: Exception -> L34
            r18.getClass();     // Catch: Exception -> L34
            JSONObject r20 = new JSONObject();     // Catch: Exception -> L34
            int r21 = 0;
        L11:
            CopyOnWriteArrayList r22 = r18.f3969a;     // Catch: Exception -> L34
            if (r21 >= r22.size()) goto L15;
            Pair<String, ?> r23 = ((a8.b) r22.get(r21)).b(r19, r13);     // Catch: Exception -> L36
            r20.put((String) r23.first, r23.second);     // Catch: Exception -> L36
        L14:
            r21 = r21 + 1;
            goto L11
        L15:
            int r24 = e.f8105a;     // Catch: Exception -> L34
            long r25 = SystemClock.uptimeMillis();     // Catch: Exception -> L34
            e.C0090e r26 = e.f8122r;     // Catch: Exception -> L34
            if (r26 == null) goto L31;
            e.C0090e r110 = e.f8123s;     // Catch: Exception -> L34
            if (r110 == null) goto L31;
        L20:
            if (r26 == r110) goto L27;
            e.C0090e r111 = r26.f8126c;     // Catch: Exception -> L34
            if (r111.f8129f > r13) goto L23;
            e.C0090e r112 = r110.f8127d;     // Catch: Exception -> L34
            if (r112.f8129f >= r19) goto L27;
            r110 = r112;
            goto L20
        L23:
            r26 = r111;
        L27:
            int r27 = r26.f8125b;     // Catch: Exception -> L34
            if (r27 != 0) goto L30;
            r27 = e.f8109e - 1;     // Catch: Exception -> L34
        L30:
            long[] r28 = e.a(r110.f8124a, r27);     // Catch: Exception -> L34
        L32:
            r20.put("evil_method", e.b(r25, r28));     // Catch: Exception -> L34
            r17.put("custom", r20);     // Catch: Exception -> L34
            r17.put("message", t2.b.P(this.f7941r));     // Catch: Exception -> L34
            r17.put("timestamp", r13);     // Catch: Exception -> L34
            r17.put("event_type", "lag_drop_frame");     // Catch: Exception -> L34
            JSONObject r29 = new JSONObject();     // Catch: Exception -> L34
            r29.put("crash_section", k.c(this.f7942s));     // Catch: Exception -> L34
            r29.put("block_frame", String.valueOf(this.f7935b));     // Catch: Exception -> L34
            r29.put("block_input", String.valueOf(this.f7934a));     // Catch: Exception -> L34
            r29.put("trace_type", "message");     // Catch: Exception -> L34
            r17.put("filters", r29);     // Catch: Exception -> L34
            n2.a.i().d(new d("drop_frame_stack", r17));     // Catch: Exception -> L34
            a.c("evil_method_end");     // Catch: Exception -> L34
            return;
        L31:
            r28 = null;
            goto L32
        L50:
            return;
        L34:
            a.c("evil_method_analyse_exception");
        }
    }

    public a(boolean r8) {
        this.f7929d = new long[3];
        this.f7930e = 0;
        this.f7931f = null;
        this.f7932g = false;
        if (r8 == true) goto L16;
        if (f7926l == true) goto L16;
        ArrayList r10 = com.bytedance.apm.block.b.f3753a;
        monitor-enter(com.bytedance.apm.block.b.class);
        com.bytedance.apm.block.b.f3753a.add(this);     // Catch: Throwable -> L12
        monitor-exit(com.bytedance.apm.block.b.class);
        f7926l = true;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (f7922h != null) goto L21;
        f7922h = this;
        return;
    }

    public static void c(String r8) {
        b3.b.C0032b.f3038a.c(new RunnableC0086a(r8));
    }

    @Override // com.bytedance.apm.block.a
    public final void a(String r8) {
        this.f3752a = true;
        e.c(1048574, a8.a.f118b);
        if ((a8.a.f118b - this.f7930e) <= 300) goto L5;
        this.f7930e = a8.a.f118b;
        this.f7927b = e.d(0, "EvilMethodTracer#dispatchBegin");
    L5:
        this.f7928c = r8;
    }

    @Override // com.bytedance.apm.block.a
    public final void b(long r17, long r19, long r21, long r23, boolean r25) {
        this.f3752a = false;
        e.e(1048574, a8.a.f118b);
        b r8 = this.f7931f;
        long[] r10 = null;
        boolean r11 = true;
        if (r8 == null) goto L10;
        r8.f7935b = r25;
        long[] r12 = i2.b.f8089k.f8091b.f8088a;
        if ((r12[0] - r12[2]) <= 100) goto L7;
        boolean r13 = true;
    L8:
        r8.f7934a = r13;
        b3.b.C0032b.f3038a.c(r8);
        this.f7931f = null;
        goto L10
    L7:
        r13 = false;
    L10:
        if (e.f8105a >= 2) goto L13;
        r11 = false;
    L13:
        if (r11 == true) goto L15;
        return;
    L15:
        long r14 = r21 - r17;
        if (r14 < f7923i) goto L37;
        c("evil_method_begin");
        e.C0090e r15 = this.f7927b;
        int r16 = e.f8109e - 1;
        if (e.f8105a != (-3)) goto L20;
    L19:
        long[] r18 = r10;
        if (r18 != null) goto L25;
    L32:
        c("evil_method_data_null");
        return;
    L25:
        if (r18.length == 0) goto L32;
        System.arraycopy(this.f7929d, 0, new long[3], 0, 3);
        String r20 = com.bytedance.apm.block.c.a();
        if (TextUtils.isEmpty(r20) == false) goto L30;
        String r22 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L31:
        String r110 = this.f7928c;
        ActivityLifeObserver.getInstance().isForeground();
        long r111 = System.currentTimeMillis();
        com.bytedance.monitor.collector.a.b().getClass();
        this.f7931f = new b(r22, r18, r23 - r19, r14, r21, r110, r111);
        return;
    L30:
        StringBuilder r24 = android.aimedia.a.k(r20, ",");
        r24.append(ActivityLifeObserver.getInstance().getTopActivityClassName());
        r22 = r24.toString();
        goto L31
    L20:
        r10 = new long[0];
        r15.getClass();     // Catch: OutOfMemoryError -> L34
        r10 = e.a(r15.f8124a - 1, r16);     // Catch: OutOfMemoryError -> L34
        goto L19
    }
}
