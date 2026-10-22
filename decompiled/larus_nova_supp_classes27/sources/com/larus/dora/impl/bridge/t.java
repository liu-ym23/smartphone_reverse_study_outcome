package com.larus.dora.impl.bridge;

import android.app.Application;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Intent r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "intent");
        Intrinsics.checkNotNullParameter(r5, "url");
        Application r0 = AppHost.a.getApplication();
        if (r4.resolveActivity(r0.getPackageManager()) != null) goto L6;
        FLogger.a.e("DoraOpenTargetLauncher", "no activity can open ".concat(r5));
        return false;
    L6:
        r4.addFlags(268435456);
        r0.startActivity(r4);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        FLogger.a.e("DoraOpenTargetLauncher", "start activity failed: ".concat(r5), e);
        return false;
    }
}
