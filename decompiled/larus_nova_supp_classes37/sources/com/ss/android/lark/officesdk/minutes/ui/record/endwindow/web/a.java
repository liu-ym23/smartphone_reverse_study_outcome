package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.a {
    public final /* synthetic */ MmEndWindowWebHelper b;

    public a(MmEndWindowWebHelper r1, com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e r2) {
        this.b = r1;
        super(r2);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r4, String r5) {
        super.onPageFinished(r4, r5);
        int r6 = bwb.b.a;
        bwb.b.g(MmUiLogScene.WEB, "onPageFinished", null, this.b.f(), 4);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r4, WebResourceRequest r5, WebResourceError r6) {
        super.onReceivedError(r4, r5, r6);
        int r7 = bwb.b.a;
        MmUiLogScene r8 = MmUiLogScene.WEB;
        StringBuilder r0 = new StringBuilder("error=");
        r0.append(r6);
        r0.append(", isForMainFrame=");
        if (r5 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r5.isForMainFrame());
    L6:
        r0.append(r1);
        bwb.b.d(r8, "onReceivedError", r0.toString(), this.b.f());
        if (r5 == null) goto L11;
        boolean r9 = r5.isForMainFrame();
        boolean r10 = true;
        if (r9 != true) goto L11;
    L12:
        if (r10 == true) goto L14;
        return;
    L14:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        if (r6 == null) goto L17;
        int r11 = r6.getErrorCode();
    L18:
        this.b.e.f(r11);
        return;
    L17:
        r11 = -1;
    L11:
        r10 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r5, WebResourceRequest r6, WebResourceResponse r7) {
        super.onReceivedHttpError(r5, r6, r7);
        int r8 = bwb.b.a;
        MmUiLogScene r9 = MmUiLogScene.WEB;
        StringBuilder r0 = new StringBuilder("error=");
        Integer r1 = null;
        if (r7 == null) goto L5;
        String r2 = r7.getReasonPhrase();
    L6:
        r0.append(r2);
        r0.append(", isForMainFrame=");
        if (r6 == null) goto L9;
        Boolean r3 = Boolean.valueOf(r6.isForMainFrame());
    L10:
        r0.append(r3);
        bwb.b.d(r9, "onReceivedHttpError", r0.toString(), this.b.f());
        if (r6 == null) goto L15;
        boolean r4 = true;
        if (r6.isForMainFrame() != true) goto L15;
    L16:
        if (r4 == false) goto L24;
        if (r7 == null) goto L19;
        r1 = Integer.valueOf(r7.getStatusCode());
    L19:
        if (r1 != null) goto L21;
        return;
    L21:
        if (r1.intValue() < 400) goto L26;
        bwb.b.d(r9, "onReceivedHttpError", "statusCode=" + r1, this.b.f());
        this.b.e.f(r1.intValue());
        return;
    L26:
        return;
    L24:
        return;
    L15:
        r4 = false;
        goto L16
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
