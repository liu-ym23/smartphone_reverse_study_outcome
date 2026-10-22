package com.larus.bmhome.chat.trace;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace$doMobClickEditMessageAsync$1", f = "ChatControlTrace.kt", i = {0}, l = {3074}, m = "invokeSuspend", n = {"replyStatus"}, s = {"L$0"})
final class ChatControlTrace$doMobClickEditMessageAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ boolean $isDeepThinkingTyping;
    final /* synthetic */ int $isLastMessage;
    final /* synthetic */ Message $lastShownMsg;
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $type;
    Object L$0;
    Object L$1;
    int label;

    public ChatControlTrace$doMobClickEditMessageAsync$1(Message r1, Message r2, boolean r3, String r4, String r5, String r6, int r7, Continuation<? super ChatControlTrace$doMobClickEditMessageAsync$1> r8) {
        this.$msg = r1;
        this.$lastShownMsg = r2;
        this.$isDeepThinkingTyping = r3;
        this.$type = r4;
        this.$scene = r5;
        this.$botId = r6;
        this.$isLastMessage = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatControlTrace$doMobClickEditMessageAsync$1(this.$msg, this.$lastShownMsg, this.$isDeepThinkingTyping, this.$type, this.$scene, this.$botId, this.$isLastMessage, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r11);
    L12:
        r2.element = r11;
        if (Intrinsics.areEqual(r3.element, "reply_completed") == false) goto L16;
        r3.element = "others";
    L16:
        if (Intrinsics.areEqual(r3.element, "replying") == true) goto L18;
    L20:
        com.larus.platform.service.o r12 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        Message r5 = this.$msg;
        String r6 = this.$type;
        String r7 = this.$scene;
        String r8 = this.$botId;
        int r9 = this.$isLastMessage;
        r4.put(MusicAppletPage.KEY_MESSAGE_ID, r5.getMessageId());
        r4.put("edit_method", r6);
        r4.put("last_send_scene", r7);
        r4.put("bot_id", r8);
        r4.put(MusicAppletPage.KEY_CONVERSATION_ID, r5.getConversationId());
        r4.put("is_last_message", r9);
        r4.put("reply_status", r3.element);
        ChatControlTrace.b.getClass();
        if (r5.getContentType() != 1) goto L24;
        String r10 = ShareType.TEXT;
    L39:
        r4.put("content_type", r10);
        r4.put("current_page", "chat");
        r4.put("user_type", ChatControlTrace.a0(r5.getUserType()));
        Unit r13 = Unit.INSTANCE;
        r12.reportEvent("click_edit_message", r4);
        return Unit.INSTANCE;
    L24:
        if (r5.getContentType() != 6) goto L27;
        r10 = ReeditType.IMAGE;
        goto L39
    L27:
        if (r5.getContentType() != 5) goto L30;
        r10 = "video";
        goto L39
    L30:
        if (r5.getContentType() != 7) goto L33;
        r10 = ShareType.FILE;
        goto L39
    L33:
        if (com.larus.im.bean.message.a.b0(r5) == false) goto L38;
        ic8.u.a.getClass();
        UplinkFileEntity r14 = (UplinkFileEntity) CollectionsKt.firstOrNull(ic8.u.a(r5));
        if (r14 == null) goto L37;
        ic8.o.a.getClass();
        r10 = ic8.o.b(r14);
        goto L39
    L37:
        r10 = null;
        goto L39
    L38:
        r10 = "";
        goto L39
    L18:
        if (this.$isDeepThinkingTyping == false) goto L20;
        r3.element = "thinking";
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        ChatControlTrace r16 = ChatControlTrace.b;
        Message r17 = this.$msg;
        Message r18 = this.$lastShownMsg;
        this.L$0 = r15;
        this.L$1 = r15;
        this.label = 1;
        Object r19 = r16.w(r17, r18, this);
        if (r19 != r0) goto L11;
        return r0;
    L11:
        r2 = r15;
        r11 = r19;
        r3 = r2;
        goto L12
    }
}
