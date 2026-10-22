package com.bytedance.reparo;

import com.bytedance.reparo.core.o;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h implements Runnable {
    public final /* synthetic */ ReparoInfoActivity a;

    @Override // java.lang.Runnable
    public final void run() {
        Map r0 = o.c().e();     // Catch: Throwable -> L4
        this.a.b.clear();     // Catch: Throwable -> L4
        this.a.b.addAll(((ConcurrentHashMap) r0).values());     // Catch: Throwable -> L4
        this.a.a.notifyDataSetChanged();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(ReparoInfoActivity r1) {
        this.a = r1;
    }
}
