package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0003H\u0014J\u001d\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"2\u0006\u0010#\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010'J&\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0015\u00100\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u001a\u00102\u001a\u00020\u001c2\b\u00103\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\bH\u0002R\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\t¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "sequence", "", EventBody.KEY_VALUE, "getValue", "()Ljava/lang/Object;", "setValue", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareAndSet", "", "expect", BuildConfig.CHANNEL, "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createSlot", "createSlotArray", "", "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "resetReplayCache", "tryEmit", "(Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class as<T> extends kotlinx.coroutines.flow.internal.a<au> implements ae<T>, c<T>, kotlinx.coroutines.flow.internal.p<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17426b = null;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17427a;

    static {
        f17426b = AtomicReferenceFieldUpdater.newUpdater(as.class, Object.class, "_state$volatile");
    }

    public as(Object r1) {
        this._state$volatile = r1;
    }

    private final boolean b(Object r7, Object r8) {
        monitor-enter(this);
        Object r0 = e().get(this);     // Catch: Throwable -> L42
        if (r7 == null) goto L11;
        if (Intrinsics.areEqual(r0, r7) == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (Intrinsics.areEqual(r0, r8) == false) goto L14;
        monitor-exit(this);
        return true;
    L14:
        e().set(this, r8);     // Catch: Throwable -> L42
        int r9 = this.f17427a;     // Catch: Throwable -> L42
        if ((r9 & 1) != 0) goto L39;
        int r10 = r9 + 1;     // Catch: Throwable -> L42
        this.f17427a = r10;     // Catch: Throwable -> L42
        au[] r11 = h();     // Catch: Throwable -> L42
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(this);
    L18:
        au[] r12 = (au[]) ZeusTransformUtils.preCheckCast(r11, au[].class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L26;
        int r3 = r12.length;
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L26;
        au r5 = r12[r4];
        if (r5 == null) goto L25;
        r5.a();
    L25:
        r4 = r4 + 1;
    L26:
        monitor-enter(this);
        int r13 = this.f17427a;     // Catch: Throwable -> L35
        if (r13 == r10) goto L29;
        au[] r14 = h();     // Catch: Throwable -> L35
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(this);
        r11 = r14;
        r10 = r13;
        goto L18
    L29:
        this.f17427a = r10 + 1;     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L35:
        th = move-exception;
        throw th;
    L39:
        this.f17427a = r9 + 2;     // Catch: Throwable -> L42
        monitor-exit(this);
        return true;
    L42:
        th = move-exception;
        throw th;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater e() {
        return f17426b;
    }

    @Override // kotlinx.coroutines.flow.ad
    public boolean a(T r1) {
        b(r1);
        return true;
    }

    @Override // kotlinx.coroutines.flow.ae
    public boolean a(T r1, T r2) {
        if (r1 != null) goto L4;
        r1 = (T) kotlinx.coroutines.flow.internal.s.f17463a;
    L4:
        if (r2 != null) goto L7;
        r2 = (T) kotlinx.coroutines.flow.internal.s.f17463a;
    L7:
        return b(r1, r2);
    }

    public au[] a(int r1) {
        return new au[r1];
    }

    @Override // kotlinx.coroutines.flow.internal.p
    public i<T> a_(CoroutineContext r3, int r4, BufferOverflow r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        return at.a((ar) ZeusTransformUtils.preCheckCast(this, ar.class, "com.obric.memorydata.plugin"), r6, r4, r5);
    }

    @Override // kotlinx.coroutines.flow.ad
    public void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.ae
    public void b(T r2) {
        if (r2 != null) goto L4;
        r2 = (T) kotlinx.coroutines.flow.internal.s.f17463a;
    L4:
        b(null, r2);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* synthetic */ kotlinx.coroutines.flow.internal.c[] b(int r2) {
        return (kotlinx.coroutines.flow.internal.c[]) ZeusTransformUtils.preCheckCast(a(r2), kotlinx.coroutines.flow.internal.c[].class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.flow.ae, kotlinx.coroutines.flow.ar
    public T c() {
        kotlinx.coroutines.internal.aj r0 = kotlinx.coroutines.flow.internal.s.f17463a;
        T r2 = (T) e().get(this);
        if (r2 != r0) goto L6;
        return null;
    L6:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<kotlinx.coroutines.flow.as>] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.flow.as] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlinx.coroutines.flow.au] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0157 -> B:33:0x011f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0169 -> B:33:0x011f). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.ai, kotlinx.coroutines.flow.i
    public Object collect(j<? super T> r12, Continuation<?> r13) {
        ?? r0 = as.class;
        j r14 = (j) ZeusTransformUtils.wrapperContextForParams(r12, j.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, StateFlowImpl$collect$1.class) == false) goto L7;
        StateFlowImpl$collect$1 r1 = (StateFlowImpl$collect$1) ZeusTransformUtils.preCheckCast(r15, StateFlowImpl$collect$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = r1.label;
        if (r4 == 0) goto L26;
        if (r4 != 1) goto L59;
        au r5 = (au) ZeusTransformUtils.preCheckCast(r1.L$2, au.class, "com.obric.memorydata.plugin");
        r14 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
        as<T> this = (as) ZeusTransformUtils.preCheckCast(r1.L$0, r0, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L53
        au r6 = r5;
    L32:
        ?? r8 = r14;
        bx r17 = (bx) ZeusTransformUtils.preCheckCast(r1.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        Object r18 = null;
        r4 = r6;
    L33:
        Object r2 = e().get(this);     // Catch: Throwable -> L53
        if (r17 == null) goto L36;
        ca.b(r17);     // Catch: Throwable -> L53
    L36:
        if (r18 == null) goto L40;
        ?? r7 = r4;
        ?? r9 = r8;
        if (Intrinsics.areEqual(r18, r2) == false) goto L40;
    L48:
        boolean r10 = r7.b();     // Catch: Throwable -> L53
        r4 = r7;
        r8 = r9;
        if (r10 == true) goto L33;
        r1.L$0 = this;     // Catch: Throwable -> L53
        r1.L$1 = r9;     // Catch: Throwable -> L53
        r1.L$2 = r7;     // Catch: Throwable -> L53
        r1.L$3 = r17;     // Catch: Throwable -> L53
        r1.L$4 = r18;     // Catch: Throwable -> L53
        r1.label = 3;     // Catch: Throwable -> L53
        Object r11 = r7.a(r1);     // Catch: Throwable -> L53
        r4 = r7;
        r8 = r9;
        if (r11 != r3) goto L33;
        return r3;
    L40:
        if (r2 != kotlinx.coroutines.flow.internal.s.f17463a) goto L42;
        Object r19 = null;
    L43:
        r1.L$0 = this;     // Catch: Throwable -> L53
        r1.L$1 = r8;     // Catch: Throwable -> L53
        r1.L$2 = r4;     // Catch: Throwable -> L53
        r1.L$3 = r17;     // Catch: Throwable -> L53
        r1.L$4 = r2;     // Catch: Throwable -> L53
        r1.label = 2;     // Catch: Throwable -> L53
        if (r8.emit(r19, r1) != r3) goto L46;
        return r3;
    L46:
        as<T> r20 = this;
        Object r110 = r2;
        ?? r21 = r4;
        ?? r22 = r8;
    L47:
        r18 = r110;
        this = r20;
        r7 = r21;
        r9 = r22;
        goto L48
    L42:
        r19 = r2;
        goto L43
    L59:
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        Object r111 = r1.L$4;
        r17 = (bx) ZeusTransformUtils.preCheckCast(r1.L$3, bx.class, "com.obric.memorydata.plugin");
        au r23 = (au) ZeusTransformUtils.preCheckCast(r1.L$2, au.class, "com.obric.memorydata.plugin");
        j r24 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
        as<T> r25 = (as) ZeusTransformUtils.preCheckCast(r1.L$0, r0, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L21
        r18 = r111;
        this = r25;
        r4 = r23;
        r8 = r24;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r110 = r1.L$4;
        r17 = (bx) ZeusTransformUtils.preCheckCast(r1.L$3, bx.class, "com.obric.memorydata.plugin");
        au r26 = (au) ZeusTransformUtils.preCheckCast(r1.L$2, au.class, "com.obric.memorydata.plugin");
        j r27 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
        r20 = (as) ZeusTransformUtils.preCheckCast(r1.L$0, r0, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L21
        r21 = r26;
        r22 = r27;
    L21:
        Throwable th = th;
    L55:
        r0.a((kotlinx.coroutines.flow.internal.c) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.internal.c.class, "com.obric.memorydata.plugin"));
        throw th;
    L26:
        ResultKt.throwOnFailure(r16);
        au r28 = (au) ZeusTransformUtils.preCheckCast(j(), au.class, "com.obric.memorydata.plugin");
        r6 = r28;
        if (ZeusTransformUtils.instanceOf(r14, av.class) == false) goto L32;
        av r112 = (av) ZeusTransformUtils.preCheckCast(r14, av.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        r1.L$0 = this;     // Catch: Throwable -> L53
        r1.L$1 = r14;     // Catch: Throwable -> L53
        r1.L$2 = r28;     // Catch: Throwable -> L53
        r1.label = 1;     // Catch: Throwable -> L53
        r6 = r28;
        if (r112.a(r1) != r3) goto L32;
        return r3;
    L53:
        th = move-exception;
        r0 = this;
        th = th;
    L7:
        r1 = new StateFlowImpl$collect$1(this, r15);
        goto L8
    }

    public au d() {
        return new au();
    }

    @Override // kotlinx.coroutines.flow.ad, kotlinx.coroutines.flow.j
    public Object emit(T r3, Continuation<? super Unit> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        b(r3);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* synthetic */ kotlinx.coroutines.flow.internal.c g() {
        return (kotlinx.coroutines.flow.internal.c) ZeusTransformUtils.preCheckCast(d(), kotlinx.coroutines.flow.internal.c.class, "com.obric.memorydata.plugin");
    }
}
