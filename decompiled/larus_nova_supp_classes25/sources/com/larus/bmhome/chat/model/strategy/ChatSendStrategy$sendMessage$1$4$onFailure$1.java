package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$sendMessage$1$4$onFailure$1", f = "ChatSendStrategy.kt", i = {2}, l = {264, 266, 268}, m = "invokeSuspend", n = {"cvs"}, s = {"L$0"})
public final class ChatSendStrategy$sendMessage$1$4$onFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMError $error;
    final /* synthetic */ yc9.f0 $request;
    final /* synthetic */ Map<String, String> $sendMessageTrackExtMap;
    Object L$0;
    int label;
    final /* synthetic */ ChatSendStrategy this$0;

    public ChatSendStrategy$sendMessage$1$4$onFailure$1(ChatSendStrategy r1, IIMError r2, yc9.f0 r3, Map<String, String> r4, Continuation<? super ChatSendStrategy$sendMessage$1$4$onFailure$1> r5) {
        this.this$0 = r1;
        this.$error = r2;
        this.$request = r3;
        this.$sendMessageTrackExtMap = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatSendStrategy$sendMessage$1$4$onFailure$1(this.this$0, this.$error, this.$request, this.$sendMessageTrackExtMap, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r9 = true;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        wc9.e r1 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r27);
        Object r2 = r27;
    L25:
        BotModel r3 = (BotModel) r2;
        ChatControlTrace r11 = ChatControlTrace.b;
        yc9.f0 r4 = this.$request;
        String r5 = r4.i;
        if (r5 != null) goto L28;
        String r12 = "";
    L29:
        Message r13 = com.larus.im.internal.core.message.converter.c.a(r4);
        Integer r6 = r1.v;
        if (r6 == null) goto L32;
        int r16 = r6.intValue();
    L33:
        if (r3 == null) goto L37;
        Integer r8 = r3.getBotType();
        if (r8 == null) goto L37;
        int r17 = r8.intValue();
    L38:
        if (r3 == null) goto L42;
        BotCreatorInfo r10 = r3.getBotCreatorInfo();
        if (r10 == null) goto L42;
        String r14 = r10.getId();
    L43:
        boolean r18 = Intrinsics.areEqual(r14, AccountService.a.getUserId());
        ChatSendUtils.a.getClass();
        boolean r19 = ChatSendUtils.o(r3);
        if (r3 == null) goto L52;
        String r15 = r3.getBgVideoModel();
        if (r15 == null) goto L52;
        if (r15.length() > 0) goto L51;
        r9 = false;
    L51:
        boolean r20 = r9;
    L53:
        if (r3 == null) goto L58;
        String r21 = r3.getBotId();
        if (r21 == null) goto L58;
        String r22 = r21;
    L59:
        ChatControlTrace.W(r11, r12, r13, null, "im_error", r16, r17, r18, r19, r20, r22, false, this.$sendMessageTrackExtMap, null, 5120);
        return Unit.INSTANCE;
    L58:
        r22 = "";
    L52:
        r20 = false;
    L42:
        r14 = null;
    L37:
        r17 = 0;
        goto L38
    L32:
        r16 = 0;
        goto L33
    L28:
        r12 = r5;
        goto L29
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r27);
        Object r23 = r27;
    L18:
        r1 = (wc9.e) r23;
        if (r1 == null) goto L21;
        RepoDispatcher.a.getClass();
        BotRepo r24 = RepoDispatcher.g;
        String r25 = r1.a;
        this.L$0 = r1;
        this.label = 3;
        r2 = r24.j1(r25, false, this);
        if (r2 != r7) goto L25;
        return r7;
    L21:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r27);
    L15:
        RepoDispatcher.a.getClass();
        ConversationRepo r26 = RepoDispatcher.f;
        String r28 = this.$request.a;
        this.label = 2;
        r23 = IConversationRepoService$a.c(r26, r28, false, null, this, 6);
        if (r23 != r7) goto L18;
        return r7;
    L12:
        ResultKt.throwOnFailure(r27);
        ChatSender r29 = this.this$0.a.e;
        IIMError r30 = this.$error;
        this.label = 1;
        if (r29.N(r30, this) != r7) goto L15;
        return r7;
    }
}
