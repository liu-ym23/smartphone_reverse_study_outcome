package com.obric.aiagent.ipc.control;

import com.obric.aiagent.ipc.utils.e;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.ipc.control.BinderControl$scheduleRebind$1", f = "BinderControl.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
public final class BinderControl$scheduleRebind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ int $reason;
    int label;
    final /* synthetic */ BinderControl this$0;

    public BinderControl$scheduleRebind$1(long r1, BinderControl r3, int r4, Continuation<? super BinderControl$scheduleRebind$1> r5) {
        this.$delay = r1;
        this.this$0 = r3;
        this.$reason = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BinderControl$scheduleRebind$1(this.$delay, this.this$0, this.$reason, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        BinderControl r8 = this.this$0;
        long r3 = this.$delay;
        int r4 = this.$reason;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (r8.f == null) goto L18;
        e.a("IPCControl", "scheduleRebind: instance is not null, abort");     // Catch: Throwable -> L22
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r8);
        return r0;
    L18:
        int r5 = e.a;     // Catch: Throwable -> L22
        e.a("IPCControl", "pendingRebind in " + r3 + "ms (lastDelay=" + r3 + "ms)");     // Catch: Throwable -> L22
        BinderControl.d(r8, r4);     // Catch: Throwable -> L22
        r8.h();     // Catch: Throwable -> L22
        monitor-exit(r8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        long r6 = this.$delay;
        this.label = 1;
        if (DelayKt.delay(r6, this) != r1) goto L11;
        return r1;
    }
}
