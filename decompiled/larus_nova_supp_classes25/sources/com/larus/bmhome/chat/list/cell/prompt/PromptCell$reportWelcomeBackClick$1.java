package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$reportWelcomeBackClick$1", f = "PromptCell.kt", i = {}, l = {1301}, m = "invokeSuspend", n = {}, s = {})
public final class PromptCell$reportWelcomeBackClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ PromptContent.SuggestItem $suggestItem;
    int label;

    public PromptCell$reportWelcomeBackClick$1(Message r1, PromptContent.SuggestItem r2, Continuation<? super PromptCell$reportWelcomeBackClick$1> r3) {
        this.$data = r1;
        this.$suggestItem = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PromptCell$reportWelcomeBackClick$1(this.$data, this.$suggestItem, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
    L44:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        String r1 = this.$data.getMessageId();
        if (r1 == null) goto L11;
        String r2 = StringsKt.removeSuffix(r1, ":fake_message:1");
    L12:
        String r3 = "";
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        FLogger.a.i("WcbSugPromptCell", "report WelcomeBack click conversation: " + this.$data.getConversationId() + ", message: " + this.$data.getMessageId() + ", realId: " + r2);
        Lazy<ChatApi> r4 = ChatApi.a;
        ChatApi r5 = ChatApi.a.a();
        String r6 = this.$data.getConversationId();
        if (r6 == null) goto L19;
        r3 = r6;
    L19:
        PromptContent.SuggestItem r7 = this.$suggestItem;
        this.label = 1;
        r5.getClass();
        JSONObject r8 = new JSONObject();
        r8.put("user_id", AccountService.a.getUserId());
        r8.put("conversation_id", r3);
        r8.put("msg_id", r2);
        if (r7 == null) goto L24;
        String r9 = r7.getItemType();
        if (r9 == null) goto L24;
        r8.put("suggest_item_type", r9);
    L24:
        if (r7 == null) goto L28;
        String r10 = r7.getWcbItem();
        if (r10 == null) goto L28;
        r8.put("wcb_item", r10);
    L28:
        if (r7 == null) goto L32;
        String r11 = r7.getSugBizType();
        if (r11 == null) goto L32;
        r8.put("sug_biz_type", r11);
    L32:
        if (r7 == null) goto L36;
        Boolean r12 = r7.isContinueAsk();
        if (r12 == null) goto L36;
        r8.put("is_continue_ask", r12.booleanValue());
    L36:
        if (r7 == null) goto L40;
        String r14 = r7.getRichTextType();
        if (r14 == null) goto L40;
        r8.put("rich_text_type", r14);
    L40:
        Unit r15 = Unit.INSTANCE;
        if (HttpExtKt.k("Basic", Object.class, "/biz/wcb/report", r8, null, null, false, null, null, null, this, 1008) != r13) goto L44;
        return r13;
    L11:
        r2 = null;
        goto L12
    }
}
