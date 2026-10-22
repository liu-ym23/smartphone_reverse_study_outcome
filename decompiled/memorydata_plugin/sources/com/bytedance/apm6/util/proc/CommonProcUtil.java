package com.bytedance.apm6.util.proc;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.apm6.util.IOUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;

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

    public static String convertStreamToString(InputStream r4) {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r4));     // Catch: Throwable -> L12
    L16:
        String r5 = r2.readLine();     // Catch: Throwable -> L10
        if (r5 == null) goto L8;
        r0.append(r5).append('\n');     // Catch: Throwable -> L10
        goto L16
    L8:
        r2.close();
        return r0.toString();
    L10:
        th = th;
        r1 = r2;
    L13:
        if (r1 == null) goto L15;
        r1.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static long getAppCPUTime() {
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10
        String r0 = r2.readLine();     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        String[] r3 = r0.split(" ");     // Catch: Throwable -> L7
        long r4 = Long.parseLong(r3[13]) + Long.parseLong(r3[14]);
        IOUtils.safeClose(r2);
        return r4;
    L7:
        r1 = r2;
    L8:
        IOUtils.safeClose(r1);
        return -1;
    }

    public static long getAppCpuActiveTime() {
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10 Exception -> L15
        String r0 = r2.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r2.close();     // Catch: Throwable -> L7 Exception -> L9
        String[] r3 = r0.split(" ");     // Catch: Throwable -> L7 Exception -> L9
        long r4 = Long.parseLong(r3[13]) + Long.parseLong(r3[14]);
        IOUtils.safeClose(r2);
        return r4;
    L9:
        r1 = r2;
    L7:
        th = th;
        r1 = r2;
    L11:
        IOUtils.safeClose(r1);
        throw th;
    L10:
        th = th;
    L13:
        IOUtils.safeClose(r1);
        return -1;
    }

    public static long getIdleCPUTime() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(PROC_STAT_FILE)), 1000);     // Catch: Throwable -> L10 Exception -> L16
        goto L14
    L19:
        String r2 = r1.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r1.close();     // Catch: Throwable -> L7 Exception -> L9
        long r3 = Long.parseLong(r2.split(" ")[5]);     // Catch: Throwable -> L7 Exception -> L9
        IOUtils.safeClose(r1);
        return r3;
    L9:
        r0 = r1;
    L7:
        Throwable th = th;
    L12:
        IOUtils.safeClose(r1);
        throw th;
    L10:
        th = move-exception;
        r1 = null;
        th = th;
    L14:
        IOUtils.safeClose(r0);
        return -1;
    }

    public static int getMyPid() {
        return Process.myPid();
    }

    public static String getStringFromFile(String r2) {
        FileInputStream r1 = new FileInputStream(new File(r2));     // Catch: Throwable -> L9
        String r3 = convertStreamToString(r1);     // Catch: Throwable -> L7
        r1.close();
        return r3;
    L7:
        Throwable th = th;
    L11:
        if (r1 == null) goto L13;
        r1.close();
    L13:
        throw th;
    L9:
        th = move-exception;
        r1 = null;
        th = th;
        goto L11
    }

    public static long getTotalCPUTime() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(PROC_STAT_FILE)), 1000);     // Catch: Throwable -> L10
        String r2 = r1.readLine();     // Catch: Throwable -> L7
        r1.close();     // Catch: Throwable -> L7
        String[] r3 = r2.split(" ");     // Catch: Throwable -> L7
        long r4 = (((((Long.parseLong(r3[2]) + Long.parseLong(r3[3])) + Long.parseLong(r3[4])) + Long.parseLong(r3[6])) + Long.parseLong(r3[5])) + Long.parseLong(r3[7])) + Long.parseLong(r3[8]);
        IOUtils.safeClose(r1);
        return r4;
    L7:
        r0 = r1;
    L8:
        IOUtils.safeClose(r0);
        return -1;
    }

    public static long getTotalMemory(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        long r2 = -1;
        if (r7 != null) goto L6;
        return -1;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L12;
        ActivityManager.MemoryInfo r0 = new ActivityManager.MemoryInfo();
        ActivityManager r8 = (ActivityManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L10;
        return -1;
    L10:
        r8.getMemoryInfo(r0);
        return r0.totalMem / 1024;
    L12:
        BufferedReader r9 = null;
        String r1 = "";
        BufferedReader r3 = new BufferedReader(new FileReader(MEMORY_INFO_PATH), 8192);     // Catch: Throwable -> L24 Exception -> L30
    L31:
        String r10 = r3.readLine();     // Catch: Throwable -> L21 Exception -> L23
        if (r10 == null) goto L19;
        if (r10.contains("MemTotal") == false) goto L31;
        r1 = r10.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[1].trim();     // Catch: Throwable -> L21 Exception -> L23
    L19:
        r3.close();     // Catch: Throwable -> L21 Exception -> L23
        r2 = Long.parseLong(r1.split(" ")[0].trim());     // Catch: Throwable -> L21 Exception -> L23
        IOUtils.safeClose(r3);
    L29:
        return r2;
    L23:
        r9 = r3;
    L21:
        Throwable th = th;
    L26:
        IOUtils.safeClose(r3);
        throw th;
    L24:
        th = move-exception;
        r3 = null;
        th = th;
    L28:
        IOUtils.safeClose(r9);
        goto L29
    }

    public static long getVmSize() {
        int r2 = 0;
        String[] r0 = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(getMyPid())})).trim().split("\n");     // Catch: Exception -> L20
        int r1 = r0.length;     // Catch: Exception -> L20
    L5:
        if (r2 >= r1) goto L14;
        String r6 = r0[r2];     // Catch: Exception -> L20
        if (r6.startsWith("VmSize") == false) goto L12;
        Matcher r5 = Pattern.compile("\\d+").matcher(r6);     // Catch: Exception -> L20
        if (r5.find() == false) goto L12;
        return Long.parseLong(r5.group());
    L12:
        r2 = r2 + 1;     // Catch: Exception -> L20
        goto L5
    L14:
        if (r0.length <= 12) goto L19;
        Matcher r3 = Pattern.compile("\\d+").matcher(r0[12]);     // Catch: Exception -> L20
        if (r3.find() == false) goto L19;
        return Long.parseLong(r3.group());
    L19:
        return -1;
    }

    public static boolean isProcStatCanRead() {
        int r0 = isSysProcCanRead;
        if (r0 != 0) goto L12;
        File r1 = new File(PROC_STAT_FILE);
        if (r1.exists() == true) goto L7;
    L10:
        isSysProcCanRead = 2;
        return false;
    L7:
        if (r1.canRead() == false) goto L10;
        isSysProcCanRead = 1;
        return true;
    L12:
        if (r0 == 1) goto L14;
        return false;
    L14:
        return true;
    }
}
