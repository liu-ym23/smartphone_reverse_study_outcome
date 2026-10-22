package kotlinx.coroutines.channels;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {68, 69}, m = "invokeSuspend", n = {}, s = {})
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<w<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ TickerMode $mode;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17272a = null;

        static {
            int[] r0 = new int[TickerMode.values().length];
            r0[TickerMode.FIXED_PERIOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TickerMode.FIXED_DELAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f17272a = r0;
        }
    }

    TickerChannelsKt$ticker$3(TickerMode r3, long r4, long r6, Continuation<? super TickerChannelsKt$ticker$3> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$mode = r3;
        this.$delayMillis = r4;
        this.$initialDelayMillis = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        TickerChannelsKt$ticker$3 r12 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, r8);
        r12.L$0 = r10;
        return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(w<? super Unit> r3, Continuation<? super Unit> r4) {
        return invoke2((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w<? super Unit> r3, Continuation<? super Unit> r4) {
        return ((TickerChannelsKt$ticker$3) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), TickerChannelsKt$ticker$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L6;
        if (r1 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        ResultKt.throwOnFailure(r12);
    L20:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r12);
        w r13 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        TickerMode r2 = this.$mode;
        int r3 = a.f17272a[r2.ordinal()];
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L20;
        long r5 = this.$delayMillis;
        long r7 = this.$initialDelayMillis;
        z r9 = r13.u();
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (aa.b(r5, r7, r9, r10) != r0) goto L20;
        return r0;
    L16:
        long r4 = this.$delayMillis;
        long r6 = this.$initialDelayMillis;
        z r14 = r13.u();
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (aa.a(r4, r6, r14, r8) != r0) goto L20;
        return r0;
    }
}
