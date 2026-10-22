package com.larus.showcase.service;

import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo$initForConversationCase$1", f = "CaseRepo.kt", i = {}, l = {265, 268}, m = "invokeSuspend", n = {}, s = {})
final class CaseRepo$initForConversationCase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public CaseRepo$initForConversationCase$1(Continuation<? super CaseRepo$initForConversationCase$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new CaseRepo$initForConversationCase$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L15:
        Unit r6 = Unit.INSTANCE;
        goto L20
    L10:
        ResultKt.throwOnFailure(r5);
        if (HomeService.a.o() == true) goto L16;
        FLogger.a.i("CaseRepo", "initForConversationCase fetchRecommendCaseList");
        CaseRepo r7 = CaseRepo.a;
        this.label = 1;
        if (r7.c(this) != r0) goto L15;
        return r0;
    L16:
        FLogger.a.i("CaseRepo", "initForConversationCase getCacheWholeCaseList");
        CaseRepo r8 = CaseRepo.a;
        this.label = 2;
        if (CaseRepo.d(this) != r0) goto L20;
        return r0;
    }
}
