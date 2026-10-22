package z2;

import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import d3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m extends WebViewClient {
    public final /* synthetic */ l a;

    public m(l r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r10) {
        super.onPageFinished(r1, r10);
        com.bytedance.ai.applet.base.log.b r11 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[EmbedWebViewService] onPageFinished: ".concat(o.a(r10)));
        c r12 = this.a.d;
        if (r12 == null) goto L6;
        r12.onPageFinished();
        return;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r10, RenderProcessGoneDetail r11) {
        l r0 = this.a;
        int r1 = l.n;
        r0.getClass();
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L10;
        String r13 = "crashed";
    L11:
        com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r15 = new StringBuilder("[EmbedWebViewService] render process ");
        r15.append(r13);
        r15.append(", url: ");
        if (r10 == null) goto L14;
        String r16 = r10.getUrl();
    L15:
        r15.append(o.a(r16));
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", r15.toString(), null);
        r0.e = null;
        w r17 = r0.f;
        if (r17 == null) goto L18;
        r17.g();
    L18:
        r0.f = null;
        return true;
    L14:
        r16 = null;
        goto L15
    L10:
        r13 = "killed by system";
        goto L11
    L5:
        if (r11.didCrash() != true) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r10, WebResourceRequest r11) {
        if (r11 == null) goto L17;
        Uri r12 = r11.getUrl();
        if (r12 == null) goto L18;
        String r13 = r12.toString();
        if (r13 == null) goto L19;
        l r0 = this.a;
        int r1 = l.n;
        if (r0.d(r13) == true) goto L15;
        com.bytedance.ai.applet.base.log.b r14 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] navigation blocked: ".concat(o.a(r13)), null);
        this.a.e();
        c r15 = this.a.d;
        if (r15 == null) goto L14;
        r15.b(-4, "Domain not allowed");
    L14:
        return true;
    L15:
        return false;
    L19:
        return true;
    L18:
        return true;
    L17:
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        super.onReceivedError(r10, r11, r12);
        if (r12 == null) goto L14;
        l r13 = this.a;
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r1 = new StringBuilder("[EmbedWebViewService] onReceivedError: code=");
        r1.append(r12.getErrorCode());
        r1.append(", desc=");
        r1.append(r12.getDescription());
        r1.append(", url=");
        if (r11 == null) goto L9;
        Uri r14 = r11.getUrl();
        if (r14 == null) goto L9;
        String r15 = r14.toString();
    L10:
        r1.append(o.a(r15));
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", r1.toString(), null);
        c r16 = r13.d;
        if (r16 == null) goto L15;
        r16.b(r12.getErrorCode(), r12.getDescription().toString());
        return;
    L15:
        return;
    L9:
        r15 = null;
        goto L10
    }
}
