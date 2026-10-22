package com.larus.business.debug.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class NmtServiceInjector {
    public static final NmtInjectService a = null;

    public NmtServiceInjector() {
    }

    public static void clearCommonQueryParams() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.f();
    }

    public static void clearTestEnv() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.i();
    }

    public static void closeAppLogEtVerify() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.g();
    }

    public static void closeDebugFloatPanel() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.d();
    }

    public static void closeNetworkAnyDoor() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a();
    }

    public static void openAppLogEtVerify() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b();
    }

    public static void openNetworkAnyDoor() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.h();
    }

    public static void uploadAllALog() {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.j();
    }

    static {
        a = (NmtInjectService) ServiceManager.get().getService(NmtInjectService.class);
    }

    public static void addOrUpdateCommonQueryParams(String r1, String r2) {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c(r1, r2);
    }

    public static void setTestEnv(String r1, String r2) {
        NmtInjectService r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.e(r1, r2);
    }
}
