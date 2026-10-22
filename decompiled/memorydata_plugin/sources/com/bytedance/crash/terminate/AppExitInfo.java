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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void append(JSONObject r2, String r3, String r4) {
        JSONObject r1 = r2.optJSONObject("filters");     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        r1 = new JSONObject();     // Catch: Throwable -> L8
        r2.put("filters", r1);     // Catch: Throwable -> L8
    L6:
        r1.put(r3, r4);     // Catch: Throwable -> L8
        return;
    }

    private void appendCustomData(JSONObject r5, Map<String, String> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        Iterator r8 = r4.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r7.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r1.getValue());     // Catch: Throwable -> L13
    L10:
        if (JSONUtils.isEmpty(r7) == true) goto L17;
        r5.put("custom", r7);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    }

    public static AppExitInfo get(ApplicationExitInfo r8) {
        AppExitInfo r0 = new AppExitInfo();
        r0.mProcessName = r8.getProcessName();
        r0.mTimestamp = r8.getTimestamp();
        r0.mPid = r8.getPid();
        r0.mImportance = r8.getImportance();
        r0.mReason = AppExitInfoUtils.reasonCodeToString(r8.getReason());
        r0.mStatus = r8.getStatus();
        r0.mRealPss = r8.getPss();
        r0.mRealRss = r8.getRss();
        r0.mPss = (r8.getPss() / 1024) + "M";
        r0.mRss = (r8.getRss() / 1024) + "M";
        r0.mDescription = r8.getDescription();
        r0.mSubReason = AppExitInfoUtils.subreasonToString(((Integer) ZeusTransformUtils.preCheckCast(JavaCalls.callMethod(r8, "getSubReason", new Object[0]), Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L5
    L6:
        return r0;
    L5:
        r0.mSubReason = "UNKNOWN";
        goto L6
    }

    public void appendFilters(JSONObject r5, Map<String, String> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        Iterator r8 = r4.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r7.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r1.getValue());     // Catch: Throwable -> L13
    L10:
        if (JSONUtils.isEmpty(r7) == true) goto L17;
        r5.put("filters", r7);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public String getNativeStack(long r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.mReason);
        r0.append("\n");
        r0.append("pid:");
        r0.append(this.mPid);
        r0.append(" process:");
        r0.append(this.mProcessName);
        r0.append(" alive_time:");
        r0.append(this.mTimestamp - r5);
        r0.append(" last_alive_time:");
        r0.append(this.mTimestamp - r5);
        r0.append("\n");
        r0.append("#exitInfo\n");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r0.append(new SimpleDateFormat().format(new Date(this.mTimestamp))).append("\n");
    L5:
        r0.append("importance=").append(this.mImportance).append("\n");
        r0.append("sub_reason=").append(this.mSubReason).append("\n");
        r0.append("status=").append(this.mStatus).append("\n");
        r0.append("description=").append(this.mDescription).append("\n");
        r0.append("pss=").append(this.mPss).append("\n");
        r0.append("reason=").append(this.mReason).append("\n");
        r0.append("process=").append(this.mProcessName).append("\n");
        r0.append("rss=").append(this.mRss).append("\n");
        return r0.toString();
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
        HashMap r2 = new HashMap();
        r2.put("exit_status", String.valueOf(getStatus()));
        r2.put("exit_pss", AppExitInfoUtils.memValueToRange(getRealPss()));
        r2.put("exit_rss", AppExitInfoUtils.memValueToRange(getRealRss()));
        r2.put("has_exit_info", "true");
        r2.put(Constants.EXIT_REASON, getReason());
        r2.put("exit_sub_reason", getSubReason());
        HashMap r3 = new HashMap(r2);
        JSONObject r5 = new JSONObject();
        r5.put(Constants.EVENT_TYPE, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Throwable -> L5
        r5.put("crash_time", this.mTimestamp);     // Catch: Throwable -> L5
        r5.put("log_type", "PROCESS_DIED");     // Catch: Throwable -> L5
        r5.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L5
        r5.put("message", "PROCESS_DIED");     // Catch: Throwable -> L5
        r5.put(CrashBody.CRASH_THREAD_NAME, "UNKNOW");     // Catch: Throwable -> L5
        r5.put("crash_md5", Digest.getMD5(r12));     // Catch: Throwable -> L5
        r5.put("process_name", getProcessName());     // Catch: Throwable -> L5
        r5.put("app_start_time", r10);     // Catch: Throwable -> L5
        r5.put(ApiPerfDetails.exceptionType, 1);     // Catch: Throwable -> L5
        r5.put(CrashBody.PID, this.mPid);     // Catch: Throwable -> L5
        r5.put(EnsureReportData.CLASS_REF, "Native");     // Catch: Throwable -> L5
        r5.put("method", "Native");     // Catch: Throwable -> L5
        r5.put("is_core", 1);     // Catch: Throwable -> L5
        r5.put(EnsureReportData.LINE_NUM, -1);     // Catch: Throwable -> L5
        r5.put(EnsureReportData.ENSURE_TYPE, EnsureDeliverer.ENSURE_NOT_REACH_HERE);     // Catch: Throwable -> L5
        r5.put("stack", r12);     // Catch: Throwable -> L5
        r5.put(Constants.HAS_DUMP, "true");     // Catch: Throwable -> L5
        r5.put("java_data", Stack.DIED_PROCESS_STACK);     // Catch: Throwable -> L5
        appendCustomData(r5, r2);     // Catch: Throwable -> L5
        appendFilters(r5, r3);     // Catch: Throwable -> L5
    L4:
        return r5;
    }

    public String toString() {
        return "AppExitInfo{mProcessName='" + this.mProcessName + "', mTimestamp=" + this.mTimestamp + ", mPid=" + this.mPid + ", mReason='" + this.mReason + "', mStatus=" + this.mStatus + ", mImportance=" + this.mImportance + ", mPss='" + this.mPss + "', mRss='" + this.mRss + "', mDescription='" + this.mDescription + "', mRealPss=" + this.mRealPss + ", mRealRss=" + this.mRealRss + ", subReason='" + this.mSubReason + "'}";
    }
}
