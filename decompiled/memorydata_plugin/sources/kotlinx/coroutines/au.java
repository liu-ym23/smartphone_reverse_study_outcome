package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0016\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class au {
    public static final long a(long r3) {
        boolean r0 = Duration.m2781isPositiveimpl(r3);
        if (r0 != true) goto L5;
        Duration.Companion r1 = Duration.Companion;
        return Duration.m2765getInWholeMillisecondsimpl(Duration.m2783plusLRDsOJo(r3, DurationKt.toDuration(999999, DurationUnit.NANOSECONDS)));
    L5:
        if (r0 == true) goto L9;
        return 0;
    L9:
        throw new NoWhenBranchMatchedException();
    }

    public static final Object a(long r4, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (r4 <= 0) goto L5;
        o r0 = new o(IntrinsicsKt.intercepted(r7), 1);
        r0.e();
        n<? super Unit> r1 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        if (r4 >= Long.MAX_VALUE) goto L9;
        a(r1.getContext()).a(r4, r1);
    L9:
        Object r5 = r0.h();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L13:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r5;
    L16:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static final Object a(Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, DelayKt$awaitCancellation$1.class) == false) goto L7;
        DelayKt$awaitCancellation$1 r0 = (DelayKt$awaitCancellation$1) ZeusTransformUtils.preCheckCast(r6, DelayKt$awaitCancellation$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L12;
        ResultKt.throwOnFailure(r7);
    L20:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        o r4 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r4.e();
        n r8 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin");
        Object r9 = r4.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"));
    L17:
        if (r9 != r2) goto L20;
        return r2;
    L7:
        r0 = new DelayKt$awaitCancellation$1(r6);
        goto L8
    }

    public static final at a(CoroutineContext r3) {
        CoroutineContext.Element r4 = ((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin")).get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r4, at.class) == false) goto L5;
        at r5 = (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return aq.a();
    L5:
        r5 = null;
        goto L6
    }
}
