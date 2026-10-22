package com.bytedance.crash.dart;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.IUploadCallback;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DartCrash {
    private static boolean sIsDropData;

    static class UploadProcess implements Runnable {
        private final IUploadCallback mCallback;
        private final long mCrashTime;
        private final Map<? extends String, ? extends String> mCustomData;
        private final Map<String, String> mCustomLongData;
        private final String mMessage;
        private final String mThreadName;

        UploadProcess(String r10, long r11, String r12, Map<? extends String, ? extends String> r13, Map<String, String> r14, IUploadCallback r15) {
            this.mCrashTime = r11;
            this.mMessage = r12;
            this.mCustomData = r13;
            this.mCustomLongData = r14;
            this.mCallback = r15;
            this.mThreadName = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppMonitor r10 = MonitorManager.getAppMonitor();
            if (r10 != null) goto L5;
            return;
        L5:
            boolean r11 = false;
            CrashBody r12 = DartSummary.assemblyCrashBody(r10, this.mThreadName, this.mCrashTime, this.mMessage, this.mCustomData, this.mCustomLongData);     // Catch: Throwable -> L11
            r11 = CrashUploader.uploadEvent(UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.DART, r12.getHeader().getJson()), r12.getJson());     // Catch: Throwable -> L11
        L7:
            IUploadCallback r13 = this.mCallback;
            if (r13 == null) goto L17;
            r13.afterUpload(r11);     // Catch: Throwable -> L12
            return;
        L18:
            return;
        }
    }

    public DartCrash() {
    }

    public static void reportError(String r10) {
        reportError(r10, null, null, null);
    }

    public static void reportError(String r10, Map<? extends String, ? extends String> r11, Map<String, String> r12, IUploadCallback r13) {
        if (sIsDropData == false) goto L5;
        return;
    L5:
        long r14 = System.currentTimeMillis();
        DefaultWorkThread.post(new UploadProcess(Thread.currentThread().getName(), r14, r10, r11, r12, r13));
    }

    public static void setDropData(boolean r10) {
        sIsDropData = r10;
    }
}
