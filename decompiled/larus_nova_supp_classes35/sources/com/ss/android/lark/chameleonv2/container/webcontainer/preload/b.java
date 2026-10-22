package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.Deprecated;
import kotlin.Result;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements IChameleonLoader.LoadingCallback {
    public final /* synthetic */ i<Boolean> a;
    public final /* synthetic */ PreloadBizHtmlStrategy b;

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final boolean getKeepOnRelease() {
        return true;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccess() {
        j.e("CML_TAG_PreloadBizHtmlStrategy", "onLoadSuccess, isActive = " + this.a.isActive() + ", isCancelled = " + this.a.isCancelled());
        OpenConfig r0 = this.b.b.getOpenConfig();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        if (r2 == false) goto L9;
        j.e("CML_TAG_PreloadBizHtmlStrategy", "statisticsByJS  == true");
    L10:
        this.b.a.A(this);
        if (this.a.isActive() == true) goto L13;
        return;
    L13:
        if (this.a.isCancelled() == true) goto L17;
        i<Boolean> r1 = this.a;
        Result.Companion r3 = Result.Companion;
        r1.resumeWith(Result.constructor-impl(Boolean.TRUE));
        return;
    L17:
        return;
    L9:
        this.b.a.setIsReady(true);
        goto L10
    L5:
        if (r0.getStatisticsByJS() != true) goto L7;
        r2 = true;
        goto L7
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadStart() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onLoadStart(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccessByJS() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onLoadSuccessByJS(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    @Deprecated(message = "已废弃，使用IRenderGoneListener")
    public final void onRenderProcessGone() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onRenderProcessGone(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onPageStarted(String r1) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onPageStarted(this, r1);
    }

    public b(kotlinx.coroutines.j r1, PreloadBizHtmlStrategy r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFail(int r1, Throwable r2) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onLoadFail(this, r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFailByJS(String r1, int r2) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onLoadFailByJS(this, r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onReceivedTitle(WebView r1, String r2) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onReceivedTitle(this, r1, r2);
    }
}
