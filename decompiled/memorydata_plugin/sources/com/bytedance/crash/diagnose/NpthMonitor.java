package com.bytedance.crash.diagnose;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NpthMonitor {
    private static final String NPTH_AID = "2010";
    private static NpthMonitor sInstance;
    private final EventMonitor mEventMonitor;

    public static class Event {
        private final JSONObject mCategory;
        private JSONObject mMetric;
        private final String mServiceName;

        public Event(String r2) {
            this.mMetric = new JSONObject();
            this.mServiceName = r2;
            this.mCategory = new JSONObject();
        }

        public Event(String r2, JSONObject r3) {
            this.mMetric = new JSONObject();
            this.mServiceName = r2;
            if (r3 == null) goto L5;
            this.mCategory = r3;
            return;
        L5:
            this.mCategory = new JSONObject();
        }

        private void appendDefaultCategory() {
            AppMonitor r0 = MonitorManager.getAppMonitor();
            if (r0 == null) goto L6;
            HashMap r1 = new HashMap();
            r1.put("aid", r0.getAppId());
            r1.put("device_id", r0.getDeviceId("0"));
            r1.put("update_version_code", String.valueOf(r0.getUpdateVersionCode()));
            r1.put("version_code", String.valueOf(r0.getVersionCode()));
            r1.put("app_version", String.valueOf(r0.getVersionName()));
            r1.put("channel", r0.getChannel());
            r1.put("npth_version", NpthBuildConfig.VERSION_NAME);
            JSONUtils.put(this.mCategory, r1);
            return;
        }

        public Event addCategories(Object... r2) {
            JSONUtils.addKVs(this.mCategory, r2);
            return this;
        }

        public Event addMetrics(JSONObject r1) {
            this.mMetric = r1;
            return this;
        }

        public Event addMetrics(Object... r2) {
            JSONUtils.addKVs(this.mMetric, r2);
            return this;
        }

        public void upload() {
            NpthMonitor r0 = NpthMonitor.access$000();
            if (r0 == null) goto L6;
            appendDefaultCategory();
            NpthMonitor.access$100(r0).reportEvent(this.mServiceName, 1, this.mCategory, this.mMetric);
            return;
        }
    }

    private NpthMonitor(Context r8) {
        EventMonitor r9 = MonitorManager.createEventMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), NPTH_AID, 4020254, 4020254, NpthBuildConfig.VERSION_NAME);
        this.mEventMonitor = r9;
        r9.setChannel("release");
        AppMonitor r7 = MonitorManager.getAppMonitor();
        if (r7 == null) goto L6;
        r9.setDeviceId(r7.getDeviceId("0"));
        return;
    }

    static /* synthetic */ NpthMonitor access$000() {
        return getInstance();
    }

    static /* synthetic */ EventMonitor access$100(NpthMonitor r0) {
        return r0.getEventMonitor();
    }

    public static void directReportInnerException(String r13, Throwable r14) {
        NpthMonitor r0 = getInstance();
        if (r0 != null) goto L5;
        return;
    L5:
        EventMonitor r1 = r0.getEventMonitor();
        EnsureReportData r12 = new EnsureReportData(r14, null, 0, r13, true, null, Thread.currentThread().getName(), EnsureDeliverer.ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Throwable -> L10
        final JSONObject r15 = new JSONObject();     // Catch: Throwable -> L10
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L10
        r16.put(r12.toJsonObject(r1));     // Catch: Throwable -> L10
        r15.put("data", r16);     // Catch: Throwable -> L10
        int r17 = Process.myPid();     // Catch: Throwable -> L10
        JSONObject r18 = Header.createEventHeader(r1, System.currentTimeMillis(), CrashType.ENSURE, r17).getJson();     // Catch: Throwable -> L10
        r15.put("header", r18);     // Catch: Throwable -> L10
        final String r19 = UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionUploadUrl(), r18);     // Catch: Throwable -> L10
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L13;
        DefaultWorkThread.post(new AnonymousClass1(r19, r15));     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    private EventMonitor getEventMonitor() {
        return this.mEventMonitor;
    }

    private static long getFileFreeSize(File r5) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r0.getFreeBytes();
    L8:
        return ((long) r0.getAvailableBlocks()) * r0.getBlockSize();
    L9:
        return 0;
    }

    public static long getInnerFreeSizeReal() {
        return getFileFreeSize(Environment.getDataDirectory());
    L4:
        return 0;
    }

    private static NpthMonitor getInstance() {
        return sInstance;
    }

    public static void init() {
        if (sInstance == null) goto L5;
        return;
    L5:
        monitor-enter(NpthMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NpthMonitor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(NpthMonitor.class);     // Catch: Throwable -> L11
    }

    public static void reportInnerException(String r1, Throwable r2) {
        NpthMonitor r0 = getInstance();
        if (r0 == null) goto L6;
        r0.getEventMonitor().reportEnsure(r1, r2);
        return;
    }

    public static void reportInnerException(Throwable r1) {
        reportInnerException("NPTH_CATCH_NEW", r1);
    }

    public static void reportInnerExceptionWithSpace(String r4, Throwable r5) {
        if (getInnerFreeSizeReal() >= 25165824) goto L5;
        boolean r0 = true;
    L6:
        NpthMonitor r1 = getInstance();
        if (r1 == null) goto L10;
        r1.getEventMonitor().reportEnsure(r4 + "_" + r0, r5);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
