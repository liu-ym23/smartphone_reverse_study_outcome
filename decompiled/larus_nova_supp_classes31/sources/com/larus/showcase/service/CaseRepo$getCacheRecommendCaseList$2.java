package com.larus.showcase.service;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/platform/model/showcase/Case;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo$getCacheRecommendCaseList$2", f = "CaseRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CaseRepo$getCacheRecommendCaseList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Case>>, Object> {
    int label;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/showcase/service/CaseRepo$getCacheRecommendCaseList$2$caseList$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/platform/model/showcase/Case;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<List<? extends Case>> {
        public a() {
        }
    }

    public CaseRepo$getCacheRecommendCaseList$2(Continuation<? super CaseRepo$getCacheRecommendCaseList$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new CaseRepo$getCacheRecommendCaseList$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Case>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r5);
        CopyOnWriteArrayList r6 = CaseRepo.f;
        boolean r1 = true;
        if ((!r6.isEmpty()) == false) goto L7;
        return r6;
    L7:
        String r7 = ((Keva) CaseRepo.g.getValue()).getString("key_recommend_case_data", "");
        Intrinsics.checkNotNull(r7);
        if (r7.length() > 0) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L36;
    L31:
        return null;
    L36:
        Gson r2 = new Gson();     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        Object r8 = Result.constructor-impl((List) r2.fromJson(r7, new a().getType()));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r8) == false) goto L21;
        r8 = null;
    L21:
        List r9 = (List) r8;     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
        CopyOnWriteArrayList r4 = CaseRepo.f;     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
        r4.clear();     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
        if (r9 == null) goto L24;
        List r10 = r9;     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
    L25:
        r4.addAll(r10);     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
        return r9;
    L24:
        r10 = new ArrayList();     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: NullPointerException -> L27 JsonSyntaxException -> L29
    L29:
        e = move-exception;
        g.a.ensureNotReachHere(e);
    L27:
        e = move-exception;
        FLogger.a.e("CaseRepo", "getCacheRecommendCaseList error e=" + e.getMessage());
        goto L31
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
