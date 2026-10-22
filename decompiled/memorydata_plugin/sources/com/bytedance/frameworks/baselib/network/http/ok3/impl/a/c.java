package com.bytedance.frameworks.baselib.network.http.ok3.impl.a;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f2454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2455b;
    private static final ReentrantReadWriteLock c = null;

    static {
        c = new ReentrantReadWriteLock();
    }

    private c() {
    }

    public static c a() {
        if (f2454a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2454a != null) goto L9;
        f2454a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f2454a;
    }

    private List<Header> a(Request r6, d r7, b r8) {
        ArrayList r5 = null;
        if (r6 == null) goto L49;
        if (r7 == null) goto L49;
        if (r8 == null) goto L49;
        if (com.bytedance.common.utility.collection.a.a(r7.e) == false) goto L15;
        if (r7.d != null) goto L12;
    L13:
        return null;
    L12:
        if (r7.d.isEmpty() == true) goto L13;
    L15:
        if (r6.getHeaders() != null) goto L17;
        r5 = new ArrayList();
    L19:
        if (com.bytedance.common.utility.collection.a.a(r5) == true) goto L32;
        if (com.bytedance.common.utility.collection.a.a(r7.e) == true) goto L32;
        Iterator<String> r0 = r7.e.iterator();
    L24:
        if (r0.hasNext() == false) goto L32;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        List<Header> r3 = r6.headers(r2);
        if (r3 == null) goto L24;
        r5.removeAll(r3);
        if (r8.d != null) goto L30;
        r8.d = new HashSet();
    L30:
        r8.d.add(r2);
    L32:
        if (r7.d == null) goto L49;
        if (r7.d.isEmpty() == true) goto L49;
        Iterator<Map.Entry<String, String>> r9 = r7.d.entrySet().iterator();
    L37:
        if (r9.hasNext() == false) goto L49;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L37;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r10.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L37;
        if (r10.getValue() == null) goto L37;
        r5.add(new Header((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.memorydata.plugin")));
        if (r8.c != null) goto L48;
        r8.c = new HashSet();
    L48:
        r8.c.add((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin"));
        goto L37
    L17:
        r5 = new ArrayList(r6.getHeaders());
    L49:
        return r5;
    }

    public static void a(JSONObject r2) {
        ReentrantReadWriteLock r0 = c;     // Catch: Throwable -> L16
        r0.writeLock().lock();     // Catch: Throwable -> L16
        a r1 = new a();     // Catch: Throwable -> L16
        f2455b = r1;     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r0.writeLock().unlock();
        return;
    L7:
        if (r1.b(r2) == true) goto L9;
        f2455b.a(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<com.bytedance.frameworks.baselib.network.a.a.a, d>> r3 = f2455b.c();     // Catch: Throwable -> L16
        if (r3 != null) goto L12;
    L13:
        f2455b.a(false);     // Catch: Throwable -> L16
    L14:
        r0.writeLock().unlock();
        return;
    L12:
        if (r3.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        c.writeLock().unlock();
        throw th;
    }

    private boolean a(Map<String, List<String>> r6, d r7, b r8) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        boolean r9 = false;
        if (r7 == null) goto L41;
        if (r8 == null) goto L41;
        if (r5.isEmpty() == true) goto L22;
        if (com.bytedance.common.utility.collection.a.a(r7.c) == true) goto L22;
        Iterator<String> r1 = r7.c.iterator();
    L12:
        if (r1.hasNext() == false) goto L22;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L12;
        if (r5.remove(r3) == null) goto L12;
        if (r8.f2453b != null) goto L20;
        r8.f2453b = new HashSet();
    L20:
        r8.f2453b.add(r3);
        r9 = true;
    L22:
        if (r7.f2456b == null) goto L41;
        if (r7.f2456b.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r10 = r7.f2456b.entrySet().iterator();
    L27:
        if (r10.hasNext() == false) goto L41;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L27;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L27;
        if (r2.getValue() == null) goto L27;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.preCheckCast(r5.get(r11), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L37;
        r4 = new ArrayList();
        r5.put(r11, r4);
    L37:
        r4.add((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
        if (r8.f2452a != null) goto L40;
        r8.f2452a = new HashSet();
    L40:
        r8.f2452a.add((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"));
        r9 = true;
    L41:
        return r9;
    }

    public String a(String r8, Request r9, b r10, List<Header> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        ReentrantReadWriteLock r2 = c;
        r2.readLock().lock();
        Pair<String, String> r3 = null;
        boolean r4 = false;
        a r5 = f2455b;     // Catch: Throwable -> L22
        if (r5 != null) goto L6;
    L10:
        r2.readLock().unlock();
        return r8;
    L6:
        if (r5.b() == false) goto L10;
        d r1 = (d) ZeusTransformUtils.preCheckCast(f2455b.a(r8), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r1 == null) goto L10;
        List<Header> r13 = a(r9, r1, r10);     // Catch: Throwable -> L22
        if (com.bytedance.common.utility.collection.a.a(r13) == true) goto L36;
        r12.addAll(r13);     // Catch: Throwable -> L22
    L36:
        r3 = k.b(r8, r0);     // Catch: Throwable -> L17
    L19:
        if (r3 == null) goto L24;
        r4 = a(r0, r1, r10);     // Catch: Throwable -> L22
    L24:
        c.readLock().unlock();
        if (r4 == true) goto L28;
        return r8;
    L28:
        return com.bytedance.frameworks.baselib.network.d.d.a(r8, r3, r0);
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        c.readLock().unlock();
        throw th;
    }
}
