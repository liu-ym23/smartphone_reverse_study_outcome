package com.larus.bmhome.chat.model.strategy.block;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMError;
import com.larus.platform.service.AccountService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$sendMessage$2$cb$1$onFailure$2", f = "ChatBlockSendStrategy.kt", i = {}, l = {362}, m = "invokeSuspend", n = {}, s = {})
public final class ChatBlockSendStrategy$sendMessage$2$cb$1$onFailure$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ IIMError $error;
    final /* synthetic */ Message $messageFromReq;
    final /* synthetic */ Map<String, String> $sendMessageTrackExtMap;
    int label;
    final /* synthetic */ ChatBlockSendStrategy this$0;

    public ChatBlockSendStrategy$sendMessage$2$cb$1$onFailure$2(ChatBlockSendStrategy r1, IIMError r2, Message r3, wc9.e r4, BotModel r5, Map<String, String> r6, Continuation<? super ChatBlockSendStrategy$sendMessage$2$cb$1$onFailure$2> r7) {
        this.this$0 = r1;
        this.$error = r2;
        this.$messageFromReq = r3;
        this.$conversation = r4;
        this.$bot = r5;
        this.$sendMessageTrackExtMap = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatBlockSendStrategy$sendMessage$2$cb$1$onFailure$2(this.this$0, this.$error, this.$messageFromReq, this.$conversation, this.$bot, this.$sendMessageTrackExtMap, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
    L11:
        ChatControlTrace r4 = ChatControlTrace.b;
        String r5 = this.$messageFromReq.getLocalMessageId();
        if (r5 != null) goto L14;
        String r6 = "";
    L15:
        Message r7 = this.$messageFromReq;
        Integer r8 = this.$conversation.v;
        if (r8 == null) goto L18;
        int r9 = r8.intValue();
    L19:
        BotModel r10 = this.$bot;
        if (r10 == null) goto L24;
        Integer r11 = r10.getBotType();
        if (r11 == null) goto L24;
        int r12 = r11.intValue();
    L25:
        BotModel r13 = this.$bot;
        String r14 = null;
        if (r13 == null) goto L30;
        BotCreatorInfo r15 = r13.getBotCreatorInfo();
        if (r15 == null) goto L30;
        String r16 = r15.getId();
    L31:
        boolean r17 = Intrinsics.areEqual(r16, AccountService.a.getUserId());
        ChatSendUtils r18 = ChatSendUtils.a;
        BotModel r19 = this.$bot;
        r18.getClass();
        boolean r110 = ChatSendUtils.o(r19);
        BotModel r111 = this.$bot;
        if (r111 == null) goto L38;
        String r112 = r111.getBgVideoModel();
        if (r112 == null) goto L38;
        if (r112.length() <= 0) goto L38;
    L39:
        BotModel r21 = this.$bot;
        if (r21 == null) goto L42;
        r14 = r21.getBotId();
    L42:
        if (r14 != null) goto L44;
        String r113 = "";
    L45:
        ChatControlTrace.W(r4, r6, r7, null, "im_error", r9, r12, r17, r110, r3, r113, false, this.$sendMessageTrackExtMap, null, 5120);
        return Unit.INSTANCE;
    L44:
        r113 = r14;
    L38:
        r3 = false;
    L30:
        r16 = null;
    L24:
        r12 = 0;
        goto L25
    L18:
        r9 = 0;
        goto L19
    L14:
        r6 = r5;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        ChatSender r22 = this.this$0.a.e;
        IIMError r23 = this.$error;
        this.label = 1;
        if (r22.N(r23, this) != r1) goto L11;
        return r1;
    }
}
