package bd;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.service.base.YieldError;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f907b;

    public f() {
        this.f906a = new LinkedHashSet();
        this.f907b = new CopyOnWriteArrayList();
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView r5, String r10) {
        super.onLoadResource(r5, r10);
        Iterator r11 = this.f907b.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ((e) r11.next()).onLoadResource(r5, r10);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView r5, String r10) {
        super.onPageCommitVisible(r5, r10);
        Iterator r11 = this.f907b.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ((e) r11.next()).onPageCommitVisible(r5, r10);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView r10, String r11) {
        super.onPageFinished(r10, r11);
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r12 = com.lynx.tasm.utils.e.b("WebViewClientDispatcher:onPageFinished,url=", r11, ",WebViewUrl=");
        String r13 = null;
        if (r10 == null) goto L5;
        String r14 = r10.getUrl();
    L6:
        String r15 = "";
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        r12.append(r14);
        com.bytedance.ies.bullet.service.base.b.a(2, r12.toString(), "XWebKit");
        tc.c r16 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r17 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r17 == null) goto L14;
        com.bytedance.ies.bullet.service.base.d r18 = (com.bytedance.ies.bullet.service.base.d) r17.f6163b.getValue();
        if (r18 == null) goto L14;
        boolean r19 = r18.f5965c;
    L15:
        if (r19 == false) goto L30;
        if (r10 == null) goto L18;
        r13 = r10.getUrl();
    L18:
        if (r13 == null) goto L25;
        LinkedHashSet r20 = this.f906a;
        String r21 = r10.getUrl();
        if (r21 == null) goto L24;
        r15 = r21;
    L24:
        if (r20.contains(r15) == false) goto L25;
    L28:
        com.bytedance.ies.bullet.service.base.b.a(2, "WebViewClientDispatcher:onPageFinished but already finish,url=" + r11, "XWebKit");
        return;
    L25:
        if (r11 == null) goto L30;
        if (this.f906a.contains(r11) == true) goto L28;
    L30:
        if (r10 == null) goto L34;
        String r22 = r10.getUrl();
        if (r22 == null) goto L34;
        this.f906a.add(r22);
    L34:
        if (r11 == null) goto L36;
        this.f906a.add(r11);
    L36:
        Iterator r23 = this.f907b.iterator();
    L38:
        if (r23.hasNext() == false) goto L42;
        ((e) r23.next()).onPageFinished(r10, r11);     // Catch: YieldError -> L43
        goto L38
    L42:
        return;
    L14:
        r19 = true;
        goto L15
    L5:
        r14 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView r5, String r10, Bitmap r11) {
        super.onPageStarted(r5, r10, r11);
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r13 = com.lynx.tasm.utils.e.b("WebViewClientDispatcher:onPageStarted,url=", r10, ",WebViewUrl=");
        String r14 = null;
        if (r5 == null) goto L5;
        String r15 = r5.getUrl();
    L6:
        if (r15 != null) goto L8;
        r15 = "";
    L8:
        r13.append(r15);
        com.bytedance.ies.bullet.service.base.b.a(2, r13.toString(), "XWebKit");
        LinkedHashSet r16 = this.f906a;
        if (r16 == null) goto L24;
        TypeIntrinsics.asMutableCollection(r16).remove(r10);
        if (r5 == null) goto L13;
        r14 = r5.getUrl();
    L13:
        if (r16 == null) goto L22;
        TypeIntrinsics.asMutableCollection(r16).remove(r14);
        Iterator r17 = this.f907b.iterator();
    L16:
        if (r17.hasNext() == false) goto L20;
        ((e) r17.next()).onPageStarted(r5, r10, r11);     // Catch: YieldError -> L25
        goto L16
    L20:
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L5:
        r15 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, int r10, String r11, String r12) {
        super.onReceivedError(r5, r10, r11, r12);
        Iterator r13 = this.f907b.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        ((e) r13.next()).onReceivedError(r5, r10, r11, r12);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r5, HttpAuthHandler r10, String r11, String r12) {
        super.onReceivedHttpAuthRequest(r5, r10, r11, r12);
        Iterator r13 = this.f907b.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        ((e) r13.next()).onReceivedHttpAuthRequest(r5, r10, r11, r12);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r5, WebResourceRequest r10, WebResourceResponse r11) {
        super.onReceivedHttpError(r5, r10, r11);
        Iterator r12 = this.f907b.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ((e) r12.next()).onReceivedHttpError(r5, r10, r11);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r5, SslErrorHandler r10, SslError r11) {
        super.onReceivedSslError(r5, r10, r11);
        Iterator r12 = this.f907b.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ((e) r12.next()).onReceivedSslError(r5, r10, r11);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r5, RenderProcessGoneDetail r10) {
        Iterator r11 = this.f907b.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        return ((e) r11.next()).onRenderProcessGone(r5, r10);
    L9:
        return super.onRenderProcessGone(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r5, String r10) {
        Iterator r11 = this.f907b.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        return ((e) r11.next()).shouldInterceptRequest(r5, r10);
    L9:
        return super.shouldInterceptRequest(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, String r10) {
        Iterator r11 = this.f907b.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        return ((e) r11.next()).shouldOverrideUrlLoading(r5, r10);
    L9:
        return super.shouldOverrideUrlLoading(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r5, WebResourceRequest r10, WebResourceError r11) {
        super.onReceivedError(r5, r10, r11);
        Iterator r12 = this.f907b.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ((e) r12.next()).onReceivedError(r5, r10, r11);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r5, WebResourceRequest r10) {
        Iterator r11 = this.f907b.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        return ((e) r11.next()).shouldInterceptRequest(r5, r10);
    L9:
        return super.shouldInterceptRequest(r5, r10);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, WebResourceRequest r10) {
        Iterator r11 = this.f907b.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        return ((e) r11.next()).shouldOverrideUrlLoading(r5, r10);
    L9:
        return super.shouldOverrideUrlLoading(r5, r10);
    }
}
