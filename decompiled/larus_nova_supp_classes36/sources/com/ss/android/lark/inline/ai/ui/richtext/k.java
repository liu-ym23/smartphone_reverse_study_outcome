package com.ss.android.lark.inline.ai.ui.richtext;

import android.content.Context;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import st5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements ys5.c {
    public final /* synthetic */ RichtextPreviewWebview a;

    public final o getServiceManager() {
        return new o();
    }

    public final Context getWebViewContext() {
        return this.a.getContext();
    }

    public final LarkWebView getWebView() {
        return this.a;
    }

    public k(RichtextPreviewWebview r1) {
        this.a = r1;
    }
}
