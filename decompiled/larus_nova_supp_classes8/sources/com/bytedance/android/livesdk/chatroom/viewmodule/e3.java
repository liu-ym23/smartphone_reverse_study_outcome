package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e3 implements Runnable {
    public final /* synthetic */ TopRightBannerWidget.f a;
    public final /* synthetic */ BannerInRoomCollection b;

    public e3(TopRightBannerWidget.f r1, BannerInRoomCollection r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TopRightBannerWidget r0 = this.a.a;     // Catch: Throwable -> L4
        BannerInRoomCollection.BannerInfo r1 = this.b.getTopRightBanner();     // Catch: Throwable -> L4
        int r2 = TopRightBannerWidget.q;     // Catch: Throwable -> L4
        r0.Eq(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
