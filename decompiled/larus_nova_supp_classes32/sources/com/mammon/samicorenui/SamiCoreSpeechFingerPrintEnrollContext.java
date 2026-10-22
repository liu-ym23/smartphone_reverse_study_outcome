package com.mammon.samicorenui;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SamiCoreSpeechFingerPrintEnrollContext {
    public transient long a;

    public static native int Native_SilentEnroll(String r0, int r1);

    public static native int Native_Upload(String r0);

    public native int Native_Cancel(long r1);

    public native int Native_Check(long r1, byte[] r3);

    public native void Native_DeleteSamiCoreSpeechFingerPrintEnrollContext(long r1);

    public native int Native_Enroll(long r1, byte[] r3, int r4);

    public native int Native_Init(long r1, String r3);

    public native long Native_NewSamiCoreSpeechFingerPrintEnrollContext();

    public synchronized void delete() {
        monitor-enter(this);
        long r0 = this.a;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        Native_DeleteSamiCoreSpeechFingerPrintEnrollContext(r0);     // Catch: Throwable -> L8
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

    public SamiCoreSpeechFingerPrintEnrollContext() {
        this.a = Native_NewSamiCoreSpeechFingerPrintEnrollContext();
    }
}
