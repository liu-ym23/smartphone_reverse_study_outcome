package com.volcengine.zeus;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Zeus$a implements Runnable {
    public final /* synthetic */ String a;

    @Override // java.lang.Runnable
    public final void run() {
        Zeus.loadPlugin(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public Zeus$a(String r1) {
        this.a = r1;
    }
}
