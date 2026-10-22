package com.larus.suggest.impl.wcb.render;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements Function1<Throwable, Unit> {
    public final /* synthetic */ AtomicBoolean a;

    public d(AtomicBoolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.set(true);
        return Unit.INSTANCE;
    }
}
