package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.z;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0094@¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H¤@¢\u0006\u0002\u0010\u0011J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectWithContextUndispatched", "newContext", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowCollect", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class g<S, T> extends d<T> {
    protected final kotlinx.coroutines.flow.i<S> d;

    public g(kotlinx.coroutines.flow.i<? extends S> r3, CoroutineContext r4, int r5, BufferOverflow r6) {
        kotlinx.coroutines.flow.i<S> r7 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        super((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin"), r5, r6);
        this.d = r7;
    }

    static /* synthetic */ <S, T> Object a(g<S, T> r3, kotlinx.coroutines.channels.w<? super T> r4, Continuation<? super Unit> r5) {
        kotlinx.coroutines.channels.w r6 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r8 = r3.a((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new v((z) ZeusTransformUtils.preCheckCast(r6, z.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    static /* synthetic */ <S, T> Object a(g<S, T> r6, kotlinx.coroutines.flow.j<? super T> r7, Continuation<? super Unit> r8) {
        kotlinx.coroutines.flow.j<? super T> r9 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (r6.f17454b != (-3)) goto L18;
        CoroutineContext r0 = r10.getContext();
        CoroutineContext r2 = ag.a(r0, r6.f17453a);
        if (Intrinsics.areEqual(r2, r0) == false) goto L12;
        Object r11 = r6.a(r9, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r11;
    L10:
        return Unit.INSTANCE;
    L12:
        if (Intrinsics.areEqual(r2.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), r0.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) == false) goto L18;
        Object r12 = r6.a(r9, r2, r10);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r12;
    L17:
        return Unit.INSTANCE;
    L18:
        Object r13 = super.collect(r9, r10);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        return r13;
    L22:
        return Unit.INSTANCE;
    }

    private final Object a(kotlinx.coroutines.flow.j<? super T> r10, CoroutineContext r11, Continuation<? super Unit> r12) {
        kotlinx.coroutines.flow.j r13 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        CoroutineContext r2 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r11, CoroutineContext.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return e.a(r2, e.a(r13, r6.getContext()), null, (Function2) ZeusTransformUtils.preCheckCast(new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), Function2.class, "com.obric.memorydata.plugin"), r6, 4, null);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public Object a(kotlinx.coroutines.channels.w<? super T> r3, Continuation<? super Unit> r4) {
        return a(this, (kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public abstract Object a(kotlinx.coroutines.flow.j<? super T> r1, Continuation<? super Unit> r2);

    @Override // kotlinx.coroutines.flow.internal.d, kotlinx.coroutines.flow.i
    public Object collect(kotlinx.coroutines.flow.j<? super T> r3, Continuation<? super Unit> r4) {
        return a(this, (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public String toString() {
        return this.d + " -> " + super.toString();
    }
}
