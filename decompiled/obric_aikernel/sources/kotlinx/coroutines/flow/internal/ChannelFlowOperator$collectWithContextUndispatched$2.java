package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowOperator$collectWithContextUndispatched$2<T> extends SuspendLambda implements Function2<kotlinx.coroutines.flow.d<? super T>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowOperator<S, T> this$0;

    ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator<S, T> r10, Continuation<? super ChannelFlowOperator$collectWithContextUndispatched$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelFlowOperator$collectWithContextUndispatched$2 r12 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
        return invoke((kotlinx.coroutines.flow.d) r10, r11);
    }

    public final Object invoke(kotlinx.coroutines.flow.d<? super T> r10, Continuation<? super Unit> r11) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2<T> for r3v4 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r3.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r4);
    L11:
        kotlin.Unit r3 = kotlin.Unit.INSTANCE;
        return r3;
    L6:
        java.lang.IllegalStateException r3 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r3;
    L8:
        kotlin.ResultKt.throwOnFailure(r4);
        java.lang.Object r4 = r3.L$0;
        kotlinx.coroutines.flow.d<? super T> r4 = (kotlinx.coroutines.flow.d) r4;
        kotlinx.coroutines.flow.internal.ChannelFlowOperator<S, T> r1 = r3.this$0;
        r3.label = 1;
        kotlinx.coroutines.flow.d<? super T> r4 = r4;
        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3;
        java.lang.Object r3 = r1.p(r4, r3);
        if (r3 != r0) goto L11;
        return r0;
    }
}
