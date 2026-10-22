package com.bytedance.crash.crash;

import com.bytedance.crash.CrashAgent;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.CrashFilter;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploadHandler;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CrashSummary implements Comparable {
    protected static final String SUFFIX = ".summary";
    private static final String UPLOAD_STATE = "upload_state.inf";
    protected final long mCrashTime;
    protected final CrashType mCrashType;
    protected final File mDirectory;
    protected final int mPid;
    protected final String mProcessName;
    protected String mStackTrace;
    protected final long mStartTime;
    protected final String mThreadName;
    protected final int mTid;
    protected final long sAppStartUpTime;

    public CrashSummary(File r1, CrashType r2, long r3, long r5, long r7, String r9, String r10, int r11, int r12) {
        this.mDirectory = r1;
        this.mCrashType = r2;
        this.mStartTime = r3;
        this.sAppStartUpTime = r5;
        this.mCrashTime = r7;
        this.mProcessName = r9;
        this.mThreadName = r10;
        this.mPid = r11;
        this.mTid = r12;
    }

    private void afterUpload(JSONObject r7, boolean r8, boolean r9) {
        if (r8 == true) goto L9;
    L4:
        if (r8 == true) goto L6;
        if (r9 == true) goto L6;
        return;
    L6:
        deleteDirectory();     // Catch: Throwable -> L8
        CoredumpAdapter.deleteCoreDir();     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L9:
        AlogManager.record(this.mProcessName, this.mStartTime, this.mCrashTime, this.mCrashType);     // Catch: Throwable -> L8
        CrashUploadHandler.afterUploadOne(this.mCrashType);     // Catch: Throwable -> L8
        goto L4
    }

    private static void assemblyCrashBodyAfterFilter(JSONObject r1, File r2) {
        NativeBridge.parseSmaps(r2.getAbsolutePath());
        MemoryInfo.packTaggedMapsSize(r1, r2);
    }

    private boolean beforeUpload(AppMonitor r4, JSONObject r5) {
        if (r4.getUserDataCenter().beforeUpload(this.mCrashType, r5) == false) goto L6;
        return true;
    L6:
        JSONObject r6 = getOriginalBody(r5);
        CrashAgent.monitorCrash(this.mCrashType, this.mCrashTime, r6);
        JSONObject r7 = r5.optJSONObject("header");
        NpthCheckUtils.checkUploadData(this.mCrashType, this.mDirectory, r6, r7);
        return false;
    }

    private void deleteDirectory() {
        NpthLog.i("delete directory=" + this.mDirectory.getAbsolutePath());
        FileSystemUtils.deleteAll(this.mDirectory);
        if (this.mDirectory.exists() == false) goto L6;
        FileSystemUtils.createFile(this.mDirectory, UPLOAD_STATE);
        return;
    }

    public static CrashSummary loadFromDirectory(File r7) {
        File[] r8 = r7.listFiles(new AnonymousClass3());
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L15;
        File r5 = r8[r4];
        NativeCrashSummary r6 = NativeCrashSummary.load(r5);
        if (r6 == null) goto L10;
        r1.add(r6);
    L10:
        JavaCrashSummary r9 = JavaCrashSummary.load(r5);
        if (r9 == null) goto L13;
        r1.add(r9);
    L13:
        r4 = r4 + 1;
        goto L6
    L15:
        if (r1.isEmpty() == false) goto L17;
        return null;
    L17:
        Collections.sort(r1, new AnonymousClass4());
        return (CrashSummary) ZeusTransformUtils.preCheckCast(r1.get(0), CrashSummary.class, "com.obric.memorydata.plugin");
    }

    public static CrashSummary loadFromDirectory(File r6, boolean r7) {
        File[] r8 = r6.listFiles(new AnonymousClass1());
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L17;
        File r5 = r8[r4];
        if (r7 == false) goto L12;
        Object r9 = NativeCrashSummary.load(r5);
        if (r9 == null) goto L15;
    L14:
        r1.add(r9);
    L15:
        r4 = r4 + 1;
        goto L6
    L12:
        r9 = JavaCrashSummary.load(r5);
        if (r9 == null) goto L15;
    L17:
        if (r1.isEmpty() == false) goto L19;
        return null;
    L19:
        Collections.sort(r1, new AnonymousClass2());
        return (CrashSummary) ZeusTransformUtils.preCheckCast(r1.get(0), CrashSummary.class, "com.obric.memorydata.plugin");
    }

    private void setInnerAid(JSONObject r3) {
        JSONObject r2 = r3.optJSONObject("header");
        JSONObject r4 = r3.optJSONObject("filters");
        if (r2 == null) goto L5;
        String r1 = String.valueOf(r2.opt("aid"));
    L6:
        JSONUtils.put(r4, "aid", r1);
        JSONUtils.put(r2, "aid", 2010);
        return;
    L5:
        r1 = "";
        goto L6
    }

    public abstract void appendSpecialFilter(JSONObject r1);

    public CrashBody assemblyCrashBody(AppMonitor r10) {
        Header r11 = Header.createCrashHeader(r10, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
        CrashBody r1 = new CrashBody();
        r1.put(CrashBody.PID, Integer.valueOf(this.mPid));     // Catch: Throwable -> L5
        r1.put(CrashBody.TID, Integer.valueOf(this.mTid));     // Catch: Throwable -> L5
        r1.put("crash_time", Long.valueOf(this.mCrashTime));     // Catch: Throwable -> L5
        r1.put(CrashBody.CRASH_THREAD_NAME, this.mThreadName);     // Catch: Throwable -> L5
        r1.put("process_name", this.mProcessName);     // Catch: Throwable -> L5
        r1.put("app_start_time", Long.valueOf(this.mStartTime));     // Catch: Throwable -> L5
        r1.put(CrashBody.APP_START_UP_TIME, Long.valueOf(this.sAppStartUpTime));     // Catch: Throwable -> L5
        r1.put(Constants.KEY_HW_JIFFIES, Long.valueOf(r11.getJiffy()));     // Catch: Throwable -> L5
        r1.put(Constants.HAS_DUMP, "true");     // Catch: Throwable -> L5
        JSONUtils.put(r1.getJson(), "business", Global.getBusiness());     // Catch: Throwable -> L5
        r1.put("data", this.mStackTrace);     // Catch: Throwable -> L5
        r1.put("crash_md5", Digest.getMD5(this.mStackTrace));     // Catch: Throwable -> L5
        r1.put(CrashBody.LAUNCH_MODE, Integer.valueOf(ActivityLifecycle.getLaunchMode()));     // Catch: Throwable -> L5
        r1.put(CrashBody.LAUNCH_TIME, Long.valueOf(ActivityLifecycle.getLaunchTime()));     // Catch: Throwable -> L5
        r1.put("session_id", r11.getJson().opt("session_id"));     // Catch: Throwable -> L5
        loadCrashInfo(r1.getJson(), r11.getJson(), this.mDirectory);     // Catch: Throwable -> L5
        CrashFilter.appendCommonFilter(r11.getJson(), r1.getJson(), this.mDirectory);     // Catch: Throwable -> L5
        assemblyCrashBodyAfterFilter(r1.getJson(), this.mDirectory);     // Catch: Throwable -> L5
        assemblySpecialCrashBody(r1, r11);     // Catch: Throwable -> L5
        appendSpecialFilter(r1.getJson());     // Catch: Throwable -> L5
    L8:
        return r1.setHeader(r11);
    L5:
        th = move-exception;
        NpthLog.i(th);
        NpthMonitor.reportInnerException(th);
        goto L8
    }

    public Header assemblyCrashHeader(AppMonitor r9) {
        return Header.createCrashHeader(r9, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
    }

    public abstract void assemblySpecialCrashBody(CrashBody r1, Header r2);

    boolean checkIfNeedUpload() {
        File r0 = new File(this.mDirectory, UPLOAD_STATE);
        int r2 = 0;
        if (r0.exists() == false) goto L24;
        FileInputStream r4 = new FileInputStream(r0);     // Catch: Exception -> L7
        int r3 = r4.read();     // Catch: Exception -> L7
        r4.close();     // Catch: Exception -> L18
    L9:
        if (r3 < 0) goto L13;
        if (r3 >= 2) goto L13;
        r2 = r3 + 1;
    L13:
        if (r3 < 2) goto L15;
        NpthMonitor.reportInnerException("upload failed, retry count is" + r3 + ".", new Exception());
    L15:
        return false;
    L7:
        r3 = 0;
    L24:
        FileOutputStream r5 = new FileOutputStream(r0);     // Catch: Exception -> L19
        r5.write(r2);     // Catch: Exception -> L19
        r5.close();     // Catch: Exception -> L19
    L17:
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r4) {
        long r0 = this.mCrashTime - ((CrashSummary) ZeusTransformUtils.preCheckCast(r4, CrashSummary.class, "com.obric.memorydata.plugin")).mCrashTime;
        if (r0 <= 0) goto L5;
        return -1;
    L5:
        if (r0 >= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    List<File> getAttachmentFileList() {
        ArrayList r0 = new ArrayList();
        File[] r6 = this.mDirectory.listFiles();
        if (r6 == null) goto L15;
        int r1 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        File r3 = r6[r2];
        String r4 = r3.getName();
        if (r4.endsWith(SUFFIX) == true) goto L14;
        if (r4.endsWith(".json") == true) goto L14;
        if (r4.endsWith(".inf") == true) goto L14;
        r0.add(r3);
    L14:
        r2 = r2 + 1;
    L15:
        return r0;
    }

    public long getCrashTime() {
        return this.mCrashTime;
    }

    public CrashType getCrashType() {
        return this.mCrashType;
    }

    public JSONObject getOriginalBody(JSONObject r1) {
        return r1;
    }

    public int getPid() {
        return this.mPid;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public int getTid() {
        return this.mTid;
    }

    public void loadCrashInfo(JSONObject r1, JSONObject r2, File r3) {
        CrashDumper.loadCrashInfo(r1, r2, r3);
    }

    public abstract String loadStackTrace();

    public boolean upload(AppMonitor r7, JSONObject r8) {
        boolean r1 = false;
        if (checkIfNeedUpload() == true) goto L6;
        deleteDirectory();
        return false;
    L6:
        File r0 = new File(this.mDirectory, "upload.json");
        String r2 = FileSystemUtils.readUtf8File(r0);
        JSONObject r3 = null;
        if (r2 != null) goto L39;
        JSONObject r4 = null;
    L14:
        if (r3 == null) goto L43;
        if (r4 == null) goto L43;
        boolean r9 = false;
    L22:
        boolean r10 = beforeUpload(r7, r3);     // Catch: Throwable -> L31
        if (r10 == false) goto L37;
    L34:
        afterUpload(r3, r1, r10);
        NpthLog.i("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + r1);
        return r1;
    L37:
        String r5 = r3.toString();     // Catch: Throwable -> L29
        if (r9 == false) goto L27;
        FileSystemUtils.writeFile(r0, r5);     // Catch: Throwable -> L29
    L27:
        String r11 = UploaderUrl.getUrlByCrashTypeAndHeader(this.mCrashType, r4);     // Catch: Throwable -> L29
        NpthLog.i("uploadOne: " + this.mCrashType + " :" + r11);     // Catch: Throwable -> L29
        r1 = CrashUploader.uploadCrashLogWithAttachment(this.mCrashType.getName(), r11, r5, getAttachmentFileList()).isSuccess();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        boolean r12 = r10;
        th = th;
    L33:
        NpthLog.w(th);
        NpthMonitor.reportInnerException("upload exception", th);
        r10 = r12;
    L31:
        th = th;
        r12 = false;
    L43:
        CrashBody r6 = assemblyCrashBody(r7);     // Catch: Throwable -> L31
        r3 = r6.getJson();     // Catch: Throwable -> L31
        r4 = r6.getHeaderJson();     // Catch: Throwable -> L31
        JSONObject r13 = JSONUtils.get(r3, "filters");     // Catch: Throwable -> L31
        if (r8 == null) goto L21;
        JSONUtils.combineJson(r13, r8);     // Catch: Throwable -> L31
    L21:
        r9 = true;
        goto L22
    L39:
        JSONObject r14 = new JSONObject(r2);     // Catch: JSONException -> L11
        r3 = r14.optJSONObject("header");     // Catch: JSONException -> L36
    L12:
        r4 = r3;
        r3 = r14;
    L11:
        r14 = null;
        goto L12
    }
}
