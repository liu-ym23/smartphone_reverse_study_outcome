package com.bytedance.ai.applet.render.core.web;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m4.c;
import org.json.JSONObject;
import y2.d;
import y2.e;
import y2.f;
import y2.g;
import y2.h;
import y2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/applet/render/core/web/WebViewAIBridgePort;", "Lcom/bytedance/ai/bridge/protocol/AbsAIBridgePort;", "webViewReference", "Ljava/lang/ref/WeakReference;", "Landroid/webkit/WebView;", "remoteMessageCache", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/bytedance/ai/bridge/utils/CacheHandle;)V", "webMessagePort", "Landroid/webkit/WebMessagePort;", "onRemoteReady", "", "realPostMessage", "messageWrapper", "Lcom/bytedance/ai/bridge/protocol/model/PostMessageWrapper;", "realSetOnMessageCallback", "consumer", "Landroidx/core/util/Consumer;", "Lcom/bytedance/ai/bridge/protocol/model/ReceiveMessageWrapper;", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "tryUseWebMessageChannel", "Companion", "JSInterface", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebViewAIBridgePort extends c {
    private static final String BRIDGE_NAME = "AppletBridgeModule";
    public static final a Companion = null;
    private static final String WEB_MESSAGE_PORT_ACK_MESSAGE = "__channel_ack__";
    private static final String WEB_MESSAGE_PORT_INIT_MESSAGE = "__channel_init__";
    private final s4.c<String> remoteMessageCache;
    private WebMessagePort webMessagePort;
    private final WeakReference<WebView> webViewReference;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/applet/render/core/web/WebViewAIBridgePort$JSInterface;", "", "<init>", "()V", "next", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "", "current", "postMessage", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "getNext", "Companion", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class JSInterface {
        public static final WeakHashMap<WebView, JSInterface> c = null;
        public final AtomicReference<s4.c<String>> a;
        public s4.c<String> b;

        public static final class a {
        }

        static {
            c = new WeakHashMap();
        }

        public JSInterface() {
            this.a = new AtomicReference(null);
        }

        @JavascriptInterface
        public final void postMessage(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            s4.c<String> r0 = this.b;
            if (r0 == null) goto L5;
            r0.b(r10);
        L5:
            com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
            com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[WebViewAIBridgePort] receive message:" + r10 + " from JavascriptInterface");
        }
    }

    public static final class a {
        public a() {
        }

        public static WebViewAIBridgePort a(WebView r10) {
            Intrinsics.checkNotNullParameter(r10, "webView");
            WeakHashMap<WebView, JSInterface> r1 = JSInterface.c;
            Intrinsics.checkNotNullParameter(r10, "webView");
            boolean r0 = p2.c.b();
            if (r0 == true) goto L6;
            com.bytedance.ai.applet.base.log.a.b("ThreadUtils", "checkMainThread not in main thread", null);
        L6:
            if (r0 == true) goto L8;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "RTSInterface initialize must be called on main thread", null);
        L12:
            JSInterface r11 = JSInterface.c.get(r10);
            if (r11 != null) goto L16;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[WebViewAIBridgePort] must call JSInterface::initialize before create WebViewAIBridgePort", null);
            return null;
        L16:
            AtomicReference<s4.c<String>> r12 = r11.a;
            s4.c<String> r13 = new s4.c();
        L18:
            if (r12.compareAndSet(null, r13) == true) goto L19;
            if (r12.get() == null) goto L18;
            boolean r14 = false;
        L23:
            if (r14 == false) goto L25;
            r11.b = r11.a.get();
            s4.c<String> r15 = r11.a.get();
        L26:
            if (r15 != null) goto L28;
            return null;
        L28:
            com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[WebViewAIBridgePort] WebViewAIBridgePort create success");
            return new WebViewAIBridgePort(new WeakReference(r10), r15);
        L25:
            r11.b = r11.a.get();
            r15 = r11.a.getAndSet(null);
            goto L26
        L19:
            r14 = true;
            goto L23
        L8:
            WeakHashMap<WebView, JSInterface> r16 = JSInterface.c;
            if (r16.get(r10) != null) goto L12;
            JSInterface r17 = new JSInterface();
            r10.addJavascriptInterface(r17, "AppletBridgeModule");
            r16.put(r10, r17);
            goto L12
        }
    }

    public static final class b extends WebMessagePort.WebMessageCallback {
        public final /* synthetic */ WebViewAIBridgePort a;
        public final /* synthetic */ WebMessagePort[] b;

        public b(WebViewAIBridgePort r1, WebMessagePort[] r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public final void onMessage(WebMessagePort r10, WebMessage r11) {
            if (r11 == null) goto L18;
            String r12 = r11.getData();
            if (r12 != null) goto L7;
            return;
        L7:
            if (r12.length() != 0) goto L9;
            boolean r13 = true;
        L10:
            if (r13 == false) goto L13;
            return;
        L13:
            if (Intrinsics.areEqual(WebViewAIBridgePort.WEB_MESSAGE_PORT_ACK_MESSAGE, r12) == false) goto L16;
            WebViewAIBridgePort.access$setWebMessagePort$p(this.a, this.b[0]);
            return;
        L16:
            WebViewAIBridgePort.access$getRemoteMessageCache$p(this.a).b(r12);
            com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
            com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[WebViewAIBridgePort] receive message:" + r12 + " from WebMessagePort");
            return;
        L9:
            r13 = false;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void c(n4.c r0, WebViewAIBridgePort r1) {
        realPostMessage$lambda$1(r0, r1);
    }

    public static /* synthetic */ void d(WebViewAIBridgePort r0) {
        tryUseWebMessageChannel$lambda$7(r0);
    }

    public static /* synthetic */ void e(WebViewAIBridgePort r0, String r1) {
        realPostMessage$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void f(WebViewAIBridgePort r0) {
        close$lambda$5(r0);
    }

    public static /* synthetic */ void g(Consumer r0, String r1) {
        realSetOnMessageCallback$lambda$4(r0, r1);
    }

    private final void tryUseWebMessageChannel() {
        p2.c.d(new y2.b(this));
    }

    @Override // m4.c
    public void close() {
        super.close();
        this.remoteMessageCache.a();
        p2.c.c(new d(this));
        final WebView r0 = this.webViewReference.get();
        if (r0 == null) goto L6;
        WeakHashMap<WebView, JSInterface> r1 = JSInterface.c;
        Intrinsics.checkNotNullParameter(r0, "webView");
        p2.c.d(new g(r0));
        return;
    }

    @Override // m4.c
    public void onRemoteReady() {
        super.onRemoteReady();
        tryUseWebMessageChannel();
    }

    public static final /* synthetic */ s4.c access$getRemoteMessageCache$p(WebViewAIBridgePort r0) {
        return r0.remoteMessageCache;
    }

    private static final void close$lambda$5(WebViewAIBridgePort r10) {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        WebMessagePort r11 = r10.webMessagePort;
        if (r11 == null) goto L9;
        r11.close();
        return;
    L9:
        return;
    }

    private static final void tryUseWebMessageChannel$lambda$7(WebViewAIBridgePort r10) {
        com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[WebViewAIBridgePort] try use web message channel");
        WebView r0 = r10.webViewReference.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        return;
    L8:
        int r1 = i.a;
        if (p2.c.b() == true) goto L11;
        com.bytedance.ai.applet.base.log.a.b("ThreadUtils", "checkMainThread not in main thread", null);
    L11:
        WebSettings r11 = r0.getSettings();
        int r12 = -1;
        if (r11 == null) goto L25;
        String r13 = r11.getUserAgentString();
        if (r13 == null) goto L25;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L18
        Object r15 = Result.constructor-impl(Integer.valueOf(CastIntegerProtector.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default(r13.toLowerCase(Locale.getDefault()), "chrome/", null, 2, null), ".", null, 2, null))));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r15) == false) goto L23;
        r15 = -1;
    L23:
        r12 = ((Number) r15).intValue();
    L18:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        if (r12 >= 66) goto L27;
        return;
    L27:
        WebMessagePort[] r17 = r0.createWebMessageChannel();
        r17[0].setWebMessageCallback(new b(r10, r17), (Handler) p2.c.c.getValue());
        r0.postWebMessage(new WebMessage(WEB_MESSAGE_PORT_INIT_MESSAGE, new WebMessagePort[]{r17[1]}), Uri.EMPTY);
    }

    @Override // m4.c
    public void realPostMessage(final n4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "messageWrapper");
        p2.c.c(new y2.c(r10, this));
    }

    @Override // m4.c
    public void realSetOnMessageCallback(final Consumer<n4.d> r10) {
        Intrinsics.checkNotNullParameter(r10, "consumer");
        this.remoteMessageCache.d(new f(r10));
    }

    public WebViewAIBridgePort(WeakReference<WebView> r10, s4.c<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "webViewReference");
        Intrinsics.checkNotNullParameter(r11, "remoteMessageCache");
        this.webViewReference = r10;
        this.remoteMessageCache = r11;
    }

    public static final /* synthetic */ void access$setWebMessagePort$p(WebViewAIBridgePort r0, WebMessagePort r1) {
        r0.webMessagePort = r1;
    }

    private static final void realPostMessage$lambda$1(n4.c r10, final WebViewAIBridgePort r11) {
        final String r12 = r10.a.i();
        WebMessagePort r0 = r11.webMessagePort;
        if (r0 != null) goto L5;
    L8:
        p2.c.d(new e(r11, r12));
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        if (r0 == null) goto L10;
        r0.postMessage(new WebMessage(r12));
        return;
    }

    private static final void realPostMessage$lambda$1$lambda$0(WebViewAIBridgePort r10, String r11) {
        WebView r12 = r10.webViewReference.get();
        if (r12 == null) goto L6;
        String r13 = "onWebViewMessage(" + JSONObject.quote(r11) + ')';
        int r0 = i.a;
        Intrinsics.checkNotNullParameter(r13, "script");
        final Consumer r1 = null;
        r12.evaluateJavascript(r13, new h(r1));
        return;
    }

    private static final void realSetOnMessageCallback$lambda$4(Consumer r10, String r11) {
        long r0 = System.currentTimeMillis();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
        int r13 = ProtocolMessage.a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L8
        ProtocolMessage r14 = ProtocolMessage.b.b(r11);     // Catch: Throwable -> L8
        if (r14 != null) goto L6;
        return;
    L6:
        n4.d r15 = new n4.d(r14);     // Catch: Throwable -> L8
        r15.b = r0;     // Catch: Throwable -> L8
        r10.accept(r15);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
