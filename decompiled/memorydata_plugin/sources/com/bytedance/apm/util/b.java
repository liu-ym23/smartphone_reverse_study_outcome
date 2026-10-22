package com.bytedance.apm.util;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private static int f1480a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f1481b = -1;
    private static int c = 0;
    private static long d = -1;

    static {
    }

    public static long a() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(CommonProcUtil.PROC_STAT_FILE)), 1000);     // Catch: Throwable -> L10
        String r2 = r1.readLine();     // Catch: Throwable -> L7
        r1.close();     // Catch: Throwable -> L7
        String[] r3 = r2.split(" ");     // Catch: Throwable -> L7
        long r4 = (((((Long.parseLong(r3[2]) + Long.parseLong(r3[3])) + Long.parseLong(r3[4])) + Long.parseLong(r3[6])) + Long.parseLong(r3[5])) + Long.parseLong(r3[7])) + Long.parseLong(r3[8]);
        com.bytedance.monitor.util.d.a(r1);
        return r4;
    L7:
        r0 = r1;
    L8:
        com.bytedance.monitor.util.d.a(r0);
        return -1;
    }

    public static long a(int r6) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + r6 + "/stat")), 1000);     // Catch: Throwable -> L10
        String r7 = r1.readLine();     // Catch: Throwable -> L7
        r1.close();     // Catch: Throwable -> L7
        String[] r8 = r7.split(" ");     // Catch: Throwable -> L7
        long r2 = ((Long.parseLong(r8[13]) + Long.parseLong(r8[14])) + Long.parseLong(r8[15])) + Long.parseLong(r8[16]);
        com.bytedance.monitor.util.d.a(r1);
        return r2;
    L7:
        r0 = r1;
    L8:
        com.bytedance.monitor.util.d.a(r0);
        return -1;
    }

    public static long a(long r4) {
        if (f1481b != (-1)) goto L16;
        if (Build.VERSION.SDK_INT < 21) goto L8;
        long r0 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L12:
        if (r0 <= 0) goto L14;
        r4 = r0;
    L14:
        f1481b = r4;
        goto L16
    L8:
        if (Build.VERSION.SDK_INT < 14) goto L10;
        r0 = b(r4);
        goto L12
    L10:
        r0 = r4;
    L16:
        return f1481b;
    }

    public static long a(File r6) {
        File[] r7 = r6.listFiles();
        long r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r2 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        File r4 = r7[r3];
        if (r4.isDirectory() == false) goto L10;
        long r5 = a(r4);
    L11:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L6
    L10:
        r5 = r4.length();
        goto L11
    L12:
        return r0;
    }

    public static LinkedList<s> a(int r24, boolean r25, long r26) {
        File[] r2 = new File("/proc/" + r24 + "/task/").listFiles();
        LinkedList<s> r3 = new LinkedList();
        int r4 = r2.length;
        BufferedReader r8 = null;
        int r7 = 0;
    L3:
        if (r7 >= r4) goto L32;
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream(r2[r7].getPath() + "/stat")), 1000);     // Catch: Throwable -> L25 Exception -> L33 FileNotFoundException -> L30
        String r9 = r10.readLine();     // Catch: Throwable -> L22 Exception -> L24
        int r11 = r9.lastIndexOf(41);     // Catch: Throwable -> L22 Exception -> L24
        String r12 = r9.substring(0, r11);     // Catch: Throwable -> L22 Exception -> L24
        String r13 = r9.substring(r11 + 4);     // Catch: Throwable -> L22 Exception -> L24
        int r14 = r12.indexOf(40);     // Catch: Throwable -> L22 Exception -> L24
        int r15 = Integer.valueOf(r12.substring(0, r14 - 1)).intValue();     // Catch: Throwable -> L22 Exception -> L24
        String r16 = r12.substring(r14 + 1);     // Catch: Throwable -> L22 Exception -> L24
        String[] r17 = r13.split(" ");     // Catch: Throwable -> L22 Exception -> L24
        long r18 = Long.parseLong(r17[10]);     // Catch: Throwable -> L22 Exception -> L24
        long r19 = Long.parseLong(r17[11]);     // Catch: Throwable -> L22 Exception -> L24
        long r20 = Long.parseLong(r17[18]);     // Catch: Throwable -> L22 Exception -> L24
        if (r25 == true) goto L9;
    L21:
        com.bytedance.monitor.util.d.a(r10);
        r8 = r10;
    L31:
        r7 = r7 + 1;
        goto L3
    L9:
        if ((r18 + r19) <= 0) goto L21;
        s r21 = new s(r15, r16, r18, r19, r20);     // Catch: Throwable -> L22 Exception -> L24
        if (r15 == Process.myPid()) goto L13;
    L20:
        r3.add(r21);     // Catch: Throwable -> L22 Exception -> L24
        goto L21
    L13:
        if (r26 <= 0) goto L20;
        if (r21.h <= (2 * r26)) goto L20;
        if (com.bytedance.apm.b.k() == false) goto L19;
        com.bytedance.apm.e.e.b("CommonMonitorUtil", new String[]{"origin thread starttime error:" + r21.h + " new:" + r26});     // Catch: Throwable -> L22 Exception -> L24
    L19:
        r21.h = r26;     // Catch: Throwable -> L22 Exception -> L24
        r21.d = (r21.c * 1.0f) / r21.h;     // Catch: Throwable -> L22 Exception -> L24
        goto L20
    L24:
        r8 = r10;
    L22:
        th = th;
        r8 = r10;
    L26:
        com.bytedance.monitor.util.d.a(r8);
        throw th;
    L30:
        com.bytedance.monitor.util.d.a(r8);
    L25:
        th = th;
    L28:
        com.bytedance.monitor.util.d.a(r8);
        return null;
    L32:
        return r3;
    }

    public static long b() {
        int r0 = c();
        long r1 = -1;
        if (r0 > 0) goto L5;
        return -1;
    L5:
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L26;
        BufferedReader r4 = null;
        BufferedReader r5 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + r3 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L22
    L30:
        String r6 = r5.readLine();     // Catch: Throwable -> L20
        if (r6 != null) goto L12;
    L28:
        r5.close();     // Catch: Throwable -> L27
        r3 = r3 + 1;     // Catch: Throwable -> L27
        goto L6
    L12:
        if (r6.isEmpty() == true) goto L28;
        String[] r7 = r6.split("\\s+");     // Catch: Throwable -> L20
        if (r7.length != 2) goto L30;
        r1 = r1 + Long.parseLong(r7[1]);
    L20:
        th = th;
        r4 = r5;
    L23:
        if (r4 == null) goto L25;
        r4.close();     // Catch: Throwable -> L27
    L25:
        throw th;     // Catch: Throwable -> L27
    L22:
        th = th;
    L26:
        return r1;
    }

    private static long b(long r9) {
        int r1 = ZeusTransformUtils.forName("libcore.io.OsConstants", "com.obric.memorydata.plugin").getField("_SC_CLK_TCK").getInt(null);     // Catch: Exception -> L5
        Class r3 = ZeusTransformUtils.forName("libcore.io.Libcore", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Class r4 = ZeusTransformUtils.forName("libcore.io.Os", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Object r2 = r3.getField("os").get(null);     // Catch: Exception -> L5
        return ((Long) ZeusTransformUtils.preCheckCast(r4.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r2, new Object[]{Integer.valueOf(r1)}), Long.class, "com.obric.memorydata.plugin")).longValue();
    L8:
        return r9;
    }

    public static LinkedList<s> b(int r3) {
        return a(r3, false, 0);
    }

    public static synchronized int c() {
        monitor-enter(b.class);
        int r1 = f1480a;     // Catch: Throwable -> L26
        if (r1 == 0) goto L8;
        monitor-exit(b.class);
        return r1;
    L8:
        int r2 = 0;
        BufferedReader r3 = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);     // Catch: Throwable -> L18
    L30:
        String r4 = r3.readLine();     // Catch: Throwable -> L16
        if (r4 == null) goto L15;
        if (r4.startsWith("processor") == false) goto L30;
        r2 = r2 + 1;
        goto L30
    L15:
        r3.close();     // Catch: Throwable -> L29
        f1480a = r2;     // Catch: Throwable -> L29
    L16:
        Throwable th = th;
    L20:
        if (r3 == null) goto L42;
        r3.close();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L42:
        throw th;     // Catch: Throwable -> L29
    L18:
        th = move-exception;
        r3 = null;
        th = th;
    L23:
        int r5 = f1480a;     // Catch: Throwable -> L26
        monitor-exit(b.class);
        return r5;
    L26:
        th = move-exception;
        throw th;
    }

    public static long d() {
        return a(Process.myPid());
    }

    public static long e() {
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10 Exception -> L15
        String r0 = r2.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r2.close();     // Catch: Throwable -> L7 Exception -> L9
        String[] r3 = r0.split(" ");     // Catch: Throwable -> L7 Exception -> L9
        long r4 = Long.parseLong(r3[13]) + Long.parseLong(r3[14]);
        com.bytedance.monitor.util.d.a(r2);
        return r4;
    L9:
        r1 = r2;
    L7:
        th = th;
        r1 = r2;
    L11:
        com.bytedance.monitor.util.d.a(r1);
        throw th;
    L10:
        th = th;
    L13:
        com.bytedance.monitor.util.d.a(r1);
        return -1;
    }
}
