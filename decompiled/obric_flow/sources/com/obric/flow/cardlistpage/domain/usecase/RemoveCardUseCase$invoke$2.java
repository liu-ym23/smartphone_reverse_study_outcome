package com.obric.flow.cardlistpage.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.domain.usecase.RemoveCardUseCase", f = "RemoveCardUseCase.kt", i = {0, 0}, l = {22}, m = "invoke$suspendImpl", n = {"$this", "widgetId"}, s = {"L$0", "I$0"})
final class RemoveCardUseCase$invoke$2 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public RemoveCardUseCase$invoke$2(f r5, Continuation<? super RemoveCardUseCase$invoke$2> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return f.a(this.this$0, null, 0, this);
    }
}
