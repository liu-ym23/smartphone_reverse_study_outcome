package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c3 extends com.bytedance.android.live.browser.d0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ TopRightBannerWidget b;
    public final /* synthetic */ BannerInRoomCollection.BannerInfo c;
    public final /* synthetic */ long d;

    public final void a() {
        TopRightBannerWidget r0 = this.b;
        int r1 = TopRightBannerWidget.q;
        r0.getClass();
        ALogger.e("TopRightBannerWidget", "onLynxFallback");
    }

    public final void g(View r8) {
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        TopRightBannerWidget.wq(this.b, this.c, this.a, this.d, false);
    }

    public final void f(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        TopRightBannerWidget.xq(this.b, this.a, r4, false);
    }

    public c3(String r1, TopRightBannerWidget r2, BannerInRoomCollection.BannerInfo r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
