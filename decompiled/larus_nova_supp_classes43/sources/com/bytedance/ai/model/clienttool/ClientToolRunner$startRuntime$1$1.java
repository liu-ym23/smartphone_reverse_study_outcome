package com.bytedance.ai.model.clienttool;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.clienttool.ClientToolRunner$startRuntime$1$1", f = "ClientToolRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ClientToolRunner$startRuntime$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, String, String, Boolean> $callback;
    final /* synthetic */ String $messageId;
    final /* synthetic */ ClientToolRuntime.c $result;
    final /* synthetic */ ClientToolRuntime $runtime;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientToolRunner$startRuntime$1$1(ClientToolRuntime r1, String r10, ClientToolRuntime.c r11, Function3<? super Integer, ? super String, ? super String, Boolean> r12, Continuation<? super ClientToolRunner$startRuntime$1$1> r13) {
        this.$runtime = r1;
        this.$messageId = r10;
        this.$result = r11;
        this.$callback = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientToolRunner$startRuntime$1$1(this.$runtime, this.$messageId, this.$result, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r11);
        ClientToolRunner r12 = ClientToolRunner.a;
        ClientToolRuntime r0 = this.$runtime;
        String r1 = this.$messageId;
        ClientToolRuntime.c r10 = this.$result;
        Function3<Integer, String, String, Boolean> r13 = this.$callback;
        r12.getClass();
        if (ClientToolRunner.b.get(r1) != r0) goto L38;
        String r14 = r10.b;
        boolean r15 = false;
        if (r10.a != 0) goto L10;
    L13:
        boolean r16 = true;
    L14:
        if (r16 == true) goto L41;
        r14 = null;
    L41:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L22
        Integer r18 = Integer.valueOf(r10.a);     // Catch: Throwable -> L22
        if (r14 != null) goto L20;
        r14 = "Client Tool execution failed";
    L20:
        Object r19 = Result.constructor-impl(Boolean.valueOf(((Boolean) r13.invoke(r18, r14, r10.c)).booleanValue()));     // Catch: Throwable -> L22
    L24:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L27;
        com.bytedance.ai.utils.g.a.e("ClientToolRunner", "Client Tool ACK callback failed messageId=" + r1, r20);
    L27:
        Boolean r21 = Boolean.FALSE;
        if (Result.isFailure-impl(r19) == false) goto L30;
        r19 = r21;
    L30:
        boolean r110 = ((Boolean) r19).booleanValue();
        LinkedHashMap<String, ClientToolRuntime> r22 = ClientToolRunner.b;
        r22.remove(r1);
        ClientToolRuntime.SettleResult r111 = r0.i(r1, r110);
        ClientToolRuntime.SettleResult r23 = ClientToolRuntime.SettleResult.IDLE;
        if (r111 != r23) goto L33;
        ClientToolRunner.c.put(r0.c, r0);
    L33:
        com.bytedance.ai.utils.g r24 = com.bytedance.ai.utils.g.a;
        StringBuilder r25 = new StringBuilder("finish request runtimeId=");
        r25.append(r0.c);
        r25.append(" messageId=");
        r25.append(r1);
        r25.append(" reused=");
        if (r111 != r23) goto L36;
        r15 = true;
    L36:
        r25.append(r15);
        r25.append(" active=");
        r25.append(r22.size());
        r25.append(" idle=");
        r25.append(ClientToolRunner.c.size());
        r24.i("ClientToolRunner", r25.toString());
    L22:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L10:
        if (Intrinsics.areEqual(r10.d, "reply") == true) goto L13;
        r16 = false;
    L38:
        return Unit.INSTANCE;
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
