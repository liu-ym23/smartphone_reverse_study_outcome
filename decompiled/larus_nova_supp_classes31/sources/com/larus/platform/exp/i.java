package com.larus.platform.exp;

import com.larus.home.impl.sdk.o2;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.d2;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public static final i a = null;
    public static volatile Boolean b;
    public static volatile Boolean c;

    static {
        a = new i();
    }

    public i() {
    }

    public static Boolean b() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        o2 r3 = r2.x0();     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        d2 r4 = r3.getLarkDriveConfigV2();     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        Boolean r5 = Boolean.valueOf(r4.a());     // Catch: Throwable -> L13
    L11:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L13
    L15:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L19;
        FLogger.a.w("LarkOfficeExp", "readLarkDriveListEnabledOrNull failed", r7);
    L19:
        if (Result.isFailure-impl(r6) == true) goto L23;
        r0 = r6;
    L23:
        return (Boolean) r0;
    L10:
        r5 = null;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static Boolean c() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        o2 r3 = r2.x0();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        Boolean r4 = Boolean.valueOf(r3.f4());     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L17;
        FLogger.a.w("LarkOfficeExp", "readOfficeMiniAppEnableOrNull failed", r6);
    L17:
        if (Result.isFailure-impl(r5) == true) goto L21;
        r0 = r5;
    L21:
        return (Boolean) r0;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final boolean a() {
        AccountService r2 = AccountService.a;
        boolean r4 = false;
        if (r2.isLogin().booleanValue() == true) goto L6;
        FLogger.a.i("LarkOfficeExp", "isLarkDriveListEnabled account is not login, fallback=false without cache");
        return false;
    L6:
        Boolean r3 = c;
        if (r3 == null) goto L10;
        boolean r0 = r3.booleanValue();
        FLogger.a.i("LarkOfficeExp", "isLarkDriveListEnabled cached=" + r0);
        return r0;
    L10:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L12:
        if (r2.isLogin().booleanValue() == true) goto L14;
        FLogger.a.i("LarkOfficeExp", "isLarkDriveListEnabled account is not login after lock, fallback=false without cache");     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return r4;
    L14:
        Boolean r5 = c;     // Catch: Throwable -> L23
        if (r5 == null) goto L17;
        r4 = r5.booleanValue();     // Catch: Throwable -> L23
        FLogger.a.i("LarkOfficeExp", "isLarkDriveListEnabled cachedAfterLock=" + r4);     // Catch: Throwable -> L23
        goto L21
    L17:
        a.getClass();     // Catch: Throwable -> L23
        Boolean r1 = b();     // Catch: Throwable -> L23
        if (r1 != null) goto L20;
        FLogger.a.w("LarkOfficeExp", "isLarkDriveListEnabled settings service is not ready, fallback=false without cache");     // Catch: Throwable -> L23
        goto L21
    L20:
        c = r1;     // Catch: Throwable -> L23
        FLogger.a.i("LarkOfficeExp", "isLarkDriveListEnabled initSnapshot=" + r1);     // Catch: Throwable -> L23
        r4 = r1.booleanValue();     // Catch: Throwable -> L23
        goto L21
    }
}
