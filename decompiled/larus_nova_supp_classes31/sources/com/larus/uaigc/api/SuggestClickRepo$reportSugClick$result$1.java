package com.larus.uaigc.api;

import com.larus.network.bean.BizResponse;
import com.larus.uaigc.lynx.pocket.IntentionType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/uaigc/api/SugClickApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.api.SuggestClickRepo$reportSugClick$result$1", f = "SuggestClickRepo.kt", i = {}, l = {IntentionType.AVATAR_GEN_IMAGE}, m = "invokeSuspend", n = {}, s = {})
public final class SuggestClickRepo$reportSugClick$result$1 extends SuspendLambda implements Function2<SugClickApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $showFrom;
    private /* synthetic */ Object L$0;
    int label;

    public SuggestClickRepo$reportSugClick$result$1(String r1, String r2, Continuation<? super SuggestClickRepo$reportSugClick$result$1> r3) {
        this.$messageId = r1;
        this.$showFrom = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SuggestClickRepo$reportSugClick$result$1 r0 = new SuggestClickRepo$reportSugClick$result$1(this.$messageId, this.$showFrom, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(SugClickApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SugClickApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        SugClickApi r7 = (SugClickApi) this.L$0;
        w r2 = new w(this.$messageId, this.$showFrom);
        this.label = 1;
        r6 = r7.sugClick(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
