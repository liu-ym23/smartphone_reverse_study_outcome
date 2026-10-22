package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.account.base.api.IAccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.account.IObricAccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n implements a {
    static {
    }

    public n() {
    }

    public Bundle call(String r6, Bundle r7) {
        IObricAccountService r8 = (IObricAccountService) ServiceManager.get().getService(IObricAccountService.class);
        boolean r0 = false;
        if (r8 == null) goto L17;
        CountDownLatch r1 = new CountDownLatch(1);
        AtomicBoolean r2 = new AtomicBoolean(false);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        r8.i(new m(r2, r1));     // Catch: Throwable -> L11
        if (r1.await(5000, TimeUnit.MILLISECONDS) == true) goto L9;
        FLogger.a.w("SwitchToPersonalAccount", "switchToPersonalAccount timeout");     // Catch: Throwable -> L11
    L9:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L16;
        FLogger.a.w("SwitchToPersonalAccount", "switchToPersonalAccount failed: " + r10.getMessage(), r10);
    L16:
        r0 = r2.get();
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        Bundle r11 = new Bundle();
        r11.putBoolean("switch_success", r0);
        if (r0 == false) goto L25;
        r38.b r12 = IAccountService.a.getUserInfo();
        if (r12 == null) goto L23;
        String r13 = r12.g();
        if (r13 == null) goto L23;
    L24:
        r11.putString("user_name", r13);
    L23:
        r13 = "";
    L25:
        return r11;
    }
}
