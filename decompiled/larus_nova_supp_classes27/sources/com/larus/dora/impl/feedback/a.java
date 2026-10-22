package com.larus.dora.impl.feedback;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements Function1<Throwable, Unit> {
    public final /* synthetic */ Job a;

    public a(Job r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
        Job.DefaultImpls.cancel$default(this.a, null, 1, null);
        return Unit.INSTANCE;
    }
}
