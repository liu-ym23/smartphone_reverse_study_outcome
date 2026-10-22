package com.ss.android.lark.mention.base.impl.atselector.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ AtView a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.mSearchEt.requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(AtView r1) {
        this.a = r1;
    }
}
