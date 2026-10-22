package com.ss.android.lark.chameleon.container.webcontainer.plugin.core;

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
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.res.IWebResourceInterceptor;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.EncriptUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J.\u0010\u0014\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u001d\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010 \u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010$\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010&\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010&\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient;", "Landroid/webkit/WebViewClient;", "interceptor", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/IWebResourceInterceptor;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "callback", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/res/IWebResourceInterceptor;Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;)V", "debounceShouldOverrideUrlLoading", "Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient$DebounceShouldOverrideUrlLoading;", "onPageFinished", BuildConfig.FLAVOR, "view", "Landroid/webkit/WebView;", "url", BuildConfig.FLAVOR, "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", Keys.API_RETURN_KEY_ERROR, "Landroid/webkit/WebResourceError;", "errorCode", BuildConfig.FLAVOR, "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onRenderProcessGone", BuildConfig.FLAVOR, "detail", "Landroid/webkit/RenderProcessGoneDetail;", "overrideUrlLoading", "shouldInterceptRequest", "shouldOverrideUrlLoading", "Companion", "DebounceShouldOverrideUrlLoading", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonWebViewClient extends WebViewClient {
    public static final Companion Companion = null;
    public static final int DEFAULT_SAFE_TIME = 500;
    private static final String MIME_TYPE_HTML = "text/html";
    private static final String MIME_TYPE_XHTML = "application/xhtml+xml";
    public static final String TAG = "CML_TAG_ChameleonWebViewClient";
    private final IChameleonLoader.LoadingCallback callback;
    private final DebounceShouldOverrideUrlLoading debounceShouldOverrideUrlLoading;
    private final IWebResourceInterceptor interceptor;
    private final ChameleonWebView webView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient$Companion;", BuildConfig.FLAVOR, "()V", "DEFAULT_SAFE_TIME", BuildConfig.FLAVOR, "MIME_TYPE_HTML", BuildConfig.FLAVOR, "MIME_TYPE_XHTML", "TAG", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient$DebounceShouldOverrideUrlLoading;", BuildConfig.FLAVOR, "(Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient;)V", "lastProcessTime", BuildConfig.FLAVOR, "lastUrl", BuildConfig.FLAVOR, "shouldOverrideUrlLoading", BuildConfig.FLAVOR, "view", "Landroid/webkit/WebView;", "url", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class DebounceShouldOverrideUrlLoading {
        private long lastProcessTime;
        private String lastUrl;
        final /* synthetic */ ChameleonWebViewClient this$0;

        public DebounceShouldOverrideUrlLoading(ChameleonWebViewClient r1) {
            this.this$0 = r1;
        }

        public final boolean shouldOverrideUrlLoading(WebView r8, String r9) {
            long r0 = System.currentTimeMillis();
            if (TextUtils.equals(this.lastUrl, r9) == true) goto L5;
        L8:
            this.lastProcessTime = r0;
            this.lastUrl = r9;
            return ChameleonWebViewClient.access$overrideUrlLoading(this.this$0, r8, r9);
        L5:
            if ((r0 - this.lastProcessTime) >= 500) goto L8;
            Log.w(ChameleonWebViewClient.TAG, "So fast click , ignored !");
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final boolean overrideUrlLoading(WebView r2, String r3) {
        Log.i(TAG, "overrideUrlLoading:" + EncriptUtils.replaceToken(ChameleonContainerUtils.INSTANCE.safeUrlString(r3)));
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r2) {
        super.onPageFinished(r1, r2);
        Log.i(TAG, "onPageFinished");
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r4, RenderProcessGoneDetail r5) {
        ChameleonOpenTracker.SessionTracker r6 = ChameleonOpenTracker.INSTANCE.getSessionTracker(this.webView.getSession());
        if (r6 == null) goto L5;
        r6.reportCommonError(100, BuildConfig.FLAVOR, !this.webView.isVisible() ? 1 : 0);
    L5:
        this.callback.onRenderProcessGone();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r4, WebResourceRequest r5) {
        IWebResourceInterceptor r6 = this.interceptor;
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
    public boolean shouldOverrideUrlLoading(WebView r4, WebResourceRequest r5) {
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
        Log.i(TAG, "shouldOverrideUrlLoading, is redirect, not intercept");
        return false;
    L9:
        r2 = false;
        goto L10
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r2, String r3) {
        return this.debounceShouldOverrideUrlLoading.shouldOverrideUrlLoading(r2, r3);
    }

    public ChameleonWebViewClient(IWebResourceInterceptor r2, ChameleonWebView r3, IChameleonLoader.LoadingCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.interceptor = r2;
        this.webView = r3;
        this.callback = r4;
        this.debounceShouldOverrideUrlLoading = new DebounceShouldOverrideUrlLoading(this);
    }

    public static final /* synthetic */ boolean access$overrideUrlLoading(ChameleonWebViewClient r0, WebView r1, String r2) {
        return r0.overrideUrlLoading(r1, r2);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r1, String r2, Bitmap r3) {
        super.onPageStarted(r1, r2, r3);
        Log.i(TAG, "onPageStarted");
        this.callback.onPageStarted(r2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r5, WebResourceRequest r6, WebResourceError r7) {
        super.onReceivedError(r5, r6, r7);
        String r8 = null;
        if (r6 == null) goto L5;
        Boolean r0 = Boolean.valueOf(r6.isForMainFrame());
    L6:
        Log.i(TAG, "onReceivedError  isMainFrame--" + r0);
        if (Build.VERSION.SDK_INT < 23) goto L37;
        StringBuilder r1 = new StringBuilder("onReceivedError request=");
        ChameleonContainerUtils r3 = ChameleonContainerUtils.INSTANCE;
        if (r6 == null) goto L11;
        Uri r9 = r6.getUrl();
    L12:
        r1.append(r3.safeUrlString(String.valueOf(r9)));
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
        Log.e(TAG, r1.toString());
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L41;
        IChameleonLoader.LoadingCallback r12 = this.callback;
        if (r7 == null) goto L25;
        int r2 = r7.getErrorCode();
    L26:
        if (r7 == null) goto L30;
        CharSequence r4 = r7.getDescription();
        if (r4 == null) goto L30;
        String r13 = r4.toString();
    L32:
        if (r7 == null) goto L36;
        CharSequence r14 = r7.getDescription();
        if (r14 == null) goto L36;
        r8 = r14.toString();
    L36:
        r12.onLoadFail(r2, r13, new Throwable(r8));
        return;
    L30:
        r13 = null;
        goto L32
    L25:
        r2 = 10000;
        goto L26
    L41:
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
    L37:
        Log.e(TAG, "onReceivedError error=" + r7);
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L43;
        this.callback.onLoadFail(-1, "onReceivedError", new Throwable("onReceivedError"));
        return;
    L43:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r5, WebResourceRequest r6, WebResourceResponse r7) {
        super.onReceivedHttpError(r5, r6, r7);
        if (Build.VERSION.SDK_INT < 23) goto L18;
        StringBuilder r8 = new StringBuilder("onReceivedHttpError request=");
        ChameleonContainerUtils r0 = ChameleonContainerUtils.INSTANCE;
        Map<String, String> r2 = null;
        if (r6 == null) goto L9;
        Uri r3 = r6.getUrl();
        if (r3 == null) goto L9;
        String r4 = r3.toString();
    L10:
        r8.append(r0.safeUrlString(r4));
        r8.append(", error=");
        if (r7 == null) goto L13;
        Integer r1 = Integer.valueOf(r7.getStatusCode());
    L14:
        r8.append(r1);
        r8.append(": ");
        if (r7 == null) goto L17;
        r2 = r7.getResponseHeaders();
    L17:
        r8.append(r2);
        Log.e(TAG, r8.toString());
    L19:
        boolean r9 = false;
        if (r6 != null) goto L22;
    L24:
        if (r7 == null) goto L26;
        String r10 = r7.getMimeType();
        int r11 = r7.getStatusCode();
        String r12 = r7.getReasonPhrase();
    L27:
        Log.i(ChameleonLoaderImpl.TAG, "onReceivedHttpError  isMainFrame--" + r9 + " ,   statusCode--" + r11 + ",   mimeType--" + r10 + ",   description--" + r12);
        if (TextUtils.equals(MIME_TYPE_XHTML, r10) == false) goto L30;
    L33:
        if (r9 == true) goto L37;
        Log.i(ChameleonLoaderImpl.TAG, "isMainFrame--" + r9);
        return;
    L37:
        if (r11 < 400) goto L40;
        this.callback.onLoadFail(r11, r12, new Throwable(r12));
        return;
    L40:
        return;
    L30:
        if (TextUtils.equals(MIME_TYPE_HTML, r10) == true) goto L33;
        Log.i(ChameleonLoaderImpl.TAG, "is no html ,return ");
        return;
    L26:
        r10 = BuildConfig.FLAVOR;
        r11 = 10000;
        r12 = BuildConfig.FLAVOR;
        goto L27
    L22:
        if (r6.isForMainFrame() != true) goto L24;
        r9 = true;
        goto L24
    L13:
        r1 = null;
    L9:
        r4 = null;
        goto L10
    L18:
        Log.e(TAG, "onReceivedHttpError error=" + r7);
        goto L19
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r2, int r3, String r4, String r5) {
        super.onReceivedError(r2, r3, r4, r5);
        Log.e(TAG, "onReceivedError errorCode=" + r3 + ", description=" + r4 + ", failingUrl=" + ChameleonContainerUtils.INSTANCE.safeUrlString(r5));
    }
}
