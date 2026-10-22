package com.bytedance.crash.crash;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
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

    protected CrashSummary(File r10, CrashType r11, long r12, long r13, long r14, String r15, String r16, int r17, int r18) {
        this.mDirectory = r10;
        this.mCrashType = r11;
        this.mStartTime = r12;
        this.sAppStartUpTime = r13;
        this.mCrashTime = r14;
        this.mProcessName = r15;
        this.mThreadName = r16;
        this.mPid = r17;
        this.mTid = r18;
    }

    private void afterUpload(JSONObject r10, boolean r11, boolean r12) {
        if (r11 == true) goto L9;
    L4:
        if (r11 == true) goto L6;
        if (r12 == true) goto L6;
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

    private static void assemblyCrashBodyAfterFilter(JSONObject r10, File r11) {
        NativeBridge.parseSmaps(r11.getAbsolutePath());
        MemoryInfo.packTaggedMapsSize(r10, r11);
    }

    private boolean beforeUpload(@NonNull AppMonitor r10, JSONObject r11) {
        if (r10.getUserDataCenter().beforeUpload(this.mCrashType, r11) == false) goto L6;
        return true;
    L6:
        JSONObject r12 = getOriginalBody(r11);
        CrashAgent.monitorCrash(this.mCrashType, this.mCrashTime, r12);
        JSONObject r13 = r11.optJSONObject("header");
        NpthCheckUtils.checkUploadData(this.mCrashType, this.mDirectory, r12, r13);
        return false;
    }

    private void deleteDirectory() {
        NpthLog.i("delete directory=" + this.mDirectory.getAbsolutePath());
        FileSystemUtils.deleteAll(this.mDirectory);
        if (this.mDirectory.exists() == false) goto L6;
        FileSystemUtils.createFile(this.mDirectory, UPLOAD_STATE);
        return;
    }

    @Nullable
    public static CrashSummary loadFromDirectory(File r10) {
        File[] r11 = r10.listFiles(new AnonymousClass3());
        if (r11 != null) goto L5;
        return null;
    L5:
        ArrayList r12 = new ArrayList();
        int r13 = r11.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L15;
        File r15 = r11[r14];
        NativeCrashSummary r16 = NativeCrashSummary.load(r15);
        if (r16 == null) goto L10;
        r12.add(r16);
    L10:
        JavaCrashSummary r17 = JavaCrashSummary.load(r15);
        if (r17 == null) goto L13;
        r12.add(r17);
    L13:
        r14 = r14 + 1;
        goto L6
    L15:
        if (r12.isEmpty() == false) goto L17;
        return null;
    L17:
        Collections.sort(r12, new AnonymousClass4());
        return (CrashSummary) r12.get(0);
    }

    @Nullable
    public static CrashSummary loadFromDirectory(File r10, boolean r11) {
        File[] r12 = r10.listFiles(new AnonymousClass1());
        if (r12 != null) goto L5;
        return null;
    L5:
        ArrayList r13 = new ArrayList();
        int r14 = r12.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L17;
        File r16 = r12[r15];
        if (r11 == false) goto L12;
        Object r17 = NativeCrashSummary.load(r16);
        if (r17 == null) goto L15;
    L14:
        r13.add(r17);
    L15:
        r15 = r15 + 1;
        goto L6
    L12:
        r17 = JavaCrashSummary.load(r16);
        if (r17 == null) goto L15;
    L17:
        if (r13.isEmpty() == false) goto L19;
        return null;
    L19:
        Collections.sort(r13, new AnonymousClass2());
        return (CrashSummary) r13.get(0);
    }

    private void setInnerAid(@NonNull JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("header");
        JSONObject r12 = r10.optJSONObject("filters");
        if (r11 == null) goto L5;
        String r13 = String.valueOf(r11.opt("aid"));
    L6:
        JSONUtils.put(r12, "aid", r13);
        JSONUtils.put(r11, "aid", 2010);
        return;
    L5:
        r13 = "";
        goto L6
    }

    protected abstract void appendSpecialFilter(JSONObject r10);

    public CrashBody assemblyCrashBody(@NonNull AppMonitor r10) {
        Header r11 = Header.createCrashHeader(r10, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
        CrashBody r12 = new CrashBody();
        r12.put("pid", Integer.valueOf(this.mPid));     // Catch: Throwable -> L5
        r12.put(CrashBody.TID, Integer.valueOf(this.mTid));     // Catch: Throwable -> L5
        r12.put("crash_time", Long.valueOf(this.mCrashTime));     // Catch: Throwable -> L5
        r12.put(CrashBody.CRASH_THREAD_NAME, this.mThreadName);     // Catch: Throwable -> L5
        r12.put("process_name", this.mProcessName);     // Catch: Throwable -> L5
        r12.put("app_start_time", Long.valueOf(this.mStartTime));     // Catch: Throwable -> L5
        r12.put(CrashBody.APP_START_UP_TIME, Long.valueOf(this.sAppStartUpTime));     // Catch: Throwable -> L5
        r12.put(Constants.KEY_HW_JIFFIES, Long.valueOf(r11.getJiffy()));     // Catch: Throwable -> L5
        r12.put(Constants.HAS_DUMP, "true");     // Catch: Throwable -> L5
        JSONUtils.put(r12.getJson(), "business", Global.getBusiness());     // Catch: Throwable -> L5
        r12.put("data", this.mStackTrace);     // Catch: Throwable -> L5
        r12.put("crash_md5", Digest.getMD5(this.mStackTrace));     // Catch: Throwable -> L5
        r12.put(CrashBody.LAUNCH_MODE, Integer.valueOf(ActivityLifecycle.getLaunchMode()));     // Catch: Throwable -> L5
        r12.put(CrashBody.LAUNCH_TIME, Long.valueOf(ActivityLifecycle.getLaunchTime()));     // Catch: Throwable -> L5
        r12.put("session_id", r11.getJson().opt("session_id"));     // Catch: Throwable -> L5
        loadCrashInfo(r12.getJson(), r11.getJson(), this.mDirectory);     // Catch: Throwable -> L5
        CrashFilter.appendCommonFilter(r11.getJson(), r12.getJson(), this.mDirectory);     // Catch: Throwable -> L5
        assemblyCrashBodyAfterFilter(r12.getJson(), this.mDirectory);     // Catch: Throwable -> L5
        assemblySpecialCrashBody(r12, r11);     // Catch: Throwable -> L5
        appendSpecialFilter(r12.getJson());     // Catch: Throwable -> L5
    L8:
        return r12.setHeader(r11);
    L5:
        th = move-exception;
        NpthLog.i(th);
        NpthMonitor.reportInnerException(th);
        goto L8
    }

    public Header assemblyCrashHeader(@NonNull AppMonitor r10) {
        return Header.createCrashHeader(r10, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
    }

    protected abstract void assemblySpecialCrashBody(CrashBody r10, Header r11);

    boolean checkIfNeedUpload() {
        File r10 = new File(this.mDirectory, UPLOAD_STATE);
        int r11 = 0;
        if (r10.exists() == false) goto L24;
        FileInputStream r12 = new FileInputStream(r10);     // Catch: Exception -> L7
        int r13 = r12.read();     // Catch: Exception -> L7
        r12.close();     // Catch: Exception -> L18
    L9:
        if (r13 < 0) goto L13;
        if (r13 >= 2) goto L13;
        r11 = r13 + 1;
    L13:
        if (r13 < 2) goto L15;
        NpthMonitor.reportInnerException("upload failed, retry count is" + r13 + ".", new Exception());
    L15:
        return false;
    L7:
        r13 = 0;
    L24:
        FileOutputStream r14 = new FileOutputStream(r10);     // Catch: Exception -> L19
        r14.write(r11);     // Catch: Exception -> L19
        r14.close();     // Catch: Exception -> L19
    L17:
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r10) {
        long r11 = this.mCrashTime - ((CrashSummary) r10).mCrashTime;
        if (r11 <= 0) goto L5;
        return -1;
    L5:
        if (r11 >= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    @NonNull
    List<File> getAttachmentFileList() {
        ArrayList r10 = new ArrayList();
        File[] r11 = this.mDirectory.listFiles();
        if (r11 == null) goto L15;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L15;
        File r14 = r11[r13];
        String r15 = r14.getName();
        if (r15.endsWith(SUFFIX) == true) goto L14;
        if (r15.endsWith(".json") == true) goto L14;
        if (r15.endsWith(".inf") == true) goto L14;
        r10.add(r14);
    L14:
        r13 = r13 + 1;
    L15:
        return r10;
    }

    public long getCrashTime() {
        return this.mCrashTime;
    }

    public CrashType getCrashType() {
        return this.mCrashType;
    }

    protected JSONObject getOriginalBody(JSONObject r10) {
        return r10;
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

    protected void loadCrashInfo(JSONObject r10, JSONObject r11, File r12) {
        CrashDumper.loadCrashInfo(r10, r11, r12);
    }

    @NonNull
    protected abstract String loadStackTrace();

    public boolean upload(@NonNull AppMonitor r10, JSONObject r11) {
        boolean r12 = false;
        if (checkIfNeedUpload() == true) goto L6;
        deleteDirectory();
        return false;
    L6:
        File r13 = new File(this.mDirectory, "upload.json");
        String r14 = FileSystemUtils.readUtf8File(r13);
        JSONObject r15 = null;
        if (r14 != null) goto L39;
        JSONObject r16 = null;
    L14:
        if (r15 == null) goto L41;
        if (r16 == null) goto L41;
        boolean r17 = false;
    L22:
        boolean r18 = beforeUpload(r10, r15);     // Catch: Throwable -> L31
        if (r18 == false) goto L37;
    L34:
        afterUpload(r15, r12, r18);
        NpthLog.i("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + r12);
        return r12;
    L37:
        String r19 = r15.toString();     // Catch: Throwable -> L29
        if (r17 == false) goto L27;
        FileSystemUtils.writeFile(r13, r19);     // Catch: Throwable -> L29
    L27:
        String r20 = UploaderUrl.getUrlByCrashTypeAndHeader(this.mCrashType, r16);     // Catch: Throwable -> L29
        NpthLog.i("uploadOne: " + this.mCrashType + " :" + r20);     // Catch: Throwable -> L29
        r12 = CrashUploader.uploadCrashLogWithAttachment(this.mCrashType.getName(), r20, r19, getAttachmentFileList()).isSuccess();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        boolean r21 = r18;
        th = th;
    L33:
        NpthLog.w(th);
        NpthMonitor.reportInnerException("upload exception", th);
        r18 = r21;
    L31:
        th = th;
        r21 = false;
    L41:
        CrashBody r22 = assemblyCrashBody(r10);     // Catch: Throwable -> L31
        r15 = r22.getJson();     // Catch: Throwable -> L31
        r16 = r22.getHeaderJson();     // Catch: Throwable -> L31
        JSONObject r23 = JSONUtils.get(r15, "filters");     // Catch: Throwable -> L31
        if (r11 == null) goto L21;
        JSONUtils.combineJson(r23, r11);     // Catch: Throwable -> L31
    L21:
        r17 = true;
        goto L22
    L39:
        JSONObject r24 = new JSONObject(r14);     // Catch: JSONException -> L11
        r15 = r24.optJSONObject("header");     // Catch: JSONException -> L36
    L12:
        r16 = r15;
        r15 = r24;
    L11:
        r24 = null;
        goto L12
    }
}
