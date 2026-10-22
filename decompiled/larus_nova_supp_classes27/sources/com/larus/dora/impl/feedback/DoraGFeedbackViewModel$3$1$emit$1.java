package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel$3$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {152, 158}, m = "emit", n = {}, s = {})
public final class DoraGFeedbackViewModel$3$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGFeedbackViewModel.AnonymousClass3.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraGFeedbackViewModel$3$1$emit$1(DoraGFeedbackViewModel.AnonymousClass3.AnonymousClass1<? super T> r1, Continuation<? super DoraGFeedbackViewModel$3$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
