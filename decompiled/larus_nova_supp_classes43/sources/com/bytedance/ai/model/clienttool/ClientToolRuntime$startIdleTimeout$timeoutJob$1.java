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
@DebugMetadata(c = "com.bytedance.ai.model.clienttool.ClientToolRuntime$startIdleTimeout$timeoutJob$1", f = "ClientToolRuntime.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {})
public final class ClientToolRuntime$startIdleTimeout$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClientToolRuntime.d.c $idle;
    int label;
    final /* synthetic */ ClientToolRuntime this$0;

    public ClientToolRuntime$startIdleTimeout$timeoutJob$1(ClientToolRuntime r1, ClientToolRuntime.d.c r10, Continuation<? super ClientToolRuntime$startIdleTimeout$timeoutJob$1> r11) {
        this.this$0 = r1;
        this.$idle = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientToolRuntime$startIdleTimeout$timeoutJob$1(this.this$0, this.$idle, r11);
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
        boolean r11 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        ClientToolRuntime r12 = this.this$0;
        Object r13 = r12.i;
        ClientToolRuntime.d.c r14 = this.$idle;
        monitor-enter(r13);
    L17:
        th = move-exception;
        throw th;
    L14:
        if (r12.l != r14) goto L19;
        r14.a = null;     // Catch: Throwable -> L17
        r12.l = ClientToolRuntime.d.b.a;     // Catch: Throwable -> L17
    L20:
        monitor-exit(r13);
        if (r11 == false) goto L23;
        com.bytedance.ai.utils.g.a.i("ClientToolRuntime", "idle timeout runtimeId=" + this.this$0.c + " appletId=" + this.this$0.f);
        this.this$0.g();
        ClientToolRuntime r15 = this.this$0;
        r15.b.invoke(r15);
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L19:
        r11 = false;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(300000, this) != r0) goto L11;
        return r0;
    }
}
