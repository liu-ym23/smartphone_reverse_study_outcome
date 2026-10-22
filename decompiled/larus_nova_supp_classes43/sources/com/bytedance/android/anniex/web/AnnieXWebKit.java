package com.bytedance.android.anniex.web;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import bolts.Task;
import com.bytedance.android.anniex.ability.l;
import com.bytedance.android.anniex.ability.p;
import com.bytedance.android.anniex.ability.q;
import com.bytedance.android.anniex.ability.s;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.android.anniex.ability.t;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.monitor.AnnieXCardScene;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.common.util.LollipopV21Compat;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.bullet.base.settings.n;
import com.bytedance.ies.bullet.base.settings.u;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.common.Arch;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.r;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.WebEngineGlobalConfig;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.secure.HybridSecureManager;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.service.base.q0;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.WebChromeClientDispatcher;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXWebKit implements r {
    public static final /* synthetic */ int K = 0;
    public SccConfig.SccLevel A;
    public WebEngineGlobalConfig B;
    public ArgusWebDelegateAdapter C;
    public final m16.b D;
    public Long E;
    public Long F;
    public WeakReference<Context> G;
    public c H;
    public ib.f I;
    public final Lazy J;
    public final String a;
    public final com.bytedance.ies.bullet.service.webkit.d b;
    public AnnieXWebModel c;
    public com.bytedance.ies.bullet.web.pia.g d;
    public volatile SSWebView e;
    public final com.bytedance.ies.bullet.kit.web.impl.a f;
    public boolean g;
    public boolean h;
    public Scenes i;
    public Arch j;
    public volatile boolean k;
    public WebBDXBridge l;
    public boolean m;
    public kb.c n;
    public kb.b o;
    public e p;
    public d q;
    public Context r;
    public final boolean s;
    public final com.bytedance.ies.bullet.service.webkit.b t;
    public Uri u;
    public int v;
    public volatile int w;
    public x06.a x;
    public SccConfig y;
    public SccDelegate z;

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
        public final /* synthetic */ AnnieXWebKit a;

        public static final class a implements Runnable {
            public final /* synthetic */ AnnieXWebKit a;

            public a(AnnieXWebKit r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.p("onUserCaptureScreen", null);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(AnnieXWebKit r1) {
            this.a = r1;
        }

        @Override // android.app.Activity.ScreenCaptureCallback
        public final void onScreenCaptured() {
            HybridLogger.f("AnnieX", "onScreenCaptured", null, 12);
            new Handler(Looper.getMainLooper()).post(new a(this.a));
        }
    }

    public static final class e implements b46.e {
        public final /* synthetic */ AnnieXWebKit a;

        public static final class a implements Runnable {
            public final /* synthetic */ AnnieXWebKit a;

            public a(AnnieXWebKit r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.p("onUserCaptureScreen", null);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(AnnieXWebKit r1) {
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
        public final /* synthetic */ AnnieXWebKit a;

        public f(AnnieXWebKit r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            b46.d r0 = b46.h.a;
            Context r1 = this.a.r;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("_context");
            r1 = null;
        L5:
            b46.h.a(r1.getApplicationContext(), this.a.p);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ AnnieXWebKit a;
        public final /* synthetic */ AnnieXWebModel b;
        public final /* synthetic */ ib.f c;

        public g(AnnieXWebKit r1, AnnieXWebModel r10, ib.f r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnieXWebKit r0 = this.a;     // Catch: Throwable -> L7
            Uri r1 = r0.u;     // Catch: Throwable -> L7
            if (r1 != null) goto L5;
            r1 = this.b.c;     // Catch: Throwable -> L7
        L5:
            r0.h(r1, false, this.c, r0.D);     // Catch: Throwable -> L7
            AnnieXWebKit r10 = this.a;     // Catch: Throwable -> L7
            AnnieXWebModel r11 = this.b;     // Catch: Throwable -> L7
            r10.getClass();     // Catch: Throwable -> L7
            AnnieXWebKit.m(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class h implements ue7.c {
        public final /* synthetic */ AnnieXWebModel a;
        public final /* synthetic */ AnnieXWebKit b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ SSWebView d;

        public final Uri a() {
            return this.a.c;
        }

        public final String b() {
            return this.a.a;
        }

        public final Context context() {
            WeakReference<Context> r0 = this.b.G;
            if (r0 == null) goto L5;
            Context r1 = r0.get();
        L7:
            if (r1 == null) goto L11;
            HybridLogger.m("XWebKit", "use flowContext", null, null, 12);
            WeakReference<Context> r10 = this.b.G;
            if (r10 == null) goto L23;
            Context r11 = r10.get();
        L26:
            if ((r11 instanceof MutableContextWrapper) == false) goto L28;
            StringBuilder r12 = new StringBuilder("Using baseContext from MutableContextWrapper: ");
            MutableContextWrapper r13 = (MutableContextWrapper) r11;
            r12.append(r13.getBaseContext());
            r12.append(" Context: ");
            r12.append(this.c);
            HybridLogger.m("XWebKit", r12.toString(), null, null, 12);
            return r13.getBaseContext();
        L28:
            HybridLogger.m("XWebKit", "Using context from IContainerInstance: " + r11, null, null, 12);
            if (r11 == null) goto L31;
            return r11;
        L31:
            return this.c;
        L23:
            r11 = null;
            goto L26
        L11:
            AnnieXWebModel r14 = this.b.c;
            if (r14 == null) goto L16;
            BulletContext r15 = r14.l;
            if (r15 == null) goto L16;
            Context r16 = r15.getContext();
        L17:
            if (r16 == null) goto L24;
            HybridLogger.m("XWebKit", "use this@AnnieXWebKit.getCurrentModel()?.bulletContext?.context", null, null, 12);
            AnnieXWebModel r17 = this.b.c;
            if (r17 == null) goto L23;
            BulletContext r18 = r17.l;
            if (r18 == null) goto L23;
            r11 = r18.getContext();
            goto L26
        L24:
            HybridLogger.m("XWebKit", "use load context", null, null, 12);
            r11 = this.c;
        L16:
            r16 = null;
            goto L17
        L5:
            r1 = null;
            goto L7
        }

        public final View i() {
            return this.d;
        }

        public final void sendEvent(String r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.b.p(r10, r11);
        }

        public h(AnnieXWebModel r1, AnnieXWebKit r10, Context r11, SSWebView r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public static final class i<V> implements Callable {
        public final /* synthetic */ AnnieXWebKit a;
        public final /* synthetic */ b46.e b;

        public i(AnnieXWebKit r1, b46.e r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            b46.d r0 = b46.h.a;
            Context r1 = this.a.r;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("_context");
            r1 = null;
        L5:
            b46.h.b(r1.getApplicationContext(), this.b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void f() {
        AnnieXContainerManager r0 = AnnieXContainerManager.INSTANCE;
        SSWebView r1 = this.e;
        if (r1 == null) goto L5;
        int r10 = r1.hashCode();
    L6:
        r0.removeContainerProxyFromEngineHashCode(r10);
        this.H = null;
        AnnieXWebModel r11 = this.c;
        if (r11 == null) goto L10;
        r11.l.release();
        Map<String, i36.d> r12 = MonitorManager.a;
        MonitorManager.a0(r11.d, true, null, KitType.WEB, false, 20);
        MonitorManager.X(r11.d);
        com.bytedance.ies.bullet.forest.f r13 = ForestLoader.a;
        ForestLoader.p(r11.d);
        com.bytedance.android.anniex.lite.a.a.a(r11.d);
    L10:
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L16;
        SSWebView r14 = this.e;
        if (r14 == null) goto L15;
        r14.setWebChromeClient(null);
        r14.setWebViewClient(new WebViewClient());
        r14.destroy();     // Catch: Throwable -> L34
    L15:
        this.e = null;
    L16:
        this.G = null;
        String r15 = this.a;
        com.bytedance.android.anniex.assemble.a r16 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r17 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r15, IAnnieXContextProvider.class);
        if (r17 == null) goto L19;
        r17.W();
    L19:
        Lazy r18 = AnnieXSettings.a;
        if (AnnieXSettings.a() == true) goto L24;
        s26.d r19 = s26.d.c;
        IAnnieXContextProvider r20 = (IAnnieXContextProvider) s26.d.c.d(r15, IAnnieXContextProvider.class);
        if (r20 == null) goto L24;
        r20.W();
    L24:
        this.f.getClass();
        WebBDXBridge r21 = this.l;
        if (r21 == null) goto L27;
        r21.A();
    L27:
        m.f.N(new String[]{SSWebView.class.getName()});
        this.D.h();
        ArgusWebDelegateAdapter r22 = this.C;
        if (r22 == null) goto L32;
        ArgusWebDelegate r23 = r22.a;
        if (r23 == null) goto L32;
        r23.i();
    L32:
        this.C = null;
        ((Handler) this.J.getValue()).removeCallbacksAndMessages(null);
        return;
    L5:
        r10 = -1;
        goto L6
    }

    public final String g() {
        AnnieXWebModel r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final void j() {
        SSWebView r0 = this.e;
        if (r0 == null) goto L5;
        r0.onPause();
    L5:
        o r1 = null;
        p("viewDisappeared", null);
        b46.h.c(true);
        XBaseRuntime.a.getClass();
        XBaseRuntime.a().a(true);
        WebBDXBridge r10 = this.l;
        if (r10 == null) goto L8;
        com.bytedance.sdk.xbridge.cn.optimize.b r11 = ((BDXBridge) r10).g;
    L9:
        if (r11 == null) goto L12;
        r11.a = false;
    L12:
        ExecutorService r12 = BulletLogger.a;
        BulletLogger.g(g(), "kitView status:on hide", "XWebKit", 8);
        kb.b r13 = this.o;
        if (r13 == null) goto L17;
        com.bytedance.ies.bullet.core.r r14 = r13.a;
        if (r14 == null) goto L17;
        r14.onClose();
    L17:
        kb.b r15 = this.o;
        if (r15 == null) goto L26;
        com.bytedance.ies.bullet.service.webkit.d r16 = this.b;
        if ((r16 instanceof o) == false) goto L22;
        r1 = (o) r16;
    L22:
        com.bytedance.ies.bullet.core.r r17 = r15.a;
        if (r17 == null) goto L27;
        r17.vH(r1);
        return;
    L27:
        return;
    L26:
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final void k() {
        SSWebView r0 = this.e;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        JSONObject r1 = new JSONObject();
        JSONObject r10 = new JSONObject();
        r10.put("isViewFirstAppeared", this.g);
        Unit r11 = Unit.INSTANCE;
        r1.put("data", r10);
        p("viewAppeared", r1);
        b46.h.c(false);
        XBaseRuntime.a.getClass();
        XBaseRuntime.a().a(false);
        this.g = false;
        kb.b r12 = this.o;
        if (r12 == null) goto L10;
        com.bytedance.ies.bullet.core.r r13 = r12.a;
        if (r13 == null) goto L10;
        r13.onOpen();
    L10:
        kb.b r14 = this.o;
        if (r14 == null) goto L20;
        Uri r15 = this.u;
        o r16 = this.b;
        if ((r16 instanceof o) == false) goto L15;
        o r17 = r16;
    L16:
        com.bytedance.ies.bullet.core.r r18 = r14.a;
        if (r18 == null) goto L21;
        r18.yO(r15, r17);
        return;
    L21:
        return;
    L15:
        r17 = null;
        goto L16
    }

    public static final void b(AnnieXWebKit r10) {
        r10.getClass();
        StringBuilder r0 = new StringBuilder("window.injectInitData=");
        Gson r1 = new Gson();
        AnnieXWebModel r11 = r10.c;
        if (r11 == null) goto L5;
        Map<String, Object> r12 = r11.f;
    L6:
        r0.append(GsonProtectorUtils.toJson(r1, r12));
        r0.append(';');
        String r13 = r0.toString();
        SSWebView r14 = r10.e;
        if (r14 == null) goto L10;
        r14.evaluateJavascript(r13, null);
        return;
    L10:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static void m(AnnieXWebModel r10) {
        Map<String, i36.d> r0 = MonitorManager.a;
        MonitorManager.N(r10.d);
        SLMonitorCompat r1 = SLMonitorCompat.a;
        String r11 = r10.d;
        j r12 = r10.h;
        if (r12 == null) goto L8;
        t36.d r13 = r12.a;
        if (r13 == null) goto L8;
        Uri r14 = r13.getOriginUrl();
        if (r14 == null) goto L8;
    L9:
        String r15 = SLMonitorCompat.ContainerType.Web.getValue();
        r1.getClass();
        SLMonitorCompat.q(r11, r14, r15, null);
        return;
    L8:
        r14 = r10.c;
        goto L9
    }

    public final void c(Activity r10) {
        AnnieXRuntime.a().getClass();
        AnnieXRuntime.a().getClass();
        com.bytedance.ies.bullet.service.base.h.y();
        if (com.bytedance.ies.bullet.service.base.h.e() == false) goto L9;
        if (Build.VERSION.SDK_INT < 34) goto L9;
        if (r10 == null) goto L9;
        d r0 = new d(this);
        this.q = r0;
        r10.registerScreenCaptureCallback(r10.getMainExecutor(), r0);
        return;
    L9:
        if (this.p != null) goto L13;
        this.p = new e(this);
        Task.callInBackground(new f(this));
        return;
    }

    public final void d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.r = r10;
        this.E = Long.valueOf(System.currentTimeMillis());
        if (this.k != true) goto L6;
        return;
    L6:
        if (this.e == null) goto L8;
        SSWebView r11 = this.e;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
    L16:
        SccConfig r0 = null;
        if (r11 == null) goto L35;
        Map r12 = x26.a.a;
        w26.g r13 = (w26.g) x26.a.a(w26.g.class);
        if (r13 == null) goto L25;
        w26.e r14 = (w26.e) r13.n0(w26.e.class);
        if (r14 == null) goto L25;
        Boolean r15 = r14.t0();
        if (r15 == null) goto L25;
        boolean r16 = r15.booleanValue();
    L26:
        if (r16 == true) goto L47;
    L34:
        LollipopV21Compat.setAcceptThirdPartyCookies(r11, true);
        goto L35
    L47:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L29
        r11.setFocusable(true);     // Catch: Throwable -> L29
        r11.setFocusableInTouchMode(true);     // Catch: Throwable -> L29
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L34;
        HybridLogger r20 = HybridLogger.a;
        HybridLogger.i("XWebKit", "setFocusable error...message is " + r19.getMessage(), null, 12);
    L29:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        r16 = true;
    L35:
        Lazy r22 = HybridSecureManager.c;
        com.bytedance.ies.bullet.secure.e r23 = HybridSecureManager.a.a().a(this.a);
        if (r23 == null) goto L38;
        x06.a r24 = r23.c;
    L39:
        this.x = r24;
        com.bytedance.ies.bullet.secure.e r25 = HybridSecureManager.a.a().a(this.a);
        if (r25 == null) goto L42;
        r0 = r25.d;
    L42:
        this.y = r0;
        SSWebView r26 = this.e;
        if (r26 == null) goto L45;
        Map r1 = com.bytedance.ies.bullet.web.pia.c.a;
        com.bytedance.ies.bullet.web.pia.c.g(this.a, r26.getSettings().getUserAgentString());
    L45:
        WebEngineGlobalConfig r27 = new WebEngineGlobalConfig();
        BulletContext r28 = new BulletContext();
        r28.C = true;
        r28.f = this.a;
        r27.e(r28, CollectionsKt.emptyList());
        this.B = r27;
        this.k = true;
        this.F = Long.valueOf(System.currentTimeMillis());
        return;
    L38:
        r24 = null;
        goto L39
    L8:
        this.e = this.f.a(r10);
        c r29 = this.H;
        if (r29 == null) goto L15;
        AnnieXContainerManager r30 = AnnieXContainerManager.INSTANCE;
        SSWebView r31 = this.e;
        if (r31 == null) goto L13;
        int r32 = r31.hashCode();
    L14:
        r30.saveContainerProxyFromEngineHashCode(r32, r29);
        goto L15
    L13:
        r32 = -1;
    L15:
        r11 = this.e;
        goto L16
    }

    public final String forestDownloadEngine(BulletContext r1) {
        return com.bytedance.ies.bullet.forest.g.a.f(r1);
    }

    public final boolean hasGeckoModelInfo(BulletContext r1) {
        return com.bytedance.ies.bullet.forest.g.a.l(r1);
    }

    public final void n(Uri r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r0 = com.bytedance.ies.bullet.forest.j.a;
        AnnieXWebModel r1 = this.c;
        String r10 = null;
        if (r1 == null) goto L7;
        j r12 = r1.h;
    L8:
        if (r1 == null) goto L11;
        String r13 = r1.d;
        if (r13 == null) goto L11;
    L12:
        String r14 = r13;
        if (r1 == null) goto L15;
        String r15 = r1.a;
    L16:
        PreloadType r16 = PreloadType.WEB;
        SSWebView r17 = this.e;
        if (r17 == null) goto L21;
        WebSettings r18 = r17.getSettings();
        if (r18 == null) goto L21;
        r10 = r18.getUserAgentString();
    L21:
        com.bytedance.ies.bullet.forest.j.b(r12, r11, r14, r15, r16, r10, true);
        return;
    L15:
        r15 = null;
    L11:
        r13 = "";
        goto L12
    L7:
        r12 = null;
        goto L8
    }

    public final void o(Activity r10) {
        d r11 = null;
        HybridLogger.f("AnnieX", "AnnieXWebKit removeScreenCaptureListener", null, 12);
        com.bytedance.ies.bullet.service.base.h.y();
        if (com.bytedance.ies.bullet.service.base.h.e() == true) goto L5;
    L12:
        e r12 = this.p;
        if (r12 == null) goto L18;
        Task.callInBackground(new i(this, r12));
        this.p = null;
        return;
    L18:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 34) goto L12;
        if (r10 == null) goto L12;
        d r0 = this.q;
        if ((r0 instanceof Activity.ScreenCaptureCallback) == false) goto L10;
        r11 = r0;
    L10:
        if (r11 == null) goto L16;
        r10.unregisterScreenCaptureCallback(r11);
        return;
    }

    public final void q(Map<String, ? extends Object> r10) {
        if (r10 == null) goto L13;
        AnnieXWebModel r0 = this.c;
        if (r0 == null) goto L8;
        Map<String, Object> r1 = r0.f;
        if (r1 == null) goto L8;
        r1.putAll(r10);
    L8:
        AnnieXWebModel r11 = this.c;
        if (r11 == null) goto L13;
        Map<String, Object> r12 = r11.g;
        if (r12 == null) goto L13;
        r12.putAll(r10);
    L13:
        AnnieXWebModel r13 = this.c;
        if (r13 == null) goto L18;
        Map<String, Object> r14 = r13.g;
        if (r14 == null) goto L18;
        this.t.b(r14);
    L18:
        SSWebView r15 = this.e;
        if (r15 == null) goto L22;
        this.t.a(r15);
        return;
    }

    public final String sessionID(BulletContext r1) {
        return com.bytedance.ies.bullet.forest.g.a.r(r1);
    }

    public final boolean useForest(BulletContext r1) {
        return com.bytedance.ies.bullet.forest.g.a.u(r1);
    }

    public final boolean hasGeckoModelInfo(q26.j r1) {
        return com.bytedance.ies.bullet.forest.g.a.m(this, r1);
    }

    public final boolean hasGeckoModelInfo(j r1) {
        return com.bytedance.ies.bullet.forest.g.a.n(r1);
    }

    public AnnieXWebKit(String r10, com.bytedance.ies.bullet.service.webkit.d r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "kitService");
        this.a = r10;
        this.b = r11;
        this.f = new com.bytedance.ies.bullet.kit.web.impl.a(r11);
        this.g = true;
        new AtomicBoolean(false);
        this.i = Scenes.Card;
        this.j = Arch.NORMAL;
        Map r12 = x26.a.a;
        w26.g r13 = (w26.g) x26.a.a(w26.g.class);
        if (r13 == null) goto L9;
        u r14 = (u) r13.n0(u.class);
        if (r14 == null) goto L9;
        n r15 = r14.a();
        if (r15 == null) goto L9;
    L10:
        this.s = r15.d();
        this.t = new com.bytedance.ies.bullet.service.webkit.b(r11);
        this.v = -1;
        this.w = -1;
        this.A = SccConfig.SccLevel.SAFE;
        this.D = new m16.b();
        this.H = new c();
        m0 r16 = r11.F0(m0.class);
        if (r16 == null) goto L13;
        r16.a0().getClass();
    L13:
        this.J = LazyKt.lazy(AnnieXWebKit$handler$2.INSTANCE);
        return;
    L9:
        r15 = new n();
        goto L10
    }

    public static final void a(AnnieXWebKit r10, String r11) {
        SSWebView r0 = r10.e;
        if (r0 == null) goto L58;
        g16.b r12 = g16.a.a(r11);
        if (com.bytedance.ies.bullet.core.h.h.a == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        String r13 = null;
        if (r1 == true) goto L14;
        r12 = null;
    L14:
        if (r12 == null) goto L60;
        int r14 = r0.getChildCount();
        DebugTagTextView r15 = null;
        int r16 = 1;
    L17:
        if (r16 >= r14) goto L28;
        View r17 = r0.getChildAt(r16);
        if (r17 != null) goto L21;
    L25:
        if (r15 != null) goto L28;
        r16 = r16 + 1;
        goto L17
    L21:
        if ((r17 instanceof DebugTagTextView) == false) goto L23;
        DebugTagTextView r18 = (DebugTagTextView) r17;
    L24:
        r15 = r18;
        goto L25
    L23:
        r18 = null;
    L28:
        if (r15 != null) goto L34;
        DebugTagTextView r19 = LayoutInflater.from(r0.getContext()).inflate(2131559209, null);
        if ((r19 instanceof DebugTagTextView) == false) goto L32;
        r15 = r19;
    L33:
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(-2, -2);
        r20.gravity = 8388691;
        int r21 = r0.getContext().getResources().getDimensionPixelSize(2131165460);
        r20.leftMargin = r21;
        r20.bottomMargin = r21;
        r0.addView(r15, r20);
        goto L34
    L32:
        r15 = null;
    L34:
        if (r15 != null) goto L36;
        return;
    L36:
        if (b.a[r10.i.ordinal()] != 1) goto L38;
        String r22 = "annieX_card";
    L40:
        if (r10.m == false) goto L42;
        String r23 = "engine";
    L43:
        AnnieXWebModel r24 = r10.c;
        if (r24 == null) goto L46;
        String r25 = r24.i;
    L48:
        if (Intrinsics.areEqual(r25, "AnnieXCard") == false) goto L50;
        r15.setText(r22 + "_web_" + r23 + '_' + r10.j.getValue());
    L54:
        com.bytedance.ies.bullet.core.h.h.getClass();
        return;
    L50:
        StringBuilder r26 = new StringBuilder();
        r26.append(r22);
        r26.append("_web_");
        AnnieXWebModel r27 = r10.c;
        if (r27 == null) goto L53;
        r13 = r27.i;
    L53:
        r26.append(r13);
        r26.append('_');
        r26.append(r23);
        r26.append('_');
        r26.append(r10.j.getValue());
        r15.setText(r26.toString());
        goto L54
    L46:
        r25 = null;
        goto L48
    L42:
        r23 = "";
        goto L43
    L38:
        r22 = "annieX_card_" + r10.i.getTag();
        goto L40
    L60:
        return;
    L7:
        if (r12.a == false) goto L9;
        r1 = true;
        goto L10
    }

    public final void p(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        if (com.bytedance.ies.bullet.core.h.h.a == true) goto L29;
        ExecutorService r0 = BulletLogger.a;
        BulletLogger.g(g(), "send event.", "XWebKit", 8);
    L9:
        Object r1 = new JSONObject();
        if (r11 != null) goto L27;
    L23:
        WebBDXBridge r12 = this.l;
        if (r12 == null) goto L31;
        r12.D(r10, (JSONObject) r1);
        return;
    L31:
        return;
    L27:
    L21:
        e = move-exception;
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.i("AnnieXWebKit", "send event:" + e.getMessage(), null, 12);
        goto L23
    L13:
        if ((r11 instanceof JSONObject) == false) goto L16;
    L20:
        r1 = r11;
        goto L23
    L16:
        if ((r11 instanceof HashMap) == false) goto L19;
        r11 = ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, (Map) r11, 0, 2, null);     // Catch: Exception -> L21
        goto L20
    L19:
        r11 = r1;
        goto L20
    L29:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L6
        ExecutorService r15 = BulletLogger.a;     // Catch: Throwable -> L6
        BulletLogger.g(g(), "send event: " + r10 + " with " + new Gson().toJson(r11), "XWebKit", 8);     // Catch: Throwable -> L6
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void h(Uri r10, boolean r11, ib.f r12, m16.b r13) {
        final SSWebView r0 = this.e;
        if (r0 == null) goto L112;
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        String r14 = r10.toString();
        r1.element = r14;
        boolean r15 = false;
        this.h = false;
        if (r11 == true) goto L87;
        com.bytedance.android.anniex.web.d r16 = new com.bytedance.android.anniex.web.d(this, r12, r14);
        b36.r r17 = this.f.b.e();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "webViewClient");
        r17.c.add(0, r16);
        this.f.b.e().a(new com.bytedance.ies.bullet.kit.web.g());
        this.f.b.e().a(new com.bytedance.android.anniex.monitor.salamander.h(g()));
        com.bytedance.android.anniex.web.b r18 = new com.bytedance.android.anniex.web.b(this, r12);
        WebChromeClientDispatcher r19 = this.f.b.c();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "webChromeClient");
        r19.a.add(0, r18);
        if (com.bytedance.android.monitorV2.util.h.d() == false) goto L9;
        this.f.b.c().a(new com.bytedance.android.anniex.monitor.salamander.f());
    L10:
        this.b.getClass();
        if (com.bytedance.ies.bullet.service.base.h.V() == false) goto L30;
        Context r20 = r0.getContext();
        BulletContext r21 = new BulletContext();
        r21.C = false;
        r21.f = this.a;
        AnnieXWebModel r22 = this.c;
        if (r22 == null) goto L17;
        j r23 = r22.h;
        if (r23 == null) goto L17;
        t36.d r24 = r23.a;
    L18:
        r21.e = r24;
        AnnieXWebModel r25 = this.c;
        if (r25 == null) goto L21;
        String r26 = r25.d;
    L22:
        String r27 = String.valueOf(r26);
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r21.a = r27;
        r21.b(r20);
        this.D.d(BulletContext.class, r21);
        s26.d r28 = s26.d.c;
        e26.b r29 = s26.d.c.d(this.a, e26.b.class);
        if (r29 == null) goto L30;
        b36.h r30 = this.f.b;
        c26.d r31 = r29.X(this.D);
        if (r31 == null) goto L27;
        r30.e().a(r31);
    L27:
        c26.c r32 = r29.e0(this.D);
        if (r32 == null) goto L30;
        r30.c().a(r32);
        goto L30
    L21:
        r26 = null;
    L17:
        r24 = null;
    L30:
        AnnieXWebModel r33 = this.c;
        if (r33 != null) goto L33;
    L35:
        boolean r34 = false;
    L36:
        if (r34 == false) goto L44;
        this.b.getClass();
        SccConfig r35 = this.y;
        if (r35 == null) goto L44;
        JsonObject r36 = r35.e();
        if (r36 == null) goto L44;
        x06.a r37 = this.x;
        if (r37 == null) goto L44;
        SccDelegate r38 = new SccDelegate(r36, r37);
        this.z = r38;
        r0.setSccDelegate$anniex_release(r38);
    L44:
        AnnieXWebModel r39 = this.c;
        if (r39 == null) goto L49;
        j r40 = r39.h;
        if (r40 == null) goto L49;
        t36.f r41 = r40.d;
    L51:
        if ((r41 instanceof v36.e) == false) goto L53;
        v36.e r42 = (v36.e) r41;
    L54:
        if (r42 == null) goto L61;
        y36.i r43 = r42.p;
        if (r43 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("webBgColor");
        r43 = null;
    L59:
        if (r43 == null) goto L61;
        String r44 = (String) r43.b;
    L62:
        if (r44 != null) goto L64;
        r0.setBackgroundColor(0);
    L64:
        AnnieXWebModel r45 = this.c;
        if (r45 == null) goto L69;
        j r46 = r45.h;
        if (r46 == null) goto L69;
        t36.f r47 = r46.d;
    L71:
        if ((r47 instanceof v36.e) == false) goto L73;
        v36.e r48 = (v36.e) r47;
    L74:
        if (r48 == null) goto L86;
        y36.i r49 = r48.c;
        if (r49 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("disableSaveImage");
        r49 = null;
    L79:
        Boolean r50 = (Boolean) r49.b;
        if (r50 == null) goto L82;
        boolean r51 = r50.booleanValue();
    L83:
        r0.setLongClickable(!r51);
        if (r51 == false) goto L86;
        r0.setOnLongClickListener(null);
        goto L86
    L82:
        r51 = false;
    L86:
        r0.setEnableSafeWebJSBAuth(Boolean.valueOf(this.s));
        goto L87
    L73:
        r48 = null;
    L69:
        r47 = null;
    L61:
        r44 = null;
        goto L62
    L53:
        r42 = null;
    L49:
        r41 = null;
        goto L51
    L33:
        if (r33.j != true) goto L35;
        r34 = true;
        goto L36
    L9:
        this.f.b.c().a(new com.bytedance.ies.bullet.kit.web.f());
    L87:
        AnnieXWebModel r52 = this.c;
        if (r52 == null) goto L92;
        String r53 = r52.a;
        if (r53 == null) goto L92;
        s26.d r54 = s26.d.c;
        e26.b r55 = (e26.b) s26.d.c.d(r53, e26.b.class);
    L93:
        if (r55 == null) goto L95;
        com.bytedance.ies.bullet.kit.web.e r56 = r55.Z(r13);
    L96:
        if (r56 == null) goto L98;
        Function4 r57 = r56.a();
    L99:
        if (r57 == null) goto L101;
        r57.invoke(r0, r0.getUrl(), null, new AnnieXWebKit$loadInner$1$1(r1, this, r0));
        return;
    L101:
        n(UriProtector.parse((String) r1.element));
        kb.c r58 = this.n;
        if (r58 == null) goto L106;
        String r59 = (String) r1.element;
        if (r58.a.g() != true) goto L106;
        r15 = true;
    L106:
        if (r15 == false) goto L110;
        kb.c r60 = this.n;
        if (r60 == null) goto L114;
        String r61 = (String) r1.element;
        Intrinsics.checkNotNullParameter(r0, "webView");
        r60.a.c(r0, r61, null);
        return;
    L114:
        return;
    L110:
        r0.loadUrl((String) r1.element);
        return;
    L98:
        r57 = null;
        goto L99
    L95:
        r56 = null;
    L92:
        r55 = null;
        goto L93
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Context r21, ib.f r22, AnnieXWebModel r23, m16.b r24) {
        Intrinsics.checkNotNullParameter(r21, "context");
        String r12 = "webViewModel";
        Intrinsics.checkNotNullParameter(r23, "webViewModel");
        String r13 = "providerFactory";
        Intrinsics.checkNotNullParameter(r24, "providerFactory");
        Map<String, i36.d> r1 = MonitorManager.a;
        MonitorManager.O(r23.d, AnnieXCardScene.NEW);
        boolean r10 = com.bytedance.ies.bullet.kit.web.impl.c.s;
        int r11 = 0;
        if (com.bytedance.ies.bullet.kit.web.impl.c.s == false) goto L6;
        HybridLogger.m("XWebKit", "cold start this time", null, null, 12);
        com.bytedance.ies.bullet.kit.web.impl.c.s = false;
    L6:
        if ((r22 instanceof com.bytedance.android.anniex.lite.container.n) == false) goto L8;
        this.I = r22;
        this.m = true;
    L8:
        Long r14 = this.E;
        if (r14 == null) goto L11;
        MonitorManager.U(r23.d, r14.longValue());
    L11:
        Long r15 = this.F;
        if (r15 == null) goto L16;
        long r16 = r15.longValue();
        SSWebView r17 = this.e;
        if (r17 == null) goto L16;
        MonitorManager.V(r17, r23.d, r16);
    L16:
        WebView r18 = this.e;
        if (r18 == null) goto L47;
        m r19 = m.f;
        String r20 = this.a;
        s26.d r25 = s26.d.c;
        MonitorReportService r26 = (com.bytedance.ies.bullet.service.base.r) s26.d.c.d(r20, com.bytedance.ies.bullet.service.base.r.class);
        if (r26 != null) goto L21;
        Lazy r27 = MonitorReportService.d;
        r26 = MonitorReportService.a.a();
    L21:
        q0 r28 = r26.getMonitorConfig();
        r19.getClass();
        com.bytedance.android.monitorV2.webview.c r29 = new com.bytedance.android.monitorV2.webview.c();
        r29.h = r28.d;
        r29.g = r28.c;
        r29.f = r28.b;
        Map r110 = x26.a.a;
        w26.g r111 = (w26.g) x26.a.a(w26.g.class);
        if (r111 == null) goto L33;
        w26.h r112 = (w26.h) r111.n0(w26.h.class);
        if (r112 == null) goto L33;
        String[] r113 = r112.e();
        if (r113 == null) goto L33;
        int r114 = r113.length;
    L28:
        if (r11 >= r114) goto L33;
        int r115 = r114;
        String[] r116 = r113;
        int r30 = 2;
        String r117 = r13;
        String r118 = r12;
        if (StringsKt.contains$default(r23.b, r113[r11], false, 2, null) == true) goto L31;
        r11 = r11 + 1;
        r114 = r115;
        r113 = r116;
        r13 = r117;
        r12 = r118;
        goto L28
    L31:
        boolean r31 = false;
    L34:
        r29.e = Boolean.valueOf(r31).booleanValue();
        r29.a(new WebView[]{r18});
        if (com.bytedance.ies.bullet.base.settings.c.a().g() != 1) goto L37;
        final WeakReference r32 = new WeakReference(this.c);
        Function0<WeakReference<AnnieXWebModel>> r119 = new AnnieXWebKit$getWeakReference$1(r32);
    L38:
        r29.j = new jb.a(r119);
        r29.i = "AnnieXWeb";
        r29.n = r23.d;
        r19.h(r29);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnnieXWebKit$initMonitorConfig$2(r23, null), 3, null);
        ExecutorService r33 = com.bytedance.ies.bullet.service.monitor.a.a;
        String r34 = r23.d;
        String r35 = this.j.getValue();
        Locale r36 = Locale.ROOT;
        if (r35 == null) goto L46;
        com.bytedance.ies.bullet.service.monitor.a.a(r34, "AnnieXArch", r35.toUpperCase(r36));
        SLMonitorCompat r37 = SLMonitorCompat.a;
        String r38 = r23.d;
        String r120 = this.j.getValue();
        if (r120 == null) goto L44;
        String r39 = r120.toUpperCase(r36);
        r37.getClass();
        SLMonitorCompat.b(r38, "AnnieXArch", r39);
        m.f.A(r18);
    L48:
        if (r24 == null) goto L50;
        this.D.b(r24);
    L50:
        SSWebView r121 = this.e;
        if (r121 == null) goto L88;
        m16.b r40 = this.D;
        if (r121.getArgusAdapter$anniex_release() == null) goto L65;
        HybridLogger r41 = HybridLogger.a;
        StringBuilder r42 = new StringBuilder("webview@");
        r42.append(r121.hashCode());
        r42.append(", already has argus adapter: ");
        ArgusWebDelegateAdapter r43 = r121.getArgusAdapter$anniex_release();
        if (r43 == null) goto L57;
        int r44 = r43.hashCode();
    L58:
        r42.append(r44);
        r42.append(", delegate: ");
        ArgusWebDelegateAdapter r45 = r121.getArgusAdapter$anniex_release();
        if (r45 == null) goto L63;
        ArgusWebDelegate r46 = r45.a;
        if (r46 == null) goto L63;
        Object r47 = Integer.valueOf(r46.hashCode());
    L64:
        r42.append(r47);
        r42.append(", return");
        HybridLogger.p("XWebKit", r42.toString(), null, 12);
    L63:
        r47 = null;
        goto L64
    L57:
        r44 = 0;
        goto L58
    L65:
        j r48 = r23.h;
        if (r48 == null) goto L68;
        t36.f r49 = r48.d;
    L70:
        if ((r49 instanceof v36.e) == false) goto L72;
        v36.e r50 = (v36.e) r49;
    L73:
        if (r50 == null) goto L80;
        y36.i r51 = r50.k;
        if (r51 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("secureLinkScene");
        r51 = null;
    L78:
        if (r51 == null) goto L80;
        String r52 = (String) r51.b;
    L81:
        String r53 = r52;
        if (r23.e != true) goto L84;
        boolean r54 = true;
    L85:
        if (r54 == true) goto L87;
        r121.setSecureLinkScene(r53);
    L87:
        int r55 = ArgusWebDelegateAdapter.h;
        char r122 = 1;
        ArgusWebDelegateAdapter r56 = ArgusWebDelegateAdapter.a.a(new com.bytedance.android.anniex.web.c(r23, r53, this, r40, r54), r121);
        this.C = r56;
        r121.setArgusAdapter$anniex_release(r56);
        this.f.b.e().b = r56;
    L89:
        SSWebView r123 = this.e;
        if (r123 == null) goto L204;
        int r57 = t.a;
        m16.b r58 = this.D;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, r118);
        Intrinsics.checkNotNullParameter(r123, "webView");
        Intrinsics.checkNotNullParameter(this, "annieXWebKit");
        Intrinsics.checkNotNullParameter(r58, "contextProviderFactory");
        Map<String, i36.d> r59 = MonitorManager.a;
        MonitorManager.k(r23.d);
        Map r60 = x26.a.a;
        w26.g r61 = (w26.g) x26.a.a(w26.g.class);
        if (r61 == null) goto L98;
        w26.e r62 = (w26.e) r61.n0(w26.e.class);
        if (r62 == null) goto L98;
        Boolean r63 = r62.k1();
        if (r63 == null) goto L98;
        boolean r64 = r63.booleanValue();
    L99:
        if (r64 == true) goto L101;
        String r65 = r23.a;
    L105:
        String r124 = r65;
    L106:
        String r66 = r23.d;
        ArgusWebDelegateAdapter r67 = this.C;
        if (r67 == null) goto L109;
        ArgusWebDelegate r68 = r67.a;
    L110:
        String r125 = "contextProviderFactory";
        WebBDXBridge r69 = new WebBDXBridge(r21, r66, r123, r124, r68);
        s26.d r70 = s26.d.c;
        m0 r71 = s26.d.c.c(m0.class);
        if (r71 == null) goto L113;
        r71.a0();
    L113:
        WebBridgeProtocol[] r72 = new WebBridgeProtocol[r30];
        r72[0] = new je7.a(r124);
        r72[r122] = new je7.b(r124);
        r69.F(r72);
        m0 r73 = s26.d.c.c(m0.class);
        if (r73 == null) goto L118;
        com.bytedance.ies.bullet.service.base.d r74 = r73.a0();
        if (r74 == null) goto L118;
        List r75 = r74.n;
        r69.s = Boolean.FALSE;
        r69.r = r75;
    L118:
        r69.x(m16.b.class, r58);
        s26.d r76 = s26.d.c;
        String r77 = r23.a;
        String r78 = "default_bid";
        if (r77 != null) goto L121;
        r77 = "default_bid";
    L121:
        k16.a r79 = (k16.b) r76.d(r77, k16.b.class);
        if ((r79 instanceof k16.a) == false) goto L124;
        k16.a r80 = r79;
    L125:
        if (r80 == null) goto L127;
        Intrinsics.checkNotNullParameter(r58, r117);
    L127:
        s26.d r81 = s26.d.c;
        String r82 = r23.a;
        if (r82 == null) goto L131;
        r78 = r82;
    L131:
        k16.a r83 = (k16.b) r81.d(r78, k16.b.class);
        if ((r83 instanceof k16.a) == false) goto L134;
        k16.a r84 = r83;
    L135:
        if (r84 == null) goto L142;
        List r85 = r84.H0(r58);
        if (r85 == null) goto L142;
        Iterator r86 = r85.iterator();
    L140:
        if (r86.hasNext() == false) goto L142;
        r69.z((IDLXBridgeMethod) r86.next());
    L142:
        BulletContext r87 = r23.l;
        r87.b(r21);
        r69.x(BulletContext.class, r87);
        BulletContext r88 = r23.l;
        if (r88 == null) goto L146;
        r88.p = new l(r23, this, r69);
    L146:
        ta.a r89 = new ta.a();
        Intrinsics.checkNotNullParameter(r89, "intercept");
        ((BDXBridge) r69).i = r89;
        r58.g(Context.class, r123.getContext());
        r58.g(WebView.class, r123);
        r58.g(BulletContext.class, r23.l);
        r58.g(XBridgeMethod.b.class, new com.bytedance.android.anniex.ability.o(this));
        r58.g(com.bytedance.ies.xbridge.IDLXBridgeMethod.b.class, new p(this));
        com.bytedance.android.anniex.assemble.a r90 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXCustomActivityService r91 = (IAnnieXCustomActivityService) com.bytedance.android.anniex.assemble.a.g(r23.a, IAnnieXCustomActivityService.class);
        if (r91 == null) goto L149;
        r69.x(IAnnieXCustomActivityService.class, r91);
    L149:
        r69.x(ue7.b.class, new com.bytedance.android.anniex.ability.m(r23));
        s26.d r92 = s26.d.c;
        k16.a r93 = (k16.b) s26.d.c.d(r23.a, k16.b.class);
        if (r93 == null) goto L168;
        ExecutorService r94 = BulletLogger.a;
        m16.b r95 = null;
        BulletLogger.k("DefaultLynxDelegate.onLynxViewCreated, createMethodFinder from ".concat(r93.getClass().getName()), null, null, 6);
        m16.b r96 = (m16.b) r69.o.getService(m16.b.class);
        if (r96 == null) goto L154;
        List r97 = r93.L(r96);
    L155:
        if (r97 == null) goto L161;
        Iterator r98 = r97.iterator();
    L158:
        if (r98.hasNext() == false) goto L161;
        r69.d((MethodFinder) r98.next());
    L161:
        if ((r93 instanceof k16.a) == false) goto L169;
        MethodFinder r99 = r93.G0(r58);
        if (r99 == null) goto L166;
        r69.e(r99, 0);
    L166:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r23.c, "enable_annie_jsb_for_common"), "1") == false) goto L169;
        x0.c(r23, r123, r69, r58, this);
    L169:
        String r100 = r23.a;
        Lazy r101 = AnnieXSettings.a;
        if (AnnieXSettings.a() == false) goto L172;
        AnnieXServiceCenter.a.getClass();
        IAnnieXContextProvider r102 = (IAnnieXContextProvider) AnnieXServiceCenter.d(r100, IAnnieXContextProvider.class);
    L176:
        if (r102 == null) goto L180;
        HashSet r103 = r102.y();
        if (r103 == null) goto L180;
        Intrinsics.checkNotNullParameter(r103, "method");
        ((HashSet) ((BDXBridge) r69).f.getValue()).addAll(r103);
    L180:
        s r104 = new s(r23, r69, this);
        r69.o.a(ue7.c.class, r104);
        m16.b r105 = (m16.b) r69.o.getService(m16.b.class);
        if (r105 == null) goto L183;
        r105.d(p56.b.class, new q(r23));
        r105.d(ue7.c.class, r104);
        r105.d(h16.e.class, new com.bytedance.android.anniex.ability.r(r23, this));
    L183:
        Map r106 = x26.a.a;
        w26.g r107 = (w26.g) x26.a.a(w26.g.class);
        if (r107 == null) goto L190;
        w26.e r108 = (w26.e) r107.n0(w26.e.class);
        if (r108 == null) goto L190;
        Boolean r109 = r108.A0();
        if (r109 == null) goto L190;
        boolean r126 = r109.booleanValue();
    L191:
        if (r126 == false) goto L194;
        Task.callInBackground(new com.bytedance.android.anniex.ability.n(r23, this, r69));
    L194:
        if (com.bytedance.ies.bullet.service.base.h.j() == true) goto L197;
    L199:
        LinkedHashMap r127 = new LinkedHashMap();
        Lazy r128 = OptimizeConfigKt.a;
        r127.put("can_run_in_background_fix", Boolean.valueOf(com.bytedance.ies.bullet.service.base.h.B()));
        r127.put("xbridge_model_proxy_enhancement", Boolean.valueOf(com.bytedance.ies.bullet.service.base.h.m0()));
        r69.f(r127);
        Map<String, i36.d> r129 = MonitorManager.a;
        MonitorManager.l(r23.d);
        this.l = r69;
        ArgusWebDelegateAdapter r130 = this.C;
        if (r130 == null) goto L205;
        ArgusWebDelegate r131 = r130.a;
        if (r131 == null) goto L205;
        WebChromeClientDispatcher r132 = this.f.b.c();
        com.bytedance.ies.bullet.secure.c r133 = new com.bytedance.ies.bullet.secure.c(r131);
        r132.getClass();
        Intrinsics.checkNotNullParameter(r133, "webChromeClient");
        r132.a.add(0, r133);
    L205:
        SSWebView r134 = this.e;
        if (r134 != null) goto L208;
    L214:
        SSWebView r135 = this.e;
        if (r135 == null) goto L231;
        WebEngineGlobalConfig r136 = this.B;
        if (r136 == null) goto L221;
        e26.b r137 = r136.e;
        if (r137 == null) goto L221;
        r137.h0(r135.getSettings(), r135, this.D);
    L221:
        WebEngineGlobalConfig r138 = this.B;
        if (r138 == null) goto L231;
        List r139 = r138.f;
        if (r139 == null) goto L231;
        List r140 = CollectionsKt.reversed(r139);
        if (r140 == null) goto L231;
        Iterator r141 = r140.iterator();
    L229:
        if (r141.hasNext() == false) goto L231;
        ((e26.b) r141.next()).h0(r135.getSettings(), r135, this.D);
    L231:
        SSWebView r142 = this.e;
        if (r142 == null) goto L240;
        j r143 = r23.h;
        if (r143 == null) goto L240;
        Integer r144 = (Integer) ((y36.i) new y36.r(r143.a, "content_bg_color")).b;
        Integer r145 = (Integer) ((y36.i) new y36.r(r143.a, "web_bg_color")).b;
        if (r144 == null) goto L238;
        r142.setBackgroundColor(r144.intValue());
    L238:
        if (r145 == null) goto L240;
        r142.setBackgroundColor(r145.intValue());
    L240:
        SSWebView r146 = this.e;
        if (r146 == null) goto L245;
        ArgusWebDelegateAdapter r147 = this.C;
        if (r147 == null) goto L245;
        r147.g(r146);
    L245:
        this.D.b(r24);
        this.c = r23;
        if (com.bytedance.ies.bullet.service.base.h.V() == false) goto L254;
        s26.d r148 = s26.d.c;
        if (s26.d.c.d(this.a, b36.d.class) == null) goto L251;
        this.n = new kb.c(r23, this.b);
    L251:
        if (s26.d.c.d(this.a, e26.b.class) == null) goto L254;
        this.o = new kb.b(this.D, this.a);
    L254:
        if (((((Map) r23.k.getValue()).isEmpty() ? 1 : 0) ^ r122) == 0) goto L260;
        Uri.Builder r149 = r23.c.buildUpon();
        Iterator r150 = ((Map) r23.k.getValue()).entrySet().iterator();
    L257:
        if (r150.hasNext() == false) goto L259;
        Map.Entry r151 = (Map.Entry) r150.next();
        r149.appendQueryParameter((String) r151.getKey(), (String) r151.getValue());
        goto L257
    L259:
        this.u = r149.build();
    L265:
        WebBDXBridge r152 = this.l;
        if (r152 == null) goto L270;
        com.bytedance.sdk.xbridge.cn.platform.web.c r153 = r152.o;
        if (r153 == null) goto L270;
        r95 = (m16.b) r153.getService(m16.b.class);
    L270:
        if (r95 != null) goto L276;
        WebBDXBridge r154 = this.l;
        if (r154 == null) goto L276;
        com.bytedance.sdk.xbridge.cn.platform.web.c r155 = r154.o;
        if (r155 == null) goto L276;
        r155.a(m16.b.class, this.D);
    L276:
        AnnieXWebModel r156 = this.c;
        if (r156 == null) goto L281;
        BulletContext r157 = r156.l;
        if (r157 == null) goto L281;
        r157.b(r21);
    L281:
        WebBDXBridge r158 = this.l;
        if (r158 == null) goto L333;
        com.bytedance.sdk.xbridge.cn.platform.web.c r159 = r158.o;
        if (r159 == null) goto L333;
        m16.b r160 = (m16.b) r159.getService(m16.b.class);
        if (r160 == null) goto L333;
        com.bytedance.ies.bullet.service.webkit.b r161 = this.t;
        r161.getClass();
        Intrinsics.checkNotNullParameter(r160, r125);
        r161.b = r160;
        Map<String, Object> r162 = r23.g;
        if (r162 == null) goto L330;
        r162.put("containerID", r23.d);
        r162.put("forestSessionId", r23.d);
        Uri r163 = this.u;
        if (r163 == null) goto L293;
        r162.put(com.bytedance.android.ec.core.event.a.KEY_LOCATION, r163.toString());
    L293:
        if ((r21 instanceof Application) == false) goto L317;
        ConcurrentHashMap<String, Object> r164 = com.bytedance.android.anniex.ability.f.a;
        String r165 = r23.a;
        Application r166 = (Application) r21;
        Intrinsics.checkNotNullParameter(r165, "bid");
        Intrinsics.checkNotNullParameter(r166, "application");
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
    L314:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        throw th;
    L296:
        if (Intrinsics.areEqual(r165, "webcast") == false) goto L310;
        Map<? extends Object, ? extends Object> r167 = com.bytedance.android.anniex.ability.f.q(r166);     // Catch: Throwable -> L314
        if (r167 == null) goto L309;
        Object r168 = r167.get("statusBarHeight");     // Catch: Throwable -> L314
        Object r169 = r167.get("screenWidth");     // Catch: Throwable -> L314
        Object r170 = r167.get("screenHeight");     // Catch: Throwable -> L314
        Object r171 = r167.get("safeAreaHeight");     // Catch: Throwable -> L314
        Map<? extends String, ? extends Object> r172 = new LinkedHashMap();     // Catch: Throwable -> L314
        r172.putAll(r167);     // Catch: Throwable -> L314
        if (r168 == 0) goto L303;
        Intrinsics.checkNotNull(r168, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L314
        r172.put("statusBarHeight", Float.valueOf(((Integer) r168).intValue()));     // Catch: Throwable -> L314
        r172.put("status_bar_height", Float.valueOf(((Integer) r168).intValue()));     // Catch: Throwable -> L314
    L303:
        if (r169 == 0) goto L305;
        Intrinsics.checkNotNull(r169, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L314
        r172.put("screenWidth", Float.valueOf(((Integer) r169).intValue()));     // Catch: Throwable -> L314
    L305:
        if (r170 == 0) goto L307;
        Intrinsics.checkNotNull(r170, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L314
        r172.put("screenHeight", Float.valueOf(((Integer) r170).intValue()));     // Catch: Throwable -> L314
    L307:
        if (r171 == 0) goto L311;
        Intrinsics.checkNotNull(r171, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L314
        r172.put("safeAreaHeight", Float.valueOf(((Integer) r171).intValue()));     // Catch: Throwable -> L314
    L311:
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        if (r172 == null) goto L317;
        r162.putAll(r172);
        goto L317
    L309:
        r172 = null;
        goto L311
    L310:
        r172 = com.bytedance.android.anniex.ability.f.q(r166);     // Catch: Throwable -> L314
    L317:
        ConcurrentHashMap<String, Object> r173 = com.bytedance.android.anniex.ability.f.a;
        String r174 = r23.a;
        KitType r175 = KitType.WEB;
        com.bytedance.android.anniex.ability.f.p(r174, r175, r21);
        if (ib.e.c(r23.h) == true) goto L320;
    L326:
        Uri r176 = this.u;
        if (r176 != null) goto L329;
        r176 = r23.c;
    L329:
        r162.putAll(com.bytedance.android.anniex.ability.f.s(r175, r176, r23.a, r23.d, false));
        this.t.b(r162);
        goto L330
    L320:
        if (com.bytedance.ies.bullet.service.base.h.q() == false) goto L326;
        com.bytedance.android.anniex.assemble.a r177 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXBizPropsProvider r178 = (IAnnieXBizPropsProvider) com.bytedance.android.anniex.assemble.a.g(this.a, IAnnieXBizPropsProvider.class);
        if (r178 == null) goto L326;
        Map<String, Object> r179 = r178.c(this.a, r175, r21);
        if (r179 == null) goto L326;
        r23.g.putAll(r179);
    L330:
        SSWebView r180 = this.e;
        if (r180 == null) goto L333;
        this.t.a(r180);
    L333:
        Uri r181 = this.u;
        if (r181 != null) goto L336;
        r181 = r23.c;
    L336:
        j r182 = r23.h;
        Map<String, Object> r183 = r23.g;
        int r184 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(UriProtector.getQueryParameter(r181, "appended_global_props")) == true) goto L391;
        Map r185 = x26.a.a;
        w26.g r186 = (w26.g) x26.a.a(w26.g.class);
        if (r186 == null) goto L346;
        w26.e r187 = (w26.e) r186.n0(w26.e.class);
        if (r187 == null) goto L346;
        Boolean r188 = r187.G0();
        if (r188 == null) goto L346;
        boolean r189 = r188.booleanValue();
    L348:
        if (r189 == false) goto L370;
        if (r182 == null) goto L351;
        t36.f r190 = r182.d;
    L352:
        Intrinsics.checkNotNull(r190, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel");
        y36.i r191 = ((v36.e) r190).q;
        if (r191 != null) goto L356;
        Intrinsics.throwUninitializedPropertyAccessException("appendGlobalProps");
        r191 = null;
    L356:
        List r192 = (List) r191.b;
        if (r192 == null) goto L391;
        if (HybridSecureUtil.a(r181) == false) goto L391;
        LinkedHashMap r193 = new LinkedHashMap();
        Iterator r194 = r192.iterator();
    L363:
        if (r194.hasNext() == false) goto L369;
        String r195 = (String) r194.next();
        if (r183 == null) goto L363;
        Object r196 = r183.get(r195);
        if (r196 == null) goto L363;
        r193.put(r195, r196);
        goto L363
    L369:
        r181 = r181.buildUpon().appendQueryParameter("appended_global_props", new JSONObject(r193).toString()).build();
        goto L391
    L351:
        r190 = null;
        goto L352
    L370:
        if (r182 == null) goto L372;
        t36.f r197 = r182.d;
    L373:
        Intrinsics.checkNotNull(r197, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel");
        y36.i r198 = ((v36.e) r197).q;
        if (r198 != null) goto L378;
        Intrinsics.throwUninitializedPropertyAccessException("appendGlobalProps");
        r198 = null;
    L378:
        if (HybridSecureUtil.a(r181) == false) goto L391;
        LinkedHashMap r199 = new LinkedHashMap();
        List r200 = (List) r198.b;
        if (r200 == null) goto L390;
        Iterator r201 = r200.iterator();
    L384:
        if (r201.hasNext() == false) goto L390;
        String r202 = (String) r201.next();
        if (r183 == null) goto L384;
        Object r203 = r183.get(r202);
        if (r203 == null) goto L384;
        r199.put(r202, r203);
    L390:
        r181 = r181.buildUpon().appendQueryParameter("appended_global_props", new JSONObject(r199).toString()).build();
        goto L391
    L372:
        r197 = null;
    L346:
        r189 = true;
    L391:
        this.u = r181;
        SSWebView r204 = this.e;
        if (r204 == null) goto L409;
        h r205 = new h(r23, this, r21, r204);
        String r0 = r23.d;
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        r204.k = r0;
        SSWebView.a r206 = r204.o;
        r206.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r206.a = r0;
        this.D.g(ue7.c.class, r205);
        if (com.bytedance.ies.bullet.service.base.h.F() == false) goto L396;
        this.D.d(ContainerBidParam.class, new ContainerBidParam(this.a));
    L396:
        String r207 = r23.a;
        Lazy r208 = AnnieXSettings.a;
        if (AnnieXSettings.a() == false) goto L399;
        AnnieXServiceCenter.a.getClass();
        IAnnieXContextProvider r209 = (IAnnieXContextProvider) AnnieXServiceCenter.d(r207, IAnnieXContextProvider.class);
    L403:
        if (r209 == null) goto L409;
        if (this.D != null) goto L407;
        new m16.b();
    L407:
        r209.A0();
        goto L409
    L399:
        com.bytedance.android.anniex.assemble.a r210 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r211 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r207, IAnnieXContextProvider.class);
        if (r211 != null) goto L402;
        s26.d r212 = s26.d.c;
        r209 = (IAnnieXContextProvider) s26.d.c.d(r207, IAnnieXContextProvider.class);
        goto L403
    L402:
        r209 = r211;
    L409:
        if (r22 == null) goto L411;
        r22.onLoadStart(String.valueOf(this.u), this.e);
    L411:
        Long r213 = com.bytedance.android.anniex.lite.utils.b.a(this.u, r23.d, this.D);
        if (r213 == null) goto L414;
        ((Handler) this.J.getValue()).postDelayed(new g(this, r23, r22), r213.longValue());
        return;
    L414:
        Uri r214 = this.u;
        if (r214 != null) goto L417;
        r214 = r23.c;
    L417:
        h(r214, false, r22, this.D);
        m(r23);
        return;
    L260:
        AnnieXWebModel r215 = this.c;
        if (r215 == null) goto L263;
        m16.b r216 = r215.c;
    L264:
        this.u = r216;
        goto L265
    L263:
        r216 = r95;
        goto L264
    L208:
        if (r23.e == false) goto L214;
        Map r217 = com.bytedance.ies.bullet.web.pia.c.a;
        m16.b r218 = com.bytedance.ies.bullet.web.pia.c.a(r23.a, r23.d);
        if (r218 == null) goto L212;
        r218.a(r134, r23.l);
        r134.setPiaLifeCycle$anniex_release(r218);
    L213:
        this.d = r218;
        goto L214
    L212:
        r218 = r95;
        goto L213
    L197:
        if (Intrinsics.areEqual(r23.a, "webcast") == false) goto L199;
        List r219 = CollectionsKt.listOf(new com.bytedance.sdk.xbridge.cn.optimize.c(SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"}), SetsKt.hashSetOf(new String[]{"sendLogV3", "setStorage"}), 26));
        r69.s = Boolean.TRUE;
        r69.r = r219;
    L190:
        r126 = false;
        goto L191
    L172:
        com.bytedance.android.anniex.assemble.a r220 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r221 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r100, IAnnieXContextProvider.class);
        if (r221 != null) goto L175;
        s26.d r222 = s26.d.c;
        r102 = (IAnnieXContextProvider) s26.d.c.d(r100, IAnnieXContextProvider.class);
        goto L176
    L175:
        r102 = r221;
        goto L176
    L154:
        r97 = null;
        goto L155
    L168:
        r95 = null;
        goto L169
    L134:
        r84 = null;
        goto L135
    L124:
        r80 = null;
        goto L125
    L109:
        r68 = null;
        goto L110
    L101:
        if (Intrinsics.areEqual(r23.a, "webcast") == false) goto L103;
        r124 = "webcast";
        goto L106
    L103:
        r65 = "";
    L98:
        r64 = true;
        goto L99
    L204:
        r125 = "contextProviderFactory";
        r95 = null;
        goto L205
    L84:
        r54 = false;
    L80:
        r52 = null;
        goto L81
    L72:
        r50 = null;
        goto L73
    L68:
        r49 = null;
    L88:
        r122 = 1;
        goto L89
    L44:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L46:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        r119 = new AnnieXWebKit$getWeakReference$2(this);
    L33:
        r118 = r12;
        r117 = r13;
        r30 = 2;
        r31 = r28.g;
        goto L34
    L47:
        r118 = "webViewModel";
        r117 = "providerFactory";
        r30 = 2;
        goto L48
    }

    public final Pair<Boolean, Scene> l(WebResourceRequest r1, q26.j r10, BulletContext r11, j r12) {
        return r.a.b(this, r1, r10, r11, r12);
    }

    public final Pair<Boolean, Scene> e(String r1, boolean r10, q26.j r11, BulletContext r12, j r13) {
        return r.a.c(this, r1, r10, r11, r12, r13);
    }
}
