package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationReviewActivity$confirmSettlementDialog$1$result$1", f = "CocreationReviewActivity.kt", i = {}, l = {1333}, m = "invokeSuspend", n = {}, s = {})
final class CocreationReviewActivity$confirmSettlementDialog$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<? extends Object>>, Object> {
    final /* synthetic */ CocreationUserFeedbackStatRequest $request;
    int label;
    final /* synthetic */ CocreationReviewActivity this$0;

    public CocreationReviewActivity$confirmSettlementDialog$1$result$1(CocreationReviewActivity r1, CocreationUserFeedbackStatRequest r2, Continuation<? super CocreationReviewActivity$confirmSettlementDialog$1$result$1> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CocreationReviewActivity$confirmSettlementDialog$1$result$1(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super dm9.a<? extends Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
        CocreationLabelingServerClient r7 = (CocreationLabelingServerClient) this.this$0.e.getValue();
        CocreationUserFeedbackStatRequest r2 = this.$request;
        this.label = 1;
        r7.getClass();
        CocreationLabelingServerApi.a r3 = CocreationLabelingServerApi.a;
        CocreationLabelingServerClient$submitUserFeedbackStat$2 r4 = new CocreationLabelingServerClient$submitUserFeedbackStat$2(r7, r2, null);
        r3.getClass();
        r6 = CocreationLabelingServerApi.a.a(r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
