package com.ss.android.lark.chameleonv2.container.webcontainer.plugin;

import android.text.TextUtils;
import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.OpenStatus;
import com.ss.android.lark.chameleon.pluginapi.RouterState;
import com.ss.android.lark.chameleon.pluginapi.WebviewStatus;
import com.ss.android.lark.chameleonv2.container.webcontainer.preload.ChameleonPreloader;
import com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadStatus;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.d;
import com.ss.android.lark.officesdk.utils.di.e;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.m;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonLoaderImpl extends WebViewClient implements IChameleonLoader {
    public final ChameleonWebView a;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final RouterState<Serializable> getRouterState() {
        return this.a.getRouterState();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final WebviewStatus getStatus() {
        return this.a.getStatus();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final boolean getVisible() {
        return this.a.getIsVisible();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void onLoadSuccess() {
        this.a.getCallbackAdapter().onLoadSuccess();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void release() {
        this.a.h1.b();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void reload() {
        this.a.clearView();
        this.a.setOnLoadSuccess(false);
        this.a.onResume();
        this.a.resumeTimers();
        this.a.setStartLoadUrlTime(System.currentTimeMillis());
        this.a.getCallbackAdapter().onLoadStart();
        this.a.reload();
    }

    public ChameleonLoaderImpl(ChameleonWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void addLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.a.w(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void addTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "cb");
        ChameleonWebView r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "cb");
        UIThreadCallbackAdapter r2 = r1.h1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "cb");
        r2.b.add(r3);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void load(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "url");
        this.a.getCallbackAdapter().onLoadStart();
        this.a.setLoadUrl(r6);
        final ChameleonPreloader r0 = this.a.getPreloader();
        final PreloadStatus r1 = r0.c();
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonLoaderImpl.TAG, "load url, preloadStatus = " + r1);
        Map r7 = MapsKt.mapOf(new Pair[]{TuplesKt.to(AnonymousClass1.INSTANCE, new AnonymousClass2(this, r6, r1, r0)), TuplesKt.to(AnonymousClass3.INSTANCE, new AnonymousClass4(r0, this, r6))});
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r7, "map");     // Catch: Throwable -> L14
        Iterator r8 = r7.entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) r8.next();     // Catch: Throwable -> L14
        if (((Boolean) ((Function1) r2.getKey()).invoke(r0.c)).booleanValue() == false) goto L6;
        ((Function0) r2.getValue()).invoke();     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L12:
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void removeLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.a.A(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void removeTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "cb");
        ChameleonWebView r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "cb");
        UIThreadCallbackAdapter r2 = r1.h1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "cb");
        r2.b.remove(r3);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void setRouteState(RouterState<Serializable> r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.setRouterState(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void onLoadFailed(int r2, Throwable r3) {
        this.a.getCallbackAdapter().onLoadFail(r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void reportOpenStatus(OpenStatus r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, ChameleonOpenTracker.ParamKey.RESULT);
        ChameleonWebView r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, ChameleonOpenTracker.ParamKey.RESULT);
        if (r4 != OpenStatus.SUCCESS) goto L5;
        r1.h1.onLoadSuccessByJS();
    L6:
        int r6 = ChameleonWebView.e.b[r4.ordinal()];
        if (r6 != 1) goto L9;
        String r7 = ChameleonOpenTracker.OpenResult.SUCCESS;
        r5 = 0;
    L19:
        Map<String, u1b.a.C0305a> r0 = u1b.a.a;
        u1b.a.C0305a r2 = u1b.a.a(r1.getSession());
        if (r2 == null) goto L23;
        u1b.a.C0305a.b(r2, r7, r5);
        return;
    L23:
        return;
    L9:
        if (r6 != 2) goto L11;
        r7 = ChameleonOpenTracker.OpenResult.FAILED;
        goto L19
    L11:
        if (r6 != 3) goto L13;
        r7 = ChameleonOpenTracker.OpenResult.TIMEOUT;
        r5 = -2;
        goto L19
    L13:
        if (r6 == 4) goto L15;
        r7 = "unknown";
        r5 = -1;
        goto L19
    L15:
        r7 = ChameleonOpenTracker.OpenResult.CANCEL;
        r5 = -3;
        goto L19
    L5:
        r1.h1.onLoadFailByJS(r4.toString(), r5);
        goto L6
    }

    public static final void a(ChameleonLoaderImpl r6, String r7, PreloadStatus r8, PreloadPolicy r9) {
        r6.getClass();
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonLoaderImpl.TAG, "doLoad url, preloadStatus = " + r8 + ", preloadType = " + r9);
        Map<String, u1b.a.C0305a> r0 = u1b.a.a;
        u1b.a.C0305a r1 = u1b.a.a(r6.a.getSession());
        String r2 = ChameleonOpenTracker.Stage.PRELOAD;
        if (r1 == null) goto L5;
        u1b.a.C0305a.e(r1, ChameleonOpenTracker.Stage.PRELOAD);
        u1b.a.C0305a.e(r1, ChameleonOpenTracker.Stage.RENDER);
    L5:
        boolean r3 = false;
        r6.a.setOnLoadSuccess(false);
        r6.a.onResume();
        r6.a.resumeTimers();
        r6.a.setStartLoadUrlTime(System.currentTimeMillis());
        if (r6.a.getIsReady() == true) goto L9;
        r2 = "no_preload";
    L9:
        String r5 = null;
        if (r9 == PreloadPolicy.PRELOAD_BIZ_HTML) goto L12;
        int r10 = e.a;
        int r11 = d.a;
        if (e.a.b(d.a.a().getApplicationContext()) == false) goto L47;
        HashMap r12 = new HashMap();
        int r13 = m.a;
        ntb.a r14 = m.a.a().h();
        if (r14 == null) goto L37;
        r5 = r14.a;
    L37:
        if (r5 != null) goto L39;
    L44:
        if (r3 == false) goto L46;
        r12.put("x-tt-env", r5);
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonLoaderImpl.TAG, "x-tt-env injected: " + r5);
    L46:
        r6.a.loadUrl(r7, r12);
    L48:
        u1b.a.C0305a r15 = u1b.a.a(r6.a.getSession());
        if (r15 == null) goto L52;
        Intrinsics.checkNotNullParameter(ChameleonOpenTracker.ParamKey.LOAD_TYPE, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r15.e.put(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r2);
        return;
    L52:
        return;
    L39:
        if (r5.length() <= 0) goto L41;
        boolean r16 = true;
    L42:
        if (r16 != true) goto L44;
        r3 = true;
        goto L44
    L41:
        r16 = false;
        goto L42
    L47:
        r6.a.loadUrl(r7);
        goto L48
    L12:
        if (r8 != PreloadStatus.PRELOAD_SUCCESS) goto L15;
        r6.a.getCallbackAdapter().onLoadSuccess();
        goto L48
    L15:
        if (r8 != PreloadStatus.PRELOAD_FAILED) goto L25;
        PreloadConfig r17 = r6.a.getChameleonConfig().getPreloadConfig();
        if (r17 == null) goto L20;
        r5 = r17.getTemplateUrl();
    L20:
        if (TextUtils.isEmpty(r5) == false) goto L48;
        String r18 = r6.a.getChameleonConfig().getLoadUrl();
        if (r18 != null) goto L24;
        r18 = r6.a.getUrl();
    L24:
        r6.a.loadUrl(r18);
        goto L48
    L25:
        OpenConfig r19 = r6.a.getChameleonConfig().getOpenConfig();
        if (r19 != null) goto L28;
    L30:
        if (r3 == true) goto L48;
        r6.a.getCallbackAdapter().onLoadSuccess();
        goto L48
    L28:
        if (r19.getHideLoadingByJS() != true) goto L30;
        r3 = true;
        goto L30
    }
}
