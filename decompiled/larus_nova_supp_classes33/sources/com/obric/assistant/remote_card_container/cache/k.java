package com.obric.assistant.remote_card_container.cache;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ j a;

    public /* synthetic */ k(j r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        String r2 = m.c.toJson(r0);     // Catch: Throwable -> L5
        m.b.storeString(r0.c(), r2);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
