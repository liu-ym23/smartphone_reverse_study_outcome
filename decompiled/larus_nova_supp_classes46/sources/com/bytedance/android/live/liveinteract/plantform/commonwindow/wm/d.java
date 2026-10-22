package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ BaseMultiLinkWindowManager.j a;

    public d(BaseMultiLinkWindowManager.j r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.D.f();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
