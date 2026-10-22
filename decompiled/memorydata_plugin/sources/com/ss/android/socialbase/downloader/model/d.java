package com.ss.android.socialbase.downloader.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, a> f15567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, a> f15568b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15570b;
        public int c;
        public int d;

        public a() {
        }
    }

    public d() {
        this.f15567a = new ConcurrentHashMap();
        this.f15568b = new ConcurrentHashMap();
    }

    public static a a(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.memorydata.plugin");
        a r0 = new a();
        if (r4 != null) goto L5;
    L7:
        return r0;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ThreadPoolExecutor.class) == false) goto L7;
        ThreadPoolExecutor r5 = (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r4, ThreadPoolExecutor.class, "com.obric.memorydata.plugin");
        r0.f15569a = r5.getActiveCount();
        r0.f15570b = r5.getCorePoolSize();
        r0.c = r5.getMaximumPoolSize();
        r0.d = r5.getQueue().size();
        goto L7
    }

    private JSONObject a(Map<String, a> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        JSONObject r8 = new JSONObject();
        Iterator r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin");
        JSONObject r3 = new JSONObject();
        r3.put("active", r2.f15569a);
        r3.put("core", r2.f15570b);
        r3.put("max", r2.c);
        r3.put("queue", r2.d);
        r8.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r3);
        goto L4
    L6:
        return r8;
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("beforeDownload", a(this.f15567a));     // Catch: Throwable -> L5
        r0.put("afterDownload", a(this.f15568b));     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public d b() {
        d r0 = new d();
        Iterator<Map.Entry<String, a>> r1 = this.f15567a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map<String, a> r3 = r0.f15567a;
        Object r4 = r2.getKey();
        r3.put((String) r4, (a) r2.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, a>> r5 = this.f15568b.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map<String, a> r7 = r0.f15568b;
        Object r8 = r6.getKey();
        r7.put((String) r8, (a) r6.getValue());
        goto L8
    L10:
        return r0;
    }

    public void c() {
        this.f15567a.clear();
        this.f15568b.clear();
    }
}
