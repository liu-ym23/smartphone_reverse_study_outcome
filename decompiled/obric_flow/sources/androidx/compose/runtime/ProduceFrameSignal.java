package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\u0005R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "takeFrameRequestLocked", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/ProduceFrameSignal\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1502:1\n70#2:1503\n70#2:1513\n314#3,9:1504\n323#3,2:1514\n1#4:1516\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/ProduceFrameSignal\n*L\n1449#1:1503\n1456#1:1513\n1455#1:1504,9\n1455#1:1514,2\n*E\n"})
final class ProduceFrameSignal {
    private Object pendingFrameContinuation;

    public ProduceFrameSignal() {
    }

    public static final /* synthetic */ Object access$getPendingFrameContinuation$p(ProduceFrameSignal r5) {
        return r5.pendingFrameContinuation;
    }

    public static final /* synthetic */ void access$setPendingFrameContinuation$p(ProduceFrameSignal r5, Object r10) {
        r5.pendingFrameContinuation = r10;
    }

    public final Object awaitFrameRequest(Object r5, Continuation<? super Unit> r10) {
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.pendingFrameContinuation != RecomposerKt.access$getProduceAnotherFrame$p()) goto L10;
        this.pendingFrameContinuation = RecomposerKt.access$getFramePending$p();     // Catch: Throwable -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        return r11;
    L10:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        l r13 = new l(1, IntrinsicsKt.intercepted(r10));
        r13.w();
        monitor-enter(r5);
    L17:
        th = move-exception;
        throw th;
    L15:
        if (access$getPendingFrameContinuation$p(this) != RecomposerKt.access$getProduceAnotherFrame$p()) goto L19;
        access$setPendingFrameContinuation$p(this, RecomposerKt.access$getFramePending$p());     // Catch: Throwable -> L17
        l r14 = r13;
    L21:
        monitor-exit(r5);
        if (r14 == null) goto L24;
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L24:
        Object r16 = r13.v();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L28:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        return r16;
    L31:
        return Unit.INSTANCE;
    L19:
        access$setPendingFrameContinuation$p(this, r13);     // Catch: Throwable -> L17
        r14 = null;
        goto L21
    }

    public final Continuation<Unit> requestFrameLocked() {
        Object r5 = this.pendingFrameContinuation;
        if ((r5 instanceof Continuation) == false) goto L6;
        this.pendingFrameContinuation = RecomposerKt.access$getFramePending$p();
        return (Continuation) r5;
    L6:
        if (Intrinsics.areEqual(r5, RecomposerKt.access$getProduceAnotherFrame$p()) == false) goto L8;
        boolean r10 = true;
    L10:
        if (r10 == true) goto L17;
        if (r5 != null) goto L16;
        this.pendingFrameContinuation = RecomposerKt.access$getProduceAnotherFrame$p();
        goto L17
    L16:
        throw new IllegalStateException(("invalid pendingFrameContinuation " + r5).toString());
    L17:
        return null;
    L8:
        r10 = Intrinsics.areEqual(r5, RecomposerKt.access$getFramePending$p());
        goto L10
    }

    public final void takeFrameRequestLocked() {
        if (this.pendingFrameContinuation != RecomposerKt.access$getFramePending$p()) goto L7;
        this.pendingFrameContinuation = null;
        return;
    L7:
        throw new IllegalStateException("frame not pending");
    }
}
