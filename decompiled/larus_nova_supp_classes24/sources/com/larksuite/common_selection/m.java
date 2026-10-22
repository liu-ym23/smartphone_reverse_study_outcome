package com.larksuite.common_selection;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m implements Runnable {
    public final /* synthetic */ i a;

    public m(i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
