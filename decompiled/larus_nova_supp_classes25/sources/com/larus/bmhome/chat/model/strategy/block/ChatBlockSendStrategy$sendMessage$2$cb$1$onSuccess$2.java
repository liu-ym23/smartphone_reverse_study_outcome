package com.larus.bmhome.chat.model.strategy.block;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$sendMessage$2$cb$1$onSuccess$2", f = "ChatBlockSendStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatBlockSendStrategy$sendMessage$2$cb$1$onSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Message $first;
    final /* synthetic */ Map<String, String> $sendMessageTrackExtMap;
    int label;

    public ChatBlockSendStrategy$sendMessage$2$cb$1$onSuccess$2(Message r1, wc9.e r2, BotModel r3, Map<String, String> r4, Continuation<? super ChatBlockSendStrategy$sendMessage$2$cb$1$onSuccess$2> r5) {
        this.$first = r1;
        this.$conversation = r2;
        this.$bot = r3;
        this.$sendMessageTrackExtMap = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatBlockSendStrategy$sendMessage$2$cb$1$onSuccess$2(this.$first, this.$conversation, this.$bot, this.$sendMessageTrackExtMap, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L48;
        ResultKt.throwOnFailure(r20);
        ChatControlTrace r2 = ChatControlTrace.b;
        String r1 = this.$first.getLocalMessageId();
        if (r1 != null) goto L7;
        String r3 = "";
    L8:
        Message r4 = this.$first;
        String r5 = r4.getMessageId();
        Integer r6 = this.$conversation.v;
        boolean r7 = false;
        if (r6 == null) goto L11;
        int r8 = r6.intValue();
    L12:
        BotModel r9 = this.$bot;
        if (r9 == null) goto L17;
        Integer r10 = r9.getBotType();
        if (r10 == null) goto L17;
        int r11 = r10.intValue();
    L18:
        BotModel r12 = this.$bot;
        String r13 = null;
        if (r12 == null) goto L23;
        BotCreatorInfo r14 = r12.getBotCreatorInfo();
        if (r14 == null) goto L23;
        String r15 = r14.getId();
    L24:
        boolean r16 = Intrinsics.areEqual(r15, AccountService.a.getUserId());
        ChatSendUtils r17 = ChatSendUtils.a;
        BotModel r18 = this.$bot;
        r17.getClass();
        boolean r19 = ChatSendUtils.o(r18);
        BotModel r110 = this.$bot;
        if (r110 == null) goto L32;
        String r111 = r110.getBgVideoModel();
        if (r111 == null) goto L32;
        if (r111.length() <= 0) goto L31;
        r7 = true;
    L31:
        boolean r112 = r7;
    L33:
        BotModel r21 = this.$bot;
        if (r21 == null) goto L36;
        r13 = r21.getBotId();
    L36:
        if (r13 != null) goto L38;
        String r113 = "";
    L39:
        ChatControlTrace.W(r2, r3, r4, r5, "", r8, r11, r16, r19, r112, r113, false, this.$sendMessageTrackExtMap, null, 5120);
        ConcurrentHashMap r22 = ChatControlTrace.m;
        String r23 = this.$first.getMessageId();
        if (r23 != null) goto L42;
        r23 = "";
    L42:
        String r24 = this.$first.getLocalMessageId();
        if (r24 != null) goto L45;
        r24 = "";
    L45:
        r22.put(r23, r24);
        return Unit.INSTANCE;
    L38:
        r113 = r13;
    L32:
        r112 = false;
    L23:
        r15 = null;
    L17:
        r11 = 0;
        goto L18
    L11:
        r8 = 0;
        goto L12
    L7:
        r3 = r1;
        goto L8
    L48:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
