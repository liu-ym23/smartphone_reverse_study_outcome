package com.bytedance.ai.model;

import android.content.Context;
import android.util.LruCache;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.worker.WorkerType;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.resource.e0;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/core/base/f;", "Landroidx/lifecycle/LifecycleOwner;", "com/bytedance/ai/model/i", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppletRuntime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppletRuntime.kt\ncom/bytedance/ai/model/AppletRuntime\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 ExtentionFunc.kt\ncom/bytedance/ai/utils/ExtentionFuncKt\n*L\n1#1,1001:1\n1#2:1002\n295#3,2:1003\n295#3,2:1005\n1863#3,2:1007\n1863#3,2:1009\n216#4,2:1011\n238#5:1013\n*S KotlinDebug\n*F\n+ 1 AppletRuntime.kt\ncom/bytedance/ai/model/AppletRuntime\n*L\n546#1:1003,2\n609#1:1005,2\n852#1:1007,2\n274#1:1009,2\n356#1:1011,2\n105#1:1013\n*E\n"})
public abstract class AppletRuntime extends com.bytedance.ai.core.base.f implements LifecycleOwner {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f2195w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f2196x = 0;
    public final Context g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Applet f2197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f2198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f2199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f2200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final kotlinx.coroutines.s f2201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f2202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f2203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LifecycleRegistry f2204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f2205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap f2206q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinkedHashMap f2207r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap f2208t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Timer f2209u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l f2210v;

    static {
        new AtomicInteger(0);
        f2195w = ((long) 5) * 1000;
    }

