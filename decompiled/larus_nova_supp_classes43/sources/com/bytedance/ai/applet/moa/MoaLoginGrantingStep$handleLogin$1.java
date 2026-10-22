package com.bytedance.ai.applet.moa;

import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$handleLogin$1", f = "MoaLoginGrantingStep.kt", i = {}, l = {189, 195}, m = "invokeSuspend", n = {}, s = {})
final class MoaLoginGrantingStep$handleLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Result<String>, Unit> $completion;
    final /* synthetic */ Long $timeoutMS;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$handleLogin$1(MoaLoginGrantingStep r1, Function1<? super Result<String>, Unit> r10, Long r11, Continuation<? super MoaLoginGrantingStep$handleLogin$1> r12) {
        this.this$0 = r1;
        this.$completion = r10;
        this.$timeoutMS = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        MoaLoginGrantingStep$handleLogin$1 r0 = new MoaLoginGrantingStep$handleLogin$1(this.this$0, this.$completion, this.$timeoutMS, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L15;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
        Object r12 = ((Result) r10).unbox-impl();     // Catch: Throwable -> L13
    L37:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L13
        Object r13 = Result.constructor-impl((String) r12);     // Catch: Throwable -> L13
    L40:
        MoaLoginGrantingStep r0 = this.this$0;
        if (r0.f == MoaLoginGrantingStep.State.FETCHING_LOGIN_CODE) goto L43;
    L51:
        this.$completion.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(MoaLoginGrantingStep.l()))));
        return Unit.INSTANCE;
    L43:
        if (r0.h == null) goto L51;
        Function1<Result<String>, Unit> r14 = this.$completion;
        Throwable r15 = Result.exceptionOrNull-impl(r13);
        if (r15 != null) goto L48;
        r0.f = MoaLoginGrantingStep.State.WAITING_LOGIN_RESULT;
        r14.invoke(Result.box-impl(Result.constructor-impl((String) r13)));
    L50:
        return Unit.INSTANCE;
    L48:
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to fetch MOA login code", r15);
        r14.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r15))));
        r0.k(MoaStepResult.FAILED);
        goto L50
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Long r16 = (Long) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
    L30:
        Result r17 = (Result) r10;     // Catch: Throwable -> L13
        if (r17 == null) goto L33;
        r12 = r17.unbox-impl();     // Catch: Throwable -> L13
        goto L37
    L33:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L13
        r12 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Login request timed out after " + r16 + "ms")));     // Catch: Throwable -> L13
        goto L37
    L15:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        o r20 = this.this$0.g;
        if (r20 == null) goto L20;
        u2.e r21 = r20.a;
        if (r21 == null) goto L20;
        String r22 = r21.d();
    L21:
        if (r22 != null) goto L23;
        r22 = "";
    L23:
        Long r23 = this.$timeoutMS;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L13
        if (r23 == null) goto L34;
        long r25 = r23.longValue();     // Catch: Throwable -> L13
        MoaLoginGrantingStep$handleLogin$1$loginCodeResult$1$result$1 r26 = new MoaLoginGrantingStep$handleLogin$1$loginCodeResult$1$result$1(r22, null);     // Catch: Throwable -> L13
        this.L$0 = r23;     // Catch: Throwable -> L13
        this.label = 1;     // Catch: Throwable -> L13
        r10 = TimeoutKt.c(r25, r26, this);     // Catch: Throwable -> L13
        if (r10 != r1) goto L29;
        return r1;
    L29:
        r16 = r23;
        goto L30
    L34:
        UserAuthService r27 = UserAuthService.a;     // Catch: Throwable -> L13
        this.label = 2;     // Catch: Throwable -> L13
        r12 = UserAuthService.k(r22, null, null, this, 30);     // Catch: Throwable -> L13
        if (r12 != r1) goto L37;
        return r1;
    L20:
        r22 = null;
    L13:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    }
}
