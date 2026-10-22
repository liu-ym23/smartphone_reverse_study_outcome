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
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo$updateWholeCase2Cache$2", f = "CaseRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaseRepo$updateWholeCase2Cache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Case> $caseList;
    final /* synthetic */ boolean $needCache;
    int label;

    public CaseRepo$updateWholeCase2Cache$2(List<Case> r1, boolean r2, Continuation<? super CaseRepo$updateWholeCase2Cache$2> r3) {
        this.$caseList = r1;
        this.$needCache = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CaseRepo$updateWholeCase2Cache$2(this.$caseList, this.$needCache, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        if (this.$caseList == null) goto L7;
        CopyOnWriteArrayList r5 = CaseRepo.d;
        r5.clear();
        r5.addAll(this.$caseList);
        if (this.$needCache == false) goto L11;
        CopyOnWriteArrayList r6 = CaseRepo.e;
        r6.clear();
        r6.addAll(this.$caseList);
        ((Keva) CaseRepo.g.getValue()).storeString("key_list_case_data", new Gson().toJson(r6));     // Catch: Exception -> L15
    L18:
        return Unit.INSTANCE;
    L15:
        e = move-exception;
        g.a.ensureNotReachHere(e, "saveWholeCase2Cache");
        goto L18
    L11:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
