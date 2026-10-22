package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements Runnable {
    public final /* synthetic */ BaseMultiLinkWindowManager a;
    public final /* synthetic */ tf0.j b;
    public final /* synthetic */ boolean c;

    public h(BaseMultiLinkWindowManager r1, tf0.j r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseMultiLinkWindowManager r0 = this.a;     // Catch: Throwable -> L11
        int r1 = BaseMultiLinkWindowManager.H;     // Catch: Throwable -> L11
        int r2 = r0.d0();     // Catch: Throwable -> L11
        int r3 = r0.c0();     // Catch: Throwable -> L11
        r0.V(r2, r3, true);     // Catch: Throwable -> L11
        r0.E0(true, r2, r3);     // Catch: Throwable -> L11
        BaseMultiLinkWindowManager r4 = this.a;     // Catch: Throwable -> L11
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r5 = r4.d;     // Catch: Throwable -> L11
        if (r5 == null) goto L6;
        r5.U3((com.bytedance.android.live.liveinteract.plantform.commonwindow.m) this.b, r4.d0(), this.a.c0());     // Catch: Throwable -> L11
    L6:
        if (this.c == false) goto L14;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = this.a.d;     // Catch: Throwable -> L11
        if (r6 == null) goto L18;
        r6.b7(0);     // Catch: Throwable -> L11
        return;
    L18:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
