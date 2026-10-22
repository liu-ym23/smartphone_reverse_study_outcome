package com.larus.bmhome.social.page.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.LoadStateHolder", f = "FlowPagingManager.kt", i = {0, 0, 1, 2, 2, 2}, l = {298, 231, 308}, m = "checkLoad", n = {"operation", "$this$withLock_u24default$iv", "operation", "operation", "result", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$2"})
public final class LoadStateHolder$checkLoad$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadStateHolder<T, Key> this$0;

    public LoadStateHolder$checkLoad$1(LoadStateHolder<T, Key> r1, Continuation<? super LoadStateHolder$checkLoad$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super g<T, Key>>) this);
    }
}
