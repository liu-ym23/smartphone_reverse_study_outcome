package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.appreciable.f;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.platform.service.AccountService;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$regenMessage$1", f = "ChatSendStrategy.kt", i = {2, 3}, l = {540, 544, 548, 557}, m = "invokeSuspend", n = {"questionId", "questionId"}, s = {"L$0", "L$0"})
public final class ChatSendStrategy$regenMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $answer;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Message $question;
    final /* synthetic */ String $regenInstruction;
    Object L$0;
    int label;
    final /* synthetic */ ChatSendStrategy this$0;

    public static final class a implements IIMCallback<Boolean> {
        public final /* synthetic */ Message a;
        public final /* synthetic */ Message b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r11) {
            Intrinsics.checkNotNullParameter(r11, "error");
            Intrinsics.checkNotNullParameter(r11, "error");
            if (this.a == null) goto L9;
            ISDKPointCallback.EndMsg r0 = new ISDKPointCallback.EndMsg("-10", 0, 6, false, 0, 16, null);
            f r1 = f.a;
            String r2 = this.a.getLocalMessageId();
            if (r2 != null) goto L7;
            r2 = "";
        L7:
            r1.getClass();
            f.g(r2, r0);
        L9:
            if (r11.getCode() != (-15)) goto L12;
            t19.s.a.g(AppHost.a.getApplication(), 2131907257, false);
            return;
        }

        public final void onSuccess(Object r10) {
            ((Boolean) r10).booleanValue();
            if (this.a == null) goto L9;
            ISDKPointCallback.EndMsg r11 = new ISDKPointCallback.EndMsg("regen_id_1", this.b.getContentType(), 0, false, 0, 16, null);
            f r0 = f.a;
            String r1 = this.a.getMessageId();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            r0.getClass();
            f.g(r1, r11);
            return;
        }

        public a(Message r1, Message r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ChatSendStrategy$regenMessage$1(wc9.e r1, ChatSendStrategy r2, Message r3, Message r4, String r5, ChatPageContext r6, Continuation<? super ChatSendStrategy$regenMessage$1> r7) {
        this.$conversation = r1;
        this.this$0 = r2;
        this.$answer = r3;
        this.$question = r4;
        this.$regenInstruction = r5;
        this.$chatPageContext = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatSendStrategy$regenMessage$1(this.$conversation, this.this$0, this.$answer, this.$question, this.$regenInstruction, this.$chatPageContext, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r6 = "";
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
    L42:
        BotModel r16 = (BotModel) r15;
        AppletPayloadProviderDelegate r3 = AppletPayloadProviderDelegate.a;
        String r4 = this.$answer.getConversationId();
        if (r4 != null) goto L45;
        r4 = "";
    L45:
        String r5 = null;
        if (r16 == null) goto L48;
        String r7 = r16.getBotId();
    L49:
        Map<String, String> r12 = r3.b(r4, r7, r2);
        ChatSendUtils r8 = ChatSendUtils.a;
        wc9.e r9 = this.$conversation;
        Message r10 = this.$answer;
        Message r11 = this.$question;
        String r13 = this.$regenInstruction;
        r8.getClass();
        Map r14 = MapsKt.toMutableMap(ChatSendUtils.m(r9, r10, r11, r13));
        Message r17 = this.$answer;
        ChatSendStrategy r18 = this.this$0;
        ChatPageContext r19 = this.$chatPageContext;
        String r20 = r17.getLocalMessageId();
        if (r20 != null) goto L52;
        r20 = "";
    L52:
        String r21 = r17.getMessageId();
        if (r21 == null) goto L56;
        r6 = r21;
    L56:
        ChatSendUtils.d(r20, r6, r14);
        ChatSendStrategy.k(r18, r14, r19);
        if (r16 == null) goto L59;
        String r110 = r16.getBotId();
    L60:
        UserSettingCacheManager.a.getClass();
        boolean r22 = UserSettingCacheManager.a();
        if (r16 == null) goto L65;
        SpeakerVoice r23 = r16.getVoiceType();
        if (r23 == null) goto L65;
        String r24 = r23.getLanguageCode();
    L66:
        if (r16 == null) goto L70;
        SpeakerVoice r25 = r16.getVoiceType();
        if (r25 == null) goto L70;
        String r26 = r25.getId();
    L71:
        if (r16 == null) goto L78;
        String r111 = r16.getCallerName();
        if (r111 == null) goto L78;
        if ((!StringsKt.isBlank(r111)) == false) goto L77;
        r5 = r111;
    L77:
        if (r5 == null) goto L78;
    L79:
        com.larus.im.d.e().regenMessage(new com.larus.im.internal.core.message.r(this.$answer, r110, new ClientControllerParam(r22, r24, r26, r5), r12, r14), new a(this.$question, this.$answer));
        return Unit.INSTANCE;
    L78:
        r5 = AccountService.a.getNickname();
    L70:
        r26 = null;
    L65:
        r24 = null;
        goto L66
    L59:
        r110 = null;
        goto L60
    L48:
        r7 = null;
        goto L49
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        String r27 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
    L34:
        RepoDispatcher.a.getClass();
        ChatRepo r112 = RepoDispatcher.d;
        final Message r28 = this.$question;
        r112.r1(r27, new a0(r28));
    L35:
        RepoDispatcher.a.getClass();
        BotRepo r113 = RepoDispatcher.g;
        String r29 = this.$answer.getConversationId();
        if (r29 != null) goto L38;
        r29 = "";
    L38:
        this.L$0 = r27;
        this.label = 4;
        r15 = r113.j1(r29, false, this);
        if (r15 != r0) goto L41;
        return r0;
    L41:
        r2 = r27;
        goto L42
    L12:
        ResultKt.throwOnFailure(r15);
    L23:
        r27 = this.$answer.getReplyId();
        if (r27 != null) goto L26;
    L29:
        boolean r114 = true;
    L30:
        if (r114 == true) goto L35;
        ChatSendUtils r115 = ChatSendUtils.a;
        this.L$0 = r27;
        this.label = 3;
        if (r115.s(r27, this) != r0) goto L34;
        return r0;
    L26:
        if (StringsKt.isBlank(r27) == true) goto L29;
        r114 = false;
        goto L30
    L13:
        ResultKt.throwOnFailure(r15);
    L19:
        Boolean r116 = (Boolean) r15;
    L20:
        ChatSendUtils r117 = ChatSendUtils.a;
        Message r30 = this.$answer;
        this.label = 2;
        if (r117.r(r30, this) != r0) goto L23;
        return r0;
    L14:
        ResultKt.throwOnFailure(r15);
        com.larus.bmhome.chat.helper.d0 r118 = com.larus.bmhome.chat.helper.d0.a;
        com.larus.bmhome.chat.helper.d0.c(this.$conversation);
        IObricChatSPIService r31 = (IObricChatSPIService) this.this$0.d.getValue();
        if (r31 == null) goto L20;
        String r32 = this.$conversation.a;
        this.label = 1;
        r15 = IObricChatSPIService.a.a(r31, r32, false, null, this, 6);
        if (r15 != r0) goto L19;
        return r0;
    }
}
