package com.obric.matrix.platform.sdk.ones.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class BaseComponentInitHelper$initExecutor$2 extends Lambda implements Function0<ExecutorService> {
    public static final BaseComponentInitHelper$initExecutor$2 INSTANCE = null;

    static {
        INSTANCE = new BaseComponentInitHelper$initExecutor$2();
    }

    BaseComponentInitHelper$initExecutor$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
    private static final Thread m425invoke$lambda0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "MatrixBaseComponentInit");
    }

    /* JADX INFO: renamed from: lambda$-uLK594zLq7UTnnqNRk5ILhajrY, reason: not valid java name */
    public static /* synthetic */ Thread m426lambda$uLK594zLq7UTnnqNRk5ILhajrY(Runnable r0) {
        return m425invoke$lambda0(r0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ExecutorService invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ExecutorService invoke2() {
        return Executors.newSingleThreadExecutor($$Lambda$BaseComponentInitHelper$initExecutor$2$uLK594zLq7UTnnqNRk5ILhajrY.INSTANCE);
    }
}
