package kotlinx.coroutines.flow;

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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1", f = "Delay.kt", i = {0, 1, 2}, l = {307, 309, 310}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class FlowKt__DelayKt$fixedPeriodTicker$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.w<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    private /* synthetic */ Object L$0;
    int label;

    FlowKt__DelayKt$fixedPeriodTicker$1(long r3, Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$delayMillis = r3;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__DelayKt$fixedPeriodTicker$1 r0 = new FlowKt__DelayKt$fixedPeriodTicker$1(this.$delayMillis, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.w<? super Unit> r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.w<? super Unit> r3, Continuation<? super Unit> r4) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), FlowKt__DelayKt$fixedPeriodTicker$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0086 -> B:15:0x005b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        kotlinx.coroutines.channels.w r2 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L18:
        long r6 = this.$delayMillis;
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 3;
        if (kotlinx.coroutines.au.a(r6, r10) == r0) goto L20;
    L15:
        kotlinx.coroutines.channels.z r11 = r2.u();
        Unit r4 = Unit.INSTANCE;
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 2;
        if (r11.send(r4, r7) != r0) goto L18;
        return r0;
    L20:
        return r0;
    L11:
        r2 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        goto L15
    L12:
        ResultKt.throwOnFailure(r9);
        r2 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        long r8 = this.$delayMillis;
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 1;
        if (kotlinx.coroutines.au.a(r8, r12) != r0) goto L15;
        return r0;
    }
}
