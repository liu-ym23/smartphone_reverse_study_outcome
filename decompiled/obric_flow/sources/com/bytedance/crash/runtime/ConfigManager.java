package com.bytedance.crash.runtime;

import ai.j0;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.e;
import com.bytedance.crash.j;
import com.bytedance.crash.n;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.p;
import com.bytedance.crash.util.g;
import com.bytedance.ies.bullet.base.utils.b;
import com.bytedance.services.slardar.config.IConfigManager;
import com.lynx.tasm.behavior.d;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import l9.c;
import og.a;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigManager {
    private static final long BLOCK_MONITOR_INTERVAL = 1000;
    private static final long BLOCK_MONITOR_MIN_INTERVAL = 10;
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    public static final String LOG_TYPE_ALL_STACK = "npth_enable_all_thread_stack";
    private static boolean sApmExists = true;
    private static IConfigManager sConfigManager;
    private String mAlogUploadUrl;
    private volatile long mAnrCheckInterval;
    private String mApmConfigUrl;
    private String mAsanReportUploadUrl;
    private boolean mBlockMonitorEnable;
    private long mBlockMonitorInterval;
    private String mCoreDumpUrl;
    private long mDelayTime;
    private boolean mEnableCorefile;
    private e mEncryptImpl;
    private boolean mEnsureEnable;
    private boolean mEnsureWithLogcat;
    private final String mEventUploadUrl;
    private String mExceptionUploadUrl;
    private String mExceptionZipUploadUrl;
    private boolean mIsDebugMode;
    private boolean mIsEngMode;
    private String mJavaCrashUploadUrl;
    private long mLaunchCrashInterval;
    private String mLaunchCrashUploadUrl;
    private int mLogcatDumpCount;
    private int mLogcatLevel;
    private final boolean mNativeCrashMiniDump;
    private String mNativeCrashUploadUrl;
    private String mNativeMemUrl;
    private final String mQuotaStateUrl;
    private ThreadPoolExecutor mThreadPoolExecutor;
    private String mUploadCheckCoreDumpUrl;
    private boolean reportErrorEnable;

    public ConfigManager() {
        this.reportErrorEnable = true;
        this.mNativeMemUrl = "";
        this.mCoreDumpUrl = "";
        this.mUploadCheckCoreDumpUrl = "";
        this.mJavaCrashUploadUrl = "";
        this.mLaunchCrashUploadUrl = "";
        this.mExceptionUploadUrl = "";
        this.mExceptionZipUploadUrl = "";
        this.mEventUploadUrl = "";
        this.mNativeCrashUploadUrl = "";
        this.mAlogUploadUrl = "";
        this.mApmConfigUrl = "";
        this.mAsanReportUploadUrl = "";
        this.mQuotaStateUrl = "/monitor/collect/quota_status";
        this.mLaunchCrashInterval = LAUNCH_CRASH_INTERVAL;
        this.mEncryptImpl = new d(12);
        this.mLogcatDumpCount = 512;
        this.mAnrCheckInterval = 500;
        this.mLogcatLevel = 1;
        this.mNativeCrashMiniDump = true;
        this.mEnsureEnable = true;
        this.mBlockMonitorInterval = 1000;
    }

    private String getUrlSuffix() {
        if (j.f4054b != null) goto L5;
        return "";
    L5:
        return "?aid=" + j.f4054b.config().mAid + "&device_id=" + n.g().e();
    }

    public String getAlogUploadUrl() {
        if (TextUtils.isEmpty(this.mAlogUploadUrl) == false) goto L5;
        return "https://mon.snssdk.com/monitor/collect/c/logcollect";
    L5:
        return this.mAlogUploadUrl;
    }

    @Nullable
    public IConfigManager getApmConfigManager() {
        if (sApmExists == false) goto L10;
        if (sConfigManager != null) goto L10;
        sConfigManager = (IConfigManager) a.a(IConfigManager.class);     // Catch: Throwable -> L8
    L8:
        sApmExists = false;
    L10:
        if (sApmExists == true) goto L12;
        return null;
    L12:
        return sConfigManager;
    }

    public String getApmConfigUrl() {
        if (TextUtils.isEmpty(this.mApmConfigUrl) == false) goto L5;
        return "https://mon.snssdk.com/monitor/appmonitor/v3/settings";
    L5:
        return this.mApmConfigUrl;
    }

    public String getAsanReportUploadUrl() {
        return "https://mon.snssdk.com/monitor/collect/c/native_bin_crash";
    }

    public long getBlockInterval() {
        return this.mBlockMonitorInterval;
    }

    public String getCoreDumpUrl() {
        return "https://mon.snssdk.com/monitor/collect/c/core_dump_collect";
    }

    public long getDefaultAnrCheckInterval() {
        return this.mAnrCheckInterval;
    }

    public long getDelayTime() {
        return this.mDelayTime;
    }

    @NonNull
    public e getEncryptImpl() {
        return this.mEncryptImpl;
    }

    public String getEventUploadUrl() {
        return "https://mon.snssdk.com/monitor/collect";
    }

    public String getExceptionUploadUrl() {
        if (TextUtils.isEmpty(this.mExceptionUploadUrl) == false) goto L5;
        return "https://mon.snssdk.com/monitor/collect/c/exception";
    L5:
        return this.mExceptionUploadUrl;
    }

    public String getExceptionZipUploadUrl() {
        if (TextUtils.isEmpty(this.mExceptionZipUploadUrl) == false) goto L5;
        return "https://mon.snssdk.com/monitor/collect/c/exception/dump_collection";
    L5:
        return this.mExceptionZipUploadUrl;
    }

    public Set<String> getFilterThreadSet() {
        return com.bytedance.crash.util.e.f4178a;
    }

    public String getJavaCrashUploadUrl() {
        if (TextUtils.isEmpty(this.mJavaCrashUploadUrl) == false) goto L5;
        return "https://mon.snssdk.com/monitor/collect/c/crash";
    L5:
        return this.mJavaCrashUploadUrl;
    }

    public long getLaunchCrashInterval() {
        return this.mLaunchCrashInterval;
    }

    public String getLaunchCrashUploadUrl() {
        if (TextUtils.isEmpty(this.mLaunchCrashUploadUrl) == false) goto L5;
        return "https://mon.snssdk.com/monitor/collect/c/exception/dump_collection";
    L5:
        return this.mLaunchCrashUploadUrl;
    }

    public int getLogcatDumpCount() {
        return this.mLogcatDumpCount;
    }

    public int getLogcatLevel() {
        return this.mLogcatLevel;
    }

    public String getNativeCrashUploadUrl() {
        if (TextUtils.isEmpty(this.mNativeCrashUploadUrl) == false) goto L5;
        return "https://mon.snssdk.com/monitor/collect/c/native_bin_crash";
    L5:
        return this.mNativeCrashUploadUrl;
    }

    public String getNativeMemUrl() {
        return "https://mon.snssdk.com/monitor/collect/c/rapheal_file_collect";
    }

    public String getQuotaStateUrl() {
        return "https://mon.snssdk.com/monitor/collect/quota_status";
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public String getUploadCheckCoreDumpUrl() {
        return "https://mon.snssdk.com/monitor/collect/c/core_dump_upload_check";
    }

    public boolean isApmExists() {
        return false;
    }

    public boolean isBlockMonitorEnable() {
        return this.mBlockMonitorEnable;
    }

    public boolean isCrashIgnored(String r10) {
        l9.e r5 = new l9.e(r10);     // Catch: Throwable -> L30
        JSONObject r11 = n9.d.f20218a;     // Catch: Throwable -> L30
        if (r11 == null) goto L12;
        JSONObject r12 = r11.optJSONObject("java_crash_ignore");     // Catch: Throwable -> L30
        if (r12 == null) goto L12;
        if (n9.d.a(r12.optJSONArray("disable"), r5) == true) goto L12;
        boolean r13 = n9.d.a(r12.optJSONArray("enable"), r5);     // Catch: Throwable -> L30
    L14:
        if (r13 == false) goto L18;
        return true;
    L18:
        if (b.n(n.f4057a) == false) goto L33;
        com.bytedance.crash.upload.b.s();     // Catch: Throwable -> L30
        if (r11 != null) goto L22;
        return false;
    L22:
        JSONObject r14 = r11.optJSONObject("java_crash_ignore");     // Catch: Throwable -> L30
        if (r14 != null) goto L26;
        return false;
    L26:
        if (n9.d.a(r14.optJSONArray("disable"), r5) == false) goto L28;
        return false;
    L28:
        return n9.d.a(r14.optJSONArray("enable"), r5);
    L33:
        return false;
    L12:
        r13 = false;
    L34:
        return false;
    }

    public boolean isDebugMode() {
        if (this.mIsDebugMode == true) goto L6;
        return false;
    L6:
        return true;
    }

    public boolean isEnableCorefile() {
        return this.mEnableCorefile;
    }

    public boolean isEngMode() {
        return this.mIsEngMode;
    }

    public boolean isEnsureEnable() {
        ConcurrentLinkedQueue r5 = c.f19554a;
        if (p.f4081a == false) goto L12;
        if (c.e() == null) goto L12;
        String r10 = n.d().i();
        n9.a r11 = (n9.a) n9.a.f.get(r10);
        if (r11 != null) goto L9;
        return true;
    L9:
        if (r11.e == false) goto L12;
        return true;
    L12:
        if (this.mEnsureEnable == true) goto L17;
        return false;
    L17:
        return true;
    }

    public boolean isEnsureWithLogcat() {
        return this.mEnsureWithLogcat;
    }

    public boolean isNativeCrashMiniDump() {
        return true;
    }

    public boolean isReportErrorEnable() {
        return this.reportErrorEnable;
    }

    public void setAlogUploadUrl(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.mAlogUploadUrl = r5;
    }

    public void setBlockMonitorEnable(boolean r5) {
        this.mBlockMonitorEnable = r5;
    }

    public void setBlockMonitorInterval(long r5) {
        this.mBlockMonitorInterval = r5;
    }

    public void setConfigGetUrl(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.mApmConfigUrl = r5;
    }

    public void setCurrentProcessName(String r5) {
        m.f23304a = r5;
    }

    public void setDebugMode(boolean r5) {
        this.mIsDebugMode = r5;
    }

    public void setDefaultAnrCheckInterval(long r5) {
        this.mAnrCheckInterval = r5;
    }

    public void setEncryptImpl(e r5) {
        if (r5 == null) goto L5;
        this.mEncryptImpl = r5;
        return;
    }

    public void setEngMode(Context r5, boolean r10, boolean r11, long r12) {
        this.mIsEngMode = r10;
        this.mEnableCorefile = r11;
        setDebugMode(r10);
        if (r10 == false) goto L6;
        this.mDelayTime = r12;
        NativeImpl.m();
        NativeImpl.i(r12);
        String r13 = g.f4181a;
        g.f4183c = r5.getExternalFilesDir("diggo").getAbsolutePath();
        return;
    }

    public void setEnsureEnable(boolean r5) {
        this.mEnsureEnable = r5;
    }

    public void setEnsureWithLogcat(boolean r5) {
        this.mEnsureWithLogcat = r5;
    }

    public void setJavaCrashUploadUrl(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.mJavaCrashUploadUrl = r5;
    }

    public void setLaunchCrashInterval(long r5) {
        if (r5 <= 0) goto L6;
        this.mLaunchCrashInterval = r5;
        return;
    }

    public void setLaunchCrashUrl(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mExceptionUploadUrl = r10;
        int r5 = r10.indexOf("//");
        if (r5 != (-1)) goto L9;
        this.mLaunchCrashUploadUrl = r10.substring(0, r10.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
        this.mExceptionZipUploadUrl = r10.substring(0, r10.indexOf("/") + 1) + "monitor/collect/c/custom_exception/zip";
        return;
    L9:
        int r11 = r5 + 2;
        this.mLaunchCrashUploadUrl = j0.q(new StringBuilder(), r10.substring(0, r10.indexOf("/", r11) + 1), "monitor/collect/c/exception/dump_collection");
        this.mExceptionZipUploadUrl = j0.q(new StringBuilder(), r10.substring(0, r10.indexOf("/", r11) + 1), "monitor/collect/c/custom_exception/zip");
    }

    public void setLogcatDumpCount(int r5) {
        if (r5 <= 0) goto L5;
        this.mLogcatDumpCount = r5;
        return;
    }

    public void setLogcatLevel(int r5) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 > 4) goto L8;
        this.mLogcatLevel = r5;
        return;
    }

    public void setNativeCrashUrl(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.mNativeCrashUploadUrl = r5;
    }

    public void setReportErrorEnable(boolean r5) {
        this.reportErrorEnable = r5;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor r5) {
        this.mThreadPoolExecutor = r5;
    }
}
