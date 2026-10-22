package com.ss.android.lark.flow.feed.sidebar.human;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ OfficeSidebarHumanFeedController a;

    public b(OfficeSidebarHumanFeedController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OfficeSidebarHumanFeedController r0 = this.a;     // Catch: Throwable -> L4
        int r1 = OfficeSidebarHumanFeedController.E;     // Catch: Throwable -> L4
        r0.A();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
