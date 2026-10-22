package com.obric.assistant.obric_action.handler.prompt;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements Runnable {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ kotlinx.coroutines.i<j> b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Ref.BooleanRef r1, kotlinx.coroutines.i<? super j> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.b(this.a, this.b, new j("dismissed", 14));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
