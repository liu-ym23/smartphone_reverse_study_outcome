package com.bytedance.awemeopen.infra.support;

import android.util.Log;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "bizType");
        Intrinsics.checkNotNullParameter(r3, "sign");
        Intrinsics.checkNotNullParameter(r4, "block");
        r4.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        String r0 = Log.getStackTraceString(th);
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.a(ErrorPriority.p0, r2, r3, r0, th);
    }
}
