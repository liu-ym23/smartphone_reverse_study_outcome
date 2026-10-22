package com.larus.asr.handsfree;

import android.app.Application;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final a a = null;
    public static volatile boolean b;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a() {
        if (b == true) goto L5;
        return;
    L5:
        Application r0 = AppHost.a.getApplication();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        int r2 = HandsfreeForegroundService.b;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r0, "context");     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Boolean.valueOf(r0.stopService(new Intent(r0, HandsfreeForegroundService.class))));     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L13;
        FLogger.a.e("HandsfreeForegroundServiceManager", "[HF] foreground service stopService failed, " + r4.getMessage());
    L13:
        b = false;
        FLogger.a.i("HandsfreeForegroundServiceManager", "[HF] foreground service stop requested");
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
