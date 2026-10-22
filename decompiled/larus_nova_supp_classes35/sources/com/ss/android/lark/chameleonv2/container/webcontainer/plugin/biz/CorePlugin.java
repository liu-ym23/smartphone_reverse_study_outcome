package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.IUrlInterceptorPlugin;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/CorePlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "onAttachToHost", BuildConfig.FLAVOR, "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "Companion", "DelegateWebViewClient", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CorePlugin extends AbsChameleonPlugin {
    public static final a Companion = null;
    public static final String TAG = "CML_TAG_CorePlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b extends WebViewClient {
        public final IUrlInterceptorPlugin a;

        public b(IUrlInterceptorPlugin r2) {
            Intrinsics.checkNotNullParameter(r2, "interceptor");
            this.a = r2;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r2, String r3) {
            if (this.a.shouldOverrideUrlLoading(r2, r3) == false) goto L6;
            return true;
        L6:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public CorePlugin() {
    }

    public void onAttachToHost(ChameleonPluginHost r4) {
        super.onAttachToHost(r4);
        IUrlInterceptorPlugin r0 = null;
        if (r4 == null) goto L5;
        f r1 = r4.findPluginByInterface(IUrlInterceptorPlugin.class);
    L7:
        if ((r1 instanceof IUrlInterceptorPlugin) == false) goto L9;
        r0 = (IUrlInterceptorPlugin) r1;
    L9:
        j.e("CML_TAG_CorePlugin", " iUrlInterceptorPlugin " + r0);
        if (r0 == null) goto L15;
        k r5 = r4.getChameleonWeb();
        if (r5 == null) goto L16;
        r5.addWebViewClientDelegate(new b(r0));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public void onDetachFromHost(ChameleonPluginHost r4) {
        super.onDetachFromHost(r4);
        ChameleonWebView r0 = null;
        if (r4 == null) goto L7;
        k r1 = r4.getWeb();
        if (r1 == null) goto L7;
        WebView r2 = r1.getWebView();
    L9:
        if ((r2 instanceof ChameleonWebView) == false) goto L11;
        r0 = (ChameleonWebView) r2;
    L11:
        if (r0 == null) goto L13;
        r0.setUsedCount(r0.getUsedCount() + 1);
    L13:
        if (r4 == null) goto L18;
        IChameleonLoader r5 = r4.getLoader();
        if (r5 == null) goto L19;
        r5.release();
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }
}
