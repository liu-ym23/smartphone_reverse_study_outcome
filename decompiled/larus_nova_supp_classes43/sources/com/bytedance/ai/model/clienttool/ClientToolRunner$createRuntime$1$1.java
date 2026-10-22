package com.bytedance.ai.model.clienttool;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.clienttool.ClientToolRunner$createRuntime$1$1", f = "ClientToolRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ClientToolRunner$createRuntime$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClientToolRuntime $invalidatedRuntime;
    int label;

    public ClientToolRunner$createRuntime$1$1(ClientToolRuntime r1, Continuation<? super ClientToolRunner$createRuntime$1$1> r10) {
        this.$invalidatedRuntime = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientToolRunner$createRuntime$1$1(this.$invalidatedRuntime, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r10);
        ClientToolRunner r11 = ClientToolRunner.a;
        ClientToolRuntime r0 = this.$invalidatedRuntime;
        r11.getClass();
        LinkedHashMap<String, ClientToolRuntime> r12 = ClientToolRunner.c;
        if (r12.get(r0.c) != r0) goto L9;
        r12.remove(r0.c);
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "remove invalidated runtimeId=" + r0.c + " packageName=" + r0.d);
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
