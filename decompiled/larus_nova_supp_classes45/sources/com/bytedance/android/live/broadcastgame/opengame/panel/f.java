package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.view.View;
import android.view.Window;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Runnable {
    public final /* synthetic */ FullScreenOpenPanel a;

    public f(FullScreenOpenPanel r1) {
        this.a = r1;
    }

    public final void b() {
        int r0 = q.a;
        q.h("FullScreenOpenPanel " + a(this.a.getWindow()).getWidth() + ':' + a(this.a.getWindow()).getHeight());
        PanelType.PANEL_TYPE_PORTRAIT.updateWH(a(this.a.getWindow()).getWidth(), a(this.a.getWindow()).getHeight());
        PanelType.PANEL_TYPE_LANDSCAPE.updateWH(a(this.a.getWindow()).getHeight(), a(this.a.getWindow()).getWidth());
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }
}
