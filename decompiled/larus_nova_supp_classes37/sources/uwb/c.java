package uwb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.p;
import com.ss.android.lark.officewebview.monitor.base.PerformanceTimingHandler;
import com.ss.android.lark.officewebview.util.f;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import dxb.k;
import dxb.n;
import dxb.o;
import dxb.q;
import dxb.r;
import dxb.t;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import oxb.d;
import oxb.i;
import oxb.l;
import oxb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class c extends WebViewClient {
    public final wwb.c a;
    public WebViewClient b;
    public final bxb.a c;
    public final nxb.a d;

    public c(wwb.c r2) {
        this.a = r2;
        this.d = new nxb.a(r2);
        this.c = new bxb.a(r2.getWebView());
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r4, String r5) {
        j.e("LarkBaseWebViewClient", "onLoadResource, load:" + p.c(r5));
        super.onLoadResource(r4, r5);
        int r0 = g.a;
        if (g.a.a("openplatform.lark.webview.load.resource.monitor") == false) goto L5;
        bxb.a r1 = this.c;
        r1.getClass();
        int r2 = t.a;
        boolean r3 = r1.e;
        cxb.a r6 = r1.a;
        Intrinsics.checkNotNullParameter(r6, "dependency");
        Lazy<Handler> r7 = ThreadUtil.a;
        ThreadUtil.a.b(new k(r6, r3, r5));
    L5:
        WebViewClient r8 = this.b;
        if (r8 == null) goto L9;
        r8.onLoadResource(r4, r5);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r3, String r4) {
        j.e("LarkBaseWebViewClient", "onPageCommitVisible");
        super.onPageCommitVisible(r3, r4);
        WebViewClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPageCommitVisible(r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r16, String r17) {
        j.e("LarkBaseWebViewClient", "onPageFinished url " + p.c(r17) + " with session:" + vwb.b.b(r17));
        bxb.a r10 = this.c;
        if (r10.b == false) goto L5;
        int r2 = t.a;
        boolean r3 = r10.e;
        cxb.a r7 = r10.a;
        int r12 = r10.c;
        Intrinsics.checkNotNullParameter(r7, "dependency");
        dxb.g r13 = new dxb.g("wb_load_url_end", dxb.c.d, r7);
        r13.a("is_first_page", Boolean.valueOf(r3));
        r13.a("result_code", 1);
        r13.a(UniContext.KEY_OF_ERROR_CODE, Integer.valueOf(r12));
        r7.getReasonParams();
        r13.a.b();
        t.c(r13, r17);
        r13.b();
        int r5 = 1;
    L6:
        long r4 = System.currentTimeMillis() - r10.a.getStartTime();
        boolean r6 = r10.e;
        if (r6 == false) goto L9;
        cxb.a r8 = r10.a;
        String r14 = String.valueOf(r4);
        Intrinsics.checkNotNullParameter(r8, "dependency");
        Lazy<Handler> r9 = ThreadUtil.a;
        ThreadUtil.a.b(new dxb.j(r8, r6, r5, r14, r17));
    L9:
        PerformanceTimingHandler.reportPerformanceTiming(r16, r10.e, r17, r10.a);
        r10.b = false;
        r10.c = -1;
        r10.e = false;
        int r11 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r16, "view");
        Intrinsics.checkNotNullParameter(r17, "url");
        zwb.a r15 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r15 == null) goto L12;
        r15.onPageFinished();
    L12:
        j.e("LarkBaseWebViewClient", "onPageFinished");
        super.onPageFinished(r16, r17);
        d r18 = (d) this.a.getServiceManager().a(d.class);
        if (r18 == null) goto L15;
        r18.onPageFinished();
    L15:
        WebViewClient r19 = this.b;
        if (r19 == null) goto L19;
        r19.onPageFinished(r16, r17);
        return;
    L19:
        return;
    L5:
        int r20 = t.a;
        boolean r21 = r10.e;
        cxb.a r22 = r10.a;
        Intrinsics.checkNotNullParameter(r22, "dependency");
        dxb.g r110 = new dxb.g("wb_load_url_end", dxb.c.b, r22);
        r110.a("is_first_page", Boolean.valueOf(r21));
        r110.a("result_code", 0);
        r22.getReasonParams();
        r110.a.b();
        t.c(r110, r17);
        r110.b();
        r5 = 0;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r3, ClientCertRequest r4) {
    L8:
        e = move-exception;
        j.c("LarkBaseWebViewClient", "onReceivedClientCertRequest error", e);
        return;
    L4:
        if (this.b == null) goto L6;
        j.e("LarkBaseWebViewClient", "onReceivedClientCertRequest mClient handle");     // Catch: Exception -> L8
        this.b.onReceivedClientCertRequest(r3, r4);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        j.e("LarkBaseWebViewClient", "onReceivedClientCertRequest default handle");     // Catch: Exception -> L8
        super.onReceivedClientCertRequest(r3, r4);     // Catch: Exception -> L8
        goto L11
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r6, RenderProcessGoneDetail r7) {
        bxb.a r0 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "detail");
        int r1 = t.a;
        t.d(r0.a);
        bxb.a.f = true;
        int r2 = g.a;
        boolean r3 = !g.a.a("openplatform.lark.webview.force_on_render_process_gone_return_true");
        l r4 = (l) this.a.getServiceManager().a(l.class);
        if (r4 != null) goto L5;
        WebViewClient r5 = this.b;
        if (r5 == null) goto L20;
        boolean r8 = r5.onRenderProcessGone(r6, r7);
        j.e("LarkBaseWebViewClient", "onRenderProcessGone mClient handle result " + r8);
        if (r3 == false) goto L19;
        j.e("LarkBaseWebViewClient", "onRenderProcessGone force return true, original result: " + r8);
        return true;
    L19:
        return r8;
    L20:
        j.e("LarkBaseWebViewClient", "onRenderProcessGone default return true");
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        new f(r7.didCrash(), r7.rendererPriorityAtExit());
    L7:
        j.e("LarkBaseWebViewClient", "onRenderProcessGone service handle");
        r4.D();
        if (r3 == false) goto L11;
        j.e("LarkBaseWebViewClient", "onRenderProcessGone force return true, original result: false");
        return true;
    L11:
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r3, KeyEvent r4) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onUnhandledKeyEvent mClient handle");
        this.b.onUnhandledKeyEvent(r3, r4);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onUnhandledKeyEvent default handle");
        super.onUnhandledKeyEvent(r3, r4);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r4, WebResourceRequest r5) {
        oxb.k r0 = (oxb.k) this.a.getServiceManager().a(oxb.k.class);
        if (r0 == null) goto L5;
        WebResourceResponse r1 = r0.e();
    L6:
        if (r1 != null) goto L10;
        WebViewClient r2 = this.b;
        if (r2 == null) goto L10;
        r1 = r2.shouldInterceptRequest(r4, r5);
    L10:
        int r3 = g.a;
        if (g.a.a("openplatform.web.webview.net.intercept.infra") == false) goto L16;
        m r6 = (m) this.a.getServiceManager().a(m.class);
        if (r6 == null) goto L16;
        if (r1 != null) goto L16;
        r1 = r6.e();
    L16:
        if (r1 == null) goto L18;
        return r1;
    L18:
        return super.shouldInterceptRequest(r4, r5);
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView r3, KeyEvent r4) {
        boolean r0 = super.shouldOverrideKeyEvent(r3, r4);
        WebViewClient r1 = this.b;
        if (r1 == null) goto L5;
        r0 = r0 | r1.shouldOverrideKeyEvent(r3, r4);
    L5:
        j.e("LarkBaseWebViewClient", "shouldOverrideKeyEvent , override = " + r0);
        return r0;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r6, WebResourceRequest r7) {
        bxb.a r0 = this.c;
        Uri r1 = r7.getUrl();
        r0.getClass();
        int r2 = t.a;
        boolean r3 = r0.e;
        cxb.a r4 = r0.a;
        Intrinsics.checkNotNullParameter(r4, "dependency");
        Lazy<Handler> r5 = ThreadUtil.a;
        ThreadUtil.a.b(new n(r4, r3, r1));
        List<String> r8 = p.a;
        Uri r9 = r7.getUrl();
        if (r9 != null) goto L5;
        String r10 = "";
    L6:
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading url " + r10 + " with session:" + vwb.b.b(r7.getUrl().toString()));
        i r11 = (i) this.a.getServiceManager().a(i.class);
        if (r11 != null) goto L9;
    L12:
        if (r11 == null) goto L14;
        r11.A(r7);
    L14:
        oxb.k r12 = (oxb.k) this.a.getServiceManager().a(oxb.k.class);
        if (r12 == null) goto L17;
        boolean r13 = r12.n();
        j.e("LarkBaseWebViewClient", "IWebViewInterceptService intercept = " + r13);
    L18:
        WebViewClient r14 = this.b;
        if (r14 == null) goto L22;
        r13 = r13 | r14.shouldOverrideUrlLoading(r6, r7);
        j.e("LarkBaseWebViewClient", "after mClient override url intercept = " + r13);
    L22:
        if (r13 == false) goto L25;
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading intercept return true");
        this.c.a(r7.getUrl(), "intercept_url_loading_old_api");
        return true;
    L25:
        int r15 = g.a;
        if (g.a.a("openplatform.lark.webview.override_modify") == false) goto L41;
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading new logic");
        String r16 = r7.getUrl().toString();
        oxb.a r17 = (oxb.a) this.a.getServiceManager().a(oxb.a.class);
        if (r17 == null) goto L33;
        this.a.getWebViewContext();
        if (r17.v() == false) goto L33;
        this.a.getWebViewContext();
        r17.t();
        j.e("LarkBaseWebViewClient", "appLinkService handle override , return true");
        this.c.b(r16, "open_applink");
        return true;
    L33:
        nxb.a r18 = this.d;
        if (r18 == null) goto L36;
        r18.a((com.ss.android.lark.officewebview.base.g) r6, r16);
    L36:
        int r19 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r16, "url");
        zwb.a r20 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r20 == null) goto L39;
        r20.x();
    L39:
        this.c.b(r16, "override_end");
        return false;
    L41:
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading return default");
        return super.shouldOverrideUrlLoading(r6, r7);
    L17:
        r13 = false;
        goto L18
    L9:
        if (r11.shouldOverrideUrlLoading(r6, r7) == false) goto L12;
        this.c.a(r7.getUrl(), "error_page_ui_opt");
        return false;
    L5:
        r10 = p.c(r9.toString());
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r4, String r5) {
        oxb.k r0 = (oxb.k) this.a.getServiceManager().a(oxb.k.class);
        if (r0 == null) goto L5;
        WebResourceResponse r1 = r0.o();
    L6:
        if (r1 != null) goto L10;
        WebViewClient r2 = this.b;
        if (r2 == null) goto L10;
        r1 = r2.shouldInterceptRequest(r4, r5);
    L10:
        if (r1 != null) goto L14;
        i r3 = (i) this.a.getServiceManager().a(i.class);
        if (r3 == null) goto L14;
        r1 = r3.k(r4, r5);
    L14:
        if (r1 == null) goto L16;
        return r1;
    L16:
        return super.shouldInterceptRequest(r4, r5);
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r5, String r6) {
        if (Build.VERSION.SDK_INT >= 24) goto L9;
        bxb.a r0 = this.c;
        r0.getClass();
        if (TextUtils.isEmpty(r6) == true) goto L7;
        Uri r1 = UriProtector.parse(r6);
    L8:
        int r2 = t.a;
        boolean r3 = r0.e;
        cxb.a r4 = r0.a;
        Intrinsics.checkNotNullParameter(r4, "dependency");
        Lazy<Handler> r7 = ThreadUtil.a;
        ThreadUtil.a.b(new n(r4, r3, r1));
        goto L9
    L7:
        r1 = null;
    L9:
        i r8 = (i) this.a.getServiceManager().a(i.class);
        boolean r9 = false;
        if (r8 != null) goto L12;
    L15:
        if (r8 == null) goto L17;
        r8.z(r6);
    L17:
        oxb.k r10 = (oxb.k) this.a.getServiceManager().a(oxb.k.class);
        if (r10 == null) goto L20;
        r9 = r10.i();
        j.e("LarkBaseWebViewClient", "interceptService intercept override result = " + r9);
    L20:
        WebViewClient r11 = this.b;
        if (r11 == null) goto L24;
        r9 = r9 | r11.shouldOverrideUrlLoading(r5, r6);
        j.e("LarkBaseWebViewClient", "after mClient override , intercept = " + r9);
    L24:
        if (r9 == false) goto L27;
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading intercept return true");
        this.c.b(r6, "intercept_url_loading_new_api");
        return true;
    L27:
        oxb.a r12 = (oxb.a) this.a.getServiceManager().a(oxb.a.class);
        if (r12 == null) goto L33;
        this.a.getWebViewContext();
        if (r12.v() == false) goto L33;
        this.a.getWebViewContext();
        r12.t();
        j.e("LarkBaseWebViewClient", "appLinkService handle override , return true");
        this.c.b(r6, "open_applink");
        return true;
    L33:
        nxb.a r13 = this.d;
        if (r13 == null) goto L36;
        r13.a((com.ss.android.lark.officewebview.base.g) r5, r6);
    L36:
        boolean r14 = super.shouldOverrideUrlLoading(r5, r6);
        if (r14 == true) goto L41;
        int r15 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "url");
        zwb.a r16 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r16 == null) goto L41;
        r16.x();
    L41:
        j.e("LarkBaseWebViewClient", "shouldOverrideUrlLoading return default");
        this.c.b(r6, "override_end");
        return r14;
    L12:
        if (r8.shouldOverrideUrlLoading(r5, r6) == false) goto L15;
        this.c.b(r6, "error_page_ui_opt");
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r4, String r5, boolean r6) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebViewClient", "doUpdateVisitedHistory mClient handle , isReload = " + r6);
        this.b.doUpdateVisitedHistory(r4, r5, r6);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "doUpdateVisitedHistory default handle, isReload = " + r6);
        super.doUpdateVisitedHistory(r4, r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView r3, Message r4, Message r5) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onFormResubmission mClient handle");
        this.b.onFormResubmission(r3, r4, r5);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onFormResubmission default handle");
        super.onFormResubmission(r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r6, String r7, Bitmap r8) {
        j.e("LarkBaseWebViewClient", "onPageStarted url " + p.c(r7) + " with session:" + vwb.b.b(r7));
        bxb.a r0 = this.c;
        if (TextUtils.isEmpty(r0.d) == true) goto L5;
        int r2 = t.a;
        cxb.a r3 = r0.a;
        String r4 = r0.d;
        Lazy<Handler> r5 = ThreadUtil.a;
        ThreadUtil.a.b(new q(r3, r4));
    L5:
        int r9 = t.a;
        cxb.a r10 = r0.a;
        Lazy<Handler> r11 = ThreadUtil.a;
        ThreadUtil.a.b(new r(r10, r7));
        boolean r12 = r0.e;
        cxb.a r13 = r0.a;
        Intrinsics.checkNotNullParameter(r13, "dependency");
        ThreadUtil.a.b(new dxb.l(r13, r12, r7));
        r0.d = r7;
        int r1 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "url");
        zwb.a r14 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r14 == null) goto L8;
        r14.onPageStarted();
    L8:
        com.ss.android.lark.officewebview.util.m r15 = this.a.getWebView().getWebTimeHelper();
        long r16 = System.currentTimeMillis();
        r15.getClass();
        if (TextUtils.isEmpty(r7) == false) goto L11;
    L13:
        j.e("LarkBaseWebViewClient", "onPageStarted");
        oxb.g r17 = (oxb.g) this.a.getServiceManager().a(oxb.g.class);
        if (r17 == null) goto L16;
        r17.F(r7, this.a.getWebView());
    L16:
        nxb.a r18 = this.d;
        if (r18 != null) goto L19;
    L23:
        super.onPageStarted(r6, r7, r8);
        d r19 = (d) this.a.getServiceManager().a(d.class);
        if (r19 == null) goto L26;
        r19.onPageStarted();
    L26:
        WebViewClient r20 = this.b;
        if (r20 == null) goto L30;
        r20.onPageStarted(r6, r7, r8);
        return;
    L30:
        return;
    L19:
        if (TextUtils.isEmpty(null) == true) goto L23;
        if (r7.startsWith("https://null") == true) goto L23;
        r18.a.clear();
        r18.b.add(r7);
        goto L23
    L11:
        if (r15.a.containsKey(r7) == true) goto L13;
        r15.a.put(r7, Long.valueOf(r16));
        goto L13
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r11, WebResourceRequest r12, WebResourceError r13) {
        bxb.a r0 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, "error");
        if (r12 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L11;
        int r4 = r13.getErrorCode();
        r0.b = true;
        r0.c = r4;
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L24;
        int r2 = t.a;
        boolean r7 = r0.e;
        if (r12 == null) goto L15;
        Uri r9 = r12.getUrl();
    L16:
        cxb.a r5 = r0.a;
        int r6 = r13.getErrorCode();
        CharSequence r1 = r13.getDescription();
        if (r1 == null) goto L19;
        String r8 = r1.toString();
    L20:
        if (r12 == null) goto L22;
        Boolean r10 = Boolean.valueOf(r12.isForMainFrame());
    L23:
        Lazy<Handler> r14 = ThreadUtil.a;
        ThreadUtil.a.a(new o(r5, r6, r8, r7, r10, r9));
        goto L24
    L22:
        r10 = null;
        goto L23
    L19:
        r8 = null;
        goto L20
    L15:
        r9 = null;
    L24:
        int r15 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "request");
        Intrinsics.checkNotNullParameter(r13, "error");
        zwb.a r16 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r16 == null) goto L27;
        r16.L();
    L27:
        oxb.c r17 = (oxb.c) this.a.getServiceManager().a(oxb.c.class);
        if (r17 == null) goto L30;
        r17.l();
    L30:
        WebViewClient r18 = this.b;
        if (r18 == null) goto L33;
        r18.onReceivedError(r11, r12, r13);
        return;
    L33:
        super.onReceivedError(r11, r12, r13);
        return;
    L5:
        if (r12.isForMainFrame() != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r11, WebResourceRequest r12, WebResourceResponse r13) {
        int r0 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "request");
        Intrinsics.checkNotNullParameter(r13, "errorResponse");
        zwb.a r1 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r1 == null) goto L5;
        r1.U();
    L5:
        bxb.a r2 = this.c;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r13, "errorResponse");
        int r3 = t.a;
        boolean r4 = r2.e;
        Boolean r5 = null;
        if (r12 == null) goto L8;
        Uri r6 = r12.getUrl();
    L9:
        cxb.a r7 = r2.a;
        Integer r8 = Integer.valueOf(r13.getStatusCode());
        String r9 = r13.getReasonPhrase();
        String r10 = r13.getMimeType();
        if (r12 == null) goto L12;
        r5 = Boolean.valueOf(r12.isForMainFrame());
    L12:
        Intrinsics.checkNotNullParameter(r7, "dependency");
        dxb.g r14 = new dxb.g("wb_load_res_failed", dxb.c.c, r7);
        r14.a(UniContext.KEY_OF_ERROR_CODE, r8);
        r14.a(UniContext.KEY_OF_ERROR_MSG, r9);
        r14.a("is_first_page", Boolean.valueOf(r4));
        r14.a("mime_type", r10);
        r14.a("is_main_frame", r5);
        r14.a("error_type", "http");
        t.b(r14, r6);
        r14.b();
        oxb.c r15 = (oxb.c) this.a.getServiceManager().a(oxb.c.class);
        if (r15 == null) goto L15;
        r15.s();
    L15:
        WebViewClient r16 = this.b;
        if (r16 == null) goto L18;
        r16.onReceivedHttpError(r11, r12, r13);
        return;
    L18:
        super.onReceivedHttpError(r11, r12, r13);
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView r9, SslErrorHandler r10, SslError r11) {
        oxb.c r0 = (oxb.c) this.a.getServiceManager().a(oxb.c.class);
        if (r0 == null) goto L6;
        r0.y();
    L6:
        if ((this.b instanceof a) == false) goto L9;
        j.e("LarkBaseWebViewClient", "mClient instanceof AbsLarkWebViewClient");
        ((a) this.b).a();
        return;
    L9:
        bxb.a r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "error");
        int r2 = r11.getPrimaryError();
        r1.b = true;
        r1.c = r2;
        int r3 = t.a;
        boolean r4 = r1.e;
        String r5 = r11.getUrl();
        cxb.a r6 = r1.a;
        int r7 = r11.getPrimaryError();
        Boolean r8 = Boolean.TRUE;
        dxb.g r12 = new dxb.g("wb_load_received_error", dxb.c.e, r6);
        r12.a(UniContext.KEY_OF_ERROR_CODE, Integer.valueOf(r7));
        r12.a(UniContext.KEY_OF_ERROR_MSG, null);
        r12.a("error_type", "ssl");
        r12.a("is_first_page", Boolean.valueOf(r4));
        r12.a("is_main_frame", r8);
        t.c(r12, r5);
        r12.b();
        WebViewClient r13 = this.b;
        if (r13 == null) goto L13;
        r13.onReceivedSslError(r9, r10, r11);
        return;
    L13:
        super.onReceivedSslError(r9, r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView r3, float r4, float r5) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onScaleChanged mClient handle");
        this.b.onScaleChanged(r3, r4, r5);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onScaleChanged default handle");
        super.onScaleChanged(r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r3, Message r4, Message r5) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onTooManyRedirects mClient handle");
        this.b.onTooManyRedirects(r3, r4, r5);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onTooManyRedirects default handle");
        super.onTooManyRedirects(r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r3, int r4, String r5, String r6) {
        int r0 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r5, "description");
        Intrinsics.checkNotNullParameter(r6, "failingUrl");
        zwb.a r1 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r1 == null) goto L5;
        r1.G();
    L5:
        oxb.c r2 = (oxb.c) this.a.getServiceManager().a(oxb.c.class);
        if (r2 == null) goto L8;
        r2.onReceivedError();
    L8:
        WebViewClient r7 = this.b;
        if (r7 == null) goto L11;
        r7.onReceivedError(r3, r4, r5, r6);
        return;
    L11:
        super.onReceivedError(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r3, HttpAuthHandler r4, String r5, String r6) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onReceivedHttpAuthRequest mClient handle");
        this.b.onReceivedHttpAuthRequest(r3, r4, r5, r6);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onReceivedHttpAuthRequest default handle");
        super.onReceivedHttpAuthRequest(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r3, String r4, String r5, String r6) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebViewClient", "onReceivedLoginRequest mClient handle");
        this.b.onReceivedLoginRequest(r3, r4, r5, r6);
        return;
    L5:
        j.e("LarkBaseWebViewClient", "onReceivedLoginRequest default handle");
        super.onReceivedLoginRequest(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r3, WebResourceRequest r4, int r5, SafeBrowsingResponse r6) {
        j.e("LarkBaseWebViewClient", "onSafeBrowsingHit");
        super.onSafeBrowsingHit(r3, r4, r5, r6);
        if (this.b == null) goto L6;
        j.e("LarkBaseWebViewClient", "onSafeBrowsingHit mClient handle");
        this.b.onSafeBrowsingHit(r3, r4, r5, r6);
        return;
    }
}
