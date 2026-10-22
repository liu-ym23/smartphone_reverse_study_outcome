package com.bytedance.ai.resource;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements Function1<Throwable, Unit> {
    public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<AIManager.b>> a;

    public f(AtomicReference<kotlinx.coroutines.i<AIManager.b>> r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        Throwable r11 = (Throwable) r10;
        this.a.set(null);
        return Unit.INSTANCE;
    }
}
