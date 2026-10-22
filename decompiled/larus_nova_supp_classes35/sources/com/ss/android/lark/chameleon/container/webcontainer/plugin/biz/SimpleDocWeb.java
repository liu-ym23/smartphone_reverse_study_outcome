package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleWebV2;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/SimpleDocWeb;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/SimpleWebV2;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "bridge", "Lcom/ss/android/lark/chameleon/bridge/Bridge;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Lcom/ss/android/lark/chameleon/bridge/Bridge;)V", "addWebChromeClientDelegate", BuildConfig.FLAVOR, "clientDelegate", "Landroid/webkit/WebChromeClient;", "priority", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SimpleDocWeb extends SimpleWebV2 {
    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleWebV2, com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebChromeClientDelegate(WebChromeClient r3) {
        if ((getWebView() instanceof ChameleonWebView) == false) goto L6;
        WebView r0 = getWebView();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView");
        ((ChameleonWebView) r0).addWebChromeClientDelegate(r3);
        return;
    }

    public SimpleDocWeb(ChameleonWebView r2, Bridge r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        super(r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleWebV2, com.ss.android.lark.chameleon.pluginsystem.Web
    public void addWebChromeClientDelegate(WebChromeClient r3, int r4) {
        if ((getWebView() instanceof ChameleonWebView) == false) goto L6;
        WebView r0 = getWebView();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView");
        ((ChameleonWebView) r0).addWebChromeClientDelegate(r4, r3);
        return;
    }
}
