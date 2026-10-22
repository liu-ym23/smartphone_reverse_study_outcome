package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {68, 69}, m = "invokeSuspend", n = {}, s = {})
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ TickerMode $mode;
    private /* synthetic */ Object L$0;
    int label;

    public TickerChannelsKt$ticker$3(TickerMode r5, long r10, long r11, Continuation<? super TickerChannelsKt$ticker$3> r12) {
        this.$mode = r5;
        this.$delayMillis = r10;
        this.$initialDelayMillis = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        TickerChannelsKt$ticker$3 r12 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L9;
        if (r10 == 1) goto L6;
        if (r10 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        ResultKt.throwOnFailure(r11);
    L21:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r11);
        u r12 = (u) this.L$0;
        TickerMode r13 = this.$mode;
        int r14 = y.f18818a[r13.ordinal()];
        if (r14 == 1) goto L17;
        if (r14 != 2) goto L16;
        long r15 = this.$delayMillis;
        long r16 = this.$initialDelayMillis;
        t r17 = (t) r12;
        r17.getClass();
        this.label = 2;
        if (p.b(r15, r16, r17, this) != r5) goto L21;
        return r5;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        long r18 = this.$delayMillis;
        long r19 = this.$initialDelayMillis;
        t r110 = (t) r12;
        r110.getClass();
        this.label = 1;
        if (p.c(r18, r19, r110, this) != r5) goto L21;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((TickerChannelsKt$ticker$3) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
