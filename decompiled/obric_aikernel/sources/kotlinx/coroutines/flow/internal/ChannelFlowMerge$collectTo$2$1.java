package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ p<Object> $collector;
    final /* synthetic */ kotlinx.coroutines.flow.c<Object> $inner;
    final /* synthetic */ kotlinx.coroutines.sync.b $semaphore;
    int label;

    ChannelFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.c<Object> r10, p<Object> r11, kotlinx.coroutines.sync.b r12, Continuation<? super ChannelFlowMerge$collectTo$2$1> r13) {
        this.$inner = r10;
        this.$collector = r11;
        this.$semaphore = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChannelFlowMerge$collectTo$2$1(this.$inner, this.$collector, this.$semaphore, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ChannelFlowMerge$collectTo$2$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, kotlin.Unit] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 != 1) goto L10;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
    L15:
        this.$semaphore.release();
        ChannelFlowMerge$collectTo$2$1 this = Unit.INSTANCE;
        return this;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.flow.c<Object> r13 = this.$inner;     // Catch: Throwable -> L7
        p<Object> r14 = this.$collector;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r13.a(r14, this) != r11) goto L15;
        return r11;
    L7:
        th = move-exception;
        this.$semaphore.release();
        throw th;
    }
}
