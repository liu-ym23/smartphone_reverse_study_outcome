package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public final class q2 extends kotlinx.coroutines.flow.internal.a implements d2, g, kotlinx.coroutines.flow.internal.r {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = null;
    private volatile /* synthetic */ Object _state$volatile;
    public int e;

    static {
        f = AtomicReferenceFieldUpdater.newUpdater(q2.class, Object.class, "_state$volatile");
    }

    public q2(Object r5) {
        this._state$volatile = r5;
    }

    @Override // kotlinx.coroutines.flow.c2
    public final boolean a(Object r5) {
        i(r5);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.r
    public final g b(CoroutineContext r5, int r10, BufferOverflow r11) {
        if (r10 < 0) goto L7;
        if (r10 >= 2) goto L7;
    L9:
        if (r11 == BufferOverflow.DROP_OLDEST) goto L19;
    L11:
        if (r10 == 0) goto L15;
        if (r10 == (-3)) goto L15;
    L18:
        return new kotlinx.coroutines.flow.internal.g(this, r5, r10, r11);
    L15:
        if (r11 != BufferOverflow.SUSPEND) goto L18;
        return this;
    L19:
        return this;
    L7:
        if (r10 != (-2)) goto L11;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, kotlinx.coroutines.flow.r2] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlinx.coroutines.flow.r2] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.flow.internal.a] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00db -> B:32:0x0095). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00ec -> B:32:0x0095). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r10, Continuation r11) {
        if ((r11 instanceof StateFlowImpl$collect$1) == false) goto L7;
        StateFlowImpl$collect$1 r5 = (StateFlowImpl$collect$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r15 = r5.label;
        if (r15 != 0) goto L11;
        ResultKt.throwOnFailure(r13);
        r15 = (r2) c();
    L30:
        ?? r16 = this;
        h r17 = r10;
        Job r18 = (Job) r5.getContext().get(Job.Key);     // Catch: Throwable -> L27
        Object r19 = null;
        r15 = r15;
    L32:
        Object r110 = f.get(r16);     // Catch: Throwable -> L17
        if (r18 != null) goto L35;
    L39:
        if (r19 == null) goto L43;
        ?? r20 = r15;
        ?? r21 = r16;
        if (Intrinsics.areEqual(r19, r110) == false) goto L43;
    L50:
        Object r111 = r20.f18905a.getAndSet(i.f18852b);     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L17
        if (r111 != i.f18853c) goto L53;
        r15 = r20;
        r16 = r21;
        goto L32
    L53:
        r5.L$0 = r21;     // Catch: Throwable -> L17
        r5.L$1 = r17;     // Catch: Throwable -> L17
        r5.L$2 = r20;     // Catch: Throwable -> L17
        r5.L$3 = r18;     // Catch: Throwable -> L17
        r5.L$4 = r19;     // Catch: Throwable -> L17
        r5.label = 3;     // Catch: Throwable -> L17
        Object r112 = r20.c(r5);     // Catch: Throwable -> L17
        r15 = r20;
        r16 = r21;
        if (r112 != r14) goto L32;
        return r14;
    L43:
        if (r110 != kotlinx.coroutines.flow.internal.b.f18863b) goto L45;
        Object r22 = null;
    L46:
        r5.L$0 = r16;     // Catch: Throwable -> L17
        r5.L$1 = r17;     // Catch: Throwable -> L17
        r5.L$2 = r15;     // Catch: Throwable -> L17
        r5.L$3 = r18;     // Catch: Throwable -> L17
        r5.L$4 = r110;     // Catch: Throwable -> L17
        r5.label = 2;     // Catch: Throwable -> L17
        if (r17.emit(r22, r5) != r14) goto L49;
        return r14;
    L49:
        r19 = r110;
        r20 = r15;
        r21 = r16;
        goto L50
    L45:
        r22 = r110;
        goto L46
    L35:
        if (r18.isActive() == true) goto L39;
        throw r18.getCancellationException();     // Catch: Throwable -> L17
    L27:
        th = move-exception;
        r16 = this;
        th = th;
    L56:
        r16.g(r15);
        throw th;
    L11:
        if (r15 == 1) goto L24;
        if (r15 == 2) goto L21;
        if (r15 != 3) goto L20;
        r19 = r5.L$4;
        r18 = (Job) r5.L$3;
        r2 r23 = (r2) r5.L$2;
        r17 = (h) r5.L$1;
        q2 r24 = (q2) r5.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L17
        r15 = r23;
        r16 = r24;
        goto L32
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r19 = r5.L$4;
        r18 = (Job) r5.L$3;
        r2 r25 = (r2) r5.L$2;
        r17 = (h) r5.L$1;
        q2 r26 = (q2) r5.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L17
        r20 = r25;
        r21 = r26;
        goto L50
    L24:
        r15 = (r2) r5.L$2;
        r10 = (h) r5.L$1;
        q2 this = (q2) r5.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L27
        r15 = r15;
    L17:
        th = th;
    L7:
        r5 = new StateFlowImpl$collect$1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.c2
    public final void d() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c e() {
        return new r2();
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        i(r5);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c[] f() {
        return new r2[2];
    }

    @Override // kotlinx.coroutines.flow.p2
    public final Object getValue() {
        g8.g r5 = kotlinx.coroutines.flow.internal.b.f18863b;
        Object r10 = f.get(this);
        if (r10 != r5) goto L6;
        return null;
    L6:
        return r10;
    }

    public final void i(Object r5) {
        if (r5 != null) goto L4;
        r5 = kotlinx.coroutines.flow.internal.b.f18863b;
    L4:
        j(null, r5);
    }

    public final boolean j(Object r10, Object r11) {
        monitor-enter(this);
        AtomicReferenceFieldUpdater r5 = f;     // Catch: Throwable -> L10
        Object r12 = r5.get(this);     // Catch: Throwable -> L10
        if (r10 == null) goto L13;
        if (Intrinsics.areEqual(r12, r10) == true) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (Intrinsics.areEqual(r12, r11) == false) goto L16;
        monitor-exit(this);
        return true;
    L16:
        r5.set(this, r11);     // Catch: Throwable -> L10
        int r13 = this.e;     // Catch: Throwable -> L10
        if ((r13 & 1) != 0) goto L62;
        int r14 = r13 + 1;     // Catch: Throwable -> L10
        this.e = r14;     // Catch: Throwable -> L10
        kotlinx.coroutines.flow.internal.c[] r15 = this.f18859a;     // Catch: Throwable -> L10
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
    L20:
        r2[] r17 = (r2[]) r15;
        if (r17 == null) goto L48;
        int r18 = r17.length;
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L48;
        r2 r20 = r17[r19];
        if (r20 == null) goto L47;
        AtomicReference r21 = r20.f18905a;
    L27:
        Object r22 = r21.get();
        if (r22 == null) goto L47;
        g8.g r23 = i.f18853c;
        if (r22 == r23) goto L47;
        g8.g r24 = i.f18852b;
        if (r22 == r24) goto L36;
    L42:
        if (r21.compareAndSet(r22, r24) == true) goto L43;
        if (r21.get() == r22) goto L42;
    L43:
        Result.Companion r25 = Result.Companion;
        ((kotlinx.coroutines.l) r22).resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L36:
        if (r21.compareAndSet(r22, r23) == true) goto L47;
        if (r21.get() == r22) goto L36;
    L47:
        r19 = r19 + 1;
    L48:
        monitor-enter(this);
        int r110 = this.e;     // Catch: Throwable -> L54
        if (r110 == r14) goto L51;
        kotlinx.coroutines.flow.internal.c[] r111 = this.f18859a;     // Catch: Throwable -> L54
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(this);
        r15 = r111;
        r14 = r110;
        goto L20
    L51:
        this.e = r14 + 1;     // Catch: Throwable -> L54
        monitor-exit(this);
        return true;
    L54:
        th = move-exception;
        throw th;
    L62:
        this.e = r13 + 2;     // Catch: Throwable -> L10
        monitor-exit(this);
        return true;
    L10:
        th = move-exception;
        throw th;
    }
}
