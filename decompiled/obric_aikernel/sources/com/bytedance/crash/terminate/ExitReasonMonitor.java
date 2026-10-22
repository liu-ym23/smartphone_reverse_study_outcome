package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import c4.d;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.services.apm.api.IApmAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ExitReasonMonitor {
    static final int REASON_LIMIT_FILE_SIZE = 50;
    private static List<ApplicationExitInfo> infos = null;
    private static boolean mExitReasonParsed = false;

    static {
        infos = new ArrayList();
    }

    public ExitReasonMonitor() {
    }

    static void clearExitInfo() {
        File r10 = new File(TerminateMonitor.mTerminateHistoryDirectory, TerminateMonitor.EXIT_INFO_PATH);
        if (r10.exists() == true) goto L5;
        return;
    L5:
        String[] r11 = r10.list();
        if (r11 != null) goto L8;
        return;
    L8:
        int r12 = 50;
        if (r11.length <= 50) goto L14;
        Arrays.sort(r11);
    L12:
        if (r12 >= r11.length) goto L16;
        FileUtils.deleteFile(new File(r10, r11[r12]));
        r12 = r12 + 1;
        goto L12
    L16:
        return;
    }

    private static long getLastExitReasonTime() {
        File r10 = new File(TerminateMonitor.mTerminateHistoryDirectory, "lastReasonTime");
        if (r10.exists() == true) goto L8;
    L6:
        return -1;
    L8:
        return TerminateMonitor.decodeWithCatch(FileUtils.readFile(r10), -1);
    }

    static List<ApplicationExitInfo> parseExitReason() {
        if (mExitReasonParsed == true) goto L5;
        mExitReasonParsed = true;
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L38;
        return null;
    L38:
        List<ApplicationExitInfo> r10 = AppExitInfoUtils.getProcessExitReasons();     // Catch: Throwable -> L28
        if (r10 != null) goto L13;
        clearExitInfo();
        return null;
    L13:
        long r11 = getLastExitReasonTime();     // Catch: Throwable -> L28
        Iterator<ApplicationExitInfo> r12 = r10.iterator();     // Catch: Throwable -> L28
    L15:
        if (r12.hasNext() == false) goto L21;
        ApplicationExitInfo r13 = r12.next();     // Catch: Throwable -> L28
        if (r13.getTimestamp() < r11) goto L21;
        infos.add(r13);     // Catch: Throwable -> L28
        TerminateMonitor.callExitReasonCallbacks(r13);     // Catch: Throwable -> L28
    L21:
        if (infos.size() != 0) goto L26;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L28
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L28
        IApmAgent r16 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Throwable -> L35
        if (r16 == null) goto L26;
        r14.put("reason", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L35
        r15.put(OaidModel.KEY_TIME, r11);     // Catch: Throwable -> L35
        r16.monitorEvent(AppExitInfoUtils.APP_EXIT, r14, null, null);     // Catch: Throwable -> L35
    L26:
        TerminateMonitor.callExitReasonCallback(infos);     // Catch: Throwable -> L28
        setExitReasonTime();     // Catch: Throwable -> L28
    L30:
        clearExitInfo();
        return infos;
    L28:
        th = move-exception;
        MonitorManager.getAppEnsureManager().reportThrowable(th);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        clearExitInfo();
        throw th;
    L5:
        return infos;
    }

    private static void setExitReasonTime() {
        File r10 = new File(TerminateMonitor.mTerminateHistoryDirectory, "lastReasonTime");
        FileUtils.writeFile(r10, String.valueOf(System.currentTimeMillis()), false);     // Catch: Throwable -> L5
        return;
    }
}
