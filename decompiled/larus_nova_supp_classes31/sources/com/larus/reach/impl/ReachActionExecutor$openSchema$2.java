package com.larus.reach.impl;

import android.app.Activity;
import android.content.Context;
import com.larus.platform.service.n3;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor$openSchema$2", f = "ReachActionExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ReachActionExecutor$openSchema$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ns9.t $request;
    final /* synthetic */ String $validSchema;
    private /* synthetic */ Object L$0;
    int label;

    public ReachActionExecutor$openSchema$2(Context r1, String r2, ns9.t r3, Continuation<? super ReachActionExecutor$openSchema$2> r4) {
        this.$context = r1;
        this.$validSchema = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ReachActionExecutor$openSchema$2 r0 = new ReachActionExecutor$openSchema$2(this.$context, this.$validSchema, this.$request, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        Context r8 = this.$context;
        String r0 = this.$validSchema;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        int r2 = n3.a;     // Catch: Throwable -> L10
        Activity r3 = com.larus.reach.runtime.t.b();     // Catch: Throwable -> L10
        if (r3 == null) goto L8;
        r8 = r3;
    L8:
        n3.a(r8, r0);     // Catch: Throwable -> L10
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        ns9.t r4 = this.$request;
        Throwable r5 = Result.exceptionOrNull-impl(r9);
        if (r5 == null) goto L16;
        FLogger.a.w("ReachAction", "reach action failed, reachUniqueId=" + r4.a.h, r5);
    L16:
        return Result.box-impl(r9);
    L10:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
