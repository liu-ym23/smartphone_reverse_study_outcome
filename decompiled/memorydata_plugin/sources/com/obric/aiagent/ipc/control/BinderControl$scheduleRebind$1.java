package com.obric.aiagent.ipc.control;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.ipc.control.BinderControl$scheduleRebind$1", f = "BinderControl.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, s = {})
final class BinderControl$scheduleRebind$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ int $reason;
    int label;
    final /* synthetic */ a this$0;

    BinderControl$scheduleRebind$1(long r3, a r5, int r6, Continuation<? super BinderControl$scheduleRebind$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$delay = r3;
        this.this$0 = r5;
        this.$reason = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BinderControl$scheduleRebind$1(this.$delay, this.this$0, this.$reason, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((BinderControl$scheduleRebind$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BinderControl$scheduleRebind$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        a r8 = this.this$0;
        long r2 = this.$delay;
        int r6 = this.$reason;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (a.a(r8) == null) goto L18;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "scheduleRebind: instance is not null, abort");     // Catch: Throwable -> L22
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r8);
        return r9;
    L18:
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "pendingRebind in " + r2 + "ms (lastDelay=" + r2 + "ms)");     // Catch: Throwable -> L22
        a.a(r8, r6);     // Catch: Throwable -> L22
        a.b(r8);     // Catch: Throwable -> L22
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        long r3 = this.$delay;
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(r3, r11) != r0) goto L11;
        return r0;
    }
}
