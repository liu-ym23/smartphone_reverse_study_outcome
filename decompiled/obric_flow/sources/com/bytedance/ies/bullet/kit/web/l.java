package com.bytedance.ies.bullet.kit.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.anniex.container.ui.AnnieXSourceLabel;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.forest.o;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.google.common.reflect.w;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends hc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f5561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f5562c;
    public final /* synthetic */ String d;

    public l(m r5, w r10, String r11) {
        this.f5561b = r5;
        this.f5562c = r10;
        this.d = r11;
    }

    @Override // bd.e
    public final boolean b(WebView r5, bd.d r10) {
        if (r10 == null) goto L11;
        Uri r11 = ((WebResourceRequest) r10.f905a).getUrl();
        if (r11 == null) goto L11;
        String r12 = r11.toString();
        if (r12 == null) goto L11;
        com.bytedance.ies.bullet.web.scc.b r13 = this.f5561b.f5570l;
        if (r13 == null) goto L11;
        Intrinsics.checkNotNullParameter(r12, "url");
        String r14 = StringsKt.W(r12, '#');
        ((ug.d) r13.f6255a.f17502b).a(r14);
    L11:
        throw new YieldError();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView r5, String r10) {
        super.onPageCommitVisible(r5, r10);
        SSWebView r11 = this.f5561b.e;
        if (r11 == null) goto L6;
        r11.setPageCommitVisibleUrl(r10);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView r10, String r11) {
        m r5 = this.f5561b;
        if (xq.b.d(r5.d.d()) == false) goto L8;
        com.bytedance.android.anniex.base.monitor.b r12 = com.bytedance.android.anniex.base.monitor.b.f3120b;
        String r13 = r5.f;
        r12.getClass();
        if (r13 == null) goto L8;
        h.f.b(new com.bytedance.android.anniex.base.monitor.a(r12, r13, 1), h.f.g);
    L8:
        rb.b r14 = r5.f5572n;
        rb.b r15 = null;
        if (r14 != null) goto L12;
        r14 = null;
    L12:
        if (r14 != null) goto L14;
    L18:
        r5.d.d().f5293c.F();
        super.onPageFinished(r10, r11);
        if (r10 == null) goto L23;
        String r16 = r5.f;
        Intrinsics.checkNotNullParameter(r10, "webView");
        if (r16 == null) goto L23;
        r10.loadUrl("javascript:(function () {    window.reactId = '" + r16 + "';})();");
    L23:
        if (r11 == null) goto L39;
        if (r11.length() == 0) goto L39;
        if (Intrinsics.areEqual("about:blank", r11) == true) goto L39;
        rb.b r17 = r5.f5572n;
        if (r17 == null) goto L32;
        r15 = r17;
    L32:
        if (r15 == null) goto L39;
        if (r15.a(com.bytedance.ies.bullet.ui.common.g.class) == null) goto L39;
        throw new ClassCastException();
    L39:
        if (this.f5560a == false) goto L41;
    L43:
        this.f5560a = false;
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, r5.f, "onPageFinished " + r11, "XWebKit");
        return;
    L41:
        if (r5.f5568j == true) goto L43;
        Intrinsics.checkNotNullParameter(this.d, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r5, "kitView");
        w r19 = this.f5562c;
        com.bytedance.ies.bullet.ui.common.loader.b r20 = (com.bytedance.ies.bullet.ui.common.loader.b) r19.f9377c;
        Uri r21 = (Uri) r19.f9376b;
        Intrinsics.checkNotNullParameter(r21, LynxResourceModule.URI_KEY);
        n r22 = r20.f5349a;
        m r23 = (m) r19.d;
        r22.w(r21, r23);
        r23.d.getClass();
        Intrinsics.checkNotNullParameter(r21, LynxResourceModule.URI_KEY);
        r20.f5349a.p(r21, r5);
        r5.f5568j = true;
        goto L43
    L14:
        if (r14.a(AnnieXSourceLabel.class) == null) goto L18;
        throw new ClassCastException();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView r5, String r10, Bitmap r11) {
        this.f5561b.d.d().f5293c.G();
        this.f5561b.d.getClass();
        super.onPageStarted(r5, r10, r11);
        SSWebView r12 = this.f5561b.e;
        if (r12 == null) goto L5;
        r12.setPageStartUrl(r10);
    L5:
        m r13 = this.f5561b;
        r13.getClass();
        Intrinsics.areEqual(r10, "about:blank");
        rb.b r14 = r13.f5572n;
        if (r14 != null) goto L9;
        r14 = null;
    L9:
        if (r14 != null) goto L11;
    L15:
        if (r10 == null) goto L52;
        m r15 = this.f5561b;
        w r16 = this.f5562c;
        com.bytedance.ies.bullet.web.scc.b r17 = r15.f5570l;
        if (r17 == null) goto L46;
        Intrinsics.checkNotNullParameter(r10, "url");
        String r18 = StringsKt.W(r10, '#');
        i4.a r19 = r17.f6255a;
        r19.getClass();
        boolean r20 = false;
        if (TextUtils.isEmpty(r18) == false) goto L21;
        boolean r21 = false;
    L25:
        if (r21 == false) goto L27;
        SccConfig.SccLevel r22 = SccConfig.SccLevel.f5895b;
    L37:
        r15.f5571m = r22;
        if (r22 == SccConfig.SccLevel.f5894a) goto L46;
        r16.g(r10, r15, new WebLoadError(403, "scc check failed", r10));
        goto L46
    L27:
        i4.a r23 = r17.f6255a;
        r23.getClass();
        if (TextUtils.isEmpty(r18) == true) goto L34;
        ArrayList r24 = (ArrayList) r23.d;
        monitor-enter(r24);
        r20 = ((ArrayList) r23.d).remove(r18);     // Catch: Throwable -> L40
        monitor-exit(r24);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L34:
        if (r20 == false) goto L36;
        r22 = SccConfig.SccLevel.f5896c;
        goto L37
    L36:
        r22 = SccConfig.SccLevel.f5894a;
        goto L37
    L21:
        ArrayList r25 = (ArrayList) r19.f17503c;
        monitor-enter(r25);
        r21 = ((ArrayList) r19.f17503c).remove(r18);     // Catch: Throwable -> L43
        monitor-exit(r25);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L46:
        Intrinsics.checkNotNullParameter(r15.f, "sessionId");
        return;
    L52:
        return;
    L11:
        if (r14.a(com.bytedance.android.anniex.base.service.f.class) == null) goto L15;
        throw new ClassCastException();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, int r10, String r11, String r12) {
        m r13 = this.f5561b;
        r13.getClass();
        this.f5560a = true;
        super.onReceivedError(r5, r10, r11, r12);
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.e(r13.f, "onReceivedError errorCode:" + r10 + ", description: " + r11, "XWebKit", LogLevel.d);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r5, HttpAuthHandler r10, String r11, String r12) {
        super.onReceivedHttpAuthRequest(r5, r10, r11, r12);
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, com.lynx.tasm.utils.b.j("onReceivedHttpAuthRequest: host=", r11, ", realm=", r12), "XWebKit");
    }

    @Override // bd.e, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        if (r11 == null) goto L4;
        Intrinsics.checkNotNullParameter(r11, "<this>");
    L4:
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "onReceivedHttpError: request=" + r11 + ", errorResponse=" + r12, "XWebKit");
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.isForMainFrame() != true) goto L44;
        String r13 = null;
        if (r12 == null) goto L11;
        Integer r14 = Integer.valueOf(r12.getStatusCode());
    L12:
        if (r14 == null) goto L20;
        int r15 = r14.intValue();
        ConcurrentHashMap r16 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r17 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r17 == null) goto L20;
        xc.d r18 = (xc.d) r17.a(xc.d.class);
        if (r18 == null) goto L20;
        List r19 = r18.r();
        if (r19 == null) goto L20;
        boolean r20 = r19.contains(Integer.valueOf(r15));
    L21:
        if (r20 == true) goto L45;
        this.f5560a = true;
        if (r10 == null) goto L46;
        String r21 = r10.getUrl();
        if (r21 == null) goto L47;
        Uri r22 = r11.getUrl();
        if (r22 == null) goto L29;
        String r23 = r22.toString();
    L31:
        if (Intrinsics.areEqual(r21, r23) == true) goto L34;
        r21 = null;
    L34:
        if (r21 != null) goto L36;
        return;
    L36:
        if (r12 == null) goto L38;
        int r24 = r12.getStatusCode();
    L39:
        if (r12 == null) goto L41;
        r13 = r12.getReasonPhrase();
    L41:
        this.f5562c.g(this.d, this.f5561b, new WebLoadError(r24, r13, r21));
        return;
    L38:
        r24 = 404;
        goto L39
    L29:
        r23 = null;
        goto L31
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L20:
        r20 = false;
        goto L21
    L11:
        r14 = null;
        goto L12
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r5, SslErrorHandler r10, SslError r11) {
        boolean r12 = true;
        this.f5560a = true;
        super.onReceivedSslError(r5, r10, r11);
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "onReceivedSslError: error=" + r11, "XWebKit");
        String r14 = null;
        if (r11 == null) goto L5;
        String r15 = r11.getUrl();
    L6:
        if (r15 != null) goto L8;
        r15 = "";
    L8:
        Uri r16 = Uri.parse(r15);
        if (r16 == null) goto L13;
        String r17 = r16.getPath();
        if (r17 == null) goto L13;
        r12 = StringsKt.g(r17, ".html");
    L13:
        if (r12 == false) goto L22;
        if (r5 == null) goto L23;
        String r18 = r5.getUrl();
        if (r18 != null) goto L18;
        return;
    L18:
        if (r11 == null) goto L20;
        r14 = r11.toString();
    L20:
        this.f5562c.g(this.d, this.f5561b, new WebLoadError(-100, r14, r18));
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r15 = null;
        goto L6
    }

    @Override // bd.e, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r5, RenderProcessGoneDetail r10) {
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "onRenderProcessGone: detail=" + r10, "XWebKit");
        return super.onRenderProcessGone(r5, r10);
    }

    @Override // bd.e, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r5, String r10) {
        m r11 = this.f5561b;
        if (r10 != null) goto L5;
    L12:
        r11.getClass();
        throw new YieldError();
    L5:
        if (r10.length() == 0) goto L12;
        r11.getClass();
        WebResourceResponse r12 = r11.d.b(r10);
        if (r12 == null) goto L9;
        return r12;
    L9:
        com.bytedance.ies.bullet.web.scc.b r13 = r11.f5570l;
        if (r13 == null) goto L12;
        r13.a(r10);
        goto L12
    }

    @Override // bd.e, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, String r10) {
        if (r10 == null) goto L7;
        com.bytedance.ies.bullet.web.scc.b r11 = this.f5561b.f5570l;
        if (r11 == null) goto L7;
        Intrinsics.checkNotNullParameter(r10, "url");
        String r12 = StringsKt.W(r10, '#');
        ((ug.d) r11.f6255a.f17502b).a(r12);
    L7:
        throw new YieldError();
    }

    @Override // bd.e, android.webkit.WebViewClient
    public final void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        m r5 = this.f5561b;
        if (r11 != null) goto L5;
    L7:
        super.onReceivedError(r10, r11, r12);
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r14 = r5.f;
        StringBuilder r15 = new StringBuilder("onReceivedError error:");
        String r16 = null;
        if (r12 == null) goto L10;
        CharSequence r17 = r12.getDescription();
    L11:
        r15.append(r17);
        r15.append(", isForMainFrame: ");
        if (r11 == null) goto L14;
        Boolean r18 = Boolean.valueOf(r11.isForMainFrame());
    L15:
        r15.append(r18);
        com.bytedance.ies.bullet.service.base.b.e(r14, r15.toString(), "XWebKit", LogLevel.d);
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.isForMainFrame() == true) goto L20;
        return;
    L20:
        if (r12 == null) goto L22;
        int r19 = r12.getErrorCode();
    L23:
        if (r12 == null) goto L25;
        CharSequence r20 = r12.getDescription();
    L26:
        Uri r21 = r11.getUrl();
        if (r21 == null) goto L29;
        r16 = r21.toString();
    L29:
        this.f5562c.g(this.d, r5, new WebLoadError(r19, r20, r16));
        return;
    L25:
        r20 = null;
        goto L26
    L22:
        r19 = 0;
        goto L23
    L14:
        r18 = null;
        goto L15
    L10:
        r17 = null;
        goto L11
    L5:
        if (r11.isForMainFrame() != true) goto L7;
        r5.getClass();
        this.f5560a = true;
        goto L7
    }

    @Override // bd.e, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r10, WebResourceRequest r11) {
        m r5 = this.f5561b;
        com.bytedance.ies.bullet.core.e r12 = r5.d.d();
        if (u8.a.q(r12) == false) goto L7;
        r5.getClass();
        if (((Boolean) o.a(r5, r11, r12).getFirst()).booleanValue() == false) goto L7;
        boolean r13 = true;
    L8:
        if (r11 == null) goto L13;
        Uri r14 = r11.getUrl();
        if (r14 == null) goto L13;
        r14.toString();
    L13:
        if (r13 == false) goto L22;
        if (r11 == null) goto L22;
        com.bytedance.ies.bullet.kit.web.impl.i r15 = r5.d;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r11, "request");
        com.bytedance.ies.bullet.web.pia.j r16 = r15.g;
        if (r16 == null) goto L18;
        WebResourceResponse r17 = r16.a(r11);
    L19:
        if (r17 == null) goto L22;
        com.bytedance.ies.bullet.core.l r18 = r12.f5309x;
        r18.getClass();
        Intrinsics.checkNotNullParameter("pia", "<set-?>");
        r18.f5347b = "pia";
        return r17;
    L18:
        r17 = null;
    L22:
        if (r13 == false) goto L27;
        if (r11 == null) goto L27;
        WebResourceResponse r19 = r5.d.a(r11);
        if (r19 == null) goto L27;
        return r19;
    L27:
        if (r11 == null) goto L39;
        if (r13 == true) goto L36;
        com.bytedance.ies.bullet.kit.web.impl.i r20 = r5.d;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r11, "request");
        com.bytedance.ies.bullet.web.pia.j r21 = r20.g;
        if (r21 == null) goto L32;
        WebResourceResponse r22 = r21.a(r11);
    L33:
        if (r22 == null) goto L36;
        com.bytedance.ies.bullet.core.l r23 = r12.f5309x;
        r23.getClass();
        Intrinsics.checkNotNullParameter("pia", "<set-?>");
        r23.f5347b = "pia";
        return r22;
    L32:
        r22 = null;
    L36:
        com.bytedance.ies.bullet.web.scc.b r24 = r5.f5570l;
        if (r24 == null) goto L39;
        r24.a(r11.getUrl().toString());
    L39:
        super.shouldInterceptRequest(r10, r11);
        throw null;
    L7:
        r13 = false;
        goto L8
    }
}
