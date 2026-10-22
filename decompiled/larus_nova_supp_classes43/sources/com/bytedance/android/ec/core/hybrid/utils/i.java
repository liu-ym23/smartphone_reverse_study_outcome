package com.bytedance.android.ec.core.hybrid.utils;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements pd.i {
    public final /* synthetic */ ti.k a;

    public i(ti.k r1) {
        this.a = r1;
    }

    @Override // pd.i
    public final void onPageFinished(WebView r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.g(r10, r11);
        return;
    }

    @Override // pd.i
    public final void onPageStarted(WebView r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPageStart(r10, r11);
        return;
    }

    @Override // pd.i
    public final void onReceivedError(WebView r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        ti.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.s(r10, r11, r12);
        return;
    }
}
