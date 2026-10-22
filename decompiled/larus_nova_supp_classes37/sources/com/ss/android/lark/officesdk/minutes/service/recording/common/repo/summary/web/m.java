package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m extends com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.a {
    public final /* synthetic */ MmSummaryWebHelper b;

    public m(MmSummaryWebHelper r1, com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e r2) {
        this.b = r1;
        super(r2);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r2) {
        super.onPageFinished(r1, r2);
        lvb.a.e(this.b.d, "[onPageFinished]");
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r2, String r3, Bitmap r4) {
        MmSummaryWebHelper r5 = this.b;
        if (r5.g == false) goto L6;
        lvb.a.h(r5.d, "[onPageStarted] ignored after webReady, url=" + r3);
        return;
    L6:
        lvb.a.e(r5.d, "[onPageStarted]");
        MmSummaryWebHelper r6 = this.b;
        r6.g = false;
        r6.h = false;
        r6.b.d();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r3, WebResourceRequest r4, WebResourceError r5) {
        super.onReceivedError(r3, r4, r5);
        String r6 = this.b.d;
        StringBuilder r0 = new StringBuilder("[onReceivedError] error=");
        r0.append(r5);
        r0.append(", isForMainFrame=");
        if (r4 == null) goto L5;
        Boolean r7 = Boolean.valueOf(r4.isForMainFrame());
    L6:
        r0.append(r7);
        lvb.a.b(r6, r0.toString());
        boolean r8 = false;
        if (r4 != null) goto L9;
    L11:
        if (r8 == false) goto L14;
        lvb.a.b(this.b.d, "[onReceivedError] onWebLoadFailed");
        MmSummaryWebHelper r9 = this.b;
        r9.h = true;
        r9.b.f();
        return;
    L14:
        return;
    L9:
        if (r4.isForMainFrame() != true) goto L11;
        r8 = true;
        goto L11
    L5:
        r7 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r4, WebResourceRequest r5, WebResourceResponse r6) {
        super.onReceivedHttpError(r4, r5, r6);
        String r7 = this.b.d;
        StringBuilder r0 = new StringBuilder("[onReceivedHttpError] error=");
        Integer r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.getReasonPhrase();
    L6:
        r0.append(r2);
        r0.append(", isForMainFrame=");
        if (r5 == null) goto L9;
        Boolean r3 = Boolean.valueOf(r5.isForMainFrame());
    L10:
        r0.append(r3);
        lvb.a.b(r7, r0.toString());
        boolean r8 = false;
        if (r5 != null) goto L13;
    L15:
        if (r8 == false) goto L23;
        if (r6 == null) goto L18;
        r1 = Integer.valueOf(r6.getStatusCode());
    L18:
        if (r1 != null) goto L20;
        return;
    L20:
        if (r1.intValue() < 400) goto L25;
        lvb.a.b(this.b.d, "[onReceivedHttpError] statusCode=" + r1 + ", onWebLoadFailed");
        MmSummaryWebHelper r9 = this.b;
        r9.h = true;
        r9.b.f();
        return;
    L25:
        return;
    L23:
        return;
    L13:
        if (r5.isForMainFrame() != true) goto L15;
        r8 = true;
        goto L15
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
