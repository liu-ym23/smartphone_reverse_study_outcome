package com.ss.android.lark.gadget.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import java.util.Iterator;
import java.util.List;
import njb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MiniAppProcessUtils {
    private static final String TAG = "MiniAppProcessUtils";

    public MiniAppProcessUtils() {
    }

    public static boolean checkMiniAppProcessExistInMainProcess(Context r8) {
        b r1 = b.a.a;
        if (r1.c == false) goto L5;
        return false;
    L5:
        r1.c = true;
        long r4 = System.currentTimeMillis();
        Iterator<ActivityManager.RunningAppProcessInfo> r9 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L12
    L8:
        if (r9.hasNext() == false) goto L14;
        if (r9.next().processName.contains(":miniapp") == false) goto L8;
        boolean r10 = true;
    L15:
        AppBrandLogger.i(TAG, new Object[]{"checkMiniAppProcessExistInMainProcess hasMiniAppProcessExist:", Boolean.valueOf(r10), "duration:", Long.valueOf(System.currentTimeMillis() - r4)});
        return r10;
    L14:
        r10 = false;
    L12:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
        goto L14
    }

    public static String getCurProcessName(Context r4) {
        b r0 = b.a.a;
        String r1 = r0.b;     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return r1;
    L6:
        int r2 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) r4.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L8:
        if (r5.hasNext() == false) goto L21;
        ActivityManager.RunningAppProcessInfo r3 = r5.next();     // Catch: Exception -> L15
        if (r3.pid != r2) goto L8;
        String r6 = r3.processName;     // Catch: Exception -> L15
        r0.b = r6;     // Catch: Exception -> L15
        return r6;
    L21:
        return "";
    L13:
        return "";
    }

    public static boolean isMainProcess(Context r3) {
        String r0 = getCurProcessName(r3);
        if (r0 != null) goto L5;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r0 != null) goto L11;
        return false;
    L11:
        if (r0.equals(r3.getPackageName()) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isMicroAppActivity(Activity r2) {
        String r3 = r2.getClass().getCanonicalName();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.substring(r3.lastIndexOf(".") + 1).matches("MiniappTabActivity\\d") == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isMiniAppProcess(String r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.contains(":miniapp") == false) goto L8;
    L9:
        return true;
    L8:
        if (r2.contains(":oryx") == true) goto L9;
        return false;
    }

    public static boolean isOryxProcess(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.contains(":oryx");
    }

    public static void killCurrentAppTask(Context r10) {
        String r3 = getCurProcessName(r10);     // Catch: Exception -> L24
        ActivityManager r11 = (ActivityManager) r10.getSystemService("activity");     // Catch: Exception -> L24
        if (r11 == null) goto L37;
        List<ActivityManager.AppTask> r12 = r11.getAppTasks();     // Catch: Exception -> L24
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.size() <= 0) goto L39;
        Iterator<ActivityManager.AppTask> r13 = r12.iterator();     // Catch: Exception -> L24
    L10:
        if (r13.hasNext() == false) goto L40;
        ActivityManager.AppTask r4 = r13.next();     // Catch: Exception -> L24
        ComponentName r5 = r4.getTaskInfo().baseIntent.getComponent();     // Catch: Exception -> L24
        if (r5 == null) goto L10;
        int r6 = r3.indexOf(":");     // Catch: Exception -> L24
        if (r6 < 0) goto L17;
        String r7 = r3.substring(r6 + 1).replace("miniapp", "");     // Catch: Exception -> L24
    L18:
        String r8 = r5.getClassName();     // Catch: Exception -> L24
        AppBrandLogger.i(TAG, new Object[]{"killCurrentAppTask processName", r3, "miniAppProcessIndex", r7, "componentClassName", r8});     // Catch: Exception -> L24
        if (r8.endsWith("MiniappTabActivity" + r7) == true) goto L22;
        if (r8.endsWith("MiniappTabHostStackActivity" + r7) == false) goto L10;
    L22:
        AppBrandLogger.i(TAG, new Object[]{"finishAndRemoveMiniAppTask"});     // Catch: Exception -> L24
        r4.finishAndRemoveTask();     // Catch: Exception -> L24
        goto L10
    L17:
        r7 = null;
        goto L18
    L40:
        return;
    L39:
        return;
    L37:
        return;
    L24:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
    }

    public static void killCurrentProcess(Context r5) {
        if (isMiniAppProcess(r5) == true) goto L11;
        return;
    L11:
        Thread.sleep(200);     // Catch: InterruptedException -> L7
    L9:
        killCurrentAppTask(r5);
        AppBrandLogger.i(TAG, new Object[]{"kill mini app process"});
        Process.killProcess(Process.myPid());
        System.exit(0);
        return;
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
        goto L9
    }

    public static boolean isMiniAppProcess(Context r0) {
        return isMiniAppProcess(getCurProcessName(r0));
    }
}
