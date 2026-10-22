package com.obric.assistant.state.impl.multitask.producer;

import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricAigcGenerationStateProducer$initProducer$1", f = "ObricAigcGenerationStateProducer.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAigcGenerationStateProducer$initProducer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ il9.a $manager;
    int label;
    final /* synthetic */ ObricAigcGenerationStateProducer this$0;

    public /* synthetic */ class a implements FlowCollector, FunctionAdapter {
        public final /* synthetic */ ObricAigcGenerationStateProducer a;

        public a(ObricAigcGenerationStateProducer r1) {
            this.a = r1;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(2, this.a, ObricAigcGenerationStateProducer.class, "handleTaskList", "handleTaskList(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(Object r2, Continuation r3) {
            ObricAigcGenerationStateProducer r0 = this.a;
            Object r4 = ObricAigcGenerationStateProducer.a(r0, (List) r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public ObricAigcGenerationStateProducer$initProducer$1(il9.a r1, ObricAigcGenerationStateProducer r2, Continuation<? super ObricAigcGenerationStateProducer$initProducer$1> r3) {
        this.$manager = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAigcGenerationStateProducer$initProducer$1(this.$manager, this.this$0, r4);
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
        StateFlowImpl r6 = this.$manager.I0();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
