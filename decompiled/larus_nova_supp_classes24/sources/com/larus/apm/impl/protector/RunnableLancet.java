package com.larus.apm.impl.protector;

import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class RunnableLancet {
    public RunnableLancet() {
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public void run() {
        Origin.callVoid();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
