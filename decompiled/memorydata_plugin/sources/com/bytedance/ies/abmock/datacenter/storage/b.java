package com.bytedance.ies.abmock.datacenter.storage;

import com.bytedance.ies.abmock.ConfigType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f2708b = null;
    private final e c;
    private final Map<String, ConfigType> d;

    static {
        f2708b = new b();
        f2707a = false;
    }

    private b() {
        this.d = new ConcurrentHashMap();
        e r0 = com.bytedance.ies.abmock.datacenter.e.a().c().e();
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.ies.abmock.datacenter.f.class) == true) goto L5;
        this.c = new com.bytedance.ies.abmock.datacenter.g(r0);
        return;
    L5:
        this.c = r0;
    }

    public static b a() {
        return f2708b;
    }

    private e b() {
        return this.c;
    }

    public int a(String r3) {
        if (b().a(r3) == true) goto L6;
        return -1;
    L6:
        return b().a(r3, -1);
    }
}
