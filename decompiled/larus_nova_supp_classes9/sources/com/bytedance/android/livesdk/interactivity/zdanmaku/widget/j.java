package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements Runnable {
    public final /* synthetic */ PortraitZDanmakuPresenter a;

    public j(PortraitZDanmakuPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.n.k();     // Catch: Throwable -> L4
        this.a.n.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
