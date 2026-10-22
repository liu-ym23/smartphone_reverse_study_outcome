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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/h;", "downstream", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {412}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n54#2,5:408\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n278#1:408,5\n*E\n"})
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, h, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ g $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FlowKt__DelayKt$sample$2(long r5, g r10, Continuation<? super FlowKt__DelayKt$sample$2> r11) {
        this.$periodMillis = r5;
        this.$this_sample = r10;
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r5, h r10, Continuation<? super Unit> r11) {
        return invoke2(r5, r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        kotlinx.coroutines.channels.w r12 = (kotlinx.coroutines.channels.w) this.L$3;
        Ref.ObjectRef r13 = (Ref.ObjectRef) this.L$2;
        kotlinx.coroutines.channels.w r14 = (kotlinx.coroutines.channels.w) this.L$1;
        h r15 = (h) this.L$0;
        ResultKt.throwOnFailure(r11);
    L10:
        if (r13.element == kotlinx.coroutines.flow.internal.b.d) goto L15;
        kotlinx.coroutines.selects.f r16 = new kotlinx.coroutines.selects.f(getContext());
        r16.j(r14.i(), new FlowKt__DelayKt$sample$2$1$1(r13, r12, null));
        r16.j(r12.h(), new FlowKt__DelayKt$sample$2$1$2(r13, r15, null));
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r13;
        this.L$3 = r12;
        this.label = 1;
        if (r16.g(this) != r5) goto L10;
        return r5;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        h r18 = (h) this.L$1;
        kotlinx.coroutines.channels.t r19 = kotlinx.coroutines.channels.s.b(r17, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        kotlinx.coroutines.channels.t r110 = kotlinx.coroutines.channels.s.b(r17, 0, new FlowKt__DelayKt$fixedPeriodTicker$1(this.$periodMillis, null), 1);
        r15 = r18;
        r12 = r110;
        r14 = r19;
        r13 = r20;
        goto L10
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, h r10, Continuation<? super Unit> r11) {
        FlowKt__DelayKt$sample$2 r12 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, r11);
        r12.L$0 = r5;
        r12.L$1 = r10;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
