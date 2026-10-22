package com.obric.aiagent.messenger.stub;

import com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$unregisterSendMessageExtCallback$1", f = "MessageIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$unregisterSendMessageExtCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowSendMessageExtCallbackIDL $callback;
    int label;

    public MessageIDLStub$unregisterSendMessageExtCallback$1(IFlowSendMessageExtCallbackIDL r1, Continuation<? super MessageIDLStub$unregisterSendMessageExtCallback$1> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessageIDLStub$unregisterSendMessageExtCallback$1(this.$callback, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        IObricChatService.a.getClass();
        IObricChatService r3 = IObricChatService.a.a();
        if (r3 == null) goto L11;
        r3.g();
        MessageApiImpl r4 = MessageApiImpl.a;
        String r0 = this.$callback.getScene();
        if (r0 != null) goto L9;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r4.a(r0);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
