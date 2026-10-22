package com.ss.android.lark.officewebview.base;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.DependencyContextUniqueId;
import com.ss.android.lark.officesdk.utils.RomUtils;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.k;
import com.ss.android.lark.officesdk.utils.di.v;
import com.ss.android.lark.officewebview.util.i;
import com.ss.android.lark.officewebview.util.l;
import com.ss.android.lark.officewebview.util.m;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dxb.t;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;
import ntb.z;
import oxb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class g extends WebView implements wwb.c, cxb.a {
    public volatile n a;
    public ywb.c b;
    public uwb.c c;
    public uwb.b d;
    public boolean e;
    public final l f;
    public m g;

    public abstract /* synthetic */ String getBaseTraceId();

    public abstract /* synthetic */ String getBizType();

    public abstract /* synthetic */ Map<String, Object> getCommonParams();

    public abstract /* synthetic */ Map<String, Object> getReasonParams();

    public abstract /* synthetic */ n getServiceManager();

    public abstract /* synthetic */ long getStartTime();

    public abstract /* synthetic */ OfficeWebView getWebView();

    public abstract void k();

    @Override // android.webkit.WebView
    public final boolean canGoBack() {
        oxb.b r0 = (oxb.b) this.a.a(oxb.b.class);
        if (r0 == null) goto L11;
        copyBackForwardList();
        boolean r1 = r0.canGoBack();
        boolean r2 = super.canGoBack();
        j.e("BaseOfficeWebView", "canGoBack proxy handle , canGoBack = " + r1 + " , super canGoBack = " + r2);
        if (r1 == false) goto L8;
        if (r2 == false) goto L8;
        return true;
    L8:
        return false;
    L11:
        return super.canGoBack();
    }

    @Override // android.webkit.WebView
    public final boolean canGoForward() {
        oxb.b r0 = (oxb.b) this.a.a(oxb.b.class);
        if (r0 == null) goto L11;
        copyBackForwardList();
        boolean r1 = r0.j();
        boolean r2 = super.canGoForward();
        j.e("BaseOfficeWebView", "canGoForward proxy handle, canGoForward = " + r1 + ", base canGoForward " + r2);
        if (r1 == false) goto L8;
        if (r2 == false) goto L8;
        return true;
    L8:
        return false;
    L11:
        return super.canGoForward();
    }

    public String getTTWebViewVersion() {
        Lazy<otb.n> r0 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(this);
        return "";
    }

    @Override // android.webkit.WebView
    public WebViewClient getWebViewClient() {
        uwb.c r0 = this.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b;
    }

    @Override // wwb.c
    public Context getWebViewContext() {
        return getContext();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeTimers();
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
        l r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a != null) goto L8;
        return;
    L8:
        if (getParent() != null) goto L11;
        return;
    L11:
        if ((getParent() instanceof FrameLayout) == false) goto L14;
        r0.a(false, (FrameLayout) getParent());
        return;
    L14:
        if ((getParent().getParent() instanceof ConstraintLayout) == false) goto L17;
        r0.b(false, (ConstraintLayout) getParent().getParent());
        return;
    L17:
        if ((getParent().getParent() instanceof FrameLayout) == false) goto L23;
        r0.a(false, (FrameLayout) getParent().getParent());
        return;
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
        l r0 = this.f;
        if (r0 == null) goto L6;
        r0.c(this);
        return;
    }

    public m getWebTimeHelper() {
        return this.g;
    }

    public ywb.c getWebViewConfig() {
        return this.b;
    }

    public g(Context r2) {
        this(new com.ss.android.lark.officewebview.util.d(r2), null);
    }

    @Override // android.webkit.WebView
    public final boolean canGoBackOrForward(int r4) {
        oxb.b r0 = (oxb.b) this.a.a(oxb.b.class);
        if (r0 == null) goto L11;
        copyBackForwardList();
        boolean r1 = r0.q();
        boolean r5 = super.canGoBackOrForward(r4);
        j.e("BaseOfficeWebView", "canGoBackOrForward proxy handle, canGoBackOrForward = " + r1 + " , superCanGoBackOrForward " + r5);
        if (r1 == false) goto L8;
        if (r5 == false) goto L8;
        return true;
    L8:
        return false;
    L11:
        return super.canGoBackOrForward(r4);
    }

    @Override // android.view.View
    public final void draw(Canvas r3) {
        int r0 = com.ss.android.lark.officesdk.utils.di.g.a;
        if (com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.web.disable.huawei.subThread.draw") == false) goto L7;
        super.draw(r3);
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
        super.draw(r3);
        return;
    L10:
        if (RomUtils.a[0].equals(RomUtils.c().a) == false) goto L12;
        j.b("BaseOfficeWebView", "huawei is drawing webView in subThread !!");
        return;
    L12:
        super.draw(r3);
    }

    public final void l(boolean r2) {
        Lazy<otb.n> r3 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(this);
        j.b("BaseOfficeWebView", "is system core not support darkMode");
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r5) {
        j.e("BaseOfficeWebView", "loadUrl");
        this.g.a(r5, System.currentTimeMillis());
        if (i.a() == true) goto L11;
        i.a.a.b(new b(this, r5));
        return;
    L11:
        super.loadUrl(r5, new HashMap());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    public void setOpenFromMultiWindow(boolean r1) {
        this.e = r1;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r4) {
        if (this.d == null) goto L5;
        j.e("BaseOfficeWebView", "setWebChromeClient success");
        uwb.b r0 = this.d;
        r0.getClass();
        j.e("LarkBaseWebChromeClient", "Caller setWebChromeClient");
        r0.b = r4;
        return;
    L5:
        int r5 = t.a;
        dxb.c.a r6 = dxb.c.a;
        int r7 = com.ss.android.lark.officesdk.utils.di.l.a;
        o r8 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r8 == null) goto L9;
        o.a r9 = r8.d();
        if (r9 == null) goto L9;
    L22:
        Map<String, Object> r1 = getCommonParams();     // Catch: Throwable -> L20
        if (r1 == null) goto L15;
        boolean r2 = true;
        if ((!r1.isEmpty()) != true) goto L15;
    L16:
        if (r2 == false) goto L18;
        r9.b();     // Catch: Throwable -> L20
    L18:
        r9.flush();     // Catch: Throwable -> L20
        return;
    L15:
        r2 = false;
    L20:
        th = move-exception;
        throw th;
    L9:
        r9 = new k();
        goto L22
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r9) {
        boolean r1 = false;
        if (this.c == null) goto L35;
        j.e("BaseOfficeWebView", "mWebViewClient setWebViewClient");
        Context r0 = getWebViewContext();
        int r3 = com.ss.android.lark.officesdk.utils.di.e.a;
        if (com.ss.android.lark.officesdk.utils.di.e.a.a(r0) == false) goto L30;
        if (r9 == null) goto L30;
        if ((r9 instanceof wwb.b) == true) goto L30;
        StackTraceElement[] r2 = ThreadMethodProxy.currentThread().getStackTrace();
        int r4 = r2.length;
        StringBuilder r5 = new StringBuilder();
        int r6 = 2;
        if (r4 <= 2) goto L13;
    L11:
        if (r6 >= r4) goto L13;
        StackTraceElement r7 = r2[r6];
        r5.append(r7.getClassName());
        r5.append("#");
        r5.append(r7.getMethodName());
        r5.append(";");
        r6 = r6 + 1;
    L13:
        int r8 = t.a;
        Intrinsics.checkNotNullParameter(r5.toString(), "stackTrace");
        dxb.c.a r10 = dxb.c.a;
        int r11 = com.ss.android.lark.officesdk.utils.di.l.a;
        o r12 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r12 == null) goto L17;
        o.a r13 = r12.d();
        if (r13 == null) goto L17;
    L18:
        Intrinsics.checkNotNullParameter("err_msg", "key");
        r13.a("err_msg");
        Map<String, Object> r14 = getCommonParams();     // Catch: Throwable -> L28
        if (r14 != null) goto L22;
    L24:
        if (r1 == false) goto L26;
        r13.b();     // Catch: Throwable -> L28
    L26:
        r13.flush();     // Catch: Throwable -> L28
        goto L30
    L22:
        if ((!r14.isEmpty()) != true) goto L24;
        r1 = true;
    L28:
        th = move-exception;
        throw th;
    L17:
        r13 = new k();
    L30:
        uwb.c r15 = this.c;
        r15.getClass();
        StringBuilder r16 = new StringBuilder("Caller setWebViewClient: client=");
        if (r9 != null) goto L33;
        Object r17 = "null";
    L34:
        r16.append(r17);
        j.e("LarkBaseWebViewClient", r16.toString());
        r15.b = r9;
        return;
    L33:
        r17 = Integer.valueOf(r9.hashCode());
        goto L34
    L35:
        int r18 = t.a;
        dxb.c.a r19 = dxb.c.a;
        int r20 = com.ss.android.lark.officesdk.utils.di.l.a;
        o r21 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r21 == null) goto L39;
        o.a r22 = r21.d();
        if (r22 == null) goto L39;
    L53:
        Map<String, Object> r23 = getCommonParams();     // Catch: Throwable -> L49
        if (r23 != null) goto L43;
    L45:
        if (r1 == false) goto L47;
        r22.b();     // Catch: Throwable -> L49
    L47:
        r22.flush();     // Catch: Throwable -> L49
        return;
    L43:
        if ((!r23.isEmpty()) != true) goto L45;
        r1 = true;
    L49:
        th = move-exception;
        throw th;
    L39:
        r22 = new k();
        goto L53
    }

    public void setWebViewConfig(ywb.c r10) {
        if (r10 == null) goto L58;
        Context r1 = getContext();
        ywb.b.a r2 = new ywb.b.a();
        ywb.e.a r3 = new ywb.e.a();
        ywb.d.a r4 = new ywb.d.a();
        int r5 = com.ss.android.lark.officesdk.utils.di.e.a;
        r2.a.a = com.ss.android.lark.officesdk.utils.di.e.a.a(r1);
        boolean r6 = true;
        r4.a.a = true;
        ywb.c r7 = new ywb.c();
        ywb.b r8 = r10.a;
        if (r8 != null) goto L8;
        r8 = r2.a;
    L8:
        r7.a = r8;
        ywb.e r9 = r10.b;
        if (r9 != null) goto L12;
        r9 = r3.a;
    L12:
        r7.b = r9;
        ywb.d r11 = r10.c;
        if (r11 != null) goto L16;
        r11 = r4.a;
    L16:
        r7.c = r11;
        this.b = r7;
        ywb.b r12 = r10.a;
        if (r12 != null) goto L19;
        j.f("BaseOfficeWebView", "setWebViewConfig failed, debuggableConfig is null.");
    L24:
        if (r10.b == null) goto L51;
        WebSettings r13 = getSettings();
        r13.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        r13.setLoadWithOverviewMode(true);
        r13.setUseWideViewPort(true);
        r13.setDomStorageEnabled(true);
        r13.setDatabaseEnabled(true);
        r13.setDisplayZoomControls(false);
        r13.setBuiltInZoomControls(true);
        r13.setAllowFileAccess(false);
        r13.setJavaScriptCanOpenWindowsAutomatically(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        r13.setSupportZoom(true);
        r13.setJavaScriptEnabled(true);
        r13.setSupportMultipleWindows(false);
        if (TextUtils.isEmpty(null) == false) goto L34;
        String r14 = r13.getUserAgentString();
        Context r15 = getContext();
        Locale r16 = Locale.getDefault();
        int r17 = v.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r14, "userAgent");
        Intrinsics.checkNotNullParameter(r16, "locale");
        DependencyContainer r18 = DependencyContainer.a;
        z r19 = (z) DependencyContainer.a(z.class, null);
        if (r19 == null) goto L33;
        String r20 = r19.Y();
        if (r20 == null) goto L33;
        r14 = r20;
    L33:
        r13.setUserAgentString(r14);
    L35:
        int r21 = com.ss.android.lark.officesdk.utils.di.b.a;
        DependencyContainer r22 = DependencyContainer.a;
        ntb.c r23 = (ntb.c) DependencyContainer.a(ntb.c.class, null);
        if (r23 == null) goto L38;
        boolean r24 = r23.isInit();
    L40:
        if (r24 == true) goto L42;
        j.f("WebSettingConfig", "AuditManager has not init");
    L50:
        r13.setGeolocationEnabled(r6);
    L52:
        ywb.d r110 = r10.c;
        if (r110 != null) goto L55;
        j.f("BaseOfficeWebView", "setPerformanceConfig failed, performanceConfig is null.");
        return;
    L55:
        if (r110.a == false) goto L60;
        j.e("BaseOfficeWebView", "performanceConfig is enable");
        Lazy<otb.n> r111 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(this);
        return;
    L60:
        return;
    L42:
        Intrinsics.checkNotNullParameter("PRIVACY_GPS_LOCATION", "permissionType");
        ntb.c r25 = (ntb.c) DependencyContainer.a(ntb.c.class, null);
        if (r25 == null) goto L45;
        int r26 = r25.j();
    L46:
        j.e("WebSettingConfig", "checkAuthority result=" + r26);
        if (r26 != 2) goto L50;
        r6 = false;
        goto L50
    L45:
        r26 = 0;
        goto L46
    L38:
        r24 = false;
        goto L40
    L34:
        r13.setUserAgentString(null);
        goto L35
    L51:
        j.f("BaseOfficeWebView", "setWebViewConfig failed, webSettingConfig is null.");
        goto L52
    L19:
        if (r12.a == true) goto L21;
        WebView.setWebContentsDebuggingEnabled(false);
        goto L24
    L21:
        j.f("BaseOfficeWebView", "open inspect");
        goto L24
    L58:
        j.f("BaseOfficeWebView", "setWebViewConfig failed, config is null.");
    }

    public g(com.ss.android.lark.officewebview.util.d r4, AttributeSet r5) {
        super(r4.getContext(), r5);
        r4.a(r4.getContext());
        this.f = new l();
        this.g = new m();
        Context r6 = getContext();
        ywb.b.a r7 = new ywb.b.a();
        ywb.e.a r0 = new ywb.e.a();
        ywb.d.a r1 = new ywb.d.a();
        int r2 = com.ss.android.lark.officesdk.utils.di.e.a;
        r7.a.a = com.ss.android.lark.officesdk.utils.di.e.a.a(r6);
        r1.a.a = true;
        ywb.c r8 = new ywb.c();
        r8.a = r7.a;
        r8.b = r0.a;
        r8.c = r1.a;
        this.b = r8;
        setWebViewConfig(r8);
        this.c = new uwb.c(this);
        this.d = new uwb.b(this);
        super.setWebViewClient(this.c);
        super.setWebChromeClient(this.d);
        this.a = new n();
        this.a.b(com.ss.android.lark.officewebview.service.impl.b.class);
        k();
        j.e("BaseOfficeWebView", "initWebView done");
        postDelayed(new d(this), 1500);
    }

    public static void a(g r1, String r2) {
        r1.getClass();
        super.loadUrl(r2, new HashMap());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    @Override // android.webkit.WebView
    public final void evaluateJavascript(final String r3, final ValueCallback<String> r4) {
        j.e("BaseOfficeWebView", "evaluateJavascript run");
        if (i.a() == false) goto L5;
        super.evaluateJavascript(r3, r4);
        return;
    L5:
        i.a.a.b(new a(this, r3, r4));
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String r5, final Map<String, String> r6) {
        j.e("BaseOfficeWebView", "loadUrl additional");
        this.g.a(r5, System.currentTimeMillis());
        if (r6 == null) goto L8;
        DependencyContainer r0 = DependencyContainer.a;
        ntb.m r1 = (ntb.m) DependencyContainer.a(ntb.m.class, DependencyContextUniqueId.OfficeWebView);
        if (r1 == null) goto L8;
        r6.put("Accept-Language", r1.t());
    L8:
        if (i.a() == true) goto L15;
        i.a.a.b(new e(this, r5, r6));
        return;
    L15:
        super.loadUrl(r5, r6);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    public static void g(g r0, String r1, Map r2) {
        r0.getClass();
        super.loadUrl(r1, r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.d("BaseOfficeWebView", e);
    }

    public static /* synthetic */ void h(g r0, String r1, ValueCallback r2) {
        super.evaluateJavascript(r1, r2);
    }

    @Override // android.webkit.WebView
    public final void loadData(final String r5, final String r6, final String r7) {
        j.e("BaseOfficeWebView", "loadData");
        this.g.a(getUrl(), System.currentTimeMillis());
        if (i.a() == false) goto L5;
        super.loadData(r5, r6, r7);
        return;
    L5:
        i.a.a.b(new f(this, r5, r6, r7));
    }

    public static /* synthetic */ void j(g r0, String r1, String r2, String r3) {
        super.loadData(r1, r2, r3);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String r10, final String r11, final String r12, final String r13, final String r14) {
        j.e("BaseOfficeWebView", "loadDataWithBaseUrl");
        this.g.a(r10, System.currentTimeMillis());
        if (i.a() == false) goto L5;
        super.loadDataWithBaseURL(r10, r11, r12, r13, r14);
        return;
    L5:
        i.a.a.b(new c(this, r10, r11, r12, r13, r14));
    }

    public static /* synthetic */ void i(g r0, String r1, String r2, String r3, String r4, String r5) {
        super.loadDataWithBaseURL(r1, r2, r3, r4, r5);
    }
}
