package com.obric.flow.cardlistpage.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.usecase.AddCardUseCase", f = "AddCardUseCase.kt", i = {0, 0, 0, 0, 0, 0, 1}, l = {71, 87}, m = "invoke", n = {"this", "currentCards", "insertPosition", "newCard", "spanX", "spanY", "items"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0"})
final class AddCardUseCase$invoke$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public AddCardUseCase$invoke$1(a r5, Continuation<? super AddCardUseCase$invoke$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(0, 0, 0, 0, null, null, this);
    }
}
