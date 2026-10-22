package com.obric.memorydata.middleware.impl.network;

import android.util.Log;
import com.obric.memorydata.utils.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f11764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f11765b;
    private Object c;

    public c() {
    }

    public static c b() {
        if (f11764a != null) goto L6;
        f11764a = new c();
    L6:
        return f11764a;
    }

    private void c() {
        if (this.c != null) goto L5;
    L17:
    L14:
        e = move-exception;
        Log.e("BDKeyManagerRef", "init failed, " + e.getMessage());
        return;
    L8:
        if (am.f13169a.c() == false) goto L11;
        Class<?> r0 = ZeusTransformUtils.forName("com.aiassistant.security.ssl.AssistantKeyManager", "com.obric.memorydata.plugin");     // Catch: Exception -> L14
    L10:
        this.f11765b = r0;     // Catch: Exception -> L14
        this.c = this.f11765b.newInstance();     // Catch: Exception -> L14
        return;
    L11:
        r0 = ZeusTransformUtils.forName("com.obric.security.ssl.ObricKeyManager", "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        goto L10
    L5:
        if (this.f11765b == null) goto L17;
    }

    public long a() {
        c();
        Method r0 = this.f11765b.getDeclaredMethod("getAlgorithmAddress", new Class[0]);     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) ZeusTransformUtils.preCheckCast(r0.invoke(this.c, new Object[0]), Long.class, "com.obric.memorydata.plugin")).longValue();
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getAlgorithmAddress failed, " + e.getMessage());
        return -1;
    }

    public List<X509Certificate> a(String r7) {
        c();
        Method r0 = this.f11765b.getDeclaredMethod("getCertChain", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return (List) ZeusTransformUtils.preCheckCast(r0.invoke(this.c, new Object[]{r7}), List.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getCertChain failed, " + e.getMessage());
        return null;
    }

    public PrivateKey b(String r7) {
        c();
        Method r0 = this.f11765b.getDeclaredMethod("getPrivateKey", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return (PrivateKey) ZeusTransformUtils.preCheckCast(r0.invoke(this.c, new Object[]{r7}), PrivateKey.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getPrivateKey failed, " + e.getMessage());
        return null;
    }

    public long c(String r7) {
        c();
        Method r0 = this.f11765b.getDeclaredMethod("getDoSignAddress", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) ZeusTransformUtils.preCheckCast(r0.invoke(this.c, new Object[]{r7}), Long.class, "com.obric.memorydata.plugin")).longValue();
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "getDoSignAddress failed, " + e.getMessage());
        return -1;
    }

    public boolean d(String r7) {
        c();
        Method r1 = this.f11765b.getDeclaredMethod("isContainsKey", new Class[]{String.class});     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(this.c, new Object[]{r7}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        e = move-exception;
        Log.e("BDKeyManagerRef", "isContainsKey failed, " + e.getMessage());
        return false;
    }
}
