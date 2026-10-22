package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.diagnose.NpthMonitor;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ANRUtils {
    public static final int ANR_CHECK_MAX_COUNT = 100;
    private static String sAnrInfoFromFile = null;
    private static long sLastAnrInfoTime = -1;
    private static ActivityManager.ProcessErrorStateInfo sLastErrInfo;

    static {
    }

    public ANRUtils() {
    }

    public static String getNewCurrentProcessANRInfo(Context r10, int r11) {
        return getNewCurrentProcessANRInfo(r10, r11, null);
    }

    public static String getNewCurrentProcessANRInfo(Context r10, int r11, int[] r12) {
        if ((SystemClock.uptimeMillis() - sLastAnrInfoTime) >= 5000) goto L33;
        System.out.println("get_anr_info_is_time_out");
        return null;
    L33:
        ActivityManager.ProcessErrorStateInfo r13 = getProcessErrorStateInfo(r10, r11);     // Catch: Throwable -> L32
        if (r13 == null) goto L25;
        if (Process.myPid() == r13.pid) goto L14;
        if (r12 == null) goto L25;
        if (r13.processName.contains(r10.getPackageName()) == false) goto L25;
    L14:
        ActivityManager.ProcessErrorStateInfo r14 = sLastErrInfo;     // Catch: Throwable -> L32
        if (r14 != null) goto L17;
    L20:
        sLastErrInfo = r13;     // Catch: Throwable -> L32
        sAnrInfoFromFile = null;     // Catch: Throwable -> L32
        sLastAnrInfoTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L32
        if (r12 == null) goto L24;
        r12[0] = r13.pid;     // Catch: Throwable -> L32
    L24:
        return AnrInfoParser.format(r13);
    L17:
        if (AnrInfoParser.isSameProcessErrorStateInfo(r14, r13) == false) goto L20;
        sLastAnrInfoTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L32
        return null;
    L25:
        String r15 = sAnrInfoFromFile;
        if (r15 == null) goto L31;
        if (r12 == null) goto L29;
        r12[0] = Process.myPid();
    L29:
        sAnrInfoFromFile = null;
        sLastAnrInfoTime = SystemClock.uptimeMillis();
        return r15;
    L31:
        return null;
    }

    private static ActivityManager.ProcessErrorStateInfo getProcessErrorStateInfo(Context r10, int r11) {
        ActivityManager r12 = (ActivityManager) r10.getSystemService("activity");
        if (r12 != null) goto L5;
        return null;
    L5:
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L20;
        List<ActivityManager.ProcessErrorStateInfo> r14 = r12.getProcessesInErrorState();
        if (r14 == null) goto L16;
        Iterator<ActivityManager.ProcessErrorStateInfo> r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L16;
        ActivityManager.ProcessErrorStateInfo r16 = r15.next();
        if (r16.condition != 2) goto L11;
        return r16;
    L16:
        r13 = r13 + 1;
        if (r11 == r13) goto L20;
        SystemClock.sleep(600);
    L20:
        System.out.println("get_anr_info_times_out");
        return null;
    }

    public static boolean isANR() {
        if (Build.VERSION.SDK_INT < 34) goto L9;
        if (GlobalSwitch.isAnrMonitorOpt() == false) goto L9;
        return isANRProcess34();
    L9:
        return isANRProcess();
    }

    private static boolean isANRProcess() {
        ActivityManager r10 = (ActivityManager) Global.getApplication().getSystemService("activity");
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r12 = r10.getRunningAppProcesses();
        if (r12 == null) goto L15;
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();
        if (r14 == null) goto L9;
        if (r14.pid != r11) goto L9;
        boolean r15 = true;
    L16:
        if (r15 == false) goto L18;
        return false;
    L18:
        List<ActivityManager.ProcessErrorStateInfo> r16 = r10.getProcessesInErrorState();
        if (r16 == null) goto L30;
        Iterator<ActivityManager.ProcessErrorStateInfo> r17 = r16.iterator();
    L22:
        if (r17.hasNext() == false) goto L30;
        ActivityManager.ProcessErrorStateInfo r18 = r17.next();
        if (r18 == null) goto L22;
        if (r18.pid != r11) goto L22;
        if (r18.condition != 1) goto L30;
        boolean r19 = true;
    L31:
        if (r19 == false) goto L33;
        return false;
    L33:
        return true;
    L30:
        r19 = false;
    L15:
        r15 = false;
        goto L16
    }

    private static boolean isANRProcess34() {
        int r10 = 0;
    L4:
        if (r10 >= 100) goto L12;
        r10 = r10 + 1;
        if (isANRProcess() == true) goto L8;
        Thread.sleep(20);     // Catch: Throwable -> L13
        goto L4
    L8:
        return true;
    L12:
        return false;
    }

    static void reportInnerError(Throwable r10) {
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR", r10);
    }
}
