package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {152}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n126#2,15:142\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n119#1:142,15\n*E\n"})
final class FlowKt__LimitKt$transformWhile$1 extends SuspendLambda implements Function2<d<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ c<Object> $this_transformWhile;
    final /* synthetic */ Function3<d<Object>, Object, Continuation<? super Boolean>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$transformWhile$1(c<Object> r10, Function3<? super d<Object>, Object, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super FlowKt__LimitKt$transformWhile$1> r12) {
        this.$this_transformWhile = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__LimitKt$transformWhile$1 r12 = new FlowKt__LimitKt$transformWhile$1(this.$this_transformWhile, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(d<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<Object> r10, Continuation<? super Unit> r11) {
        return ((FlowKt__LimitKt$transformWhile$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L11;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r13 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: AbortFlowException -> L8
    L20:
        return Unit.INSTANCE;
    L8:
        e = e;
    L18:
        kotlinx.coroutines.flow.internal.j.a(e, r13);
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        d r14 = (d) this.L$0;
        c<Object> r15 = this.$this_transformWhile;
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r16 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this.$transform, r14);
        this.L$0 = r16;     // Catch: AbortFlowException -> L16
        this.label = 1;     // Catch: AbortFlowException -> L16
        if (r15.a(r16, this) != r11) goto L20;
        return r11;
    L16:
        e = e;
        r13 = r16;
        goto L18
    }
}
