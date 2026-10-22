package com.bytedance.ttnet.utils;

import ai.g0;
import ai.h;
import ai.h0;
import ai.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import wc.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f7541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ConcurrentHashMap f7542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.frameworks.baselib.network.http.util.a f7543c = null;
    public static final com.bytedance.frameworks.baselib.network.http.util.a d = null;

    static {
        f7541a = new CopyOnWriteArrayList();
        f7542b = new ConcurrentHashMap();
        h0.f212i = f7541a;
        f7543c = new com.bytedance.frameworks.baselib.network.http.util.a(10);
        d = new com.bytedance.frameworks.baselib.network.http.util.a(10);
    }

    public static synchronized h0 a(String r5, bi.a r10) {
        monitor-enter(d.class);
        h0 r11 = b(null, null, r10, r5);     // Catch: Throwable -> L10
        monitor-exit(d.class);
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized h0 b(ArrayList r5, ArrayList r10, bi.a r11, String r12) {
        monitor-enter(d.class);
        g0 r13 = new g0(0);     // Catch: Throwable -> L7
        r13.g(r12);     // Catch: Throwable -> L7
        r13.f210b = r11;     // Catch: Throwable -> L7
        r13.g = new h.a(3);     // Catch: Throwable -> L7
        if (r5 != null) goto L10;
        r5 = new ArrayList();     // Catch: Throwable -> L7
    L10:
        if (r5.isEmpty() == false) goto L12;
        r5.add(aa.a.f());     // Catch: Throwable -> L7
    L12:
        Iterator r14 = r5.iterator();     // Catch: Throwable -> L7
    L14:
        if (r14.hasNext() == false) goto L16;
        r13.c((h) r14.next());     // Catch: Throwable -> L7
        goto L14
    L16:
        if (r10 != null) goto L18;
    L23:
        LinkedList r15 = new LinkedList();     // Catch: Throwable -> L7
        r15.add(0, new wa.a(1));     // Catch: Throwable -> L7
        if (f7541a != null) goto L26;
    L28:
        r15.add(new wa.a(2));     // Catch: Throwable -> L7
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L7
    L30:
        if (r16.hasNext() == false) goto L32;
        r13.d((ei.b) r16.next());     // Catch: Throwable -> L7
        goto L30
    L32:
        h0 r17 = r13.e();     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r17;
    L26:
        if (f7541a.size() <= 0) goto L28;
        r15.addAll(f7541a);     // Catch: Throwable -> L7
        goto L28
    L18:
        if (r10.isEmpty() == true) goto L23;
        Iterator r18 = r10.iterator();     // Catch: Throwable -> L7
    L21:
        if (r18.hasNext() == false) goto L23;
        ai.d r19 = (ai.d) r18.next();     // Catch: Throwable -> L7
        ArrayList r20 = (ArrayList) r13.f;     // Catch: Throwable -> L7
        w0.b(r19, "factory == null");     // Catch: Throwable -> L7
        r20.add(r19);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Object c(Class r5, String r10) {
        monitor-enter(d.class);
        h0 r11 = e(r10);     // Catch: Throwable -> L17
        monitor-enter(d.class);     // Catch: Throwable -> L17
        if (r11 != null) goto L20;
        monitor-exit(d.class);     // Catch: Throwable -> L17
        Object r12 = null;
    L15:
        monitor-exit(d.class);
        return r12;
    L20:
        r12 = r11.b(r5);     // Catch: Throwable -> L10
        monitor-exit(d.class);     // Catch: Throwable -> L17
        goto L15
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static synchronized h0 d(String r5) {
        monitor-enter(d.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (com.bytedance.common.utility.b.b(r5) == false) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        com.bytedance.frameworks.baselib.network.http.util.a r10 = d;     // Catch: Throwable -> L23
        h0 r11 = (h0) r10.a(r5);     // Catch: Throwable -> L23
        if (r11 == null) goto L14;
        monitor-exit(d.class);
        return r11;
    L14:
        monitor-enter(d.class);     // Catch: Throwable -> L23
        h0 r12 = a(r5, new f(7));     // Catch: Throwable -> L20
        monitor-exit(d.class);     // Catch: Throwable -> L23
        r10.b(r5, r12);     // Catch: Throwable -> L23
        monitor-exit(d.class);
        return r12;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    }

    public static synchronized h0 e(String r5) {
        monitor-enter(d.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (com.bytedance.common.utility.b.b(r5) == false) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        com.bytedance.frameworks.baselib.network.http.util.a r10 = f7543c;     // Catch: Throwable -> L23
        h0 r11 = (h0) r10.a(r5);     // Catch: Throwable -> L23
        if (r11 == null) goto L14;
        monitor-exit(d.class);
        return r11;
    L14:
        monitor-enter(d.class);     // Catch: Throwable -> L23
        h0 r12 = a(r5, new uj.a());     // Catch: Throwable -> L20
        monitor-exit(d.class);     // Catch: Throwable -> L23
        r10.b(r5, r12);     // Catch: Throwable -> L23
        monitor-exit(d.class);
        return r12;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    }
}
