package com.bytedance.android.annie.business.container;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends WebViewClient {
    public final /* synthetic */ AnnieXLiveDialog a;

    public d(AnnieXLiveDialog r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r10, String r11) {
        super.onPageFinished(r10, r11);
        i r0 = this.a.d;
        if (r0 == null) goto L8;
        n r1 = r0.r;
        if (r1 == null) goto L9;
        r1.onPageFinished(r10, r11);
        return;
    L9:
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r10, String r11, Bitmap r12) {
        super.onPageStarted(r10, r11, r12);
        i r0 = this.a.d;
        if (r0 == null) goto L8;
        n r1 = r0.r;
        if (r1 == null) goto L9;
        r1.onPageStarted(r10, r11, r12);
        return;
    L9:
        return;
    }
}
