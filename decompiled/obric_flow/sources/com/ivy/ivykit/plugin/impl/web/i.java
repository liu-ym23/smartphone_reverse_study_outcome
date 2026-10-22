package com.ivy.ivykit.plugin.impl.web;

import android.webkit.WebSettings;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends tc.a implements rc.c {
    public static void d(WebSettings r5, WebView r10, rb.b r11) {
        Intrinsics.checkNotNullParameter(r5, "settings");
        Intrinsics.checkNotNullParameter(r10, "webView");
        Intrinsics.checkNotNullParameter(r11, "providerFactory");
        r5.setJavaScriptEnabled(true);
        r5.setLoadWithOverviewMode(true);
        r5.setSupportZoom(true);
        r5.setBuiltInZoomControls(true);
        r5.setUseWideViewPort(true);
        r5.setDomStorageEnabled(true);
        r5.setAllowFileAccess(true);
        r5.setBlockNetworkImage(false);
    }
}
