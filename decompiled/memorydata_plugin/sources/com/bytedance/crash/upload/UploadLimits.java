package com.bytedance.crash.upload;

import com.bytedance.crash.Global;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class UploadLimits {
    private static final String CRASH_ALL = "crash_all";
    private static final String ENSURE_ALL = "ensure_all";
    private static final long ONE_DAY = 86400000;
    private static final String TAG = "UploadLimits";
    private static final String UPLOAD_LIMIT_DIR = "uploadLimits";
    private static final String UPLOAD_LIMIT_FILE = ".times";
    private static volatile boolean isInited;
    private static boolean isNoLimit;
    private static int mCrashAllLimit;
    private static int mCrashStackLimit;
    private static int mEnsureAllLimit;
    private static int mEnsureMsgLimit;
    private static int mEnsureStackLimit;
    private static boolean sCrashLimitCallbackInvoked;
    private static boolean sEnsureLimitCallbackInvoked;
    private static UploadLimits sInstance;
    private static final CrashLimitCallback sLimitCallback = null;
    private long createTime;
    private final File mFile;
    private final HashMap<String, Long> mTimesMap;

    public static class CrashLimitCallback {
        public CrashLimitCallback() {
        }

        static /* synthetic */ void access$000(CrashLimitCallback r0, String r1) {
            r0.onLimitExceed(r1);
        }

        private void onLimitExceed(String r1) {
            onLimitExceed();     // Catch: Throwable -> L4
            return;
        }

        public void onLimitExceed() {
        }
    }

    static {
        sLimitCallback = new CrashLimitCallback();
        mCrashStackLimit = 50;
        mCrashAllLimit = 100;
        mEnsureAllLimit = 100;
        mEnsureStackLimit = 2;
        mEnsureMsgLimit = 5;
        isNoLimit = false;
    }

    private UploadLimits() {
        this.createTime = 0;
        String r0 = App.getProcessName().replace(".", "_").replace(ParameterizedMessage.ERROR_MSG_SEPARATOR, "-") + UPLOAD_LIMIT_FILE;
        File r1 = new File(Global.getRootDirectory(), UPLOAD_LIMIT_DIR);
        FileSystemUtils.createDirectory(r1);
        this.mFile = new File(r1, r0);
        HashMap<String, Long> r2 = readUploadTimesFile();
        this.mTimesMap = r2;
        NpthLog.i(TAG, "upload_times:" + r2);
        isInited = true;
    }

    private static void callCrashLimitListener() {
        if (sCrashLimitCallbackInvoked == true) goto L6;
        sCrashLimitCallbackInvoked = true;
        CrashLimitCallback.access$000(sLimitCallback, CrashManager.DIR_NAME);
        return;
    }

    private static void callEnsureLimitListener() {
        if (sEnsureLimitCallbackInvoked == true) goto L6;
        sEnsureLimitCallbackInvoked = true;
        CrashLimitCallback.access$000(sLimitCallback, "ensure");
        return;
    }

    public static UploadLimits get() {
        if (sInstance != null) goto L15;
        monitor-enter(UploadLimits.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new UploadLimits();     // Catch: Throwable -> L11
    L9:
        monitor-exit(UploadLimits.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static boolean isInited() {
        return isInited;
    }

    private HashMap<String, Long> readUploadTimesFile() {
        HashMap<String, Long> r0 = new HashMap();
        if (this.mFile.exists() == true) goto L22;
        this.createTime = System.currentTimeMillis();
        return r0;
    L22:
        JSONArray r1 = FileUtils.readFileArray(this.mFile);     // Catch: Throwable -> L20
        if (JSONUtils.isEmpty(r1) == false) goto L9;
        return r0;
    L9:
        Long r2 = safeParse(r1.optString(0, null));     // Catch: Throwable -> L20
        if ((System.currentTimeMillis() - r2.longValue()) < 86400000) goto L13;
        NpthLog.i(TAG, "limit file exceed 1 day");     // Catch: Throwable -> L20
        this.createTime = System.currentTimeMillis();     // Catch: Throwable -> L20
        FileUtils.deleteFile(this.mFile);     // Catch: Throwable -> L20
        return r0;
    L13:
        this.createTime = r2.longValue();     // Catch: Throwable -> L20
        int r4 = 1;
    L15:
        if (r4 >= r1.length()) goto L21;
        String[] r5 = r1.optString(r4, "").split(" ");     // Catch: Throwable -> L20
        if (r5.length != 2) goto L19;
        r0.put(r5[0], Long.decode(r5[1]));     // Catch: Throwable -> L20
    L19:
        r4 = r4 + 1;
    L21:
        return r0;
    L20:
        this.createTime = System.currentTimeMillis();
        FileUtils.deleteFile(this.mFile);
        goto L21
    }

    private static Long safeParse(String r2) {
        return Long.decode(r2);
    L5:
        return 0L;
    }

    public static void updateConfig(UploadLimitConfig r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        mCrashStackLimit = r2.getCrashLimitIssue();
        mCrashAllLimit = r2.getCrashLimitAll();
        mEnsureAllLimit = r2.getExceptionAllLimit();
        mEnsureMsgLimit = r2.getExceptionMsgLimit();
        mEnsureStackLimit = r2.getExceptionStackLimit();
        isNoLimit = r2.isNoLimit();
        NpthLog.i(TAG, "updateConfig:" + r2);
    }

    private synchronized void updateTimes(String r6) {
        monitor-enter(this);
        NpthLog.i(TAG, "updateTimes:" + r6);     // Catch: Throwable -> L13
        if (r6 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.mTimesMap.get(r6), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        long r1 = 1;
        if (r0 == null) goto L10;
        r1 = 1 + r0.longValue();     // Catch: Throwable -> L13
    L10:
        this.mTimesMap.put(r6, Long.valueOf(r1));     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean checkCrashLimit(String r6) {
        if (isNoLimit == false) goto L5;
        return false;
    L5:
        String r7 = Digest.getMD5(r6);
        boolean r0 = checkLimit(r7, mCrashStackLimit);
        boolean r2 = checkLimit(CRASH_ALL, mCrashAllLimit);
        if (r0 == true) goto L10;
        if (r2 == true) goto L10;
        updateTimes(r7);
        updateTimes(CRASH_ALL);
        return false;
    L10:
        callCrashLimitListener();
        return true;
    }

    public boolean checkCrashTotalLimit() {
        return checkLimit(CRASH_ALL, mCrashAllLimit);
    }

    public boolean checkEnsureAllLimit() {
        return checkLimit(ENSURE_ALL, mEnsureAllLimit);
    }

    public boolean checkEnsureLimit(String r7, String r8) {
        boolean r1 = false;
        if (isNoLimit == false) goto L5;
        return false;
    L5:
        boolean r0 = checkLimit(r8, mEnsureStackLimit);
        if (r7 == null) goto L8;
        boolean r2 = checkLimit(r7, mEnsureMsgLimit);
    L9:
        boolean r6 = checkLimit(ENSURE_ALL, mEnsureAllLimit);
        NpthLog.i("CustomException", "checkEnsureLimit:" + r8 + " " + mEnsureStackLimit + "=" + r0 + " " + r7 + " " + mEnsureMsgLimit + "=" + r2 + " totalExceed=" + r6);
        if (r0 == true) goto L13;
        if (r2 == true) goto L13;
        if (r6 == true) goto L13;
    L14:
        if (r1 == false) goto L16;
        callEnsureLimitListener();
    L16:
        return r1;
    L13:
        r1 = true;
        goto L14
    L8:
        r2 = false;
        goto L9
    }

    public synchronized boolean checkLimit(String r4, long r5) {
        monitor-enter(this);
        boolean r0 = false;
        if (r4 != null) goto L19;
        monitor-exit(this);
        return false;
    L19:
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(this.mTimesMap.get(r4), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        r6 = 0L;     // Catch: Throwable -> L16
    L10:
        if (r6.longValue() < r5) goto L14;
        r0 = true;
    L14:
        monitor-exit(this);
        return r0;
    L16:
        th = move-exception;
        throw th;
    }

    public void updateEnsureUploadTimes(String r1, String r2) {
        if (r1 == null) goto L4;
        updateTimes(r1);
    L4:
        if (r2 == null) goto L6;
        updateTimes(r2);
    L6:
        updateTimes(ENSURE_ALL);
    }

    public void writeUploadTimesFile() {
        StringBuilder r1 = new StringBuilder().append(this.createTime).append('\n');     // Catch: Exception -> L9
        Iterator<Map.Entry<String, Long>> r3 = this.mTimesMap.entrySet().iterator();     // Catch: Exception -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
        r1.append((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")).append(' ').append(r4.getValue()).append('\n');     // Catch: Exception -> L9
        goto L5
    L7:
        NpthLog.i("CustomException", "writeUploadTimesFile:" + r1);     // Catch: Exception -> L9
        FileUtils.writeFile(this.mFile, r1.toString(), false);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AppMonitor", e);
        NpthLog.e(e);
    }
}
