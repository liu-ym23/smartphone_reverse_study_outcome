package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.webkit.WebView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a3 implements IBaseBrowserService.PageFinishedListener {
    public final /* synthetic */ TopRightBannerWidget a;
    public final /* synthetic */ BannerInRoomCollection.BannerInfo b;
    public final /* synthetic */ long c;

    public final void onPageFinished(WebView r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "webView");
        Intrinsics.checkNotNullParameter(r8, "url");
        TopRightBannerWidget.wq(this.a, this.b, r8, this.c, true);
    }

    public a3(TopRightBannerWidget r1, BannerInRoomCollection.BannerInfo r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
