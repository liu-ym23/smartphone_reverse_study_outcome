package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.v;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements Runnable {
    public final /* synthetic */ SeatAnimationView a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i b;

    public i(SeatAnimationView r1, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v r0 = this.a.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.c(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
