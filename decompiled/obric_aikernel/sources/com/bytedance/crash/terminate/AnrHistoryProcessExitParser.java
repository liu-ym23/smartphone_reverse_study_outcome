package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.bytedance.crash.constants.Constants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AnrHistoryProcessExitParser {
    public AnrHistoryProcessExitParser() {
    }

    public static void parseProcessExitReason(JSONObject r14) {
        List<ApplicationExitInfo> r10 = AppExitInfoUtils.getProcessExitReasons();     // Catch: Throwable -> L28
        if (r10 != null) goto L5;
        return;
    L5:
        JSONObject r11 = r14.optJSONObject("custom");     // Catch: Throwable -> L28
        long r12 = r14.optLong("crash_time");     // Catch: Throwable -> L28
        int r13 = r14.optInt("pid");     // Catch: Throwable -> L28
        String r15 = r14.optString("process_name");     // Catch: Throwable -> L28
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L28
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L28
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L28
        Iterator<ApplicationExitInfo> r19 = r10.iterator();     // Catch: Throwable -> L28
    L7:
        if (r19.hasNext() == false) goto L22;
        ApplicationExitInfo r20 = r19.next();     // Catch: Throwable -> L28
        if (r20.getProcessName().equals(r15) == false) goto L7;
        if (r13 != r20.getPid()) goto L7;
        long r110 = r20.getTimestamp() - r12;     // Catch: Throwable -> L28
        if (r110 <= 0) goto L7;
        if (r110 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) goto L7;
        if (r20.getReason() != 6) goto L20;
        r18.append(r20.getDescription() + ",");     // Catch: Throwable -> L28
    L20:
        r16.append(r20.getReason() + ",");     // Catch: Throwable -> L28
        r17.append("timestamp=" + r20.getTimestamp());     // Catch: Throwable -> L28
        r17.append(" crash_pid=" + r13);     // Catch: Throwable -> L28
        r17.append(" crash_time=" + r12 + " \n");     // Catch: Throwable -> L28
        r17.append(r20);     // Catch: Throwable -> L28
        r17.append("\n");     // Catch: Throwable -> L28
        goto L7
    L22:
        if (r17.length() <= 0) goto L24;
        r11.put("history_exit_process_list", r17);     // Catch: Throwable -> L28
    L24:
        r14.put(Constants.EXIT_REASON, r16);     // Catch: Throwable -> L28
        if (r18.length() <= 0) goto L42;
        r14.put(Constants.PROCESS_EXIT_ANR_REASON, r18);     // Catch: Throwable -> L28
        return;
    L42:
        return;
    }

    public static void pushToFilters(@NonNull JSONObject r10, @NonNull JSONObject r11) {
        String r12 = r10.optString(Constants.EXIT_REASON);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r12) == true) goto L6;
        r11.put(Constants.EXIT_REASON, r12);     // Catch: Throwable -> L10
    L6:
        String r13 = r10.optString(Constants.PROCESS_EXIT_ANR_REASON);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r13) == true) goto L13;
        r11.put(Constants.PROCESS_EXIT_ANR_REASON, r13);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }
}
