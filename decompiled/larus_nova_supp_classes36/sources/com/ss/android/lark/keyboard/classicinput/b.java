package com.ss.android.lark.keyboard.classicinput;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ a b;

    public b(View r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.c.d(this.b.a().e());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
