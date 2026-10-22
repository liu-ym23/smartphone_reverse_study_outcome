package com.larus.bootprotector.activity;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bootprotector.activity.BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1", f = "BootProtectorLandingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1(Continuation<? super BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        nu8.a.e("BootProtectorLandingAct", "requestSettingInBootProtectorInternal: updateColdBootSettingRepo start");     // Catch: Throwable -> L7
        ht9.a r4 = ht9.a.a;     // Catch: Throwable -> L7
        Application r1 = AppHost.a.getApplication();     // Catch: Throwable -> L7
        r4.getClass();     // Catch: Throwable -> L7
        ht9.a.c(r1);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        nu8.a.f("BootProtectorLandingAct", th, "requestSettingInBootProtectorInternal: fail");
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
