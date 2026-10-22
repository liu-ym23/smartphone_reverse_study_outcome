package com.bytedance.android.btm.bridge;

import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements b {
    public c() {
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final String getHybridContainerType(g66.c r1) {
        if (obtainView(r1) == null) goto L5;
        return "ttwebview";
    L5:
        return "unkown";
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final String getPageUrl(g66.c r10) {
        WebView r11 = (WebView) r10.c(WebView.class);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getUrl();
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final View obtainView(g66.c r10) {
        return (View) r10.c(WebView.class);
    }
}
