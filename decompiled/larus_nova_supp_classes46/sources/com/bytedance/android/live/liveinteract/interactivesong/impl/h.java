package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.android.livesdk.chatroom.model.interact.OrderSingItemAction;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements Runnable {
    public final /* synthetic */ InteractiveSongWidget a;
    public final /* synthetic */ String b;

    public h(InteractiveSongWidget r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InteractiveSongWidget r0 = this.a;     // Catch: Throwable -> L4
        pf0.a r8 = new pf0.a(this.b, 0, Integer.valueOf(OrderSingItemAction.ORDER_SING_START_ITEM.getValue()), null, null, 24);     // Catch: Throwable -> L4
        int r1 = InteractiveSongWidget.C;     // Catch: Throwable -> L4
        r0.Lq(r8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
