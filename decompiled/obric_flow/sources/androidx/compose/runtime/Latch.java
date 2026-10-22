package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\r\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ%\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\bø\u0001\u0001¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/Latch;", "", "()V", "_isOpen", "", "awaiters", "", "Lkotlin/coroutines/Continuation;", "", "isOpen", "()Z", "lock", "spareList", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeLatch", "openLatch", "withClosed", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Latch.kt\nandroidx/compose/runtime/Latch\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,90:1\n70#2:91\n70#2:92\n70#2:93\n70#2:103\n314#3,9:94\n323#3,2:104\n*S KotlinDebug\n*F\n+ 1 Latch.kt\nandroidx/compose/runtime/Latch\n*L\n39#1:91\n51#1:92\n57#1:93\n79#1:103\n78#1:94,9\n78#1:104,2\n*E\n"})
public final class Latch {
    private boolean _isOpen;
    private List<Continuation<Unit>> awaiters;
    private final Object lock;
    private List<Continuation<Unit>> spareList;

    public Latch() {
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
        this._isOpen = true;
    }

    public static final /* synthetic */ List access$getAwaiters$p(Latch r5) {
        return r5.awaiters;
    }

    public static final /* synthetic */ Object access$getLock$p(Latch r5) {
        return r5.lock;
    }

    public final Object await(Continuation<? super Unit> r5) {
        if (isOpen() == true) goto L5;
        final l r10 = new l(1, IntrinsicsKt.intercepted(r5));
        r10.w();
        Object r11 = access$getLock$p(this);
        monitor-enter(r11);
        access$getAwaiters$p(this).add(r10);     // Catch: Throwable -> L18
        monitor-exit(r11);
        r10.y(new Latch$await$2$2(this, r10));
        Object r12 = r10.v();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L14:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r12;
    L17:
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        throw th;
    L5:
        return Unit.INSTANCE;
    }

    public final void closeLatch() {
        Object r5 = this.lock;
        monitor-enter(r5);
        this._isOpen = false;     // Catch: Throwable -> L8
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean isOpen() {
        Object r5 = this.lock;
        monitor-enter(r5);
        boolean r10 = this._isOpen;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final void openLatch() {
        Object r5 = this.lock;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == false) goto L8;
        monitor-exit(r5);
        return;
    L8:
        List<Continuation<Unit>> r10 = this.awaiters;     // Catch: Throwable -> L11
        this.awaiters = this.spareList;     // Catch: Throwable -> L11
        this.spareList = r10;     // Catch: Throwable -> L11
        this._isOpen = true;     // Catch: Throwable -> L11
        int r11 = r10.size();     // Catch: Throwable -> L11
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L13;
        Continuation<Unit> r13 = r10.get(r12);     // Catch: Throwable -> L11
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        r13.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L11
        r12 = r12 + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        r10.clear();     // Catch: Throwable -> L11
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
    }

    public final <R> R withClosed(Function0<? extends R> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        closeLatch();
        R r10 = r5.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        openLatch();
        InlineMarker.finallyEnd(1);
        return r10;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        openLatch();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
