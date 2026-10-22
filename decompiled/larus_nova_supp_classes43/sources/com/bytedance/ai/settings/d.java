package com.bytedance.ai.settings;

import com.bytedance.ai.utils.g;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final d a = null;
    public static boolean b;

    static {
        a = new d();
    }

    public d() {
    }

    public static IAISDKSettings a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl((IAISDKSettings) g37.a.c("flow_ai_sdk").b(IAISDKSettings.class));     // Catch: Throwable -> L4
    L6:
        Throwable r10 = Result.exceptionOrNull-impl(r1);
        if (r10 != null) goto L9;
    L12:
        DefaultValueAISDKSettings r11 = DefaultValueAISDKSettings.INSTANCE;
        if (Result.isFailure-impl(r1) == false) goto L16;
        r1 = r11;
    L16:
        return (IAISDKSettings) r1;
    L9:
        if (b == true) goto L11;
        g.a.w("AppletSettingsManager", "obtain settings failed", r10);
        goto L12
    L11:
        throw r10;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
