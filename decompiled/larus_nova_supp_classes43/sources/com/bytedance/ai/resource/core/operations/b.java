package com.bytedance.ai.resource.core.operations;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Function1<Throwable, Unit> {
    public final /* synthetic */ AtomicReference<i<String>> a;

    public b(AtomicReference<i<String>> r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        Throwable r11 = (Throwable) r10;
        this.a.set(null);
        return Unit.INSTANCE;
    }
}
