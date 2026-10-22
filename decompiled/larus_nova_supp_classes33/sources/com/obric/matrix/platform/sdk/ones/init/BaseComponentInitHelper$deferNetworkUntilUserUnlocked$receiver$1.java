package com.obric.matrix.platform.sdk.ones.init;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1", "Landroid/content/BroadcastReceiver;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class BaseComponentInitHelper$deferNetworkUntilUserUnlocked$receiver$1 extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (r4 == null) goto L5;
        String r5 = r4.getAction();
    L7:
        if (Intrinsics.areEqual(r5, "android.intent.action.USER_UNLOCKED") == true) goto L9;
        return;
    L9:
        dka.a.c("BaseComponentInitHelper", "received USER_UNLOCKED, start deferred network init");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        ReceiverRegisterLancet.loge(this, false);     // Catch: Throwable -> L20
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L25;
        throw null;     // Catch: Throwable -> L20
    L25:
    L16:
        e = move-exception;
        Npth.addTag("unregisterReceiver", toString());     // Catch: Throwable -> L20
        e.printStackTrace();     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        BaseComponentInitHelper.b.set(false);
        BaseComponentInitHelper.a.getClass();
        ((ExecutorService) BaseComponentInitHelper.c.getValue()).execute(new a());
        return;
    L13:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(this, null) == false) goto L18;
        throw null;     // Catch: Exception -> L16 Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L5:
        r5 = null;
        goto L7
    }
}
