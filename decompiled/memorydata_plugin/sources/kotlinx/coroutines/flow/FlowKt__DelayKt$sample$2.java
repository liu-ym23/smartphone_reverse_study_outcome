package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {415}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class FlowKt__DelayKt$sample$2<T> extends SuspendLambda implements Function3<kotlinx.coroutines.al, j<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ i<T> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    FlowKt__DelayKt$sample$2(long r3, i<? extends T> r5, Continuation<? super FlowKt__DelayKt$sample$2> r6) {
        i<T> r7 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$periodMillis = r3;
        this.$this_sample = r7;
        super(3, r8);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Object r4, Continuation<? super Unit> r5) {
        return invoke((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(kotlinx.coroutines.al r4, j<? super T> r5, Continuation<? super Unit> r6) {
        kotlinx.coroutines.al r7 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__DelayKt$sample$2 r0 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, r9);
        r0.L$0 = r7;
        r0.L$1 = r8;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        kotlinx.coroutines.channels.y<Unit> r2 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(this.L$3, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r5 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.y r6 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        j r7 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L10:
        if (r5.element == kotlinx.coroutines.flow.internal.s.c) goto L15;
        kotlinx.coroutines.selects.l r15 = new kotlinx.coroutines.selects.l(getContext());
        kotlinx.coroutines.selects.c r8 = (kotlinx.coroutines.selects.c) ZeusTransformUtils.preCheckCast(r15, kotlinx.coroutines.selects.c.class, "com.obric.memorydata.plugin");
        r8.a(r6.k(), (Function2) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$sample$2$1$1(r5, r2, null), Function2.class, "com.obric.memorydata.plugin"));
        r8.a(r2.j(), (Function2) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$sample$2$1$2(r5, r7, null), Function2.class, "com.obric.memorydata.plugin"));
        this.L$0 = r7;
        this.L$1 = r6;
        this.L$2 = r5;
        this.L$3 = r2;
        this.label = 1;
        if (r15.a(this) != r0) goto L10;
        return r0;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.al r16 = (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        j r3 = (j) ZeusTransformUtils.preCheckCast(this.L$1, j.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.y r9 = kotlinx.coroutines.channels.u.a(r16, null, -1, (Function2) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        kotlinx.coroutines.channels.y<Unit> r17 = k.a(r16, this.$periodMillis);
        r7 = r3;
        r2 = r17;
        r6 = r9;
        r5 = r10;
        goto L10
    }
}
