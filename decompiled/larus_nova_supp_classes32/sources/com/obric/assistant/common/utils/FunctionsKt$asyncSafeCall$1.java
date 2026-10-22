package com.obric.assistant.common.utils;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.common.utils.FunctionsKt$asyncSafeCall$1", f = "functions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FunctionsKt$asyncSafeCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    private /* synthetic */ Object L$0;
    int label;

    public FunctionsKt$asyncSafeCall$1(Function0<Unit> r1, Continuation<? super FunctionsKt$asyncSafeCall$1> r2) {
        this.$action = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FunctionsKt$asyncSafeCall$1 r0 = new FunctionsKt$asyncSafeCall$1(this.$action, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        Function0<Unit> r0 = this.$action;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        r0.invoke();     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L13;
        FLogger.a.w("functions", "asyncSafeCall failed: " + r6 + ", " + r3.getMessage(), r3);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
