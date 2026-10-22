package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtils {
    public static final String MESSAGE_PROCESS_SERVICE_SUFFIX = ":pushservice";
    public static final String MESSAGE_PROCESS_SUFFIX = ":push";
    private static String sCurProcessName;

    public ProcessUtils() {
    }

    public static String getCurProcessName(Context r8) {
        String r10 = sCurProcessName;
        if (TextUtils.isEmpty(r10) == true) goto L19;
        return r10;
    L19:
        int r11 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r12.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();     // Catch: Exception -> L15
        if (r13.pid != r11) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r13.processName);     // Catch: Exception -> L15
    L13:
        String r14 = r13.processName;     // Catch: Exception -> L15
        sCurProcessName = r14;     // Catch: Exception -> L15
        return r14;
    L17:
        String r15 = getCurProcessNameFromProc();
        sCurProcessName = r15;
        return r15;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r8 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r11 = r8.read();     // Catch: Throwable -> L19
        if (r11 <= 0) goto L9;
        r10.append((char) r11);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r10.toString());     // Catch: Throwable -> L19
    L11:
        String r12 = r10.toString();     // Catch: Throwable -> L19
        r8.close();     // Catch: Exception -> L18
    L13:
        return r12;
    L15:
        if (r8 != null) goto L27;
    L17:
        return null;
    L27:
        r8.close();     // Catch: Exception -> L20
    L14:
        r8 = null;
        goto L15
    }

    public static boolean isMainProcess(Context r8) {
        String r10 = getCurProcessName(r8);
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r10.equals(r8.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r10.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L7;
        return false;
    }

    public static boolean isMessageProcess(Context r8) {
        String r10 = getCurProcessName(r8);
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.endsWith(MESSAGE_PROCESS_SUFFIX) == false) goto L7;
        return true;
    L7:
        if (r10.endsWith(MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L13;
        return true;
    L13:
        return false;
    }
}
