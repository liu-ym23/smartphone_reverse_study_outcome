package com.obric.assistant.cocreationreview;

import com.larus.platform.service.AccountService;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.banner.bean.ObricBannerType;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationReviewActivity$loadCenterTasks$1", f = "CocreationReviewActivity.kt", i = {1}, l = {998, ObricBannerType.OTHER}, m = "invokeSuspend", n = {"tasks"}, s = {"L$0"})
public final class CocreationReviewActivity$loadCenterTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userId;
    Object L$0;
    int label;
    final /* synthetic */ CocreationReviewActivity this$0;

    public CocreationReviewActivity$loadCenterTasks$1(CocreationReviewActivity r1, String r2, Continuation<? super CocreationReviewActivity$loadCenterTasks$1> r3) {
        this.this$0 = r1;
        this.$userId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CocreationReviewActivity$loadCenterTasks$1(this.this$0, this.$userId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L13;
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L10;
        List<e4> r4 = (List) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
    L21:
        Set<String> r11 = (Set) r10;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        if (Intrinsics.areEqual(this.$userId, AccountService.a.getUserId()) == true) goto L30;
        q4 r12 = this.this$0.o;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r12.getClass();     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r12.a = CollectionsKt.emptyList();     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r12.d.clear();     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r12.e.clear();     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r12.f = null;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r12.g = null;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r12.h = CocreationTaskFilter.ALL;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        this.this$0.r = null;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
    L33:
        this.this$0.o.b = false;
        this.this$0.o2(false);
        return Unit.INSTANCE;
    L30:
        this.this$0.o.a(r4, r11);     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        int r5 = s3.a;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        s3.b("task.load", "recommendations visible=" + r4.size() + ", persistedRuns=" + r11.size());     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        goto L33
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
    L17:
        List<e4> r13 = (List) r10;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        CocreationTaskRunStore r6 = this.this$0.q;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        String r8 = this.$userId;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        this.L$0 = r13;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        this.label = 2;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        Object r7 = r6.b(r8, r13, this);     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        if (r7 != r2) goto L20;
        return r2;
    L20:
        r4 = r13;
        r10 = r7;
        goto L21
    L13:
        ResultKt.throwOnFailure(r10);
        CocreationTaskRepository r14 = (CocreationTaskRepository) this.this$0.s.getValue();     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        this.label = 1;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        r10 = r14.a(this);     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        if (r10 != r2) goto L17;
        return r2;
    L24:
        th = move-exception;
        this.this$0.o.b = false;
        throw th;
    L28:
        e = move-exception;
        throw e;     // Catch: Throwable -> L24
    L26:
        e = move-exception;
        this.this$0.o.c = true;     // Catch: Throwable -> L24
        int r0 = s3.a;     // Catch: Throwable -> L24
        s3.c("task.load", "memory recommendations failed type=".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L24
        goto L33
    }
}
