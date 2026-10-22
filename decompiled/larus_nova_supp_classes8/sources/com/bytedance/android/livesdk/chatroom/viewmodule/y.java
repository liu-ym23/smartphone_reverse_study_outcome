package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdkapi.banner.BannerData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y implements Runnable {
    public final /* synthetic */ BannerData a;
    public final /* synthetic */ BottomRightBannerWidget b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.VW(this.a.getData());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public y(BottomRightBannerWidget r1, BannerData r2) {
        this.b = r1;
        this.a = r2;
    }
}
