package com.larus.bot.impl.repository;

import com.google.gson.reflect.TypeToken;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.network.http.HttpExtKt;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "", "Lcom/larus/bot/impl/bean/EnrichBotData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotApi$requireBotEnrichCheck$2", f = "UgcBotApi.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
final class UgcBotApi$requireBotEnrichCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends List<? extends EnrichBotData>>>, Object> {
    final /* synthetic */ BotEnrichParam $param;
    int label;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/network/http/HttpExtKt$httpPost2$2", "Lcom/google/gson/reflect/TypeToken;", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends EnrichBotData>> {
        public a() {
        }
    }

    public UgcBotApi$requireBotEnrichCheck$2(BotEnrichParam r1, Continuation<? super UgcBotApi$requireBotEnrichCheck$2> r2) {
        this.$param = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcBotApi$requireBotEnrichCheck$2(this.$param, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<? extends List<EnrichBotData>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L49:
        return (com.larus.network.http.a) r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        JSONObject r4 = new JSONObject();
        BotEnrichParam r13 = this.$param;
        JSONArray r5 = new JSONArray();
        List<EnrichBotData> r14 = r13.enrichBotContent;
        if (r14 == null) goto L45;
        Iterator<T> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L45;
        EnrichBotData r6 = (EnrichBotData) r15.next();
        JSONObject r7 = new JSONObject();
        JSONArray r8 = null;
        if (r6 == null) goto L16;
        String r9 = r6.contentSource;
    L17:
        r7.putOpt("content_source", r9);
        if (r6 == null) goto L20;
        String r10 = r6.contentType;
    L21:
        r7.putOpt("content_type", r10);
        if (r6 == null) goto L24;
        List<String> r11 = r6.content;
    L25:
        List<String> r16 = r11;
        if (r16 != null) goto L28;
    L31:
        boolean r17 = true;
    L32:
        if (r17 == true) goto L44;
        r8 = new JSONArray();
        List<String> r18 = r6.content;
        if (r18 == null) goto L43;
        Iterator<T> r19 = r18.iterator();
    L38:
        if (r19.hasNext() == false) goto L43;
        String r20 = (String) r19.next();
        if (r20 != null) goto L42;
        r20 = "";
    L42:
        r8.put(r20);
    L43:
        Unit r21 = Unit.INSTANCE;
    L44:
        r7.putOpt("content", r8);
        r5.put(r7);
        goto L12
    L28:
        if (r16.isEmpty() == true) goto L31;
        r17 = false;
        goto L32
    L24:
        r11 = null;
        goto L25
    L20:
        r10 = null;
        goto L21
    L16:
        r9 = null;
    L45:
        Unit r110 = Unit.INSTANCE;
        r4.put("enrich_bot_content", r5);
        Map r22 = MapsKt.emptyMap();
        Type r111 = new a().getType();
        this.label = 1;
        r12 = HttpExtKt.m("Social", r111, "/alice/bot/enrich_check", r4, r22, true, this);
        if (r12 != r0) goto L49;
        return r0;
    }
}
