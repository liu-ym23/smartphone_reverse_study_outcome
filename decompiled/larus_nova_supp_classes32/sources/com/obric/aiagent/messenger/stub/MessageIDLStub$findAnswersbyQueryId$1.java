package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$findAnswersbyQueryId$1", f = "MessageIDLStub.kt", i = {}, l = {1275}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$findAnswersbyQueryId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowFindMessagesCallbackIDL $callback;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $id;
    int label;

    public MessageIDLStub$findAnswersbyQueryId$1(String r1, String r2, IFlowFindMessagesCallbackIDL r3, Continuation<? super MessageIDLStub$findAnswersbyQueryId$1> r4) {
        this.$conversationId = r1;
        this.$id = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageIDLStub$findAnswersbyQueryId$1(this.$conversationId, this.$id, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        List r6 = (List) r5;
        if (r6.isEmpty() == false) goto L16;
        IFlowFindMessagesCallbackIDL r7 = this.$callback;
        if (r7 == null) goto L24;
        r7.onFail();
    L24:
        return Unit.INSTANCE;
    L16:
        IFlowFindMessagesCallbackIDL r2 = this.$callback;
        if (r2 == null) goto L24;
        List r8 = r6;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L22;
        r3.add(com.obric.aiagent.messenger.a.a((Message) r9.next(), null));
        goto L20
    L22:
        r2.onSuccess(r3);
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MessageHelper r10 = MessageHelper.a;
        String r4 = this.$conversationId;
        String r11 = this.$id;
        this.label = 1;
        r5 = r10.b(r4, r11, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
