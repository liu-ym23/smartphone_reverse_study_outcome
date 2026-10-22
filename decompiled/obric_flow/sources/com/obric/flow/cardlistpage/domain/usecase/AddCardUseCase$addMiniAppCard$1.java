package com.obric.flow.cardlistpage.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.usecase.AddCardUseCase", f = "AddCardUseCase.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {98, 116, 125}, m = "addMiniAppCard$suspendImpl", n = {"$this", "input", "currentCards", "insertPosition", "cardId", "$this", "currentCards", "insertPosition", "card", "items"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0"})
final class AddCardUseCase$addMiniAppCard$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public AddCardUseCase$addMiniAppCard$1(a r5, Continuation<? super AddCardUseCase$addMiniAppCard$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, null, null, null, this);
    }
}
