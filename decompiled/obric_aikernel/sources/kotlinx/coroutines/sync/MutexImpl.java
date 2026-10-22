package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.c3;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.q;
import kotlinx.coroutines.selects.k;
import kotlinx.coroutines.selects.l;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n332#2,12:311\n1#3:323\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n175#1:311,12\n*E\n"})
public class MutexImpl extends SemaphoreImpl implements kotlinx.coroutines.sync.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10695h = null;

    @Volatile
    private volatile Object owner;

    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    private final class CancellableContinuationWithOwner implements n<Unit>, c3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final o<Unit> f10696c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public final Object f10697g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ MutexImpl f10698h;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(MutexImpl r10, o<? super Unit> r11, Object r12) {
            this.f10698h = r10;
            this.f10696c = r11;
            this.f10697g = r12;
        }

        @Override // kotlinx.coroutines.n
        public void N(Object r10) {
            this.f10696c.N(r10);
        }

        @Override // kotlinx.coroutines.n
        public boolean a() {
            return this.f10696c.a();
        }

        public void b(Unit r10, Function1<? super Throwable, Unit> r11) {
            MutexImpl r12 = this.f10698h;
            if (n0.a() == true) goto L5;
        L12:
            MutexImpl.p().set(this.f10698h, this.f10697g);
            o<Unit> r13 = this.f10696c;
            final MutexImpl r14 = this.f10698h;
            r13.y(r10, new MutexImpl$CancellableContinuationWithOwner$resume$2(r14, this));
            return;
        L5:
            if (MutexImpl.p().get(r12) != MutexKt.c()) goto L7;
            boolean r15 = true;
        L8:
            if (r15 == true) goto L12;
            throw new AssertionError();
        L7:
            r15 = false;
            goto L8
        }

        @Override // kotlinx.coroutines.c3
        public void c(f0<?> r10, int r11) {
            this.f10696c.c(r10, r11);
        }

        public void d(CoroutineDispatcher r10, Unit r11) {
            this.f10696c.q(r10, r11);
        }

        public Object e(Unit r10, Object r11, Function1<? super Throwable, Unit> r12) {
            MutexImpl r13 = this.f10698h;
            boolean r14 = true;
            if (n0.a() == true) goto L5;
        L12:
            o<Unit> r15 = this.f10696c;
            final MutexImpl r16 = this.f10698h;
            Object r17 = r15.k(r10, r11, new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(r16, this));
            if (r17 == null) goto L25;
            MutexImpl r18 = this.f10698h;
            if (n0.a() == true) goto L17;
        L24:
            MutexImpl.p().set(this.f10698h, this.f10697g);
            goto L25
        L17:
            if (MutexImpl.p().get(r18) == MutexKt.c()) goto L20;
            r14 = false;
        L20:
            if (r14 == true) goto L24;
            throw new AssertionError();
        L25:
            return r17;
        L5:
            if (MutexImpl.p().get(r13) != MutexKt.c()) goto L7;
            boolean r19 = true;
        L8:
            if (r19 == true) goto L12;
            throw new AssertionError();
        L7:
            r19 = false;
            goto L8
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f10696c.getContext();
        }

        @Override // kotlinx.coroutines.n
        public void h(Function1<? super Throwable, Unit> r10) {
            this.f10696c.h(r10);
        }

        @Override // kotlinx.coroutines.n
        public boolean isActive() {
            return this.f10696c.isActive();
        }

        @Override // kotlinx.coroutines.n
        public Object j(Throwable r10) {
            return this.f10696c.j(r10);
        }

        @Override // kotlinx.coroutines.n
        public /* bridge */ /* synthetic */ Object k(Unit r10, Object r11, Function1 r12) {
            return e(r10, r11, r12);
        }

        @Override // kotlinx.coroutines.n
        public void m(CoroutineDispatcher r10, Throwable r11) {
            this.f10696c.m(r10, r11);
        }

        @Override // kotlinx.coroutines.n
        public /* bridge */ /* synthetic */ void q(CoroutineDispatcher r10, Unit r11) {
            d(r10, r11);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r10) {
            this.f10696c.resumeWith(r10);
        }

        @Override // kotlinx.coroutines.n
        public /* bridge */ /* synthetic */ void y(Unit r10, Function1 r11) {
            b(r10, r11);
        }

        @Override // kotlinx.coroutines.n
        public boolean z(Throwable r10) {
            return this.f10696c.z(r10);
        }
    }

    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    private final class a<Q> implements l<Q> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final l<Q> f10699c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public final Object f10700g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ MutexImpl f10701h;

        public a(MutexImpl r10, l<Q> r11, Object r12) {
            this.f10701h = r10;
            this.f10699c = r11;
            this.f10700g = r12;
        }

        @Override // kotlinx.coroutines.selects.k
        public void a(b1 r10) {
            this.f10699c.a(r10);
        }

        @Override // kotlinx.coroutines.c3
        public void c(f0<?> r10, int r11) {
            this.f10699c.c(r10, r11);
        }

        @Override // kotlinx.coroutines.selects.k
        public boolean d(Object r10, Object r11) {
            MutexImpl r12 = this.f10701h;
            if (n0.a() == true) goto L5;
        L12:
            boolean r13 = this.f10699c.d(r10, r11);
            MutexImpl r14 = this.f10701h;
            if (r13 == false) goto L15;
            MutexImpl.p().set(r14, this.f10700g);
        L15:
            return r13;
        L5:
            if (MutexImpl.p().get(r12) != MutexKt.c()) goto L7;
            boolean r15 = true;
        L8:
            if (r15 == true) goto L12;
            throw new AssertionError();
        L7:
            r15 = false;
            goto L8
        }

        @Override // kotlinx.coroutines.selects.k
        public void f(Object r10) {
            MutexImpl r11 = this.f10701h;
            if (n0.a() == true) goto L5;
        L12:
            MutexImpl.p().set(this.f10701h, this.f10700g);
            this.f10699c.f(r10);
            return;
        L5:
            if (MutexImpl.p().get(r11) != MutexKt.c()) goto L7;
            boolean r12 = true;
        L8:
            if (r12 == true) goto L12;
            throw new AssertionError();
        L7:
            r12 = false;
            goto L8
        }

        @Override // kotlinx.coroutines.selects.k
        public CoroutineContext getContext() {
            return this.f10699c.getContext();
        }
    }

    static {
        f10695h = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    }

    public MutexImpl(boolean r10) {
        super(1, r10 ? 1 : 0);
        if (r10 == false) goto L5;
        i0 r11 = null;
    L6:
        this.owner = r11;
        new MutexImpl$onSelectCancellationUnlockConstructor$1(this);
        return;
    L5:
        r11 = MutexKt.c();
        goto L6
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater p() {
        return f10695h;
    }

    private final int r(Object r10) {
    L3:
        if (s() == false) goto L4;
        Object r11 = f10695h.get(this);
        if (r11 == MutexKt.c()) goto L3;
        if (r11 != r10) goto L10;
        return 1;
    L10:
        return 2;
    L4:
        return 0;
    }

    static /* synthetic */ Object t(MutexImpl r10, Object r11, Continuation<? super Unit> r12) {
        if (r10.x(r11) == true) goto L5;
        Object r13 = r10.u(r11, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r13;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final Object u(Object r10, Continuation<? super Unit> r11) {
        o r12 = q.b(IntrinsicsKt.intercepted(r11));
        e(new CancellableContinuationWithOwner(this, r12, r10));     // Catch: Throwable -> L12
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L8:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        return r13;
    L11:
        return Unit.INSTANCE;
    L12:
        th = move-exception;
        r12.S();
        throw th;
    }

    private final int y(Object r10) {
    L2:
        boolean r11 = true;
        if (m() == true) goto L5;
        if (r10 == null) goto L17;
        int r12 = r(r10);
        if (r12 == 1) goto L23;
        if (r12 != 2) goto L2;
        return 1;
    L23:
        return 2;
    L17:
        return 1;
    L5:
        if (n0.a() == true) goto L7;
    L14:
        f10695h.set(this, r10);
        return 0;
    L7:
        if (f10695h.get(this) == MutexKt.c()) goto L10;
        r11 = false;
    L10:
        if (r11 == true) goto L14;
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.sync.a
    public Object b(Object r10, Continuation<? super Unit> r11) {
        return t(this, r10, r11);
    }

    @Override // kotlinx.coroutines.sync.a
    public void c(Object r10) {
    L3:
        if (s() == false) goto L19;
        AtomicReferenceFieldUpdater r11 = f10695h;
        Object r12 = r11.get(this);
        if (r12 == MutexKt.c()) goto L3;
        if (r12 == r10) goto L10;
        if (r10 == null) goto L10;
        boolean r13 = false;
    L11:
        if (r13 == false) goto L17;
        if (r11.compareAndSet(this, r12, MutexKt.c()) == false) goto L3;
        release();
        return;
    L17:
        throw new IllegalStateException(("This mutex is locked by " + r12 + ", but " + r10 + " is expected").toString());
    L10:
        r13 = true;
        goto L11
    L19:
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public boolean q(Object r10) {
        if (r(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean s() {
        if (k() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "Mutex@" + o0.b(this) + "[isLocked=" + s() + ",owner=" + f10695h.get(this) + ']';
    }

    protected Object v(Object r10, Object r11) {
        if (Intrinsics.areEqual(r11, MutexKt.d()) == true) goto L6;
        return this;
    L6:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r10).toString());
    }

    protected void w(k<?> r10, Object r11) {
        if (r11 != null) goto L4;
    L6:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        l(new a(this, (l) r10, r11), r11);
        return;
    L4:
        if (q(r11) == false) goto L6;
        r10.f(MutexKt.d());
    }

    public boolean x(Object r10) {
        int r11 = y(r10);
        if (r11 == 0) goto L13;
        if (r11 != 1) goto L6;
        return false;
    L6:
        if (r11 == 2) goto L10;
        throw new IllegalStateException("unexpected".toString());
    L10:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r10).toString());
    L13:
        return true;
    }
}
