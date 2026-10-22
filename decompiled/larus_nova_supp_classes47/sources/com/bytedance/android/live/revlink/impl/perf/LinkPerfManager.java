package com.bytedance.android.live.revlink.impl.perf;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenuelink.rtc.g;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.api.service.IDegradeTask;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kc0.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkPerfManager implements p11.d, h {
    public Handler a;
    public Handler b;
    public PthreadHandlerThreadV2 c;
    public IHostPerformanceMonitor d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public final com.bytedance.android.live.revlink.impl.perf.b i;
    public final com.bytedance.android.live.revlink.impl.perf.a j;
    public boolean k;
    public String l;
    public final Lazy m;
    public String n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final long r;
    public final float s;
    public final Lazy t;
    public boolean u;
    public final Lazy v;
    public final d w;
    public final c x;
    public final b y;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LinkPerfManager a;

        public final void a() {
            LinkPerfManager r0 = this.a;
            if (r0.k == true) goto L5;
            return;
        L5:
            int r1 = r0.h;
            int r4 = 1;
            if (r1 != 1) goto L27;
            double r2 = vh6.c.b(pr2.b.class).getRenderFps();
            if (Double.compare(r2, 0) < 0) goto L10;
            this.a.i.g.add(Double.valueOf(r2));
        L10:
            LinkPerfManager r3 = this.a;
            int r5 = r3.f + 1;
            r3.f = r5;
            r11.e r6 = com.bytedance.android.live.revlink.impl.settings.live.b.p.b();
            if (r3.h != 1) goto L22;
            if (r6 == null) goto L17;
            r11.e.c r7 = r6.c9();
            if (r7 == null) goto L17;
            Integer r8 = Integer.valueOf(r7.i());
        L18:
            r4 = r8.intValue();
            if (r4 > 0) goto L22;
            r4 = 3;
        L17:
            r8 = null;
        L22:
            if (r5 < r4) goto L24;
            LinkPerfManager r9 = this.a;
            r9.getClass();
            r9.n(new com.bytedance.android.live.revlink.impl.perf.c(r9));
            return;
        L24:
            LinkPerfManager r10 = this.a;
            Handler r12 = r10.b;
            if (r12 == null) goto L37;
            r12.postDelayed(this, r10.m(2));
            return;
        L37:
            return;
        L27:
            if (r1 != 2) goto L39;
            IPerformanceManager r13 = (IPerformanceManager) r0.t.getValue();
            if (r13 == null) goto L31;
            float r14 = r13.getFps();
        L33:
            if (Float.compare(r14, 0) < 0) goto L40;
            this.a.i.g.add(Double.valueOf(r14));
            return;
        L40:
            return;
        L31:
            r14 = 0.0f;
            goto L33
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LinkPerfManager r1) {
            this.a = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkPerfManager a;

        public final void a() {
            LinkPerfManager r0 = this.a;
            if (r0.l() == false) goto L15;
            r0.f = 0;
            Handler r1 = r0.b;
            if (r1 == null) goto L8;
            r1.removeCallbacks(r0.y);
        L8:
            Handler r2 = r0.b;
            if (r2 == null) goto L15;
            b r3 = r0.y;
            if (r0.h != 2) goto L13;
            int r4 = 5;
        L14:
            r2.postDelayed(r3, r0.m(r4));
            goto L15
        L13:
            r4 = 4;
        L15:
            LinkPerfManager r5 = this.a;
            if (r5.e == false) goto L25;
            Handler r6 = r5.b;
            if (r6 != null) goto L20;
            return;
        L20:
            if (r5.h != 2) goto L22;
            int r7 = 3;
        L23:
            r6.postDelayed(this, r5.m(r7));
            return;
        L22:
            r7 = 1;
            goto L23
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LinkPerfManager r1) {
            this.a = r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LinkPerfManager a;

        public final void a() {
            if (this.a.l() == false) goto L94;
            LinkPerfManager r0 = this.a;
            if (r0.q == false) goto L97;
            IHostPerformanceMonitor r1 = r0.d;
            if (r1 == null) goto L88;
            com.bytedance.android.live.revlink.impl.perf.b r2 = r0.i;
            String r3 = r0.n;
            e r4 = new e();
            Map r5 = r1.getCpuRate();
            double r6 = -1.0d;
            if (r5 == null) goto L14;
            Double r7 = (Double) r5.get("cpu_rate");
            if (r7 == null) goto L14;
            double r8 = r7.doubleValue();
        L15:
            r4.a = r8;
            if (r5 == null) goto L20;
            Double r9 = (Double) r5.get("cpu_speed");
            if (r9 == null) goto L20;
            r6 = r9.doubleValue();
        L20:
            r4.b = r6;
            r4.c = r1.getGpuUsage();
            Map r10 = r1.getMemory();
            long r12 = -1;
            if (r10 == null) goto L25;
            Long r13 = (Long) r10.get("mem_pss_total");
            if (r13 == null) goto L25;
            long r14 = r13.longValue();
        L26:
            r4.e = r14;
            if (r10 == null) goto L31;
            Long r15 = (Long) r10.get("mem_pss_native");
            if (r15 == null) goto L31;
            long r16 = r15.longValue();
        L32:
            r4.f = r16;
            if (r10 == null) goto L37;
            Long r17 = (Long) r10.get("mem_java_total");
            if (r17 == null) goto L37;
            long r18 = r17.longValue();
        L38:
            r4.g = r18;
            if (r10 == null) goto L43;
            Long r19 = (Long) r10.get("mem_graphics");
            if (r19 == null) goto L43;
            r12 = r19.longValue();
        L43:
            r4.h = r12;
            r4.d = vh6.c.b(pr2.b.class).getRenderFps();
            Unit r20 = Unit.INSTANCE;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "scene");
            Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
            boolean r22 = !Intrinsics.areEqual(r2.a, r3);
            r2.b = r22;
            if (r22 == false) goto L87;
            String r23 = r2.a;
            r2.a = r3;
            r2.e.put("last_rev_scene", String.valueOf(r23));
            r2.e.put("cur_rev_scene", String.valueOf(r2.a));
            e r24 = r2.c;
            if (r24 == null) goto L87;
            double r25 = r4.a;
            double r26 = 0;
            if (r25 <= r26) goto L52;
            double r27 = r24.a;
            if (r27 <= r26) goto L52;
            r2.e.put("cpu_diff", String.valueOf(r25 - r27));
        L52:
            double r28 = r4.b;
            if (r28 <= r26) goto L57;
            double r29 = r24.b;
            if (r29 <= r26) goto L57;
            r2.e.put("cpu_speed_diff", String.valueOf(r28 - r29));
        L57:
            double r30 = r4.d;
            if (r30 < r26) goto L62;
            double r32 = r24.d;
            if (r32 < r26) goto L62;
            r2.e.put("stream_preview_fps_diff", String.valueOf(r30 - r32));
        L62:
            double r33 = r4.c;
            if (r33 <= r26) goto L67;
            double r34 = r24.c;
            if (r34 <= r26) goto L67;
            r2.e.put("gpu_diff", String.valueOf(r33 - r34));
        L67:
            long r35 = r4.e;
            if (r35 < 0) goto L72;
            long r110 = r24.e;
            if (r110 < 0) goto L72;
            r2.e.put("mem_pss_total_diff", String.valueOf(((r35 - r110) / 1024.0d) / 1024.0d));
        L72:
            long r36 = r4.f;
            if (r36 < 0) goto L77;
            long r111 = r24.f;
            if (r111 < 0) goto L77;
            r2.e.put("mem_native_diff", String.valueOf(((r36 - r111) / 1024.0d) / 1024.0d));
        L77:
            long r37 = r4.g;
            if (r37 < 0) goto L82;
            long r112 = r24.g;
            if (r112 < 0) goto L82;
            r2.e.put("mem_java_diff", String.valueOf(((r37 - r112) / 1024.0d) / 1024.0d));
        L82:
            long r38 = r4.h;
            if (r38 < 0) goto L87;
            long r39 = r24.h;
            if (r39 < 0) goto L87;
            r2.e.put("mem_graphics_diff", String.valueOf(((r38 - r39) / 1024.0d) / 1024.0d));
        L87:
            r2.c = r4;
        L37:
            r18 = -1;
        L31:
            r16 = -1;
        L25:
            r14 = -1;
        L14:
            r8 = -1.0d;
        L88:
            LinkPerfManager r40 = this.a;
            r40.getClass();
            r40.n(new com.bytedance.android.live.revlink.impl.perf.d(r40));
            LinkPerfManager r42 = this.a;
            int r43 = r42.g + 1;
            r42.g = r43;
            if (r43 >= LinkPerfManager.j(r42, 3)) goto L95;
            LinkPerfManager r44 = this.a;
            Handler r45 = r44.b;
            if (r45 == null) goto L96;
            r45.postDelayed(this, r44.m(9));
            return;
        L96:
            return;
        L95:
            return;
        L97:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LinkPerfManager r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // p11.d
    public final void b() {
        o(2);
    }

    @Override // p11.d
    public final void g() {
        q(2);
    }

    @Override // p11.d
    public final void h() {
        o(1);
        k();
    }

    public final void onBackground() {
        this.k = false;
        if (this.e == true) goto L5;
        return;
    L5:
        if (l() == false) goto L14;
        this.f = 0;
        Handler r0 = this.b;
        if (r0 == null) goto L9;
        r0.removeCallbacks(this.y);
    L9:
        Handler r1 = this.b;
        if (r1 == null) goto L15;
        r1.removeCallbacks(this.x);
        return;
    L15:
        return;
    }

    public final void onForeground() {
        this.k = true;
        if (this.e == true) goto L5;
        return;
    L5:
        if (l() == false) goto L9;
        p();
        return;
    }

    @Override // p11.d
    public final boolean a() {
        if (this.p == true) goto L5;
        return false;
    L5:
        this.j.getClass();
        if (com.bytedance.android.live.revlink.impl.perf.a.j() == false) goto L8;
        return true;
    L8:
        IPerformanceManager r0 = k.f(IPerformanceManager.class);
        if (r0 != null) goto L11;
        return false;
    L11:
        if (this.r <= 0) goto L15;
        long r3 = r0.getPssTotal();
        long r5 = WebcastRedirectException.UNKNOWN;
        if (((r3 / r5) / r5) <= this.r) goto L15;
    L18:
        return true;
    L15:
        if (this.s > 0) goto L17;
        return false;
    L17:
        if (r0.getCpuRate() > this.s) goto L18;
        return false;
    }

    @Override // com.bytedance.android.live.revlink.api.service.ILinkDegradeManager
    public final void d() {
        this.j.d();
    }

    @Override // p11.d
    public final boolean e() {
        if (this.p == true) goto L5;
        return false;
    L5:
        this.j.getClass();
        if (com.bytedance.android.live.revlink.impl.perf.a.j() == true) goto L24;
        com.bytedance.android.live.revlink.impl.settings.live.b r0 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        if (r11.f.a(r0.b()) == true) goto L24;
        if (this.j.c == true) goto L24;
        if (r11.f.a(r0.b()) == true) goto L21;
        Pair<Double, Long> r1 = this.i.a(7);
        if (r1 == null) goto L22;
        double r4 = ((Number) r1.getFirst()).doubleValue();
        long r6 = ((Number) r1.getSecond()).longValue();
        this.j.getClass();
        if (com.bytedance.android.live.revlink.impl.perf.a.l(r4, false) == false) goto L22;
        if ((System.currentTimeMillis() - r6) <= m(7)) goto L21;
    L22:
        boolean r2 = false;
    L23:
        if (r2 == true) goto L24;
        return false;
    L21:
        r2 = true;
    L24:
        return true;
    }

    public final void k() {
        if (this.o == true) goto L5;
        return;
    L5:
        if (this.u == true) goto L16;
        com.bytedance.android.live.revenuelink.rtc.f r0 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r0 == null) goto L10;
        i r1 = r0.getRtcManager();
    L11:
        if (r1 == null) goto L15;
        this.u = true;
        r1.g1((g) this.v.getValue());
        return;
    L15:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final boolean l() {
        if (this.o == true) goto L5;
        return false;
    L5:
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);
        if (r0 == null) goto L40;
        IRoom r1 = r0.getRoom();
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.isLiveTypeAudio() == false) goto L13;
        return false;
    L13:
        if (this.d != null) goto L16;
        this.d = vh6.c.b(dr2.g.class).Df();
    L16:
        if (this.b == null) goto L24;
        if (this.a == null) goto L24;
        PthreadHandlerThreadV2 r2 = this.c;
        if (r2 == null) goto L24;
        if (ThreadMethodProxy.isAlive(r2) != true) goto L24;
    L31:
        if (this.b != null) goto L33;
        return false;
    L33:
        if (this.a == null) goto L43;
        PthreadHandlerThreadV2 r3 = this.c;
        if (r3 != null) goto L37;
        return false;
    L37:
        if (ThreadMethodProxy.isAlive(r3) != true) goto L45;
        return true;
    L45:
        return false;
    L43:
        return false;
    L24:
        if (this.o == false) goto L31;
        PthreadHandlerThreadV2 r4 = new PthreadHandlerThreadV2("LivePerformanceManagerThread", 0);
        this.c = r4;
        ThreadMethodProxy.start(r4);
        PthreadHandlerThreadV2 r5 = this.c;
        if (r5 == null) goto L28;
        Looper r6 = r5.getLooper();
    L29:
        Intrinsics.checkNotNull(r6);
        this.b = new Handler(r6);
        this.a = new Handler(Looper.getMainLooper());
        k();
        goto L31
    L28:
        r6 = null;
        goto L29
    L40:
        return false;
    }

    public final void p() {
        com.bytedance.android.live.revlink.impl.perf.b r0 = this.i;
        r0.f.clear();
        r0.g.clear();
        r0.d = 0;
        if (this.h != 1) goto L5;
        com.bytedance.android.live.revlink.impl.perf.a r1 = this.j;
        r1.c = false;
        r1.a = -1;
        r1.e = -1;
    L5:
        Handler r2 = this.b;
        if (r2 == null) goto L8;
        r2.removeCallbacks(this.x);
    L8:
        Handler r3 = this.b;
        if (r3 == null) goto L12;
        r3.post(this.x);
        return;
    }

    public final void release() {
        Handler r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.x);
    L5:
        Handler r1 = this.b;
        if (r1 == null) goto L8;
        r1.removeCallbacks(this.y);
    L8:
        Handler r2 = this.b;
        if (r2 == null) goto L11;
        r2.removeCallbacks(this.w);
    L11:
        this.e = false;
        if (this.u == false) goto L19;
        com.bytedance.android.live.revenuelink.rtc.f r3 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r3 == null) goto L18;
        i r4 = r3.getRtcManager();
        if (r4 == null) goto L18;
        r4.i1((g) this.v.getValue());
    L18:
        this.u = false;
    L19:
        com.bytedance.android.live.revlink.impl.perf.b r5 = this.i;
        r5.f.clear();
        r5.g.clear();
        r5.d = 0;
        r5.e.clear();
        String r6 = "";
        r5.a = "";
        r5.b = false;
        r5.c = null;
        com.bytedance.android.live.revlink.impl.perf.a r7 = this.j;
        r7.c = false;
        r7.a = -1;
        r7.e = -1;
        ConcurrentHashMap<Integer, IDegradeTask> r8 = r7.h;
        if (r8 == null) goto L27;
        Iterator<Map.Entry<Integer, IDegradeTask>> r9 = r8.entrySet().iterator();
    L23:
        if (r9.hasNext() == false) goto L27;
        IDegradeTask r10 = r9.next().getValue();
        if (r10 == null) goto L23;
        r10.onClear();
    L27:
        r7.h.clear();
        PthreadHandlerThreadV2 r12 = this.c;     // Catch: Exception -> L33
        if (r12 == null) goto L31;
        r12.quit();     // Catch: Exception -> L33
    L31:
        this.c = null;     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        String r13 = e.getMessage();
        if (r13 == null) goto L38;
        r6 = r13;
    L38:
        jy0.b.c("HandlerThread", r6, null, 4);
    }

    public LinkPerfManager() {
        this.h = -1;
        this.i = new com.bytedance.android.live.revlink.impl.perf.b();
        this.j = new com.bytedance.android.live.revlink.impl.perf.a();
        boolean r0 = true;
        this.k = true;
        this.l = "";
        this.m = LazyKt.lazy(LinkPerfManager$isAnchor$2.INSTANCE);
        this.n = "";
        com.bytedance.android.live.revlink.impl.settings.live.b r1 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        this.o = r1.b().getEnable();
        r11.e r2 = r1.b();
        Intrinsics.checkNotNullParameter(r2, "$this$isDegradeEnable");
        if (r2.getEnable() == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.p = r3;
        r11.e r4 = r1.b();
        Intrinsics.checkNotNullParameter(r4, "$this$isSceneEnable");
        if (r4.getEnable() == true) goto L11;
    L15:
        r0 = false;
    L16:
        this.q = r0;
        this.r = r1.b().Y6();
        this.s = r1.b().w1();
        this.t = LazyKt.lazy(LinkPerfManager$basePerfManager$2.INSTANCE);
        this.v = LazyKt.lazy(new LinkPerfManager$rtcListener$2(this));
        this.w = new d(this);
        this.x = new c(this);
        this.y = new b(this);
        return;
    L11:
        if (r4.M() == null) goto L15;
        r11.e.d r5 = r4.M();
        Intrinsics.checkNotNull(r5);
        if (r5.getEnable() == false) goto L15;
    L5:
        if (r2.V6() == false) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.api.service.ILinkDegradeManager
    public final void c(LinkRtcDegradeTask r2) {
        Intrinsics.checkNotNullParameter(r2, "degradeTask");
        this.j.c(r2);
    }

    @Override // p11.d
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter("multi_linker", "source");
        this.j.f("multi_linker");
    }

    @Override // p11.d
    public final void i(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (Intrinsics.areEqual(this.l, r6) == true) goto L35;
        com.bytedance.android.live.revlink.impl.perf.a r1 = this.j;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "scene");
        ConcurrentHashMap<Integer, IDegradeTask> r0 = r1.h;
        if (r0 == null) goto L17;
        Iterator<Map.Entry<Integer, IDegradeTask>> r2 = r0.entrySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<Integer, IDegradeTask> r3 = r2.next();
        IDegradeTask r4 = r3.getValue();     // Catch: Exception -> L15
        if (r4 == null) goto L9;
        r4.onSceneEnter(r6);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        jy0.b.c("LinkDegradeManager", "trigger scene enter：type = " + r3.getKey().intValue() + "; message = " + e.getMessage(), null, 4);
    L17:
        int r5 = r6.hashCode();
        if (r5 == (-1942410259)) goto L31;
        if (r5 == 3579) goto L28;
        if (r5 == 1544803905) goto L25;
    L33:
        this.l = r6;
        goto L35
    L25:
        if (r6.equals("default") == false) goto L33;
        q(1);
        goto L33
    L28:
        if (r6.equals("pk") == false) goto L33;
    L32:
        h();
        goto L33
    L31:
        if (r6.equals("multi_linker") == false) goto L33;
    L35:
        if (this.q == true) goto L37;
        return;
    L37:
        if (l() == false) goto L56;
        Handler r7 = this.b;
        if (r7 == null) goto L42;
        r7.removeCallbacks(this.w);
    L42:
        this.n = r6;
        this.g = 0;
        Handler r8 = this.b;
        if (r8 == null) goto L55;
        r8.postDelayed(this.w, m(6));
        return;
    L55:
        return;
    }

    public final long m(int r9) {
        r11.e r0 = com.bytedance.android.live.revlink.impl.settings.live.b.p.b();
        long r1 = 10000;
        long r3 = 1000;
        Long r5 = null;
        switch(r9) {
            case 1: goto L72;
            case 2: goto L64;
            case 3: goto L57;
            case 4: goto L52;
            case 5: goto L45;
            case 6: goto L38;
            case 7: goto L29;
            case 8: goto L21;
            case 9: goto L6;
            default: goto L83;
        };
    L21:
        if (r0 == null) goto L25;
        r11.e.c r10 = r0.c9();
        if (r10 == null) goto L25;
        r5 = Long.valueOf(r10.p());
    L25:
        long r2 = r5.longValue();
        if (r2 > 0) goto L81;
        int r12 = 30;
    L37:
        r2 = ((long) r12) * 1000;
    L81:
        return r2;
    L29:
        if (r0 == null) goto L33;
        r11.e.b r13 = r0.m4();
        if (r13 == null) goto L33;
        r5 = Long.valueOf(r13.p());
    L33:
        r2 = r5.longValue();
        if (r2 > 0) goto L81;
        r12 = 5;
        goto L37
    L38:
        if (r0 == null) goto L42;
        r11.e.d r14 = r0.M();
        if (r14 == null) goto L42;
        r5 = Long.valueOf(r14.H());
    L42:
        long r4 = r5.longValue();
        if (r4 <= 0) goto L80;
    L78:
        r1 = r4;
    L80:
        return r1;
    L45:
        if (r0 == null) goto L47;
        r5 = Long.valueOf(r0.g9());
    L47:
        r2 = r5.longValue();
        if (r2 > 0) goto L81;
        r2 = 200;
        goto L81
    L52:
        if (r0 == null) goto L54;
        r5 = Long.valueOf(r0.H());
    L54:
        long r6 = r5.longValue();
        if (r6 <= 0) goto L82;
    L56:
        r3 = r6;
    L82:
        return r3;
    L57:
        if (r0 == null) goto L61;
        r11.e.b r15 = r0.m4();
        if (r15 == null) goto L61;
        r5 = Long.valueOf(r15.getInterval());
    L61:
        r6 = r5.longValue();
        if (r6 <= 0) goto L82;
    L64:
        if (r0 == null) goto L68;
        r11.e.c r16 = r0.c9();
        if (r16 == null) goto L68;
        r5 = Long.valueOf(r16.O6());
    L68:
        r6 = r5.longValue();
        if (r6 <= 0) goto L82;
    L72:
        if (r0 == null) goto L76;
        r11.e.c r17 = r0.c9();
        if (r17 == null) goto L76;
        r5 = Long.valueOf(r17.getInterval());
    L76:
        r4 = r5.longValue();
        if (r4 <= 0) goto L80;
    L83:
        return 0;
    L6:
        if (((Boolean) this.m.getValue()).booleanValue() == true) goto L12;
        if (r0 == null) goto L11;
        r11.e.d r18 = r0.M();
        if (r18 == null) goto L11;
        r5 = Long.valueOf(r18.w2());
    L11:
        r3 = r5.longValue();
    L18:
        if (r3 > 0) goto L82;
        r3 = ((long) 2) * 10000;
        goto L82
    L12:
        if (r0 == null) goto L16;
        r11.e.d r19 = r0.M();
        if (r19 == null) goto L16;
        r5 = Long.valueOf(r19.getInterval());
    L16:
        r3 = r5.longValue();
        goto L18
    }

    public final void n(Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.run();
        return;
    L5:
        Handler r0 = this.a;
        if (r0 == null) goto L10;
        r0.post(r3);
        return;
    }

    public final void o(int r4) {
        if (l() == true) goto L6;
        return;
    L6:
        if (this.e == false) goto L13;
        int r0 = this.h;
        if (r4 == r0) goto L13;
        if (r0 == (-1)) goto L13;
        if (r0 == 1) goto L13;
        n(new com.bytedance.android.live.revlink.impl.perf.c(this));
    L13:
        this.h = r4;
        this.e = true;
        p();
    }

    public final void q(int r2) {
        if (l() == true) goto L5;
        return;
    L5:
        if (this.e == false) goto L17;
        int r0 = this.h;
        if (r0 == r2) goto L10;
        return;
    L10:
        if (r0 != 2) goto L12;
        n(new com.bytedance.android.live.revlink.impl.perf.c(this));
    L12:
        this.h = -1;
        this.e = false;
        Handler r3 = this.b;
        if (r3 == null) goto L18;
        r3.removeCallbacks(this.x);
        return;
    L18:
        return;
    }

    public static final int j(LinkPerfManager r4, int r5) {
        r4.getClass();
        r11.e r0 = com.bytedance.android.live.revlink.impl.settings.live.b.p.b();
        Integer r2 = null;
        if (r5 != 1) goto L5;
        if (r0 == null) goto L33;
        r11.e.c r6 = r0.c9();
        if (r6 == null) goto L33;
        r2 = Integer.valueOf(r6.i());
    L33:
        int r7 = r2.intValue();
        if (r7 > 0) goto L36;
        return 3;
    L36:
        return r7;
    L5:
        if (r5 == 2) goto L22;
        if (r5 == 3) goto L9;
        return 3;
    L9:
        if (((Boolean) r4.m.getValue()).booleanValue() == true) goto L15;
        if (r0 == null) goto L14;
        r11.e.d r8 = r0.M();
        if (r8 == null) goto L14;
        r2 = Integer.valueOf(r8.D7());
    L14:
        r7 = r2.intValue();
    L20:
        if (r7 > 0) goto L36;
        return 3;
    L15:
        if (r0 == null) goto L19;
        r11.e.d r9 = r0.M();
        if (r9 == null) goto L19;
        r2 = Integer.valueOf(r9.i());
    L19:
        r7 = r2.intValue();
        goto L20
    L22:
        if (r0 == null) goto L26;
        r11.e.b r10 = r0.m4();
        if (r10 == null) goto L26;
        r2 = Integer.valueOf(r10.i());
    L26:
        r7 = r2.intValue();
        if (r7 > 0) goto L36;
        return 3;
    }
}
