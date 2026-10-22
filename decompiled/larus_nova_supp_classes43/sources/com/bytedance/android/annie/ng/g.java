package com.bytedance.android.annie.ng;

import android.app.Application;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static Application a;
    public static d b;
    public static final ConcurrentHashMap<String, a> c = null;
    public static final ConcurrentHashMap<String, b> d = null;
    public static final com.bytedance.android.annie.card.e e = null;
    public static final List<String> f = null;
    public static volatile boolean g;

    static {
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new com.bytedance.android.annie.card.e();
        f = Collections.synchronizedList(CollectionsKt.mutableListOf(new String[]{"host", "webcast", "default"}));
    }

    public static final Application a() {
        Application r0 = a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
        return null;
    }

    public static final d b() {
        d r0 = b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mGlobalConfig");
        return null;
    }

    public static void d(String r10, j r11) {
        Intrinsics.checkNotNullParameter(r10, "moduleKey");
        Intrinsics.checkNotNullParameter(r11, "initGlobalConfigCallBack");
        Map<String, j> r0 = i.b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((LinkedHashMap) r0).get(r10) != null) goto L7;
        r0.put(r10, r11);     // Catch: Throwable -> L10
    L7:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public static void c(String r10, String r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bizKey");
        Intrinsics.checkNotNullParameter(r11, "moduleKey");
        Intrinsics.checkNotNullParameter(r12, "initBizConfigCallBack");
        Map<String, Map<String, h>> r0 = i.a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (((LinkedHashMap) r0).get(r10) != null) goto L7;
        r0.put(r10, new LinkedHashMap());     // Catch: Throwable -> L13
    L7:
        Object r1 = ((LinkedHashMap) r0).get(r10);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L13
        if (((Map) r1).get(r11) != null) goto L10;
        Object r13 = ((LinkedHashMap) r0).get(r10);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L13
        ((Map) r13).put(r11, r12);     // Catch: Throwable -> L13
    L10:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
    }
}
