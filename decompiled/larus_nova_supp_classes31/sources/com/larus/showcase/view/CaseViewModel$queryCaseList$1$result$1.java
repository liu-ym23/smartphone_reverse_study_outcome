package com.larus.showcase.view;

import com.larus.network.bean.BizResponse;
import com.larus.platform.model.showcase.CaseListRequest;
import com.larus.platform.model.showcase.ListCaseResponse;
import com.larus.showcase.api.CaseApi;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/platform/model/showcase/ListCaseResponse;", "Lcom/larus/showcase/api/CaseApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.view.CaseViewModel$queryCaseList$1$result$1", f = "CaseViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
public final class CaseViewModel$queryCaseList$1$result$1 extends SuspendLambda implements Function2<CaseApi, Continuation<? super BizResponse<ListCaseResponse>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public CaseViewModel$queryCaseList$1$result$1(Continuation<? super CaseViewModel$queryCaseList$1$result$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        CaseViewModel$queryCaseList$1$result$1 r0 = new CaseViewModel$queryCaseList$1$result$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(CaseApi r1, Continuation<? super BizResponse<ListCaseResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CaseApi) r1, (Continuation) r2);
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
        CaseApi r7 = (CaseApi) this.L$0;
        CaseListRequest r2 = new CaseListRequest(Boxing.boxInt(20), Boxing.boxInt(1));
        this.label = 1;
        r6 = r7.requestCaseList(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
