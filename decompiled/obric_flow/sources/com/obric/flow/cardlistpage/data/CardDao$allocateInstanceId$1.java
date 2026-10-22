package com.obric.flow.cardlistpage.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.data.CardDao", f = "CardDao.kt", i = {0, 1, 2}, l = {46, 47, 48}, m = "allocateInstanceId$suspendImpl", n = {"$this", "$this", "instanceId"}, s = {"L$0", "L$0", "I$0"})
final class CardDao$allocateInstanceId$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public CardDao$allocateInstanceId$1(a r5, Continuation<? super CardDao$allocateInstanceId$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, this);
    }
}
