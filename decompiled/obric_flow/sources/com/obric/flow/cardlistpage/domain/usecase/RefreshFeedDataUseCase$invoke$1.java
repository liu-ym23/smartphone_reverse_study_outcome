package com.obric.flow.cardlistpage.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.usecase.RefreshFeedDataUseCase", f = "RefreshFeedDataUseCase.kt", i = {0, 1, 2, 2}, l = {30, 32, 47}, m = "invoke$suspendImpl", n = {"$this", "$this", "$this", "list"}, s = {"L$0", "L$0", "L$0", "L$1"})
final class RefreshFeedDataUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    public RefreshFeedDataUseCase$invoke$1(e r5, Continuation<? super RefreshFeedDataUseCase$invoke$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return e.a(this.this$0, this);
    }
}
