package com.bytedance.ai.model.clienttool;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.clienttool.ClientToolRuntime$startExecutionTimeout$timeoutJob$1", f = "ClientToolRuntime.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
final class ClientToolRuntime$startExecutionTimeout$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClientToolRuntime.a $call;
    final /* synthetic */ long $executionTimeoutMs;
    int label;
    final /* synthetic */ ClientToolRuntime this$0;

    public ClientToolRuntime$startExecutionTimeout$timeoutJob$1(long r1, ClientToolRuntime r10, ClientToolRuntime.a r11, Continuation<? super ClientToolRuntime$startExecutionTimeout$timeoutJob$1> r12) {
        this.$executionTimeoutMs = r1;
        this.this$0 = r10;
        this.$call = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientToolRuntime$startExecutionTimeout$timeoutJob$1(this.$executionTimeoutMs, this.this$0, this.$call, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        com.bytedance.ai.utils.g.a.w("ClientToolRuntime", "timeout runtimeId=" + this.this$0.c + " messageId=" + this.$call.i);
        this.this$0.c(this.$call, new ClientToolRuntime.c(-1, "Client Tool Runtime timeout", "", "execute", "execution_timeout"), false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r11 = this.$executionTimeoutMs;
        this.label = 1;
        if (DelayKt.delay(r11, this) != r0) goto L11;
        return r0;
    }
}
