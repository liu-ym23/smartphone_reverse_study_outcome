package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0012\u001a\u00020\u00042\f\b\u0002\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aJ+\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "awaiters", "", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "failureCause", "", "hasAwaiters", "", "getHasAwaiters", "()Z", "lock", "", "spareList", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fail", "cause", "sendFrame", "timeNanos", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FrameAwaiter", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBroadcastFrameClock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastFrameClock.kt\nandroidx/compose/runtime/BroadcastFrameClock\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,132:1\n70#2:133\n70#2:134\n70#2:144\n70#2:147\n314#3,9:135\n323#3,2:145\n33#4,6:148\n*S KotlinDebug\n*F\n+ 1 BroadcastFrameClock.kt\nandroidx/compose/runtime/BroadcastFrameClock\n*L\n54#1:133\n62#1:134\n81#1:144\n112#1:147\n79#1:135,9\n79#1:145,2\n115#1:148,6\n*E\n"})
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private List<FrameAwaiter<?>> awaiters;
    private Throwable failureCause;
    private final Object lock;
    private final Function0<Unit> onNewAwaiters;
    private List<FrameAwaiter<?>> spareList;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "getContinuation", "()Lkotlin/coroutines/Continuation;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "resume", "", "timeNanos", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBroadcastFrameClock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastFrameClock.kt\nandroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,132:1\n1#2:133\n*E\n"})
    public static final class FrameAwaiter<R> {
        private final Continuation<R> continuation;
        private final Function1<Long, R> onFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public FrameAwaiter(Function1<? super Long, ? extends R> r5, Continuation<? super R> r10) {
            Intrinsics.checkNotNullParameter(r5, "onFrame");
            Intrinsics.checkNotNullParameter(r10, "continuation");
            this.onFrame = r5;
            this.continuation = r10;
        }

        public final Continuation<R> getContinuation() {
            return this.continuation;
        }

        public final Function1<Long, R> getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long r5) {
            Continuation<R> r10 = this.continuation;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
            Object r12 = Result.m124constructorimpl(this.onFrame.invoke(Long.valueOf(r5)));     // Catch: Throwable -> L5
        L7:
            r10.resumeWith(r12);
            return;
        L5:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastFrameClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ void access$fail(BroadcastFrameClock r5, Throwable r10) {
        r5.fail(r10);
    }

    public static final /* synthetic */ List access$getAwaiters$p(BroadcastFrameClock r5) {
        return r5.awaiters;
    }

    public static final /* synthetic */ Throwable access$getFailureCause$p(BroadcastFrameClock r5) {
        return r5.failureCause;
    }

    public static final /* synthetic */ Object access$getLock$p(BroadcastFrameClock r5) {
        return r5.lock;
    }

    public static final /* synthetic */ Function0 access$getOnNewAwaiters$p(BroadcastFrameClock r5) {
        return r5.onNewAwaiters;
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock r5, CancellationException r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = new CancellationException("clock cancelled");
    L5:
        r5.cancel(r10);
    }

    private final void fail(Throwable r10) {
        Object r5 = this.lock;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.failureCause == null) goto L8;
        monitor-exit(r5);
        return;
    L8:
        this.failureCause = r10;     // Catch: Throwable -> L11
        List<FrameAwaiter<?>> r11 = this.awaiters;     // Catch: Throwable -> L11
        int r12 = r11.size();     // Catch: Throwable -> L11
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L13;
        Continuation<?> r14 = r11.get(r13).getContinuation();     // Catch: Throwable -> L11
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L11
        r14.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r10)));     // Catch: Throwable -> L11
        r13 = r13 + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        this.awaiters.clear();     // Catch: Throwable -> L11
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
    }

    public final void cancel(CancellationException r5) {
        Intrinsics.checkNotNullParameter(r5, "cancellationException");
        fail(r5);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r5, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r10) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r5, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r5) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, r5);
    }

    public final boolean getHasAwaiters() {
        Object r5 = this.lock;
        monitor-enter(r5);
        boolean r10 = !this.awaiters.isEmpty();
        monitor-exit(r5);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r5) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, r5);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r5) {
        return MonotonicFrameClock.DefaultImpls.plus(this, r5);
    }

    public final void sendFrame(long r5) {
        Object r10 = this.lock;
        monitor-enter(r10);
        List<FrameAwaiter<?>> r11 = this.awaiters;     // Catch: Throwable -> L7
        this.awaiters = this.spareList;     // Catch: Throwable -> L7
        this.spareList = r11;     // Catch: Throwable -> L7
        int r12 = r11.size();     // Catch: Throwable -> L7
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11.get(r13).resume(r5);     // Catch: Throwable -> L7
        r13 = r13 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        r11.clear();     // Catch: Throwable -> L7
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter] */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> r10, Continuation<? super R> r11) {
        l r5 = new l(1, IntrinsicsKt.intercepted(r11));
        r5.w();
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        Object r13 = access$getLock$p(this);
        monitor-enter(r13);
        Throwable r14 = access$getFailureCause$p(this);     // Catch: Throwable -> L9
        if (r14 == null) goto L11;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L9
        r5.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r14)));     // Catch: Throwable -> L9
        monitor-exit(r13);
    L25:
        Object r16 = r5.v();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L28:
        return r16;
    L11:
        r12.element = new FrameAwaiter(r10, r5);     // Catch: Throwable -> L9
        boolean r17 = access$getAwaiters$p(this).isEmpty();     // Catch: Throwable -> L9
        List r18 = access$getAwaiters$p(this);     // Catch: Throwable -> L9
        T r19 = r12.element;     // Catch: Throwable -> L9
        if (r19 != 0) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("awaiter");     // Catch: Throwable -> L9
        FrameAwaiter r20 = null;
    L15:
        r18.add(r20);     // Catch: Throwable -> L9
        monitor-exit(r13);
        r5.y(new BroadcastFrameClock$withFrameNanos$2$1(this, r12));
        if (r17 == false) goto L25;
        if (access$getOnNewAwaiters$p(this) == null) goto L25;
        access$getOnNewAwaiters$p(this).invoke();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        access$fail(this, th);
        goto L25
    L14:
        r20 = (FrameAwaiter) r19;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public BroadcastFrameClock(Function0<Unit> r5) {
        this.onNewAwaiters = r5;
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
    }

    public /* synthetic */ BroadcastFrameClock(Function0 r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
