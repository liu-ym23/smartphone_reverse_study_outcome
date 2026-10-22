package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8.g f18851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g8.g f18852b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g8.g f18853c = null;

    static {
        f18851a = new g8.g("NO_VALUE", 10);
        int r5 = 10;
        f18852b = new g8.g("NONE", r5);
        f18853c = new g8.g("PENDING", r5);
    }

    public static i2 a(int r5, int r10, BufferOverflow r11) {
        if ((r10 & 2) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r10 & 4) == 0) goto L8;
        r11 = BufferOverflow.SUSPEND;
    L8:
        if (r5 < 0) goto L20;
        if (r5 <= 0) goto L11;
    L15:
        if (r5 >= 0) goto L18;
        r5 = Integer.MAX_VALUE;
    L18:
        return new i2(0, r5, r11);
    L11:
        if (r11 == BufferOverflow.SUSPEND) goto L15;
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + r11).toString());
    L20:
        throw new IllegalArgumentException(ai.j0.g(r5, "extraBufferCapacity cannot be negative, but was ").toString());
    }

    public static final q2 b(Object r5) {
        if (r5 != null) goto L6;
        r5 = kotlinx.coroutines.flow.internal.b.f18863b;
    L6:
        return new q2(r5);
    }

    public static final Object c(Object[] r5, long r10) {
        return r5[((int) r10) & (r5.length - 1)];
    }

    public static final void d(Object[] r5, long r10, Object r11) {
        r5[((int) r10) & (r5.length - 1)] = r11;
    }

    public static g e(g r5, int r10) {
        BufferOverflow r11 = BufferOverflow.SUSPEND;
        if (r10 < 0) goto L5;
    L10:
        if (r10 != (-1)) goto L13;
        r11 = BufferOverflow.DROP_OLDEST;
        r10 = 0;
    L13:
        if ((r5 instanceof kotlinx.coroutines.flow.internal.r) == false) goto L16;
        return ((kotlinx.coroutines.flow.internal.r) r5).b(EmptyCoroutineContext.INSTANCE, r10, r11);
    L16:
        return new kotlinx.coroutines.flow.internal.g(r5, r10, r11, 2);
    L5:
        if (r10 == (-2)) goto L10;
        if (r10 == (-1)) goto L10;
        throw new IllegalArgumentException(ai.j0.g(r10, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ").toString());
    }

    public static final Object f(g r10, Function2 r11, ContinuationImpl r12) {
        int r5 = u0.f18908a;
        Object r13 = e(new kotlinx.coroutines.flow.internal.i(new FlowKt__MergeKt$mapLatest$1(r11, null), r10, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND), 0).collect(kotlinx.coroutines.flow.internal.t.f18883a, r12);
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        r13 = Unit.INSTANCE;
    L7:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r13;
    L10:
        return Unit.INSTANCE;
    }

    public static final g g(g r5) {
        return new kotlinx.coroutines.flow.internal.q(new FlowKt__DelayKt$debounceInternal$1(new com.bytedance.ai.model.m(18), r5, null));
    }

    public static final g h(g r5) {
        if ((r5 instanceof p2) == false) goto L6;
        return r5;
    L6:
        if ((r5 instanceof e) == false) goto L9;
        ((e) r5).getClass();
        return r5;
    L9:
        return new e(r5);
    }

    public static final Object i(h r5, g r10, SuspendLambda r11) {
        Object r12 = r10.collect(r5, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0092 -> B:14:0x0039). Please report as a decompilation issue!!! */
    public static final Object j(h r10, kotlinx.coroutines.channels.w r11, boolean r12, ContinuationImpl r13) {
        if ((r13 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r5 = (FlowKt__ChannelsKt$emitAllImpl$1) r13;
        int r14 = r5.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.label;
        if (r17 == 0) goto L22;
        if (r17 == 1) goto L19;
        if (r17 != 2) goto L18;
        r12 = r5.Z$0;
        kotlinx.coroutines.channels.k r18 = (kotlinx.coroutines.channels.k) r5.L$2;
        r11 = (kotlinx.coroutines.channels.w) r5.L$1;
        h r19 = (h) r5.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
        kotlinx.coroutines.channels.k r20 = r18;
    L14:
        kotlinx.coroutines.channels.k r21 = r20;
        r10 = r19;
    L24:
        r5.L$0 = r10;     // Catch: Throwable -> L15
        r5.L$1 = r11;     // Catch: Throwable -> L15
        r5.L$2 = r21;     // Catch: Throwable -> L15
        r5.Z$0 = r12;     // Catch: Throwable -> L15
        r5.label = 1;     // Catch: Throwable -> L15
        kotlinx.coroutines.channels.e r22 = (kotlinx.coroutines.channels.e) r21;     // Catch: Throwable -> L15
        Object r23 = r22.c(r5);     // Catch: Throwable -> L15
        if (r23 != r16) goto L27;
        return r16;
    L27:
        r19 = r10;
        kotlinx.coroutines.channels.k r24 = r22;
        r15 = r23;
    L29:
        if (((Boolean) r15).booleanValue() == false) goto L33;
        kotlinx.coroutines.channels.e r25 = (kotlinx.coroutines.channels.e) r24;     // Catch: Throwable -> L15
        Object r26 = r25.d();     // Catch: Throwable -> L15
        r5.L$0 = r19;     // Catch: Throwable -> L15
        r5.L$1 = r11;     // Catch: Throwable -> L15
        r5.L$2 = r25;     // Catch: Throwable -> L15
        r5.Z$0 = r12;     // Catch: Throwable -> L15
        r5.label = 2;     // Catch: Throwable -> L15
        r20 = r25;
        if (r19.emit(r26, r5) != r16) goto L14;
        return r16;
    L33:
        if (r12 == false) goto L36;
        r11.cancel(null);
    L36:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r12 = r5.Z$0;
        r24 = (kotlinx.coroutines.channels.k) r5.L$2;
        r11 = (kotlinx.coroutines.channels.w) r5.L$1;
        r19 = (h) r5.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
        goto L29
    L22:
        ResultKt.throwOnFailure(r15);
        r21 = r11.iterator();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (r12 == false) goto L41;
        kotlinx.coroutines.channels.p.d(r11, th);
    L41:
        throw th;
    L7:
        r5 = new FlowKt__ChannelsKt$emitAllImpl$1(r13);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, g8.g] */
    public static final Object k(g r5, ContinuationImpl r10) {
        if ((r10 instanceof FlowKt__ReduceKt$first$1) == false) goto L7;
        FlowKt__ReduceKt$first$1 r11 = (FlowKt__ReduceKt$first$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        ?? r16 = kotlinx.coroutines.flow.internal.b.f18863b;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        h r17 = (v0) r11.L$1;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: AbortFlowException -> L14
    L27:
        r14 = r18.element;
        if (r14 == r16) goto L31;
    L29:
        return r14;
    L31:
        throw new NoSuchElementException("Expected at least one element");
    L14:
        AbortFlowException e = e;
    L26:
        if (e.owner == r17) goto L27;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r19.element = r16;
        h r20 = new v0(r19);
        r11.L$0 = r19;     // Catch: AbortFlowException -> L23
        r11.L$1 = r20;     // Catch: AbortFlowException -> L23
        r11.label = 1;     // Catch: AbortFlowException -> L23
        if (r5.collect(r20, r11) == r14) goto L29;
        r18 = r19;
    L23:
        e = move-exception;
        r18 = r19;
        e = e;
        r17 = r20;
    L7:
        r11 = new FlowKt__ReduceKt$first$1(r10);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, g8.g] */
    public static final Object l(p2 r5, Function2 r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$first$3) == false) goto L7;
        FlowKt__ReduceKt$first$3 r12 = (FlowKt__ReduceKt$first$3) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        ?? r17 = kotlinx.coroutines.flow.internal.b.f18863b;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        h r18 = (w0) r12.L$2;
        Ref.ObjectRef r19 = (Ref.ObjectRef) r12.L$1;
        Function2 r20 = (Function2) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: AbortFlowException -> L14
    L27:
        r15 = r19.element;
        if (r15 == r17) goto L31;
    L29:
        return r15;
    L31:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r20);
    L14:
        AbortFlowException e = e;
    L26:
        if (e.owner == r18) goto L27;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r21 = new Ref.ObjectRef();
        r21.element = r17;
        h r22 = new w0(r10, r21);
        r12.L$0 = r10;     // Catch: AbortFlowException -> L23
        r12.L$1 = r21;     // Catch: AbortFlowException -> L23
        r12.L$2 = r22;     // Catch: AbortFlowException -> L23
        r12.label = 1;     // Catch: AbortFlowException -> L23
        if (r5.collect(r22, r12) == r15) goto L29;
        r20 = r10;
        r19 = r21;
    L23:
        e = move-exception;
        r20 = r10;
        r19 = r21;
        e = e;
        r18 = r22;
    L7:
        r12 = new FlowKt__ReduceKt$first$3(r11);
        goto L8
    }
}
