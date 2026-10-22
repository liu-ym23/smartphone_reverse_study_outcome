package com.bytedance.lego.init;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f6739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f6740b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f6741c = null;

    static {
        f6739a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(k.class), "threadPoolExecutor", "getThreadPoolExecutor$initscheduler_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f6741c = new k();
        f6740b = LazyKt.lazy(InitSchedulerExecutors$threadPoolExecutor$2.INSTANCE);
    }
}
