package com.obric.matrix.platform.sdk.ones.safecushion.repair;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionThreadExecutor;", "", "()V", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getIoExecutor", "()Ljava/util/concurrent/ExecutorService;", "ioExecutor$delegate", "Lkotlin/Lazy;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "executeOnIO", "", "task", "Ljava/lang/Runnable;", "runOnMain", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f8140b = null;
    private static final Lazy c = null;

    static {
        f8139a = new c();
        f8140b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(SafeCushionThreadExecutor$mainHandler$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(SafeCushionThreadExecutor$ioExecutor$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private c() {
    }
}
