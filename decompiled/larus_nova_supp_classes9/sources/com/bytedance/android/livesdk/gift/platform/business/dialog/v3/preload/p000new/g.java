package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<V> implements Callable {
    public final /* synthetic */ Function0 a;

    public g(Function0 r1) {
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
