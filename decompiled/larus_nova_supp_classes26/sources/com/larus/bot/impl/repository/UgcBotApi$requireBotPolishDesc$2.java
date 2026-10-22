package com.larus.bot.impl.repository;

import com.larus.bot.impl.bean.BotPolishDescResp;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.im.bean.bot.CreationIdInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotPolishDescResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotApi$requireBotPolishDesc$2", f = "UgcBotApi.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
final class UgcBotApi$requireBotPolishDesc$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotPolishDescResp>>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ BotEnrichParam $param;
    int label;

    public UgcBotApi$requireBotPolishDesc$2(String r1, BotEnrichParam r2, Continuation<? super UgcBotApi$requireBotPolishDesc$2> r3) {
        this.$botId = r1;
        this.$param = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UgcBotApi$requireBotPolishDesc$2(this.$botId, this.$param, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotPolishDescResp>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L64:
        return (com.larus.network.http.a) r1;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        JSONObject r4 = new JSONObject();
        String r5 = this.$botId;
        BotEnrichParam r6 = this.$param;
        if (o0.d(r5) == false) goto L11;
        r4.put("string_bot_id", r5);
    L11:
        JSONArray r7 = new JSONArray();
        List<EnrichBotData> r8 = r6.enrichBotContent;
        String r9 = "";
        if (r8 == null) goto L48;
        Iterator<T> r10 = r8.iterator();
    L15:
        if (r10.hasNext() == false) goto L48;
        EnrichBotData r11 = (EnrichBotData) r10.next();
        JSONObject r12 = new JSONObject();
        JSONArray r14 = null;
        if (r11 == null) goto L19;
        String r15 = r11.contentSource;
    L20:
        r12.putOpt("content_source", r15);
        if (r11 == null) goto L23;
        String r16 = r11.contentType;
    L24:
        r12.putOpt("content_type", r16);
        if (r11 == null) goto L27;
        List<String> r18 = r11.content;
    L28:
        List<String> r19 = r18;
        if (r19 != null) goto L31;
    L34:
        boolean r20 = true;
    L35:
        if (r20 == true) goto L47;
        r14 = new JSONArray();
        List<String> r21 = r11.content;
        if (r21 == null) goto L46;
        Iterator<T> r22 = r21.iterator();
    L41:
        if (r22.hasNext() == false) goto L46;
        String r110 = (String) r22.next();
        if (r110 != null) goto L45;
        r110 = "";
    L45:
        r14.put(r110);
    L46:
        Unit r23 = Unit.INSTANCE;
    L47:
        r12.putOpt("content", r14);
        r7.put(r12);
        goto L15
    L31:
        if (r19.isEmpty() == true) goto L34;
        r20 = false;
        goto L35
    L27:
        r18 = null;
        goto L28
    L23:
        r16 = null;
        goto L24
    L19:
        r15 = null;
    L48:
        Unit r24 = Unit.INSTANCE;
        r4.put("polish_bot_content", r7);
        JSONObject r25 = new JSONObject();
        CreationIdInfo r26 = r6.creationIdInfo;
        if (r26 == null) goto L54;
        String r27 = r26.getCreationId();
        if (r27 == null) goto L54;
        r9 = r27;
    L54:
        r25.putOpt("creation_id", r9);
        CreationIdInfo r28 = r6.creationIdInfo;
        if (r28 == null) goto L59;
        Integer r29 = r28.getCreationCount();
        if (r29 == null) goto L59;
        int r30 = r29.intValue();
    L60:
        r25.putOpt("creation_count", Boxing.boxInt(r30));
        r4.putOpt("creation_id_info", r25);
        this.label = 1;
        r1 = HttpExtKt.k("Social", BotPolishDescResp.class, "/alice/bot/polish_bot_desc", r4, null, null, true, null, null, null, this, 944);
        if (r1 != r13) goto L64;
        return r13;
    L59:
        r30 = 0;
        goto L60
    }
}
