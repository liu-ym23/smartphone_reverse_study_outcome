package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,428:1\n1#2:429\n314#3,11:430\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n298#1:430,11\n*E\n"})
final class r1 extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10511a = null;

    @Volatile
    private volatile Object _state;

    static {
        f10511a = AtomicReferenceFieldUpdater.newUpdater(r1.class, Object.class, "_state");
    }

    public r1() {
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater c() {
        return f10511a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ boolean a(StateFlowImpl<?> r10) {
        return d(r10);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ Continuation[] b(StateFlowImpl<?> r10) {
        return f(r10);
    }

    public boolean d(StateFlowImpl<?> r10) {
        AtomicReferenceFieldUpdater r11 = f10511a;
        if (r11.get(this) == null) goto L6;
        return false;
    L6:
        r11.set(this, q1.b());
        return true;
    }

    public final Object e(Continuation<? super Unit> r10) {
        boolean r11 = true;
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r10), 1);
        r12.F();
        if (kotlinx.coroutines.n0.a() == false) goto L10;
        if ((!(c().get(this) instanceof kotlinx.coroutines.o)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (c().compareAndSet(this, q1.b(), r12) == false) goto L12;
    L22:
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L26:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r13;
    L29:
        return Unit.INSTANCE;
    L12:
        if (kotlinx.coroutines.n0.a() == true) goto L14;
    L21:
        Result.Companion r14 = Result.Companion;
        r12.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
        goto L22
    L14:
        if (c().get(this) == q1.c()) goto L17;
        r11 = false;
    L17:
        if (r11 == true) goto L21;
        throw new AssertionError();
    }

    public Continuation<Unit>[] f(StateFlowImpl<?> r10) {
        f10511a.set(this, null);
        return kotlinx.coroutines.flow.internal.b.f10489a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater r10 = f10511a;
    L3:
        Object r11 = r10.get(this);
        if (r11 == null) goto L5;
        if (r11 == q1.c()) goto L8;
        if (r11 == q1.b()) goto L12;
        if (f10511a.compareAndSet(this, r11, q1.b()) == false) goto L3;
        Result.Companion r12 = Result.Companion;
        ((kotlinx.coroutines.o) r11).resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
        return;
    L12:
        if (f10511a.compareAndSet(this, r11, q1.c()) == false) goto L3;
        return;
    L8:
        return;
    }

    public final boolean h() {
        Object r10 = f10511a.getAndSet(this, q1.b());
        Intrinsics.checkNotNull(r10);
        if (kotlinx.coroutines.n0.a() == false) goto L10;
        if ((!(r10 instanceof kotlinx.coroutines.o)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (r10 == q1.c()) goto L14;
        return false;
    L14:
        return true;
    }
}
