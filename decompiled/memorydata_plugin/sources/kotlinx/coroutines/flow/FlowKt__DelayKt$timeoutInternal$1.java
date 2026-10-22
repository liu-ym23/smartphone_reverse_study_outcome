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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.time.Duration;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downStream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {416}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
final class FlowKt__DelayKt$timeoutInternal$1<T> extends SuspendLambda implements Function3<kotlinx.coroutines.al, j<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<T> $this_timeoutInternal;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    FlowKt__DelayKt$timeoutInternal$1(long r3, i<? extends T> r5, Continuation<? super FlowKt__DelayKt$timeoutInternal$1> r6) {
        i<T> r7 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$timeout = r3;
        this.$this_timeoutInternal = r7;
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
        FlowKt__DelayKt$timeoutInternal$1 r0 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, r9);
        r0.L$0 = r7;
        r0.L$1 = r8;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00a7 -> B:14:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r5 = this.J$0;
        kotlinx.coroutines.channels.y r2 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        j r7 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L15:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
    L11:
        kotlinx.coroutines.selects.l r14 = new kotlinx.coroutines.selects.l(getContext());
        kotlinx.coroutines.selects.c r8 = (kotlinx.coroutines.selects.c) ZeusTransformUtils.preCheckCast(r14, kotlinx.coroutines.selects.c.class, "com.obric.memorydata.plugin");
        r8.a(r2.k(), (Function2) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$timeoutInternal$1$1$1(r7, null), Function2.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.selects.b.b(r8, r5, (Function1) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$timeoutInternal$1$1$2(r5, null), Function1.class, "com.obric.memorydata.plugin"));
        this.L$0 = r7;
        this.L$1 = r2;
        this.J$0 = r5;
        this.label = 1;
        r13 = r14.a(this);
        if (r13 != r0) goto L15;
        return r0;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.al r15 = (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        j r3 = (j) ZeusTransformUtils.preCheckCast(this.L$1, j.class, "com.obric.memorydata.plugin");
        if (Duration.m2746compareToLRDsOJo(this.$timeout, Duration.Companion.m2850getZEROUwyO8pc()) <= 0) goto L19;
        kotlinx.coroutines.channels.y r16 = k.a(k.a(this.$this_timeoutInternal, 0, null, 2, null), r15);
        r5 = this.$timeout;
        r7 = r3;
        r2 = r16;
        goto L11
    L19:
        throw new TimeoutCancellationException("Timed out immediately");
    }
}
