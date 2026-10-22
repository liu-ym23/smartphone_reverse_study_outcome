package com.bytedance.crash.diagnose;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
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
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NpthMonitor {
    private static final String NPTH_AID = "2010";
    private static NpthMonitor sInstance;
    private final EventMonitor mEventMonitor;

    public static class Event {
        private final JSONObject mCategory;
        private JSONObject mMetric;
        private final String mServiceName;

        public Event(String r10) {
            this.mMetric = new JSONObject();
            this.mServiceName = r10;
            this.mCategory = new JSONObject();
        }

        public Event(String r10, JSONObject r11) {
            this.mMetric = new JSONObject();
            this.mServiceName = r10;
            if (r11 == null) goto L5;
            this.mCategory = r11;
            return;
        L5:
            this.mCategory = new JSONObject();
        }

        private void appendDefaultCategory() {
            AppMonitor r10 = MonitorManager.getAppMonitor();
            if (r10 == null) goto L6;
            HashMap r11 = new HashMap();
            r11.put("aid", r10.getAppId());
            r11.put("device_id", r10.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE));
            r11.put("update_version_code", String.valueOf(r10.getUpdateVersionCode()));
            r11.put("version_code", String.valueOf(r10.getVersionCode()));
            r11.put("app_version", String.valueOf(r10.getVersionName()));
            r11.put("channel", r10.getChannel());
            r11.put("npth_version", NpthBuildConfig.VERSION_NAME);
            JSONUtils.put(this.mCategory, r11);
            return;
        }

        public Event addCategories(Object... r10) {
            JSONUtils.addKVs(this.mCategory, r10);
            return this;
        }

        public Event addMetrics(JSONObject r10) {
            this.mMetric = r10;
            return this;
        }

        public Event addMetrics(Object... r10) {
            JSONUtils.addKVs(this.mMetric, r10);
            return this;
        }

        public void upload() {
            NpthMonitor r10 = NpthMonitor.access$000();
            if (r10 == null) goto L6;
            appendDefaultCategory();
            NpthMonitor.access$100(r10).reportEvent(this.mServiceName, 1, this.mCategory, this.mMetric);
            return;
        }
    }

    private NpthMonitor(@NonNull Context r10) {
        EventMonitor r11 = MonitorManager.createEventMonitor(r10, NPTH_AID, 4020254, 4020254, NpthBuildConfig.VERSION_NAME);
        this.mEventMonitor = r11;
        r11.setChannel("release");
        AppMonitor r12 = MonitorManager.getAppMonitor();
        if (r12 == null) goto L6;
        r11.setDeviceId(r12.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE));
        return;
    }

    static /* synthetic */ NpthMonitor access$000() {
        return getInstance();
    }

    static /* synthetic */ EventMonitor access$100(NpthMonitor r10) {
        return r10.getEventMonitor();
    }

    public static void directReportInnerException(String r13, Throwable r14) {
        NpthMonitor r10 = getInstance();
        if (r10 != null) goto L5;
        return;
    L5:
        EventMonitor r11 = r10.getEventMonitor();
        EnsureReportData r12 = new EnsureReportData(r14, null, 0, r13, true, null, Thread.currentThread().getName(), EnsureDeliverer.ENSURE_NOT_REACH_HERE, "core_exception_monitor", CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Throwable -> L10
        final JSONObject r15 = new JSONObject();     // Catch: Throwable -> L10
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L10
        r16.put(r12.toJsonObject(r11));     // Catch: Throwable -> L10
        r15.put("data", r16);     // Catch: Throwable -> L10
        int r17 = Process.myPid();     // Catch: Throwable -> L10
        JSONObject r18 = Header.createEventHeader(r11, System.currentTimeMillis(), CrashType.ENSURE, r17).getJson();     // Catch: Throwable -> L10
        r15.put("header", r18);     // Catch: Throwable -> L10
        final String r19 = UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionUploadUrl(), r18);     // Catch: Throwable -> L10
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L13;
        DefaultWorkThread.post(new AnonymousClass1(r19, r15));     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    @NonNull
    private EventMonitor getEventMonitor() {
        return this.mEventMonitor;
    }

    private static long getFileFreeSize(File r10) {
        StatFs r11 = new StatFs(r10.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r11.getFreeBytes();
    L8:
        return ((long) r11.getAvailableBlocks()) * r11.getBlockSize();
    L9:
        return 0;
    }

    public static long getInnerFreeSizeReal() {
        return getFileFreeSize(Environment.getDataDirectory());
    L4:
        return 0;
    }

    @Nullable
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
        sInstance = new NpthMonitor(Global.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(NpthMonitor.class);     // Catch: Throwable -> L11
    }

    public static void reportInnerException(String r10, Throwable r11) {
        NpthMonitor r12 = getInstance();
        if (r12 == null) goto L6;
        r12.getEventMonitor().reportEnsure(r10, r11);
        return;
    }

    public static void reportInnerException(Throwable r10) {
        reportInnerException("NPTH_CATCH_NEW", r10);
    }

    public static void reportInnerExceptionWithSpace(String r10, Throwable r11) {
        if (getInnerFreeSizeReal() >= 25165824) goto L5;
        boolean r12 = true;
    L6:
        NpthMonitor r13 = getInstance();
        if (r13 == null) goto L10;
        r13.getEventMonitor().reportEnsure(r10 + "_" + r12, r11);
        return;
    L10:
        return;
    L5:
        r12 = false;
        goto L6
    }
}
