package com.obric.assistant.provider.hybrid;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ CountDownLatch b;

    public /* synthetic */ m(AtomicBoolean r1, CountDownLatch r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        AtomicBoolean r0 = this.a;
        CountDownLatch r1 = this.b;
        r0.set(((Boolean) r3).booleanValue());
        r1.countDown();
        return Unit.INSTANCE;
    }
}
