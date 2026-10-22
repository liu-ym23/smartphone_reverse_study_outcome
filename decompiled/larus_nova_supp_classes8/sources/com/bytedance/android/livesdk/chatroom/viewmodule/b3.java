package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.webkit.WebView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b3 implements IBaseBrowserService.PageErrorListener {
    public final /* synthetic */ TopRightBannerWidget a;

    public b3(TopRightBannerWidget r1) {
        this.a = r1;
    }

    public final void onReceiveError(WebView r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "msg");
        TopRightBannerWidget.xq(this.a, r3, r4, true);
    }
}
