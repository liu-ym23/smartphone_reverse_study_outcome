package com.bytedance.android.anniex.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import com.bytedance.android.anniex.ability.XBridgeHelper;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.optimize.UsageLynxOptimize;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.android.anniex.utils.e;
import com.bytedance.android.anniex.utils.f;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.lynx.init.LynxConfig;
import com.bytedance.ies.bullet.service.base.m;
import com.bytedance.ies.bullet.service.base.q0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.navigator.NavigationModule;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
        new Handler(Looper.getMainLooper());
    }

    public static final void a(Context r10, AnnieXLynxView r11) {
        TraceEvent.beginSection("AnnieXApi:initCanvasSettings");
        LynxConfig r12 = null;
        LynxKryptonHelper r13 = LynxKryptonUtils.getLynxKryptonHelper(r11);     // Catch: Throwable -> L7
        if (r13 == null) goto L9;
        r13.registerService(KryptonVideoPlayerService.class, new f26.b.a.a(r10));     // Catch: Throwable -> L7
    L9:
        s26.d r14 = s26.d.c;     // Catch: Throwable -> L20
        u26.c r15 = s26.d.c.c(u26.c.class);     // Catch: Throwable -> L20
        if (r15 == null) goto L12;
        m r16 = r15.P();     // Catch: Throwable -> L20
    L14:
        if ((r16 instanceof LynxConfig) == false) goto L16;
        r12 = (LynxConfig) r16;     // Catch: Throwable -> L20
    L16:
        if (r12 == null) goto L18;
        r12.a.getClass();     // Catch: Throwable -> L20
    L18:
        TraceEvent.endSection("AnnieXApi:initCanvasSettings");
        return;
    L12:
        r16 = null;
    L20:
        th = move-exception;
        TraceEvent.endSection("AnnieXApi:initCanvasSettings");
        throw th;
    L7:
        th = move-exception;
        HybridLogger r17 = HybridLogger.a;     // Catch: Throwable -> L20
        HybridLogger.i("AnnieX", "take it easy. just check ttvideo engine sdk is not exist: " + th, null, 12);     // Catch: Throwable -> L20
        goto L9
    }

    @Deprecated(message = "请使用AnnieX.createLynxView(context: Context,annieXLynxViewNextModel: AnnieXLynxViewNextModel)代替", replaceWith = @ReplaceWith(expression = "AnnieX.createLynxView(context: Context,annieXLynxViewNextModel: AnnieXLynxViewNextModel)", imports = {}))
    public static AnnieXLynxView e(Context r16, ra.a r17) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "lynxModel");
        TraceEvent.beginSection("AnnieXApi:createLynxView");
    L86:
        th = move-exception;
        TraceEvent.endSection("AnnieXApi:createLynxView");
        throw th;
    L4:
        if (Intrinsics.areEqual(r17.c, "Loki") == false) goto L6;
        AnnieXLynxView r0 = f.b(r16, r17);     // Catch: Throwable -> L86
    L84:
        TraceEvent.endSection("AnnieXApi:createLynxView");
        return r0;
    L6:
        ra.a.C0191a r10 = r17.o;     // Catch: Throwable -> L86
        boolean r11 = false;
        if (r10 != null) goto L9;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == false) goto L14;
        Map<String, i36.d> r13 = MonitorManager.a;     // Catch: Throwable -> L86
        String r14 = r17.g;     // Catch: Throwable -> L86
        Intrinsics.checkNotNullParameter(r14, "sessionId");     // Catch: Throwable -> L86
        MonitorManager.l.add(r14);     // Catch: Throwable -> L86
    L14:
        Map<String, i36.d> r15 = MonitorManager.a;     // Catch: Throwable -> L86
        MonitorManager.m(r17.g);     // Catch: Throwable -> L86
        com.bytedance.android.monitorV2.lynx.jsb.a r18 = new com.bytedance.android.monitorV2.lynx.jsb.a(0);     // Catch: Throwable -> L86
        LynxViewBuilder r19 = r17.f.d(r17.g, r17.c, r17.t);     // Catch: Throwable -> L86
        TraceEvent.beginSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L86
        r19.registerModule(NavigationModule.NAME, NavigationModule.class, null);     // Catch: Throwable -> L86
        r19.registerModule("hybridMonitor", LynxViewMonitorModule.class, r18);     // Catch: Throwable -> L86
        com.bytedance.android.anniex.assemble.a r110 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L86
        IAnnieXLatchService r111 = (IAnnieXLatchService) com.bytedance.android.anniex.assemble.a.g(r17.c, IAnnieXLatchService.class);     // Catch: Throwable -> L86
        if (r111 == null) goto L17;
        r111.Y();     // Catch: Throwable -> L86
    L17:
        String r112 = r17.f.A;     // Catch: Throwable -> L86
        if (r112 == null) goto L22;
        int r113 = com.bytedance.ies.bullet.secure.a.b;     // Catch: Throwable -> L86
        com.bytedance.ies.bullet.secure.a r114 = com.bytedance.ies.bullet.secure.a.a.a(null, null, r112);     // Catch: Throwable -> L86
        if (r114 == null) goto L22;
        r114.d(r19);     // Catch: Throwable -> L86
    L23:
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L86
        if (r17.n == false) goto L26;
        LynxBDXBridge r115 = XBridgeHelper.a(r16, r17, r19);     // Catch: Throwable -> L86
    L27:
        ra.b r1 = r17.f;     // Catch: Throwable -> L86
        float r116 = r1.x;     // Catch: Throwable -> L86
        if (r116 != 1.0f) goto L30;
        boolean r117 = true;
    L31:
        if (r117 == true) goto L46;
        int r118 = r1.l;     // Catch: Throwable -> L86
        if (r118 == (-1)) goto L35;
    L42:
        if (r118 == (-1)) goto L46;
        int r20 = r1.m;     // Catch: Throwable -> L86
        if (r20 == (-1)) goto L46;
        r19.setScreenSize((int) (r118 * r116), (int) (r20 * r116));     // Catch: Throwable -> L86
        goto L46
    L35:
        if (r1.m != (-1)) goto L42;
        Display r21 = i16.a.c(r16);     // Catch: Throwable -> L86
        if (r21 == null) goto L46;
        Point r119 = new Point();     // Catch: Exception -> L40 Throwable -> L86
        r21.getSize(r119);     // Catch: Exception -> L40 Throwable -> L86
        float r22 = r119.x;     // Catch: Exception -> L40 Throwable -> L86
        float r23 = r1.x;     // Catch: Exception -> L40 Throwable -> L86
        r19.setScreenSize((int) (r22 * r23), (int) (r119.y * r23));     // Catch: Exception -> L40 Throwable -> L86
    L40:
        e = move-exception;
        HybridLogger r24 = HybridLogger.a;     // Catch: Throwable -> L86
        HybridLogger.i("AnnieX", ": " + e, null, 12);     // Catch: Throwable -> L86
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L86
    L46:
        int r26 = UsageLynxOptimize.a;     // Catch: Throwable -> L86
        UsageLynxOptimize.a(r17.f, r19, r17.a);     // Catch: Throwable -> L86
        TraceEvent.endSection("LynxViewBuilderParams:toLynxViewBuilder");     // Catch: Throwable -> L86
        TraceEvent.beginSection("AnnieXLynxView:init");     // Catch: Throwable -> L86
        r0 = new AnnieXLynxView(r16, r17.g, r17.c, r19);     // Catch: Throwable -> L86
        int r27 = e.a;     // Catch: Throwable -> L86
        Uri r28 = r17.b;     // Catch: Throwable -> L86
        Intrinsics.checkNotNullParameter(r28, "uri");     // Catch: Throwable -> L86
        if (r28.getBooleanQueryParameter("use_motion", false) == false) goto L51;
        Intrinsics.checkNotNullParameter(r0, "annieXLynxView");     // Catch: Throwable -> L86
        com.bytedance.ies.bullet.lynx.impl.f r29 = new com.bytedance.ies.bullet.lynx.impl.f();     // Catch: Throwable -> L86
        LynxKryptonHelper r30 = LynxKryptonUtils.getLynxKryptonHelper(r0);     // Catch: Throwable -> L86
        if (r30 == null) goto L51;
        r30.registerService(com.bytedance.ies.bullet.lynx.impl.f.class, r29);     // Catch: Throwable -> L86
    L51:
        if (r115 == null) goto L54;
        r0.x(r115, r17);     // Catch: Throwable -> L86
    L54:
        if (r17.k == true) goto L63;
        ra.a.C0191a r31 = r17.o;     // Catch: Throwable -> L86
        if (r31 != null) goto L58;
    L60:
        boolean r32 = false;
    L61:
        if (r32 == true) goto L63;
        a(r16, r0);     // Catch: Throwable -> L86
        goto L63
    L58:
        if (r31.b != true) goto L60;
        r32 = true;
    L63:
        ra.a.C0191a r33 = r17.o;     // Catch: Throwable -> L86
        if (r33 != null) goto L66;
    L68:
        boolean r34 = false;
    L69:
        if (r34 == false) goto L71;
        c(r33.f, r0, r17.g);     // Catch: Throwable -> L86
    L75:
        r18.a = r0;     // Catch: Throwable -> L86
        r0.setViewZoom(r17.f.x);     // Catch: Throwable -> L86
        String r35 = r17.f.d;     // Catch: Throwable -> L86
        if (r35 == null) goto L78;
        r0.setGroupName(r35);     // Catch: Throwable -> L86
    L78:
        com.bytedance.android.anniex.assemble.a r36 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L86
        IAnnieXLatchService r37 = (IAnnieXLatchService) com.bytedance.android.anniex.assemble.a.g(r17.c, IAnnieXLatchService.class);     // Catch: Throwable -> L86
        if (r37 == null) goto L81;
        r37.Y();     // Catch: Throwable -> L86
    L81:
        if (r114 == null) goto L83;
        r0.w(r114);     // Catch: Throwable -> L86
    L83:
        TraceEvent.endSection("AnnieXLynxView:init");     // Catch: Throwable -> L86
        Map<String, i36.d> r38 = MonitorManager.a;     // Catch: Throwable -> L86
        MonitorManager.n(r0, r17.g);     // Catch: Throwable -> L86
        goto L84
    L71:
        String r39 = r17.c;     // Catch: Throwable -> L86
        if (r17.b.getBooleanQueryParameter("use_card_mode", true) == true) goto L74;
        r11 = true;
    L74:
        b(r39, r0, r11, r17.k, r17.g);     // Catch: Throwable -> L86
        goto L75
    L66:
        if (r33.c != true) goto L68;
        r34 = true;
        goto L69
    L30:
        r117 = false;
        goto L31
    L26:
        r115 = null;
    L22:
        r114 = null;
        goto L23
    L9:
        if (r10.c != true) goto L11;
        r12 = true;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(String r10, AnnieXLynxView r11, String r12) {
        TraceEvent.beginSection("AnnieXApi:initMonitorConfig");
        Map<String, i36.d> r1 = MonitorManager.a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r12, "sessionId");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r11, "container");     // Catch: Throwable -> L9
        sz2.e r13 = sz2.e.a;     // Catch: Throwable -> L9
        sz2.f r14 = new sz2.f(r11, "lynx");     // Catch: Throwable -> L9
        r13.getClass();     // Catch: Throwable -> L9
        sz2.e.b(r12, r14);     // Catch: Throwable -> L9
        sz2.e.f(r12, "container_name", "AnnieX");     // Catch: Throwable -> L9
        if (r10 != null) goto L6;
        r10 = "bullet_custom_bid";
    L6:
        pz2.a r15 = new pz2.a(r10);     // Catch: Throwable -> L9
        r15.b = true;     // Catch: Throwable -> L9
        r15.c = false;     // Catch: Throwable -> L9
        com.bytedance.android.monitorV2.lynx_helper.b.a(r11, r15);     // Catch: Throwable -> L9
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
        TraceEvent.endSection("AnnieXApi:initMonitorConfig");
        return;
    L9:
        th = move-exception;
        TraceEvent.endSection("AnnieXApi:initMonitorConfig");
        throw th;
    }

    public static final void d(Context r10, AnnieXLynxEngine r11, AnnieXLynxView r12) {
        Map r0 = x26.a.a;
        g r1 = (g) x26.a.a(g.class);
        if (r1 == null) goto L9;
        w26.e r13 = (w26.e) r1.n0(w26.e.class);
        if (r13 == null) goto L9;
        Boolean r14 = r13.h2();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        if (r15 == false) goto L13;
        new Handler(Looper.getMainLooper()).postDelayed(new a(r10, r11, r12), 100);
        return;
    L13:
        return;
    L9:
        r15 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.FrameLayout, com.bytedance.android.anniex.ui.AnnieXLynxView, com.lynx.tasm.LynxView] */
    @Deprecated(message = "请使用AnnieX.createLynxViewFromEngine()代替", replaceWith = @ReplaceWith(expression = "AnnieX.createLynxViewFromEngine()", imports = {}))
    public static AnnieXLynxView f(Context r10, ra.a r11, AnnieXLynxEngine r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "lynxModel");
        TraceEvent.beginSection("AnnieXApi:createLynxViewFromEngine");
        Map<String, i36.d> r13 = MonitorManager.a;     // Catch: Throwable -> L35
        MonitorManager.m(r11.g);     // Catch: Throwable -> L35
        TraceEvent.beginSection("AnnieXLynxView:init");     // Catch: Throwable -> L35
        if (r12 != null) goto L6;
        r12 = AnnieXLynxEngineManager.a.a(r11.c, r11.g);     // Catch: Throwable -> L35
    L6:
        if (r12 == null) goto L32;
        MutableContextWrapper r14 = r12.a;     // Catch: Throwable -> L35
        com.bytedance.android.monitorV2.lynx.jsb.a r15 = r12.d;     // Catch: Throwable -> L35
        ?? r16 = new AnnieXLynxView(r10, r11.g, r11.c, r12);     // Catch: Throwable -> L35
        ExecutorService r17 = com.bytedance.ies.bullet.service.monitor.a.a;     // Catch: Throwable -> L35
        com.bytedance.ies.bullet.service.monitor.a.a(r11.g, "is_from_engine", "true");     // Catch: Throwable -> L35
        if (r15 == null) goto L11;
        r15.a = r16;     // Catch: Throwable -> L35
    L11:
        ConcurrentHashMap<String, Object> r18 = com.bytedance.android.anniex.ability.f.a;     // Catch: Throwable -> L35
        Map r19 = com.bytedance.android.anniex.ability.f.o(r16.getContext(), r11.g);     // Catch: Throwable -> L35
        if (Intrinsics.areEqual(r19, com.bytedance.android.anniex.ability.f.o(r14.getBaseContext(), r11.g)) == true) goto L15;
        if (r19 == null) goto L15;
        r16.updateGlobalProps(r19);     // Catch: Throwable -> L35
        d(r10, r12, r16);     // Catch: Throwable -> L35
    L15:
        r14.setBaseContext(r10);     // Catch: Throwable -> L35
        LynxBDXBridge r20 = r12.c;     // Catch: Throwable -> L35
        if (r20 == null) goto L18;
        r16.x(r20, r11);     // Catch: Throwable -> L35
    L18:
        r16.setResourceInfo$anniex_release(r12.j);     // Catch: Throwable -> L35
        if (r11.k == true) goto L21;
        a(r10, r16);     // Catch: Throwable -> L35
    L21:
        String r21 = r11.c;     // Catch: Throwable -> L35
        if (r11.b.getBooleanQueryParameter("use_card_mode", true) == true) goto L24;
        boolean r22 = true;
    L25:
        b(r21, r16, r22, r11.k, r11.g);     // Catch: Throwable -> L35
        r16.setViewZoom(r11.f.x);     // Catch: Throwable -> L35
        String r23 = r11.f.d;     // Catch: Throwable -> L35
        if (r23 == null) goto L28;
        r16.setGroupName(r23);     // Catch: Throwable -> L35
    L28:
        com.bytedance.android.anniex.assemble.a r24 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L35
        IAnnieXLatchService r25 = (IAnnieXLatchService) com.bytedance.android.anniex.assemble.a.g(r11.c, IAnnieXLatchService.class);     // Catch: Throwable -> L35
        if (r25 == null) goto L31;
        r25.Y();     // Catch: Throwable -> L35
    L31:
        r12.e = true;     // Catch: Throwable -> L35
        TraceEvent.endSection("AnnieXLynxView:init");     // Catch: Throwable -> L35
        MonitorManager.n(r16, r11.g);     // Catch: Throwable -> L35
        AnnieXLynxView r26 = r16;
    L33:
        TraceEvent.endSection("AnnieXApi:createLynxViewFromEngine");
        return r26;
    L24:
        r22 = false;
        goto L25
    L32:
        com.bytedance.android.anniex.assemble.a r110 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L35
        r26 = c.a(r10, r11);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        TraceEvent.endSection("AnnieXApi:createLynxViewFromEngine");
        throw th;
    }

    public static final void b(String r10, AnnieXLynxView r11, boolean r12, boolean r13, String r14) {
        TraceEvent.beginSection("AnnieXApi:initMonitorConfig");
        s26.d r1 = s26.d.c;     // Catch: Throwable -> L9
        MonitorReportService r15 = (r) s26.d.c.d(r10, r.class);     // Catch: Throwable -> L9
        if (r15 != null) goto L6;
        Lazy r16 = MonitorReportService.d;     // Catch: Throwable -> L9
        r15 = MonitorReportService.a.a();     // Catch: Throwable -> L9
    L6:
        q0 r17 = r15.getMonitorConfig();     // Catch: Throwable -> L9
        pz2.a r18 = new pz2.a(r17.c);     // Catch: Throwable -> L9
        r18.e = r17.d;     // Catch: Throwable -> L9
        r18.b = r17.b;     // Catch: Throwable -> L9
        r18.c = r12;     // Catch: Throwable -> L9
        r18.i = r13;     // Catch: Throwable -> L9
        r18.j = r14;     // Catch: Throwable -> L9
        com.bytedance.android.monitorV2.lynx_helper.b.a(r11, r18);     // Catch: Throwable -> L9
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnnieXApi$initMonitorConfig$1$2(r14, null), 3, null);     // Catch: Throwable -> L9
        TraceEvent.endSection("AnnieXApi:initMonitorConfig");
        return;
    L9:
        th = move-exception;
        TraceEvent.endSection("AnnieXApi:initMonitorConfig");
        throw th;
    }
}
