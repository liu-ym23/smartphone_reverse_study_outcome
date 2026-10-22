package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements IChameleonLoader.LoadingCallback {
    public final /* synthetic */ yv4.e a;

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccess() {
        this.a.i();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final boolean getKeepOnRelease() {
        return IChameleonLoader.LoadingCallback.DefaultImpls.getKeepOnRelease(this);
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

    public b(yv4.e r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onPageStarted(String r1) {
        IChameleonLoader.LoadingCallback.DefaultImpls.onPageStarted(this, r1);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFail(int r1, Throwable r2) {
        this.a.i();
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
