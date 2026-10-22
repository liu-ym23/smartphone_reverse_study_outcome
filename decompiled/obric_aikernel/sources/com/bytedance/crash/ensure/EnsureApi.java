package com.bytedance.crash.ensure;

import c4.d;
import com.bytedance.services.apm.api.IEnsure;
import t4.a;

/* JADX INFO: loaded from: classes.dex */
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
        IEnsure r10 = new AnonymousClass1();     // Catch: Throwable -> L8
        d.d(IEnsure.class, r10);     // Catch: Throwable -> L8
        a.g(r10);     // Catch: Throwable -> L8
        return;
    }
}
