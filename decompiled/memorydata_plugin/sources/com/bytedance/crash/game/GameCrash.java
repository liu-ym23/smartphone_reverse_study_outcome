package com.bytedance.crash.game;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.NpthLog;

/* JADX INFO: loaded from: classes2.dex */
public class GameCrash {
    private static boolean sIsDropData;

    static class UploadProcess implements Runnable {
        private final String mCrashName;
        private final long mCrashTime;
        private final String mReason;
        private final String mStack;
        private final String mThreadName;

        UploadProcess(String r1, long r2, String r4, String r5, String r6) {
            this.mThreadName = r1;
            this.mCrashTime = r2;
            this.mCrashName = r4;
            this.mReason = r5;
            this.mStack = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppMonitor r0 = MonitorManager.getAppMonitor();
            if (r0 != null) goto L5;
            return;
        L5:
            boolean r7 = false;
            CrashBody r8 = GameSummary.assemblyCrashBody(r0, this.mThreadName, this.mCrashTime, this.mCrashName, this.mReason, this.mStack);     // Catch: Throwable -> L10
            r7 = CrashUploader.uploadEvent(UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.GAME, r8.getHeader().getJson()), r8.getJson());     // Catch: Throwable -> L10
        L7:
            if (r7 == true) goto L13;
            NpthLog.i("upload failed!");
            return;
        }
    }

    public GameCrash() {
    }

    public static void reportError(String r8, String r9, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L10;
        if (TextUtils.isEmpty(r9) == false) goto L10;
        if (TextUtils.isEmpty(r8) == false) goto L10;
        return;
    L10:
        if (sIsDropData == false) goto L12;
        return;
    L12:
        long r3 = System.currentTimeMillis();
        DefaultWorkThread.post(new UploadProcess(Thread.currentThread().getName(), r3, r8, r9, r10));
    }

    public static void setDropData(boolean r0) {
        sIsDropData = r0;
    }
}
