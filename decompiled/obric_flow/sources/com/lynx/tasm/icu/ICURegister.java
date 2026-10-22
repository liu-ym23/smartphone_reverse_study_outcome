package com.lynx.tasm.icu;

import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.service.ILynxI18nService;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public class ICURegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f10883a = false;

    @CalledByNative
    private static synchronized boolean register(long r5) {
        monitor-enter(ICURegister.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f10883a == false) goto L13;
        ILynxI18nService r10 = (ILynxI18nService) r.g().e(ILynxI18nService.class);     // Catch: Throwable -> L11
        if (r10 == null) goto L13;
        boolean r11 = r10.registerNapiEnv(r5);     // Catch: Throwable -> L11
        monitor-exit(ICURegister.class);
        return r11;
    L13:
        monitor-exit(ICURegister.class);
        return false;
    }
}
