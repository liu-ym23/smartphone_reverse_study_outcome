package com.ss.android.lark.chameleon.pluginsystem;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExtendableWebViewClientV2 extends LarkBaseWebViewClient {
    private List<WebViewClient> delegates;

    public ExtendableWebViewClientV2(ILarkWebViewContext r1) {
        super(r1);
        this.delegates = new CopyOnWriteArrayList();
    }

    public void addWebViewClientDelegate(WebViewClient r2) {
        if (this.delegates.contains(r2) == true) goto L6;
        this.delegates.add(r2);
        return;
    }

    public void removeWebViewClientDelegate(WebViewClient r2) {
        this.delegates.remove(r2);
    }

    public void sortDelegates(Comparator<WebViewClient> r3) {
        ArrayList r0 = new ArrayList(this.delegates);
        Collections.sort(r0, r3);
        this.delegates.clear();
        this.delegates.addAll(r0);
    }

    private void innerOnLoadResource(WebView r3, String r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onLoadResource(r3, r4);
        goto L4
    }

    private void innerOnPageCommitVisible(WebView r3, String r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPageCommitVisible(r3, r4);
        goto L4
    }

    private void innerOnPageFinished(WebView r3, String r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPageFinished(r3, r4);
        goto L4
    }

    private void innerOnReceivedClientCertRequest(WebView r3, ClientCertRequest r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedClientCertRequest(r3, r4);
        goto L4
    }

    private boolean innerOnRenderProcessGone(WebView r3, RenderProcessGoneDetail r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().onRenderProcessGone(r3, r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private void innerOnUnhandledKeyEvent(WebView r3, KeyEvent r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onUnhandledKeyEvent(r3, r4);
        goto L4
    }

    private WebResourceResponse innerShouldInterceptRequest(WebView r3, WebResourceRequest r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        WebResourceResponse r1 = r0.next().shouldInterceptRequest(r3, r4);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    private boolean innerShouldOverrideKeyEvent(WebView r3, KeyEvent r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().shouldOverrideKeyEvent(r3, r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean innerShouldOverrideUrlLoading(WebView r3, WebResourceRequest r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().shouldOverrideUrlLoading(r3, r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void addWebViewClientDelegate(int r2, WebViewClient r3) {
        if (this.delegates.contains(r3) == true) goto L6;
        ListProtector.add(this.delegates, r2, r3);
        return;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onLoadResource(WebView r1, String r2) {
        super.onLoadResource(r1, r2);
        innerOnLoadResource(r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r1, String r2) {
        super.onPageCommitVisible(r1, r2);
        innerOnPageCommitVisible(r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r2) {
        super.onPageFinished(r1, r2);
        innerOnPageFinished(r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r1, ClientCertRequest r2) {
        super.onReceivedClientCertRequest(r1, r2);
        innerOnReceivedClientCertRequest(r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r2, RenderProcessGoneDetail r3) {
        if (innerOnRenderProcessGone(r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onRenderProcessGone(r2, r3) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r1, KeyEvent r2) {
        super.onUnhandledKeyEvent(r1, r2);
        innerOnUnhandledKeyEvent(r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r2, WebResourceRequest r3) {
        WebResourceResponse r0 = innerShouldInterceptRequest(r2, r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.shouldInterceptRequest(r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView r2, KeyEvent r3) {
        if (innerShouldOverrideKeyEvent(r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.shouldOverrideKeyEvent(r2, r3) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
        return innerShouldOverrideUrlLoading(r1, r2);
    }

    private boolean innerShouldOverrideUrlLoading(WebView r3, String r4) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().shouldOverrideUrlLoading(r3, r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r1, String r2) {
        return innerShouldOverrideUrlLoading(r1, r2);
    }

    private void innerDoUpdateVisitedHistory(WebView r3, String r4, boolean r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().doUpdateVisitedHistory(r3, r4, r5);
        goto L4
    }

    private void innerOnFormResubmission(WebView r3, Message r4, Message r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onFormResubmission(r3, r4, r5);
        goto L4
    }

    private void innerOnPageStarted(WebView r3, String r4, Bitmap r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPageStarted(r3, r4, r5);
        goto L4
    }

    private void innerOnReceivedError(WebView r3, WebResourceRequest r4, WebResourceError r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedError(r3, r4, r5);
        goto L4
    }

    private void innerOnReceivedHttpError(WebView r3, WebResourceRequest r4, WebResourceResponse r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedHttpError(r3, r4, r5);
        goto L4
    }

    private void innerOnReceivedSslError(WebView r3, SslErrorHandler r4, SslError r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedSslError(r3, r4, r5);
        goto L4
    }

    private void innerOnScaleChanged(WebView r3, float r4, float r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onScaleChanged(r3, r4, r5);
        goto L4
    }

    private void innerOnTooManyRedirects(WebView r3, Message r4, Message r5) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onTooManyRedirects(r3, r4, r5);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r1, String r2, boolean r3) {
        super.doUpdateVisitedHistory(r1, r2, r3);
        innerDoUpdateVisitedHistory(r1, r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onFormResubmission(WebView r1, Message r2, Message r3) {
        super.onFormResubmission(r1, r2, r3);
        innerOnFormResubmission(r1, r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onPageStarted(WebView r1, String r2, Bitmap r3) {
        super.onPageStarted(r1, r2, r3);
        innerOnPageStarted(r1, r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedError(WebView r3, WebResourceRequest r4, WebResourceError r5) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        super.onReceivedError(r3, r4, r5);
    L5:
        innerOnReceivedError(r3, r4, r5);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r3, WebResourceRequest r4, WebResourceResponse r5) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        super.onReceivedHttpError(r3, r4, r5);
    L5:
        innerOnReceivedHttpError(r3, r4, r5);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedSslError(WebView r1, SslErrorHandler r2, SslError r3) {
        super.onReceivedSslError(r1, r2, r3);
        innerOnReceivedSslError(r1, r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onScaleChanged(WebView r1, float r2, float r3) {
        super.onScaleChanged(r1, r2, r3);
        innerOnScaleChanged(r1, r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r1, Message r2, Message r3) {
        super.onTooManyRedirects(r1, r2, r3);
        innerOnTooManyRedirects(r1, r2, r3);
    }

    private void innerOnReceivedError(WebView r3, int r4, String r5, String r6) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedError(r3, r4, r5, r6);
        goto L4
    }

    private void innerOnReceivedHttpAuthRequest(WebView r3, HttpAuthHandler r4, String r5, String r6) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedHttpAuthRequest(r3, r4, r5, r6);
        goto L4
    }

    private void innerOnReceivedLoginRequest(WebView r3, String r4, String r5, String r6) {
        Iterator<WebViewClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedLoginRequest(r3, r4, r5, r6);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedError(WebView r1, int r2, String r3, String r4) {
        super.onReceivedError(r1, r2, r3, r4);
        innerOnReceivedError(r1, r2, r3, r4);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r1, HttpAuthHandler r2, String r3, String r4) {
        super.onReceivedHttpAuthRequest(r1, r2, r3, r4);
        innerOnReceivedHttpAuthRequest(r1, r2, r3, r4);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r1, String r2, String r3, String r4) {
        super.onReceivedLoginRequest(r1, r2, r3, r4);
        innerOnReceivedLoginRequest(r1, r2, r3, r4);
    }
}
