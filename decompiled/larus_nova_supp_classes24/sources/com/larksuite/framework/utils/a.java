package com.larksuite.framework.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;
import wgb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AndroidThrottle b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        this.b.e.a(Collections.singletonList(this.a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(AndroidThrottle r1, b.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
