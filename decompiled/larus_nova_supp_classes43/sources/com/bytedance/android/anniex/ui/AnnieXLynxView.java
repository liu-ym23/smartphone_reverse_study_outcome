package com.bytedance.android.anniex.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import b46.m;
import bolts.Task;
import bytedance.util.BdFileUtils;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.anniex.ability.XBridgeHelper;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.monitor.AnnieXCardScene;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.solutions.card.AirActionConstant$AirSolutionLifecycle;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.crash.Npth;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.argus.api.params.o;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Arch;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.p;
import com.bytedance.ies.bullet.forest.t;
import com.bytedance.ies.bullet.forest.w;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.ui.common.Orientation;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.e2;
import com.bytedance.salamander.anniex.k7;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxLoadOption;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.q1;
import com.lynx.tasm.s0;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v26.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLynxView extends LynxView {
    public static final /* synthetic */ int B = 0;
    public boolean A;
    public String a;
    public String b;
    public LynxBDXBridge c;
    public bb.a d;
    public WeakReference<com.bytedance.android.anniex.ui.e> e;
    public com.bytedance.android.anniex.ui.e f;
    public com.bytedance.android.anniex.ui.b g;
    public com.bytedance.android.anniex.ui.b h;
    public String i;
    public String j;
    public Scenes k;
    public Arch l;
    public final Map<String, Object> m;
    public e n;
    public d o;
    public Orientation p;
    public float q;
    public boolean r;
    public String s;
    public boolean t;
    public int u;
    public final boolean v;
    public d1 w;
    public com.bytedance.ies.bullet.secure.a x;
    public ia.a y;
    public final Lazy z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Scenes.values().length];
            r0[Scenes.Card.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class c extends ia.a {
        public c() {
        }
    }

    public static final class d implements Activity.ScreenCaptureCallback {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ AnnieXLynxView b;

        public static final class a implements Runnable {
            public final /* synthetic */ Activity a;
            public final /* synthetic */ AnnieXLynxView b;

            public a(Activity r1, AnnieXLynxView r10) {
                this.a = r1;
                this.b = r10;
            }

            public final void a() {
                Activity r0 = this.a;
                if (r0 == null) goto L10;
                Context r1 = r0.getApplicationContext();
                if (r1 == null) goto L10;
                b46.d r10 = b46.h.a;
                Intrinsics.checkNotNullParameter(r1, "appContext");
                f16.b r11 = (f16.b) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(f16.a.d(r1), new b46.g()));
                if (r11 != null) goto L9;
                com.bytedance.android.anniex.assemble.a r12 = com.bytedance.android.anniex.assemble.a.a;
                HybridLogger.i("ScreenCaptureUtils", "updateScreenShotImageUrl, firstOne is null", null, 12);
                goto L10
            L9:
                com.bytedance.android.anniex.assemble.a r13 = com.bytedance.android.anniex.assemble.a.a;
                BdFileUtils.convertUriToPath(r1, r11.i);
            L10:
                AnnieXLynxView r14 = this.b;
                int r15 = AnnieXLynxView.B;
                r14.O("onUserCaptureScreen", null, true);
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
        }

        public d(Activity r1, AnnieXLynxView r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.app.Activity.ScreenCaptureCallback
        public final void onScreenCaptured() {
            HybridLogger.f("AnnieX", "onScreenCaptured", null, 12);
            new Handler(Looper.getMainLooper()).postDelayed(new a(this.a, this.b), 1000);
        }
    }

    public static final class e implements b46.e {
        public final /* synthetic */ AnnieXLynxView a;

        public static final class a implements Runnable {
            public final /* synthetic */ AnnieXLynxView a;

            public a(AnnieXLynxView r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnnieXLynxView r0 = this.a;     // Catch: Throwable -> L4
                int r1 = AnnieXLynxView.B;     // Catch: Throwable -> L4
                r0.O("onUserCaptureScreen", null, true);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(AnnieXLynxView r1) {
            this.a = r1;
        }

        public final void a(int r10) {
            HybridLogger r0 = HybridLogger.a;
            HybridLogger.f("AnnieX", "onUserCaptureScreen onCapture, responseType=" + r10, null, 12);
            if (r10 != 0) goto L6;
            new Handler(Looper.getMainLooper()).post(new a(this.a));
            return;
        }
    }

    public static final class f<V> implements Callable {
        public final /* synthetic */ AnnieXLynxView a;

        public f(AnnieXLynxView r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            b46.d r0 = b46.h.a;
            b46.h.a(this.a.getContext().getApplicationContext(), this.a.n);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ AnnieXLynxView a;

        public g(AnnieXLynxView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnieXLynxView.k(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ AnnieXLynxView a;
        public final /* synthetic */ ra.a b;
        public final /* synthetic */ TemplateBundle c;
        public final /* synthetic */ LynxLoadMode d;
        public final /* synthetic */ com.bytedance.android.anniex.ui.e e;
        public final /* synthetic */ boolean f;

        public h(AnnieXLynxView r1, ra.a r10, TemplateBundle r11, LynxLoadMode r12, com.bytedance.android.anniex.ui.e r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnieXLynxView.j(this.a, this.b, this.c, this.d, this.e, this.f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i<V> implements Callable {
        public final /* synthetic */ AnnieXLynxView a;
        public final /* synthetic */ b46.e b;

        public i(AnnieXLynxView r1, b46.e r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            b46.d r0 = b46.h.a;
            b46.h.b(this.a.getContext().getApplicationContext(), this.b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    private final q1 getAirSolutionLynxViewClient() {
        return new eb.b(new AnonymousClass1(this), new AnonymousClass2(this));
    }

    private final Handler getMHandler() {
        return (Handler) this.z.getValue();
    }

    public final LynxDevtool D() {
        LynxTemplateRender r0 = ((LynxView) this).mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDevTool();
    }

    public final void H() {
        JSONObject r0 = new JSONObject();
        r0.put("isViewFirstAppeared", this.r);
        Unit r1 = Unit.INSTANCE;
        O("viewAppeared", r0, true);
        onEnterForeground();
        this.r = false;
        b46.h.c(false);
        XBaseRuntime.a.getClass();
        XBaseRuntime.a().a(false);
        bb.a r10 = this.d;
        if (r10 == null) goto L6;
        r10.a(AirActionConstant$AirSolutionLifecycle.OnShow);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void destroy() {
        TraceEvent.beginSection("AnnieXLynxView:destroy");
        LynxContext r10 = getLynxContext();     // Catch: Throwable -> L47
        if (r10 == null) goto L6;
        String r0 = AnnieXContainerManager.INSTANCE.getEngineAliveUrlMap().remove("" + r10.getInstanceId());     // Catch: Throwable -> L47
    L6:
        AnnieXContainerManager.INSTANCE.removeContainerProxyFromEngineHashCode(hashCode());     // Catch: Throwable -> L47
        this.y = null;     // Catch: Throwable -> L47
        if (Intrinsics.areEqual(this.b, "Loki") == false) goto L12;
        if (this.A == false) goto L12;
        new Handler(Looper.getMainLooper()).postDelayed(new g(this), 20);     // Catch: Throwable -> L47
    L44:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L47
        TraceEvent.endSection("AnnieXLynxView:destroy");
        return;
    L12:
        if (TraceEvent.enableTrace() == true) goto L14;
        toString();     // Catch: Throwable -> L47
    L14:
        Map<String, i36.d> r11 = MonitorManager.a;     // Catch: Throwable -> L47
        MonitorManager.a0(this.a, true, null, null, false, 28);     // Catch: Throwable -> L47
        int r12 = XBridgeHelper.a;     // Catch: Throwable -> L47
        XBridgeHelper.d(this.b, this.c);     // Catch: Throwable -> L47
        Map r13 = c36.a.a;     // Catch: Throwable -> L47
        c36.a.c(this.a);     // Catch: Throwable -> L47
        com.bytedance.android.anniex.ui.b r14 = this.g;     // Catch: Throwable -> L47
        if (r14 == null) goto L17;
        removeLynxViewClient(r14);     // Catch: Throwable -> L47
    L17:
        setAsyncImageInterceptor(null);     // Catch: Throwable -> L47
        ((LinkedHashMap) this.m).clear();     // Catch: Throwable -> L47
        LynxBDXBridge r15 = this.c;     // Catch: Throwable -> L47
        if (r15 == null) goto L20;
        r15.A();     // Catch: Throwable -> L47
    L20:
        s26.d r16 = s26.d.c;     // Catch: Throwable -> L47
        m0 r17 = s26.d.c.c(m0.class);     // Catch: Throwable -> L47
        if (r17 == null) goto L25;
        com.bytedance.ies.bullet.service.base.d r18 = r17.a0();     // Catch: Throwable -> L47
        if (r18 == null) goto L25;
        boolean r19 = r18.k;     // Catch: Throwable -> L47
    L26:
        if (r19 == false) goto L28;
        this.c = null;     // Catch: Throwable -> L47
    L28:
        String r20 = this.s;     // Catch: Throwable -> L47
        if (r20 == null) goto L31;
        Object r21 = com.bytedance.ies.bullet.lynx.init.e.a;     // Catch: Throwable -> L47
        com.bytedance.ies.bullet.lynx.init.e.e(r20);     // Catch: Throwable -> L47
    L31:
        com.bytedance.ies.bullet.secure.a r22 = s(null);     // Catch: Throwable -> L47
        if (r22 == null) goto L34;
        r22.b();     // Catch: Throwable -> L47
    L34:
        com.bytedance.android.anniex.assemble.a r23 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L47
        IAnnieXLatchService r24 = (IAnnieXLatchService) com.bytedance.android.anniex.assemble.a.g(this.b, IAnnieXLatchService.class);     // Catch: Throwable -> L47
        if (r24 == null) goto L37;
        r24.r0();     // Catch: Throwable -> L47
    L37:
        com.bytedance.android.anniex.lite.a.a.a(this.a);     // Catch: Throwable -> L47
        if (com.bytedance.ies.bullet.service.base.h.L() == false) goto L41;
        com.bytedance.ies.bullet.forest.f r25 = ForestLoader.a;     // Catch: Throwable -> L47
        ForestLoader.p(this.a);     // Catch: Throwable -> L47
    L41:
        if (com.bytedance.ies.bullet.service.base.h.b0() == false) goto L43;
        com.bytedance.android.monitorV2.lynx_helper.b.b(this);     // Catch: Throwable -> L47
    L43:
        MonitorManager.X(this.a);     // Catch: Throwable -> L47
        getMHandler().removeCallbacksAndMessages(null);     // Catch: Throwable -> L47
        super.destroy();     // Catch: Throwable -> L47
    L25:
        r19 = true;
    L47:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:destroy");
        throw th;
    }

    public final m16.b getBridgeContextProviderFactory$anniex_release() {
        LynxBDXBridge r0 = this.c;
        if (r0 == null) goto L7;
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r1 = r0.D();
        if (r1 == null) goto L7;
        return (m16.b) r1.getService(m16.b.class);
    L7:
        return null;
    }

    public final void onDetachedFromWindow() {
        TraceEvent.beginSection("AnnieXLynxView:onDetachedFromWindow");
        super.onDetachedFromWindow();     // Catch: Throwable -> L24
        if (TraceEvent.enableTrace() == true) goto L6;
        toString();     // Catch: Throwable -> L24
    L6:
        WeakReference<com.bytedance.android.anniex.ui.e> r1 = this.e;     // Catch: Throwable -> L24
        if (r1 == null) goto L9;
        com.bytedance.android.anniex.ui.e r10 = r1.get();     // Catch: Throwable -> L24
    L11:
        if ((r10 instanceof com.bytedance.android.anniex.ui.e.a) == false) goto L13;
        com.bytedance.android.anniex.ui.e.a r11 = (com.bytedance.android.anniex.ui.e.a) r10;     // Catch: Throwable -> L24
    L13:
        Map<String, i36.d> r12 = MonitorManager.a;     // Catch: Throwable -> L24
        String r13 = this.a;     // Catch: Throwable -> L24
        Map r14 = x26.a.a;     // Catch: Throwable -> L24
        w26.g r15 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L24
        boolean r16 = false;
        if (r15 == null) goto L18;
        w26.e r17 = (w26.e) r15.n0(w26.e.class);     // Catch: Throwable -> L24
        if (r17 == null) goto L18;
        boolean r18 = Intrinsics.areEqual(r17.y(), Boolean.TRUE);     // Catch: Throwable -> L24
    L19:
        if (r18 == true) goto L21;
        r16 = true;
    L21:
        MonitorManager.a0(r13, false, null, null, r16, 14);     // Catch: Throwable -> L24
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L24
        TraceEvent.endSection("AnnieXLynxView:onDetachedFromWindow");
        return;
    L18:
        r18 = false;
        goto L19
    L9:
        r10 = null;
    L24:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:onDetachedFromWindow");
        throw th;
    }

    public final void F() {
        com.bytedance.sdk.xbridge.cn.optimize.b r1 = null;
        O("viewDisappeared", null, true);
        onEnterBackground();
        LynxBDXBridge r0 = this.c;
        if (r0 == null) goto L5;
        r1 = ((BDXBridge) r0).g;
    L5:
        if (r1 == null) goto L8;
        r1.a = false;
    L8:
        b46.h.c(true);
        XBaseRuntime.a.getClass();
        XBaseRuntime.a().a(true);
        bb.a r10 = this.d;
        if (r10 == null) goto L12;
        r10.a(AirActionConstant$AirSolutionLifecycle.OnHide);
        return;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, i36.d> r0 = MonitorManager.a;
        MonitorManager.g(this.a, this.i);
    }

    public final String getBid() {
        return this.b;
    }

    public final boolean getIsFromEngine() {
        return this.v;
    }

    public final LynxBDXBridge getLynxBDXBridge$anniex_release() {
        return this.c;
    }

    public final d1 getResourceInfo$anniex_release() {
        return this.w;
    }

    public final String getSessionId() {
        return this.a;
    }

    public static final void k(AnnieXLynxView r10) {
        r10.getClass();
        int r0 = XBridgeHelper.a;
        XBridgeHelper.d(r10.b, r10.c);
        Map r1 = c36.a.a;
        c36.a.c(r10.a);
        com.bytedance.android.anniex.ui.b r11 = r10.g;
        if (r11 == null) goto L5;
        r10.removeLynxViewClient(r11);
    L5:
        r10.setAsyncImageInterceptor(null);
        ((LinkedHashMap) r10.m).clear();
        LynxBDXBridge r12 = r10.c;
        if (r12 == null) goto L8;
        r12.A();
    L8:
        String r13 = r10.s;
        if (r13 == null) goto L11;
        Object r14 = com.bytedance.ies.bullet.lynx.init.e.a;
        com.bytedance.ies.bullet.lynx.init.e.e(r13);
    L11:
        com.bytedance.ies.bullet.secure.a r15 = r10.s(null);
        if (r15 == null) goto L15;
        r15.b();
    L15:
        if (com.bytedance.ies.bullet.service.base.h.L() == false) goto L17;
        com.bytedance.ies.bullet.forest.f r16 = ForestLoader.a;
        ForestLoader.p(r10.a);
    L17:
        Map<String, i36.d> r17 = MonitorManager.a;
        MonitorManager.X(r10.a);
        super.destroy();
    }

    private final void setNpthLastUrl(String r11) {
        TraceEvent.beginSection("AnnieXLynxView:setNpthLastUrl");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        HashMap r10 = new HashMap();     // Catch: Throwable -> L12
        if (r11 == null) goto L9;
        List r12 = StringsKt.split$default(r11, new String[]{"?"}, false, 0, 6, null);     // Catch: Throwable -> L12
        if (r12 == null) goto L9;
        String r13 = (String) r12.get(0);     // Catch: Throwable -> L12
        if (r13 == null) goto L9;
    L10:
        r10.put("last_lynx_url", r13);     // Catch: Throwable -> L12
        r10.put("lynx_sdk_version", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L12
        Npth.addTags(r10);     // Catch: Throwable -> L12
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
        TraceEvent.endSection("AnnieXLynxView:setNpthLastUrl");
        return;
    L9:
        r13 = "";
    L17:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:setNpthLastUrl");
        throw th;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        goto L14
    }

    public final void K(Activity r10) {
        d r11 = null;
        HybridLogger.f("AnnieX", "AnnieXLynxView removeScreenCaptureListener", null, 12);
        com.bytedance.ies.bullet.service.base.h.y();
        if (com.bytedance.ies.bullet.service.base.h.e() == true) goto L5;
    L12:
        e r12 = this.n;
        if (r12 == null) goto L19;
        Task.callInBackground(new i(this, r12));
        this.n = null;
        return;
    L19:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 34) goto L12;
        d r0 = this.o;
        if ((r0 instanceof Activity.ScreenCaptureCallback) == false) goto L9;
        r11 = r0;
    L9:
        if (r11 == null) goto L16;
        if (r10 == null) goto L17;
        r10.unregisterScreenCaptureCallback(r11);
        return;
    L17:
        return;
    }

    public final void L(ra.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:renderSSRHydrate");
    L38:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:renderSSRHydrate");
        throw th;
    L4:
        boolean r11 = false;
        if (r10.j == true) goto L7;
    L31:
        HybridLogger r12 = HybridLogger.a;     // Catch: Throwable -> L38
        StringBuilder r13 = new StringBuilder("invalid params in renderSSRHydrate. isSSR: ");     // Catch: Throwable -> L38
        r13.append(r10.j);     // Catch: Throwable -> L38
        r13.append(", check if ssrHydrateConfig is NULL: ");     // Catch: Throwable -> L38
        if (r10.l != null) goto L34;
        r11 = true;
    L34:
        r13.append(r11);     // Catch: Throwable -> L38
        HybridLogger.i("AnnieX", r13.toString(), null, 12);     // Catch: Throwable -> L38
    L35:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L38
        TraceEvent.endSection("AnnieXLynxView:renderSSRHydrate");
        return;
    L7:
        if (r10.l == null) goto L31;
        TemplateData r0 = r10.d;     // Catch: Throwable -> L38
        if (r0 == null) goto L17;
        Map<String, Object> r15 = u(r10);     // Catch: Throwable -> L38
        if (r15 == null) goto L16;
        Iterator<Map.Entry<String, Object>> r16 = r15.entrySet().iterator();     // Catch: Throwable -> L38
    L14:
        if (r16.hasNext() == false) goto L16;
        Map.Entry<String, Object> r17 = r16.next();     // Catch: Throwable -> L38
        r0.put(r17.getKey(), r17.getValue());     // Catch: Throwable -> L38
    L16:
        z(r0, false);     // Catch: Throwable -> L38
        r0.markConcurrent();     // Catch: Throwable -> L38
        updateGlobalProps(r0);     // Catch: Throwable -> L38
    L17:
        Map<String, i36.d> r1 = MonitorManager.a;     // Catch: Throwable -> L38
        MonitorManager.K(r10.g);     // Catch: Throwable -> L38
        ra.a.c r18 = r10.l;     // Catch: Throwable -> L38
        if (TraceEvent.enableTrace() == true) goto L20;
        toString();     // Catch: Throwable -> L38
    L20:
        ra.a.b r19 = r18.a;     // Catch: Throwable -> L38
        if (r19 == null) goto L23;
        byte[] r20 = r19.a;     // Catch: Throwable -> L38
    L24:
        if (r20 == null) goto L27;
        ssrHydrate(r19.a, r10.a, r18.c);     // Catch: Throwable -> L38
    L30:
        MonitorManager.J(r10.g);     // Catch: Throwable -> L38
        SLMonitorCompat r21 = SLMonitorCompat.a;     // Catch: Throwable -> L38
        String r22 = this.a;     // Catch: Throwable -> L38
        Uri r110 = r10.b;     // Catch: Throwable -> L38
        String r23 = SLMonitorCompat.ContainerType.Lynx.getValue();     // Catch: Throwable -> L38
        r21.getClass();     // Catch: Throwable -> L38
        SLMonitorCompat.q(r22, r110, r23, null);     // Catch: Throwable -> L38
        goto L35
    L27:
        if (r18.b == null) goto L29;
        ssrHydrateUrl(r18.b, r18.c);     // Catch: Throwable -> L38
        goto L30
    L29:
        HybridLogger.i("AnnieX", "invalid params in ssrHydrateConfig. check if template or baseUrl is NULL", null, 12);     // Catch: Throwable -> L38
        goto L30
    L23:
        r20 = null;
        goto L24
    }

    public final void M(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        TraceEvent.beginSection("AnnieXLynxView:resetData");
        bb.a r1 = this.d;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.c(r10, true);     // Catch: Throwable -> L9
    L6:
        TemplateData r11 = TemplateData.fromMap(r10);     // Catch: Throwable -> L9
        r11.put("bullet_update_type", 0);     // Catch: Throwable -> L9
        super.resetData(r11);     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        TraceEvent.endSection("AnnieXLynxView:resetData");
        return;
    L9:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:resetData");
        throw th;
    }

    public final void addLynxViewClient(q1 r10) {
        if (this.v == false) goto L7;
        com.bytedance.android.anniex.ui.b r0 = this.g;
        if (r0 == null) goto L9;
        r0.a(r10);
        return;
    L9:
        return;
    L7:
        super.addLynxViewClient(r10);
    }

    public final void o(Activity r10) {
        AnnieXRuntime.a().getClass();
        AnnieXRuntime.a().getClass();
        com.bytedance.ies.bullet.service.base.h.y();
        if (com.bytedance.ies.bullet.service.base.h.e() == false) goto L10;
        if (Build.VERSION.SDK_INT < 34) goto L10;
        d r0 = new d(r10, this);
        this.o = r0;
        if (r10 == null) goto L13;
        r10.registerScreenCaptureCallback(r10.getMainExecutor(), r0);
        return;
    L13:
        return;
    L10:
        if (this.n != null) goto L15;
        this.n = new e(this);
        Task.callInBackground(new f(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r10) {
        super/*android.widget.FrameLayout*/.onConfigurationChanged(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        e2 r0 = e2.b;
        if (e2.a.a().a(getSessionId()) != null) goto L41;
        Enum[] r1 = Orientation.values();
        int r11 = r1.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L17;
        Enum r13 = r1[r12];
        if (r13.ordinal() != r10.orientation) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == true) goto L18;
        r12 = r12 + 1;
    L18:
        if (r13 != null) goto L21;
        r13 = Orientation.UNKNOWN;
    L21:
        if (r13 == this.p) goto L44;
        int r15 = m.a;
        b46.i r16 = m.a(getContext());
        JSONObject r17 = new JSONObject();
        String r18 = r13.name();
        Locale r19 = Locale.ROOT;
        if (r18 == null) goto L40;
        r17.put("screenOrientation", r18.toLowerCase(r19));
        if (r16 == null) goto L31;
        i16.c r20 = i16.c.a;
        int r21 = i16.c.k(getContext(), r16.b);
        int r22 = i16.c.k(getContext(), r16.a);
        if (r13 != Orientation.LANDSCAPE) goto L29;
        r17.put("screenHeight", Math.min(r22, r21));
        r17.put("screenWidth", Math.max(r22, r21));
    L30:
        r17.put("kitViewHeight", null);
        r17.put("kitViewWidth", null);
        goto L31
    L29:
        r17.put("screenHeight", Math.max(r22, r21));
        r17.put("screenWidth", Math.min(r22, r21));
    L31:
        Unit r23 = Unit.INSTANCE;
        O("screenOrientationChange", r17, true);
        if (r16 == null) goto L34;
        updateScreenMetrics(r16.a, r16.b);
        HybridLogger r24 = HybridLogger.a;
        HybridLogger.m("AnnieX", "updateLynxScreenMetrics: width " + r16.a + " , height " + r16.b, null, null, 12);
    L34:
        this.p = r13;
        ConcurrentHashMap<String, Object> r110 = com.bytedance.android.anniex.ability.f.a;
        Context r111 = getContext();
        if (r111 != null) goto L37;
        return;
    L37:
        if ((r111 instanceof Activity) == false) goto L46;
        com.bytedance.android.anniex.ability.f.c.remove(Integer.valueOf(r111.hashCode()));
        return;
    L46:
        return;
    L40:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L44:
        return;
    L13:
        r14 = false;
        goto L14
    L17:
        r13 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        TraceEvent.beginSection("AnnieXLynxView:addTagView");
        g16.b r11 = g16.a.a(r10);     // Catch: Throwable -> L44
        boolean r12 = true;
        if (com.bytedance.ies.bullet.core.h.h.a == true) goto L6;
    L8:
        boolean r13 = false;
    L9:
        com.bytedance.android.anniex.utils.d r14 = null;
        if (r13 == true) goto L13;
        r11 = null;
    L13:
        if (r11 != null) goto L16;
    L41:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L44
        TraceEvent.endSection("AnnieXLynxView:addTagView");
        return;
    L16:
        if (b.a[this.k.ordinal()] != 1) goto L18;
        String r0 = "annieX_card";
    L19:
        String r16 = r11.b;     // Catch: Throwable -> L44
        if (r16 != null) goto L22;
    L25:
        if (r12 == false) goto L27;
        String r17 = "";
    L28:
        String r18 = r0 + '_' + r17 + this.j + '_' + this.l.getValue();     // Catch: Throwable -> L44
        if (getForeground() != null) goto L36;
        TraceEvent.beginSection("AnnieXLynxView:init_debug_tag");     // Catch: Throwable -> L44
        setForeground(new com.bytedance.android.anniex.utils.d(0));     // Catch: Throwable -> L33
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L33
        TraceEvent.endSection("AnnieXLynxView:init_debug_tag");     // Catch: Throwable -> L44
        goto L36
    L33:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:init_debug_tag");     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L36:
        Drawable r1 = getForeground();     // Catch: Throwable -> L44
        if ((r1 instanceof com.bytedance.android.anniex.utils.d) == false) goto L39;
        r14 = (com.bytedance.android.anniex.utils.d) r1;     // Catch: Throwable -> L44
    L39:
        if (r14 == null) goto L41;
        Intrinsics.checkNotNullParameter(r18, "text");     // Catch: Throwable -> L44
        r14.d = r18;     // Catch: Throwable -> L44
        r14.invalidateSelf();     // Catch: Throwable -> L44
        goto L41
    L27:
        r17 = r11.b + " - ";     // Catch: Throwable -> L44
        goto L28
    L22:
        if (r16.length() == 0) goto L25;
        r12 = false;
        goto L25
    L18:
        r0 = "annieX_card_" + this.k.getTag();     // Catch: Throwable -> L44
        goto L19
    L6:
        if (r11.a == false) goto L8;
        r13 = true;
    L44:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:addTagView");
        throw th;
    }

    public final void resetData(TemplateData r10) {
        TraceEvent.beginSection("AnnieXLynxView:resetData");
        bb.a r1 = this.d;     // Catch: Throwable -> L6
        if (r1 == null) goto L8;
        r1.b(r10, true);     // Catch: Throwable -> L6
    L8:
        if (r10 == null) goto L10;
        r10.put("bullet_update_type", 0);     // Catch: Throwable -> L6
    L11:
        super.resetData(r10);     // Catch: Throwable -> L6
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.endSection("AnnieXLynxView:resetData");
        return;
    L10:
        r10 = null;
    L6:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:resetData");
        throw th;
    }

    public final com.bytedance.ies.bullet.secure.a s(ra.a r10) {
        boolean r0 = false;
        if (r10 == null) goto L10;
        ra.a.C0191a r11 = r10.o;
        if (r11 == null) goto L10;
        if (r11.d != true) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L13;
        return null;
    L13:
        if (this.x != null) goto L16;
        w(null);
        Unit r12 = Unit.INSTANCE;
    L16:
        return this.x;
    }

    public final void setArch$anniex_release(Arch r10) {
        Intrinsics.checkNotNullParameter(r10, "arch");
        this.l = r10;
        ExecutorService r0 = com.bytedance.ies.bullet.service.monitor.a.a;
        String r1 = this.a;
        String r11 = r10.getValue();
        Locale r12 = Locale.ROOT;
        if (r11 == null) goto L11;
        com.bytedance.ies.bullet.service.monitor.a.a(r1, "AnnieXArch", r11.toUpperCase(r12));
        SLMonitorCompat r13 = SLMonitorCompat.a;
        String r14 = this.a;
        String r15 = this.l.getValue();
        if (r15 == null) goto L9;
        String r16 = r15.toUpperCase(r12);
        r13.getClass();
        SLMonitorCompat.b(r14, "AnnieXArch", r16);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public void setGlobalProps(Map<String, Object> r10) {
        if (r10 != null) goto L4;
    L9:
        super.setGlobalProps(r10);
        return;
    L4:
        if (Intrinsics.areEqual(this.b, "Loki") == false) goto L9;
        Object r0 = r10.get("opt_loki_destroy");
        if (r0 != null) goto L8;
        r0 = Boolean.FALSE;
    L8:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Boolean");
        this.A = ((Boolean) r0).booleanValue();
        goto L9
    }

    public final void setGroupName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "groupName");
        this.s = r10;
    }

    public final void setResourceInfo$anniex_release(d1 r1) {
        this.w = r1;
    }

    public final void setViewScene$anniex_release(Scenes r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        this.k = r10;
    }

    public final void setViewZoom(float r1) {
        this.q = r1;
    }

    public final <T> T t(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        LynxBDXBridge r0 = this.c;
        if (r0 == null) goto L7;
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r1 = r0.D();
        if (r1 == null) goto L7;
        return (T) r1.getService(r10);
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> u(ra.a r10) {
        ConcurrentHashMap<String, Object> r0 = com.bytedance.android.anniex.ability.f.a;
        Map<String, Object> r1 = com.bytedance.android.anniex.ability.f.o(getContext(), getSessionId());
        if (r1 == null) goto L12;
        ra.a.C0191a r11 = r10.o;
        if (r11 == null) goto L9;
        boolean r12 = true;
        if (r11.g != true) goto L9;
    L10:
        if (r12 == false) goto L14;
        LinkedHashMap r13 = new LinkedHashMap();
        r13.putAll(r1);
        r13.remove("bottomHeight");
        r13.remove("contentHeight");
        r13.remove("contentWidth");
        r13.remove("safeAreaHeight");
        r13.remove("topHeight");
        return r13;
    L14:
        return r1;
    L9:
        r12 = false;
        goto L10
    L12:
        return null;
    }

    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        TraceEvent.beginSection("AnnieXLynxView:updateData");
        bb.a r1 = this.d;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.c(r10, false);     // Catch: Throwable -> L9
    L6:
        TemplateData r11 = TemplateData.fromMap(r10);     // Catch: Throwable -> L9
        r11.put("bullet_update_type", 1);     // Catch: Throwable -> L9
        r11.markReadOnly();     // Catch: Throwable -> L9
        super.updateData(r11);     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        TraceEvent.endSection("AnnieXLynxView:updateData");
        return;
    L9:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:updateData");
        throw th;
    }

    public final void updateGlobalProps(TemplateData r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        com.bytedance.ies.bullet.secure.a r1 = this.x;     // Catch: Throwable -> L6
        if (r1 == null) goto L8;
        r1.c(r10);     // Catch: Throwable -> L6
    L8:
        super.updateGlobalProps(r10);     // Catch: Throwable -> L6
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.endSection("LynxView:updateGlobalProps");
        return;
    L6:
        th = move-exception;
        TraceEvent.endSection("LynxView:updateGlobalProps");
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(com.bytedance.ies.bullet.secure.a r10) {
        if (r10 == null) goto L4;
        Intrinsics.checkNotNullParameter(this, "view");
        r10.a.a(this);
    L5:
        this.x = r10;
        return;
    L4:
        int r11 = com.bytedance.ies.bullet.secure.a.b;
        r10 = com.bytedance.ies.bullet.secure.a.a.b(null, this, 4);
        goto L5
    }

    public final void updateData(TemplateData r10) {
        bb.a r0 = this.d;
        if (r0 == null) goto L5;
        r0.b(r10, false);
    L5:
        super.updateData(r10);
    }

    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        TraceEvent.beginSection("LynxView:updateGlobalProps");
        super.updateGlobalProps(r10);     // Catch: Throwable -> L6
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.endSection("LynxView:updateGlobalProps");
        return;
    L6:
        th = move-exception;
        TraceEvent.endSection("LynxView:updateGlobalProps");
        throw th;
    }

    public static final void m(AnnieXLynxView r1, Function0 r10) {
        r1.getClass();
        Map r11 = x26.a.a;
        w26.g r12 = (w26.g) x26.a.a(w26.g.class);
        if (r12 == null) goto L9;
        w26.e r13 = (w26.e) r12.n0(w26.e.class);
        if (r13 == null) goto L9;
        Boolean r14 = r13.o1();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        if (r15 == true) goto L12;
    L14:
        r10.invoke();
        return;
    L12:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L14;
        Task.call(new com.bytedance.android.anniex.ui.c(r10), Task.UI_THREAD_EXECUTOR);
        return;
    L9:
        r15 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(ra.a r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        Map<String, i36.d> r0 = MonitorManager.a;
        MonitorManager.e(r10.g, r11);
        if (Intrinsics.areEqual(r10.g, this.a) == true) goto L6;
        String r12 = r10.g;
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(this, "container");
        Intrinsics.checkNotNullParameter("lynx", "engineType");
        sz2.e r1 = sz2.e.a;
        sz2.f r13 = new sz2.f(this, "lynx");
        r1.getClass();
        sz2.e.b(r12, r13);
        return;
    }

    public final void n(MethodFinder r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r10, "finder");
        LynxBDXBridge r0 = this.c;
        if (r0 == null) goto L6;
        r0.e(r10, r11);
        return;
    }

    public final void updateScreenMetrics(int r10, int r11) {
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L7;
        float r0 = this.q;
        int r12 = (int) (r10 * r0);
        int r13 = (int) (r11 * r0);
        super.updateScreenMetrics(r12, r13);
        requestLayout();
        HybridLogger r1 = HybridLogger.a;
        HybridLogger.m("AnnieX", "updateScreenMetrics w:" + r12 + " h:" + r13 + " view:" + this, null, null, 12);
        return;
    L7:
        return;
    }

    public final void x(LynxBDXBridge r10, ra.a r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxBDXBridge");
        Intrinsics.checkNotNullParameter(r11, "lynxViewModel");
        TraceEvent.beginSection("AnnieXLynxView:initBridge");
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L29
        Lazy r12 = OptimizeConfigKt.a;     // Catch: Throwable -> L29
        Map r13 = x26.a.a;     // Catch: Throwable -> L29
        w26.g r14 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L29
        boolean r15 = true;
        if (r14 == null) goto L10;
        w26.e r16 = (w26.e) r14.n0(w26.e.class);     // Catch: Throwable -> L29
        if (r16 == null) goto L10;
        Boolean r17 = r16.p2();     // Catch: Throwable -> L29
        if (r17 == null) goto L10;
        boolean r18 = r17.booleanValue();     // Catch: Throwable -> L29
    L11:
        r1.put("loki_jsb_opt_switch", Boolean.valueOf(r18));     // Catch: Throwable -> L29
        w26.g r19 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L29
        if (r19 == null) goto L18;
        w26.e r20 = (w26.e) r19.n0(w26.e.class);     // Catch: Throwable -> L29
        if (r20 == null) goto L18;
        Boolean r21 = r20.o2();     // Catch: Throwable -> L29
        if (r21 == null) goto L18;
        r15 = r21.booleanValue();     // Catch: Throwable -> L29
    L18:
        r1.put("loki_jsb_log_drop_switch", Boolean.valueOf(r15));     // Catch: Throwable -> L29
        r1.put("can_run_in_background_fix", Boolean.valueOf(com.bytedance.ies.bullet.service.base.h.B()));     // Catch: Throwable -> L29
        r1.put("xbridge_model_proxy_enhancement", Boolean.valueOf(com.bytedance.ies.bullet.service.base.h.m0()));     // Catch: Throwable -> L29
        r10.f(r1);     // Catch: Throwable -> L29
        this.c = r10;     // Catch: Throwable -> L29
        id7.c r22 = id7.c.a;     // Catch: Throwable -> L29
        id7.c.e = com.bytedance.ies.bullet.service.base.h.o();     // Catch: Throwable -> L29
        XBridgeHelper.b(r10, this, r11);     // Catch: Throwable -> L29
        com.bytedance.ies.bullet.secure.a r23 = s(r11);     // Catch: Throwable -> L29
        if (r23 == null) goto L23;
        ArgusLynxDelegate r24 = r23.a;     // Catch: Throwable -> L29
        if (r24 == null) goto L23;
        Intrinsics.checkNotNullParameter(r24, "delegate");     // Catch: Throwable -> L29
        r10.c(new com.bytedance.sdk.xbridge.cn.auth.a(r24), AuthPriority.LOW);     // Catch: Throwable -> L29
    L23:
        bb.c.a.getClass();     // Catch: Throwable -> L29
        bb.a r25 = bb.c.a(this, r10, r11);     // Catch: Throwable -> L29
        if (r25 == null) goto L26;
        this.d = r25;     // Catch: Throwable -> L29
    L26:
        boolean r26 = r11.r;     // Catch: Throwable -> L29
        r10.o = r26;     // Catch: Throwable -> L29
        ((com.bytedance.sdk.xbridge.cn.platform.lynx.i) r10.n.getValue()).b.a = r26;     // Catch: Throwable -> L29
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L29
        TraceEvent.endSection("AnnieXLynxView:initBridge");
        return;
    L10:
        r18 = true;
    L29:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:initBridge");
        throw th;
    }

    public final void y(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "bid");
        TraceEvent.beginSection("AnnieXLynxView:init_block");
        if (TraceEvent.enableTrace() == true) goto L5;
        toString();
    L5:
        this.a = r10;
        this.b = r11;
        if (Intrinsics.areEqual("Loki", r11) == false) goto L8;
    L11:
        TraceEvent.endSection("AnnieXLynxView:init_block");
        return;
    L8:
        if (this.v == true) goto L10;
        com.bytedance.android.anniex.ui.b r1 = new com.bytedance.android.anniex.ui.b(this, r10, r11);
        this.g = r1;
        addLynxViewClient(r1);
    L10:
        this.h = new com.bytedance.android.anniex.ui.b(this, r10, r11);
        com.bytedance.android.anniex.ui.b r12 = this.h;
        Intrinsics.checkNotNull(r12);
        setAsyncImageInterceptor(new com.bytedance.ies.bullet.lynx.impl.a(r12));
        addLynxViewClient(getAirSolutionLynxViewClient());
        addLynxViewClient(new com.bytedance.android.anniex.monitor.salamander.d(new AnnieXLynxView$initialize$2(this)));
        addLynxViewClientV2(new com.bytedance.android.anniex.monitor.salamander.e(new AnnieXLynxView$initialize$3(this)));
        goto L11
    }

    public final void z(TemplateData r10, boolean r11) {
        int r0 = this.u;
        boolean r12 = false;
        if ((r0 & 1) <= 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r0 & 2) <= 0) goto L10;
        r12 = true;
    L10:
        if (r11 == false) goto L12;
        this.m.put("isColdStart", Boolean.valueOf(this.t));
        Boolean r13 = Boolean.valueOf(r1);
        this.m.put("isPreCreate", r13);
        Boolean r14 = Boolean.valueOf(r12);
        this.m.put("isAsyncLayout", r14);
    L12:
        r10.put("isColdStart", Boolean.valueOf(this.t));
        r10.put("isPreCreate", Boolean.valueOf(r1));
        r10.put("isAsyncLayout", Boolean.valueOf(r12));
        r10.put("isFromEngine", Boolean.valueOf(this.v));
        bb.a r15 = this.d;
        if (r15 == null) goto L22;
        bb.b r16 = r15.b;
        if (r16 == null) goto L23;
        db.a r17 = r16.c;
        if (r17 == null) goto L24;
        Map<String, Object> r18 = r17.b;
        if (r18 == null) goto L25;
        r18.putAll(this.m);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r1 = false;
        goto L7
    }

    public static final TemplateData i(AnnieXLynxView r10, ra.a r11, boolean r12) {
        r10.getClass();
        Map r0 = null;
        if (r12 == false) goto L12;
        TemplateData r13 = r11.d;
        if (r13 == null) goto L15;
        Map r14 = TemplateData.empty();
        r14.markConcurrent();
        r14.updateData(r10.m);
        Map r15 = r13.toMap();
        if ((r15 instanceof Map) == false) goto L9;
        r0 = r15;
    L9:
        if (r0 == null) goto L11;
        r14.updateData(r0);
    L11:
        r14.markConcurrent();
        r0 = r14;
    L15:
        if (r0 == null) goto L19;
        com.bytedance.ies.bullet.secure.a r16 = r10.x;
        if (r16 == null) goto L19;
        r16.c(r0);
    L19:
        return r0;
    L12:
        Map r17 = r11.d;
        if (r17 == null) goto L15;
        r17.markConcurrent();
        r17.updateData(r10.m);
        r17.markConcurrent();
        r0 = r17;
        goto L15
    }

    public final void A(ra.a r10, m16.b r11, com.bytedance.android.anniex.ui.e r12) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:load");
        B(r10, r11, r12, false);     // Catch: Throwable -> L6
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6
        TraceEvent.endSection("AnnieXLynxView:load");
        return;
    L6:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:load");
        throw th;
    }

    public final void N(ra.a r10, m16.b r11, com.bytedance.android.anniex.ui.e r12) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:resetData");
    L13:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:resetData");
        throw th;
    L4:
        if (TraceEvent.enableTrace() == true) goto L6;
        toString();     // Catch: Throwable -> L13
    L6:
        h(this, r10, r11, r12, AnnieXCardScene.RESET_DATA);     // Catch: Throwable -> L13
        p(this.b);     // Catch: Throwable -> L13
        setNpthLastUrl(r10.a);     // Catch: Throwable -> L13
        Map<String, i36.d> r13 = MonitorManager.a;     // Catch: Throwable -> L13
        MonitorManager.x(r10.g);     // Catch: Throwable -> L13
        TemplateData r14 = r10.h;     // Catch: Throwable -> L13
        if (r14 == null) goto L9;
        r14.put("bullet_update_type", 1);     // Catch: Throwable -> L13
    L10:
        resetData(r14);     // Catch: Throwable -> L13
        MonitorManager.y(r10.g);     // Catch: Throwable -> L13
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L13
        TraceEvent.endSection("AnnieXLynxView:resetData");
        return;
    L9:
        r14 = null;
        goto L10
    }

    public final void O(String r10, Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        TraceEvent.beginSection("AnnieXLynxView:sendEvent");
        if (r12 == false) goto L8;
        int r13 = com.bytedance.android.anniex.ability.e.a;     // Catch: Throwable -> L5
        com.bytedance.android.anniex.ability.e.a(r10, r11, this, this.b, this.a);     // Catch: Throwable -> L5
    L26:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L5
        TraceEvent.endSection("AnnieXLynxView:sendEvent");
        return;
    L8:
        List r15 = null;
        if (com.bytedance.ies.bullet.core.h.h.a == true) goto L31;
        HybridLogger r16 = HybridLogger.a;     // Catch: Throwable -> L5
        HybridLogger.m("AnnieX", "send event: " + r10, null, null, 12);     // Catch: Throwable -> L5
    L15:
        if (r11 != null) goto L18;
        com.bytedance.android.anniex.utils.g.d(this, r10, JavaOnlyArray.from(new ArrayList()));     // Catch: Throwable -> L5
        goto L26
    L18:
        if ((r11 instanceof List) == true) goto L20;
        com.bytedance.android.anniex.utils.g.d(this, r10, JavaOnlyArray.of(new Object[]{r11}));     // Catch: Throwable -> L5
        goto L26
    L20:
        if ((r11 instanceof List) == false) goto L22;
        r15 = (List) r11;     // Catch: Throwable -> L5
    L22:
        if (r15 != null) goto L24;
        r15 = new ArrayList();     // Catch: Throwable -> L5
    L24:
        com.bytedance.android.anniex.utils.g.d(this, r10, JavaOnlyArray.from(r15));     // Catch: Throwable -> L5
        goto L26
    L31:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L12
        HybridLogger r18 = HybridLogger.a;     // Catch: Throwable -> L12
        HybridLogger.f("AnnieX", "send event: " + r10 + " with params: " + new Gson().toJson(r11), null, 12);     // Catch: Throwable -> L12
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:sendEvent");
        throw th;
    }

    public final void P(ra.a r10, m16.b r11, com.bytedance.android.anniex.ui.e r12) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:updateData");
    L13:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:updateData");
        throw th;
    L4:
        if (TraceEvent.enableTrace() == true) goto L6;
        toString();     // Catch: Throwable -> L13
    L6:
        h(this, r10, r11, r12, AnnieXCardScene.UPDATE_DATA);     // Catch: Throwable -> L13
        p(this.b);     // Catch: Throwable -> L13
        setNpthLastUrl(r10.a);     // Catch: Throwable -> L13
        Map<String, i36.d> r13 = MonitorManager.a;     // Catch: Throwable -> L13
        MonitorManager.x(r10.g);     // Catch: Throwable -> L13
        TemplateData r14 = r10.h;     // Catch: Throwable -> L13
        if (r14 == null) goto L9;
        r14.put("bullet_update_type", 1);     // Catch: Throwable -> L13
    L10:
        updateData(r14);     // Catch: Throwable -> L13
        MonitorManager.y(r10.g);     // Catch: Throwable -> L13
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L13
        TraceEvent.endSection("AnnieXLynxView:updateData");
        return;
    L9:
        r14 = null;
        goto L10
    }

    public final void r(com.bytedance.android.anniex.ui.e r10, m16.b r11, ra.a r12) {
        Intrinsics.checkNotNullParameter(r12, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:flushAllStickyEvents");
    L66:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:flushAllStickyEvents");
        throw th;
    L4:
        if (this.v == false) goto L63;
        LynxBDXBridge r13 = this.c;     // Catch: Throwable -> L66
        WeakReference<com.bytedance.android.anniex.ui.e> r14 = null;
        if (r13 == null) goto L10;
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r15 = r13.D();     // Catch: Throwable -> L66
        if (r15 == null) goto L10;
        m16.b r16 = (m16.b) r15.getService(m16.b.class);     // Catch: Throwable -> L66
    L11:
        if (r11 == null) goto L14;
        if (r16 == null) goto L14;
        r16.b(r11);     // Catch: Throwable -> L66
    L14:
        if (r16 == null) goto L17;
        r16.d(com.bytedance.ies.bullet.service.base.c.class, new com.bytedance.ies.bullet.service.base.c(r12.b.toString()));     // Catch: Throwable -> L66
    L17:
        if (com.bytedance.ies.bullet.service.base.h.F() == false) goto L20;
        if (r16 == null) goto L20;
        r16.d(ContainerBidParam.class, new ContainerBidParam(this.b));     // Catch: Throwable -> L66
    L20:
        Map r17 = c36.a.a;     // Catch: Throwable -> L66
        c36.a.b(this.a, r11);     // Catch: Throwable -> L66
        if (r10 == null) goto L32;
        this.e = new WeakReference(r10);     // Catch: Throwable -> L66
        Map r18 = x26.a.a;     // Catch: Throwable -> L66
        w26.g r19 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L66
        if (r19 == null) goto L29;
        w26.e r20 = (w26.e) r19.n0(w26.e.class);     // Catch: Throwable -> L66
        if (r20 == null) goto L29;
        Boolean r21 = r20.M0();     // Catch: Throwable -> L66
        if (r21 == null) goto L29;
        boolean r22 = r21.booleanValue();     // Catch: Throwable -> L66
    L30:
        if (r22 == false) goto L32;
        this.f = r10;     // Catch: Throwable -> L66
    L29:
        r22 = true;
    L32:
        Map r23 = x26.a.a;     // Catch: Throwable -> L66
        w26.g r24 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L66
        if (r24 == null) goto L39;
        w26.e r25 = (w26.e) r24.n0(w26.e.class);     // Catch: Throwable -> L66
        if (r25 == null) goto L39;
        Boolean r26 = r25.s();     // Catch: Throwable -> L66
        if (r26 == null) goto L39;
        boolean r27 = r26.booleanValue();     // Catch: Throwable -> L66
    L40:
        if (r27 == true) goto L42;
    L44:
        com.bytedance.android.anniex.ui.b r28 = this.g;     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient");     // Catch: Throwable -> L66
        com.bytedance.android.anniex.engine.a r29 = (com.bytedance.android.anniex.engine.a) r28;     // Catch: Throwable -> L66
        WeakReference<com.bytedance.android.anniex.ui.e> r110 = r29.h;     // Catch: Throwable -> L66
        if (r110 == null) goto L47;
        r110.clear();     // Catch: Throwable -> L66
    L47:
        if (r10 != null) goto L49;
        WeakReference<com.bytedance.android.anniex.ui.e> r111 = null;
    L50:
        r29.h = r111;     // Catch: Throwable -> L66
        WeakReference<com.bytedance.android.anniex.ui.e> r112 = r29.f;     // Catch: Throwable -> L66
        if (r112 == null) goto L53;
        r112.clear();     // Catch: Throwable -> L66
    L53:
        if (r10 == null) goto L56;
        r14 = new WeakReference(r10);     // Catch: Throwable -> L66
    L56:
        r29.f = r14;     // Catch: Throwable -> L66
        com.bytedance.android.anniex.ui.b r30 = this.g;     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient");     // Catch: Throwable -> L66
        com.bytedance.android.anniex.engine.a r31 = (com.bytedance.android.anniex.engine.a) r30;     // Catch: Throwable -> L66
        WeakReference<AnnieXLynxView> r32 = r31.i;     // Catch: Throwable -> L66
        if (r32 == null) goto L59;
        r32.clear();     // Catch: Throwable -> L66
    L59:
        r31.i = new WeakReference(this);     // Catch: Throwable -> L66
        WeakReference<AnnieXLynxView> r33 = r31.d;     // Catch: Throwable -> L66
        if (r33 == null) goto L62;
        r33.clear();     // Catch: Throwable -> L66
    L62:
        r31.d = new WeakReference(this);     // Catch: Throwable -> L66
        processRender();     // Catch: Throwable -> L66
        startLynxRuntime();     // Catch: Throwable -> L66
        com.bytedance.android.anniex.ui.b r34 = this.g;     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type com.bytedance.android.anniex.engine.AnnieXDefaultLynxEngineClient");     // Catch: Throwable -> L66
        ((com.bytedance.android.anniex.engine.a) r34).x();     // Catch: Throwable -> L66
        goto L63
    L49:
        r111 = new WeakReference(r10);     // Catch: Throwable -> L66
        goto L50
    L42:
        if (r12.b.getBooleanQueryParameter("is_attach_engine_to_ui_thread", true) == false) goto L44;
        attachEngineToUIThread();     // Catch: Throwable -> L66
    L39:
        r27 = true;
    L10:
        r16 = null;
    L63:
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L66
        TraceEvent.endSection("AnnieXLynxView:flushAllStickyEvents");
    }

    public final void renderTemplateBundle(TemplateBundle r10, TemplateData r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        TraceEvent.beginSection("AnnieXLynxView:renderTemplateBundle");
        if (r12 != null) goto L18;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        com.bytedance.android.anniex.utils.g.c(this, r12, null, null, null);     // Catch: Throwable -> L8
    L13:
        super.renderTemplateBundle(r10, r11, r12);     // Catch: Throwable -> L8
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L8
        TraceEvent.endSection("AnnieXLynxView:renderTemplateBundle");
        return;
    L8:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:renderTemplateBundle");
        throw th;
    L18:
        if (StringsKt.isBlank(r12) == true) goto L10;
        r1 = false;
        goto L11
    }

    public final void renderTemplateWithBaseUrl(byte[] r10, TemplateData r11, String r12) {
        TraceEvent.beginSection("LynxView:renderTemplateWithBaseUrl");
        bb.a r1 = this.d;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.b(r11, false);     // Catch: Throwable -> L9
    L6:
        super.renderTemplateWithBaseUrl(r10, r11, r12);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
        TraceEvent.endSection("LynxView:renderTemplateWithBaseUrl");
        return;
    L9:
        th = move-exception;
        TraceEvent.endSection("LynxView:renderTemplateWithBaseUrl");
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnieXLynxView(Context r10, String r11, String r12, AnnieXLynxEngine r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "annieXLynxEngine");
        super(r10, r13.b);
        this.a = "";
        this.b = "";
        this.j = "";
        this.k = Scenes.Card;
        this.l = Arch.NORMAL;
        this.m = new LinkedHashMap();
        this.p = Orientation.UNKNOWN;
        this.q = 1.0f;
        this.r = true;
        this.y = new c();
        ia.a r0 = this.y;
        if (r0 == null) goto L5;
        AnnieXContainerManager.INSTANCE.saveContainerProxyFromEngineHashCode(hashCode(), r0);
    L5:
        this.z = LazyKt.lazy(AnnieXLynxView$mHandler$2.INSTANCE);
        this.g = r13.i;
        this.v = true;
        this.j = "engine";
        com.bytedance.ies.bullet.secure.a r14 = (com.bytedance.ies.bullet.secure.a) r13.k.getValue();
        if (r14 == null) goto L8;
        w(r14);
    L8:
        y(r11, r12);
    }

    public static void J(AnnieXLynxView r10, ra.a r11, com.bytedance.caijing.sdk.infra.base.impl.container.anniex_card.a.a r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:reloadTemplate");
        r10.I(r11, null, r12, false);     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        TraceEvent.endSection("AnnieXLynxView:reloadTemplate");
        return;
    L9:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:reloadTemplate");
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(ra.a r12, m16.b r13, com.bytedance.android.anniex.ui.e r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:load");
    L55:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:load");
        throw th;
    L4:
        if (TraceEvent.enableTrace() == true) goto L6;
        toString();     // Catch: Throwable -> L55
    L6:
        boolean r10 = DefaultLynxDelegate.q;     // Catch: Throwable -> L55
        if (DefaultLynxDelegate.q == false) goto L10;
        this.t = true;     // Catch: Throwable -> L55
        DefaultLynxDelegate.q = false;     // Catch: Throwable -> L55
    L10:
        if (r12.j == false) goto L12;
        AnnieXCardScene r11 = AnnieXCardScene.SSR;     // Catch: Throwable -> L55
    L13:
        h(this, r12, r13, r14, r11);     // Catch: Throwable -> L55
        SLMonitorCompat r16 = SLMonitorCompat.a;     // Catch: Throwable -> L55
        String r17 = this.a;     // Catch: Throwable -> L55
        Uri r18 = r12.b;     // Catch: Throwable -> L55
        String r19 = SLMonitorCompat.ContainerType.Lynx.getValue();     // Catch: Throwable -> L55
        r16.getClass();     // Catch: Throwable -> L55
        TemplateBundle r20 = null;
        SLMonitorCompat.q(r17, r18, r19, null);     // Catch: Throwable -> L55
        com.bytedance.android.anniex.ui.b r21 = this.h;     // Catch: Throwable -> L55
        if (r21 == null) goto L19;
        Forest r22 = r12.t;     // Catch: Throwable -> L55
        if (r22 != null) goto L18;
        r21.g = null;     // Catch: Throwable -> L55
        goto L19
    L18:
        r21.g = new WeakReference(r22);     // Catch: Throwable -> L55
    L19:
        com.bytedance.android.anniex.ui.b r23 = this.g;     // Catch: Throwable -> L55
        if (r23 == null) goto L25;
        Forest r24 = r12.t;     // Catch: Throwable -> L55
        if (r24 != null) goto L24;
        r23.g = null;     // Catch: Throwable -> L55
        goto L25
    L24:
        r23.g = new WeakReference(r24);     // Catch: Throwable -> L55
    L25:
        com.bytedance.ies.bullet.secure.a r25 = this.x;     // Catch: Throwable -> L55
        if (r25 == null) goto L32;
        ArgusLynxDelegate r26 = r25.a;     // Catch: Throwable -> L55
        if (r26 == null) goto L32;
        ArgusContainerDelegate r27 = ((com.bytedance.ies.argus.aspect.a) r26).b;     // Catch: Throwable -> L55
        if (r27 == null) goto L32;
        r27.c(new o(r12.b, ArgusContainerCreateType.View, r12.c, 8));     // Catch: Throwable -> L55
    L32:
        if (r13 == null) goto L34;
        r20 = (TemplateBundle) r13.c(TemplateBundle.class);     // Catch: Throwable -> L55
    L34:
        TemplateBundle r28 = r20;
        if (r13 == null) goto L38;
        LynxLoadMode r29 = (LynxLoadMode) r13.c(LynxLoadMode.class);     // Catch: Throwable -> L55
        if (r29 == null) goto L38;
    L39:
        LynxLoadMode r30 = r29;
        bb.a r31 = this.d;     // Catch: Throwable -> L55
        if (r31 == null) goto L42;
        r31.b(r12.h, false);     // Catch: Throwable -> L55
    L42:
        Long r110 = com.bytedance.android.anniex.lite.utils.b.a(r12.b, r12.g, r13);     // Catch: Throwable -> L55
        if (r110 == null) goto L45;
        getMHandler().postDelayed(new h(this, r12, r28, r30, r14, r15), r110.longValue());     // Catch: Throwable -> L55
    L46:
        LynxContext r111 = getLynxContext();     // Catch: Throwable -> L55
        if (r111 == null) goto L49;
        AnnieXContainerManager.INSTANCE.saveTemplateUrlFromEngineHashCode("" + r111.getInstanceId(), r12.a);     // Catch: Throwable -> L55
    L49:
        AnnieXJSWorkerManager r112 = AnnieXJSWorkerManager.a;     // Catch: Throwable -> L55
        Context r113 = getContext().getApplicationContext();     // Catch: Throwable -> L55
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.app.Application");     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter((Application) r113, "context");     // Catch: Throwable -> L55
        s26.d r114 = s26.d.c;     // Catch: Throwable -> L55
        m0 r115 = s26.d.c.c(m0.class);     // Catch: Throwable -> L55
        if (r115 == null) goto L52;
        r115.a0();     // Catch: Throwable -> L55
    L52:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L55
        TraceEvent.endSection("AnnieXLynxView:load");
        return;
    L45:
        j(this, r12, r28, r30, r14, r15);     // Catch: Throwable -> L55
    L38:
        r29 = LynxLoadMode.NORMAL;     // Catch: Throwable -> L55
        goto L39
    L12:
        r11 = AnnieXCardScene.NEW;     // Catch: Throwable -> L55
        goto L13
    }

    public final void C(final ra.a r23, final LynxLoadMode r24, final com.bytedance.android.anniex.ui.e r25, final boolean r26) {
        TraceEvent.beginSection("AnnieXLynxView:loadTemplateWithUrl");
        Map<String, i36.d> r1 = MonitorManager.a;     // Catch: Throwable -> L28
        MonitorManager.B(r23.g);     // Catch: Throwable -> L28
        final boolean r10 = r23.b.getBooleanQueryParameter("enable_lynx_predecode", false);     // Catch: Throwable -> L28
        if (r23.j == true) goto L6;
    L8:
        final boolean r11 = false;
    L9:
        final boolean r12 = r11;
        Function1<Response, Unit> r20 = new AnnieXLynxView$loadTemplateWithUrl$1$callback$1(r12, this, r23, r24, r25, r26, r10);     // Catch: Throwable -> L28
        l r13 = new l();     // Catch: Throwable -> L28
        String r14 = r23.b.getQueryParameter("dynamic");     // Catch: Throwable -> L28
        if (r14 == null) goto L12;
        Integer r15 = StringsKt.toIntOrNull(r14);     // Catch: Throwable -> L28
    L13:
        r13.f = r15;     // Catch: Throwable -> L28
        Function1<RequestParams, Unit> r16 = new AnnieXLynxView$loadTemplateWithUrl$1$onRequestParamsBuilt$1(r11);     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(r23.q, "ssr") == false) goto L16;
        l(this, r23, r24, r25, r26);     // Catch: Throwable -> L28
    L25:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L28
        TraceEvent.endSection("AnnieXLynxView:loadTemplateWithUrl");
        return;
    L16:
        if (r10 == false) goto L21;
        TraceEvent.enableTrace();     // Catch: Throwable -> L28
        com.bytedance.ies.bullet.forest.f r17 = ForestLoader.a;     // Catch: Throwable -> L28
        Forest r18 = r23.t;     // Catch: Throwable -> L28
        if (r18 != null) goto L20;
        r18 = ForestLoader.d();     // Catch: Throwable -> L28
    L20:
        ForestLoader.g(r18, r23.b.toString(), "ttnet", Scene.LYNX_TEMPLATE, r23.g, r13, new w(null, 3), r16, r20, 64);     // Catch: Throwable -> L28
        goto L25
    L21:
        com.bytedance.ies.bullet.forest.f r19 = ForestLoader.a;     // Catch: Throwable -> L28
        Forest r21 = r23.t;     // Catch: Throwable -> L28
        if (r21 != null) goto L24;
        r21 = ForestLoader.d();     // Catch: Throwable -> L28
    L24:
        ForestLoader.f(r21, r23.b.toString(), "ttnet", Scene.LYNX_TEMPLATE, r23.g, r13, false, r16, r20, 64);     // Catch: Throwable -> L28
        goto L25
    L12:
        r15 = null;
        goto L13
    L6:
        if (r23.p == false) goto L8;
        r11 = true;
    L28:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:loadTemplateWithUrl");
        throw th;
    }

    public final void I(ra.a r10, m16.b r11, com.bytedance.android.anniex.ui.e r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "annieXLynxModel");
        TraceEvent.beginSection("AnnieXLynxView:reloadTemplate");
    L13:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:reloadTemplate");
        throw th;
    L4:
        if (TraceEvent.enableTrace() == true) goto L6;
        toString();     // Catch: Throwable -> L13
    L6:
        h(this, r10, r11, r12, AnnieXCardScene.REUSE);     // Catch: Throwable -> L13
        setNpthLastUrl(r10.a);     // Catch: Throwable -> L13
        Map<String, i36.d> r14 = MonitorManager.a;     // Catch: Throwable -> L13
        MonitorManager.x(r10.g);     // Catch: Throwable -> L13
        TemplateData r15 = i(this, r10, r13);     // Catch: Throwable -> L13
        TemplateData r16 = r10.h;     // Catch: Throwable -> L13
        if (r16 == null) goto L9;
        r16.put("bullet_update_type", 0);     // Catch: Throwable -> L13
    L10:
        super.reloadTemplate(r16, r15);     // Catch: Throwable -> L13
        MonitorManager.y(r10.g);     // Catch: Throwable -> L13
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L13
        TraceEvent.endSection("AnnieXLynxView:reloadTemplate");
        return;
    L9:
        r16 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnieXLynxView(Context r10, String r11, String r12, LynxViewBuilder r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "builder");
        super(r10, r13);
        this.a = "";
        this.b = "";
        this.j = "";
        this.k = Scenes.Card;
        this.l = Arch.NORMAL;
        this.m = new LinkedHashMap();
        this.p = Orientation.UNKNOWN;
        this.q = 1.0f;
        this.r = true;
        this.y = new c();
        ia.a r14 = this.y;
        if (r14 == null) goto L5;
        AnnieXContainerManager.INSTANCE.saveContainerProxyFromEngineHashCode(hashCode(), r14);
    L5:
        this.z = LazyKt.lazy(AnnieXLynxView$mHandler$2.INSTANCE);
        y(r11, r12);
    }

    public static final void h(AnnieXLynxView r10, ra.a r11, m16.b r12, com.bytedance.android.anniex.ui.e r13, AnnieXCardScene r14) {
        if (Intrinsics.areEqual(r10.a, r11.g) == false) goto L5;
        r10.j = r14.getValue();
    L16:
        String r0 = r11.g;
        r10.a = r0;
        com.bytedance.android.anniex.ui.b r1 = r10.g;
        m16.b r15 = null;
        if (r1 == null) goto L25;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r1.b = r0;
        String r16 = r11.c;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r1.c = r16;
        WeakReference<com.bytedance.android.anniex.ui.e> r17 = r1.f;
        if (r17 == null) goto L21;
        r17.clear();
    L21:
        if (r13 != null) goto L23;
        WeakReference<com.bytedance.android.anniex.ui.e> r18 = null;
    L24:
        r1.f = r18;
        goto L25
    L23:
        r18 = new WeakReference(r13);
    L25:
        com.bytedance.android.anniex.ui.b r19 = r10.h;
        if (r19 == null) goto L28;
        String r20 = r11.g;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r19.b = r20;
        String r21 = r11.c;
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r19.c = r21;
    L28:
        r10.i = r11.a;
        Map<String, i36.d> r22 = MonitorManager.a;
        MonitorManager.q(r10.a, r14);
        LynxBDXBridge r110 = r10.c;
        if (r110 == null) goto L33;
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r111 = r110.D();
        if (r111 == null) goto L33;
        r15 = (m16.b) r111.getService(m16.b.class);
    L33:
        if (r12 == null) goto L36;
        if (r15 == null) goto L36;
        r15.b(r12);
    L36:
        if (r15 == null) goto L39;
        r15.d(com.bytedance.ies.bullet.service.base.c.class, new com.bytedance.ies.bullet.service.base.c(r11.b.toString()));
    L39:
        if (com.bytedance.ies.bullet.service.base.h.F() == false) goto L42;
        if (r15 == null) goto L42;
        r15.d(ContainerBidParam.class, new ContainerBidParam(r10.b));
    L42:
        Map r112 = c36.a.a;
        c36.a.b(r10.a, r12);
        if (r13 == null) goto L56;
        r10.e = new WeakReference(r13);
        Map r23 = x26.a.a;
        w26.g r24 = (w26.g) x26.a.a(w26.g.class);
        if (r24 == null) goto L51;
        w26.e r25 = (w26.e) r24.n0(w26.e.class);
        if (r25 == null) goto L51;
        Boolean r26 = r25.r1();
        if (r26 == null) goto L51;
        boolean r27 = r26.booleanValue();
    L52:
        if (r27 == false) goto L54;
        r10.f = r13;
    L54:
        r13.n(r11.b, r10);
        return;
    L51:
        r27 = true;
        goto L52
    L56:
        return;
    L5:
        if (r14 != AnnieXCardScene.NEW) goto L7;
        AnnieXCardScene r28 = AnnieXCardScene.RELOAD;
    L9:
        if (TraceEvent.enableTrace() == false) goto L11;
    L11:
        Map<String, i36.d> r29 = MonitorManager.a;
        MonitorManager.z(r10.a, r11.g, r28);
        r10.j = r28.getValue();
        MonitorManager.a0(r10.a, true, null, null, false, 28);
        MonitorManager.X(r10.a);
        Map r30 = c36.a.a;
        c36.a.c(r10.a);
        SLMonitorCompat r31 = SLMonitorCompat.a;
        String r32 = r10.a;
        String r33 = r11.g;
        String r34 = r11.b.toString();
        String r35 = r11.a;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "originalSessionId");
        Intrinsics.checkNotNullParameter(r33, "sessionId");
        if (SLMonitorCompat.b == false) goto L16;
        com.bytedance.android.anniex.monitor.salamander.c.a.a(r32).H(r32, r33, r35, r34, new k7());
        goto L16
    L7:
        r28 = r14;
        goto L9
    }

    public static final void l(final AnnieXLynxView r19, final ra.a r20, final LynxLoadMode r21, final com.bytedance.android.anniex.ui.e r22, final boolean r23) {
        r19.getClass();
        Map<String, i36.d> r0 = MonitorManager.a;
        MonitorManager.I(r20.g);
        com.bytedance.ies.bullet.forest.f r1 = ForestLoader.a;
        Forest r10 = r20.t;
        String r11 = r20.b.toString();
        Scene r12 = Scene.LYNX_TEMPLATE;
        String r13 = r20.g;
        l r14 = new l();
        r14.c(r20.a);
        r14.b(r20.c);
        r14.G = false;
        r14.F = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Accept-Engine-Version", LynxEnv.inst().getSSRApiVersion()), TuplesKt.to("X-Lynx-Ssr-Accept-Type", "binary_v1")});
        String r15 = UriProtector.getQueryParameter(r20.b, "dynamic");
        if (r15 == null) goto L5;
        Integer r16 = StringsKt.toIntOrNull(r15);
    L6:
        r14.f = r16;
        Unit r17 = Unit.INSTANCE;
        ForestLoader.g(r10, r11, "ttnet", r12, r13, r14, new com.bytedance.ies.bullet.forest.i(r20.g, r20.c, false, false, 28), null, new AnnieXLynxView$requestLynxSSRData$2(r19, r20, r21, r22, r23), 320);
        return;
    L5:
        r16 = null;
        goto L6
    }

    public final void G(String r10, String r11, final int r12, final String r13, final com.bytedance.android.anniex.ui.e r14) {
        TraceEvent.beginSection("AnnieXLynxView:onLoadFail");
        Intrinsics.checkNotNullParameter(r13, "errorMsg");     // Catch: Throwable -> L10
        if (com.bytedance.ies.bullet.core.h.h.a == false) goto L7;
        UIThreadUtils.runOnUiThreadImmediately(new com.bytedance.android.anniex.ui.d(r13, CallStackUtil.a(new Throwable("Fetch template resource failed")), this));     // Catch: Throwable -> L10
    L7:
        m(this, new AnnieXLynxView$onLoadFail$1$1(r14, this, r13, r12));     // Catch: Throwable -> L10
        HybridLogger.i("XResourceLoader", r13, null, 12);     // Catch: Throwable -> L10
        Map<String, i36.d> r15 = MonitorManager.a;     // Catch: Throwable -> L10
        MonitorManager.p(r10, r11, AbsBulletMonitorCallback.ErrStage.RL, r13, this);     // Catch: Throwable -> L10
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L10
        TraceEvent.endSection("AnnieXLynxView:onLoadFail");
        return;
    L10:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxView:onLoadFail");
        throw th;
    }

    public final TemplateData q(ra.a r10, boolean r11, String r12, p r13, boolean r14) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("res_from", r12);
        if (r13 == null) goto L5;
        r0.put("geckoId", String.valueOf(((d1) r13).f));
        r0.put("geckoChannel", ((d1) r13).u);
    L5:
        if (r14 == false) goto L7;
        this.m.putAll(r0);
    L7:
        Map r15 = null;
        if (r11 == false) goto L29;
        TemplateData r16 = r10.d;
        if (r16 == null) goto L44;
        Map r17 = TemplateData.empty();
        Iterator r1 = r0.entrySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        Map.Entry r18 = (Map.Entry) r1.next();
        r17.put((String) r18.getKey(), r18.getValue());
        goto L13
    L15:
        z(r17, r14);
        Map<String, Object> r19 = u(r10);
        if (r19 == null) goto L23;
        Iterator<Map.Entry<String, Object>> r20 = r19.entrySet().iterator();
    L19:
        if (r20.hasNext() == false) goto L23;
        Map.Entry<String, Object> r21 = r20.next();
        r17.put(r21.getKey(), r21.getValue());
        if (r14 == false) goto L19;
        this.m.put(r21.getKey(), r21.getValue());
    L23:
        Map r22 = r16.toMap();
        if ((r22 instanceof Map) == false) goto L26;
        r15 = r22;
    L26:
        if (r15 == null) goto L28;
        r17.updateData(r15);
    L28:
        r17.markConcurrent();
        r15 = r17;
    L44:
        if (r15 == null) goto L48;
        com.bytedance.ies.bullet.secure.a r23 = this.x;
        if (r23 == null) goto L48;
        r23.c(r15);
    L48:
        return r15;
    L29:
        Map r24 = r10.d;
        if (r24 == null) goto L44;
        Iterator r25 = r0.entrySet().iterator();
    L33:
        if (r25.hasNext() == false) goto L35;
        Map.Entry r26 = (Map.Entry) r25.next();
        r24.put((String) r26.getKey(), r26.getValue());
        goto L33
    L35:
        z(r24, r14);
        Map<String, Object> r27 = u(r10);
        if (r27 == null) goto L43;
        Iterator<Map.Entry<String, Object>> r28 = r27.entrySet().iterator();
    L39:
        if (r28.hasNext() == false) goto L43;
        Map.Entry<String, Object> r29 = r28.next();
        r24.put(r29.getKey(), r29.getValue());
        if (r14 == false) goto L39;
        this.m.put(r29.getKey(), r29.getValue());
    L43:
        r24.markConcurrent();
        r15 = r24;
        goto L44
    }

    public final void v(Response r31, ra.a r32, LynxLoadMode r33, final com.bytedance.android.anniex.ui.e r34, boolean r35) {
        String r12 = "Failed to load template. url: " + r32.b + ", error message: ";
        boolean r10 = true;
        if (r31.r == false) goto L135;
        Map<String, i36.d> r1 = MonitorManager.a;
        MonitorManager.C(r32.g);
        MonitorManager.u(r32.g);
        p r11 = new p(UriProtector.parse(r32.a), r31);
        this.w = r11;
        LynxViewMonitor r13 = LynxViewMonitor.b;
        String r14 = String.valueOf(((d1) r11).f);
        r13.getClass();
        LynxViewMonitor.g(this, "geckoId", r14);
        String r15 = ((d1) r11).u;
        r13.getClass();
        LynxViewMonitor.g(this, "channel", r15);
        com.bytedance.android.anniex.utils.g.a(this, r32.g, r32.b.toString(), ((d1) r11).u, ((d1) r11).v, Long.valueOf(((d1) r11).f));
        if ((r34 instanceof com.bytedance.android.anniex.ui.e.a) == false) goto L7;
        com.bytedance.android.anniex.ui.e.a r16 = (com.bytedance.android.anniex.ui.e.a) r34;
    L8:
        if (r16 == null) goto L10;
        r16.t(r31);
    L10:
        Object r17 = r11.d();
        if ((r17 instanceof TemplateBundle) == false) goto L34;
        if (r34 == null) goto L14;
        r34.onTemplateReady("internalTemplateBundle", ((d1) r11).n);
    L14:
        String r18 = r32.g;
        long r19 = ((d1) r11).f;
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type com.bytedance.forest.postprocessor.ProcessedResponse<*>");
        com.bytedance.forest.postprocessor.f r0 = (com.bytedance.forest.postprocessor.f) r31;
        ProcessedData r20 = r0.E;
        if (r20 == null) goto L17;
        int r21 = r20.getSize();
    L18:
        MonitorManager.v(r18, null, "internalTemplateBundle", r19, r21);
        String r110 = r32.a;
        setNpthLastUrl(r110);
        TemplateData r22 = q(r32, r35, "internalTemplateBundle", r11, true);
        s0.a r23 = new s0.a();
        r23.a = r110;
        TemplateBundle r24 = (TemplateBundle) r0.q();
        r23.c = r24;
        if (r32.s == false) goto L29;
        if (r24 != null) goto L22;
    L24:
        r10 = false;
    L25:
        if (r10 == false) goto L29;
        if (r24.h() == true) goto L29;
        r23.a(LynxLoadOption.DUMP_ELEMENT);
        goto L29
    L22:
        if (r24.i() != true) goto L24;
    L29:
        r23.d = r32.h;
        if (r22 == null) goto L32;
        r23.e = r22;
    L32:
        r23.f = r33;
        s0 r25 = r23.b();
        MonitorManager.x(r32.g);
        loadTemplate(r25);
        MonitorManager.y(r32.g);
        return;
    L17:
        r21 = 0;
        goto L18
    L34:
        if ((r17 instanceof t) == false) goto L36;
        ra.a r26 = r32;
        ra.a r27 = ra.a.a(r32, r31.q.getOriginUrl(), null, null, null, null, null, null, true, null, 32254);
        r27.p = r26.p;
        String r28 = r26.q;
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r27.q = r28;
        r27.t = r26.t;
    L37:
        final ra.a r29 = r27;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L53
        if ((r17 instanceof t) == false) goto L42;
        ByteBuffer r111 = ByteBuffer.wrap(((t) r17).c);     // Catch: Throwable -> L53
        p r36 = r11;
    L49:
        Object r37 = Result.constructor-impl(r111);     // Catch: Throwable -> L51
    L56:
        Object r112 = r37;
        Throwable r38 = Result.exceptionOrNull-impl(r112);
        if (r38 == null) goto L59;
        String r39 = r26.c;
        String r40 = r26.g;
        StringBuilder r41 = new StringBuilder();
        String r113 = r12;
        r41.append(r113);
        r41.append(r38.getMessage());
        G(r39, r40, -3, r41.toString(), r34);
    L61:
        if (Result.isFailure-impl(r112) == false) goto L63;
        r112 = null;
    L63:
        ByteBuffer r114 = (ByteBuffer) r112;
        if (r34 == null) goto L66;
        r34.onTemplateReady(r36.a(), ((d1) r36).n);
    L66:
        Map<String, i36.d> r42 = MonitorManager.a;
        Map r115 = null;
        MonitorManager.w(r26.g, r36, null, 28);
        if (r114 != null) goto L71;
        G(r29.c, r29.g, -2, "byte buffer is null. url: " + r29.b, r34);
    L69:
        r115 = null;
    L109:
        if (r29.j == true) goto L111;
    L113:
        boolean r43 = false;
    L114:
        if (r43 == false) goto L145;
        if (r114 == null) goto L146;
        Object r44 = r36.d();
        if ((r44 instanceof t) == false) goto L119;
        Map r45 = (t) r44;
    L120:
        if (r45 != null) goto L123;
        G(r29.c, r29.g, -3, r113 + "can not get ssrData from forest response, ssr_url:" + r29.a, r34);
        return;
    L123:
        if (((t) r45).d.length() != 0) goto L125;
        boolean r46 = true;
    L126:
        if (r46 == false) goto L128;
    L134:
        HybridLogger r47 = HybridLogger.a;
        HybridLogger.m("AnnieX", r113 + "initData or hydrateUrl is empty, ssr_url:" + r29.a, r115, r115, 12);
        return;
    L128:
        if (((t) r45).b.length() != 0) goto L130;
        boolean r48 = true;
    L131:
        if (r48 == true) goto L134;
        com.bytedance.ies.bullet.forest.f r49 = ForestLoader.a;
        Forest r116 = r29.t;
        String r117 = ((t) r45).b;
        Scene r118 = Scene.LYNX_TEMPLATE;
        String r50 = r29.g;
        l r119 = new l();
        r119.b(r29.c);
        r119.c(((t) r45).b);
        r119.G = true;
        Unit r51 = Unit.INSTANCE;
        final String r52 = r113;
        final Map r53 = r45;
        ForestLoader.f(r116, r117, "ttnet", r118, r50, r119, false, null, new AnnieXLynxView$requestLynxSSRHydrate$2(r29, r52, r53, this, r34), 192);
        return;
    L130:
        r48 = false;
        goto L131
    L125:
        r46 = false;
        goto L126
    L119:
        r45 = r115;
        goto L120
    L146:
        return;
    L145:
        return;
    L111:
        if (r29.p == false) goto L113;
        r43 = true;
        goto L114
    L71:
        if (r114.isDirect() == true) goto L76;
        if (r114.hasArray() == true) goto L76;
        G(r29.c, r29.g, -2, "byte buffer neither a heap based buffer nor a direct buffer", r34);
    L76:
        if (((d1) r36).d != ResourceFrom.CDN) goto L78;
        String r54 = r29.a;
    L81:
        setNpthLastUrl(r29.a);
        TemplateData r55 = q(r29, r35, r36.a(), r36, true);
        if (r29.j == false) goto L92;
        if (r55 == null) goto L85;
        updateGlobalProps(r55);
    L85:
        MonitorManager.x(r29.g);
        MonitorManager.E(r29.g);
        if (r114.isDirect() == false) goto L88;
    L91:
        G(r29.c, r29.g, -2, "ssr can not be performed by a non-heap based buffer", r34);
        goto L69
    L88:
        if (r114.hasArray() == false) goto L91;
        renderSSR(r114.array(), r29.a, r29.h);
        MonitorManager.D(r29.g);
        r115 = null;
    L107:
        MonitorManager.y(r29.g);
        goto L109
    L92:
        com.bytedance.ies.bullet.secure.a r120 = s(r29);
        if (r120 == null) goto L99;
        if (r114.isDirect() == false) goto L97;
        r120.a(r36, "AnnieXLynxView", r29.b, null, r114);
        goto L99
    L97:
        Uri r56 = r29.b;
        byte[] r121 = r114.array();
        int r57 = com.bytedance.ies.bullet.secure.a.b;
        r120.a(r36, "AnnieXLynxView", r56, r121, null);
    L99:
        s0.a r58 = new s0.a();
        r58.a = r54;
        if (r114.isDirect() == false) goto L102;
        r58.h = r114;
    L103:
        r58.d = r29.h;
        if (r55 == null) goto L106;
        r58.e = r55;
    L106:
        r58.f = r33;
        s0 r59 = r58.b();
        MonitorManager.x(r29.g);
        loadTemplate(r59);
        goto L107
    L102:
        r58.b = r114.array();
        goto L103
    L78:
        r54 = ((d1) r36).b;
        if (r54 != null) goto L81;
        r54 = r29.a;
        goto L81
    L59:
        r113 = r12;
    L51:
        th = th;
    L55:
        Result.Companion r60 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L42:
        r36 = r11;
        r111 = r36.H.k();     // Catch: Throwable -> L51
        if (r111 != null) goto L49;
        byte[] r61 = r36.b();     // Catch: Throwable -> L51
        if (r61 == null) goto L48;
        r111 = ByteBuffer.wrap(r61);     // Catch: Throwable -> L51
        goto L49
    L48:
        r111 = null;
    L53:
        th = th;
        r36 = r11;
        goto L55
    L36:
        r26 = r32;
        r27 = ra.a.a(r32, r26.b.toString(), null, null, null, null, null, null, false, null, 32254);
        r27.t = r26.t;
        goto L37
    L7:
        r16 = null;
        goto L8
    L135:
        String r62 = r12 + r31.s;
        if (r31.a == false) goto L138;
        HybridLogger r63 = HybridLogger.a;
        HybridLogger.m("AnnieX", "Forest request has been cancelled", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r31.q.getUrl()), TuplesKt.to(MessageIndication.MESSAGE_TYPE_MSG, r31.s.toString())}), null, 8);
        return;
    L138:
        G(r32.c, r32.g, -3, r62, r34);
    }

    public static final void j(AnnieXLynxView r10, ra.a r11, TemplateBundle r12, LynxLoadMode r13, com.bytedance.android.anniex.ui.e r14, boolean r15) {
        r10.getClass();
        TemplateData r16 = null;
        if (r12 == null) goto L21;
        Map<String, i36.d> r17 = MonitorManager.a;
        MonitorManager.B(r11.g);
        MonitorManager.C(r11.g);
        MonitorManager.u(r11.g);
        if (r14 == null) goto L7;
        r14.onTemplateReady("externalTemplateBundle", true);
    L7:
        MonitorManager.w(r11.g, null, "externalTemplateBundle", 24);
        r10.setNpthLastUrl(r11.a);
        com.bytedance.android.anniex.utils.g.b(r10, r11.g, r11.b.toString());
        if (r11.k == true) goto L10;
        r16 = r10.q(r11, r15, "externalTemplateBundle", null, false);
    L10:
        s0.a r18 = new s0.a();
        r18.a = r11.a;
        r18.d = r11.h;
        if (r16 == null) goto L13;
        r18.e = r16;
    L13:
        r18.c = r12;
        if (r11.s == true) goto L16;
    L20:
        r18.f = r13;
        s0 r19 = r18.b();
        MonitorManager.x(r11.g);
        r10.loadTemplate(r19);
        MonitorManager.y(r11.g);
        return;
    L16:
        if (r12.i() == false) goto L20;
        if (r12.h() == true) goto L20;
        r18.a(LynxLoadOption.DUMP_ELEMENT);
        goto L20
    L21:
        ra.a.b r110 = r11.i;
        if (r110 == null) goto L47;
        byte[] r111 = r110.a;
        boolean r20 = false;
        if (r111.length != 0) goto L26;
        boolean r21 = true;
    L28:
        if ((!r21) == false) goto L47;
        if (r111.length != 0) goto L33;
        r20 = true;
    L33:
        if ((!r20) == false) goto L50;
        Map<String, i36.d> r112 = MonitorManager.a;
        MonitorManager.B(r11.g);
        MonitorManager.C(r11.g);
        MonitorManager.u(r11.g);
        MonitorManager.w(r11.g, null, "custom", 24);
        r10.setNpthLastUrl(r11.a);
        com.bytedance.android.anniex.utils.g.b(r10, r11.g, r11.b.toString());
        if (r11.j == false) goto L38;
        MonitorManager.x(r11.g);
        TraceEvent.beginSection("AnnieXLynxView:renderSSR");
        r10.renderSSR(r11.i.a, r11.a, r11.h);
        TraceEvent.endSection("AnnieXLynxView:renderSSR");
        r10.p(r10.b);
        MonitorManager.y(r11.g);
        return;
    L38:
        if (r14 == null) goto L41;
        r14.onTemplateReady("custom", true);
    L41:
        if (r11.k == true) goto L43;
        r16 = r10.q(r11, r15, "custom", null, false);
    L43:
        s0.a r113 = new s0.a();
        r113.a = r11.a;
        r113.b = r11.i.a;
        r113.d = r11.h;
        if (r16 == null) goto L46;
        r113.e = r16;
    L46:
        r113.f = r13;
        s0 r114 = r113.b();
        MonitorManager.x(r11.g);
        r10.loadTemplate(r114);
        MonitorManager.y(r11.g);
        return;
    L50:
        return;
    L26:
        r21 = false;
    L47:
        r10.C(r11, r13, r14, r15);
    }
}
