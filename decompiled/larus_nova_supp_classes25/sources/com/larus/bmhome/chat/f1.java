package com.larus.bmhome.chat;

import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f1 implements Function1 {
    public final /* synthetic */ h1 a;

    public /* synthetic */ f1(h1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        h1 r0 = this.a;
        Pair r7 = (Pair) r6;
        FLogger.a.i(r0.f, "currentShowIndex=" + r7);
        r0.j = ((Number) r7.getFirst()).intValue();
        return Unit.INSTANCE;
    }
}
