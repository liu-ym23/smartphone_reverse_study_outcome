package com.larus.canvas.feature.component.logic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2$2", f = "GenImagePlannerComponent.kt", i = {0, 1}, l = {1032, 1046, 1070}, m = "emit", n = {"updateData", "updateData"}, s = {"L$0", "L$0"})
public final class GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GenImagePlannerComponent$startGenerateAndObserve$2.AnonymousClass2<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1(GenImagePlannerComponent$startGenerateAndObserve$2.AnonymousClass2<? super T> r1, Continuation<? super GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1> r2) {
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
