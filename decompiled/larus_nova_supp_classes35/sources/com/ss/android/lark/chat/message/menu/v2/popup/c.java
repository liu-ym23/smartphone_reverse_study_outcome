package com.ss.android.lark.chat.message.menu.v2.popup;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ PopupMenu a;

    public c(PopupMenu r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PopupMenu.b r0 = this.a.e;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.onShow();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
