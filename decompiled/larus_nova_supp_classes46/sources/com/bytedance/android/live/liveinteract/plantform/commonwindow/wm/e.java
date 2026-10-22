package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ f a;

    public e(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a.a.d0();     // Catch: Throwable -> L6
        int r1 = this.a.a.c0();     // Catch: Throwable -> L6
        this.a.a.V(r0, r1, true);     // Catch: Throwable -> L6
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r2 = this.a.a.d;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        r2.Ma();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
