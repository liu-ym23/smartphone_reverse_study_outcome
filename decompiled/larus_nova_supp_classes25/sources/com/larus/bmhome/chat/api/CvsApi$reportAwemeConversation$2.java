package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.CvsApi$reportAwemeConversation$2", f = "CvsApi.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
public final class CvsApi$reportAwemeConversation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends Object>>, Object> {
    final /* synthetic */ wc9.e $conversation;
    int label;

    public CvsApi$reportAwemeConversation$2(wc9.e r1, Continuation<? super CvsApi$reportAwemeConversation$2> r2) {
        this.$conversation = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CvsApi$reportAwemeConversation$2(this.$conversation, r3);
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
    L11:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        wc9.e r5 = this.$conversation;
        r4.put("conversation_id", r5.a);
        r4.put("conversation_type", r5.v);
        Unit r6 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Basic", Object.class, "/alice/conversation/report", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}
