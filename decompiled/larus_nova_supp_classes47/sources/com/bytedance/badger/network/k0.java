package com.bytedance.badger.network;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function1 b;

    public k0(Function0 r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = Result.constructor-impl(this.a.invoke());     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.exceptionOrNull-impl(r0);     // Catch: Throwable -> L12
        if (r1 == null) goto L15;
        Function1 r2 = this.b;     // Catch: Throwable -> L12
        if (r2 == null) goto L20;
        Unit r3 = (Unit) r2.invoke(r1);     // Catch: Throwable -> L12
        return;
    L20:
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    L21:
        return;
    L4:
        th = move-exception;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L12
        goto L6
    }
}
