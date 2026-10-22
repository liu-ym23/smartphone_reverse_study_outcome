package m7;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
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
import com.bytedance.android.annie.param.AnnieXLiveContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends WebViewClient {
    public final AnnieXLiveContext a;
    public final WebViewClient b;
    public final b7.b c;
    public ia.c d;

    public static final class a {
    }

    static {
    }

    public c(AnnieXLiveContext r10, WebViewClient r11) {
        Intrinsics.checkNotNullParameter(r11, "webViewClient");
        this.a = r10;
        this.b = r11;
        if (r10 == null) goto L5;
        b7.b r12 = r10.getCommonLifecycle();
    L6:
        this.c = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r10, String r11) {
        super.onLoadResource(r10, r11);
        this.b.onLoadResource(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r10, String r11) {
        super.onPageCommitVisible(r10, r11);
        this.b.onPageCommitVisible(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r10, String r11) {
        super.onPageFinished(r10, r11);
        this.b.onPageFinished(r10, r11);
        b7.b r12 = this.c;
        if (r12 == null) goto L6;
        r12.onLoadSuccess(r10);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r10, ClientCertRequest r11) {
        super.onReceivedClientCertRequest(r10, r11);
        this.b.onReceivedClientCertRequest(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r10, RenderProcessGoneDetail r11) {
        this.b.onRenderProcessGone(r10, r11);
        return super.onRenderProcessGone(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r10, KeyEvent r11) {
        super.onUnhandledKeyEvent(r10, r11);
        this.b.onUnhandledKeyEvent(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r10, WebResourceRequest r11) {
        this.b.shouldInterceptRequest(r10, r11);
        return super.shouldInterceptRequest(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r10, KeyEvent r11) {
        this.b.shouldOverrideKeyEvent(r10, r11);
        return super.shouldOverrideKeyEvent(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r10, WebResourceRequest r11) {
        this.b.shouldOverrideUrlLoading(r10, r11);
        return super.shouldOverrideUrlLoading(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r10, String r11) {
        this.b.shouldInterceptRequest(r10, r11);
        return super.shouldInterceptRequest(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r10, String r11) {
        this.b.shouldOverrideUrlLoading(r10, r11);
        return super.shouldOverrideUrlLoading(r10, r11);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r10, String r11, boolean r12) {
        super.doUpdateVisitedHistory(r10, r11, r12);
        this.b.doUpdateVisitedHistory(r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r10, Message r11, Message r12) {
        super.onFormResubmission(r10, r11, r12);
        this.b.onFormResubmission(r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r10, String r11, Bitmap r12) {
        super.onPageStarted(r10, r11, r12);
        this.b.onPageStarted(r10, r11, r12);
        b7.b r13 = this.c;
        if (r13 == null) goto L6;
        r13.onLoadStart(r10, false);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        super.onReceivedError(r10, r11, r12);
        this.b.onReceivedError(r10, r11, r12);
        b7.b r13 = this.c;
        if (r13 == null) goto L17;
        ia.c r14 = this.d;
        CharSequence r0 = null;
        if (r14 == null) goto L7;
        View r15 = r14.getKitView();
    L8:
        AnnieXLiveContext r1 = this.a;
        if (r1 == null) goto L11;
        String r16 = r1.getUrl();
    L12:
        String r17 = String.valueOf(r16);
        if (r12 == null) goto L15;
        r0 = r12.getDescription();
    L15:
        r13.onLoadFail(r15, r17, String.valueOf(r0));
        return;
    L11:
        r16 = null;
        goto L12
    L7:
        r15 = null;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        super.onReceivedHttpError(r10, r11, r12);
        this.b.onReceivedHttpError(r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r10, SslErrorHandler r11, SslError r12) {
        super.onReceivedSslError(r10, r11, r12);
        this.b.onReceivedSslError(r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r10, float r11, float r12) {
        super.onScaleChanged(r10, r11, r12);
        this.b.onScaleChanged(r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r10, Message r11, Message r12) {
        super.onTooManyRedirects(r10, r11, r12);
        this.b.onTooManyRedirects(r10, r11, r12);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r10, int r11, String r12, String r13) {
        super.onReceivedError(r10, r11, r12, r13);
        this.b.onReceivedError(r10, r11, r12, r13);
        b7.b r14 = this.c;
        if (r14 == null) goto L13;
        ia.c r15 = this.d;
        String r16 = null;
        if (r15 == null) goto L7;
        View r17 = r15.getKitView();
    L8:
        AnnieXLiveContext r0 = this.a;
        if (r0 == null) goto L11;
        r16 = r0.getUrl();
    L11:
        r14.onLoadFail(r17, String.valueOf(r16), r12);
        return;
    L7:
        r17 = null;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r10, HttpAuthHandler r11, String r12, String r13) {
        super.onReceivedHttpAuthRequest(r10, r11, r12, r13);
        this.b.onReceivedHttpAuthRequest(r10, r11, r12, r13);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r10, String r11, String r12, String r13) {
        super.onReceivedLoginRequest(r10, r11, r12, r13);
        this.b.onReceivedLoginRequest(r10, r11, r12, r13);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r10, WebResourceRequest r11, int r12, SafeBrowsingResponse r13) {
        this.b.onSafeBrowsingHit(r10, r11, r12, r13);
        super.onSafeBrowsingHit(r10, r11, r12, r13);
    }
}
