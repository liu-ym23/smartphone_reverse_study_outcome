package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\\\u0010\b\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\n\"\b\b\u0001\u0010\u000b*\u0002H\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0002¢\u0006\u0002\u0010\u0012\u001aR\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0015\u001aW\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0018\u0010\u0015\u001aG\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@¢\u0006\u0002\u0010\u0015\u001aL\u0010\u0019\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e¢\u0006\u0002\b\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", OaidModel.KEY_TIME, "", "delay", "Lkotlinx/coroutines/Delay;", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", LocationMonitorConst.TIMEOUT, "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class da {
    public static final <T> Object a(long r2, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r4, Continuation<? super T> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if (r2 <= 0) goto L9;
        Object r3 = a(new cz(r2, r7), r6);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L7:
        return r3;
    L9:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    private static final <U, T extends U> Object a(cz<U, ? super T> r7, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r8) {
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r8, Function2.class, "com.obric.memorydata.plugin");
        CoroutineContext r0 = r7.c.getContext();
        ca.a((bx) ZeusTransformUtils.preCheckCast(r7, bx.class, "com.obric.memorydata.plugin"), au.a(r0).a(r7.f17306b, (Runnable) ZeusTransformUtils.preCheckCast(r7, Runnable.class, "com.obric.memorydata.plugin"), r7.getContext()));
        return kotlinx.coroutines.a.b.b((kotlinx.coroutines.internal.af) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.internal.af.class, "com.obric.memorydata.plugin"), r7, r9);
    }

    public static final TimeoutCancellationException a(long r2, at r4, bx r5) {
        at r6 = (at) ZeusTransformUtils.wrapperContextForParams(r4, at.class, "com.obric.memorydata.plugin");
        bx r7 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, av.class) == false) goto L5;
        av r8 = (av) ZeusTransformUtils.preCheckCast(r6, av.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 == null) goto L9;
        Duration.Companion r0 = Duration.Companion;
        String r9 = r8.a(DurationKt.toDuration(r2, DurationUnit.MILLISECONDS));
        if (r9 == null) goto L9;
    L11:
        return new TimeoutCancellationException(r9, r7);
    L9:
        r9 = "Timed out waiting for " + r2 + " ms";
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, kotlinx.coroutines.cz] */
    public static final <T> Object b(long r8, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Function2 r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, TimeoutKt$withTimeoutOrNull$1.class) == false) goto L7;
        TimeoutKt$withTimeoutOrNull$1 r0 = (TimeoutKt$withTimeoutOrNull$1) ZeusTransformUtils.preCheckCast(r13, TimeoutKt$withTimeoutOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        long r9 = r0.J$0;
        Ref.ObjectRef r15 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$0, Function2.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: TimeoutCancellationException -> L14
        return r14;
    L14:
        e = e;
    L32:
        if (e.coroutine != r15.element) goto L34;
        return null;
    L34:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        if (r8 > 0) goto L21;
        return null;
    L21:
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        r0.L$0 = r12;     // Catch: TimeoutCancellationException -> L29
        r0.L$1 = r17;     // Catch: TimeoutCancellationException -> L29
        r0.J$0 = r8;     // Catch: TimeoutCancellationException -> L29
        r0.label = 1;     // Catch: TimeoutCancellationException -> L29
        ?? r5 = (T) new cz(r8, (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"));
        r17.element = r5;     // Catch: TimeoutCancellationException -> L29
        Object r18 = a(r5, r12);     // Catch: TimeoutCancellationException -> L29
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: TimeoutCancellationException -> L29
    L25:
        if (r18 != r2) goto L28;
        return r2;
    L28:
        return r18;
    L29:
        e = e;
        r15 = r17;
    L7:
        r0 = new TimeoutKt$withTimeoutOrNull$1(r13);
        goto L8
    }
}
