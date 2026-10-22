package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<l0, kotlinx.coroutines.flow.d<Object>, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowCoroutineKt$scopedFlow$1$1(Function3<? super l0, ? super kotlinx.coroutines.flow.d<Object>, ? super Continuation<? super Unit>, ? extends Object> r10, kotlinx.coroutines.flow.d<Object> r11, Continuation<? super FlowCoroutineKt$scopedFlow$1$1> r12) {
        this.$block = r10;
        this.$this_unsafeFlow = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowCoroutineKt$scopedFlow$1$1 r12 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        l0 r13 = (l0) this.L$0;
        Function3<l0, kotlinx.coroutines.flow.d<Object>, Continuation<? super Unit>, Object> r14 = this.$block;
        kotlinx.coroutines.flow.d<Object> r15 = this.$this_unsafeFlow;
        this.label = 1;
        if (r14.invoke(r13, r15, this) != r11) goto L12;
        return r11;
    }
}
