package com.larus.drive.sdk.impl.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public static volatile com.bytedance.ee.drive.preview.d a;
    public static com.bytedance.ee.bear.drive.sdk.service.g b;
    public static ik5.a c;
    public static com.bytedance.ee.permission.b d;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;

    static {
        e = LazyKt.lazy(new p());
        f = LazyKt.lazy(new q());
        g = LazyKt.lazy(new r());
        h = LazyKt.lazy(new s());
    }

    public static e89.c a() {
        return (e89.c) g.getValue();
    }

    public static e89.d b() {
        return (e89.d) e.getValue();
    }
}
