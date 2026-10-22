package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.text.TextUtils;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnrHistoryProcessExitParser {
    public AnrHistoryProcessExitParser() {
    }

    public static void parseProcessExitReason(JSONObject r14) {
        List<ApplicationExitInfo> r0 = AppExitInfoUtils.getProcessExitReasons();     // Catch: Throwable -> L28
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = r14.optJSONObject("custom");     // Catch: Throwable -> L28
        long r2 = r14.optLong("crash_time");     // Catch: Throwable -> L28
        int r4 = r14.optInt(CrashBody.PID);     // Catch: Throwable -> L28
        String r5 = r14.optString("process_name");     // Catch: Throwable -> L28
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L28
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L28
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L28
        Iterator<ApplicationExitInfo> r3 = r0.iterator();     // Catch: Throwable -> L28
    L7:
        if (r3.hasNext() == false) goto L22;
        ApplicationExitInfo r9 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r3.next(), ApplicationExitInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r9.getProcessName().equals(r5) == false) goto L7;
        if (r4 != r9.getPid()) goto L7;
        long r10 = r9.getTimestamp() - r2;     // Catch: Throwable -> L28
        if (r10 <= 0) goto L7;
        if (r10 > 30000) goto L7;
        if (r9.getReason() != 6) goto L20;
        r8.append(r9.getDescription() + ",");     // Catch: Throwable -> L28
    L20:
        r6.append(r9.getReason() + ",");     // Catch: Throwable -> L28
        r7.append("timestamp=" + r9.getTimestamp());     // Catch: Throwable -> L28
        r7.append(" crash_pid=" + r4);     // Catch: Throwable -> L28
        r7.append(" crash_time=" + r2 + " \n");     // Catch: Throwable -> L28
        r7.append(r9);     // Catch: Throwable -> L28
        r7.append("\n");     // Catch: Throwable -> L28
        goto L7
    L22:
        if (r7.length() <= 0) goto L24;
        r1.put("history_exit_process_list", r7);     // Catch: Throwable -> L28
    L24:
        r14.put(Constants.EXIT_REASON, r6);     // Catch: Throwable -> L28
        if (r8.length() <= 0) goto L42;
        r14.put(Constants.PROCESS_EXIT_ANR_REASON, r8);     // Catch: Throwable -> L28
        return;
    L42:
        return;
    }

    public static void pushToFilters(JSONObject r4, JSONObject r5) {
        String r2 = r4.optString(Constants.EXIT_REASON);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r5.put(Constants.EXIT_REASON, r2);     // Catch: Throwable -> L10
    L6:
        String r6 = r4.optString(Constants.PROCESS_EXIT_ANR_REASON);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r5.put(Constants.PROCESS_EXIT_ANR_REASON, r6);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }
}
