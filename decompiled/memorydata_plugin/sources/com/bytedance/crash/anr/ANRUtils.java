package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ANRUtils {
    public static final int ANR_CHECK_MAX_COUNT = 100;
    private static String sAnrInfoFromFile = null;
    private static long sLastAnrInfoTime = -1;
    private static ActivityManager.ProcessErrorStateInfo sLastErrInfo;

    static {
    }

    public ANRUtils() {
    }

    public static String getNewCurrentProcessANRInfo(Context r2, int r3) {
        return getNewCurrentProcessANRInfo((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, null);
    }

    public static String getNewCurrentProcessANRInfo(Context r4, int r5, int[] r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if ((SystemClock.uptimeMillis() - sLastAnrInfoTime) >= 5000) goto L33;
        System.out.println("get_anr_info_is_time_out");
        return null;
    L33:
        ActivityManager.ProcessErrorStateInfo r8 = getProcessErrorStateInfo(r7, r5);     // Catch: Throwable -> L32
        if (r8 == null) goto L25;
        if (Process.myPid() == r8.pid) goto L14;
        if (r6 == null) goto L25;
        if (r8.processName.contains(r7.getPackageName()) == false) goto L25;
    L14:
        ActivityManager.ProcessErrorStateInfo r9 = sLastErrInfo;     // Catch: Throwable -> L32
        if (r9 != null) goto L17;
    L20:
        sLastErrInfo = r8;     // Catch: Throwable -> L32
        sAnrInfoFromFile = null;     // Catch: Throwable -> L32
        sLastAnrInfoTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L32
        if (r6 == null) goto L24;
        r6[0] = r8.pid;     // Catch: Throwable -> L32
    L24:
        return AnrInfoParser.format(r8);
    L17:
        if (AnrInfoParser.isSameProcessErrorStateInfo(r9, r8) == false) goto L20;
        sLastAnrInfoTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L32
        return null;
    L25:
        String r10 = sAnrInfoFromFile;
        if (r10 == null) goto L31;
        if (r6 == null) goto L29;
        r6[0] = Process.myPid();
    L29:
        sAnrInfoFromFile = null;
        sLastAnrInfoTime = SystemClock.uptimeMillis();
        return r10;
    L31:
        return null;
    }

    private static ActivityManager.ProcessErrorStateInfo getProcessErrorStateInfo(Context r7, int r8) {
        ActivityManager r9 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return null;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r8) goto L20;
        List<ActivityManager.ProcessErrorStateInfo> r3 = r9.getProcessesInErrorState();
        if (r3 == null) goto L16;
        Iterator<ActivityManager.ProcessErrorStateInfo> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L16;
        ActivityManager.ProcessErrorStateInfo r5 = (ActivityManager.ProcessErrorStateInfo) ZeusTransformUtils.preCheckCast(r4.next(), ActivityManager.ProcessErrorStateInfo.class, "com.obric.memorydata.plugin");
        if (r5.condition != 2) goto L11;
        return r5;
    L16:
        r2 = r2 + 1;
        if (r8 == r2) goto L20;
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
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        int r3 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r4 = r0.getRunningAppProcesses();
        if (r4 == null) goto L15;
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r6 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r5.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        if (r6.pid != r3) goto L9;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        return false;
    L18:
        List<ActivityManager.ProcessErrorStateInfo> r1 = r0.getProcessesInErrorState();
        if (r1 == null) goto L30;
        Iterator<ActivityManager.ProcessErrorStateInfo> r2 = r1.iterator();
    L22:
        if (r2.hasNext() == false) goto L30;
        ActivityManager.ProcessErrorStateInfo r8 = (ActivityManager.ProcessErrorStateInfo) ZeusTransformUtils.preCheckCast(r2.next(), ActivityManager.ProcessErrorStateInfo.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L22;
        if (r8.pid != r3) goto L22;
        if (r8.condition != 1) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L33;
        return false;
    L33:
        return true;
    L30:
        r9 = false;
    L15:
        r7 = false;
        goto L16
    }

    private static boolean isANRProcess34() {
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L12;
        r1 = r1 + 1;
        if (isANRProcess() == true) goto L8;
        Thread.sleep(20);     // Catch: Throwable -> L13
        goto L4
    L8:
        return true;
    L12:
        return false;
    }

    static void reportInnerError(Throwable r1) {
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR", r1);
    }
}
