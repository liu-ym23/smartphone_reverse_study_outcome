package com.bytedance.ai.applet.render.core.webview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import d3.a0;
import d3.w;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import z2.b;
import z2.c;
import z2.d;
import z2.g;
import z2.l;
import z2.m;
import z2.n;
import z2.p;
import z2.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\fH\u0007J\b\u0010 \u001a\u00020\u001aH\u0016J\u001c\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u001c\u0010&\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u001c\u0010'\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u001c\u0010(\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\b\u0010)\u001a\u00020\u001aH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006*"}, d2 = {"Lcom/bytedance/ai/applet/render/core/webview/EmbedWebView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "webView", "Landroid/webkit/WebView;", "service", "Lcom/bytedance/ai/applet/render/core/webview/EmbedWebViewService;", "urlChanged", "", "htmlChanged", com.bytedance.android.ec.core.event.a.KEY_URL, "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "html", "getHtml", "setHtml", "createView", "Landroid/content/Context;", "setService", "", "setSrc", "src", "setHtmlString", "setDebug", "debug", "onNodeReady", "eval", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "reload", "postMessage", "onGoBack", "destroy", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmbedWebView extends UISimpleView<FrameLayout> {
    public WebView a;
    public l b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;

    public static final class a implements c {
        public final /* synthetic */ EmbedWebView a;

        @Override // z2.c
        public final void onPageFinished() {
            l r0 = this.a.b;
            if (r0 == null) goto L7;
            Intrinsics.checkNotNullParameter("(function() {window.addEventListener('message', function(event) {   var data = event.data;   if (typeof data !== 'string') return;   if (typeof AppletBridgeModule === 'object' && AppletBridgeModule.postMessage) {       AppletBridgeModule.postMessage(JSON.stringify({           type: 'call',           name: 'doubao.postMessage',           callbackId: 0,           params: { data: data },           target: { scope: 'system', target: 'bridge' }       }));   }});})();", "script");
            WebView r1 = r0.e;
            if (r1 == null) goto L7;
            r1.evaluateJavascript("(function() {window.addEventListener('message', function(event) {   var data = event.data;   if (typeof data !== 'string') return;   if (typeof AppletBridgeModule === 'object' && AppletBridgeModule.postMessage) {       AppletBridgeModule.postMessage(JSON.stringify({           type: 'call',           name: 'doubao.postMessage',           callbackId: 0,           params: { data: data },           target: { scope: 'system', target: 'bridge' }       }));   }});})();", null);
        L7:
            l r10 = this.a.b;
            if (r10 != null) goto L29;
        L27:
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(this.a.getSign(), "load"));
            return;
        L29:
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
            d r12 = r10.c;     // Catch: Throwable -> L15
            if (r12 == null) goto L12;
            String r13 = r12.e();     // Catch: Throwable -> L15
        L13:
            Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L15
        L18:
            if (Result.isFailure-impl(r14) == false) goto L20;
            r14 = null;
        L20:
            String r15 = (String) r14;
            if (r15 == null) goto L27;
            l r16 = this.a.b;
            if (r16 == null) goto L27;
            Intrinsics.checkNotNullParameter(r15, "script");
            WebView r17 = r16.e;
            if (r17 == null) goto L27;
            r17.evaluateJavascript(r15, null);
            goto L27
        L12:
            r13 = null;
        L15:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L18
        }

        public a(EmbedWebView r1) {
            this.a = r1;
        }

        @Override // z2.c
        public final void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            EventEmitter r1 = this.a.getLynxContext().getEventEmitter();
            m7a.a r11 = new m7a.a(this.a.getSign(), com.bytedance.android.ec.core.event.a.KEY_MSG);
            r11.a(MessageIndication.MESSAGE_TYPE_MSG, r10);
            r1.sendCustomEvent(r11);
        }

        @Override // z2.c
        public final void b(int r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "errorMessage");
            EventEmitter r0 = this.a.getLynxContext().getEventEmitter();
            m7a.a r1 = new m7a.a(this.a.getSign(), IHostStyleUIDepend.TOAST_TYPE_ERROR);
            r1.a("errorCode", Integer.valueOf(r10));
            r1.a("errorMsg", r11);
            r0.sendCustomEvent(r1);
        }
    }

    public final void destroy() {
        super/*com.lynx.tasm.behavior.ui.UIGroup*/.destroy();
        l r0 = this.b;
        if (r0 == null) goto L14;
        EmbedWebViewService$registerBackPressedInterception$callback$1 r10 = r0.m;
        if (r10 == null) goto L7;
        r10.remove();
    L7:
        r0.m = null;
        r0.c();
        w r11 = r0.f;
        if (r11 == null) goto L10;
        r11.g();
    L10:
        r0.f = null;
        WebView r12 = r0.e;
        if (r12 == null) goto L13;
        r12.destroy();
    L13:
        r0.e = null;
    L14:
        this.b = null;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.activity.OnBackPressedCallback, com.bytedance.ai.applet.render.core.webview.EmbedWebViewService$registerBackPressedInterception$callback$1] */
    public final void onNodeReady() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onNodeReady();
        boolean r10 = true;
        if (this.a != null) goto L83;
        final l r0 = this.b;
        final ComponentActivity r11 = null;
        if (r0 == null) goto L64;
        WebView r12 = new WebView(r0.a);
        r0.e = r12;
        WebSettings r13 = r12.getSettings();
        if (r13 == null) goto L9;
        r13.setJavaScriptEnabled(true);
    L9:
        WebView r14 = r0.e;
        if (r14 == null) goto L14;
        WebSettings r15 = r14.getSettings();
        if (r15 == null) goto L14;
        r15.setAllowFileAccess(false);
    L14:
        WebView r16 = r0.e;
        if (r16 == null) goto L19;
        WebSettings r17 = r16.getSettings();
        if (r17 == null) goto L19;
        r17.setAllowContentAccess(false);
    L19:
        WebView r18 = r0.e;
        if (r18 == null) goto L24;
        WebSettings r19 = r18.getSettings();
        if (r19 == null) goto L24;
        r19.setJavaScriptCanOpenWindowsAutomatically(true);
    L24:
        WebView r20 = r0.e;
        if (r20 == null) goto L29;
        WebSettings r21 = r20.getSettings();
        if (r21 == null) goto L29;
        r21.setMixedContentMode(0);
    L29:
        WebView r22 = r0.e;
        if (r22 == null) goto L34;
        WebSettings r23 = r22.getSettings();
        if (r23 == null) goto L34;
        r23.setDomStorageEnabled(true);
    L34:
        WebView r24 = r0.e;
        if (r24 == null) goto L39;
        WebSettings r25 = r24.getSettings();
        if (r25 == null) goto L39;
        r25.setUseWideViewPort(true);
    L39:
        WebView r26 = r0.e;
        if (r26 == null) goto L44;
        WebSettings r27 = r26.getSettings();
        if (r27 == null) goto L44;
        r27.setLoadWithOverviewMode(true);
    L44:
        WebView r28 = r0.e;
        if (r28 == null) goto L60;
        WebSettings r29 = r28.getSettings();
        if (r29 == null) goto L60;
        if (r0.b.length() <= 0) goto L51;
        boolean r30 = true;
    L53:
        if (r30 == true) goto L117;
        String r31 = "";
    L59:
        r29.setUserAgentString(r29.getUserAgentString() + ' ' + r31 + "DoubaoApps/0.3.0");
        goto L60
    L117:
        String r32 = r0.a.getPackageManager().getPackageInfo(r0.a.getPackageName(), 0).versionName;     // Catch: Exception -> L116
        if (r32 == null) goto L56;
    L57:
        r31 = r0.b + '/' + r32 + ' ';
    L56:
        r32 = "unknown";
        goto L57
    L51:
        r30 = false;
    L60:
        WebView r33 = r0.e;
        Intrinsics.checkNotNull(r33);
        r33.setWebViewClient(new m(r0));
        WebView r34 = r0.e;
        Intrinsics.checkNotNull(r34);
        r34.setWebChromeClient(new n(r0));
        WebView r35 = r0.e;
        Intrinsics.checkNotNull(r35);
        WebViewAIBridgePort.Companion.getClass();
        WebViewAIBridgePort r36 = WebViewAIBridgePort.a.a(r35);
        if (r36 != null) goto L63;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] failed to create WebViewAIBridgePort", null);
        goto L64
    L63:
        w r37 = new w();
        r0.f = r37;
        r37.i.b(a0.class, r0.g, RefType.WEAK);
        r37.i.b(p.class, new g(r0), RefType.NORMAL);
        r37.d(new t());
        r37.k(r36);
    L64:
        l r1 = this.b;
        if (r1 == null) goto L67;
        a r38 = new a(this);
        Intrinsics.checkNotNullParameter(r38, "callback");
        r1.d = r38;
    L67:
        l r39 = this.b;
        if (r39 == null) goto L70;
        WebView r40 = r39.e;
    L71:
        this.a = r40;
        if (r40 == null) goto L74;
        ((FrameLayout) ((LynxUI) this).mView).addView(r40, new ViewGroup.LayoutParams(-1, -1));
    L74:
        final l r41 = this.b;
        if (r41 == null) goto L83;
        Activity r42 = r41.f();
        if ((r42 instanceof ComponentActivity) == false) goto L79;
        r11 = (ComponentActivity) r42;
    L79:
        if (r11 == null) goto L83;
        ?? r43 = new EmbedWebViewService$registerBackPressedInterception$callback$1(r41, r11);
        r11.getOnBackPressedDispatcher().addCallback(r43);
        r41.m = r43;
        goto L83
    L70:
        r40 = null;
    L83:
        if (this.c == false) goto L85;
    L86:
        String r44 = this.e;
        if (r44 != null) goto L89;
    L94:
        boolean r45 = false;
    L95:
        String r46 = this.f;
        if (r46 != null) goto L98;
    L103:
        r10 = false;
    L104:
        if (r45 == true) goto L106;
    L108:
        if (r10 == false) goto L111;
        if (r45 == true) goto L111;
        ((FrameLayout) ((LynxUI) this).mView).post(new b(this));
    L111:
        if (r45 == true) goto L114;
        if (r10 == true) goto L114;
        EventEmitter r47 = getLynxContext().getEventEmitter();
        m7a.a r48 = new m7a.a(getSign(), IHostStyleUIDepend.TOAST_TYPE_ERROR);
        r48.a("errorCode", -1);
        r48.a("errorMsg", "invalid input: src and html are empty");
        r47.sendCustomEvent(r48);
    L114:
        this.c = false;
        this.d = false;
        return;
    L106:
        if (this.c == false) goto L108;
        ((FrameLayout) ((LynxUI) this).mView).post(new z2.a(this));
        goto L111
    L98:
        if (r46.length() <= 0) goto L100;
        boolean r49 = true;
    L101:
        if (r49 != true) goto L103;
    L100:
        r49 = false;
        goto L101
    L89:
        if (r44.length() <= 0) goto L91;
        boolean r50 = true;
    L92:
        if (r50 != true) goto L94;
        r45 = true;
        goto L95
    L91:
        r50 = false;
        goto L92
    L85:
        if (this.d == true) goto L86;
    }

    public EmbedWebView(LynxContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, null);
    }

    public final View createView(Context r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return new FrameLayout(r10);
    }

    @LynxProp(name = "enable-debug")
    public final void setDebug(boolean r1) {
        WebView.setWebContentsDebuggingEnabled(r1);
    }

    @LynxProp(name = "html")
    public final void setHtmlString(String r1) {
        this.f = r1;
        this.d = true;
    }

    @LynxProp(name = "src")
    public final void setSrc(String r1) {
        this.e = r1;
        this.c = true;
    }

    @LynxUIMethod
    public final void eval(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        String r12 = r10.getString("func");
        if (r12 == null) goto L11;
        l r13 = this.b;
        if (r13 == null) goto L9;
        Intrinsics.checkNotNullParameter(r12, "script");
        WebView r14 = r13.e;
        if (r14 == null) goto L9;
        r14.evaluateJavascript(r12, null);
    L9:
        if (r11 == null) goto L14;
        r11.invoke(new Object[]{0});
        return;
    L14:
        return;
    L11:
        if (r11 == null) goto L16;
        r11.invoke(new Object[]{4, "params error"});
        return;
    }

    @LynxUIMethod
    public final void onGoBack(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        l r12 = this.b;
        if (r12 == null) goto L21;
        WebView r13 = r12.e;
        if (r13 == null) goto L7;
        boolean r14 = r13.canGoBack();
    L8:
        if (r14 == false) goto L12;
        WebView r15 = r12.e;
        if (r15 == null) goto L12;
        r15.goBack();
    L12:
        if (r14 == true) goto L20;
        d r16 = r12.c;
        if (r16 != null) goto L16;
    L18:
        boolean r17 = false;
    L19:
        if (r17 == false) goto L21;
    L16:
        if (r16.c() != true) goto L18;
        r17 = true;
    L20:
        boolean r18 = true;
    L22:
        JavaOnlyMap r19 = new JavaOnlyMap();
        r19.put("consumed", Boolean.valueOf(r18));
        if (r11 == null) goto L26;
        r11.invoke(new Object[]{0, r19});
        return;
    L26:
        return;
    L7:
        r14 = false;
    L21:
        r18 = false;
        goto L22
    }

    @LynxUIMethod
    public final void postMessage(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        String r12 = r10.getString("data");
        if (r12 == null) goto L12;
        l r13 = this.b;
        if (r13 == null) goto L10;
        Intrinsics.checkNotNullParameter(r12, "data");
        w r14 = r13.f;
        if (r14 == null) goto L10;
        JsonObject r15 = new JsonObject();
        r15.addProperty("data", r12);
        r14.a(com.bytedance.android.ec.core.event.a.KEY_MSG, r15);
    L10:
        if (r11 == null) goto L15;
        r11.invoke(new Object[]{0});
        return;
    L15:
        return;
    L12:
        if (r11 == null) goto L17;
        r11.invoke(new Object[]{4, "data is required"});
        return;
    }

    @LynxUIMethod
    public final void reload(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        l r12 = this.b;
        if (r12 == null) goto L7;
        WebView r13 = r12.e;
        if (r13 == null) goto L7;
        r13.reload();
    L7:
        if (r11 == null) goto L10;
        r11.invoke(new Object[]{0});
        return;
    }
}
