package com.obric.aikernel.res.task;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.task.NamedTaskScheduler", f = "NamedTaskScheduler.kt", i = {0, 0, 0, 1, 1}, l = {29, 14}, m = "executeWith", n = {"tag", "block", "$this$withLock$iv", "tag", "$this$withLock$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
final class NamedTaskScheduler$executeWith$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NamedTaskScheduler this$0;

    NamedTaskScheduler$executeWith$1(NamedTaskScheduler r10, Continuation<? super NamedTaskScheduler$executeWith$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
