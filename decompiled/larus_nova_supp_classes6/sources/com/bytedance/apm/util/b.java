package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static int a = 0;
    public static long b = -1;
    public static int c = 0;
    public static long d = -1;

    public static long i() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/stat")), 1000);     // Catch: Throwable -> L10
        String r2 = r1.readLine();     // Catch: Throwable -> L7
        r1.close();     // Catch: Throwable -> L7
        String[] r3 = r2.split(" ");     // Catch: Throwable -> L7
        long r4 = (((((Long.parseLong(r3[2]) + Long.parseLong(r3[3])) + Long.parseLong(r3[4])) + Long.parseLong(r3[6])) + Long.parseLong(r3[5])) + Long.parseLong(r3[7])) + Long.parseLong(r3[8]);
        d27.d.a(r1);
        return r4;
    L7:
        r0 = r1;
    L8:
        d27.d.a(r0);
        return -1;
    }

    public static long k() {
        int r2 = 0;
        String[] r0 = g(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split("\n");     // Catch: Exception -> L20
        int r1 = r0.length;     // Catch: Exception -> L20
    L5:
        if (r2 >= r1) goto L14;
        String r6 = r0[r2];     // Catch: Exception -> L20
        if (r6.startsWith("VmSize") == false) goto L12;
        Matcher r5 = PatternProtector.compile("\\d+").matcher(r6);     // Catch: Exception -> L20
        if (r5.find() == false) goto L12;
        return CastLongProtector.parseLong(r5.group());
    L12:
        r2 = r2 + 1;     // Catch: Exception -> L20
        goto L5
    L14:
        if (r0.length <= 12) goto L19;
        Matcher r3 = PatternProtector.compile("\\d+").matcher(r0[12]);     // Catch: Exception -> L20
        if (r3.find() == false) goto L19;
        return CastLongProtector.parseLong(r3.group());
    L19:
        return -1;
    }

    public static synchronized int b() {
        monitor-enter(b.class);
        int r1 = a;     // Catch: Throwable -> L27
        if (r1 == 0) goto L37;
        monitor-exit(b.class);
        return r1;
    L37:
        BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"), 50);     // Catch: Throwable -> L19
        int r3 = 0;
    L31:
        String r4 = r2.readLine();     // Catch: Throwable -> L17
        if (r4 == null) goto L16;
        if (r4.startsWith("processor") == false) goto L31;
        r3 = r3 + 1;
        goto L31
    L16:
        r2.close();     // Catch: Throwable -> L30
        a = r3;     // Catch: Throwable -> L30
    L17:
        Throwable th = th;
    L21:
        if (r2 == null) goto L43;
        r2.close();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L43:
        throw th;     // Catch: Throwable -> L30
    L19:
        th = move-exception;
        r2 = null;
        th = th;
    L24:
        int r5 = a;     // Catch: Throwable -> L27
        monitor-exit(b.class);
        return r5;
    L27:
        th = move-exception;
        throw th;
    }

    public static long f() {
        if (b != (-1)) goto L10;
        long r0 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r0 > 0) goto L8;
        r0 = 100;
    L8:
        b = r0;
    L10:
        return b;
    }

    public static long a() {
        return d(Process.myPid());
    }

    public static long j() {
        int r0 = b();
        long r1 = -1;
        if (r0 > 0) goto L5;
        return -1;
    L5:
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L26;
        BufferedReader r4 = null;
        BufferedReader r5 = new BufferedReader(new PolarisFileReaderWrapper("/sys/devices/system/cpu/cpu" + r3 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L22
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

    public static long c(File r6) {
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
        long r5 = c(r4);
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

    public static long d(int r6) {
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + r6 + "/stat")), 1000);     // Catch: Throwable -> L10
        String r7 = r2.readLine();     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        String[] r8 = r7.split(" ");     // Catch: Throwable -> L7
        long r0 = ((Long.parseLong(r8[13]) + Long.parseLong(r8[14])) + Long.parseLong(r8[15])) + Long.parseLong(r8[16]);
        d27.d.a(r2);
        return r0;
    L7:
        r1 = r2;
    L8:
        d27.d.a(r1);
        return -1;
    }

    public static String g(String r4) throws Exception {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);
        BufferedReader r5 = null;
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r0);     // Catch: Throwable -> L21
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L13
        BufferedReader r3 = new BufferedReader(new InputStreamReader(r1));     // Catch: Throwable -> L17
    L29:
        String r6 = r3.readLine();     // Catch: Throwable -> L15
        if (r6 == null) goto L10;
        r2.append(r6);     // Catch: Throwable -> L15
        r2.append('\n');     // Catch: Throwable -> L15
        goto L29
    L10:
        r3.close();     // Catch: Throwable -> L13
        String r7 = r2.toString();     // Catch: Throwable -> L13
        r1.close();
        return r7;
    L15:
        th = move-exception;
        th = th;
        r5 = r3;
    L18:
        if (r5 == null) goto L20;
        r5.close();     // Catch: Throwable -> L13
    L20:
        throw th;     // Catch: Throwable -> L13
    L17:
        th = th;
    L13:
        Throwable th = th;
    L23:
        if (r1 == null) goto L25;
        r1.close();
    L25:
        throw th;
    L21:
        th = move-exception;
        r1 = null;
        th = th;
        goto L23
    }

    public static Debug.MemoryInfo e(int r3, Context r4) {
        if (r4 != null) goto L11;
        return null;
    L11:
        ActivityManager r5 = (ActivityManager) r4.getSystemService("activity");     // Catch: Exception -> L10
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.getProcessMemoryInfo(new int[]{r3})[0];
    L10:
        return null;
    }

    public static LinkedList<t> h(int r24, boolean r25, long r26) {
        File[] r2 = new PolarisFileWrapper("/proc/" + r24 + "/task/").listFiles();
        LinkedList<t> r3 = new LinkedList();
        int r4 = r2.length;
        BufferedReader r8 = null;
        int r7 = 0;
    L3:
        if (r7 >= r4) goto L32;
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r2[r7].getPath() + "/stat")), 1000);     // Catch: Throwable -> L25 Exception -> L33 FileNotFoundException -> L30
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
        d27.d.a(r10);
        r8 = r10;
    L31:
        r7 = r7 + 1;
        goto L3
    L9:
        if ((r18 + r19) <= 0) goto L21;
        t r21 = new t(r15, r16, r18, r19, r20);     // Catch: Throwable -> L22 Exception -> L24
        if (r15 == Process.myPid()) goto L13;
    L20:
        r3.add(r21);     // Catch: Throwable -> L22 Exception -> L24
        goto L21
    L13:
        if (r26 <= 0) goto L20;
        if (r21.g <= (2 * r26)) goto L20;
        if (com.bytedance.apm.d.j() == false) goto L19;
        ps3.b.a(new String[]{"origin thread starttime error:" + r21.g + " new:" + r26});     // Catch: Throwable -> L22 Exception -> L24
    L19:
        r21.g = r26;     // Catch: Throwable -> L22 Exception -> L24
        r21.d = (r21.c * 1.0f) / r26;     // Catch: Throwable -> L22 Exception -> L24
        goto L20
    L24:
        r8 = r10;
    L22:
        th = th;
        r8 = r10;
    L26:
        d27.d.a(r8);
        throw th;
    L30:
        d27.d.a(r8);
    L25:
        th = th;
    L28:
        d27.d.a(r8);
        return null;
    L32:
        return r3;
    }
}
