package com.ss.android.lark.chameleon.container.webcontainer.plugin.core;

import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.api.PreloadPolicy;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.container.webcontainer.preload.ChameleonPreloader;
import com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadStatus;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0002J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonLoaderImpl;", "Landroid/webkit/WebViewClient;", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;)V", "addLoadCallback", BuildConfig.FLAVOR, "cb", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "beforeLoad", "doLoad", "url", BuildConfig.FLAVOR, "preloadStatus", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadStatus;", "preloadType", "Lcom/ss/android/lark/chameleon/api/PreloadPolicy;", "getVisible", BuildConfig.FLAVOR, "load", "onLoadFailed", "code", BuildConfig.FLAVOR, "message", "e", BuildConfig.FLAVOR, "onLoadSuccess", "release", "reload", "removeLoadCallback", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonLoaderImpl extends WebViewClient implements IChameleonLoader {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_ChameleonLoaderImpl";
    private final ChameleonWebView webView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonLoaderImpl$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void beforeLoad() {
        this.webView.setOnLoadSuccess(false);
        this.webView.onResume();
        this.webView.resumeTimers();
        this.webView.setStartLoadUrlTime(System.currentTimeMillis());
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public boolean getVisible() {
        return this.webView.isVisible();
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public void onLoadSuccess() {
        this.webView.getCallbackAdapter().onLoadSuccess();
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public void release() {
        this.webView.release();
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public void reload() {
        this.webView.clearView();
        beforeLoad();
        this.webView.getCallbackAdapter().onLoadStart();
        this.webView.reload();
    }

    public ChameleonLoaderImpl(ChameleonWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.webView = r2;
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public void addLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.webView.addLoadCallback(r2);
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public void load(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "url");
        this.webView.getCallbackAdapter().onLoadStart();
        this.webView.setLoadUrl(r6);
        final ChameleonPreloader r0 = this.webView.getPreloader();
        final PreloadStatus r1 = r0.getPreloadStatus();
        Log.i(TAG, "load url, preloadStatus = " + r1);
        r0.executeWithStatus(MapsKt.mapOf(new Pair[]{TuplesKt.to(AnonymousClass1.INSTANCE, new AnonymousClass2(this, r6, r1, r0)), TuplesKt.to(AnonymousClass3.INSTANCE, new AnonymousClass4(r0, this, r6))}));
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public void removeLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.webView.removeLoadCallback(r2);
    }

    private final void doLoad(String r8, PreloadStatus r9, PreloadPolicy r10) {
        Log.i(TAG, "doLoad url, preloadStatus = " + r9 + ", preloadType = " + r10);
        ChameleonOpenTracker r11 = ChameleonOpenTracker.INSTANCE;
        ChameleonOpenTracker.SessionTracker r1 = r11.getSessionTracker(this.webView.getSession());
        if (r1 == null) goto L5;
        ChameleonOpenTracker.SessionTracker.stageStart$default(r1, ChameleonOpenTracker.Stage.RENDER, 0, 2, null);
    L5:
        beforeLoad();
        if (r10 != PreloadPolicy.PRELOAD_BIZ_HTML) goto L17;
        OpenConfig r12 = this.webView.getChameleonConfig().getOpenConfig();
        boolean r13 = false;
        if (r12 != null) goto L10;
    L12:
        if (r13 == true) goto L14;
        this.webView.getCallbackAdapter().onLoadSuccess();
    L14:
        ChameleonOpenTracker.SessionTracker r14 = r11.getSessionTracker(this.webView.getSession());
        if (r14 == null) goto L21;
        r14.recordParam(ChameleonOpenTracker.ParamKey.LOAD_TYPE, "offline");
        return;
    L21:
        return;
    L10:
        if (r12.getHideLoadingByJS() != true) goto L12;
        r13 = true;
        goto L12
    L17:
        this.webView.loadUrl(r8);
        ChameleonOpenTracker.SessionTracker r15 = r11.getSessionTracker(this.webView.getSession());
        if (r15 == null) goto L23;
        r15.recordParam(ChameleonOpenTracker.ParamKey.LOAD_TYPE, "online");
        return;
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader
    public void onLoadFailed(int r2, String r3, Throwable r4) {
        this.webView.getCallbackAdapter().onLoadFail(r2, r3, r4);
    }

    public static final /* synthetic */ void access$doLoad(ChameleonLoaderImpl r0, String r1, PreloadStatus r2, PreloadPolicy r3) {
        r0.doLoad(r1, r2, r3);
    }
}
