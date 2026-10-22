package com.obric.memorydata.memory;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.MemoryManagerWrapper$launchGatedMemoryTask$1", f = "MemoryManagerWrapper.kt", i = {}, l = {1498}, m = "invokeSuspend", n = {}, s = {})
final class MemoryManagerWrapper$launchGatedMemoryTask$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ long $epoch;
    final /* synthetic */ String $reason;
    final /* synthetic */ bx $timeoutJob;
    int label;

    MemoryManagerWrapper$launchGatedMemoryTask$1(long r3, String r5, Function1<? super Continuation<? super Unit>, ? extends Object> r6, bx r7, Continuation<? super MemoryManagerWrapper$launchGatedMemoryTask$1> r8) {
        Function1<Continuation<? super Unit>, Object> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        bx r10 = (bx) ZeusTransformUtils.wrapperContextForParams(r7, bx.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$epoch = r3;
        this.$reason = r5;
        this.$block = r9;
        this.$timeoutJob = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$launchGatedMemoryTask$1(this.$epoch, this.$reason, this.$block, this.$timeoutJob, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryManagerWrapper$launchGatedMemoryTask$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryManagerWrapper$launchGatedMemoryTask$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L7
    L20:
        bx.a.a(this.$timeoutJob, null, 1, null);
        v.a(v.f11572a, this.$epoch, this.$reason);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r11);
        if (v.a(v.f11572a, this.$epoch) == true) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "[gate] stale task dropped, epoch=" + this.$epoch + ", reason=" + this.$reason, false, 4, null);     // Catch: Throwable -> L7
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
        bx.a.a(this.$timeoutJob, null, 1, null);
        v.a(v.f11572a, this.$epoch, this.$reason);
        return r12;
    L17:
        Function1<Continuation<? super Unit>, Object> r13 = this.$block;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r13.invoke(this) != r0) goto L20;
        return r0;
    L7:
        th = move-exception;
        RunLog.INSTANCE.error("MemoryManagerWrapper", this.$reason + " failed", th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        bx.a.a(this.$timeoutJob, null, 1, null);
        v.a(v.f11572a, this.$epoch, this.$reason);
        throw th;
    }
}
