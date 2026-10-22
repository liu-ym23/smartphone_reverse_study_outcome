package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class l0 implements com.lynx.tasm.base.e {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ com.lynx.tasm.base.e b;

    public /* synthetic */ l0(AtomicBoolean r1, k0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.lynx.tasm.base.e
    public final void accept(Object r5) {
        AtomicBoolean r0 = this.a;
        com.lynx.tasm.base.e r1 = this.b;
        r0 r6 = (r0) r5;
        if (r0.compareAndSet(false, true) == false) goto L11;
        r1.accept(r6);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        LLog.e("LynxMemoryCollector", "Failed to handle Lynx memory usage fetcher result: " + th.getMessage());
        return;
    }
}
