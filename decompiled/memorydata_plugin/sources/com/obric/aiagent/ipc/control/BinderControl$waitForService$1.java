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
@DebugMetadata(c = "com.obric.aiagent.ipc.control.BinderControl$waitForService$1", f = "BinderControl.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
final class BinderControl$waitForService$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $waitTime;
    int label;
    final /* synthetic */ a this$0;

    BinderControl$waitForService$1(long r3, a r5, Continuation<? super BinderControl$waitForService$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$waitTime = r3;
        this.this$0 = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BinderControl$waitForService$1(this.$waitTime, this.this$0, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((BinderControl$waitForService$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BinderControl$waitForService$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        a r9 = this.this$0;
        monitor-enter(r9);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (a.a(r9) != null) goto L16;
        com.obric.aiagent.ipc.utils.c.a(com.obric.aiagent.ipc.utils.c.f5945a, "IPCControl", "waitForService service is null", null, 4, null);     // Catch: Throwable -> L21
        a.b(r9, 1);     // Catch: Throwable -> L21
    L17:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r9);
        return Unit.INSTANCE;
    L16:
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "waitForService service not null");     // Catch: Throwable -> L21
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r3 = this.$waitTime;
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(r3, r12) != r0) goto L11;
        return r0;
    }
}
