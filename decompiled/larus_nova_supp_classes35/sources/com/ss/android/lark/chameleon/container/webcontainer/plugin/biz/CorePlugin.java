package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.api.pluginapi.IUrlInterceptorPlugin;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0003\u001a\b\u0018\u00010\u0004R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/CorePlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "delegateWebViewClient", "Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/CorePlugin$DelegateWebViewClient;", "onAttachToHost", BuildConfig.FLAVOR, "host", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "Companion", "DelegateWebViewClient", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CorePlugin extends AbsChameleonPlugin {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_CorePlugin";
    private DelegateWebViewClient delegateWebViewClient;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/CorePlugin$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/CorePlugin$DelegateWebViewClient;", "Landroid/webkit/WebViewClient;", "interceptor", "Lcom/ss/android/lark/chameleon/api/pluginapi/IUrlInterceptorPlugin;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/CorePlugin;Lcom/ss/android/lark/chameleon/api/pluginapi/IUrlInterceptorPlugin;)V", "shouldOverrideUrlLoading", BuildConfig.FLAVOR, "view", "Landroid/webkit/WebView;", "url", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class DelegateWebViewClient extends WebViewClient {
        private final IUrlInterceptorPlugin interceptor;
        final /* synthetic */ CorePlugin this$0;

        public DelegateWebViewClient(CorePlugin r2, IUrlInterceptorPlugin r3) {
            Intrinsics.checkNotNullParameter(r3, "interceptor");
            this.this$0 = r2;
            this.interceptor = r3;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r2, String r3) {
            if (this.interceptor.shouldOverrideUrlLoading(r2, r3) == false) goto L6;
            return true;
        L6:
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CorePlugin() {
    }

    public void onAttachToHost(ChameleonPluginHost r4) {
        super.onAttachToHost(r4);
        IUrlInterceptorPlugin r0 = null;
        if (r4 == null) goto L7;
        Web r1 = r4.getWeb();
        if (r1 == null) goto L7;
        WebView r2 = r1.getWebView();
    L9:
        if ((r2 instanceof ChameleonWebView) == false) goto L11;
        ChameleonWebView r3 = (ChameleonWebView) r2;
    L12:
        if (r3 == null) goto L14;
        r3.setUsedCount(r3.getUsedCount() + 1);
    L14:
        if (r4 == null) goto L16;
        Plugin r5 = r4.findPluginByInterface(IUrlInterceptorPlugin.class);
    L18:
        if ((r5 instanceof IUrlInterceptorPlugin) == false) goto L20;
        r0 = (IUrlInterceptorPlugin) r5;
    L20:
        Log.i("CML_TAG_CorePlugin", " iUrlInterceptorPlugin " + r0);
        if (r0 == null) goto L25;
        if (r3 == null) goto L26;
        DelegateWebViewClient r6 = new DelegateWebViewClient(this, r0);
        this.delegateWebViewClient = r6;
        r3.addWebViewClientDelegate(0, r6);
        return;
    L26:
        return;
    L25:
        return;
    L16:
        r5 = null;
        goto L18
    L11:
        r3 = null;
    L7:
        r2 = null;
        goto L9
    }

    public void onDetachFromHost(ChameleonPluginHost r5) {
        super.onDetachFromHost(r5);
        DelegateWebViewClient r0 = this.delegateWebViewClient;
        if (r0 == null) goto L15;
        ChameleonWebView r1 = null;
        if (r5 == null) goto L9;
        Web r2 = r5.getWeb();
        if (r2 == null) goto L9;
        WebView r3 = r2.getWebView();
    L11:
        if ((r3 instanceof ChameleonWebView) == false) goto L13;
        r1 = (ChameleonWebView) r3;
    L13:
        if (r1 == null) goto L15;
        r1.removeWebViewClientDelegate(r0);
    L9:
        r3 = null;
    L15:
        if (r5 == null) goto L20;
        IChameleonLoader r6 = r5.getLoader();
        if (r6 == null) goto L21;
        r6.release();
        return;
    L21:
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }
}
