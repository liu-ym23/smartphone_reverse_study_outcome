package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<e1> implements MutableSharedFlow<T>, Flow, l<T> {
    public final int e;
    public final int f;
    public final BufferOverflow g;
    public Object[] h;
    public long i;
    public long j;
    public int k;
    public int l;

    public static final class a implements m0 {
        public final SharedFlowImpl<?> a;
        public final long b;
        public final Object c;
        public final Continuation<Unit> d;

        public final void dispose() {
            SharedFlowImpl<?> r0 = this.a;
            monitor-enter(r0);
        L16:
            th = move-exception;
            throw th;
        L6:
            if (this.b >= r0.l()) goto L9;
            monitor-exit(r0);
            return;
        L9:
            Object[] r1 = r0.h;     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L16
            if (SharedFlowKt.access$getBufferAt(r1, this.b) == this) goto L13;
            monitor-exit(r0);
            return;
        L13:
            SharedFlowKt.access$setBufferAt(r1, this.b, SharedFlowKt.NO_VALUE);     // Catch: Throwable -> L16
            r0.g();     // Catch: Throwable -> L16
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(r0);
        }

        public a(SharedFlowImpl r1, long r2, Object r4, j r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BufferOverflow.values().length];
            r0[BufferOverflow.SUSPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BufferOverflow.DROP_LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BufferOverflow.DROP_OLDEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {382, 389, 392}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl<T> this$0;

        public AnonymousClass1(SharedFlowImpl<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= IntCompanionObject.MIN_VALUE;
            return SharedFlowImpl.h(this.this$0, null, this);
        }
    }

    public final Object collect(FlowCollector<? super T> r1, Continuation<?> r2) {
        return h(this, r1, r2);
    }

    public final kotlinx.coroutines.flow.internal.c[] d() {
        return new e1[2];
    }

    public final List<T> getReplayCache() {
        monitor-enter(this);
        int r1 = (int) ((l() + ((long) this.k)) - this.i);     // Catch: Throwable -> L14
        if (r1 != 0) goto L8;
        List<T> r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    L8:
        ArrayList r2 = new ArrayList(r1);     // Catch: Throwable -> L14
        Object[] r3 = this.h;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L14
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L12;
        r2.add(SharedFlowKt.access$getBufferAt(r3, this.i + ((long) r4)));     // Catch: Throwable -> L14
        r4 = r4 + 1;
        goto L9
    L12:
        monitor-exit(this);
        return r2;
    L14:
        th = move-exception;
        throw th;
    }

    public final void resetReplayCache() {
        monitor-enter(this);
        q(l() + ((long) this.k), this.j, l() + ((long) this.k), (l() + ((long) this.k)) + ((long) this.l));     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final kotlinx.coroutines.flow.internal.c c() {
        return new e1();
    }

    public final void g() {
        if (this.f == 0) goto L5;
    L7:
        Object[] r0 = this.h;
        Intrinsics.checkNotNull(r0);
    L9:
        if (this.l <= 0) goto L13;
        if (SharedFlowKt.access$getBufferAt(r0, (l() + ((long) (this.k + this.l))) - 1) != SharedFlowKt.NO_VALUE) goto L16;
        this.l--;
        SharedFlowKt.access$setBufferAt(r0, l() + ((long) (this.k + this.l)), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.l > 1) goto L7;
    }

    public final void i() {
        Object[] r0 = this.h;
        Intrinsics.checkNotNull(r0);
        SharedFlowKt.access$setBufferAt(r0, l(), null);
        this.k--;
        long r1 = l() + 1;
        if (this.i >= r1) goto L6;
        this.i = r1;
    L6:
        if (this.j < r1) goto L8;
        return;
    L8:
        if (((kotlinx.coroutines.flow.internal.a) this).b == 0) goto L21;
        kotlinx.coroutines.flow.internal.c[] r2 = ((kotlinx.coroutines.flow.internal.a) this).a;
        if (r2 == null) goto L21;
        int r3 = r2.length;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L21;
        kotlinx.coroutines.flow.internal.c r5 = r2[r4];
        if (r5 == null) goto L20;
        e1 r6 = (e1) r5;
        long r7 = r6.a;
        if (r7 < 0) goto L20;
        if (r7 >= r1) goto L20;
        r6.a = r1;
    L20:
        r4 = r4 + 1;
    L21:
        this.j = r1;
    }

    public final long l() {
        return Math.min(this.j, this.i);
    }

    public final void j(Object r7) {
        int r0 = this.k + this.l;
        Object[] r1 = this.h;
        if (r1 != null) goto L6;
        r1 = m(null, 0, 2);
    L8:
        SharedFlowKt.access$setBufferAt(r1, l() + ((long) r0), r7);
        return;
    L6:
        if (r0 < r1.length) goto L8;
        r1 = m(r1, r0, r1.length * 2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final Continuation<Unit>[] k(Continuation<Unit>[] r12) {
        int r0 = r12.length;
        if (((kotlinx.coroutines.flow.internal.a) this).b == 0) goto L21;
        kotlinx.coroutines.flow.internal.c[] r1 = ((kotlinx.coroutines.flow.internal.a) this).a;
        if (r1 == null) goto L21;
        int r2 = r1.length;
        int r3 = 0;
        r12 = r12;
    L7:
        if (r3 >= r2) goto L21;
        kotlinx.coroutines.flow.internal.c r4 = r1[r3];
        if (r4 == null) goto L19;
        e1 r5 = (e1) r4;
        Continuation r6 = r5.b;
        if (r6 == null) goto L19;
        if (o(r5) < 0) goto L19;
        int r7 = r12.length;
        r12 = r12;
        if (r0 < r7) goto L18;
        r12 = Arrays.copyOf(r12, Math.max(2, r12.length * 2));
    L18:
        ((Continuation[]) r12)[r0] = r6;
        r5.b = null;
        r0 = r0 + 1;
    L19:
        r3 = r3 + 1;
        r12 = r12;
    L21:
        return (Continuation[]) r12;
    }

    public final boolean n(T r13) {
        if (((kotlinx.coroutines.flow.internal.a) this).b != 0) goto L13;
        if (this.e == 0) goto L11;
        j(r13);
        int r0 = this.k + 1;
        this.k = r0;
        if (r0 <= this.e) goto L10;
        i();
    L10:
        this.j = l() + ((long) this.k);
    L11:
        return true;
    L13:
        if (this.k >= this.f) goto L15;
    L24:
        j(r13);
        int r1 = this.k + 1;
        this.k = r1;
        if (r1 <= this.f) goto L27;
        i();
    L27:
        long r2 = l() + ((long) this.k);
        long r3 = this.i;
        if (((int) (r2 - r3)) <= this.e) goto L30;
        q(r3 + 1, this.j, l() + ((long) this.k), (l() + ((long) this.k)) + ((long) this.l));
    L30:
        return true;
    L15:
        if (this.j > this.i) goto L24;
        BufferOverflow r4 = this.g;
        int r5 = b.a[r4.ordinal()];
        if (r5 != 1) goto L19;
        return false;
    L19:
        if (r5 != 2) goto L24;
        return true;
    }

    public final long o(e1 r7) {
        long r0 = r7.a;
        if (r0 >= (l() + ((long) this.k))) goto L6;
        return r0;
    L6:
        if (this.f <= 0) goto L9;
        return -1;
    L9:
        if (r0 <= l()) goto L12;
        return -1;
    L12:
        if (this.l != 0) goto L14;
        return -1;
    L14:
        return r0;
    }

    public final Object p(e1 r9) {
        Continuation<Unit>[] r0 = kotlinx.coroutines.flow.internal.b.a;
        monitor-enter(this);
        long r1 = o(r9);     // Catch: Throwable -> L20
        if (r1 >= 0) goto L7;
        Object r10 = SharedFlowKt.NO_VALUE;     // Catch: Throwable -> L20
    L12:
        monitor-exit(this);
        int r2 = r0.length;
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L19;
        Continuation<Unit> r4 = r0[r3];
        if (r4 == null) goto L18;
        Result.Companion r5 = Result.Companion;
        r4.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    L18:
        r3 = r3 + 1;
        goto L14
    L19:
        return r10;
    L7:
        long r6 = r9.a;     // Catch: Throwable -> L20
        Object[] r7 = this.h;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L20
        Object r8 = SharedFlowKt.access$getBufferAt(r7, r1);     // Catch: Throwable -> L20
        if ((r8 instanceof a) == false) goto L10;
        r8 = ((a) r8).c;     // Catch: Throwable -> L20
    L10:
        r9.a = r1 + 1;     // Catch: Throwable -> L20
        Object r11 = r8;
        r0 = r(r6);     // Catch: Throwable -> L20
        r10 = r11;
    L20:
        th = move-exception;
        throw th;
    }

    public final Continuation<Unit>[] r(long r22) {
        long r0 = this.j;
        Continuation<Unit>[] r2 = kotlinx.coroutines.flow.internal.b.a;
        if (r22 <= r0) goto L5;
        return r2;
    L5:
        long r1 = l();
        long r3 = ((long) this.k) + r1;
        if (this.f != 0) goto L11;
        if (this.l <= 0) goto L11;
        r3 = r3 + 1;
    L11:
        if (((kotlinx.coroutines.flow.internal.a) this).b == 0) goto L25;
        kotlinx.coroutines.flow.internal.c[] r5 = ((kotlinx.coroutines.flow.internal.a) this).a;
        if (r5 == null) goto L25;
        int r8 = r5.length;
        int r11 = 0;
    L15:
        if (r11 >= r8) goto L25;
        kotlinx.coroutines.flow.internal.c r12 = r5[r11];
        if (r12 == null) goto L23;
        long r13 = ((e1) r12).a;
        if (r13 < 0) goto L23;
        if (r13 >= r3) goto L23;
        r3 = r13;
    L23:
        r11 = r11 + 1;
    L25:
        if (r3 > this.j) goto L27;
        return r2;
    L27:
        long r14 = l() + ((long) this.k);
        if (((kotlinx.coroutines.flow.internal.a) this).b <= 0) goto L30;
        int r6 = Math.min(this.l, this.f - ((int) (r14 - r3)));
    L31:
        long r15 = ((long) this.l) + r14;
        if (r6 <= 0) goto L45;
        r2 = new Continuation[r6];
        Object[] r9 = this.h;
        Intrinsics.checkNotNull(r9);
        long r7 = r14;
        int r16 = 0;
    L35:
        if (r14 >= r15) goto L43;
        Object r10 = SharedFlowKt.access$getBufferAt(r9, r14);
        long r17 = r3;
        kotlinx.coroutines.internal.b0 r4 = SharedFlowKt.NO_VALUE;
        if (r10 == r4) goto L41;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        a r18 = (a) r10;
        int r19 = r16 + 1;
        long r110 = r15;
        r2[r16] = r18.d;
        SharedFlowKt.access$setBufferAt(r9, r14, r4);
        SharedFlowKt.access$setBufferAt(r9, r7, r18.c);
        long r111 = 1;
        r7 = r7 + 1;
        if (r19 >= r6) goto L44;
        r16 = r19;
    L42:
        r14 = r14 + r111;
        r3 = r17;
        r15 = r110;
    L44:
        r14 = r7;
    L46:
        Continuation<Unit>[] r112 = r2;
        int r20 = (int) (r14 - r1);
        if (((kotlinx.coroutines.flow.internal.a) this).b != 0) goto L49;
        long r21 = r14;
    L50:
        long r23 = Math.max(this.i, r14 - ((long) Math.min(this.e, r20)));
        if (this.f == 0) goto L53;
    L57:
        q(r23, r21, r14, r110);
        g();
        if (r112.length != 0) goto L60;
        boolean r113 = true;
    L62:
        if ((!r113) == true) goto L64;
        return r112;
    L64:
        return k(r112);
    L60:
        r113 = false;
        goto L62
    L53:
        if (r23 >= r110) goto L57;
        Object[] r24 = this.h;
        Intrinsics.checkNotNull(r24);
        if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(r24, r23), SharedFlowKt.NO_VALUE) == false) goto L57;
        r14 = r14 + 1;
        r23 = r23 + 1;
        goto L57
    L49:
        r21 = r17;
        goto L50
    L41:
        r110 = r15;
        r111 = 1;
        goto L42
    L43:
        r17 = r3;
        r110 = r15;
        goto L44
    L45:
        r17 = r3;
        r110 = r15;
        goto L46
    L30:
        r6 = this.l;
        goto L31
    }

    public final boolean tryEmit(T r6) {
        Continuation<Unit>[] r0 = kotlinx.coroutines.flow.internal.b.a;
        monitor-enter(this);
        int r1 = 0;
        if (n(r6) == false) goto L8;
        r0 = k(r0);     // Catch: Throwable -> L17
        boolean r7 = true;
    L9:
        monitor-exit(this);
        int r2 = r0.length;
    L11:
        if (r1 >= r2) goto L16;
        Continuation<Unit> r3 = r0[r1];
        if (r3 == null) goto L15;
        Result.Companion r4 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    L15:
        r1 = r1 + 1;
        goto L11
    L16:
        return r7;
    L8:
        r7 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final Object emit(T r11, Continuation<? super Unit> r12) {
        if (tryEmit(r11) == true) goto L42;
        j r6 = new j(IntrinsicsKt.intercepted(r12), 1);
        r6.C();
        Continuation<Unit>[] r8 = kotlinx.coroutines.flow.internal.b.a;
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L8:
        if (n(r11) == false) goto L10;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L35
        r6.resumeWith(Result.constructor-impl(Unit.INSTANCE));     // Catch: Throwable -> L35
        Continuation<Unit>[] r14 = k(r8);     // Catch: Throwable -> L35
        a r0 = null;
    L14:
        monitor-exit(this);
        if (r0 == null) goto L17;
        kotlinx.coroutines.l.b(r6, new n0(r0));
    L17:
        int r1 = r14.length;
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L23;
        Continuation<Unit> r3 = r14[r2];
        if (r3 == null) goto L22;
        Result.Companion r4 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    L22:
        r2 = r2 + 1;
        goto L18
    L23:
        Object r15 = r6.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L27:
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        r15 = Unit.INSTANCE;
    L31:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        return r15;
    L34:
        return Unit.INSTANCE;
    L10:
        a r9 = new a(this, ((long) (this.k + this.l)) + l(), r11, r6);     // Catch: Throwable -> L35
        j(r9);     // Catch: Throwable -> L35
        this.l++;     // Catch: Throwable -> L35
        if (this.f != 0) goto L13;
        r8 = k(r8);     // Catch: Throwable -> L35
    L13:
        r14 = r8;
        r0 = r9;
        goto L14
    L42:
        return Unit.INSTANCE;
    }

    public final Object f(e1 r7, Continuation<? super Unit> r8) {
        j r0 = new j(IntrinsicsKt.intercepted(r8), 1);
        r0.C();
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (o(r7) >= 0) goto L7;
        r7.b = r0;     // Catch: Throwable -> L18
    L8:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        Object r10 = r0.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L14:
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r10;
    L17:
        return Unit.INSTANCE;
    L7:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L18
        r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));     // Catch: Throwable -> L18
        goto L8
    }

    public SharedFlowImpl(int r1, int r2, BufferOverflow r3) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
    }

    public static /* synthetic */ <T> Object h(SharedFlowImpl<T> r8, FlowCollector<? super T> r9, Continuation<?> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        Job r12 = (Job) r0.L$3;
        e1 r13 = (e1) r0.L$2;
        FlowCollector<? super T> r4 = (FlowCollector) r0.L$1;
        SharedFlowImpl<T> r5 = (SharedFlowImpl) r0.L$0;
    L56:
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L19
        FlowCollector<? super T> r14 = r4;
        Job r6 = r12;
        r8 = r5;
    L34:
        Object r7 = r8.p(r13);     // Catch: Throwable -> L44
        if (r7 == SharedFlowKt.NO_VALUE) goto L36;
        if (r6 == null) goto L41;
        JobKt.ensureActive(r6);     // Catch: Throwable -> L44
    L41:
        r0.L$0 = r8;     // Catch: Throwable -> L44
        r0.L$1 = r14;     // Catch: Throwable -> L44
        r0.L$2 = r13;     // Catch: Throwable -> L44
        r0.L$3 = r6;     // Catch: Throwable -> L44
        r0.label = 3;     // Catch: Throwable -> L44
        if (r14.emit(r7, r0) != r2) goto L34;
        return r2;
    L36:
        r0.L$0 = r8;     // Catch: Throwable -> L44
        r0.L$1 = r14;     // Catch: Throwable -> L44
        r0.L$2 = r13;     // Catch: Throwable -> L44
        r0.L$3 = r6;     // Catch: Throwable -> L44
        r0.label = 2;     // Catch: Throwable -> L44
        if (r8.f(r13, r0) != r2) goto L34;
        return r2;
    L44:
        th = move-exception;
        r5 = r8;
        Throwable th = th;
    L48:
        r5.e(r13);
        throw th;
    L19:
        th = th;
        goto L48
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r12 = (Job) r0.L$3;
        r13 = (e1) r0.L$2;
        r4 = (FlowCollector) r0.L$1;
        r5 = (SharedFlowImpl) r0.L$0;
        goto L56
    L21:
        r13 = (e1) r0.L$2;
        FlowCollector<? super T> r15 = (FlowCollector) r0.L$1;
        SharedFlowImpl<T> r16 = (SharedFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L24
        r14 = r15;
        r8 = r16;
    L52:
        r6 = r0.getContext().get(Job.Key);     // Catch: Throwable -> L44
    L24:
        th = th;
        r5 = r16;
        goto L48
    L26:
        ResultKt.throwOnFailure(r11);
        e1 r17 = (e1) r8.b();
    L46:
        th = move-exception;
        r5 = r8;
        th = th;
        r13 = r17;
        goto L48
    L28:
        if ((r9 instanceof SubscribedFlowCollector) == false) goto L32;
        r0.L$0 = r8;     // Catch: Throwable -> L46
        r0.L$1 = r9;     // Catch: Throwable -> L46
        r0.L$2 = r17;     // Catch: Throwable -> L46
        r0.label = 1;     // Catch: Throwable -> L46
        if (((SubscribedFlowCollector) r9).a(r0) != r2) goto L32;
        return r2;
    L32:
        r14 = r9;
        r13 = r17;
    L7:
        r0 = new AnonymousClass1(r8, r10);
        goto L8
    }

    public final Flow<T> a(CoroutineContext r1, int r2, BufferOverflow r3) {
        return SharedFlowKt.fuseSharedFlow(this, r1, r2, r3);
    }

    public final Object[] m(Object[] r7, int r8, int r9) {
        int r0 = 0;
        if (r9 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        Object[] r10 = new Object[r9];
        this.h = r10;
        if (r7 != null) goto L10;
        return r10;
    L10:
        long r2 = l();
    L11:
        if (r0 >= r8) goto L13;
        long r3 = ((long) r0) + r2;
        SharedFlowKt.access$setBufferAt(r10, r3, SharedFlowKt.access$getBufferAt(r7, r3));
        r0 = r0 + 1;
        goto L11
    L13:
        return r10;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final void q(long r7, long r9, long r11, long r13) {
        long r0 = Math.min(r9, r7);
        long r2 = l();
    L4:
        if (r2 >= r0) goto L6;
        Object[] r4 = this.h;
        Intrinsics.checkNotNull(r4);
        SharedFlowKt.access$setBufferAt(r4, r2, null);
        r2 = r2 + 1;
        goto L4
    L6:
        this.i = r7;
        this.j = r9;
        this.k = (int) (r11 - r0);
        this.l = (int) (r13 - r11);
    }
}
