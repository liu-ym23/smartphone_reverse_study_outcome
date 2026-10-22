package com.lynx.tasm.icu;

import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.service.ILynxI18nService;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ICURegister {
    public static volatile boolean a;

    public ICURegister() {
    }

    public static synchronized void a(INativeLibraryLoader r3) {
        monitor-enter(ICURegister.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (a == false) goto L8;
        monitor-exit(ICURegister.class);
        return;
    L8:
        ILynxI18nService r1 = (ILynxI18nService) n.c().a(ILynxI18nService.class);     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        a = r1.loadLibrary(r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ICURegister.class);
    }

    private static synchronized boolean register(long r3) {
        monitor-enter(ICURegister.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a == false) goto L11;
        ILynxI18nService r1 = (ILynxI18nService) n.c().a(ILynxI18nService.class);     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        boolean r4 = r1.registerNapiEnv(r3);     // Catch: Throwable -> L14
        monitor-exit(ICURegister.class);
        return r4;
    L11:
        monitor-exit(ICURegister.class);
        return false;
    }
}
