package com.ss.android.socialbase.downloader.model;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class DownloadThreadInfo {
    public Map<String, ThreadExecutorInfo> afterDownloadThreadExecutors;
    public Map<String, ThreadExecutorInfo> beforeDownloadThreadExecutors;

    public DownloadThreadInfo copy() {
        DownloadThreadInfo r0 = new DownloadThreadInfo();
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r1 = this.beforeDownloadThreadExecutors.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, ThreadExecutorInfo> r2 = r1.next();
        r0.beforeDownloadThreadExecutors.put(r2.getKey(), r2.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r3 = this.afterDownloadThreadExecutors.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<String, ThreadExecutorInfo> r4 = r3.next();
        r0.afterDownloadThreadExecutors.put(r4.getKey(), r4.getValue());
        goto L8
    L10:
        return r0;
    }

    public JSONObject obtainStats() {
        JSONObject r0 = new JSONObject();
        r0.put("beforeDownload", translate(this.beforeDownloadThreadExecutors));     // Catch: Throwable -> L5
        r0.put("afterDownload", translate(this.afterDownloadThreadExecutors));     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void reset() {
        this.beforeDownloadThreadExecutors.clear();
        this.afterDownloadThreadExecutors.clear();
    }

    public DownloadThreadInfo() {
        this.beforeDownloadThreadExecutors = new ConcurrentHashMap();
        this.afterDownloadThreadExecutors = new ConcurrentHashMap();
    }

    public static ThreadExecutorInfo parse(ExecutorService r2) {
        ThreadExecutorInfo r0 = new ThreadExecutorInfo();
        if (r2 != null) goto L5;
    L7:
        return r0;
    L5:
        if ((r2 instanceof ThreadPoolExecutor) == false) goto L7;
        ThreadPoolExecutor r3 = (ThreadPoolExecutor) r2;
        r0.activeCount = r3.getActiveCount();
        r0.corePoolSize = r3.getCorePoolSize();
        r0.maximumPoolSize = r3.getMaximumPoolSize();
        r0.queueSize = r3.getQueue().size();
        goto L7
    }

    private JSONObject translate(Map<String, ThreadExecutorInfo> r7) throws Throwable {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry<String, ThreadExecutorInfo> r1 = r8.next();
        ThreadExecutorInfo r2 = r1.getValue();
        JSONObject r3 = new JSONObject();
        r3.put("active", r2.activeCount);
        r3.put("core", r2.corePoolSize);
        r3.put("max", r2.maximumPoolSize);
        r3.put("queue", r2.queueSize);
        r0.put(r1.getKey(), r3);
        goto L4
    L6:
        return r0;
    }
}
