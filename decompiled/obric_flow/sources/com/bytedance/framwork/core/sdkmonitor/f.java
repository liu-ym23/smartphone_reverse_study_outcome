package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f4728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f4729b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f4730c = null;

    static {
        f4728a = new ConcurrentHashMap();
        f4729b = new ConcurrentHashMap();
        f4730c = new ConcurrentHashMap();
    }

    public static LinkedList a(List r5) {
        LinkedList r10 = new LinkedList();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        r10.add(("https://" + new URL((String) r11.next()).getHost()) + "/monitor/collect/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r10;
    }

    public static e b(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L20;
        ConcurrentHashMap r10 = f4728a;
        if (r10.get(r5) != null) goto L18;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (r10.get(r5) != null) goto L13;
        r10.put(r5, new e(r5));     // Catch: Throwable -> L11
    L13:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L18:
        return (e) r10.get(r5);
    L20:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static synchronized void c(Context r5, String r10, JSONObject r11, d r12) {
        monitor-enter(f.class);
        if (r5 != null) goto L37;
        monitor-exit(f.class);
        return;
    L37:
    L15:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r10) == true) goto L34;
        ConcurrentHashMap r13 = f4728a;     // Catch: Throwable -> L15
        if (r13.get(r10) != null) goto L12;
    L17:
        e r14 = (e) r13.get(r10);     // Catch: Throwable -> L15
        if (r14 != null) goto L20;
        r14 = new e(r10);     // Catch: Throwable -> L15
        r13.put(r10, r14);     // Catch: Throwable -> L15
    L20:
        List r15 = (List) f4730c.remove(r10);     // Catch: Throwable -> L15
        if (r15 != null) goto L23;
    L25:
        List r16 = (List) f4729b.remove(r10);     // Catch: Throwable -> L15
        if (r16 != null) goto L28;
    L30:
        r14.s = true;     // Catch: Throwable -> L15
        i4.a r17 = ia.a.f17554a;     // Catch: Throwable -> L15
        com.bytedance.apm.e r18 = new com.bytedance.apm.e(r14, r5, r11, r12);     // Catch: Throwable -> L15
        ia.f r19 = (ia.f) r17.f17502b;     // Catch: Throwable -> L15
        r19.b(Message.obtain(r19.d, r18), 5000);     // Catch: Throwable -> L15
        monitor-exit(f.class);
        return;
    L28:
        if (dn.a.R(r16) == true) goto L30;
        r14.f4724u.clear();     // Catch: Throwable -> L15
        r14.f4724u.addAll(r16);     // Catch: Throwable -> L15
        goto L30
    L23:
        if (dn.a.R(r15) == true) goto L25;
        LinkedList r20 = r14.f4719o;     // Catch: Throwable -> L15
        r20.clear();     // Catch: Throwable -> L15
        r20.addAll(r15);     // Catch: Throwable -> L15
        goto L25
    L12:
        if (((e) r13.get(r10)).s == false) goto L17;
        monitor-exit(f.class);
        return;
    L34:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L15
    }

    public static synchronized void d(String r5, List r10) {
        monitor-enter(f.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L22:
        monitor-exit(f.class);
        return;
    L7:
        if (dn.a.R(r10) == true) goto L22;
        LinkedList r11 = new LinkedList();     // Catch: Throwable -> L15
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L15
    L11:
        if (r12.hasNext() == false) goto L19;
        r11.add(("https://" + new URL((String) r12.next()).getHost()) + "/monitor/appmonitor/v3/settings");     // Catch: Throwable -> L15 MalformedURLException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L11
    L19:
        f4730c.put(r5, r11);     // Catch: Throwable -> L15
        monitor-exit(f.class);
    }

    public static synchronized void e(String r5, List r10) {
        monitor-enter(f.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L14:
        monitor-exit(f.class);
        return;
    L7:
        if (dn.a.R(r10) == true) goto L14;
        f4729b.put(r5, a(r10));     // Catch: Throwable -> L12
        monitor-exit(f.class);
    }
}
