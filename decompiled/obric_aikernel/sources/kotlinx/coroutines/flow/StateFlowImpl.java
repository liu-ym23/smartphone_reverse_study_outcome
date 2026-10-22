package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,428:1\n18#2:429\n18#2:443\n28#3,4:430\n28#3,4:437\n20#4:434\n20#4:441\n13579#5,2:435\n329#6:442\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n315#1:429\n396#1:443\n324#1:430,4\n352#1:437,4\n324#1:434\n352#1:441\n348#1:435,2\n385#1:442\n*E\n"})
final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<r1> implements g1<T>, kotlinx.coroutines.flow.internal.k<T>, kotlinx.coroutines.flow.internal.k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10456k = null;

    @Volatile
    private volatile Object _state;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10457j;

    static {
        f10456k = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    }

    public StateFlowImpl(Object r10) {
        this._state = r10;
    }

    private final boolean p(Object r10, Object r11) {
        monitor-enter(this);
        AtomicReferenceFieldUpdater r12 = f10456k;     // Catch: Throwable -> L42
        Object r13 = r12.get(this);     // Catch: Throwable -> L42
        if (r10 == null) goto L11;
        if (Intrinsics.areEqual(r13, r10) == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (Intrinsics.areEqual(r13, r11) == false) goto L14;
        monitor-exit(this);
        return true;
    L14:
        r12.set(this, r11);     // Catch: Throwable -> L42
        int r14 = this.f10457j;     // Catch: Throwable -> L42
        if ((r14 & 1) != 0) goto L39;
        int r15 = r14 + 1;     // Catch: Throwable -> L42
        this.f10457j = r15;     // Catch: Throwable -> L42
        r1[] r16 = m();     // Catch: Throwable -> L42
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(this);
    L18:
        r1[] r18 = r16;
        if (r18 == null) goto L26;
        int r19 = r18.length;
        int r20 = 0;
    L21:
        if (r20 >= r19) goto L26;
        r1 r21 = r18[r20];
        if (r21 == null) goto L25;
        r21.g();
    L25:
        r20 = r20 + 1;
    L26:
        monitor-enter(this);
        int r22 = this.f10457j;     // Catch: Throwable -> L35
        if (r22 == r15) goto L29;
        r1[] r23 = m();     // Catch: Throwable -> L35
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(this);
        r16 = r23;
        r15 = r22;
        goto L18
    L29:
        this.f10457j = r15 + 1;     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L35:
        th = move-exception;
        throw th;
    L39:
        this.f10457j = r14 + 2;     // Catch: Throwable -> L42
        monitor-exit(this);
        return true;
    L42:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, kotlinx.coroutines.flow.r1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlinx.coroutines.flow.d] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00dd -> B:33:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ef -> B:33:0x00a7). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.c
    public Object a(d<? super T> r11, Continuation<?> r12) {
        if ((r12 instanceof StateFlowImpl$collect$1) == false) goto L7;
        StateFlowImpl$collect$1 r10 = (StateFlowImpl$collect$1) r12;
        int r13 = r10.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r10.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r16 = r10.label;
        if (r16 == 0) goto L26;
        if (r16 != 1) goto L59;
        r1 r17 = (r1) r10.L$2;
        r11 = (d) r10.L$1;
        StateFlowImpl<T> this = (StateFlowImpl) r10.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L53
        r1 r18 = r17;
    L32:
        ?? r19 = r11;
        v1 r110 = (v1) r10.getContext().get(v1.f10723e);     // Catch: Throwable -> L53
        Object r111 = null;
        r16 = r18;
    L33:
        Object r20 = f10456k.get(this);     // Catch: Throwable -> L53
        if (r110 == null) goto L36;
        y1.h(r110);     // Catch: Throwable -> L53
    L36:
        if (r111 == null) goto L40;
        ?? r21 = r16;
        ?? r22 = r19;
        if (Intrinsics.areEqual(r111, r20) == false) goto L40;
    L48:
        boolean r23 = r21.h();     // Catch: Throwable -> L53
        r16 = r21;
        r19 = r22;
        if (r23 == true) goto L33;
        r10.L$0 = this;     // Catch: Throwable -> L53
        r10.L$1 = r22;     // Catch: Throwable -> L53
        r10.L$2 = r21;     // Catch: Throwable -> L53
        r10.L$3 = r110;     // Catch: Throwable -> L53
        r10.L$4 = r111;     // Catch: Throwable -> L53
        r10.label = 3;     // Catch: Throwable -> L53
        Object r24 = r21.e(r10);     // Catch: Throwable -> L53
        r16 = r21;
        r19 = r22;
        if (r24 != r15) goto L33;
        return r15;
    L40:
        if (r20 != kotlinx.coroutines.flow.internal.n.f10495a) goto L42;
        Object r112 = null;
    L43:
        r10.L$0 = this;     // Catch: Throwable -> L53
        r10.L$1 = r19;     // Catch: Throwable -> L53
        r10.L$2 = r16;     // Catch: Throwable -> L53
        r10.L$3 = r110;     // Catch: Throwable -> L53
        r10.L$4 = r20;     // Catch: Throwable -> L53
        r10.label = 2;     // Catch: Throwable -> L53
        if (r19.emit(r112, r10) != r15) goto L46;
        return r15;
    L46:
        StateFlowImpl<T> r25 = this;
        Object r113 = r20;
        ?? r26 = r16;
        ?? r27 = r19;
    L47:
        r111 = r113;
        this = r25;
        r21 = r26;
        r22 = r27;
        goto L48
    L42:
        r112 = r20;
        goto L43
    L59:
        if (r16 == 2) goto L18;
        if (r16 != 3) goto L17;
        Object r114 = r10.L$4;
        r110 = (v1) r10.L$3;
        r1 r28 = (r1) r10.L$2;
        d r29 = (d) r10.L$1;
        StateFlowImpl<T> r30 = (StateFlowImpl) r10.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L21
        r111 = r114;
        this = r30;
        r16 = r28;
        r19 = r29;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r113 = r10.L$4;
        r110 = (v1) r10.L$3;
        r1 r31 = (r1) r10.L$2;
        d r32 = (d) r10.L$1;
        r25 = (StateFlowImpl) r10.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L21
        r26 = r31;
        r27 = r32;
    L21:
        Throwable th = th;
    L55:
        r7.k(r16);
        throw th;
    L26:
        ResultKt.throwOnFailure(r14);
        r1 r33 = h();
        r18 = r33;
        if ((r11 instanceof SubscribedFlowCollector) == false) goto L32;
        r10.L$0 = this;     // Catch: Throwable -> L53
        r10.L$1 = r11;     // Catch: Throwable -> L53
        r10.L$2 = r33;     // Catch: Throwable -> L53
        r10.label = 1;     // Catch: Throwable -> L53
        r18 = r33;
        if (((SubscribedFlowCollector) r11).a(r10) != r15) goto L32;
        return r15;
    L53:
        th = move-exception;
        StateFlowImpl<T> r34 = this;
        th = th;
    L7:
        r10 = new StateFlowImpl$collect$1(this, r12);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.f1
    public void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.f1
    public boolean c(T r10) {
        setValue(r10);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.k
    public c<T> e(CoroutineContext r10, int r11, BufferOverflow r12) {
        return q1.d(this, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.f1, kotlinx.coroutines.flow.d
    public Object emit(T r10, Continuation<? super Unit> r11) {
        setValue(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.g1, kotlinx.coroutines.flow.p1
    public T getValue() {
        kotlinx.coroutines.internal.i0 r10 = kotlinx.coroutines.flow.internal.n.f10495a;
        T r11 = (T) f10456k.get(this);
        if (r11 != r10) goto L6;
        return null;
    L6:
        return r11;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c i() {
        return n();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c[] j(int r10) {
        return o(r10);
    }

    protected r1 n() {
        return new r1();
    }

    protected r1[] o(int r10) {
        return new r1[r10];
    }

    @Override // kotlinx.coroutines.flow.g1
    public void setValue(T r10) {
        if (r10 != null) goto L4;
        r10 = (T) kotlinx.coroutines.flow.internal.n.f10495a;
    L4:
        p(null, r10);
    }
}
