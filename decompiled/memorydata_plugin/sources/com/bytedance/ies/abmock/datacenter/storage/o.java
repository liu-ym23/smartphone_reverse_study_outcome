package com.bytedance.ies.abmock.datacenter.storage;

import android.util.Log;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f2736a;

    static {
        f2736a = new Gson();
    }

    public static Keva a() {
        if (n.d() == false) goto L6;
        return b();
    L6:
        return c();
    }

    public static String a(JsonObject r1) {
        n.a r0 = n.a();
        if (r0 == null) goto L7;
        return r0.a(r1);
    L7:
        return r1.toString();
    }

    static Keva b() {
        return Keva.getRepoSync("unregistered_config_opt_repo", !n.e() ? 1 : 0);
    }

    public static void b(JsonObject r6) {
        Log.w("UnregisteredRepo", "try migrate to new repo");
        Keva r2 = b();     // Catch: Throwable -> L8
        r2.clear();     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, JsonElement>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L8
    L5:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r2.storeString((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), ((JsonElement) ZeusTransformUtils.preCheckCast(r3.getValue(), JsonElement.class, "com.obric.memorydata.plugin")).toString());     // Catch: Throwable -> L8
    L10:
        Log.w("UnregisteredRepo", "success migrate to new repo");
        return;
    L8:
        th = move-exception;
        Log.e("UnregisteredRepo", "migrate fail", th);
        goto L10
    }

    static Keva c() {
        return Keva.getRepoSync("unregistered_config", 1);
    }
}
