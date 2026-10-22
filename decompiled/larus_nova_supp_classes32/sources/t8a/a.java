package t8a;

import android.content.Context;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.xelement.webview.LynxUIWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements u8a.b {
    public final Context a;
    public u8a.a b;
    public WebView c;

    /* JADX INFO: renamed from: t8a.a$a, reason: collision with other inner class name */
    public class C0112a extends WebViewClient {
        public final /* synthetic */ a a;

        public C0112a(a r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r3, String r4) {
            super.onPageFinished(r3, r4);
            u8a.a r5 = this.a.b;
            if (r5 == null) goto L6;
            LynxUIWebView.a r6 = (LynxUIWebView.a) r5;
            LynxUIWebView.access$000(r6.a).c("(function() {   window.addEventListener('message', function(event) {       window.LynxWebViewBridge.onMessageReceived(event.data);   });})();");
            r6.a.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r6.a.getSign(), "load"));
            return;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r4, WebResourceRequest r5, WebResourceError r6) {
            super.onReceivedError(r4, r5, r6);
            if (Build.VERSION.SDK_INT < 23) goto L9;
            u8a.a r7 = this.a.b;
            if (r7 == null) goto L10;
            if (r6 == null) goto L11;
            int r8 = r6.getErrorCode();
            String r9 = r6.getDescription().toString();
            LynxUIWebView.a r10 = (LynxUIWebView.a) r7;
            r10.getClass();
            m7a.a r0 = new m7a.a(r10.a.getSign(), "error");
            r0.a("errorCode", Integer.valueOf(r8));
            r0.a("errorMsg", r9);
            r10.a.getLynxContext().getEventEmitter().sendCustomEvent(r0);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    @Override // u8a.b
    public final void a() {
    }

    @Override // u8a.b
    public final void b() {
        WebView r0 = new WebView(this.a);
        this.c = r0;
        WebSettings r1 = r0.getSettings();
        r1.setJavaScriptEnabled(true);
        r1.setAllowFileAccess(false);
        r1.setAllowContentAccess(false);
        r1.setJavaScriptCanOpenWindowsAutomatically(true);
        r1.setMixedContentMode(0);
        r1.setDomStorageEnabled(true);
        r1.setUseWideViewPort(true);
        r1.setLoadWithOverviewMode(true);
        this.c.addJavascriptInterface(this, "LynxWebViewBridge");
        this.c.setWebViewClient(new C0112a(this));
    }

    @Override // u8a.b
    public final void destroy() {
        WebView r0 = this.c;
        if (r0 == null) goto L6;
        r0.destroy();
        this.c = null;
        return;
    }

    @Override // u8a.b
    public final void reload() {
        WebView r0 = this.c;
        if (r0 == null) goto L6;
        r0.reload();
        return;
    }

    @Override // u8a.b
    public final WebView getWebView() {
        return this.c;
    }

    public a(LynxContext r1) {
        this.a = r1;
    }

    @Override // u8a.b
    public final void c(String r3) {
        WebView r0 = this.c;
        if (r0 == null) goto L6;
        r0.evaluateJavascript(r3, null);
        return;
    }

    @Override // u8a.b
    public final void d(LynxUIWebView.a r1) {
        this.b = r1;
    }

    @Override // u8a.b
    public final void e(String r7) {
        WebView r0 = this.c;
        if (r0 == null) goto L6;
        r0.loadDataWithBaseURL(null, r7, "text/html", "utf-8", null);
        return;
    }

    @Override // u8a.b
    public final void loadUrl(String r2) {
        WebView r0 = this.c;
        if (r0 == null) goto L6;
        r0.loadUrl(r2);
        return;
    }

    @JavascriptInterface
    public void onMessageReceived(String r5) {
        u8a.a r0 = this.b;
        if (r0 == null) goto L6;
        LynxUIWebView.a r1 = (LynxUIWebView.a) r0;
        r1.getClass();
        m7a.a r2 = new m7a.a(r1.a.getSign(), "message");
        r2.a("msg", r5);
        r1.a.getLynxContext().getEventEmitter().sendCustomEvent(r2);
        return;
    }
}
