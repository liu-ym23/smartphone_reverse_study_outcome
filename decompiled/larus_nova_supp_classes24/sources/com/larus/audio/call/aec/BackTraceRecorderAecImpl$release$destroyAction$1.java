package com.larus.audio.call.aec;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.aec.BackTraceRecorderAecImpl$release$destroyAction$1", f = "BackTraceRecorderAecImpl.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
final class BackTraceRecorderAecImpl$release$destroyAction$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BackTraceRecorderAecImpl this$0;

    public BackTraceRecorderAecImpl$release$destroyAction$1(BackTraceRecorderAecImpl r1, Continuation<? super BackTraceRecorderAecImpl$release$destroyAction$1> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new BackTraceRecorderAecImpl$release$destroyAction$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L13:
        BackTraceRecorderAecImpl r5 = this.this$0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        r5.g.set(0);     // Catch: Throwable -> L19
        r5.l = false;     // Catch: Throwable -> L19
        BackTraceRecorderAecImpl.a(r5);     // Catch: Throwable -> L19
        Unit r3 = null;
        f r6 = r5.f.getAndSet(null);     // Catch: Throwable -> L19
        if (r6 == null) goto L17;
        r6.a();     // Catch: Throwable -> L19
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r7 = Result.constructor-impl(r3);     // Catch: Throwable -> L19
    L21:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L24;
        c68.b.c("BackTraceRecorderAecImpl", "destroy failed", r8);
    L24:
        BackTraceRecorderAecImpl r9 = this.this$0;
        Object r10 = r9.c;
        monitor-enter(r10);
        r9.i = false;     // Catch: Throwable -> L30
        r9.j = false;     // Catch: Throwable -> L30
        monitor-exit(r10);
        return Unit.INSTANCE;
    L30:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Job r12 = this.this$0.k;
        if (r12 == null) goto L13;
        this.label = 1;
        if (r12.join(this) != r0) goto L13;
        return r0;
    }
}
