package com.ss.android.lark.chameleonv2.container.webcontainer.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IDependency;
import com.ss.android.lark.chameleon.IMonitorDependency;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonReport;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.router.c;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import swb.i;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends WebViewClient {
    public final y0b.b a;
    public final ChameleonWebView b;
    public final UIThreadCallbackAdapter c;
    public final C0020b d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.plugin.b$b, reason: collision with other inner class name */
    public final class C0020b {
        public long a;
        public String b;
        public final /* synthetic */ b c;

        public C0020b(b r1) {
            this.c = r1;
        }
    }

    static {
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r2) {
        super.onPageFinished(r1, r2);
        j.e(ChameleonWebViewClient.TAG, "onPageFinished");
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r7, RenderProcessGoneDetail r8) {
        Map<String, u1b.a.C0305a> r9 = u1b.a.a;
        u1b.a.C0305a r10 = u1b.a.a(this.b.getSession());
        if (r10 == null) goto L21;
        int r1 = !this.b.getIsVisible() ? 1 : 0;
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "msg");
        JSONObject r3 = new JSONObject();
        r3.put("code", 100);
        r3.put(ChameleonOpenTracker.ParamKey.APP_NAME, r10.a.getBizName());
        r3.put(ChameleonOpenTracker.ParamKey.ERRORMSG, BuildConfig.FLAVOR);
        r3.put(ChameleonOpenTracker.ParamKey.ERROR_TYPE, r1);
        ChameleonPluginHost r2 = r10.c;
        if (r2 == null) goto L20;
        IDependency r11 = r10.a.getDependency();
        if (r11 == null) goto L20;
        IMonitorDependency r12 = r11.getMonitorDependency();
        if (r12 == null) goto L20;
        Map<String, Object> r13 = r12.getBizParams(r2);
        if (r13 == null) goto L20;
        Iterator<Map.Entry<String, Object>> r14 = r13.entrySet().iterator();
    L14:
        if (r14.hasNext() == false) goto L20;
        Map.Entry<String, Object> r4 = r14.next();
        String r5 = r4.getKey();
        Object r6 = r4.getValue();
        if (r3.has(r5) == true) goto L14;
        r3.put(r5, r6);     // Catch: Exception -> L19
    L19:
        j.f(ChameleonReport.TAG, "skip invalid biz param: " + r5);
    L20:
        u1b.b.b(ChameleonOpenTracker.Event.CHAMELEON_COMMON_ERROR_DEV, r3);
    L21:
        int r15 = -1;
        if (Build.VERSION.SDK_INT <= 26) goto L30;
        CopyOnWriteArrayList<k.a> r16 = RenderGoneHelper.a;
        if (r8 == null) goto L26;
        boolean r17 = r8.didCrash();
    L27:
        if (r8 == null) goto L29;
        r15 = r8.rendererPriorityAtExit();
    L29:
        Log.i("CML_TAG_RenderGoneHelper", "onRenderProcessGone");
        RenderGoneHelper.b.trySend-JP2dKIU(new Pair(Boolean.valueOf(r17), Integer.valueOf(r15)));
    L31:
        return true;
    L26:
        r17 = false;
        goto L27
    L30:
        CopyOnWriteArrayList<k.a> r18 = RenderGoneHelper.a;
        Log.i("CML_TAG_RenderGoneHelper", "onRenderProcessGone");
        RenderGoneHelper.b.trySend-JP2dKIU(new Pair(Boolean.FALSE, -1));
        goto L31
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r4, WebResourceRequest r5) {
        y0b.b r6 = this.a;
        Map<String, String> r0 = null;
        if (r5 == null) goto L5;
        Uri r1 = r5.getUrl();
    L6:
        if (r5 == null) goto L8;
        String r2 = r5.getMethod();
    L9:
        if (r5 == null) goto L12;
        r0 = r5.getRequestHeaders();
    L12:
        return r6.shouldInterceptRequest(r1, r2, r0);
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r10, String r11) {
        C0020b r0 = this.d;
        r0.getClass();
        long r1 = System.currentTimeMillis();
        if (TextUtils.equals(r0.b, r11) == true) goto L5;
    L7:
        r0.a = r1;
        r0.b = r11;
        r0.c.getClass();
        j.e(ChameleonWebViewClient.TAG, "overrideUrlLoading:" + i.a(com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r11)));
        if (TextUtils.isEmpty(r11) == true) goto L14;
        int r2 = c.a;
        if (r10 == null) goto L12;
        Context r12 = r10.getContext();
    L17:
        return c.b(r12, r11);
    L12:
        r12 = null;
        goto L17
    L14:
        return false;
    L5:
        if ((r1 - r0.a) >= 500) goto L7;
        j.f(ChameleonWebViewClient.TAG, "So fast click , ignored !");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r4, WebResourceRequest r5) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L13:
        if (r5 == null) goto L18;
        Uri r6 = r5.getUrl();
        if (r6 == null) goto L18;
        String r7 = r6.toString();
        if (r7 == null) goto L18;
    L20:
        return shouldOverrideUrlLoading(r4, r7);
    L18:
        r7 = BuildConfig.FLAVOR;
        goto L20
    L5:
        if (r5 == null) goto L9;
        boolean r2 = true;
        if (r5.isRedirect() != true) goto L9;
    L10:
        if (r2 == false) goto L13;
        j.e(ChameleonWebViewClient.TAG, "shouldOverrideUrlLoading, is redirect, not intercept");
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public b(com.ss.android.lark.chameleonv2.container.webcontainer.res.a r2, ChameleonWebView r3, UIThreadCallbackAdapter r4) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new C0020b(this);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r1, String r2, Bitmap r3) {
        super.onPageStarted(r1, r2, r3);
        j.e(ChameleonWebViewClient.TAG, "onPageStarted");
        this.c.onPageStarted(r2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, WebResourceRequest r6, WebResourceError r7) {
        super.onReceivedError(r5, r6, r7);
        String r8 = null;
        if (r6 == null) goto L5;
        Boolean r0 = Boolean.valueOf(r6.isForMainFrame());
    L6:
        j.e(ChameleonWebViewClient.TAG, "onReceivedError  isMainFrame--" + r0);
        if (Build.VERSION.SDK_INT < 23) goto L32;
        StringBuilder r1 = new StringBuilder("onReceivedError request=");
        Map<String, Pair<ChameleonConfig, List<AbsChameleonPlugin>>> r3 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a;
        if (r6 == null) goto L11;
        Uri r9 = r6.getUrl();
    L12:
        r1.append(com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(String.valueOf(r9)));
        r1.append(", error=");
        if (r7 == null) goto L15;
        Integer r10 = Integer.valueOf(r7.getErrorCode());
    L16:
        r1.append(r10);
        r1.append(": ");
        if (r7 == null) goto L19;
        CharSequence r11 = r7.getDescription();
    L20:
        r1.append(r11);
        j.b(ChameleonWebViewClient.TAG, r1.toString());
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L36;
        UIThreadCallbackAdapter r12 = this.c;
        if (r7 == null) goto L25;
        int r2 = r7.getErrorCode();
    L27:
        if (r7 == null) goto L31;
        CharSequence r13 = r7.getDescription();
        if (r13 == null) goto L31;
        r8 = r13.toString();
    L31:
        r12.onLoadFail(r2, new Throwable(r8));
        return;
    L25:
        r2 = 10000;
        goto L27
    L36:
        return;
    L19:
        r11 = null;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    L32:
        j.b(ChameleonWebViewClient.TAG, "onReceivedError error=" + r7);
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L38;
        this.c.onLoadFail(-1, new Throwable("onReceivedError"));
        return;
    L38:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r4, WebResourceRequest r5, WebResourceResponse r6) {
        super.onReceivedHttpError(r4, r5, r6);
        if (Build.VERSION.SDK_INT < 23) goto L18;
        StringBuilder r7 = new StringBuilder("onReceivedHttpError request=");
        Map<String, Pair<ChameleonConfig, List<AbsChameleonPlugin>>> r0 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a;
        Map<String, String> r1 = null;
        if (r5 == null) goto L9;
        Uri r2 = r5.getUrl();
        if (r2 == null) goto L9;
        String r3 = r2.toString();
    L10:
        r7.append(com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r3));
        r7.append(", error=");
        if (r6 == null) goto L13;
        Integer r8 = Integer.valueOf(r6.getStatusCode());
    L14:
        r7.append(r8);
        r7.append(": ");
        if (r6 == null) goto L17;
        r1 = r6.getResponseHeaders();
    L17:
        r7.append(r1);
        j.b(ChameleonWebViewClient.TAG, r7.toString());
    L19:
        if (r5 == null) goto L23;
        boolean r9 = r5.isForMainFrame();
        boolean r10 = true;
        if (r9 != true) goto L23;
    L24:
        if (r6 == null) goto L26;
        String r11 = r6.getMimeType();
        int r12 = r6.getStatusCode();
        String r13 = r6.getReasonPhrase();
    L27:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonLoaderImpl.TAG, "onReceivedHttpError  isMainFrame--" + r10 + " ,   statusCode--" + r12 + ",   mimeType--" + r11 + ",   description--" + r13);
        if (TextUtils.equals("application/xhtml+xml", r11) == false) goto L30;
    L33:
        if (r10 == true) goto L37;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonLoaderImpl.TAG, "isMainFrame--" + r10);
        return;
    L37:
        if (r12 < 400) goto L40;
        this.c.onLoadFail(r12, new Throwable(r13));
        return;
    L40:
        return;
    L30:
        if (TextUtils.equals("text/html", r11) == true) goto L33;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonLoaderImpl.TAG, "is no html ,return ");
        return;
    L26:
        r11 = BuildConfig.FLAVOR;
        r12 = 10000;
        r13 = BuildConfig.FLAVOR;
    L23:
        r10 = false;
        goto L24
    L13:
        r8 = null;
    L9:
        r3 = null;
        goto L10
    L18:
        j.b(ChameleonWebViewClient.TAG, "onReceivedHttpError error=" + r6);
        goto L19
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r2, int r3, String r4, String r5) {
        super.onReceivedError(r2, r3, r4, r5);
        j.b(ChameleonWebViewClient.TAG, "onReceivedError errorCode=" + r3 + ", description=" + r4 + ", failingUrl=" + com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r5));
    }
}
