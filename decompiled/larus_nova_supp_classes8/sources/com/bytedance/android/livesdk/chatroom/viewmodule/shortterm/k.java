package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.webkit.WebView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements IBaseBrowserService.PageErrorListener {
    public final /* synthetic */ f a;

    public k(f r1, f.d r2) {
        this.a = r1;
    }

    public final void onReceiveError(WebView r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "webView");
        Intrinsics.checkNotNullParameter(r8, "url");
        Intrinsics.checkNotNullParameter(r9, "msg");
        int r10 = com.bytedance.android.livesdk.chatroom.utils.a.a;
        int r0 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
        ActivityHybridMonitor.ContainerType r2 = ActivityHybridMonitor.ContainerType.WEB;
        f r11 = this.a;
        com.bytedance.android.livesdk.chatroom.utils.a.c(r0, "onReceiveError", r2, ((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) r11).d, String.valueOf(r11.o), r8);
    }
}
