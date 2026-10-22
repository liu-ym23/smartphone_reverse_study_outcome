package com.obric.flow.cardlistpage.mvi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nBaseMviComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMviComponent.kt\ncom/obric/flow/cardlistpage/mvi/BaseMviComponent$collectState$1$2$emit$1\n*L\n1#1,99:1\n*E\n"})
public final class BaseMviComponent$collectState$1$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public BaseMviComponent$collectState$1$2$emit$1(b r5, Continuation<? super BaseMviComponent$collectState$1$2$emit$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
