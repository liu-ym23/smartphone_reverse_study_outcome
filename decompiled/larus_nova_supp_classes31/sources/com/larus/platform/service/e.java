package com.larus.platform.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L14;
        FLogger.a.i("AigcMetadataCheckHelper", "skip empty filePath");
        return;
    L14:
        if (new PolarisFileWrapper(r5).exists() == true) goto L31;
        FLogger.a.i("AigcMetadataCheckHelper", "skip non-existing file, path=" + r5);
        return;
    L31:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L25
        if (r3 == null) goto L22;
        r3.D0();     // Catch: Throwable -> L25
        com.larus.home.impl.sdk.b1.a.a(r5, new d(r5));     // Catch: Throwable -> L25
    L23:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r4 = Result.exceptionOrNull-impl(r0);
        if (r4 == null) goto L33;
        FLogger.a.e("AigcMetadataCheckHelper", "checkAndFix failed to start, path=" + r5, r4);
        return;
    L33:
        return;
    L22:
        FLogger.a.i("AigcMetadataCheckHelper", "metadata check service is null, path=" + r5);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static void b(String r6) {
        boolean r2 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L14;
        FLogger.a.i("AigcMetadataCheckHelper", "skip empty filePath");
        return;
    L14:
        if (new PolarisFileWrapper(r6).exists() == true) goto L35;
        FLogger.a.i("AigcMetadataCheckHelper", "skip non-existing file, path=" + r6);
        return;
    L35:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L25
        if (r5 == null) goto L22;
        r5.D0();     // Catch: Throwable -> L25
        r2 = com.larus.home.impl.sdk.b1.a.b(r6);     // Catch: Throwable -> L25
        FLogger.a.i("AigcMetadataCheckHelper", "checkAndFix sync finish, success=" + r2 + ", path=" + r6);     // Catch: Throwable -> L25
    L23:
        Object r0 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L25
    L27:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L30;
        FLogger.a.e("AigcMetadataCheckHelper", "checkAndFix sync failed, path=" + r6, r1);
    L30:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L33;
        r0 = r7;
    L33:
        ((Boolean) r0).booleanValue();
        return;
    L22:
        FLogger.a.i("AigcMetadataCheckHelper", "metadata check service is null, path=" + r6);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L5:
        if (r6.length() == 0) goto L8;
        r3 = false;
        goto L10
    }
}
