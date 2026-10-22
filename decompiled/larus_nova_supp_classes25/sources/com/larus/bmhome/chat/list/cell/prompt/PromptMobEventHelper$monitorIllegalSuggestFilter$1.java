package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptMobEventHelper$monitorIllegalSuggestFilter$1", f = "PromptMobEventHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PromptMobEventHelper$monitorIllegalSuggestFilter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ PromptContent $promptContent;
    private /* synthetic */ Object L$0;
    int label;

    public PromptMobEventHelper$monitorIllegalSuggestFilter$1(Message r1, PromptContent r2, Continuation<? super PromptMobEventHelper$monitorIllegalSuggestFilter$1> r3) {
        this.$data = r1;
        this.$promptContent = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PromptMobEventHelper$monitorIllegalSuggestFilter$1 r0 = new PromptMobEventHelper$monitorIllegalSuggestFilter$1(this.$data, this.$promptContent, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r20);
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        Message r5 = this.$data;
        PromptContent r6 = this.$promptContent;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L32
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L32
        r8.put("conversation_id", r5.getConversationId());     // Catch: Throwable -> L32
        r8.put("message_id", r5.getMessageId());     // Catch: Throwable -> L32
        r8.put("local_message_id", r5.getLocalMessageId());     // Catch: Throwable -> L32
        r8.put("server_index", r5.getServerIndex());     // Catch: Throwable -> L32
        r8.put("local_index", r5.getLocalIndex());     // Catch: Throwable -> L32
        r8.put("create_time", r5.getCreateTime());     // Catch: Throwable -> L32
        r8.put("content_type", String.valueOf(r5.getContentType()));     // Catch: Throwable -> L32
        List r9 = r5.getTags();     // Catch: Throwable -> L32
        if (r9 == null) goto L8;
        String r10 = CollectionsKt.joinToString$default(r9, ",", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L32
    L9:
        r8.put("tags", r10);     // Catch: Throwable -> L32
        r8.put("is_no_disappear", r6.isNoDisappear());     // Catch: Throwable -> L32
        List<PromptContent.SuggestItem> r11 = r6.getSuggestItems();     // Catch: Throwable -> L32
        int r12 = 0;
        if (r11 == null) goto L12;
        int r13 = r11.size();     // Catch: Throwable -> L32
    L13:
        r8.put("suggest_items_count", r13);     // Catch: Throwable -> L32
        List<PromptContent.SuggestV2> r14 = r6.getSuggestV2();     // Catch: Throwable -> L32
        if (r14 == null) goto L16;
        int r15 = r14.size();     // Catch: Throwable -> L32
    L17:
        r8.put("suggest_v2_count", r15);     // Catch: Throwable -> L32
        List<String> r16 = r6.getSuggest();     // Catch: Throwable -> L32
        if (r16 == null) goto L20;
        r12 = r16.size();     // Catch: Throwable -> L32
    L20:
        r8.put("legacy_suggest_count", r12);     // Catch: Throwable -> L32
        r8.put("suggest_action_card_cnt", r6.getSuggestActionCardCnt());     // Catch: Throwable -> L32
        r8.put("onboarding_display_style", r6.getOnboardingDisplayStyle());     // Catch: Throwable -> L32
        r8.put("sug_type", r6.getSugType());     // Catch: Throwable -> L32
        int r17 = com.larus.utils.p0.a;     // Catch: Throwable -> L32
        String r18 = com.larus.utils.p0.a(com.larus.bmhome.chat.bean.d.x(r5).getSuggestItemsV2());     // Catch: Throwable -> L32
        if (r18 == null) goto L24;
        FLogger.a.i("WcbSugPromptCell", "filter_illegal_suggest_msg, suggestItemsV2=".concat(r18));     // Catch: Throwable -> L32
    L24:
        String r3 = com.larus.utils.p0.a(com.larus.bmhome.chat.bean.d.x(r5).getSuggestItems());     // Catch: Throwable -> L32
        if (r3 == null) goto L27;
        FLogger.a.i("WcbSugPromptCell", "filter_illegal_suggest_msg, suggestItems=".concat(r3));     // Catch: Throwable -> L32
    L27:
        String r2 = com.larus.utils.p0.a(com.larus.bmhome.chat.bean.d.x(r5).getSuggestV2Prompt());     // Catch: Throwable -> L32
        if (r2 == null) goto L30;
        FLogger.a.i("WcbSugPromptCell", "filter_illegal_suggest_msg, suggestV2Prompt=".concat(r2));     // Catch: Throwable -> L32
    L30:
        com.larus.platform.service.g.a.monitorEventForSlardar("filter_illegal_suggest_msg", r8, null, null);     // Catch: Throwable -> L32
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L35:
        return Unit.INSTANCE;
    L16:
        r15 = 0;
        goto L17
    L12:
        r13 = 0;
        goto L13
    L8:
        r10 = null;
    L32:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
