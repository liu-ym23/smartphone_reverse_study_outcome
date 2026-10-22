package com.larus.bmhome.chat.model.repo;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g0 implements Function1 {
    public final /* synthetic */ BotRepo a;
    public final /* synthetic */ BotRepo$a b;
    public final /* synthetic */ Deferred c;

    public /* synthetic */ g0(BotRepo r1, BotRepo$a r2, Deferred r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        BotRepo r0 = this.a;
        BotRepo$a r1 = this.b;
        Deferred r2 = this.c;
        Throwable r5 = (Throwable) r4;
        r0.b.remove(r1, r2);
        return Unit.INSTANCE;
    }
}
