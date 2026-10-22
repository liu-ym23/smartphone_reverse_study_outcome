package com.larus.showcase.service;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.g;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo$saveRecommendCaseList$2", f = "CaseRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CaseRepo$saveRecommendCaseList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Case> $caseList;
    int label;

    public CaseRepo$saveRecommendCaseList$2(List<Case> r1, Continuation<? super CaseRepo$saveRecommendCaseList$2> r2) {
        this.$caseList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaseRepo$saveRecommendCaseList$2(this.$caseList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        if (this.$caseList == null) goto L7;
        CopyOnWriteArrayList r5 = CaseRepo.f;
        r5.clear();
        r5.addAll(this.$caseList);
        ((Keva) CaseRepo.g.getValue()).storeString("key_recommend_case_data", new Gson().toJson(this.$caseList));     // Catch: Exception -> L11
    L14:
        return Unit.INSTANCE;
    L11:
        e = move-exception;
        g.a.ensureNotReachHere(e, "saveRecommendCaseList");
        goto L14
    L7:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
