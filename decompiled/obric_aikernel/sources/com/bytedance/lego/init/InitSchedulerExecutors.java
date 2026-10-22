package com.bytedance.lego.init;

import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
public final class InitSchedulerExecutors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2049a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f2050b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InitSchedulerExecutors f2051c = null;

    static {
        f2049a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitSchedulerExecutors.class), "threadPoolExecutor", "getThreadPoolExecutor$initscheduler_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f2051c = new InitSchedulerExecutors();
        f2050b = LazyKt.lazy(InitSchedulerExecutors$threadPoolExecutor$2.INSTANCE);
    }

    private InitSchedulerExecutors() {
    }

    public final ThreadPoolExecutor a() {
        Lazy r10 = f2050b;
        KProperty r11 = f2049a[0];
        return (ThreadPoolExecutor) r10.getValue();
    }
}
