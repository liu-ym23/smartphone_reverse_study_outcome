package bd;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.service.base.YieldError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends WebViewClient {
    public void a() {
        throw new YieldError();
    }

    public boolean b(WebView r5, d r10) {
        throw new YieldError();
    }

    public boolean c(WebView r5, wc.f r10) {
        throw new YieldError();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r5, WebResourceRequest r10, WebResourceError r11) {
        if (r10 == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
    L5:
        if (r11 == null) goto L8;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r5, WebResourceRequest r10, WebResourceResponse r11) {
        if (r10 == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r5, RenderProcessGoneDetail r10) {
        if (r10 == null) goto L4;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        wc.f r11 = new wc.f(1);
    L6:
        return c(r5, r11);
    L4:
        r11 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r5, WebResourceRequest r10) {
        if (r10 == null) goto L4;
        Intrinsics.checkNotNullParameter(r10, "<this>");
    L4:
        a();
        throw null;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, WebResourceRequest r10) {
        if (r10 == null) goto L4;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        d r11 = new d(r10);
    L6:
        return b(r5, r11);
    L4:
        r11 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r5, String r10) {
        throw new YieldError();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r5, String r10) {
        throw new YieldError();
    }
}
