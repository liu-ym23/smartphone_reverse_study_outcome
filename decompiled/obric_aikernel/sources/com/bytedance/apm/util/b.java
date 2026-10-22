package com.bytedance.apm.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1103a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f1104b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f1105c = -1;

    static {
    }

    private static long a(long r10) {
        int r11 = Class.forName("libcore.io.OsConstants").getField("_SC_CLK_TCK").getInt(null);     // Catch: Exception -> L4
        Class<?> r12 = Class.forName("libcore.io.Libcore");     // Catch: Exception -> L4
        Class<?> r13 = Class.forName("libcore.io.Os");     // Catch: Exception -> L4
        Object r14 = r12.getField("os").get(null);     // Catch: Exception -> L4
        return ((Long) r13.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r14, new Object[]{Integer.valueOf(r11)})).longValue();
    L7:
        return r10;
    }

    public static long b() {
        return i(Process.myPid());
    }

    public static long c() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10 Exception -> L15
        goto L13
    L18:
        String r12 = r11.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r11.close();     // Catch: Throwable -> L7 Exception -> L9
        String[] r13 = r12.split(" ");     // Catch: Throwable -> L7 Exception -> L9
        long r14 = Long.parseLong(r13[13]) + Long.parseLong(r13[14]);
        x3.d.b(r11);
        return r14;
    L9:
        r10 = r11;
    L7:
        th = th;
        r10 = r11;
    L11:
        x3.d.b(r10);
        throw th;
    L10:
        th = th;
    L13:
        x3.d.b(r10);
        return -1;
    }

    public static synchronized int d() {
        monitor-enter(b.class);
        int r10 = f1103a;     // Catch: Throwable -> L26
        if (r10 == 0) goto L8;
        monitor-exit(b.class);
        return r10;
    L8:
        int r11 = 0;
        BufferedReader r12 = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);     // Catch: Throwable -> L18
    L30:
        String r13 = r12.readLine();     // Catch: Throwable -> L16
        if (r13 == null) goto L15;
        if (r13.startsWith("processor") == false) goto L30;
        r11 = r11 + 1;
        goto L30
    L15:
        r12.close();     // Catch: Throwable -> L29
        f1103a = r11;     // Catch: Throwable -> L29
    L16:
        Throwable th = th;
    L20:
        if (r12 == null) goto L42;
        r12.close();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L42:
        throw th;     // Catch: Throwable -> L29
    L18:
        th = move-exception;
        r12 = null;
        th = th;
    L23:
        int r14 = f1103a;     // Catch: Throwable -> L26
        monitor-exit(b.class);
        return r14;
    L26:
        th = move-exception;
        throw th;
    }

    public static long e() {
        File r10 = Environment.getRootDirectory();
        return f() + h(r10);
    }

    protected static long f() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return h(f.a(com.bytedance.apm.d.g()));
    L6:
        return 0;
    L11:
        return 0;
    }

    public static long g(File r10) {
        File[] r11 = r10.listFiles();
        long r12 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r13 = r11.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L12;
        File r15 = r11[r14];
        if (r15.isDirectory() == false) goto L10;
        long r16 = g(r15);
    L11:
        r12 = r12 + r16;
        r14 = r14 + 1;
        goto L6
    L10:
        r16 = r15.length();
        goto L11
    L12:
        return r12;
    }

    public static long h(File r10) {
        StatFs r11 = new StatFs(r10.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r11.getTotalBytes();
    L8:
        return ((long) r11.getBlockCount()) * r11.getBlockSize();
    L9:
        return 0;
    }

    public static long i(int r10) {
        BufferedReader r11 = null;
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + r10 + "/stat")), 1000);     // Catch: Throwable -> L10
        String r13 = r12.readLine();     // Catch: Throwable -> L7
        r12.close();     // Catch: Throwable -> L7
        String[] r14 = r13.split(" ");     // Catch: Throwable -> L7
        long r15 = ((Long.parseLong(r14[13]) + Long.parseLong(r14[14])) + Long.parseLong(r14[15])) + Long.parseLong(r14[16]);
        x3.d.b(r12);
        return r15;
    L7:
        r11 = r12;
    L8:
        x3.d.b(r11);
        return -1;
    }

    public static long j() {
        if (f1105c != (-1)) goto L6;
        f1105c = Runtime.getRuntime().maxMemory();     // Catch: Exception -> L7
    L6:
        return f1105c;
    }

    public static long k(long r10) {
        if (f1104b != (-1)) goto L16;
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 21) goto L8;
        long r12 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L12:
        if (r12 <= 0) goto L14;
        r10 = r12;
    L14:
        f1104b = r10;
        goto L16
    L8:
        if (r11 < 14) goto L10;
        r12 = a(r10);
        goto L12
    L10:
        r12 = r10;
    L16:
        return f1104b;
    }

    public static LinkedList<v> l(int r10) {
        return m(r10, false, 0);
    }

    public static LinkedList<v> m(int r24, boolean r25, long r26) {
        File[] r10 = new File("/proc/" + r24 + "/task/").listFiles();
        LinkedList<v> r11 = new LinkedList();
        int r12 = r10.length;
        BufferedReader r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L32;
        BufferedReader r15 = new BufferedReader(new InputStreamReader(new FileInputStream(r10[r14].getPath() + "/stat")), 1000);     // Catch: Throwable -> L25 Exception -> L33 FileNotFoundException -> L30
        String r16 = r15.readLine();     // Catch: Throwable -> L22 Exception -> L24
        int r17 = r16.lastIndexOf(41);     // Catch: Throwable -> L22 Exception -> L24
        String r18 = r16.substring(0, r17);     // Catch: Throwable -> L22 Exception -> L24
        String r19 = r16.substring(r17 + 4);     // Catch: Throwable -> L22 Exception -> L24
        int r20 = r18.indexOf(40);     // Catch: Throwable -> L22 Exception -> L24
        int r110 = Integer.valueOf(r18.substring(0, r20 - 1)).intValue();     // Catch: Throwable -> L22 Exception -> L24
        String r111 = r18.substring(r20 + 1);     // Catch: Throwable -> L22 Exception -> L24
        String[] r21 = r19.split(" ");     // Catch: Throwable -> L22 Exception -> L24
        long r112 = Long.parseLong(r21[10]);     // Catch: Throwable -> L22 Exception -> L24
        long r113 = Long.parseLong(r21[11]);     // Catch: Throwable -> L22 Exception -> L24
        long r22 = Long.parseLong(r21[18]);     // Catch: Throwable -> L22 Exception -> L24
        if (r25 == true) goto L9;
    L21:
        x3.d.b(r15);
        r13 = r15;
    L31:
        r14 = r14 + 1;
        goto L3
    L9:
        if ((r112 + r113) <= 0) goto L21;
        v r23 = new v(r110, r111, r112, r113, r22);     // Catch: Throwable -> L22 Exception -> L24
        if (r110 == Process.myPid()) goto L13;
    L20:
        r11.add(r23);     // Catch: Throwable -> L22 Exception -> L24
        goto L21
    L13:
        if (r26 <= 0) goto L20;
        if (r23.f1155g <= (2 * r26)) goto L20;
        if (com.bytedance.apm.d.D() == false) goto L19;
        e0.e.g("CommonMonitorUtil", new String[]{"origin thread starttime error:" + r23.f1155g + " new:" + r26});     // Catch: Throwable -> L22 Exception -> L24
    L19:
        r23.f1155g = r26;     // Catch: Throwable -> L22 Exception -> L24
        r23.f1152d = (r23.f1151c * 1.0f) / r26;     // Catch: Throwable -> L22 Exception -> L24
        goto L20
    L24:
        r13 = r15;
    L22:
        th = th;
        r13 = r15;
    L26:
        x3.d.b(r13);
        throw th;
    L30:
        x3.d.b(r13);
    L25:
        th = th;
    L28:
        x3.d.b(r13);
        return null;
    L32:
        return r11;
    }

    public static long n() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream(CommonProcUtil.PROC_STAT_FILE)), 1000);     // Catch: Throwable -> L10
        String r12 = r11.readLine();     // Catch: Throwable -> L7
        r11.close();     // Catch: Throwable -> L7
        String[] r13 = r12.split(" ");     // Catch: Throwable -> L7
        long r14 = (((((Long.parseLong(r13[2]) + Long.parseLong(r13[3])) + Long.parseLong(r13[4])) + Long.parseLong(r13[6])) + Long.parseLong(r13[5])) + Long.parseLong(r13[7])) + Long.parseLong(r13[8]);
        x3.d.b(r11);
        return r14;
    L7:
        r10 = r11;
    L8:
        x3.d.b(r10);
        return -1;
    }

    public static long o() {
        int r10 = d();
        long r11 = -1;
        if (r10 > 0) goto L5;
        return -1;
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r10) goto L26;
        BufferedReader r13 = null;
        BufferedReader r14 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + r12 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L22
    L30:
        String r15 = r14.readLine();     // Catch: Throwable -> L20
        if (r15 != null) goto L12;
    L28:
        r14.close();     // Catch: Throwable -> L27
        r12 = r12 + 1;     // Catch: Throwable -> L27
        goto L6
    L12:
        if (r15.isEmpty() == true) goto L28;
        String[] r16 = r15.split("\\s+");     // Catch: Throwable -> L20
        if (r16.length != 2) goto L30;
        r11 = r11 + Long.parseLong(r16[1]);
    L20:
        th = th;
        r13 = r14;
    L23:
        if (r13 == null) goto L25;
        r13.close();     // Catch: Throwable -> L27
    L25:
        throw th;     // Catch: Throwable -> L27
    L22:
        th = th;
    L26:
        return r11;
    }

    public static long p(Context r10) {
        if (r10 != null) goto L18;
        return -1;
    L18:
    L17:
        return -1;
    L6:
        if (TextUtils.isEmpty(r10.getPackageName()) == false) goto L8;
        return -1;
    L8:
        File r11 = r10.getCacheDir();     // Catch: Throwable -> L17
        long r12 = 0;
        if (r11.exists() == false) goto L11;
        long r13 = g(r11);     // Catch: Throwable -> L17
    L12:
        File r14 = com.bytedance.apm.d.g().getExternalCacheDir();     // Catch: Throwable -> L17
        if (r14.exists() == false) goto L16;
        r12 = g(r14);     // Catch: Throwable -> L17
    L16:
        return r13 + r12;
    L11:
        r13 = 0;
        goto L12
    }

    public static long q(Context r10) {
        if (r10 != null) goto L17;
        return -1;
    L17:
        File r11 = new File(r10.getFilesDir().getParent());     // Catch: Throwable -> L16
        if (r11.exists() == true) goto L8;
        return -1;
    L8:
        long r12 = g(r11);     // Catch: Throwable -> L16
        File r13 = r10.getExternalFilesDir(null);     // Catch: Throwable -> L16
        if (r13 == null) goto L15;
        File r14 = r13.getParentFile();     // Catch: Throwable -> L16
        long r15 = 0;
        if (r14.exists() == false) goto L14;
        r15 = g(r14);     // Catch: Throwable -> L16
    L14:
        return r12 + r15;
    L15:
        return -1;
    }
}
