package com.bytedance.android.anniex.monitor;

import a36.c;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.core.m;
import com.bytedance.ies.bullet.core.t;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.salamander.anniex.SLContainerTiming;
import com.bytedance.salamander.anniex.SLEndToEndErrorCode;
import com.bytedance.salamander.anniex.SLEndToEndStage;
import com.bytedance.salamander.anniex.SLEndToEndStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import i36.d;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import jz2.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MonitorManager {
    public static final Map<String, d> a = null;
    public static final Map<String, i36.a> b = null;
    public static final Map<String, d> c = null;
    public static final Map<String, i36.a> d = null;
    public static final Map<String, d> e = null;
    public static final Map<String, i36.a> f = null;
    public static final Map<String, AtomicInteger> g = null;
    public static final Lazy h = null;
    public static final Map<String, m> i = null;
    public static final Map<String, com.bytedance.android.anniex.monitor.b> j = null;
    public static final Lazy k = null;
    public static final CopyOnWriteArraySet<String> l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final boolean o = false;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AbsBulletMonitorCallback.ErrStage.values().length];
            r0[AbsBulletMonitorCallback.ErrStage.Container.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AbsBulletMonitorCallback.ErrStage.Plugin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AbsBulletMonitorCallback.ErrStage.RL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AbsBulletMonitorCallback.ErrStage.Engine.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MonitorManager() {
    }

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
        d = new LinkedHashMap();
        e = new LinkedHashMap();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        h = LazyKt.lazy(MonitorManager$monitorContextMap$2.INSTANCE);
        i = new LinkedHashMap();
        j = new LinkedHashMap();
        k = LazyKt.lazy(MonitorManager$handler$2.INSTANCE);
        l = new CopyOnWriteArraySet();
        m = LazyKt.lazy(MonitorManager$anniexVid$2.INSTANCE);
        n = LazyKt.lazy(MonitorManager$devtoolReportFunction$2.INSTANCE);
        Map r0 = x26.a.a;
        g r1 = (g) x26.a.a(g.class);
        if (r1 == null) goto L7;
        e r10 = (e) r1.n0(e.class);
        if (r10 == null) goto L7;
        boolean r11 = r10.L1();
    L8:
        o = r11;
        return;
    L7:
        r11 = true;
        goto L8
    }

    public static void A(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onPageStart$1$1(r10, r0));
    }

    public static void B(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        TraceEvent.beginSection("resource_load");
        TraceEvent.beginSection("download_template");
        SLMonitorCompat r11 = SLMonitorCompat.a;
        SLContainerTiming r12 = SLContainerTiming.PrepareTemplateStart;
        r11.getClass();
        SLMonitorCompat.g(r10, r12, r0);
        c0(r10, new MonitorManager$onPrepareTemplateBegin$1$1(r10, r0));
    }

    public static void C(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        SLMonitorCompat r11 = SLMonitorCompat.a;
        SLContainerTiming r12 = SLContainerTiming.PrepareTemplateEnd;
        r11.getClass();
        SLMonitorCompat.g(r10, r12, r0);
        c0(r10, new MonitorManager$onPrepareTemplateEnd$1$1(r10, r0));
        TraceEvent.endSection("download_template");
    }

    public static void D(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onRenderSSREnd$1$1(r10, r0));
    }

    public static void E(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onRenderSSRStart$1$1(r10, r0));
    }

    public static void F(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onRequestHydrateUrlEnd$1$1(r10, r0));
    }

    public static void G(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onRequestHydrateUrlStart$1$1(r10, r0));
    }

    public static void H(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onRequestSSRUrlEnd$1$1(r10, r0));
    }

    public static void I(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onRequestSSRUrlStart$1$1(r10, r0));
    }

    public static void J(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onSSRHydrateEnd$1$1(r10, r0));
    }

    public static void K(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onSSRHydrateStart$1$1(r10, r0));
    }

    public static void N(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onWebLoadEnd$1$1(r10, r0));
    }

    public static void Q(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        SLMonitorCompat r11 = SLMonitorCompat.a;
        SLContainerTiming r12 = SLContainerTiming.PrepareGlobalPropsEnd;
        r11.getClass();
        SLMonitorCompat.g(r10, r12, r0);
        c0(r10, new MonitorManager$onWebModelCreateEnd$1$1(r10, r0));
        TraceEvent.endSection("web_model_init");
    }

    public static void R(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onWebPageFinish$1$1(r10, r0));
    }

    public static void S(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onWebPageStart$1$1(r10, r0));
    }

    public static void W(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        if (h.z() == true) goto L5;
        return;
    L5:
        ExecutorService r0 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.a(r10, "anniex_vid", String.valueOf((String) m.getValue()));
    }

    public static void X(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        c0(r10, new MonitorManager$removeMonitorInfo$1(r10));
        CopyOnWriteArraySet<String> r0 = l;
        if (r0.contains(r10) == false) goto L6;
        sz2.e.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        sz2.e.d.post(new sz2.d(r10));
        r0.remove(r10);
        return;
    }

    public static final String a(AbsBulletMonitorCallback.ErrStage r1) {
        int r10 = a.a[r1.ordinal()];
        if (r10 != 1) goto L5;
        return "load_container_fail";
    L5:
        if (r10 != 2) goto L7;
        return "load_plugin_fail";
    L7:
        if (r10 == 3) goto L9;
        return "load_fail";
    L9:
        return "load_template_fail";
    }

    public static final void b(String r10) {
        if (c(r10).get() <= 2) goto L10;
        t r0 = (t) c36.a.a(r10).c(t.class);
        if (r0 == null) goto L11;
        int r1 = i36.e.a;
        JSONObject r11 = i36.e.a(d0(c, r10), d(d, r10));
        JSONObject r12 = i36.e.a(d0(a, r10), d(b, r10));
        r0.a(r11, r12);
        if (TraceEvent.enableTrace() == true) goto L12;
        r11.toString();
        r12.toString();
        return;
    L12:
        return;
    L11:
        return;
    }

    public static m b0(String r10) {
        Map<String, m> r0 = i;
        if (r0.containsKey(r10) == false) goto L5;
        Object r11 = ((LinkedHashMap) r0).get(r10);
        Intrinsics.checkNotNull(r11);
        return (m) r11;
    L5:
        m r1 = new m();
        r0.put(r10, r1);
        return r1;
    }

    public static AtomicInteger c(String r10) {
        Map<String, AtomicInteger> r0 = g;
        if (r0.containsKey(r10) == false) goto L5;
        Object r11 = ((LinkedHashMap) r0).get(r10);
        Intrinsics.checkNotNull(r11);
        return (AtomicInteger) r11;
    L5:
        AtomicInteger r1 = new AtomicInteger(0);
        r0.put(r10, r1);
        return r1;
    }

    public static k f(String r10) {
        if (h.d0() == false) goto L8;
        Map r0 = (Map) h.getValue();
        Object r1 = r0.get(r10);
        Object r11 = r1;
        if (r1 != null) goto L13;
        k r12 = new k(r10);
        r12.b = r10;
        r0.put(r10, r12);
        r11 = r12;
    L13:
        return (k) r11;
    L8:
        Lazy r13 = h;
        if (((Map) r13.getValue()).containsKey(r10) == false) goto L11;
        Object r14 = ((Map) r13.getValue()).get(r10);
        Intrinsics.checkNotNull(r14);
        return (k) r14;
    L11:
        k r15 = new k(r10);
        r15.b = r10;
        ((Map) r13.getValue()).put(r10, r15);
        return r15;
    }

    public static void j(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onFirstScreen$1$1(r10, r0));
    }

    public static void k(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onJsbRegisterBegin$1$1(r10, r0));
    }

    public static void l(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onJsbRegisterEnd$1$1(r10, r0));
    }

    public static void m(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        TraceEvent.beginSection("create_lynxview");
        c0(r10, new MonitorManager$onKitViewCreateBegin$1$1(r10, r0));
    }

    public static void r(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onLoadSuccess$1$1(r10, r0));
    }

    public static void t(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        SLMonitorCompat r11 = SLMonitorCompat.a;
        SLContainerTiming r12 = SLContainerTiming.PrepareGlobalPropsEnd;
        r11.getClass();
        SLMonitorCompat.g(r10, r12, r0);
        c0(r10, new MonitorManager$onLynxModelCreateEnd$1$1(r10, r0));
        TraceEvent.endSection("lynx_model_init");
    }

    public static void u(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onLynxReadTemplateBegin$1$1(r10, r0));
        TraceEvent.beginSection("read_template");
    }

    public static void x(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onLynxRenderTemplateBegin$1$1(r10, r0));
        TraceEvent.endSection("rl_to_render");
    }

    public static void y(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onLynxRenderTemplateEnd$1$1(r10, r0));
    }

    public static void O(final String r10, AnnieXCardScene r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "annieXCardScene");
        q(r10, r11);
        final long r0 = System.currentTimeMillis();
        c0(r10, new MonitorManager$onWebLoadStart$1$1(r10, r0));
        AnnieXFrequencyMonitor.c();
    }

    public static void T(final String r10, final m r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "rlContext");
        final long r0 = System.currentTimeMillis();
        SLMonitorCompat r12 = SLMonitorCompat.a;
        SLContainerTiming r13 = SLContainerTiming.PrepareTemplateEnd;
        r12.getClass();
        SLMonitorCompat.g(r10, r13, r0);
        c0(r10, new MonitorManager$onWebPrepareTemplateEnd$1$1(r10, r0, r11));
        TraceEvent.endSection("download_template");
    }

    public static void U(final String r1, final long r10) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        TraceEvent.beginSection("create_webview");
        c0(r1, new MonitorManager$onWebViewCreateBegin$1(r1, r10));
    }

    public static void Z(final String r1, final String r10) {
        Intrinsics.checkNotNullParameter(r1, "bid");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        c0(r10, new MonitorManager$reportEndToEndTraceWithSafeAction$1(r10, r1));
    }

    public static void c0(String r1, Function0 r10) {
        if (l.contains(r1) == true) goto L6;
        ((Handler) k.getValue()).post(new b(r10));
        return;
    }

    public static i36.a d(Map r1, String r10) {
        if (r1.containsKey(r10) == false) goto L5;
        Object r11 = ((LinkedHashMap) r1).get(r10);
        Intrinsics.checkNotNull(r11);
        return (i36.a) r11;
    L5:
        i36.a r0 = new i36.a();
        r1.put(r10, r0);
        return r0;
    }

    public static d d0(Map r1, String r10) {
        if (r1.containsKey(r10) == false) goto L5;
        Object r11 = ((LinkedHashMap) r1).get(r10);
        Intrinsics.checkNotNull(r11);
        return (d) r11;
    L5:
        d r0 = new d();
        r1.put(r10, r0);
        return r0;
    }

    public static void e(String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        if (r11 == null) goto L5;
        long r0 = r11.longValue();
    L6:
        d0(a, r10).c("open_time", Long.valueOf(r0));
        sz2.e.a.getClass();
        sz2.e.e(r10, "open_time", r0);
        SLMonitorCompat r12 = SLMonitorCompat.a;
        SLContainerTiming r13 = SLContainerTiming.OpenTime;
        r12.getClass();
        SLMonitorCompat.g(r10, r13, r0);
        return;
    L5:
        r0 = System.currentTimeMillis();
        goto L6
    }

    public static void e0(final String r1, final Uri r10) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "uri");
        c0(r1, new MonitorManager$updateUriIdentifier$1(r1, r10));
    }

    public static void g(final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        if (o == true) goto L5;
        return;
    L5:
        final boolean r0 = ((Boolean) SwitchCenter.d.getValue()).booleanValue();
        if (r0 == false) goto L15;
        SceneManager r1 = SceneManager.n;
        SceneManager r12 = SceneManager.a.a();
        a36.a r13 = f(r10).l;
        if (r13 == null) goto L13;
        Uri r14 = ((c) r13).a;
        if (r14 == null) goto L13;
        String r15 = r14.toString();
        if (r15 == null) goto L13;
    L14:
        r12.i(r10, r15);
    L13:
        r15 = r11;
    L15:
        c0(r10, new MonitorManager$onAttachToWindow$1(r0, r10, r11));
    }

    public static void h(final String r1, final String r10) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "viewType");
        c0(r1, new MonitorManager$onClientComponent$1(r1, r10));
    }

    public static void n(final AnnieXLynxView r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        final long r0 = System.currentTimeMillis();
        c0(r11, new MonitorManager$onKitViewCreateEnd$1$1(r11, r0, r10));
        TraceEvent.endSection("create_lynxview");
    }

    public static void q(final String r1, final AnnieXCardScene r10) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "annieXCardScene");
        c0(r1, new MonitorManager$onLoadStart$1(r10, r1));
    }

    public static void L(final String r1, final Map r10, final LynxDevtool r11) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        c0(r1, new MonitorManager$onTimingSetup$1(r1, r10, r11));
    }

    public static void P(final String r10, final String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        final long r13 = System.currentTimeMillis();
        TraceEvent.beginSection("web_model_init");
        SLMonitorCompat r0 = SLMonitorCompat.a;
        SLContainerTiming r1 = SLContainerTiming.PrepareGlobalPropsStart;
        r0.getClass();
        SLMonitorCompat.g(r11, r1, r13);
        SLMonitorCompat.c(r11, new MonitorManager$onWebModelCreateBegin$1$1(r10));
        if (Intrinsics.areEqual(r12, "AnnieXCard") == false) goto L5;
        SLMonitorCompat.c(r11, MonitorManager$onWebModelCreateBegin$1$2.INSTANCE);
        SLMonitorCompat.g(r11, SLContainerTiming.ContainerInitStart, r13);
        SLMonitorCompat.g(r11, SLContainerTiming.ContainerInitEnd, r13);
    L5:
        c0(r11, new MonitorManager$onWebModelCreateBegin$1$3(r11, r12, r10, r13));
    }

    public static void V(final SSWebView r1, final String r10, final long r11) {
        Intrinsics.checkNotNullParameter(r1, "webView");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        c0(r10, new MonitorManager$onWebViewCreateEnd$1(r10, r11, r1));
        TraceEvent.endSection("create_webview");
    }

    public static void Y(String r13, String r14, int r15) {
        String r0 = null;
        if ((r15 & 4) == 0) goto L5;
        r14 = null;
    L5:
        Map r16 = x26.a.a;
        g r17 = (g) x26.a.a(g.class);
        if (r17 == null) goto L10;
        e r18 = (e) r17.n0(e.class);
        if (r18 == null) goto L10;
        boolean r19 = r18.P();
    L11:
        if (r19 == false) goto L101;
        LinkedHashMap r110 = (LinkedHashMap) j;
        com.bytedance.android.anniex.monitor.b r10 = (com.bytedance.android.anniex.monitor.b) r110.get(r13);
        int r11 = 0;
        if (r10 != null) goto L16;
    L18:
        boolean r12 = false;
    L19:
        if (r12 == true) goto L102;
        com.bytedance.android.anniex.monitor.b r20 = (com.bytedance.android.anniex.monitor.b) r110.get(r13);
        if (r20 == null) goto L25;
        r20.b = true;
    L25:
        sz2.e.a.getClass();
        jz2.e r1 = sz2.e.h(r13);
        if (r1.c.a == UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain()) goto L28;
        o r21 = r1.c;
        r11 = r21.c;
        String r22 = r21.b;
    L36:
        m r23 = b0(r13);
        c1 r111 = new c1("bdx_monitor_end_to_end_trace", null, null, null, null, 254);
        r111.k = f(r13).l;
        JSONObject r24 = new JSONObject();
        com.bytedance.android.anniex.monitor.b r25 = (com.bytedance.android.anniex.monitor.b) r110.get(r13);
        if (r25 == null) goto L39;
        String r26 = r25.c;
    L40:
        com.bytedance.android.anniex.monitor.b r27 = (com.bytedance.android.anniex.monitor.b) r110.get(r13);
        if (r27 == null) goto L43;
        String r28 = r27.e;
    L44:
        r24.put("stage", r28);
        r24.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r26);
        r24.put("error_message", r22);
        r24.put("template_res_type", r23.b);
        r24.put("domain_error_code", r11);
        r111.d = r24;
        JSONObject r29 = new JSONObject();
        long r30 = d0(a, r13).b("open_time");
        if (r30 > 0) goto L48;
        r30 = System.currentTimeMillis();
    L48:
        r29.put("stay_duration", System.currentTimeMillis() - r30);
        r29.put("native_error_count", r1.e);
        r29.put("res_loader_error_count", r1.j);
        r29.put("res_loader_error_template_count", r1.j);
        r29.put("static_error_count", r1.f);
        r29.put("fetch_error_count", r1.g);
        r29.put("jsb_error_count", r1.h);
        r29.put("js_exception_error_count", r1.d);
        r111.e = r29;
        r111.m = r13;
        s26.d r31 = s26.d.c;
        r r32 = s26.d.c.d("default_bid", r.class);
        if (r32 == null) goto L51;
        r32.S(r111);
    L51:
        SLEndToEndStage r33 = SLEndToEndStage.Begin;
        SLEndToEndStatus r34 = SLEndToEndStatus.Cancel;
        if (r14 != null) goto L54;
        r14 = r22;
    L54:
        com.bytedance.android.anniex.monitor.b r112 = (com.bytedance.android.anniex.monitor.b) r110.get(r13);
        if (r112 == null) goto L57;
        String r113 = r112.e;
    L58:
        if (r113 != null) goto L60;
    L95:
        SLEndToEndErrorCode r35 = null;
        SLEndToEndStatus r114 = r34;
    L96:
        SLMonitorCompat r36 = SLMonitorCompat.a;
        if (r114 != SLEndToEndStatus.Fail) goto L99;
        r0 = r14;
    L99:
        r36.getClass();
        SLMonitorCompat.e(r13, r33, r114, r35, r0);
        return;
    L60:
        switch(r113.hashCode()) {
            case -1276235010: goto L92;
            case -1204309802: goto L88;
            case 93616297: goto L86;
            case 539994402: goto L83;
            case 937454741: goto L79;
            case 1069124650: goto L75;
            case 1389161175: goto L71;
            case 1697055311: goto L67;
            case 1710187946: goto L63;
            default: goto L95;
        };
    L86:
        r113.equals("begin");
        goto L95
    L63:
        if (r113.equals("load_success") == false) goto L95;
        r33 = SLEndToEndStage.LoadSuccess;
        goto L95
    L67:
        if (r113.equals("load_template_end") == false) goto L95;
        r33 = SLEndToEndStage.LoadTemplateEnd;
        goto L95
    L71:
        if (r113.equals("load_fail") == false) goto L95;
        r114 = SLEndToEndStatus.Fail;
        r33 = SLEndToEndStage.LoadFail;
        r35 = SLEndToEndErrorCode.EngineRenderFail;
        goto L96
    L75:
        if (r113.equals("load_template_fail") == false) goto L95;
        r114 = SLEndToEndStatus.Fail;
        r33 = SLEndToEndStage.LoadTemplateFail;
        r35 = SLEndToEndErrorCode.LoadTemplateFail;
        goto L96
    L79:
        if (r113.equals("load_container_fail") == false) goto L95;
        r114 = SLEndToEndStatus.Fail;
        r33 = SLEndToEndStage.LoadContainerFail;
        r35 = SLEndToEndErrorCode.LoadContainerFail;
        goto L96
    L83:
        if (r113.equals("load_engine_fail") == false) goto L95;
        r114 = SLEndToEndStatus.Fail;
        r33 = SLEndToEndStage.LoadEngineFail;
        r35 = SLEndToEndErrorCode.LoadEngineFail;
        goto L96
    L88:
        if (r113.equals("load_template_start") == false) goto L95;
        r33 = SLEndToEndStage.LoadTemplateStart;
        goto L95
    L92:
        if (r113.equals("data_update") == false) goto L95;
        r34 = SLEndToEndStatus.Success;
        r33 = SLEndToEndStage.DataUpdate;
        goto L95
    L57:
        r113 = null;
        goto L58
    L43:
        r28 = null;
        goto L44
    L39:
        r26 = null;
        goto L40
    L28:
        com.bytedance.android.anniex.monitor.b r37 = (com.bytedance.android.anniex.monitor.b) r110.get(r13);
        if (r37 == null) goto L31;
        r11 = r37.g;
    L31:
        com.bytedance.android.anniex.monitor.b r38 = (com.bytedance.android.anniex.monitor.b) r110.get(r13);
        if (r38 == null) goto L35;
        r22 = r38.f;
        if (r22 != null) goto L36;
    L35:
        r22 = "";
        goto L36
    L102:
        return;
    L16:
        if (r10.b != true) goto L18;
        r12 = true;
        goto L19
    L101:
        return;
    L10:
        r19 = true;
        goto L11
    }

    public static void i(final String r10, final String r11, final AbsBulletMonitorCallback.ErrStage r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "errStage");
        final String r1 = "open_dialog_fragment_with_no_activity";
        Intrinsics.checkNotNullParameter("open_dialog_fragment_with_no_activity", "errMessage");
        c0(r11, new MonitorManager$onContainerError$1(r11, r10, r12, r1));
    }

    public static void s(final String r10, final String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        final long r13 = System.currentTimeMillis();
        TraceEvent.beginSection("lynx_model_init");
        SLMonitorCompat r0 = SLMonitorCompat.a;
        SLContainerTiming r1 = SLContainerTiming.PrepareGlobalPropsStart;
        r0.getClass();
        SLMonitorCompat.g(r11, r1, r13);
        SLMonitorCompat.c(r11, new MonitorManager$onLynxModelCreateBegin$1$1(r10));
        if (Intrinsics.areEqual(r12, "AnnieXCard") == false) goto L5;
        SLMonitorCompat.g(r11, SLContainerTiming.ContainerInitStart, r13);
        SLMonitorCompat.g(r11, SLContainerTiming.ContainerInitEnd, r13);
        SLMonitorCompat.c(r11, MonitorManager$onLynxModelCreateBegin$1$2.INSTANCE);
    L5:
        c0(r11, new MonitorManager$onLynxModelCreateBegin$1$3(r11, r12, r10, r13));
    }

    public static void z(final String r10, final String r11, final AnnieXCardScene r12) {
        Intrinsics.checkNotNullParameter(r10, "originalSessionId");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "annieXCardScene");
        final long r13 = System.currentTimeMillis();
        c0(r11, new MonitorManager$onLynxViewReused$1$1(r11, r12, r10, r13));
    }

    public static void M(final String r1, final Map r10, final Map r11, final String r12) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        c0(r1, new MonitorManager$onTimingUpdate$1(r1, r10, r11, r12));
    }

    public static /* synthetic */ void w(String r10, p r11, String r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r12 = "userInput";
    L5:
        v(r10, r11, r12, 0, 0.0d);
    }

    public static void o(final String r10, final String r11, final AbsBulletMonitorCallback.ErrStage r12, final String r13, final SSWebView r14) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "errStage");
        Intrinsics.checkNotNullParameter(r13, "errMessage");
        if (TraceEvent.enableTrace() == true) goto L5;
        Objects.toString(r12);
    L5:
        c0(r11, new MonitorManager$onLoadFail$4(r11, r12, r13, r10, r14));
    }

    public static void p(final String r10, final String r11, final AbsBulletMonitorCallback.ErrStage r12, final String r13, final LynxView r14) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "errStage");
        Intrinsics.checkNotNullParameter(r13, "errMessage");
        if (TraceEvent.enableTrace() == true) goto L5;
        Objects.toString(r12);
    L5:
        c0(r11, new MonitorManager$onLoadFail$2(r11, r12, r13, r10, r14));
    }

    public static void v(final String r12, final p r13, final String r14, final long r15, final double r17) {
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "customResFrom");
        final long r10 = System.currentTimeMillis();
        c0(r12, new MonitorManager$onLynxReadTemplateEnd$1$1(r13, r12, r10, r14, r15, r17));
        TraceEvent.endSection("read_template");
        TraceEvent.endSection("resource_load");
        TraceEvent.beginSection("rl_to_render");
    }

    public static void a0(final String r10, boolean r11, Function1 r12, KitType r13, boolean r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        final boolean r16 = false;
    L7:
        if ((r15 & 4) == 0) goto L9;
        r12 = null;
    L9:
        final Function1 r17 = r12;
        if ((r15 & 8) == 0) goto L12;
        r13 = KitType.LYNX;
    L12:
        final KitType r18 = r13;
        if ((r15 & 16) == 0) goto L15;
        final boolean r19 = true;
    L16:
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r18, "kitType");
        c0(r10, new MonitorManager$reportInfo$1(r10, r19, r16, r18, r17));
        return;
    L15:
        r19 = r14;
        goto L16
    L5:
        r16 = r11;
        goto L7
    }
}
