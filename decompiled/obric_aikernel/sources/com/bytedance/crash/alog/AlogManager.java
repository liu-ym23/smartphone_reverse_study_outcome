package com.bytedance.crash.alog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.NpthAlogApi;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.Net;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlogManager {
    public static final String ERR_NO_AID = "no_aid";
    public static final String ERR_NO_DID = "no_did";
    public static final String ERR_SUCCESS = "success";
    public static final String ERR_UNKNOWN = "unknown";
    private static Controller sController;
    private static final HashMap<String, CrashRecord> sCrashRecords = null;

    interface Controller {
        List<String> collect(long r10, String r11);

        void flush();

        boolean isInit();
    }

    static class CrashRecord {
        final List<Long> mCrashTimeList;
        boolean mIsLunch;
        final String mProcessName;

        CrashRecord(String r10, long r11, CrashType r12) {
            ArrayList r13 = new ArrayList();
            this.mCrashTimeList = r13;
            this.mProcessName = r10;
            r13.add(Long.valueOf(r11));
            if (r12 != CrashType.LAUNCH) goto L6;
            this.mIsLunch = true;
            return;
        }

        void append(long r10, CrashType r11) {
            this.mCrashTimeList.add(Long.valueOf(r10));
            if (r11 != CrashType.LAUNCH) goto L6;
            this.mIsLunch = true;
            return;
        }
    }

    static class ExternalController implements Controller {
        ExternalController() {
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        @Nullable
        public List<String> collect(long r10, String r11) {
            return NpthAlogApi.getAlogFiles(r10, r11);
        L4:
            return null;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public void flush() {
            NpthAlogApi.flushAlogSync();     // Catch: Throwable -> L4
            return;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public boolean isInit() {
            return NpthAlogApi.isAlogInit();
        L4:
            return false;
        }
    }

    static class InnerController implements Controller {
        private final File mAlogFilesDir;
        private final IAlogUploadStrategy mAlogUploadStrategy;
        private final IALogCrashObserver mLogCrashObserver;

        InnerController(String r10, IALogCrashObserver r11, IAlogUploadStrategy r12) {
            this.mAlogFilesDir = new File(r10);
            this.mLogCrashObserver = r11;
            this.mAlogUploadStrategy = r12;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        @Nullable
        public List<String> collect(long r10, String r11) {
            if (this.mAlogFilesDir.exists() == false) goto L9;
            IAlogUploadStrategy r12 = this.mAlogUploadStrategy;
            if ((r12 instanceof DefaultAlogUploadStrategy) == false) goto L12;
            r12 = new DefaultAlogUploadStrategy(r11);
        L12:
            return r12.getUploadAlogFiles(this.mAlogFilesDir.getAbsolutePath(), r10);
        L14:
            return null;
        L9:
            return null;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public void flush() {
            IALogCrashObserver r10 = this.mLogCrashObserver;
            if (r10 == null) goto L11;
            r10.flushAlogDataToFile();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            NpthMonitor.reportInnerException(th);
            return;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public boolean isInit() {
            return true;
        }
    }

    static class UploadTask implements Runnable {
        private final int MAX_CHECK_TIMES;
        private AppMonitor mAppMonitor;
        private int mCheckTimes;

        UploadTask(@NonNull AppMonitor r10) {
            this.MAX_CHECK_TIMES = 60;
            this.mCheckTimes = 0;
            this.mAppMonitor = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlogManager.isInit() == true) goto L5;
        L8:
            int r10 = this.mCheckTimes;
            this.mCheckTimes = r10 + 1;
            if (r10 >= 60) goto L13;
            DefaultWorkThread.postDelayed(this, 2000);
            return;
        L13:
            return;
        L5:
            if (Net.isNetworkAvailable() == false) goto L8;
            AlogManager.access$000(this.mAppMonitor);
        }
    }

    static {
        sCrashRecords = new HashMap();
    }

    public AlogManager() {
    }

    static /* synthetic */ void access$000(AppMonitor r10) {
        uploadAlogRecord(r10);
    }

    @Nullable
    public static List<String> collectAlog(long r10, String r11) {
        if (isInit() == true) goto L5;
        return null;
    L5:
        return sController.collect(r10, r11);
    }

    public static void flushData() {
        if (isInit() == false) goto L6;
        sController.flush();
        return;
    }

    public static boolean isInit() {
        Controller r10 = sController;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isInit() == false) goto L7;
        return true;
    }

    public static void record(String r10, long r11, long r12, CrashType r13) {
        HashMap<String, CrashRecord> r14 = sCrashRecords;
        monitor-enter(r14);
        CrashRecord r15 = r14.get(r10 + r11);     // Catch: Throwable -> L10
        if (r15 != null) goto L7;
        r14.put(r10 + r11, new CrashRecord(r10, r12, r13));     // Catch: Throwable -> L10
    L8:
        monitor-exit(r14);     // Catch: Throwable -> L10
        return;
    L7:
        r15.append(r12, r13);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static void setAlogFlushFunction(long r10) {
        NativeBridge.setAlogFlushFunction(r10);
    }

    public static void setExternalController() {
        if (NpthAlogApi.getAlogFilesInit() == true) goto L5;
        return;
    L5:
        if (NpthAlogApi.sAlogFlushInit() == false) goto L9;
        sController = new ExternalController();
        return;
    }

    public static void setInnerController(String r10, IALogCrashObserver r11, IAlogUploadStrategy r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (sController != null) goto L9;
        sController = new InnerController(r10, r11, r12);
        return;
    }

    public static void upload(@NonNull AppMonitor r10) {
        new UploadTask(r10).run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AlogManager", e);
    }

    private static String uploadAlog(@NonNull AppMonitor r10, List<String> r11, String r12) {
        int r13 = Integer.parseInt(r10.getAppId());     // Catch: Throwable -> L4
    L5:
        if (r13 > 0) goto L20;
        return "no_aid";
    L20:
        String r14 = r10.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r14) == false) goto L12;
        return "no_did";
    L12:
        int r15 = r13;
        if (CrashUploader.uploadAlogFiles(UploaderUrl.appendAlogUrlParams(NetConfig.getAlogUploadUrl(), r15, r14, r10.getVersionName(), r10.getUpdateVersionCode()), r13, r14, r12, r11) == false) goto L24;
        return "success";
    L24:
        return "unknown";
    L16:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        return "unknown";
    L4:
        r13 = 0;
        goto L5
    }

    private static void uploadAlogRecord(@NonNull AppMonitor r10) {
        HashMap<String, CrashRecord> r11 = sCrashRecords;
        monitor-enter(r11);
        HashMap r12 = new HashMap(r11);     // Catch: Throwable -> L32
        r11.clear();     // Catch: Throwable -> L32
        monitor-exit(r11);     // Catch: Throwable -> L32
        Iterator r13 = r12.keySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L31;
        CrashRecord r14 = (CrashRecord) r12.get((String) r13.next());
        if (r14 == null) goto L8;
        if (r14.mCrashTimeList.isEmpty() == true) goto L8;
        HashSet r15 = new HashSet();
        Iterator<Long> r16 = r14.mCrashTimeList.iterator();
    L15:
        if (r16.hasNext() == false) goto L20;
        List<String> r17 = collectAlog(r16.next().longValue(), r14.mProcessName);
        if (r17 == null) goto L15;
        r15.addAll(r17);
        goto L15
    L20:
        if (r15.isEmpty() == true) goto L8;
        String r18 = uploadAlog(r10, new ArrayList(r15), r14.mProcessName);
        NpthMonitor.Event r19 = new NpthMonitor.Event("alog_check");
        Object[] r20 = new Object[6];
        r20[0] = "check_result";
        r20[1] = r18;
        r20[2] = Header.KEY_CRASH_TYPE;
        if (r14.mIsLunch == false) goto L25;
        String r21 = "lunch";
    L26:
        r20[3] = r21;
        r20[4] = "alog_inited";
        if (isInit() == false) goto L29;
        String r22 = "true";
    L30:
        r20[5] = r22;
        r19.addCategories(r20).upload();
        goto L8
    L29:
        r22 = "uncertain";
        goto L30
    L25:
        r21 = "normal";
        goto L26
    L31:
        return;
    L32:
        th = move-exception;
        throw th;
    }
}
