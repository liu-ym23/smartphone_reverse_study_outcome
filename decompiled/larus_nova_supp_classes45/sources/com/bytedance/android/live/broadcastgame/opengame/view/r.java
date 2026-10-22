package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements Runnable {
    public final /* synthetic */ OPPluginMoreDialog a;

    public r(OPPluginMoreDialog r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PluginContext r0 = this.a.F;     // Catch: Throwable -> L6
        DataCenter r1 = r0.i;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.put("show_toolbar_red_dot_by_collect_game", r0.m.i);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
