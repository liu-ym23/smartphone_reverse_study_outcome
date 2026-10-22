package com.obric.flow.cardlistpage.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.usecase.AddCardUseCase", f = "AddCardUseCase.kt", i = {0, 0, 0}, l = {140}, m = "persistSortIndexes", n = {"this", "items", "i"}, s = {"L$0", "L$1", "I$0"})
final class AddCardUseCase$persistSortIndexes$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public AddCardUseCase$persistSortIndexes$1(a r5, Continuation<? super AddCardUseCase$persistSortIndexes$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
