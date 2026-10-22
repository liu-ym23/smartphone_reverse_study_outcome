package com.obric.assistant.chat.impl;

import bda.b$a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/chat/impl/MessageApiImpl$GetExtTaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1", f = "MessageApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MessageApiImpl$b>, Object> {
    final /* synthetic */ bda.b $callback;
    final /* synthetic */ Map<String, String> $originExt;
    final /* synthetic */ b$a $queryData;
    int label;

    public MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1(b$a r1, bda.b r2, Map<String, String> r3, Continuation<? super MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1> r4) {
        this.$queryData = r1;
        this.$callback = r2;
        this.$originExt = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1(this.$queryData, this.$callback, this.$originExt, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super MessageApiImpl$b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        b$a r5 = this.$queryData;
        if (r5 == null) goto L7;
        b$a r0 = new b$a(r5.a, r5.b);
    L9:
        return new MessageApiImpl$b(this.$callback.getExt(this.$originExt, r0), System.currentTimeMillis());
    L7:
        r0 = null;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
