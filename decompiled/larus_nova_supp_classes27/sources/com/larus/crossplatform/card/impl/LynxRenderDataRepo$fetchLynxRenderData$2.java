package com.larus.crossplatform.card.impl;

import com.larus.bmhome.chat.resp.LynxRenderData;
import com.larus.network.http.HttpExtKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/resp/LynxRenderData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$fetchLynxRenderData$2", f = "LynxRenderDataRepo.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
final class LynxRenderDataRepo$fetchLynxRenderData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LynxRenderData>, Object> {
    final /* synthetic */ String $dataUrl;
    final /* synthetic */ String $messageId;
    int label;

    public LynxRenderDataRepo$fetchLynxRenderData$2(String r1, String r2, Continuation<? super LynxRenderDataRepo$fetchLynxRenderData$2> r3) {
        this.$dataUrl = r1;
        this.$messageId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LynxRenderDataRepo$fetchLynxRenderData$2(this.$dataUrl, this.$messageId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super LynxRenderData> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return ((com.larus.network.http.a) r14).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        String r3 = this.$dataUrl;
        JSONObject r4 = new JSONObject();
        r4.put("msg_id", this.$messageId);
        Unit r5 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Message", LynxRenderData.class, r3, r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L12;
        return r0;
    }
}
