package com.bytedance.services.apm.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IEnsure f3177a;

    public static IEnsure a() {
        return f3177a;
    }

    public static void a(IEnsure r2) {
        f3177a = (IEnsure) ZeusTransformUtils.wrapperContextForParams(r2, IEnsure.class, "com.obric.memorydata.plugin");
    }

    public static void a(String r1) {
        IEnsure r0 = f3177a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1);
    }

    public static void a(String r2, Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        IEnsure r0 = f3177a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r2, r4);
    }

    public static void a(Throwable r1) {
        IEnsure r0 = f3177a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1);
    }

    public static void a(Throwable r1, String r2) {
        IEnsure r0 = f3177a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r1, r2);
    }

    public static void a(Throwable r2, String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        IEnsure r0 = f3177a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.ensureNotReachHere(r2, r3, r5);
    }
}
