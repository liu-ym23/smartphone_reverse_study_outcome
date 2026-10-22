package com.larus.bmhome.social.userchat.model;

import androidx.lifecycle.MutableLiveData;
import com.larus.im.bean.bot.BotModel;
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
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatConversationRequestModel$getBotFromDbAndServer$4", f = "ChatConversationRequestModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationRequestModel$getBotFromDbAndServer$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableLiveData<a> $botLiveData;
    final /* synthetic */ BotModel $botServer;
    int label;
    final /* synthetic */ ChatConversationRequestModel this$0;

    public ChatConversationRequestModel$getBotFromDbAndServer$4(BotModel r1, ChatConversationRequestModel r2, MutableLiveData<a> r3, Continuation<? super ChatConversationRequestModel$getBotFromDbAndServer$4> r4) {
        this.$botServer = r1;
        this.this$0 = r2;
        this.$botLiveData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatConversationRequestModel$getBotFromDbAndServer$4(this.$botServer, this.this$0, this.$botLiveData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        BotModel r5 = this.$botServer;
        if (r5 == null) goto L10;
        ChatConversationRequestModel r0 = this.this$0;
        MutableLiveData<a> r1 = this.$botLiveData;
        String r6 = r5.getBotId();
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        int r2 = ChatConversationRequestModel.r;
        r0.d();
        h r3 = new h(r1);
        r0.m = r3;
        r0.i.registerBotChangeListener(r6, r3);
        this.$botLiveData.setValue(new a(true, this.$botServer));
    L12:
        return Unit.INSTANCE;
    L10:
        this.$botLiveData.setValue(null);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
