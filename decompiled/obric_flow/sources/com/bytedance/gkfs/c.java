package com.bytedance.gkfs;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f4814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f4815b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f4816c = null;

    static {
        f4816c = new c();
        f4814a = new ThreadPoolExecutor(3, 5, 30, TimeUnit.MINUTES, new LinkedBlockingQueue(), b.f4813a);
        f4815b = LazyKt.lazy(GkFSExecutor$defaultExecutor$2.f4799a);
    }
}
