package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements Runnable {
    public final /* synthetic */ SonicGamePlugin a;

    public h(SonicGamePlugin r1) {
        this.a = r1;
    }

    public final void a() {
        if (((SimplePanelStateDispatchService) this.a.n.getValue()).d().c.a == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        GameCastStrategy r1 = this.a.K.h(true);
        int r2 = g.b[r1.ordinal()];
        if (r2 != 1) goto L13;
        this.a.K.v();
        return;
    L13:
        if (r2 != 2) goto L22;
        f r3 = this.a.w();
        if (r3 == null) goto L20;
        ((a) r3).g(true);
        return;
    L20:
        return;
    L22:
        return;
    L5:
        if (((SimplePanelStateDispatchService) this.a.n.getValue()).d().c.b == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
