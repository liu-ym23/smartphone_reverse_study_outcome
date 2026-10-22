package com.bytedance.android.live.liveinteract.revenue.game;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements Runnable {
    public final /* synthetic */ LinkMicGameWidget a;

    public o(LinkMicGameWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkMicGameWidget r0 = this.a;     // Catch: Throwable -> L7
        int r1 = LinkMicGameWidget.w;     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        LinkMicGameContext r2 = LinkMicGameContext.Companion.getContext();     // Catch: Throwable -> L7
        if (r2 == null) goto L5;
        r2.setGameScores(null);     // Catch: Throwable -> L7
    L5:
        r0.getStore().d0(ti0.a.b, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
