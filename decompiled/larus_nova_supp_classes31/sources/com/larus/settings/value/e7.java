package com.larus.settings.value;

import android.app.ActivityManager;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class e7 implements Function0 {
    public /* synthetic */ e7() {
    }

    public final Object invoke() {
        e10 r0 = e10.a;
        int r1 = e10.L().h();
        boolean r2 = false;
        if (r1 <= 0) goto L47;
        Long r3 = Long.valueOf(e10.e);
        if (r3.longValue() <= 0) goto L7;
        boolean r4 = true;
    L8:
        ActivityManager r5 = null;
        if (r4 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        long r6 = r3.longValue();
    L41:
        if (r6 < (((long) r1) * 1073741824)) goto L47;
        r2 = true;
        goto L47
    L14:
        monitor-enter(r0);
        Long r7 = Long.valueOf(e10.e);     // Catch: Throwable -> L43
        if (r7.longValue() <= 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L22;
        r7 = null;
    L22:
        if (r7 == null) goto L48;
        r6 = r7.longValue();     // Catch: Throwable -> L43
    L39:
        monitor-exit(r0);
        goto L41
    L48:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L33
        Object r10 = AppHost.a.getApplication().getSystemService("activity");     // Catch: Throwable -> L33
        if ((r10 instanceof ActivityManager) == false) goto L28;
        r5 = (ActivityManager) r10;     // Catch: Throwable -> L33
    L28:
        ActivityManager.MemoryInfo r11 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L33
        if (r5 == null) goto L31;
        r5.getMemoryInfo(r11);     // Catch: Throwable -> L33
    L31:
        Object r12 = Result.constructor-impl(Long.valueOf(r11.totalMem));     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r12) == false) goto L38;
        r12 = 0L;
    L38:
        r6 = ((Number) r12).longValue();     // Catch: Throwable -> L43
        e10.e = r6;     // Catch: Throwable -> L43
    L33:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L43
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L43
        goto L36
    L18:
        r8 = false;
    L43:
        th = move-exception;
        throw th;
    L7:
        r4 = false;
    L47:
        return Boolean.valueOf(r2);
    }
}
