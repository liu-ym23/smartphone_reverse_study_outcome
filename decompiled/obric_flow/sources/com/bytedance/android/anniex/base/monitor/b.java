package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3120b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f3121a;

    static {
        f3120b = new b();
    }

    public b() {
        LazyKt.lazy(MonitorCenter$gson$2.f3116a);
        this.f3121a = new ConcurrentHashMap();
    }
}
