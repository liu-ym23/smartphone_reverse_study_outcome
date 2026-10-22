package com.ss.android.lark.chameleon.basewebview.client;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
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
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import com.ss.android.lark.chameleon.idependency.Log;
import k0b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkBaseWebViewClient extends WebViewClient {
    private static final String TAG = "LarkBaseWebViewClient";
    private WebViewClient mClient;
    private ILarkWebViewContext mContext;

    public static /* synthetic */ void a() {
        lambda$onReceivedSslError$0();
    }

    private static /* synthetic */ void lambda$onReceivedSslError$0() {
        Log.i(TAG, "sslErrorLoadEnsureCancel clicked");
    }

    public WebViewClient getWebViewClient() {
        return this.mClient;
    }

    public LarkBaseWebViewClient(ILarkWebViewContext r1) {
        this.mContext = r1;
    }

    public void setWebViewClient(WebViewClient r3) {
        StringBuilder r0 = new StringBuilder("Caller setWebViewClient: client=");
        if (r3 != null) goto L5;
        Object r1 = "null";
    L6:
        r0.append(r1);
        Log.i(TAG, r0.toString());
        this.mClient = r3;
        return;
    L5:
        r1 = Integer.valueOf(r3.hashCode());
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r3, String r4) {
        Log.i(TAG, "onLoadResource, this" + hashCode());
        super.onLoadResource(r3, r4);
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onLoadResource(r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r3, String r4) {
        Log.i(TAG, "onPageCommitVisible");
        super.onPageCommitVisible(r3, r4);
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onPageCommitVisible(r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r3, String r4) {
        Log.i(TAG, "onPageFinished");
        super.onPageFinished(r3, r4);
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onPageFinished(r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r3, ClientCertRequest r4) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onReceivedClientCertRequest mClient handle");
        this.mClient.onReceivedClientCertRequest(r3, r4);
        return;
    L5:
        Log.i(TAG, "onReceivedClientCertRequest default handle");
        super.onReceivedClientCertRequest(r3, r4);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r3, RenderProcessGoneDetail r4) {
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L6;
        boolean r5 = r0.onRenderProcessGone(r3, r4);
        Log.i(TAG, "onRenderProcessGone mClient handle result " + r5);
        return r5;
    L6:
        Log.i(TAG, "onRenderProcessGone default return true");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r3, KeyEvent r4) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onUnhandledKeyEvent mClient handle");
        this.mClient.onUnhandledKeyEvent(r3, r4);
        return;
    L5:
        Log.i(TAG, "onUnhandledKeyEvent default handle");
        super.onUnhandledKeyEvent(r3, r4);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r2, WebResourceRequest r3) {
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L5;
        WebResourceResponse r1 = r0.shouldInterceptRequest(r2, r3);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return super.shouldInterceptRequest(r2, r3);
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView r3, KeyEvent r4) {
        boolean r0 = super.shouldOverrideKeyEvent(r3, r4);
        WebViewClient r1 = this.mClient;
        if (r1 == null) goto L5;
        r0 = r0 | r1.shouldOverrideKeyEvent(r3, r4);
    L5:
        Log.i(TAG, "shouldOverrideKeyEvent , override = " + r0);
        return r0;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r5, WebResourceRequest r6) {
        WebViewClient r0 = this.mClient;
        boolean r2 = false;
        if (r0 == null) goto L5;
        r2 = false | r0.shouldOverrideUrlLoading(r5, r6);
        Log.i(TAG, "after mClient override url intercept = " + r2);
    L5:
        if (r2 == false) goto L8;
        Log.i(TAG, "shouldOverrideUrlLoading intercept return true");
        return true;
    L8:
        Log.i(TAG, "shouldOverrideUrlLoading return default");
        return super.shouldOverrideUrlLoading(r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r2, String r3) {
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L5;
        WebResourceResponse r1 = r0.shouldInterceptRequest(r2, r3);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return super.shouldInterceptRequest(r2, r3);
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r5, String r6) {
        WebViewClient r0 = this.mClient;
        boolean r2 = false;
        if (r0 == null) goto L5;
        r2 = false | r0.shouldOverrideUrlLoading(r5, r6);
        Log.i(TAG, "after mClient override , intercept = " + r2);
    L5:
        if (r2 == false) goto L8;
        Log.i(TAG, "shouldOverrideUrlLoading intercept return true");
        return true;
    L8:
        boolean r7 = super.shouldOverrideUrlLoading(r5, r6);
        Log.i(TAG, "shouldOverrideUrlLoading return default");
        return r7;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r4, String r5, boolean r6) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "doUpdateVisitedHistory mClient handle , isReload = " + r6);
        this.mClient.doUpdateVisitedHistory(r4, r5, r6);
        return;
    L5:
        Log.i(TAG, "doUpdateVisitedHistory default handle, isReload = " + r6);
        super.doUpdateVisitedHistory(r4, r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView r3, Message r4, Message r5) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onFormResubmission mClient handle");
        this.mClient.onFormResubmission(r3, r4, r5);
        return;
    L5:
        Log.i(TAG, "onFormResubmission default handle");
        super.onFormResubmission(r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r3, String r4, Bitmap r5) {
        Log.i(TAG, "onPageStarted url ");
        super.onPageStarted(r3, r4, r5);
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L6;
        r0.onPageStarted(r3, r4, r5);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r2, WebResourceRequest r3, WebResourceError r4) {
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L5;
        r0.onReceivedError(r2, r3, r4);
        return;
    L5:
        super.onReceivedError(r2, r3, r4);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r2, WebResourceRequest r3, WebResourceResponse r4) {
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L5;
        r0.onReceivedHttpError(r2, r3, r4);
        return;
    L5:
        super.onReceivedHttpError(r2, r3, r4);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView r3, SslErrorHandler r4, SslError r5) {
        WebViewClient r0 = this.mClient;
        if ((r0 instanceof AbsLarkWebViewClient) == false) goto L6;
        Log.i(TAG, "mClient instanceof AbsLarkWebViewClient");
        ((AbsLarkWebViewClient) this.mClient).onReceivedSslError(r3, r4, r5, new a());
        return;
    L6:
        if (r0 == null) goto L9;
        r0.onReceivedSslError(r3, r4, r5);
        return;
    L9:
        super.onReceivedSslError(r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView r3, float r4, float r5) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onScaleChanged mClient handle");
        this.mClient.onScaleChanged(r3, r4, r5);
        return;
    L5:
        Log.i(TAG, "onScaleChanged default handle");
        super.onScaleChanged(r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r3, Message r4, Message r5) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onTooManyRedirects mClient handle");
        this.mClient.onTooManyRedirects(r3, r4, r5);
        return;
    L5:
        Log.i(TAG, "onTooManyRedirects default handle");
        super.onTooManyRedirects(r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r2, int r3, String r4, String r5) {
        WebViewClient r0 = this.mClient;
        if (r0 == null) goto L5;
        r0.onReceivedError(r2, r3, r4, r5);
        return;
    L5:
        super.onReceivedError(r2, r3, r4, r5);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r3, HttpAuthHandler r4, String r5, String r6) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onReceivedHttpAuthRequest mClient handle");
        this.mClient.onReceivedHttpAuthRequest(r3, r4, r5, r6);
        return;
    L5:
        Log.i(TAG, "onReceivedHttpAuthRequest default handle");
        super.onReceivedHttpAuthRequest(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r3, String r4, String r5, String r6) {
        if (this.mClient == null) goto L5;
        Log.i(TAG, "onReceivedLoginRequest mClient handle");
        this.mClient.onReceivedLoginRequest(r3, r4, r5, r6);
        return;
    L5:
        Log.i(TAG, "onReceivedLoginRequest default handle");
        super.onReceivedLoginRequest(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(WebView r3, WebResourceRequest r4, int r5, SafeBrowsingResponse r6) {
        Log.i(TAG, "onSafeBrowsingHit");
        super.onSafeBrowsingHit(r3, r4, r5, r6);
        if (this.mClient == null) goto L6;
        Log.i(TAG, "onSafeBrowsingHit mClient handle");
        this.mClient.onSafeBrowsingHit(r3, r4, r5, r6);
        return;
    }
}
