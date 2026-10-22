package com.bytedance.ies.abmock.datacenter.storage;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f2737a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f2738b;
    private final q c;

    @Deprecated
    private volatile JsonObject d;
    private volatile JsonObject e;

    static {
        f2737a = new p();
    }

    private p() {
        e r0 = com.bytedance.ies.abmock.datacenter.e.a().c().c();
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.ies.abmock.datacenter.f.class) == true) goto L5;
        this.f2738b = new com.bytedance.ies.abmock.datacenter.g(r0);
    L6:
        this.c = new q(this.f2738b);
        return;
    L5:
        this.f2738b = r0;
        goto L6
    }

    @Deprecated
    public JsonObject a() {
        if (n.j == false) goto L10;
        if (n.d() == false) goto L10;
        Log.e("UnregisteredRepo", "usingNewRepo is not allowed here");
        throw new RuntimeException("getUnregisteredLibraJsonObject fatal");
    L10:
        if (this.e != null) goto L30;
        monitor-enter(p.class);
    L26:
        th = move-exception;
        throw th;
    L14:
        if (this.e == null) goto L32;
    L24:
        monitor-exit(p.class);     // Catch: Throwable -> L26
        goto L30
    L32:
        Log.d("UnregisteredRepo", "force getUnregisteredLibraJsonObject");     // Catch: Exception -> L22 Throwable -> L26
        if (n.c() == false) goto L20;
        int r1 = m.a();     // Catch: Exception -> L22 Throwable -> L26
        this.e = (JsonObject) ZeusTransformUtils.preCheckCast(o.f2736a.fromJson(this.f2738b.a("key_unregistered_libra_config", "{}"), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22 Throwable -> L26
        if (r1 == m.f2733a) goto L31;
        m.a(r1);     // Catch: Exception -> L22 Throwable -> L26
    L31:
    L20:
        this.e = (JsonObject) ZeusTransformUtils.preCheckCast(o.f2736a.fromJson(this.f2738b.a("key_unregistered_libra_config", "{}"), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22 Throwable -> L26
    L22:
        e = move-exception;
        Log.e("UnregisteredRepo", "getUnregisteredLibraJsonObject error:" + e.getMessage());     // Catch: Throwable -> L26
    L30:
        return this.e;
    }

    @Deprecated
    public Object a(String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return null;
    L6:
        if (n.d() == true) goto L8;
        JsonObject r2 = a();
        if (r2 == null) goto L15;
        JsonElement r5 = r2.get(r3);
        if (ZeusTransformUtils.instanceOf(r5, JsonObject.class) == false) goto L15;
        return ((JsonObject) ZeusTransformUtils.preCheckCast(r5, JsonObject.class, "com.obric.memorydata.plugin")).get("val");
    L15:
        return null;
    L8:
        return this.c.a(r3, r4);
    }

    @Deprecated
    synchronized void a(JsonObject r2) {
        monitor-enter(this);
        this.f2738b.c("key_unregistered_config");     // Catch: Throwable -> L5 Exception -> L7
        this.d = null;     // Catch: Throwable -> L5 Exception -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    public boolean a(String r2) {
        if (n.d() == true) goto L5;
        JsonObject r1 = a();
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.has(r2);
    L5:
        return this.c.a(r2);
    }

    @Deprecated
    public Object b(String r2) {
        return a(r2, false);
    }

    @Deprecated
    public Set<String> b() {
        if (n.d() == true) goto L5;
        JsonObject r1 = a();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.keySet();
    L5:
        return this.c.a();
    }

    synchronized void b(JsonObject r8) {
        monitor-enter(this);
        boolean r0 = n.d();     // Catch: Throwable -> L33
        boolean r1 = n.f2735b;     // Catch: Throwable -> L33
        Log.i("UnregisteredRepo", "storeLibraJsonObject start current_new_repo:" + r0 + " ongoing_new_repo:" + r1);     // Catch: Throwable -> L33
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L33
        int r4 = 0;
        if (r0 == true) goto L6;
    L26:
        e = move-exception;
        Log.e("UnregisteredRepo", "storeLibraJsonObject", e);     // Catch: Throwable -> L33
    L28:
        if (r1 == false) goto L30;
        o.b(r8);     // Catch: Throwable -> L33
    L30:
        Log.i("UnregisteredRepo", "storeLibraJsonObject end:" + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L33
        l.a(r1, n.d, n.e);     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L15:
        if (n.i == true) goto L17;
    L21:
        this.f2738b.b("key_unregistered_libra_config", o.a(r8));     // Catch: Exception -> L26 Throwable -> L33
        this.d = null;     // Catch: Exception -> L26 Throwable -> L33
        if (n.f2734a == false) goto L24;
        Log.i("UnregisteredRepo", "opt assignment unregisteredLibraJsonObject, no need init again");     // Catch: Exception -> L26 Throwable -> L33
        this.e = r8;     // Catch: Exception -> L26 Throwable -> L33
        goto L28
    L24:
        this.e = null;     // Catch: Exception -> L26 Throwable -> L33
        goto L28
    L17:
        if (this.e == null) goto L20;
        r4 = this.e.keySet().size();     // Catch: Exception -> L26 Throwable -> L33
    L20:
        Log.d("UnregisteredRepo", "storeLibraJsonObjectOrigin origin:" + r4 + " new:" + r8.keySet().size());     // Catch: Exception -> L26 Throwable -> L33
        goto L21
    L6:
        if (n.i == false) goto L12;
        Set<String> r3 = b();     // Catch: Throwable -> L33
        if (r3 == null) goto L11;
        r4 = r3.size();     // Catch: Throwable -> L33
    L11:
        Log.d("UnregisteredRepo", "storeLibraJsonObjectOrigin origin:" + r4 + " new:" + r8.keySet().size());     // Catch: Throwable -> L33
    L12:
        this.c.a(r8);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }
}
