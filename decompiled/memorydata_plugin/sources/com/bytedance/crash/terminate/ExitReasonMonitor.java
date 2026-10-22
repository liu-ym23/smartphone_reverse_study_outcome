package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
        File r0 = new File(TerminateMonitor.mTerminateHistoryDirectory, TerminateMonitor.EXIT_INFO_PATH);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        String[] r1 = r0.list();
        if (r1 != null) goto L8;
        return;
    L8:
        int r3 = 50;
        if (r1.length <= 50) goto L14;
        Arrays.sort(r1);
    L12:
        if (r3 >= r1.length) goto L16;
        FileUtils.deleteFile(new File(r0, r1[r3]));
        r3 = r3 + 1;
        goto L12
    L16:
        return;
    }

    private static long getLastExitReasonTime() {
        File r0 = new File(TerminateMonitor.mTerminateHistoryDirectory, "lastReasonTime");
        if (r0.exists() == true) goto L8;
    L6:
        return -1;
    L8:
        return TerminateMonitor.decodeWithCatch(FileUtils.readFile(r0), -1);
    }

    static List<ApplicationExitInfo> parseExitReason() {
        if (mExitReasonParsed == true) goto L5;
        mExitReasonParsed = true;
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L39;
        return null;
    L39:
        List<ApplicationExitInfo> r0 = AppExitInfoUtils.getProcessExitReasons();     // Catch: Throwable -> L29
        if (r0 != null) goto L13;
        clearExitInfo();
        return null;
    L13:
        long r2 = getLastExitReasonTime();     // Catch: Throwable -> L29
        Iterator<ApplicationExitInfo> r1 = r0.iterator();     // Catch: Throwable -> L29
    L16:
        if (r1.hasNext() == false) goto L22;
        ApplicationExitInfo r4 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r1.next(), ApplicationExitInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r4.getTimestamp() < r2) goto L22;
        infos.add(r4);     // Catch: Throwable -> L29
        TerminateMonitor.callExitReasonCallbacks(r4);     // Catch: Throwable -> L29
    L22:
        if (infos.size() != 0) goto L27;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L29
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L29
        IApmAgent r6 = (IApmAgent) ZeusTransformUtils.preCheckCast(d.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (r6 == null) goto L27;
        r3.put(InfoRequestQPSOptTraceLogger.REASON, "1");     // Catch: Throwable -> L36
        r5.put(OaidModel.KEY_TIME, r2);     // Catch: Throwable -> L36
        r6.monitorEvent(AppExitInfoUtils.APP_EXIT, r3, null, null);     // Catch: Throwable -> L36
    L27:
        TerminateMonitor.callExitReasonCallback(infos);     // Catch: Throwable -> L29
        setExitReasonTime();     // Catch: Throwable -> L29
    L31:
        clearExitInfo();
        return infos;
    L29:
        th = move-exception;
        MonitorManager.getAppEnsureManager().reportThrowable(th);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        clearExitInfo();
        throw th;
    L5:
        return infos;
    }

    private static void setExitReasonTime() {
        File r0 = new File(TerminateMonitor.mTerminateHistoryDirectory, "lastReasonTime");
        FileUtils.writeFile(r0, String.valueOf(System.currentTimeMillis()), false);     // Catch: Throwable -> L5
        return;
    }
}
