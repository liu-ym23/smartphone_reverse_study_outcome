package com.bytedance.crash.dart;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.IUploadCallback;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DartCrash {
    private static boolean sIsDropData;

    static class UploadProcess implements Runnable {
        private final IUploadCallback mCallback;
        private final long mCrashTime;
        private final Map<? extends String, ? extends String> mCustomData;
        private final Map<String, String> mCustomLongData;
        private final String mMessage;
        private final String mThreadName;

        UploadProcess(String r3, long r4, String r6, Map<? extends String, ? extends String> r7, Map<String, String> r8, IUploadCallback r9) {
            Map<? extends String, ? extends String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            IUploadCallback r12 = (IUploadCallback) ZeusTransformUtils.wrapperContextForParams(r9, IUploadCallback.class, "com.obric.memorydata.plugin");
            this.mCrashTime = r4;
            this.mMessage = r6;
            this.mCustomData = r10;
            this.mCustomLongData = r11;
            this.mCallback = r12;
            this.mThreadName = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppMonitor r0 = MonitorManager.getAppMonitor();
            if (r0 != null) goto L5;
            return;
        L5:
            boolean r7 = false;
            CrashBody r1 = DartSummary.assemblyCrashBody(r0, this.mThreadName, this.mCrashTime, this.mMessage, this.mCustomData, this.mCustomLongData);     // Catch: Throwable -> L11
            r7 = CrashUploader.uploadEvent(UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.DART, r1.getHeader().getJson()), r1.getJson());     // Catch: Throwable -> L11
        L7:
            IUploadCallback r8 = this.mCallback;
            if (r8 == null) goto L17;
            r8.afterUpload(r7);     // Catch: Throwable -> L12
            return;
        L18:
            return;
        }
    }

    public DartCrash() {
    }

    public static void reportError(String r1) {
        reportError(r1, null, null, null);
    }

    public static void reportError(String r10, Map<? extends String, ? extends String> r11, Map<String, String> r12, IUploadCallback r13) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        IUploadCallback r9 = (IUploadCallback) ZeusTransformUtils.wrapperContextForParams(r13, IUploadCallback.class, "com.obric.memorydata.plugin");
        if (sIsDropData == false) goto L5;
        return;
    L5:
        long r4 = System.currentTimeMillis();
        DefaultWorkThread.post(new UploadProcess(Thread.currentThread().getName(), r4, r10, r7, r8, r9));
    }

    public static void setDropData(boolean r0) {
        sIsDropData = r0;
    }
}
