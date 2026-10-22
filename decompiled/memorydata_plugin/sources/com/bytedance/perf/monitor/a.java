package com.bytedance.perf.monitor;

import android.text.TextUtils;
import com.bytedance.apm.block.a.f;
import com.bytedance.apm.block.a.g;
import com.bytedance.apm.block.e;
import com.bytedance.apm.block.h;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.a.d;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.Tools;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.constants.Constants;
import com.bytedance.monitor.collector.k;
import com.bytedance.monitor.collector.o;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.apm.block.a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2970a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2971b = false;
    private static a c = null;
    private static b d = null;
    private static long k = 0;
    private static volatile boolean l = false;
    private volatile boolean e;
    private g.a f;
    private g.a g;
    private volatile String h;
    private long[] i;
    private boolean j;
    private volatile long m;
    private RunnableC0150a n;
    private boolean o;

    /* JADX INFO: renamed from: com.bytedance.perf.monitor.a$a, reason: collision with other inner class name */
    private class RunnableC0150a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long[] f2976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long[] f2977b;
        long c;
        long d;
        long e;
        String f;
        boolean g;
        String h;
        String i;
        long j;
        com.bytedance.monitor.collector.g.e k;
        final /* synthetic */ a l;
        private boolean m;
        private boolean n;

        RunnableC0150a(a r4, boolean r5, String r6, long[] r7, long[] r8, long r9, long r11, long r13, String r15, long r16, String r18, com.bytedance.monitor.collector.g.e r19) {
            this.l = r4;
            this.g = r5;
            this.f = r6;
            this.d = r11;
            this.c = r9;
            this.f2977b = r7;
            this.f2976a = r8;
            this.e = r13;
            this.h = r15;
            this.j = r16;
            this.i = r18;
            this.k = r19;
        }

        static /* synthetic */ boolean a(RunnableC0150a r0, boolean r1) {
            r0.n = r1;
            return r1;
        }

        static /* synthetic */ boolean b(RunnableC0150a r0, boolean r1) {
            r0.m = r1;
            return r1;
        }

        void a() {
            LinkedList r2 = new LinkedList();     // Catch: Exception -> L14
            long[] r3 = this.f2977b;     // Catch: Exception -> L14
            if (r3.length <= 0) goto L7;
            com.bytedance.perf.a.a.a(r3, r2, true, this.e);     // Catch: Exception -> L14
            com.bytedance.perf.a.a.a(r2, 30, new AnonymousClass1(this));     // Catch: Exception -> L14
        L7:
            if (r2.size() > 2) goto L9;
            return;
        L9:
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L14
            long r5 = Math.max(this.d, com.bytedance.perf.a.a.a(r2, r4));     // Catch: Exception -> L14
            String r6 = com.bytedance.perf.a.a.a(r2, r5);     // Catch: Exception -> L14
            JSONObject r7 = new JSONObject();     // Catch: Exception -> L14
            String r8 = r4.toString();     // Catch: Exception -> L14
            com.bytedance.monitor.collector.g.e r9 = this.k;     // Catch: Exception -> L14
            if (r9 == null) goto L12;
            r9.a(this.i, null, null, r8);     // Catch: Exception -> L14
        L12:
            r7.put("stack", r8);     // Catch: Exception -> L14
            r7.put("stack_key", r6);     // Catch: Exception -> L14
            r7.put(MemoryInfoSectionEditActivity.KIND_SCENE, this.f);     // Catch: Exception -> L14
            r7.put("cost_time", r5);     // Catch: Exception -> L14
            r7.put("cpu_cost", this.c);     // Catch: Exception -> L14
            r7.put("method_time", r5);     // Catch: Exception -> L14
            k r10 = k.a();     // Catch: Exception -> L14
            long r11 = this.e;     // Catch: Exception -> L14
            JSONObject r12 = r10.a(r11 - this.d, r11);     // Catch: Exception -> L14
            g r13 = g.a();     // Catch: Exception -> L14
            long r14 = this.e;     // Catch: Exception -> L14
            r12.put("evil_method", r13.a(r14 - this.d, r14));     // Catch: Exception -> L14
            r7.put("custom", r12);     // Catch: Exception -> L14
            r7.put("message", o.a(this.h));     // Catch: Exception -> L14
            r7.put("timestamp", this.e);     // Catch: Exception -> L14
            r7.put(Constants.EVENT_TYPE, "lag_drop_frame");     // Catch: Exception -> L14
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L14
            r15.put("crash_section", com.bytedance.apm.b.a(this.j));     // Catch: Exception -> L14
            r15.put("block_frame", String.valueOf(this.n));     // Catch: Exception -> L14
            r15.put("block_input", String.valueOf(this.m));     // Catch: Exception -> L14
            r15.put("trace_type", "message");     // Catch: Exception -> L14
            r15.put("update_version_code", com.bytedance.apm.b.r().optString("update_version_code"));     // Catch: Exception -> L14
            r7.put("filters", r15);     // Catch: Exception -> L14
            com.bytedance.apm.data.pipeline.a.b().a(new d(LogTypeName.MONITOR_TYPE_DROP_FRAME_STACK, r7));     // Catch: Exception -> L14
            a.b("evil_method_end");     // Catch: Exception -> L14
            return;
        L14:
            a.b("evil_method_analyse_exception");
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static {
    }

    public a() {
        this(false);
    }

    public a(boolean r1) {
        this(false, false);
    }

    public a(boolean r4, boolean r5) {
        this.e = false;
        this.i = new long[3];
        this.m = 0;
        this.n = null;
        this.o = false;
        this.j = r4;
        if (r5 == true) goto L6;
        c();
    L6:
        if (c != null) goto L9;
        c = this;
        return;
    }

    public static void a(long r2) {
        if (r2 >= 70) goto L5;
        r2 = 1000;
    L5:
        k = r2;
    }

    public static void a(boolean r0) {
        f2971b = r0;
    }

    static /* synthetic */ void b(String r0) {
        c(r0);
    }

    private static void c(final String r2) {
        com.bytedance.apm.l.b.a().a(new AnonymousClass3(r2));
    }

    @Override // com.bytedance.apm.block.a
    public void a(long r19, long r21, long r23, long r25, boolean r27) {
        super.a(r19, r21, r23, r25, r27);
        g.b(1048574, com.bytedance.monitor.collector.a.f2831b);
        RunnableC0150a r1 = this.n;
        if (r1 == null) goto L6;
        RunnableC0150a.a(r1, r27);
        RunnableC0150a.b(this.n, f.a().f1196a.b());
        com.bytedance.apm.l.b.a().a(this.n);
        this.n = null;
    L6:
        if (g.a().d() == true) goto L8;
        return;
    L8:
        long r8 = r23 - r19;
        if (r8 < k) goto L25;
        b r2 = d;
        if (r2 == null) goto L13;
        r2.a(r8, r27);
    L13:
        c("evil_method_begin");
        long[] r4 = g.a().a(this.f);
        if (r4 != null) goto L16;
    L23:
        c("evil_method_data_null");
        return;
    L16:
        if (r4.length == 0) goto L23;
        long[] r5 = new long[3];
        System.arraycopy(this.i, 0, r5, 0, 3);
        String r0 = h.a();
        if (TextUtils.isEmpty(r0) == false) goto L21;
        String r3 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L22:
        String r12 = this.h;
        this.n = new RunnableC0150a(this, ActivityLifeObserver.getInstance().isForeground(), r3, r4, r5, r25 - r21, r8, r23, r12, System.currentTimeMillis(), Api.KEY_UUID, k.a().o());
        return;
    L21:
        r3 = r0 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L22
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r6) {
        super.a(r6);
        g.a(1048574, com.bytedance.monitor.collector.a.f2831b);
        if ((com.bytedance.monitor.collector.a.f2831b - this.m) <= 300) goto L9;
        this.g = this.f;
        this.m = com.bytedance.monitor.collector.a.f2831b;
        this.f = g.a("EvilMethodTracer#dispatchBegin", 0);
        if (this.e == false) goto L9;
        if (this.g == null) goto L9;
        final long[] r0 = g.a().a(this.g);     // Catch: Throwable -> L11
        final long r1 = com.bytedance.monitor.collector.a.f2831b;     // Catch: Throwable -> L11
        k.a().i().b(new AnonymousClass2(this, r0, r1));     // Catch: Throwable -> L11
    L9:
        this.h = r6;
    }

    @Override // com.bytedance.apm.block.e
    public void a(boolean r1, long r2) {
        a(r2);
        f2971b = r1;
        if (r1 == true) goto L6;
        Tools.runOnUiThread(new AnonymousClass1(this));
        g.a().c();
        return;
    }

    public synchronized void b() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.o == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (f2971b == true) goto L10;
    L12:
        this.o = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (f2970a == false) goto L12;
        f.a().a(this);     // Catch: Throwable -> L15
        goto L12
    }

    public void b(boolean r1) {
        this.j = r1;
    }

    public void c() {
        if (l == false) goto L5;
        return;
    L5:
        com.bytedance.apm.block.f.a(this);
        l = true;
    }
}
