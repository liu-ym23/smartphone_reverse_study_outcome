package com.bytedance.crash.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.runtime.AllDefaultUrls;

/* JADX INFO: loaded from: classes.dex */
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

    @NonNull
    public static String getAlogUploadUrl() {
        return sInstance.mAlogUploadUrl;
    }

    @NonNull
    public static String getApmConfigUrl() {
        return sInstance.mApmConfigUrl;
    }

    @NonNull
    public static String getAsanReportUploadUrl() {
        return getNativeCrashUploadUrl();
    }

    @NonNull
    public static String getBizExceptionUploadUrl() {
        return sInstance.mBizExceptionUploadUrl;
    }

    @NonNull
    public static String getCoreDumpUrl() {
        return sInstance.mCoreDumpUrl;
    }

    @NonNull
    public static String getEventUploadUrl() {
        return sInstance.mEventUploadUrl;
    }

    @NonNull
    public static String getExceptionUploadUrl() {
        return sInstance.mExceptionUploadUrl;
    }

    @NonNull
    public static String getExceptionZipUploadUrl() {
        return sInstance.mExceptionZipUploadUrl;
    }

    @NonNull
    public static String getJavaCrashUploadUrl() {
        return sInstance.mJavaCrashUploadUrl;
    }

    @NonNull
    public static String getLaunchCrashUploadUrl() {
        return sInstance.mLaunchCrashUploadUrl;
    }

    @NonNull
    public static String getNativeCrashUploadUrl() {
        return sInstance.mNativeCrashUploadUrl;
    }

    @NonNull
    public static String getNativeMemUrl() {
        return sInstance.mNativeMemUrl;
    }

    public static String getQuotaStateUrl() {
        return sInstance.mQuotaStatusURL;
    }

    @NonNull
    public static String getUploadCheckCoreDumpUrl() {
        return sInstance.mUploadCheckCoreDumpUrl;
    }

    @NonNull
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

    public void setAlogUploadUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mAlogUploadUrl = r10;
    }

    public void setConfigGetUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mApmConfigUrl = r10;
    }

    public void setCustomDomain(String r10) {
        this.mDomain = r10;
        updateURL();
    }

    public void setJavaCrashUploadUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mJavaCrashUploadUrl = r10;
    }

    public void setLaunchCrashUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mExceptionUploadUrl = r10;
        int r11 = r10.indexOf("//");
        if (r11 != (-1)) goto L8;
        this.mLaunchCrashUploadUrl = r10.substring(0, r10.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
        String r12 = r10.substring(0, r10.indexOf("/") + 1) + "monitor/collect/c/custom_exception/zip";
    L9:
        this.mExceptionZipUploadUrl = r12;
        return;
    L8:
        StringBuilder r13 = new StringBuilder();
        int r14 = r11 + 2;
        r13.append(r10.substring(0, r10.indexOf("/", r14) + 1));
        r13.append("monitor/collect/c/exception/dump_collection");
        this.mLaunchCrashUploadUrl = r13.toString();
        r12 = r10.substring(0, r10.indexOf("/", r14) + 1) + "monitor/collect/c/custom_exception/zip";
        goto L9
    }

    public void setNativeCrashUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mNativeCrashUploadUrl = r10;
    }
}
