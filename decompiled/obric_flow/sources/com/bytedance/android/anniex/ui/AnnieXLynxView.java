package com.bytedance.android.anniex.ui;

import ai.j0;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.m;
import com.bytedance.android.anniex.lite.container.h;
import com.bytedance.android.anniex.monitor.AnnieXCardScene;
import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.crash.Npth;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.t;
import com.bytedance.forest.model.w;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.ies.bullet.forest.r;
import com.bytedance.ies.bullet.forest.u;
import com.bytedance.ies.bullet.lynx.init.d;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback$ErrStage;
import com.bytedance.ies.bullet.ui.common.Orientation;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.v0;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.l0;
import com.lynx.tasm.o0;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.j;
import com.lynx.tasm.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wc.g;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public final class AnnieXLynxView extends LynxView {
    public static final /* synthetic */ int s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.sdk.xbridge.cn.platform.lynx.a f3466c;
    public g4.a d;
    public WeakReference e;
    public final b f;
    public final b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Scenes f3469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f3470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Orientation f3471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3473n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3475p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a0 f3476q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3477r;

    public AnnieXLynxView(FragmentActivity r5, String r10, String r11, l0 r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "builder");
        super(r5, r12);
        this.f3464a = "";
        this.f3465b = "";
        this.f3468i = "";
        this.f3469j = Scenes.f;
        this.f3470k = new LinkedHashMap();
        this.f3471l = Orientation.f6193a;
        this.f3472m = 1.0f;
        this.f3473n = true;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "bid");
        TraceEvent.c("AnnieXLynxView:init_block");
        if (TraceEvent.f10115c == true) goto L5;
        Log.d("AnnieXLynxView===", "===init===: " + this);
    L5:
        this.f3464a = r10;
        this.f3465b = r11;
        if (Intrinsics.areEqual("Loki", r11) == true) goto L8;
        b r13 = new b(this, r10, r11);
        this.f = r13;
        super.addLynxViewClient(r13);
        b r14 = new b(this, r10, r11);
        this.g = r14;
        Intrinsics.checkNotNull(r14);
        setAsyncImageInterceptor(new android.support.v4.media.c(r14));
        super.addLynxViewClient(getAirSolutionLynxViewClient());
    L8:
        TraceEvent.a(0, "AnnieXLynxView:init_block");
    }

    public static final void e(AnnieXLynxView r5) {
        LinkedHashMap r10 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.H(r5.f3464a);
        jm.c.g(r5.f3465b, r5.f3466c);
        LinkedHashMap r11 = cd.a.f1171a;
        cd.a.c(r5.f3464a);
        b r12 = r5.f;
        if (r12 == null) goto L5;
        r5.removeLynxViewClient(r12);
    L5:
        r5.setAsyncImageInterceptor(null);
        r5.f3470k.clear();
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r13 = r5.f3466c;
        if (r13 == null) goto L8;
        r13.r();
    L8:
        String r14 = r5.f3474o;
        if (r14 == null) goto L11;
        d.d(r14);
    L11:
        super.destroy();
    }

    public static final void f(final AnnieXLynxView r12, final b4.c r13, final LynxLoadMode r14, final h r15) {
        r12.getClass();
        p();
        zm.c r5 = f.f5397a;
        String r10 = r13.f860b.toString();
        Scene r11 = Scene.f4345a;
        g r16 = new g("");
        String r17 = r13.f859a;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.f22839h = r17;
        String r18 = r13.f861c;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.f22838c = r18;
        r16.f22852v = false;
        r16.f22851u = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Accept-Engine-Version", LynxEnv.inst().getSSRApiVersion()), TuplesKt.to("X-Lynx-Ssr-Accept-Type", "binary_v1")});
        String r19 = r13.f860b.getQueryParameter("dynamic");
        if (r19 == null) goto L5;
        Integer r20 = StringsKt.toIntOrNull(r19);
    L6:
        r16.d = r20;
        Unit r21 = Unit.INSTANCE;
        String r22 = r13.f861c;
        com.bytedance.ies.bullet.forest.h r23 = new com.bytedance.ies.bullet.forest.h(r13.f, r22, false, false, 28);
        Function1<com.bytedance.forest.postprocessor.g, Unit> r24 = new AnnieXLynxView$requestLynxSSRData$2(r12, r13, r14, r15);
        f.d(r10, "ttnet", r11, r13.f, r16, r23, null, r24, 321);
        return;
    L5:
        r20 = null;
        goto L6
    }

    public static final void g(AnnieXLynxView r20, b4.c r21, TemplateBundle r22, LynxLoadMode r23, h r24) {
        r20.getClass();
        LinkedHashMap r5 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.F(r21.f);
        String r10 = r21.f;
        com.bytedance.android.anniex.monitor.c.G(r10);
        com.bytedance.android.anniex.monitor.c.B(r10);
        if (r24 == null) goto L5;
        Intrinsics.checkNotNullParameter("externalTemplateBundle", "resFrom");
    L5:
        com.bytedance.android.anniex.monitor.c.h(r10, null, "externalTemplateBundle", 0, 0.0d);
        r20.setNpthLastUrl(r21.f859a);
        int r11 = 0;
        TemplateData r17 = r20.b(r21, "externalTemplateBundle", null, false);
        if (r21.f865k == true) goto L8;
    L12:
        String r13 = r21.f859a;
        x r12 = new x(r13, null, r22, null, r17, r23, r11);
        com.bytedance.android.anniex.monitor.c.C(r10);
        r20.loadTemplate(r12);
        com.bytedance.android.anniex.monitor.c.D(r10);
        return;
    L8:
        if (r22.d() == false) goto L12;
        if (r22.c() == true) goto L12;
        r11 = 2;
        goto L12
    }

    private final o0 getAirSolutionLynxViewClient() {
        return new j4.b(new AnonymousClass1(this), new AnonymousClass2(this));
    }

    public static final void h(AnnieXLynxView r10, b4.c r11, rb.b r12, h r13, AnnieXCardScene r14) {
        boolean r5 = Intrinsics.areEqual(r10.f3464a, r11.f);
        String r15 = r11.f;
        if (r5 == false) goto L5;
        r10.f3468i = r14.f3261a;
    L13:
        r10.f3464a = r15;
        rb.b r16 = null;
        String r17 = r11.f861c;
        b r18 = r10.f;
        if (r18 == null) goto L22;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r18.f3495b = r15;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r18.f3496c = r17;
        WeakReference r19 = r18.f;
        if (r19 == null) goto L18;
        r19.clear();
    L18:
        if (r13 != null) goto L20;
        WeakReference r20 = null;
    L21:
        r18.f = r20;
        goto L22
    L20:
        r20 = new WeakReference(r13);
    L22:
        b r21 = r10.g;
        if (r21 == null) goto L25;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r21.f3495b = r15;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r21.f3496c = r17;
    L25:
        r10.f3467h = r11.f859a;
        LinkedHashMap r22 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.f(r14, r10.f3464a);
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r110 = r10.f3466c;
        if (r110 == null) goto L30;
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r111 = r110.t();
        if (r111 == null) goto L30;
        r16 = (rb.b) r111.a(rb.b.class);
    L30:
        if (r12 == null) goto L33;
        if (r16 == null) goto L33;
        Intrinsics.checkNotNullParameter(r12, "other");
        r16.f21717a.putAll(r12.f21717a);
    L33:
        Uri r23 = r11.f860b;
        if (r16 == null) goto L36;
        com.bytedance.ies.bullet.service.base.c r24 = new com.bytedance.ies.bullet.service.base.c(r23.toString());
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.c.class, "clazz");
        r16.b(com.bytedance.ies.bullet.service.base.c.class, new rb.a(r24, 0));
    L36:
        ConcurrentHashMap r25 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r26 = (e) yc.a.a(e.class, "default_bid");
        if (r26 == null) goto L43;
        xc.d r27 = (xc.d) r26.a(xc.d.class);
        if (r27 == null) goto L43;
        Boolean r28 = r27.C();
        if (r28 == null) goto L43;
        boolean r29 = r28.booleanValue();
    L44:
        if (r29 == false) goto L47;
        if (r16 == null) goto L47;
        ContainerBidParam r30 = new ContainerBidParam(r10.f3465b);
        Intrinsics.checkNotNullParameter(ContainerBidParam.class, "clazz");
        r16.b(ContainerBidParam.class, new rb.a(r30, 0));
    L47:
        LinkedHashMap r112 = cd.a.f1171a;
        cd.a.b(r10.f3464a, r12);
        if (r13 == null) goto L54;
        r10.e = new WeakReference(r13);
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r31 = (e) yc.a.a(e.class, "default_bid");
        if (r31 == null) goto L52;
        xc.d r32 = (xc.d) r31.a(xc.d.class);
    L52:
        Intrinsics.checkNotNullParameter(r23, LynxResourceModule.URI_KEY);
        r13.f3250b.i(r23.toString(), r13.f3251c);
        return;
    L54:
        return;
    L43:
        r29 = true;
        goto L44
    L5:
        if (r14 != AnnieXCardScene.f3258b) goto L7;
        AnnieXCardScene r33 = AnnieXCardScene.f3259c;
    L9:
        if (TraceEvent.f10115c == true) goto L11;
        Log.d("AnnieXMonitorManager", "oldSession:" + r10.f3464a + ", new:" + r15);
    L11:
        LinkedHashMap r34 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.l(r10.f3464a, r15, r33);
        r10.f3468i = r33.f3261a;
        com.bytedance.android.anniex.monitor.c.d(28, r10.f3464a);
        com.bytedance.android.anniex.monitor.c.H(r10.f3464a);
        LinkedHashMap r35 = cd.a.f1171a;
        cd.a.c(r10.f3464a);
        goto L13
    L7:
        r33 = r14;
        goto L9
    }

    public static void i(AnnieXLynxView r5, String r10, Object r11) {
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "eventName");
        TraceEvent.c("AnnieXLynxView:sendEvent");
        i.a.l(r10, r11, r5, r5.f3465b, r5.f3464a);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "AnnieXLynxView:sendEvent");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:sendEvent");
        throw th;
    }

    public static final void j(AnnieXLynxView r5, Function0 r10) {
        r5.getClass();
        ConcurrentHashMap r11 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r12 = (e) yc.a.a(e.class, "default_bid");
        if (r12 == null) goto L9;
        xc.d r13 = (xc.d) r12.a(xc.d.class);
        if (r13 == null) goto L9;
        Boolean r14 = r13.j0();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        if (r15 == true) goto L12;
    L15:
        ((AnnieXLynxView$onLoadFail$1$1) r10).invoke();
        return;
    L12:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L15;
        h.f.b(new m(r10, 2), h.f.f17263i);
        return;
    L9:
        r15 = true;
        goto L10
    }

    public static void p() {
        Lazy r5 = com.bytedance.ies.bullet.secure.f.f5904c;
        wn.h.e().getClass();
        Unit r10 = Unit.INSTANCE;
    }

    private final void setNpthLastUrl(String r10) {
        TraceEvent.c("AnnieXLynxView:setNpthLastUrl");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L10
        HashMap r11 = new HashMap();     // Catch: Throwable -> L10
        if (r10 == null) goto L12;
        List r12 = StringsKt.K(r10, new String[]{"?"}, 0, 6);     // Catch: Throwable -> L10
        if (r12 == null) goto L12;
        String r13 = (String) r12.get(0);     // Catch: Throwable -> L10
        if (r13 == null) goto L12;
    L13:
        r11.put("last_lynx_url", r13);     // Catch: Throwable -> L10
        r11.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L10
        Npth.addTags(r11);     // Catch: Throwable -> L10
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L16:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L19
        TraceEvent.a(0, "AnnieXLynxView:setNpthLastUrl");
        return;
    L12:
        r13 = "";
    L19:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:setNpthLastUrl");
        throw th;
    L10:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
        Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
        goto L16
    }

    public final TemplateData b(b4.c r5, String r10, com.bytedance.ies.bullet.forest.m r11, boolean r12) {
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("res_from", r10);
        if (r11 == null) goto L5;
        r13.put("geckoId", String.valueOf(r11.f));
        r13.put("geckoChannel", r11.s);
    L5:
        if (r12 == false) goto L7;
        this.f3470k.putAll(r13);
    L7:
        TemplateData r14 = r5.d;
        Iterator r15 = r13.entrySet().iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.i((String) r16.getKey(), r16.getValue());
        goto L9
    L11:
        m(r14, r12);
        ConcurrentHashMap r17 = o3.a.f20403a;
        ConcurrentHashMap r18 = o3.a.n(getContext());
        if (r18 != null) goto L15;
        r18 = null;
    L15:
        if (r18 == null) goto L22;
        Iterator r19 = r18.entrySet().iterator();
    L18:
        if (r19.hasNext() == false) goto L22;
        Map.Entry r20 = (Map.Entry) r19.next();
        r14.i((String) r20.getKey(), r20.getValue());
        if (r12 == false) goto L18;
        this.f3470k.put(r20.getKey(), r20.getValue());
    L22:
        r14.d = true;
        return r14;
    }

    public final void c(final b4.c r24, final LynxLoadMode r25, final h r26) {
        TraceEvent.c("AnnieXLynxView:loadTemplateWithUrl");
        LinkedHashMap r5 = com.bytedance.android.anniex.monitor.c.f3335a;     // Catch: Throwable -> L11
        String r10 = r24.f;     // Catch: Throwable -> L11
        Uri r11 = r24.f860b;
        com.bytedance.android.anniex.monitor.c.F(r10);     // Catch: Throwable -> L11
        boolean r12 = false;
        final boolean r13 = r11.getBooleanQueryParameter("enable_lynx_predecode", false);     // Catch: Throwable -> L11
        if (r24.g == true) goto L8;
    L10:
        final boolean r14 = r12;
        Function1<w, Unit> r21 = new AnnieXLynxView$loadTemplateWithUrl$1$callback$1(r14, this, r24, r25, r26, r13);     // Catch: Throwable -> L11
        g r15 = new g("");     // Catch: Throwable -> L11
        String r16 = r11.getQueryParameter("dynamic");     // Catch: Throwable -> L11
        if (r16 == null) goto L16;
        Integer r17 = StringsKt.toIntOrNull(r16);     // Catch: Throwable -> L11
    L17:
        r15.d = r17;     // Catch: Throwable -> L11
        Function1<t, Unit> r18 = new AnnieXLynxView$loadTemplateWithUrl$1$onRequestParamsBuilt$1(r14);     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(r24.f864j, "ssr") == false) goto L20;
        f(this, r24, r25, r26);     // Catch: Throwable -> L11
    L26:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L11
        TraceEvent.a(0, "AnnieXLynxView:loadTemplateWithUrl");
        return;
    L20:
        if (r13 == true) goto L22;
        zm.c r20 = f.f5397a;     // Catch: Throwable -> L11
        f.e(r11.toString(), "ttnet", Scene.f4345a, r24.f, r15, r18, r21, 65);     // Catch: Throwable -> L11
        goto L26
    L22:
        if (TraceEvent.f10115c == true) goto L24;
        Log.d("AnnieXLynxView===", "==========loadAsyncWithProcessor========");     // Catch: Throwable -> L11
    L24:
        zm.c r22 = f.f5397a;     // Catch: Throwable -> L11
        f.d(r11.toString(), "ttnet", Scene.f4345a, r24.f, r15, new u(null, 3), r18, r21, 65);     // Catch: Throwable -> L11
        goto L26
    L16:
        r17 = null;
        goto L17
    L8:
        if (r24.f863i == false) goto L10;
        r12 = true;
    L11:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:loadTemplateWithUrl");
        throw th;
    }

    public final void d(b4.c r10, rb.b r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.c("AnnieXLynxView:load");
    L6:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:load");
        throw th;
    L4:
        if (TraceEvent.f10115c == true) goto L9;
        Log.d("AnnieXLynxView===", "load: " + this);     // Catch: Throwable -> L6
    L9:
        if (com.bytedance.ies.bullet.lynx.impl.e.f5654o == false) goto L12;
        this.f3475p = true;     // Catch: Throwable -> L6
        com.bytedance.ies.bullet.lynx.impl.e.f5654o = false;     // Catch: Throwable -> L6
    L12:
        if (r10.g == false) goto L14;
        AnnieXCardScene r5 = AnnieXCardScene.g;     // Catch: Throwable -> L6
    L15:
        h(this, r10, r11, r12, r5);     // Catch: Throwable -> L6
        String r13 = this.f3464a;     // Catch: Throwable -> L6
        Uri r14 = r10.f860b;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r13, "sessionId");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r14, "schema");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter("lynx", "containerType");     // Catch: Throwable -> L6
        if (r11 == null) goto L18;
        TemplateBundle r15 = (TemplateBundle) r11.a(TemplateBundle.class);     // Catch: Throwable -> L6
    L19:
        if (r11 == null) goto L22;
        LynxLoadMode r16 = (LynxLoadMode) r11.a(LynxLoadMode.class);     // Catch: Throwable -> L6
        if (r16 == null) goto L22;
    L23:
        g4.a r17 = this.d;     // Catch: Throwable -> L6
        if (r17 == null) goto L26;
        r17.b(null, false);     // Catch: Throwable -> L6
    L26:
        if (r15 == null) goto L28;
        g(this, r10, r15, r16, r12);     // Catch: Throwable -> L6
    L29:
        com.bytedance.android.anniex.worker.b r18 = com.bytedance.android.anniex.worker.b.f3505a;     // Catch: Throwable -> L6
        Context r19 = getContext().getApplicationContext();     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.app.Application");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter((Application) r19, "context");     // Catch: Throwable -> L6
        tc.c r20 = tc.c.f22119c;     // Catch: Throwable -> L6
        com.bytedance.ies.bullet.settings.b r21 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);     // Catch: Throwable -> L6
        if (r21 == null) goto L32;
        com.bytedance.ies.bullet.service.base.d r22 = (com.bytedance.ies.bullet.service.base.d) r21.f6163b.getValue();     // Catch: Throwable -> L6
    L32:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "AnnieXLynxView:load");
        return;
    L28:
        c(r10, r16, r12);     // Catch: Throwable -> L6
    L22:
        r16 = LynxLoadMode.f10003a;     // Catch: Throwable -> L6
        goto L23
    L18:
        r15 = null;
        goto L19
    L14:
        r5 = AnnieXCardScene.f3258b;     // Catch: Throwable -> L6
        goto L15
    }

    @Override // com.lynx.tasm.LynxView
    public final void destroy() {
        String r5 = this.f3465b;
        TraceEvent.c("AnnieXLynxView:destroy");
    L8:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:destroy");
        throw th;
    L4:
        if (Intrinsics.areEqual(r5, "Loki") == false) goto L11;
        if (this.f3477r == false) goto L11;
        new Handler(Looper.getMainLooper()).postDelayed(new a6.a(this, 7), 20);     // Catch: Throwable -> L8
    L36:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
        TraceEvent.a(0, "AnnieXLynxView:destroy");
        return;
    L11:
        if (TraceEvent.f10115c == true) goto L13;
        Log.d("AnnieXLynxView===", "===destroy===: " + this);     // Catch: Throwable -> L8
    L13:
        LinkedHashMap r11 = com.bytedance.android.anniex.monitor.c.f3335a;     // Catch: Throwable -> L8
        com.bytedance.android.anniex.monitor.c.d(28, this.f3464a);     // Catch: Throwable -> L8
        com.bytedance.android.anniex.monitor.c.H(this.f3464a);     // Catch: Throwable -> L8
        jm.c.g(r5, this.f3466c);     // Catch: Throwable -> L8
        LinkedHashMap r12 = cd.a.f1171a;     // Catch: Throwable -> L8
        cd.a.c(this.f3464a);     // Catch: Throwable -> L8
        b r13 = this.f;     // Catch: Throwable -> L8
        if (r13 == null) goto L16;
        removeLynxViewClient(r13);     // Catch: Throwable -> L8
    L16:
        setAsyncImageInterceptor(null);     // Catch: Throwable -> L8
        this.f3470k.clear();     // Catch: Throwable -> L8
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r14 = this.f3466c;     // Catch: Throwable -> L8
        if (r14 == null) goto L20;
        r14.r();     // Catch: Throwable -> L8
    L20:
        if (xq.b.i() == false) goto L22;
        this.f3466c = null;     // Catch: Throwable -> L8
    L22:
        String r15 = this.f3474o;     // Catch: Throwable -> L8
        if (r15 == null) goto L25;
        d.d(r15);     // Catch: Throwable -> L8
    L25:
        com.bytedance.ies.bullet.base.utils.logger.a.c("AnnieX", "removeScreenCaptureListener");     // Catch: Throwable -> L8
        p();     // Catch: Throwable -> L8
        com.bytedance.android.anniex.assemble.a.b(com.bytedance.android.anniex.utils.b.class, r5);     // Catch: Throwable -> L8
        ConcurrentHashMap r16 = yc.a.f23246a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L8
        e r17 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L8
        if (r17 == null) goto L32;
        xc.d r18 = (xc.d) r17.a(xc.d.class);     // Catch: Throwable -> L8
        if (r18 == null) goto L32;
        Boolean r19 = r18.O();     // Catch: Throwable -> L8
        if (r19 == null) goto L32;
        boolean r20 = r19.booleanValue();     // Catch: Throwable -> L8
    L33:
        if (r20 == false) goto L35;
        zm.c r21 = f.f5397a;     // Catch: Throwable -> L8
        f.l(this.f3464a);     // Catch: Throwable -> L8
    L35:
        super.destroy();     // Catch: Throwable -> L8
    L32:
        r20 = true;
        goto L33
    }

    public final String getBid() {
        return this.f3465b;
    }

    public final rb.b getBridgeContextProviderFactory$anniex_release() {
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r5 = this.f3466c;
        if (r5 == null) goto L8;
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r10 = r5.t();
        if (r10 != null) goto L7;
        return null;
    L7:
        return (rb.b) r10.a(rb.b.class);
    L8:
        return null;
    }

    public final boolean getIsFromEngine() {
        return false;
    }

    public final a0 getResourceInfo$anniex_release() {
        return this.f3476q;
    }

    public final String getSessionId() {
        return this.f3464a;
    }

    public final void k(w r28, b4.c r29, LynxLoadMode r30, final h r31) {
        final String r10 = "Failed to load template. url: " + r29.f860b + ", error message: ";
        if (r28.f4442r == false) goto L80;
        LinkedHashMap r5 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.G(r29.f);
        com.bytedance.android.anniex.monitor.c.B(r29.f);
        com.bytedance.ies.bullet.forest.m r15 = new com.bytedance.ies.bullet.forest.m(Uri.parse(r29.f859a), r28);
        this.f3476q = r15;
        com.bytedance.android.monitorV2.lynx.d r11 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        String r12 = String.valueOf(r15.f);
        r11.getClass();
        com.bytedance.android.monitorV2.lynx.d.e(this, "geckoId", r12);
        com.bytedance.android.monitorV2.lynx.d.e(this, LynxMonitorService.KEY_CHANNEL, r15.s);
        Object r13 = r15.d();
        int r14 = 0;
        if ((r13 instanceof TemplateBundle) == false) goto L24;
        if (r31 == null) goto L9;
        Intrinsics.checkNotNullParameter("internalTemplateBundle", "resFrom");
    L9:
        String r16 = r29.f;
        long r17 = r15.f;
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.bytedance.forest.postprocessor.ProcessedResponse<*>");
        com.bytedance.forest.postprocessor.g r18 = (com.bytedance.forest.postprocessor.g) r28;
        ProcessedData r19 = r18.C;
        if (r19 == null) goto L12;
        int r20 = r19.getSize();
    L13:
        com.bytedance.android.anniex.monitor.c.h(r16, null, "internalTemplateBundle", r17, r20);
        String r21 = r29.f859a;
        setNpthLastUrl(r21);
        TemplateData r24 = b(r29, "internalTemplateBundle", r15, true);
        TemplateBundle r22 = (TemplateBundle) r18.o();
        if (r29.f865k == false) goto L21;
        if (r22 == null) goto L21;
        if (r22.d() != true) goto L21;
        if (r22.c() == true) goto L21;
        r14 = 2;
    L21:
        x r23 = new x(r21, null, r22, null, r24, r30, r14);
        com.bytedance.android.anniex.monitor.c.C(r29.f);
        loadTemplate(r23);
        com.bytedance.android.anniex.monitor.c.D(r29.f);
        return;
    L12:
        r20 = 0;
        goto L13
    L24:
        if ((r13 instanceof r) == false) goto L27;
        b4.c r25 = b4.c.a(r29, r28.f4441q.getOriginUrl(), true, null, 32254);
        r25.f863i = r29.f863i;
        String r26 = r29.f864j;
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r25.f864j = r26;
    L26:
        final b4.c r110 = r25;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L31
        if ((r13 instanceof r) == false) goto L33;
        byte[] r32 = ((r) r13).f5416c;     // Catch: Throwable -> L31
    L34:
        Object r33 = Result.m124constructorimpl(r32);     // Catch: Throwable -> L31
    L37:
        Throwable r34 = Result.m127exceptionOrNullimpl(r33);
        if (r34 == null) goto L41;
        n(r29.f861c, r29.f, -3, androidx.room.jarjarred.org.antlr.runtime.a.x(r34, sk.a.a(r10)), r31);
    L41:
        if (Result.m130isFailureimpl(r33) == false) goto L43;
        r33 = null;
    L43:
        byte[] r35 = (byte[]) r33;
        if (r31 == null) goto L46;
        Intrinsics.checkNotNullParameter(r15.a(), "resFrom");
    L46:
        LinkedHashMap r36 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.h(r29.f, r15, "userInput", 0, 0.0d);
        if (r35 != null) goto L49;
        String r111 = "byte array is null. url: " + r110.f860b;
        String r37 = r110.f861c;
        String r38 = r110.f;
        com.bytedance.ies.bullet.forest.m r112 = r15;
        boolean r113 = true;
        n(r37, r38, -2, r111, r31);
    L62:
        if (r110.g == true) goto L64;
        return;
    L64:
        if (r110.f863i == false) goto L85;
        if (r35 == null) goto L86;
        Object r39 = r112.d();
        if ((r39 instanceof r) == false) goto L69;
        final r r40 = (r) r39;
    L70:
        if (r40 != null) goto L73;
        String r41 = r110.f861c;
        String r42 = r110.f;
        StringBuilder r43 = j.d(r10, "can not get ssrData from forest response, ssr_url:");
        r43.append(r110.f859a);
        n(r41, r42, -3, r43.toString(), r31);
        return;
    L73:
        if (r40.d.length() != 0) goto L76;
    L77:
        int r44 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r45 = j.d(r10, "initData or hydrateUrl is empty, ssr_url:");
        r45.append(r110.f859a);
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", r45.toString(), null, 12);
        return;
    L76:
        if (r40.f5415b.length() == 0) goto L77;
        zm.c r46 = f.f5397a;
        String r114 = r40.f5415b;
        Scene r115 = Scene.f4345a;
        String r116 = r110.f;
        g r47 = new g("");
        String r48 = r110.f861c;
        Intrinsics.checkNotNullParameter(r48, r6);
        r47.f22838c = r48;
        String r49 = r40.f5415b;
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r47.f22839h = r49;
        r47.f22852v = r113;
        Unit r50 = Unit.INSTANCE;
        f.e(r114, "ttnet", r115, r116, r47, null, new AnnieXLynxView$requestLynxSSRHydrate$2(r10, r110, r40, this, r31), 193);
        return;
    L69:
        r40 = null;
        goto L70
    L86:
        return;
    L85:
        return;
    L49:
        r112 = r15;
        r113 = true;
        if (r112.d != ResourceFrom.f5927c) goto L53;
        String r51 = r110.f859a;
    L52:
        String r117 = r51;
        setNpthLastUrl(r110.f859a);
        TemplateData r52 = b(r110, r112.a(), r112, true);
        if (r110.g == false) goto L59;
        updateGlobalProps(r52);
        com.bytedance.android.anniex.monitor.c.C(r110.f);
        renderSSR(r35, r110.f859a, null);
    L60:
        com.bytedance.android.anniex.monitor.c.D(r110.f);
        goto L62
    L59:
        p();
        x r53 = new x(r117, r35, null, null, r52, r30, 0);
        com.bytedance.android.anniex.monitor.c.C(r110.f);
        loadTemplate(r53);
        goto L60
    L53:
        r51 = r112.f5933b;
        if (r51 != null) goto L52;
        r51 = r110.f859a;
        goto L52
    L33:
        r32 = r15.b();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r33 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L37
    L27:
        r25 = b4.c.a(r29, r29.f860b.toString(), false, null, 32254);
        goto L26
    L80:
        StringBuilder r55 = sk.a.a(r10);
        r55.append(r28.s);
        n(r29.f861c, r29.f, -3, r55.toString(), r31);
    }

    public final void l(com.bytedance.sdk.xbridge.cn.platform.lynx.a r12, b4.c r13) {
        Intrinsics.checkNotNullParameter(r12, "lynxBDXBridge");
        Intrinsics.checkNotNullParameter(r13, "lynxViewModel");
        TraceEvent.c("AnnieXLynxView:initBridge");
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L11
        Lazy r11 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;     // Catch: Throwable -> L11
        ConcurrentHashMap r14 = yc.a.f23246a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L11
        e r15 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L11
        boolean r16 = true;
        if (r15 == null) goto L13;
        xc.d r17 = (xc.d) r15.a(xc.d.class);     // Catch: Throwable -> L11
        if (r17 == null) goto L13;
        Boolean r18 = r17.z();     // Catch: Throwable -> L11
        if (r18 == null) goto L13;
        boolean r19 = r18.booleanValue();     // Catch: Throwable -> L11
    L14:
        r10.put("loki_jsb_opt_switch", Boolean.valueOf(r19));     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L11
        e r20 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L11
        if (r20 == null) goto L21;
        xc.d r21 = (xc.d) r20.a(xc.d.class);     // Catch: Throwable -> L11
        if (r21 == null) goto L21;
        Boolean r22 = r21.x();     // Catch: Throwable -> L11
        if (r22 == null) goto L21;
        boolean r23 = r22.booleanValue();     // Catch: Throwable -> L11
    L22:
        r10.put("loki_jsb_log_drop_switch", Boolean.valueOf(r23));     // Catch: Throwable -> L11
        r10.put("can_run_in_background_fix", Boolean.valueOf(xq.b.g()));     // Catch: Throwable -> L11
        r10.put("xbridge_model_proxy_enhancement", Boolean.valueOf(xq.b.s()));     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r10, "settings");     // Catch: Throwable -> L11
        r12.e.putAll(r10);     // Catch: Throwable -> L11
        this.f3466c = r12;     // Catch: Throwable -> L11
        ki.a r24 = ki.a.f18646a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L11
        e r5 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L11
        if (r5 == null) goto L29;
        xc.d r25 = (xc.d) r5.a(xc.d.class);     // Catch: Throwable -> L11
        if (r25 == null) goto L29;
        Boolean r26 = r25.G0();     // Catch: Throwable -> L11
        if (r26 == null) goto L29;
        r16 = r26.booleanValue();     // Catch: Throwable -> L11
    L29:
        ki.a.e = r16;     // Catch: Throwable -> L11
        jm.c.e(r13, this, r12);     // Catch: Throwable -> L11
        p();     // Catch: Throwable -> L11
        g4.a r110 = k5.d.b(r13, this, r12);     // Catch: Throwable -> L11
        if (r110 == null) goto L32;
        this.d = r110;     // Catch: Throwable -> L11
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L32:
        TraceEvent.a(0, "AnnieXLynxView:initBridge");
        return;
    L21:
        r23 = true;
    L13:
        r19 = true;
    L11:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:initBridge");
        throw th;
    }

    public final void m(TemplateData r5, boolean r10) {
        LinkedHashMap r11 = this.f3470k;
        if (r10 == false) goto L5;
        r11.put("isColdStart", Boolean.valueOf(this.f3475p));
        Boolean r12 = Boolean.FALSE;
        r11.put("isPreCreate", r12);
        r11.put("isAsyncLayout", r12);
    L5:
        r5.i("isColdStart", Boolean.valueOf(this.f3475p));
        Boolean r13 = Boolean.FALSE;
        r5.i("isPreCreate", r13);
        r5.i("isAsyncLayout", r13);
        r5.i("isFromEngine", r13);
        g4.a r14 = this.d;
        if (r14 == null) goto L15;
        ug.d r15 = r14.f17030b;
        if (r15 == null) goto L16;
        i4.a r16 = (i4.a) r15.d;
        if (r16 == null) goto L17;
        LinkedHashMap r17 = (LinkedHashMap) r16.f17503c;
        if (r17 == null) goto L18;
        r17.putAll(r11);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void n(String r10, String r11, int r12, String r13, h r14) {
        TraceEvent.c("AnnieXLynxView:onLoadFail");
        Intrinsics.checkNotNullParameter(r13, "errorMsg");     // Catch: Throwable -> L10
        if (com.bytedance.ies.bullet.core.h.g.f5315a == false) goto L7;
        int r5 = 1;
        j.f(new i(r5, r13, this, CallStackUtil.a(new Throwable("Fetch template resource failed"))));     // Catch: Throwable -> L10
    L7:
        j(this, new AnnieXLynxView$onLoadFail$1$1(r14, this, r13, r12));     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.d("XResourceLoader", r13, null, 12);     // Catch: Throwable -> L10
        LinkedHashMap r15 = com.bytedance.android.anniex.monitor.c.f3335a;     // Catch: Throwable -> L10
        com.bytedance.android.anniex.monitor.c.i(r10, AbsBulletMonitorCallback$ErrStage.e, r11, r13, this);     // Catch: Throwable -> L10
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L10
        TraceEvent.a(0, "AnnieXLynxView:onLoadFail");
        return;
    L10:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:onLoadFail");
        throw th;
    }

    public final void o(b4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.c("AnnieXLynxView:reloadTemplate");
    L6:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:reloadTemplate");
        throw th;
    L4:
        if (TraceEvent.f10115c == true) goto L8;
        Log.d("AnnieXLynxView===", "reloadTemplate: " + this);     // Catch: Throwable -> L6
    L8:
        h(this, r10, null, null, AnnieXCardScene.d);     // Catch: Throwable -> L6
        setNpthLastUrl(r10.f859a);     // Catch: Throwable -> L6
        LinkedHashMap r5 = com.bytedance.android.anniex.monitor.c.f3335a;     // Catch: Throwable -> L6
        com.bytedance.android.anniex.monitor.c.C(r10.f);     // Catch: Throwable -> L6
        TemplateData r11 = r10.d;     // Catch: Throwable -> L6
        if (r11 == null) goto L11;
        r11.d = true;     // Catch: Throwable -> L6
        r11.l(this.f3470k);     // Catch: Throwable -> L6
        r11.d = true;     // Catch: Throwable -> L6
    L12:
        super.reloadTemplate(null, r11);     // Catch: Throwable -> L6
        com.bytedance.android.anniex.monitor.c.D(r10.f);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(this.f3464a, "sessionId");     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "AnnieXLynxView:reloadTemplate");
        return;
    L11:
        r11 = null;
        goto L12
    }

    @Override // com.lynx.tasm.LynxView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinkedHashMap r5 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.k(this.f3464a, this.f3467h);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        if (r10 == null) goto L42;
        Orientation[] r5 = Orientation.values();
        int r11 = r5.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L12;
        Orientation r13 = r5[r12];
        if (r13.ordinal() == r10.orientation) goto L13;
        r12 = r12 + 1;
    L13:
        if (r13 != null) goto L16;
        r13 = Orientation.f6193a;
    L16:
        if (r13 == this.f3471l) goto L37;
        xd.d r14 = v0.p(getContext());
        JSONObject r15 = new JSONObject();
        String r16 = r13.name();
        Locale r17 = Locale.ROOT;
        if (r16 == null) goto L36;
        r15.put("screenOrientation", r16.toLowerCase(r17));
        if (r14 == null) goto L26;
        int r18 = com.lynx.tasm.utils.g.c(getContext(), r14.f23106b);
        int r19 = com.lynx.tasm.utils.g.c(getContext(), r14.f23105a);
        if (r13 != Orientation.f6194b) goto L24;
        r15.put("screenHeight", Math.min(r19, r18));
        r15.put("screenWidth", Math.max(r19, r18));
    L25:
        r15.put("kitViewHeight", null);
        r15.put("kitViewWidth", null);
        goto L26
    L24:
        r15.put("screenHeight", Math.max(r19, r18));
        r15.put("screenWidth", Math.min(r19, r18));
    L26:
        Unit r20 = Unit.INSTANCE;
        i(this, "screenOrientationChange", r15);
        if (r14 == null) goto L29;
        int r21 = r14.f23105a;
        int r22 = r14.f23106b;
        updateScreenMetrics(r21, r22);
        int r23 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", "updateLynxScreenMetrics: width " + r21 + " , height " + r22, null, 12);
    L29:
        this.f3471l = r13;
        ConcurrentHashMap r24 = o3.a.f20403a;
        Context r25 = getContext();
        if (r25 != null) goto L32;
        return;
    L32:
        if ((r25 instanceof Activity) == false) goto L41;
        o3.a.f20405c.remove(Integer.valueOf(r25.hashCode()));
        return;
    L41:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        return;
    L12:
        r13 = null;
        goto L13
    }

    @Override // com.lynx.tasm.LynxView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        TraceEvent.c("AnnieXLynxView:onDetachedFromWindow");
        super.onDetachedFromWindow();     // Catch: Throwable -> L6
        if (TraceEvent.f10115c == true) goto L8;
        Log.d("AnnieXLynxView===", this.f3464a + ": onViewDetachedFromWindow: " + this);     // Catch: Throwable -> L6
    L8:
        WeakReference r5 = this.e;     // Catch: Throwable -> L6
        if (r5 == null) goto L11;
        h r10 = (h) r5.get();     // Catch: Throwable -> L6
    L11:
        LinkedHashMap r11 = com.bytedance.android.anniex.monitor.c.f3335a;     // Catch: Throwable -> L6
        com.bytedance.android.anniex.monitor.c.d(30, this.f3464a);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "AnnieXLynxView:onDetachedFromWindow");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:onDetachedFromWindow");
        throw th;
    }

    public final LynxDevtool q() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.r0();
    }

    @Override // com.lynx.tasm.LynxView
    public final void renderTemplateBundle(TemplateBundle r5, TemplateData r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "bundle");
        TraceEvent.c("AnnieXLynxView:renderTemplateBundle");
        super.renderTemplateBundle(r5, r10, r11);     // Catch: Throwable -> L6
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "AnnieXLynxView:renderTemplateBundle");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:renderTemplateBundle");
        throw th;
    }

    @Override // com.lynx.tasm.LynxView
    public final void renderTemplateWithBaseUrl(byte[] r10, TemplateData r11, String r12) {
        TraceEvent.c("LynxView:renderTemplateWithBaseUrl");
        g4.a r5 = this.d;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.b(r11, false);     // Catch: Throwable -> L6
    L8:
        super.renderTemplateWithBaseUrl(r10, r11, r12);     // Catch: Throwable -> L6
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "LynxView:renderTemplateWithBaseUrl");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "LynxView:renderTemplateWithBaseUrl");
        throw th;
    }

    @Override // com.lynx.tasm.LynxView
    public final void resetData(TemplateData r10) {
        TraceEvent.c("AnnieXLynxView:resetData");
        g4.a r5 = this.d;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.b(r10, true);     // Catch: Throwable -> L6
    L8:
        if (r10 == null) goto L10;
        r10.i("bullet_update_type", 0);     // Catch: Throwable -> L6
    L11:
        super.resetData(r10);     // Catch: Throwable -> L6
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "AnnieXLynxView:resetData");
        return;
    L10:
        r10 = null;
    L6:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:resetData");
        throw th;
    }

    @Override // com.lynx.tasm.LynxView
    public void setGlobalProps(Map<String, Object> r5) {
        if (r5 != null) goto L4;
    L9:
        super.setGlobalProps(r5);
        return;
    L4:
        if (Intrinsics.areEqual(this.f3465b, "Loki") == false) goto L9;
        Object r10 = r5.get("opt_loki_destroy");
        if (r10 != null) goto L8;
        r10 = Boolean.FALSE;
    L8:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");
        this.f3477r = ((Boolean) r10).booleanValue();
        goto L9
    }

    public final void setGroupName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "groupName");
        this.f3474o = r5;
    }

    public final void setResourceInfo$anniex_release(a0 r5) {
        this.f3476q = r5;
    }

    public final void setViewScene$anniex_release(Scenes r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        this.f3469j = r5;
    }

    public final void setViewZoom(float r5) {
        this.f3472m = r5;
    }

    @Override // com.lynx.tasm.LynxView
    public final void updateData(Map r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        TraceEvent.c("AnnieXLynxView:updateData");
        g4.a r5 = this.d;     // Catch: Throwable -> L9
        if (r5 == null) goto L11;
        Intrinsics.checkNotNullParameter(r10, "templateData");     // Catch: Throwable -> L9
        if (r10.isEmpty() == true) goto L11;
        ((LinkedHashMap) ((i4.a) r5.f17030b.d).f17502b).putAll(r10);     // Catch: Throwable -> L9
    L11:
        TemplateData r11 = TemplateData.c(r10);     // Catch: Throwable -> L9
        r11.i("bullet_update_type", 1);     // Catch: Throwable -> L9
        r11.e = true;     // Catch: Throwable -> L9
        super.updateData(r11);     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        TraceEvent.a(0, "AnnieXLynxView:updateData");
        return;
    L9:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxView:updateData");
        throw th;
    }

    @Override // com.lynx.tasm.LynxView
    public final void updateGlobalProps(TemplateData r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        TraceEvent.c("LynxView:updateGlobalProps");
        super.updateGlobalProps(r5);     // Catch: Throwable -> L6
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "LynxView:updateGlobalProps");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "LynxView:updateGlobalProps");
        throw th;
    }

    @Override // com.lynx.tasm.LynxView
    public final void updateScreenMetrics(int r5, int r10) {
        if (r5 <= 0) goto L6;
        if (r10 <= 0) goto L7;
        float r11 = this.f3472m;
        int r12 = (int) (r5 * r11);
        int r13 = (int) (r10 * r11);
        super.updateScreenMetrics(r12, r13);
        requestLayout();
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        StringBuilder r15 = j0.v("updateScreenMetrics w:", r12, r13, " h:", " view:");
        r15.append(this);
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", r15.toString(), null, 12);
        return;
    L7:
        return;
    }

    @Override // com.lynx.tasm.LynxView
    public final void updateGlobalProps(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        TraceEvent.c("LynxView:updateGlobalProps");
        super.updateGlobalProps(r5);     // Catch: Throwable -> L6
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.a(0, "LynxView:updateGlobalProps");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "LynxView:updateGlobalProps");
        throw th;
    }

    @Override // com.lynx.tasm.LynxView
    public final void updateData(TemplateData r5) {
        g4.a r10 = this.d;
        if (r10 == null) goto L5;
        r10.b(r5, false);
    L5:
        super.updateData(r5);
    }
}
