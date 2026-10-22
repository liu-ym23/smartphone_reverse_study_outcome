package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.webkit.WebView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements IBaseBrowserService.PageFinishedListener {
    public final /* synthetic */ f.b a;

    public h(f.b r1) {
        this.a = r1;
    }

    public final void onPageFinished(WebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "url");
        this.a.onLoadSuccess();
    }
}
