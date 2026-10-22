package com.ss.android.socialbase.downloader.model;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, a> f8175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, a> f8176b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8180d;

        public a() {
        }
    }

    public e() {
        this.f8175a = new ConcurrentHashMap();
        this.f8176b = new ConcurrentHashMap();
    }

    public static a c(ExecutorService r10) {
        a r11 = new a();
        if (r10 != null) goto L5;
    L7:
        return r11;
    L5:
        if ((r10 instanceof ThreadPoolExecutor) == false) goto L7;
        ThreadPoolExecutor r12 = (ThreadPoolExecutor) r10;
        r11.f8177a = r12.getActiveCount();
        r11.f8178b = r12.getCorePoolSize();
        r11.f8179c = r12.getMaximumPoolSize();
        r11.f8180d = r12.getQueue().size();
        goto L7
    }

    private JSONObject e(Map<String, a> r10) {
        JSONObject r11 = new JSONObject();
        Iterator<Map.Entry<String, a>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, a> r13 = r12.next();
        a r14 = r13.getValue();
        JSONObject r15 = new JSONObject();
        r15.put("active", r14.f8177a);
        r15.put("core", r14.f8178b);
        r15.put("max", r14.f8179c);
        r15.put("queue", r14.f8180d);
        r11.put(r13.getKey(), r15);
        goto L4
    L6:
        return r11;
    }

    public e a() {
        e r10 = new e();
        Iterator<Map.Entry<String, a>> r11 = this.f8175a.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, a> r12 = r11.next();
        r10.f8175a.put(r12.getKey(), r12.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, a>> r13 = this.f8176b.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry<String, a> r14 = r13.next();
        r10.f8176b.put(r14.getKey(), r14.getValue());
        goto L8
    L10:
        return r10;
    }

    public JSONObject b() {
        JSONObject r10 = new JSONObject();
        r10.put("beforeDownload", e(this.f8175a));     // Catch: Throwable -> L5
        r10.put("afterDownload", e(this.f8176b));     // Catch: Throwable -> L5
    L7:
        return r10;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void d() {
        this.f8175a.clear();
        this.f8176b.clear();
    }
}
