package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$sendMessage$1$4$onSuccess$1", f = "ChatSendStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatSendStrategy$sendMessage$1$4$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ wc9.e $cvs;
    final /* synthetic */ yc9.f0 $request;
    final /* synthetic */ Message $result;
    final /* synthetic */ Map<String, String> $sendMessageTrackExtMap;
    int label;

    public ChatSendStrategy$sendMessage$1$4$onSuccess$1(yc9.f0 r1, Message r2, wc9.e r3, BotModel r4, Map<String, String> r5, Continuation<? super ChatSendStrategy$sendMessage$1$4$onSuccess$1> r6) {
        this.$request = r1;
        this.$result = r2;
        this.$cvs = r3;
        this.$bot = r4;
        this.$sendMessageTrackExtMap = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSendStrategy$sendMessage$1$4$onSuccess$1(this.$request, this.$result, this.$cvs, this.$bot, this.$sendMessageTrackExtMap, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L49;
        ResultKt.throwOnFailure(r19);
        ChatControlTrace r2 = ChatControlTrace.b;
        String r1 = this.$request.i;
        if (r1 != null) goto L7;
        String r3 = "";
    L8:
        Message r4 = this.$result;
        String r5 = r4.getMessageId();
        Integer r6 = this.$cvs.v;
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
        if (r12 == null) goto L23;
        BotCreatorInfo r13 = r12.getBotCreatorInfo();
        if (r13 == null) goto L23;
        String r14 = r13.getId();
    L24:
        boolean r15 = Intrinsics.areEqual(r14, AccountService.a.getUserId());
        ChatSendUtils r16 = ChatSendUtils.a;
        BotModel r17 = this.$bot;
        r16.getClass();
        boolean r18 = ChatSendUtils.o(r17);
        BotModel r110 = this.$bot;
        if (r110 == null) goto L32;
        String r111 = r110.getBgVideoModel();
        if (r111 == null) goto L32;
        if (r111.length() <= 0) goto L31;
        r7 = true;
    L31:
        boolean r112 = r7;
    L33:
        BotModel r20 = this.$bot;
        if (r20 == null) goto L39;
        String r21 = r20.getBotId();
        if (r21 == null) goto L39;
        String r113 = r21;
    L40:
        int r22 = r8;
        ChatControlTrace.W(r2, r3, r4, r5, "", r22, r11, r15, r18, r112, r113, false, this.$sendMessageTrackExtMap, null, 5120);
        ConcurrentHashMap r23 = ChatControlTrace.m;
        String r24 = this.$result.getMessageId();
        if (r24 != null) goto L43;
        r24 = "";
    L43:
        String r25 = this.$request.i;
        if (r25 != null) goto L46;
        r25 = "";
    L46:
        r23.put(r24, r25);
        return Unit.INSTANCE;
    L39:
        r113 = "";
    L32:
        r112 = false;
    L23:
        r14 = null;
    L17:
        r11 = 0;
        goto L18
    L11:
        r8 = 0;
        goto L12
    L7:
        r3 = r1;
        goto L8
    L49:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
