package com.larus.bot.impl.repository;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.bot.impl.bean.BotEnrichRespData;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.im.bean.bot.CreationIdInfo;
import com.larus.network.http.HttpExtKt;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotEnrichRespData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotApi$requireEnrichBot$2", f = "UgcBotApi.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
final class UgcBotApi$requireEnrichBot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotEnrichRespData>>, Object> {
    final /* synthetic */ BotEnrichParam $param;
    int label;

    public UgcBotApi$requireEnrichBot$2(BotEnrichParam r1, Continuation<? super UgcBotApi$requireEnrichBot$2> r2) {
        this.$param = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcBotApi$requireEnrichBot$2(this.$param, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotEnrichRespData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L63:
        return (com.larus.network.http.a) r1;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        RequestContext r8 = new RequestContext();
        ((BaseRequestContext) r8).timeout_connect = 60000;
        ((BaseRequestContext) r8).timeout_read = 60000;
        JSONObject r4 = new JSONObject();
        BotEnrichParam r5 = this.$param;
        r4.putOpt("name", r5.name);
        r4.putOpt("bot_lang", r5.botLang);
        r4.putOpt("need_desc", r5.needDesc);
        r4.putOpt("need_voice_type", r5.needVoiceType);
        r4.putOpt("bg_img_prompt", r5.bgImgPrompt);
        List<EnrichBotData> r6 = r5.enrichBotContent;
        String r10 = "";
        if (r6 == null) goto L46;
        JSONArray r11 = new JSONArray();
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L45;
        EnrichBotData r14 = (EnrichBotData) r7.next();
        JSONObject r15 = new JSONObject();
        if (r14 == null) goto L16;
        String r9 = r14.contentSource;
    L17:
        r15.putOpt("content_source", r9);
        if (r14 == null) goto L20;
        String r12 = r14.contentType;
    L21:
        r15.putOpt("content_type", r12);
        if (r14 == null) goto L24;
        List<String> r16 = r14.content;
    L25:
        List<String> r18 = r16;
        if (r18 != null) goto L28;
    L31:
        boolean r19 = true;
    L32:
        if (r19 == false) goto L34;
        JSONArray r20 = null;
    L44:
        r15.putOpt("content", r20);
        r11.put(r15);
        goto L12
    L34:
        r20 = new JSONArray();
        List<String> r21 = r14.content;
        if (r21 == null) goto L43;
        Iterator<T> r22 = r21.iterator();
    L38:
        if (r22.hasNext() == false) goto L43;
        String r110 = (String) r22.next();
        if (r110 != null) goto L42;
        r110 = "";
    L42:
        r20.put(r110);
    L43:
        Unit r23 = Unit.INSTANCE;
        goto L44
    L28:
        if (r18.isEmpty() == true) goto L31;
        r19 = false;
        goto L32
    L24:
        r16 = null;
        goto L25
    L20:
        r12 = null;
        goto L21
    L16:
        r9 = null;
        goto L17
    L45:
        Object r24 = r11;
    L47:
        r4.putOpt("data", r24);
        JSONObject r25 = new JSONObject();
        CreationIdInfo r26 = r5.creationIdInfo;
        if (r26 == null) goto L53;
        String r27 = r26.getCreationId();
        if (r27 == null) goto L53;
        r10 = r27;
    L53:
        r25.putOpt("creation_id", r10);
        CreationIdInfo r28 = r5.creationIdInfo;
        if (r28 == null) goto L58;
        Integer r29 = r28.getCreationCount();
        if (r29 == null) goto L58;
        int r30 = r29.intValue();
    L59:
        r25.putOpt("creation_count", Boxing.boxInt(r30));
        Unit r31 = Unit.INSTANCE;
        r4.putOpt("creation_id_info", r25);
        this.label = 1;
        r1 = HttpExtKt.k("Social", BotEnrichRespData.class, "/alice/bot/enrich", r4, null, null, true, null, r8, null, this, 688);
        if (r1 != r13) goto L63;
        return r13;
    L58:
        r30 = 0;
        goto L59
    L46:
        r24 = null;
        goto L47
    }
}
