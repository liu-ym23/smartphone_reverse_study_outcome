package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.an;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aX\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tH\u0080@¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¨\u0006\u0012"}, d2 = {"withContextUndispatched", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", "Lkotlin/coroutines/CoroutineContext;", EventBody.KEY_VALUE, "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class e {
    public static final <T, V> Object a(CoroutineContext r3, V r4, Object r5, Function2<? super V, ? super Continuation<? super T>, ? extends Object> r6, Continuation<? super T> r7) {
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        Object r11 = an.a(r8, r5);
        Continuation r0 = (Continuation) ZeusTransformUtils.preCheckCast(new w(r10, r8), Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(r9, BaseContinuationImpl.class) == true) goto L6;
        Object r12 = IntrinsicsKt.wrapWithContinuationImpl(r9, r4, r0);     // Catch: Throwable -> L11
    L7:
        an.b(r8, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L10:
        return r12;
    L6:
        r12 = ((Function2) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r9, 2), Function2.class, "com.obric.memorydata.plugin")).invoke(r4, r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        an.b(r8, r11);
        throw th;
    }

    public static /* synthetic */ Object a(CoroutineContext r1, Object r2, Object r3, Function2 r4, Continuation r5, int r6, Object r7) {
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r1, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r3 = an.a(r8);
    L6:
        return a(r8, r2, r3, r9, r10);
    }

    public static final <T> d<T> a(kotlinx.coroutines.flow.i<? extends T> r9) {
        kotlinx.coroutines.flow.i r3 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L5;
        d<T> r10 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L8;
        return r10;
    L8:
        return (d) ZeusTransformUtils.preCheckCast(new h(r3, null, 0, null, 14, null), d.class, "com.obric.memorydata.plugin");
    L5:
        r10 = null;
        goto L6
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.j a(kotlinx.coroutines.flow.j r2, CoroutineContext r3) {
        return b((kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private static final <T> kotlinx.coroutines.flow.j<T> b(kotlinx.coroutines.flow.j<? super T> r2, CoroutineContext r3) {
        kotlinx.coroutines.flow.j<T> r4 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, v.class) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r4;
    L9:
        return (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new y(r4, r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
    L5:
        r0 = ZeusTransformUtils.instanceOf(r4, r.class);
        goto L6
    }
}
