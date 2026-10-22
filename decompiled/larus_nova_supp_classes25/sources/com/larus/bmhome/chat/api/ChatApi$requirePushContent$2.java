package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.resp.MessageList;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/resp/MessageList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.ChatApi$requirePushContent$2", f = "ChatApi.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
public final class ChatApi$requirePushContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MessageList>, Object> {
    final /* synthetic */ String $groupId;
    final /* synthetic */ String $userId;
    int label;

    public ChatApi$requirePushContent$2(String r1, String r2, Continuation<? super ChatApi$requirePushContent$2> r3) {
        this.$groupId = r1;
        this.$userId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatApi$requirePushContent$2(this.$groupId, this.$userId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super MessageList> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r1 = r14;
    L12:
        return ((a) r1).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        FLogger.a.d("ChatApi", "requirePushContent: groupId = " + this.$groupId + ", userId = " + this.$userId);
        JSONObject r4 = new JSONObject();
        String r5 = this.$groupId;
        String r6 = this.$userId;
        r4.put("group_id", r5);
        r4.put("user_id", r6);
        Unit r7 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Basic", MessageList.class, "/alice/notice/push_content", r4, null, null, false, null, null, null, this, 1008);
        if (r1 != r12) goto L12;
        return r12;
    }
}
