package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h1 implements Runnable {
    public final /* synthetic */ ShowCountDownWidget a;

    public h1(ShowCountDownWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ShowCountDownWidget.wq(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
