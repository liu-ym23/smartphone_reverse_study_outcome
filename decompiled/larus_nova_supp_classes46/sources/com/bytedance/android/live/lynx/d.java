package com.bytedance.android.live.lynx;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.lynx.callback.AnnieLynxMonitorCallback;
import com.bytedance.android.live.lynx.components.LiveLynxComponentForSaas;
import com.bytedance.android.live.lynx.components.n;
import com.bytedance.android.live.lynx.monitor.LynxMonitor;
import com.bytedance.android.live.lynx.open.OpenLynxComponent;
import com.bytedance.android.live.lynx.ui.LiveLynxBehaviorProvider;
import com.bytedance.android.live.lynx.ui.paidlive.LynxLiveFeature;
import com.bytedance.android.live.lynx.ui.replay.ReplayVideoLynxView;
import com.bytedance.android.live.lynx.widget.LynxTestWidget;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.ies.xelement.live.LynxLiveView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.canvas.LynxCanvasDownStreamManager;
import com.lynx.devtoolwrapper.DevToolLifecycle;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class d implements w {
    private final n30.a hybridMonitor;

    public static final class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("x-live");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new LynxLiveView(r2);
        }
    }

    public static final class b implements n30.a {
        public b() {
        }

        public final void a(View r10, String r11, String r12, JSONObject r13, JSONObject r14, JSONObject r15, boolean r16) {
            int r0 = rl0.b.a;
            rl0.a r1 = rl0.a.b;
            View r2 = r10;
            if ((r2 instanceof LynxView) == true) goto L5;
            r2 = null;
        L5:
            r1.j((LynxView) r2, r11, r12, r13, r14, r15, null, r16);
        }

        public final void reportCustomV2(View r11, String r12, String r13, JSONObject r14, JSONObject r15, JSONObject r16, JSONObject r17, int r18) {
            int r0 = rl0.b.a;
            rl0.a r1 = rl0.a.b;
            View r2 = r11;
            if ((r2 instanceof LynxView) == true) goto L5;
            r2 = null;
        L5:
            r1.k((LynxView) r2, r12, r13, r14, r15, r16, r17, r18);
        }
    }

    public static final class c extends com.lynx.tasm.behavior.a {
        public c() {
            super("x-live-feature");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            return new LynxLiveFeature(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.lynx.d$d, reason: collision with other inner class name */
    public static final class C0123d extends com.lynx.tasm.behavior.a {
        public C0123d() {
            super("x-record-video");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new ReplayVideoLynxView(r2);
        }
    }

    public void addHybridDebugTool(Context r1, ViewGroup r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        Intrinsics.checkNotNullParameter(r3, "url");
    }

    public void createHybridCard(Context r1, Uri r2, b7.a r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "uri");
    }

    public List<f> getLynxLifeCallback() {
        return CollectionsKt.mutableListOf(new AnnieLynxMonitorCallback[]{new AnnieLynxMonitorCallback()});
    }

    public void prepareRemoteDebug(String r1) {
    }

    public List<com.lynx.tasm.behavior.a> provideLynxLiveBehaviors() {
        return CollectionsKt.mutableListOf(new com.lynx.tasm.behavior.a[]{new c(), new C0123d()});
    }

    public List<com.lynx.tasm.behavior.a> getBehaviorList() {
        Lazy r0 = LiveLynxBehaviorProvider.a;
        ArrayList r1 = new ArrayList();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(Boolean.valueOf(r1.addAll((List) LiveLynxBehaviorProvider.b.getValue())));     // Catch: Throwable -> L5
    L7:
        IHostAction r3 = k.f(IHostAction.class);
        if (r3 == null) goto L10;
        List r4 = r3.getECLynxBehaviorList();
    L11:
        ALogger.i("LiveLynxBehaviorProvider-ECLynxBehaviorList", String.valueOf(r4));
        if (r4 == null) goto L19;
        Iterator r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if ((r6 instanceof com.lynx.tasm.behavior.a) == false) goto L15;
        ALogger.i("LiveLynxBehaviorProvider-ECLynxBehavior", String.valueOf(r6));
        r1.add(r6);
    L19:
        return r1;
    L10:
        r4 = null;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public k7a.a getDynamicComponentFetcher() {
        return new n();
    }

    public List<com.lynx.tasm.behavior.a> getLiveExportedXElements() {
        return CollectionsKt.listOf(new a());
    }

    public boolean isEnableDevtoolDebug() {
        com.bytedance.android.live.lynx.a r0 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r0 == null) goto L6;
        return r0.isEnableDebug();
    L6:
        return LynxEnv.inst().isEnableDevtoolDebug();
    }

    public d() {
        this.hybridMonitor = new b();
    }

    public String getLynxVersion() {
        return LynxEnv.inst().getLynxVersion();
    }

    public boolean isV8Enable() {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (DevToolSettings.inst().isDevToolEnabled() == false) goto L9;
        if (DevToolSettings.inst().getV8Enabled() == 0) goto L9;
        return true;
    }

    public <T extends LiveRecyclableWidget> Class<T> createTestWidgetClass() {
        return LynxTestWidget.class;
    }

    public d8a.b getAbsTemplateProvider() {
        return ol0.b.a;
    }

    public n30.a getHybridMonitor() {
        return this.hybridMonitor;
    }

    private final LynxMonitor.FallbackType getLynxFallbackType(int r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        if (tb1.c.c == false) goto L9;
        if (k.n(IHostBusiness.class).checkLynxPlugin() == true) goto L9;
        return LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED;
    L9:
        if (LynxEnv.inst().hasInited() == true) goto L13;
        return LynxMonitor.FallbackType.INIT_FAILED;
    L13:
        if (r2 == 400) goto L15;
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        return LynxMonitor.FallbackType.UNKNOWN;
    L15:
        return LynxMonitor.FallbackType.LOAD_FAILED;
    L18:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    private final String getPath(String r3) {
        if (StringsKt.isBlank(r3) == false) goto L17;
        return "";
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(UriProtector.parse(r3).getPath());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r4) == false) goto L12;
        r4 = null;
    L12:
        String r5 = (String) r4;
        if (r5 != null) goto L16;
        return "";
    L16:
        return r5;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public List<u> getJsbMonitors(View r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        if ((r3 instanceof LynxView) == true) goto L5;
        View r0 = null;
    L7:
        if (((LynxView) r0) == null) goto L11;
        List<u> r4 = CollectionsKt.mutableListOf(new ql0.a[]{new ql0.a((LynxView) r3)});
        if (r4 == null) goto L11;
        return r4;
    L11:
        return new ArrayList();
    L5:
        r0 = r3;
        goto L7
    }

    public void setEnableDevtoolDebug(boolean r2) {
        com.bytedance.android.live.lynx.a r0 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r0 == null) goto L5;
        r0.b(r2);
        return;
    L5:
        LynxEnv.inst().setEnableDevtoolDebug(r2);
    }

    public void tryInitEnvIfNeeded(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        kjc.c r0 = new kjc.c();
        if (2 != kjc.a.a()) goto L9;
        kjc.b r1 = r0.a;
        if (k.n(IHostBusiness.class).checkLynxPlugin() == true) goto L7;
        return;
    L7:
        pl0.b.a(r4);
        r1.a = Unit.INSTANCE;
        r0.b = true;
    L9:
        if (r0.b == true) goto L11;
        kjc.b r2 = r0.a;
        pl0.b.a(r4);
        r2.a = Unit.INSTANCE;
    L11:
        Object r5 = r0.a.a;
    }

    private final com.bytedance.android.live.lynx.api.c catchingCreate(String r5, Function0<? extends com.bytedance.android.live.lynx.api.c> r6) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (tb1.c.c == true) goto L6;
    L9:
        Object r7 = Result.constructor-impl((com.bytedance.android.live.lynx.api.c) r6.invoke());     // Catch: Throwable -> L11
    L13:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L21;
        boolean r2 = LynxMonitor.a;
        if (LynxEnv.inst().hasInited() == true) goto L18;
        LynxMonitor.FallbackType r3 = LynxMonitor.FallbackType.INIT_FAILED;
    L19:
        LynxMonitor.b(r3, e.a(r8), null, 0, 28);
        goto L21
    L18:
        r3 = LynxMonitor.FallbackType.UNKNOWN;
    L21:
        if (Result.isFailure-impl(r7) == true) goto L25;
        r0 = r7;
    L25:
        return (com.bytedance.android.live.lynx.api.c) r0;
    L6:
        if (k.n(IHostBusiness.class).checkLynxPlugin() == true) goto L9;
        boolean r9 = LynxMonitor.a;     // Catch: Throwable -> L11
        LynxMonitor.d(LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED, r5);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public Object map2TemplateData(Map<String, ? extends Object> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (k.n(IHostBusiness.class).checkLynxPlugin() == true) goto L6;
        return null;
    L6:
        TemplateData r4 = TemplateData.fromMap(r2);
        if (r3 != null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == true) goto L15;
        r4.markState(r3);
    L15:
        return r4;
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r0 = false;
        goto L13
    }

    public void monitorCachePropsInject(String r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r13, "categoryJson");
        boolean r1 = LynxMonitor.a;
        Intrinsics.checkNotNullParameter(r13, "categoryJson");
        JSONObject r9 = new JSONObject();
        r9.put("virtual_aid", "88888");
        if (LynxMonitor.a == false) goto L5;
        int r0 = rl0.b.a;
        rl0.a.b.k(null, "inject_data_to_props", r12, r13, null, null, r9, 0);
        return;
    L5:
        int r2 = rl0.b.a;
        rl0.a.b.j(null, "inject_data_to_props", r12, r13, null, null, r9, false);
    }

    public void setEnableJSRuntime(LynxViewBuilder r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        com.bytedance.android.live.lynx.a r0 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r0 == null) goto L6;
        r0.setEnableJSRuntime(r2, r3);
        return;
    }

    public Fragment createLynxFragment(Context r2, Bundle r3, d0 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        return vl0.c.b.createLiveLynxFragment(r3, r4, new vl0.b());
    }

    public void reportLynxFallback(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        boolean r0 = LynxMonitor.a;
        LynxMonitor.a(getLynxFallbackType(r3), r4, getPath(r2), r3);
    }

    public void setEnableUserCodeCache(LynxViewBuilder r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "builder");
        com.bytedance.android.live.lynx.a r4 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r4 == null) goto L6;
        r4.a(r1, r3);
        return;
    }

    public void stopLynxCast(LynxView r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "canvasId");
        LynxCanvasDownStreamManager.getInstance().RemoveDownStreamSurface(r2, r3, r4);
    }

    public void updateData(View r2, Object r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "data");
        if ((r2 instanceof LynxView) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof Map) == false) goto L9;
        ((LynxView) r2).updateData((Map) r3);
        return;
    L9:
        if ((r3 instanceof TemplateData) == false) goto L17;
        if (r4 == false) goto L14;
        com.bytedance.android.live.lynx.a r5 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r5 == null) goto L14;
        r5.d((TemplateData) r3);
    L14:
        ((LynxView) r2).updateData((TemplateData) r3);
        return;
    }

    public com.bytedance.android.live.lynx.api.d create(Context r8, Integer r9, LynxThreadStrategy r10, d0 r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "threadStrategy");
        return new OpenLynxComponent(r8, r9, r10, r11, r12);
    }

    public void monitorLynxListFps(LynxView r11, String r12, String r13, double r14, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "lynxView");
        Intrinsics.checkNotNullParameter(r12, "path");
        Intrinsics.checkNotNullParameter(r13, "tag");
        boolean r6 = LynxMonitor.a;
        Intrinsics.checkNotNullParameter(r11, "lynxView");
        Intrinsics.checkNotNullParameter(r12, "path");
        Intrinsics.checkNotNullParameter(r13, "tag");
        JSONObject r7 = new JSONObject();
        r7.put("fps", r14);
        JSONObject r4 = new JSONObject();
        r4.put("tag", r13);
        r4.put("annie", "0");
        Object r0 = r11.getContext().getSystemService("window");
        if (r0 == null) goto L12;
        r4.put("refresh_rate", String.valueOf((int) ((WindowManager) r0).getDefaultDisplay().getRefreshRate()));
        JSONObject r8 = new JSONObject();
        r8.put("virtual_aid", "88888");
        if (LynxMonitor.a == false) goto L9;
        if (r16 == false) goto L8;
        int r1 = rl0.b.a;
        rl0.a.b.k(r11, "lynx_list_fps", r12, r4, r7, null, r8, 2);
        return;
    L8:
        int r2 = rl0.b.a;
        rl0.a.b.k(r11, "lynx_list_fps", r12, r4, r7, null, r8, 0);
        return;
    L9:
        int r3 = rl0.b.a;
        rl0.a.b.j(r11, "lynx_list_fps", r12, r4, r7, null, r8, r16);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public void reportLynxFetchJsbError(View r14, String r15, String r16, int r17, String r18) {
        Intrinsics.checkNotNullParameter(r14, "lynxView");
        Intrinsics.checkNotNullParameter(r15, "url");
        Intrinsics.checkNotNullParameter(r16, "method");
        if ((r14 instanceof LynxView) == true) goto L5;
        View r6 = null;
    L7:
        if (((LynxView) r6) == null) goto L31;
        int r7 = rl0.b.a;
        LynxView r11 = (LynxView) r14;
        rl0.a.b.getClass();
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r15, "url");
        Intrinsics.checkNotNullParameter(r16, "method");
        Object r12 = 0;
        if (r18 == null) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        int r1 = StringsKt.lastIndexOf$default(r18, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L13
        int r4 = StringsKt.indexOf$default(r18, ',', r1, false, 4, null);     // Catch: Throwable -> L13
        r12 = Integer.valueOf(CastIntegerProtector.parseInt(r18.substring(r1 + 18, r4)));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r2 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r2) == true) goto L18;
        r12 = r2;
    L18:
        r12 = (Number) r12;
    L20:
        if (rl0.a.a == false) goto L26;
        qz2.c r3 = new qz2.c();
        r3.c = r15;
        r3.b = r16;
        r3.d = r17;
        if (r12 == null) goto L25;
        r3.e = ((Integer) r12).intValue();
        r3.g = r18;
        LynxViewMonitor.b.getClass();
        LynxViewMonitor.n(r11, r3);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L26:
        vy2.c r8 = new vy2.c();
        r8.c = r15;
        r8.b = r16;
        r8.d = r17;
        if (r12 == null) goto L30;
        r8.e = ((Integer) r12).intValue();
        r8.f = r18;
        com.bytedance.android.monitor.lynx.LynxMonitor.j.l(r11, r8);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L31:
        return;
    L5:
        r6 = r14;
        goto L7
    }

    public long startLynxCast(LynxView r8, String r9, Surface r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        Intrinsics.checkNotNullParameter(r9, "canvasId");
        Intrinsics.checkNotNullParameter(r10, "surface");
        return LynxCanvasDownStreamManager.getInstance().AddDownStreamSurface(r8, r9, r10, r11, r12);
    }

    public com.bytedance.android.live.lynx.api.c create(Activity r12, Integer r13, String r14, LynxThreadStrategy r15, String r16, d0 r17) {
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r15, "threadStrategy");
        Intrinsics.checkNotNullParameter(r16, "oriScheme");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.parse(r14).getPath());     // Catch: Throwable -> L5
    L7:
        Object r10 = null;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        String r2 = (String) r1;
        if (r2 != null) goto L35;
        r2 = "";
    L35:
    L20:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Object r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L30;
        boolean r6 = LynxMonitor.a;
        if (LynxEnv.inst().hasInited() == true) goto L27;
        LynxMonitor.FallbackType r7 = LynxMonitor.FallbackType.INIT_FAILED;
    L28:
        LynxMonitor.b(r7, e.a(r5), null, 0, 28);
        goto L30
    L27:
        r7 = LynxMonitor.FallbackType.UNKNOWN;
    L30:
        if (Result.isFailure-impl(r4) == true) goto L34;
        r10 = r4;
    L34:
        return (com.bytedance.android.live.lynx.api.c) r10;
    L14:
        if (tb1.c.c == true) goto L16;
    L18:
        r4 = Result.constructor-impl(new LiveLynxComponentForSaas(r12, null, r14, r13, r15, r16, r17, false));     // Catch: Throwable -> L20
        goto L22
    L16:
        if (k.n(IHostBusiness.class).checkLynxPlugin() == true) goto L18;
        boolean r8 = LynxMonitor.a;     // Catch: Throwable -> L20
        LynxMonitor.d(LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED, r2);     // Catch: Throwable -> L20
        return null;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public com.bytedance.android.live.lynx.api.c createAndLoad(ILiveHybridContainer r12, String r13, Integer r14, LynxThreadStrategy r15, String r16, d0 r17) {
        Intrinsics.checkNotNullParameter(r12, "container");
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r15, "threadStrategy");
        Intrinsics.checkNotNullParameter(r16, "oriScheme");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.parse(r13).getPath());     // Catch: Throwable -> L5
    L7:
        Object r10 = null;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        String r2 = (String) r1;
        if (r2 != null) goto L37;
        r2 = "";
    L37:
    L20:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Object r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L30;
        boolean r6 = LynxMonitor.a;
        if (LynxEnv.inst().hasInited() == true) goto L27;
        LynxMonitor.FallbackType r7 = LynxMonitor.FallbackType.INIT_FAILED;
    L28:
        LynxMonitor.b(r7, e.a(r5), null, 0, 28);
        goto L30
    L27:
        r7 = LynxMonitor.FallbackType.UNKNOWN;
    L30:
        if (Result.isFailure-impl(r4) == true) goto L34;
        r10 = r4;
    L34:
        return (com.bytedance.android.live.lynx.api.c) r10;
    L14:
        if (tb1.c.c == true) goto L16;
    L18:
        ALogger.i("LynxService", "lynx version: 3.9.1-rc.11");     // Catch: Throwable -> L20
        r4 = Result.constructor-impl(new LiveLynxComponentForSaas(r12.getCurrentActivity(), r12, r13, r14, r15, r16, r17, true));     // Catch: Throwable -> L20
        goto L22
    L16:
        if (k.n(IHostBusiness.class).checkLynxPlugin() == true) goto L18;
        boolean r8 = LynxMonitor.a;     // Catch: Throwable -> L20
        LynxMonitor.d(LynxMonitor.FallbackType.PLUGIN_NOT_INSTALLED, r2);     // Catch: Throwable -> L20
        return null;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public LynxGroup getLynxGroup(String r9, String[] r10, boolean r11, boolean r12, boolean r13, int r14) {
        com.bytedance.android.live.lynx.a r1 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.e(r9, r10, r11, r12, r13, r14);
    }
}
