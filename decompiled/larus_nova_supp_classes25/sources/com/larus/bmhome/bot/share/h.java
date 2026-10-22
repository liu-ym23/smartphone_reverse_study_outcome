package com.larus.bmhome.bot.share;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements Function1<Boolean, Unit> {
    public final /* synthetic */ Continuation<Boolean> a;

    public h(SafeContinuation r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Boolean r3 = Boolean.valueOf(((Boolean) r2).booleanValue());
        this.a.resumeWith(Result.constructor-impl(r3));
        return Unit.INSTANCE;
    }
}
