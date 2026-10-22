package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/h;", "downStream", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {413}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n27#2:408\n28#2:414\n54#3,5:409\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n392#1:408\n392#1:414\n392#1:409,5\n*E\n"})
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements Function3<CoroutineScope, h, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $this_timeoutInternal;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public FlowKt__DelayKt$timeoutInternal$1(long r5, g r10, Continuation<? super FlowKt__DelayKt$timeoutInternal$1> r11) {
        this.$timeout = r5;
        this.$this_timeoutInternal = r10;
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r5, h r10, Continuation<? super Unit> r11) {
        return invoke2(r5, r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008a -> B:20:0x008d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        long r12 = this.J$0;
        kotlinx.coroutines.channels.w r13 = (kotlinx.coroutines.channels.w) this.L$1;
        h r14 = (h) this.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        if (((Boolean) r11).booleanValue() == false) goto L23;
    L17:
        kotlinx.coroutines.selects.f r15 = new kotlinx.coroutines.selects.f(getContext());
        r15.j(r13.i(), new FlowKt__DelayKt$timeoutInternal$1$1$1(r14, null));
        kotlinx.coroutines.selects.b.a(r15, DelayKt.m1627toDelayMillisLRDsOJo(r12), new FlowKt__DelayKt$timeoutInternal$1$1$2(r12, null));
        this.L$0 = r14;
        this.L$1 = r13;
        this.J$0 = r12;
        this.label = 1;
        r11 = r15.g(this);
        if (r11 != r5) goto L21;
        return r5;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        h r17 = (h) this.L$1;
        if (Duration.m1462compareToLRDsOJo(this.$timeout, Duration.Companion.m1566getZEROUwyO8pc()) <= 0) goto L25;
        g r18 = i.e(this.$this_timeoutInternal, 0);
        if ((r18 instanceof kotlinx.coroutines.flow.internal.d) == false) goto L13;
        kotlinx.coroutines.flow.internal.d r19 = (kotlinx.coroutines.flow.internal.d) r18;
    L14:
        if (r19 != null) goto L16;
        r19 = new kotlinx.coroutines.flow.internal.g(r18, 0, null, 14);
    L16:
        kotlinx.coroutines.channels.t r110 = r19.f(r16);
        r12 = this.$timeout;
        r14 = r17;
        r13 = r110;
        goto L17
    L13:
        r19 = null;
        goto L14
    L25:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, h r10, Continuation<? super Unit> r11) {
        FlowKt__DelayKt$timeoutInternal$1 r12 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, r11);
        r12.L$0 = r5;
        r12.L$1 = r10;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
