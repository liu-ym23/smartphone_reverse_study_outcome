package com.bytedance.lego.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/lego/init/InitSchedulerExecutors;", "", "()V", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor$initscheduler_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "threadPoolExecutor$delegate", "Lkotlin/Lazy;", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f2767b = null;
    private static final Lazy c = null;

    static {
        f2766a = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(e.class), "threadPoolExecutor", "getThreadPoolExecutor$initscheduler_release()Ljava/util/concurrent/ThreadPoolExecutor;")), KProperty.class, "com.obric.memorydata.plugin")};
        f2767b = new e();
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(InitSchedulerExecutors$threadPoolExecutor$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private e() {
    }

    public final ThreadPoolExecutor a() {
        Lazy r2 = c;
        KProperty r0 = f2766a[0];
        return (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r2.getValue(), ThreadPoolExecutor.class, "com.obric.memorydata.plugin");
    }
}
