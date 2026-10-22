package com.bytedance.crash.resource;

import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.crash.general.RomInfoHelper;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.resource.utils.GuardFile;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.librarian.a;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceMonitorAdapter {
    private static final int DIRS_LIMIT_UNEXPECTED = 15;
    public static final int RET_OK = 0;
    private static final String TAG = "ResourceMonitorAdapter: ";
    protected String mConfigDir;
    protected File mConfigFile;
    protected GuardFile mGuardFile;
    protected boolean mHasInited;
    protected String mLogDir;
    protected File mReportDir;
    protected boolean mSoLoaded;

    public static abstract class ResourceMonitorUploader {
        private static final int EXCEPTION_LIMIT = 10;
        private static final String TAG = "ResourceMonitorUploader: ";
        protected String mIgnorePath;
        protected AppMonitor mMonitor;
        protected File mReportDir;

        protected ResourceMonitorUploader(AppMonitor r10, @NonNull File r11) {
            this.mMonitor = r10;
            this.mReportDir = r11;
            this.mIgnorePath = r11.getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();
        }

        static /* synthetic */ void access$000(ResourceMonitorUploader r10, EnsureReportData r11, File r12, UploaderData r13) {
            r10.nativeCustomizeExceptionUploadInner(r11, r12, r13);
        }

        protected static String buildIDToUUID(String r10) {
            StringBuilder r11 = new StringBuilder();
            if (r10.length() >= 16) goto L6;
            r11.append(r10);     // Catch: Throwable -> L11
        L12:
            goto L10
        L6:
            r11.append(r10.charAt(6));     // Catch: Throwable -> L11
            r11.append(r10.charAt(7));     // Catch: Throwable -> L11
            r11.append(r10.charAt(4));     // Catch: Throwable -> L11
            r11.append(r10.charAt(5));     // Catch: Throwable -> L11
            r11.append(r10.charAt(2));     // Catch: Throwable -> L11
            r11.append(r10.charAt(3));     // Catch: Throwable -> L11
            r11.append(r10.charAt(0));     // Catch: Throwable -> L11
            r11.append(r10.charAt(1));     // Catch: Throwable -> L11
            r11.append(r10.charAt(10));     // Catch: Throwable -> L11
            r11.append(r10.charAt(11));     // Catch: Throwable -> L11
            r11.append(r10.charAt(8));     // Catch: Throwable -> L11
            r11.append(r10.charAt(9));     // Catch: Throwable -> L11
            r11.append(r10.charAt(14));     // Catch: Throwable -> L11
            r11.append(r10.charAt(15));     // Catch: Throwable -> L11
            r11.append(r10.charAt(12));     // Catch: Throwable -> L11
            r11.append(r10.charAt(13));     // Catch: Throwable -> L11
            if (r10.length() < 32) goto L12;
            r11.append(r10, 16, 32);     // Catch: Throwable -> L11
            r11.append('0');     // Catch: Throwable -> L11
        L10:
            return r11.toString().toUpperCase();
        }

        protected static int getLineIndex(JSONArray r10, int r11, String r12) {
        L3:
            if (r11 >= r10.length()) goto L10;
            String r13 = r10.optString(r11, null);
            if (r13 == null) goto L9;
            if (r13.startsWith(r12) == false) goto L9;
            return r11;
        L9:
            r11 = r11 + 1;
            goto L3
        L10:
            return -1;
        }

        protected static String getSizeRange(String r10, String r11) {
            if (r10 != null) goto L5;
            return "other";
        L5:
            if (r11 != null) goto L7;
        L8:
            r11 = "B";
        L10:
            if (r11.equals("GB") == false) goto L12;
            return "1GB+";
        L12:
            if (r11.equals("MB") == true) goto L33;
            return "0~1MB";
        L33:
            int r12 = Integer.parseInt(r10.substring(0, r10.indexOf(46)));     // Catch: Throwable -> L30
            if (r12 >= 200) goto L21;
            return "0~200MB";
        L21:
            if (r12 >= 500) goto L25;
            return "200~500MB";
        L25:
            if (r12 >= 800) goto L28;
            return "500~800MB";
        L28:
            return "800~1024MB(1G)";
        L30:
            return "other";
        L7:
            if (r11.length() != 0) goto L10;
            goto L8
        }

        protected static String getSizeRangeMB(long r10) {
            if (r10 > 350) goto L6;
            return "~350MB";
        L6:
            if (r10 <= 350) goto L11;
            if (r10 > 450) goto L11;
            return "350MB~450MB";
        L11:
            if (r10 <= 450) goto L16;
            if (r10 > 550) goto L16;
            return "450MB~550MB";
        L16:
            if (r10 <= 550) goto L21;
            if (r10 > 650) goto L21;
            return "550MB~650MB";
        L21:
            if (r10 <= 650) goto L26;
            if (r10 > 750) goto L26;
            return "650MB~750MB";
        L26:
            if (r10 <= 750) goto L31;
            if (r10 > 850) goto L31;
            return "750MB~850MB";
        L31:
            if (r10 <= 850) goto L36;
            if (r10 > 950) goto L36;
            return "850MB~950MB";
        L36:
            if (r10 <= 950) goto L41;
            if (r10 > 1050) goto L41;
            return "950MB~1050MB";
        L41:
            if (r10 <= 1050) goto L46;
            if (r10 > 1250) goto L46;
            return "1050MB~1250MB";
        L46:
            if (r10 <= 1250) goto L51;
            if (r10 > 1450) goto L51;
            return "1250MB~1450MB";
        L51:
            if (r10 <= 1450) goto L56;
            if (r10 > 1650) goto L56;
            return "1450MB~1650MB";
        L56:
            if (r10 <= 1650) goto L61;
            if (r10 > 1850) goto L61;
            return "1650MB~1850MB";
        L61:
            if (r10 > 1850) goto L63;
        L65:
            return ">2.3G";
        L63:
            if (r10 > 2050) goto L65;
            return "1850MB~2050MB";
        }

        private void nativeCustomizeExceptionUpload(final File r12, Map<String, String> r13, final UploaderData r14) {
            AppMonitor r10 = this.mMonitor;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.getEnsureDeliver() != null) goto L8;
            return;
        L8:
            if (r14.mPid != 0) goto L10;
            r14.mPid = Process.myPid();
        L10:
            final EnsureReportData r11 = new EnsureReportData(r14.mJavaStack, r14.mNativeStack, r14.mAbortLine, r13, r14.mThreadName, NetConst.ENCRYPT_VERISON_CODE, "native_exception", (int) r14.mPid);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) goto L13;
            nativeCustomizeExceptionUploadInner(r11, r12, r14);
            return;
        L13:
            DefaultWorkThread.post(new AnonymousClass1(this, r11, r12, r14));
        }

        private void nativeCustomizeExceptionUploadInner(EnsureReportData r10, File r11, UploaderData r12) {
            JSONObject r13 = Header.createEventHeader(this.mMonitor, System.currentTimeMillis(), CrashType.NATIVE_CUSTOMIZE, (int) r12.mPid).getJson();     // Catch: Exception -> L7
            JSONObject r14 = new JSONObject();     // Catch: Exception -> L7
            JSONArray r15 = new JSONArray();     // Catch: Exception -> L7
            JSONObject r16 = r10.toJsonObject(this.mMonitor);     // Catch: Exception -> L7
            r15.put(r16);     // Catch: Exception -> L7
            r14.put("data", r15);     // Catch: Exception -> L7
            r14.put(CrashBody.CRASH_LIB_UUID, r12.mSoUUID);     // Catch: Exception -> L7
            JSONUtils.combineJson(r14, r12.extraDataInBody);     // Catch: Exception -> L7
            r14.put("header", r13);     // Catch: Exception -> L7
            updateHeader(r11, r13, r16);     // Catch: Exception -> L7
            if (CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r13), r14.toString(), new File[]{r11}) == false) goto L10;
            NpthLog.d("ResourceMonitorUploader: upload success");     // Catch: Exception -> L7
            FileUtils.deleteFile(r11);     // Catch: Exception -> L7
            return;
        L10:
            return;
        }

        protected void packFilterData(Map<String, String> r10, UploaderData r11) {
            if (r10 == null) goto L7;
            if (r11 == null) goto L8;
            r10.putAll(r11.filterData);
            return;
        L8:
            return;
        }

        protected abstract boolean parseReport(File r10, UploaderData r11);

        public void updateHeader(File r10, JSONObject r11, JSONObject r12) {
            File r13 = new File(r10, "summary.json");
            File r14 = new File(r10, "crash_time");
            String r15 = FileSystemUtils.readUtf8File(r13);
            String r16 = FileSystemUtils.readUtf8File(r14);
            JSONObject r17 = r12.optJSONObject("filters");
            if (r15 != null) goto L9;
        L5:
            if (r16 == null) goto L11;
            long r18 = Long.parseLong(r16) * 1000;     // Catch: Throwable -> L8
            r12.put("crash_time", r18);     // Catch: Throwable -> L8
            r12.put("timestamp", r18);     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L11:
            return;
        L9:
            JSONObject r19 = new JSONObject(r15);     // Catch: Throwable -> L8
            JSONUtils.combineJson(r11, r19.optJSONObject("header"));     // Catch: Throwable -> L8
            JSONUtils.combineJson(r17, r19.optJSONObject("filters"));     // Catch: Throwable -> L8
            r12.put("app_start_time", r11.opt("app_start_time"));     // Catch: Throwable -> L8
            goto L5
        }

        public void uploadAll() {
            File[] r10 = this.mReportDir.listFiles();
            if (r10 != null) goto L5;
            return;
        L5:
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L6:
            if (r12 >= r11) goto L32;
            File r14 = r10[r12];
            if (this.mIgnorePath.equals(r14.getAbsolutePath()) == true) goto L31;
            if (r14.isFile() == true) goto L31;
            if (FileUtils.isEmpty(r14) == true) goto L30;
            int r15 = r13 + 1;
            if (r13 < 10) goto L17;
            r13 = r15;
            goto L30
        L17:
            UploaderData r16 = new UploaderData();
            HashMap r17 = new HashMap();
            if (parseReport(r14, r16) == false) goto L21;
            packFilterData(r17, r16);     // Catch: Throwable -> L23
            NativeBridge.parseSmaps(r14.getAbsolutePath());     // Catch: Throwable -> L23
            nativeCustomizeExceptionUpload(r14, r17, r16);     // Catch: Throwable -> L23
        L22:
            FileUtils.deleteFile(r14);
            r13 = r15;
            goto L31
        L21:
            FileUtils.deleteFile(r14);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            NpthLog.e(TAG, "upload exception:" + th);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            FileUtils.deleteFile(r14);
            throw th;
        L30:
            FileUtils.deleteFile(r14);
        L31:
            r12 = r12 + 1;
            goto L6
        }
    }

    public static class UploaderData {
        public JSONObject extraDataInBody;
        public Map<String, String> filterData;
        public String mAbortLine;
        public String mJavaStack;
        public String mNativeStack;
        public long mPid;
        public String mProcessName;
        public JSONArray mSoUUID;
        public String mThreadName;
        public long mTid;

        UploaderData() {
            this.mJavaStack = "";
            this.mNativeStack = null;
            this.mThreadName = null;
            this.mAbortLine = null;
            this.mProcessName = null;
            this.mPid = 0;
            this.mTid = 0;
            this.mSoUUID = new JSONArray();
            this.filterData = new HashMap();
            this.extraDataInBody = new JSONObject();
        }
    }

    public ResourceMonitorAdapter() {
        this.mSoLoaded = false;
        this.mHasInited = false;
    }

    private static String getAppVersion() {
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L7;
        return "unknown";
    L7:
        return String.valueOf(r10.getVersionCode());
    }

    private synchronized boolean initMonitor(ResourceMonitorConfig r10) {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L4:
        boolean r11 = false;
        if (this.mHasInited == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.mHasInited = true;     // Catch: Throwable -> L51
        int r12 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L51
        if (r12 >= r10.getmApiLevelMin()) goto L12;
    L48:
        NpthLog.e(TAG, "Unsupported API!!!");     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L12:
        if (r12 > r10.getmApiLevelMax()) goto L48;
        this.mConfigDir = Global.getConfigDir();     // Catch: Throwable -> L51
        File r13 = r10.getReportDir();     // Catch: Throwable -> L51
        this.mReportDir = r13;     // Catch: Throwable -> L51
        if (r13 != null) goto L17;
    L45:
        NpthLog.e(TAG, "cannot create " + this.mReportDir);     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L17:
        if (r13.exists() == false) goto L19;
    L21:
        this.mLogDir = this.mReportDir.getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();     // Catch: Throwable -> L51
        GuardFile r14 = new GuardFile(this.mReportDir.getAbsolutePath(), r10.getGuardFileName(), GuardFile.DEFAULT_EXPIRE_TIME);     // Catch: Throwable -> L51
        this.mGuardFile = r14;     // Catch: Throwable -> L51
        if (r14.checkGuardFile() == true) goto L26;
        monitor-exit(this);
        return false;
    L26:
        if (initBeforeSoLoad() == true) goto L29;
        monitor-exit(this);
        return false;
    L29:
        writeConfig(r10);     // Catch: Throwable -> L51
        if (loadLibrary(r10) == true) goto L55;
        NpthLog.i(TAG, "loadLibrary() failed!");     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L55:
    L41:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return false;
    L35:
        if (this.mConfigDir == null) goto L43;
        if (NativeResourceMonitor.LoadNativeBridgeSoInit(r12, r10.getResourceType(), r10.getFullSoName(), getAppVersion(), this.mLogDir, this.mConfigDir) != 0) goto L39;
        r11 = true;
    L39:
        monitor-exit(this);
        return r11;
    L19:
        if (this.mReportDir.mkdir() == true) goto L21;
        goto L21
    }

    private boolean loadLibrary(ResourceMonitorConfig r10) {
        NpthLog.i(TAG, "loadLibrary...");
        if (this.mSoLoaded == true) goto L6;
        a.a(r10.getLibName(), Global.getContext());     // Catch: Throwable -> L7
        this.mSoLoaded = true;     // Catch: Throwable -> L7
    L6:
        return this.mSoLoaded;
    }

    private void writeConfig(ResourceMonitorConfig r10) {
        if (r10 != null) goto L12;
        return;
    L12:
        File r11 = new File(this.mConfigDir, r10.getConfigName());     // Catch: Throwable -> L9
        this.mConfigFile = r11;     // Catch: Throwable -> L9
        if (r11.exists() == true) goto L7;
        this.mConfigFile.createNewFile();     // Catch: Throwable -> L9
    L7:
        NpthLog.e(TAG, "write Config");     // Catch: Throwable -> L9
        FileUtils.writeFile(this.mConfigFile, r10.toString(), false);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public void clearFilesIfNeed() {
        File r10 = this.mReportDir;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mLogDir == null) goto L26;
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length < 15) goto L28;
        Arrays.sort(r11, new AnonymousClass2(this));     // Catch: Throwable -> L20
        int r12 = 0;
    L13:
        if (r12 >= (r11.length - 15)) goto L30;
        File r13 = r11[r12];     // Catch: Throwable -> L20
        if (this.mLogDir.equals(r13.getAbsolutePath()) == true) goto L18;
        FileUtils.deleteFile(r13);     // Catch: Throwable -> L20
    L18:
        r12 = r12 + 1;
        goto L13
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public void dumpHeader() {
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mLogDir == null) goto L27;
        File r11 = new File(this.mLogDir, "summary.json");
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        if (r10.getVersionCode() != 0) goto L11;
    L13:
        r13.put("channel", r10.getChannel());     // Catch: Throwable -> L22
        r13.put("os_api", RomInfoHelper.getOsApiLevel());     // Catch: Throwable -> L22
        r13.put("os_version", RomInfoHelper.getOsVersion());     // Catch: Throwable -> L22
        r13.put(AppInfo.KEY_NPTH_VERSION_NAME, NpthBuildConfig.VERSION_NAME);     // Catch: Throwable -> L22
        r13.put("sdk_version", 4020254);     // Catch: Throwable -> L22
        r13.put("app_start_time", Global.getAppStartTime());     // Catch: Throwable -> L22
        if (NativeBridge.is64BitRuntime() == false) goto L16;
        String r15 = "true";
    L17:
        r14.put("is_64_runtime", r15);     // Catch: Throwable -> L22
        r14.put("sdk_version", NpthBuildConfig.VERSION_NAME);     // Catch: Throwable -> L22
        r12.put("header", r13);     // Catch: Throwable -> L22
        r12.put("filters", r14);     // Catch: Throwable -> L22
        goto L19
    L16:
        r15 = "false";
        goto L17
    L11:
        if (TextUtils.isEmpty(r10.getVersionName()) == true) goto L13;
        r13.put("version_code", r10.getVersionCode());     // Catch: Throwable -> L22
        r13.put("update_version_code", r10.getUpdateVersionCode());     // Catch: Throwable -> L22
        r13.put("version_name", r10.getVersionName());     // Catch: Throwable -> L22
        r13.put("app_version", r10.getVersionName());     // Catch: Throwable -> L22
        r13.put("manifest_version_code", r10.getManifestVersionCode());     // Catch: Throwable -> L22
    L19:
        if (r12.length() <= 0) goto L26;
        FileSystemUtils.writeFile(r11, r12.toString());
        return;
    L26:
        return;
    }

    protected void executeMonitor() {
    }

    protected boolean initBeforeExecute() {
        return true;
    }

    protected boolean initBeforeSoLoad() {
        return true;
    }

    protected void startMonitor(ResourceMonitorConfig r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (initMonitor(r10) == true) goto L7;
        return;
    L7:
        if (initBeforeExecute() == false) goto L14;
        this.mGuardFile.deleteGurardFile();
        if (r10.getResourceType() == 4) goto L11;
        DefaultWorkThread.post(new AnonymousClass1(this));
        dumpHeader();
    L11:
        executeMonitor();
        return;
    }
}
