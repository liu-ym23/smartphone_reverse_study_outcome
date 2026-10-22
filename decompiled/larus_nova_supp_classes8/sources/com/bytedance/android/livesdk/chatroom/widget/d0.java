package com.bytedance.android.livesdk.chatroom.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ FansRankListAnimationWidget a;

    public d0(FansRankListAnimationWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FansRankListAnimationWidget r0 = this.a;     // Catch: Throwable -> L4
        int r1 = FansRankListAnimationWidget.o;     // Catch: Throwable -> L4
        r0.wq();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
