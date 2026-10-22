package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.Stack;
import com.obric.aikernel.request.track.ApiPerfDetails;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppExitInfo {
    private String mDescription;
    private int mImportance;
    private int mPid;
    private String mProcessName;
    private String mPss;
    private long mRealPss;
    private long mRealRss;
    private String mReason;
    private String mRss;
    private int mStatus;
    private String mSubReason;
    private long mTimestamp;

    public AppExitInfo() {
    }

    public static void append(JSONObject r10, String r11, String r12) {
        JSONObject r13 = r10.optJSONObject("filters");     // Catch: Throwable -> L8
        if (r13 != null) goto L6;
        r13 = new JSONObject();     // Catch: Throwable -> L8
        r10.put("filters", r13);     // Catch: Throwable -> L8
    L6:
        r13.put(r11, r12);     // Catch: Throwable -> L8
        return;
    }

    private void appendCustomData(JSONObject r10, Map<String, String> r11) {
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L12
        if (r11 == null) goto L9;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r13.hasNext() == false) goto L9;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Throwable -> L12
        r12.put(r14.getKey(), r14.getValue());     // Catch: Throwable -> L12
    L9:
        if (JSONUtils.isEmpty(r12) == true) goto L16;
        r10.put("custom", r12);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    }

    public static AppExitInfo get(ApplicationExitInfo r10) {
        AppExitInfo r11 = new AppExitInfo();
        r11.mProcessName = r10.getProcessName();
        r11.mTimestamp = r10.getTimestamp();
        r11.mPid = r10.getPid();
        r11.mImportance = r10.getImportance();
        r11.mReason = AppExitInfoUtils.reasonCodeToString(r10.getReason());
        r11.mStatus = r10.getStatus();
        r11.mRealPss = r10.getPss();
        r11.mRealRss = r10.getRss();
        r11.mPss = (r10.getPss() / 1024) + "M";
        r11.mRss = (r10.getRss() / 1024) + "M";
        r11.mDescription = r10.getDescription();
        r11.mSubReason = AppExitInfoUtils.subreasonToString(((Integer) JavaCalls.callMethod(r10, "getSubReason", new Object[0])).intValue());     // Catch: Throwable -> L5
    L6:
        return r11;
    L5:
        r11.mSubReason = "UNKNOWN";
        goto L6
    }

    public void appendFilters(JSONObject r10, Map<String, String> r11) {
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L12
        if (r11 == null) goto L9;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r13.hasNext() == false) goto L9;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Throwable -> L12
        r12.put(r14.getKey(), r14.getValue());     // Catch: Throwable -> L12
    L9:
        if (JSONUtils.isEmpty(r12) == true) goto L16;
        r10.put("filters", r12);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public String getNativeStack(long r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(this.mReason);
        r11.append("\n");
        r11.append("pid:");
        r11.append(this.mPid);
        r11.append(" process:");
        r11.append(this.mProcessName);
        r11.append(" alive_time:");
        r11.append(this.mTimestamp - r10);
        r11.append(" last_alive_time:");
        r11.append(this.mTimestamp - r10);
        r11.append("\n");
        r11.append("#exitInfo\n");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r11.append(new SimpleDateFormat().format(new Date(this.mTimestamp)));
        r11.append("\n");
    L5:
        r11.append("importance=");
        r11.append(this.mImportance);
        r11.append("\n");
        r11.append("sub_reason=");
        r11.append(this.mSubReason);
        r11.append("\n");
        r11.append("status=");
        r11.append(this.mStatus);
        r11.append("\n");
        r11.append("description=");
        r11.append(this.mDescription);
        r11.append("\n");
        r11.append("pss=");
        r11.append(this.mPss);
        r11.append("\n");
        r11.append("reason=");
        r11.append(this.mReason);
        r11.append("\n");
        r11.append("process=");
        r11.append(this.mProcessName);
        r11.append("\n");
        r11.append("rss=");
        r11.append(this.mRss);
        r11.append("\n");
        return r11.toString();
    }

    public int getPid() {
        return this.mPid;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getPss() {
        return this.mPss;
    }

    public long getRealPss() {
        return this.mRealPss;
    }

    public long getRealRss() {
        return this.mRealRss;
    }

    public String getReason() {
        return this.mReason;
    }

    public String getRss() {
        return this.mRss;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getSubReason() {
        return this.mSubReason;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public JSONObject toJson(long r10, String r12) {
        HashMap r11 = new HashMap();
        r11.put("exit_status", String.valueOf(getStatus()));
        r11.put("exit_pss", AppExitInfoUtils.memValueToRange(getRealPss()));
        r11.put("exit_rss", AppExitInfoUtils.memValueToRange(getRealRss()));
        r11.put("has_exit_info", "true");
        r11.put(Constants.EXIT_REASON, getReason());
        r11.put("exit_sub_reason", getSubReason());
        HashMap r13 = new HashMap(r11);
        JSONObject r14 = new JSONObject();
        r14.put(Constants.EVENT_TYPE, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Throwable -> L5
        r14.put("crash_time", this.mTimestamp);     // Catch: Throwable -> L5
        r14.put("log_type", "PROCESS_DIED");     // Catch: Throwable -> L5
        r14.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L5
        r14.put("message", "PROCESS_DIED");     // Catch: Throwable -> L5
        r14.put(CrashBody.CRASH_THREAD_NAME, "UNKNOW");     // Catch: Throwable -> L5
        r14.put("crash_md5", Digest.getMD5(r12));     // Catch: Throwable -> L5
        r14.put("process_name", getProcessName());     // Catch: Throwable -> L5
        r14.put("app_start_time", r10);     // Catch: Throwable -> L5
        r14.put(ApiPerfDetails.exceptionType, 1);     // Catch: Throwable -> L5
        r14.put("pid", this.mPid);     // Catch: Throwable -> L5
        r14.put(EnsureReportData.CLASS_REF, "Native");     // Catch: Throwable -> L5
        r14.put(EnsureReportData.METHOD, "Native");     // Catch: Throwable -> L5
        r14.put("is_core", 1);     // Catch: Throwable -> L5
        r14.put(EnsureReportData.LINE_NUM, -1);     // Catch: Throwable -> L5
        r14.put(EnsureReportData.ENSURE_TYPE, EnsureDeliverer.ENSURE_NOT_REACH_HERE);     // Catch: Throwable -> L5
        r14.put("stack", r12);     // Catch: Throwable -> L5
        r14.put(Constants.HAS_DUMP, "true");     // Catch: Throwable -> L5
        r14.put("java_data", Stack.DIED_PROCESS_STACK);     // Catch: Throwable -> L5
        appendCustomData(r14, r11);     // Catch: Throwable -> L5
        appendFilters(r14, r13);     // Catch: Throwable -> L5
    L4:
        return r14;
    }

    public String toString() {
        return "AppExitInfo{mProcessName='" + this.mProcessName + "', mTimestamp=" + this.mTimestamp + ", mPid=" + this.mPid + ", mReason='" + this.mReason + "', mStatus=" + this.mStatus + ", mImportance=" + this.mImportance + ", mPss='" + this.mPss + "', mRss='" + this.mRss + "', mDescription='" + this.mDescription + "', mRealPss=" + this.mRealPss + ", mRealRss=" + this.mRealRss + ", subReason='" + this.mSubReason + "'}";
    }
}
