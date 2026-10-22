package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.z;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B?\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0014J\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0094@¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0011\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "additionalToStringProps", "", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class f<T> extends d<T> {
    private final kotlinx.coroutines.flow.i<kotlinx.coroutines.flow.i<T>> d;
    private final int e;

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "inner", "Lkotlinx/coroutines/flow/Flow;", "emit", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class a<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bx f17455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.sync.d f17456b;
        final /* synthetic */ kotlinx.coroutines.channels.w<T> c;
        final /* synthetic */ v<T> d;

        a(bx r3, kotlinx.coroutines.sync.d r4, kotlinx.coroutines.channels.w<? super T> r5, v<T> r6) {
            bx r7 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.sync.d r8 = (kotlinx.coroutines.sync.d) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.sync.d.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.channels.w<T> r9 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
            this.f17455a = r7;
            this.f17456b = r8;
            this.c = r9;
            this.d = r6;
        }

        public final Object a(kotlinx.coroutines.flow.i<? extends T> r9, Continuation<? super Unit> r10) {
            kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, ChannelFlowMerge$collectTo$2$emit$1.class) == false) goto L7;
            ChannelFlowMerge$collectTo$2$emit$1 r0 = (ChannelFlowMerge$collectTo$2$emit$1) ZeusTransformUtils.preCheckCast(r12, ChannelFlowMerge$collectTo$2$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r11 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            a<T> this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
        L20:
            kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(this.c, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ChannelFlowMerge$collectTo$2$1(r11, this.d, this.f17456b, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            bx r14 = this.f17455a;
            if (r14 == null) goto L17;
            ca.b(r14);
        L17:
            kotlinx.coroutines.sync.d r15 = this.f17456b;
            r0.L$0 = this;
            r0.L$1 = r11;
            r0.label = 1;
            if (r15.a(r0) != r2) goto L20;
            return r2;
        L7:
            r0 = new ChannelFlowMerge$collectTo$2$emit$1(this, r12);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    public f(kotlinx.coroutines.flow.i<? extends kotlinx.coroutines.flow.i<? extends T>> r3, int r4, CoroutineContext r5, int r6, BufferOverflow r7) {
        kotlinx.coroutines.flow.i<kotlinx.coroutines.flow.i<T>> r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        super((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin"), r6, r7);
        this.d = r8;
        this.e = r4;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public Object a(kotlinx.coroutines.channels.w<? super T> r7, Continuation<? super Unit> r8) {
        kotlinx.coroutines.channels.w r9 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.d r0 = kotlinx.coroutines.sync.f.a(this.e, 0, 2, null);
        v r2 = new v((z) ZeusTransformUtils.preCheckCast(r9, z.class, "com.obric.memorydata.plugin"));
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(r10.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        Object r6 = this.d.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new a(r3, r0, r9, r2), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r10);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public kotlinx.coroutines.channels.y<T> a(al r3) {
        return kotlinx.coroutines.channels.u.a((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), this.f17453a, this.f17454b, c());
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public d<T> a(CoroutineContext r9, int r10, BufferOverflow r11) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r9, CoroutineContext.class, "com.obric.memorydata.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new f(this.d, this.e, r5, r10, r11), d.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public String b() {
        return "concurrency=" + this.e;
    }
}
