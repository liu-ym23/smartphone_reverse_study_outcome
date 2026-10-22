package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.LocalSubConvHelper$awaitCurrentAccountMainBotId$3", f = "LocalSubConvHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalSubConvHelper$awaitCurrentAccountMainBotId$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $expectedSecUserId;
    final /* synthetic */ c1<com.larus.bmhome.auth.h0> $initialCoreResult;
    int label;

    public LocalSubConvHelper$awaitCurrentAccountMainBotId$3(String r1, c1<com.larus.bmhome.auth.h0> r2, Continuation<? super LocalSubConvHelper$awaitCurrentAccountMainBotId$3> r3) {
        this.$expectedSecUserId = r1;
        this.$initialCoreResult = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalSubConvHelper$awaitCurrentAccountMainBotId$3(this.$expectedSecUserId, this.$initialCoreResult, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$expectedSecUserId) == false) goto L14;
        AuthModelDelegate r5 = AuthModelDelegate.b;
        c1<com.larus.bmhome.auth.h0> r0 = this.$initialCoreResult;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        IAuthModelService.a.a(r5, "local_main_bot_sub_conversation", r1, 4);
        goto L14
    L9:
        if (r0.b != 2) goto L11;
        r1 = true;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
