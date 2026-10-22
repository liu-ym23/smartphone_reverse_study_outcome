package com.ss.android.lark.chat.message.menu.v2.popup;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements Runnable {
    public final /* synthetic */ PopupMenuRootView a;
    public final /* synthetic */ PopupMenuContentContainer b;

    public m(PopupMenuRootView r1, PopupMenuContentContainer r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.removeView(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
