package otb;

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
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k extends WebViewClient {
    public final WebViewClient a;
    public j b;

    public static final class a {
        public final /* synthetic */ RenderProcessGoneDetail a;
        public final /* synthetic */ k b;

        public final boolean a() {
            return this.a.didCrash();
        }

        public final void b() {
            this.b.getClass();
        }

        public a(RenderProcessGoneDetail r1, k r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public k(WebViewClient r1, j r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onLoadResource(r2, r3);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPageCommitVisible(r2, r3);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPageFinished(r2, r3);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r2, ClientCertRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "request");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedClientCertRequest(r2, r3);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r3, RenderProcessGoneDetail r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "detail");
        j r0 = this.b;
        if (r0 != null) goto L5;
        WebViewClient r1 = this.a;
        if (r1 != null) goto L11;
        return true;
    L11:
        return r1.onRenderProcessGone(r3, r4);
    L5:
        return r0.a(r3, new a(r4, this));
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onUnhandledKeyEvent(r2, r3);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r2, WebResourceRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "request");
        WebViewClient r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.shouldInterceptRequest(r2, r3);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        WebViewClient r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.shouldOverrideKeyEvent(r2, r3);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r2, WebResourceRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "request");
        WebViewClient r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.shouldOverrideUrlLoading(r2, r3);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public final WebResourceResponse shouldInterceptRequest(WebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        WebViewClient r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.shouldInterceptRequest(r2, r3);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        WebViewClient r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.shouldOverrideUrlLoading(r2, r3);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.doUpdateVisitedHistory(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r2, Message r3, Message r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFormResubmission(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r2, String r3, Bitmap r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPageStarted(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r2, WebResourceRequest r3, WebResourceError r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "error");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedError(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r2, WebResourceRequest r3, WebResourceResponse r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "errorResponse");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedHttpError(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r2, SslErrorHandler r3, SslError r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r4, "error");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedSslError(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onScaleChanged(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r2, Message r3, Message r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "cancelMsg");
        Intrinsics.checkNotNullParameter(r4, "continueMsg");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onTooManyRedirects(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public final void onReceivedError(WebView r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedError(r2, r3, r4, r5);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r2, HttpAuthHandler r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r5, "realm");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedHttpAuthRequest(r2, r3, r4, r5);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "realm");
        Intrinsics.checkNotNullParameter(r5, "args");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedLoginRequest(r2, r3, r4, r5);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r2, WebResourceRequest r3, int r4, SafeBrowsingResponse r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r5, "callback");
        WebViewClient r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSafeBrowsingHit(r2, r3, r4, r5);
        return;
    }
}
