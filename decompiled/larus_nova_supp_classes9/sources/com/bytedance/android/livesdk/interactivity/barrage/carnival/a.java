package com.bytedance.android.livesdk.interactivity.barrage.carnival;

import com.bytedance.android.live.core.utils.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Runnable {
    public final /* synthetic */ DanmakuCarnivalManager a;

    public a(DanmakuCarnivalManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StateMachine<DanmakuCarnivalManager.State, DanmakuCarnivalManager.Event, DanmakuCarnivalManager.SideEffect> r0 = this.a.v;     // Catch: Throwable -> L10
        DanmakuCarnivalManager.Event.End r1 = DanmakuCarnivalManager.Event.End.INSTANCE;     // Catch: Throwable -> L10
        StateMachine.a r2 = StateMachine.c;     // Catch: Throwable -> L10
        r0.d(r1, null);     // Catch: Throwable -> L10
        DanmakuCarnivalManager r3 = this.a;     // Catch: Throwable -> L10
        DanmakuCarnivalManager.a r4 = r3.k;     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        f52.b r5 = r3.j;     // Catch: Throwable -> L10
        if (r5 == null) goto L7;
        r5.d(r4);     // Catch: Throwable -> L10
    L7:
        r3.k = null;     // Catch: Throwable -> L10
    L8:
        this.a.o();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
