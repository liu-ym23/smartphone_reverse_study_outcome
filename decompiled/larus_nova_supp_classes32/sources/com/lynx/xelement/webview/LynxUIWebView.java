package com.lynx.xelement.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import t8a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"webview"})
@LynxGeneratorName(packageName = "com.lynx.xelement.webview")
public class LynxUIWebView<T extends t8a.b> extends UISimpleView<T> {
    public static final String DEFAULT = "default";
    private String html;
    private boolean htmlChanged;
    private u8a.c provider;
    private String type;
    private String url;
    private boolean urlChanged;
    private WebView webView;
    private HashMap<String, Object> webViewParams;
    private u8a.b webViewService;

    public class a implements u8a.a {
        public final /* synthetic */ LynxUIWebView a;

        public a(LynxUIWebView r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ LynxUIWebView a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (LynxUIWebView.access$000(this.a) == null) goto L9;
            LynxUIWebView.access$000(this.a).loadUrl(LynxUIWebView.access$100(this.a));     // Catch: Throwable -> L6
            return;
        }

        public b(LynxUIWebView r1) {
            this.a = r1;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ LynxUIWebView a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (LynxUIWebView.access$000(this.a) == null) goto L9;
            LynxUIWebView.access$000(this.a).e(LynxUIWebView.access$200(this.a));     // Catch: Throwable -> L6
            return;
        }

        public c(LynxUIWebView r1) {
            this.a = r1;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        u8a.b r0 = this.webViewService;
        if (r0 == null) goto L6;
        r0.destroy();
        this.webViewService = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.webViewService != null) goto L13;
        if (this.provider != null) goto L7;
        this.provider = new t8a.c();
    L7:
        u8a.b r0 = this.provider.a(this.type, this.mContext);
        this.webViewService = r0;
        if (r0 == null) goto L13;
        r0.a();
        this.webViewService.b();
        this.webViewService.d(new a(this));
        WebView r1 = this.webViewService.getWebView();
        this.webView = r1;
        if (r1 == null) goto L13;
        r1.setBackgroundColor(0);
        ((t8a.b) this.mView).addView(this.webView, new ViewGroup.LayoutParams(-1, -1));
    L13:
        if (this.urlChanged == false) goto L15;
    L16:
        String r2 = this.url;
        boolean r3 = true;
        if (r2 != null) goto L19;
    L21:
        boolean r4 = false;
    L22:
        String r5 = this.html;
        if (r5 != null) goto L25;
    L27:
        r3 = false;
    L28:
        if (r4 == true) goto L30;
    L32:
        if (r3 == false) goto L35;
        if (r4 == true) goto L35;
        ((t8a.b) this.mView).post(new c(this));
    L35:
        if (r4 == true) goto L38;
        if (r3 == true) goto L38;
        m7a.a r6 = new m7a.a(getSign(), "error");
        r6.a("errorCode", -1);
        r6.a("errorMsg", "invalid input: src and html are empty");
        getLynxContext().getEventEmitter().sendCustomEvent(r6);
    L38:
        this.urlChanged = false;
        this.htmlChanged = false;
        return;
    L30:
        if (this.urlChanged == false) goto L32;
        ((t8a.b) this.mView).post(new b(this));
        goto L35
    L25:
        if (r5.isEmpty() == true) goto L27;
    L19:
        if (r2.isEmpty() == true) goto L21;
        r4 = true;
        goto L22
    L15:
        if (this.htmlChanged == true) goto L16;
    }

    public String getHtml() {
        return this.html;
    }

    public u8a.c getProvider() {
        return this.provider;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public LynxUIWebView(LynxContext r2) {
        this(r2, null);
    }

    public static /* synthetic */ u8a.b access$000(LynxUIWebView r0) {
        return r0.webViewService;
    }

    public static /* synthetic */ String access$100(LynxUIWebView r0) {
        return r0.url;
    }

    public static /* synthetic */ String access$200(LynxUIWebView r0) {
        return r0.html;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public T createView(Context r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (T) createWebViewContainer(r1);
    }

    public T createWebViewContainer(Context r2) {
        return (T) new t8a.b(r2);
    }

    @LynxProp(name = "enable-debug")
    public void setDebug(boolean r6) {
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L8;
        LynxContext r7 = this.mContext;
        if (r7 == null) goto L10;
        r7.handleLynxError(new LynxError(229800, "Not allow to set enable-debug if devtool is not enabled, please enable Lynx Devtool.", NameKeys.UnloadStrategy_No_Strategy, LynxError.LEVEL_WARN));
        return;
    L10:
        return;
    L8:
        WebView.setWebContentsDebuggingEnabled(r6);
    }

    public void setHtml(String r1) {
        this.html = r1;
    }

    @LynxProp(name = "html")
    public void setHtmlString(String r1) {
        this.html = r1;
        this.htmlChanged = true;
    }

    @LynxProp(name = LynxResourceModule.PARAMS_KEY)
    public void setParams(ReadableMap r1) {
        if (r1 != null) goto L4;
        HashMap<String, Object> r2 = null;
    L5:
        this.webViewParams = r2;
        return;
    L4:
        r2 = r1.asHashMap();
        goto L5
    }

    public void setProvider(u8a.c r1) {
        this.provider = r1;
    }

    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public void setSrc(String r1) {
        this.url = r1;
        this.urlChanged = true;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    @LynxProp(name = "webview-type")
    public void setWebViewType(String r1) {
        this.type = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    public LynxUIWebView(LynxContext r1, Object r2) {
        super(r1, r2);
        this.type = DEFAULT;
    }

    @LynxUIMethod
    public void eval(ReadableMap r4, Callback r5) {
        if (r4 != null) goto L4;
        String r6 = null;
    L6:
        if (r6 == null) goto L12;
        u8a.b r2 = this.webViewService;
        if (r2 == null) goto L10;
        r2.c(r6);
    L10:
        if (r5 == null) goto L15;
        r5.invoke(new Object[]{0});
        return;
    L15:
        return;
    L12:
        if (r5 == null) goto L17;
        r5.invoke(new Object[]{4, "params error"});
        return;
    L17:
        return;
    L4:
        r6 = r4.getString("func");
        goto L6
    }

    @LynxUIMethod
    public void reload(ReadableMap r3, Callback r4) {
        u8a.b r5 = this.webViewService;
        if (r5 == null) goto L5;
        r5.reload();
    L5:
        if (r4 == null) goto L8;
        r4.invoke(new Object[]{0});
        return;
    }
}
