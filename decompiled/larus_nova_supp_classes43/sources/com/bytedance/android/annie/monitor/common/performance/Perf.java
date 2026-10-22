package com.bytedance.android.annie.monitor.common.performance;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.ng.g;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Single;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class Perf implements c {
    public static final Perf a = null;
    public static final Map<String, d> b = null;
    public static final Rect c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static volatile boolean f;
    public static final AtomicInteger g = null;
    public static final Lazy h = null;

    public Perf() {
    }

    static {
        a = new Perf();
        b = new ConcurrentHashMap();
        c = new Rect();
        d = LazyKt.lazy(Perf$workThread$2.INSTANCE);
        e = LazyKt.lazy(Perf$workerHandler$2.INSTANCE);
        g = new AtomicInteger();
        h = LazyKt.lazy(Perf$config$2.INSTANCE);
    }

    public static final JSONObject f() {
        JSONObject r0 = new JSONObject();
        m9.c r1 = (m9.c) Annie.getService$default(m9.c.class, null, 2, null);
        r0.put("cpu_rate", r1.getCpuRate());
        r0.put("cpu_speed", r1.getCpuSpeed());
        return r0.put("temperature", Float.valueOf(r1.getTemperature()));
    }

    public static com.bytedance.android.annie.service.setting.a i() {
        return (com.bytedance.android.annie.service.setting.a) h.getValue();
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void e() {
        h(Perf$startMonitorFPS$1.INSTANCE);
    }

    public static void h(Function0 r10) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L5;
        r10.invoke();
        return;
    L5:
        Single.fromCallable(new e.a(r10)).subscribeOn(Schedulers.single()).subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
    }

    public static void j(String r10) {
        if (g.g == true) goto L5;
    L7:
        int r0 = x8.a.a;
        x8.a.d("AnniePerformanceMonitor", "thread = " + ThreadMethodProxy.currentThread() + " : " + r10, false);
        return;
    L5:
        if (g.b().a.a == false) goto L7;
        Objects.toString(ThreadMethodProxy.currentThread());
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageUrl");
        String r11 = e.a(r10);
        ConcurrentHashMap r0 = (ConcurrentHashMap) b;
        j("onPageLeave() looping=" + f + ", pages.size=" + r0.size() + ", evict=" + ((d) r0.remove(r11)) + ", url=" + r11);
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void b(final String r10, final String r11, final String r12) {
        h(new Perf$afterOpen$1(r10, r11, r12));
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void d(final String r10, final String r11, final String r12) {
        h(new Perf$beforeOpen$1(r10, r11, r12));
    }

    public static final void g(final String r10, final String r11, final WeakReference r12, final String r13) {
        StringBuilder r0 = new StringBuilder("loop fps: looping=");
        r0.append(f);
        r0.append(", view=");
        View r1 = (View) r12.get();
        if (r1 == null) goto L5;
        Integer r14 = Integer.valueOf(r1.hashCode());
    L6:
        r0.append(r14);
        r0.append(", url=");
        r0.append(e.a(r10));
        j(r0.toString());
        if (((ConcurrentHashMap) b).isEmpty() == false) goto L10;
        return;
    L10:
        if (f == true) goto L12;
        f = true;
        g.set(0);
        ((m9.c) Annie.getService$default(m9.c.class, null, 2, null)).c1("annie_cyclic_fps");
        ((Handler) e.getValue()).postDelayed(new Perf$loopMonitorFPS$1(r10, r11, r13, r12), Math.max(2000, i().a));
        return;
    L12:
        if (i().d() == 0) goto L18;
        AtomicInteger r15 = g;
        if (r15.incrementAndGet() <= i().d()) goto L19;
        JSONObject r16 = new JSONObject();
        r16.put("type", "dead-loop");
        r16.put("count", r15.get());
        Unit r17 = Unit.INSTANCE;
        k(null, null, r16, "event_annie_perf_runtime_status", 0, r13);
        i().f();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.monitor.common.performance.c
    public final void c(final String r10, final String r11, final AnnieCard r12, final String r13) {
        Intrinsics.checkNotNullParameter(r10, "pageUrl");
        Intrinsics.checkNotNullParameter(r12, "view");
        final int r14 = r12.hashCode();
        h(new Perf$stopMonitorFPS$1(r10, r14, r11, r13, r12));
    }

    public static /* synthetic */ void l(String r10, String r11, JSONObject r12, String r13, String r14) {
        k(r10, r11, r12, r13, i().e(), r14);
    }

    public static void k(String r14, String r15, JSONObject r16, String r17, int r18, String r19) {
        j("report: metric=" + r16 + ", event=" + r17 + ", url=" + r14);
        int r10 = 0;
        if (r15 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        String r12 = "88888";
        if (r11 == false) goto L24;
        j9.b r13 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r20 = new JSONObject();
        r20.put("engine_type", IHybridComponent.HybridType.H5.toMonitorString());
        Unit r110 = Unit.INSTANCE;
        JSONObject r111 = new JSONObject();
        com.bytedance.android.annie.ng.a r1 = g.c.get(r19);
        if (r1 == null) goto L19;
        o8.f r21 = r1.b;
        if (r21 == null) goto L19;
        String r22 = r21.a;
        if (r22 == null) goto L19;
        r12 = r22;
    L19:
        r111.put("virtual_aid", r12);
        if (g.b().a.a == false) goto L22;
        int r112 = 0;
    L23:
        j9.b.a.a(r13, null, r17, r14, r20, r16, null, r111, r112, 256);
        return;
    L22:
        r112 = r18;
        goto L23
    L24:
        int r23 = j9.c.a;
        JSONObject r113 = new JSONObject();
        r113.put("engine_type", r15);
        Unit r24 = Unit.INSTANCE;
        JSONObject r114 = new JSONObject();
        com.bytedance.android.annie.ng.a r25 = g.c.get(r19);
        if (r25 == null) goto L32;
        o8.f r26 = r25.b;
        if (r26 == null) goto L32;
        String r27 = r26.a;
        if (r27 == null) goto L32;
        r12 = r27;
    L32:
        r114.put("virtual_aid", r12);
        if (g.b().a.a == true) goto L36;
        r10 = r18;
    L36:
        Intrinsics.checkNotNullParameter(r15, "engineType");
        if (Intrinsics.areEqual(r15, "lynx") == false) goto L39;
        ((l9.b) Annie.getService$default(l9.b.class, null, 2, null)).g(null, r17, r14, r113, r16, r114, r10);
        return;
    L39:
        ((n9.b) Annie.getService$default(n9.b.class, null, 2, null)).g(null, r17, r14, r113, r16, r114, r10);
        return;
    L5:
        if (StringsKt.isBlank(r15) == true) goto L8;
        r11 = false;
        goto L9
    }
}
