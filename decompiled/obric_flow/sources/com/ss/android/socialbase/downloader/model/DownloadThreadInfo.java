package com.ss.android.socialbase.downloader.model;

import cn.nubia.neopush.commons.Constant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadThreadInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f15897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f15898b;

    public static class ThreadExecutorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15901c;
        public int d;

        public ThreadExecutorInfo() {
        }
    }

    public DownloadThreadInfo() {
        this.f15897a = new ConcurrentHashMap();
        this.f15898b = new ConcurrentHashMap();
    }

    public static ThreadExecutorInfo a(ExecutorService r5) {
        ThreadExecutorInfo r10 = new ThreadExecutorInfo();
        if (r5 != null) goto L5;
    L7:
        return r10;
    L5:
        if ((r5 instanceof ThreadPoolExecutor) == false) goto L7;
        ThreadPoolExecutor r11 = (ThreadPoolExecutor) r5;
        r10.f15899a = r11.getActiveCount();
        r10.f15900b = r11.getCorePoolSize();
        r10.f15901c = r11.getMaximumPoolSize();
        r10.d = r11.getQueue().size();
        goto L7
    }

    public static JSONObject a(ConcurrentHashMap r10) {
        JSONObject r5 = new JSONObject();
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        ThreadExecutorInfo r13 = (ThreadExecutorInfo) r12.getValue();
        JSONObject r14 = new JSONObject();
        r14.put(Constant.ClientMessageType.ACTIVE, r13.f15899a);
        r14.put("core", r13.f15900b);
        r14.put("max", r13.f15901c);
        r14.put("queue", r13.d);
        r5.put((String) r12.getKey(), r14);
        goto L4
    L6:
        return r5;
    }
}
