package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {0, 0, 1, 1}, l = {592, 608}, m = "bindBudsAndClearIfNecessaryWithRetry", n = {"$this$bindBudsAndClearIfNecessaryWithRetry", "needClear", "$this$bindBudsAndClearIfNecessaryWithRetry", "needClear"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
public final class DoraAdapterExtKt$bindBudsAndClearIfNecessaryWithRetry$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$bindBudsAndClearIfNecessaryWithRetry$1(Continuation<? super DoraAdapterExtKt$bindBudsAndClearIfNecessaryWithRetry$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraAdapterExtKt.c(null, false, this);
    }
}
