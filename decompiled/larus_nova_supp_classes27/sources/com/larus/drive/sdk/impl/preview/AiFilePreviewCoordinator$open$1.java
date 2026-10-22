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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$open$1", f = "AiFilePreviewCoordinator.kt", i = {0}, l = {47, 56}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u241"}, s = {"L$5"})
final class AiFilePreviewCoordinator$open$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $fallback;
    final /* synthetic */ cr9.a $request;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    public AiFilePreviewCoordinator$open$1(cr9.a r1, Context r2, CoroutineScope r3, String r4, Function0<Unit> r5, Continuation<? super AiFilePreviewCoordinator$open$1> r6) {
        this.$request = r1;
        this.$context = r2;
        this.$scope = r3;
        this.$accountId = r4;
        this.$fallback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        AiFilePreviewCoordinator$open$1 r7 = new AiFilePreviewCoordinator$open$1(this.$request, this.$context, this.$scope, this.$accountId, this.$fallback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L32
    L30:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Context r2 = this.$context;
        CoroutineScope r3 = this.$scope;
        String r4 = this.$accountId;
        Function0<Unit> r5 = this.$fallback;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L42;
        if ((r16 instanceof CancellationException) == true) goto L39;
        FLogger.a.e("AiFilePreview", "fallback, stage=resolve_or_route, errorType=".concat(r16.getClass().getSimpleName()), r16);
        AiFilePreviewCoordinator.a(r2, r3, r4, r5);
        goto L42
    L39:
        FLogger.a.i("AiFilePreview", "cancel, stage=resolve_or_route");
        throw r16;
    L42:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CoroutineScope r6 = (CoroutineScope) this.L$5;
        Function0<Unit> r7 = (Function0) this.L$4;
        String r8 = (String) this.L$3;
        CoroutineScope r9 = (CoroutineScope) this.L$2;
        Context r10 = (Context) this.L$1;
        cr9.a r11 = (cr9.a) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L32
        Function0<Unit> r12 = r7;
        String r13 = r8;
        cr9.a r17 = r11;
    L13:
        CoroutineScope r18 = r9;
        AiFilePreviewCoordinator.a r20 = (AiFilePreviewCoordinator.a) r14;     // Catch: Throwable -> L32
        if (r20 != null) goto L24;
        FLogger.a.w("AiFilePreview", "fallback, stage=resolve");     // Catch: Throwable -> L32
        AiFilePreviewCoordinator.a(r10, r18, r13, r12);     // Catch: Throwable -> L32
        return Unit.INSTANCE;
    L24:
        if (AiFilePreviewCoordinator.b(r10, r18, r13) == true) goto L27;
        FLogger.a.i("AiFilePreview", "cancel before route, reason=context_changed");     // Catch: Throwable -> L32
        return Unit.INSTANCE;
    L27:
        MainCoroutineDispatcher r110 = Dispatchers.getMain().getImmediate();     // Catch: Throwable -> L32
        AiFilePreviewCoordinator$open$1$1$1 r21 = new AiFilePreviewCoordinator$open$1$1$1(r10, r18, r13, r20, r17, r12, null);     // Catch: Throwable -> L32
        this.L$0 = null;     // Catch: Throwable -> L32
        this.L$1 = null;     // Catch: Throwable -> L32
        this.L$2 = null;     // Catch: Throwable -> L32
        this.L$3 = null;     // Catch: Throwable -> L32
        this.L$4 = null;     // Catch: Throwable -> L32
        this.L$5 = null;     // Catch: Throwable -> L32
        this.label = 2;     // Catch: Throwable -> L32
        if (BuildersKt.withContext(r110, r21, this) != r0) goto L30;
        return r0;
    L14:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        cr9.a r22 = this.$request;
        r10 = this.$context;
        r9 = this.$scope;
        String r23 = this.$accountId;
        Function0<Unit> r24 = this.$fallback;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L32
        AiFilePreviewCoordinator r26 = AiFilePreviewCoordinator.a;     // Catch: Throwable -> L32
        this.L$0 = r22;     // Catch: Throwable -> L32
        this.L$1 = r10;     // Catch: Throwable -> L32
        this.L$2 = r9;     // Catch: Throwable -> L32
        this.L$3 = r23;     // Catch: Throwable -> L32
        this.L$4 = r24;     // Catch: Throwable -> L32
        this.L$5 = r111;     // Catch: Throwable -> L32
        this.label = 1;     // Catch: Throwable -> L32
        r14 = AiFilePreviewCoordinator.c(r26, r22, this);     // Catch: Throwable -> L32
        if (r14 != r0) goto L18;
        return r0;
    L18:
        r17 = r22;
        r12 = r24;
        r13 = r23;
    L32:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }
}
