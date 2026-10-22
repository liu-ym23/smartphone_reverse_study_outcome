package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<l<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ TickerMode $mode;
    private /* synthetic */ Object L$0;
    int label;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10312a = null;

        static {
            int[] r10 = new int[TickerMode.values().length];
            r10[TickerMode.FIXED_PERIOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[TickerMode.FIXED_DELAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10312a = r10;
        }
    }

    TickerChannelsKt$ticker$3(TickerMode r10, long r11, long r12, Continuation<? super TickerChannelsKt$ticker$3> r13) {
        this.$mode = r10;
        this.$delayMillis = r11;
        this.$initialDelayMillis = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        TickerChannelsKt$ticker$3 r12 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<? super Unit> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<? super Unit> r10, Continuation<? super Unit> r11) {
        return ((TickerChannelsKt$ticker$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L9;
        if (r12 == 1) goto L6;
        if (r12 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        ResultKt.throwOnFailure(r11);
    L20:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r11);
        l r13 = (l) this.L$0;
        TickerMode r14 = this.$mode;
        int r15 = a.f10312a[r14.ordinal()];
        if (r15 == 1) goto L16;
        if (r15 != 2) goto L20;
        long r16 = this.$delayMillis;
        long r17 = this.$initialDelayMillis;
        n r18 = r13.getChannel();
        this.label = 2;
        if (TickerChannelsKt.a(r16, r17, r18, this) != r10) goto L20;
        return r10;
    L16:
        long r19 = this.$delayMillis;
        long r20 = this.$initialDelayMillis;
        n r110 = r13.getChannel();
        this.label = 1;
        if (TickerChannelsKt.b(r19, r20, r110, this) != r10) goto L20;
        return r10;
    }
}
