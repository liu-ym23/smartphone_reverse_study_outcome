package com.bytedance.apm6.util.proc;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.apm6.util.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class CommonProcUtil {
    public static final int BUFFER_SIZE = 8192;
    public static final String CACHE = "cache";
    public static final long DEFAULT_CLOCK_TICKS_PER_SECOND = 100;
    private static final int ERROR_RESULT = -1;
    public static final long KB = 1024;
    public static final String MEMORY_INFO_PATH = "/proc/meminfo";
    public static final String OUTSIDE_STORAGE = "/Android/data/";
    public static final String PROC_STAT_FILE = "/proc/stat";
    private static int isSysProcCanRead = 0;
    private static long sClkTck = -1;

    static {
    }

    public CommonProcUtil() {
    }

    public static String convertStreamToString(InputStream r10) {
        StringBuilder r11 = new StringBuilder();
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new InputStreamReader(r10));     // Catch: Throwable -> L12
    L16:
        String r14 = r13.readLine();     // Catch: Throwable -> L10
        if (r14 == null) goto L8;
        r11.append(r14);     // Catch: Throwable -> L10
        r11.append('\n');     // Catch: Throwable -> L10
        goto L16
    L8:
        r13.close();
        return r11.toString();
    L10:
        th = th;
        r12 = r13;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static long getAppCPUTime() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10
        String r12 = r11.readLine();     // Catch: Throwable -> L7
        r11.close();     // Catch: Throwable -> L7
        String[] r13 = r12.split(" ");     // Catch: Throwable -> L7
        long r14 = Long.parseLong(r13[13]) + Long.parseLong(r13[14]);
        IOUtils.safeClose(r11);
        return r14;
    L7:
        r10 = r11;
    L8:
        IOUtils.safeClose(r10);
        return -1;
    }

    public static long getAppCpuActiveTime() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10 Exception -> L15
        goto L13
    L18:
        String r12 = r11.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r11.close();     // Catch: Throwable -> L7 Exception -> L9
        String[] r13 = r12.split(" ");     // Catch: Throwable -> L7 Exception -> L9
        long r14 = Long.parseLong(r13[13]) + Long.parseLong(r13[14]);
        IOUtils.safeClose(r11);
        return r14;
    L9:
        r10 = r11;
    L7:
        th = th;
        r10 = r11;
    L11:
        IOUtils.safeClose(r10);
        throw th;
    L10:
        th = th;
    L13:
        IOUtils.safeClose(r10);
        return -1;
    }

    public static long getIdleCPUTime() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream(PROC_STAT_FILE)), 1000);     // Catch: Throwable -> L10 Exception -> L16
        goto L14
    L19:
        String r12 = r11.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r11.close();     // Catch: Throwable -> L7 Exception -> L9
        long r13 = Long.parseLong(r12.split(" ")[5]);     // Catch: Throwable -> L7 Exception -> L9
        IOUtils.safeClose(r11);
        return r13;
    L9:
        r10 = r11;
    L7:
        Throwable th = th;
    L12:
        IOUtils.safeClose(r11);
        throw th;
    L10:
        th = move-exception;
        r11 = null;
        th = th;
    L14:
        IOUtils.safeClose(r10);
        return -1;
    }

    public static int getMyPid() {
        return Process.myPid();
    }

    public static String getStringFromFile(String r10) {
        FileInputStream r11 = new FileInputStream(new File(r10));     // Catch: Throwable -> L9
        String r12 = convertStreamToString(r11);     // Catch: Throwable -> L7
        r11.close();
        return r12;
    L7:
        Throwable th = th;
    L11:
        if (r11 == null) goto L13;
        r11.close();
    L13:
        throw th;
    L9:
        th = move-exception;
        r11 = null;
        th = th;
        goto L11
    }

    public static long getTotalCPUTime() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream(PROC_STAT_FILE)), 1000);     // Catch: Throwable -> L10
        String r12 = r11.readLine();     // Catch: Throwable -> L7
        r11.close();     // Catch: Throwable -> L7
        String[] r13 = r12.split(" ");     // Catch: Throwable -> L7
        long r14 = (((((Long.parseLong(r13[2]) + Long.parseLong(r13[3])) + Long.parseLong(r13[4])) + Long.parseLong(r13[6])) + Long.parseLong(r13[5])) + Long.parseLong(r13[7])) + Long.parseLong(r13[8]);
        IOUtils.safeClose(r11);
        return r14;
    L7:
        r10 = r11;
    L8:
        IOUtils.safeClose(r10);
        return -1;
    }

    public static long getTotalMemory(Context r10) {
        long r11 = -1;
        if (r10 != null) goto L6;
        return -1;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L12;
        ActivityManager.MemoryInfo r12 = new ActivityManager.MemoryInfo();
        ActivityManager r13 = (ActivityManager) r10.getSystemService("activity");
        if (r13 != null) goto L10;
        return -1;
    L10:
        r13.getMemoryInfo(r12);
        return r12.totalMem / 1024;
    L12:
        BufferedReader r14 = null;
        String r15 = "";
        BufferedReader r16 = new BufferedReader(new FileReader(MEMORY_INFO_PATH), 8192);     // Catch: Throwable -> L24 Exception -> L30
    L31:
        String r17 = r16.readLine();     // Catch: Throwable -> L21 Exception -> L23
        if (r17 == null) goto L19;
        if (r17.contains("MemTotal") == false) goto L31;
        r15 = r17.split(":")[1].trim();     // Catch: Throwable -> L21 Exception -> L23
    L19:
        r16.close();     // Catch: Throwable -> L21 Exception -> L23
        r11 = Long.parseLong(r15.split(" ")[0].trim());     // Catch: Throwable -> L21 Exception -> L23
        IOUtils.safeClose(r16);
    L29:
        return r11;
    L23:
        r14 = r16;
    L21:
        Throwable th = th;
    L26:
        IOUtils.safeClose(r16);
        throw th;
    L24:
        th = move-exception;
        r16 = null;
        th = th;
    L28:
        IOUtils.safeClose(r14);
        goto L29
    }

    public static long getVmSize() {
        int r10 = 0;
        String[] r11 = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(getMyPid())})).trim().split("\n");     // Catch: Exception -> L20
        int r12 = r11.length;     // Catch: Exception -> L20
    L5:
        if (r10 >= r12) goto L14;
        String r13 = r11[r10];     // Catch: Exception -> L20
        if (r13.startsWith("VmSize") == false) goto L12;
        Matcher r14 = Pattern.compile("\\d+").matcher(r13);     // Catch: Exception -> L20
        if (r14.find() == false) goto L12;
        return Long.parseLong(r14.group());
    L12:
        r10 = r10 + 1;     // Catch: Exception -> L20
        goto L5
    L14:
        if (r11.length <= 12) goto L19;
        Matcher r15 = Pattern.compile("\\d+").matcher(r11[12]);     // Catch: Exception -> L20
        if (r15.find() == false) goto L19;
        return Long.parseLong(r15.group());
    L19:
        return -1;
    }

    public static boolean isProcStatCanRead() {
        int r10 = isSysProcCanRead;
        if (r10 != 0) goto L12;
        File r11 = new File(PROC_STAT_FILE);
        if (r11.exists() == true) goto L7;
    L10:
        isSysProcCanRead = 2;
        return false;
    L7:
        if (r11.canRead() == false) goto L10;
        isSysProcCanRead = 1;
        return true;
    L12:
        if (r10 == 1) goto L14;
        return false;
    L14:
        return true;
    }
}
