package com.lark.kmp.rustclient.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DefaultRustClientDefinition implements r {
    public final Lazy a;
    public final Lazy b;

    @Override // com.lark.kmp.rustclient.internal.r
    public final void b() {
    }

    @Override // com.lark.kmp.rustclient.internal.r
    public final CoroutineDispatcher a() {
        return (CoroutineDispatcher) this.b.getValue();
    }

    @Override // com.lark.kmp.rustclient.internal.r
    public final CoroutineDispatcher c() {
        return (CoroutineDispatcher) this.a.getValue();
    }

    public DefaultRustClientDefinition() {
        this.a = LazyKt.lazy(DefaultRustClientDefinition$pushDispatcher$2.INSTANCE);
        this.b = LazyKt.lazy(DefaultRustClientDefinition$asyncDispatcher$2.INSTANCE);
    }
}
