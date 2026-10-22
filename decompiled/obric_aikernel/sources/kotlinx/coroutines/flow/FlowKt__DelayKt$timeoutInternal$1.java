package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {TypedValues.CycleType.TYPE_WAVE_OFFSET}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n31#2:416\n32#2:425\n55#3,8:417\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n401#1:416\n401#1:425\n401#1:417,8\n*E\n"})
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements Function3<kotlinx.coroutines.l0, d<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ c<Object> $this_timeoutInternal;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    FlowKt__DelayKt$timeoutInternal$1(long r10, c<Object> r11, Continuation<? super FlowKt__DelayKt$timeoutInternal$1> r12) {
        this.$timeout = r10;
        this.$this_timeoutInternal = r11;
        super(3, r12);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.l0 r10, d<Object> r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.l0 r10, d<Object> r11, Continuation<? super Unit> r12) {
        FlowKt__DelayKt$timeoutInternal$1 r13 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0074 -> B:14:0x0077). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        long r13 = this.J$0;
        ReceiveChannel r14 = (ReceiveChannel) this.L$1;
        d r15 = (d) this.L$0;
        ResultKt.throwOnFailure(r10);
    L15:
        if (((Boolean) r10).booleanValue() == false) goto L17;
    L11:
        SelectImplementation r16 = new SelectImplementation(getContext());
        r16.e(r14.d(), new FlowKt__DelayKt$timeoutInternal$1$1$1(r15, null));
        kotlinx.coroutines.selects.a.b(r16, r13, new FlowKt__DelayKt$timeoutInternal$1$1$2(r13, null));
        this.L$0 = r15;
        this.L$1 = r14;
        this.J$0 = r13;
        this.label = 1;
        r10 = r16.r(this);
        if (r10 != r11) goto L15;
        return r11;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.l0 r17 = (kotlinx.coroutines.l0) this.L$0;
        d r18 = (d) this.L$1;
        if (Duration.m1383compareToLRDsOJo(this.$timeout, Duration.Companion.m1487getZEROUwyO8pc()) <= 0) goto L19;
        ReceiveChannel r19 = e.B(e.c(this.$this_timeoutInternal, 0, null, 2, null), r17);
        r13 = this.$timeout;
        r15 = r18;
        r14 = r19;
        goto L11
    L19:
        throw new TimeoutCancellationException("Timed out immediately");
    }
}
