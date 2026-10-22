package com.bytedance.crash.config;

import android.text.TextUtils;
import com.bytedance.crash.runtime.AllDefaultUrls;

/* JADX INFO: loaded from: classes2.dex */
public class NetConfig {
    static final String BIZ_EXCEPTION_URL = "/monitor/collect/c/biz_exception";
    static final String FILE_UPLOAD_URL = "/monitor/collect/c/logcollect";
    static final String PATH_ALOG_UPLOAD = "/monitor/collect/c/logcollect";
    static final String PATH_APM_CONFIG = "/monitor/appmonitor/v3/settings";
    static final String PATH_CORE_DUMP = "/monitor/collect/c/core_dump_collect";
    static final String PATH_EVENT = "/monitor/collect/batch/";
    public static final String PATH_EXCEPTION = "/monitor/collect/c/exception";
    public static final String PATH_JAVA_CRASH = "/monitor/collect/c/crash";
    static final String PATH_LAUNCH_CRASH = "/monitor/collect/c/exception/dump_collection";
    public static final String PATH_NATIVE_CRASH = "/monitor/collect/c/native_bin_crash";
    static final String PATH_NATIVE_EXCEPTION = "/monitor/collect/c/exception/dump_collection";
    static final String PATH_NATIVE_MEM = "/monitor/collect/c/rapheal_file_collect";
    static final String PATH_UPLOAD_CHECK_COREDUMP = "/monitor/collect/c/core_dump_upload_check";
    static final String QUOTA_STATUS_URL = "/monitor/collect/quota_status";
    private static final NetConfig sInstance = null;
    private String mAlogUploadUrl;
    private String mApmConfigUrl;
    private String mBizExceptionUploadUrl;
    private String mCoreDumpUrl;
    private String mDomain;
    private String mEventUploadUrl;
    private String mExceptionUploadUrl;
    private String mExceptionZipUploadUrl;
    private String mJavaCrashUploadUrl;
    private String mLaunchCrashUploadUrl;
    private String mNativeCrashUploadUrl;
    private String mNativeMemUrl;
    private String mQuotaStatusURL;
    private String mUploadCheckCoreDumpUrl;
    private String mUploadFileURL;

    static {
        sInstance = new NetConfig();
    }

    private NetConfig() {
        this.mDomain = AllDefaultUrls.getDomainName();
        updateURL();
    }

    public static NetConfig get() {
        return sInstance;
    }

    public static String getAlogUploadUrl() {
        return sInstance.mAlogUploadUrl;
    }

    public static String getApmConfigUrl() {
        return sInstance.mApmConfigUrl;
    }

    public static String getAsanReportUploadUrl() {
        return getNativeCrashUploadUrl();
    }

    public static String getBizExceptionUploadUrl() {
        return sInstance.mBizExceptionUploadUrl;
    }

    public static String getCoreDumpUrl() {
        return sInstance.mCoreDumpUrl;
    }

    public static String getEventUploadUrl() {
        return sInstance.mEventUploadUrl;
    }

    public static String getExceptionUploadUrl() {
        return sInstance.mExceptionUploadUrl;
    }

    public static String getExceptionZipUploadUrl() {
        return sInstance.mExceptionZipUploadUrl;
    }

    public static String getJavaCrashUploadUrl() {
        return sInstance.mJavaCrashUploadUrl;
    }

    public static String getLaunchCrashUploadUrl() {
        return sInstance.mLaunchCrashUploadUrl;
    }

    public static String getNativeCrashUploadUrl() {
        return sInstance.mNativeCrashUploadUrl;
    }

    public static String getNativeMemUrl() {
        return sInstance.mNativeMemUrl;
    }

    public static String getQuotaStateUrl() {
        return sInstance.mQuotaStatusURL;
    }

    public static String getUploadCheckCoreDumpUrl() {
        return sInstance.mUploadCheckCoreDumpUrl;
    }

    public static String getUploadFileUrl() {
        return sInstance.mUploadFileURL;
    }

    private void updateURL() {
        this.mNativeMemUrl = this.mDomain + PATH_NATIVE_MEM;
        this.mCoreDumpUrl = this.mDomain + PATH_CORE_DUMP;
        this.mUploadCheckCoreDumpUrl = this.mDomain + PATH_UPLOAD_CHECK_COREDUMP;
        this.mJavaCrashUploadUrl = this.mDomain + PATH_JAVA_CRASH;
        this.mLaunchCrashUploadUrl = this.mDomain + "/monitor/collect/c/exception/dump_collection";
        this.mExceptionUploadUrl = this.mDomain + "/monitor/collect/c/exception";
        this.mExceptionZipUploadUrl = this.mDomain + "/monitor/collect/c/exception/dump_collection";
        this.mEventUploadUrl = this.mDomain + "/monitor/collect/batch/";
        this.mNativeCrashUploadUrl = this.mDomain + PATH_NATIVE_CRASH;
        this.mAlogUploadUrl = this.mDomain + "/monitor/collect/c/logcollect";
        this.mApmConfigUrl = this.mDomain + PATH_APM_CONFIG;
        this.mQuotaStatusURL = this.mDomain + QUOTA_STATUS_URL;
        this.mUploadFileURL = this.mDomain + "/monitor/collect/c/logcollect";
        this.mBizExceptionUploadUrl = this.mDomain + BIZ_EXCEPTION_URL;
    }

    public void setAlogUploadUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.mAlogUploadUrl = r2;
    }

    public void setConfigGetUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.mApmConfigUrl = r2;
    }

    public void setCustomDomain(String r1) {
        this.mDomain = r1;
        updateURL();
    }

    public void setJavaCrashUploadUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.mJavaCrashUploadUrl = r2;
    }

    public void setLaunchCrashUrl(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        this.mExceptionUploadUrl = r8;
        int r0 = r8.indexOf("//");
        if (r0 != (-1)) goto L8;
        this.mLaunchCrashUploadUrl = r8.substring(0, r8.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
        StringBuilder r9 = new StringBuilder().append(r8.substring(0, r8.indexOf("/") + 1));
    L9:
        this.mExceptionZipUploadUrl = r9.append("monitor/collect/c/custom_exception/zip").toString();
        return;
    L8:
        int r1 = r0 + 2;
        this.mLaunchCrashUploadUrl = r8.substring(0, r8.indexOf("/", r1) + 1) + "monitor/collect/c/exception/dump_collection";
        r9 = new StringBuilder().append(r8.substring(0, r8.indexOf("/", r1) + 1));
        goto L9
    }

    public void setNativeCrashUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.mNativeCrashUploadUrl = r2;
    }
}
