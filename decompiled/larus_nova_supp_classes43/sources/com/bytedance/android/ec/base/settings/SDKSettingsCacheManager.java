package com.bytedance.android.ec.base.settings;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.google.gson.Gson;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SDKSettingsCacheManager {
    public static final ConcurrentHashMap<String, Object> a = null;
    public static final ConcurrentHashMap<String, Object> b = null;
    public static final WeakHashMap<LifecycleOwner, ConcurrentHashMap<String, Object>> c = null;
    public static final Lazy d = null;
    public static final SDKSettingsCacheManager e = null;

    public SDKSettingsCacheManager() {
    }

    public static Gson a() {
        return (Gson) d.getValue();
    }

    static {
        e = new SDKSettingsCacheManager();
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new WeakHashMap();
        d = LazyKt.lazy(SDKSettingsCacheManager$gson$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return b;
    }

    public static ConcurrentHashMap c() {
        return a;
    }

    public static WeakHashMap d() {
        return c;
    }

    public static void e(String r1, Object r10) {
        Intrinsics.checkNotNullParameter(r1, "key");
        a.put(r1, r10);
    }

    public static void f(LifecycleOwner r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter("key_test_a", "key");
        WeakHashMap<LifecycleOwner, ConcurrentHashMap<String, Object>> r1 = c;
        monitor-enter(r1);
        ConcurrentHashMap<String, Object> r12 = r1.get(r10);     // Catch: Throwable -> L11
        if (r12 != null) goto L7;
        r12 = new ConcurrentHashMap();     // Catch: Throwable -> L11
        r1.put(r10, r12);     // Catch: Throwable -> L11
    L7:
        ConcurrentHashMap<String, Object> r13 = r12;     // Catch: Throwable -> L11
        monitor-exit(r1);
        r13.put("key_test_a", r11);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
