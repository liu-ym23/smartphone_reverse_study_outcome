package com.bytedance.ai.applet.components.view;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule;
import com.bytedance.ai.applet.render.core.lynx.LynxAppletBridgeSyncModule;
import com.bytedance.ai.applet.render.core.lynx.LynxRenderView;
import com.bytedance.ai.applet.render.core.lynx.k;
import com.bytedance.ai.applet.render.core.lynx.l;
import com.bytedance.ai.applet.render.core.lynx.s;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$d;
import com.bytedance.ai.lynx.AISDKLynxBehaviorRegistry;
import com.bytedance.ai.lynx.u;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.o;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ivy.ivykit.api.bridge.IIvyLynxBridgeService;
import com.ivy.ivykit.api.plugin.IIvyHybridMonitorService;
import com.ivy.ivykit.api.plugin.IIvyLynxBehaviorService;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.navigator.NavigationModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RenderViewFactory {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RenderType.values().length];
            r0[RenderType.LYNX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RenderType.WEB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static LynxRenderView a(Context r12, q2.c r13, LynxRenderView.a r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "loader");
        h2.a r1 = f2.b.c;
        String r10 = "";
        if (r1 == null) goto L6;
        String r11 = r1.m;
        if (r11 == null) goto L6;
    L7:
        if (r14 != null) goto L9;
        r14 = new LynxRenderView.a(r12);
    L9:
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Intrinsics.checkNotNullParameter(r11, "bid");
        r14.b = r11;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        Intrinsics.checkNotNullParameter(r13, "loader");
        r14.f = r13;
        List r16 = new XElementBehavior().create();
        Intrinsics.checkNotNullParameter(r16, "bundle");
        r14.d.addBehaviors(r16);
        List r17 = IIvyLynxBehaviorService.a.a();
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L11:
        if (r19.hasNext() == false) goto L15;
        Object r20 = r19.next();
        if ((r20 instanceof com.lynx.tasm.behavior.a) == false) goto L11;
        r18.add(r20);
        goto L11
    L15:
        Intrinsics.checkNotNullParameter(r18, "bundle");
        r14.d.addBehaviors(r18);
        List<com.lynx.tasm.behavior.a> r110 = AISDKLynxBehaviorRegistry.getExtraBehaviors();
        Intrinsics.checkNotNullParameter(r110, "bundle");
        r14.d.addBehaviors(r110);
        d r111 = new d();
        Intrinsics.checkNotNullParameter(r111, "bundle");
        r14.d.addBehavior(r111);
        e r112 = new e();
        Intrinsics.checkNotNullParameter(r112, "bundle");
        r14.d.addBehavior(r112);
        g r113 = new g(r15);
        Intrinsics.checkNotNullParameter(r113, "bundle");
        r14.d.addBehavior(r113);
        h2.a r114 = f2.b.c;
        if (r114 == null) goto L20;
        Integer r115 = r114.s;
        if (r115 == null) goto L20;
        float r116 = r115.intValue() / o.a(17.0f);
    L21:
        r14.c = r116;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        Function2<? super String, ? super ContainerType, Boolean> r117 = new com.bytedance.ai.applet.components.view.a();
        Intrinsics.checkNotNullParameter(r117, "checker");
        r14.g = r117;
        com.bytedance.ai.applet.render.core.lynx.o r21 = r14.f;
        if (r21 == null) goto L52;
        final Ref.ObjectRef r118 = new Ref.ObjectRef();
        if (r14.c != 1.0f) goto L26;
        boolean r0 = true;
    L28:
        if (r0 == true) goto L40;
        Object r22 = r14.getContext().getSystemService("window");
        if ((r22 instanceof WindowManager) == false) goto L32;
        WindowManager r23 = (WindowManager) r22;
    L33:
        if (r23 == null) goto L40;
        Display r24 = r23.getDefaultDisplay();
        if (r24 == null) goto L40;
        Point r25 = new Point();     // Catch: Exception -> L38
        r24.getSize(r25);     // Catch: Exception -> L38
        float r26 = r25.x;     // Catch: Exception -> L38
        float r27 = r14.c;     // Catch: Exception -> L38
        r14.d.setScreenSize((int) (r26 * r27), (int) (r25.y * r27));     // Catch: Exception -> L38
    L38:
        e = move-exception;
        com.bytedance.ai.applet.base.log.a.b("LynxRenderView", "setViewZoom error", e);
        Unit r28 = Unit.INSTANCE;
        goto L40
    L32:
        r23 = null;
    L40:
        com.ivy.ivykit.api.plugin.b r29 = IIvyHybridMonitorService.a.c(r14.d);
        s4.c r119 = new s4.c();
        AppletBridgeModule.b r30 = new AppletBridgeModule.b(r119, r14.g, new k(r118), ContainerType.WIDGET);
        LynxAppletBridgeSyncModule.b r31 = new LynxAppletBridgeSyncModule.b(new l(r118));
        Intrinsics.checkNotNullParameter(AppletBridgeModule.class, "module");
        r14.d.registerModule("AppletBridgeModule", AppletBridgeModule.class, r30);
        Intrinsics.checkNotNullParameter(LynxAppletBridgeSyncModule.class, "module");
        r14.d.registerModule(LynxAppletBridgeSyncModule.NAME, LynxAppletBridgeSyncModule.class, r31);
        String r32 = NavigationModule.NAME;
        Intrinsics.checkNotNullParameter(NavigationModule.class, "module");
        r14.d.registerModule(r32, NavigationModule.class, null);
        r14.d.setEnableMTSModule(true);
        IIvyLynxBridgeService.Companion r33 = IIvyLynxBridgeService.a;
        Context r34 = r14.getContext();
        String r35 = r14.e;
        String r36 = r14.b;
        if (r36 == null) goto L44;
        r10 = r36;
    L44:
        com.ivy.ivykit.api.bridge.g r37 = r33.a(r34, r35, r10, r14.d);
        r14.d.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);
        r14.d.setTemplateResourceFetcher(new u(r14.getContext(), r21));
        r14.d.setResourceProvider("EXTERNAL_JS_SOURCE", new s(r21));
        LynxRenderView r38 = new LynxRenderView(r14.getContext(), r14.d, r21, r14.e, r37, r29, r119);
        r118.element = r38;
        if (r29 == null) goto L47;
        r29.a(r38, r14.e);
    L47:
        r15.element = r38;
        com.ivy.ivykit.api.bridge.g r120 = r38.getIvyLynxBridge();
        if (r120 == null) goto L50;
        r120.a(r38);
    L50:
        return r38;
    L26:
        r0 = false;
        goto L28
    L52:
        throw new IllegalArgumentException("ResourceLoader is required");
    L20:
        r116 = 1.0f;
    L6:
        r11 = "";
        goto L7
    }

    public static w2.a b(Context r16, RenderType r17, Widget r18, com.bytedance.ai.widget.cache.b r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "type");
        Intrinsics.checkNotNullParameter(r18, "widget");
        Intrinsics.checkNotNullParameter(r19, "loader");
        h2.a r10 = f2.b.c;
        String r11 = "";
        if (r10 == null) goto L6;
        String r12 = r10.m;
        if (r12 == null) goto L6;
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.b), null, null, new RenderViewFactory$createWidgetRenderView$1(r12, null), 3, null);
        int r13 = a.a[r17.ordinal()];
        if (r13 != 1) goto L10;
        com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r15 = new StringBuilder("createWidgetLynxRenderView, appletId:");
        r15.append(r18.b);
        r15.append(", widgetId:");
        if (com.bytedance.ai.utils.f.g(r18.K) == false) goto L33;
        String r20 = r18.K;
    L34:
        r15.append(r20);
        r15.append(", runtimeVersion:");
        r15.append(r18.C);
        com.bytedance.ai.applet.base.log.a.c("RenderViewFactory", r15.toString());
        Uri r21 = r19.f();
        if (r21 == null) goto L99;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r16, "context");
        boolean r22 = r21.getBooleanQueryParameter("enable_code_cache", false);
        boolean r23 = r21.getBooleanQueryParameter("enable_dynamic_v8", false);
        String r24 = UriProtector.getQueryParameter(r21, "group");
        if (r24 == null) goto L40;
        r11 = r24;
    L40:
        LynxGroup.a r25 = new LynxGroup.a();
        r25.d = true;
        r25.a = r11;
        r25.e = r23;
        String r26 = UriProtector.getQueryParameter(r21, "lynx_preset_height");
        String r27 = UriProtector.getQueryParameter(r21, "lynx_preset_width");
        if (r27 != null) goto L46;
        if (r26 != null) goto L46;
        int r28 = 0;
        int r29 = 0;
    L52:
        String r110 = UriProtector.getQueryParameter(r21, "preset_safe_point");
        if (r110 == null) goto L60;
        Integer r111 = StringsKt.toIntOrNull(r110);
        if (r111 == null) goto L60;
        if (r111.intValue() != 1) goto L60;
        boolean r112 = true;
    L61:
        String r113 = UriProtector.getQueryParameter(r21, "thread_strategy");
        if (r113 == null) goto L64;
        Integer r114 = Integer.valueOf(CastIntegerProtector.parseInt(r113));
    L65:
        ThreadStrategyForRendering r115 = ThreadStrategyForRendering.ALL_ON_UI;
        int r116 = r115.id();
        if (r114 != null) goto L69;
    L71:
        ThreadStrategyForRendering r117 = ThreadStrategyForRendering.MOST_ON_TASM;
        int r118 = r117.id();
        if (r114 != null) goto L75;
    L77:
        ThreadStrategyForRendering r119 = ThreadStrategyForRendering.PART_ON_LAYOUT;
        int r120 = r119.id();
        if (r114 != null) goto L81;
    L83:
        r119 = ThreadStrategyForRendering.MULTI_THREADS;
        int r121 = r119.id();
        if (r114 != null) goto L87;
    L89:
        String r30 = UriProtector.getQueryParameter(r21, "air_strict_mode");
        if (r30 == null) goto L97;
        Integer r31 = StringsKt.toIntOrNull(r30);
        if (r31 == null) goto L97;
        if (r31.intValue() != 1) goto L97;
        boolean r32 = true;
    L98:
        LynxViewBuilder r122 = LynxView.builder();
        r122.setLynxGroup(LynxGroup.Create(r25));
        r122.setEnableUserCodeCache(r22);
        r122.setPresetMeasuredSpec(r29, r28);
        r122.setEnableLayoutSafepoint(r112);
        r122.setThreadStrategyForRendering(r115);
        r122.setEnableAirStrictMode(r32);
        Intrinsics.checkNotNull(r122);
        final LynxRenderView.a r33 = new LynxRenderView.a(r16, r122);
    L100:
        IAISDKDebugService.Companion r34 = IAISDKDebugService.a;
        IAISDKDebugService$d r123 = r34.f(new b(r33));
        AppletAppManagerService r35 = AppletAppManagerService.INSTANCE;
        String r36 = r18.b;
        r35.getClass();
        OnlineAppletApplication r37 = AppletAppManagerService.b(r36);
        if (r37 == null) goto L106;
        com.bytedance.ai.applet.base.log.a.c("RenderViewFactory", "createWidgetLynxRenderView: find installed online app, appletId=" + r18.b);
        LynxGroup r38 = r37.q;
        if (r38 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("_widgetLynxGroup");
        r38 = null;
    L105:
        Intrinsics.checkNotNullParameter(r38, "group");
        r33.d.setLynxGroup(r38);
    L106:
        com.bytedance.ai.applet.base.log.a.c("RenderViewFactory", "createWidgetLynxRenderView: isDebug=" + r18.A);
        r33.d.setDebuggable(r18.A);
        String r39 = r18.x;
        if (r18.E != 1) goto L109;
        boolean r40 = true;
    L110:
        final LynxRenderView r41 = a(r16, new s2.a(r19, r39, r40, r18.b, r18.K), r33);
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type com.bytedance.ai.applet.render.core.lynx.LynxRenderView");
        r41.addLynxViewClient(new h(r123));
        r34.i(r123, r41, null);
        m4.c r0 = r41.getBridge().f;
        if (r0 == null) goto L114;
        r0.setRemoteReadyListener(new c(r41));
    L114:
        if (r18.E != 1) goto L116;
        boolean r124 = true;
    L117:
        com.bytedance.ai.resource.security.e r1 = com.bytedance.ai.resource.security.e.a;
        String r42 = r18.b;
        String r43 = r18.K;
        r1.getClass();
        com.bytedance.ai.resource.security.e.d(r41, r124, r42, r43);
        return r41;
    L116:
        r124 = false;
        goto L117
    L109:
        r40 = false;
    L97:
        r32 = false;
        goto L98
    L87:
        if (r114.intValue() != r121) goto L89;
    L82:
        r115 = r119;
        goto L89
    L81:
        if (r114.intValue() != r120) goto L83;
    L75:
        if (r114.intValue() != r118) goto L77;
        r115 = r117;
        goto L89
    L69:
        if (r114.intValue() != r116) goto L71;
    L64:
        r114 = null;
    L60:
        r112 = false;
    L46:
        if (r27 == null) goto L48;
        r29 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r27), 1073741824);
    L49:
        if (r26 == null) goto L51;
        r28 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r26), 1073741824);
        goto L52
    L51:
        r28 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L52
    L48:
        r29 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L49
    L99:
        r33 = new LynxRenderView.a(r16);
        goto L100
    L33:
        r20 = r18.a;
        goto L34
    L10:
        if (r13 != 2) goto L29;
        com.bytedance.ai.applet.render.core.web.a.C0018a r44 = new com.bytedance.ai.applet.render.core.web.a.C0018a(r16);
        h2.a r45 = f2.b.c;
        if (r45 == null) goto L17;
        String r46 = r45.m;
        if (r46 == null) goto L17;
        r11 = r46;
    L17:
        Intrinsics.checkNotNullParameter(r11, "bid");
        r44.b = r11;
        Intrinsics.checkNotNull(r44, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        h2.a r47 = f2.b.c;
        if (r47 == null) goto L22;
        Integer r48 = r47.s;
        if (r48 == null) goto L22;
        float r49 = r48.intValue() / o.a(17.0f);
    L23:
        r44.c = r49;
        Intrinsics.checkNotNull(r44, "null cannot be cast to non-null type T of com.bytedance.ai.applet.render.core.RenderView.Builder");
        String r50 = r44.b;
        if (r50 == null) goto L27;
        return new com.bytedance.ai.applet.render.core.web.a(r44.getContext(), r50, r44.c);
    L27:
        throw new IllegalArgumentException("Bid is required");
    L22:
        r49 = 1.0f;
        goto L23
    L29:
        throw new NoWhenBranchMatchedException();
    L6:
        r12 = "";
        goto L7
    }
}
