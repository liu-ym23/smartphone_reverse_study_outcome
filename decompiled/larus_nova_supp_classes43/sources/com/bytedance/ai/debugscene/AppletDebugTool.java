package com.bytedance.ai.debugscene;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.debug.IAISDKDebugService$a;
import com.bytedance.ai.infra.thread_pool.AISdkCoroutineUtil;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.monitor.timeline.OpenFrom;
import com.bytedance.debugrouter.DebugRouter;
import com.bytedance.debugrouter.DebugRouterGlobalHandler;
import com.bytedance.debugrouter.DebugRouterSessionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.ILynxDevToolService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import m5.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletDebugTool implements DebugRouterGlobalHandler, DebugRouterSessionHandler {
    public static volatile boolean f;
    public static final Set<String> g = null;
    public final String a;
    public final String b;
    public final j1 c;
    public final q1 d;
    public final ILynxDevToolService e;

    public static final class a {
    }

    public final void onSessionCreate(int r1, String r10) {
    }

    public final void openCard(String r1) {
    }

    static {
        g = SetsKt.setOf(new String[]{"enable_cdp_domain_dom", "enable_cdp_domain_css", "enable_cdp_domain_page", "enable_cdp_domain_debugger", "enable_cdp_domain_runtime"});
    }

    public static void b() {
        h1.a.getClass();
        Object r0 = h1.i;
        monitor-enter(r0);
        boolean r10 = true;
        if (h1.b == false) goto L7;
    L14:
        boolean r1 = true;
    L15:
        monitor-exit(r0);
        h1.c(new IllegalStateException("debug router channel closed before Applet_Connected"), null);
        h1.b();
        h1.f = false;
        String r11 = h1.d;
        h1.d = null;
        h1.b = false;
        t2.a.getClass();
        t2.b(false);
        t2.c();
        com.bytedance.ai.utils.g.a.i("AppletDebugTool", "debug channel closed");
        DebugRouter.getInstance().disableDebugChannel();
        if (r11 != null) goto L19;
    L22:
        if (r10 == true) goto L24;
        h1.e(r11);
    L25:
        if (r1 == false) goto L35;
        IAISDKDebugService$a r12 = h1.e;
        if (r12 == null) goto L36;
        r12.a();
        return;
    L36:
        return;
    L35:
        return;
    L24:
        h1.e("");
        goto L25
    L19:
        if (StringsKt.isBlank(r11) == true) goto L22;
        r10 = false;
        goto L22
    L7:
        if (h1.c == true) goto L14;
        if (h1.d != null) goto L14;
        if (h1.j != null) goto L14;
        r1 = false;
    L30:
        th = move-exception;
        throw th;
    }

    public static void c() {
        DebugRouter.getInstance().disableDebugChannel();
        d();
        boolean r0 = com.bytedance.ai.widget.n.b;
        com.bytedance.ai.widget.n.b = false;
        ConcurrentHashMap<String, Widget> r1 = com.bytedance.ai.widget.cache.a.a;
        com.bytedance.ai.widget.cache.a.c = false;
    }

    public static void d() {
        LynxEnv.inst().enableLynxDebug(false);
        LynxEnv.inst().enableDebugMode(false);
        DevToolSettings.inst().setEnabledCDPDomains(SetsKt.emptySet());
    }

    public static JavaOnlyMap f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "settings");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r11 = StringsKt.split$default(r10, new String[]{"&"}, false, 0, 6, null).iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        List r1 = StringsKt.split$default((String) r11.next(), new String[]{"="}, false, 0, 6, null);
        if (r1.size() != 2) goto L4;
        r0.put(ListProtector.get(r1, 0), ListProtector.get(r1, 1));
        goto L4
    L9:
        return JavaOnlyMap.from(r0);
    }

    public static void k(String r11) {
        Intrinsics.checkNotNullParameter(r11, "packageName");
        AIDebugManager.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "packageName");
        AppletDebugTool r1 = AIDebugManager.b;
        if (r1 == null) goto L9;
        j1 r10 = r1.c;
        if (r10 == null) goto L9;
        Intrinsics.checkNotNullParameter(r11, "appletName");
        r10.b.remove("host_" + r11);
        r10.b.remove("verify_" + r11);
        r10.b.remove("sign_version_" + r11);
        r10.b.remove("encrypted_" + r11);
        r10.b.remove("version_tag_" + r11);
        r10.b.remove("show_debug_tag_" + r11);
        if (r10.c == false) goto L9;
        SharedPreferences.Editor r12 = r10.a.edit();
        r12.remove("host_" + r11);
        r12.remove("verify_" + r11);
        r12.remove("sign_version_" + r11);
        r12.remove("encrypted_" + r11);
        r12.remove("version_tag_" + r11);
        r12.remove("show_debug_tag_" + r11);
        r12.remove("local_debug_config_" + r11);
        r12.commit();
    L9:
        ConcurrentHashMap<String, com.bytedance.ai.resource.d0> r13 = AIDebugManager.d;
        if (r13.get(r11) == null) goto L12;
        r13.remove(r11);
        AIDebugManager.p.remove(r11);
        AIDebugManager.y(null, r11);
    L12:
        com.bytedance.ai.resource.security.e.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "packageName");
        com.bytedance.ai.resource.security.h.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Set<String> r0 = com.bytedance.ai.resource.security.h.h.keySet();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r0.iterator();
    L14:
        if (r15.hasNext() == false) goto L22;
        Object r16 = r15.next();
        String r17 = (String) r16;
        Intrinsics.checkNotNull(r17);
        int r18 = StringsKt.lastIndexOf$default(r17, '_', 0, false, 6, null);
        boolean r19 = false;
        if (r18 > 0) goto L18;
    L20:
        if (r19 == false) goto L14;
        r14.add(r16);
        goto L14
    L18:
        if (Intrinsics.areEqual(r17.substring(0, r18), r11) == false) goto L20;
        r19 = true;
        goto L20
    L22:
        Iterator r20 = r14.iterator();
    L24:
        if (r20.hasNext() == false) goto L26;
        com.bytedance.ai.resource.security.h.h.remove((String) r20.next());
        goto L24
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AIDebugManager$uninstallPackageFromLocalDebug$2(r11, null), 3, null);
    }

    public final void g(boolean r10) {
        AIDebugManager.a.getClass();
        Iterator r0 = AIDebugManager.c().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        this.c.h(r1, r10);
        goto L4
    L6:
        SharedPreferences.Editor r11 = this.c.a.edit();
        r11.putBoolean("remote_debug_tag_enabled", r10);
        r11.commit();
        v4.c.c();
    }

    public final void onSessionDestroy(int r10) {
        t2.a.getClass();
        Object r0 = r2.a;
        monitor-enter(r0);
        r2.a r1 = r2.d.remove(Integer.valueOf(r10));     // Catch: Throwable -> L12
        Long r11 = null;
        if (r1 == null) goto L9;
        r1.d = null;     // Catch: Throwable -> L12
        q2 r12 = r1.a;     // Catch: Throwable -> L12
        if (r12 == null) goto L9;
        r11 = Long.valueOf(r12.a);     // Catch: Throwable -> L12
    L9:
        monitor-exit(r0);
        com.bytedance.ai.utils.g.a.d("JsbDebugRuntimeRegistry", "unbind session, sessionId:" + r10 + ", handle:" + r11);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public AppletDebugTool(Context r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r12, "appVersion");
        this.a = r11;
        this.b = r12;
        Context r13 = r10.getApplicationContext();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.app.Application");
        this.c = new j1(r10);
        this.d = new q1(this);
        h1.a.getClass();
        Intrinsics.checkNotNullParameter(this, "tool");
        h1.g = this;
        com.bytedance.ai.debug.f.a.getClass();
        Intrinsics.checkNotNullParameter(this, "debugRouterInitializer");
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        r14.i("AppletDebugTool", "do LynxServiceCenter initialize");
        i8a.n r0 = i8a.n.c();
        r0.b((Application) r13);
        ILynxDevToolService r15 = i8a.n.c().a(ILynxDevToolService.class);
        this.e = r15;
        r14.i("AppletDebugTool", "do devtool setLoadQJSBridge true");
        if (r15 == null) goto L6;
        r15.setLoadQJSBridge(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.bytedance.ai.debugscene.p1, java.lang.Runnable] */
    public final void e(String r17, int r18, String r19) {
        t2.a.getClass();
        boolean r10 = true;
        if (Intrinsics.areEqual(r17, "doubao_jsb_debug") == true) goto L5;
        r10 = false;
    L72:
        if (r10 == false) goto L74;
        return;
    L74:
        final q1 r0 = this.d;
        r0.getClass();
        if (Intrinsics.areEqual(r17, "Applet_Connected") == false) goto L77;
        r0.d();
        return;
    L77:
        if (r19 != null) goto L79;
    L82:
        boolean r11 = true;
    L83:
        if (r11 == true) goto L166;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L150
        JSONObject r13 = new JSONObject(r19);     // Catch: Throwable -> L150
        String r14 = r13.optString("method");     // Catch: Throwable -> L150
        if (r14 != null) goto L88;
    L91:
        boolean r15 = true;
    L92:
        if (r15 == true) goto L164;
        q1.b r16 = new q1.b(r13.optJSONObject("params"));     // Catch: Throwable -> L150
        if (StringsKt.contains$default(r14, "Applet", false, 2, null) == false) goto L97;
        com.bytedance.ai.utils.g.a.i("AppletDebugRouterMessageDispatcher", "receive debug router method: " + r14);     // Catch: Throwable -> L150
    L97:
        if (r14 != null) goto L100;
    L148:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L150
    L153:
        if (Result.exceptionOrNull-impl(r1) == null) goto L165;
        com.bytedance.ai.utils.g.a.e("AppletDebugRouterMessageDispatcher", "failed to parse debug router message. type:" + r17 + ", sessionId:" + r18);
        return;
    L165:
        return;
    L100:
        switch(r14.hashCode()) {
            case -2093280924: goto L145;
            case -1920478142: goto L141;
            case -1800539586: goto L137;
            case -1468390565: goto L133;
            case -1313173673: goto L126;
            case -785629596: goto L122;
            case -56874635: goto L118;
            case -28161455: goto L114;
            case 760986163: goto L110;
            case 1534254243: goto L103;
            default: goto L148;
        };
    L103:
        if (r14.equals("Applet_CloseDebugChannel") == false) goto L148;
        com.bytedance.ai.utils.g.a.i("AppletDebugRouterMessageDispatcher", "notifyDebugChannelClosed");     // Catch: Throwable -> L150
        p1 r20 = r0.b;     // Catch: Throwable -> L150
        if (r20 == null) goto L108;
        q1.c.removeCallbacks(r20);     // Catch: Throwable -> L150
    L108:
        r0.b = null;     // Catch: Throwable -> L150
        r0.a.getClass();     // Catch: Throwable -> L150
        b();     // Catch: Throwable -> L150
        goto L148
    L110:
        if (r14.equals("Applet_OpenWidget") == false) goto L148;
        r0.i("Applet_PushWidgetResult", r0.g(r16), r18);     // Catch: Throwable -> L150
        goto L148
    L114:
        if (r14.equals("Applet_OpenPageUrl") == false) goto L148;
        r0.i("Applet_PushPageResult", r0.f(r16, true), r18);     // Catch: Throwable -> L150
        goto L148
    L118:
        if (r14.equals("Applet_AppReload") == false) goto L148;
        r0.a(r16, r18);     // Catch: Throwable -> L150
        goto L148
    L122:
        if (r14.equals("Applet_SetDebugTag") == false) goto L148;
        r0.i("Applet_SetDebugTagResult", r0.e(r13.optJSONObject("params")), r18);     // Catch: Throwable -> L150
        goto L148
    L126:
        if (r14.equals("Applet_Heartbeat") == false) goto L148;
        p1 r21 = r0.b;     // Catch: Throwable -> L150
        if (r21 == null) goto L131;
        q1.c.removeCallbacks(r21);     // Catch: Throwable -> L150
    L131:
        r0.b = null;     // Catch: Throwable -> L150
        ?? r22 = new p1(r0);     // Catch: Throwable -> L150
        q1.c.postDelayed(r22, 3000);     // Catch: Throwable -> L150
        r0.b = r22;     // Catch: Throwable -> L150
        goto L148
    L133:
        if (r14.equals("Applet_CallTool") == false) goto L148;
        r0.i("Applet_CallToolResult", r0.b(r16), r18);     // Catch: Throwable -> L150
        goto L148
    L137:
        if (r14.equals("Applet_OpenPage") == false) goto L148;
        r0.i("Applet_PushPageResult", r0.f(r16, false), r18);     // Catch: Throwable -> L150
        goto L148
    L141:
        if (r14.equals("Applet_DecryptDEK") == false) goto L148;
        r0.i("Applet_DecryptDEKResult", q1.c(r13), r18);     // Catch: Throwable -> L150
        goto L148
    L145:
        if (r14.equals("Applet_Connected") == false) goto L148;
        r0.d();     // Catch: Throwable -> L150
        goto L148
    L164:
        return;
    L88:
        if (r14.length() == 0) goto L91;
        r15 = false;
    L150:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L153
    L166:
        return;
    L79:
        if (r19.length() == 0) goto L82;
        r11 = false;
        goto L83
    L5:
        if (r19 != null) goto L7;
    L10:
        boolean r24 = true;
    L11:
        if (r24 == false) goto L13;
        com.bytedance.ai.utils.g.a.w("JsbDebugTransport", "ignore empty JSB debug message, sessionId:" + r18);
        goto L72
    L13:
        h1.a.getClass();
        String r25 = h1.d;
        com.bytedance.ai.utils.g r26 = com.bytedance.ai.utils.g.a;
        r26.d("JsbDebugTransport", "handle message, appId:" + r25 + ", sessionId:" + r18 + ", messageLength:" + r19.length());
        if (r25 != null) goto L16;
    L19:
        boolean r27 = true;
    L20:
        if (r27 == false) goto L156;
        r26.w("JsbDebugTransport", "ignore JSB debug message because current appId is empty");
        goto L72
    L156:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L24
        Object r29 = Result.constructor-impl(new JSONObject(r19));     // Catch: Throwable -> L24
    L26:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 != null) goto L70;
        JSONObject r31 = (JSONObject) r29;
        String r32 = r31.optString("type");
        Intrinsics.checkNotNull(r32);
        if ((!StringsKt.isBlank(r32)) == true) goto L32;
        r32 = null;
    L32:
        String r33 = r31.optString("requestId");
        Intrinsics.checkNotNull(r33);
        if ((!StringsKt.isBlank(r33)) == true) goto L36;
        r33 = null;
    L36:
        Object r110 = r2.a;
        monitor-enter(r110);
        r2.a r111 = r2.d.get(Integer.valueOf(r18));     // Catch: Throwable -> L67
        if (r111 == null) goto L42;
        Object r112 = r111.b;     // Catch: Throwable -> L67
    L43:
        monitor-exit(r110);
        if (r112 != null) goto L46;
        r112 = t2.d(r18, r25);
    L46:
        if (r112 != null) goto L48;
        com.bytedance.ai.utils.g.a.w("JsbDebugTransport", "drop JSB debug request because runtime is unavailable, appId:" + r25 + ", sessionId:" + r18 + ", type:" + r32 + ", requestId:" + r33);
        goto L72
    L48:
        Function2<? super q2, ? super String, Unit> r113 = p2.a;
        p2.a = new s2();
        JavaOnlyArray r34 = JavaOnlyArray.of(new Object[]{t2.f(r31)});     // Catch: Throwable -> L59
        if ((r112 instanceof LynxView) == false) goto L54;
        ((LynxView) r112).sendGlobalEvent("__DOUBAO_JSB_DEBUG__", r34);     // Catch: Throwable -> L59
    L56:
        Object r35 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L59
    L62:
        if (Result.isSuccess-impl(r35) == false) goto L64;
        Unit r114 = (Unit) r35;
        com.bytedance.ai.utils.g.a.d("JsbDebugTransport", "dispatch JSB debug message, appId:" + r25 + ", sessionId:" + r18 + ", engine:" + r112.getClass().getSimpleName() + ", type:" + r32 + ", requestId:" + r33);
    L64:
        Throwable r36 = Result.exceptionOrNull-impl(r35);
        if (r36 == null) goto L71;
        com.bytedance.ai.utils.g.a.e("JsbDebugTransport", "dispatch JSB debug message failed, appId:" + r25 + ", sessionId:" + r18 + ", type:" + r32 + ", requestId:" + r33 + ", error:" + r36.getMessage());
    L71:
        r10 = true;
        goto L72
    L54:
        if ((r112 instanceof LynxBackgroundRuntime) == false) goto L58;
        ((LynxBackgroundRuntime) r112).f("__DOUBAO_JSB_DEBUG__", r34);     // Catch: Throwable -> L59
        goto L56
    L58:
        throw new IllegalStateException("unsupported runtime: ".concat(r112.getClass().getName()).toString());     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L42:
        r112 = null;
    L67:
        th = move-exception;
        throw th;
    L70:
        com.bytedance.ai.utils.g.a.e("JsbDebugTransport", "invalid JSB debug payload, sessionId:" + r18 + ", error:" + r30.getMessage());
    L24:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L16:
        if (StringsKt.isBlank(r25) == true) goto L19;
        r27 = false;
        goto L20
    L7:
        if (StringsKt.isBlank(r19) == true) goto L10;
        r24 = false;
        goto L11
    }

    public final void onMessage(String r1, int r10, String r11) {
        e(r1, r10, r11);
    }

    public final void onMessage(String r1, String r10, int r11) {
        e(r1, r11, r10);
    }

    public static void j(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "appletName");
        Intrinsics.checkNotNullParameter(r11, "widgetName");
        Intrinsics.checkNotNullParameter(r12, "widgetData");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Map<String, String> r14 = MapsKt.mapOf(new Pair[]{TuplesKt.to("appletId", r10), TuplesKt.to("widgetName", r11), TuplesKt.to("widgetData", r12), TuplesKt.to("botId", r13)});
        r4.h r15 = r4.a.l;
        if (r15 == null) goto L6;
        r15.g(r14, null);
        return;
    }

    public static final void a(AppletDebugTool r10, String r11, final PageInfo r12, final String r13, Map r14) {
        r10.getClass();
        i1 r15 = m5.y0.a;
        m5.y0.m(r13, "applet_page_timeline_full");
        AppletRuntimeManager.o(AppletRuntimeManager.INSTANCE, r11, "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", null, null, r14, new r1(r13, r12), 24);
    }

    public final void i(String r19, String r20, String r21, String r22, JavaOnlyMap r23, String r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r20, "pageName");
        Intrinsics.checkNotNullParameter(r21, "pageUrl");
        Intrinsics.checkNotNullParameter(r22, "pageData");
        Intrinsics.checkNotNullParameter(r23, "pageSettings");
        Intrinsics.checkNotNullParameter(r24, "pageMode");
        Ref.DoubleRef r10 = new Ref.DoubleRef();
        double r11 = 0.5d;
        r10.element = 0.5d;
        Ref.BooleanRef r12 = new Ref.BooleanRef();
        int r13 = r24.hashCode();
        if (r13 == 3154575) goto L23;
        if (r13 == 106852524) goto L19;
        if (r13 == 2010122246) goto L10;
    L25:
        PageType r14 = PageType.FULL_PAGE;
    L26:
        PageType r15 = r14;
        if (r19 != null) goto L29;
    L32:
        boolean r16 = true;
    L33:
        if (r16 == true) goto L36;
        i1 r17 = m5.y0.a;
        String r18 = m5.y0.a("api", r19, r20);
        m5.y0.e(r18, r20, r24, OpenFrom.DEBUG.getFrom());
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("trace_id", r18);
        r110.put("eventName", "applet_page_timeline_full");
        int r0 = AISdkCoroutineUtil.a;
        AISdkCoroutineUtil.a(new AppletDebugTool$startApplet$1(r19, r20, r22, r25, r21, r15, r23, r10, r12, r110, this, r18, null));
        return;
    L36:
        return;
    L29:
        if (r19.length() == 0) goto L32;
        r16 = false;
        goto L33
    L10:
        if (r24.equals("floating") == false) goto L25;
        String r26 = r23.getString("pos");
        if (r26 == null) goto L17;
        Double r27 = StringsKt.toDoubleOrNull(r26);
        if (r27 == null) goto L17;
        r11 = r27.doubleValue();
    L17:
        r10.element = RangesKt.coerceIn(r11, 0.0d, 1.0d);
        r12.element = Intrinsics.areEqual(r23.getString("align"), "left");
        r14 = PageType.FLOATING_VIEW;
        goto L26
    L19:
        if (r24.equals(com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L25;
        r14 = PageType.POPUP_PAGE;
        goto L26
    L23:
        if (r24.equals("full") == false) goto L25;
        r14 = PageType.FULL_PAGE;
        goto L26
    }

    public final void h(final String r18, String r19, boolean r20, String r21, String r22, boolean r23, final String r24, boolean r25, final Function0<Unit> r26, final Function1<? super Throwable, Unit> r27) {
        Intrinsics.checkNotNullParameter(r18, "packageName");
        Intrinsics.checkNotNullParameter(r19, "hostUrl");
        Intrinsics.checkNotNullParameter(r21, "appletType");
        Intrinsics.checkNotNullParameter(r26, "resolve");
        Intrinsics.checkNotNullParameter(r27, "reject");
        AIDebugManager.a.getClass();
        if ((!AIDebugManager.e.isEmpty()) == false) goto L6;
        r27.invoke(new IllegalStateException("Please exit preview mode before enabling end-to-end debug mode."));
        return;
    L6:
        j1 r10 = this.c;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r18, "appletName");
        Intrinsics.checkNotNullParameter(r19, "host");
        String r11 = "host_" + r18;
        String r12 = "verify_" + r18;
        String r13 = "sign_version_" + r18;
        String r14 = "encrypted_" + r18;
        String r15 = "version_tag_" + r18;
        r10.b.put(r11, r19);
        r10.b.put(r12, String.valueOf(r20));
        if (r22 != null) goto L9;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == true) goto L15;
        r10.b.put(r13, r22);
    L16:
        r10.b.put(r14, String.valueOf(r23));
        if (r24 != null) goto L19;
    L22:
        boolean r17 = true;
    L23:
        if (r17 == true) goto L25;
        r10.b.put(r15, r24);
    L27:
        if (r10.c == false) goto L50;
        SharedPreferences.Editor r28 = r10.a.edit();
        r28.putString(r11, r19);
        r28.putBoolean(r12, r20);
        if (r22 != null) goto L31;
    L34:
        boolean r110 = true;
    L35:
        if (r110 == false) goto L37;
        r28.remove(r13);
    L38:
        r28.putBoolean(r14, r23);
        if (r24 != null) goto L41;
    L44:
        boolean r111 = true;
    L45:
        if (r111 == false) goto L47;
        r28.remove(r15);
    L48:
        r28.commit();
        goto L50
    L47:
        r28.putString(r15, r24);
        goto L48
    L41:
        if (r24.length() == 0) goto L44;
        r111 = false;
        goto L45
    L37:
        r28.putString(r13, r22);
        goto L38
    L31:
        if (r22.length() == 0) goto L34;
        r110 = false;
    L50:
        r10.h(r18, r25);
        SharedPreferences.Editor r29 = r10.a.edit();
        r29.putBoolean("remote_debug_tag_enabled", r25);
        r29.commit();
        Unit r30 = Unit.INSTANCE;
        com.bytedance.ai.utils.g r31 = com.bytedance.ai.utils.g.a;
        r31.d("AppletDebugTool", "set applet debug host. Result: " + r30);
        ILynxDevToolService r32 = this.e;
        if (r32 == null) goto L53;
        Boolean r33 = Boolean.valueOf(r32.getLoadQJSBridge());
    L54:
        r31.i("AppletDebugTool", "getLoadQJSBridge present value: " + r33);
        DebugRouter.getInstance().enableDebugChannel();
        AIDebugManager.k(r18, r20, r22, r23, new s1(r24, r18, r26), new t1(r27), r21);
        boolean r1 = com.bytedance.ai.widget.n.b;
        com.bytedance.ai.widget.n.b = true;
        com.bytedance.ai.widget.cache.a.a();
        com.bytedance.ai.widget.cache.a.c = true;
        return;
    L53:
        r33 = null;
        goto L54
    L25:
        r10.b.remove(r15);
        goto L27
    L19:
        if (r24.length() == 0) goto L22;
        r17 = false;
        goto L23
    L15:
        r10.b.remove(r13);
        goto L16
    L9:
        if (r22.length() == 0) goto L12;
        r16 = false;
        goto L13
    }
}
