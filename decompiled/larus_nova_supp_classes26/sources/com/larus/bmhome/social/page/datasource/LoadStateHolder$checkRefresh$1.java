package com.larus.bmhome.social.page.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.LoadStateHolder", f = "FlowPagingManager.kt", i = {0, 0, 2, 4, 4}, l = {298, 266, 308, 274, 318}, m = "checkRefresh", n = {"$this$withLock_u24default$iv", "retry", "$this$withLock_u24default$iv", "result", "$this$withLock_u24default$iv"}, s = {"L$0", "Z$0", "L$0", "L$0", "L$1"})
public final class LoadStateHolder$checkRefresh$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadStateHolder<T, Key> this$0;

    public LoadStateHolder$checkRefresh$1(LoadStateHolder<T, Key> r1, Continuation<? super LoadStateHolder$checkRefresh$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, (Continuation<? super g<T, Key>>) this);
    }
}
