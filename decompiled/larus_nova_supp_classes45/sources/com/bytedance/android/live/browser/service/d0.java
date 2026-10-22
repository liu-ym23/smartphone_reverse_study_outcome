package com.bytedance.android.live.browser.service;

import android.webkit.WebView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 implements aa.b {
    public d0() {
    }

    public final boolean isTTWebView() {
        return jc1.k.n(IMiddlewareHostBusiness.class).isTTWebView();
    }

    public final JSONObject g0(WebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        return jc1.k.n(IMiddlewareHostBusiness.class).getTTWebViewPerfTiming(r2);
    }

    public final void y1(WebView r3) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        if (jc1.k.n(IMiddlewareHostBusiness.class).isTTWebView() == false) goto L6;
        r3.evaluateJavascript("ttwebview:/*enableTTLogEvent*/;", null);
        return;
    }
}
