package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AlogManager {
    public static final String ERR_NO_AID = "no_aid";
    public static final String ERR_NO_DID = "no_did";
    public static final String ERR_SUCCESS = "success";
    public static final String ERR_UNKNOWN = "unknown";
    private static Controller sController;
    private static final HashMap<String, CrashRecord> sCrashRecords = null;

    interface Controller {
        List<String> collect(long r1, String r3);

        void flush();

        boolean isInit();
    }

    static class CrashRecord {
        final List<Long> mCrashTimeList;
        boolean mIsLunch;
        final String mProcessName;

        CrashRecord(String r2, long r3, CrashType r5) {
            ArrayList r0 = new ArrayList();
            this.mCrashTimeList = r0;
            this.mProcessName = r2;
            r0.add(Long.valueOf(r3));
            if (r5 != CrashType.LAUNCH) goto L6;
            this.mIsLunch = true;
            return;
        }

        void append(long r2, CrashType r4) {
            this.mCrashTimeList.add(Long.valueOf(r2));
            if (r4 != CrashType.LAUNCH) goto L6;
            this.mIsLunch = true;
            return;
        }
    }

    static class ExternalController implements Controller {
        ExternalController() {
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public List<String> collect(long r1, String r3) {
            return NpthAlogApi.getAlogFiles(r1, r3);
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

        InnerController(String r3, IALogCrashObserver r4, IAlogUploadStrategy r5) {
            IALogCrashObserver r6 = (IALogCrashObserver) ZeusTransformUtils.wrapperContextForParams(r4, IALogCrashObserver.class, "com.obric.memorydata.plugin");
            IAlogUploadStrategy r7 = (IAlogUploadStrategy) ZeusTransformUtils.wrapperContextForParams(r5, IAlogUploadStrategy.class, "com.obric.memorydata.plugin");
            this.mAlogFilesDir = new File(r3);
            this.mLogCrashObserver = r6;
            this.mAlogUploadStrategy = r7;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public List<String> collect(long r3, String r5) {
            if (this.mAlogFilesDir.exists() == false) goto L9;
            IAlogUploadStrategy r0 = this.mAlogUploadStrategy;
            if (ZeusTransformUtils.instanceOf(r0, DefaultAlogUploadStrategy.class) == false) goto L12;
            r0 = new DefaultAlogUploadStrategy(r5);
        L12:
            return r0.getUploadAlogFiles(this.mAlogFilesDir.getAbsolutePath(), r3);
        L14:
            return null;
        L9:
            return null;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public void flush() {
            IALogCrashObserver r0 = this.mLogCrashObserver;
            if (r0 == null) goto L11;
            r0.flushAlogDataToFile();     // Catch: Throwable -> L6
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

        UploadTask(AppMonitor r2) {
            this.MAX_CHECK_TIMES = 60;
            this.mCheckTimes = 0;
            this.mAppMonitor = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlogManager.isInit() == true) goto L5;
        L8:
            int r0 = this.mCheckTimes;
            this.mCheckTimes = r0 + 1;
            if (r0 >= 60) goto L13;
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

    static /* synthetic */ void access$000(AppMonitor r0) {
        uploadAlogRecord(r0);
    }

    public static List<String> collectAlog(long r1, String r3) {
        if (isInit() == true) goto L5;
        return null;
    L5:
        return sController.collect(r1, r3);
    }

    public static void flushData() {
        if (isInit() == false) goto L6;
        sController.flush();
        return;
    }

    public static boolean isInit() {
        Controller r0 = sController;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isInit() == false) goto L7;
        return true;
    }

    public static void record(String r4, long r5, long r7, CrashType r9) {
        HashMap<String, CrashRecord> r0 = sCrashRecords;
        monitor-enter(r0);
        CrashRecord r1 = (CrashRecord) ZeusTransformUtils.preCheckCast(r0.get(r4 + r5), CrashRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r0.put(r4 + r5, new CrashRecord(r4, r7, r9));     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        r1.append(r7, r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static void setAlogFlushFunction(long r0) {
        NativeBridge.setAlogFlushFunction(r0);
    }

    public static void setExternalController() {
        if (NpthAlogApi.getAlogFilesInit() == true) goto L5;
        return;
    L5:
        if (NpthAlogApi.sAlogFlushInit() == false) goto L9;
        sController = new ExternalController();
        return;
    }

    public static void setInnerController(String r2, IALogCrashObserver r3, IAlogUploadStrategy r4) {
        IALogCrashObserver r5 = (IALogCrashObserver) ZeusTransformUtils.wrapperContextForParams(r3, IALogCrashObserver.class, "com.obric.memorydata.plugin");
        IAlogUploadStrategy r6 = (IAlogUploadStrategy) ZeusTransformUtils.wrapperContextForParams(r4, IAlogUploadStrategy.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (sController != null) goto L9;
        sController = new InnerController(r2, r5, r6);
        return;
    }

    public static void upload(AppMonitor r1) {
        new UploadTask(r1).run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AlogManager", e);
    }

    private static String uploadAlog(AppMonitor r8, List<String> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        int r0 = Integer.parseInt(r8.getAppId());     // Catch: Throwable -> L5
    L6:
        if (r0 > 0) goto L21;
        return "no_aid";
    L21:
        String r7 = r8.getDeviceId("0");     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r7) == false) goto L13;
        return "no_did";
    L13:
        int r2 = r0;
        if (CrashUploader.uploadAlogFiles(UploaderUrl.appendAlogUrlParams(NetConfig.getAlogUploadUrl(), r2, r7, r8.getVersionName(), r8.getUpdateVersionCode()), r0, r7, r10, r11) == false) goto L25;
        return "success";
    L25:
        return "unknown";
    L17:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        return "unknown";
    L5:
        r0 = 0;
        goto L6
    }

    private static void uploadAlogRecord(AppMonitor r8) {
        HashMap<String, CrashRecord> r0 = sCrashRecords;
        monitor-enter(r0);
        HashMap r1 = new HashMap(r0);     // Catch: Throwable -> L32
        r0.clear();     // Catch: Throwable -> L32
        monitor-exit(r0);     // Catch: Throwable -> L32
        Iterator r2 = r1.keySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L31;
        CrashRecord r3 = (CrashRecord) ZeusTransformUtils.preCheckCast(r1.get((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")), CrashRecord.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        if (r3.mCrashTimeList.isEmpty() == true) goto L8;
        HashSet r4 = new HashSet();
        Iterator<Long> r5 = r3.mCrashTimeList.iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        List<String> r6 = collectAlog(((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.memorydata.plugin")).longValue(), r3.mProcessName);
        if (r6 == null) goto L15;
        r4.addAll(r6);
        goto L15
    L20:
        if (r4.isEmpty() == true) goto L8;
        String r7 = uploadAlog(r8, new ArrayList(r4), r3.mProcessName);
        NpthMonitor.Event r9 = new NpthMonitor.Event("alog_check");
        Object[] r10 = new Object[6];
        r10[0] = LocationMonitorConst.CHECK_RESULT;
        r10[1] = r7;
        r10[2] = Header.KEY_CRASH_TYPE;
        if (r3.mIsLunch == false) goto L25;
        String r11 = "lunch";
    L26:
        r10[3] = r11;
        r10[4] = "alog_inited";
        if (isInit() == false) goto L29;
        String r12 = "true";
    L30:
        r10[5] = r12;
        r9.addCategories(r10).upload();
        goto L8
    L29:
        r12 = "uncertain";
        goto L30
    L25:
        r11 = "normal";
        goto L26
    L31:
        return;
    L32:
        th = move-exception;
        throw th;
    }
}
