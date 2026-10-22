package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u001c\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0094@¢\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0018\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¨\u0006!"}, d2 = {"Lkotlinx/coroutines/flow/ChannelAsFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "consume", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "additionalToStringProps", "", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "markConsumed", "produceImpl", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class e<T> extends kotlinx.coroutines.flow.internal.d<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    private volatile /* synthetic */ int consumed$volatile;
    private final kotlinx.coroutines.channels.y<T> d;
    private final boolean e;

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(e.class, "consumed$volatile");
    }

    public e(kotlinx.coroutines.channels.y<? extends T> r3, boolean r4, CoroutineContext r5, int r6, BufferOverflow r7) {
        kotlinx.coroutines.channels.y<T> r8 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        super((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin"), r6, r7);
        this.d = r8;
        this.e = r4;
        this.consumed$volatile = 0;
    }

    public /* synthetic */ e(kotlinx.coroutines.channels.y r8, boolean r9, CoroutineContext r10, int r11, BufferOverflow r12, int r13, DefaultConstructorMarker r14) {
        kotlinx.coroutines.channels.y r2 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        CoroutineContext r15 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r10, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r13 & 4) == 0) goto L5;
        r15 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L5:
        CoroutineContext r4 = r15;
        if ((r13 & 8) == 0) goto L8;
        r11 = -3;
    L8:
        int r5 = r11;
        if ((r13 & 16) == 0) goto L11;
        r12 = BufferOverflow.SUSPEND;
    L11:
        this(r2, r9, r4, r5, r12);
    }

    private final void e() {
        if (this.e == false) goto L12;
        boolean r1 = true;
        if (f().getAndSet(this, 1) == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater f() {
        return f;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public Object a(kotlinx.coroutines.channels.w<? super T> r4, Continuation<? super Unit> r5) {
        kotlinx.coroutines.channels.w r6 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r3 = m.a((j) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.flow.internal.v((kotlinx.coroutines.channels.z) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.z.class, "com.obric.memorydata.plugin")), j.class, "com.obric.memorydata.plugin"), this.d, this.e, r7);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public kotlinx.coroutines.channels.y<T> a(kotlinx.coroutines.al r3) {
        kotlinx.coroutines.al r4 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        e();
        if (this.f17454b != (-3)) goto L6;
        return this.d;
    L6:
        return super.a(r4);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public i<T> a() {
        return (i) ZeusTransformUtils.preCheckCast(new e(this.d, this.e, null, 0, null, 28, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public kotlinx.coroutines.flow.internal.d<T> a(CoroutineContext r9, int r10, BufferOverflow r11) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r9, CoroutineContext.class, "com.obric.memorydata.plugin");
        return (kotlinx.coroutines.flow.internal.d) ZeusTransformUtils.preCheckCast(new e(this.d, this.e, r5, r10, r11), kotlinx.coroutines.flow.internal.d.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public String b() {
        return "channel=" + this.d;
    }

    @Override // kotlinx.coroutines.flow.internal.d, kotlinx.coroutines.flow.i
    public Object collect(j<? super T> r3, Continuation<? super Unit> r4) {
        j<? super T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if (this.f17454b != (-3)) goto L9;
        e();
        Object r2 = m.a(r5, this.d, this.e, r6);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r2;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r7 = super.collect(r5, r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r7;
    L13:
        return Unit.INSTANCE;
    }
}
