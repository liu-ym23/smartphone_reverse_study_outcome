package kotlinx.coroutines.flow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00100\u000f2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\tR\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "()V", "_state", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "allocateLocked", "", "flow", "awaitPending", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeLocked", "", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class au extends kotlinx.coroutines.flow.internal.c<as<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<Object> f17430a;

    public au() {
        this.f17430a = new AtomicReference(null);
    }

    public static final /* synthetic */ AtomicReference a(au r0) {
        return r0.f17430a;
    }

    public final Object a(Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r8), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        if (kotlinx.coroutines.an.a() == false) goto L10;
        if ((!ZeusTransformUtils.instanceOf(kotlinx.coroutines.internal.g.a(a(this)), kotlinx.coroutines.o.class)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (a(this).compareAndSet(at.a(), r2) == false) goto L12;
    L22:
        Object r6 = r0.h();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L26:
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r6;
    L29:
        return Unit.INSTANCE;
    L12:
        if (kotlinx.coroutines.an.a() == true) goto L14;
    L21:
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r1 = Result.Companion;
        r9.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
        goto L22
    L14:
        if (kotlinx.coroutines.internal.g.a(a(this)) == at.b()) goto L17;
        r3 = false;
    L17:
        if (r3 == true) goto L21;
        throw new AssertionError();
    }

    public final void a() {
        AtomicReference<Object> r0 = this.f17430a;
    L3:
        Object r1 = kotlinx.coroutines.internal.g.a(r0);
        if (r1 == null) goto L5;
        if (r1 == at.b()) goto L8;
        if (r1 == at.a()) goto L12;
        if (this.f17430a.compareAndSet(r1, at.a()) == false) goto L3;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast((kotlinx.coroutines.o) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.o.class, "com.obric.memorydata.plugin"), Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;
        r4.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
        return;
    L12:
        if (this.f17430a.compareAndSet(r1, at.b()) == false) goto L3;
        return;
    L8:
        return;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* synthetic */ boolean a(as<?> r3) {
        return a2((as) ZeusTransformUtils.preCheckCast(r3, as.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(as<?> r1) {
        if (kotlinx.coroutines.internal.g.a(this.f17430a) == null) goto L6;
        return false;
    L6:
        kotlinx.coroutines.internal.g.a(this.f17430a, at.a());
        return true;
    }

    public final boolean b() {
        Object r2 = this.f17430a.getAndSet(at.a());
        Intrinsics.checkNotNull(r2);
        if (kotlinx.coroutines.an.a() == false) goto L10;
        if ((!ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.o.class)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (r2 == at.b()) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* synthetic */ Continuation[] b(as<?> r3) {
        return b2((as) ZeusTransformUtils.preCheckCast(r3, as.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public Continuation<Unit>[] b2(as<?> r1) {
        kotlinx.coroutines.internal.g.a(this.f17430a, null);
        return kotlinx.coroutines.flow.internal.b.f17452a;
    }
}
