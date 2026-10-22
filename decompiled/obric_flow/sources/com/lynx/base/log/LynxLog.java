package com.lynx.base.log;

import android.util.Log;
import com.lynx.tasm.service.ILynxLogService;
import km.a;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public class LynxLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9720a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9721b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ILynxLogService f9722c;

    public static void a(int r10) {
    L6:
        e = move-exception;
        Log.e("lynx", "Please check index, " + e.getMessage());
        return;
    L4:
        if (f9721b == true) goto L9;
        f9721b = a.a().f18685a;     // Catch: ArrayIndexOutOfBoundsException -> L6
    L9:
        if (f9721b == false) goto L19;
        String[] r5 = {"VERBOSE", "DEBUG", "INFO", "WARN", "ERROR"};     // Catch: ArrayIndexOutOfBoundsException -> L6
        int r11 = f9720a;     // Catch: ArrayIndexOutOfBoundsException -> L6
        if (r11 >= r10) goto L14;
        f9720a = r10;     // Catch: ArrayIndexOutOfBoundsException -> L6
        nativeSetNativeMinLogLevel(r10);     // Catch: ArrayIndexOutOfBoundsException -> L6
        Log.w("lynx", "Reset minimum log level as " + r5[f9720a]);     // Catch: ArrayIndexOutOfBoundsException -> L6
        return;
    L14:
        Log.w("lynx", "Please set a log level higher than " + r5[r11] + " to filter lynx logs!");     // Catch: ArrayIndexOutOfBoundsException -> L6
        return;
    }

    public static void b(int r5, String r10, String r11) {
        if (r11 == null) goto L44;
        if (r10 == null) goto L47;
    L21:
        e = move-exception;
        Log.e("lynx", "load liblynxbase.so exception [ " + e.getMessage() + " ]");
        return;
    L6:
        if (f9721b == true) goto L32;
        boolean r12 = a.a().f18685a;     // Catch: UnsatisfiedLinkError -> L21
        f9721b = r12;     // Catch: UnsatisfiedLinkError -> L21
        if (r12 == true) goto L32;
        if (r5 != 0) goto L11;
        Log.v(r10, r11);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L11:
        if (r5 != 1) goto L13;
        Log.d(r10, r11);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L13:
        if (r5 != 2) goto L15;
        Log.i(r10, r11);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L15:
        if (r5 != 3) goto L17;
        Log.w(r10, r11);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L17:
        if (r5 != 4) goto L45;
        Log.e(r10, r11);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L45:
        return;
    L32:
        if (r5 < f9720a) goto L46;
        ILynxLogService r13 = f9722c;     // Catch: UnsatisfiedLinkError -> L21
        if (r13 != null) goto L36;
    L39:
        nativeInternalLog(r5, r10, r11);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L36:
        if (r13.isLogOutputByPlatform() == false) goto L39;
        f9722c.logByPlatform(r5, r10, r11);     // Catch: UnsatisfiedLinkError -> L21
        return;
    L46:
        return;
    L47:
        return;
    }

    public static void c(boolean r5) {
        nativeInitLynxLoggingNative(r5);
        ILynxLogService r10 = (ILynxLogService) r.g().e(ILynxLogService.class);
        f9722c = r10;
        if (r10 == null) goto L5;
        long r11 = r10.getDefaultWriteFunction();
    L7:
        if (r11 == 0) goto L9;
        nativeInitALogNative(r11);
        Log.i("LynxLog", "LynxLog dependency load successfully. function native address is " + r11);
    L10:
        ILynxLogService r12 = f9722c;
        if (r12 != null) goto L13;
        return;
    L13:
        if (r12.isLogOutputByPlatform() == false) goto L17;
        nativeSetLogOutputByPlatform();
        return;
    L17:
        return;
    L9:
        Log.i("LynxLog", "failed to load LynxLog dependency");
        goto L10
    L5:
        r11 = 0;
        goto L7
    }

    private static native void nativeInitALogNative(long r5);

    private static native void nativeInitLynxLoggingNative(boolean r5);

    private static native void nativeInternalLog(int r5, String r10, String r11);

    private static native void nativeSetLogOutputByPlatform();

    private static native void nativeSetNativeMinLogLevel(int r5);
}
