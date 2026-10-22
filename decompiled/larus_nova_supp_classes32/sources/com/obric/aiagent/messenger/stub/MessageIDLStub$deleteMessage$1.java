package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$deleteMessage$1", f = "MessageIDLStub.kt", i = {}, l = {462, 466}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$deleteMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowDeleteMessageCallbackIDL $callback;
    final /* synthetic */ String $localMessageId;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$deleteMessage$1(MessageIDLStub r1, String r2, IFlowDeleteMessageCallbackIDL r3, Continuation<? super MessageIDLStub$deleteMessage$1> r4) {
        this.this$0 = r1;
        this.$localMessageId = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageIDLStub$deleteMessage$1(this.this$0, this.$localMessageId, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L25:
        if (((Boolean) r9).booleanValue() == false) goto L29;
        IFlowDeleteMessageCallbackIDL r10 = this.$callback;
        if (r10 == null) goto L33;
        r10.onSuccess();
    L33:
        return Unit.INSTANCE;
    L29:
        IFlowDeleteMessageCallbackIDL r11 = this.$callback;
        if (r11 == null) goto L33;
        r11.onFail();
        goto L33
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        Message r12 = (Message) r9;
        if (r12 != null) goto L18;
        IFlowDeleteMessageCallbackIDL r13 = this.$callback;
        if (r13 == null) goto L33;
        r13.onFail();
        goto L33
    L18:
        MessageIDLStub r2 = this.this$0;
        String r4 = r12.getConversationId();
        if (r4 != null) goto L21;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        boolean r5 = com.larus.utils.o0.d(r12.getMessageId());
        ArrayList r14 = CollectionsKt.arrayListOf(new Message[]{r12});
        this.label = 2;
        r9 = MessageIDLStub.access$deleteMessage(r2, r4, r5, false, r14, this);
        if (r9 != r0) goto L25;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        MessageIDLStub r15 = this.this$0;
        String r3 = this.$localMessageId;
        Intrinsics.checkNotNull(r3);
        this.label = 1;
        r9 = MessageIDLStub.access$getMessageById(r15, r3, this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
