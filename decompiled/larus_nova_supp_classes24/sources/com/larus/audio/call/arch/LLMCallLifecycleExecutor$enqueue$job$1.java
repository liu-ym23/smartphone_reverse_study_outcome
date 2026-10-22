package com.larus.audio.call.arch;

import android.os.SystemClock;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.arch.LLMCallLifecycleExecutor$enqueue$job$1", f = "LLMCallLifecycleExecutor.kt", i = {0, 0, 1, 1}, l = {120, 82}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "startAt", "$this$withLock_u24default$iv", "startAt"}, s = {"L$0", "J$0", "L$0", "J$0"})
final class LLMCallLifecycleExecutor$enqueue$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super LLMCallController.b>, Object> $block;
    final /* synthetic */ CompletableDeferred<LLMCallController.b> $deferred;
    final /* synthetic */ LifecycleStage $stage;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ u this$0;

    public LLMCallLifecycleExecutor$enqueue$job$1(u r1, CompletableDeferred<LLMCallController.b> r2, LifecycleStage r3, Function1<? super Continuation<? super LLMCallController.b>, ? extends Object> r4, Continuation<? super LLMCallLifecycleExecutor$enqueue$job$1> r5) {
        this.this$0 = r1;
        this.$deferred = r2;
        this.$stage = r3;
        this.$block = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LLMCallLifecycleExecutor$enqueue$job$1(this.this$0, this.$deferred, this.$stage, this.$block, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    public final Object invokeSuspend(Object r19) {
        long r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        long r4 = this.J$0;
        LifecycleStage r7 = (LifecycleStage) this.L$2;
        CompletableDeferred<LLMCallController.b> r8 = (CompletableDeferred) this.L$1;
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L9
        kotlinx.coroutines.sync.a r12 = r10;
        long r11 = r4;
        Object r5 = r19;
    L29:
        LLMCallController.b r6 = (LLMCallController.b) r5;     // Catch: Throwable -> L33
        com.larus.audio.call.util.e.a.i("LLMCallLifecycleExecutor", "lifecycle dispatch result=" + Reflection.getOrCreateKotlinClass(r6.getClass()).getSimpleName() + ", stage=" + r7 + ", cost=" + (SystemClock.elapsedRealtime() - r11) + "ms");     // Catch: Throwable -> L33
        r8.complete(r6);     // Catch: Throwable -> L33
    L24:
        r10 = r12;
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r10.unlock(null);     // Catch: Throwable -> L37 CancellationException -> L49
    L48:
        return Unit.INSTANCE;
    L9:
        th = th;
    L35:
        r10.unlock(null);     // Catch: Throwable -> L37 CancellationException -> L49
        throw th;     // Catch: Throwable -> L37 CancellationException -> L49
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        r11 = this.J$0;
        Function1<Continuation<? super LLMCallController.b>, Object> r9 = (Function1) this.L$4;
        LifecycleStage r13 = (LifecycleStage) this.L$3;
        CompletableDeferred<LLMCallController.b> r14 = (CompletableDeferred) this.L$2;
        u r15 = (u) this.L$1;
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L39 CancellationException -> L49
        LifecycleStage r17 = r13;
        r8 = r14;
        r12 = r16;
    L54:
        if (((Boolean) r15.c.invoke()).booleanValue() == false) goto L25;
        r8.complete(new LLMCallController.b.C0079b(r17, "TERMINATED"));     // Catch: Throwable -> L33
        goto L24
    L25:
        this.L$0 = r12;     // Catch: Throwable -> L33
        this.L$1 = r8;     // Catch: Throwable -> L33
        this.L$2 = r17;     // Catch: Throwable -> L33
        this.L$3 = null;     // Catch: Throwable -> L33
        this.L$4 = null;     // Catch: Throwable -> L33
        this.J$0 = r11;     // Catch: Throwable -> L33
        this.label = 2;     // Catch: Throwable -> L33
        r5 = r9.invoke(this);     // Catch: Throwable -> L33
        if (r5 != r2) goto L28;
        return r2;
    L28:
        r7 = r17;
    L33:
        th = th;
        r10 = r12;
        goto L35
    L16:
        ResultKt.throwOnFailure(r19);
        r11 = SystemClock.elapsedRealtime();
        r15 = this.this$0;     // Catch: Throwable -> L39 CancellationException -> L49
        kotlinx.coroutines.sync.a r20 = r15.d;     // Catch: Throwable -> L39 CancellationException -> L49
        CompletableDeferred<LLMCallController.b> r110 = this.$deferred;     // Catch: Throwable -> L39 CancellationException -> L49
        r17 = this.$stage;     // Catch: Throwable -> L39 CancellationException -> L49
        Function1<Continuation<? super LLMCallController.b>, Object> r111 = this.$block;     // Catch: Throwable -> L39 CancellationException -> L49
        this.L$0 = r20;     // Catch: Throwable -> L39 CancellationException -> L49
        this.L$1 = r15;     // Catch: Throwable -> L39 CancellationException -> L49
        this.L$2 = r110;     // Catch: Throwable -> L39 CancellationException -> L49
        this.L$3 = r17;     // Catch: Throwable -> L39 CancellationException -> L49
        this.L$4 = r111;     // Catch: Throwable -> L39 CancellationException -> L49
        this.J$0 = r11;     // Catch: Throwable -> L39 CancellationException -> L49
        this.label = 1;     // Catch: Throwable -> L39 CancellationException -> L49
        if (r20.a(null, this) != r2) goto L20;
        return r2;
    L20:
        r8 = r110;
        r12 = r20;
        r9 = r111;
    L49:
        e = move-exception;
        this.$deferred.completeExceptionally(e);
        throw e;
    L37:
        th = th;
    L41:
        com.larus.audio.call.util.e.a.e("LLMCallLifecycleExecutor", "lifecycle dispatch failed, stage=" + this.$stage + ", cost=" + (SystemClock.elapsedRealtime() - r2) + "ms", th);
        CompletableDeferred<LLMCallController.b> r21 = this.$deferred;
        LifecycleStage r22 = this.$stage;
        String r23 = th.getMessage();
        if (r23 != null) goto L46;
        r23 = Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName();
        if (r23 != null) goto L46;
        r23 = "";
    L46:
        r21.complete(new LLMCallController.b.a(r22, r23, th));
    L39:
        th = th;
        r2 = r11;
        goto L41
    }
}
