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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$bindObservers$3", f = "GenImagePlannerComponent.kt", i = {}, l = {1865}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$bindObservers$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImagePlannerComponent a;

        public a(GenImagePlannerComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            final int r5 = ((Number) r3).intValue();
            final GenImagePlannerComponent r6 = this.a;
            com.larus.canvas.feature.component.logic.helper.f.a(r6.p, new i1(r5, r6));
            return Unit.INSTANCE;
        }
    }

    public GenImagePlannerComponent$bindObservers$3(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$bindObservers$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImagePlannerComponent$bindObservers$3(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GenImagePlannerComponent r6 = this.this$0;
        int r2 = GenImagePlannerComponent.W;
        com.larus.canvas.feature.component.resultdisplay.image.r r7 = r6.Z3();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.b1 r8 = r7.OP();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
