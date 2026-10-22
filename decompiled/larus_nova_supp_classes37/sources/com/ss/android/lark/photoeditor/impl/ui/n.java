package com.ss.android.lark.photoeditor.impl.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ o b;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    L3:
        if (this.a != (-1)) goto L5;
        ((b) this.b.getView()).z(2131892247);     // Catch: Throwable -> L7
    L5:
        ((b) this.b.getView()).y();     // Catch: Throwable -> L7
    }

    public n(o r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
