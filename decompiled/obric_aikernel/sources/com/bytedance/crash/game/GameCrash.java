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

/* JADX INFO: loaded from: classes.dex */
public class GameCrash {
    private static boolean sIsDropData;

    static class UploadProcess implements Runnable {
        private final String mCrashName;
        private final long mCrashTime;
        private final String mReason;
        private final String mStack;
        private final String mThreadName;

        UploadProcess(String r10, long r11, String r12, String r13, String r14) {
            this.mThreadName = r10;
            this.mCrashTime = r11;
            this.mCrashName = r12;
            this.mReason = r13;
            this.mStack = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppMonitor r10 = MonitorManager.getAppMonitor();
            if (r10 != null) goto L5;
            return;
        L5:
            boolean r11 = false;
            CrashBody r12 = GameSummary.assemblyCrashBody(r10, this.mThreadName, this.mCrashTime, this.mCrashName, this.mReason, this.mStack);     // Catch: Throwable -> L10
            r11 = CrashUploader.uploadEvent(UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.GAME, r12.getHeader().getJson()), r12.getJson());     // Catch: Throwable -> L10
        L7:
            if (r11 == true) goto L13;
            NpthLog.i("upload failed!");
            return;
        }
    }

    public GameCrash() {
    }

    public static void reportError(String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L10;
        if (TextUtils.isEmpty(r11) == false) goto L10;
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return;
    L10:
        if (sIsDropData == false) goto L12;
        return;
    L12:
        long r13 = System.currentTimeMillis();
        DefaultWorkThread.post(new UploadProcess(Thread.currentThread().getName(), r13, r10, r11, r12));
    }

    public static void setDropData(boolean r10) {
        sIsDropData = r10;
    }
}
