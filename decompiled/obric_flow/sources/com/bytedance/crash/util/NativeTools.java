package com.bytedance.crash.util;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.p;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import l9.o;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public class NativeTools {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static NativeTools f4167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f4168c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f4169a;

    @Keep
    public class NativeHeapSize {
        public long allocate;
        public long free;
        final /* synthetic */ NativeTools this$0;
        public long total;

        public NativeHeapSize(NativeTools r5) {
            this.this$0 = r5;
        }

        public void print() {
            io.reactivex.exceptions.a.i("NativeHeapSize.total = " + this.total);
            io.reactivex.exceptions.a.i("NativeHeapSize.allocate = " + this.allocate);
            io.reactivex.exceptions.a.i("NativeHeapSize.free = " + this.free);
        }
    }

    static {
        f4168c = new HashMap();
    }

    public static long B(String r5) {
        return nativeGetPathSize(r5, 0);
    }

    public static long D(String r5) {
        return nativeGetPathSize(r5, 1);
    }

    public static JSONArray F(String r10) {
        JSONArray r5 = new JSONArray();
        HashSet r11 = new HashSet();
        String[] r12 = r10.split("\n");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L16;
        String[] r15 = i9.g.c(r12[r14]);
        if (r15 == null) goto L15;
        NativeTools r16 = k();
        String r17 = r15[1];
        r16.getClass();
        HashMap r18 = f4168c;
        String r19 = (String) r18.get(r17);
        if (TextUtils.isEmpty(r19) == false) goto L10;
        k().getClass();
        r19 = l(z(r17));
        r18.put(r17, r19);
    L10:
        if (TextUtils.isEmpty(r19) == true) goto L15;
        if (r11.contains(r15[0]) == true) goto L15;
        r11.add(r15[0]);
        JSONObject r20 = new JSONObject();
        mh.e.g(r15[0], "lib_name", r20);
        mh.e.g(r19, "lib_uuid", r20);
        r5.put(r20);
    L15:
        r14 = r14 + 1;
        goto L3
    L16:
        return r5;
    }

    @Keep
    private static native int doCommonLogPath(int r5, String r10);

    @Keep
    private static native long doDumpEnvInfo();

    @Keep
    private static native void doEnvMonitorInit(int r5);

    @Keep
    private static native void doSetNpthCatchAddr(long r5);

    public static void f(String r10, String r11, String r12, String r13, String r14) {
        nativeDumpCrashInfo(r10, r11, r12, r13, r14, null, null, false);
    }

    public static NativeTools k() {
        if (f4167b != null) goto L26;
        monitor-enter(NativeTools.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (f4167b != null) goto L21;
        NativeTools r5 = new NativeTools();     // Catch: Throwable -> L19
        if (r5.f4169a == false) goto L29;
    L14:
        f4167b = r5;     // Catch: Throwable -> L19
        if (r5.f4169a == false) goto L21;
        nativeToolsInit(Build.VERSION.SDK_INT, NativeImpl.c(n.f4057a));     // Catch: Throwable -> L28
        doSetNpthCatchAddr(NativeImpl.l());     // Catch: Throwable -> L28
        goto L21
    L29:
        System.loadLibrary("npth_tools");     // Catch: Throwable -> L13
        r5.f4169a = true;     // Catch: Throwable -> L13
    L13:
        io.reactivex.exceptions.a.p(n.f4057a, "npth_tools");     // Catch: Throwable -> L27
        r5.f4169a = true;     // Catch: Throwable -> L27
    L21:
        monitor-exit(NativeTools.class);     // Catch: Throwable -> L19
    L26:
        return f4167b;
    }

    public static String l(String r5) {
        StringBuilder r10 = new StringBuilder();
        if (r5 == null) goto L5;
        if (r5.length() >= 16) goto L9;
        r10.append(r5);     // Catch: Throwable -> L14
    L15:
        goto L13
    L9:
        r10.append(r5.charAt(6));     // Catch: Throwable -> L14
        r10.append(r5.charAt(7));     // Catch: Throwable -> L14
        r10.append(r5.charAt(4));     // Catch: Throwable -> L14
        r10.append(r5.charAt(5));     // Catch: Throwable -> L14
        r10.append(r5.charAt(2));     // Catch: Throwable -> L14
        r10.append(r5.charAt(3));     // Catch: Throwable -> L14
        r10.append(r5.charAt(0));     // Catch: Throwable -> L14
        r10.append(r5.charAt(1));     // Catch: Throwable -> L14
        r10.append(r5.charAt(10));     // Catch: Throwable -> L14
        r10.append(r5.charAt(11));     // Catch: Throwable -> L14
        r10.append(r5.charAt(8));     // Catch: Throwable -> L14
        r10.append(r5.charAt(9));     // Catch: Throwable -> L14
        r10.append(r5.charAt(14));     // Catch: Throwable -> L14
        r10.append(r5.charAt(15));     // Catch: Throwable -> L14
        r10.append(r5.charAt(12));     // Catch: Throwable -> L14
        r10.append(r5.charAt(13));     // Catch: Throwable -> L14
        if (r5.length() < 32) goto L15;
        r10.append(r5, 16, 32);     // Catch: Throwable -> L14
        r10.append('0');     // Catch: Throwable -> L14
    L13:
        return r10.toString().toUpperCase();
    L5:
        return r10.toString();
    }

    @Keep
    private static native int nStartFixArtDumpNativeStack(int r5);

    @Keep
    private static native int nativeAnrDump(String r5);

    @Keep
    private static native int nativeAnrMonitorInit();

    @Keep
    private static native int nativeAnrMonitorLoop();

    @Keep
    private static native int nativeCloseFile(int r5);

    @Keep
    private static native int nativeDumpCrashInfo(String r5, String r10, String r11, String r12, String r13, String r14, String r15, boolean r16);

    @Keep
    private static native int nativeDumpLogcat(String r5, String r10);

    @Keep
    private static native int nativeDumpPthreadFile(String r5);

    @Keep
    private static native int nativeDumpPthreadList(String r5, String r10);

    @Keep
    private static native int nativeDumpThrowable(String r5, Throwable r10);

    @Keep
    private static native int nativeFakeOpen(String r5);

    @Keep
    private static native int nativeFillNativeHeapSize(NativeHeapSize r5);

    @Keep
    private static native String nativeGetBuildID(String r5);

    @Keep
    private static native int nativeGetFDCount();

    @Keep
    private static native String[] nativeGetFdListForAPM();

    @Keep
    private static native int nativeGetMapsSize(String r5);

    @Keep
    private static native String nativeGetOOMReason(String r5, String r10);

    @Keep
    private static native long nativeGetPathSize(String r5, int r10);

    @Keep
    private static native int nativeGetResendSigquit();

    @Keep
    private static native long nativeGetSymbolAddress(String r5, String r10, int r11);

    @Keep
    private static native long nativeGetThreadCpuTimeMills(int r5);

    @Keep
    private static native int nativeGetThreadInfoFromTombStone(String r5, String r10);

    @Keep
    private static native boolean nativeIs64BitLibrary();

    @Keep
    private static native int nativeLockFile(String r5);

    @Keep
    private static native int nativeOpenFile(String r5);

    @Keep
    private static native boolean nativePidExists(int r5);

    @Keep
    private static native void nativeSetFdLimit();

    @Keep
    private static native void nativeSetMallocInfoFunctionAddress(long r5);

    @Keep
    private static native void nativeSetResendSigquit(int r5);

    @Keep
    private static native int nativeTerminateMonitorWait(long r5, String r10, String r11, String r12, boolean r13, boolean r14, boolean r15);

    @Keep
    private static native int nativeToolsInit(int r5, String r10);

    @Keep
    private static native int nativeUnlockFile(int r5);

    @Keep
    private static native int nativeUpdateEspInfoFromTombStone(String r5, String r10);

    @Keep
    private static native int nativeWriteFile(int r5, String r10, int r11);

    @Keep
    private static void onClearExcept(int[] r5) {
    }

    @Keep
    private static void onFindOneDied(int r5, String r10) {
        i9.f.f(r5, r10);
    }

    @Keep
    private static void onProcessBeWorker() {
        io.reactivex.exceptions.a.e("TermianteMonitor", "current be worker " + m.o(n.f4057a));
        o.e().b(new com.bytedance.android.anniex.worker.a(11));
    }

    @Keep
    private static void onStartAllClear() {
        o.e().c(new com.bytedance.android.anniex.worker.a(10), p.g);
    }

    @Keep
    private static void reportEventForAnrMonitor() {
        ((w8.b) w8.f.c(n.f4057a).f22816a).j();     // Catch: Throwable -> L9
        if (Header.i() == true) goto L11;
        File r5 = g.a();     // Catch: Throwable -> L9
        com.bytedance.android.anniex.base.service.e.l("anr_signal_trace", r5.getParentFile().getName());     // Catch: Throwable -> L9
        long r10 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        nativeAnrDump(r5.getAbsolutePath());     // Catch: Throwable -> L9
        long r11 = SystemClock.uptimeMillis() - r10;     // Catch: Throwable -> L9
        com.bytedance.android.anniex.base.service.e.l("after_signal_trace", r5.getParentFile().getName());     // Catch: Throwable -> L9
        JSONArray r12 = cl.a.F(r5.getAbsolutePath());     // Catch: Throwable -> L8
    L22:
        ((w8.b) w8.f.c(n.f4057a).f22816a).k(r11, r12);     // Catch: Throwable -> L15
    L26:
        return;
    L15:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L9
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L9
        return;
    L8:
        r12 = new JSONArray();     // Catch: Throwable -> L9
        goto L22
    L11:
        r12 = new JSONArray();     // Catch: Throwable -> L9
        r11 = -1;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
    }

    public static String z(String r5) {
        return nativeGetBuildID(r5);
    L4:
        return null;
    }

    public final void A() {
        if (this.f4169a == false) goto L12;
        nativeSetFdLimit();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        return;
    }

    public final void C() {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeAnrMonitorInit();     // Catch: Throwable -> L7
        return;
    }

    public final boolean E() {
        if (this.f4169a == true) goto L8;
        return false;
    L8:
        return nativeIs64BitLibrary();
    L7:
        return false;
    }

    public final int G(String r5) {
        if (this.f4169a == true) goto L8;
        return -1;
    L8:
        return nativeLockFile(r5);
    L7:
        return -1;
    }

    public final int H(String r5) {
        if (this.f4169a == true) goto L8;
        return -1;
    L8:
        return nativeOpenFile(r5);
    L7:
        return -1;
    }

    public final void a() {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeAnrMonitorLoop();     // Catch: Throwable -> L7
        return;
    }

    public final void b(int r5) {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeCloseFile(r5);     // Catch: Throwable -> L7
        return;
    }

    public final void c(int r5, String r10) {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeWriteFile(r5, r10, r10.length());     // Catch: Throwable -> L7
        return;
    }

    public final void d(long r11, String r13, String r14) {
        if (this.f4169a == true) goto L25;
        return;
    L25:
        String r10 = m.o(n.f4057a);     // Catch: Throwable -> L14
        boolean r12 = m.q(n.f4057a);     // Catch: Throwable -> L14
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_kill_history_data"}) != 1) goto L9;
    L13:
        boolean r15 = false;
    L18:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_kill_history_subprocess"}) != 1) goto L20;
        boolean r16 = false;
    L21:
        nativeTerminateMonitorWait(r11, r13, r14, r10, r12, r15, r16);     // Catch: Throwable -> L14
        return;
    L20:
        r16 = true;
        goto L21
    L9:
        if (m.q(n.f4057a) == false) goto L11;
    L16:
        r15 = true;
        goto L18
    L11:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_kill_history_data_sub"}) != 1) goto L13;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
    }

    public final void e(String r5, String r10) {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeDumpLogcat(r5, r10);     // Catch: Throwable -> L7
        return;
    }

    public final void g(boolean r5) {
        if (this.f4169a == false) goto L10;
        nativeSetResendSigquit(r5 ? 1 : 0);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    @Keep
    public long getSymbolAddress(String r5, String r10, boolean r11) {
        if (this.f4169a == true) goto L10;
        return -1;
    L10:
        return nativeGetSymbolAddress(r5, r10, r11 ? 1 : 0);
    L8:
        return 0;
    }

    public final void h(boolean r5, int r10) {
        if (this.f4169a == false) goto L37;
        if (ByteHook.init() == 0) goto L32;
        return;
    L32:
        if (r5 == false) goto L19;
        Context r11 = n.f4057a;     // Catch: Throwable -> L30
        String r12 = g.f4181a;     // Catch: Throwable -> L30
        File r13 = new File(g.h(r11), x8.a.f);     // Catch: Throwable -> L30
        if (r13.exists() == true) goto L13;
        r13.mkdirs();     // Catch: Throwable -> L30
    L13:
        String r14 = r13.getAbsolutePath() + '/' + n.f();     // Catch: Throwable -> L30
        if (this.f4169a == false) goto L27;
        doCommonLogPath(1, r14);     // Catch: Throwable -> L29
    L31:
        goto L27
    L19:
        Context r15 = n.f4057a;     // Catch: Throwable -> L30
        String r16 = g.f4181a;     // Catch: Throwable -> L30
        File r17 = new File(g.h(r15), x8.a.f);     // Catch: Throwable -> L30
        if (r17.exists() == true) goto L22;
        r17.mkdirs();     // Catch: Throwable -> L30
    L22:
        String r18 = r17.getAbsolutePath() + '/' + n.f();     // Catch: Throwable -> L30
        if (this.f4169a == false) goto L27;
        doCommonLogPath(0, r18);     // Catch: Throwable -> L29
    L27:
        doEnvMonitorInit(r10);     // Catch: Throwable -> L30
        return;
    L38:
        return;
    }

    public final boolean i(String r5) {
        if (this.f4169a == true) goto L9;
        return false;
    L9:
        nativeAnrDump(r5);     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }

    public final long j(int r5) {
        if (this.f4169a == true) goto L10;
        return -1;
    L10:
        return nativeGetThreadCpuTimeMills(r5);
    L8:
        return 0;
    }

    public final void m(String r5, String r10) {
        if (this.f4169a == false) goto L10;
        nativeDumpPthreadList(r5, r10);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public final long n() {
        if (this.f4169a == true) goto L8;
        return 0;
    L8:
        return doDumpEnvInfo();
    L10:
        return 0;
    }

    public final String o(String r5, String r10) {
        if (this.f4169a == true) goto L10;
        return "UNKNOWN";
    L10:
        String r11 = nativeGetOOMReason(r5, r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L8;
        return "UNKNOWN";
    L8:
        return r11;
    L9:
        return "UNKNOWN";
    }

    public final void p(String r10) {
        if (this.f4169a == true) goto L9;
        return;
    L9:
        nativeDumpCrashInfo(null, null, null, null, null, r10, null, false);     // Catch: Throwable -> L8
        return;
    }

    public final boolean q(int r5) {
        if (this.f4169a == true) goto L8;
        return false;
    L8:
        return nativePidExists(r5);
    L7:
        return false;
    }

    public final int r() {
        if (this.f4169a == true) goto L8;
        return -1;
    L8:
        return nativeGetFDCount();
    L7:
        return -1;
    }

    public final void s(int r5) {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nStartFixArtDumpNativeStack(r5);     // Catch: Throwable -> L7
        return;
    }

    @Keep
    public void setMallocInfoFunc(long r5) {
        if (this.f4169a == false) goto L10;
        nativeSetMallocInfoFunctionAddress(r5);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public final void t(String r10) {
        if (this.f4169a == true) goto L9;
        return;
    L9:
        nativeDumpCrashInfo(null, null, null, null, null, null, r10, false);     // Catch: Throwable -> L8
        return;
    }

    public final void u(String r5, String r10) {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeGetThreadInfoFromTombStone(r5, r10);     // Catch: Throwable -> L7
        return;
    }

    public final int v(String r5) {
        if (this.f4169a == true) goto L8;
        return -1;
    L8:
        return nativeFakeOpen(r5);
    L7:
        return -1;
    }

    public final void w(int r5) {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeUnlockFile(r5);     // Catch: Throwable -> L7
        return;
    }

    public final void x(String r5, String r10) {
        if (this.f4169a == true) goto L8;
        return;
    L8:
        nativeUpdateEspInfoFromTombStone(r5, r10);     // Catch: Throwable -> L7
        return;
    }

    public final boolean y() {
        if (this.f4169a == true) goto L11;
        return false;
    L11:
        if (nativeGetResendSigquit() == 0) goto L9;
        return true;
    L9:
        return false;
    }
}
