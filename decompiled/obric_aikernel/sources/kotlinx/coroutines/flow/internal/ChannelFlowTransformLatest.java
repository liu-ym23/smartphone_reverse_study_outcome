package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function3<kotlinx.coroutines.flow.d<? super R>, T, Continuation<? super Unit>, Object> f10468j;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(Function3<? super kotlinx.coroutines.flow.d<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r10, kotlinx.coroutines.flow.c<? extends T> r11, CoroutineContext r12, int r13, BufferOverflow r14) {
        super(r11, r12, r13, r14);
        this.f10468j = r10;
    }

    public /* synthetic */ ChannelFlowTransformLatest(Function3 r10, kotlinx.coroutines.flow.c r11, CoroutineContext r12, int r13, BufferOverflow r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        r12 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r17 = r12;
        if ((r15 & 8) == 0) goto L8;
        r13 = -2;
    L8:
        int r18 = r13;
        if ((r15 & 16) == 0) goto L11;
        r14 = BufferOverflow.SUSPEND;
    L11:
        this(r10, r11, r17, r18, r14);
    }

    public static final /* synthetic */ Function3 q(ChannelFlowTransformLatest r10) {
        return r10.f10468j;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<R> i(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new ChannelFlowTransformLatest(this.f10468j, this.f10467i, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    protected Object p(kotlinx.coroutines.flow.d<? super R> r10, Continuation<? super Unit> r11) {
        if (n0.a() == true) goto L5;
    L9:
        Object r12 = m0.d(new ChannelFlowTransformLatest$flowCollect$3(this, r10, null), r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r12;
    L13:
        return Unit.INSTANCE;
    L5:
        if ((r10 instanceof p) == true) goto L9;
        throw new AssertionError();
    }
}
