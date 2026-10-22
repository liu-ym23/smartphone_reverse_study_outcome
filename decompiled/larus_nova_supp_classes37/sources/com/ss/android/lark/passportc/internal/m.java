package com.ss.android.lark.passportc.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements Runnable {
    public final /* synthetic */ Function1<f0c.b, Unit> a;
    public final /* synthetic */ f0c.b b;

    public m(com.ss.android.lark.passportc.ffi.a.C0096a r1, f0c.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
