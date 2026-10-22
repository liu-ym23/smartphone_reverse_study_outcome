package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.auth.c1;
import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lcom/larus/bmhome/auth/LaunchResult;", "Lcom/larus/bmhome/auth/CoreLaunchInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1", f = "LocalSubConvHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1 extends SuspendLambda implements Function2<c1<com.larus.bmhome.auth.h0>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $expectedSecUserId;
    final /* synthetic */ c1<com.larus.bmhome.auth.h0> $initialCoreResult;
    /* synthetic */ Object L$0;
    int label;

    public LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1(String r1, c1<com.larus.bmhome.auth.h0> r2, Continuation<? super LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1> r3) {
        this.$expectedSecUserId = r1;
        this.$initialCoreResult = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1 r0 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1(this.$expectedSecUserId, this.$initialCoreResult, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(c1<com.larus.bmhome.auth.h0> r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((c1) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r5);
        c1<com.larus.bmhome.auth.h0> r6 = (c1) this.L$0;
        boolean r1 = true;
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$expectedSecUserId) == false) goto L37;
        if (Intrinsics.areEqual(r6.c, "local_main_bot_sub_conversation") == true) goto L9;
    L14:
        com.larus.bmhome.auth.h0 r7 = (com.larus.bmhome.auth.h0) r6.d;
        if (r7 == null) goto L32;
        String r2 = this.$expectedSecUserId;
        if (Intrinsics.areEqual(r7.h(), r2) == false) goto L29;
        String r3 = r7.b();
        if (r3 != null) goto L21;
    L24:
        boolean r4 = true;
    L25:
        if (r4 == true) goto L29;
        if (Intrinsics.areEqual(r7.b(), TriggerSendLoading.NO_LOADING) == true) goto L29;
        boolean r8 = true;
    L30:
        if (r8 != true) goto L32;
        boolean r9 = true;
    L33:
        if (r9 == true) goto L37;
        r1 = false;
        goto L37
    L21:
        if (StringsKt.isBlank(r3) == true) goto L24;
        r4 = false;
    L29:
        r8 = false;
    L32:
        r9 = false;
        goto L33
    L9:
        if (r6 == this.$initialCoreResult) goto L14;
        int r0 = r6.b;
        if (r0 == 3) goto L37;
        if (r0 != 4) goto L14;
    L37:
        return Boxing.boxBoolean(r1);
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
