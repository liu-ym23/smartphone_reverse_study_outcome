package com.obric.assistant.cocreationreview;

import com.larus.network.bean.BizResponse;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/CocreationLabelingServerApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationLabelingServerClient$submitUserFeedbackStat$2", f = "CocreationLabelingServerClient.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class CocreationLabelingServerClient$submitUserFeedbackStat$2 extends SuspendLambda implements Function2<CocreationLabelingServerApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ CocreationUserFeedbackStatRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CocreationLabelingServerClient this$0;

    public CocreationLabelingServerClient$submitUserFeedbackStat$2(CocreationLabelingServerClient r1, CocreationUserFeedbackStatRequest r2, Continuation<? super CocreationLabelingServerClient$submitUserFeedbackStat$2> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CocreationLabelingServerClient$submitUserFeedbackStat$2 r0 = new CocreationLabelingServerClient$submitUserFeedbackStat$2(this.this$0, this.$request, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(CocreationLabelingServerApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CocreationLabelingServerApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CocreationLabelingServerApi r6 = (CocreationLabelingServerApi) this.L$0;
        String r2 = CocreationLabelingServerClient.a(this.this$0);
        CocreationUserFeedbackStatRequest r3 = this.$request;
        this.label = 1;
        r5 = r6.submitUserFeedbackStat(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
