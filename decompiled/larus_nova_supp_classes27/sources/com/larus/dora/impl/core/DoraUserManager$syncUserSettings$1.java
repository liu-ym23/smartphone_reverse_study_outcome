package com.larus.dora.impl.core;

import com.larus.account.base.api.ILoginService;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.f0;
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
@DebugMetadata(c = "com.larus.dora.impl.core.DoraUserManager$syncUserSettings$1", f = "DoraUserManager.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"uid"}, s = {"L$0"})
final class DoraUserManager$syncUserSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public DoraUserManager$syncUserSettings$1(Continuation<? super DoraUserManager$syncUserSettings$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraUserManager$syncUserSettings$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L13:
        if (Result.isSuccess-impl(r8) == false) goto L26;
        f0 r4 = (f0) r8;
        g49.d.d("DoraUserManager", "syncUserSettings: userSettings=" + r4);
        com.larus.dora.impl.network.r r5 = r4.b();
        if (r5 == null) goto L22;
        Integer r6 = r5.a();
        if (r6 == null) goto L22;
        if (r6.intValue() != 1) goto L22;
    L23:
        com.larus.dora.impl.util.b0.a.getClass();
        if (com.larus.dora.impl.util.b0.t(r3) == r2) goto L26;
        com.larus.dora.impl.util.b0.E(r3, r2);
    L22:
        r2 = false;
    L26:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L30;
        g49.d.c("DoraUserManager", "syncUserSettings: exception", r9);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        String r10 = ILoginService.a.getAccountInfo().c;
        DoraNetworkApi r11 = DoraNetworkApi.a;
        this.L$0 = r10;
        this.label = 1;
        Object r12 = r11.v(true, this);
        if (r12 != r0) goto L11;
        return r0;
    L11:
        r3 = r10;
        r8 = r12;
        goto L13
    }
}
