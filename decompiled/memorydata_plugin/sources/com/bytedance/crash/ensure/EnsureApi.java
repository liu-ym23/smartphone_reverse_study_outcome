package com.bytedance.crash.ensure;

import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.a;

/* JADX INFO: loaded from: classes2.dex */
public class EnsureApi {
    private static final int STACKTRACE_NORMAL_DEPTH = 5;
    private static boolean sInited = false;

    static {
    }

    public EnsureApi() {
    }

    public static void init() {
        if (sInited == false) goto L5;
        return;
    L5:
        sInited = true;
        IEnsure r0 = new AnonymousClass1();     // Catch: Throwable -> L8
        d.a(IEnsure.class, r0);     // Catch: Throwable -> L8
        a.a(r0);     // Catch: Throwable -> L8
        return;
    }
}
