package com.larus.common.account.platform.larklogin;

import a09.a;
import com.larus.common.account.platform.larkauth.AuthorizationFactory;
import com.larus.utils.t0;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larklogin.LarkLogin$authorize$startResult$1$1$onSuccess$1", f = "LarkLogin.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
final class LarkLogin$authorize$startResult$1$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $osType;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $terminalType;
    private /* synthetic */ Object L$0;
    int label;

    public LarkLogin$authorize$startResult$1$1$onSuccess$1(String r1, String r2, String r3, Continuation<? super LarkLogin$authorize$startResult$1$1$onSuccess$1> r4) {
        this.$osType = r1;
        this.$terminalType = r2;
        this.$sessionId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        LarkLogin$authorize$startResult$1$1$onSuccess$1 r0 = new LarkLogin$authorize$startResult$1$1$onSuccess$1(this.$osType, this.$terminalType, this.$sessionId, r6);
        r0.L$0 = r5;
        return r0;
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl((a) r5);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r6) == false) goto L20;
        r6 = null;
    L20:
        final a r7 = (a) r6;
        final String r2 = this.$sessionId;
        t0.c(new h(r7, r2));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        String r9 = this.$osType;
        String r3 = this.$terminalType;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        AuthorizationFactory r10 = AuthorizationFactory.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r5 = r10.c(r9, r3, this);     // Catch: Throwable -> L15
        if (r5 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
