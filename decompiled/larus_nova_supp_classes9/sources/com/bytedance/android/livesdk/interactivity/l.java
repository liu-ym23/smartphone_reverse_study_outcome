package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public static boolean a;
    public static final boolean b = false;

    static {
        a = ((Boolean) l42.a.c.getValue()).booleanValue();
        b = com.bytedance.android.live.core.utils.v.a();
    }

    @JvmStatic
    public static final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "TAG");
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (b == true) goto L5;
        return;
    L5:
        if (a == false) goto L17;
        ALogger.i(r1, r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    }
}
