package com.larus.bmhome.social.userchat.model;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatConversationRequestModel$_chatBotParticipantLiveData$2$2", f = "ChatConversationRequestModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationRequestModel$_chatBotParticipantLiveData$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ MutableLiveData<a> $botLiveData;
    int label;
    final /* synthetic */ ChatConversationRequestModel this$0;

    public ChatConversationRequestModel$_chatBotParticipantLiveData$2$2(ChatConversationRequestModel r1, String r2, MutableLiveData<a> r3, Continuation<? super ChatConversationRequestModel$_chatBotParticipantLiveData$2$2> r4) {
        this.this$0 = r1;
        this.$botId = r2;
        this.$botLiveData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatConversationRequestModel$_chatBotParticipantLiveData$2$2(this.this$0, this.$botId, this.$botLiveData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ChatConversationRequestModel r7 = this.this$0;
        String r2 = this.$botId;
        if (r7.b == false) goto L11;
        String r3 = "default_write";
    L12:
        MutableLiveData<a> r4 = this.$botLiveData;
        this.label = 1;
        if (r7.b(r2, r3, r4, this) != r0) goto L16;
        return r0;
    L11:
        r3 = "detail";
        goto L12
    }
}
