package com.larus.dora.impl.frameassembler;

import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.frameassembler.DoraStreamingFrameAssembler$1", f = "DoraStreamingFrameAssembler.kt", i = {0}, l = {39}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DoraStreamingFrameAssembler$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $interval;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ k this$0;

    public DoraStreamingFrameAssembler$1(long r1, k r3, Continuation<? super DoraStreamingFrameAssembler$1> r4) {
        this.$interval = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DoraStreamingFrameAssembler$1 r0 = new DoraStreamingFrameAssembler$1(this.$interval, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0035 -> B:20:0x0038). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
        DoraStreamingFrameAssembler$1 r8 = this;
    L20:
        r8.this$0.b();     // Catch: Throwable -> L16
    L10:
        if (CoroutineScopeKt.isActive(r2) == false) goto L19;
        long r3 = r8.$interval;
        r8.L$0 = r2;
        r8.label = 1;
        if (DelayKt.delay(r3, r8) != r0) goto L20;
        return r0;
    L19:
        return Unit.INSTANCE;
    L16:
        th = move-exception;
        d.c("DoraStreamingFrameAssem", "cleanupExpiredSessions scheduled task error", th);
        goto L10
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r2 = (CoroutineScope) this.L$0;
        r8 = this;
        goto L10
    }
}
