package com.larus.dora.impl;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Callable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ e(d r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.a.invoke();
        return Unit.INSTANCE;
    }
}
