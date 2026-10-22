package com.bytedance.crash.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.Global;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
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

        static /* synthetic */ void access$000(CrashLimitCallback r10, String r11) {
            r10.onLimitExceed(r11);
        }

        private void onLimitExceed(String r10) {
            onLimitExceed();     // Catch: Throwable -> L4
            return;
        }

        protected void onLimitExceed() {
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
        String r10 = App.getProcessName().replace(".", "_").replace(":", "-") + UPLOAD_LIMIT_FILE;
        File r11 = new File(Global.getRootDirectory(), UPLOAD_LIMIT_DIR);
        FileSystemUtils.createDirectory(r11);
        this.mFile = new File(r11, r10);
        HashMap<String, Long> r12 = readUploadTimesFile();
        this.mTimesMap = r12;
        NpthLog.i(TAG, "upload_times:" + r12);
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

    @NonNull
    private HashMap<String, Long> readUploadTimesFile() {
        HashMap<String, Long> r10 = new HashMap();
        if (this.mFile.exists() == true) goto L22;
        this.createTime = System.currentTimeMillis();
        return r10;
    L22:
        JSONArray r11 = FileUtils.readFileArray(this.mFile);     // Catch: Throwable -> L20
        if (JSONUtils.isEmpty(r11) == false) goto L9;
        return r10;
    L9:
        Long r12 = safeParse(r11.optString(0, null));     // Catch: Throwable -> L20
        if ((System.currentTimeMillis() - r12.longValue()) < ONE_DAY) goto L13;
        NpthLog.i(TAG, "limit file exceed 1 day");     // Catch: Throwable -> L20
        this.createTime = System.currentTimeMillis();     // Catch: Throwable -> L20
        FileUtils.deleteFile(this.mFile);     // Catch: Throwable -> L20
        return r10;
    L13:
        this.createTime = r12.longValue();     // Catch: Throwable -> L20
        int r13 = 1;
    L15:
        if (r13 >= r11.length()) goto L21;
        String[] r14 = r11.optString(r13, "").split(" ");     // Catch: Throwable -> L20
        if (r14.length != 2) goto L19;
        r10.put(r14[0], Long.decode(r14[1]));     // Catch: Throwable -> L20
    L19:
        r13 = r13 + 1;
    L21:
        return r10;
    L20:
        this.createTime = System.currentTimeMillis();
        FileUtils.deleteFile(this.mFile);
        goto L21
    }

    private static Long safeParse(String r10) {
        return Long.decode(r10);
    L5:
        return 0L;
    }

    public static void updateConfig(UploadLimitConfig r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        mCrashStackLimit = r10.getCrashLimitIssue();
        mCrashAllLimit = r10.getCrashLimitAll();
        mEnsureAllLimit = r10.getExceptionAllLimit();
        mEnsureMsgLimit = r10.getExceptionMsgLimit();
        mEnsureStackLimit = r10.getExceptionStackLimit();
        isNoLimit = r10.isNoLimit();
        NpthLog.i(TAG, "updateConfig:" + r10);
    }

    private synchronized void updateTimes(String r10) {
        monitor-enter(this);
        NpthLog.i(TAG, "updateTimes:" + r10);     // Catch: Throwable -> L13
        if (r10 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Long r11 = this.mTimesMap.get(r10);     // Catch: Throwable -> L13
        long r12 = 1;
        if (r11 == null) goto L10;
        r12 = 1 + r11.longValue();     // Catch: Throwable -> L13
    L10:
        this.mTimesMap.put(r10, Long.valueOf(r12));     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean checkCrashLimit(String r10) {
        if (isNoLimit == false) goto L5;
        return false;
    L5:
        String r11 = Digest.getMD5(r10);
        boolean r12 = checkLimit(r11, mCrashStackLimit);
        boolean r13 = checkLimit(CRASH_ALL, mCrashAllLimit);
        if (r12 == true) goto L10;
        if (r13 == true) goto L10;
        updateTimes(r11);
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

    public boolean checkEnsureLimit(@Nullable String r10, String r11) {
        boolean r12 = false;
        if (isNoLimit == false) goto L5;
        return false;
    L5:
        boolean r13 = checkLimit(r11, mEnsureStackLimit);
        if (r10 == null) goto L8;
        boolean r14 = checkLimit(r10, mEnsureMsgLimit);
    L9:
        boolean r15 = checkLimit(ENSURE_ALL, mEnsureAllLimit);
        NpthLog.i("CustomException", "checkEnsureLimit:" + r11 + " " + mEnsureStackLimit + "=" + r13 + " " + r10 + " " + mEnsureMsgLimit + "=" + r14 + " totalExceed=" + r15);
        if (r13 == true) goto L13;
        if (r14 == true) goto L13;
        if (r15 == true) goto L13;
    L14:
        if (r12 == false) goto L16;
        callEnsureLimitListener();
    L16:
        return r12;
    L13:
        r12 = true;
        goto L14
    L8:
        r14 = false;
        goto L9
    }

    public synchronized boolean checkLimit(String r10, long r11) {
        monitor-enter(this);
        boolean r12 = false;
        if (r10 != null) goto L19;
        monitor-exit(this);
        return false;
    L19:
        Long r13 = this.mTimesMap.get(r10);     // Catch: Throwable -> L16
        if (r13 != null) goto L10;
        r13 = 0L;     // Catch: Throwable -> L16
    L10:
        if (r13.longValue() < r11) goto L14;
        r12 = true;
    L14:
        monitor-exit(this);
        return r12;
    L16:
        th = move-exception;
        throw th;
    }

    public void updateEnsureUploadTimes(String r10, @Nullable String r11) {
        if (r10 == null) goto L4;
        updateTimes(r10);
    L4:
        if (r11 == null) goto L6;
        updateTimes(r11);
    L6:
        updateTimes(ENSURE_ALL);
    }

    public void writeUploadTimesFile() {
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L8
        r10.append(this.createTime);     // Catch: Exception -> L8
        r10.append('\n');     // Catch: Exception -> L8
        Iterator<Map.Entry<String, Long>> r11 = this.mTimesMap.entrySet().iterator();     // Catch: Exception -> L8
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, Long> r12 = r11.next();     // Catch: Exception -> L8
        r10.append(r12.getKey());     // Catch: Exception -> L8
        r10.append(' ');     // Catch: Exception -> L8
        r10.append(r12.getValue());     // Catch: Exception -> L8
        r10.append('\n');     // Catch: Exception -> L8
        goto L4
    L6:
        NpthLog.i("CustomException", "writeUploadTimesFile:" + r10);     // Catch: Exception -> L8
        FileUtils.writeFile(this.mFile, r10.toString(), false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AppMonitor", e);
        NpthLog.e(e);
    }
}
