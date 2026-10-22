package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.BotApi$requireCustomActionBarCustomize$2", f = "BotApi.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
public final class BotApi$requireCustomActionBarCustomize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends Object>>, Object> {
    final /* synthetic */ long $botId;
    final /* synthetic */ List<Long> $sortItemIdList;
    int label;

    public BotApi$requireCustomActionBarCustomize$2(long r1, List<Long> r3, Continuation<? super BotApi$requireCustomActionBarCustomize$2> r4) {
        this.$botId = r1;
        this.$sortItemIdList = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotApi$requireCustomActionBarCustomize$2(this.$botId, this.$sortItemIdList, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<? extends Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return (a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        long r5 = this.$botId;
        List<Long> r7 = this.$sortItemIdList;
        r4.put("bot_id", String.valueOf(r5));
        r4.put("sorted_item_id_list", new JSONArray(r7));
        Unit r6 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", Object.class, "/alice/bot/action_bar_v3/cumstomize", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L12;
        return r0;
    }
}
