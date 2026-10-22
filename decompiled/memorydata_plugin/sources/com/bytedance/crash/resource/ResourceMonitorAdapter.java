package com.bytedance.crash.resource;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
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
import com.obric.oui.texteffects.preset.AnimatedCharacterSpanPerformanceScenario;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

        public ResourceMonitorUploader(AppMonitor r1, File r2) {
            this.mMonitor = r1;
            this.mReportDir = r2;
            this.mIgnorePath = r2.getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();
        }

        static /* synthetic */ void access$000(ResourceMonitorUploader r0, EnsureReportData r1, File r2, UploaderData r3) {
            r0.nativeCustomizeExceptionUploadInner(r1, r2, r3);
        }

        public static String buildIDToUUID(String r4) {
            StringBuilder r0 = new StringBuilder();
            if (r4.length() >= 16) goto L6;
            r0.append(r4);     // Catch: Throwable -> L11
        L12:
            goto L10
        L6:
            r0.append(r4.charAt(6));     // Catch: Throwable -> L11
            r0.append(r4.charAt(7));     // Catch: Throwable -> L11
            r0.append(r4.charAt(4));     // Catch: Throwable -> L11
            r0.append(r4.charAt(5));     // Catch: Throwable -> L11
            r0.append(r4.charAt(2));     // Catch: Throwable -> L11
            r0.append(r4.charAt(3));     // Catch: Throwable -> L11
            r0.append(r4.charAt(0));     // Catch: Throwable -> L11
            r0.append(r4.charAt(1));     // Catch: Throwable -> L11
            r0.append(r4.charAt(10));     // Catch: Throwable -> L11
            r0.append(r4.charAt(11));     // Catch: Throwable -> L11
            r0.append(r4.charAt(8));     // Catch: Throwable -> L11
            r0.append(r4.charAt(9));     // Catch: Throwable -> L11
            r0.append(r4.charAt(14));     // Catch: Throwable -> L11
            r0.append(r4.charAt(15));     // Catch: Throwable -> L11
            r0.append(r4.charAt(12));     // Catch: Throwable -> L11
            r0.append(r4.charAt(13));     // Catch: Throwable -> L11
            if (r4.length() < 32) goto L12;
            r0.append(r4, 16, 32);     // Catch: Throwable -> L11
            r0.append('0');     // Catch: Throwable -> L11
        L10:
            return r0.toString().toUpperCase();
        }

        public static int getLineIndex(JSONArray r1, int r2, String r3) {
        L3:
            if (r2 >= r1.length()) goto L10;
            String r0 = r1.optString(r2, null);
            if (r0 == null) goto L9;
            if (r0.startsWith(r3) == false) goto L9;
            return r2;
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            return -1;
        }

        public static String getSizeRange(String r2, String r3) {
            if (r2 != null) goto L5;
            return "other";
        L5:
            if (r3 != null) goto L7;
        L8:
            r3 = "B";
        L9:
            r3.hashCode();
            if (r3.equals("GB") == false) goto L12;
            return "1GB+";
        L12:
            if (r3.equals("MB") == true) goto L33;
            return "0~1MB";
        L33:
            int r4 = Integer.parseInt(r2.substring(0, r2.indexOf(46)));     // Catch: Throwable -> L30
            if (r4 >= 200) goto L21;
            return "0~200MB";
        L21:
            if (r4 >= 500) goto L25;
            return "200~500MB";
        L25:
            if (r4 >= 800) goto L28;
            return "500~800MB";
        L28:
            return "800~1024MB(1G)";
        L30:
            return "other";
        L7:
            if (r3.length() != 0) goto L9;
            goto L8
        }

        public static String getSizeRangeMB(long r3) {
            if (r3 > 350) goto L6;
            return "~350MB";
        L6:
            if (r3 <= 350) goto L11;
            if (r3 > 450) goto L11;
            return "350MB~450MB";
        L11:
            if (r3 <= 450) goto L16;
            if (r3 > 550) goto L16;
            return "450MB~550MB";
        L16:
            if (r3 <= 550) goto L21;
            if (r3 > 650) goto L21;
            return "550MB~650MB";
        L21:
            if (r3 <= 650) goto L26;
            if (r3 > 750) goto L26;
            return "650MB~750MB";
        L26:
            if (r3 <= 750) goto L31;
            if (r3 > 850) goto L31;
            return "750MB~850MB";
        L31:
            if (r3 <= 850) goto L36;
            if (r3 > 950) goto L36;
            return "850MB~950MB";
        L36:
            if (r3 <= 950) goto L41;
            if (r3 > 1050) goto L41;
            return "950MB~1050MB";
        L41:
            if (r3 <= 1050) goto L46;
            if (r3 > AnimatedCharacterSpanPerformanceScenario.DurationMs) goto L46;
            return "1050MB~1250MB";
        L46:
            if (r3 <= AnimatedCharacterSpanPerformanceScenario.DurationMs) goto L51;
            if (r3 > 1450) goto L51;
            return "1250MB~1450MB";
        L51:
            if (r3 <= 1450) goto L56;
            if (r3 > 1650) goto L56;
            return "1450MB~1650MB";
        L56:
            if (r3 <= 1650) goto L61;
            if (r3 > 1850) goto L61;
            return "1650MB~1850MB";
        L61:
            if (r3 > 1850) goto L63;
        L65:
            return ">2.3G";
        L63:
            if (r3 > 2050) goto L65;
            return "1850MB~2050MB";
        }

        private void nativeCustomizeExceptionUpload(final File r10, Map<String, String> r11, final UploaderData r12) {
            Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
            AppMonitor r13 = this.mMonitor;
            if (r13 != null) goto L5;
            return;
        L5:
            if (r13.getEnsureDeliver() != null) goto L8;
            return;
        L8:
            if (r12.mPid != 0) goto L10;
            r12.mPid = Process.myPid();
        L10:
            final EnsureReportData r14 = new EnsureReportData(r12.mJavaStack, r12.mNativeStack, r12.mAbortLine, r4, r12.mThreadName, "1", "native_exception", (int) r12.mPid);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) goto L13;
            nativeCustomizeExceptionUploadInner(r14, r10, r12);
            return;
        L13:
            DefaultWorkThread.post(new AnonymousClass1(this, r14, r10, r12));
        }

        private void nativeCustomizeExceptionUploadInner(EnsureReportData r7, File r8, UploaderData r9) {
            JSONObject r0 = Header.createEventHeader(this.mMonitor, System.currentTimeMillis(), CrashType.NATIVE_CUSTOMIZE, (int) r9.mPid).getJson();     // Catch: Exception -> L7
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L7
            JSONArray r2 = new JSONArray();     // Catch: Exception -> L7
            JSONObject r10 = r7.toJsonObject(this.mMonitor);     // Catch: Exception -> L7
            r2.put(r10);     // Catch: Exception -> L7
            r1.put("data", r2);     // Catch: Exception -> L7
            r1.put(CrashBody.CRASH_LIB_UUID, r9.mSoUUID);     // Catch: Exception -> L7
            JSONUtils.combineJson(r1, r9.extraDataInBody);     // Catch: Exception -> L7
            r1.put("header", r0);     // Catch: Exception -> L7
            updateHeader(r8, r0, r10);     // Catch: Exception -> L7
            if (CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r0), r1.toString(), new File[]{r8}) == false) goto L10;
            NpthLog.d("ResourceMonitorUploader: upload success");     // Catch: Exception -> L7
            FileUtils.deleteFile(r8);     // Catch: Exception -> L7
            return;
        L10:
            return;
        }

        public void packFilterData(Map<String, String> r2, UploaderData r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L8;
            if (r3 == null) goto L9;
            r1.putAll(r3.filterData);
            return;
        L9:
            return;
        }

        public abstract boolean parseReport(File r1, UploaderData r2);

        public void updateHeader(File r6, JSONObject r7, JSONObject r8) {
            File r0 = new File(r6, "summary.json");
            File r1 = new File(r6, "crash_time");
            String r9 = FileSystemUtils.readUtf8File(r0);
            String r2 = FileSystemUtils.readUtf8File(r1);
            JSONObject r3 = r8.optJSONObject("filters");
            if (r9 != null) goto L9;
        L5:
            if (r2 == null) goto L11;
            long r5 = Long.parseLong(r2) * 1000;     // Catch: Throwable -> L8
            r8.put("crash_time", r5);     // Catch: Throwable -> L8
            r8.put("timestamp", r5);     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L11:
            return;
        L9:
            JSONObject r4 = new JSONObject(r9);     // Catch: Throwable -> L8
            JSONUtils.combineJson(r7, r4.optJSONObject("header"));     // Catch: Throwable -> L8
            JSONUtils.combineJson(r3, r4.optJSONObject("filters"));     // Catch: Throwable -> L8
            r8.put("app_start_time", r7.opt("app_start_time"));     // Catch: Throwable -> L8
            goto L5
        }

        public void uploadAll() {
            File[] r0 = this.mReportDir.listFiles();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L6:
            if (r2 >= r1) goto L32;
            File r4 = r0[r2];
            if (this.mIgnorePath.equals(r4.getAbsolutePath()) == true) goto L31;
            if (r4.isFile() == true) goto L31;
            if (FileUtils.isEmpty(r4) == true) goto L30;
            int r5 = r3 + 1;
            if (r3 < 10) goto L17;
            r3 = r5;
            goto L30
        L17:
            UploaderData r6 = new UploaderData();
            HashMap r7 = new HashMap();
            if (parseReport(r4, r6) == false) goto L21;
            packFilterData(r7, r6);     // Catch: Throwable -> L23
            NativeBridge.parseSmaps(r4.getAbsolutePath());     // Catch: Throwable -> L23
            nativeCustomizeExceptionUpload(r4, r7, r6);     // Catch: Throwable -> L23
        L22:
            FileUtils.deleteFile(r4);
            r3 = r5;
            goto L31
        L21:
            FileUtils.deleteFile(r4);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            NpthLog.e(TAG, "upload exception:" + th);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            FileUtils.deleteFile(r4);
            throw th;
        L30:
            FileUtils.deleteFile(r4);
        L31:
            r2 = r2 + 1;
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
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L7;
        return "unknown";
    L7:
        return String.valueOf(r0.getVersionCode());
    }

    private synchronized boolean initMonitor(ResourceMonitorConfig r10) {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (this.mHasInited == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.mHasInited = true;     // Catch: Throwable -> L51
        if (Build.VERSION.SDK_INT >= r10.getmApiLevelMin()) goto L12;
    L48:
        NpthLog.e(TAG, "Unsupported API!!!");     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L12:
        if (Build.VERSION.SDK_INT > r10.getmApiLevelMax()) goto L48;
        this.mConfigDir = Global.getConfigDir();     // Catch: Throwable -> L51
        File r2 = r10.getReportDir();     // Catch: Throwable -> L51
        this.mReportDir = r2;     // Catch: Throwable -> L51
        if (r2 != null) goto L17;
    L45:
        NpthLog.e(TAG, "cannot create " + this.mReportDir);     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L17:
        if (r2.exists() == false) goto L19;
    L21:
        this.mLogDir = this.mReportDir.getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();     // Catch: Throwable -> L51
        GuardFile r3 = new GuardFile(this.mReportDir.getAbsolutePath(), r10.getGuardFileName(), GuardFile.DEFAULT_EXPIRE_TIME);     // Catch: Throwable -> L51
        this.mGuardFile = r3;     // Catch: Throwable -> L51
        if (r3.checkGuardFile() == true) goto L26;
        monitor-exit(this);
        return false;
    L26:
        if (initBeforeSoLoad() == true) goto L29;
        monitor-exit(this);
        return false;
    L29:
        writeConfig(r10);     // Catch: Throwable -> L51
        if (loadLibrary(r10) == true) goto L54;
        NpthLog.i(TAG, "loadLibrary() failed!");     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L54:
    L41:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return false;
    L35:
        if (this.mConfigDir == null) goto L43;
        if (NativeResourceMonitor.LoadNativeBridgeSoInit(Build.VERSION.SDK_INT, r10.getResourceType(), r10.getFullSoName(), getAppVersion(), this.mLogDir, this.mConfigDir) != 0) goto L39;
        r1 = true;
    L39:
        monitor-exit(this);
        return r1;
    L19:
        if (this.mReportDir.mkdir() == true) goto L21;
        goto L21
    }

    private boolean loadLibrary(ResourceMonitorConfig r4) {
        NpthLog.i(TAG, "loadLibrary...");
        if (this.mSoLoaded == true) goto L6;
        a.a(r4.getLibName(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        this.mSoLoaded = true;     // Catch: Throwable -> L7
    L6:
        return this.mSoLoaded;
    }

    private void writeConfig(ResourceMonitorConfig r4) {
        if (r4 != null) goto L12;
        return;
    L12:
        File r0 = new File(this.mConfigDir, r4.getConfigName());     // Catch: Throwable -> L9
        this.mConfigFile = r0;     // Catch: Throwable -> L9
        if (r0.exists() == true) goto L7;
        this.mConfigFile.createNewFile();     // Catch: Throwable -> L9
    L7:
        NpthLog.e(TAG, "write Config");     // Catch: Throwable -> L9
        FileUtils.writeFile(this.mConfigFile, r4.toString(), false);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public void clearFilesIfNeed() {
        File r0 = this.mReportDir;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mLogDir == null) goto L26;
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.length < 15) goto L28;
        Arrays.sort(r1, new AnonymousClass2(this));     // Catch: Throwable -> L20
        int r2 = 0;
    L13:
        if (r2 >= (r1.length - 15)) goto L30;
        File r3 = r1[r2];     // Catch: Throwable -> L20
        if (this.mLogDir.equals(r3.getAbsolutePath()) == true) goto L18;
        FileUtils.deleteFile(r3);     // Catch: Throwable -> L20
    L18:
        r2 = r2 + 1;
        goto L13
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public void dumpHeader() {
        AppMonitor r1 = MonitorManager.getAppMonitor();
        if (r1 != null) goto L5;
        return;
    L5:
        if (this.mLogDir == null) goto L27;
        File r2 = new File(this.mLogDir, "summary.json");
        JSONObject r9 = new JSONObject();
        JSONObject r3 = new JSONObject();
        JSONObject r4 = new JSONObject();
        if (r1.getVersionCode() != 0) goto L11;
    L13:
        r3.put("channel", r1.getChannel());     // Catch: Throwable -> L22
        r3.put("os_api", RomInfoHelper.getOsApiLevel());     // Catch: Throwable -> L22
        r3.put("os_version", RomInfoHelper.getOsVersion());     // Catch: Throwable -> L22
        r3.put(AppInfo.KEY_NPTH_VERSION_NAME, NpthBuildConfig.VERSION_NAME);     // Catch: Throwable -> L22
        r3.put("sdk_version", 4020254);     // Catch: Throwable -> L22
        r3.put("app_start_time", Global.getAppStartTime());     // Catch: Throwable -> L22
        if (NativeBridge.is64BitRuntime() == false) goto L16;
        String r5 = "true";
    L17:
        r4.put("is_64_runtime", r5);     // Catch: Throwable -> L22
        r4.put("sdk_version", NpthBuildConfig.VERSION_NAME);     // Catch: Throwable -> L22
        r9.put("header", r3);     // Catch: Throwable -> L22
        r9.put("filters", r4);     // Catch: Throwable -> L22
        goto L19
    L16:
        r5 = "false";
        goto L17
    L11:
        if (TextUtils.isEmpty(r1.getVersionName()) == true) goto L13;
        r3.put("version_code", r1.getVersionCode());     // Catch: Throwable -> L22
        r3.put("update_version_code", r1.getUpdateVersionCode());     // Catch: Throwable -> L22
        r3.put("version_name", r1.getVersionName());     // Catch: Throwable -> L22
        r3.put("app_version", r1.getVersionName());     // Catch: Throwable -> L22
        r3.put("manifest_version_code", r1.getManifestVersionCode());     // Catch: Throwable -> L22
    L19:
        if (r9.length() <= 0) goto L26;
        FileSystemUtils.writeFile(r2, r9.toString());
        return;
    L26:
        return;
    }

    public void executeMonitor() {
    }

    public boolean initBeforeExecute() {
        return true;
    }

    public boolean initBeforeSoLoad() {
        return true;
    }

    public void startMonitor(ResourceMonitorConfig r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (initMonitor(r2) == true) goto L7;
        return;
    L7:
        if (initBeforeExecute() == false) goto L14;
        this.mGuardFile.deleteGurardFile();
        if (r2.getResourceType() == 4) goto L11;
        DefaultWorkThread.post(new AnonymousClass1(this));
        dumpHeader();
    L11:
        executeMonitor();
        return;
    }
}
