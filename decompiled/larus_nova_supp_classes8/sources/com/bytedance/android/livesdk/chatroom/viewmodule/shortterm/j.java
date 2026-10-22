package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.webkit.WebView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements IBaseBrowserService.PageFinishedListener {
    public final /* synthetic */ f a;
    public final /* synthetic */ f.b b;

    public j(f r1, f.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onPageFinished(WebView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "url");
        this.b.onLoadSuccess();
        this.a.l(true);
        com.bytedance.android.livesdk.chatroom.monitor.f r4 = this.a.k;
        if (r4 == null) goto L8;
        r4.d("ON_PAGE_FINISHED");
        if (r4.i != 2) goto L9;
        r4.g();
        return;
    L9:
        return;
    }
}
