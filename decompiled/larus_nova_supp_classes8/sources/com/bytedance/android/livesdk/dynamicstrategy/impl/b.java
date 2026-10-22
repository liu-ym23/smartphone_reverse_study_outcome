package com.bytedance.android.livesdk.dynamicstrategy.impl;

import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Runnable {
    public final /* synthetic */ a.g a;
    public final /* synthetic */ KVData b;

    public b(a.g r1, KVData r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KVData r0 = this.b;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        Object r1 = r0.getData();     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        this.a.update(r1);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
