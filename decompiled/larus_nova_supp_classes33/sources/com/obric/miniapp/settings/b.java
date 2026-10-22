package com.obric.miniapp.settings;

import com.bytedance.ai.utils.g;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;
    public static boolean b;

    static {
        a = new b();
    }

    public b() {
    }

    public static g37.a a() {
        return g37.a.c("obric-mini-app");
    }

    public static IMiniAppSettings b() {
        g.a.d("MiniAppSettingsManager", "obtainSettings");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl((IMiniAppSettings) a().b(IMiniAppSettings.class));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 != null) goto L10;
    L13:
        DefaultValueMiniAppSettings r3 = DefaultValueMiniAppSettings.INSTANCE;
        if (Result.isFailure-impl(r1) == false) goto L17;
        r1 = r3;
    L17:
        return (IMiniAppSettings) r1;
    L10:
        if (b == true) goto L12;
        g.a.w("MiniAppSettingsManager", "obtain settings failed", r2);
        goto L13
    L12:
        throw r2;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
