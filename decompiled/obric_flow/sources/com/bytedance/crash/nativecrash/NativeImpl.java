package com.bytedance.crash.nativecrash;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Keep;
import com.bytedance.apm.d;
import com.bytedance.crash.n;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.g;
import java.io.File;
import l9.o;
import x8.a;

/* JADX INFO: loaded from: classes2.dex */
public class NativeImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f4076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f4077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4078c;

    @Keep
    private static native int CoredumpNativeInit(int r5);

    public static int a() {
        if (f4076a == true) goto L7;
        return -1000;
    L7:
        return doCreateCallbackThread();
    }

    public static int b(int r5) {
        if (f4076a == true) goto L5;
        return -1;
    L5:
        return CoredumpNativeInit(r5);
    }

    public static String c(Context r5) {
        String r10 = f4078c;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (new File(r5.getApplicationInfo().nativeLibraryDir, "libnpth_dumper.so").exists() == false) goto L8;
        f4078c = r5.getApplicationInfo().nativeLibraryDir;
    L10:
        return f4078c;
    L8:
        f4078c = n.f4057a.getFilesDir() + a.f22988k;
        int r11 = 5;
        o.e().b(new d("npth_dumper", r11));
        o.e().b(new d("npth_wrapper", r11));
        goto L10
    }

    public static String d(String r5) {
        if (f4076a == true) goto L7;
        return null;
    L7:
        return doGetCrashHeader(r5);
    }

    @Keep
    private static native boolean doCheckNativeCrash();

    @Keep
    private static native int doCreateCallbackThread();

    @Keep
    private static native void doDelayCheck();

    @Keep
    private static native String doGetCrashHeader(String r5);

    @Keep
    private static native long doGetNpthCatchAddr();

    @Keep
    private static native int doGetPthreadKeyCount(int r5);

    @Keep
    private static native void doPthreadKeyMonitorInit(int r5, int r10);

    @Keep
    private static native void doRebuildTombstone(String r5, String r10, String r11);

    @Keep
    private static native void doSetAlogFlushAddr(long r5);

    @Keep
    private static native void doSetCbDelayTime(long r5);

    @Keep
    private static native void doSetDropDataState(int r5);

    @Keep
    private static native void doSetDumpEnvInfoAddr(long r5);

    @Keep
    private static native void doSetMallocInfoFunctionAddress(long r5);

    @Keep
    private static native void doSetNativeCallbackAddr(long r5);

    @Keep
    private static native void doSetUploadEnd();

    @Keep
    private static native int doStartNativeCrashMonitor(int r5, String r10, String r11, String r12, long r13, long r14);

    public static void e(int r5, boolean r10) {
        doPthreadKeyMonitorInit(r5, r10 ? 1 : 0);     // Catch: Throwable -> L4
        return;
    }

    public static void f(long r5) {
        if (f4076a == false) goto L10;
        doSetAlogFlushAddr(r5);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public static void g(File r5) {
        if (f4076a == true) goto L5;
        return;
    L5:
        String r10 = g.f4181a;
        String r11 = new File(r5, "header.bin").getAbsolutePath();
        String r12 = new File(g.c(n.f4057a, r5.getName()), "maps.txt").getAbsolutePath();
        doRebuildTombstone(r11, new File(r5, "tombstone.txt").getAbsolutePath(), r12);
    }

    public static void h(int r5) {
        if (f4076a == true) goto L5;
        return;
    L5:
        doSetDropDataState(r5);
    }

    @Keep
    private static void handleNativeCrash(String r5) {
        NativeCrashCollector.onNativeCrash(r5);
    }

    public static void i(long r5) {
        doSetCbDelayTime(r5);
    }

    public static boolean j() {
        if (f4076a == true) goto L8;
        return false;
    L8:
        return doCheckNativeCrash();
    L7:
        return false;
    }

    public static boolean k(Context r11) {
        if (m() == true) goto L10;
    L8:
        return false;
    L10:
        doStartNativeCrashMonitor(Build.VERSION.SDK_INT, c(r11), g.h(r11) + a.f22989l, n.f(), n.s, n.f4059c);     // Catch: Throwable -> L9
        return true;
    }

    public static long l() {
        if (f4076a == true) goto L7;
        return 0;
    L7:
        return doGetNpthCatchAddr();
    }

    public static boolean m() {
        if (f4077b == true) goto L5;
        boolean r5 = true;
        f4077b = true;
        if (f4076a == true) goto L24;
        System.loadLibrary("npth");     // Catch: Throwable -> L11
    L12:
        boolean r10 = true;
    L14:
        f4076a = r10;
        if (f4076a == false) goto L24;
        System.loadLibrary("npth_tools");     // Catch: Throwable -> L19
    L22:
        f4076a = r5;
        doSetDumpEnvInfoAddr(NativeTools.k().n());
    L19:
        io.reactivex.exceptions.a.p(n.f4057a, "npth_tools");     // Catch: Throwable -> L21
    L21:
        r5 = false;
    L11:
        io.reactivex.exceptions.a.p(n.f4057a, "npth");     // Catch: Throwable -> L13
    L13:
        r10 = false;
    L24:
        return f4076a;
    L5:
        return f4076a;
    }

    public static void n() {
        if (f4076a == true) goto L5;
        return;
    L5:
        doSetUploadEnd();
    }
}
