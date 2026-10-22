package com.larus.showcase.service;

import com.larus.network.bean.BizResponse;
import com.larus.platform.model.showcase.CaseMessageDataRequest;
import com.larus.showcase.api.CaseApi;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "", "Lcom/larus/showcase/api/CaseApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo$getCaseMessageListByRemote$resp$1", f = "CaseRepo.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
public final class CaseRepo$getCaseMessageListByRemote$resp$1 extends SuspendLambda implements Function2<CaseApi, Continuation<? super BizResponse<List<? extends String>>>, Object> {
    final /* synthetic */ String $caseId;
    private /* synthetic */ Object L$0;
    int label;

    public CaseRepo$getCaseMessageListByRemote$resp$1(String r1, Continuation<? super CaseRepo$getCaseMessageListByRemote$resp$1> r2) {
        this.$caseId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaseRepo$getCaseMessageListByRemote$resp$1 r0 = new CaseRepo$getCaseMessageListByRemote$resp$1(this.$caseId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(CaseApi r1, Continuation<? super BizResponse<List<String>>> r2) {
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
    L15:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CaseApi r7 = (CaseApi) this.L$0;
        Long r3 = StringsKt.toLongOrNull(this.$caseId);
        if (r3 == null) goto L11;
        long r4 = r3.longValue();
    L12:
        CaseMessageDataRequest r2 = new CaseMessageDataRequest(Boxing.boxLong(r4));
        this.label = 1;
        r6 = r7.getCaseData(r2, this);
        if (r6 != r0) goto L15;
        return r0;
    L11:
        r4 = 0;
        goto L12
    }
}
