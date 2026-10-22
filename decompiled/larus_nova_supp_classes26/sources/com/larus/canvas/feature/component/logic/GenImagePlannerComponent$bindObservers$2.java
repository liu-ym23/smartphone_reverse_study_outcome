package com.larus.canvas.feature.component.logic;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$bindObservers$2", f = "GenImagePlannerComponent.kt", i = {}, l = {1853}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImagePlannerComponent a;

        public a(GenImagePlannerComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            ky8.g r4 = (ky8.g) r2;
            final GenImagePlannerComponent r5 = this.a;
            com.larus.canvas.feature.component.logic.helper.f.a(r5.p, new h1(r5));
            return Unit.INSTANCE;
        }
    }

    public GenImagePlannerComponent$bindObservers$2(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImagePlannerComponent$bindObservers$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GenImagePlannerComponent r6 = this.this$0;
        StateFlowImpl r2 = r6.m;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
