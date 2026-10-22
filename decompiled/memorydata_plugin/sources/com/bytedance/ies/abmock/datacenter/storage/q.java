package com.bytedance.ies.abmock.datacenter.storage;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
class q {
    private static final Object c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f2739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile CountDownLatch f2740b;
    private final ConcurrentHashMap<String, Object> d;

    static {
        c = new Object();
    }

    q(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        this.f2740b = null;
        this.d = new ConcurrentHashMap();
        this.f2739a = r4;
    }

    private void b() {
        if (n.j == true) goto L5;
    L9:
        CountDownLatch r1 = this.f2740b;
        if (r1 == null) goto L16;
        boolean r0 = false;
    L17:
        r1.await();     // Catch: InterruptedException -> L15
        if (r0 == false) goto L20;
        Thread.currentThread().interrupt();
        return;
    L20:
        return;
    L15:
        r0 = true;
        goto L17
    L16:
        return;
    L5:
        if (n.d() == true) goto L9;
        throw new RuntimeException("not permit when using new unregister mode!!@liaobinbin");
    }

    Object a(String r6, boolean r7) {
        b();
        Object r0 = this.d.get(r6);
        JsonElement r1 = null;
        if (r0 != null) goto L5;
        String r2 = this.f2739a.a(r6, "");
        if (TextUtils.isEmpty(r2) == false) goto L30;
    L21:
        if (r7 == false) goto L29;
        ConcurrentHashMap<String, Object> r8 = this.d;
        if (r1 == null) goto L25;
        r8.put(r6, r1);
    L27:
        if (n.i == false) goto L29;
        Log.w("UnregisteredNewRepo", "cache map size:" + this.d.size());
        goto L29
    L25:
        r8.put(r6, c);
    L29:
        return r1;
    L30:
        JsonObject r3 = (JsonObject) ZeusTransformUtils.preCheckCast(o.f2736a.fromJson(r2, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r3 == null) goto L21;
        r1 = r3.get("val");     // Catch: Throwable -> L20
    L20:
        Log.e("UnregisteredNewRepo", "getUnregisteredJsonObjectFromVal not JsonObject");
        goto L21
    L5:
        if (r0 != c) goto L11;
        if (n.i == false) goto L9;
        Log.w("UnregisteredNewRepo", "repeat get null key:" + r6);
    L9:
        return null;
    L11:
        if (n.i == false) goto L13;
        Log.w("UnregisteredNewRepo", "repeat get valid key:" + r6);
    L13:
        return r0;
    }

    Set<String> a() {
        b();
        return this.f2739a.b();
    }

    void a(JsonObject r9) {
        if (n.h == false) goto L5;
    L7:
        CountDownLatch r0 = null;
    L8:
        if (r9 != null) goto L38;
    L33:
        if (r0 == null) goto L47;
    L34:
        r0.countDown();
        this.f2740b = null;
        return;
    L47:
        return;
    L38:
    L25:
        th = move-exception;
        Log.e("UnregisteredNewRepo", "storeLibraJsonObject", th);     // Catch: Throwable -> L29
        if (r0 != null) goto L34;
        return;
    L29:
        th = move-exception;
        if (r0 == null) goto L32;
        r0.countDown();
        this.f2740b = null;
    L32:
        throw th;
    L11:
        if (n.h == false) goto L18;
        Set<String> r3 = this.f2739a.b();     // Catch: Throwable -> L25
        Set<String> r5 = r9.keySet();     // Catch: Throwable -> L25
        Iterator<String> r4 = r3.iterator();     // Catch: Throwable -> L25
    L14:
        if (r4.hasNext() == false) goto L19;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r5.contains(r6) == true) goto L14;
        this.f2739a.c(r6);     // Catch: Throwable -> L25
    L19:
        Iterator<Map.Entry<String, JsonElement>> r10 = r9.entrySet().iterator();     // Catch: Throwable -> L25
    L21:
        if (r10.hasNext() == false) goto L23;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        this.f2739a.b((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin"), ((JsonElement) ZeusTransformUtils.preCheckCast(r7.getValue(), JsonElement.class, "com.obric.memorydata.plugin")).toString());     // Catch: Throwable -> L25
        goto L21
    L23:
        this.d.clear();     // Catch: Throwable -> L25
        goto L33
    L18:
        this.f2739a.a();     // Catch: Throwable -> L25
        goto L19
    L5:
        if (n.f() == true) goto L7;
        Log.i("UnregisteredNewRepo", "for use lock");
        r0 = new CountDownLatch(1);
        this.f2740b = r0;
        goto L8
    }

    boolean a(String r1) {
        b();
        return this.f2739a.a(r1);
    }
}
