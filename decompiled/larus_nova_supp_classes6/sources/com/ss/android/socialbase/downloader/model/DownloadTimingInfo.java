package com.ss.android.socialbase.downloader.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class DownloadTimingInfo {
    public long afterOnPrepareTime;
    public long afterOnStartTime;
    public long beforeOnEndCallbackTime;
    public long beforeOnPrepareTime;
    public long beforeOnStartTime;
    public long beforeThreadExecuteTime;
    public long buildDownloadInfoTime;
    public long callDownloadTime;
    public long doDownloadTime;
    public long endDownloadTime;
    public long threadExecuteTime;
    public long tryDownloadTime;

    public DownloadTimingInfo() {
    }

    public DownloadTimingInfo copy() {
        DownloadTimingInfo r0 = new DownloadTimingInfo();
        r0.callDownloadTime = this.callDownloadTime;
        r0.buildDownloadInfoTime = this.buildDownloadInfoTime;
        r0.tryDownloadTime = this.tryDownloadTime;
        r0.doDownloadTime = this.doDownloadTime;
        r0.beforeThreadExecuteTime = this.beforeThreadExecuteTime;
        r0.threadExecuteTime = this.threadExecuteTime;
        r0.beforeOnPrepareTime = this.beforeOnPrepareTime;
        r0.afterOnPrepareTime = this.afterOnPrepareTime;
        r0.beforeOnStartTime = this.beforeOnStartTime;
        r0.afterOnStartTime = this.afterOnStartTime;
        r0.beforeOnEndCallbackTime = this.beforeOnEndCallbackTime;
        r0.endDownloadTime = System.currentTimeMillis();
        return r0;
    }

    public JSONObject obtainDurationStats() {
        JSONObject r0 = new JSONObject();
        long r2 = this.callDownloadTime;     // Catch: Throwable -> L12
        long r4 = 0;
        if (r2 <= 0) goto L6;
        long r6 = this.buildDownloadInfoTime - r2;     // Catch: Throwable -> L12
    L7:
        r0.put("build_download_info", r6);     // Catch: Throwable -> L12
        long r3 = this.buildDownloadInfoTime;     // Catch: Throwable -> L12
        if (r3 <= 0) goto L10;
        r4 = this.tryDownloadTime - r3;     // Catch: Throwable -> L12
    L10:
        r0.put("try_download", r4);     // Catch: Throwable -> L12
        r0.put("do_download", this.doDownloadTime - this.tryDownloadTime);     // Catch: Throwable -> L12
        r0.put("before_thread_execute", this.beforeThreadExecuteTime - this.doDownloadTime);     // Catch: Throwable -> L12
        r0.put("thread_execute", this.threadExecuteTime - this.beforeThreadExecuteTime);     // Catch: Throwable -> L12
        r0.put("before_on_prepare", this.beforeOnPrepareTime - this.threadExecuteTime);     // Catch: Throwable -> L12
        r0.put("after_on_prepare", this.afterOnPrepareTime - this.beforeOnPrepareTime);     // Catch: Throwable -> L12
        r0.put("before_on_start", this.beforeOnStartTime - this.afterOnPrepareTime);     // Catch: Throwable -> L12
        r0.put("after_on_start", this.afterOnStartTime - this.beforeOnStartTime);     // Catch: Throwable -> L12
        r0.put("before_on_finish", this.beforeOnEndCallbackTime - this.afterOnStartTime);     // Catch: Throwable -> L12
        r0.put("after_on_finish", this.endDownloadTime - this.beforeOnEndCallbackTime);     // Catch: Throwable -> L12
    L14:
        return r0;
    L6:
        r6 = 0;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    public JSONObject obtainOriginStats() {
        JSONObject r0 = new JSONObject();
        r0.put("call_download", this.callDownloadTime);     // Catch: Throwable -> L5
        r0.put("build_download_info", this.buildDownloadInfoTime);     // Catch: Throwable -> L5
        r0.put("try_download", this.tryDownloadTime);     // Catch: Throwable -> L5
        r0.put("do_download", this.doDownloadTime);     // Catch: Throwable -> L5
        r0.put("before_thread_execute", this.beforeThreadExecuteTime);     // Catch: Throwable -> L5
        r0.put("thread_execute", this.threadExecuteTime);     // Catch: Throwable -> L5
        r0.put("before_on_prepare", this.beforeOnPrepareTime);     // Catch: Throwable -> L5
        r0.put("after_on_prepare", this.afterOnPrepareTime);     // Catch: Throwable -> L5
        r0.put("before_on_start", this.beforeOnStartTime);     // Catch: Throwable -> L5
        r0.put("after_on_start", this.afterOnStartTime);     // Catch: Throwable -> L5
        r0.put("before_on_finish", this.beforeOnEndCallbackTime);     // Catch: Throwable -> L5
        r0.put("after_on_finish", System.currentTimeMillis());     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void reset() {
        this.callDownloadTime = 0;
        this.buildDownloadInfoTime = 0;
        this.tryDownloadTime = 0;
        this.doDownloadTime = 0;
        this.beforeThreadExecuteTime = 0;
        this.threadExecuteTime = 0;
        this.beforeOnPrepareTime = 0;
        this.afterOnPrepareTime = 0;
        this.beforeOnStartTime = 0;
        this.afterOnStartTime = 0;
        this.beforeOnEndCallbackTime = 0;
    }
}
