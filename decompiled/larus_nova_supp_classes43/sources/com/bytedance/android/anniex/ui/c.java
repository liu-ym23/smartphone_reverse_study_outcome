package com.bytedance.android.anniex.ui;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<V> implements Callable {
    public final /* synthetic */ Function0<Unit> a;

    public c(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.a.invoke();
    }
}
