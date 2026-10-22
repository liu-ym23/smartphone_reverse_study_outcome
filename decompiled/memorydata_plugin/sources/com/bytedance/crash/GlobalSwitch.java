package com.bytedance.crash;

import android.os.Build;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;

/* JADX INFO: loaded from: classes2.dex */
public final class GlobalSwitch {
    private static boolean sIsAllowBlockStack = false;
    private static boolean sIsAnrMonitorOpt = false;
    private static boolean sIsFilterOtherAnr = false;
    private static boolean sIsLooperMonitor = false;
    private static boolean sIsOpenNewAnrMonitor;

    static {
    }

    public GlobalSwitch() {
    }

    public static boolean isAllowBlockStack() {
        return sIsAllowBlockStack;
    }

    public static boolean isAnrMonitorOpt() {
        return sIsAnrMonitorOpt;
    }

    public static boolean isFilterNotAnr() {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        return false;
    L5:
        if (sIsFilterOtherAnr == false) goto L7;
        return true;
    }

    public static boolean isOpenLooperMonitor() {
        return sIsLooperMonitor;
    }

    public static boolean isOpenNewAnrMonitor() {
        return sIsOpenNewAnrMonitor;
    }

    public static void setANRImprovementOpt(boolean r0) {
        sIsFilterOtherAnr = r0;
    }

    public static void setAllowBlockStack(boolean r0) {
        sIsAllowBlockStack = r0;
    }

    public static void setAnrMonitorOpt(boolean r0) {
        sIsAnrMonitorOpt = r0;
    }

    public static void setOpenLooperMonitor(boolean r0) {
        if (r0 == true) goto L4;
        return;
    L4:
        sIsLooperMonitor = true;
        if (MonitorManager.getAppMonitor() == null) goto L8;
        DefaultWorkThread.post(new AnonymousClass1());
        return;
    }

    public static void setOpenNewAnrMonitor(boolean r0) {
        sIsOpenNewAnrMonitor = r0;
    }
}
