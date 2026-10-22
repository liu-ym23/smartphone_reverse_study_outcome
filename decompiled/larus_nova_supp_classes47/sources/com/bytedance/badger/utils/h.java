package com.bytedance.badger.utils;

import com.bytedance.badger.monitor.TriggerStage;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements Runnable {
    public final /* synthetic */ String a;

    public h(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.badger.C.b r0 = x64.b.a;     // Catch: Throwable -> L4
        x64.b.a(new x64.l(TriggerStage.periodic, 16, false, null, this.a, null, 44), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
