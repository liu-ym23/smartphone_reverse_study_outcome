package com.obric.aikernel.runtime.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class RuntimeMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RuntimeMetrics f5408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5409b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f5410c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f5411d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lazy f5412e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f5413f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f5414g = null;

    static {
        f5408a = new RuntimeMetrics();
        f5409b = LazyKt.lazy(RuntimeMetrics$timestampEngineInitResStart$2.INSTANCE);
        f5410c = LazyKt.lazy(RuntimeMetrics$timestampEngineInitResEnd$2.INSTANCE);
        f5411d = LazyKt.lazy(RuntimeMetrics$timestampInitAddPackageResStart$2.INSTANCE);
        f5412e = LazyKt.lazy(RuntimeMetrics$timestampInitAddPackageResEnd$2.INSTANCE);
        f5413f = LazyKt.lazy(RuntimeMetrics$timestampResourceManagerStart$2.INSTANCE);
        f5414g = LazyKt.lazy(RuntimeMetrics$timestampResourceManagerEnd$2.INSTANCE);
    }

    private RuntimeMetrics() {
    }

    public final long a() {
        return ((Number) f5410c.getValue()).longValue();
    }

    public final long b() {
        return ((Number) f5409b.getValue()).longValue();
    }

    public final long c() {
        return ((Number) f5412e.getValue()).longValue();
    }

    public final long d() {
        return ((Number) f5411d.getValue()).longValue();
    }

    public final long e() {
        return ((Number) f5414g.getValue()).longValue();
    }

    public final long f() {
        return ((Number) f5413f.getValue()).longValue();
    }
}
