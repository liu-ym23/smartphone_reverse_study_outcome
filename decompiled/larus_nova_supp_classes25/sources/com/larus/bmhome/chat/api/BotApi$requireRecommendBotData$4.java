package com.larus.bmhome.chat.api;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.BotApi$requireRecommendBotData$4", f = "BotApi.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_21}, m = "invokeSuspend", n = {}, s = {})
final class BotApi$requireRecommendBotData$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.o0>, Object> {
    final /* synthetic */ long $curMaxIndex;
    final /* synthetic */ boolean $isFirstReq;
    final /* synthetic */ long $lastIndex;
    final /* synthetic */ List<Message> $payload;
    final /* synthetic */ int $recommendType;
    int label;

    public BotApi$requireRecommendBotData$4(List<Message> r1, int r2, boolean r3, long r4, long r6, Continuation<? super BotApi$requireRecommendBotData$4> r8) {
        this.$payload = r1;
        this.$recommendType = r2;
        this.$isFirstReq = r3;
        this.$lastIndex = r4;
        this.$curMaxIndex = r6;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new BotApi$requireRecommendBotData$4(this.$payload, this.$recommendType, this.$isFirstReq, this.$lastIndex, this.$curMaxIndex, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ic8.o0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L18:
        ic8.o0 r2 = (ic8.o0) ((a) r1).b;
        if (r2 == null) goto L21;
        int r3 = this.$recommendType;
        Lazy<BotApi> r4 = BotApi.a;
        r2.i(BotApi.a.a(r3));
        return r2;
    L21:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        JSONArray r5 = new JSONArray();
        Iterator<T> r6 = this.$payload.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        Message r7 = (Message) r6.next();
        JSONObject r8 = new JSONObject();
        r8.put("msg_id", r7.getMessageId());
        r8.put("create_time", r7.getCreateTime());
        r5.put(r8);
        goto L10
    L12:
        JSONObject r9 = new JSONObject();
        int r10 = this.$recommendType;
        boolean r11 = this.$isFirstReq;
        long r12 = this.$lastIndex;
        long r14 = this.$curMaxIndex;
        r9.put("recommend_type", r10);
        r9.put("msg_list", r5);
        r9.put("cold_start", r11);
        if (AppHost.a.isDebug() == false) goto L15;
        r9.put("last_index", r12);
        r9.put("cur_max_index", r14);
    L15:
        Unit r15 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", ic8.o0.class, "/alice/bot/recommend", r9, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L18;
        return r13;
    }
}
