package com.larus.bmhome.social.userchat.model;

import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.LocalSubConvHelper$awaitCurrentAccountMainBotId$4", f = "LocalSubConvHelper.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
public final class LocalSubConvHelper$awaitCurrentAccountMainBotId$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $expectedSecUserId;
    final /* synthetic */ c1<com.larus.bmhome.auth.h0> $initialCoreResult;
    private /* synthetic */ Object L$0;
    int label;

    public LocalSubConvHelper$awaitCurrentAccountMainBotId$4(String r1, c1<com.larus.bmhome.auth.h0> r2, Continuation<? super LocalSubConvHelper$awaitCurrentAccountMainBotId$4> r3) {
        this.$expectedSecUserId = r1;
        this.$initialCoreResult = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        LocalSubConvHelper$awaitCurrentAccountMainBotId$4 r0 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$4(this.$expectedSecUserId, this.$initialCoreResult, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);
    L15:
        return LocalSubConvHelper.b(r2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        String r9 = LocalSubConvHelper.b(this.$expectedSecUserId);
        if (r9 != null) goto L16;
        String r10 = this.$expectedSecUserId;
        c1<com.larus.bmhome.auth.h0> r3 = this.$initialCoreResult;
        Flow r4 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.a());
        LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1 r5 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1(r10, r3, null);
        this.L$0 = r10;
        this.label = 1;
        if (kotlinx.coroutines.flow.e.t(r4, r5, this) != r0) goto L13;
        return r0;
    L13:
        r2 = r10;
        goto L15
    L16:
        return r9;
    }
}
