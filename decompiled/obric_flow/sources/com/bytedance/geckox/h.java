package com.bytedance.geckox;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f4751a = null;

    static {
        f4751a = new ConcurrentHashMap();
    }

    public static g a(String r10) {
        Object r5 = null;
        if (r10 == null) goto L27;
        ConcurrentHashMap r11 = f4751a;
        if (r11.get(r10) != null) goto L7;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        ConcurrentHashMap r13 = df.c.d;     // Catch: Throwable -> L13
        df.c.f16652i.a();     // Catch: Throwable -> L13
        GeckoGlobalConfig r14 = df.c.f;     // Catch: Throwable -> L13
        if (r14 != null) goto L11;
    L15:
        g r15 = null;
    L16:
        Object r16 = Result.m124constructorimpl(r15);     // Catch: Throwable -> L13
    L20:
        if (Result.m130isFailureimpl(r16) == true) goto L24;
        r5 = r16;
    L24:
        return (g) r5;
    L11:
        if (r13.containsKey(r10) == false) goto L15;
        i r17 = new i(r14.getContext()).a(r14.getAppId()).b(r14.getDeviceId()).c(r14.getHost());     // Catch: Throwable -> L13
        r17.getClass();     // Catch: Throwable -> L13
        r17.f4752a = Arrays.asList(new String[]{r10});     // Catch: Throwable -> L13
        r17.f4753b = new File((String) r13.get(r10));     // Catch: Throwable -> L13
        r15 = g.a(new j(r17));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    L7:
        return (g) r11.get(r10);
    L27:
        return null;
    }
}