    public AppletRuntime(Context r5, Applet r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "app");
        Intrinsics.checkNotNullParameter(r10, "applet");
        this.g = r5;
        this.f2197h = r10;
        this.f2198i = r11;
        boolean r12 = false;
        this.f2199j = new AtomicBoolean(false);
        this.f2200k = new AtomicBoolean(false);
        Boolean r13 = Boolean.FALSE;
        kotlinx.coroutines.s r14 = new kotlinx.coroutines.s(null);
        r14.N(r13);
        this.f2201l = r14;
        this.f2202m = "";
        this.f2203n = new ArrayList();
        this.f2204o = new LifecycleRegistry(this);
        this.f2205p = new AtomicBoolean(false);
        this.f2206q = new ConcurrentHashMap();
        this.f2207r = new LinkedHashMap();
        String r15 = r10.f2268o;
        int r16 = r15.hashCode();
        if (r16 == 3337239) goto L18;
        if (r16 == 108397200) goto L14;
        if (r16 == 1224424441) goto L10;
    L19:
        RenderType[] r17 = RenderType.f2230a;
    L21:
        this.f2208t = new ConcurrentHashMap();
        r10.g();
        z2.d.e("applet_init_js_worker_start", new sj.k(this, r12));
        return;
    L10:
        if (r15.equals("webview") == false) goto L19;
        RenderType[] r18 = RenderType.f2230a;
        goto L21
    L14:
        if (r15.equals("relax") == false) goto L19;
        RenderType[] r19 = RenderType.f2230a;
        goto L21
    L18:
        if (r15.equals("lynx") == false) goto L19;
        RenderType[] r20 = RenderType.f2230a;
        goto L21
    }

    @Override // m2.a
    public final m3.a d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r10 == true) goto L5;
        LinkedHashMap r11 = this.f2207r;
        m3.a r12 = (m3.a) r11.get(r5);
        if (r12 != null) goto L14;
        com.bytedance.ai.model.widgets.o r13 = new com.bytedance.ai.model.widgets.o(r5, 1);
        r11.put(r5, r13);
        return r13;
    L14:
        return r12;
    L5:
        if (this.f2204o.getCurrentState() != Lifecycle.State.DESTROYED) goto L7;
        return null;
    L7:
        return av.i.d(this, r5);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f2204o;
    }

    @Override // com.bytedance.ai.core.base.d
    public void j() {
        v();
    }

    public final com.bytedance.ai.core.base.g k(String r10, String r11, SessionType r12) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        ConcurrentHashMap r5 = this.f2206q;
        com.bytedance.ai.core.base.g r13 = (com.bytedance.ai.core.base.g) r5.get(r10);
        if (r13 == null) goto L8;
        String r14 = "bindSession(" + r13.f2094a + ") has one --> " + r13.f2095b;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L22;
        r15.i("WorkerRuntime", r14);
    L22:
        r5.putIfAbsent(r10, r13);
        if ((r13 instanceof com.bytedance.ai.core.base.a) == false) goto L30;
        if (r11 != null) goto L26;
    L29:
        ((com.bytedance.ai.core.base.a) r13).getClass();
        goto L30
    L26:
        if (r11.length() == 0) goto L29;
        return r13;
    L30:
        return r13;
    L8:
        if (Intrinsics.areEqual(r10, "SYSTEM_CVS_ID") == true) goto L10;
    L12:
        String r16 = "bindSession(" + r10 + ") create one --> " + r12;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L15;
        r17.i("WorkerRuntime", r16);
    L15:
        int r18 = j.f2248a[r12.ordinal()];
        if (r18 != 1) goto L18;
        r13 = com.bytedance.ai.core.base.b.d;
        goto L22
    L18:
        if (r18 == 2) goto L20;
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        com.bytedance.ai.core.base.a r19 = new com.bytedance.ai.core.base.a(r10, SessionType.f2087a);
        r19.d = true;
        i();
        r13 = r19;
        goto L22
    L20:
        r13 = com.bytedance.ai.core.base.e.d;
        goto L22
    L10:
        if (r12 != SessionType.f2087a) goto L12;
        r12 = SessionType.f2089c;
        goto L12
    }

    public final void l(long r5, boolean r10) {
        if (r5 < 0) goto L32;
        l r11 = this.f2210v;
        if (r11 == null) goto L8;
        r11.cancel();
    L8:
        this.f2210v = null;
        Timer r12 = this.f2209u;
        if (r12 == null) goto L11;
        r12.cancel();
    L11:
        this.f2209u = null;
        AtomicBoolean r13 = this.f2205p;
        Applet r14 = this.f2197h;
        if (r10 == false) goto L14;
        this.f2209u = new Timer();
        this.f2210v = new l(this, 0);
        if (r13.get() == true) goto L27;
        r13.set(true);
        i();
        String r15 = ug.a.c(new StringBuilder(), r14.F, " set alive", "WorkerRuntime");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L27;
        r16.d("WorkerRuntime", r15);
    L27:
        Timer r17 = this.f2209u;
        if (r17 == null) goto L31;
        r17.schedule(this.f2210v, r5 * ((long) 1000));
        return;
    L31:
        return;
    L14:
        if (r13.get() == false) goto L33;
        r13.set(false);
        String r18 = ug.a.c(new StringBuilder(), r14.F, " cancel alive", "WorkerRuntime");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L19;
        r19.d("WorkerRuntime", r18);
    L19:
        h();
        return;
    L33:
        return;
    }

    public abstract void m(com.bytedance.ai.bridge.method.net.e r5);

    public final void o(PageInfo r15, Function3 r16) {
        Intrinsics.checkNotNullParameter(r15, "pageInfo");
        Map<String, Object> r5 = r15.getTraceInfo();
        if (r5 == null) goto L8;
        Object r10 = r5.get("trace_id");
        if (r10 == null) goto L8;
        String r11 = r10.toString();
        if (r11 == null) goto L8;
    L9:
        Map<String, Object> r12 = r15.getTraceInfo();
        if (r12 == null) goto L15;
        Object r13 = r12.get("eventName");
        if (r13 == null) goto L15;
        String r14 = r13.toString();
        if (r14 == null) goto L15;
    L16:
        if (r11 == null) goto L19;
        if (r14 == null) goto L19;
        b3.p r17 = b3.h.f841a;
        Intrinsics.checkNotNullParameter(r11, "traceId");
        b3.h.c(new a3.b(r11, System.currentTimeMillis(), 22));
    L19:
        String r18 = r15.getPageUrl();
        Applet r19 = this.f2197h;
        boolean r20 = true;
        if (r18 != null) goto L22;
    L24:
        String r21 = r15.getPageName();
        if (r21 != null) goto L27;
        String r22 = null;
    L43:
        if (r22 != null) goto L52;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L47;
        r23.e("WorkerRuntime", "createWebViewPopupPage find App null");
    L47:
        if (r11 == null) goto L50;
        if (r14 == null) goto L50;
        b3.p r24 = b3.h.f841a;
        AppletErrorCode r25 = AppletErrorCode.f2378b;
        b3.h.a(104, r11, "createWebViewPopupPage find App null", r14);
    L50:
        r16.invoke(null, Boolean.FALSE, "createWebViewPopupPage find App null");
        return;
    L52:
        String r26 = r15.getPageData();
        Lazy r27 = v0.e.f;
        v0.e r28 = com.bytedance.android.anniex.base.service.f.g();
        r28.getClass();
        Intrinsics.checkNotNullParameter(r19, "applet");
        Intrinsics.checkNotNullParameter(r15, "pageInfo");
        PageType r110 = r15.getPageType();
        PageType r111 = PageType.FLOATING_VIEW;
        if (r110 != r111) goto L83;
        String r112 = wn.h.f(r19, r15);
        RenderType[] r113 = RenderType.f2230a;
        if (Intrinsics.areEqual(r112, "lynx") == true) goto L80;
        Intrinsics.checkNotNullParameter(r19, "applet");
        Intrinsics.checkNotNullParameter(r15, "pageInfo");
        if (r15.getPageType() != r111) goto L83;
        Lazy r29 = v0.d.f22502n;
        if (cl.a.h().s() == false) goto L83;
        String r30 = r15.getPageName();
        w0.k r31 = v0.e.n();
        if (r31 == null) goto L67;
        PageInfo r32 = ((com.bytedance.ai.model.widgets.a) r31).f2330b;
        if (r32 == null) goto L67;
        String r33 = r32.getPageName();
    L69:
        if (Intrinsics.areEqual(r30, r33) == false) goto L71;
        String r34 = "already hasFloatingView " + r15.getPageName();
        Intrinsics.checkNotNullParameter(r34, "errorMsg");
        r16.invoke(null, Boolean.FALSE, r34);
        Unit r35 = Unit.INSTANCE;
    L79:
        r20 = false;
        goto L83
    L71:
        w0.k r36 = v0.e.n();
        if (r36 == null) goto L76;
        String r37 = ((com.bytedance.ai.model.widgets.a) r36).f2331c;
        if (r37 == null) goto L76;
        boolean r38 = r28.o(r37);
    L77:
        if (r38 == true) goto L83;
        Intrinsics.checkNotNullParameter("hasFloatingView and close current floating failed", "errorMsg");
        r16.invoke(null, Boolean.FALSE, "hasFloatingView and close current floating failed");
        Unit r39 = Unit.INSTANCE;
    L76:
        r38 = false;
    L67:
        r33 = null;
        goto L69
    L80:
        String r40 = r15.getPageName();
        if (r40 == null) goto L83;
        String r41 = r15.getPackageName();
        Intrinsics.checkNotNullParameter(r40, "pageName");
        Intrinsics.checkNotNullParameter(r41, "packageName");
    L83:
        if (r20 == false) goto L108;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L88
        com.bytedance.ai.model.widgets.a r43 = wn.h.c(this, r15);     // Catch: Throwable -> L88
        if (r43 == null) goto L90;
        wn.h.d(r43);     // Catch: Throwable -> L88
    L91:
        Object r44 = Result.m124constructorimpl(r43);     // Catch: Throwable -> L88
    L95:
        if (Result.m130isFailureimpl(r44) == false) goto L97;
        r44 = null;
    L97:
        w0.f r45 = (w0.f) r44;
        if (r45 != null) goto L101;
        r16.invoke(null, Boolean.FALSE, "create page failed, check renderType first");
        return;
    L101:
        Lazy r46 = p.f2292a;
        BuildersKt.launch$default(h0.a(t2.b.d), null, null, new AppletRuntime$createPage$1(r45, r15, r26, r22, r16, null), 3, null);
        return;
    L90:
        r43 = null;
    L88:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r44 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L95
    L108:
        return;
    L27:
        String r114 = r15.getPackageName();
        List r115 = r19.G;
        if (r115 == null) goto L39;
        Iterator r116 = r115.iterator();
    L31:
        if (r116.hasNext() == false) goto L35;
        Object r117 = r116.next();
        if (Intrinsics.areEqual(((Page) r117).pageId(), r21) == false) goto L31;
    L36:
        Page r118 = (Page) r117;
        if (r118 == null) goto L39;
        String r119 = r118.getEntry();
    L40:
        if (r119 == null) goto L42;
        LruCache r48 = e0.f2711a;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        Intrinsics.checkNotNullParameter(r119, "filePath");
        r22 = e0.c(r19, r119);
        goto L43
    L42:
        r22 = (String) BuildersKt.runBlocking$default(null, new AppletRuntime$realUrl$1(r114, r21, r15, null), 1, null);
        goto L43
    L35:
        r117 = null;
    L39:
        r119 = null;
        goto L40
    L22:
        if (StringsKt.P(r18, "http") != true) goto L24;
        r22 = r15.getPageUrl();
    L15:
        r14 = null;
    L8:
        r11 = null;
        goto L9
    }

    @Override // w0.k
    public final void onMessageToAIBridge(final String r5, final JsonObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        final m1.i r11 = r();
        if (r11 == null) goto L6;
        t().d(new b(r11, r5, r10));
        return;
    }

    public final void p(String r12, String r13) {
        if (r12 == null) goto L14;
        if (r13 == null) goto L14;
        b3.p r5 = b3.h.f841a;
        Intrinsics.checkNotNullParameter(r12, "traceId");
        Intrinsics.checkNotNullParameter(r13, "eventType");
        long r10 = System.currentTimeMillis();
        String r11 = com.lynx.tasm.utils.b.j("onLoadMainJSStart: ", r12, ", ", r13);
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L8;
        r14.d("AppletEventMonitorManager", r11);
    L8:
        if (Intrinsics.areEqual(r13, "applet_widget_timeline_full") == false) goto L11;
        b3.h.c(new a3.b(r12, r10, 23));
        goto L14
    L11:
        if (Intrinsics.areEqual(r13, "applet_page_timeline_full") == false) goto L14;
        b3.h.c(new a3.b(r12, r10, 24));
    L14:
        if (s() != WorkerType.f2373a) goto L16;
        boolean r15 = true;
    L17:
        Applet r16 = this.f2197h;
        g r17 = new g(this, r15, r12, r13);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "callback");
        com.bytedance.ai.utils.c.n("begin to load main.js from gecko");
        z2.d.e("applet_load_main_js", new ug.e(r16.i(), 12));
        LruCache r18 = e0.f2711a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        String r19 = r16.K;
        if (r19 != null) goto L20;
    L23:
        if (r15 == false) goto L25;
        String r110 = "main.rasm";
    L26:
        String r111 = r16.F + '/' + r110;
    L28:
        if (ym.h.a(r16.f2261h, "3.0") < 0) goto L52;
        String r20 = e0.l(r111);
        Intrinsics.checkNotNullParameter(r16.f2259b, "appletName");
        if (r16.A == true) goto L32;
        String r112 = e0.f(r16.f2259b, r16.F, "base_" + r16.f2260c, r20, r16.f2260c, null);
    L53:
        e0.k(r16.f2276x, r112, new n(r15, r17, r112), new com.bytedance.ai.model.widgets.d(15, r17, r112), !r15);
        return;
    L32:
        if (com.bytedance.ai.utils.c.l("") == false) goto L34;
        r112 = e0.b(r16.f2260c, td.d.b("/", r20));
        goto L53
    L34:
        String r21 = "base_" + r16.f2260c;
        String r113 = r16.f2259b;
        com.bytedance.ai.multiprocess.a r114 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r114 != null) goto L37;
    L49:
        String r115 = null;
    L50:
        r112 = e0.f(r16.f2259b, r16.F, r21, r20, r16.f2260c, r115);
        goto L53
    L37:
        if (r114.f2402c == false) goto L40;
    L47:
        r115 = e0.e(r16.f2259b, r20);
        goto L50
    L40:
        if (r114.f2402c == true) goto L49;
        if (r113 == null) goto L49;
        if (r113.length() == 0) goto L49;
        if (r114.d.contains(r113) == false) goto L49;
    L52:
        r112 = e0.c(r16, r111);
        goto L53
    L25:
        r110 = "main.js";
        goto L26
    L20:
        if (r19.length() == 0) goto L23;
        r111 = r16.K;
        goto L28
    L16:
        r15 = false;
        goto L17
    }

    public final void q(String r5) {
        if (r5 != null) goto L4;
        String r10 = this.f2197h.I;
    L5:
        ConcurrentHashMap r11 = o2.a.f20402a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() != 0) goto L8;
        String r12 = null;
    L9:
        if (r12 == null) goto L16;
        k(r12, r5, SessionType.f2087a).getClass();
        t0.b r13 = p.f2294c;
        if (r13 == null) goto L15;
        r13.onAppletPayloadChanged(r12, r10);
        return;
    L15:
        return;
    L16:
        return;
    L8:
        r12 = (String) o2.a.f20402a.get(r10);
        goto L9
    L4:
        r10 = r5;
        goto L5
    }

    public abstract m1.i r();

    public abstract WorkerType s();

    public abstract y2.e t();

    public abstract void u();

    public final void v() {
        this.f2199j.set(false);
        this.f2200k.set(true);
        HashSet r5 = i.f2247a;
        Intrinsics.checkNotNullParameter(this, "runtime");
        i.f2247a.remove(this);
        this.f2208t.clear();
        Iterator r10 = this.f2207r.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L25;
        ((m3.a) r10.next()).a().a();
        goto L4
    L25:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        t().a();     // Catch: Throwable -> L8
        Object r12 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m127exceptionOrNullimpl(r12);
        if (r13 == null) goto L15;
        String r14 = "exception when jsWorker is terminated. " + r13;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L15;
        r15.e("WorkerRuntime", r14);
    L15:
        Applet r16 = this.f2197h;
        r16.h();
        Intrinsics.checkNotNullParameter("onDestroy", "eventName");
        m1.i r17 = r();
        if (r17 == null) goto L18;
        r17.e("onDestroy", null);
    L18:
        com.bytedance.ai.utils.c.g(this.f2204o, Lifecycle.Event.ON_DESTROY);
        m1.i r18 = r();
        if (r18 == null) goto L21;
        r18.g();
    L21:
        String r19 = "AppletRuntime is terminated. appletId; " + r16.i();
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L27;
        r20.i("WorkerRuntime", r19);
        return;
    L27:
        return;
    L8:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
