package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $collector;
    final /* synthetic */ kotlinx.coroutines.flow.g $inner;
    final /* synthetic */ kotlinx.coroutines.sync.f $semaphore;
    int label;

    public ChannelFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.g r5, w r10, kotlinx.coroutines.sync.f r11, Continuation<? super ChannelFlowMerge$collectTo$2$1> r12) {
        this.$inner = r5;
        this.$collector = r10;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new ChannelFlowMerge$collectTo$2$1(this.$inner, this.$collector, null, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L14
        throw null;
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.g r12 = this.$inner;     // Catch: Throwable -> L14
        w r13 = this.$collector;     // Catch: Throwable -> L14
        this.label = 1;     // Catch: Throwable -> L14
        if (r12.collect(r13, this) != r10) goto L13;
        return r10;
    L13:
        throw null;
    L18:
        throw null;
    L14:
        throw null;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((ChannelFlowMerge$collectTo$2$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
