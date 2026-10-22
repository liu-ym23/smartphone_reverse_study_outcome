package com.bytedance.framwork.core.sdklib.apm6;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.services.apm.api.IHttpService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f2610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, JSONObject> f2611b = null;
    private static Map<String, String> c;
    private static FileLock d;
    private static volatile boolean e;
    private static boolean f;

    static {
        f2611b = new ConcurrentHashMap();
        e = false;
    }

    public static com.bytedance.services.apm.api.c a(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        IHttpService r0 = (IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IHttpService.class), IHttpService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        return r0.doPost(r3, r5, r6);
    L7:
        return com.bytedance.framwork.core.sdklib.apm6.b.a.a(r3, r5, r6);
    }

    public static synchronized JSONObject a() {
        monitor-enter(j.class);
        ConcurrentHashMap<Long, JSONObject> r1 = f2611b;     // Catch: Throwable -> L12
        Iterator<Long> r2 = r1.keySet().iterator();     // Catch: Throwable -> L12
        if (r2.hasNext() == false) goto L10;
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(r1.get((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        monitor-exit(j.class);
        return r3;
    L10:
        monitor-exit(j.class);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized JSONObject a(long r2) {
        monitor-enter(j.class);
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(f2611b.get(Long.valueOf(r2)), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(Context r3) {
        monitor-enter(j.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (f2610a == null) goto L8;
        monitor-exit(j.class);
        return;
    L8:
        f2610a = r4;     // Catch: Throwable -> L11
        monitor-exit(j.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(String r4, JSONObject r5) {
        monitor-enter(j.class);
        f2611b.put(Long.valueOf(Long.parseLong(r4)), r5);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(j.class);
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "setHeader", e);     // Catch: Throwable -> L6
        goto L10
    }

    public static void a(Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return;
    L8:
        if (c != null) goto L10;
        c = new HashMap();
    L10:
        Map<? extends String, ? extends String> r4 = c;
        r4.putAll(r4);
        c.remove("aid");
    }

    public static Map<String, String> b() {
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(c.get("device_id"), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        Iterator<Long> r0 = f2611b.keySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.memorydata.plugin");
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(f2611b.get(r2), JSONObject.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        Long.parseLong(r3.optString("device_id"));     // Catch: Throwable -> L15
        c.put("device_id", r3.optString("device_id"));     // Catch: Throwable -> L15
    L14:
        return c;
    L5:
        return c;
    }

    public static synchronized boolean c() {
        monitor-enter(j.class);
    L18:
        boolean r1 = false;
    L7:
        monitor-exit(j.class);
        return r1;
    L5:
        if (e == false) goto L9;
        r1 = true;
        goto L7
    L9:
        File r2 = a.g();     // Catch: Throwable -> L18
        if (r2.exists() == true) goto L12;
        r2.createNewFile();     // Catch: Throwable -> L18
    L12:
        FileChannel r3 = new RandomAccessFile(r2, "rw").getChannel();     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        FileLock r4 = r3.tryLock();     // Catch: Throwable -> L18
        d = r4;     // Catch: Throwable -> L18
        e = r4.isValid();     // Catch: Throwable -> L18
    L15:
        boolean r5 = e;     // Catch: Throwable -> L18
        monitor-exit(j.class);
        return r5;
    }

    public static boolean d() {
        return f;
    }

    public static Context getContext() {
        return f2610a;
    }
}
