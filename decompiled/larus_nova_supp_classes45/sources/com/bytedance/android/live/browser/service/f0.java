package com.bytedance.android.live.browser.service;

import android.app.Activity;
import android.view.ViewParent;
import android.webkit.WebView;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 implements ca.b {
    public final com.bytedance.android.live.browser.u a;

    public f0(com.bytedance.android.live.browser.u r2) {
        Intrinsics.checkNotNullParameter(r2, "h5Service");
        this.a = r2;
    }

    public final boolean G1(ViewParent r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return r2 instanceof LiveVerticalViewPager;
    }

    public final void m0(Activity r12, WebView r13, String r14, String r15, String r16, String r17, long r18) {
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r13, "webView");
        if (r14 == null) goto L6;
        TTMiddlewareLiveSDK.hostMiddlewareService().action().webViewDownload(r12, r13, r14, r15, r16, r17, r18, this.a.f(r14));
        return;
    }
}
