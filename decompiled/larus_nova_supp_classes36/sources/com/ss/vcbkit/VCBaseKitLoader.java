package com.ss.vcbkit;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class VCBaseKitLoader {
    public static volatile boolean a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("vcbasekit", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> vcbasekit");
        com.bytedance.librarian.a.c("vcbasekit");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> vcbasekit");
    }

    public static synchronized boolean loadLibrary() {
        monitor-enter(VCBaseKitLoader.class);
    L25:
        th = move-exception;
        throw th;
    L6:
        if (a == false) goto L10;
        monitor-exit(VCBaseKitLoader.class);
        return true;
    L10:
        if (UnExpected.a == true) goto L32;
        UnExpected.a = true;     // Catch: Throwable -> L14
    L15:
        UnExpected.a = false;     // Catch: Throwable -> L25
    L32:
        a();     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
        a = true;     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
    L22:
        boolean r1 = a;     // Catch: Throwable -> L25
        monitor-exit(VCBaseKitLoader.class);
        return r1;
    L20:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L25
    L18:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L25
        goto L22
    }

    public VCBaseKitLoader() {
    }
}
