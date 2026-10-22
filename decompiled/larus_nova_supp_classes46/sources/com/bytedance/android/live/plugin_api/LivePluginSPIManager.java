package com.bytedance.android.live.plugin_api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePluginSPIManager {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<a>> b = null;
    public static b c;
    public static final Lazy d = null;
    public static final LivePluginSPIManager e = null;

    public interface a {
        void afterReady();
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePluginSPIManager.class), "service", "getService()Lcom/bytedance/android/live/plugin_api/service/IPluginService;"))};
        e = new LivePluginSPIManager();
        b = new ConcurrentHashMap();
        d = LazyKt.lazy(LivePluginSPIManager$service$2.INSTANCE);
    }

    public LivePluginSPIManager() {
    }

    public static com.bytedance.android.live.plugin_api.a a() {
        b r0 = c;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r0.isDisabled("com.ss.android.live.broadcast") == false) goto L9;
        com.bytedance.android.live.plugin_api.a.a.getClass();
        return com.bytedance.android.live.plugin_api.a.C0188a.a;
    L9:
        b r1 = c;
        if (r1 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r1.getPlugin("com.ss.android.live.broadcast");
    }

    public static boolean b() {
        b r0 = c;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r0.isPlugin("com.ss.android.live.broadcast");
    }

    public static boolean c() {
        b r0 = c;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r0.isPluginReady("com.ss.android.live.broadcast");
    }

    public static void d(a r3) {
        b r0 = c;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r0.isDisabled("com.ss.android.live.broadcast") == false) goto L9;
        return;
    L9:
        if (c() == false) goto L11;
    L19:
        r3.afterReady();
        return;
    L11:
        if (b() == false) goto L19;
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> r1 = b;
        CopyOnWriteArrayList<a> r2 = r1.get("com.ss.android.live.broadcast");
        if (r2 != null) goto L18;
        r2 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<a> r4 = r1.putIfAbsent("com.ss.android.live.broadcast", r2);
        if (r4 == null) goto L18;
        r2 = r4;
    L18:
        r2.add(r3);
    }

    public static void e(a r2) {
        CopyOnWriteArrayList<a> r0 = b.get("com.ss.android.live.broadcast");
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }
}
