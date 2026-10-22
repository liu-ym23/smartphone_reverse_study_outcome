package com.larus.bmhome.chat.model.prompt;

import com.larus.bmhome.chat.bean.UpdateWcbSuggestsRequest;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.UpdateWcbSuggestsApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/bmhome/chat/model/repo/UpdateWcbSuggestsApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.prompt.PromptRulesRepo$updateWcbSuggests$result$1", f = "PromptRulesRepo.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class PromptRulesRepo$updateWcbSuggests$result$1 extends SuspendLambda implements Function2<UpdateWcbSuggestsApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $suggests;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    public PromptRulesRepo$updateWcbSuggests$result$1(String r1, String r2, String r3, Continuation<? super PromptRulesRepo$updateWcbSuggests$result$1> r4) {
        this.$userId = r1;
        this.$messageId = r2;
        this.$suggests = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        PromptRulesRepo$updateWcbSuggests$result$1 r0 = new PromptRulesRepo$updateWcbSuggests$result$1(this.$userId, this.$messageId, this.$suggests, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(UpdateWcbSuggestsApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UpdateWcbSuggestsApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        UpdateWcbSuggestsApi r9 = (UpdateWcbSuggestsApi) this.L$0;
        UpdateWcbSuggestsRequest r2 = new UpdateWcbSuggestsRequest(this.$userId, this.$messageId, this.$suggests, Boxing.boxBoolean(true));
        this.label = 1;
        r8 = r9.updateWcbSuggests(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
