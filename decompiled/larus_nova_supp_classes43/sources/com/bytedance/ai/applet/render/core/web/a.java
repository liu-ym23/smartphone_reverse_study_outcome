package com.bytedance.ai.applet.render.core.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import d3.w;
import ix7.h;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements w2.a {
    public final Context a;
    public final float b;
    public final com.bytedance.ai.applet.base.log.d c;
    public final w2.c d;
    public final kx7.c e;
    public WebView f;
    public boolean g;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.render.core.web.a$a, reason: collision with other inner class name */
    public static final class C0018a extends w2.a.AbstractC0209a<C0018a, a> {
        public C0018a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            super(r10);
        }
    }

    public static final class b {
    }

    public static final class c implements ix7.e {
        public final /* synthetic */ a a;

        public final void b(SslError r1) {
        }

        public final lx7.b c(lx7.b r10) {
            Intrinsics.checkNotNullParameter(r10, "before");
            return r10;
        }

        public final boolean d(com.ivy.ivykit.plugin.impl.web.b r1) {
            return false;
        }

        public final void e(View r1) {
        }

        public final void f() {
        }

        public final boolean g(WebView r1, ValueCallback r10) {
            return false;
        }

        public final void i(WebView r1, int r10) {
        }

        public final void onReceivedTitle(WebView r1, String r10) {
        }

        public c(a r1) {
            this.a = r1;
        }

        public final void onPageStarted(String r10) {
            a r0 = this.a;
            w2.b r1 = r0.d.e;
            if (r1 == null) goto L8;
            if (r10 != null) goto L6;
            r10 = "";
        L6:
            r1.d(r0, r10);
            return;
        }

        public final boolean j(WebView r10, com.ivy.ivykit.plugin.impl.web.c r11) {
            AtomicInteger r0 = com.bytedance.ai.applet.base.log.d.d;
            this.a.c.a("onRenderProcessGone: " + r11, null);
            return true;
        }

        public final void k(WebResourceRequest r10, WebResourceError r11) {
            if (r11 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            Object r12 = null;
            if (r1 == false) goto L15;
            com.bytedance.ai.applet.base.log.d r0 = this.a.c;
            StringBuilder r13 = new StringBuilder("onReceivedError url=");
            if (r10 == null) goto L13;
            r12 = r10.getUrl();
        L13:
            r13.append(r12);
            r13.append(" error=");
            r13.append(r11.getErrorCode());
            r13.append(' ');
            r13.append(r11.getDescription());
            com.bytedance.ai.applet.base.log.d.d(r0, r13.toString());
            return;
        L15:
            if (r10 == null) goto L19;
            Uri r14 = r10.getUrl();
            if (r14 == null) goto L19;
            String r15 = r14.getLastPathSegment();
        L21:
            if (Intrinsics.areEqual(r15, "favicon.ico") == true) goto L40;
            StringBuilder r16 = new StringBuilder("Request: ");
            if (r10 == null) goto L25;
            Uri r17 = r10.getUrl();
        L26:
            r16.append(r17);
            r16.append(", error: ");
            if (r11 == null) goto L29;
            CharSequence r18 = r11.getDescription();
        L30:
            r16.append(r18);
            r16.append(" code: ");
            if (r11 == null) goto L33;
            r12 = Integer.valueOf(r11.getErrorCode());
        L33:
            r16.append(r12);
            String r19 = r16.toString();
            a r20 = this.a;
            w2.b r21 = r20.d.e;
            if (r21 == null) goto L41;
            if (r11 == null) goto L37;
            int r22 = r11.getErrorCode();
        L38:
            r21.f(r20, false, r22, r19);
            return;
        L37:
            r22 = 403;
            goto L38
        L41:
            return;
        L29:
            r18 = null;
            goto L30
        L25:
            r17 = null;
            goto L26
        L40:
            return;
        L19:
            r15 = null;
            goto L21
        L5:
            if (r11.getErrorCode() != (-1)) goto L7;
            r1 = true;
            goto L8
        }

        public final void onPageFinished(WebView r10, String r11) {
            a r12 = this.a;
            w2.b r0 = r12.d.e;
            if (r0 == null) goto L8;
            if (r11 != null) goto L6;
            r11 = "";
        L6:
            r0.e(r12, r11);
            return;
        }

        public final boolean shouldOverrideUrlLoading(WebView r10, String r11) {
            if (r11 != null) goto L5;
        L8:
            boolean r12 = true;
        L10:
            if (r12 == false) goto L14;
            com.bytedance.ai.applet.base.log.d r13 = this.a.c;
            AtomicInteger r14 = com.bytedance.ai.applet.base.log.d.d;
            r13.a("shouldOverrideUrlLoading url is empty", null);
            return false;
        L14:
            if (StringsKt.startsWith$default(r11, "http", false, 2, null) == false) goto L21;
            return false;
        L21:
            this.a.c.c("shouldOverrideUrlLoading http url:" + r11);     // Catch: Exception -> L17
            Intent r1 = new Intent("android.intent.action.VIEW", UriProtector.parse(r11));     // Catch: Exception -> L17
            r1.setFlags(805306368);     // Catch: Exception -> L17
            this.a.getContext().startActivity(r1);     // Catch: Exception -> L17
        L19:
            return true;
        L17:
            e = move-exception;
            this.a.c.a("shouldOverrideUrlLoading http url:" + r11, e);
            goto L19
        L5:
            if (r11.length() == 0) goto L8;
            r12 = false;
            goto L10
        }

        public final void a(int r10, String r11, String r12) {
            if (r10 != (-1)) goto L6;
            com.bytedance.ai.applet.base.log.d.d(this.a.c, "onReceivedError url=" + r12 + " error=" + r10 + ' ' + r11);
            return;
        L6:
            StringBuilder r0 = new StringBuilder("errorCode: ");
            r0.append(r10);
            r0.append(", description: ");
            r0.append(r11);
            r0.append(", failingUrl: ");
            if (r12 != null) goto L9;
            r12 = "";
        L9:
            r0.append(r12);
            String r13 = r0.toString();
            a r14 = this.a;
            w2.b r1 = r14.d.e;
            if (r1 == null) goto L13;
            r1.f(r14, false, r10, r13);
            return;
        }

        public final void h(String r10, int r11, String r12) {
            if (r10 == null) goto L9;
            a r0 = this.a;
            if (TextUtils.isEmpty(r12) == false) goto L7;
            r12 = "unknown-source";
        L7:
            com.bytedance.ai.applet.base.log.d r1 = r0.c;
            String r13 = "[console]\"" + r10 + "\", source: " + r12 + '(' + r11 + ')';
            r1.getClass();
            Intrinsics.checkNotNullParameter(r13, MessageIndication.MESSAGE_TYPE_MSG);
            com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
            com.bytedance.ai.applet.base.log.a.a(r1.a, r1.b(r13));
            return;
        }
    }

    public static final class d extends ix7.d.a {
        public final /* synthetic */ a a;

        public final void f() {
        }

        public d(a r1) {
            this.a = r1;
        }

        public final void d(View r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            a r0 = this.a;
            if ((r10 instanceof WebView) == false) goto L5;
            WebView r11 = (WebView) r10;
        L6:
            r0.f = r11;
            WebView r12 = r0.f;
            if (r12 == null) goto L13;
            r12.getSettings().setTextZoom((int) (r0.b * 100));
            r12.setOverScrollMode(2);
            r12.getSettings().setJavaScriptEnabled(true);
            r12.getSettings().setDisplayZoomControls(false);
            r12.getSettings().setBuiltInZoomControls(false);
            WebViewAIBridgePort.Companion.getClass();
            WebViewAIBridgePort r1 = WebViewAIBridgePort.a.a(r12);
            r0.getBridge().j(r12);
            if (r1 == null) goto L11;
            r0.getBridge().k(r1);
            return;
        L11:
            com.bytedance.ai.applet.base.log.a.b("WebRenderView", "webViewPort is NULL", null);
            return;
        L13:
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    public static final class e implements ix7.f {
        public final /* synthetic */ a a;

        public final Boolean a(int r1, boolean r10) {
            return null;
        }

        public e(a r1) {
            this.a = r1;
        }

        public final void onTouchEvent(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            int r11 = r10.getAction();
            if (r11 == 0) goto L14;
            if (r11 != 1) goto L6;
            WebView r12 = this.a.f;
            if (r12 == null) goto L20;
            r12.requestDisallowInterceptTouchEvent(false);
            return;
        L20:
            return;
        L6:
            if (r11 != 2) goto L23;
            a r13 = this.a;
            WebView r0 = r13.f;
            if (r0 == null) goto L18;
            r0.requestDisallowInterceptTouchEvent(!r13.g);
            return;
        L18:
            return;
        L23:
            return;
        L14:
            a r14 = this.a;
            r14.g = false;
            WebView r15 = r14.f;
            if (r15 == null) goto L22;
            r15.requestDisallowInterceptTouchEvent(true);
            return;
        }
    }

    public static final class f implements h {
        public final /* synthetic */ a a;

        public final void b(int r1, int r10, int r11, int r12, int r13, int r14, int r15, int r16, boolean r17) {
        }

        public final void onScrollChanged(int r1, int r10, int r11, int r12) {
        }

        public f(a r1) {
            this.a = r1;
        }

        public final void a(int r1, int r10, boolean r11, boolean r12) {
            a r13 = this.a;
            if (r11 == true) goto L7;
            if (r12 == true) goto L7;
            boolean r14 = false;
        L8:
            r13.g = r14;
            return;
        L7:
            r14 = true;
            goto L8
        }
    }

    public static final class g implements ix7.g {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        public final WebResourceResponse a(String r11, WebResourceResponse r12) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            if (r12 != null) goto L5;
        L24:
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            return r12;
        L5:
            if (Intrinsics.areEqual(r12.getMimeType(), "text/html") == false) goto L24;
            this.a.c.c("[afterLoadResource] " + r12.getMimeType() + " inject data for the webview");
            InputStream r13 = r12.getData();
            if (r13 == null) goto L23;
            a r1 = this.a;
            if (r1.d.d.length() != 0) goto L11;
            String r10 = "JSON.stringify('')";
        L12:
            String r14 = StringsKt.trimIndent("\n                            window.__AI_SDK_VERSION__ = '1.15.0-rc.7';\n                            window.__APPLET_VIEW_DATA__ = " + r10 + ";\n                            window.__APPLET_VIEW_CONTEXT__ = " + new JSONObject(r1.d.c) + ";\n                            window.__START_GET_FMP__ = true;\n                        ");
            Intrinsics.checkNotNullParameter(r13, "<this>");
            StringBuilder r15 = new StringBuilder();
            BufferedReader r16 = new BufferedReader(new InputStreamReader(r13));
            String r17 = r16.readLine();     // Catch: Throwable -> L18
        L14:
            if (r17 == null) goto L16;
            r15.append(r17);     // Catch: Throwable -> L18
            r15.append("\n");     // Catch: Throwable -> L18
            r17 = r16.readLine();     // Catch: Throwable -> L18
            goto L14
        L16:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L18
            CloseableKt.closeFinally(r16, null);
            return new WebResourceResponse(r12.getMimeType(), "utf-8", new ByteArrayInputStream(StringsKt.replace$default(r15.toString(), "<!-- INJECT_GLOBAL_VARIABLES_CONTENT -->", "<script>" + r14 + "</script>", false, 4, null).getBytes(Charsets.UTF_8)));
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            CloseableKt.closeFinally(r16, th);
            throw th;
        L11:
            r10 = r1.d.d.toString();
            Intrinsics.checkNotNull(r10);
            goto L12
        L23:
            return null;
        }
    }

    static {
    }

    @Override // w2.a
    public final boolean d() {
        return false;
    }

    @Override // w2.a
    public final void setReused(boolean r1) {
    }

    @Override // w2.a
    public final View asView() {
        BulletContainerView r0 = this.e.f();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // w2.a
    public final void destroy() {
        this.c.c("will destroy");
        new Handler(Looper.getMainLooper()).postDelayed(new y2.a(this), 2000);
    }

    @Override // w2.a
    public final void a() {
        getComposition().f = null;
    }

    @Override // w2.a
    public final void c() {
        getComposition().e = null;
    }

    @Override // w2.a
    public final w getBridge() {
        return getComposition().a;
    }

    @Override // w2.a
    public final w2.c getComposition() {
        return this.d;
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // w2.a
    public final RenderType getRenderType() {
        return RenderType.WEB;
    }

    @Override // w2.a
    public final View realView() {
        return this.f;
    }

    @Override // w2.a
    public final void e(Map<String, ? extends Object> r1) {
        w2.a.b.b(this, r1);
    }

    @Override // w2.a
    public final void setGlobalProperties(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        w2.c r0 = getComposition();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.b = r10;
    }

    @Override // w2.a
    public final void setOnTouchEventListener(w2.a.c r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        getComposition().f = r10;
    }

    @Override // w2.a
    public final void setViewClient(w2.b r10) {
        Intrinsics.checkNotNullParameter(r10, "client");
        getComposition().e = r10;
    }

    @Override // w2.a
    public final void setViewContext(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        w2.c r0 = getComposition();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.c = r10;
    }

    @Override // w2.a
    public final void setViewData(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        w2.c r0 = getComposition();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.d = r10;
    }

    @Override // w2.a
    public final void b(JSONObject r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        com.bytedance.ai.applet.base.log.d r12 = this.c;
        AtomicInteger r13 = com.bytedance.ai.applet.base.log.d.d;
        r12.a("reload is not supported", null);
    }

    public a(Context r11, String r12, float r13) {
        this.a = r11;
        this.b = r13;
        this.c = new com.bytedance.ai.applet.base.log.d(a.class.getSimpleName(), null);
        this.d = new w2.c();
        IIvyWebService.Companion r14 = IIvyWebService.a;
        lx7.a r15 = IIvyWebService.a.a(r14, r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA, new c(this), new d(this), new e(this), new f(this), new g(this), null, 384);
        if (r15 == null) goto L11;
        kx7.c r16 = r14.b(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r15, r11);
        if (r16 == null) goto L9;
        this.e = r16;
        return;
    L9:
        throw new IllegalStateException("Ivy web view service is unavailable");
    L11:
        throw new IllegalStateException("Ivy web client service is unavailable");
    }

    @Override // w2.a
    public final Object f(String r1, JSONObject r10, Continuation<? super Unit> r11) {
        this.e.d(r1);
        return Unit.INSTANCE;
    }
}
