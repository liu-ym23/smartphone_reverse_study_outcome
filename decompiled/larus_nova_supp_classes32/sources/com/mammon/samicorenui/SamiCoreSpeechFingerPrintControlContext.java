package com.mammon.samicorenui;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SamiCoreSpeechFingerPrintControlContext {
    public transient long a;

    public native void Native_deleteSamiCoreSpeechFingerPrintControlContext(long r1);

    public native int Native_init(long r1, String r3);

    public native long Native_newSamiCoreSpeechFingerPrintControlContext();

    public native int Native_toggle(long r1, int r3);

    public synchronized void delete() {
        monitor-enter(this);
        long r0 = this.a;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        Native_deleteSamiCoreSpeechFingerPrintControlContext(r0);     // Catch: Throwable -> L8
        this.a = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter(BuildConfig.LIBNAME, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> audioeffect");
        a.c(BuildConfig.LIBNAME);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> audioeffect");
    }

    static {
        a();     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.getLocalizedMessage();
        e.printStackTrace();
    }

    public SamiCoreSpeechFingerPrintControlContext() {
        this.a = 0;
        this.a = Native_newSamiCoreSpeechFingerPrintControlContext();
    }
}
