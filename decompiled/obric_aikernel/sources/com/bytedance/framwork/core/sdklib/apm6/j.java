package com.bytedance.framwork.core.sdklib.apm6;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f1950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, JSONObject> f1951b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, String> f1952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static FileLock f1953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f1954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f1955f;

    static {
        f1951b = new ConcurrentHashMap();
        f1954e = false;
    }

    public static t4.c a(String r10, Map<String, String> r11, byte[] r12) {
        IHttpService r13 = (IHttpService) c4.d.a(IHttpService.class);
        if (r13 == null) goto L7;
        return r13.doPost(r10, r12, r11);
    L7:
        return i3.a.a(r10, r12, r11);
    }

    public static Map<String, String> b() {
        if (TextUtils.isEmpty(f1952c.get("device_id")) == false) goto L5;
        Iterator<Long> r10 = f1951b.keySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        Long r11 = r10.next();
        JSONObject r12 = f1951b.get(r11);
        if (r12 == null) goto L8;
        Long.parseLong(r12.optString("device_id"));     // Catch: Throwable -> L15
        f1952c.put("device_id", r12.optString("device_id"));     // Catch: Throwable -> L15
    L14:
        return f1952c;
    L5:
        return f1952c;
    }

    public static Context c() {
        return f1950a;
    }

    public static synchronized JSONObject d() {
        monitor-enter(j.class);
        ConcurrentHashMap<Long, JSONObject> r10 = f1951b;     // Catch: Throwable -> L12
        Iterator<Long> r11 = r10.keySet().iterator();     // Catch: Throwable -> L12
        if (r11.hasNext() == false) goto L10;
        JSONObject r12 = r10.get(r11.next());     // Catch: Throwable -> L12
        monitor-exit(j.class);
        return r12;
    L10:
        monitor-exit(j.class);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized JSONObject e(long r10) {
        monitor-enter(j.class);
        JSONObject r11 = f1951b.get(Long.valueOf(r10));     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean f() {
        return f1955f;
    }

    public static synchronized boolean g() {
        monitor-enter(j.class);
    L20:
        boolean r10 = false;
    L7:
        monitor-exit(j.class);
        return r10;
    L5:
        if (f1954e == false) goto L9;
        r10 = true;
        goto L7
    L9:
        File r11 = a.c();     // Catch: Throwable -> L20
        if (r11.exists() == true) goto L12;
        r11.createNewFile();     // Catch: Throwable -> L20
    L12:
        FileChannel r12 = new RandomAccessFile(r11, "rw").getChannel();     // Catch: Throwable -> L20
        if (r12 == null) goto L17;
        FileLock r13 = r12.tryLock();     // Catch: Throwable -> L20
        f1953d = r13;     // Catch: Throwable -> L20
        if (r13 == null) goto L17;
        f1954e = r13.isValid();     // Catch: Throwable -> L20
    L17:
        boolean r14 = f1954e;     // Catch: Throwable -> L20
        monitor-exit(j.class);
        return r14;
    }

    public static void h(Map<String, String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == false) goto L7;
        return;
    L7:
        if (f1952c != null) goto L9;
        f1952c = new HashMap();
    L9:
        f1952c.putAll(r10);
        f1952c.remove("aid");
    }

    public static synchronized void i(Context r10) {
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f1950a == null) goto L8;
        monitor-exit(j.class);
        return;
    L8:
        f1950a = r10;     // Catch: Throwable -> L11
        monitor-exit(j.class);
    }

    public static synchronized void j(String r10, JSONObject r11) {
        monitor-enter(j.class);
        f1951b.put(Long.valueOf(Long.parseLong(r10)), r11);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(j.class);
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        j3.c.c("APM-SDK", "setHeader", e);     // Catch: Throwable -> L6
        goto L10
    }
}
