package com.bytedance.android.live.room.discovery;

import android.webkit.WebView;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 implements IBrowserService.PageErrorListener {
    public final /* synthetic */ TopLeftActivityBannerWidget a;

    public q0(TopLeftActivityBannerWidget r1) {
        this.a = r1;
    }

    public final void onReceiveError(WebView r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
        ((Widget) this.a).contentView.setVisibility(4);
    }
}
