package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements Runnable {
    public final /* synthetic */ LinkMicGameWidget a;
    public final /* synthetic */ boolean b;

    public n(LinkMicGameWidget r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.s.run();     // Catch: Throwable -> L6
        if (this.b == false) goto L9;
        com.bytedance.android.live.broadcastgame.api.xplay.n r0 = com.bytedance.android.live.broadcastgame.api.xplay.n.b;     // Catch: Throwable -> L6
        r0.m(XplayScene.TalkRoom);     // Catch: Throwable -> L6
        r0.g();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
