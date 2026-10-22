package com.larus.drive.sdk.impl.preview;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$fallbackIfCurrent$1", f = "AiFilePreviewCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AiFilePreviewCoordinator$fallbackIfCurrent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $fallback;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    public AiFilePreviewCoordinator$fallbackIfCurrent$1(Context r1, CoroutineScope r2, String r3, Function0<Unit> r4, Continuation<? super AiFilePreviewCoordinator$fallbackIfCurrent$1> r5) {
        this.$context = r1;
        this.$scope = r2;
        this.$accountId = r3;
        this.$fallback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        AiFilePreviewCoordinator$fallbackIfCurrent$1 r6 = new AiFilePreviewCoordinator$fallbackIfCurrent$1(this.$context, this.$scope, this.$accountId, this.$fallback, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        Context r8 = this.$context;
        CoroutineScope r1 = this.$scope;
        String r2 = this.$accountId;
        Function0<Unit> r3 = this.$fallback;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        if (AiFilePreviewCoordinator.b(r8, r1, r2) == false) goto L8;
        FLogger.a.i("AiFilePreview", "invoke legacy fallback");     // Catch: Throwable -> L11
        r3.invoke();     // Catch: Throwable -> L11
    L9:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L20;
        if ((r10 instanceof CancellationException) == true) goto L18;
        FLogger.a.e("AiFilePreview", "fallback failed, stage=legacy, errorType=".concat(r10.getClass().getSimpleName()), r10);
        goto L20
    L18:
        throw r10;
    L20:
        return Unit.INSTANCE;
    L8:
        FLogger.a.i("AiFilePreview", "skip fallback on main, reason=context_changed");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
