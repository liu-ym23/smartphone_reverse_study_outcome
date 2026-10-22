package com.bytedance.android.live.lynx.components;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.browser.u;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.g7;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.gson.ILiveGsonService;
import com.bytedance.android.live.lynx.bridge.LiveLynxBridgeModule;
import com.bytedance.android.live.lynx.callback.LynxMonitorCallback;
import com.bytedance.android.live.lynx.monitor.LynxMonitor;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.o70;
import com.bytedance.android.livesdk.config.r70;
import com.bytedance.android.livesdk.g1;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.disposables.Disposable;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveLynxComponentForSaas implements com.bytedance.android.live.lynx.api.c {
    public static int y;
    public String a;
    public String b;
    public final LynxView c;
    public final IJsBridgeManager d;
    public final String e;
    public final ll0.a f;
    public final Lazy g;
    public Disposable h;
    public long i;
    public final Activity j;
    public final String k;
    public final Lazy<Handler> l;
    public final List<l> m;
    public final Map<String, Map<String, String>> n;
    public com.bytedance.android.live.browser.utils.b o;
    public v p;
    public u q;
    public com.bytedance.android.live.browser.jsbridge.h r;
    public w s;
    public final List<String> t;
    public int u;
    public final ILiveHybridContainer v;
    public final LynxThreadStrategy w;
    public d0 x;

    public static final class a {
    }

    public class b extends q1 {
        public final List<Function1<String, String>> a;
        public final /* synthetic */ LiveLynxComponentForSaas b;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveLynxComponentForSaas r0 = this.a.b;     // Catch: Throwable -> L6
                d0 r1 = r0.x;     // Catch: Throwable -> L6
                if (r1 == null) goto L9;
                r1.g(r0.c);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public final void onFirstScreen() {
            super.onFirstScreen();
            LiveLynxComponentForSaas r0 = this.b;
            d0 r1 = r0.x;
            if (r1 == null) goto L5;
            r1.b(r0.c);
        L5:
            Iterator r2 = ((ArrayList) this.b.m).iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            ((l) r2.next()).d(this.b.c);
            goto L7
        }

        public final void onLoadSuccess() {
            super.onLoadSuccess();
            LiveLynxComponentForSaas r0 = this.b;
            d0 r1 = r0.x;
            if (r1 == null) goto L5;
            r1.d(r0.c);
        L5:
            Iterator<T> r2 = this.b.m.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            ((l) r2.next()).e(this.b.c);
            goto L7
        }

        public final void onRuntimeReady() {
            super.onRuntimeReady();
            Iterator<T> r0 = this.b.m.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            ((l) r0.next()).k(this.b.c);
            goto L4
        L7:
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L11;
            LiveLynxComponentForSaas r1 = this.b;
            d0 r2 = r1.x;
            if (r2 == null) goto L14;
            r2.g(r1.c);
            return;
        L14:
            return;
        L11:
            ((Handler) this.b.l.getValue()).post(new a(this));
        }

        public final void onFirstLoadPerfReady(v0 r5) {
            super.onFirstLoadPerfReady(r5);
            Iterator<T> r0 = this.b.m.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((l) r0.next()).c(this.b.c, r5);
            goto L4
        L6:
            ALogger.d("chh_lynx", "onFirstLoadPerfReady() called with: metric = " + r5);
            this.b.sendJsEvent("perf", MapsKt.mapOf(new Pair[]{TuplesKt.to("perfBaseTimeStamp", String.valueOf(System.currentTimeMillis())), TuplesKt.to("perf", r5)}));
        }

        public final void onLoadFailed(String r4) {
            Iterator r0 = ((ArrayList) this.b.m).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            l r1 = (l) r0.next();
            LynxView r2 = this.b.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            com.bytedance.android.live.core.utils.v.a();
            goto L4
        L6:
            d0 r3 = this.b.x;
            if (r3 == null) goto L9;
            r3.a();
        L9:
            LiveLynxComponentForSaas r5 = this.b;
            d0 r6 = r5.x;
            if (r6 == null) goto L14;
            r6.c(r5.c, r4);
            return;
        }

        public final void onPageStart(String r4) {
            super.onPageStart(r4);
            LiveLynxComponentForSaas r0 = this.b;
            r0.i = System.currentTimeMillis();
            LiveLynxComponentForSaas r1 = this.b;
            d0 r2 = r1.x;
            if (r2 == null) goto L5;
            r2.e(r1.c, r4);
        L5:
            Iterator<T> r3 = this.b.m.iterator();
        L7:
            if (r3.hasNext() == false) goto L9;
            ((l) r3.next()).g(this.b.c, r4);
            goto L7
        }

        public final void onReceivedError(String r4) {
            super.onReceivedError(r4);
            Iterator<T> r0 = this.b.m.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((l) r0.next()).i(this.b.c, r4);
            goto L4
        L6:
            LiveLynxComponentForSaas r1 = this.b;
            d0 r2 = r1.x;
            if (r2 == null) goto L11;
            r2.f(r1.c, r4);
            return;
        }

        public final void onUpdatePerfReady(v0 r4) {
            super.onUpdatePerfReady(r4);
            Iterator<T> r0 = this.b.m.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((l) r0.next()).m(this.b.c, r4);
            goto L4
        }

        public final String shouldRedirectImageUrl(String r12) {
            Iterator<Function1<String, String>> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            String r1 = (String) r0.next().invoke(r12);
            if (TextUtils.isEmpty(r1) == true) goto L4;
            return r1;
        L8:
            boolean r2 = true;
            if (r12 != null) goto L11;
        L14:
            boolean r3 = true;
        L15:
            if (r3 == true) goto L66;
            String r4 = null;
            if (StringsKt.startsWith$default(r12, "data:image", false, 2, null) == true) goto L66;
            if (StringsKt.startsWith$default(r12, "app://", false, 2, null) == false) goto L27;
            if (r12 == null) goto L25;
            return "res:///" + r12.substring(6);
        L25:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L27:
            if (TextUtils.isEmpty(r12) == true) goto L64;
            if (com.bytedance.android.livesdk.gecko.n.b.c(r12) == null) goto L64;
            Iterator<T> r5 = this.b.t.iterator();
            int r6 = -1;
        L32:
            if (r5.hasNext() == false) goto L44;
            Object r7 = r5.next();
            String r8 = (String) r7;
            if (r12 == null) goto L36;
            Integer r9 = Integer.valueOf(StringsKt.indexOf$default(r12, r8, 0, false, 6, null));
        L37:
            int r10 = r9.intValue();
            if (r10 <= 0) goto L40;
            boolean r11 = true;
        L41:
            if (r11 == true) goto L45;
            r6 = r10;
        L45:
            String r13 = (String) r7;
            if (r13 != null) goto L48;
        L51:
            if (r2 == true) goto L64;
            StringBuilder r14 = new StringBuilder("file://");
            r14.append(jc1.k.n(IHostWebView.class).getOfflineCacheDir());
            r14.append('/');
            if (r12 == null) goto L55;
            r4 = r12.substring(r10 + r13.length());
        L55:
            r14.append(r4);
            String r15 = r14.toString();
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L61
            if (new PolarisFileWrapper(URI.create(r15)).exists() == false) goto L59;
            return r15;
        L59:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L64
        L48:
            if (StringsKt.isBlank(r13) == true) goto L51;
            r2 = false;
            goto L51
        L40:
            r11 = false;
            goto L41
        L36:
            r9 = null;
            goto L37
        L44:
            r10 = r6;
            r7 = null;
        L64:
            return super.shouldRedirectImageUrl(r12);
        L66:
            return super.shouldRedirectImageUrl(r12);
        L11:
            if (StringsKt.isBlank(r12) == true) goto L14;
            r3 = false;
            goto L15
        }

        public final void onReceivedError(LynxError r4) {
            super.onReceivedError(r4);
            Iterator<T> r0 = this.b.m.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((l) r0.next()).h(this.b.c, r4);
            goto L4
        }

        public b(LiveLynxComponentForSaas r2, List<? extends Function1<? super String, String>> r3) {
            Intrinsics.checkNotNullParameter(r3, "redirectImageUrls");
            this.b = r2;
            this.a = r3;
        }
    }

    static {
    }

    public final void release() {
        if (this.l.isInitialized() == false) goto L5;
        ((Handler) this.l.getValue()).removeCallbacksAndMessages(null);
    L5:
        com.bytedance.android.live.browser.jsbridge.i.d r0 = this.f.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stateObserver");
    L8:
        r0.release();
        this.c.destroy();
        this.d.release();
        Disposable r1 = this.h;
        if (r1 != null) goto L11;
    L15:
        Iterator<T> r2 = this.m.iterator();
    L17:
        if (r2.hasNext() == false) goto L19;
        ((l) r2.next()).j();
        goto L17
    L19:
        this.x = null;
        if ((!this.n.isEmpty()) == false) goto L34;
        Iterator<Map.Entry<String, Map<String, String>>> r3 = this.n.entrySet().iterator();
    L23:
        if (r3.hasNext() == false) goto L28;
        Map.Entry<String, Map<String, String>> r4 = r3.next();
        if (r4.getValue().containsKey("duration") == true) goto L27;
        r4.getValue().put("duration", String.valueOf(System.currentTimeMillis() - this.i));
    L27:
        com.bytedance.android.livesdk.log.u.l().sendLog(r4.getKey(), r4.getValue(), new Object[0]);
        goto L23
    L28:
        this.n.clear();
        return;
    L34:
        return;
    L11:
        if (r1.isDisposed() == true) goto L15;
        Disposable r5 = this.h;
        if (r5 == null) goto L15;
        r5.dispose();
        goto L15
    }

    public final void reload() {
        a(this, this.a, null, 6);
    }

    @Override // com.bytedance.android.live.lynx.api.c
    public final LynxView getLynxView() {
        return this.c;
    }

    public final void b(String r2) {
        this.a = r2;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(UriProtector.parse(r2).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        String r4 = (String) r3;
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        this.b = r4;
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void loadUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        a(this, r3, null, 6);
    }

    @Override // com.bytedance.android.live.lynx.api.c
    public final void updateData(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        updateData(r3, false, null);
    }

    public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.d.registerMethod(r2, r3);
    }

    @Override // com.bytedance.android.live.lynx.api.c
    public final void renderTemplate(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        a(this, r2, r3, 4);
    }

    public final <T> void sendJsEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.d.sendJsEvent(r2, r3);
    }

    public final <P, R> void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.g<P, R> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.d.registerMethod(r2, r3);
    }

    @Override // com.bytedance.android.live.lynx.api.c
    public final void updateData(Map<String, ? extends Object> r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r3 == false) goto L17;
        TemplateData r5 = TemplateData.fromMap(r2);
        if (r4 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == true) goto L13;
        r5.markState(r4);
    L13:
        com.bytedance.android.live.lynx.a r7 = (com.bytedance.android.live.lynx.a) com.bytedance.android.live.lynx.c.a(com.bytedance.android.live.lynx.a.class);
        if (r7 == null) goto L16;
        r7.d(r5);
    L16:
        this.c.updateData(r5);
        return;
    L7:
        if (StringsKt.isBlank(r4) == true) goto L10;
        r6 = false;
        goto L11
    L17:
        this.c.updateData(r2);
    }

    public static void a(final LiveLynxComponentForSaas r24, String r25, Map r26, int r27) {
        String r0 = r25;
        Object r4 = null;
        if ((r27 & 2) == 0) goto L5;
        Map r3 = null;
    L6:
        r24.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        int r5 = p20.c.a;
        Intrinsics.checkNotNullParameter(r0, "url");
    L10:
        if (((Boolean) o70.a.getValue()).booleanValue() == false) goto L16;
        u r6 = r24.q;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L14:
        r0 = r6.appendCommonParams(r0);
    L16:
        if (r0.length() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
        String r8 = r0;
    L22:
        if (r8 == null) goto L214;
        r24.b(r8);
        Iterator<T> r9 = r24.m.iterator();
    L26:
        if (r9.hasNext() == false) goto L29;
        ((l) r9.next()).b(r24.c, r24.a, r24.b);
        goto L26
    L29:
        if (((Boolean) LiveConfigSettingKeys.ENABLE_LYNX_OFFLINE.getValue()).booleanValue() == false) goto L40;
        int r10 = p20.c.a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L40;
        WebResourceResponse r12 = com.bytedance.android.livesdk.gecko.n.b.c(r0);
        if (r12 == null) goto L40;
        InputStream r13 = r12.getData();
        if (r13 == null) goto L40;
        byte[] r14 = ByteStreamsKt.readBytes(r13);
    L42:
        if (r14 != null) goto L44;
    L76:
        r14 = null;
    L77:
        List r15 = (List) r70.a.getValue();
        if (r14 == null) goto L80;
    L86:
        if (r14 != null) goto L102;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L102;
        int r16 = p20.c.a;
        Activity r17 = r24.j;
        Intrinsics.checkNotNullParameter(r0, "url");
        if (r17 == null) goto L102;
        if (SharedPrefHelper.c(r17, "ttlive_sdk_hybrid_test").a.getBoolean("lynx_fallback_switch", false) == false) goto L102;
        if (StringsKt.contains$default(r0, "/live/webcast_lynx_douyin", false, 2, null) == false) goto L96;
        List r18 = StringsKt.split$default(r0, new String[]{"/live/webcast_lynx_douyin"}, false, 0, 6, null);
    L97:
        if (r18 == null) goto L102;
        if (r18.size() < 2) goto L102;
        r0 = ((String) ListProtector.get(r18, 0)) + "/live/webcast_lynx_douyin/test" + ((String) ListProtector.get(r18, 1));
        goto L102
    L96:
        r18 = null;
    L102:
        String r19 = r0;
        if (r14 == null) goto L105;
        int r1 = 1;
    L106:
        r24.u = r1;
        Activity r2 = r24.j;
        if (r2 == null) goto L202;
        String r20 = r24.k;
        int r21 = com.bytedance.android.live.browser.utils.c.a;
        if (r19 != null) goto L111;
    L114:
        boolean r22 = true;
    L115:
        if (r22 == false) goto L117;
        com.bytedance.android.live.browser.utils.b r23 = null;
    L135:
        r24.o = r23;
        if (r23 == null) goto L138;
        r23.m(r24.e);
    L138:
        com.bytedance.android.live.browser.utils.b r28 = r24.o;
        if (r28 == null) goto L141;
        r28.F(LynxEnv.inst().getLynxVersion());
    L141:
        com.bytedance.android.live.browser.utils.b r29 = r24.o;
        if (r29 == null) goto L144;
        r29.K(r24.u);
    L144:
        ll0.a r30 = r24.f;
        r30.b = r24.o;
        IJsBridgeManager r31 = r24.d;
        Function1<String, Unit> r110 = new LiveLynxComponentForSaas$renderUrl$3(r24);
        Intrinsics.checkNotNullParameter(r19, "url");
        Intrinsics.checkNotNullParameter(r31, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r110, "subscriber");
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L158
        String r33 = UriProtector.getQueryParameter(UriProtector.parse(r19), "initialProps");     // Catch: Throwable -> L158
        if (r33 != null) goto L207;
        JSONArray r34 = null;
    L156:
        Object r35 = Result.constructor-impl(r34);     // Catch: Throwable -> L158
    L161:
        if (Result.isFailure-impl(r35) == false) goto L163;
        r35 = null;
    L163:
        JSONArray r36 = (JSONArray) r35;
        com.bytedance.android.live.browser.utils.b r37 = r30.b;
        if (r37 == null) goto L166;
        r37.E(r19);
    L166:
        com.bytedance.android.live.browser.jsbridge.i.d r38 = r30.a;
        if (r38 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("stateObserver");
    L169:
        r38.b(r19, r36, new ll0.b(r31), r110);
        Map<String, Object> r39 = r30.c;
        com.bytedance.android.live.browser.utils.b r40 = r30.b;
        int r41 = com.bytedance.android.live.browser.utils.c.a;
        if (r40 == null) goto L176;
        JsonObject r42 = GsonProtectorUtils.toJsonTree(jc1.k.n(ILiveGsonService.class).getDefault(), r40);
        if (r42 == null) goto L175;
        JsonObject r43 = r42;
        Lazy r44 = UtilsKt.a;
        Intrinsics.checkNotNullParameter(r43, "$this$toLinkedGsonMap");
        LinkedHashMap r45 = new LinkedHashMap(new GsonMap(r43));
    L177:
        r39.put("__globalProps", r45);
        Map<String, Object> r46 = r30.c;
        com.bytedance.android.live.browser.jsbridge.i.d r47 = r30.a;
        if (r47 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("stateObserver");
    L180:
        r46.put("initialProps", UtilsKt.i(r47.a()));
        long r48 = System.currentTimeMillis();
        if (r3 == null) goto L183;
        r24.f.c.putAll((Map<? extends String, ? extends Object>) r3);
        Map r49 = new LinkedHashMap();
        r49.putAll(r3);
        r49.putAll(r24.f.c);
    L184:
        LynxView r50 = r24.c;
        Object r51 = r49.get("__globalProps");
        if ((r51 instanceof Map) == false) goto L188;
        r4 = r51;
    L188:
        r50.setGlobalProps((Map) r4);
        if (r14 == null) goto L191;
        r24.c.renderTemplateWithBaseUrl(r14, r49, r19);
    L192:
        ALogger.i("chh_lynx", "renderTemplate() called with: template = " + r14 + ", url = " + r19 + ", cost:" + (System.currentTimeMillis() - r48));
        Iterator<T> r52 = r24.m.iterator();
    L194:
        if (r52.hasNext() == false) goto L215;
        l r53 = (l) r52.next();
        LynxView r54 = r24.c;
        if (r14 == null) goto L198;
        boolean r55 = true;
    L199:
        r53.l(r54, r55);
        goto L194
    L198:
        r55 = false;
        goto L199
    L215:
        return;
    L191:
        r24.c.renderTemplateUrl(r19, r49);
        goto L192
    L183:
        r49 = r24.f.c;
        goto L184
    L175:
        throw new NullPointerException("null cannot be cast to non-null type com.google.gson.JsonObject");
    L176:
        r45 = new LinkedHashMap();
        goto L177
    L207:
        Object r56 = Result.constructor-impl(new JSONArray(r33));     // Catch: Throwable -> L149
    L152:
        if (Result.isFailure-impl(r56) == false) goto L154;
        r56 = null;
    L154:
        r34 = (JSONArray) r56;     // Catch: Throwable -> L158
    L149:
        th = move-exception;
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L158
        r56 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L158:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L161
    L117:
        r23 = new com.bytedance.android.live.browser.utils.b();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L129
        if (((Boolean) com.bytedance.android.livesdk.v0.a.getValue()).booleanValue() == false) goto L123;
        IMiddlewareNetworkService r112 = (IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class);     // Catch: Throwable -> L129
        if (r112 == null) goto L126;
        Map<String, String> r113 = r112.getCommonParams();     // Catch: Throwable -> L129
    L127:
        com.bytedance.android.live.browser.utils.c.a(r23);     // Catch: Throwable -> L129
        r23.B(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L129
        com.bytedance.android.live.browser.utils.c.c(r23, r2, r113);     // Catch: Throwable -> L129
        com.bytedance.android.live.browser.utils.c.b(r23, r20, r19);     // Catch: Throwable -> L129
        com.bytedance.android.live.browser.utils.c.d(r23, r113);     // Catch: Throwable -> L129
        Object r59 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L129
    L131:
        Throwable r60 = Result.exceptionOrNull-impl(r59);
        if (r60 == null) goto L134;
        ALogger.e("HybridParamUtil", r60);
    L134:
        ALogger.i("HybridParamUtil", "common params:" + r23);
    L126:
        r113 = null;
        goto L127
    L123:
        IMiddlewareHostNetwork r114 = jc1.k.f(IMiddlewareHostNetwork.class);     // Catch: Throwable -> L129
        if (r114 == null) goto L126;
        r113 = r114.getCommonParams();     // Catch: Throwable -> L129
    L129:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        r59 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L131
    L111:
        if (StringsKt.isBlank(r19) == true) goto L114;
        r22 = false;
        goto L115
    L202:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    L105:
        r1 = 0;
        goto L106
    L80:
        if (ListUtils.isEmpty(r15) == true) goto L86;
        if (r15.contains(r24.b) == false) goto L86;
        boolean r62 = LynxMonitor.a;
        LynxMonitor.b(LynxMonitor.FallbackType.MISS_GECKO, "", r24.b, 0, 24);
        d0 r63 = r24.x;
        if (r63 == null) goto L200;
        r63.a();
        return;
    L200:
        return;
    L44:
        if (r14.length != 0) goto L46;
        boolean r65 = true;
    L47:
        if (r65 == false) goto L50;
        Pair r66 = TuplesKt.to(LynxMonitor.VerifyTemplateType.EMPTY_FILE, null);
    L57:
        LynxMonitor.VerifyTemplateType r67 = (LynxMonitor.VerifyTemplateType) r66.component1();
        Pair r68 = (Pair) r66.component2();
        if (r67 == LynxMonitor.VerifyTemplateType.VERIFY_SUCCEED) goto L77;
        boolean r115 = LynxMonitor.a;
        String r116 = r24.b;
        if (r68 == null) goto L64;
        Integer r117 = (Integer) r68.getFirst();
        if (r117 == null) goto L64;
        int r118 = r117.intValue();
    L65:
        if (r68 == null) goto L69;
        Integer r69 = (Integer) r68.getSecond();
        if (r69 == null) goto L69;
        int r70 = r69.intValue();
    L70:
        Intrinsics.checkNotNullParameter(r67, "type");
        Intrinsics.checkNotNullParameter(r116, "path");
        JSONObject r119 = new JSONObject();
        r119.put("type", r67.getTYPE());
        r119.put("path", r116);
        JSONObject r71 = new JSONObject();
        r71.put("header_value", r118);
        r71.put("template_size", r70);
        JSONObject r72 = new JSONObject();
        r72.put("virtual_aid", "88888");
        if (LynxMonitor.a == false) goto L73;
        int r120 = rl0.b.a;
        rl0.a.b.k(null, "lynx_verify_template", r116, r119, null, r71, r72, 0);
    L75:
        if (((Boolean) LiveConfigSettingKeys.ENABLE_LYNX_VERIFY_GECKO_RESOURCE.getValue()).booleanValue() == false) goto L77;
    L73:
        int r121 = rl0.b.a;
        rl0.a.b.j(null, "lynx_verify_template", r116, r119, null, r71, r72, false);
    L69:
        r70 = 0;
    L64:
        r118 = 0;
        goto L65
    L50:
        if (r14.length >= 4) goto L52;
        int r73 = -1;
    L54:
        if (r73 == r14.length) goto L56;
        r66 = TuplesKt.to(LynxMonitor.VerifyTemplateType.BROKEN_FILE, TuplesKt.to(Integer.valueOf(r73), Integer.valueOf(r14.length)));
        goto L57
    L56:
        r66 = TuplesKt.to(LynxMonitor.VerifyTemplateType.VERIFY_SUCCEED, null);
        goto L57
    L52:
        r73 = (((r14[0] & 255) | ((r14[1] & 255) << 8)) | ((r14[2] & 255) << 16)) | ((r14[3] & 255) << 24);
        goto L54
    L46:
        r65 = false;
        goto L47
    L33:
        r11 = ((Boolean) AnnieConfigSettingKeys.OFFLINE_SWITCH.a()).booleanValue();
    L40:
        r14 = null;
        goto L42
    L214:
        return;
    L21:
        r8 = null;
        goto L22
    L18:
        r7 = false;
        goto L19
    L5:
        r3 = r26;
        goto L6
    }

    public LiveLynxComponentForSaas(Activity r7, ILiveHybridContainer r8, String r9, Integer r10, LynxThreadStrategy r11, String r12, d0 r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r11, "lynxThreadStrategy");
        this.v = r8;
        this.w = r11;
        this.x = r13;
        this.a = "";
        this.b = "";
        this.g = LazyKt.lazy(LiveLynxComponentForSaas$redirectImageUrls$2.INSTANCE);
        this.l = LazyKt.lazy(LiveLynxComponentForSaas$handler$1.INSTANCE);
        ArrayList r15 = new ArrayList();
        this.m = r15;
        this.n = new LinkedHashMap();
        ArrayList r16 = new ArrayList();
        r16.addAll(TTLiveWebOfflineConfig.DOUYIN_CHANNEL_LIST);
        r16.addAll((List) g1.a.getValue());
        Unit r0 = Unit.INSTANCE;
        this.t = r16;
        this.j = r7;
        this.k = r12;
        BrowserServiceImpl.Companion.getClass();
        s20.b r17 = BrowserServiceImpl.access$getDiComponent$cp();
        r17.getClass();
        s20.b r18 = r17.b;
        v r1 = (v) r18.e.get();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.p = r1;
        u r2 = (u) r18.g.get();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
        this.r = (com.bytedance.android.live.browser.jsbridge.h) r18.c.get();
        w r19 = (w) r18.h.get();
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        this.s = r19;
        int r110 = pl0.b.a;
        pl0.b.a(r7.getApplication());
        b(r9);
        if (r8 == null) goto L6;
        String r111 = r8.getContainerId();
        if (r111 == null) goto L6;
    L7:
        this.e = r111;
        kl0.c r112 = new kl0.c(r7, new LiveLynxComponentForSaas$bridgeImpl$1(this));
        if (r8 == null) goto L13;
        v r3 = this.p;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L12:
        IJsBridgeManager r20 = r3.c(r8, r112);
    L17:
        this.d = r20;
        LynxMonitorCallback r4 = new LynxMonitorCallback();
        Intrinsics.checkNotNullParameter(r4, "callback");
        r15.add(r4);
        com.bytedance.android.live.browser.jsbridge.h r113 = this.r;
        if (r113 == null) goto L20;
        r113.a(r20);
    L20:
        r20.registerMethod("lynxReleaseSendLog", new e(this));
        this.h = jc1.k.n(IUserService.class).user().followStateChanged().subscribe(new com.bytedance.android.live.lynx.components.b(this), c.a);
        r20.registerMethod("monitorCommerceLotteryNumMsg", new f());
        boolean r21 = false;
        if (r12 != null) goto L23;
    L26:
        boolean r5 = true;
    L27:
        if (r5 == false) goto L29;
        r12 = r9;
    L29:
        JsonObject r6 = new JsonObject();
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L36
        Uri r114 = UriProtector.parse(r12);     // Catch: Throwable -> L36
        Iterator r23 = UriProtector.getQueryParameterNames(r114).iterator();     // Catch: Throwable -> L36
    L32:
        if (r23.hasNext() == false) goto L34;
        String r24 = (String) r23.next();     // Catch: Throwable -> L36
        r6.addProperty(r24, UriProtector.getQueryParameter(r114, r24));     // Catch: Throwable -> L36
        goto L32
    L34:
        Result.constructor-impl(r114);     // Catch: Throwable -> L36
    L38:
        this.f = new ll0.a();
        LynxViewBuilder r115 = LynxView.builder();     // Catch: Throwable -> L75
        r115.registerModule("bridge", LiveLynxBridgeModule.class, r112);     // Catch: Throwable -> L75
        Iterator<T> r25 = this.m.iterator();     // Catch: Throwable -> L75
    L41:
        if (r25.hasNext() == false) goto L43;
        ((l) r25.next()).a(r115);     // Catch: Throwable -> L75
        goto L41
    L43:
        w r26 = this.s;     // Catch: Throwable -> L75
        if (r26 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");     // Catch: Throwable -> L75
    L46:
        r115.addBehaviors(r26.getBehaviorList());     // Catch: Throwable -> L75
        if (r10 != null) goto L49;
    L54:
        Resources r116 = LiveResUtil.getResources();     // Catch: Throwable -> L75
        int r117 = WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics()).widthPixels;     // Catch: Throwable -> L75
    L55:
        r115.setPresetMeasuredSpec(View.MeasureSpec.makeMeasureSpec(r117, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Throwable -> L75
        ThreadStrategyForRendering r118 = ThreadStrategyForRendering.ALL_ON_UI;     // Catch: Throwable -> L75
        Map r27 = g7.a;     // Catch: Throwable -> L75
        Class r28 = Integer.TYPE;     // Catch: Throwable -> L75
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L75
        if (((Number) g7.a("lynx_thread_strategy", r28, 0)).intValue() != 1) goto L58;
        r21 = true;
    L58:
        if (r21 == false) goto L60;
        r118 = ThreadStrategyForRendering.PART_ON_LAYOUT;     // Catch: Throwable -> L75
    L60:
        LynxThreadStrategy r29 = this.w;     // Catch: Throwable -> L75
        int r30 = com.bytedance.android.live.lynx.components.a.a[r29.ordinal()];     // Catch: Throwable -> L75
        if (r30 == 1) goto L68;
        if (r30 != 2) goto L64;
        r118 = ThreadStrategyForRendering.PART_ON_LAYOUT;     // Catch: Throwable -> L75
    L69:
        r115.setThreadStrategyForRendering(r118);     // Catch: Throwable -> L75
        tl0.a.a(r115, r9, this.e);     // Catch: Throwable -> L75
        r115.setDynamicComponentFetcher(new n());     // Catch: Throwable -> L75
        LynxView r31 = r115.build(r7);     // Catch: Throwable -> L75
        r31.addLynxViewClient(new b(this, (List) this.g.getValue()));     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r31, "<set-?>");     // Catch: Throwable -> L75
        r112.o = r31;     // Catch: Throwable -> L75
        Iterator<T> r32 = this.m.iterator();     // Catch: Throwable -> L75
    L71:
        if (r32.hasNext() == false) goto L73;
        ((l) r32.next()).f(r31);     // Catch: Throwable -> L75
        goto L71
    L73:
        Object r33 = Result.constructor-impl(r31);     // Catch: Throwable -> L75
    L78:
        if (Result.exceptionOrNull-impl(r33) == null) goto L80;
        this.d.release();
    L80:
        ResultKt.throwOnFailure(r33);
        this.c = (LynxView) r33;
        if (r14 == false) goto L91;
        reload();
        return;
    L91:
        return;
    L64:
        if (r30 != 3) goto L69;
        r118 = ThreadStrategyForRendering.MULTI_THREADS;     // Catch: Throwable -> L75
        goto L69
    L68:
        r118 = ThreadStrategyForRendering.MOST_ON_TASM;     // Catch: Throwable -> L75
        goto L69
    L49:
        if (r10.intValue() <= 0) goto L51;
        boolean r34 = true;
    L52:
        if (r34 != true) goto L54;
        r117 = r10.intValue();     // Catch: Throwable -> L75
        goto L55
    L51:
        r34 = false;
    L75:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L23:
        if (StringsKt.isBlank(r12) == true) goto L26;
        r5 = false;
        goto L27
    L13:
        v r37 = this.p;
        if (r37 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L16:
        r20 = r37.createJsBridgeManager(r7, r112, 2);
    L6:
        int r119 = y;
        y = r119 + 1;
        r111 = String.valueOf(r119);
        goto L7
    }
}
