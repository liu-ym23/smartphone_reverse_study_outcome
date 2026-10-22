package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.al;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.z;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u000f\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flows", "", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class j<T> extends d<T> {
    private final Iterable<kotlinx.coroutines.flow.i<T>> d;

    public j(Iterable<? extends kotlinx.coroutines.flow.i<? extends T>> r3, CoroutineContext r4, int r5, BufferOverflow r6) {
        Iterable<kotlinx.coroutines.flow.i<T>> r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        super((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin"), r5, r6);
        this.d = r7;
    }

    public /* synthetic */ j(Iterable r2, CoroutineContext r3, int r4, BufferOverflow r5, int r6, DefaultConstructorMarker r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -2;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = BufferOverflow.SUSPEND;
    L11:
        this(r8, r9, r4, r5);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public Object a(kotlinx.coroutines.channels.w<? super T> r10, Continuation<? super Unit> r11) {
        kotlinx.coroutines.channels.w r12 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        v r14 = new v((z) ZeusTransformUtils.preCheckCast(r12, z.class, "com.obric.memorydata.plugin"));
        Iterator<kotlinx.coroutines.flow.i<T>> r9 = this.d.iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r9.next(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r12, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ChannelLimitedFlowMerge$collectTo$2$1(r0, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public kotlinx.coroutines.channels.y<T> a(al r3) {
        return kotlinx.coroutines.channels.u.a((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), this.f17453a, this.f17454b, c());
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public d<T> a(CoroutineContext r3, int r4, BufferOverflow r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new j(this.d, r6, r4, r5), d.class, "com.obric.memorydata.plugin");
    }
}
