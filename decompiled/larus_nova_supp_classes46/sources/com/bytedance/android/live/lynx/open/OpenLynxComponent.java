package com.bytedance.android.live.lynx.open;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.broadcastgame.opengame.lynx.LynxOpenPlugin;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.a4;
import com.bytedance.android.monitor.lynx.jsb.LynxMonitorModule;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.o;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class OpenLynxComponent implements com.bytedance.android.live.lynx.api.d {
    public static int h;
    public String a;
    public final LynxView b;
    public final d0 c;
    public final HashMap<String, Object> d;
    public v e;
    public com.bytedance.android.live.browser.d0 f;
    public final String g;

    public final class LiveLynxClient extends q1 {
        public final /* synthetic */ OpenLynxComponent a;

        public final void onPageUpdate() {
        }

        public final void onFirstScreen() {
            OpenLynxComponent r0 = this.a;
            com.bytedance.android.live.browser.d0 r1 = r0.f;
            if (r1 == null) goto L6;
            r1.b(r0.b);
            return;
        }

        public final void onLoadSuccess() {
            OpenLynxComponent r0 = this.a;
            com.bytedance.android.live.browser.d0 r1 = r0.f;
            if (r1 == null) goto L5;
            r1.d(r0.b);
        L5:
            this.a.getClass();
        }

        public final void onRuntimeReady() {
            UtilityKotlinExtentionsKt.s(0, false, false, new OpenLynxComponent$LiveLynxClient$onRuntimeReady$1(this), 7);
        }

        public final void onFirstLoadPerfReady(v0 r1) {
            super.onFirstLoadPerfReady(r1);
            this.a.getClass();
        }

        public final void onLoadFailed(String r3) {
            this.a.getClass();
            com.bytedance.android.live.browser.d0 r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            OpenLynxComponent r1 = this.a;
            com.bytedance.android.live.browser.d0 r2 = r1.f;
            if (r2 == null) goto L9;
            r2.c(r1.b, r3);
            return;
        }

        public final void onPageStart(String r3) {
            System.currentTimeMillis();
            OpenLynxComponent r0 = this.a;
            com.bytedance.android.live.browser.d0 r1 = r0.f;
            if (r1 == null) goto L6;
            r1.e(r0.b, r3);
            return;
        }

        public final void onReceivedError(String r3) {
            OpenLynxComponent r0 = this.a;
            com.bytedance.android.live.browser.d0 r1 = r0.f;
            if (r1 == null) goto L6;
            r1.f(r0.b, r3);
            return;
        }

        public final void onUpdatePerfReady(v0 r1) {
            super.onUpdatePerfReady(r1);
            this.a.getClass();
        }

        public final String shouldRedirectImageUrl(String r8) {
            boolean r1 = true;
            if (r8 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            Object r4 = "";
            if (r3 == false) goto L13;
            return "";
        L13:
            if (Intrinsics.areEqual(r8, "res:///2131233768") == false) goto L15;
            return r8;
        L15:
            String r5 = this.a.g;
            if (r5 != null) goto L18;
        L21:
            if (r1 == false) goto L24;
            return "";
        L24:
            if (TextUtils.isEmpty(r8) == true) goto L51;
            String r6 = null;
            if (StringsKt.startsWith$default(r8, "res://", false, 2, null) == false) goto L51;
            if (r8 == null) goto L50;
            String r9 = r8.substring(6);
            if (StringsKt.contains$default(this.a.g, "http", false, 2, null) == true) goto L31;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L41
            StringBuilder r7 = new StringBuilder("file://");     // Catch: Throwable -> L41
            File r10 = FilesKt.resolve(new PolarisFileWrapper(this.a.g), r9);     // Catch: Throwable -> L41
            if (r10 == null) goto L39;
            r6 = r10.getAbsolutePath();     // Catch: Throwable -> L41
        L39:
            r7.append(r6);     // Catch: Throwable -> L41
            Object r11 = Result.constructor-impl(r7.toString());     // Catch: Throwable -> L41
        L44:
            if (Result.isFailure-impl(r11) == true) goto L48;
            r4 = r11;
        L48:
            return (String) r4;
        L41:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L44
        L31:
            if (StringsKt.startsWith$default(r9, "/", false, 2, null) == false) goto L33;
            StringBuilder r12 = new StringBuilder();
            r12.append(this.a.g);
        L34:
            r12.append(r9);
            return r12.toString();
        L33:
            r12 = new StringBuilder();
            r12.append(this.a.g);
            r12.append('/');
            goto L34
        L50:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L51:
            return r8;
        L18:
            if (r5.length() == 0) goto L21;
            r1 = false;
            goto L21
        L5:
            if (r8.length() == 0) goto L8;
            r3 = false;
            goto L9
        }

        public LiveLynxClient(OpenLynxComponent r2, LynxView r3) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            this.a = r2;
        }
    }

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            float r6 = s1.e(12.0f);
            r9.setRoundRect(0, 0, r8.getWidth(), ((int) (r8.getBottom() + r6)) + 1, r6);
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final void a() {
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final void release() {
        this.b.onEnterBackground();
        this.b.destroy();
        this.c.e();
        this.d.clear();
        this.f = null;
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final LynxView getLynxView() {
        return this.b;
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final String getUrl() {
        return this.a;
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final void e(LynxOpenPlugin.createLynxView.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.f = r2;
    }

    @Override // io0.a
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.c.g(r2);
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final void b(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "valueObj");
        this.d.put(r2, r3);
    }

    @Override // io0.a
    public final void registerMethod(String r2, f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.c.c(r2, r3);
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final <T> void sendJsEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
        if (this.c.f == true) goto L6;
        this.c.f(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.lynx.api.d
    public final void c(String r5, String r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "params");
        b("relative_url", r5);
        int r0 = sl0.b.a;
        sl0.a.b.a(this.b, this.d);
        if (StringsKt.startsWith$default(r5, '/', false, 2, null) == true) goto L5;
        r5 = "/" + r5;
    L5:
        this.a = r5;
        this.b.setGlobalProps(r7);
        this.b.renderTemplateUrl(r6, "");
    }

    @Override // com.bytedance.android.live.lynx.api.b
    public final void d(String r5, byte[] r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "template");
        Intrinsics.checkNotNullParameter(r7, "params");
        if (StringsKt.startsWith$default(r5, '/', false, 2, null) == true) goto L5;
        r5 = "/" + r5;
    L5:
        this.a = r5;
        b("relative_url", r5);
        int r8 = sl0.b.a;
        sl0.a.b.a(this.b, this.d);
        this.b.setGlobalProps(r7);
        this.b.renderTemplateWithBaseUrl(r6, r7, this.a);
    }

    public OpenLynxComponent(Context r11, Integer r12, LynxThreadStrategy r13, com.bytedance.android.live.browser.d0 r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "lynxThreadStrategy");
        this.f = r14;
        this.g = r15;
        this.a = "";
        this.d = new HashMap();
        boolean r16 = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
        if (r16 == false) goto L5;
        com.bytedance.android.monitorV2.lynx.jsb.a r2 = new com.bytedance.android.monitorV2.lynx.jsb.a(0);
    L6:
        BrowserServiceImpl.Companion.getClass();
        s20.b r3 = BrowserServiceImpl.access$getDiComponent$cp();
        r3.getClass();
        v r4 = (v) r3.b.e.get();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.e = r4;
        pl0.b.a(r11);
        com.bytedance.android.live.lynx.open.a r5 = new com.bytedance.android.live.lynx.open.a(r11, new OpenLynxComponent$bridgeImpl$1(this));
        c r6 = new c(r5);
        d0.a r7 = d0.g;
        o r8 = new o(r6);
        r8.f = r11;
        r8.c = r5;
        LocalTestManager.a(new Class[]{wy.a.class});
        r8.g = false;
        r8.h = true;
        r8.d = "LivePlatformJsbridge";
        r8.o = true;
        r8.c(new d());
        r8.k = "webcast";
        this.c = r8.a();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L52
        LynxViewBuilder r10 = LynxView.builder();     // Catch: Throwable -> L52
        if (((Boolean) a4.a.getValue()).booleanValue() == false) goto L10;
        r10.enableAutoExpose(false);     // Catch: Throwable -> L52
    L10:
        r10.registerModule("bridge", OpenLynxBridgeModule.class, r5);     // Catch: Throwable -> L52
        r10.addBehaviors((List) OpenLynxBehaviorProvider.b.getValue());     // Catch: Throwable -> L52
        if (r12 != null) goto L13;
    L18:
        Resources r17 = s1.getResources();     // Catch: Throwable -> L52
        int r18 = WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics()).widthPixels;     // Catch: Throwable -> L52
    L19:
        r10.setPresetMeasuredSpec(View.MeasureSpec.makeMeasureSpec(r18, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Throwable -> L52
        r10.setTemplateProvider(new e());     // Catch: Throwable -> L52
        int r19 = com.bytedance.android.live.lynx.open.b.a[r13.ordinal()];     // Catch: Throwable -> L52
        if (r19 != 1) goto L22;
        ThreadStrategyForRendering r110 = ThreadStrategyForRendering.MOST_ON_TASM;     // Catch: Throwable -> L52
    L29:
        r10.setThreadStrategyForRendering(r110);     // Catch: Throwable -> L52
        com.bytedance.android.livesdk.sharedpref.e r111 = com.bytedance.android.livesdk.sharedpref.b.A2;     // Catch: Throwable -> L52
        String r112 = (String) ((SparseArray) r111.getValue()).get(13);     // Catch: Throwable -> L52
        if (r112 != null) goto L34;
        r112 = "assets://open_platform_jssdk.js";
    L34:
        if ((!Intrinsics.areEqual(r112, "assets://open_platform_jssdk.js")) == false) goto L39;
        if (new PolarisFileWrapper(r112).exists() == true) goto L39;
        ((SparseArray) r111.getValue()).put(13, "assets://open_platform_jssdk.js");     // Catch: Throwable -> L52
        r112 = "assets://open_platform_jssdk.js";
    L41:
        Intrinsics.areEqual(r112, "assets://open_platform_jssdk.js");     // Catch: Throwable -> L52
        StringBuilder r113 = new StringBuilder("unspecified-");     // Catch: Throwable -> L52
        int r0 = h;     // Catch: Throwable -> L52
        h = r0 + 1;     // Catch: Throwable -> L52
        r113.append(r0);     // Catch: Throwable -> L52
        r10.setLynxGroup(LynxGroup.Create(r113.toString(), new String[]{r112}));     // Catch: Throwable -> L52
        if (r16 == false) goto L45;
        r10.registerModule("hybridMonitor", LynxViewMonitorModule.class, r2);     // Catch: Throwable -> L52
    L46:
        LynxView r114 = r10.build(r11);     // Catch: Throwable -> L52
        if ((r2 instanceof com.bytedance.android.monitorV2.lynx.jsb.a) == false) goto L49;
        r2.a = r114;     // Catch: Throwable -> L52
    L50:
        int r115 = sl0.b.a;     // Catch: Throwable -> L52
        sl0.a.b.b(r114);     // Catch: Throwable -> L52
        r114.addLynxViewClient(new LiveLynxClient(this, r114));     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r114, "<set-?>");     // Catch: Throwable -> L52
        r5.o = r114;     // Catch: Throwable -> L52
        Object r116 = Result.constructor-impl(r114);     // Catch: Throwable -> L52
    L55:
        if (Result.exceptionOrNull-impl(r116) == null) goto L57;
        this.c.e();
    L57:
        ResultKt.throwOnFailure(r116);
        LynxView r117 = (LynxView) r116;
        this.b = r117;
        r117.setClipToOutline(true);
        r117.setOutlineProvider(new a());
        return;
    L49:
        ((xy2.a) r2).a = r114;     // Catch: Throwable -> L52
        goto L50
    L45:
        r10.registerModule("hybridMonitor", LynxMonitorModule.class, r2);     // Catch: Throwable -> L52
    L39:
        if ((!Intrinsics.areEqual(r112, "assets://open_platform_jssdk.js")) == false) goto L41;
        r112 = "file://".concat(r112);     // Catch: Throwable -> L52
        goto L41
    L22:
        if (r19 != 2) goto L24;
        r110 = ThreadStrategyForRendering.PART_ON_LAYOUT;     // Catch: Throwable -> L52
        goto L29
    L24:
        if (r19 == 3) goto L26;
        r110 = ThreadStrategyForRendering.ALL_ON_UI;     // Catch: Throwable -> L52
        goto L29
    L26:
        r110 = ThreadStrategyForRendering.MULTI_THREADS;     // Catch: Throwable -> L52
        goto L29
    L13:
        if (r12.intValue() <= 0) goto L15;
        boolean r20 = true;
    L16:
        if (r20 != true) goto L18;
        r18 = r12.intValue();     // Catch: Throwable -> L52
        goto L19
    L15:
        r20 = false;
    L52:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L5:
        r2 = new xy2.a();
        goto L6
    }
}
