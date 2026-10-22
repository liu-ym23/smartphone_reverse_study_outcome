package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/channels/u;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1", f = "Delay.kt", i = {0, 1, 2}, l = {StatusLine.HTTP_TEMP_REDIRECT, 309, 310}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class FlowKt__DelayKt$fixedPeriodTicker$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.u, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    private /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$fixedPeriodTicker$1(long r5, Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$1> r10) {
        this.$delayMillis = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        FlowKt__DelayKt$fixedPeriodTicker$1 r11 = new FlowKt__DelayKt$fixedPeriodTicker$1(this.$delayMillis, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(kotlinx.coroutines.channels.u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005e -> B:15:0x003f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        kotlinx.coroutines.channels.u r12 = (kotlinx.coroutines.channels.u) this.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        long r13 = this.$delayMillis;
        this.L$0 = r12;
        this.label = 3;
        if (DelayKt.delay(r13, this) == r5) goto L20;
    L15:
        kotlinx.coroutines.channels.t r14 = (kotlinx.coroutines.channels.t) r12;
        r14.getClass();
        Unit r15 = Unit.INSTANCE;
        this.L$0 = r12;
        this.label = 2;
        if (r14.d.r(r15, this) != r5) goto L18;
        return r5;
    L20:
        return r5;
    L11:
        r12 = (kotlinx.coroutines.channels.u) this.L$0;
        ResultKt.throwOnFailure(r10);
        goto L15
    L12:
        ResultKt.throwOnFailure(r10);
        r12 = (kotlinx.coroutines.channels.u) this.L$0;
        long r16 = this.$delayMillis;
        this.L$0 = r12;
        this.label = 1;
        if (DelayKt.delay(r16, this) != r5) goto L15;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.u r5, Continuation<? super Unit> r10) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
