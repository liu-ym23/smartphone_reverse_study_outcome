package com.bytedance.android.annie.pia;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge2.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends com.bytedance.android.annie.card.web.e {
    public final h47.a b;
    public final l0 c;

    @Override // com.bytedance.android.annie.card.web.e
    public final void y() {
        this.b.onDestroy();
    }

    public d(h47.a r10) {
        Intrinsics.checkNotNullParameter(r10, "innerLifeCycle");
        super(null);
        this.b = r10;
        this.c = new l0();
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void A(WebView r10) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        this.b.a(r10);
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void f(String r1, ValueCallback<String> r10) {
        this.c.E(r1);
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void g(View r1, String r10) {
        if (r10 == null) goto L5;
        this.b.onLoadFinish();
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void s(WebView r10, String r11) {
        if (r11 == null) goto L4;
        this.b.loadUrl(r11);
    L4:
        this.c.s(r10, r11);
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void v(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return;
    L6:
        if (r11.isForMainFrame() == false) goto L15;
        if (r12 != null) goto L10;
        this.b.b();
        return;
    L10:
        h47.a r13 = this.b;
        r12.getStatusCode();
        r12.getReasonPhrase();
        r13.b();
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void k(View r1, String r10, Bitmap r11, boolean r12) {
        if (r10 == null) goto L5;
        this.b.onLoadStart();
        return;
    }
}
