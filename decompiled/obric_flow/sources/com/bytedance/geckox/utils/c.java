package com.bytedance.geckox.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f4791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f4792b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f4793c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    static {
        f4791a = LazyKt.lazy(GeckoExecutors$checkUpdateExecutor$2.f4783a);
        f4792b = LazyKt.lazy(GeckoExecutors$delayHandler$2.f4784a);
        f4793c = LazyKt.lazy(GeckoExecutors$updateExecutor$2.f4786a);
        d = LazyKt.lazy(GeckoExecutors$accessExecutor$2.f4781a);
        e = LazyKt.lazy(GeckoExecutors$callbackExecutor$2.f4782a);
        f = LazyKt.lazy(GeckoExecutors$ioExecutor$2.f4785a);
    }
}
