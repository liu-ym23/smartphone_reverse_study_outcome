package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongMicSeatView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ ILinkPlayerInfoBridge b;

    public l(k r1, ILinkPlayerInfoBridge r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RequestSongMicSeatView r0 = this.a.a;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.p();     // Catch: Throwable -> L9
    L5:
        RequestSongMicSeatView r1 = this.a.a;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.l(this.b, 0);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
